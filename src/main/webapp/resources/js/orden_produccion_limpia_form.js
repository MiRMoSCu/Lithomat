
// limpia formularios

function limpiaFormCliente() {
    document.cliente.nombre_moral.value           = "";
    document.cliente.id_cliente.value             = "";
    document.cliente.clave.value                  = "";
    document.cliente.nombre_representante.value   = "";
    document.cliente.calle.value                  = "";
    document.cliente.num_exterior.value           = "";
    document.cliente.num_interior.value           = "";
    document.cliente.colonia.value                = "";
    document.cliente.delegacion_municipio.value   = "";
    document.cliente.estado.value                 = "";
    document.cliente.codigo_postal.value          = "";
    document.cliente.rfc.value                    = "";
    document.cliente.telefono_particular.value    = "";
    document.cliente.telefono_movil.value         = "";
    document.cliente.observaciones.value          = "";
    document.cliente.select_search.options[0].selected = true;
    document.cliente.id_cliente.focus();
}





//************************/
// orden de produccion

function limpiaCamposFormOrdenProduccion() {
    // limpia datos externos
    document.orden_produccion.nombre.value                              = "";
    document.orden_produccion.descripcion.value                         = "";
    document.orden_produccion.select_comprobante_fiscal.selectedIndex	= 0;
    document.orden_produccion.fecha_prometida_entrega.value             = "";
    document.orden_produccion.nombre.focus();
}

function limpiaFormOrdenProduccion() {
    // limpia campos ocultos
	document.orden_produccion.id_orden_produccion.value			= "";
    document.orden_produccion.id_usuario.value                 	= "";
    document.orden_produccion.id_cliente.value                 	= "";
    document.orden_produccion.id_tipo_comprobante_fiscal.value 	= "";
    limpiaCamposFormOrdenProduccion();
}


function activaCamposOrdenProduccion() {
    document.orden_produccion.nombre.readOnly                      = false;
    document.orden_produccion.descripcion.readOnly                 = false;
    document.orden_produccion.select_comprobante_fiscal.disabled   = false;
    document.orden_produccion.fecha_prometida_entrega.readOnly     = false;
}


function desactivaCamposOrdenProduccion() {
    document.orden_produccion.nombre.readOnly                      = true;
    document.orden_produccion.descripcion.readOnly                 = true;
    document.orden_produccion.select_comprobante_fiscal.disabled   = true;
    document.orden_produccion.fecha_prometida_entrega.readOnly     = true;
}


function activaBtnOrdenProduccion() {
    document.getElementById("imgBtnAgregarOrdnProdInactivo").style.display  = "none";
    document.getElementById("imgBtnLimpiarOrdnProdInactivo").style.display  = "none";
    document.getElementById("imgBtnAgregarOrdnProdActivo").style.display    = "inline";
    document.getElementById("imgBtnLimpiarOrdnProdActivo").style.display    = "inline";
}


function desactivaBtnOrdenProduccion() {
    document.getElementById("imgBtnAgregarOrdnProdActivo").style.display    = "none";
    document.getElementById("imgBtnLimpiarOrdnProdActivo").style.display    = "none";
    document.getElementById("imgBtnAgregarOrdnProdInactivo").style.display  = "inline";
    document.getElementById("imgBtnLimpiarOrdnProdInactivo").style.display  = "inline";
}





//************************/
// partida

function limpiaCamposFormPartida() {
    // limpia campos externos
    document.partida.tipo_trabajo[0].click();
    document.partida.nombre_partida.value                  = "";
    document.partida.cantidad.value                        = "";
    document.partida.select_forma_trabajo.selectedIndex    = 0;
    document.partida.descripcion_partida.value             = "";
    document.partida.diagrama_formacion.value              = "";
    document.partida.observaciones_generales.value         = "";
    document.partida.observaciones_aprobacion.value        = "";
    document.partida.nombre_partida.focus();
}


function limpiaFormPartida() {
    // limpia campos ocultos
	document.partida.id_partida.value				= "";
    document.partida.id_orden_produccion.value     	= "";
    document.partida.id_tipo_trabajo.value         	= "";
    document.partida.id_tipo_forma_trabajo.value   	= "";
    limpiaCamposFormPartida();
    activaCamposPartida();
    activaBtnPartida();
}


function activaCamposPartida() {
    document.partida.tipo_trabajo[0].disabled          = false;
    document.partida.tipo_trabajo[1].disabled          = false;
    document.partida.tipo_trabajo[2].disabled          = false;
    document.partida.nombre_partida.readOnly           = false;
    document.partida.cantidad.readOnly                 = false;
    document.partida.select_forma_trabajo.disabled     = false;
    document.partida.descripcion_partida.readOnly      = false;
    document.partida.diagrama_formacion.disabled       = false;
    document.partida.observaciones_generales.readOnly  = false;
    document.partida.observaciones_aprobacion.readOnly = false;
}


