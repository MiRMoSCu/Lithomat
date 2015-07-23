/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_tipo_vuelta, nombre, descripcion) {
    document.forms[0].id_tipo_vuelta.value  = id_tipo_vuelta;
    document.forms[0].nombre.value          = nombre;
    document.forms[0].descripcion.value     = descripcion;
}

function crear() {
    if (document.forms[0].nombre.value == "")
        alert("El campo nombre es obligatorio, favor de informarlos.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].nombre.value == "")
        alert("El campo nombre es obligatorio, favor de informarlos.");
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
    document.forms[0].id_tipo_vuelta.value  = "";
    document.forms[0].nombre.value          = "";
    document.forms[0].descripcion.value     = "";
}