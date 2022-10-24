// Call the dataTables jQuery plugin
$(document).ready(function() {

});


async function registrarUsuario(){

     let datos = {};
        datos.username = datos.nombre = document.getElementById('txtNombre').value;
        datos.apellido = datos.nombre = document.getElementById('txtApellido').value;
        datos.email = datos.nombre = document.getElementById('txtEmail').value;
        datos.password = datos.nombre = document.getElementById('txtPassword').value;

        let passwordb = document.getElementById('txtPasswordB').value;

        if(passwordb != datos.password){
        alert("las contraseña son diferentes");
        return;
        }


          const request = await fetch('api/usuarios', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
              body: JSON.stringify(datos)
          });
          alert("se a registrado correctamente");
          window.location.href = 'login.html';
}