function desactivaCamposPartida() {
    document.partida.tipo_trabajo[0].disabled          = true;
    document.partida.tipo_trabajo[1].disabled          = true;
    document.partida.tipo_trabajo[2].disabled          = true;
    document.partida.nombre_partida.readOnly           = true;
    document.partida.cantidad.readOnly                 = true;
    document.partida.select_forma_trabajo.disabled     = true;
    document.partida.descripcion_partida.readOnly      = true;
    document.partida.observaciones_generales.readOnly  = true;
    document.partida.observaciones_aprobacion.readOnly = true;
}


function activaBtnPartida() {
    document.getElementById("imgBtnAgregarPartidaInactivo").style.display   = "none";
    document.getElementById("imgBtnLimpiarPartidaInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarPartidaActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarPartidaActivo").style.display     = "inline";
}


function desactivaBtnPartida() {
    document.getElementById("imgBtnAgregarPartidaActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarPartidaActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarPartidaInactivo").style.display   = "inline";
    document.getElementById("imgBtnLimpiarPartidaInactivo").style.display   = "inline";
}





//************************/
// detalle partida

function limpiaCamposFormTipoTrabajoDetalle() {
    // limpia campos externos
    document.tipo_trabajo_detalle.descripcion_partida_detalle.value                	= "";
    document.tipo_trabajo_detalle.alto_final.value                                 	= "";
    document.tipo_trabajo_detalle.ancho_final.value                                	= "";
    document.tipo_trabajo_detalle.alto_extendido.value                             	= "";
    document.tipo_trabajo_detalle.ancho_extendido.value                            	= "";
    document.tipo_trabajo_detalle.proporciona_papel.checked                        	= false;
    document.tipo_trabajo_detalle.proporciona_tinta_especial.checked               	= false;
    document.tipo_trabajo_detalle.proporciona_barniz.checked                       	= false;
    document.tipo_trabajo_detalle.proporciona_placas.checked                       	= false;
    document.tipo_trabajo_detalle.tipo_papel_extendido.value                      	= "";
    document.tipo_trabajo_detalle.repeticiones_x_pliego.value                      	= "";
    document.tipo_trabajo_detalle.numero_paginas_publicacion.value                 	= 0;
    document.tipo_trabajo_detalle.alto_corte_inicial.value                 			= 0;
    document.tipo_trabajo_detalle.ancho_corte_inicial.value                 		= 0;
    document.tipo_trabajo_detalle.select_tamanio_publicacion.selectedIndex         	= 0;
    document.tipo_trabajo_detalle.select_frente_combinacion_tintas.selectedIndex 	= 0;
    document.tipo_trabajo_detalle.frente_num_tinta_especial.value                  	= 0;
    document.tipo_trabajo_detalle.select_frente_tipo_barniz.selectedIndex          	= 0;
    document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value          	= "";
    document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.selectedIndex   	= 0;
    document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value                  	= 0;
    document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.selectedIndex          	= 0;
    document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value          	= "";
    document.tipo_trabajo_detalle.select_maquina.selectedIndex                     	= 0;
    document.tipo_trabajo_detalle.select_tipo_placa.selectedIndex                  	= 0;
    document.tipo_trabajo_detalle.select_tipo_complejidad.selectedIndex            	= 0;
    document.tipo_trabajo_detalle.descripcion_partida_detalle.focus();
}


function limpiaFormTipoTrabajoDetalle() {
    // limpia campos ocultos
	document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value 			= "";
    document.tipo_trabajo_detalle.id_partida.value                         	= "";
    document.tipo_trabajo_detalle.cliente_proporciona_papel.value          	= "";
    document.tipo_trabajo_detalle.cliente_proporciona_tinta.value          	= "";
    document.tipo_trabajo_detalle.cliente_proporciona_tinta_especial.value 	= "";
    document.tipo_trabajo_detalle.cliente_proporciona_barniz.value         	= "";
    document.tipo_trabajo_detalle.cliente_proporciona_placas.value         	= "";
    document.tipo_trabajo_detalle.id_tipo_papel_extendido.value            	= "";
    document.tipo_trabajo_detalle.id_tamanio_publicacion.value             	= "";
    document.tipo_trabajo_detalle.frente_id_combinacion_tintas.value       	= "";
    document.tipo_trabajo_detalle.frente_id_tipo_barniz.value              	= "";
    document.tipo_trabajo_detalle.vuelta_id_combinacion_tintas.value       	= "";
    document.tipo_trabajo_detalle.vuelta_id_tipo_barniz.value              	= "";
    document.tipo_trabajo_detalle.id_maquina.value                         	= "";
    document.tipo_trabajo_detalle.id_tipo_placa.value                      	= "";
    document.tipo_trabajo_detalle.id_tipo_complejidad.value                	= "";
    limpiaCamposFormTipoTrabajoDetalle();
    activaCamposTipoTrabajoDetalle();
    activaBtnTipoTrabajoDetalle();
}


