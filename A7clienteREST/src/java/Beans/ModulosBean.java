/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import pojo.Campanya;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;
import pojo.Modulo;
import wsClient.CampanyaWSClient;
import wsClient.ModuloWSClient;

/**
 *
 * @author Alesinx
 */
@Named(value = "modulosBean")
@SessionScoped
public class ModulosBean implements Serializable{

//    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/iWebServer/crudCampanya.wsdl")
//    private CrudCampanya_Service service_1;
//
//    // ------------------------------------------------------------------------------------
//    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/iWebServer/crudModulo.wsdl")
//    private CrudModulo_Service service;
//    // ------------------------------------------------------------------------------------
    
    protected CampanyaWSClient campanyaService;
    protected ModuloWSClient moduloService;
    
    
    protected List<pojo.Modulo> listaModulo;
    protected List<pojo.Campanya> listaCampanyas;
    protected String filtro;
    protected String campanyaFiltro;


    @PostConstruct
    public void init() {
        if( listaModulo == null){
            listaModulo = moduloService.findAll();
        }
        
        if( listaCampanyas == null) {
            listaCampanyas = campanyaService.findAll();
        }
    }
    
    public String orderByNombre() {
//      listaModulo = moduloService.;
        return "listaModulos";
    }
    
    public String orderByRendimiento() {
//      listaModulo = moduloAllByRendimiento();
        return "listaModulos";
    }
    
    public String FilterByNombre() {
//      listaModulo = moduloService.;
        return "listaModulos";
    }
    
    public String FilterByIdealidad() {
//        Double num = Double.parseDouble(filtro);
//        if(num != null){
//            listaModulo = moduloFilterByIdealidad(num);
//        }
            
        return "listaModulos";
    }
    
    public String listaModulos() {
        return "listaModulos";
    }
    
    public String listaCampanyas() {
        return "listaCampanyas";
    }
    
    public String CampanyasByModulo(int id) {
        if(id >= 0) {
            listaCampanyas = campanyaService.findByModuloId(id);
        }
        
        return "CampanyasByModulo";
    }
    
    public String Volver() {
        return "listaModulos";
    }
    
    public String CampanyaOrderByNombre() {
//        listaCampanyas = campanyaService.
        return "listaCampanyas";
    }
    
    public String CampanyaOrderByFecha() {
//        listaCampanyas = campanyaallByFecha();
        return "listaCampanyas";
    }
    
    public String CampanyaFilterByNombre() {
//        listaCampanyas = campanyaService.
        return "listaCampanyas";
    }
    
    public String CampanyaFilterByFecha() throws ParseException, DatatypeConfigurationException {
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS z");
//        Date date = format.parse(campanyaFiltro);
//        GregorianCalendar cal = new GregorianCalendar();
//        cal.setTime(date);
//        XMLGregorianCalendar xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
//        
//        listaCampanyas = campanyaFilterByFecha(xmlGregCal);
//        
        return "listaCampanyas";
    }
    
    public String VolverIndex(){
        return "index";
    }

    public ModulosBean() {
    }
    
    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // GETTERS AND SETTERS
    
    public List<Modulo> getListaModulo() {
        return listaModulo;
    }

    public void setListaModulo(List<Modulo> listaModulo) {
        this.listaModulo = listaModulo;
    }

    public List<Campanya> getListaCampanyas() {
        return listaCampanyas;
    }

    public void setListaCampanyas(List<Campanya> listaCampanyas) {
        this.listaCampanyas = listaCampanyas;
    }
    
    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtroNombre) {
        this.filtro = filtroNombre;
    }

    public String getCampanyaFiltro() {
        return campanyaFiltro;
    }

    public void setCampanyaFiltro(String CampanyaFiltro) {
        this.campanyaFiltro = CampanyaFiltro;
    }
    
    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
}
