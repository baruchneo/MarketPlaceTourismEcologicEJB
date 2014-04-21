/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.marketPlaceTourismEcologicEJB.session;

import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Persona;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Persona_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author cristian
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {
    @PersistenceContext(unitName = "MarketPlaceTourismEcologicEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    public Persona findByUser(String user)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery <Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> persona = cq.from(Persona.class);
        cq.where(cb.equal(persona.get(Persona_.usuario), user));
        TypedQuery<Persona> q = em.createQuery(cq);
        List<Persona> allPets = q.getResultList();
        return allPets.get(0);
    }
    
}
