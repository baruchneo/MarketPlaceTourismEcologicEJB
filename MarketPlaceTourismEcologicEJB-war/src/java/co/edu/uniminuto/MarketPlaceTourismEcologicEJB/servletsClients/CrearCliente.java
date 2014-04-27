/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.MarketPlaceTourismEcologicEJB.servletsClients;

import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.utils.DateUtils;
import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.utils.LoginUtils;
import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.utils.PasswordUtils;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Persona;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Registro;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.TipoPersona;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.TipoRegistro;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.PersonaFacade;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.RegistroFacade;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.TipoPersonaFacade;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.TipoRegistroFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "CrearCliente", urlPatterns = {"/CrearCliente"})
public class CrearCliente extends HttpServlet 
{
    @EJB
    private PersonaFacade personaFacade;
    
    @EJB
    private RegistroFacade registroFacade;
    
    @EJB
    private TipoPersonaFacade tipoPersonaFacade;
    
    @EJB
    private TipoRegistroFacade tipoRegistroFacade;
    
    private Persona persona;
    
    private Registro registro;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearCliente at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
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
        //insertar nueva persona alistar data
        LoginUtils loginUtils = new LoginUtils();
        PasswordUtils passwordUtils = new PasswordUtils();
        DateUtils dateUtils = new DateUtils();
        Date fechaNacimiento = new Date();
        String clave = "";
        persona = new Persona();
        registro = new Registro();
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String calveDecrypt = passwordUtils.generateAleatoriumPassword();
        try {
            clave = passwordUtils.hashPassword(calveDecrypt);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CrearCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String usuario = loginUtils.crearUsuario(nombres, apellidos);
        String tipoDocumento = request.getParameter("tipoDocumento");
        String documento = request.getParameter("documento");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String telefonoMovil = request.getParameter("telefonoMovil");
        String email = request.getParameter("email");
        String estado = "activo";
        Integer tipoPersona = Integer.parseInt(request.getParameter("tipoPersona"));
        String fechaNacimientoString = request.getParameter("fechaNacimiento");
        try {
            fechaNacimiento = dateUtils.stringToDate(fechaNacimientoString, "yyyy-MM-dd");
        } catch (ParseException ex) {
            Logger.getLogger(CrearCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TipoPersona tipoPersonaObject = tipoPersonaFacade.find(tipoPersona);
        
        Persona per = personaFacade.findByUser(usuario);
        if(per != null)
        {
            usuario = loginUtils.updateUser(per.getUsuario(), usuario);
        }
        
        //llenar objeto persona y registro para prepararlos en la inserción
        persona.setNombres(nombres);
        persona.setAppellidos(apellidos);
        persona.setUsuario(usuario);
        persona.setClave(clave);
        persona.setTipoDocumento(tipoDocumento);
        persona.setNumDocumento(documento);
        persona.setFechaNacimiento(fechaNacimiento);
        persona.setEmail(email);
        persona.setDireccion(direccion);
        persona.setTelefono(telefono);
        persona.setTelefonoMovil(telefonoMovil);
        persona.setEstado(estado);
        persona.setIdTipoPersona(tipoPersonaObject);
        
        //personaFacade.create(persona);
        
        
        //llenar objeto registro
        TipoRegistro tipoRegistro = tipoRegistroFacade.find(1);
        String fechaRegistro;
        fechaRegistro = dateUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
        String msg = "Se ha creado un nuevo cliente con esta informacion";
        msg += "Nombres[" + nombres + "], Apellidos [" + apellidos + "] ";
        msg += "usuario [" + usuario + "], email [" + email + "], ";
        msg += "telefono [" + telefono + "], movil [" + telefonoMovil + "]";
        registro.setTitulo("Creacion de nuevo Ususario");
        registro.setDescripcion(msg);
        try {
            registro.setFechaRegistro(dateUtils.stringToDate(fechaRegistro, "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException ex) {
            Logger.getLogger(CrearCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        registro.setIdTipoRegistro(tipoRegistro);
        //falta id persona pero es cuando se inserte una nueva.
        
        
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
