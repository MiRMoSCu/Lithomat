/**
 * 
 */

function buscaCondicionesProduccion() {
	var correcto = true;
	if( correcto
			&& ( document.reporte_cotizacion.nut.value == ""
				|| isNaN( document.reporte_cotizacion.nut.value ) ) ) {
		correcto = false;
		alert("Favor de especificar el NUT");
		document.reporte_orden_produccion.nut.focus();
	}
	if( correcto ) {
		document.body.style.cursor = "wait";
		$.ajax({
			type:'POST',
			url:urlBuscaCondicionesProduccion,
			data:{nut:document.reporte_cotizacion.nut.value},
			success:function(response) {
				document.body.style.cursor = "default";
				//console.log(response);
				objJson = JSON.parse(response);
				//console.log(objJson);
				if( objJson.existeRegistro ) {
					if( objJson.condicionesProduccion != null || objJson.condicionesProduccion != "" || objJson.condicionesProduccion != "null" )
						document,reporte_cotizacion.condiciones_produccion.value = objJson.condicionesProduccion;
					else
						document,reporte_cotizacion.condiciones_produccion.value = "";
				} else {
					alert("NUT no encontrado; favor de verificarlo.");
				}
			},
			error:function(e) {
				document.body.style.cursor = "default";
				alert("Problemas de comunicacion con el servidor.");
			}
		});
	}
}

function cerrarVentana() {
	window.parent.Shadowbox.close();
}

function limpiarFormulario() {
	document.reporte_cotizacion.id_tipo_formato_impresion.value 			= "";
	document.reporte_cotizacion.nut.value 									= "";
	document.reporte_cotizacion.condiciones_produccion.value 				= "";
	document.reporte_cotizacion.select_tipo_formato_impresion.selectedIndex = 0;
}

function enviarFormulario() {
	// copia valores
	document.reporte_cotizacion.id_tipo_formato_impresion.value = $("[name=select_tipo_formato_impresion]").val();
	// validacion
	var correcto = true;
	if( correcto
			&& ( document.reporte_cotizacion.nut.value == "" 
				|| isNaN( document.reporte_cotizacion.nut.value ) ) ) {
		correcto = false;
		alert("Favor de especificar el NUT");
		document.reporte_cotizacion.nut.focus();
	}
	if( correcto ) {
		document.body.style.cursor = "wait";
		$.ajax({
			type:'POST',
			url:urlExisteNut,
			data:{nut:document.reporte_cotizacion.nut.value},
			success:function(response){
				document.body.style.cursor = "default";
				if(response){
					document.reporte_cotizacion.action = urlExportaReporteCotizacion;
					document.reporte_cotizacion.submit();
				} else {
					alert("NUT no encontrado; favor de verificarlo.");
					document.reporte_cotizacion.nut.focus();
				}
			},
			error:function(e){
				document.body.style.cursor = "default";
				alert("Problemas de comunicacion con el servidor.");
			}
		});
	}
}