
// limpia formularios

function limpiaFormCliente() {
	
    document.forms["cliente"].elements["nombre_moral"].value           = "";
    document.forms["cliente"].elements["id_cliente"].value             = "";
    document.forms["cliente"].elements["clave"].value                  = "";
    document.forms["cliente"].elements["nombre_representante"].value   = "";
    document.forms["cliente"].elements["calle"].value                  = "";
    document.forms["cliente"].elements["num_exterior"].value           = "";
    document.forms["cliente"].elements["num_interior"].value           = "";
    document.forms["cliente"].elements["colonia"].value                = "";
    document.forms["cliente"].elements["delegacion_municipio"].value   = "";
    document.forms["cliente"].elements["estado"].value                 = "";
    document.forms["cliente"].elements["codigo_postal"].value          = "";
    document.forms["cliente"].elements["rfc"].value                    = "";
    document.forms["cliente"].elements["telefono_particular"].value    = "";
    document.forms["cliente"].elements["telefono_movil"].value         = "";
    document.forms["cliente"].elements["observaciones"].value          = "";
    document.cliente.select_search.options[0].selected = true;
    
    document.forms["cliente"].elements["id_cliente"].focus();
} // limpiaFormCliente()





//************************/
// orden de produccion

function limpiaCamposFormOrdenProduccion() {
    // limpia datos externos
    document.forms["orden_produccion"].elements["nombre"].value                                = "";
    document.forms["orden_produccion"].elements["descripcion"].value                           = "";
    document.forms["orden_produccion"].elements["id_tipo_comprobante_fiscal"].selectedIndex    = 0;
    document.forms["orden_produccion"].elements["fecha_prometida_entrega"].value               = "";
    document.forms["orden_produccion"].elements["nombre"].focus();
} // limpiaCamposFormOrdenProduccion()


function limpiaFormOrdenProduccion() {
    // limpia datos internos
    document.forms["orden_produccion"].elements["id_usuario"].value                 = "";
    document.forms["orden_produccion"].elements["id_cliente"].value                 = "";
    document.forms["orden_produccion"].elements["id_tipo_comprobante_fiscal"].value = "";
    limpiaCamposFormOrdenProduccion();
} // limpiaFormOrdenProduccion()


function activaCamposOrdenProduccion() {
    document.forms["orden_produccion"].elements["nombre"].readOnly                      = false;
    document.forms["orden_produccion"].elements["descripcion"].readOnly                 = false;
    document.forms["orden_produccion"].elements["select_comprobante_fiscal"].disabled   = false;
    document.forms["orden_produccion"].elements["fecha_prometida_entrega"].readOnly     = false;
} // activaCamposOrdenProduccion()


function desactivaCamposOrdenProduccion() {
    document.forms["orden_produccion"].elements["nombre"].readOnly                      = true;
    document.forms["orden_produccion"].elements["descripcion"].readOnly                 = true;
    document.forms["orden_produccion"].elements["select_comprobante_fiscal"].disabled   = true;
    document.forms["orden_produccion"].elements["fecha_prometida_entrega"].readOnly     = true;
} // desactivaCamposOrdenProduccion()


function activaBtnOrdenProduccion() {
    document.getElementById("imgBtnAgregarOrdnProdInactivo").style.display  = "none";
    document.getElementById("imgBtnLimpiarOrdnProdInactivo").style.display  = "none";
    document.getElementById("imgBtnAgregarOrdnProdActivo").style.display    = "inline";
    document.getElementById("imgBtnLimpiarOrdnProdActivo").style.display    = "inline";
} // activaBtnOrdenProduccion()


function desactivaBtnOrdenProduccion() {
    document.getElementById("imgBtnAgregarOrdnProdActivo").style.display    = "none";
    document.getElementById("imgBtnLimpiarOrdnProdActivo").style.display    = "none";
    document.getElementById("imgBtnAgregarOrdnProdInactivo").style.display  = "inline";
    document.getElementById("imgBtnLimpiarOrdnProdInactivo").style.display  = "inline";
} // desactivaBtnOrdenProduccion()





//************************/
// partida

function limpiaCamposFormPartida() {
    // limpia campos externos
    document.forms["partida"].elements["tipo_trabajo"][0].click();
    document.forms["partida"].elements["nombre_partida"].value                  = "";
    document.forms["partida"].elements["cantidad"].value                        = "";
    document.forms["partida"].elements["select_forma_trabajo"].selectedIndex    = 0;
    document.forms["partida"].elements["descripcion_partida"].value             = "";
    document.forms["partida"].elements["diagrama_formacion"].value              = "";
    document.forms["partida"].elements["observaciones_generales"].value         = "";
    document.forms["partida"].elements["observaciones_aprobacion"].value        = "";
    document.forms["partida"].elements["nombre_partida"].focus();
} // limpiaCamposFormPartida()


function limpiaFormPartida() {
    // limpia campos internos
    document.forms["partida"].elements["id_orden_produccion"].value     = "";
    document.forms["partida"].elements["id_tipo_trabajo"].value         = "";
    document.forms["partida"].elements["id_tipo_forma_trabajo"].value   = "";
    limpiaCamposFormPartida();
    activaCamposPartida();
    activaBtnPartida();
} // limpiaFormPartida()


function activaCamposPartida() {
    document.forms["partida"].elements["tipo_trabajo"][0].disabled          = false;
    document.forms["partida"].elements["tipo_trabajo"][1].disabled          = false;
    document.forms["partida"].elements["tipo_trabajo"][2].disabled          = false;
    document.forms["partida"].elements["nombre_partida"].readOnly           = false;
    document.forms["partida"].elements["cantidad"].readOnly                 = false;
    document.forms["partida"].elements["select_forma_trabajo"].disabled     = false;
    document.forms["partida"].elements["descripcion_partida"].readOnly      = false;
    document.forms["partida"].elements["diagrama_formacion"].disabled       = false;
    document.forms["partida"].elements["observaciones_generales"].readOnly  = false;
    document.forms["partida"].elements["observaciones_aprobacion"].readOnly = false;
} // activaCamposPartida()


