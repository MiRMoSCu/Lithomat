/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_usuario, nombre, ap_paterno, ap_materno, usuario, contrasenia) {
    document.forms[0].id_usuario.value 	= id_usuario;
    document.forms[0].nombre.value 		= nombre;
    document.forms[0].ap_paterno.value  = ap_paterno;
    document.forms[0].ap_materno.value  = ap_materno;
    document.forms[0].usuario.value     = usuario;
    document.forms[0].contrasenia.value = contrasenia;
}

function crear() {
    if (document.forms[0].nombre.value == ""
    	|| document.forms[0].ap_paterno.value == ""
    	|| document.forms[0].ap_materno.value == ""
    	|| document.forms[0].usuario.value == ""
    	|| document.forms[0].contrasenia.value == "" )
        alert("Todos los campos son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].nombre.value == ""
    	|| document.forms[0].ap_paterno.value == ""
    	|| document.forms[0].ap_materno.value == ""
    	|| document.forms[0].usuario.value == ""
    	|| document.forms[0].contrasenia.value == "")
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
    document.forms[0].id_usuario.value  = "";
    document.forms[0].nombre.value      = "";
    document.forms[0].ap_paterno.value 	= "";
    document.forms[0].ap_materno.value 	= "";
    document.forms[0].usuario.value 	= "";
    document.forms[0].contrasenia.value = "";
}