function activaCamposTipoTrabajoDetalle() {
    document.tipo_trabajo_detalle.descripcion_partida_detalle.readOnly         	= false;
    document.tipo_trabajo_detalle.alto_final.readOnly                          	= false;
    document.tipo_trabajo_detalle.ancho_final.readOnly                         	= false;
    document.tipo_trabajo_detalle.alto_extendido.readOnly                      	= false;
    document.tipo_trabajo_detalle.ancho_extendido.readOnly                     	= false;
    document.tipo_trabajo_detalle.proporciona_papel.disabled                   	= false;
    document.tipo_trabajo_detalle.proporciona_tinta_especial.disabled          	= false;
    document.tipo_trabajo_detalle.proporciona_barniz.disabled                  	= false;
    document.tipo_trabajo_detalle.proporciona_placas.disabled                  	= false;
    document.tipo_trabajo_detalle.repeticiones_x_pliego.readOnly               	= false;
    document.tipo_trabajo_detalle.numero_paginas_publicacion.readOnly          	= false;
    document.tipo_trabajo_detalle.alto_corte_inicial.readOnly          			= false;
    document.tipo_trabajo_detalle.ancho_corte_inicial.readOnly          		= false;
    document.tipo_trabajo_detalle.select_tamanio_publicacion.disabled          	= false;
    document.tipo_trabajo_detalle.select_frente_combinacion_tintas.disabled    	= false;
    document.tipo_trabajo_detalle.frente_num_tinta_especial.readOnly           	= false;
    document.tipo_trabajo_detalle.select_frente_tipo_barniz.disabled           	= false;
    document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.readOnly   	= false;
    document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.disabled    	= false;
    document.tipo_trabajo_detalle.vuelta_num_tinta_especial.readOnly           	= false;
    document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.disabled           	= false;
    document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.readOnly   	= false;
    document.tipo_trabajo_detalle.select_maquina.disabled                      	= false;
    document.tipo_trabajo_detalle.select_tipo_placa.disabled                   	= false;
    document.tipo_trabajo_detalle.select_tipo_complejidad.disabled             	= false;
}


function desactivaCamposTipoTrabajoDetalle() {
    document.tipo_trabajo_detalle.descripcion_partida_detalle.readOnly         	= true;
    document.tipo_trabajo_detalle.alto_final.readOnly                          	= true;
    document.tipo_trabajo_detalle.ancho_final.readOnly                         	= true;
    document.tipo_trabajo_detalle.alto_extendido.readOnly                      	= true;
    document.tipo_trabajo_detalle.ancho_extendido.readOnly                     	= true;
    document.tipo_trabajo_detalle.proporciona_papel.disabled                   	= true;
    document.tipo_trabajo_detalle.proporciona_tinta_especial.disabled          	= true;
    document.tipo_trabajo_detalle.proporciona_barniz.disabled                  	= true;
    document.tipo_trabajo_detalle.proporciona_placas.disabled                  	= true;
    document.tipo_trabajo_detalle.repeticiones_x_pliego.readOnly               	= true;
    document.tipo_trabajo_detalle.numero_paginas_publicacion.readOnly          	= true;
    document.tipo_trabajo_detalle.alto_corte_inicial.readOnly          			= true;
    document.tipo_trabajo_detalle.ancho_corte_inicial.readOnly          		= true;
    document.tipo_trabajo_detalle.select_tamanio_publicacion.disabled          	= true;
    document.tipo_trabajo_detalle.select_frente_combinacion_tintas.disabled    	= true;
    document.tipo_trabajo_detalle.frente_num_tinta_especial.readOnly           	= true;
    document.tipo_trabajo_detalle.select_frente_tipo_barniz.disabled           	= true;
    document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.readOnly   	= true;
    document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.disabled    	= true;
    document.tipo_trabajo_detalle.vuelta_num_tinta_especial.readOnly           	= true;
    document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.disabled           	= true;
    document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.readOnly   	= true;
    document.tipo_trabajo_detalle.select_maquina.disabled                      	= true;
    document.tipo_trabajo_detalle.select_tipo_placa.disabled                   	= true;
    document.tipo_trabajo_detalle.select_tipo_complejidad.disabled             	= true;
}