function desactivaCamposPartida() {
    document.forms["partida"].elements["tipo_trabajo"][0].disabled          = true;
    document.forms["partida"].elements["tipo_trabajo"][1].disabled          = true;
    document.forms["partida"].elements["tipo_trabajo"][2].disabled          = true;
    document.forms["partida"].elements["nombre_partida"].readOnly           = true;
    document.forms["partida"].elements["cantidad"].readOnly                 = true;
    document.forms["partida"].elements["select_forma_trabajo"].disabled     = true;
    document.forms["partida"].elements["descripcion_partida"].readOnly      = true;
    document.forms["partida"].elements["observaciones_generales"].readOnly  = true;
    document.forms["partida"].elements["observaciones_aprobacion"].readOnly = true;
} // desactivaCamposPartida()


function activaBtnPartida() {
    document.getElementById("imgBtnAgregarPartidaInactivo").style.display   = "none";
    document.getElementById("imgBtnLimpiarPartidaInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarPartidaActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarPartidaActivo").style.display     = "inline";
} // activaBotonesPartida()


function desactivaBtnPartida() {
    document.getElementById("imgBtnAgregarPartidaActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarPartidaActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarPartidaInactivo").style.display   = "inline";
    document.getElementById("imgBtnLimpiarPartidaInactivo").style.display   = "inline";
} // desactivaBtnPartida()





//************************/
// detalle partida

function limpiaCamposFormTipoTrabajoDetalle() {
    // limpia campos externos
    document.forms["tipo_trabajo_detalle"].elements["descripcion_partida_detalle"].value                = "";
    document.forms["tipo_trabajo_detalle"].elements["alto_final"].value                                 = "";
    document.forms["tipo_trabajo_detalle"].elements["ancho_final"].value                                = "";
    document.forms["tipo_trabajo_detalle"].elements["alto_extendido"].value                             = "";
    document.forms["tipo_trabajo_detalle"].elements["ancho_extendido"].value                            = "";
    document.forms["tipo_trabajo_detalle"].elements["proporciona_papel"].checked                        = false;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_tinta_especial"].checked               = false;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_barniz"].checked                       = false;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_placas"].checked                       = false;
    document.forms["tipo_trabajo_detalle"].elements["tipo_papel_extendido"].value                      	= "";
    document.forms["tipo_trabajo_detalle"].elements["repeticiones_x_pliego"].value                      = "";
    document.forms["tipo_trabajo_detalle"].elements["numero_paginas_publicacion"].value                 = 0;
    document.forms["tipo_trabajo_detalle"].elements["alto_corte_inicial"].value                 		= 0;
    document.forms["tipo_trabajo_detalle"].elements["ancho_corte_inicial"].value                 		= 0;
    document.forms["tipo_trabajo_detalle"].elements["select_tamanio_publicacion"].selectedIndex         = 0;
    document.forms["tipo_trabajo_detalle"].elements["select_frente_combinacion_tintas"].selectedIndex   = 0;
    document.forms["tipo_trabajo_detalle"].elements["frente_num_tinta_especial"].value                  = 0;
    document.forms["tipo_trabajo_detalle"].elements["select_frente_tipo_barniz"].selectedIndex          = 0;
    document.forms["tipo_trabajo_detalle"].elements["frente_descripcion_tinta_especial"].value          = "";
    document.forms["tipo_trabajo_detalle"].elements["select_vuelta_combinacion_tintas"].selectedIndex   = 0;
    document.forms["tipo_trabajo_detalle"].elements["vuelta_num_tinta_especial"].value                  = 0;
    document.forms["tipo_trabajo_detalle"].elements["select_vuelta_tipo_barniz"].selectedIndex          = 0;
    document.forms["tipo_trabajo_detalle"].elements["vuelta_descripcion_tinta_especial"].value          = "";
    document.forms["tipo_trabajo_detalle"].elements["select_maquina"].selectedIndex                     = 0;
    document.forms["tipo_trabajo_detalle"].elements["select_tipo_placa"].selectedIndex                  = 0;
    document.forms["tipo_trabajo_detalle"].elements["select_tipo_complejidad"].selectedIndex            = 0;
    document.forms["tipo_trabajo_detalle"].elements["descripcion_partida_detalle"].focus();
} // limpiaCamposFormTipoTrabajoDetalle()


function limpiaFormTipoTrabajoDetalle() {
    // limpia campos ocultos
    document.forms["tipo_trabajo_detalle"].elements["id_partida"].value                         = "";
    document.forms["tipo_trabajo_detalle"].elements["cliente_proporciona_papel"].value          = "";
    document.forms["tipo_trabajo_detalle"].elements["cliente_proporciona_tinta"].value          = "";
    document.forms["tipo_trabajo_detalle"].elements["cliente_proporciona_tinta_especial"].value = "";
    document.forms["tipo_trabajo_detalle"].elements["cliente_proporciona_barniz"].value         = "";
    document.forms["tipo_trabajo_detalle"].elements["cliente_proporciona_placas"].value         = "";
    document.forms["tipo_trabajo_detalle"].elements["id_tipo_papel_extendido"].value            = "";
    document.forms["tipo_trabajo_detalle"].elements["id_tamanio_publicacion"].value             = "";
    document.forms["tipo_trabajo_detalle"].elements["frente_id_combinacion_tintas"].value       = "";
    document.forms["tipo_trabajo_detalle"].elements["frente_id_tipo_barniz"].value              = "";
    document.forms["tipo_trabajo_detalle"].elements["vuelta_id_combinacion_tintas"].value       = "";
    document.forms["tipo_trabajo_detalle"].elements["vuelta_id_tipo_barniz"].value              = "";
    document.forms["tipo_trabajo_detalle"].elements["id_maquina"].value                         = "";
    document.forms["tipo_trabajo_detalle"].elements["id_tipo_placa"].value                      = "";
    document.forms["tipo_trabajo_detalle"].elements["id_tipo_complejidad"].value                = "";
    limpiaCamposFormTipoTrabajoDetalle();
    activaCamposTipoTrabajoDetalle();
    activaBtnTipoTrabajoDetalle();
} // limpiaFormDetallePartida()


