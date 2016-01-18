/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */


function setCampos( id_papel_sobrante, inicio_tabulador, fin_tabulador, num_tinta_frente, num_tinta_vuelta, tinta_especial, hojas_sobrante ) {
    document.forms[0].id_papel_sobrante.value   = id_papel_sobrante;
    document.forms[0].inicio_tabulador.value    = inicio_tabulador;
    document.forms[0].fin_tabulador.value       = fin_tabulador;
    document.forms[0].num_tinta_frente.value    = num_tinta_frente;
    document.forms[0].num_tinta_vuelta.value    = num_tinta_vuelta;
    document.forms[0].hojas_sobrante.value      = hojas_sobrante;
    if( tinta_especial == "true" )
        document.forms[0].tinta_especial[0].checked = true;
    else
        document.forms[0].tinta_especial[1].checked = true;
}

function validaForm() {
	var correcto = true;
	if ( document.forms[0].inicio_tabulador.value == "" 
			|| document.forms[0].fin_tabulador.value == "" 
			|| document.forms[0].num_tinta_frente.value == "" 
			|| document.forms[0].num_tinta_vuelta.value == "" 
			|| document.forms[0].hojas_sobrante.value == "" ) {
		correcto = false;
		alert("Los campos Tabulador inicio, Tabulador fin, No. tinta frente, No. tinta vuelta, Hojas sobrante son obligatorios, favor de informarlos");
	}
	if ( isNaN(document.forms[0].inicio_tabulador.value)
			|| isNaN(document.forms[0].fin_tabulador.value)
			|| isNaN(document.forms[0].num_tinta_frente.value)
			|| isNaN(document.forms[0].num_tinta_vuelta.value)
			|| isNaN(document.forms[0].hojas_sobrante.value) ) {
		correcto = false;
		alert("Los campos Tabulador inicio, Tabulador fin, No. tinta frente, No. tinta vuelta y Hojas sobrante deben ser numeros validos.");
	}
	return correcto;
}

function crear() {
    if( validaForm() ) {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if( validaForm() ) {
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
    document.forms[0].id_papel_sobrante.value   = "";
    document.forms[0].inicio_tabulador.value    = "";
    document.forms[0].fin_tabulador.value       = "";
    document.forms[0].num_tinta_frente.value    = "";
    document.forms[0].num_tinta_vuelta.value    = "";
    document.forms[0].hojas_sobrante.value      = "";
    document.forms[0].tinta_especial[1].checked = true;
}