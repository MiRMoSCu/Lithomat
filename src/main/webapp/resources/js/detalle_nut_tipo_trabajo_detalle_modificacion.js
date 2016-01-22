
var cerradoOKVentanaListaPliegos = false;

var obj_ttd = {
	
	descripcion							: "",
	alto_final 							: "",
	ancho_final 						: "",
	alto_extendido 						: "",
	ancho_extendido 					: "",
	proporciona_papel 					: "",
	proporciona_placas 					: "",
	proporciona_tinta_especial 			: "",
	proporciona_barniz 					: "",
	tipo_papel 							: "",
	repeticiones_x_pliego 				: "",
	numero_paginas_publicacion 			: "",
	tamanio_publicacion 				: "",
	alto_corte_inicial					: "",
	ancho_corte_inicial					: "",
	frente_combinacion_tintas 			: "",
	frente_num_tinta_especial 			: "",
	frente_descripcion_tinta_especial 	: "",
	frente_tipo_barniz 					: "",
	vuelta_combinacion_tintas 			: "",
	vuelta_num_tinta_especial 			: "",
	vuelta_descripcion_tinta_especial 	: "",
	vuelta_tipo_barniz 					: "",
	maquina 							: "",
	tipo_placa 							: "",
	tipo_complejidad					: "",
	listaIdPliegoEliminado				: "",
	htmlListaPliegos					: "",
		
	setObjTTD : function() {
		this.descripcion						= document.tipo_trabajo_detalle.descripcion_partida_detalle.value;
		this.alto_final 						= document.tipo_trabajo_detalle.alto_final.value;
		this.ancho_final 						= document.tipo_trabajo_detalle.ancho_final.value;
		this.alto_extendido 					= document.tipo_trabajo_detalle.alto_extendido.value;
		this.ancho_extendido 					= document.tipo_trabajo_detalle.ancho_extendido.value;
		this.proporciona_papel 					= document.tipo_trabajo_detalle.proporciona_papel.value;
		this.proporciona_placas 				= document.tipo_trabajo_detalle.proporciona_placas.value;
		this.proporciona_tinta_especial 		= document.tipo_trabajo_detalle.proporciona_tinta_especial.value;
		this.proporciona_barniz 				= document.tipo_trabajo_detalle.proporciona_barniz.value;
		this.tipo_papel 						= document.tipo_trabajo_detalle.tipo_papel.value;
		this.repeticiones_x_pliego 				= document.tipo_trabajo_detalle.repeticiones_x_pliego.value;
		this.numero_paginas_publicacion 		= document.tipo_trabajo_detalle.numero_paginas_publicacion.value;
		this.tamanio_publicacion 				= document.tipo_trabajo_detalle.tamanio_pubicacion.value;
		this.alto_corte_inicial					= document.tipo_trabajo_detalle.alto_corte_inicial.value;
		this.ancho_corte_inicial				= document.tipo_trabajo_detalle.ancho_corte_inicial.value;
		this.frente_combinacion_tintas 			= document.tipo_trabajo_detalle.frente_combinacion_tintas.value;
		this.frente_num_tinta_especial 			= document.tipo_trabajo_detalle.frente_num_tinta_especial.value;
		this.frente_descripcion_tinta_especial 	= document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value;
		this.frente_tipo_barniz 				= document.tipo_trabajo_detalle.frente_tipo_barniz.value;
		this.vuelta_combinacion_tintas 			= document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value;
		this.vuelta_num_tinta_especial 			= document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value;
		this.vuelta_descripcion_tinta_especial 	= document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value;
		this.vuelta_tipo_barniz 				= document.tipo_trabajo_detalle.vuelta_tipo_barniz.value;
		this.maquina 							= document.tipo_trabajo_detalle.maquina.value;
		this.tipo_placa 						= document.tipo_trabajo_detalle.tipo_placa.value;
		this.tipo_complejidad 					= document.tipo_trabajo_detalle.tipo_complejidad.value;
	}, // setObjTTD
	
	setFormTTD : function() {
		document.tipo_trabajo_detalle.descripcion_partida_detalle.value			= this.descripcion_partida_detalle;
		document.tipo_trabajo_detalle.alto_final.value							= this.alto_final;
		document.tipo_trabajo_detalle.ancho_final.value 						= this.ancho_final;
		document.tipo_trabajo_detalle.alto_extendido.value 						= this.alto_extendido;
		document.tipo_trabajo_detalle.ancho_extendido.value 					= this.ancho_extendido;
		document.tipo_trabajo_detalle.proporciona_papel.value 					= this.proporciona_papel;
		document.tipo_trabajo_detalle.proporciona_placas.value 					= this.proporciona_placas;
		document.tipo_trabajo_detalle.proporciona_tinta_especial.value 			= this.proporciona_tinta_especial;
		document.tipo_trabajo_detalle.proporciona_barniz.value 					= this.proporciona_barniz;
		document.tipo_trabajo_detalle.tipo_papel.value 							= this.tipo_papel;
		document.tipo_trabajo_detalle.repeticiones_x_pliego.value 				= this.repeticiones_x_pliego;
		document.tipo_trabajo_detalle.numero_paginas_publicacion.value 			= this.numero_paginas_publicacion;
		document.tipo_trabajo_detalle.tamanio_pubicacion.value 					= this.tamanio_publicacion;
		document.tipo_trabajo_detalle.alto_corte_inicial.value 					= this.alto_corte_inicial;
		document.tipo_trabajo_detalle.ancho_corte_inicial.value 				= this.ancho_corte_inicial;
		document.tipo_trabajo_detalle.frente_combinacion_tintas.value 			= this.frente_combinacion_tintas;
		document.tipo_trabajo_detalle.frente_num_tinta_especial.value 			= this.frente_num_tinta_especial;
		document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value 	= this.frente_descripcion_tinta_especial;
		document.tipo_trabajo_detalle.frente_tipo_barniz.value 					= this.frente_tipo_barniz;
		document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value 			= this.vuelta_combinacion_tintas;
		document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value 			= this.vuelta_num_tinta_especial;
		document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value 	= this.vuelta_descripcion_tinta_especial;
		document.tipo_trabajo_detalle.vuelta_tipo_barniz.value 					= this.vuelta_tipo_barniz;
		document.tipo_trabajo_detalle.maquina.value 							= this.maquina;
		document.tipo_trabajo_detalle.tipo_placa.value 							= this.tipo_placa;
		document.tipo_trabajo_detalle.tipo_complejidad.value 					= this.tipo_complejidad;
	} //setFormTTD
} // obj_ttd_encabezado
	
