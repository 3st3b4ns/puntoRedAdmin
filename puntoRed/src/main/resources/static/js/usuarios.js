// Call the dataTables jQuery plugin
$(document).ready(function() {
 cargarUsuarios();
 probarApi();
  $('#usuarios').DataTable();
});


async function cargarUsuarios(){
    (async () => {
      const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      const usuarios = await request.json();



       let ListadoHtml = '';
      for (let usuario of usuarios){
           let botonEliminar = '<a href="#" onclick="elimonarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
           let telefono = usuario.telefono == null ? '-' : usuario.telefono;

           let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.username+' '
           +usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+telefono+
           '</td><td>'+botonEliminar+'</td></tr>';

           ListadoHtml += usuarioHtml;
      }

      document.querySelector('#usuarios tbody').outerHTML = ListadoHtml;
    })();
}

async function elimonarUsuario(id){

if (!confirm('¿DESEA ELIMINAR EL USUARIO?')){
    return;
}

      const request = await fetch('api/usuarios/' + id, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      });

      location.reload()
}
