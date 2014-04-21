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
        <title>Marketplace Turismo Ecológico</title>
    </head>
  
    <body>
        <div id="Admin" >  </div>
        <div id="login" >  
            <form method="post" action="" > 
                <input type="text" id="user" name="user" value="" placeholder="Usuario" />   
                <input type="text" id="pass" name="pass" value="" placeholder="Contraseña" /> 
                <input type="submit" value="Entrar" id="submit" />  
                <input type="submit" value="Registrar" id="submit" />  
                <br> <a href="">Olvide mi<br> Contraseña</a>
            </form > 
        </div>
        <ol id="toc">
            <div class="current" id="grid_Admin" >
                <li><a href="Admin.html"><span></span></a></li>
            </div>
            <div id="grid_Admin_grid7">
                <li><a href="page7.html"><span></span></a></li>
            </div>
        </ol>
        <div class="content" id="grid_Conten" style="margin-left: 28px;">
            <div id="scroll">
            
                <h3>Registro de Usuarios</h3>
                    <form action="Register" method="post">
                        <fieldset>
                            <legend> Datos Personales Requeridos </legend>
                            Nombre: <br>
                            <input type="text" name="nombres" size="25" maxlength="50"></p>
                            Email: <br>
                            <input type="text" name="email" size="25" maxlength="50"></p>
                            Usuario: <br>
                            <input type="text" name="usuario" size="25" maxlength="50"></p> 
                            <label for="so">Tipo de Usuario</label> <br/>
                                <select id="so" name="so">
                                  <option value="" selected="selected">- seleccionar -</option>
                                  <option value="1">Administrador</option>
                                  <option value="2">Proveedor</option>
                                  <option value="3">Cliente</option>
                                </select>
                            <br>
                            Contraseña: <br>
                            <input type="password" name="password1" size="25" maxlength="50"></p>
                            Confirma contraseña <br>
                            <input type="password" name="password2" size="25" maxlength="50"></p>
                            
                        <p><input type="submit" value="Registrar"> <input type="button" value="Regresar" onClick=" window.location.href='clientHome.jsp' "></p>
                        
                        
                 </form>
                </p>
                
                          </div> 
        </div>
    </body>
</html>