function activaBtnTipoTrabajoDetalle() {
    document.getElementById("imgBtnAgregarDetallePartidaInactivo").style.display    = "none";
    document.getElementById("imgBtnLimpiarDetallePartidaInactivo").style.display    = "none";
    document.getElementById("imgBtnAgregarDetallePartidaActivo").style.display      = "inline";
    document.getElementById("imgBtnLimpiarDetallePartidaActivo").style.display      = "inline";
}


function desactivaBtnTipoTrabajoDetalle() {
    document.getElementById("imgBtnAgregarDetallePartidaActivo").style.display      = "none";
    document.getElementById("imgBtnLimpiarDetallePartidaActivo").style.display      = "none";
    document.getElementById("imgBtnAgregarDetallePartidaInactivo").style.display    = "inline";
    document.getElementById("imgBtnLimpiarDetallePartidaInactivo").style.display    = "inline";
}


//************************/
//descuento

function limpiaCamposDescuento() {
	document.descuento.chkbx_aplica_descuento.checked 			= false;
	document.descuento.select_precio_tabulador.selectedIndex 	= 0;
	document.descuento.precio_tabulador.value 					= "";
	document.descuento.select_tipo_precio.selectedIndex			= 0;
}

function limpiaFormDescuento() {
	document.descuento.aplica_descuento.value 		= "";
	document.descuento.id_tipo_precio.value			= "";
	limpiaCamposDescuento();
	activaCamposDescuento();
	activaBtnDescuento();
}

function activaCamposDescuento() {
	document.descuento.chkbx_aplica_descuento.disabled 		= false;
	document.descuento.select_precio_tabulador.disabled 	= false;
	document.descuento.precio_tabulador.readOnly 			= false;
	document.descuento.select_tipo_precio.disabled 			= false;
}

function desactivaCamposDescuento() {
	document.descuento.chkbx_aplica_descuento.disabled 		= true;
	document.descuento.select_precio_tabulador.disabled 	= true;
	document.descuento.precio_tabulador.readOnly 			= true;
	document.descuento.select_tipo_precio.disabled 			= true;
}

function activaBtnDescuento() {
	document.getElementById("imgBtnLimpiarDescuentoInactivo").style.display = "none";
	document.getElementById("imgBtnAgregarDescuentoInactivo").style.display = "none";
	document.getElementById("imgBtnLimpiarDescuentoActivo").style.display 	= "inline";
	document.getElementById("imgBtnAgregarDescuentoActivo").style.display 	= "inline";
}

function desactivaBtnDescuento() {
	document.getElementById("imgBtnLimpiarDescuentoActivo").style.display 	= "none";
	document.getElementById("imgBtnAgregarDescuentoActivo").style.display 	= "none";
	document.getElementById("imgBtnLimpiarDescuentoInactivo").style.display = "inline";
	document.getElementById("imgBtnAgregarDescuentoInactivo").style.display = "inline";
}



//************************/
//costo_extra_detalle

function limpiaCamposCostoExtraDetalle() {
	document.costo_extra_detalle.select_costo_extra.selectedIndex 			= 0;
	document.costo_extra_detalle.select_responsable_insumo.selectedIndex 	= 0;
	document.costo_extra_detalle.cantidad.value 							= "";
	document.costo_extra_detalle.nombre_unidad_medida.value 				= "";
	document.costo_extra_detalle.especificacion.value 						= "";
	ajaxUnidadCostoExtra();
}

function limpiaFormCostoExtraDetalle() {
	document.costo_extra_detalle.id_tipo_trabajo_detalle.value 	= "";
	document.costo_extra_detalle.id_costo_extra.value 			= "";
	document.costo_extra_detalle.id_responsable_insumo.value 	= "";
	// inicializa select
	$("[name='select_costo_extra']").empty();
    jsonObject = JSON.parse( strJsonListaCostosExtra );
    $.each( jsonObject, function(i, item){
        var option = document.createElement("option");
        option.value    = item.value;
        option.text     = item.text;
        document.getElementById("select_costo_extra").add( option );
        delete option;
    });
    delete jsonObject;
    // limpia tabla de costo extra detalle
	document.getElementById("div_tabla_costo_extra_tipo_trabajo").innerHTML = "<table><tr><th>Id.<\/th><th>Costo Extra<\/th><th>Responsable<\/th><th>Cantidad<\/th><th>Especificaci&oacute;n<\/th></tr><tr class=\"l1\"><td><\/td><td><\/td><td><\/td><td><\/td><td><\/td><\/tr><\/table>";
	limpiaCamposCostoExtraDetalle();
	activaCamposCostoExtraDetalle();
	activaBtnCostoExtraDetalle();
}


