/**
 * 
 */

function cerrarVentana() {
	window.parent.Shadowbox.close();
}

function limpiarFormulario() {
	// campos ocultos
	document.reporte_cola_impresion.id_maquina.value 					= "";
	document.reporte_cola_impresion.id_estatus_orden.value 				= "";
	// campos visibles
	document.reporte_cola_impresion.fecha_impresion.value				= "";
	document.reporte_cola_impresion.select_maquina.selectedIndex 		= 0;
	document.reporte_cola_impresion.select_estatus_orden.selectedIndex 	= 0;
}

function enviarFormulario() {
	// copia informacion
	document.reporte_cola_impresion.id_maquina.value = $("[name=select_maquina]").val();
	document.reporte_cola_impresion.id_estatus_orden.value = $("[name=select_estatus_orden]").val();
	// validacion
	var correcto = true;
	
	if( document.reporte_cola_impresion.fecha_impresion.value == "" ) {
		correcto = false;
		alert("Favor de especificar la fecha de impresion.");
		document.reporte_cola_impresion.fecha_impresion.focus();
	}
	
	var pattern = /^([0-3])([0-9])\/([0-1])([0-2])\/([0-9]{4})$/;
	if( correcto && !pattern.test(document.reporte_cola_impresion.fecha_impresion.value) ) {
		correcto = false;
		alert("Fecha invalida, favor de especificar una fecha correcta");
		document.reporte_cola_impresion.fecha_impresion.focus();
	}
	
	var arr = document.reporte_cola_impresion.fecha_impresion.value.split("/");
	console.log(arr);
	if( correcto &$ ( arr[0] == "00" || arr[1] == "00" || arr[2] == "0000"  )  ) {
		correcto = false;
		alert("Fecha invalida, favor de especificar una fecha correcta");
		document.reporte_cola_impresion.fecha_impresion.focus();
	}
	
	if( correcto ) {
		document.reporte_cola_impresion.action = urlExportaReporteColaImpresion;
		document.reporte_cola_impresion.submit();
	}
}