/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.MarketPlaceTourismEcologicEJB.utils;

/**
 * @author Cristian rodriguez    baruchneo@gmail.com
 * @author Cristian Vargas      cvarga35@uniminuto.edu.co
 * @author Yohan EspaNa         espanaqwe123@gmail.com
 * @author Wilson Lombana       sonwil1525@gmail.com
 * 
 */
public class LoginUtils 
{
    public String crearUsuario(String nombre, String apellido) throws NullPointerException
    {
        String userResult = "";
        String tempName = nombre.substring(0, nombre.indexOf(" ")-1);
        String tempLastName = apellido.substring(0, apellido.indexOf(" ")-1);
        userResult = tempName + tempLastName;
        return userResult;
    }
}
