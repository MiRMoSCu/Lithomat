/**
 * 
 */

function cerrarVentana() {
	window.parent.Shadowbox.close();
}

function  limpiarFormulario() {
	document.condiciones_produccion.id_tipo_reporte.value 				= "";
	document.condiciones_produccion.id_tipo_formato_impresion.value 	= "";
	document.condiciones_produccion.select_tipo_reporte.selectedIndex 	= 0;
	document.condiciones_produccion.condiciones_produccion.value 		= "";
	document.condiciones_produccion.select_tipo_formato_impresion.value = "";
}

function enviarFormulario() {
	// copia de valoes
	document.condiciones_produccion.id_tipo_reporte.value 			= $("[name=select_tipo_reporte]").val();
	document.condiciones_produccion.id_tipo_formato_impresion.value	= $("[name=select_tipo_formato_impresion]").val();
	document.condiciones_produccion.action 							= urlSeleccionReporte;
	document.condiciones_produccion.submit();
}
