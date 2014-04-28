/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.MarketPlaceTourismEcologicEJB.actions.cliente;

import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.PaqueteTuristico;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Proveedor;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.PaqueteTuristicoFacade;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.ProveedorFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WilsonGiovanny
 */
@WebServlet(name = "ServletCientes", urlPatterns = {"/ServletCientes"})
public class ServletCientes extends HttpServlet {

    @EJB ProveedorFacade provedorFacade;
    @EJB PaqueteTuristicoFacade paqueteTuristicoFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Buscar Proveedor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Buscar Proveedor</h1>");
            out.println("</body>");
            
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String textProvider = request.getParameter("nameProvider");
        String textPackage = request.getParameter("namePackage");
        List <Proveedor> proveedores = provedorFacade.getProveedorBuscar(textProvider);
        List <PaqueteTuristico> paquete = paqueteTuristicoFacade.getPaqueteBuscar(textPackage);
        request.setAttribute("proveedores", proveedores);
        request.setAttribute("paquete", paquete);
        request.getRequestDispatcher("buscar.jsp").forward(request, response);
        //request.getRequestDispatcher("/clienteHome.jsp").forward(request, response);
        
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
