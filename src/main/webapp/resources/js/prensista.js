/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_prensista, nombre, ap_paterno, ap_materno) {
    document.forms[0].id_prensista.value    = id_prensista;
    document.forms[0].nombre.value          = nombre;
    document.forms[0].ap_paterno.value      = ap_paterno;
    document.forms[0].ap_materno.value      = ap_materno;
}

function crear() {
    if (document.forms[0].nombre.value == "" || document.forms[0].ap_paterno.value == "")
        alert("Los campos nombre y apellido paterno son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].nombre.value == "" || document.forms[0].ap_paterno.value == "")
        alert("Los campos nombre y apellido paterno son obligatorios, favor de informarlos.");
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
    document.forms[0].id_prensista.value    = "";
    document.forms[0].nombre.value          = "";
    document.forms[0].ap_paterno.value      = "";
    document.forms[0].ap_materno.value      = "";
}