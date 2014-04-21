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
            
                <h2>Ingreso Usuarios  Proveedores</h2>
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
                <div id="form_style_Radio"> 
                    <label>Radio buttons<br></label>     
                    <label for = "sizeSmall">Si</label>          
                    <input type = "radio" name = "radSize" id = "sizeSmall" value = "small" checked = "checked" />          
                    <label for = "sizeSmall">No</label>
                    <input type = "radio" name = "radSize" id = "sizeSmall" value = "small" />
                    <br>
                </div>             
                <div id="form_style_Check"> 
                    <label>Checkbox<br></label>               
                    <input type='checkbox' name="check1" value="true">check1    
                    <input type='checkbox' name="check2" value="true">check2 
                </div>                    
            
                <div id="form_style_Text"> 
                    <label>Texto: <br></label> 
                    <input type="text" id="texto" name="texto" value="" placeholder="Texto" required="required" autofocus="autofocus" />
                    <br>
                </div> 
            
                <div id="form_style_Lista"> 
                    <label>Lista<br> </label> 
                    <select id="lista" name="lista">   
                        <option value="lista1">lista 1</option>
                        <option value="lista2">lista 2</option> 
                        <option value="lista3">lista 3</option>   
                    </select>
                    <br>
                </div> 
            
                <div id="form_style_TextArea"> 
                    <label >Text Area:<br></label> 
                    <textarea id="textarea" name="textarea" placeholder="Escriba su texto"></textarea>
                    <br>
                </div> 

                <div id="form_style_Date"> 
                    <label for="date">Tipo Fecha : <br></label>
                    <input id="date" type="date" value="2014-07-13"/> 
                    <br>
                </div>              

                <label ><br>Div con scroll :</label>

                <div id="scroll_preba"> 
                    <label for="date"><br>espacio para agregar lo que se desee solo hay <br>que modificar en el style.css el tamaño del div en este caso se llama #scroll_preba Div con scroll : <br></label>  <br>
                </div>

                <div id="form_style_Boton"> 
                    <label >Boton :</label>    
                    <input type="submit" value="Boton" id="submit" />  
                </div>      
            </form> 

            <div id="contact-form" > 
                <p id="failure">Oops... Algo anduvo mal.</p> 
                <p id="success">Gracias, tu mensaje ha sido enviado correctamente.</p> 
                <label>Formulario de mensaje con validacion</label>   
                <form method="post" action="" > 
         
                    <label for="name">Nombre: <span class="required">*</span></label> 
                    <input type="text" id="name" name="name" value="" placeholder="Tu nombre" required="required" autofocus="autofocus" /> 

                    <label for="email">Email : <span class="required">*</span></label> 
                    <input type="email" id="email" name="email" value="" placeholder="tuemail@email.com" required="required" /> 

                    <label for="website">Website: </label> 
                    <input type="web" id="webstie" name="website" value="" /> 

                    <label for="subject">Asunto: </label> 
                    <select id="subject" name="subject">   
                        <option value="hello">Hola que mas</option>
                        <option value="quote">Quiero hacer una pregunta</option> 
                        <option value="general">General</option>   
                    </select> 

                    <label for="message">Mensaje: <span class="required">*</span></label> 
                    <textarea id="message" name="message" placeholder="Escriba su mensaje aquí, muchas gracias." required="required"></textarea> 

                    <input type="submit" value="Enviar!" id="submit" />
                </form> 
            </div>
        </div> 
        </div>
    </body>
</html>