function activaCamposTipoTrabajoDetalle() {
    document.forms["tipo_trabajo_detalle"].elements["descripcion_partida_detalle"].readOnly         = false;
    document.forms["tipo_trabajo_detalle"].elements["alto_final"].readOnly                          = false;
    document.forms["tipo_trabajo_detalle"].elements["ancho_final"].readOnly                         = false;
    document.forms["tipo_trabajo_detalle"].elements["alto_extendido"].readOnly                      = false;
    document.forms["tipo_trabajo_detalle"].elements["ancho_extendido"].readOnly                     = false;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_papel"].disabled                   = false;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_tinta_especial"].disabled          = false;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_barniz"].disabled                  = false;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_placas"].disabled                  = false;
    document.forms["tipo_trabajo_detalle"].elements["repeticiones_x_pliego"].readOnly               = false;
    document.forms["tipo_trabajo_detalle"].elements["numero_paginas_publicacion"].readOnly          = false;
    document.forms["tipo_trabajo_detalle"].elements["alto_corte_inicial"].readOnly          		= false;
    document.forms["tipo_trabajo_detalle"].elements["ancho_corte_inicial"].readOnly          		= false;
    document.forms["tipo_trabajo_detalle"].elements["select_tamanio_publicacion"].disabled          = false;
    document.forms["tipo_trabajo_detalle"].elements["select_frente_combinacion_tintas"].disabled    = false;
    document.forms["tipo_trabajo_detalle"].elements["frente_num_tinta_especial"].readOnly           = false;
    document.forms["tipo_trabajo_detalle"].elements["select_frente_tipo_barniz"].disabled           = false;
    document.forms["tipo_trabajo_detalle"].elements["frente_descripcion_tinta_especial"].readOnly   = false;
    document.forms["tipo_trabajo_detalle"].elements["select_vuelta_combinacion_tintas"].disabled    = false;
    document.forms["tipo_trabajo_detalle"].elements["vuelta_num_tinta_especial"].readOnly           = false;
    document.forms["tipo_trabajo_detalle"].elements["select_vuelta_tipo_barniz"].disabled           = false;
    document.forms["tipo_trabajo_detalle"].elements["vuelta_descripcion_tinta_especial"].readOnly   = false;
    document.forms["tipo_trabajo_detalle"].elements["select_maquina"].disabled                      = false;
    document.forms["tipo_trabajo_detalle"].elements["select_tipo_placa"].disabled                   = false;
    document.forms["tipo_trabajo_detalle"].elements["select_tipo_complejidad"].disabled             = false;
} // activaCamposTipoTrabajoDetalle()


function desactivaCamposTipoTrabajoDetalle() {
    document.forms["tipo_trabajo_detalle"].elements["descripcion_partida_detalle"].readOnly         = true;
    document.forms["tipo_trabajo_detalle"].elements["alto_final"].readOnly                          = true;
    document.forms["tipo_trabajo_detalle"].elements["ancho_final"].readOnly                         = true;
    document.forms["tipo_trabajo_detalle"].elements["alto_extendido"].readOnly                      = true;
    document.forms["tipo_trabajo_detalle"].elements["ancho_extendido"].readOnly                     = true;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_papel"].disabled                   = true;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_tinta_especial"].disabled          = true;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_barniz"].disabled                  = true;
    document.forms["tipo_trabajo_detalle"].elements["proporciona_placas"].disabled                  = true;
    document.forms["tipo_trabajo_detalle"].elements["repeticiones_x_pliego"].readOnly               = true;
    document.forms["tipo_trabajo_detalle"].elements["numero_paginas_publicacion"].readOnly          = true;
    document.forms["tipo_trabajo_detalle"].elements["alto_corte_inicial"].readOnly          		= true;
    document.forms["tipo_trabajo_detalle"].elements["ancho_corte_inicial"].readOnly          		= true;
    document.forms["tipo_trabajo_detalle"].elements["select_tamanio_publicacion"].disabled          = true;
    document.forms["tipo_trabajo_detalle"].elements["select_frente_combinacion_tintas"].disabled    = true;
    document.forms["tipo_trabajo_detalle"].elements["frente_num_tinta_especial"].readOnly           = true;
    document.forms["tipo_trabajo_detalle"].elements["select_frente_tipo_barniz"].disabled           = true;
    document.forms["tipo_trabajo_detalle"].elements["frente_descripcion_tinta_especial"].readOnly   = true;
    document.forms["tipo_trabajo_detalle"].elements["select_vuelta_combinacion_tintas"].disabled    = true;
    document.forms["tipo_trabajo_detalle"].elements["vuelta_num_tinta_especial"].readOnly           = true;
    document.forms["tipo_trabajo_detalle"].elements["select_vuelta_tipo_barniz"].disabled           = true;
    document.forms["tipo_trabajo_detalle"].elements["vuelta_descripcion_tinta_especial"].readOnly   = true;
    document.forms["tipo_trabajo_detalle"].elements["select_maquina"].disabled                      = true;
    document.forms["tipo_trabajo_detalle"].elements["select_tipo_placa"].disabled                   = true;
    document.forms["tipo_trabajo_detalle"].elements["select_tipo_complejidad"].disabled             = true;
} // desactivaCamposTipoTrabajoDetalle()


function activaBtnTipoTrabajoDetalle() {
    document.getElementById("imgBtnAgregarDetallePartidaInactivo").style.display    = "none";
    document.getElementById("imgBtnLimpiarDetallePartidaInactivo").style.display    = "none";
    document.getElementById("imgBtnAgregarDetallePartidaActivo").style.display      = "inline";
    document.getElementById("imgBtnLimpiarDetallePartidaActivo").style.display      = "inline";
} // activaBotonesTipoTrabajoDetalle()


