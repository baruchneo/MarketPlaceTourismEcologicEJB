/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.MarketPlaceTourismEcologicEJB.servletsProviders;

import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.servletsAdmin.*;
import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.servlets.ejemplo.*;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Persona;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.PersonaFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cristian
 */
@WebServlet(name = "PruebaPersona", urlPatterns = {"/PruebaPersona"})
public class Borrar_este_archivo extends HttpServlet {

    @EJB
    public PersonaFacade miPersonaEjemplo;
    
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Persona> personasCreadas = miPersonaEjemplo.findAll();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PruebaPersona</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PruebaPersona at " + request.getContextPath() + "</h1>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>Nombres</td>");
            out.println("<td>Apellidos</td>");
            out.println("<td>Doc Iden.</td>");
            out.println("<td>Direccion</td>");
            out.println("<td>Email</td>");
            out.println("<td>Usuario</td>");
            out.println("<td>Clave</td>");
            out.println("</tr>");
            for(Persona persona : personasCreadas)
            {
                out.println("<tr>");
                out.println("<td>" + persona.getNombres() + "</td>");
                out.println("<td>" + persona.getAppellidos() + "</td>");
                out.println("<td>" + persona.getNumDocumento() + "</td>");
                out.println("<td>" + persona.getDireccion() + "</td>");
                out.println("<td>" + persona.getEmail() + "</td>");
                out.println("<td>" + persona.getUsuario() + "</td>");
                out.println("<td>" + persona.getClave() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Borrar_este_archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Borrar_este_archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
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
