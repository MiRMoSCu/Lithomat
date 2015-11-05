/**
 * 
 */

function cerrarVentana() {
	window.parent.Shadowbox.close();
}

function limpiarFormulario() {
	document.reporte_remision_factura.id_tipo_formato_impresion.value 				= "";
	document.reporte_remision_factura.nut.value										= "";
	document.reporte_remision_factura.select_tipo_formato_impresion.selectedIndex 	= 0;
}

function enviarFormulario() {
	// copia valores
	document.reporte_remision_factura.id_tipo_formato_impresion.value = $("[name=select_tipo_formato_impresion]").val();
	// validacion
	var correcto = true;
	if( document.reporte_remision_factura.nut.value == "" ) {
		correcto = false;
		alert("Favor de especificar el NUT");
		document.reporte_remision_factura.nut.focus();
	}
	if( correcto ){
		// verifica que el nut exista
		document.body.style.cursor = "wait";
		$.ajax({
			type:'POST',
			url:urlExisteNut,
			data:{nut:document.reporte_remision_factura.nut.value},
			success:function(response){
				console.log(response);
				document.body.style.cursor = "default";
				if( response ) {
					document.reporte_remision_factura.action = urlNotaRemisionFactura;
					document.reporte_remision_factura.submit();
				} else {
					alert("NUT no encontrado; favor de verificarlo.");
					document.reporte_remision_factura.nut.focus();
				}
			},
			error:function(e){
				document.body.style.cursor = "default";
				alert("Problemas de comunicacion con el servidor.");
			}
		});
	}
}

