/**
 * 
 */

function cerrarVentana() {
	window.parent.Shadowbox.close();
}

function limpiarFormulario() {
	document.reporte_orden_produccion.id_tipo_formato_impresion.value 				= "";
	document.reporte_orden_produccion.nut.value										= "";
	document.reporte_orden_produccion.select_tipo_formato_impresion.selectedIndex 	= 0;
}

function enviarFormulario() {
	// copia de valores
	document.reporte_orden_produccion.id_tipo_formato_impresion.value = $("[name=select_tipo_formato_impresion]").val();
	// validacion
	var correcto = true;
	if( document.reporte_orden_produccion.nut.value == "" ) {
		correcto = false;
		alert("Favor de especificar el NUT");
		document.reporte_orden_produccion.nut.focus();
	}
	if( correcto ) {
		// verifica que nut exista
		document.body.style.cursor = "wait";
		$.ajax({
			type:'POST',
			url:urlExisteNut,
			data:{nut:document.reporte_orden_produccion.nut.value},
			success:function(response){
				document.body.style.cursor = "default";
				if( response ) {
					document.reporte_orden_produccion.action = urlExportaReporteOrdenProduccion;
					document.reporte_orden_produccion.submit();
				} else {
					alert("NUT no encontrado; favor de verificarlo.");
					document.reporte_orden_produccion.nut.focus();
				}
			},
			error:function(e){
				document.body.style.cursor = "default";
				alert("Problemas de comunicacion con el servidor.");
			}
		});
	}
	delete correcto;
}