function desactivaBtnTipoTrabajoDetalle() {
    document.getElementById("imgBtnAgregarDetallePartidaActivo").style.display      = "none";
    document.getElementById("imgBtnLimpiarDetallePartidaActivo").style.display      = "none";
    document.getElementById("imgBtnAgregarDetallePartidaInactivo").style.display    = "inline";
    document.getElementById("imgBtnLimpiarDetallePartidaInactivo").style.display    = "inline";
} // desactivaBtnTipoTrabajoDetalle()





//************************/
//costo_extra_detalle

function limpiaCamposCostoExtraDetalle() {
	document.forms["costo_extra_detalle"].elements["select_costo_extra"].selectedIndex 			= 0;
	document.forms["costo_extra_detalle"].elements["select_responsable_insumo"].selectedIndex 	= 0;
	document.forms["costo_extra_detalle"].elements["cantidad"].value 							= "";
	document.forms["costo_extra_detalle"].elements["nombre_unidad_medida"].value 				= "";
	document.forms["costo_extra_detalle"].elements["especificacion"].value 						= "";
	ajaxUnidadCostoExtra();
} // limpiaCamposCostoExtraDetalle

function limpiaFormCostoExtraDetalle() {
	document.forms["costo_extra_detalle"].elements["id_tipo_trabajo_detalle"].value = "";
	document.forms["costo_extra_detalle"].elements["id_costo_extra"].value 			= "";
	document.forms["costo_extra_detalle"].elements["id_responsable_insumo"].value 	= "";
	limpiaCamposCostoExtraDetalle();
	activaCamposCostoExtraDetalle();
	activaBtnCostoExtraDetalle();
	// limpia tabla de costo extra detalle
	document.getElementById("div_tabla_costo_extra_tipo_trabajo").innerHTML = "<table><tr><th>Id.<\/th><th>Costo Extra<\/th><th>Responsable<\/th><th>Cantidad<\/th><th>Especificaci&oacute;n<\/th></tr><tr class=\"l1\"><td><\/td><td><\/td><td><\/td><td><\/td><td><\/td><\/tr><\/table>";
} // limpiaFormCostoExtraDetalle


function activaCamposCostoExtraDetalle() {
	document.forms["costo_extra_detalle"].elements["select_costo_extra"].disabled 			= false;
	document.forms["costo_extra_detalle"].elements["select_responsable_insumo"].disabled 	= false;
	document.forms["costo_extra_detalle"].elements["cantidad"].readOnly 					= false;
	document.forms["costo_extra_detalle"].elements["especificacion"].readOnly 				= false;
} // activaCamposCostoExtraDetalle

function desactivaCamposCostoExtraDetalle() {
	document.forms["costo_extra_detalle"].elements["select_costo_extra"].disabled 			= true;
	document.forms["costo_extra_detalle"].elements["select_responsable_insumo"].disabled 	= true;
	document.forms["costo_extra_detalle"].elements["cantidad"].readOnly 					= true;
	document.forms["costo_extra_detalle"].elements["especificacion"].readOnly 				= true;
} // desactivaCamposCostoExtraDetalle

function activaBtnCostoExtraDetalle() {
	document.getElementById("imgBtnLimpiarCostoExtraDetalleInactivo").style.display = "none";
	document.getElementById("imgBtnAgregarCostoExtraDetalleInactivo").style.display = "none";
	document.getElementById("imgBtnLimpiarCostoExtraDetalleActivo").style.display   = "inline";
	document.getElementById("imgBtnAgregarCostoExtraDetalleActivo").style.display   = "inline";
} // activaBtnCostoExtraDetalle

function desactivaBtnCostoExtraDetalle() {
	document.getElementById("imgBtnLimpiarCostoExtraDetalleActivo").style.display   = "none";
	document.getElementById("imgBtnAgregarCostoExtraDetalleActivo").style.display   = "none";
	document.getElementById("imgBtnLimpiarCostoExtraDetalleInactivo").style.display = "inline";
	document.getElementById("imgBtnAgregarCostoExtraDetalleInactivo").style.display = "inline";
} // desactivaBtnCostoExtraDetalle





//************************/
// disenio

function activaCamposDisenio() {
    document.forms["disenio"].elements["indicacion_tarea_realizar"].readOnly    = false;
    document.forms["disenio"].elements["materiales_recibe"].readOnly            = false;
    document.forms["disenio"].elements["observaciones"].readOnly                = false;
} // activaCamposDisenio()

function desactivaCamposDisenio() {
    document.forms["disenio"].elements["indicacion_tarea_realizar"].readOnly    = true;
    document.forms["disenio"].elements["materiales_recibe"].readOnly            = true;
    document.forms["disenio"].elements["observaciones"].readOnly                = true;
} // desactivaCamposDisenio()



function activaBtnDisenio() {
    document.getElementById("imgBtnLimpiarDisenioInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarDisenioInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarDisenioActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarDisenioActivo").style.display     = "inline";
} // activaBotonesDisenio()

function desactivaBtnDisenio() {
    document.getElementById("imgBtnAgregarDisenioActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarDisenioActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarDisenioInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarDisenioInactivo").style.display   = "inline";
} // desactivaBtnDisenio()



function limpiaCamposFormDisenio() {
    // limpia datos externos
    document.forms["disenio"].elements["indicacion_tarea_realizar"].value   = "";
    document.forms["disenio"].elements["materiales_recibe"].value           = "";
    document.forms["disenio"].elements["observaciones"].value               = "";
    document.forms["disenio"].elements["indicacion_tarea_realizar"].focus();
} // limpiaCamposFormDisenio()


function limpiaFormDisenio() {
    // limpia datos internos
    document.forms["disenio"].elements["id_partida"].value = "";
    limpiaCamposFormDisenio();
    activaCamposDisenio();
    activaBtnDisenio();
    
} // limpiaFormDisenio()





//************************/
// disenio detalle

