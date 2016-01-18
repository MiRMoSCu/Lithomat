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

function validaForm() {
	var correcto = true;
	if ( document.forms[0].nombre.value == "" 
	     || document.forms[0].tamanio_fraccion.value == ""
	     || document.forms[0].numero_paginas.value == ""
	     || document.forms[0].numero_decimal.value == ""
	     || document.forms[0].numero_doblez.value == "" ) {
		correcto = false;
		alert("Todos los campos son obligatorios, favor de informarlos.");
	}
	if ( isNaN(document.forms[0].numero_paginas.value
			|| isNaN(document.forms[0].numero_decimal.value) 
			|| isNaN(document.forms[0].numero_doblez.value) ) ) {
		correcto = false;
		alert("Los campos numero de paginas, numero decimal y numero de doblez deben ser numeros validos, favor de informarlos.");
	}
	return correcto;
}

function crear() {
    if ( validaForm() ) {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if ( validaForm() ) {
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