function activaCamposCostoExtraDetalle() {
	document.costo_extra_detalle.select_costo_extra.disabled 			= false;
	document.costo_extra_detalle.select_responsable_insumo.disabled 	= false;
	document.costo_extra_detalle.cantidad.readOnly 						= false;
	document.costo_extra_detalle.especificacion.readOnly 				= false;
}

function desactivaCamposCostoExtraDetalle() {
	document.costo_extra_detalle.select_costo_extra.disabled 			= true;
	document.costo_extra_detalle.select_responsable_insumo.disabled 	= true;
	document.costo_extra_detalle.cantidad.readOnly 						= true;
	document.costo_extra_detalle.especificacion.readOnly 				= true;
}

function activaBtnCostoExtraDetalle() {
	document.getElementById("imgBtnLimpiarCostoExtraDetalleInactivo").style.display = "none";
	document.getElementById("imgBtnAgregarCostoExtraDetalleInactivo").style.display = "none";
	document.getElementById("imgBtnLimpiarCostoExtraDetalleActivo").style.display   = "inline";
	document.getElementById("imgBtnAgregarCostoExtraDetalleActivo").style.display   = "inline";
}

function desactivaBtnCostoExtraDetalle() {
	document.getElementById("imgBtnLimpiarCostoExtraDetalleActivo").style.display   = "none";
	document.getElementById("imgBtnAgregarCostoExtraDetalleActivo").style.display   = "none";
	document.getElementById("imgBtnLimpiarCostoExtraDetalleInactivo").style.display = "inline";
	document.getElementById("imgBtnAgregarCostoExtraDetalleInactivo").style.display = "inline";
}





//************************/
// disenio

function activaCamposDisenio() {
    document.disenio.indicacion_tarea_realizar.readOnly    = false;
    document.disenio.materiales_recibe.readOnly            = false;
    document.disenio.observaciones.readOnly                = false;
}

function desactivaCamposDisenio() {
    document.disenio.indicacion_tarea_realizar.readOnly    = true;
    document.disenio.materiales_recibe.readOnly            = true;
    document.disenio.observaciones.readOnly                = true;
}



function activaBtnDisenio() {
    document.getElementById("imgBtnLimpiarDisenioInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarDisenioInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarDisenioActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarDisenioActivo").style.display     = "inline";
}

function desactivaBtnDisenio() {
    document.getElementById("imgBtnAgregarDisenioActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarDisenioActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarDisenioInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarDisenioInactivo").style.display   = "inline";
}



function limpiaCamposFormDisenio() {
    // limpia datos externos
    document.disenio.indicacion_tarea_realizar.value   = "";
    document.disenio.materiales_recibe.value           = "";
    document.disenio.observaciones.value               = "";
    document.disenio.indicacion_tarea_realizar.focus();
}


function limpiaFormDisenio() {
    // limpia datos internos
    document.disenio.id_partida.value = "";
    limpiaCamposFormDisenio();
    activaCamposDisenio();
    activaBtnDisenio();
    
}





//************************/
// disenio detalle

function activaCamposDisenioDetalle() {
    document.disenio_detalle.select_proceso_disenio.disabled   = false;
    document.disenio_detalle.cantidad.readOnly                 = false;
    document.disenio_detalle.precio_total_pesos.readOnly       = false;
    document.disenio_detalle.especificaciones.disabled         = false;
}

function desactivaCamposDisenioDetalle() {
    document.disenio_detalle.select_proceso_disenio.disabled   = true;
    document.disenio_detalle.cantidad.readOnly                 = true;
    document.disenio_detalle.precio_total_pesos.readOnly       = true;
    document.disenio_detalle.especificaciones.disabled         = true;
}



function activaBtnDisenioDetalle() {
    document.getElementById("imgBtnLimpiarDisenioDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarDisenioDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnLimpiarDisenioDetalleActivo").style.display     = "inline";
    document.getElementById("imgBtnAgregarDisenioDetalleActivo").style.display     = "inline";
}

function desactivaBtnDisenioDetalle() {
    document.getElementById("imgBtnLimpiarDisenioDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarDisenioDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarDisenioDetalleInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarDisenioDetalleInactivo").style.display   = "inline";
}

function limpiaCamposFormDisenioDetalle() {
    // limpia datos externos
    document.disenio_detalle.select_proceso_disenio.selectedIndex  = "-1";
    document.disenio_detalle.detalle.value                         = "";
    document.disenio_detalle.cantidad.value                        = "";
    document.disenio_detalle.precio_total_pesos.value              = "";
    document.disenio_detalle.especificaciones.value                = "";
    document.disenio_detalle.select_proceso_disenio.focus();
}

