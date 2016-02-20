/**
 * 
 */

Number.prototype.formatMoney = function(c, d, t) {
	var n = this, 
	    c = isNaN(c = Math.abs(c)) ? 2 : c, 
	    d = d == undefined ? "." : d, 
	    t = t == undefined ? "," : t, 
	    s = n < 0 ? "-" : "", 
	    i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", 
	    j = (j = i.length) > 3 ? j % 3 : 0;
	return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
};

function cerrarVentana() {
	window.parent.Shadowbox.close();
}

function limpiarFormulario() {
	//alert("limpia formulario");
	document.descuento.nut.value 										= "";
	document.descuento.nombre_moral.value 								= "";
	document.descuento.tipo_cliente.value 								= "";
	document.descuento.estatus.value 									= "";
	document.descuento.precio_bruto.value 								= "";
	document.descuento.precio_cliente.value 							= "";
	document.descuento.porcentaje_descuento.value 						= "";
	document.descuento.precio_cliente_con_descuento.value 				= "";
	document.descuento.tipo_comprobante.value 							= "";
	document.descuento.precio_neto.value 								= "";
	document.descuento.porcentaje_descuento_modificado_porcentaje.value = "";
	document.descuento.porcentaje_descuento_modificado_pesos.value 		= "";
	document.descuento.precio_cliente_con_descuento_modificado.value 	= "";
	document.descuento.precio_neto_modificado.value 					= "";
}

function calculaDescuento() {
	
	if ( document.descuento.porcentaje_descuento_modificado_porcentaje.value != "" ) {
		
		document.descuento.porcentaje_descuento_modificado_porcentaje.value = parseInt(document.descuento.porcentaje_descuento_modificado_porcentaje.value);
		
		var validaciones_correctas = true;
		
		if ( !parseInt(document.descuento.porcentaje_descuento_modificado_porcentaje.value) ) {
			if ( document.descuento.porcentaje_descuento_modificado_porcentaje.value == "0" )
				validaciones_correctas = true;
			else {
				validaciones_correctas = false;
				alert("Favor de informar una numero entero mayor a cero");
				document.descuento.porcentaje_descuento_modificado_porcentaje.value = "";
				document.descuento.porcentaje_descuento_modificado_porcentaje.focus();
			}
		}
		
		if ( validaciones_correctas
				&& parseInt(document.descuento.porcentaje_descuento_modificado_porcentaje.value) > 100 ) {
			validaciones_correctas = false;
			alert("No es posible asignar un descuento mayor al 100%");
			document.descuento.porcentaje_descuento_modificado_porcentaje.focus();
		}
		
		if ( validaciones_correctas ) {
			// realiza calculo de nuevas cantidades
			var descuento 						= parseInt(document.descuento.porcentaje_descuento_modificado_porcentaje.value);
			var precio_cliente_original 		= parseFloat(document.descuento.precio_cliente_original.value);
			var precio_cliente_final 			= (precio_cliente_original - (precio_cliente_original * (descuento / 100)).toFixed(2));
			var porcentaje_comprobante_fiscal 	= parseInt(document.descuento.precio_tipo_comprobante_fiscal.value);
			var precio_neto 					= (precio_cliente_final * (1 + (porcentaje_comprobante_fiscal / 100)));
			
			document.descuento.porcentaje_descuento_modificado_pesos.value		= ((precio_cliente_original * (descuento / 100))).formatMoney(2);
			document.descuento.precio_cliente_con_descuento_modificado.value 	= "$ " + (precio_cliente_final).formatMoney(2);
			document.descuento.precio_neto_modificado.value						= "$ " + (precio_neto).formatMoney(2);
			
			delete descuento;
			delete precio_cliente_original;
			delete precio_cliente_final;
			delete porcentaje_comprobante_fiscal;
			delete precio_neto;
		}
		delete validaciones_correctas;
	} 
}

