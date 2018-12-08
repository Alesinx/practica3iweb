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
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.json.Json;
import javax.json.JsonArray;
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
    @EJB
    protected CampanyaWSClient campanyaService;
    @EJB
    protected ModuloWSClient moduloService;
    
    
    protected List<pojo.Modulo> listaModulo;
    protected List<pojo.Campanya> listaCampanyas;
    protected String filtro;
    protected String campanyaFiltro;
    
    protected String moduloJson;

    protected String dateString;

    @PostConstruct
    public void init() {
        campanyaService = new CampanyaWSClient();
        moduloService = new ModuloWSClient();
        if( listaModulo == null){
            listaModulo = moduloService.findAll();
        }
        
        if( listaCampanyas == null) {
            listaCampanyas = campanyaService.findAll();
        }
        moduloJson = getUbications();
    }
    
    public String orderByNombre() {
      listaModulo = moduloService.orderByNombre();
        return "listaModulos";
    }
    
    public String orderByRendimiento() {
//      listaModulo =moduloService.ord;
        return "listaModulos";
    }
    
    public String FilterByNombre() {
        listaModulo = moduloService.filterByNombre(filtro);
        return "listaModulos";
    }
    
    public String FilterByIdealidadLower() {
        
        Double num = Double.parseDouble(filtro);
        if(num != null){
            listaModulo = moduloService.filterByIdealidadLower(num);
        }
            
        return "listaModulos";
    }
    
    public String FilterByIdealidadGreater() {
        
        Double num = Double.parseDouble(filtro);
        if(num != null){
            listaModulo = moduloService.filterByIdealidadLower(num);
        }
            
        return "listaModulos";
    }
    
    public String listaModulosPage() {
        return "listaModulos";
    }
    
    public String listaCampanyasPage() {
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
        listaCampanyas = campanyaService.orderByNombre();
        return "listaCampanyas";
    }
    
    public String CampanyaOrderByFecha() {
        listaCampanyas = campanyaService.orderByFecha();
        return "listaCampanyas";
    }
    
    public String CampanyaFilterByNombre() {
        listaCampanyas = campanyaService.filterByNombre(filtro);
        return "listaCampanyas";
    }
    
    public String CampanyaFilterByFecha() {
        listaCampanyas = campanyaService.filterByFecha(dateString);
        return "listaCampanyas";
    }
    
    public String deleteModulo(int id) {
        moduloService.remove(id);
        return "index";
    }
    
    public String VolverIndex(){
        return "index";
    }
    
    public String seeMap() {
        return "Map";
    }
    

    public ModulosBean() {
    }
    
     // -------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    private String getUbications() {
        String s="[ ";
        int indx = 0; 
        for(Modulo m : listaModulo){
            indx++;
            s+="{lat: parseFloat("+m.getLatitud()+"), lng: parseFloat("+m.getLongitud()+")}"; 
            if(indx<listaModulo.size()){
                s+=",";
            }
        }
        s+="]";
        
        return s;
    }
    
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------
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
    public String getModuloJson() {
        return moduloJson;
    }

    public void setModuloJson(String ModuloJson) {
        this.moduloJson = ModuloJson;
    }
    
    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
    
    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------

    
    
}