function limpiaFormDisenioDetalle() {
    // limpia datos internos
    document.disenio_detalle.id_disenio.value          = "";
    document.disenio_detalle.id_proceso_disenio.value  = "";
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
}





//************************/
// preprensa

function activaCamposPreprensa() {
    document.preprensa.indicacion_tarea_realizar.readOnly  = false;
    document.preprensa.materiales_recibe.readOnly          = false;
    document.preprensa.observaciones.readOnly              = false;
}

function desactivaCamposPreprensa() {
    document.preprensa.indicacion_tarea_realizar.readOnly  = true;
    document.preprensa.materiales_recibe.readOnly          = true;
    document.preprensa.observaciones.readOnly              = true;
}



function activaBtnPreprensa() {
    document.getElementById("imgBtnLimpiarPreprensaInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarPreprensaInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarPreprensaActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarPreprensaActivo").style.display     = "inline";
}

function desactivaBtnPreprensa() {
    document.getElementById("imgBtnAgregarPreprensaActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarPreprensaActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarPreprensaInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarPreprensaInactivo").style.display   = "inline";
}



function limpiaCamposFormPreprensa() {
    // limpia datos externos
    document.preprensa.indicacion_tarea_realizar.value = "";
    document.preprensa.materiales_recibe.value         = "";
    document.preprensa.observaciones.value             = "";
    document.preprensa.indicacion_tarea_realizar.focus();
}

function limpiaFormPreprensa() {
    // limpia datos internos
    document.preprensa.id_partida.value = "";
    limpiaCamposFormPreprensa();
    activaCamposPreprensa();
    activaBtnPreprensa();
}





//************************/
// preprensa_detalle

function activaCamposPreprensaDetalle() {
    document.preprensa_detalle.select_proceso_preprensa.disabled   = false;
    document.preprensa_detalle.cantidad.readOnly                   = false;
    document.preprensa_detalle.precio_total_pesos.readOnly         = false;
    document.preprensa_detalle.especificaciones.disabled           = false;
}

function desactivaCamposPreprensaDetalle() {
    document.preprensa_detalle.select_proceso_preprensa.disabled   = true;
    document.preprensa_detalle.cantidad.readOnly                   = true;
    document.preprensa_detalle.precio_total_pesos.readOnly         = true;
    document.preprensa_detalle.especificaciones.disabled           = true;
}



function activaBtnPreprensaDetalle() {
    document.getElementById("imgBtnLimpiarPreprensaDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarPreprensaDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnLimpiarPreprensaDetalleActivo").style.display     = "inline";
    document.getElementById("imgBtnAgregarPreprensaDetalleActivo").style.display     = "inline";
}

function desactivaBtnPreprensaDetalle() {
    document.getElementById("imgBtnLimpiarPreprensaDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarPreprensaDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarPreprensaDetalleInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarPreprensaDetalleInactivo").style.display   = "inline";
}



function limpiaCamposFormPreprensaDetalle() {
    // limpia datos externos
    document.preprensa_detalle.select_proceso_preprensa.selectedIndex  = "-1";
    document.preprensa_detalle.detalle.value                           = "";
    document.preprensa_detalle.cantidad.value                          = "";
    document.preprensa_detalle.precio_total_pesos.value                = "";
    document.preprensa_detalle.especificaciones.value                  = "";
    document.preprensa_detalle.select_proceso_preprensa.focus();
}

function limpiaFormPreprensaDetalle() {
    // limpia campos internos
    document.preprensa_detalle.id_preprensa.value          = "";
    document.preprensa_detalle.id_proceso_preprensa.value  = "";
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
}





//************************/
// transporte

function activaCamposTransporte() {
    document.transporte.indicacion_tarea_realizar.readOnly = false;
    document.transporte.materiales_recibe.readOnly         = false;
    document.transporte.observaciones.readOnly             = false;
}

function desactivaCamposTransporte() {
    document.transporte.indicacion_tarea_realizar.readOnly = true;
    document.transporte.materiales_recibe.readOnly         = true;
    document.transporte.observaciones.readOnly             = true;
}



function activaBtnTransporte() {
    document.getElementById("imgBtnLimpiarTransporteInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarTransporteInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarTransporteActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarTransporteActivo").style.display     = "inline";
}

function desactivaBtnTransporte() {
    document.getElementById("imgBtnAgregarTransporteActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarTransporteActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarTransporteInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarTransporteInactivo").style.display   = "inline";
}



