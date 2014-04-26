/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function validateForm()
{
    var usuario = document.getElementById("user");
    var clave = document.getElementById("pass");
    
    if(usuario.length < 5)
    {
        alert('El nombre de usuario debe contener minimo 5 letras');
        return false;
    }
    else if(clave.length < 8)
    {
        alert('La clave debe ser minimo de 8 letras');
        return false;
    }
    else 
    {
        return true;
    }
}


