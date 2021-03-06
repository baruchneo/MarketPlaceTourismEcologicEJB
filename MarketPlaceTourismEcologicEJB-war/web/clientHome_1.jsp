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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    /*String usuarioSession = "";
    String tipoUsuarioSession = "";
    int idUsuarioSession = 0;
    String nombreUsuarioSession = "";
    if(request.getAttribute("usuario").equals(""))
    {
        usuarioSession  = (String) request.getSession().getAttribute("usuario");
        tipoUsuarioSession  = (String) request.getSession().getAttribute("tipoUsuario");
        idUsuarioSession  = Integer.parseInt((String) request.getSession().getAttribute("idPersona"));
        nombreUsuarioSession = (String) request.getSession().getAttribute("nombres");
    }*/
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/ClientStyle.css">
        <script src="javascript/ValidateLogin.js" type="text/javascript"></script>
        <title>Marketplace Turismo Ecológico</title>
    </head>
    <body>
        <% //if(usuarioSession.trim().equals("")){ %>
            <div id="login2" >
                <form method="post" action="AccesoUsuarios" > 
                    <input type="text" id="user" name="usuario" value="" placeholder="Usuario" size="11" style="margin-right: 56px;" />   
                    <input type="password" id="pass" name="password" value="" placeholder="Contraseña" size="11" /> 
                    <input type="submit" value="Ingresar" id="loginButton" />
                    <input type="button" value="Registrar" id="registerButton" onClick="window.location.href='createNewClient.jsp'"/>
                    <br> <a href="">Olvide mi<br> Contraseña</a>
                </form > 
            </div>
        <%// } else { %>
           <!-- <div id="login2" >
                <p style="margin-right: 56px;" ><%= //tipoUsuarioSession%></p>
                <p><%= //usuarioSession%></p>
                <br> <a href="../">Salir</a>
            </div> -->
        <%// } %>
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
                        <h2>Ofertas</h2>
                        <p>Texto...</p>
                        <form action="PersonaServlet" method="post">
                            <input type="submit" name="consultar" value="Consultar Personas">
                        </form>
                        {}
                    </div>
                </div> 
            </div>
        </div>
    </body>
</html>

