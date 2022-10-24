// Call the dataTables jQuery plugin
$(document).ready(function() {
});




async function iniciarSession(){
    let datos = {};
    datos.username = document.getElementById('username').value;
    datos.password = document.getElementById('password').value;



      const request = await fetch('api/recarga', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
          body: JSON.stringify(datos)
      });
     const respuesta = await request.text();

     if(respuesta == 'ok'){
         iniciarSessionTk(datos);
     }else{
        alert("No posee un usuario");
     }


}

async function iniciarSessionTk(datost){

   const request = await fetch('https://puntored-prueba-tecnica.herokuapp.com/auth', {
            method: 'POST',
            body: JSON.stringify(datost),
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
            }
          });

        const ini = await request.json();
        sessionStorage.removeItem('tk');
          if(ini['message'] == 'Proccess Successful'){

            sessionStorage.setItem("tk", ini['data']['token'])

             window.location.replace("blank.html");

           }else{
              alert("Contatese con el provedor para que le proporcione permisos");
           }
}

