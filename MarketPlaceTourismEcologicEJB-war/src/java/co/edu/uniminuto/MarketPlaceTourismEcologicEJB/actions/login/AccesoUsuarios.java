/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.MarketPlaceTourismEcologicEJB.actions.login;

import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.utils.PasswordUtils;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Persona;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.PersonaFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cristian
 */
public class AccesoUsuarios extends HttpServlet 
{
    private LoginSuperUser superUser;
    private PasswordUtils passwordUtils;
    private String usuario;
    private String clave;
    private HttpSession session;
    
    @EJB
    private PersonaFacade personaFacade;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Persona persona = null;
            superUser = new LoginSuperUser();
            
            session = request.getSession();
            
            if(superUser.veryfyLoginAdmin(usuario, clave))
            {
                session.setAttribute("usuario", usuario);
                session.setAttribute("nombre", "Superusuario");
                request.getRequestDispatcher("superAdminHome.jsp").forward(request, response);
            }
            else
            {
                int result = 0;
                persona = personaFacade.findByUserPassword(usuario, clave);
                if(persona != null)
                {
                    result = persona.getIdTipoPersona().getIdTipoPersona();
                    if(result == 1)
                    {
                        //Adminisradores
                        request.getRequestDispatcher("adminHome.jsp").forward(request, response);
                    }
                    if(result == 2)
                    {
                        //Proveedores
                        request.getRequestDispatcher("proveedorHome.jsp").forward(request, response);
                    }
                    if(result == 3)
                    {
                        // clientes
                        request.getRequestDispatcher("clientHome.jsp").forward(request, response);
                    }
                }
                else
                {
                    persona = personaFacade.findByUser(usuario);
                    if(persona != null)
                    {
                        //clave errada
                        request.setAttribute("error", 1);
                        request.getRequestDispatcher("clientHome.jsp?error=1").forward(request, response);
                        //pagina para crear un cliente nuevo
                    }
                    else
                    {
                        String msg = "";
                        msg = "El usuario no se encuentra logueado, si es un cliente";
                        msg += " llene los datos de nuevo cliente, de lo contrario solicite";
                        msg += " su usuario con el administrador";
                        out.println("<html><body><script type=\"text/javascript\">");  
                        out.println("alert(" + msg + ");");  
                        out.println("</script></body></html>");
                        response.sendRedirect("createNewClient.jsp?error=1");//pagina para crear un cliente nuevo
                    }
                }
            }
        }
        finally 
        {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        String claveTemp = "";
        String usaurioTemp = "";
        claveTemp = request.getParameter("password");
        usaurioTemp = request.getParameter("usuario");
        passwordUtils = new PasswordUtils();
        this.usuario = usaurioTemp;
        try {
            this.clave = passwordUtils.hashPassword(claveTemp);
        } 
        catch (NoSuchAlgorithmException ex) 
        {
            Logger.getLogger(AccesoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
