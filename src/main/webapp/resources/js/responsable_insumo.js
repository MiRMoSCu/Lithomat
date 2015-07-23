/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_responsable_insumo, nombre, descripcion) {
    document.forms[0].id_responsable_insumo.value   = id_responsable_insumo;
    document.forms[0].nombre.value                  = nombre;
    document.forms[0].descripcion.value             = descripcion;
}

function crear() {
    if (document.forms[0].nombre.value == "")
        alert("El campo nombre es obligatorio, favor de informarlo.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].nombre.value == "")
        alert("El campo nombre es obligatorio, favor de informarlo.");
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
    document.forms[0].id_responsable_insumo.value   = "";
    document.forms[0].nombre.value                  = "";
    document.forms[0].descripcion.value             = "";
}