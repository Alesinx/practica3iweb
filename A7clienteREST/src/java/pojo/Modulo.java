/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author JaGaRo
 */
public class Modulo {
    private int idmodulo;
    private String nombremodulo;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private double idealidad;
    private double rendimiento;
    private double resistencia;
    private double valoralpha;
    private double valorbeta;
    private double valorgamma;
    private double valorkappa;

    public int getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(int idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getNombremodulo() {
        return nombremodulo;
    }

    public void setNombremodulo(String nombremodulo) {
        this.nombremodulo = nombremodulo;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public double getIdealidad() {
        return idealidad;
    }

    public void setIdealidad(double idealidad) {
        this.idealidad = idealidad;
    }

    public double getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(double rendimiento) {
        this.rendimiento = rendimiento;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    public double getValoralpha() {
        return valoralpha;
    }

    public void setValoralpha(double valoralpha) {
        this.valoralpha = valoralpha;
    }

    public double getValorbeta() {
        return valorbeta;
    }

    public void setValorbeta(double valorbeta) {
        this.valorbeta = valorbeta;
    }

    public double getValorgamma() {
        return valorgamma;
    }

    public void setValorgamma(double valorgamma) {
        this.valorgamma = valorgamma;
    }

    public double getValorkappa() {
        return valorkappa;
    }

    public void setValorkappa(double valorkappa) {
        this.valorkappa = valorkappa;
    }
    
    public static <T> String findTemperatura(Class<T> responseType, BigDecimal lat, BigDecimal lon) throws IOException {
        final String URLs = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=60365771bc7d83329184c63b95c4966a";
        /*
        Client client = javax.ws.rs.client.ClientBuilder.newClient();
        WebTarget resource = client.target(URL);
        Invocation.Builder invocationBuilder =  resource.request(MediaType.APPLICATION_JSON); 
        Response setUserResponse = invocationBuilder.get(Entity.entity(request, MediaType.APPLICATION_JSON)); 
        String resp = setUserResponse.readEntity(String.class);

        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);*/
        URL url = new URL(URLs);
        URLConnection request = url.openConnection();
        request.connect();

        // Convert to a JSON object to print data
        
         java.util.Scanner s = new java.util.Scanner(new InputStreamReader((InputStream) request.getContent())).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }


}
