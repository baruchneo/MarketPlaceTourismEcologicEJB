/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.MarketPlaceTourismEcologicEJB.servletsSuperAdmin;

import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.servletsClients.CrearCliente;
import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.utils.DateUtils;
import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.utils.LoginUtils;
import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.utils.MailUtils;
import co.edu.uniminuto.MarketPlaceTourismEcologicEJB.utils.PasswordUtils;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Persona;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Proveedor;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Registro;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.TipoPersona;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.TipoRegistro;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.PersonaFacade;
import co.edu.uniminuto.marketPlaceTourismEcologicEJB.session.ProveedorFacade;
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
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "CrearProveedorSuperAdmin", urlPatterns = {"/CrearProveedorSuperAdmin"})
public class CrearProveedorSuperAdmin extends HttpServlet 
{

    @EJB
    private ProveedorFacade proveedorFacade;
    
    @EJB
    private RegistroFacade regitroFacade;
    
    @EJB
    private PersonaFacade personaFacade;
    
    @EJB
    private TipoPersonaFacade tipoPersonaFacade;
    
    @EJB
    private TipoRegistroFacade tipoRegistroFacade;
    
    private Persona persona;
    
    private Proveedor proveedor;
    
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearProveedorSuperAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearProveedorSuperAdmin at " + request.getContextPath() + "</h1>");
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
        String telefono = (request.getParameter("telefono").trim().equals("")? "0000000" : request.getParameter("telefono"));
        String telefonoMovil = (request.getParameter("telefonoMovil").trim().equals("")? "0000000000" : request.getParameter("telefonoMovil"));
        String email = request.getParameter("email");
        String estado = "Activo";
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
        persona.setIdPersona(0);
        
        personaFacade.create(persona);
        
        // obtengo el id de la persona
        persona = personaFacade.findByUserPassword(usuario, clave);
        //llenar objeto registro
        TipoRegistro tipoRegistro = tipoRegistroFacade.find(1);
        String fechaRegistro;
        fechaRegistro = dateUtils.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
        String msg = "Se ha creado un nuevo proveedor con esta informaci\u00f3n";
        msg += "Nombres[" + nombres + "], Apellidos [" + apellidos + "] ";
        msg += "Usuario [" + usuario + "], Email [" + email + "], ";
        msg += "Telefono [" + telefono + "], M\u00f3vil [" + telefonoMovil + "]";
        registro.setTitulo("Creaci\u00f3n de nuevo Ususario");
        registro.setDescripcion(msg);
        try {
            registro.setFechaRegistro(dateUtils.stringToDate(fechaRegistro, "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException ex) {
            Logger.getLogger(CrearCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        registro.setIdTipoRegistro(tipoRegistro);
        registro.setIdPersona(persona.getIdPersona());
        registro.setIdRegistroLog(0);
        //falta id persona pero es cuando se inserte una nueva.
        
        regitroFacade.create(registro);
        
        if(sendMail(calveDecrypt))
        {
            request.setAttribute("persona", persona);
            request.setAttribute("msgError", "");
            request.setAttribute("msgError", "Proveedor Creado");
            request.getRequestDispatcher("superAdminProviders.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("persona", persona);
            request.setAttribute("msgError", "Error al enviar datos de contacto al nuevo proveedor");
            request.setAttribute("msgError", "Proveedor Creado");
            request.getRequestDispatcher("superAdminProviders.jsp").forward(request, response);
        }
        
        processRequest(request, response);
    }
    
    public boolean sendMail(String clave)
    {
        MailUtils mailUtils  = new MailUtils();
        String mailSubject = "Creaci\u00f3n y confirmaci\u00f3n cliente";
        String htmlString = "<body>"
                + "<div>"
                + "<h3>Usuario creado con &eacute;xito</h3>"
                + "<p>Ha sido añadido como proveedor de la aplicaci&oacute;n para compra"
                + " de paquetes Tur&iacute;sticos.</p><br><br>"
                + "<p>Sudatos de conexi&oacute son:"
                + "<ul><li> Usuario: <p style=\"font-weight:bold; font-weight:italic;\">" + persona.getUsuario() + "</p></li>"
                + "<li> Usuario: <p style=\"font-weight:bold; font-weight:italic;\">" + clave + "</p></li></ul>"
                + "<br><br><p> Debe completar la creaci&oacute;n del proveedor desde este enlace: <br><br>"
                + "<a href=\"http://localhost:8080/MarketPlaceTourismEcologicEJB-war/crearDatosProveedor?user=" + persona.getUsuario() + "&clave=" + persona.getClave() + "\" >Clic Aqu&iacute;</a>"
                + "<br><br><p>Por favor no responsda este correo</p></body>";
        try {
            mailUtils.send(persona.getEmail(), mailSubject, htmlString);
            return true;
        } catch (MessagingException ex) {
            Logger.getLogger(CrearCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
