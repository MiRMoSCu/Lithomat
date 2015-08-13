/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_perfil_x_usuario, usuario, perfil) {
	document.forms[0].id_perfil_x_usuario.value	= id_perfil_x_usuario;
    
    var select_usuario = document.forms[0].id_usuario;
    for ( var i = 0; i < select_usuario.length; i++ ) {
    	if (select_usuario.options[i].innerText == usuario) {
    		document.forms[0].id_usuario.selectedIndex = i;
		}
    }
    
    var select_perfil = document.forms[0].id_perfil;
    for (var i = 0; i < select_perfil.length; i++) {
		if (select_perfil.options[i].innerText == perfil) {
			document.forms[0].id_perfil.selectedIndex = i;
		}
	}
    
}

function crear() {
    document.forms[0].action = urlAlta;
    document.forms[0].submit();
}

function modifica() {
    document.forms[0].action = urlModifica;
    document.forms[0].submit();
}

function elimina() {
    if (confirm(String.fromCharCode(191) + "Realmente desea eliminar este registro?")) {
        document.forms[0].action = urlElimina;
        document.forms[0].submit();
    }
}

function limpia() {
    document.forms[0].id_perfil_x_usuario.value = "";
    document.forms[0].id_usuario.selectedIndex 	= 0;
    document.forms[0].id_perfil.selectedIndex		= 0;
}