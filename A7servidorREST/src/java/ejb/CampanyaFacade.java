/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Campanya;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JaGaRo
 */
@Stateless
public class CampanyaFacade extends AbstractFacade<Campanya> {

    @PersistenceContext(unitName = "iweb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CampanyaFacade() {
        super(Campanya.class);
    }
    
    public List<Campanya> filterByNombre(String nombre) {
        Query q;
        q = em.createQuery("SELECT c FROM Campanya c WHERE c.nombrecampanya = :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }
    
    public List<Campanya> filterByFecha (Date date) {
        Query q;
        q = em.createQuery("SELECT c FROM Campanya c WHERE c.fecha <= :fecha");
        q.setParameter("fecha", date);
        return q.getResultList();
    }
    
    public List<Campanya> orderByFecha() {
        Query q;
        q = em.createQuery("SELECT c FROM Campanya c ORDER BY c.fecha");
        return q.getResultList();
    }
    
    public List<Campanya> orderByNombre() {
       Query q;
        q = em.createQuery("SELECT c FROM Campanya c ORDER BY c.nombrecampanya");
        return q.getResultList(); 
    }
    
    public List<Campanya> findByModuloId(int id) {
        Query q;
        q = em.createQuery("SELECT c FROM Campanya c WHERE c.moduloIdmodulo.idmodulo = :id");
        q.setParameter("id", id);
        return q.getResultList();
    }
}
