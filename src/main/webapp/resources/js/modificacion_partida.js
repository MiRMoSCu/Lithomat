
var obj_partida = {
	cantidad					: "",
	forma_trabajo 				: "",
	descripcion_partida 		: "",
	observaciones_generales 	: "",
	observaciones_aprobacion 	: "",
	
	setObjPartida : function() {
		this.cantidad 					= document.partida.cantidad.value;
		this.forma_trabajo 				= document.partida.forma_trabajo.value;
		this.descripcion_partida		= document.partida.descripcion_partida.value;
		this.observaciones_generales 	= document.partida.observaciones_generales.value;
		this.observaciones_aprobacion 	= document.partida.observaciones_aprobacion.value;
	}, // setObjPartida
	
	setFormPartida : function() {
		document.partida.cantidad.value 				= this.cantidad;
		document.partida.forma_trabajo.value  			= this.forma_trabajo;
		document.partida.descripcion_partida.value		= this.descripcion_partida;
		document.partida.observaciones_generales.value 	= this.observaciones_generales;
		document.partida.observaciones_aprobacion.value = this.observaciones_aprobacion;
	} // setFormPartida
} // obj_partida
	
function activaCamposFormPartida() {
	// coloca el select en la opcion correcta
	var index 	= 0;
	var clave 	= document.partida.forma_trabajo.value;
	var select 	= document.partida.select_forma_trabajo;
	for(var i=0; i < select.length; i++) {
		if( select.options[i].innerText == clave ) {
			index = i;
			break;
		}
	}
	
	document.partida.select_forma_trabajo.selectedIndex = index;
	//muestra select
	document.partida.forma_trabajo.style.display 		= "none";
	document.partida.select_forma_trabajo.style.display = "inline";
	delete index;
	delete clave;
	delete select;
	
	// quita opcion readonly
	document.partida.cantidad.readOnly 					= false;
	document.partida.descripcion_partida.readOnly 		= false;
	document.partida.observaciones_generales.readOnly 	= false;
	document.partida.observaciones_aprobacion.readOnly 	= false;
	document.partida.observaciones_generales.disabled 	= false;
	document.partida.observaciones_aprobacion.disabled 	= false;
	
	// cambia el color
	document.partida.cantidad.style.background 					= "#fff";
	document.partida.descripcion_partida.style.background 		= "#fff";
	document.partida.observaciones_generales.style.background 	= "#fff";
	document.partida.observaciones_aprobacion.style.background 	= "#fff";
	
} // activaCamposFormPartida

function desactivaCamposFormPartida() {
	
	document.partida.cantidad.readOnly 					= true;
	document.partida.descripcion_partida.readOnly 		= true;
	document.partida.observaciones_generales.readOnly 	= true;
	document.partida.observaciones_aprobacion.readOnly 	= true;
	document.partida.observaciones_generales.disabled 	= true;
	document.partida.observaciones_aprobacion.disabled 	= true;
	document.partida.select_forma_trabajo.style.display = "none";
	document.partida.forma_trabajo.style.display 		= "inline";
	
	document.partida.cantidad.style.background 					= "transparent";
	document.partida.descripcion_partida.style.background 		= "transparent";
	document.partida.observaciones_generales.style.background 	= "transparent";
	document.partida.observaciones_aprobacion.style.background 	= "transparent";
	
} // desactivaCamposFormPartida

function activaBotonesModificarFormPartida() {
	document.getElementById("imgBtnModificarPartida").style.display 		= "none";
	document.getElementById("imgBtnAceptaModificarPartida").style.display 	= "inline";
	document.getElementById("imgBtnCancelaModificarPartida").style.display 	= "inline";
} // activaBotonesModificaFormPartida

function desactivaBotonesModificarFormPartida() {
	document.getElementById("imgBtnModificarPartida").style.display 		= "inline";
	document.getElementById("imgBtnAceptaModificarPartida").style.display 	= "none";
	document.getElementById("imgBtnCancelaModificarPartida").style.display 	= "none";
} // desactivaBotonesMoidificaFormPartida

function modificaPartida() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_partida").style.display = "inline";
	
	obj_partida.setObjPartida();
	activaBotonesModificarFormPartida();
	activaCamposFormPartida();
} // modificaPartida

function aceptaModificarPartida() {
	
	document.partida.id_tipo_forma_trabajo.value 	= document.partida.select_forma_trabajo.value;
	document.partida.forma_trabajo.value 			= document.partida.select_forma_trabajo.options[document.partida.select_forma_trabajo.selectedIndex].text;
	
	var correcto = true;
	
	if( document.partida.cantidad.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo cantidad");
	}
	
	if( document.partida.descripcion_partida.value == "" ) {
		correcto = false;
		alert("Favor de informar el campo descripcion");
	}
	
	if( correcto ) {
		document.body.style.cursor = "wait";
		desactivaCamposFormPartida();
		desactivaBotonesModificarFormPartida();
		
		var data 	= $("[name=partida]").serialize() 
					+ "&observaciones_generales=" + document.partida.observaciones_generales.value
					+ "&observaciones_aprobacion=" + document.partida.observaciones_aprobacion.value;
		
		$.ajax({
			type:'POST',
			url:urlActualizaPartida,
			data:data,
			success:function(response) {
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						cancelaModificarPartida();
						alert("No fue posible actualizar la informacion.");
						break;
					default: // exito
						// actualiza cantidad y descripcion partida en la tabla resumen
						var id_cantidad				= "td_" + document.partida.id_partida.value + "_cantidad";
						var id_descripcion_partida	= "td_" + document.partida.id_partida.value + "_descripcion_partida";
						document.getElementById(id_cantidad).innerHTML 				= document.partida.cantidad.value;
						document.getElementById(id_descripcion_partida).innerHTML 	= document.partida.descripcion_partida.value;
						delete id_cantidad;
						delete id_descripcion_partida;
						// actualiza precio
						document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
						// oculta divs
						document.getElementById("div_tipo_trabajo_detalle").style.display = "none";
						document.getElementById("div_visualizador_pliegos").style.display = "none";
						document.getElementById("div_pestania").style.display = "none";
						document.getElementById("div_material_ayuda").style.display = "none";
						break;
				}
				// muestra botones de modificar
				muestraBotonesModificarPorSeccion();
			},
			error:function(e) {
				document.body.style.cursor = "default";
				cancelaModificarPartida()
				alert("No fue posible actualizar la informacion.");
				// muestra botones de modificar
				muestraBotonesModificarPorSeccion();
			}
		});
		delete data;
	}
	delete correcto;
} // aceptaModificarPartida

function cancelaModificarPartida() {
	obj_partida.setFormPartida();
	desactivaBotonesModificarFormPartida();
	desactivaCamposFormPartida();
	// activa botones de modificar en las areas restantes
	muestraBotonesModificarPorSeccion();
} // cancelaModificarPartida