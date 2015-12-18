
var modificaAcabadoDetalle = false;

function activaBotonesModificarFormAcabadoDetalle() {
	document.getElementById("imgBtnModificarAcabadoDetalle").style.display 			= "none";
	document.getElementById("imgBtnAceptaEliminarAcabadoDetalle").style.display 	= "inline";
	document.getElementById("imgBtnAceptaModificarAcabadoDetalle").style.display 	= "inline";
	document.getElementById("imgBtnCancelaModificarAcabadoDetalle").style.display 	= "inline";
} // activaBotonesModificarFormAcabadoDetalle

function desactivaBotonesModificarFormAcabadoDetalle() {
	document.getElementById("imgBtnModificarAcabadoDetalle").style.display 			= "inline";
	document.getElementById("imgBtnAceptaEliminarAcabadoDetalle").style.display 	= "none";
	document.getElementById("imgBtnAceptaModificarAcabadoDetalle").style.display 	= "none";
	document.getElementById("imgBtnCancelaModificarAcabadoDetalle").style.display 	= "none";
} // desactivaBotonesModificarFormAcabadoDetalle

function setCamposAcabadoDetalle( id_acabado_detalle, nombre_proceso, ancho, alto, cantidad, especificaciones, precio_total_pesos ) {
	if( modificaAcabadoDetalle ) {
		document.acabado_detalle.id_acabado_detalle.value		= id_acabado_detalle;
		document.acabado_detalle.detalle.value 					= nombre_proceso;
		document.acabado_detalle.ancho.value 					= ancho;
		document.acabado_detalle.alto.value 					= alto;
		document.acabado_detalle.cantidad_proceso_externo.value	= cantidad;
		document.acabado_detalle.precio_total_pesos.value		= precio_total_pesos;
		document.acabado_detalle.especificaciones.value			= especificaciones;
		activaCamposFormAcabadoDetalle();
	}
} // setCamposAcabadoDetalle

function modificaTablaAcabadoDetalle() {
	// oculta botones de modificar en las demas areas
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_acabado_detalle").style.display = "inline";
	// activa bandera
	modificaAcabadoDetalle = true;
	// crea estilo
	var css = "table#tabla_lista_acabado_detalle tr:hover td {cursor:pointer; color:#000; background-color:#99CCFF;}";
	style = document.createElement("style");
	if( style.styleSheet )
		style.styleSheet.cssText = css;
	else
		style.appendChild(document.createTextNode(css));
	document.getElementsByTagName("head")[0].appendChild(style);
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesModificarFormAcabadoDetalle();
} // modificaTablaAcabadoDetalle

function aceptaModificarAcabadoDetalle() {
	
	var correcto = true;
	
	if( document.acabado_detalle.cantidad_proceso_externo.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo Cantidad");
	}
	
	if( document.acabado_detalle.precio_total_pesos.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo precio");
	}
	
	if( document.acabado_detalle.especificaciones.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo especificaciones");
	}
	
	if( correcto ) {
		document.body.style.cursor = "wait";
		desactivaCamposFormAcabadoDetalle();
		desactivaBotonesModificarFormAcabadoDetalle();
		
		document.acabado_detalle.id_acabado.value = document.acabado.id_acabado.value;
		// como aquí ya esta desactivado los botones, el textarea ya no funciona
		var data = $("[name=acabado_detalle]").serialize() + "&especificaciones=" + document.acabado_detalle.especificaciones.value;
		$.ajax({
			type:"POST",
			url:urlActualizaAcabadoDetalle,
			data:data,
			success:function(response) {
				document.body.style.cursor = "default";
				// actualiza la tabla
				document.getElementById("div_tabla_lista_acabado_detalle").innerHTML = response.textoHTML;
				// actualiza precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				// desactiva todo
				cancelaModificarAcabadoDetalle();
				muestraBotonesModificarPorSeccion();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaModificarAcabadoDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
				muestraBotonesModificarPorSeccion();
			}
		});
		delete data;
	}
} // aceptaModificarAcabadoDetalle

function aceptaEliminarAcabadoDetalle() {
	if( confirm("¿Esta seguro de querer eliminar este registro?") ) {
		document.acabado_detalle.id_acabado.value = document.acabado.id_acabado.value;
		$.ajax({
			type:"POST",
			url:urlEliminaAcabadoDetalle,
			data:$("[name=acabado_detalle]").serialize(),
			success:function(response){
				// actualiza la tabla
				document.getElementById("div_tabla_lista_acabado_detalle").innerHTML = response.textoHTML;
				// actualiza precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				// desactiva todo
				cancelaModificarAcabadoDetalle();
			},
			error:function(e){
				cancelaModificarAcabadoDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
	}
} // aceptaEliminarAcabadoDetalle

function cancelaModificarAcabadoDetalle() {
	// desactiva bandera
	modificaAcabadoDetalle = false;
	// elimina estilos
	document.getElementsByTagName("style")[0].remove();
	//limpia campos
	limpiaCamposFormAcabadoDetalle();
	// desactiva botones
	desactivaCamposFormAcabadoDetalle();
	desactivaBotonesModificarFormAcabadoDetalle();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
} // cancelaModificarAcabadoDetalle