$(document).ready(function() {
ApiSuppliers();
$('#sig').hide();
});
const dato = sessionStorage.getItem('tk');
async function ApiSuppliers(){

      const request = await fetch('https://puntored-prueba-tecnica.herokuapp.com/puntored/api/recharge/suppliers', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Authorization': 'Bearer '+dato
        }
      });
       if(request['status'] != "403"){
        const supplier = await request.json();
           let sup = supplier['data']['suppliers'];

            $.each(sup, function(key, value) {
                $("#opera").append($('<option>', {
                           value: value['supplierId'],
                           text: value['supplierName']
                }));
            });
       }else{
             alert("Caduco Sesion");
             window.location.href = 'login.html';
       }
   }

 async function registrarRecarga(transaccion){
    let datosBuys = {};
         datosBuys.amount = document.getElementById('txtValor').value;
         datosBuys.phonenumber = document.getElementById('txtTelefono').value;
         datosBuys.supplier = document.getElementById('opera').value;
         datosBuys.transaccion = transaccion;
     const request = await fetch('api/registrorecarga', {
     method: 'POST',
      headers: {
         'Accept': 'application/json',
         'Content-Type': 'application/json'
       },
        body: JSON.stringify(datosBuys)
      });

      alert("se a registrado correctamente");
            location.reload()

}
async function ApiBuy(){
        let datosBuy = {};
        datosBuy.clientTransId = 123;
        datosBuy.amount = document.getElementById('txtValor').value;
        datosBuy.phoneNumber = document.getElementById('txtTelefono').value;
        datosBuy.supplierId = document.getElementById('opera').value;

      const request = await fetch('https://puntored-prueba-tecnica.herokuapp.com/puntored/api/recharge/buy', {
        method: 'POST',
        body: JSON.stringify(datosBuy),
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Authorization': 'Bearer '+dato
        }
      });
     if(request['status'] != "403"){
         const buy = await request.json();
         transaccion = buy['data']['ticket']['body']['Aprobacion'];
         registrarRecarga(transaccion);
     }else{
         alert("Caduco Sesion");
         window.location.href = 'login.html';
     }

}

var Vnum = 0;
var Vmon = 0;
var Vsel = 0;

function valMonto() {
    sst = $('#txtValor').val();
    if (sst.length >= 4 && sst.length <= 6) {
        Vmon = 1;
        past();
    }else{
        Vmon = 0;
        $('#sig').hide();
    }
}

function valNum() {
    sst = $('#txtTelefono').val();
    if (sst.length > 9 && sst.length <= 10) {
         Vnum = 1;
         past();
    }else{
          Vnum = 0;
         $('#sig').hide();
    }
      acomp = (sst.substr(0, 1));
        if(acomp != 3 && acomp != ""){
           alert("El numero telefonico debe comezar por 3");
           $("#txtTelefono").val("");
      }
}

function selectD(){
    var sx = document.getElementById("opera").value;
    if(!isNaN(sx)){
        Vsel = 1;
        past();
    }else{
        Vsel = 0;
        $('#sig').hide();
    }

}

function past(){
    if(Vnum == 1 && Vmon == 1 && Vsel == 1){
        $('#sig').show();
    }
}