function activaCamposDisenioDetalle() {
    document.forms["disenio_detalle"].elements["select_proceso_disenio"].disabled   = false;
    document.forms["disenio_detalle"].elements["cantidad"].readOnly                 = false;
    document.forms["disenio_detalle"].elements["precio_total_pesos"].readOnly       = false;
    document.forms["disenio_detalle"].elements["especificaciones"].disabled         = false;
} // activaCamposDisenioDetalle()

function desactivaCamposDisenioDetalle() {
    document.forms["disenio_detalle"].elements["select_proceso_disenio"].disabled   = true;
    document.forms["disenio_detalle"].elements["cantidad"].readOnly                 = true;
    document.forms["disenio_detalle"].elements["precio_total_pesos"].readOnly       = true;
    document.forms["disenio_detalle"].elements["especificaciones"].disabled         = true;
}



function activaBtnDisenioDetalle() {
    document.getElementById("imgBtnLimpiarDisenioDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarDisenioDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnLimpiarDisenioDetalleActivo").style.display     = "inline";
    document.getElementById("imgBtnAgregarDisenioDetalleActivo").style.display     = "inline";
} // activaBotonesDisenioDetalle()

function desactivaBtnDisenioDetalle() {
    document.getElementById("imgBtnLimpiarDisenioDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarDisenioDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarDisenioDetalleInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarDisenioDetalleInactivo").style.display   = "inline";
}

function limpiaCamposFormDisenioDetalle() {
    // limpia datos externos
    document.forms["disenio_detalle"].elements["select_proceso_disenio"].selectedIndex  = "-1";
    document.forms["disenio_detalle"].elements["detalle"].value                         = "";
    document.forms["disenio_detalle"].elements["cantidad"].value                        = "";
    document.forms["disenio_detalle"].elements["precio_total_pesos"].value              = "";
    document.forms["disenio_detalle"].elements["especificaciones"].value                = "";
    document.forms["disenio_detalle"].elements["select_proceso_disenio"].focus();
} // limpiaCamposFormDisenioDetalle()

function limpiaFormDisenioDetalle() {
    // limpia datos internos
    document.forms["disenio_detalle"].elements["id_disenio"].value          = "";
    document.forms["disenio_detalle"].elements["id_proceso_disenio"].value  = "";
    // inicializa select
    $("[name='select_proceso_disenio']").empty();
    var jsonObject = JSON.parse( strJsonListaProcesoDisenio );
    $.each( jsonObject, function(i, item){
        var option = document.createElement("option");
        option.value    = item.value;
        option.text     = item.text;
        document.getElementById("select_proceso_disenio").add( option );
        delete option;
    });
    jsonObject = null;
    // limpia tabla
    document.getElementById("div_tabla_disenio_detalle").innerHTML = "<table><tr><th>No.<\/th><th>Descripci&oacute;n<\/th><th>Cantidad<\/th><th>Especificaci&oacute;n<\/th><\/tr><tr class=\"l1\"><td><\/td><td><\/td><td><\/td><td><\/td><\/tr><\/table>";
    
    limpiaCamposFormDisenioDetalle();
    desactivaCamposDisenioDetalle();
    desactivaBtnDisenioDetalle();
} // limpiaFormDetalleDisenio()





//************************/
// preprensa

function activaCamposPreprensa() {
    document.forms["preprensa"].elements["indicacion_tarea_realizar"].readOnly  = false;
    document.forms["preprensa"].elements["materiales_recibe"].readOnly          = false;
    document.forms["preprensa"].elements["observaciones"].readOnly              = false;
} // activaCamposPreprensa()

function desactivaCamposPreprensa() {
    document.forms["preprensa"].elements["indicacion_tarea_realizar"].readOnly  = true;
    document.forms["preprensa"].elements["materiales_recibe"].readOnly          = true;
    document.forms["preprensa"].elements["observaciones"].readOnly              = true;
} // desactivaCamposPreprensa()



function activaBtnPreprensa() {
    document.getElementById("imgBtnLimpiarPreprensaInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarPreprensaInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarPreprensaActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarPreprensaActivo").style.display     = "inline";
} // activaBotonesPreprensa()

function desactivaBtnPreprensa() {
    document.getElementById("imgBtnAgregarPreprensaActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarPreprensaActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarPreprensaInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarPreprensaInactivo").style.display   = "inline";
} // desactivaBtnPreprensa()



function limpiaCamposFormPreprensa() {
    // limpia datos externos
    document.forms["preprensa"].elements["indicacion_tarea_realizar"].value = "";
    document.forms["preprensa"].elements["materiales_recibe"].value         = "";
    document.forms["preprensa"].elements["observaciones"].value             = "";
    document.forms["preprensa"].elements["indicacion_tarea_realizar"].focus();
} // limpiaCamposFormPreprensa();

function limpiaFormPreprensa() {
    // limpia datos internos
    document.forms["preprensa"].elements["id_partida"].value = "";
    limpiaCamposFormPreprensa();
    activaCamposPreprensa();
    activaBtnPreprensa();
} // limpiaFormPreprensa()





//************************/
// preprensa_detalle

function activaCamposPreprensaDetalle() {
    document.forms["preprensa_detalle"].elements["select_proceso_preprensa"].disabled   = false;
    document.forms["preprensa_detalle"].elements["cantidad"].readOnly                   = false;
    document.forms["preprensa_detalle"].elements["precio_total_pesos"].readOnly         = false;
    document.forms["preprensa_detalle"].elements["especificaciones"].disabled           = false;
} // activaCamposPreprensaDetalle();

function desactivaCamposPreprensaDetalle() {
    document.forms["preprensa_detalle"].elements["select_proceso_preprensa"].disabled   = true;
    document.forms["preprensa_detalle"].elements["cantidad"].readOnly                   = true;
    document.forms["preprensa_detalle"].elements["precio_total_pesos"].readOnly         = true;
    document.forms["preprensa_detalle"].elements["especificaciones"].disabled           = true;
} // desactivaCamposPreprensaDetalle();



