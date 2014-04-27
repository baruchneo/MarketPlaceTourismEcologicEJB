/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.marketPlaceTourismEcologicEJB.session;

import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.PaqueteTuristico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
@Stateless
public class PaqueteTuristicoFacade extends AbstractFacade<PaqueteTuristico> {
    @PersistenceContext(unitName = "MarketPlaceTourismEcologicEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaqueteTuristicoFacade() {
        super(PaqueteTuristico.class);
    }
    public List<PaqueteTuristico> getPaqueteBuscar(String buscar)
    {
        if(!buscar.trim().equals(""))
        {
            //String textQuery = "SELECT t FROM paquete_turistico t WHERE t.nombre LIKE '%:busquedaResult%' and t.estado = 'disponible' and publicado = 1";
            Query query = this.getEntityManager().createNamedQuery("PaqueteTuristico.findByLike")
                    .setParameter("codigo", "%" + buscar + "%");
            return query.getResultList();
        }
        else
        {
            return null;
        }
    }
    
}
