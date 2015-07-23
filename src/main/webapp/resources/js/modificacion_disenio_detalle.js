
var modificaDisenioDetalle = false;

function activaBotonesModificarFormDisenioDetalle() {
	document.getElementById("imgBtnModificarDisenioDetalle").style.display 			= "none";
	document.getElementById("imgBtnAceptaEliminarDisenioDetalle").style.display 	= "inline";
	document.getElementById("imgBtnAceptaModificarDisenioDetalle").style.display 	= "inline";
	document.getElementById("imgBtnCancelaModificarDisenioDetalle").style.display 	= "inline";
} // activaBotonesModificarFormDisenioDetalle
	
function desactivaBotonesModificarFormDisenioDetalle() {
	document.getElementById("imgBtnModificarDisenioDetalle").style.display 			= "inline";
	document.getElementById("imgBtnAceptaEliminarDisenioDetalle").style.display 	= "none";
	document.getElementById("imgBtnAceptaModificarDisenioDetalle").style.display 	= "none";
	document.getElementById("imgBtnCancelaModificarDisenioDetalle").style.display 	= "none";
} // desactivaBotonesModificarFormDisenioDetalle


function setCamposDisenioDetalle( id_disenio_detalle, nombre_proceso, cantidad, especificaciones, precio_total_pesos ) {
	if( modificaDisenioDetalle ) {
		document.disenio_detalle.id_disenio_detalle.value	= id_disenio_detalle;
		document.disenio_detalle.detalle.value 				= nombre_proceso;
		document.disenio_detalle.cantidad.value				= cantidad;
		document.disenio_detalle.precio_total_pesos.value	= precio_total_pesos;
		document.disenio_detalle.especificaciones.value		= especificaciones;
		activaCamposFormDisenioDetalle();
	}
} // setCamposDisenioDetalle

function modificaTablaDisenioDetalle() {
	// texto a codigo html
	/*
	var divTable = document.getElementById("div_tabla_disenio_detalle");
	var range = document.createRange();
	var tabla = range.createContextualFragment(divTable.innerHTML);
	*/
	// oculta botones de modificar en las demas areas
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_disenio_detalle").style.display = "inline";
	// activa bandera
	modificaDisenioDetalle = true;
	// crea estilo
	var css = "table#tabla_lista_disenio_detalle tr:hover td {cursor:pointer; color:#000; background-color:#99CCFF;}";
	style = document.createElement("style");
	if( style.styleSheet )
		style.styleSheet.cssText = css;
	else
		style.appendChild(document.createTextNode(css));
	document.getElementsByTagName("head")[0].appendChild(style);
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesModificarFormDisenioDetalle();
} // modificaTablaDisenioDetalle

function aceptaModificarDisenioDetalle() {
	
	var correcto = true;
	
	if( document.disenio_detalle.cantidad.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo Cantidad");
	}
	
	if( document.disenio_detalle.precio_total_pesos.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo precio");
	}
	
	if( document.disenio_detalle.especificaciones.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo especificaciones");
	}
	
	if( correcto ) {
		document.body.style.cursor = "wait";
		desactivaCamposFormDisenioDetalle();
		desactivaBotonesModificarFormDisenioDetalle();
		
		document.disenio_detalle.id_disenio.value = document.disenio.id_disenio.value;
		// como aquí ya esta desactivado los botones, el textarea ya no funciona
		var data = $("[name=disenio_detalle]").serialize() + "&especificaciones=" + document.disenio_detalle.especificaciones.value;
		$.ajax({
			type:"POST",
			url:urlActualizaDisenioDetalle,
			data:data,
			success:function(response) {
				document.body.style.cursor = "default";
				// actualiza la tabla
				document.getElementById("div_tabla_lista_disenio_detalle").innerHTML = response.textoHTML;
				// actualiza precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				// desactiva todo
				cancelaModificarDisenioDetalle();
				muestraBotonesModificarPorSeccion();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaModificarDisenioDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
				muestraBotonesModificarPorSeccion();
			}
		});
		delete data;
	}
} // aceptaModificarDisenioDetalle

function aceptaEliminarDisenioDetalle() {
	if( confirm("¿Esta seguro de querer eliminar este registro?") ) {
		document.disenio_detalle.id_disenio.value = document.disenio.id_disenio.value;
		$.ajax({
			type:"POST",
			url:urlEliminaDisenioDetalle,
			data:$("[name=disenio_detalle]").serialize(),
			success:function(response){
				// actualiza la tabla
				document.getElementById("div_tabla_lista_disenio_detalle").innerHTML = response.textoHTML;
				// actualiza precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				// desactiva todo
				cancelaModificarDisenioDetalle();
			},
			error:function(e){
				cancelaModificarDisenioDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
	}
} // aceptaEliminarDisenioDetalle

function cancelaModificarDisenioDetalle() {
	// desactiva bandera
	modificaDisenioDetalle = false;
	// elimina estilos
	document.getElementsByTagName("style")[0].remove();
	//limpia campos
	limpiaCamposFormDisenioDetalle();
	// desactiva botones
	desactivaCamposFormDisenioDetalle();
	desactivaBotonesModificarFormDisenioDetalle();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
} // cancelaModificarDisenioDetalle