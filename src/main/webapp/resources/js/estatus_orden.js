/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_estatus_orden, nombre, descripcion) {
    document.forms[0].id_estatus_orden.value    = id_estatus_orden;
    document.forms[0].nombre.value              = nombre;
    document.forms[0].descripcion.value         = descripcion;
}

function limpia() {
    document.forms[0].id_estatus_orden.value    = "";
    document.forms[0].nombre.value              = "";
    document.forms[0].descripcion.value         = "";
}