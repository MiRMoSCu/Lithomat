
var modificaPreprensaDetalle = false;

function activaBotonesModificarFormPreprensaDetalle() {
	document.getElementById("imgBtnModificarPreprensaDetalle").style.display 		= "none";
	document.getElementById("imgBtnAceptaEliminarPreprensaDetalle").style.display 	= "inline";
	document.getElementById("imgBtnAceptaModificarPreprensaDetalle").style.display 	= "inline";
	document.getElementById("imgBtnCancelaModificarPreprensaDetalle").style.display = "inline";
} // activaBotonesModificarFormPreprensaDetalle
	
function desactivaBotonesModificarFormPreprensaDetalle() {
	document.getElementById("imgBtnModificarPreprensaDetalle").style.display 		= "inline";
	document.getElementById("imgBtnAceptaEliminarPreprensaDetalle").style.display 	= "none";
	document.getElementById("imgBtnAceptaModificarPreprensaDetalle").style.display 	= "none";
	document.getElementById("imgBtnCancelaModificarPreprensaDetalle").style.display = "none";
} // desactivaBotonesModificarFormPreprensaDetalle

function setCamposPreprensaDetalle( id_preprensa_detalle, nombre_proceso, cantidad, especificaciones, precio_total_pesos ) {
	if( modificaPreprensaDetalle ) {
		document.preprensa_detalle.id_preprensa_detalle.value	= id_preprensa_detalle;
		document.preprensa_detalle.detalle.value 				= nombre_proceso;
		document.preprensa_detalle.cantidad.value				= cantidad;
		document.preprensa_detalle.precio_total_pesos.value		= precio_total_pesos;
		document.preprensa_detalle.especificaciones.value		= especificaciones;
		activaCamposFormPreprensaDetalle();
	}
} // setCamposPreprensaDetalle

function modificaTablaPreprensaDetalle() {
	// oculta botones de modificar en las demas areas
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_preprensa_detalle").style.display = "inline";
	// activa bandera
	modificaPreprensaDetalle = true;
	// crea estilo
	var css = "table#tabla_lista_preprensa_detalle tr:hover td {cursor:pointer; color:#000; background-color:#99CCFF;}";
	style = document.createElement("style");
	if( style.styleSheet )
		style.styleSheet.cssText = css;
	else
		style.appendChild(document.createTextNode(css));
	document.getElementsByTagName("head")[0].appendChild(style);
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesModificarFormPreprensaDetalle();
} // modificaTablaPreprensaDetalle

function aceptaModificarPreprensaDetalle() {
	
	var correcto = true;
	
	if( document.preprensa_detalle.cantidad.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo Cantidad");
	}
	
	if( document.preprensa_detalle.precio_total_pesos.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo precio");
	}
	
	if( document.preprensa_detalle.especificaciones.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo especificaciones");
	}
	
	if( correcto ) {
		document.body.style.cursor = "wait";
		desactivaCamposFormPreprensaDetalle();
		desactivaBotonesModificarFormPreprensaDetalle();
		
		document.preprensa_detalle.id_preprensa.value = document.preprensa.id_preprensa.value;
		// como aquí ya esta desactivado los botones, el textarea ya no funciona
		var data = $("[name=preprensa_detalle]").serialize() + "&especificaciones=" + document.preprensa_detalle.especificaciones.value;
		$.ajax({
			type:"POST",
			url:urlActualizaPreprensaDetalle,
			data:data,
			success:function(response) {
				document.body.style.cursor = "default";
				// actualiza la tabla
				document.getElementById("div_tabla_lista_preprensa_detalle").innerHTML = response.textoHTML;
				// actualiza precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				// desactiva todo
				cancelaModificarPreprensaDetalle();
				muestraBotonesModificarPorSeccion();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaModificarPreprensaDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
				muestraBotonesModificarPorSeccion();
			}
		});
		delete data;
	}
} // aceptaModificarPreprensaDetalle

function aceptaEliminarPreprensaDetalle() {
	if( confirm("¿Esta seguro de querer eliminar este registro?") ) {
		document.preprensa_detalle.id_preprensa.value = document.preprensa.id_preprensa.value;
		$.ajax({
			type:"POST",
			url:urlEliminaPreprensaDetalle,
			data:$("[name=preprensa_detalle]").serialize(),
			success:function(response){
				// actualiza la tabla
				document.getElementById("div_tabla_lista_preprensa_detalle").innerHTML = response.textoHTML;
				// actualiza precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				// desactiva todo
				cancelaModificarPreprensaDetalle();
			},
			error:function(e){
				cancelaModificarPreprensaDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
	}
} // aceptaEliminarPreprensaDetalle

function cancelaModificarPreprensaDetalle() {
	// desactiva bandera
	modificaPreprensaDetalle = false;
	// elimina estilos
	document.getElementsByTagName("style")[0].remove();
	//limpia campos
	limpiaCamposFormPreprensaDetalle();
	// desactiva botones
	desactivaCamposFormPreprensaDetalle();
	desactivaBotonesModificarFormPreprensaDetalle();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
} // cancelaModificarPreprensaDetalle