function enviarFormulario() {
	
	// validaciones 
	var correcto = true;
	
	if ( correcto
			&& ( document.descuento.nut.value == ""
				|| isNaN(document.descuento.nut.value) ) ) {
		correcto = false;
		alert("Favor de informar el NUT");
		document.descuento.nut.focus();
	}
	
	if ( correcto
			&& document.descuento.porcentaje_descuento_modificado_porcentaje.value == "" ) {
		correcto = false;
		alert("Favor de informar el porcentaje de descuento");
		document.descuento.porcentaje_descuento_modificado_porcentaje.focus();
	} 
	
	// envia formulario
	if ( correcto ) {
		//alert( "envia: " + document.descuento.porcentaje_descuento_modificado_porcentaje.value );
		document.body.style.cursor = "wait";
		$.ajax({
			type:'POST',
			url:urlCreaDescuento,
			data:{nut:document.descuento.nut.value,porcentaje_descuento:document.descuento.porcentaje_descuento_modificado_porcentaje.value},
			success:function(response){
				document.body.style.cursor = "default";
				window.parent.Shadowbox.close();
			},
			error:function(e){
				document.body.style.cursor = "default";
				alert("Problemas de comunicacion con el servidor.");
			}
		});
	}
	delete correcto;
}

function buscarNut() {
	var correcto = true;
	if ( document.descuento.nut.value == "" ) {
		correcto = false;
		alert("Favor de informar el NUT");
		document.descuento.nut.focus();
	}
	if ( correcto ) {
		// verifica que nut exista
		document.body.style.cursor = "wait";
		$.ajax({
			type:'POST',
			url:urlExisteNut,
			data:{nut:document.descuento.nut.value},
			success:function(response) {
				//
				if ( response ) {
					// si existe el nut; realiza la busqueda de información
					$.ajax({
						type:'POST',
						url:urlBuscaPrecios,
						data:{nut:document.descuento.nut.value},
						success:function( response ) {
							var jsonResponse = JSON.parse(response);
							//console.log( jsonResponse );
							// campos ocultos
							document.descuento.precio_cliente_original.value		= jsonResponse.precio_cliente;
							document.descuento.precio_tipo_comprobante_fiscal.value	= jsonResponse.precio_tipo_comprobante_fiscal;
							// campos visibles
							document.descuento.nombre_moral.value 					= jsonResponse.nombre_moral;
							document.descuento.tipo_cliente.value 					= jsonResponse.tipo_cliente;
							document.descuento.estatus.value 						= jsonResponse.estatus;
							document.descuento.precio_bruto.value					= "$ " + (jsonResponse.precio_bruto).formatMoney(2);
							document.descuento.precio_cliente.value					= "$ " + (jsonResponse.precio_cliente).formatMoney(2);
							document.descuento.porcentaje_descuento.value			= jsonResponse.porcentaje_descuento;
							document.descuento.precio_cliente_con_descuento.value	= "$ " + (jsonResponse.precio_cliente_con_descuento).formatMoney(2);
							document.descuento.tipo_comprobante.value				= jsonResponse.tipo_comprobante;
							document.descuento.precio_neto.value					= "$ " + (jsonResponse.precio_neto).formatMoney(2);
							delete jsonResponse;
							// activa campos de lectura
							document.descuento.porcentaje_descuento_modificado_porcentaje.readOnly = false;
							document.descuento.porcentaje_descuento_modificado_porcentaje.focus();
							document.body.style.cursor = "default";
						},
						error:function( e ) {
							document.body.style.cursor = "default";
							alert("Problemas de comunicacion con el servidor.");
						}
					});
				} else {
					alert("NUT no encontrado; favor de verificarlo.");
					document.descuento.nut.focus();
				}
			},
			error:function(e) {
				document.body.style.cursor = "default";
				alert("Problemas de comunicacion con el servidor.");
			}
		});
	}
	delete correcto;
}
