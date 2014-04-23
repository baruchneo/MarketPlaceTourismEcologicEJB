/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.MarketPlaceTourismEcologicEJB.actions.login;

/**
 *
 * @author cristian
 */
class LoginSuperUser 
{
    private static final String USER_SUPER_ADMIN = "admin";
    
    private static final String PASSWORD_SUPER_ADMIN = "7c222fb2927d828af22f592134e8932480637c0d";//12345678
    
    public boolean veryfyLoginAdmin(String user, String password)
    {
        return  (user.trim().equals(USER_SUPER_ADMIN) && password.trim().equals(PASSWORD_SUPER_ADMIN));
    }
    
    public boolean verifyPassword()
    {
        return true;
    }
 
}
