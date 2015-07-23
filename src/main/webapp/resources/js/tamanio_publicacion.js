/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_tamanio_publicacion, nombre, tamanio_fraccion, numero_paginas, numero_decimal, numero_doblez) {
    document.forms[0].id_tamanio_publicacion.value  = id_tamanio_publicacion;
    document.forms[0].nombre.value                  = nombre;
    document.forms[0].tamanio_fraccion.value        = tamanio_fraccion;
    document.forms[0].numero_paginas.value          = numero_paginas;
    document.forms[0].numero_decimal.value          = numero_decimal;
    document.forms[0].numero_doblez.value           = numero_doblez;
}

function crear() {
    if (document.forms[0].nombre.value == "" 
     || document.forms[0].tamanio_fraccion.value == ""
     || document.forms[0].numero_paginas.value == ""
     || document.forms[0].numero_decimal.value == ""
     || document.forms[0].numero_doblez.value == "" )
        alert("Todos los campos son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].nombre.value == "" 
     || document.forms[0].tamanio_fraccion.value == ""
     || document.forms[0].numero_paginas.value == ""
     || document.forms[0].numero_decimal.value == ""
     || document.forms[0].numero_doblez.value == "" )
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
    document.forms[0].id_tamanio_publicacion.value  = "";
    document.forms[0].nombre.value                  = "";
    document.forms[0].tamanio_fraccion.value        = "";
    document.forms[0].numero_paginas.value          = "";
    document.forms[0].numero_decimal.value          = "";
    document.forms[0].numero_doblez.value           = "";
}