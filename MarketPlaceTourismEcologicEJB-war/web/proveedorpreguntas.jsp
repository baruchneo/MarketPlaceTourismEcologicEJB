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
                <link rel="stylesheet" href="style/ProvStyle.css">
                <link rel="stylesheet" href="style/ClientStyle.css">
                <link rel="stylesheet" href="ClientStyle.css">

                <title>Marketplace Turismo Ecológico</title>

            </head>


 <body>
  <div id="login2" >  
            <form method="post" action="" > 
                <input type="text" id="user" name="user" value="" placeholder="Usuario" size="11" style="margin-right: 56px;" />   
                <input type="text" id="pass" name="pass" value="" placeholder="Contraseña" size="11" /> 
                <input type="submit" value="Ingresar" id="submit" />
                <input type="submit" value="Registrar" id="submit" />
                <br> <a href="">Olvide mi<br> Contraseña</a>
            </form > 
        </div> 
                
      <div id="Provee" > 

        <ol id="toc">

            <div id="grid_Provee" >
            <li class="current" ><a href="proveedorHome.jsp"><span></span></a></li>
            </div>

            <div id="grid_Provee_SERVICIOS">
            <li><a href="proveedorServicios.jsp"><span></span></a></li>
            </div>

            <div id="grid_Provee_PAQUETES">
            <li ><a href="proveedorPaquetes.jsp"><span></span></a></li>
            </div>

            <div id="grid_Provee_CLIENTES">
            <li ><a href="proveedorClientes.jsp"><span></span></a></li>
            </div>

            <div id="grid_Provee_BUSCAR">
            <li ><a href="proveedorBuscar.jsp"><span></span></a></li>
            </div>

            <div id="grid_Provee_Historial">
            <li ><a href="HistoricoVentasProveedor.jsp"><span></span></a></li>
            </div>

              <div id="grid_Provee_PREGUNTAS">
            <li ><a href="Fecha.jsp"><span></span></a></li>
            </div>

              <div id="grid_Provee_CREAREMP">
            <li ><a href="proveedorCreaEmp.jsp"><span></span></a></li>
            </div>

  </div>  

<div id="scroll">

        <form method="post" action="" >


            <div id="form_style_Radio"> 
                 

				<label for="subject">Asunto: </label> 
              <select id="subject" name="subject">   
                 <!--<option value="hello">Hola que mas</option>-->
                 <option value="quote">Vacío</option> 
                 <option value="quote">Quiero hacer una pregunta</option> 
				 <option value="quote">Tengo dudas acerca de un tema</option>
				 <option value="quote">Inconformidad con un servicio</option>
                 <option value="general">General</option>   
              </select>  		 

        <div id="form_style_Text"> 
                <label>Debe diligenciar los datos obligatorios e ingresar sus preguntas: <br></label> 
                   
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
                 
              <!--<label for="subject">Asunto: </label> 
              <select id="subject" name="subject">   
              <option value="general">General</option>   
              </select> -->
                 
              <label for="message">Mensaje: <span class="required">*</span></label> 
              <textarea id="message" name="message" placeholder="Escriba su mensaje aquí, muchas gracias." required="required"></textarea> 
                   
              <input type="submit" value="Enviar!" id="submit" />
           </form> 
        </div>

        </div> 


        </div>

            </body>

        </html>



