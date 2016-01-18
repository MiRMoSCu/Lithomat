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

function validaForm() {
	var correcto = true;
	if ( document.forms[0].nombre.value == "" 
			|| document.forms[0].factor_divisor.value == "" ){
		correcto = false;
		alert("Los campos nombre y factor divisor son obligatorios, favor de informarlos.");
	}
	if ( isNaN(document.forms[0].factor_divisor.value) ) {
		correcto = false;
		alert("El campo factor divisor debe ser un numero valido, favor de informarlos.");
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
    document.forms[0].id_tipo_precio.value  = "";
    document.forms[0].nombre.value          = "";
    document.forms[0].descripcion.value     = "";
    document.forms[0].factor_divisor.value  = "";
}