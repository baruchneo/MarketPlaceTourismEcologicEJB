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
                <fieldset>
                    <legend><h2>Ingreso Usuarios  Proveedores</h2></legend>
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
                                <option value="CC">Cédula Ciudaddanía</option>
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
    </body>
</html>

