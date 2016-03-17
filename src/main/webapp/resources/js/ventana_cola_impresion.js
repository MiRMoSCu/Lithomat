/**
 * 
 */

function cerrarVentana() {
	window.parent.Shadowbox.close();
}

function limpiarFormulario() {
	document.reporte_cola_impresion.id_estatus_orden.selectedIndex 	= 0;
	document.reporte_cola_impresion.id_maquina.selectedIndex 		= 0;
	$("[name=fecha_inicial]").datepicker("setDate",new Date());
	$("[name=fecha_final]").datepicker("setDate",new Date());
}

function enviarFormulario() {
	// validacion
	var correcto = true;
	if ( new Date(document.reporte_cola_impresion.fecha_inicial.value) > new Date(document.reporte_cola_impresion.fecha_final.value) ) {
		correcto = false;
		alert("Los campoa de b\u00fasqueda FECHA INICIAL deber ser menor a FECHA FINAL. Favor de reportarlos.");
		$("[name=fecha_inicial]").datepicker("setDate",new Date());
		$("[name=fecha_final]").datepicker("setDate",new Date());
	}
	if( correcto ) {
		document.reporte_cola_impresion.action = urlExportaReporteColaImpresion;
		document.reporte_cola_impresion.submit();
	}
}