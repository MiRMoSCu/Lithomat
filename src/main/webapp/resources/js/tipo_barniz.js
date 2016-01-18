/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_tipo_barniz, descripcion, num_entradas_maquina, num_placas, precio, nombre_precio) {
    
    // busqueda de nombre_tipo_precio
    var select = document.forms[0].id_tipo_precio;
    var index_precio = 0;
    for (i = 0;i < select.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select.options[i].text == nombre_precio) {
            index_precio = i;
            break;
        }
    }

    document.forms[0].id_tipo_barniz.value          = id_tipo_barniz;
    document.forms[0].descripcion.value             = descripcion;
    document.forms[0].num_entradas_maquina.value    = num_entradas_maquina;
    document.forms[0].num_placas.value              = num_placas;
    document.forms[0].precio.value                  = precio;  
    document.forms[0].id_tipo_precio.selectedIndex  = index_precio;
}

function validaForm() {
	var correcto = true;
	if ( document.forms[0].descripcion.value == "" 
	     	|| document.forms[0].num_entradas_maquina.value == ""
	        || document.forms[0].num_placas.value == ""
	        || document.forms[0].precio.value == "" ) {
		correcto = false;
		alert("Todos los campos son obligatorios, favor de informarlos.");
	}
	if ( isNaN(document.forms[0].num_entradas_maquina.value)
			|| isNaN(document.forms[0].num_placas.value) 
			|| isNaN(document.forms[0].precio.value) ) {
		correcto = false;
		alert("Los campos Numero de entradas maquina, Numero de placas y Precio deben ser numeros validos, favor de informarlos.");
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
    document.forms[0].id_tipo_barniz.value          = "";
    document.forms[0].descripcion.value             = "";
    document.forms[0].num_entradas_maquina.value    = "";
    document.forms[0].num_placas.value              = "";
    document.forms[0].precio.value                  = "";  
    document.forms[0].id_tipo_precio.selectedIndex  = 0;
}