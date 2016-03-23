
function cierraVentana() {
	window.parent.Shadowbox.close();
}

function limpiaForm() {
	// campos generacion
	document.cotizador_express.id_tipo_cliente.selectedIndex 				= 0;
	document.cotizador_express.cantidad.value 								= "";
	document.cotizador_express.numero_pliegos.value 						= "";
	document.cotizador_express.frente_id_combinacion_tintas.selectedIndex 	= 0;
	document.cotizador_express.vuelta_id_combinacion_tintas.selectedIndex 	= 0;
	document.cotizador_express.frente_numero_tinta_especial.value 			= "0";
	document.cotizador_express.vuelta_numero_tinta_especial.value 			= "0";
	document.cotizador_express.frente_id_tipo_barniz.selectedIndex 			= 0;
	document.cotizador_express.vuelta_id_tipo_barniz.selectedIndex 			= 0;
	document.cotizador_express.vuelta_mismas_placas.checked 				= false;
	// campos resultado
	document.cotizador_express.tinta_precio_unitario.value 			= "$ 0.00";
	document.cotizador_express.tinta_precio_total.value 			= "$ 0.00";
	document.cotizador_express.tinta_especial_precio_unitario.value = "$ 0.00";
	document.cotizador_express.tinta_especial_precio_total.value 	= "$ 0.00";
	document.cotizador_express.barniz_precio_unitario.value 		= "$ 0.00";
	document.cotizador_express.barniz_precio_total.value 			= "$ 0.00";
	document.cotizador_express.placas_precio_unitario.value 		= "$ 0.00";
	document.cotizador_express.placas_precio_total.value 			= "$ 0.00";
	document.cotizador_express.coste_total.value 					= "$ 0.00";
}

function buscaCotizacionExpress() {
	// validacion
	var correcto = true;
	
	if ( correcto
			&& (document.cotizador_express.cantidad.value == ""
				|| isNaN(document.cotizador_express.cantidad.value) 
				|| document.cotizador_express.cantidad.value <= 0) ) {
		correcto = false;
		alert("La cantidad debe ser un número entero mayor a cero");
		document.cotizador_express.cantidad.focus();
		document.cotizador_express.cantidad.selected();
	}
	
	if ( correcto
			&& (document.cotizador_express.numero_pliegos.value == ""
				|| isNaN(document.cotizador_express.numero_pliegos.value)
				|| document.cotizador_express.numero_pliegos.value <=0 ) ) {
		correcto = false;
		alert("El numero de pliegos debe ser un número mayor a cero");
		document.cotizador_express.numero_pliegos.focus();
		document.cotizador_express.numero_pliegos.selected();
	}
	
	if ( correcto ) {
		alert("realiza ajax");
	}
	
	delete correcto;
}