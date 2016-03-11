
function limpiaMuestraCamposFormTipoTrabajoDetalle() {
	// campos ocultos
	document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value = "";
	// chnk
	document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked 			= false;
	document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked 			= false;
	document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked 	= false;
	document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked 			= false;
	// muestra los checkbox
	document.tipo_trabajo_detalle.proporciona_papel.style.display 					= "none";
	document.tipo_trabajo_detalle.checkbox_proporciona_papel.style.display 			= "inline";
	document.tipo_trabajo_detalle.proporciona_placas.style.display 					= "none";
	document.tipo_trabajo_detalle.checkbox_proporciona_placas.style.display 		= "inline";
	document.tipo_trabajo_detalle.proporciona_tinta_especial.style.display 			= "none";
	document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.style.display = "inline";
	document.tipo_trabajo_detalle.proporciona_barniz.style.display 					= "none";
	document.tipo_trabajo_detalle.checkbox_proporciona_barniz.style.display 		= "inline";
	// muestra los select
	document.tipo_trabajo_detalle.tipo_papel.style.display 							= "none";
	document.tipo_trabajo_detalle.select_tipo_papel_extendido.style.display 		= "inline";
	document.tipo_trabajo_detalle.tamanio_pubicacion.style.display 					= "none";
	document.tipo_trabajo_detalle.select_tamanio_publicacion.style.display 			= "inline";
	document.tipo_trabajo_detalle.frente_combinacion_tintas.style.display 			= "none";
	document.tipo_trabajo_detalle.select_frente_combinacion_tintas.style.display 	= "inline";
	document.tipo_trabajo_detalle.frente_tipo_barniz.style.display 					= "none";
	document.tipo_trabajo_detalle.select_frente_tipo_barniz.style.display 			= "inline";
	document.tipo_trabajo_detalle.vuelta_combinacion_tintas.style.display 			= "none";
	document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.style.display 	= "inline";
	document.tipo_trabajo_detalle.vuelta_tipo_barniz.style.display 					= "none";
	document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.style.display 			= "inline";
	document.tipo_trabajo_detalle.maquina.style.display 							= "none";
	document.tipo_trabajo_detalle.select_maquina.style.display 						= "inline";
	document.tipo_trabajo_detalle.tipo_placa.style.display 							= "none";
	document.tipo_trabajo_detalle.select_tipo_placa.style.display 					= "inline";
	document.tipo_trabajo_detalle.tipo_complejidad.style.display 					= "none";
	document.tipo_trabajo_detalle.select_tipo_complejidad.style.display 			= "inline";
	// ajax para buscar tipo placa segun select tipo maquina
	buscaTipoPlaca( document.tipo_trabajo_detalle.select_maquina );
	// limpia campos visibles
	document.tipo_trabajo_detalle.descripcion_partida_detalle.value 		= "";
	document.tipo_trabajo_detalle.alto_final.value 							= "";
	document.tipo_trabajo_detalle.ancho_final.value 						= "";
	document.tipo_trabajo_detalle.alto_extendido.value 						= "";
	document.tipo_trabajo_detalle.ancho_extendido.value 					= "";
	document.tipo_trabajo_detalle.numero_paginas_publicacion.value 			= "";
	document.tipo_trabajo_detalle.alto_corte_inicial.value 					= "0";
	document.tipo_trabajo_detalle.ancho_corte_inicial.value 				= "0";
	document.tipo_trabajo_detalle.frente_num_tinta_especial.value 			= "0";
	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value 	= "";
	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value 			= "0";
	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value 	= "";
	// desactiva readOnly
	document.tipo_trabajo_detalle.descripcion_partida_detalle.readOnly 			= false;
	document.tipo_trabajo_detalle.alto_final.readOnly 							= false;
	document.tipo_trabajo_detalle.ancho_final.readOnly 							= false;
	document.tipo_trabajo_detalle.alto_extendido.readOnly 						= false;
	document.tipo_trabajo_detalle.ancho_extendido.readOnly 						= false;
	document.tipo_trabajo_detalle.repeticiones_x_pliego.readOnly 				= false;
	document.tipo_trabajo_detalle.numero_paginas_publicacion.readOnly 			= false;
	document.tipo_trabajo_detalle.alto_corte_inicial.readOnly					= false;
	document.tipo_trabajo_detalle.ancho_corte_inicial.readOnly					= false;
	document.tipo_trabajo_detalle.frente_num_tinta_especial.readOnly 			= false;
	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.readOnly 	= false;
	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.readOnly 			= false;
	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.readOnly 	= false;
}


