/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsClient;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import pojo.Modulo;

/**
 * Jersey REST client generated for REST resource:ModuloFacadeREST [modulo]<br>
 * USAGE:
 * <pre>
 *        ModuloWSClient client = new ModuloWSClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author JaGaRo
 */
@Stateless
public class ModuloWSClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/A7servidorREST/webresources";

    public ModuloWSClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("modulo");
    }

    public void edit(Modulo requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public Modulo find(Integer id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Modulo.class);
    }

    public List<Modulo> findRange(Integer from, Integer to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from.toString(), to.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Modulo>>(){});
    }

    public String count() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("count");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void create(Modulo requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }
    
    public List<Modulo> orderByNombre() throws ClientErrorException {
        return webTarget.path("orderBy/nombre").
                request(javax.ws.rs.core.MediaType.APPLICATION_JSON).
                get(new GenericType<List<Modulo>>(){});
    }
    
    public List<Modulo> orderByRendimiento() throws ClientErrorException {
        return webTarget.path("orderBy/rendimiento").
                request(javax.ws.rs.core.MediaType.APPLICATION_JSON).
                get(new GenericType<List<Modulo>>(){});
    }
    
    public List<Modulo> filterByNombre(String nombre) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("filter/nombre/{0}", new Object[]{nombre}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Modulo>>(){});
    }

    public List<Modulo> findByValues(Double alpha, Double beta, Double gamma, Double kappa) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("filter/values/{0}/{1}/{2}/{3}", new Object[]{alpha.toString(), beta.toString(), gamma.toString(), kappa.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Modulo>>(){});
    }
    
    public List<Modulo> filterByIdealidadGreater(Double idealidad) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("filter/idealidad/greater/{0}", new Object[]{idealidad.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Modulo>>(){});
    }
    
    public List<Modulo> filterByIdealidadLower(Double idealidad) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("filter/rendimiento/lower/{0}", new Object[]{idealidad.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Modulo>>(){});
    }
    
    public List<Modulo> filterByRendimientoGreater(Double rendimiento) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("filter/rendimiento/greater/{0}", new Object[]{rendimiento.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Modulo>>(){});
    }
    
    public List<Modulo> filterByRendimientoLower(Double rendimiento) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("filter/rendimiento/lower/{0}", new Object[]{rendimiento.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Modulo>>(){});
    }
    
    public List<Modulo> filterByResistenciaGreater(Double resistencia) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("filter/resistencia/greater/{0}", new Object[]{resistencia.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Modulo>>(){}); 
    }
    
    public List<Modulo> filterByResistenciaLower(Double resistencia) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("filter/resistencia/lower/{0}", new Object[]{resistencia.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Modulo>>(){});
    }

    public List<Modulo> findAll() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Modulo>>(){});
    }

    public void remove(Integer id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id.toString()})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