function activaBtnPreprensaDetalle() {
    document.getElementById("imgBtnLimpiarPreprensaDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarPreprensaDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnLimpiarPreprensaDetalleActivo").style.display     = "inline";
    document.getElementById("imgBtnAgregarPreprensaDetalleActivo").style.display     = "inline";
} // activaBtnPreprensaDetalle()

function desactivaBtnPreprensaDetalle() {
    document.getElementById("imgBtnLimpiarPreprensaDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarPreprensaDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarPreprensaDetalleInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarPreprensaDetalleInactivo").style.display   = "inline";
} // activaBtnPreprensaDetalle()



function limpiaCamposFormPreprensaDetalle() {
    // limpia datos externos
    document.forms["preprensa_detalle"].elements["select_proceso_preprensa"].selectedIndex  = "-1";
    document.forms["preprensa_detalle"].elements["detalle"].value                           = "";
    document.forms["preprensa_detalle"].elements["cantidad"].value                          = "";
    document.forms["preprensa_detalle"].elements["precio_total_pesos"].value                = "";
    document.forms["preprensa_detalle"].elements["especificaciones"].value                  = "";
    document.forms["preprensa_detalle"].elements["select_proceso_preprensa"].focus();
} // limpiaCamposFormPreprensaDetalle

function limpiaFormPreprensaDetalle() {
    // limpia campos internos
    document.forms["preprensa_detalle"].elements["id_preprensa"].value          = "";
    document.forms["preprensa_detalle"].elements["id_proceso_preprensa"].value  = "";
    // inicializa select
    $("[name='select_proceso_preprensa']").empty();
    var jsonObject = JSON.parse( strJsonListaProcesoPreprensa );
    $.each( jsonObject, function(i, item){
        var option = document.createElement("option");
        option.value    = item.value;
        option.text     = item.text;
        document.getElementById("select_proceso_preprensa").add( option );
        delete option;
    });
    jsonObject = null;
    // limpia tabla
    document.getElementById("div_tabla_preprensa_detalle").innerHTML    = "<table><tbody><tr><th>No.<\/th><th>Descripci&oacute;n<\/th><th>Cantidad<\/th><th>Especificaci&oacute;n<\/th><\/tr><tr class=\"l1\"><td><\/td><td><\/td><td><\/td><td><\/td><\/tr><\/tbody><\/table>";
    
    limpiaCamposFormPreprensaDetalle();
    desactivaCamposPreprensaDetalle();
    desactivaBtnPreprensaDetalle();
} // limpiaFormPreprensaDetalle





//************************/
// transporte

function activaCamposTransporte() {
    document.forms["transporte"].elements["indicacion_tarea_realizar"].readOnly = false;
    document.forms["transporte"].elements["materiales_recibe"].readOnly         = false;
    document.forms["transporte"].elements["observaciones"].readOnly             = false;
} // activaCamposTransporte()

function desactivaCamposTransporte() {
    document.forms["transporte"].elements["indicacion_tarea_realizar"].readOnly = true;
    document.forms["transporte"].elements["materiales_recibe"].readOnly         = true;
    document.forms["transporte"].elements["observaciones"].readOnly             = true;
} // desactivaCamposTransporte()



function activaBtnTransporte() {
    document.getElementById("imgBtnLimpiarTransporteInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarTransporteInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarTransporteActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarTransporteActivo").style.display     = "inline";
} // activaBotonesTransporte()

function desactivaBtnTransporte() {
    document.getElementById("imgBtnAgregarTransporteActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarTransporteActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarTransporteInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarTransporteInactivo").style.display   = "inline";
} // desactivaBtnTransporte()



function limpiaCamposFormTransporte() {
    // limpia datos externos
    document.forms["transporte"].elements["indicacion_tarea_realizar"].value    = "";
    document.forms["transporte"].elements["materiales_recibe"].value            = "";
    document.forms["transporte"].elements["observaciones"].value                = "";
    document.forms["transporte"].elements["indicacion_tarea_realizar"].focus();
} // limpiaCamposFormTransporte();

function limpiaFormTransporte() {
    // limpia datos internos
    document.forms["transporte"].elements["id_partida"].value = "";
    limpiaCamposFormTransporte();
    activaCamposTransporte();
    activaBtnTransporte();
} // limpiaFormTransporte()





//************************/
// transporte detalle

function activaCamposTransporteDetalle() {
    document.forms["transporte_detalle"].elements["select_proceso_transporte"].disabled = false;
    document.forms["transporte_detalle"].elements["cantidad"].readOnly                  = false;
    document.forms["transporte_detalle"].elements["precio_total_pesos"].readOnly        = false;
    document.forms["transporte_detalle"].elements["especificaciones"].disabled          = false;
} // activaCamposTransporteDetalle()

function desactivaCamposTransporteDetalle() {
    document.forms["transporte_detalle"].elements["select_proceso_transporte"].disabled = true;
    document.forms["transporte_detalle"].elements["cantidad"].readOnly                  = true;
    document.forms["transporte_detalle"].elements["precio_total_pesos"].readOnly        = true;
    document.forms["transporte_detalle"].elements["especificaciones"].disabled          = true;
} // desactivaCamposTransporteDetalle()



function activaBtnTransporteDetalle() {
    document.getElementById("imgBtnLimpiarTransporteDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarTransporteDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnLimpiarTransporteDetalleActivo").style.display     = "inline";
    document.getElementById("imgBtnAgregarTransporteDetalleActivo").style.display     = "inline";
} // activaBotonesTransporteDetalle()

function desactivaBtnTransporteDetalle() {
    document.getElementById("imgBtnLimpiarTransporteDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarTransporteDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarTransporteDetalleInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarTransporteDetalleInactivo").style.display   = "inline";
} // desctivaBtnTransporteDetalle()