function activaBotonesModificarFormTipoTrabajoDetalle() {
	document.getElementById("imgBtnModificarTTD").style.display 		= "none";
	document.getElementById("imgBtnAceptaModificarTTD").style.display	= "inline";
	document.getElementById("imgBtnCancelaModificarTTD").style.display	= "inline";
} // activaBotonesModificarFormTipoTrabajoDetalle

function desactivaBotonesModificarFormTipoTrabajoDetalle() {
	document.getElementById("imgBtnAceptaModificarTTD").style.display	= "none";
	document.getElementById("imgBtnCancelaModificarTTD").style.display	= "none";
	document.getElementById("imgBtnModificarTTD").style.display 		= "inline";
} // desactivaBotonesModificarFormTipoTrabajoDetalle

function activaCamposFormTipoTrabajoDetalle() {
	// activa los checkbox segun resultado
	//alert( document.tipo_trabajo_detalle.proporciona_papel.value );
	if( document.tipo_trabajo_detalle.proporciona_papel.value == "Si" )
		document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked = true;
	else 
		document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked = false;
	
	if( document.tipo_trabajo_detalle.proporciona_placas.value == "Si" )
		document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked = true;
	else
		document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked = false;
	
	if( document.tipo_trabajo_detalle.proporciona_tinta_especial.value == "Si" )
		document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked = true;
	else
		document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked = false;
		
	if( document.tipo_trabajo_detalle.proporciona_barniz.value == "Si" )
		document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked = true;
	else
		document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked = false;
	
	
	// coloca los select en la opcion indicada.
	// select tipo_papel
	var clave	= document.tipo_trabajo_detalle.tipo_papel.value;
	var select 	= document.tipo_trabajo_detalle.select_tipo_papel_extendido;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// select tamanio_publicacion
	clave	= document.tipo_trabajo_detalle.tamanio_pubicacion.value;
	select 	= document.tipo_trabajo_detalle.select_tamanio_publicacion;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// select frente_combinacion_tintas
	clave	= document.tipo_trabajo_detalle.frente_combinacion_tintas.value;
	select 	= document.tipo_trabajo_detalle.select_frente_combinacion_tintas;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// select frente_tipo_barniz
	clave	= document.tipo_trabajo_detalle.frente_tipo_barniz.value;
	select 	= document.tipo_trabajo_detalle.select_frente_tipo_barniz;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// select vuelta_combinacion_tintas
	clave	= document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value;
	select 	= document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// select vuelta_tipo_barniz
	clave	= document.tipo_trabajo_detalle.vuelta_tipo_barniz.value;
	select 	= document.tipo_trabajo_detalle.select_vuelta_tipo_barniz;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	//  select maquina
	clave	= document.tipo_trabajo_detalle.maquina.value;
	select 	= document.tipo_trabajo_detalle.select_maquina;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// ajax para buscar tipo_placa	
	buscaTipoPlaca( document.tipo_trabajo_detalle.select_maquina );
	
	// select tipo_placa
	clave 	= document.tipo_trabajo_detalle.tipo_placa.value;
	select	= document.tipo_trabajo_detalle.select_tipo_placa;
	var encontroOpcion 	= false;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			encontroOpcion = true;
			break;
		}
	}
	if( !encontroOpcion ) {
		select.selectedIndex	= 0;
	}
	delete encontroOpcion;
	
	// select tipo_complejidad
	clave 	= document.tipo_trabajo_detalle.tipo_complejidad.value;
	select 	= document.tipo_trabajo_detalle.select_tipo_complejidad;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// -------
	delete clave;
	delete select;
	
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
	
	// cambia el color campos text
	document.tipo_trabajo_detalle.descripcion_partida_detalle.style.background 			= "#fff";
	document.tipo_trabajo_detalle.alto_final.style.background 							= "#fff";
	document.tipo_trabajo_detalle.ancho_final.style.background 							= "#fff";
	document.tipo_trabajo_detalle.alto_extendido.style.background 						= "#fff";
	document.tipo_trabajo_detalle.ancho_extendido.style.background 						= "#fff";
	document.tipo_trabajo_detalle.repeticiones_x_pliego.style.background 				= "#fff";
	document.tipo_trabajo_detalle.numero_paginas_publicacion.style.background 			= "#fff";
	document.tipo_trabajo_detalle.alto_corte_inicial.style.background					= "#fff";
	document.tipo_trabajo_detalle.ancho_corte_inicial.style.background					= "#fff";
	document.tipo_trabajo_detalle.frente_num_tinta_especial.style.background 			= "#fff";
	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.style.background 	= "#fff";
	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.style.background 			= "#fff";
	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.style.background 	= "#fff";
} // activaCamposFormTipoTrabajoDetalle

