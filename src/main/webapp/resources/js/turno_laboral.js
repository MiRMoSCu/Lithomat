/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_turno_laboral, descripcion, texto_hora_inicio, texto_hora_fin) {
    document.forms[0].id_turno_laboral.value    = id_turno_laboral;
    document.forms[0].descripcion.value         = descripcion;
    document.forms[0].hora_inicio.value         = texto_hora_inicio;
    document.forms[0].hora_fin.value            = texto_hora_fin;
}

function crear() {
    if (document.forms[0].descripcion.value == "" 
     || document.forms[0].hora_inicio.value == ""
     || document.forms[0].hora_fin.value == "")
        alert("Todos los campos son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].descripcion.value == "" 
     || document.forms[0].hora_inicio.value == ""
     || document.forms[0].hora_fin.value == "")
        alert("Todos los campos son obligatorios, favor de informarlos.");
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
    document.forms[0].id_turno_laboral.value    = "";
    document.forms[0].descripcion.value         = "";
    document.forms[0].hora_inicio.value         = "";
    document.forms[0].hora_fin.value            = "";
}