function limpiaCamposFormTransporte() {
    // limpia datos externos
    document.transporte.indicacion_tarea_realizar.value    = "";
    document.transporte.materiales_recibe.value            = "";
    document.transporte.observaciones.value                = "";
    document.transporte.indicacion_tarea_realizar.focus();
}

function limpiaFormTransporte() {
    // limpia datos internos
    document.transporte.id_partida.value = "";
    limpiaCamposFormTransporte();
    activaCamposTransporte();
    activaBtnTransporte();
}





//************************/
// transporte detalle

function activaCamposTransporteDetalle() {
    document.transporte_detalle.select_proceso_transporte.disabled = false;
    document.transporte_detalle.cantidad.readOnly                  = false;
    document.transporte_detalle.precio_total_pesos.readOnly        = false;
    document.transporte_detalle.especificaciones.disabled          = false;
}

function desactivaCamposTransporteDetalle() {
    document.transporte_detalle.select_proceso_transporte.disabled = true;
    document.transporte_detalle.cantidad.readOnly                  = true;
    document.transporte_detalle.precio_total_pesos.readOnly        = true;
    document.transporte_detalle.especificaciones.disabled          = true;
}



function activaBtnTransporteDetalle() {
    document.getElementById("imgBtnLimpiarTransporteDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarTransporteDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnLimpiarTransporteDetalleActivo").style.display     = "inline";
    document.getElementById("imgBtnAgregarTransporteDetalleActivo").style.display     = "inline";
}

function desactivaBtnTransporteDetalle() {
    document.getElementById("imgBtnLimpiarTransporteDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarTransporteDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarTransporteDetalleInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarTransporteDetalleInactivo").style.display   = "inline";
}



function limpiaCamposFormTransporteDetalle() {
    // limpia datos externos
    document.transporte_detalle.select_proceso_transporte.selectedIndex    = "-1";
    document.transporte_detalle.detalle.value                              = "";
    document.transporte_detalle.cantidad.value                             = "";
    document.transporte_detalle.precio_total_pesos.value                   = "";
    document.transporte_detalle.especificaciones.value                     = "";
    document.transporte_detalle.select_proceso_transporte.focus();
}

function limpiaFormTransporteDetalle() {
    // limpia datos internos
    document.transporte_detalle.id_transporte.value            = "";
    document.transporte_detalle.id_proceso_transporte.value    = "";
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
}





//************************/
// acabado

function activaCamposAcabado() {
    document.acabado.indicacion_tarea_realizar.readOnly    = false;
    document.acabado.materiales_recibe.readOnly            = false;
    document.acabado.observaciones.readOnly                = false;
}

function desactivaCamposAcabado() {
    document.acabado.indicacion_tarea_realizar.readOnly    = true;
    document.acabado.materiales_recibe.readOnly            = true;
    document.acabado.observaciones.readOnly                = true;
}



function activaBtnAcabado() {
    document.getElementById("imgBtnLimpiarAcabadoInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarAcabadoInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarAcabadoActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarAcabadoActivo").style.display     = "inline";
}

function desactivaBtnAcabado() {
    document.getElementById("imgBtnAgregarAcabadoActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarAcabadoActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarAcabadoInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarAcabadoInactivo").style.display   = "inline";
}



function limpiaCamposFormAcabado() {
    // limpia datos externos
    document.acabado.indicacion_tarea_realizar.value   = "";
    document.acabado.materiales_recibe.value           = "";
    document.acabado.observaciones.value               = "";
    document.acabado.indicacion_tarea_realizar.focus();
}

function limpiaFormAcabado() {
    // limpia datos internos
    document.acabado.id_partida.value = "";
    limpiaCamposFormAcabado();
    activaCamposAcabado();
    activaBtnAcabado();
}





//************************/
// acabado detalle

function activaCamposAcabadoDetalle() {
    document.acabado_detalle.select_proceso_externo.disabled   = false;
    document.acabado_detalle.ancho.readOnly                    = false;
    document.acabado_detalle.alto.readOnly                     = false;
    document.acabado_detalle.cantidad_proceso_externo.readOnly = false;
    document.acabado_detalle.precio_total_pesos.readOnly       = false;
    document.acabado_detalle.especificaciones.disabled         = false;
}

function desactivaCamposAcabadoDetalle() {
    document.acabado_detalle.select_proceso_externo.disabled   = true;
    document.acabado_detalle.ancho.readOnly                    = true;
    document.acabado_detalle.alto.readOnly                     = true;
    document.acabado_detalle.cantidad_proceso_externo.readOnly = true;
    document.acabado_detalle.precio_total_pesos.readOnly       = true;
    document.acabado_detalle.especificaciones.disabled         = true;
}



