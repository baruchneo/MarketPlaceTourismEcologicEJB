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


            </body>

        </html>



