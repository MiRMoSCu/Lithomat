
function ajaxUnidadCostoExtra() {
	//alert( $("[name=select_costo_extra]").val() );
	$.ajax({
		type:"POST",
		url:urlBuscaUnidadMedidaCostoExtra,
		data:{id_costo_extra:$("[name=select_costo_extra]").val()},
		success:function(response) {
			document.costo_extra_detalle.nombre_unidad_medida.value = response;
		},
		error:function(e) {
			console.log(e);
			document.costo_extra_detalle.nombre_unidad_medida.value = "-";
		}
	});
}

function limpiaCamposFormCostoExtraDetalle() {
	// campos ocultos
	document.costo_extra_detalle.id_costo_extra_detalle.value 	= "";
	document.costo_extra_detalle.id_costo_extra.value 			= "";
	document.costo_extra_detalle.id_responsable_insumo.value 	= "";
	// campos visibles
		// select
	$("[name='select_costo_extra']").empty();
		// campos restantes
	document.costo_extra_detalle.costo_extra.value 						= "";
	document.costo_extra_detalle.responsable_insumo_costo_extra.value 	= "";
	document.costo_extra_detalle.cantidad.value 						= "";
	document.costo_extra_detalle.nombre_unidad_medida.value 			= "";
	document.costo_extra_detalle.especificacion.value 					= "";
}

function activaCamposFormCostoExtraDetalle() {
	// activa select
	document.costo_extra_detalle.select_costo_extra.disabled 		= false;
	document.costo_extra_detalle.select_responsable_insumo.disabled	= false;
	// oculta campos readonly
	document.costo_extra_detalle.costo_extra.style.display 						= "none";
	document.costo_extra_detalle.responsable_insumo_costo_extra.style.display 	= "none";
	// muestra select
	document.costo_extra_detalle.select_costo_extra.style.display			= "inline";
	document.costo_extra_detalle.select_responsable_insumo.style.display 	= "inline";
	// desactiva propiedad readonly
	document.costo_extra_detalle.cantidad.readOnly 			= false;
	document.costo_extra_detalle.especificacion.readOnly	= false;
	// cambia el color de los readonly
	document.costo_extra_detalle.cantidad.style.background 			= "#fff";
	document.costo_extra_detalle.especificacion.style.background	= "#fff";
	// actualiza campo medido en
	ajaxUnidadCostoExtra();
}

function desactivaCamposFormCostoExtraDetalle() {
	// desactiva select
	document.costo_extra_detalle.select_costo_extra.disabled 		= true;
	document.costo_extra_detalle.select_responsable_insumo.disabled	= true;
	// oculta los select
	document.costo_extra_detalle.select_costo_extra.style.display			= "none";
	document.costo_extra_detalle.select_responsable_insumo.style.display 	= "none";
	// muestra los botones readonly
	document.costo_extra_detalle.costo_extra.style.display 						= "inline";
	document.costo_extra_detalle.responsable_insumo_costo_extra.style.display 	= "inline";
	// activa propiedad readonly
	document.costo_extra_detalle.cantidad.readOnly 			= true;
	document.costo_extra_detalle.especificacion.readOnly	= true;
	// cambia el color de los readonly
	document.costo_extra_detalle.cantidad.style.background 			= "transparent";
	document.costo_extra_detalle.especificacion.style.background	= "transparent";
}

function activaBotonesAgregarFormCostoExtraDetalle() {
	document.getElementById("imgBtnAgregarCostoExtraDetalle").style.display 		= "none";
	document.getElementById("imgBtnCancelaAgregarCostoExtraDetalle").style.display 	= "inline";
	document.getElementById("imgBtnAceptaAgregarCostoExtraDetalle").style.display 	= "inline";
}

function desactivaBotonesAgregarFormCostoExtraDetalle() {
	document.getElementById("imgBtnAgregarCostoExtraDetalle").style.display 		= "inline";
	document.getElementById("imgBtnCancelaAgregarCostoExtraDetalle").style.display 	= "none";
	document.getElementById("imgBtnAceptaAgregarCostoExtraDetalle").style.display 	= "none";
}

function generaListaCostoExtra() {
	// genera el arreglo
	var arregloCostoExtra = [];
	// lee la tabla de costo extra
	var tabla = document.getElementById("tabla_lista_costo_extra_tipo_trabajo");
	for(var i=1; i<tabla.rows.length; i++) {
		arregloCostoExtra.push(tabla.rows[i].cells[1].innerHTML);
	}
	tabla = null;
	// limpia select
	$("[name='select_costo_extra']").empty();
	// parse del json
	var jsonObject = JSON.parse( strJsonListaCostoExtra );
	$.each( jsonObject, function(i, item){
		if( $.inArray( item.text, arregloCostoExtra ) < 0 ) {
			var option = document.createElement("option");
			option.value = item.value;
			option.text	 = item.text;
			document.getElementById("select_costo_extra").add(option);
			delete option;
		}
	});
	jsonObject = null;
} // generaListaCostoExtra

function agregaCostoExtraDetalle() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_agregar_costo_extra_detalle").style.display = "inline";
	// genera la lista de los costo extra sobrantes disponibles a agregar
	generaListaCostoExtra();
	// activa campos del form
	activaCamposFormCostoExtraDetalle();
	//muestra botones ACEPTAR y CANCELAR
	activaBotonesAgregarFormCostoExtraDetalle();
}

function aceptaAgregarCostoExtraDetalle() {
	document.costo_extra_detalle.id_costo_extra.value 			= $("[name=select_costo_extra]").val();
	document.costo_extra_detalle.id_responsable_insumo.value 	= $("[name=select_responsable_insumo]").val();
	
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
			url:urlAgregaCostoExtraDetalleOlvidado,
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
				// limpia campos
				cancelaAgregarCostoExtraDetalle();
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
	delete correcto;
}

function cancelaAgregarCostoExtraDetalle() {
	// limpia los campos del formulario
	limpiaCamposFormCostoExtraDetalle();
	// desactiva campos del form
	desactivaCamposFormCostoExtraDetalle();
	// desactiva botones ACEPTAR y CANCELAR
	desactivaBotonesAgregarFormCostoExtraDetalle();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
}