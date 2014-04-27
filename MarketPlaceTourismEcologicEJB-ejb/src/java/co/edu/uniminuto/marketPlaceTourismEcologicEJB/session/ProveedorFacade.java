/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.marketPlaceTourismEcologicEJB.session;

import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Proveedor;
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
public class ProveedorFacade extends AbstractFacade<Proveedor> {
    @PersistenceContext(unitName = "MarketPlaceTourismEcologicEJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorFacade() {
        super(Proveedor.class);
    }
    
    public List<Proveedor> getProveedorBuscar(String buscar)
    {
        if(!buscar.trim().equals(""))
        {
            //String textQuery="SELECT p FROM Proveedor p WHERE p.telefono LIKE '%"+buscar+"%' OR p.codigo LIKE '%"+buscar+"%'";
            Query query = this.getEntityManager().createNamedQuery("Proveedor.findByLike")
                .setParameter("codigo","%" + buscar + "%")
                .setParameter("razonSocial", "%" + buscar + "%")
                .setParameter("telefono", "%" + buscar + "%");
            

            return query.getResultList();
        }
        else
        {
            return null;
        }
    }
}