function limpiaCamposFormTransporteDetalle() {
    // limpia datos externos
    document.forms["transporte_detalle"].elements["select_proceso_transporte"].selectedIndex    = "-1";
    document.forms["transporte_detalle"].elements["detalle"].value                              = "";
    document.forms["transporte_detalle"].elements["cantidad"].value                             = "";
    document.forms["transporte_detalle"].elements["precio_total_pesos"].value                   = "";
    document.forms["transporte_detalle"].elements["especificaciones"].value                     = "";
    document.forms["transporte_detalle"].elements["select_proceso_transporte"].focus();
}

function limpiaFormTransporteDetalle() {
    // limpia datos internos
    document.forms["transporte_detalle"].elements["id_transporte"].value            = "";
    document.forms["transporte_detalle"].elements["id_proceso_transporte"].value    = "";
    // inicializa select
    $("[name='select_proceso_transporte']").empty();
    jsonObject = JSON.parse( strJsonListaProcesoTransporte );
    $.each( jsonObject, function(i, item){
        var option = document.createElement("option");
        option.value    = item.value;
        option.text     = item.text;
        document.getElementById("select_proceso_transporte").add( option );
        delete option;
    });
    jsonObject = null;
    // limpia tabla
    document.getElementById("div_tabla_transporte_detalle").innerHTML = "<table><tbody><tr><th>No.<\/th><th>Descripci&oacute;n<\/th><th>Cantidad<\/th><th>Especificaci&oacute;n<\/th><\/tr><tr class=\"l1\"><td><\/td><td><\/td><td><\/td><td><\/td><\/tr><\/tbody><\/table>";
    
    limpiaCamposFormTransporteDetalle();
    desactivaCamposTransporteDetalle();
    desactivaBtnTransporteDetalle();
} // limpiaFormDetalleTransporte()





//************************/
// acabado

function activaCamposAcabado() {
    document.forms["acabado"].elements["indicacion_tarea_realizar"].readOnly    = false;
    document.forms["acabado"].elements["materiales_recibe"].readOnly            = false;
    document.forms["acabado"].elements["observaciones"].readOnly                = false;
} // activaCamposAcabado()

function desactivaCamposAcabado() {
    document.forms["acabado"].elements["indicacion_tarea_realizar"].readOnly    = true;
    document.forms["acabado"].elements["materiales_recibe"].readOnly            = true;
    document.forms["acabado"].elements["observaciones"].readOnly                = true;
} // desactivaCamposAcabado()



function activaBtnAcabado() {
    document.getElementById("imgBtnLimpiarAcabadoInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarAcabadoInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarAcabadoActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarAcabadoActivo").style.display     = "inline";
} // activaBotonesAcabado()

function desactivaBtnAcabado() {
    document.getElementById("imgBtnAgregarAcabadoActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarAcabadoActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarAcabadoInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarAcabadoInactivo").style.display   = "inline";
} // desactivaBtnAcabado()



function limpiaCamposFormAcabado() {
    // limpia datos externos
    document.forms["acabado"].elements["indicacion_tarea_realizar"].value   = "";
    document.forms["acabado"].elements["materiales_recibe"].value           = "";
    document.forms["acabado"].elements["observaciones"].value               = "";
    document.forms["acabado"].elements["indicacion_tarea_realizar"].focus();
} // limpiaCamposFormAcabado();

function limpiaFormAcabado() {
    // limpia datos internos
    document.forms["acabado"].elements["id_partida"].value = "";
    limpiaCamposFormAcabado();
    activaCamposAcabado();
    activaBtnAcabado();
} // limpiaFormAcabado()





//************************/
// acabado detalle

function activaCamposAcabadoDetalle() {
    document.forms["acabado_detalle"].elements["select_proceso_externo"].disabled   = false;
    document.forms["acabado_detalle"].elements["ancho"].readOnly                    = false;
    document.forms["acabado_detalle"].elements["alto"].readOnly                     = false;
    document.forms["acabado_detalle"].elements["cantidad_proceso_externo"].readOnly = false;
    document.forms["acabado_detalle"].elements["precio_total_pesos"].readOnly       = false;
    document.forms["acabado_detalle"].elements["especificaciones"].disabled         = false;
} // activaCamposAcabadoDetalle()

function desactivaCamposAcabadoDetalle() {
    document.forms["acabado_detalle"].elements["select_proceso_externo"].disabled   = true;
    document.forms["acabado_detalle"].elements["ancho"].readOnly                    = true;
    document.forms["acabado_detalle"].elements["alto"].readOnly                     = true;
    document.forms["acabado_detalle"].elements["cantidad_proceso_externo"].readOnly = true;
    document.forms["acabado_detalle"].elements["precio_total_pesos"].readOnly       = true;
    document.forms["acabado_detalle"].elements["especificaciones"].disabled         = true;
} // desactivaCamposAcabadoDetalle()



function activaBtnAcabadoDetalle() {
    document.getElementById("imgBtnLimpiarAcabadoDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarAcabadoDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnLimpiarAcabadoDetalleActivo").style.display     = "inline";
    document.getElementById("imgBtnAgregarAcabadoDetalleActivo").style.display     = "inline";
} // activaBotonesAcabadoDetalle()

function desactivaBtnAcabadoDetalle() {
    document.getElementById("imgBtnLimpiarAcabadoDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarAcabadoDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarAcabadoDetalleInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarAcabadoDetalleInactivo").style.display   = "inline";
} // desactivaBtnAcabadoDetalle()



function limpiaCamposFormAcabadoDetalle() {
    // limpia datos externos
    document.forms["acabado_detalle"].elements["select_proceso_externo"].selectedIndex  = "-1";
    document.forms["acabado_detalle"].elements["detalle"].value                         = "";
    document.forms["acabado_detalle"].elements["ancho"].value                           = "";
    document.forms["acabado_detalle"].elements["alto"].value                            = "";
    document.forms["acabado_detalle"].elements["cantidad_proceso_externo"].value        = "";
    document.forms["acabado_detalle"].elements["precio_total_pesos"].value              = "";
    document.forms["acabado_detalle"].elements["especificaciones"].value                = "";
    document.forms["acabado_detalle"].elements["select_proceso_externo"].focus();
} // limpiaCamposFormAcabadoDetalle();

