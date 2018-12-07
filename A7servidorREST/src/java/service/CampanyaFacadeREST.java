/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.CampanyaFacade;
import entity.Campanya;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author JaGaRo
 */
@Stateless
@Path("campanya")
public class CampanyaFacadeREST {

    @EJB
    private CampanyaFacade campanyaFacade;    

    public CampanyaFacadeREST() {    
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Campanya entity) {
        campanyaFacade.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(Campanya entity) {
        campanyaFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        campanyaFacade.remove(campanyaFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Campanya find(@PathParam("id") Integer id) {
        return campanyaFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Campanya> findAll() {
        return campanyaFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Campanya> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return campanyaFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(campanyaFacade.count());
    }
    
    @GET
    @Path("filter/date/{date}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Campanya> filterByDate(@PathParam("date") String date)throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy");
        return campanyaFacade.filterByDate(sdf.parse(date));
    }
    
    @GET
    @Path("find/byModuloId/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Campanya> findByModuloId(@PathParam("id") int id) {
        return campanyaFacade.findByModuloId(id);
    }
    
}