function desactivaCamposFormTipoTrabajoDetalle() {
	// oculta input checkbox
	document.tipo_trabajo_detalle.checkbox_proporciona_papel.style.display 			= "none";
	document.tipo_trabajo_detalle.proporciona_papel.style.display 					= "inline";
	document.tipo_trabajo_detalle.checkbox_proporciona_placas.style.display 		= "none";
	document.tipo_trabajo_detalle.proporciona_placas.style.display 					= "inline";
	document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.style.display = "none";
	document.tipo_trabajo_detalle.proporciona_tinta_especial.style.display 			= "inline";
	document.tipo_trabajo_detalle.checkbox_proporciona_barniz.style.display 		= "none";
	document.tipo_trabajo_detalle.proporciona_barniz.style.display 					= "inline";
	
	// oculta input select
	document.tipo_trabajo_detalle.select_tipo_papel_extendido.style.display 		= "none";
	document.tipo_trabajo_detalle.tipo_papel.style.display 							= "inline";
	document.tipo_trabajo_detalle.select_tamanio_publicacion.style.display 			= "none";
	document.tipo_trabajo_detalle.tamanio_pubicacion.style.display 					= "inline";
	document.tipo_trabajo_detalle.select_frente_combinacion_tintas.style.display 	= "none";
	document.tipo_trabajo_detalle.frente_combinacion_tintas.style.display 			= "inline";
	document.tipo_trabajo_detalle.select_frente_tipo_barniz.style.display 			= "none";
	document.tipo_trabajo_detalle.frente_tipo_barniz.style.display 					= "inline";
	document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.style.display 	= "none";
	document.tipo_trabajo_detalle.vuelta_combinacion_tintas.style.display 			= "inline";
	document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.style.display 			= "none";
	document.tipo_trabajo_detalle.vuelta_tipo_barniz.style.display 					= "inline";
	document.tipo_trabajo_detalle.select_maquina.style.display 						= "none";
	document.tipo_trabajo_detalle.maquina.style.display 							= "inline";
	document.tipo_trabajo_detalle.select_tipo_placa.style.display 					= "none";
	document.tipo_trabajo_detalle.tipo_placa.style.display 							= "inline";
	document.tipo_trabajo_detalle.select_tipo_complejidad.style.display 			= "none";
	document.tipo_trabajo_detalle.tipo_complejidad.style.display 					= "inline";
	
	// activa readOnly
	document.tipo_trabajo_detalle.descripcion_partida_detalle.readOnly 			= true;
	document.tipo_trabajo_detalle.alto_final.readOnly 							= true;
	document.tipo_trabajo_detalle.ancho_final.readOnly 							= true;
	document.tipo_trabajo_detalle.alto_extendido.readOnly 						= true;
	document.tipo_trabajo_detalle.ancho_extendido.readOnly 						= true;
	document.tipo_trabajo_detalle.repeticiones_x_pliego.readOnly 				= true;
	document.tipo_trabajo_detalle.numero_paginas_publicacion.readOnly 			= true;
	document.tipo_trabajo_detalle.alto_corte_inicial.readOnly					= true;
	document.tipo_trabajo_detalle.ancho_corte_inicial.readOnly					= true;
	document.tipo_trabajo_detalle.frente_num_tinta_especial.readOnly 			= true;
	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.readOnly 	= true;
	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.readOnly 			= true;
	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.readOnly 	= true;
	
	// cambio el color de campos text
	document.tipo_trabajo_detalle.descripcion_partida_detalle.style.background 			= "transparent";
	document.tipo_trabajo_detalle.alto_final.style.background 							= "transparent";
	document.tipo_trabajo_detalle.ancho_final.style.background 							= "transparent";
	document.tipo_trabajo_detalle.alto_extendido.style.background 						= "transparent";
	document.tipo_trabajo_detalle.ancho_extendido.style.background 						= "transparent";
	document.tipo_trabajo_detalle.repeticiones_x_pliego.style.background 				= "transparent";
	document.tipo_trabajo_detalle.numero_paginas_publicacion.style.background 			= "transparent";
	document.tipo_trabajo_detalle.alto_corte_inicial.style.background					= "transparent";
	document.tipo_trabajo_detalle.ancho_corte_inicial.style.background					= "transparent";
	document.tipo_trabajo_detalle.frente_num_tinta_especial.style.background 			= "transparent";
	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.style.background 	= "transparent";
	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.style.background 			= "transparent";
	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.style.background 	= "transparent";
} // desactivaCamposFormTipoTrabajoDetalle

