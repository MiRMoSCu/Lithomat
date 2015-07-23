/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_proveedor_papel, razon_social, calle, num_exterior, num_interior, colonia, delegacion, estado, codigo_postal, telefono, observaciones) {
    document.forms[0].id_proveedor_papel.value  = id_proveedor_papel;
    document.forms[0].razon_social.value        = razon_social;
    document.forms[0].calle.value               = calle;
    document.forms[0].num_exterior.value        = num_exterior;
    document.forms[0].num_interior.value        = num_interior;
    document.forms[0].colonia.value             = colonia;
    document.forms[0].delegacion.value          = delegacion;
    document.forms[0].estado.value              = estado;
    document.forms[0].codigo_postal.value       = codigo_postal;
    document.forms[0].telefono.value            = telefono;
    document.forms[0].observaciones.value       = observaciones;
}

function crear() {
    if (document.forms[0].razon_social.value == "")
        alert("El campo raz&oacute;n social es obligatorio, favor de informarlo.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].razon_social.value == "")
        alert("El campo raz&oacute;n social es obligatorio, favor de informarlo.");
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
    document.forms[0].id_proveedor_papel.value  = "";
    document.forms[0].razon_social.value        = "";
    document.forms[0].calle.value               = "";
    document.forms[0].num_exterior.value        = "";
    document.forms[0].num_interior.value        = "";
    document.forms[0].colonia.value             = "";
    document.forms[0].delegacion.value          = "";
    document.forms[0].estado.value              = "";
    document.forms[0].codigo_postal.value       = "";
    document.forms[0].telefono.value            = "";
    document.forms[0].observaciones.value       = "";
}