function activaBotonesAgregarFormTTD() {
	document.getElementById("imgBtnAgregarTTD").style.display 			= "none";
	document.getElementById("imgBtnCancelaAgregarTTD").style.display 	= "inline";
	document.getElementById("imgBtnAceptaAgregarTTD").style.display 	= "inline";
}

function desactivaBotonesAgregarFormTTD() {
	document.getElementById("imgBtnAgregarTTD").style.display 			= "inline";
	document.getElementById("imgBtnCancelaAgregarTTD").style.display 	= "none";
	document.getElementById("imgBtnAceptaAgregarTTD").style.display 	= "none";
}


function agregaTTD() {
	// elimina permiso para seleccionar PARTIDA  Y TTD; variable declarada en detalle_nut.js
	puedeSeleccionarPartida				= false;
	puedeSeleccionarTipoTrabajoDetalle 	= false;
	// elimina estilo de tabla que permite seleccionar ttd
	var styleSheetList = document.styleSheets;
	styleSheetList[3].cssRules[19].style.cursor = "default";
	styleSheetList[3].cssRules[19].style.backgroundColor = "transparent";
	styleSheetList[3].cssRules[19].style.color = "#898987";
	//NO BORRAR: // console.log( styleSheetList );
	//NO BORRAR: // console.log( styleSheetList[3].cssRules[19].cssText );
	//NO BORRAR: // console.log( "cursor: " + styleSheetList[3].cssRules[19].style.cursor );
	//NO BORRAR: // console.log( "backgroundColor: " + styleSheetList[3].cssRules[19].style.backgroundColor );
	//NO BORRAR: // console.log( "color: " + styleSheetList[3].cssRules[19].style.color );
	delete styleSheetList;
	// oculta botones de modificacion
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_agregar_ttd_encabezado").style.display = "inline";
	// ocultar divs que estan abajo de la seccion tipo trabajo detalle
	document.getElementById("div_tipo_trabajo_detalle").style.display 				= "none";
	document.getElementById("div_visualizador_pliegos").style.display 				= "none";
	document.getElementById("div_visualizador_costo_extra_detalle").style.display	= "none";
    document.getElementById("div_costo_extra_detalle").style.display				= "none";
	document.getElementById("div_pestania").style.display 							= "none";
	document.getElementById("div_material_ayuda").style.display 					= "none";
	// limpia y activa campos del form
	limpiaMuestraCamposFormTipoTrabajoDetalle();
	// muestra el form TTD
	document.getElementById("div_tipo_trabajo_detalle").style.display = "block";
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesAgregarFormTTD()
}

function aceptaAgregarTTD() {
	//alert("listo para agregar informacion");
	
	
	// validacion
	var correcto = true;
	
	
	
	
	if ( correcto ) {
		// 1) realiza ajax ttd
		// 2) dentro de respuesta ajax realiza la apertura de la ventana modal de generacion de pliegos
		// 3) si acepta, todo correcto, muestra informacion completa de toda OT
		// 4) sino, activa campos ttd para nueva corrección
		alert("realiza ajax");
		alert("apertura ventana modal de pliegos");
		alert
	}
	
	
	
}

function cancelaAgregarTTD() {
	// limpia los campos del formulario ttd
	
	// desactiva campos del form
	
	// desactiva botones ACEPTAR y CANCELAR
	desactivaBotonesAgregarFormTTD();
	// muestra botones Modificar por seccion
	muestraBotonesModificarPorSeccion();
	// activa estilos para permitir seleccionar el registro
	var styleSheetList = document.styleSheets;
	styleSheetList[3].cssRules[19].style.cursor = "pointer";
	styleSheetList[3].cssRules[19].style.backgroundColor = "#99CCFF";
	styleSheetList[3].cssRules[19].style.color = "#000";
	delete styleSheetList;
	// activa permiso para seleccionar TTD; variable declarada en detalle_nut.js
	puedeSeleccionarPartida				= true;
	puedeSeleccionarTipoTrabajoDetalle 	= true;
	// ocultar divs que estan abajo de la seccion tipo trabajo detalle
	document.getElementById("div_tipo_trabajo_detalle").style.display 				= "none";
	document.getElementById("div_visualizador_pliegos").style.display 				= "none";
	document.getElementById("div_visualizador_costo_extra_detalle").style.display	= "none";
    document.getElementById("div_costo_extra_detalle").style.display				= "none";
	document.getElementById("div_pestania").style.display 							= "none";
	document.getElementById("div_material_ayuda").style.display 					= "none";
}
