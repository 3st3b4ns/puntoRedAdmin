// Call the dataTables jQuery plugin
$(document).ready(function() {
 cargarUsuarios();
  $('#historial').DataTable();
});


async function cargarUsuarios(){
    (async () => {
      const request = await fetch('api/registrorecarga', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      const registrorecargas = await request.json();

       let ListadoHtml = '';
      for (let registrorecarga of registrorecargas){
           let usuarioHtml = '<tr><td>'+registrorecarga.id+'</td><td>'+registrorecarga.phonenumber+'</td><td>'+registrorecarga.amount+'</td><td>'+registrorecarga.supplier+
           '</td><td>'+registrorecarga.transaccion+'</td></tr>';
           ListadoHtml += usuarioHtml;
      }

      document.querySelector('#historial tbody').outerHTML = ListadoHtml;
    })();
}