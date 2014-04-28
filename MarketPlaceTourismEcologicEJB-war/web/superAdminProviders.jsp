<%-- 
/**
 * Uniminuto 
 * Arquitectura de Software 
 * Docente: Yamid Ramirez       NRC: 3242
 * @author Cristian rodriguez   baruchneo@gmail.com         IdGenesis: 000034860
 * @author Cristian Vargas      cvarga35@uniminuto.edu.co   IdGenesis: 000164598
 * @author Yohan EspaNa         espanaqwe123@gmail.com      IdGenesis: 000127710
 * @author Wilson Lombana       sonwil1525@gmail.com        IdGenesis: 000065955
 * Marzo 2014
 */
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
String msgSearch = "";
List<Proveedor> proveedores = new ArrayList <Proveedor> ();

if((List<Proveedor>) request.getAttribute("proveedores") != null)
{
    proveedores = (List<Proveedor>) request.getAttribute("proveedores");
}
else
{
    msgSearch = "No hay coincidencias disponibles por el filtrado de la búsqueda";
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/SuperAdminStyle.css">
        <link rel="stylesheet" href="style/FormsStyle.css">
        <title>Marketplace Turismo Ecológico</title>
    </head>
  
    <body>
        <div id="login2" >
            <p style="margin-right: 56px;">Usuario</p>
            <p>Super Usuario</p>
            <a href="">Salir</a> 
        </div>
        <ol id="toc">
            <div id="gridSuperAdminHome" >
                <li><a href="superAdminHome.jsp"><span></span></a></li>
            </div>
            <div class="current"  id="gridSuperAdminProvider" >
                <li><a href="superAdminProviders.jsp"><span></span></a></li>
            </div>
            <div id="gridSuperAdminServices" >
                <li><a href="superAdminServices.jsp"><span></span></a></li>
            </div>
            <div id="gridSuperAdminMessages" >
                <li><a href="superAdminMessages.jsp"><span></span></a></li>
            </div>
            <div id="gridSuperAdminHistory">
                <li><a href="superAdminHistory.jsp"><span></span></a></li>
            </div>
        </ol>
        <div class="content" id="grid_Conten" style="margin-left: 30px;">
            <div id="scroll">
                <div id="contact-form" >
                    <p id="failure">Oops... Algo anduvo mal.</p> 
                    <p id="success">Gracias, tu mensaje ha sido enviado correctamente.</p> 
                    <label>Formulario de Busqueda de Proveedores - Paquetes Turisticos</label> 
                    <form action="ServletCientes" method="post">
                        <label for="name">Codigo de Proveedor: <span class="required">*</span></label> 
                        <input type="text" id="name" name="nameProvider" value="" placeholder="Nombre proveedor" autofocus="autofocus" />
                        <label for="name">Codigo de Paquete: <span class="required">*</span></label> 
                        <input type="text" id="name" name="namePackage" value="" placeholder="Codido del paquete" autofocus="autofocus" />
                        <input type="submit" value="Buscar!" id="submit" />

                    </form>
                </div>
                        
                <br>
                <%if(!proveedores.isEmpty()){%>
                    <table border="1">
                        <tr>
                            <% for(Proveedor proveedor: proveedores){ %>
                            <td><%= proveedor.getRazonSocial() %></td>
                            <td><%= proveedor.getCodigo() %></td>
                            <td><%= proveedor.getTelefono() %></td>
                            <td><%= proveedor.getDireccion()%></td>
                            <td><%= proveedor.getPaginaWeb()%></td>
                            <td><%= proveedor.getEmail()%></td>                               
                            <% } %>
                        </tr>
                    </table>
                <% } else { %>
                    <p><%= msgSearch %></p>
                <% } %>
            </div> 
        </div>
    </body>
</html>