function activaBtnAcabadoDetalle() {
    document.getElementById("imgBtnLimpiarAcabadoDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarAcabadoDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnLimpiarAcabadoDetalleActivo").style.display     = "inline";
    document.getElementById("imgBtnAgregarAcabadoDetalleActivo").style.display     = "inline";
}

function desactivaBtnAcabadoDetalle() {
    document.getElementById("imgBtnLimpiarAcabadoDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarAcabadoDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarAcabadoDetalleInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarAcabadoDetalleInactivo").style.display   = "inline";
}



function limpiaCamposFormAcabadoDetalle() {
    // limpia datos externos
    document.acabado_detalle.select_proceso_externo.selectedIndex  = "-1";
    document.acabado_detalle.detalle.value                         = "";
    document.acabado_detalle.ancho.value                           = "";
    document.acabado_detalle.alto.value                            = "";
    document.acabado_detalle.cantidad_proceso_externo.value        = "";
    document.acabado_detalle.precio_total_pesos.value              = "";
    document.acabado_detalle.especificaciones.value                = "";
    document.acabado_detalle.select_proceso_externo.focus();
}

function limpiaFormAcabadoDetalle() {
    // limpia datos internos
    document.acabado_detalle.id_acabado.value          = "";
    document.acabado_detalle.id_proceso_externo.value  = "";
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
}





//************************/
// offset

function activaCamposOffset() {
    document.offset.indicacion_tarea_realizar.disabled = false;
    document.offset.materiales_recibe.disabled         = false;
    document.offset.observaciones.disabled             = false;
}

function desactivaCamposOffset() {
    document.offset.indicacion_tarea_realizar.disabled = true;
    document.offset.materiales_recibe.disabled         = true;
    document.offset.observaciones.disabled             = true;
}



function activaBtnOffset() {
    document.getElementById("imgBtnLimpiarOffsetInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarOffsetInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarOffsetActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarOffsetActivo").style.display     = "inline";
}

function desactivaBtnOffset() {
    document.getElementById("imgBtnAgregarOffsetActivo").style.display      = "none";
    document.getElementById("imgBtnLimpiarOffsetActivo").style.display      = "none";
    document.getElementById("imgBtnLimpiarOffsetInactivo").style.display    = "inline";
    document.getElementById("imgBtnAgregarOffsetInactivo").style.display    = "inline";
}



function limpiaCamposFormOffset() {
    // limpia datos externos
    document.offset.indicacion_tarea_realizar.value    = "";
    document.offset.materiales_recibe.value            = "";
    document.offset.observaciones.value                = "";
    document.offset.indicacion_tarea_realizar.focus();
}

function limpiaFormOffset() {
    // limpia datos internos 
    document.offset.id_partida.value = "";
    limpiaCamposFormOffset();
    activaCamposOffset();
    activaBtnOffset();
}





//************************/
// material ayuda

function activaCamposMaterialAyuda() {
    document.material_ayuda.select_material_ayuda.disabled     = false;
    document.material_ayuda.select_responsable_insumo.disabled = false;
    document.material_ayuda.observaciones.readOnly             = false;
}

function desactivaCamposMaterialAyuda() {
    document.material_ayuda.select_material_ayuda.disabled     = true;
    document.material_ayuda.select_responsable_insumo.disabled = true;
    document.material_ayuda.observaciones.readOnly             = true;
}



function activaBtnMaterialAyuda() {
    document.getElementById("imgBtnLimpiarMatAyudaInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarMatAyudaInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarMatAyudaActivo").style.display     = "inline";
    document.getElementById("imgBtnLimpiarMatAyudaActivo").style.display     = "inline";
}

function desactivaBtnMaterialAyuda() {
    document.getElementById("imgBtnAgregarMatAyudaActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarMatAyudaActivo").style.display     = "none";
    document.getElementById("imgBtnLimpiarMatAyudaInactivo").style.display   = "inline";
    document.getElementById("imgBtnAgregarMatAyudaInactivo").style.display   = "inline";
}



function limpiaCamposFormMaterialAyuda() {
    // limpia datos externos
    document.material_ayuda.select_responsable_insumo.selectedIndex    = 0;
    document.material_ayuda.observaciones.value                        = "";
}

function limpiaFormMaterialAyuda() {
    // limpia datos internos
    document.material_ayuda.id_partida.value               = "";
    document.material_ayuda.id_material_ayuda.value        = "";
    document.material_ayuda.id_responsable_insumo.value    = "";
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
}


//*******************************************************************************************************************/

