
var modificaTransporteDetalle = false;

function activaBotonesModificarFormTransporteDetalle() {
	document.getElementById("imgBtnModificarTransporteDetalle").style.display 			= "none";
	document.getElementById("imgBtnAceptaEliminarTransporteDetalle").style.display 		= "inline";
	document.getElementById("imgBtnAceptaModificarTransporteDetalle").style.display 	= "inline";
	document.getElementById("imgBtnCancelaModificarTransporteDetalle").style.display 	= "inline";
} // activaBotonesModificarFormTransporteDetalle

function desactivaBotonesModificarFormTransporteDetalle() {
	document.getElementById("imgBtnModificarTransporteDetalle").style.display 			= "inline";
	document.getElementById("imgBtnAceptaEliminarTransporteDetalle").style.display 		= "none";
	document.getElementById("imgBtnAceptaModificarTransporteDetalle").style.display 	= "none";
	document.getElementById("imgBtnCancelaModificarTransporteDetalle").style.display 	= "none";
} // desactivaBotonesModificarFormTransporteDetalle

function setCamposTransporteDetalle( id_transporte_detalle, nombre_proceso, cantidad, especificaciones, precio_total_pesos ) {
	if( modificaTransporteDetalle ) {
		document.transporte_detalle.id_transporte_detalle.value	= id_transporte_detalle;
		document.transporte_detalle.detalle.value 				= nombre_proceso;
		document.transporte_detalle.cantidad.value				= cantidad;
		document.transporte_detalle.precio_total_pesos.value	= precio_total_pesos;
		document.transporte_detalle.especificaciones.value		= especificaciones;
		activaCamposFormTransporteDetalle();
	}
} // setCamposTransporteDetalle

function modificaTablaTransporteDetalle() {
	// oculta botones de modificar en las demas areas
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_transporte_detalle").style.display = "inline";
	// activa bandera
	modificaTransporteDetalle = true;
	// crea estilo
	var css = "table#tabla_lista_transporte_detalle tr:hover td {cursor:pointer; color:#000; background-color:#99CCFF;}";
	style = document.createElement("style");
	if( style.styleSheet )
		style.styleSheet.cssText = css;
	else
		style.appendChild(document.createTextNode(css));
	document.getElementsByTagName("head")[0].appendChild(style);
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesModificarFormTransporteDetalle();
} // modificaTablaTransporteDetalle

function aceptaModificarTransporteDetalle() {
	
	var correcto = true;
	
	if( document.transporte_detalle.cantidad.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo Cantidad");
	}
	
	if( document.transporte_detalle.precio_total_pesos.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo precio");
	}
	
	if( document.transporte_detalle.especificaciones.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo especificaciones");
	}
	
	if( correcto ) {
		document.body.style.cursor = "wait";
		desactivaCamposFormTransporteDetalle();
		desactivaBotonesModificarFormTransporteDetalle();
		
		document.transporte_detalle.id_transporte.value = document.transporte.id_transporte.value;
		// como aquí ya esta desactivado los botones, el textarea ya no funciona
		var data = $("[name=transporte_detalle]").serialize() + "&especificaciones=" + document.transporte_detalle.especificaciones.value;
		$.ajax({
			type:"POST",
			url:urlActualizaTransporteDetalle,
			data:data,
			success:function(response) {
				document.body.style.cursor = "default";
				// actualiza la tabla
				document.getElementById("div_tabla_lista_transporte_detalle").innerHTML = response.textoHTML;
				// actualiza precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				// desactiva todo
				cancelaModificarTransporteDetalle();
				muestraBotonesModificarPorSeccion();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaModificarTransporteDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
				muestraBotonesModificarPorSeccion();
			}
		});
		delete data;
	}
} // aceptaModificarTransporteDetalle

function aceptaEliminarTransporteDetalle() {
	if( confirm("¿Esta seguro de querer eliminar este registro?") ) {
		document.transporte_detalle.id_transporte.value = document.transporte.id_transporte.value;
		$.ajax({
			type:"POST",
			url:urlEliminaTransporteDetalle,
			data:$("[name=transporte_detalle]").serialize(),
			success:function(response){
				// actualiza la tabla
				document.getElementById("div_tabla_lista_transporte_detalle").innerHTML = response.textoHTML;
				// actualiza precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				// desactiva todo
				cancelaModificarTransporteDetalle();
			},
			error:function(e){
				cancelaModificarTransporteDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
	}
} // aceptaEliminarTransporteDetalle

function cancelaModificarTransporteDetalle() {
	// desactiva bandera
	modificaTransporteDetalle = false;
	// elimina estilos
	document.getElementsByTagName("style")[0].remove();
	//limpia campos
	limpiaCamposFormTransporteDetalle();
	// desactiva botones
	desactivaCamposFormTransporteDetalle();
	desactivaBotonesModificarFormTransporteDetalle();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
} // cancelaModificarTransporteDetalle