function limpiaFormAcabadoDetalle() {
    // limpia datos internos
    document.forms["acabado_detalle"].elements["id_acabado"].value          = "";
    document.forms["acabado_detalle"].elements["id_proceso_externo"].value  = "";
    // inicializa select
    $("[name='select_proceso_externo']").empty();
    jsonObject = JSON.parse( strJsonListaProcesoExterno );
    $.each( jsonObject, function(i, item){
        var option = document.createElement("option");
        option.value    = item.value;
        option.text     = item.text;
        document.getElementById("select_proceso_externo").add( option );
        delete option;
    });
    jsonObject = null;
    // limpia tabla
    document.getElementById("div_tabla_acabado_detalle").innerHTML = "<table><tbody><tr><th>No.<\/th><th>Descripci&oacute;n<\/th><th>Cantidad<\/th><th>Especificaci&oacute;n<\/th><\/tr><tr class=\"l1\"><td><\/td><td><\/td><td><\/td><td><\/td><\/tr><\/tbody><\/table>";
    
    limpiaCamposFormAcabadoDetalle();
    desactivaCamposAcabadoDetalle();
    desactivaBtnAcabadoDetalle();
} // limpiaFormAcabadoDetalle()





//************************/
// offset

function activaCamposOffset() {
    document.forms["offset"].elements["indicacion_tarea_realizar"].disabled = false;
    document.forms["offset"].elements["materiales_recibe"].disabled         = false;
    document.forms["offset"].elements["observaciones"].disabled             = false;
} // activaCamposOffset()

function desactivaCamposOffset() {
    document.forms["offset"].elements["indicacion_tarea_realizar"].disabled = true;
    document.forms["offset"].elements["materiales_recibe"].disabled         = true;
    document.forms["offset"].elements["observaciones"].disabled             = true;
} // desactivaCamposOffset()



function activaBtnOffset() {
    document.getElementById("imgBtnLimpiarOffsetInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarOffsetInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarOffsetActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarOffsetActivo").style.display     = "inline";
} // activaBotonesOffset()

function desactivaBtnOffset() {
    document.getElementById("imgBtnAgregarOffsetActivo").style.display      = "none";
    document.getElementById("imgBtnLimpiarOffsetActivo").style.display      = "none";
    document.getElementById("imgBtnLimpiarOffsetInactivo").style.display    = "inline";
    document.getElementById("imgBtnAgregarOffsetInactivo").style.display    = "inline";
} // desactivaBtnOffset()



function limpiaCamposFormOffset() {
    // limpia datos externos
    document.forms["offset"].elements["indicacion_tarea_realizar"].value    = "";
    document.forms["offset"].elements["materiales_recibe"].value            = "";
    document.forms["offset"].elements["observaciones"].value                = "";
    document.forms["offset"].elements["indicacion_tarea_realizar"].focus();
}

function limpiaFormOffset() {
    // limpia datos internos 
    document.forms["offset"].elements["id_partida"].value = "";
    limpiaCamposFormOffset();
    activaCamposOffset();
    activaBtnOffset();
} // limpiaFormOffset()





//************************/
// material ayuda

function activaCamposMaterialAyuda() {
    document.forms["material_ayuda"].elements["select_material_ayuda"].disabled     = false;
    document.forms["material_ayuda"].elements["select_responsable_insumo"].disabled = false;
    document.forms["material_ayuda"].elements["observaciones"].readOnly             = false;
} // activaCamposMaterialAyuda()

function desactivaCamposMaterialAyuda() {
    document.forms["material_ayuda"].elements["select_material_ayuda"].disabled     = true;
    document.forms["material_ayuda"].elements["select_responsable_insumo"].disabled = true;
    document.forms["material_ayuda"].elements["observaciones"].readOnly             = true;
} // desactivaCamposMaterialAyuda()



function activaBtnMaterialAyuda() {
    document.getElementById("imgBtnLimpiarMatAyudaInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarMatAyudaInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarMatAyudaActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarMatAyudaActivo").style.display     = "inline";
} // activaBtnMaterialAyuda()

function desactivaBtnMaterialAyuda() {
    document.getElementById("imgBtnAgregarMatAyudaActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarMatAyudaActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarMatAyudaInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarMatAyudaInactivo").style.display   = "inline";
}// desactivaBtnMaterialAyuda()



function limpiaCamposFormMaterialAyuda() {
    // limpia datos externos
    document.forms["material_ayuda"].elements["select_responsable_insumo"].selectedIndex    = 0;
    document.forms["material_ayuda"].elements["observaciones"].value                        = "";
} // limpiaCamposFormMaterialAyuda();

function limpiaFormMaterialAyuda() {
    // limpia datos internos
    document.forms["material_ayuda"].elements["id_partida"].value               = "";
    document.forms["material_ayuda"].elements["id_material_ayuda"].value        = "";
    document.forms["material_ayuda"].elements["id_responsable_insumo"].value    = "";
    // inicializa select
    $("[name='select_material_ayuda']").empty();
    jsonObject = JSON.parse( strJsonListaMaterialAyuda );
    $.each( jsonObject, function(i, item){
        var option = document.createElement("option");
        option.value    = item.value;
        option.text     = item.text;
        document.getElementById("select_material_ayuda").add( option );
        delete option;
    });
    delete jsonObject;
    // limpia tabla
    document.getElementById("div_tabla_material_ayuda").innerHTML = "<table id=\"tabla_material_ayuda\"><tbody><tr><th>No.<\/th><th>Material<\/th><th>Responsable<\/th><th>Observaciones<\/th><\/tr><tr class=\"l1\"><td><\/td><td><\/td><td><\/td><td><\/td><\/tr><\/tbody><\/table>";
    
    limpiaCamposFormMaterialAyuda();
    activaCamposMaterialAyuda();
    activaBtnMaterialAyuda();
} // limpiaFormMatAyuda()






//*******************************************************************************************************************/

