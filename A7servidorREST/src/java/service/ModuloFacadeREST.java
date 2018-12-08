/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.ModuloFacade;
import entity.Modulo;
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
@Path("modulo")
public class ModuloFacadeREST {

    @EJB
    private ModuloFacade moduloFacade;    

    public ModuloFacadeREST() { }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Modulo entity) {
        moduloFacade.create(entity);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(Modulo entity) {
        moduloFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
         moduloFacade.remove(moduloFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Modulo find(@PathParam("id") Integer id) {
        return moduloFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> findAll() {
        return moduloFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return moduloFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String count() {
        return String.valueOf(moduloFacade.count());
    }
    
    @GET
    @Path("orderBy/nombre")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> orberByNombre() {
        return moduloFacade.orderByNombre();
    }
    
    @GET
    @Path("orderBy/rendimiento")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> orderByRendimiento() {
        return moduloFacade.orderByRendimiento();
    }
    
    @GET
    @Path("filter/nombre/{nombre}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> filterByNombre(@PathParam("nombre") String nombre) {
        return moduloFacade.filterByNombre(nombre);
    }
    
    @GET
    @Path("filter/rendimiento/greater/{rendimiento}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> filterByRendimientoGreater(@PathParam("rendimiento") double rendimiento) {
        return moduloFacade.filterByRendimientoGreater(rendimiento);
    }
    
    @GET
    @Path("filter/rendimiento/lower/{rendimiento}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> filterByRendimientoLower(@PathParam("rendimiento") double rendimiento) {
        return moduloFacade.filterByRendimientoLower(rendimiento);
    }
    
    @GET
    @Path("filter/resistencia/greater/{resistencia}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> filterByResistenciaGreater(@PathParam("resistencia") double resistencia) {
        return moduloFacade.filterByResistenciaGreater(resistencia);
    }
    
    @GET
    @Path("filter/resistencia/lower/{resistencia}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> filterByResistenciaLower(@PathParam("resistencia") double resistencia) {
        return moduloFacade.filterByResistenciaLower(resistencia);
    }
    
    @GET
    @Path("filter/idealidad/greater/{idealidad}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> filterByIdealidadGreater(@PathParam("idealidad") double idealidad) {
        return moduloFacade.filterByIdealidadGreater(idealidad);
    }
    
    @GET
    @Path("filter/idealidad/lower/{idealidad}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> filterByIdealidadLower(@PathParam("idealidad") double idealidad) {
        return moduloFacade.filterByIdealidadLower(idealidad);
    }
    
    @GET
    @Path("filter/values/{alpha}/{beta}/{gamma}/{kappa}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modulo> filterByValues(@PathParam("alpha") double alpha, 
                                     @PathParam("beta") double beta,
                                     @PathParam("gamma") double gamma,
                                     @PathParam("kappa") double kappa) {
        
        return moduloFacade.filterByValues(alpha, beta, gamma, kappa);
    }
    
}
