
function ocultaBotonesModificarPorSeccion() {
	if ( document.getElementById("div_btn_actualizar_orden_produccion") )
		document.getElementById("div_btn_actualizar_orden_produccion").style.display 	= "none";
	if ( document.getElementById("div_btn_actualizar_partida") )
		document.getElementById("div_btn_actualizar_partida").style.display 			= "none";
	if ( document.getElementById("div_btn_agregar_ttd_encabezado") )
		document.getElementById("div_btn_agregar_ttd_encabezado").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_ttd_encabezado") )
		document.getElementById("div_btn_actualizar_ttd_encabezado").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_pliego") )
		document.getElementById("div_btn_actualizar_pliego").style.display 				= "none";
	if ( document.getElementById("div_btn_actualizar_descuento") )
		document.getElementById("div_btn_actualizar_descuento").style.display 			= "none";
	if ( document.getElementById("div_btn_actualizar_costo_extra_detalle") )
		document.getElementById("div_btn_actualizar_costo_extra_detalle").style.display = "none";
	if ( document.getElementById("div_btn_agregar_costo_extra_detalle") )
		document.getElementById("div_btn_agregar_costo_extra_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_modificar_disenio") )
		document.getElementById("div_btn_modificar_disenio").style.display 				= "none";
	if ( document.getElementById("div_btn_agregar_disenio_detalle") )
		document.getElementById("div_btn_agregar_disenio_detalle").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_disenio_detalle") )
		document.getElementById("div_btn_actualizar_disenio_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_modificar_preprensa") )
		document.getElementById("div_btn_modificar_preprensa").style.display 			= "none";
	if ( document.getElementById("div_btn_agregar_preprensa_detalle") )
		document.getElementById("div_btn_agregar_preprensa_detalle").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_preprensa_detalle") )
		document.getElementById("div_btn_actualizar_preprensa_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_modificar_transporte") )
		document.getElementById("div_btn_modificar_transporte").style.display 			= "none";
	if ( document.getElementById("div_btn_agregar_transporte_detalle") )
		document.getElementById("div_btn_agregar_transporte_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_actualizar_transporte_detalle") )
		document.getElementById("div_btn_actualizar_transporte_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_modificar_acabado") )
		document.getElementById("div_btn_modificar_acabado").style.display 				= "none";
	if ( document.getElementById("div_btn_agregar_acabado_detalle") )
		document.getElementById("div_btn_agregar_acabado_detalle").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_acabado_detalle") )
		document.getElementById("div_btn_actualizar_acabado_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_modificar_offset") )
		document.getElementById("div_btn_modificar_offset").style.display 				= "none";
	if ( document.getElementById("div_btn_agregar_material_ayuda") )
		document.getElementById("div_btn_agregar_material_ayuda").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_material_ayuda") )
		document.getElementById("div_btn_actualizar_material_ayuda").style.display 		= "none";
	
	document.getElementById("imgBtnModificarEstatus").style.display 					= "none";
	document.getElementById("imgBtnRevisarCostos").style.display 						= "none";
} // ocultaBotonesModificarPorSeccion

function muestraBotonesModificarPorSeccion() {
	if ( document.getElementById("div_btn_actualizar_orden_produccion") )
		document.getElementById("div_btn_actualizar_orden_produccion").style.display 	= "inline";
	if ( document.getElementById("div_btn_actualizar_partida") )
		document.getElementById("div_btn_actualizar_partida").style.display 			= "inline";
	if ( document.getElementById("div_btn_agregar_ttd_encabezado") )
		document.getElementById("div_btn_agregar_ttd_encabezado").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_ttd_encabezado") )
		document.getElementById("div_btn_actualizar_ttd_encabezado").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_pliego") )
		document.getElementById("div_btn_actualizar_pliego").style.display 				= "inline";
	if ( document.getElementById("div_btn_actualizar_descuento") )
		document.getElementById("div_btn_actualizar_descuento").style.display 			= "inline";
	if ( document.getElementById("div_btn_actualizar_costo_extra_detalle") )
		document.getElementById("div_btn_actualizar_costo_extra_detalle").style.display = "inline";
	if ( document.getElementById("div_btn_agregar_costo_extra_detalle") )
		document.getElementById("div_btn_agregar_costo_extra_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_modificar_disenio") )
		document.getElementById("div_btn_modificar_disenio").style.display 				= "inline";
	if ( document.getElementById("div_btn_agregar_disenio_detalle") )
		document.getElementById("div_btn_agregar_disenio_detalle").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_disenio_detalle") )
		document.getElementById("div_btn_actualizar_disenio_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_modificar_preprensa") )
		document.getElementById("div_btn_modificar_preprensa").style.display 			= "inline";
	if ( document.getElementById("div_btn_agregar_preprensa_detalle") )
		document.getElementById("div_btn_agregar_preprensa_detalle").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_preprensa_detalle") )
		document.getElementById("div_btn_actualizar_preprensa_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_modificar_transporte") )
		document.getElementById("div_btn_modificar_transporte").style.display 			= "inline";
	if ( document.getElementById("div_btn_agregar_transporte_detalle") )
		document.getElementById("div_btn_agregar_transporte_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_actualizar_transporte_detalle") )
		document.getElementById("div_btn_actualizar_transporte_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_modificar_acabado") )
		document.getElementById("div_btn_modificar_acabado").style.display 				= "inline";
	if ( document.getElementById("div_btn_agregar_acabado_detalle") )
		document.getElementById("div_btn_agregar_acabado_detalle").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_acabado_detalle") )
		document.getElementById("div_btn_actualizar_acabado_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_modificar_offset") )
		document.getElementById("div_btn_modificar_offset").style.display 				= "inline";
	if ( document.getElementById("div_btn_agregar_material_ayuda") )
		document.getElementById("div_btn_agregar_material_ayuda").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_material_ayuda") )
		document.getElementById("div_btn_actualizar_material_ayuda").style.display 		= "inline";
	
	document.getElementById("imgBtnModificarEstatus").style.display 					= "inline";
	document.getElementById("imgBtnRevisarCostos").style.display 						= "inline";
} // muestraBotonesModificarPorSeccion

