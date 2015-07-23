/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */

//ATENCION: el factor de division no puede ser cero.
function setCampos(id_tipo_precio, nombre, descripcion, factor_divisor) {

    document.forms[0].id_tipo_precio.value  = id_tipo_precio;
    document.forms[0].nombre.value          = nombre;
    document.forms[0].descripcion.value     = descripcion;
    document.forms[0].factor_divisor.value  = factor_divisor;
    
}

function crear() {
    if (document.forms[0].nombre.value == "" || document.forms[0].factor_divisor.value == "")
        alert("Los campos nombre y factor_divisor son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].nombre.value == "" || document.forms[0].factor_divisor.value == "")
        alert("Los campos nombre y factor_divisor son obligatorios, favor de informarlos.");
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
    document.forms[0].id_tipo_precio.value  = "";
    document.forms[0].nombre.value          = "";
    document.forms[0].descripcion.value     = "";
    document.forms[0].factor_divisor.value  = "";
}