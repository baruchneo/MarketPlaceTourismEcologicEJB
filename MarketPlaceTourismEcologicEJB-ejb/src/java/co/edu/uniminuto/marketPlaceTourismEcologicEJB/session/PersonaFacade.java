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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author cristian
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> 
{
    @PersistenceContext(unitName = "MarketPlaceTourismEcologicEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }

    public PersonaFacade()
    {
        super(Persona.class);
    }
    
    /*+public Persona findByUserPassword(String user, String password)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery <Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> persona = cq.from(Persona.class);
        cq.where(
            cb.and(
                cb.equal(persona.get(Persona_.usuario), user),
                cb.equal(persona.get(Persona_.clave), password)
            )
        );
        TypedQuery<Persona> q = em.createQuery(cq);
        return (q.getSingleResult() == null) ? null : q.getSingleResult();
    }**/
    
    public Persona findByUserPassword(String user, String password)
    {
        String queryText;
        queryText = "SELECT p FROM Persona p WHERE p.usuario LIKE '" + user + "'";
        queryText += " AND p.clave LIKE '" + password + "'";
        
        Query query = this.getEntityManager().createQuery(queryText);

        return (Persona) ((query.getSingleResult() == null) ? null : query.getSingleResult());
    }
    
    public Persona findByUser(String user)
    {
        String queryText;
        queryText = "SELECT p FROM Persona p WHERE p.user LIKE '" + user + "%' ORDER BY p.id desc";
        
        Query query = this.getEntityManager().createQuery(queryText);
        query.setMaxResults(1);
        
        List <Persona> allPersonas = query.getResultList();
        return (allPersonas.isEmpty())? null : allPersonas.get(0);
    }
    
    /**public Persona findByUser(String user)
    {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery <Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> persona = cq.from(Persona.class);
        cq.where(cb.like(persona.get(Persona_.usuario), user + "*"));
        cq.orderBy(cb.desc(persona.get(Persona_.usuario)));
        TypedQuery<Persona> q = em.createQuery(cq);
        List <Persona> allPersonas = q.getResultList();        
        return (q.getSingleResult() == null) ? null : allPersonas.get(0);
    }**/
}
