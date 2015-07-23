/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_proceso_externo, nombre_proveedor, nombre_proceso, observaciones, precio, nombre_precio) {
    
    //busqueda de nombre_tipo_precio
    var select_precio = document.forms[0].id_tipo_precio;
    var index_precio = 0;
    for (i = 0;i < select_precio.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select_precio.options[i].innerText == nombre_precio) {
            index_precio = i;
            break;
        }
    }
    
    //busqueda de nombre de proveedor
    var select_proveedor = document.forms[0].id_proveedor_externo;
    var index_proveedor = 0;
    for (i = 0;i < select_proveedor.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select_proveedor.options[i].innerText == nombre_proveedor) {
            index_proveedor = i;
            break;
        }
    }
    
    document.forms[0].id_proceso_externo.value              = id_proceso_externo;
    document.forms[0].id_proveedor_externo.selectedIndex    = index_proveedor;
    document.forms[0].nombre_proceso.value                  = nombre_proceso;
    document.forms[0].observaciones.value                   = observaciones;
    document.forms[0].precio.value                          = precio;
    document.forms[0].id_tipo_precio.selectedIndex          = index_precio;
}

function crear() {
    if (document.forms[0].nombre_proceso.value == "" || document.forms[0].precio.value == "")
        alert("Los campos nombre proceso y precio son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].nombre_proceso.value == "" || document.forms[0].precio.value == "")
        alert("Los campos nombre proceso y precio son obligatorios, favor de informarlos.");
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
    document.forms[0].id_proceso_externo.value              = "";
    document.forms[0].id_proveedor_externo.selectedIndex    = 0;
    document.forms[0].nombre_proceso.value                  = "";
    document.forms[0].observaciones.value                   = "";
    document.forms[0].precio.value                          = "";
    document.forms[0].id_tipo_precio.selectedIndex          = 0;
}