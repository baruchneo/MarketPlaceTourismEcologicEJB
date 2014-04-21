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
        <link rel="stylesheet" href="style/AdministratorStyle.css">
        <link rel="stylesheet" href="style/FormsStyle.css">
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
            <div id="gridAdminProvider" >
                <li><a href="adminHome.jsp"><span></span></a></li>
            </div>
            <div id="gridAdminService" >
                <li><a href="adminService.jsp"><span></span></a></li>
            </div>
            <div id="gridAdminPackage" >
                <li><a href="adminPackage.jsp"><span></span></a></li>
            </div>
            <div class="current" id="gridAdminClient" >
                <li><a href="adminClient.jsp"><span></span></a></li>
            </div>
            <div id="gridAdminHistory">
                <li><a href="adminHistory.jsp"><span></span></a></li>
            </div>
            <div id="gridAdminQuest">
                <li><a href="adminQuest.jsp"><span></span></a></li>
            </div>
        </ol>
        <div class="content" id="grid_Conten" style="margin-left: 30px;">
            <div id="scroll">
            
                <h2>Ingreso Usuarios Clientes</h2>
                <p>
                    <form action="AccesoUsuarios" method="post">
                        <table>
                            <tr>
                                <td>Usuario :</td>
                                <td><input type="text" name="usuario" >
                            </tr>
                            <tr>
                                <td>Clave :</td>
                                <td><input type="password" name="password" >
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" name="ingresar" value="Ingresar">
                                </td>
                            </tr>
                        </table>
                    </form>
                </p>
                <form method="post" action="" >
            </div>
        </div> 
        </div>
    </body>
</html>

