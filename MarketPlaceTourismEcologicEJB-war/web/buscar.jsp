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


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.PaqueteTuristico"%>
<%@page import="co.edu.uniminuto.marketPlaceTourismEcologicEJB.entities.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String msgSearch = "";
    List<Proveedor> proveedores = new ArrayList <Proveedor> ();
    List<PaqueteTuristico> paquete = new ArrayList <PaqueteTuristico> ();

    if((List<Proveedor>) request.getAttribute("proveedores") != null)
    {
        proveedores = (List<Proveedor>) request.getAttribute("proveedores");
    }
    else if((List<PaqueteTuristico>) request.getAttribute("paquete") != null)
    {
            paquete = (List<PaqueteTuristico>) request.getAttribute("paquete");
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
        <link rel="stylesheet" href="style/ClientStyle.css">
        <title>Marketplace Turismo Ecológico</title>
    </head>
    <body>
        <div id="login2" >  
            <form method="post" action="AccesoUsuarios" > 
                <input type="text" id="user" name="usuario" value="" placeholder="Usuario" size="11" style="margin-right: 56px;" />   
                <input type="password" id="pass" name="password" value="" placeholder="Contraseña" size="11" /> 
                <input type="submit" value="Ingresar" id="submit" />
                <input type="button" value="Registrar" id="submit" onClick="window.location.href='registrarUser.jsp'"/>
                <br> <a href="">Olvide mi<br> Contraseña</a>
            </form > 
        </div>  
        <div id="fondo">
            <div>
                <ol id="toc">
                    <div  id="grid1" >
                        <li><a href="hoteles.jsp"><span></span></a></li>
                    </div> 
                    <div id="grid2">
                        <li><a href="alimentacion.jsp"><span></span></a></li>
                    </div> 
                    <div id="grid3">
                        <li><a href="viajesEcologicos.jsp"><span></span></a></li>
                    </div> 
                    <div id="grid4">
                        <li class="current"><a href="clientHome.jsp"><span></span></a></li>
                    </div> 
                    <div id="grid5">
                        <li><a href="comprar.jsp"><span></span></a></li>
                    </div> 
                    <div id="grid6">
                        <li><a href="preguntas.jsp"><span></span></a></li>
                    </div> 
                    <div id="grid7">
                        <li><a href="historial.jsp"><span></span></a></li>
                    </div> 
                    <div id="grid8">
                        <li><a href="buscar.jsp"><span></span></a></li>
                    </div> 
                    <div id="grid9">
                        <li><a href="ingresar.jsp"><span></span></a></li>
                    </div>
                </ol>
                <div class="content" id="grid" style="margin-left: 30px;">
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
                        <%}else if(!paquete.isEmpty()){%>
                            <table border="1">
                                <tr>
                                    <% for(PaqueteTuristico PaqueteTuristico: paquete){ %>
                                    <td><%= PaqueteTuristico.getNombre() %></td>
                                    <td><%= PaqueteTuristico.getUbicacion()%></td>
                                    <td><%= PaqueteTuristico.getCodigo()%></td>
                                    <td><%= PaqueteTuristico.getDescripcion()%></td>
                                    <td><%= PaqueteTuristico.getEstado()%></td>

                                    <% } %>
                                </tr>
                            </table>
                        <% } else { %>
                            <p><%= msgSearch %></p>
                        <% } %>
                    </div>
                </div> 
            </div>
        </div>
    </body>
</html>

