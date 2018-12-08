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
import pojo.Campanya;

/**
 * Jersey REST client generated for REST resource:CampanyaFacadeREST
 * [campanya]<br>
 * USAGE:
 * <pre>
 *        CampanyaWSClient client = new CampanyaWSClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author JaGaRo
 */
@Stateless
public class CampanyaWSClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/A7servidorREST/webresources";

    public CampanyaWSClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("campanya");
    }

    public String count() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("count");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void edit(Campanya requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public Campanya find(Integer id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Campanya.class);
    }

    public List<Campanya> findRange(Integer from, Integer to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from.toString(), to.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Campanya>>(){});
    }

    public void create(Campanya requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public List<Campanya> findAll() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Campanya>>(){});
    }

    public void remove(Integer id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id.toString()})).request().delete();
    }
    
    public List<Campanya> filterByFecha(String fecha) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("filter/fecha/{0}", new Object[]{fecha}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Campanya>>(){});
    }
    
    public List<Campanya> filterByNombre(String nombre) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("filter/nombre/{0}", new Object[]{nombre}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Campanya>>(){});
    }
    
    public List<Campanya> findByModuloId(Integer id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("find/byModuloId/{0}", new Object[]{id.toString()}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Campanya>>(){});
    }
    
    public List<Campanya> orderByFecha() throws ClientErrorException {
        return webTarget.path("orderBy/fecha").
                request(javax.ws.rs.core.MediaType.APPLICATION_JSON).
                get(new GenericType<List<Campanya>>(){});
    }
    
    public List<Campanya> orderByNombre() throws ClientErrorException {
        return webTarget.path("orderBy/nombre").
                request(javax.ws.rs.core.MediaType.APPLICATION_JSON).
                get(new GenericType<List<Campanya>>(){});
    }

    public void close() {
        client.close();
    }
    
}