function modificaTTD() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_ttd_encabezado").style.display = "inline";
	// activa botones ACEPTAR y CANCELAR
	obj_ttd.setObjTTD();
	activaCamposFormTipoTrabajoDetalle();
	activaBotonesModificarFormTipoTrabajoDetalle();
} // modificaTTDEncabezado

function aceptaModificarTTD() {
	// campos ocultos
	document.tipo_trabajo_detalle.cliente_proporciona_papel.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked;
	document.tipo_trabajo_detalle.cliente_proporciona_placas.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked;
	document.tipo_trabajo_detalle.cliente_proporciona_tinta_especial.value 	= document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked;
	document.tipo_trabajo_detalle.cliente_proporciona_barniz.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked;
	document.tipo_trabajo_detalle.id_tipo_papel_extendido.value				= document.tipo_trabajo_detalle.select_tipo_papel_extendido.value;
	document.tipo_trabajo_detalle.id_tamanio_publicacion.value				= document.tipo_trabajo_detalle.select_tamanio_publicacion.value;
	document.tipo_trabajo_detalle.frente_id_combinacion_tintas.value		= document.tipo_trabajo_detalle.select_frente_combinacion_tintas.value;
	document.tipo_trabajo_detalle.frente_id_tipo_barniz.value				= document.tipo_trabajo_detalle.select_frente_tipo_barniz.value;
	document.tipo_trabajo_detalle.vuelta_id_combinacion_tintas.value		= document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.value;
	document.tipo_trabajo_detalle.vuelta_id_tipo_barniz.value				= document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.value;
	document.tipo_trabajo_detalle.id_maquina.value							= document.tipo_trabajo_detalle.select_maquina.value;
	document.tipo_trabajo_detalle.id_tipo_placa.value						= document.tipo_trabajo_detalle.select_tipo_placa.value;
	document.tipo_trabajo_detalle.id_tipo_complejidad.value					= document.tipo_trabajo_detalle.select_tipo_complejidad.value;
	
	// genera la informacion de los input checkbox
	if( document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked )
		document.tipo_trabajo_detalle.proporciona_papel.value = "Si";
	else
		document.tipo_trabajo_detalle.proporciona_papel.value = "No";
	
	if( document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked )
		document.tipo_trabajo_detalle.proporciona_placas.value 	= "Si";
	else
		document.tipo_trabajo_detalle.proporciona_placas.value 	= "No";
		
	if( document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked )
		document.tipo_trabajo_detalle.proporciona_tinta_especial.value 	= "Si";
	else
		document.tipo_trabajo_detalle.proporciona_tinta_especial.value 	= "No";
	
	if( document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked )
		document.tipo_trabajo_detalle.proporciona_barniz.value 	= "Si";
	else
		document.tipo_trabajo_detalle.proporciona_barniz.value 	= "No";
	
	// guarda la informacion de los select en los input correspondientes
	document.tipo_trabajo_detalle.tipo_papel.value 					= document.tipo_trabajo_detalle.select_tipo_papel_extendido.options[document.tipo_trabajo_detalle.select_tipo_papel_extendido.selectedIndex].text;
	document.tipo_trabajo_detalle.tamanio_pubicacion.value 			= document.tipo_trabajo_detalle.select_tamanio_publicacion.options[document.tipo_trabajo_detalle.select_tamanio_publicacion.selectedIndex].text;;
	document.tipo_trabajo_detalle.frente_combinacion_tintas.value 	= document.tipo_trabajo_detalle.select_frente_combinacion_tintas.options[document.tipo_trabajo_detalle.select_frente_combinacion_tintas.selectedIndex].text;
	document.tipo_trabajo_detalle.frente_tipo_barniz.value 			= document.tipo_trabajo_detalle.select_frente_tipo_barniz.options[document.tipo_trabajo_detalle.select_frente_tipo_barniz.selectedIndex].text;
	document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value 	= document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.options[document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.selectedIndex].text;
	document.tipo_trabajo_detalle.vuelta_tipo_barniz.value 			= document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.options[document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.selectedIndex].text;
	document.tipo_trabajo_detalle.maquina.value 					= document.tipo_trabajo_detalle.select_maquina.options[document.tipo_trabajo_detalle.select_maquina.selectedIndex].text;
	document.tipo_trabajo_detalle.tipo_placa.value 					= document.tipo_trabajo_detalle.select_tipo_placa.options[document.tipo_trabajo_detalle.select_tipo_placa.selectedIndex].text;
	document.tipo_trabajo_detalle.tipo_complejidad.value 			= document.tipo_trabajo_detalle.select_tipo_complejidad.options[document.tipo_trabajo_detalle.select_tipo_complejidad.selectedIndex].text;
	
	var correcto = true;
	
	if ( document.tipo_trabajo_detalle.descripcion_partida_detalle.value == "" ) {
		correcto = false;
		alert("El campo descripcion no puede estar vacio. Favor de informarlo");
	}
	// Revisa que ancho y alto no este vacios
	if( correcto 
			&& isNaN(document.tipo_trabajo_detalle.alto_final.value) ) {
		correcto = false;
		alert("El campo alto debe ser un numero. Favor de informarlo");
		document.tipo_trabajo_detalle.alto_final.value.focus();
	}
	if ( correcto
			&& isNaN(document.tipo_trabajo_detalle.ancho_final.value ) ) {
		correcto = false;
		alert("El campo ancho debe ser un numero. Favor de informarlo");
		document.tipo_trabajo_detalle.ancho_final.focus(); 
	}
	if ( correcto
			&& isNaN(document.tipo_trabajo_detalle.alto_extendido.value) ) {
		correcto = false;
		alert("El campo alto extendido debe ser un numero. Favor de informarlo");
		document.tipo_trabajo_detalle.alto_extendido.value.focus();
	}
	if ( correcto
			&& isNaN(document.tipo_trabajo_detalle.ancho_extendido.value ) ) {
		correcto = false;
		alert("El campo ancho extendido debe ser un numero. Favor de informarlo");
		document.tipo_trabajo_detalle.ancho_extendido.focus(); 
	}
	
	if ( correcto
			&& (document.tipo_trabajo_detalle.alto_corte_inicial.value == ""
					|| isNaN(document.tipo_trabajo_detalle.alto_corte_inicial.value) )  ) {
		correcto = false;
		alert("El campo Alto Corte Inicial debe ser un numero valido. Favor de informarlo");
		document.tipo_trabajo_detalle.alto_corte_inicial.focus();
	}
	if ( correcto
			&& (document.tipo_trabajo_detalle.ancho_corte_inicial.value == ""
					|| isNaN(document.tipo_trabajo_detalle.ancho_corte_inicial.value) )  ) {
		correcto = false;
		alert("El campo Ancho Corte Inicial debe ser un numero valido. Favor de informarlo");
		document.tipo_trabajo_detalle.ancho_corte_inicial.focus();
	}
	
    switch( parseInt( document.partida.tipo_trabajo.value ) ) {
        case 1:
            if( correcto
            		&& ( document.tipo_trabajo_detalle.repeticiones_x_pliego.value == ""
            		|| isNaN( document.tipo_trabajo_detalle.repeticiones_x_pliego.value )
            		|| parseInt( document.tipo_trabajo_detalle.repeticiones_x_pliego.value ) <= 0 ) ) {
                correcto = false;
                alert("El n\u00famero de repeticiones deber ser un n\u00famero positivo mayor de cero");
                document.tipo_trabajo_detalle.repeticiones_x_pliego.focus();
            }
            break;
        
        case 2:
            if( correcto 
            		&& ( document.tipo_trabajo_detalle.numero_paginas_publicacion.value == ""
            		|| isNaN( document.tipo_trabajo_detalle.numero_paginas_publicacion.value )
            		|| parseInt( document.tipo_trabajo_detalle.numero_paginas_publicacion.value ) <= 0 
            		|| parseInt( document.tipo_trabajo_detalle.numero_paginas_publicacion.value )%4 != 0 ) ) {
                correcto = false;
                alert("El n\u00famero de p\u00e1ginas deber ser un n\u00famero positivo mayor de cero y multiplo de 4");
                document.tipo_trabajo_detalle.numero_paginas_publicacion.focus();
            }
            
            if( correcto
            		&& document.tipo_trabajo_detalle.select_tamanio_publicacion.value == "1" ) {
                correcto = false;
                alert("El tama\u00f1o de la publicaci\u00f3n debe ser especificado");
                document.forms["tipo_trabajo_detalle"].elements["select_tamanio_publicacion"].focus();
            }
            break;
            
        case 3:
            break;
            
        default:
            break;
    } // switch validacion tipo trabajo
    
     // valida que si no hay tinta normal en frente, debe forzosamente haber tinta especial en frente
    if( correcto 
    		&& document.tipo_trabajo_detalle.frente_id_combinacion_tintas.value == "16" ) {
        // valida en frente si la tinta especial es mayor a cero, exista obligatoriamente una descripcion.
        if( document.tipo_trabajo_detalle.frente_num_tinta_especial.value == ""
        		|| isNaN(document.tipo_trabajo_detalle.frente_num_tinta_especial)
        		|| parseInt( document.tipo_trabajo_detalle.frente_num_tinta_especial.value ) <= 0 ) {
            correcto = false;
            alert("Es necesario que exista al menos tinta especial en el frente");
            document.tipo_trabajo_detalle.frente_num_tinta_especial.focus();
        }   
    }
    
    // valida que informacion de frente num tinta especial
    if ( correcto 
    		&& document.tipo_trabajo_detalle.frente_num_tinta_especial.value == "" ) {
    	correcto = false;
    	alert("El numero de frente tinta especial debe ser cero");
    	document.tipo_trabajo_detalle.frente_num_tinta_especial.focus();
    }
    if ( correcto 
    		&& document.tipo_trabajo_detalle.frente_num_tinta_especial.value != ""
    		&& isNaN( document.tipo_trabajo_detalle.frente_num_tinta_especial.value ) ) {
    	correcto = false;
    	alert("El dato de frente tinta especial debe ser un numero");
    	document.tipo_trabajo_detalle.frente_num_tinta_especial.focus();
    }
    if ( correcto 
    		&& parseInt( document.tipo_trabajo_detalle.frente_num_tinta_especial.value ) > 0 
    		&& document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value == "" ) {
    	correcto = false;
    	alert("El numero de frente tinta especial es mayor a cero; debe especificar la descripcion de frente tinta especial");
    	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.focus();
    }
    if ( correcto
    		&& document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value != "" 
    		&& ( parseInt( document.tipo_trabajo_detalle.frente_num_tinta_especial.value ) == 0 
    				|| parseInt( document.tipo_trabajo_detalle.frente_num_tinta_especial.value ) < 0 ) ) {
    	correcto = false;
    	alert("Tiene especificada una descripcion de frente tinta especial; debe especificar que frente tinta especial es al menos 1");
    	document.tipo_trabajo_detalle.frente_num_tinta_especial.focus();
    }
    
 // valida que informacion de vuelta num tinta especial
    if ( correcto 
    		&& document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value == "" ) {
    	correcto = false;
    	alert("El numero de vuelta tinta especial debe ser cero");
    	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.focus();
    }
    if ( correcto 
    		&& document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value != ""
    		&& isNaN( document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value ) ) {
    	correcto = false;
    	alert("El dato de vuelta tinta especial debe ser un numero");
    	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.focus();
    }
    if ( correcto 
    		&& parseInt( document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value ) > 0 
    		&& document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value == "" ) {
    	correcto = false;
    	alert("El numero de vuelta tinta especial es mayor a cero; debe especificar la descripcion de vuelta tinta especial");
    	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.focus();
    }
    if ( correcto
    		&& document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value != "" 
    		&& ( parseInt( document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value ) == 0 
    				|| parseInt( document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value ) < 0 ) ) {
    	correcto = false;
    	alert("Tiene especificada una descripcion de vuelta tinta especial; debe especificar que vuelta tinta especial es al menos 1");
    	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.focus();
    }
    
	if( correcto ) {
		// realiza ajax
		document.body.style.cursor = "wait";
		desactivaCamposFormTipoTrabajoDetalle();
		desactivaBotonesModificarFormTipoTrabajoDetalle();
		
		var modificarPliegos = false;
		
		if ( document.tipo_trabajo_detalle.repeticiones_x_pliego.value != obj_ttd.repeticiones_x_pliego
				|| document.tipo_trabajo_detalle.numero_paginas_publicacion.value != obj_ttd.numero_paginas_publicacion
				|| document.tipo_trabajo_detalle.tamanio_pubicacion.value != obj_ttd.tamanio_publicacion ) 
			modificarPliegos = true;
		
		if ( modificarPliegos ) {
			// es necesario modificar la cantidad de pliegos y papel porque:
			// a) modifico el numero de repeticiones que caben en cada papel
			// b) modifico el numero de hojas de la publicacion
			// c) modifico el tamaño de la publicacion
			$.ajax({
				type:'POST',
				url:urlActualizaTipoTrabajoDetalleConPliegos,
				data:$("[name=tipo_trabajo_detalle]").serialize(),
				success:function(response) {
					//console.log(response);
					document.body.style.cursor = "default";
					switch(response.estatusOperacion) {
						case 0: // error
							cancelaModificarTTD();
							alert("No fue posible actualizar la informacion.");
							break;
						default: // exito
							// guarda informacion de pliegos
							obj_ttd.listaIdPliegoEliminado = response.textoJson;
							// guarda html ista de pliegos anterior
							obj_ttd.htmlListaPliegos = document.getElementById("div_tabla_lista_pliegos").innerHTML;
							// abre ventana creacion de pliegos para nueva informacion 
							Shadowbox.open({
		                        content:urlCalculaPliego + "?id_tipo_trabajo_detalle=" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value,
		                        player:"iframe",
		                        width:861,
		                        height:704,
		                        options:{ 
		                        	modal: true,
		                            overlayOpacity: 0.75,
		                            onClose: revisaCierreSegundaVentanaModal
		                        }
		                    });
							break;
					}
					muestraBotonesModificarPorSeccion();
				},
				error: function() {
					document.body.style.cursor = "default";
					cancelaModificarTTD()
					alert("No fue posible actualizar la informaci\u00F3n.");
					muestraBotonesModificarPorSeccion();
				}
			});
		} else {
			// no es necesario modificar informacion respecto a cantidad de pliegos
			// no es necesario modificar informacion respecto a cantidad de papel
			$.ajax({
				type:'POST',
				url:urlActualizaTipoTrabajoDetalle,
				data:$("[name=tipo_trabajo_detalle]").serialize(),
				success:function(response) {
					//console.log(response);
					document.body.style.cursor = "default";
					switch(response.estatusOperacion) {
						case 0: // error
							cancelaModificarTTD();
							alert("No fue posible actualizar la informacion.");
							break;
						default: // exito
							document.body.style.cursor = "default";
							// obtiene el precio neto
							$.ajax({
								type:"POST",
								url:urlObtienePrecioNeto,
								data:{
									id_orden_produccion:document.tipo_trabajo_detalle.id_orden_produccion.value,
									nut:document.tipo_trabajo_detalle.nut.value
								},
								success:function(response){
									// actualiza html
									var descripcion				= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_descripcion";
									var repeticiones_x_pliego 	= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_repeticiones_x_pliego";
									var numero_paginas 			= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_numero_paginas_publicacion";
									var tamanio_publicacion 	= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_tamanio_publicacion";
									var nombre_maquina 			= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_nombre_maquina";
									document.getElementById(descripcion).innerHTML 				= document.tipo_trabajo_detalle.descripcion_partida_detalle.value;
									document.getElementById(repeticiones_x_pliego).innerHTML 	= document.tipo_trabajo_detalle.repeticiones_x_pliego.value==""?"0":document.tipo_trabajo_detalle.repeticiones_x_pliego.value;
									document.getElementById(numero_paginas).innerHTML 			= document.tipo_trabajo_detalle.numero_paginas_publicacion.value==""?"0":document.tipo_trabajo_detalle.numero_paginas_publicacion.value;
									document.getElementById(tamanio_publicacion).innerHTML 		= document.tipo_trabajo_detalle.tamanio_pubicacion.value==""?"null":document.tipo_trabajo_detalle.tamanio_pubicacion.value;
									document.getElementById(nombre_maquina).innerHTML 			= document.tipo_trabajo_detalle.maquina.value;
									delete descripcion;
									delete repeticiones_x_pliego;
									delete numero_paginas;
									delete tamanio_publicacion;
									delete nombre_maquina;
									// actualiza precio
									//alert("regreso bien del segundo ajax en revisaCierreSegundaVentanaModal");
									document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
									muestraBotonesModificarPorSeccion();
								},
								error:function(e){
									alert("No fue posible obtener precio neto");
									muestraBotonesModificarPorSeccion();
								}
							});
							break;
					}
					muestraBotonesModificarPorSeccion();
				},
				error: function() {
					document.body.style.cursor = "default";
					cancelaModificarTTD()
					alert("No fue posible actualizar la informaci\u00F3n.");
					muestraBotonesModificarPorSeccion();
				}
			});
		}
	}
	delete correcto;
} // aceptaModificarTTDEncabezado

