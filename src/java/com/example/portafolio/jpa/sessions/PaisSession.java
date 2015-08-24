package com.example.portafolio.jpa.sessions;

import com.example.portafolio.jpa.entities.Pais;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author leoandresm
 */
@Stateless
public class PaisSession {

    @PersistenceContext
    private EntityManager entityManager;
    
    public void create(Pais pais) {
        entityManager.persist(pais);
    }
    
    public void update(Pais pais) {
        entityManager.merge(pais);
    }
    
    public void remove(Pais pais) {
        entityManager.remove(pais);
    }
    
    public List<Pais> findAll(){
        CriteriaQuery cq = 
                entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Pais.class));
        return entityManager.createQuery(cq).getResultList();
    }
}
