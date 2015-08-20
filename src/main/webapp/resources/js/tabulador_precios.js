/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_tabulador_precios, nombre_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, precio_complejidad_sencilla, precio_complejidad_regular, precio_complejidad_dificil, nombre_precio) {
    
    // busqueda de nombre_tipo_precio
    var select_precio = document.forms[0].id_tipo_precio;
    var index_precio = 0;
    for (i = 0;i < select_precio.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select_precio.options[i].innerText == nombre_precio) {
            index_precio = i;
            break;
        }
    }

    // busqueda de nombre_maquina
    var select_maquina = document.forms[0].id_maquina;
    var index_maquina = 0;
    for (i = 0;i < select_maquina.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select_maquina.options[i].innerText == nombre_maquina) {
            index_maquina = i;
            break;
        }
    }    
    
    document.forms[0].id_tabulador_precios.value    	= id_tabulador_precios;
    document.forms[0].id_maquina.selectedIndex      	= index_maquina;
    document.forms[0].nombre_insumo.value           	= nombre_insumo;
    document.forms[0].descripcion.value             	= descripcion;
    document.forms[0].inicio_tabulador.value        	= inicio_tabulador;
    document.forms[0].fin_tabulador.value           	= fin_tabulador;
    document.forms[0].precio_complejidad_sencilla.value	= precio_complejidad_sencilla;    
    document.forms[0].precio_complejidad_regular.value	= precio_complejidad_regular;
    document.forms[0].precio_complejidad_dificil.value	= precio_complejidad_dificil;
    document.forms[0].id_tipo_precio.selectedIndex  	= index_precio;
}

function crear() {
    if (document.forms[0].nombre_insumo.value == "" 
     || document.forms[0].inicio_tabulador.value == "" 
     || document.forms[0].fin_tabulador.value == "" 
     || document.forms[0].precio_complejidad_sencilla.value == ""
     || document.forms[0].precio_complejidad_regular.value == ""
     || document.forms[0].precio_complejidad_dificil.value == "" )
        alert("Los campos nombre, tabulador y precio son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].nombre_insumo.value == "" 
     || document.forms[0].inicio_tabulador.value == "" 
     || document.forms[0].fin_tabulador.value == "" 
	 || document.forms[0].precio_complejidad_sencilla.value == ""
     || document.forms[0].precio_complejidad_regular.value == ""
     || document.forms[0].precio_complejidad_dificil.value == "" )
        alert("Los campos nombre, tabulador y precio son obligatorios, favor de informarlos.");
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
    document.forms[0].id_tabulador_precios.value    	= "";
    document.forms[0].id_maquina.selectedIndex      	= 0;
    document.forms[0].nombre_insumo.value           	= "";
    document.forms[0].descripcion.value             	= "";
    document.forms[0].inicio_tabulador.value        	= "";
    document.forms[0].fin_tabulador.value           	= "";
    document.forms[0].precio_complejidad_sencilla.value	= "";    
    document.forms[0].precio_complejidad_regular.value	= "";
    document.forms[0].precio_complejidad_dificil.value	= "";
    document.forms[0].id_tipo_precio.selectedIndex  	= 0;
}