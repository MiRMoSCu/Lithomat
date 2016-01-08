/**
 * 
 */

function cerrarVentana() {
	window.parent.Shadowbox.close();
}

function limpiarFormulario() {
	document.cambio_estatus.id_estatus_orden.value 							= "";
	document.cambio_estatus.nut.value										= "";
	document.cambio_estatus.select_estatus_orden_produccion.selectedIndex 	= 0;
	document.cambio_estatus.observaciones.value								= "";
}

function enviarFormulario() {
	// copia de valores
	document.cambio_estatus.id_estatus_orden.value = $("[name=select_estatus_orden_produccion]").val();
	// validacion
	var correcto = true;
	if ( correcto
			&& document.cambio_estatus.nut.value == "" ) {
		correcto = false;
		alert("Favor de especificar el NUT");
		document.cambio_estatus.nut.focus();
	}
	if ( correcto
			&& document.cambio_estatus.observaciones.value == "" ) {
		correcto = false;
		alert("Favor de especificar el porque del cambio de estatus");
		document.cambio_estatus.observaiones.focus();
	}
	
	if ( correcto ) {
		// verifica que nut exista
		document.body.style.cursor = "wait";
		$.ajax({
			type:'POST',
			url:urlExisteNut,
			data:{nut:document.cambio_estatus.nut.value},
			success:function(response){
				document.body.style.cursor = "default";
				if( response ) {
					// realiza cambio de estatus
					$.ajax({
						type:'POST',
						url:urlCambioEstatus,
						data:$("[name=cambio_estatus]").serialize(),
						success:function( response ) {
							console.log( response );
							var resultado = Boolean( response );
							if ( resultado )
								window.parent.Shadowbox.close();
							delete resultado;
						},
						error:function( e ) {
							alert("No fue posible cambiar el estatus a la orden de produccion");
						}
					});					
					
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