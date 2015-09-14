/**
 * 
 */
var tipo_reporte = 0;

function cierraVentanaModal() {
	window.parent.Shadowbox.close();
}

function limpiaVentana() {
	document.condiciones_produccion.condiciones_produccion.value = "";
}

function revisaSelect() {
	
}

function exportaReporte(id_tipo_formato) {
	document.tipo_reporte.nut.value 			= window.parent.document.orden_produccion.nut.value;
	document.tipo_reporte.id_tipo_formato.value = id_tipo_formato;
	// genera action
	switch( parseInt(document.tipo_reporte.select_tipo_reporte.value) ) {
	case -1: // orden de trabajo
		document.tipo_reporte.condiciones_produccion.value = document.condiciones_produccion.condiciones_produccion.value;
		document.tipo_reporte.action = urlExportaReporteOrdenTrabajo;
		break;
	case 0: // cotizacion
		document.tipo_reporte.condiciones_produccion.value = document.condiciones_produccion.condiciones_produccion.value;
		document.tipo_reporte.action = urlExportaReporteCotizacion;
		break;
	case 1: // remision, viene desde base de datos.
		document.tipo_reporte.action = urlExportaReporteRemision;
		break;
	case 2: // factura; viene desde base de datos.
		document.tipo_reporte.action = urlExportaReporteFactura;
		break;
	default:
		document.tipo_reporte.action = urlExportaReporteRemision;
		break;
	}
	document.tipo_reporte.submit();
}