function cancelaModificarTTD() {
	obj_ttd.setFormTTD();
	desactivaBotonesModificarFormTipoTrabajoDetalle();
	desactivaCamposFormTipoTrabajoDetalle();
	// activa botones de modificar en las areas restantes
	muestraBotonesModificarPorSeccion();
} // cancelaModificarTTDEncabezado

function revisaCierreSegundaVentanaModal() {
	//alert("cerro la segunda ventana modal");
	//alert("el valor de la bandera es: " + cerradoOKVentanaListaPliegos);
	if( cerradoOKVentanaListaPliegos ) {
		// Ok.
		//alert("entro al if");
		$.ajax({
			type:"POST",
			url:urlObtienePrecioNeto,
			data:{
				id_orden_produccion:document.tipo_trabajo_detalle.id_orden_produccion.value,
				nut:document.tipo_trabajo_detalle.nut.value
			},
			success:function(response){
				// actualiza html
				var descripcion				= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_descripcion";
				var repeticiones_x_pliego 	= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_repeticiones_x_pliego";
				var numero_paginas 			= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_numero_paginas_publicacion";
				var tamanio_publicacion 	= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_tamanio_publicacion";
				var nombre_maquina 			= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_nombre_maquina";
				document.getElementById(descripcion).innerHTML 				= document.tipo_trabajo_detalle.descripcion_partida_detalle.value;
				document.getElementById(repeticiones_x_pliego).innerHTML 	= document.tipo_trabajo_detalle.repeticiones_x_pliego.value==""?"0":document.tipo_trabajo_detalle.repeticiones_x_pliego.value;
				document.getElementById(numero_paginas).innerHTML 			= document.tipo_trabajo_detalle.numero_paginas_publicacion.value==""?"0":document.tipo_trabajo_detalle.numero_paginas_publicacion.value;
				document.getElementById(tamanio_publicacion).innerHTML 		= document.tipo_trabajo_detalle.tamanio_pubicacion.value==""?"null":document.tipo_trabajo_detalle.tamanio_pubicacion.value;
				document.getElementById(nombre_maquina).innerHTML 			= document.tipo_trabajo_detalle.maquina.value;
				delete descripcion;
				delete repeticiones_x_pliego;
				delete numero_paginas;
				delete tamanio_publicacion;
				delete nombre_maquina;
				// actualiza precio
				//alert("regreso bien del segundo ajax en revisaCierreSegundaVentanaModal");
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				muestraBotonesModificarPorSeccion();
			},
			error:function(e){
				alert("No fue posible obtener precio neto");
				muestraBotonesModificarPorSeccion();
			}
		});
		// inicializa variable
		cerradoOKVentanaListaPliegos = false;
	} else {
		// 1) Debe copiar en pantalla el valor anterior
		// 2) Debe hacer update en base de datos con el registro anterior tipo_trabajo_detalle
		// 3) Debe activar los pliegoe eliminados
		// 4) Busca el precio
		//alert("entro al else");
		
		// 1)
		obj_ttd.setFormTTD();
		
		// 2)
		activaCamposFormTipoTrabajoDetalle();
		
		document.tipo_trabajo_detalle.cliente_proporciona_papel.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked;
		document.tipo_trabajo_detalle.cliente_proporciona_placas.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked;
		document.tipo_trabajo_detalle.cliente_proporciona_tinta_especial.value 	= document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked;
		document.tipo_trabajo_detalle.cliente_proporciona_barniz.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked;
		document.tipo_trabajo_detalle.id_tipo_papel_extendido.value				= document.tipo_trabajo_detalle.select_tipo_papel_extendido.value;
		document.tipo_trabajo_detalle.id_tamanio_publicacion.value				= document.tipo_trabajo_detalle.select_tamanio_publicacion.value;
		document.tipo_trabajo_detalle.frente_id_combinacion_tintas.value		= document.tipo_trabajo_detalle.select_frente_combinacion_tintas.value;
		document.tipo_trabajo_detalle.frente_id_tipo_barniz.value				= document.tipo_trabajo_detalle.select_frente_tipo_barniz.value;
		document.tipo_trabajo_detalle.vuelta_id_combinacion_tintas.value		= document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.value;
		document.tipo_trabajo_detalle.vuelta_id_tipo_barniz.value				= document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.value;
		document.tipo_trabajo_detalle.id_maquina.value							= document.tipo_trabajo_detalle.select_maquina.value;
		document.tipo_trabajo_detalle.id_tipo_placa.value						= document.tipo_trabajo_detalle.select_tipo_placa.value;
		
		// genera la informacion de los input checkbox
		if( document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked )
			document.tipo_trabajo_detalle.proporciona_papel.value = "Si";
		else
			document.tipo_trabajo_detalle.proporciona_papel.value = "No";
		
		if( document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked )
			document.tipo_trabajo_detalle.proporciona_placas.value 	= "Si";
		else
			document.tipo_trabajo_detalle.proporciona_placas.value 	= "No";
			
		if( document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked )
			document.tipo_trabajo_detalle.proporciona_tinta_especial.value 	= "Si";
		else
			document.tipo_trabajo_detalle.proporciona_tinta_especial.value 	= "No";
		
		if( document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked )
			document.tipo_trabajo_detalle.proporciona_barniz.value 	= "Si";
		else
			document.tipo_trabajo_detalle.proporciona_barniz.value 	= "No";
		
		// guarda la informacion de los select en los input correspondientes
		document.tipo_trabajo_detalle.tipo_papel.value 					= document.tipo_trabajo_detalle.select_tipo_papel_extendido.options[document.tipo_trabajo_detalle.select_tipo_papel_extendido.selectedIndex].text;
		document.tipo_trabajo_detalle.tamanio_pubicacion.value 			= document.tipo_trabajo_detalle.select_tamanio_publicacion.options[document.tipo_trabajo_detalle.select_tamanio_publicacion.selectedIndex].text;;
		document.tipo_trabajo_detalle.frente_combinacion_tintas.value 	= document.tipo_trabajo_detalle.select_frente_combinacion_tintas.options[document.tipo_trabajo_detalle.select_frente_combinacion_tintas.selectedIndex].text;
		document.tipo_trabajo_detalle.frente_tipo_barniz.value 			= document.tipo_trabajo_detalle.select_frente_tipo_barniz.options[document.tipo_trabajo_detalle.select_frente_tipo_barniz.selectedIndex].text;
		document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value 	= document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.options[document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.selectedIndex].text;
		document.tipo_trabajo_detalle.vuelta_tipo_barniz.value 			= document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.options[document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.selectedIndex].text;
		document.tipo_trabajo_detalle.maquina.value 					= document.tipo_trabajo_detalle.select_maquina.options[document.tipo_trabajo_detalle.select_maquina.selectedIndex].text;
		document.tipo_trabajo_detalle.tipo_placa.value 					= document.tipo_trabajo_detalle.select_tipo_placa.options[document.tipo_trabajo_detalle.select_tipo_placa.selectedIndex].text;
		
		// desactiva campos
		desactivaCamposFormTipoTrabajoDetalle();
		desactivaBotonesModificarFormTipoTrabajoDetalle();
		
		// realiza ajax
		// 3)
		$.ajax({
			type:'POST',
			url:urlActualizaTipoTrabajoDetalle,
			data:$("[name=tipo_trabajo_detalle]").serialize(),
			success:function(response) {
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						cancelaModificarTTD();
						alert("No fue posible actualizar la informaci\u00F3n.");
						break;
						
					default: // exito
			
	        			//alert("activa pliegos eliminados");
	        			$.ajax({
	        				type:"POST",
	        				url:urlActivaListaPliegos,
	        				data:{json:obj_ttd.listaIdPliegoEliminado},
	        				success:function(response){
	        					//alert("exito activando pliegos");
	        					document.getElementById("div_tabla_lista_pliegos").innerHTML = obj_ttd.htmlListaPliegos;
	// 4)
		             			$.ajax({
		             				type:"POST",
		             				url:urlObtienePrecioNeto,
		             				data:{
		             					id_orden_produccion:document.tipo_trabajo_detalle.id_orden_produccion.value,
		             					nut:document.tipo_trabajo_detalle.nut.value
		             				},
		             				success:function(response){
		             					// actualiza precio
		             					//alert("regreso bien del segundo ajax en revisaCierreSegundaVentanaModal");
		             					document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);		
		             				},
		             				error:function(e){
		             					alert("No fue posible obtener precio neto");
		             				}
		             			});
	        				},
	        				error:function(e){
	        					alert("error activando pliegos");
	        				}
	        			});
	       				break;
				}
				muestraBotonesModificarPorSeccion();
			},
			error: function() {
				document.body.style.cursor = "default";
				cancelaModificarTTD()
				alert("No fue posible actualizar la informaci\u00F3n.");
				muestraBotonesModificarPorSeccion();
			}
		});
	}
} // revisaCierreSegundaVentanaModal