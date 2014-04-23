/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.MarketPlaceTourismEcologicEJB.actions.login;

import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Persona;
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
    
    private Persona persona;
    
    @EJB
    private TipoPersonaFacade tipoPersonaFacade;

    public Persona getPersona() 
    {
        return persona;
    }

    public void setPersona(Persona persona) 
    {
        this.persona = persona;
    }
    
    
    
    public int veryfyLogin(String user, String password)
    {
        int result = 0;

        if(user.trim().equals(USER_SUPER_ADMIN) && password.trim().equals(PASSWORD_SUPER_ADMIN))
        { 
            result = -1;
        }
        else
        {
            if(persona != null)
            {
                this.user = persona.getUsuario();
                this.password = persona.getClave();
                result = persona.getIdTipoPersona().getIdTipoPersona();
            }
        }

        return result;
    }
    
    public boolean verifyPassword()
    {
        return true;
    }
 
}
