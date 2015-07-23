/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_tipo_placa, nombre_maquina, descripcion, precio, nombre_precio) {

    // busqueda de nombre_maquina
    var select_maquina = document.forms[0].id_maquina;
    var index_maquina = 0;
    for (i = 0;i < select_maquina.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_precio );
        if (select_maquina.options[i].innerText == nombre_maquina) {
            index_maquina = i;
            break;
        }
    }
    
    // busqueda de nombre_precio
    var select_precio = document.forms[0].id_tipo_precio;
    var index_precio = 0;
    for (i = 0;i < select_precio.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_precio );
        if (select_precio.options[i].innerText == nombre_precio) {
            index_precio = i;
            break;
        }
    }

    document.forms[0].id_tipo_placa.value           = id_tipo_placa;
    document.forms[0].id_maquina.selectedIndex      = index_maquina;
    document.forms[0].descripcion.value             = descripcion;
    document.forms[0].precio.value                  = precio;
    document.forms[0].id_tipo_precio.selectedIndex  = index_precio;
}

function crear() {
    if (document.forms[0].descripcion.value == "" || document.forms[0].precio.value == "")
        alert("Los campos descripcion y precio son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].descripcion.value == "" || document.forms[0].precio.value == "")
        alert("Los campos descripcion y precio son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlModifica;
        document.forms[0].submit();
    }
}

function elimina() {
    if (confirm(String.fromCharCode(191) + "Realmente desea eliminar este registro?")) {
        document.forms[0].action = urlElimina;
        document.forms[0].submit();
    }
}

function limpia() {
    document.forms[0].id_tipo_placa.value           = "";
    document.forms[0].id_maquina.selectedIndex      = 0;
    document.forms[0].descripcion.value             = "";
    document.forms[0].precio.value                  = "";
    document.forms[0].id_tipo_precio.selectedIndex  = 0;
}