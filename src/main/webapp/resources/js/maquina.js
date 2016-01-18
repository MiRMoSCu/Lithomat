/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_maquina, nombre, descripcion, num_colores, ancho_placa, alto_placa, ancho_max_papel, alto_max_papel, ancho_min_papel, alto_min_papel) {
    document.forms[0].id_maquina.value          = id_maquina;
    document.forms[0].nombre.value              = nombre;
    document.forms[0].descripcion.value         = descripcion;
    document.forms[0].num_colores.value         = num_colores;
    document.forms[0].ancho_placa.value         = ancho_placa;
    document.forms[0].alto_placa.value          = alto_placa;
    document.forms[0].ancho_max_papel.value     = ancho_max_papel;
    document.forms[0].alto_max_papel.value      = alto_max_papel;
    document.forms[0].ancho_min_papel.value     = ancho_min_papel;
    document.forms[0].alto_min_papel.value      = alto_min_papel;
}

function validaForm() {
	var correcto = true;
	if ( document.forms[0].nombre.value == "" 
			|| document.forms[0].num_colores.value == ""
			|| document.forms[0].alto_placa.value == ""
			|| document.forms[0].ancho_placa.value == "" 
			|| document.forms[0].alto_max_papel.value == "" 
			|| document.forms[0].ancho_max_papel.value == ""
			|| document.forms[0].alto_min_papel.value == "" 
			|| document.forms[0].ancho_min_papel.value == "" ) {
		correcto = false;
		alert("Todos los campos son obligatorios, favor de informarlos.");
	}
	if ( isNaN(document.forms[0].num_colores.value)
			|| isNaN(document.forms[0].alto_placa.value)
			|| isNaN(document.forms[0].ancho_placa.value)
			|| isNaN(document.forms[0].alto_max_papel.value)
			|| isNaN(document.forms[0].ancho_max_papel.value)
			|| isNaN(document.forms[0].alto_min_papel.value)
			|| isNaN(document.forms[0].ancho_min_papel.value) ) {
		correcto = false;
		alert("Los campos numero de colores, alto y ancho de placa, alto y ancho maximo y minimo de papel son obligatorios, favor de informarlos.");
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
    document.forms[0].id_maquina.value          = "";
    document.forms[0].nombre.value              = "";
    document.forms[0].descripcion.value         = "";
    document.forms[0].num_colores.value         = "";
    document.forms[0].ancho_placa.value         = "";
    document.forms[0].alto_placa.value          = "";
    document.forms[0].ancho_max_papel.value     = "";
    document.forms[0].alto_max_papel.value      = "";
    document.forms[0].ancho_min_papel.value     = "";
    document.forms[0].alto_min_papel.value      = "";
}