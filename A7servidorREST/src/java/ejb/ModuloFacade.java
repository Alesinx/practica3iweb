/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Modulo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author JaGaRo
 */
@Stateless
public class ModuloFacade extends AbstractFacade<Modulo> {

    @PersistenceContext(unitName = "iweb")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModuloFacade() {
        super(Modulo.class);
    }
    
    public List<Modulo> orderByNombre() {
        Query q;
        q = em.createQuery("SELECT m FROM Modulo m ORDER BY m.nombremodulo");
        return q.getResultList();
    }
    
    public List<Modulo> orderByRendimiento() {
        Query q;
        q = em.createQuery("SELECT m FROM Modulo m ORDER BY m.rendimiento");
        return q.getResultList();
    }
    
    public List<Modulo> filterByNombre(String nombre) {
        Query q;
        q = em.createQuery("SELECT m FROM Modulo m WHERE m.nombremodulo  = :nombre");
        q.setParameter("nombre", nombre);
        return q.getResultList();
    }
    
    public List<Modulo> filterByRendimientoLower(double rendimiento) {
        Query q;
        q = em.createQuery("SELECT m FROM Modulo m WHERE m.rendimiento <= :rendimiento");
        q.setParameter("rendimiento", rendimiento);
        return q.getResultList();
    }
    
    public List<Modulo> filterByRendimientoGreater(double rendimiento) {
        Query q;
        q = em.createQuery("SELECT m FROM Modulo m WHERE m.rendimiento >= :rendimiento");
        q.setParameter("rendimiento", rendimiento);
        return q.getResultList();
    }
    
    public List<Modulo> filterByResistenciaLower(double resistencia) {
        Query q;
        q = em.createQuery("SELECT m FROM Modulo m WHERE m.resistencia <= :resistencia");
        q.setParameter("resistencia", resistencia);
        return q.getResultList();
    }
    
    public List<Modulo> filterByResistenciaGreater(double resistencia) {
        Query q;
        q = em.createQuery("SELECT m FROM Modulo m WHERE m.resistencia >= :resistencia");
        q.setParameter("resistencia", resistencia);
        return q.getResultList();
    }
    
    public List<Modulo> filterByIdealidadLower(double idealidad) {
        Query q;
        q = em.createQuery("SELECT m FROM Modulo m WHERE m.idealidad <= :idealidad");
        q.setParameter("idealidad", idealidad);
        return q.getResultList();
    }
    
    public List<Modulo> filterByIdealidadGreater(double idealidad) {
        Query q;
        q = em.createQuery("SELECT m FROM Modulo m WHERE m.idealidad >= :idealidad");
        q.setParameter("idealidad", idealidad);
        return q.getResultList();
    }
    
    public List<Modulo> filterByValues(double alpha, double beta, double gamma, double kappa) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Modulo> query = cb.createQuery(Modulo.class);
        Root<Modulo> m = query.from(Modulo.class);
        Predicate predicate = null;
        
        if (alpha != -1) {
            predicate = cb.equal(m.get("valoralpha"), alpha);
        }
        if (beta != -1) {
            if (predicate == null) {
                predicate = cb.equal(m.get("valorbeta"), beta);
            }
            else {
                predicate = cb.and(predicate, cb.equal(m.get("valorbeta"), beta));
            }
        }
        if (gamma != -1) {
            if (predicate == null) {
                predicate = cb.equal(m.get("valorgamma"), gamma);
            }
            else {
               predicate = cb.and(predicate, cb.equal(m.get("valorgamma"), gamma));
            }
        }
        if (kappa != -1) {
            if (predicate == null) {
                predicate = cb.equal(m.get("valorkappa"), kappa);
            }
            else {
               predicate = cb.and(predicate, cb.equal(m.get("valorkappa"), kappa));
            }
        }
        
        query.select(m).where(predicate);
        return em.createQuery(query).getResultList();
    }   
    
}
