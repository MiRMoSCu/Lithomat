/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_proceso_preprensa, nombre_proceso, descripcion, precio, nombre_tipo_precio) {
    
    // busqueda de nombre_tipo_precio
    var select = document.forms[0].id_tipo_precio;
    var index_precio = 0;
    for (i = 0;i < select.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select.options[i].text == nombre_tipo_precio) {
            index_precio = i;
            break;
        }
    }
    
    document.forms[0].id_proceso_preprensa.value    = id_proceso_preprensa;
    document.forms[0].nombre_proceso.value          = nombre_proceso;
    document.forms[0].descripcion.value             = descripcion;
    document.forms[0].precio.value                  = precio;
    document.forms[0].id_tipo_precio.selectedIndex  = index_precio;
}

function validaForm() {
	var correcto = true;
	if ( document.forms[0].nombre_proceso.value == "" 
			|| document.forms[0].precio.value == "" ) {
		correcto = false;
		alert("Los campos nombre proceso y precio son obligatorios, favor de informarlos.");
	}
	if ( isNaN(document.forms[0].precio.value) ) {
		correcto = false;
		alert("El campo precio debe ser un numero valido, favor de informarlo.");
	}
	return correcto;
}

function crear() {
    if ( validaForm() )  {
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
    document.forms[0].id_proceso_preprensa.value    = "";
    document.forms[0].nombre_proceso.value          = "";
    document.forms[0].descripcion.value             = "";
    document.forms[0].precio.value                  = "";
    document.forms[0].id_tipo_precio.selectedIndex  = 0;
}