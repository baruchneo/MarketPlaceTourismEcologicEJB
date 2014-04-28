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
                <input type="button" value="Registrar" id="submit" onClick="window.location.href='createNewClient.jsp'"/>
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
                        <fieldset>
                            <legend><h2>Crear Cleinte nuevo</h2></legend>
                            <div id="contact-form">
                                <p id="failure">Oops... Algo anduvo mal.</p> 
                                <p id="success">Gracias, tu mensaje ha sido enviado correctamente.</p>
                                <label>Por favor llene los campos solicitados</label>
                                <form method="post" action="CrearCliente" >
                                    <label>Nombres: <span class="required">*</span></label> 
                                    <input type="text" id="name" name="nombres" value="" placeholder="Escriba sus nombres" required="required" autofocus="autofocus" />
                                    <br>
                                    <label>Apellidos: <span class="required">*</span></label> 
                                    <input type="text" id="lastname" name="apellidos" value="" placeholder="Escriba sus apellidos" required="required" />
                                    <br>
                                    <label>Fecha Nacimiento: <span class="required">*</span></label> 
                                    <input id="date" type="date" name="fechaNacimiento" value="2014-07-13"/>
                                    <br> 
                                    <label>Lista<span class="required">*</span> </label> 
                                    <select id="typeDoc" name="tipoDocumento" style="width: 393px;">
                                        <option value="">Elija Opción</option>
                                        <option value="CC">Cédula Ciudadanía</option>
                                        <option value="CE">Cédula Extrangería</option> 
                                        <option value="PA">Pasaporte</option>
                                        <option value="OT">Otro Tipo Documento</option> 
                                    </select>
                                    <br>
                                    <label>Número Documento: <span class="required">*</span></label> 
                                    <input type="text" id="document" name="documento" value="" placeholder="Escriba su num. doc." required="required" />
                                    <br>
                                    <label>Dirección: <span class="required">*</span></label> 
                                    <input type="text" id="addres" name="direccion" value="" placeholder="Escriba ladirección de su domicilio." required="required" />
                                    <br>
                                    <label>Número telefónico: <br></label> 
                                    <input type="tel" id="phone" name="telefono" value="" placeholder="Escriba su num. telefonico" />
                                    <br>
                                    <label>Número telefónico móvil: <br></label> 
                                    <input type="tel" id="movilPhone" name="telefonoMovil" value="" placeholder="Escriba su num. celular" />
                                    <br>
                                    <label>Email: <span class="required">*</span></label> 
                                    <input type="email" id="email" name="email" value="" placeholder="suemail@email.com" required="required" />
                                    <br>
                                    <input type="hidden" id="tipeUser" name="tipoPersona" value="3">
                                    <input type="submit" value="Enviar" id="submit" />
                                </form>
                            </div>
                        </fieldset>
                    </div>
                </div> 
            </div>
        </div>
    </body>
</html>

