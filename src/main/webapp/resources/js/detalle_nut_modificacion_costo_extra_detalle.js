var modificaCostoExtraDetalle = false;

function activaBotonesModificarFormCostoExtraDetalle() {
	document.getElementById("imgBtnModificarCostoExtraDetalle").style.display 			= "none";
	document.getElementById("imgBtnCancelaModificarCostoExtraDetalle").style.display 	= "inline";
	document.getElementById("imgBtnAceptaEliminarCostoExtraDetalle").style.display 		= "inline";
	document.getElementById("imgBtnAceptaModificarCostoExtraDetalle").style.display 	= "inline";
}

function desactivaBotonesModificarFormCostoExtraDetalle() {
	document.getElementById("imgBtnModificarCostoExtraDetalle").style.display 			= "inline";
	document.getElementById("imgBtnCancelaModificarCostoExtraDetalle").style.display 	= "none";
	document.getElementById("imgBtnAceptaEliminarCostoExtraDetalle").style.display 		= "none";
	document.getElementById("imgBtnAceptaModificarCostoExtraDetalle").style.display 	= "none";
}



function setCamposCostoExtraDetalle( id_costo_extra_detalle, id_responsable_insumo, id_costo_extra, nombre_costo_extra, nombre_responsable, cantidad, especificacion, unidad_medida ) {
	if( modificaCostoExtraDetalle ) {
		document.costo_extra_detalle.id_costo_extra_detalle.value 			= id_costo_extra_detalle;
		document.costo_extra_detalle.id_responsable_insumo.value 			= id_responsable_insumo;
		document.costo_extra_detalle.id_costo_extra.value 					= id_costo_extra;
		document.costo_extra_detalle.costo_extra.value 						= nombre_costo_extra;
		document.costo_extra_detalle.responsable_insumo_costo_extra.value 	= nombre_responsable;
		document.costo_extra_detalle.cantidad.value 						= cantidad;
		document.costo_extra_detalle.especificacion.value 					= especificacion;
		document.costo_extra_detalle.nombre_unidad_medida.value 			= unidad_medida;
		// cambia el color
		document.costo_extra_detalle.cantidad.style.background 			= "#fff";
		document.costo_extra_detalle.especificacion.style.background 	= "#fff";
		//activa campos cantidad y especificacion
		document.costo_extra_detalle.cantidad.readOnly 			= false;
		document.costo_extra_detalle.especificacion.readOnly	= false;
	}
}

function modificaTablaCostoExtraDetalle() {
	// oculta botones de modificar en las demas areas
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_costo_extra_detalle").style.display = "inline";
	// activa badera
	modificaCostoExtraDetalle = true;
	// crea estilo y agrega a la pagina
	var css = "table#tabla_lista_costo_extra_tipo_trabajo tr:hover td {cursor:pointer; color:#000; background-color:#99CCFF;}";
	style = document.createElement("style");
	if( style.styleSheet )
		style.styleSheet.cssText = css;
	else
		style.appendChild(document.createTextNode(css));
	document.getElementsByTagName("head")[0].appendChild(style);
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesModificarFormCostoExtraDetalle();
}

function aceptaModificarCostoExtraDetalle() {
	// VALIDACIONES
	var correcto = true;
	
	if( document.costo_extra_detalle.cantidad.value == "" ) {
		correcto = false;
		alert("Favor de indicar la cantidad");
		document.costo_extra_detalle.cantidad.focus();
	}
	
	if( correcto ) {
		document.body.style.cursor = "wait";
		desactivaCamposFormCostoExtraDetalle();
		desactivaBotonesAgregarFormCostoExtraDetalle();
		
		$.ajax({
			type:"POST",
			url:urlActualizaCostoExtraDetalle,
			data:$("[name=costo_extra_detalle]").serialize(),
			success:function(response){
				switch( response.estatusOperacion ) {
					case 0: 	// error
						break;
					default: 	// exito
						// actualiza la tabla
						document.getElementById("div_tabla_costo_extra_tipo_trabajo").innerHTML = response.textoHTML;
						// actualiza el precio
						document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
						break
				}
				// cambia el color
				document.costo_extra_detalle.cantidad.style.background 			= "transparent";
				document.costo_extra_detalle.especificacion.style.background 	= "transparent";
				// limpia campos
				cancelaModificarCostoExtraDetalle();
				// cambia cursor
				document.body.style.cursor = "default";
			},
			error:function(e) {
				document.body.style.cursor = "default";
				cancelaAgregarCostoExtraDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
	}
}

function aceptaEliminarCostoExtraDetalle() {
	if( confirm("¿Esta seguro de querer eliminar este registro?") ) {
		$.ajax({
			type:"POST",
			url:urlEliminaCostoExtraDetalle,
			data:$("[name=costo_extra_detalle]").serialize(),
			success:function(response){
				switch( response.estatusOperacion ) {
					case 0: 	// error
						break;
					default: 	// exito
						// actualiza la tabla
						document.getElementById("div_tabla_costo_extra_tipo_trabajo").innerHTML = response.textoHTML;
						// actualiza el precio
						document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
						break
				}
				// cambia el color
				document.costo_extra_detalle.cantidad.style.background 			= "transparent";
				document.costo_extra_detalle.especificacion.style.background 	= "transparent";
				// limpia campos
				cancelaModificarCostoExtraDetalle();
				// cambia cursor
				document.body.style.cursor = "default";
			},
			error:function(e) {
				document.body.style.cursor = "default";
				cancelaAgregarCostoExtraDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
	}
}

function cancelaModificarCostoExtraDetalle() {
	// desactiva bandera
	modificaCostoExtraDetalle = false;
	// elimina estilos
	document.getElementsByTagName("style")[0].remove();
	// limpia campos
	limpiaCamposFormCostoExtraDetalle();
	// desactiva botones
	desactivaCamposFormCostoExtraDetalle();
	desactivaBotonesModificarFormCostoExtraDetalle();
	// muestra botones Modificar por seccion
	muestraBotonesModificarPorSeccion();
}