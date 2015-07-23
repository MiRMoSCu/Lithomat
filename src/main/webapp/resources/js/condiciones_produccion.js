/**
 * 
 */

function cierraVentanaModal() {
	window.parent.Shadowbox.close();
}

function limpiaVentana() {
	document.condiciones_produccion.condiciones_produccion.value = "";
}

function exportaReporte(tipo_formato) {
	document.condiciones_produccion.nut.value 			= window.parent.document.orden_produccion.nut.value;
	document.condiciones_produccion.tipo_formato.value 	= tipo_formato;
	document.condiciones_produccion.action 				= urlExportaReporte;
	document.condiciones_produccion.submit();
}

