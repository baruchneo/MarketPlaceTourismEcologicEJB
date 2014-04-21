/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.MarketPlaceTourismEcologicEJB.actions.login;

import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Persona;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.PersonaFacade;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.TipoPersonaFacade;
import javax.ejb.EJB;

/**
 *
 * @author cristian
 */
class LoginUsers 
{
    private static final String USER_SUPER_ADMIN = "admin";
    
    private static final String PASSWORD_SUPER_ADMIN = "12345678";
    
    private String user;
    
    private String password;
    
    @EJB
    private PersonaFacade personaFacade;
    
    @EJB
    private TipoPersonaFacade tipoPersonaFacade;
    
    public int veryfyLogin(String user, String password)
    {
        int result = -1;
        if(user.trim().equals(USER_SUPER_ADMIN) && password.trim().equals(PASSWORD_SUPER_ADMIN))
        {
            return 4;
        }
        else
        {
            Persona persona = personaFacade.findByUser(user);
            if(persona != null)
            {
                this.user = persona.getUsuario();
                this.password = persona.getClave();
                result = persona.getIdTipoPersona().getIdTipoPersona();
                
            }
            
            return result; 
        }
    }
    
    public boolean verifyPassword()
    {
        return true;
    }
 
}
