<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:url value="/tipo_placa/busca"            				var="urlBuscaTipoPlaca"/>
<c:url value="/orden_produccion/cambia_estatus"				var="urlCambiaEstatus"/>
<c:url value="/visualizador/obtiene_partida"         		var="urlObtienePartida"/>
<c:url value="/visualizador/obtiene_tipo_trabajo_detalle"   var="urlObtieneTipoTrabajoDetalle"/>
<c:url value="/visualizador/obtiene_precio_detalle"    		var="urlObtienePrecioDetalle"/>
<c:url value="/visualizador/obtiene_precio_neto"            var="urlObtienePrecioNeto"/>
<c:url value="/orden_produccion/actualiza"    				var="urlActualizaOrdenProduccion"/>
<c:url value="/partida/actualiza"    						var="urlActualizaPartida"/>
<c:url value="/tipo_trabajo_detalle/agrega"  				var="urlAgregaTipoTrabajoDetalle"/>
<c:url value="/tipo_trabajo_detalle/actualiza_con_pliegos"  var="urlActualizaTipoTrabajoDetalleConPliegos"/>
<c:url value="/tipo_trabajo_detalle/actualiza"  			var="urlActualizaTipoTrabajoDetalle"/>
<c:url value="/tipo_trabajo_detalle/elimina"  				var="urlEliminaTipoTrabajoDetalle"/>
<c:url value="/tipo_trabajo_detalle/busca"  				var="urlBuscaTipoTrabajoDetalle"/>
<c:url value="/pliego/calcula"              				var="urlCalculaPliego"/>
<c:url value="/pliego/activa_lista"            				var="urlActivaListaPliegos"/>
<c:url value="/pliego/actualiza"            				var="urlActualizaPliego"/>
<c:url value="/descuento_por_tabulador/actualiza" 			var="urlActualizaDescuento"/>
<c:url value="/costo_extra_detalle/ventana" 				var="urlCostoExtraDetalle"/>
<c:url value="/costo_extra_detalle/busca_unidad_medida" 	var="urlBuscaUnidadMedidaCostoExtra"/>
<c:url value="/costo_extra_detalle/agrega_olvidado" 		var="urlAgregaCostoExtraDetalleOlvidado"/>
<c:url value="/costo_extra_detalle/actualiza_en_op" 		var="urlActualizaCostoExtraDetalle"/>
<c:url value="/costo_extra_detalle/elimina_en_op" 			var="urlEliminaCostoExtraDetalle"/>
<c:url value="/disenio/modifica"       						var="urlModificaDisenio"/>
<c:url value="/disenio_detalle/agrega_olvidado"				var="urlAgregaDisenioDetalleOlvidado"/>
<c:url value="/disenio_detalle/actualiza"       			var="urlActualizaDisenioDetalle"/>
<c:url value="/disenio_detalle/elimina"       				var="urlEliminaDisenioDetalle"/>
<c:url value="/preprensa/modifica"							var="urlModificaPreprensa"/>
<c:url value="/preprensa_detalle/agrega_olvidado"			var="urlAgregaPreprensaDetalleOlvidado"/>
<c:url value="/preprensa_detalle/actualiza"       			var="urlActualizaPreprensaDetalle"/>
<c:url value="/preprensa_detalle/elimina"       			var="urlEliminaPreprensaDetalle"/>
<c:url value="/transporte/modifica"							var="urlModificaTransporte"/>
<c:url value="/transporte_detalle/agrega_olvidado"			var="urlAgregaTransporteDetalleOlvidado"/>
<c:url value="/transporte_detalle/actualiza"       			var="urlActualizaTransporteDetalle"/>
<c:url value="/transporte_detalle/elimina"       			var="urlEliminaTransporteDetalle"/>
<c:url value="/acabado/modifica"							var="urlModificaAcabado"/>
<c:url value="/acabado_detalle/agrega_olvidado"				var="urlAgregaAcabadoDetalleOlvidado"/>
<c:url value="/acabado_detalle/actualiza"       			var="urlActualizaAcabadoDetalle"/>
<c:url value="/acabado_detalle/elimina"       				var="urlEliminaAcabadoDetalle"/>
<c:url value="/offset/modifica"       						var="urlModificaOffset"/>
<c:url value="/material_ayuda_x_partida/agrega_olvidado"	var="urlAgregaMaterialAyudaXPartidaOlvidado"/>
<c:url value="/material_ayuda_x_partida/actualiza"       	var="urlActualizaMaterialAyudaXPartida"/>
<c:url value="/material_ayuda_x_partida/elimina"       		var="urlEliminaMaterialAyudaXPartida"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Resumen cotizaci&oacute;n</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/detalle_nut.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/shadowbox/shadowbox.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/master.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_orden_produccion_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_partida_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_tipo_trabajo_detalle.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_tipo_trabajo_detalle_agrega.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_tipo_trabajo_detalle_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_pliego_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_descuento_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_costo_extra_detalle_agrega.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_costo_extra_detalle_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_disenio_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_disenio_detalle_agrega.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_disenio_detalle_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_preprensa_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_preprensa_detalle_agrega.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_preprensa_detalle_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_transporte_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_transporte_detalle_agrega.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_transporte_detalle_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_acabado_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_acabado_detalle_agrega.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_acabado_detalle_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_offset_modificacion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_material_ayuda_agrega.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/detalle_nut_material_ayuda_modificacion.js"/>"></script>
        <script type="text/javascript">
            //inicializacion jquery
            $(document).ready(function (){});
            //inicializacion shadowbox
            Shadowbox.init({
                //modal: true,
                //overlayOpacity: 0.75
            });
        </script>
        <script type="text/javascript">
        	var urlBuscaTipoPlaca							= "${urlBuscaTipoPlaca}";
        	var urlCambiaEstatus							= "${urlCambiaEstatus}";
            var urlObtienePartida        					= "${urlObtienePartida}";
            var urlObtieneTipoTrabajoDetalle    			= "${urlObtieneTipoTrabajoDetalle}";
            var urlObtienePrecioDetalle						= "${urlObtienePrecioDetalle}";
            var urlObtienePrecioNeto						= "${urlObtienePrecioNeto}";
            var urlActualizaOrdenProduccion					= "${urlActualizaOrdenProduccion}";
            var urlActualizaPartida							= "${urlActualizaPartida}";
            var urlAgregaTipoTrabajoDetalle					= "${urlAgregaTipoTrabajoDetalle}";
            var urlActualizaTipoTrabajoDetalleConPliegos	= "${urlActualizaTipoTrabajoDetalleConPliegos}";
            var urlActualizaTipoTrabajoDetalle				= "${urlActualizaTipoTrabajoDetalle}";
            var urlEliminaTipoTrabajoDetalle				= "${urlEliminaTipoTrabajoDetalle}";
            var urlBuscaTipoTrabajoDetalle					= "${urlBuscaTipoTrabajoDetalle}";
            var urlCalculaPliego            				= "${urlCalculaPliego}";
            var urlActivaListaPliegos						= "${urlActivaListaPliegos}";
            var urlActualizaPliego							= "${urlActualizaPliego}";
            var urlActualizaDescuento						= "${urlActualizaDescuento}";
            var urlCostoExtraDetalle						= "${urlCostoExtraDetalle}";
            var urlBuscaUnidadMedidaCostoExtra				= "${urlBuscaUnidadMedidaCostoExtra}";
            var urlAgregaCostoExtraDetalleOlvidado			= "${urlAgregaCostoExtraDetalleOlvidado}";
            var urlActualizaCostoExtraDetalle				= "${urlActualizaCostoExtraDetalle}";
            var urlEliminaCostoExtraDetalle					= "${urlEliminaCostoExtraDetalle}";
            var urlModificaDisenio							= "${urlModificaDisenio}";
            var urlAgregaDisenioDetalleOlvidado				= "${urlAgregaDisenioDetalleOlvidado}";
            var urlActualizaDisenioDetalle					= "${urlActualizaDisenioDetalle}";
            var urlEliminaDisenioDetalle					= "${urlEliminaDisenioDetalle}";
            var urlModificaPreprensa						= "${urlModificaPreprensa}";
            var urlAgregaPreprensaDetalleOlvidado			= "${urlAgregaPreprensaDetalleOlvidado}";
            var urlActualizaPreprensaDetalle				= "${urlActualizaPreprensaDetalle}";
            var urlEliminaPreprensaDetalle					= "${urlEliminaPreprensaDetalle}";
            var urlModificaTransporte						= "${urlModificaTransporte}";
            var urlAgregaTransporteDetalleOlvidado			= "${urlAgregaTransporteDetalleOlvidado}";
            var urlActualizaTransporteDetalle				= "${urlActualizaTransporteDetalle}";
            var urlEliminaTransporteDetalle					= "${urlEliminaTransporteDetalle}";
            var urlModificaAcabado							= "${urlModificaAcabado}";
            var urlAgregaAcabadoDetalleOlvidado				= "${urlAgregaAcabadoDetalleOlvidado}";
            var urlActualizaAcabadoDetalle					= "${urlActualizaAcabadoDetalle}";
            var urlEliminaAcabadoDetalle					= "${urlEliminaAcabadoDetalle}";
            var urlModificaOffset							= "${urlModificaOffset}";
            var urlAgregaMaterialAyudaXPartidaOlvidado		= "${urlAgregaMaterialAyudaXPartidaOlvidado}";
            var urlActualizaMaterialAyudaXPartida			= "${urlActualizaMaterialAyudaXPartida}";
            var urlEliminaMaterialAyudaXPartida				= "${urlEliminaMaterialAyudaXPartida}";
        </script>
        <script type="text/javascript">
            var strJsonListaProcesoDisenio      = '${jsonListaProcesoDisenio}';
            var strJsonListaProcesoPreprensa    = '${jsonListaProcesoPreprensa}';
            var strJsonListaProcesoTransporte   = '${jsonListaProcesoTransporte}';
            var strJsonListaProcesoExterno      = '${jsonListaProcesoExterno}';
            var strJsonListaCostoExtra			= '${jsonListaCostoExtra}';
            var strJsonListaMaterialAyuda       = '${jsonListaMaterialAyuda}';
        </script>
    </head>
    <body>
    	<fmt:setLocale value="en_US" scope="session" />
		<c:set var="estatus_cotizacion" value="1"/>
		<c:set var="estatus_finalizado" value="10"/>
        <div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_cuerpo">
                        <div id="div_contenido">
                            <div id="div_formulario">
                                <div id="div_cliente">
                                    <form name="cliente" action="" accept-charset="ISO-8859-1">
                                        <br/>
                                        <div class="titulo">
                                            <img alt="" src="<c:url value="/resources/image/titulo_cliente.png"/>"/>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="15%">Nombre del Cliente:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="nombre_moral" 
                                                                        value="${cliente.nombreMoral}" 
                                                                        readOnly/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="36%">Id. Cliente:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="id_cliente"
                                                                                value="${cliente.idCliente}" 
                                                                                onkeypress="if( event.keyCode == 13 ) ajaxBuscaCliente(); else if( isNaN( String.fromCharCode (event.keyCode) ) ) {return false;}"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="42%">Cve. Cliente:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="clave" 
                                                                                value="${cliente.tipoCliente.clave}" 
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="20%">Representante:</td>
                                                                <td>
                                                                    <input type="text" 
                                                                           class="input"
                                                                           name="nombre_representante"
                                                                           value="${cliente.nombreRepresentante}"
                                                                           readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="8%">Calle:</td>
                                                                <td>
                                                                    <input type="text" 
                                                                           class="input"
                                                                           name="calle"
                                                                           value="${cliente.calle}" 
                                                                           readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="25%">No Ext:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="num_exterior" 
                                                                                value="${cliente.numExterior}"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="23%">No Int:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="num_interior" 
                                                                                value="${cliente.numInterior}"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="10%">Colonia:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="colonia"
                                                                            value="${cliente.colonia}" 
                                                                            readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="37%">Delegaci&oacute;n / Municipio:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="delegacion_municipio"
                                                                            value="${cliente.delegacionMunicipio}" 
                                                                            readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="10%">Estado:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="estado"
                                                                            value="${cliente.estado}" 
                                                                            readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="35%">C. Postal.:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="codigo_postal" 
                                                                                value="${cliente.codigoPostal}"
                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;" 
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="10%">RFC:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="rfc"
                                                                                value="${cliente.rfc}" 
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="10%">Tel&eacute;fono:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="telefono_particular" 
                                                                                value="${cliente.telefonoParticular}"
                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;" 
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="10%">M&oacute;vil:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="telefono_movil" 
                                                                                value="${cliente.telefonoMovil}"
                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;" 
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="10%">Observaciones:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="observaciones" 
                                                                            value="${cliente.observaciones}"
                                                                            readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                
<!-- div_orden_produccion -->
							                                
                                <div id="div_orden_produccion">
                                    <form name="orden_produccion" action="" accept-charset="ISO-8859-1">
                                    	<input type="hidden" name="id_orden_produccion" 		value="${ordenProduccion.idOrdenProduccion}"/>
                                    	<input type="hidden" name="id_cliente"					value="">
                                    	<input type="hidden" name="id_tipo_comprobante_fiscal" 	value="">
                                        <div class="div_separador_grande">
                                            <img alt="" src="<c:url value="/resources/image/separador_grande.png"/>"/>
                                        </div>
                                        <div class="titulo">
                                            <img alt="" src="<c:url value="/resources/image/titulo_orden.png"/>"/>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="1%">NUT:</td>
                                                                    <td>
                                                                        <input  type="text"
                                                                                class="input"
                                                                                name="nut"
                                                                                value="${ordenProduccion.nut}"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Nombre:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="nombre"
                                                                        value="${ordenProduccion.nombre}"
                                                                        readonly/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Descripci&oacute;n:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="descripcion"
                                                                        value="${ordenProduccion.descripcion}"
                                                                        readonly/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="1%">Comprobante:</td>
                                                                <td>
                                                               		<input  type="text"
                                                                           	class="input"
                                                                           	name="comprobante_fiscal"
                                                                           	style="display:inline;"
                                                                           	value="${ordenProduccion.tipoComprobanteFiscal.nombre}"
                                                                           	readonly/>
                                                                	<select name="select_comprobante_fiscal" style="display:none;">
                                                                		<c:forEach var="ltcf" items="${listaTipoComprobanteFiscal}">
                                                                        	<option value="${ltcf.value}">${ltcf.text}</option>
                                                                    	</c:forEach>
                                                                	</select>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="30%">Fecha generaci&oacute;n:</td>
                                                                <td>
                                                                    <input  type="text"
                                                                            class="input"
                                                                            name="fecha_generacion"
                                                                            value="<fmt:formatDate value="${ordenProduccion.fechaGeneracion}" type="both" pattern="MMM dd, yyyy"/>"
                                                                            readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="43%">Fecha aproximada entrega:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input" 
                                                                            name="fecha_prometida_entrega" 
                                                                            value="<fmt:formatDate value="${ordenProduccion.fechaPrometidaEntrega}" type="both" pattern="MMM dd, yyyy"/>"
                                                                            readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="1%">Estatus:</td>
                                                                    <td>
                                                                        <input  type="text"
                                                                                class="input"
                                                                                name="estatus"
                                                                                value="${historialEstatus.estatusOrden.nombre}"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="49%">Fecha estatus:</td>
                                                                    <td>
                                                                        <input  type="text"
                                                                                class="input"
                                                                                name="fecha_estatus"
                                                                                value="<fmt:formatDate value="${historialEstatus.fecha}" type="both" pattern="MMM dd, yyyy"/>"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    	<c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                        	<div class="linea">
	                                        	<div class="casilla" style="text-align:right;">
	                                        		<div id="div_btn_actualizar_orden_produccion">
	                                        			<img id="imgBtnModificarOrdenProduccion" alt="" style="cursor:pointer;" onclick="modificaOrdenProduccion()" src="<c:url value="/resources/image/boton_modificar.jpg"/>"/>
		                                        		
		                                        		<span id="imgBtnCancelaModificarOrdenProduccion" style="cursor:pointer; display:none;" onclick="cancelaModificarOrdenProduccion()">
		                                        			<font  color="gray">CANCELAR</font>
		                                        		</span>
		                                        		<span id="imgBtnAceptaModificarOrdenProduccion" style="cursor:pointer; display:none;" onclick="aceptaModificarOrdenProduccion()">
		                                        			<font  color="blue">ACEPTAR</font>
		                                        		</span>
	                                        		</div>
	                                        	</div>
	                                        </div>
                                        </c:if>
                                    </form>
                                </div>
                                
<!-- div_visualizador_partidas, display: block -->
                            
                                <div id="div_visualizador_partidas" style="display:block;">
                                    <div class="div_separador_mediano">
                                        <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                    </div>
                                    <div class="titulo">
                                        <font size="5">LISTA DE TRABAJOS</font>
                                    </div>
                                    <div style="width:800px; height:150px; margin-left:auto; margin-right:auto;">
                                        <div class="columna_completa">
                                            <div id="div_tabla_lista_partidas" style="overflow-x:scroll;">
                                                <table id="tabla_lista_partidas">
                                                    <tr>
                                                        <th>No.</th>
                                                        <th>Tipo trabajo</th>
                                                        <th>Nombre</th>
                                                        <th>Cantidad</th>
                                                        <th>Descripci&oacute;n</th>
                                                    </tr>
												<c:choose>
													<c:when test="${fn:length(listaPartida) gt 0}">
														<c:forEach var="partida" items="${listaPartida}" varStatus="i">
		                                                 	<tr class='${i.count%2==0?"l2":"l1"}' onclick="buscaPartida(${partida.idPartida});">
		                                                        <td>${i.count}</td>
		                                                        <td>${partida.tipoTrabajo.nombre}</td>
		                                                        <td id="td_${partida.idPartida}_nombre_partida">${partida.nombrePartida}</td>
		                                                        <td id="td_${partida.idPartida}_cantidad"><fmt:formatNumber pattern="#,###" value="${partida.cantidad}"/></td>
		                                                        <td id="td_${partida.idPartida}_descripcion_partida">${partida.descripcionPartida}</td>
		                                                    </tr>
		                                                </c:forEach>
													</c:when>
													<c:otherwise>
														<tr class="l1">
                                                			<td>&nbsp;</td>
                                                			<td>&nbsp;</td>
                                                			<td>&nbsp;</td>
                                                			<td>&nbsp;</td>
                                                			<td>&nbsp;</td>
                                                		</tr>
													</c:otherwise>
												</c:choose>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
<!-- div_partida, display: none -->
                            
                                <div id="div_partida" style="display:none;">
                                    <form name="partida" action="" accept-charset="ISO-8859-1">
                                    	<input type="hidden" name="id_orden_produccion" 	value="${ordenProduccion.idOrdenProduccion}">
                                    	<input type="hidden" name="nut"						value="${ordenProduccion.nut}">
                                    	<input type="hidden" name="id_partida" 				value="">
                                    	<input type="hidden" name="id_tipo_trabajo" 		value="">
                                    	<input type="hidden" name="id_tipo_forma_trabajo" 	value="">
                                        <br/><br/> <!-- CUANDO ESTE EL BOTON; SOLO DEBE TENER UN <BR> -->
                                        <div class="titulo">
                                            <!--  <img alt="" src="<c:url value="/resources/image/titulo_descripcion_partida.png"/>"/> -->
                                            <font size="5">DESCRIPCI&Oacute;N DE TRABAJO</font>
                                        </div>
                                        <div class="linea">
                                            <table border="0">
                                                <tr>
                                                    <td width="33%" align="center">
                                                        <div style="width:39%; margin-left:auto; margin-right:auto;">
                                                            <table border="0">
                                                                <tr>
                                                                    <td>
                                                                        <input  type="radio" 
                                                                                name="tipo_trabajo"
                                                                                value="1"
                                                                                onclick="cambiaCampos( this );"/>
                                                                    </td>
                                                                    <td>
                                                                        <img alt="" src="<c:url value="/resources/image/titulo_flyer.png"/>"/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </td>
                                                    <td width="33%" align="center">
                                                        <div style="width:67%; margin-left:auto; margin-right:auto;">
                                                            <table border="0">
                                                                <tr>
                                                                    <td width="1%">
                                                                        <input  type="radio" 
                                                                                name="tipo_trabajo"
                                                                                value="2"
                                                                                onclick="cambiaCampos( this );"/>
                                                                    </td>
                                                                    <td>
                                                                    	<img alt="" src="<c:url value="/resources/image/titulo_revista.png"/>"/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </td>
                                                    <td width="33%" align="center">
                                                        <div style="width:23%; margin-left:auto; margin-right:auto;">
                                                            <table border="0">
                                                                <tr>
                                                                    <td width="1%">
                                                                        <input  type="radio" 
                                                                                name="tipo_trabajo"
                                                                                value="3"
                                                                                onclick="cambiaCampos( this );"/>
                                                                    </td>
                                                                    <td>
                                                                    	<img alt="" src="<c:url value="/resources/image/titulo_otros.png"/>"/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="1%">Nombre:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input" 
                                                                            name="nombre_partida"
                                                                            value=""
                                                                            readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="1%">Cantidad:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="cantidad"
                                                                                value="" 
                                                                                onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="48%">Tipo Acabado:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="forma_trabajo"
                                                                                style="display:inline;" 
                                                                                value="" 
                                                                                readonly/>
                                                                        <select name="select_forma_trabajo" style="display:none;">
                                                                        	<c:forEach var="tft" items="${listaTipoFormaTrabajo}">
	                                                                            <option value="${tft.value}">${tft.text}</option>
	                                                                        </c:forEach>
                                                                        </select>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Descripci&oacute;n:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="descripcion_partida"
                                                                        value=""
                                                                        readonly/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Diagrama:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="diagrama_formacion"
                                                                        value=""
                                                                        readonly/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="doble_linea">
                                            <div class="casilla_doble_alto">
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="10%" valign="top" style="padding-top:4px;">Obs. Generales:</td>
                                                                <td>
                                                                    <textarea class="textarea_doble"
                                                                              name="observaciones_generales" 
                                                                              disabled readonly></textarea>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="10%" valign="top" style="padding-top:4px;">Obs. Aprobaci&oacute;n:</td>
                                                                <td>
                                                                    <textarea class="textarea_doble"
                                                                              name="observaciones_aprobacion" 
                                                                              disabled readonly></textarea>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                        	<div class="linea">
	                                        	<div class="casilla" style="text-align:right;">
	                                        		<div id="div_btn_actualizar_partida">
	                                        			<!-- 
	                                        			<span style="cursor:pointer;" onclick="eliminaPartida();">
	                                        				<font color="blue">ELIMINAR</font>
	                                        			</span>
	                                        			-->
	                                        			<img id="imgBtnModificarPartida" alt="" style="cursor:pointer;" onclick="modificaPartida()" src="<c:url value="/resources/image/boton_modificar.jpg"/>"/>
		                                        		<span id="imgBtnCancelaModificarPartida" style="cursor:pointer; display:none;" onclick="cancelaModificarPartida()">
		                                        			<font  color="gray">CANCELAR</font>
		                                        		</span>
		                                        		<span id="imgBtnAceptaModificarPartida" style="cursor:pointer; display:none;" onclick="aceptaModificarPartida()">
		                                        			<font  color="blue">ACEPTAR</font>
		                                        		</span>
	                                        		</div>
	                                        	</div>
	                                        </div>
                                        </c:if>
                                    </form>
                                </div>
                                
<!-- div_visualizador, display: none -->
                            
                                <div id="div_visualizador_tipo_trabajo_detalle" style="display:none;">
                                    <div class="div_separador_mediano">
                                    	<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                    </div>
                                    <div class="titulo">
                                        <font size="5">LISTA DE DETALLE DE IMPRESI&Oacute;N</font>
                                    </div>
                                    <div style="width:800px; height:150px; margin-left:auto; margin-right:auto;">
                                        <div class="columna_completa">
                                            <div id="div_tabla_lista_tipo_trabajo_detalle" style="overflow-x:scroll;">
                                                <table id="tabla_lista_tipo_trabajo_detalle">
                                                    <tr>
                                                        <th>No.</th>
                                                        <th>Descripci&oacute;n</th>
                                                        <th>Repeticiones pliego</th>
                                                        <th>No. p&aacute;ginas</th>
                                                        <th>Tama&ntilde;o publicaci&oacute;n</th>
                                                        <th>M&aacute;quina</th>
                                                    </tr>
                                                    <tr class="l1">
                                                        <td>&nbsp;</td>
                                                        <td>&nbsp;</td>
                                                        <td>&nbsp;</td>
                                                        <td>&nbsp;</td>
                                                        <td>&nbsp;</td>
                                                        <td>&nbsp;</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                    	<div style="width: 800px; margin-left: auto; margin-right: auto;">
	                                    	<div class="linea" style="padding-top: 5px;">
		                                   		<div class="casilla" style="text-align: right;">
		                                   			<div id="div_btn_agregar_ttd_encabezado" style="display: inline;">
		                                   				<img id="imgBtnAgregarTTD" alt="" style="cursor:pointer;" onclick="agregaTTD()" src="<c:url value="/resources/image/boton_agregar.jpg"/>">
		                                   				<span id="imgBtnCancelaAgregarTTD" style="cursor: pointer; display: none;" onclick="cancelaAgregarTTD()">
		                                   					<font color="gray">CANCELAR</font>
		                                   				</span>
		                                   				<span id="imgBtnAceptaAgregarTTD" style="cursor: pointer; display: none;" onclick="aceptaAgregarTTD()">
		                                   					<font color="blue">ACEPTAR</font>
		                                   				</span>
		                                   			</div>
		                                   		</div>
		                                   	</div>
	                                    </div>
                                    </c:if>
                                </div>
                                
<!-- div_tipo_trabajo_detalle, display: none -->
                            
                                <div id="div_tipo_trabajo_detalle" style="display:none;">
                                    <form name="tipo_trabajo_detalle" action="" accept-charset="ISO-8859-1">
                                    	<input type="hidden" name="id_orden_produccion" 				value="${ordenProduccion.idOrdenProduccion}"/>
                                    	<input type="hidden" name="nut"									value="${ordenProduccion.nut}">
                                    	<input type="hidden" name="id_partida" 							value="">
                                    	<input type="hidden" name="id_tipo_trabajo_detalle" 			value="">
                                    	<input type="hidden" name="cliente_proporciona_papel" 			value="">
                                    	<input type="hidden" name="cliente_proporciona_placas" 			value="">
                                    	<input type="hidden" name="cliente_proporciona_tinta_especial" 	value="">
                                    	<input type="hidden" name="cliente_proporciona_barniz" 			value="">
                                    	<input type="hidden" name="id_tipo_papel_extendido" 			value="">
                                    	<input type="hidden" name="id_tamanio_publicacion" 				value="">
                                    	<input type="hidden" name="frente_id_combinacion_tintas" 		value="">
                                    	<input type="hidden" name="frente_id_tipo_barniz" 				value="">
                                    	<input type="hidden" name="vuelta_id_combinacion_tintas" 		value="">
                                    	<input type="hidden" name="vuelta_id_tipo_barniz" 				value="">
                                    	<input type="hidden" name="id_maquina" 							value="">
                                    	<input type="hidden" name="id_tipo_placa" 						value="">
                                    	<input type="hidden" name="id_tipo_complejidad" 				value="">
                                    	<br/>
                                        <div class="titulo">
                                            <!--  <img alt="" src="<c:url value="/resources/image/titulo_detalle_partida.png"/>"/> -->
                                            <font size="5">DETALLE DE IMPRESI&Oacute;N</font>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Descripci&oacute;n:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="descripcion_partida_detalle"
                                                                        value=""
                                                                        readonly/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="50%">Alto Final (cm):</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="alto_final" 
                                                                                value=""
                                                                                onkeydown="revisaNumero(true, this.value, event, null, null)"
                                                                                onkeyup="document.getElementsByName('alto_extendido')[0].value=value;"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                        	<table>
                                                                <tr>
                                                                    <td width="58%">Ancho Final (cm):</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="ancho_final" 
                                                                                value=""
                                                                                onkeydown="revisaNumero(true, this.value, event, null, null)"
                                                                                onkeyup="document.getElementsByName('ancho_extendido')[0].value=value;"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="65%">Alto extendido (cm):</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="alto_extendido" 
                                                                                value=""
                                                                                onkeydown="revisaNumero(true, this.value, event, null, null)"
                                                                                onblur="document.getElementsByName('alto_extendido')[0].value=value;"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                        	<table>
                                                                <tr>
                                                                    <td width="74%">Ancho extendido (cm):</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="ancho_extendido" 
                                                                                value=""
                                                                                onkeydown="revisaNumero(true, this.value, event, null, null)"
                                                                                onblur="document.getElementsByName('ancho_extendido')[0].value=value;"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="58%">Cte provee papel:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="proporciona_papel"
                                                                                style="display:inline;"
                                                                                value=""
                                                                                readOnly/>
                                                                        <input 	type="checkbox"
                                                                        		name="checkbox_proporciona_papel"
                                                                        		style="display:none;">
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="62%">Cte provee placas:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="proporciona_placas"
                                                                                style="display:inline;"
                                                                                value=""
                                                                                readOnly/>
                                                                        <input 	type="checkbox"
                                                                        		name="checkbox_proporciona_placas"
                                                                        		style="display:none;">
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="82%">Cte provee tinta especial:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="proporciona_tinta_especial"
                                                                                style="display:inline;"
                                                                                value=""
                                                                                readOnly/>
                                                                        <input	type="checkbox"
                                                                        		name="checkbox_proporciona_tinta_especial"
                                                                        		style="display:none;">
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="60%">Cte provee barniz:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="proporciona_barniz"
                                                                                style="display:inline;"
                                                                                value=""
                                                                                readOnly/>
                                                                        <input	type="checkbox"
                                                                        		name="checkbox_proporciona_barniz"
                                                                        		style="display:none;">
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="div_separador_chico">
                                            <img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
                                        </div>
                                        <div class="titulo">
                                            <img alt="" src="<c:url value="/resources/image/titulo_papel.png"/>"/>
                                        </div>
                        <!--REVISTA: Medianiles + Tamaño publicacion = Tamaño de papel-->
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="18%">Tipo Papel:</td>
                                                                <td>
                                                                    <input  type="text"
                                                                            class="input"
                                                                            name="tipo_papel"
                                                                            style="display:inline;"
                                                                            readonly/>
                                                                    <select name="select_tipo_papel_extendido" 
                                                                        	style="display:none;">
                                                                    	<c:forEach var="tpe" items="${listaTipoPapelExtendido}">
                                                                        	<option value="${tpe.value}">${tpe.text}</option>
                                                                    	</c:forEach>
                                                                	</select>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div id="repeticiones_flyer" class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="66%">N&uacute;mero de flyer por pliego (Repeticiones):</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="repeticiones_x_pliego" 
                                                                            value=""
                                                                            onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                            readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                    <div id="numero_paginas_publicacion" class="mitad_columna_izquierda" style="display:none;">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="56%">N&uacute;mero p&aacute;ginas:</td>
                                                                    <td>
                                                                        <input  type="text"
                                                                                class="input"
                                                                                name="numero_paginas_publicacion"
                                                                                value="0"
                                                                                onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div id="tamanio_publicacion" class="mitad_columna_derecha" style="display:none;">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="1%">Tama&ntilde;o:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="tamanio_pubicacion"
                                                                                style="display:inline;" 
                                                                                value="" 
                                                                                readonly/>
                                                                        <select name="select_tamanio_publicacion"
                                                                        		style="display:none;">
	                                                                        <c:forEach var="tp" items="${listaTamanioPublicacion}">
	                                                                            <option value="${tp.value}">${tp.text}</option>
	                                                                        </c:forEach>
	                                                                    </select>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                        	<div class="casilla">
                                        		<div class="columna_izquierda">
                                        			<div class="mitad_columna_izquierda">
                                        				<div class="columna_completa">
                                        					<table>
                                        						<tr>
                                        							<td width="63%">Alto Corte Inic.(cm)</td>
                                        							<td>
                                        								<input	type="text"
	                                    										class="input"
	                                    										name="alto_corte_inicial"
	                                    										maxlength="4"
	                                    										onkeydown="revisaNumero(true, this.value, event, null, null)"
	                                    										readonly/>
                                        							</td>
                                        						</tr>
                                        					</table>
                                        				</div>
                                        			</div>
                                        			<div class="mitad_columna_derecha">
                                        				<div class="columna_completa">
                                        					<table>
                                        						<tr>
                                        							<td width="73%">Ancho Corte Inic. (cm)</td>
                                        							<td>
                                        								<input 	type="text"
	                                    										class="input"
	                                    										name="ancho_corte_inicial"
	                                    										maxlength="4"
	                                    										onkeydown="revisaNumero(true, this.value, event, null, null)"
	                                    										readonly/>
                                        							</td>
                                        						</tr>
                                        					</table>
                                        				</div>
                                        			</div>
                                        		</div>
                                        	</div>
                                        </div>
                                        <div class="div_separador_chico">
                                            <img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
                                        </div>
                                        <div class="titulo">
                                            <img alt="" src="<c:url value="/resources/image/titulo_tinta.png"/>"/>
                                        </div>
                                        <div>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <img alt="" src="<c:url value="/resources/image/titulo_frente.png"/>"/>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="40%">Num. Tinta:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="frente_combinacion_tintas"
                                                                                style="display:inline;"
                                                                                value=""
                                                                                readonly/>
                                                                        <select name="select_frente_combinacion_tintas"
                                                                        		style="display:none;">
	                                                                        <c:forEach var="ct" items="${listaCombinacionTintas}">
	                                                                            <option value="${ct.value}">${ct.text}</option>
	                                                                        </c:forEach>
	                                                                    </select>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="68%">Num. Tinta Especial:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="frente_num_tinta_especial" 
                                                                                value=""
                                                                                onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="41%">Descripci&oacute;n tinta especial:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="frente_descripcion_tinta_especial"
                                                                            value="" 
                                                                            readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                            <!--<div class="columna_izquierda_tres_cuartos">-->
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="19%">Tipo barniz:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input" 
                                                                            name="frente_tipo_barniz"
                                                                            style="display:inline;" 
                                                                            value="" 
                                                                            readonly/>
                                                                    <select name="select_frente_tipo_barniz"
                                                                    		style="display:none;">
	                                                                    <c:forEach var="tb" items="${listaTipoBarniz}">
	                                                                        <option value="${tb.value}">${tb.text}</option>
	                                                                    </c:forEach>
	                                                                </select>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                            <img alt="" src="<c:url value="/resources/image/titulo_vuelta.png"/>"/>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="mitad_columna_izquierda">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="40%">Num. Tinta:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input" 
                                                                                name="vuelta_combinacion_tintas"
                                                                                style="display:inline;" 
                                                                                value="" 
                                                                                readonly/>
                                                                        <select name="select_vuelta_combinacion_tintas"
                                                                        		style="display:none;">
	                                                                        <c:forEach var="ct" items="${listaCombinacionTintas}">
	                                                                            <option value="${ct.value}">${ct.text}</option>
	                                                                        </c:forEach>
	                                                                    </select>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="mitad_columna_derecha">
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="68%">Num. Tinta Especial:</td>
                                                                    <td>
                                                                        <input  type="text" 
                                                                                class="input"
                                                                                name="vuelta_num_tinta_especial" 
                                                                                value=""
                                                                                onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                                readonly/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="41%">Descripci&oacute;n tinta especial:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="vuelta_descripcion_tinta_especial"
                                                                            value="" 
                                                                            readonly/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                            <!--<div class="columna_izquierda_tres_cuartos">-->
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="19%">Tipo barniz:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input" 
                                                                            name="vuelta_tipo_barniz"
                                                                            style="display:inline;" 
                                                                            value="" 
                                                                            readonly/>
                                                                    <select name="select_vuelta_tipo_barniz"
                                                                    		style="display:none;">
	                                                                    <c:forEach var="tb" items="${listaTipoBarniz}">
	                                                                        <option value="${tb.value}">${tb.text}</option>
	                                                                    </c:forEach>
	                                                                </select>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="div_separador_chico">
                                            <img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
                                        </div>
                                        <div class="titulo">
                                            <img alt="" src="<c:url value="/resources/image/titulo_placa.png"/>"/>
                                        </div>
                                        <div class="linea">
                                            <div class="casilla">
                                                <div class="columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="1%">M&aacute;quina:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input" 
                                                                            name="maquina" 
                                                                            style="display:inline;"
                                                                            value="" 
                                                                            readonly/>
                                                                    <select name="select_maquina"
                                                                    		style="display:none;" 
	                                                                        onchange="buscaTipoPlaca( this );">
	                                                                    <c:forEach var="m" items="${listaMaquina}">
	                                                                        <option value="${m.value}">${m.text}</option>
	                                                                    </c:forEach>
	                                                                </select>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="18%">Tipo placa:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input" 
                                                                            name="tipo_placa"
                                                                            style="display:inline;" 
                                                                            value="" 
                                                                            readonly/>
                                                                    <select name="select_tipo_placa"
                                                                    		style="display:none;"></select>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="linea">
                                        	<div class="casilla">
                                        		<div class="columna_izquierda">
                                        			<div class="columna_completa">
                                        				<table>
                                        					<tr>
                                        						<td width="33%">Tipo de Complejidad</td>
	                                    						<td>
	                                    							<input	type="text"
	                                    									class="input"
	                                    									name="tipo_complejidad"
	                                    									style="display:inline;"
	                                    									value=""
	                                    									readonly/>
	                                    							<select name="select_tipo_complejidad"
	                                    									style="display:none;">
	                                    								<c:forEach var="x" items="${listaTipoComplejidad}">
	                                    									<option value="${x.value}">${x.text}</option>
	                                    								</c:forEach>
	                                    							</select>
                                    							</td>
                                        					</tr>
                                        				</table>
                                        			</div>
                                        		</div>
                                        	</div>
                                        </div>
                                        <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                        	<div class="linea">
	                                        	<div class="casilla" style="text-align:right;">
	                                        		<div id="div_btn_actualizar_ttd_encabezado">
	                                        			<img id="imgBtnModificarTTD" alt="" style="cursor:pointer;" onclick="modificaTTD()" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
	                                        			<span id="imgBtnCancelaModificarTTD" style="cursor:pointer; display:none;" onclick="cancelaModificarTTD()">
	                                        				<font color="gray">CANCELAR</font>
	                                        			</span>
	                                        			<span id="imgBtnAceptaEliminarTTD" style="cursor: pointer; display: none;" onclick="aceptaEliminarTTD()">
	                                        				<font color="#FFCC00">ELIMINAR</font>
	                                        			</span>
	                                        			<span id="imgBtnAceptaModificarTTD" style="cursor:pointer; display:none;" onclick="aceptaModificarTTD()">
	                                        				<font color="blue">ACEPTAR</font>
	                                        			</span>
	                                        		</div>
	                                        	</div>
	                                        </div>
                                        </c:if>
                                    </form>
                                </div>
                                
<!-- div_visualizador_pliegos, display: none -->

                                <div id="div_visualizador_pliegos" style="display:none;">
                                    <form name="visualizador_pliegos" action="" accept-charset="ISO-8859-1">
                                    	<input type="hidden" name="id_orden_produccion" value="${ordenProduccion.idOrdenProduccion}"/>
                                    	<input type="hidden" name="id_tipo_trabajo_detalle" value=""/>
                                    	<input type="hidden" name="id_pliego" value=""/>
                                        <div class="div_separador_mediano">
                                            <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                        </div>                                
                                        <div class="titulo">
                                            <font size="5">LISTA DE PLIEGOS</font>
                                        </div>
                                        <div style="width:800px; height:150px; margin-left:auto; margin-right:auto;">
                                            <div class="columna_completa">
                                                <div id="div_tabla_lista_pliegos" style="overflow:scroll;">
                                                    <table id="tabla_lista_pliegos">
                                                        <tr>
                                                            <th>No. Pgo</th>
                                                            <th>Rebase (mm.)</th>
                                                            <th>Medianiles (mm.)</th>
                                                            <th>Pinzas (mm.)</th>
                                                            <th>H. Requeridas</th>
                                                            <th>H. Sobrantes</th>
                                                            <th>H. Totales</th>
                                                            <th width="20%">Observaciones</th>
                                                            <th>Frente Ent. M&aacute;quina</th>
                                                            <th>Frente Num. Placas</th>
                                                            <th>Vuelta Ent. M&aacute;quina</th>
                                                            <th>Vuelta Num. Placas</th>
                                                        </tr>
                                                        <tr class="l1">
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                        <tr class="l2">
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <td><i>TOTAL</i></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td><i>&nbsp;</i></td>
                                                            <td><i>&nbsp;</i></td>
                                                            <td><i>&nbsp;</i></td>
                                                            <td></td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                        	<div style="width:800px; margin-left: auto; margin-right: auto; overflow-x: scroll;">
                                        		<div class="linea" style="padding-top: 5px;">
                                        			<div class="casilla" style="text-align: right;">
                                        				<div id="div_btn_actualizar_pliego">
                                        					<img id="imgBtnModificarPliego" alt="" style="cursor:pointer;" onclick="modificaTablaPliego();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
                                        					
                                        					<span id="imgBtnCancelaModificarPliego" style="cursor:pointer; display:none;" onclick="cancelaModificarPliego();">
			                                    				<font color="gray">CANCELAR</font>
			                                    			</span>
			                                    			<span id="imgBtnAceptaModificarPliego" style="cursor:pointer; display:none;" onclick="aceptaModificarPliego();">
			                                    				<font color="blue">ACEPTAR</font>
			                                    			</span>
                                        				</div>
                                        			</div>
                                        		</div>
                                        	</div>
                                        	<div style="width: 100%;">
	                                        	<div class="linea">
	                                        		<div class="casilla">
	                                        			<div class="columna_izquierda">
	                                        				<div class="mitad_columna_izquierda">
	                                        					<div class="columna_completa">
	                                        						<table>
	                                        							<tr>
	                                        								<td width="1%">Pliego:</td>
	                                        								<td>
	                                        									<input 	type="text"
	                                        											class="input"
	                                        											name="numero_pliego"
	                                        											value=""
	                                        											readonly/>
	                                        								</td>
	                                        							</tr>
	                                        						</table>
	                                        					</div>
	                                        				</div>
	                                        				<div class="mitad_columna_derecha">
	                                        					<div class="columna_completa">
	                                        						<table>
	                                        							<tr>
	                                        								<td width="1%">Rebases:</td>
	                                        								<td>
	                                        									<input 	type="text"
	                                        											class="input"
	                                        											name="rebases"
	                                        											value=""
	                                        											maxlength="2"
	                                        											onkeydown="revisaNumero(false, this.value, event, null, null)"
	                                        											readonly/>
	                                        								</td>
	                                        							</tr>
	                                        						</table>
	                                        					</div>
	                                        				</div>
	                                        			</div>
	                                        			<div class="columna_derecha">
	                                        				<div class="mitad_columna_izquierda">
	                                        					<div class="columna_completa">
	                                        						<table>
	                                        							<tr>
	                                        								<td width="1%">Medianiles:</td>
	                                        								<td>
	                                        									<input 	type="text"
	                                        											class="input"
	                                        											name="medianiles"
	                                        											value=""
	                                        											maxlength="2"
	                                        											onkeydown="revisaNumero(false, this.value, event, null, null)"
	                                        											readonly/>
	                                        								</td>
	                                        							</tr>
	                                        						</table>
	                                        					</div>
	                                        				</div>
	                                        				<div class="mitad_columna_derecha">
	                                        					<div class="columna_completa">
	                                        						<table>
	                                        							<tr>
	                                        								<td width="1%">Pinzas:</td>
	                                        								<td>
	                                        									<input 	type="text"
	                                        											class="input"
	                                        											name="pinzas"
	                                        											value=""
	                                        											maxlength="2"
	                                        											onkeydown="revisaNumero(false, this.value, event, null, null)"
	                                        											readonly/>
	                                        								</td>
	                                        							</tr>
	                                        						</table>
	                                        					</div>
	                                        				</div>
	                                        			</div>
	                                        		</div>
	                                        	</div>
	                                        	<div class="linea">
	                                        		<div class="casilla">
	                                        			<div class="columna_izquierda">
	                                        				<div class="mitad_columna_derecha">
	                                        					<div class="columna_completa">
	                                        						<table>
	                                        							<tr>
	                                        								<td width="25%">H. Sob:</td>
	                                        								<td>
	                                        									<input 	type="text"
	                                        											class="input"
	                                        											name="hojas_sobrantes"
	                                        											value=""
	                                        											onkeydown="revisaNumero(false, this.value, event, null, null)"
	                                        											readonly/>
	                                        								</td>
	                                        							</tr>
	                                        						</table>
	                                        					</div>
	                                        				</div>
	                                        			</div>
	                                        			<div class="columna_derecha">
	                                        				<div class="columna_completa">
	                                        					<table>
	                                        						<tr>
	                                        							<td width="1%">Observaciones:</td>
	                                        							<td>
	                                        								<input 	type="text"
	                                       											class="input"
	                                       											name="observaciones"
	                                       											value=""
	                                       											readonly/>
	                                        							</td>
	                                        						</tr>
	                                        					</table>
	                                        				</div>
	                                        			</div>
	                                        		</div>
	                                        	</div>
	                                        </div>
                                        </c:if>
                                        <br/>
                                    </form>
                                </div>
                                
<!-- div_descuento_tabulador_precios, display: none -->

								<div id="div_descuento_tabulador_precios" style="display:none;">
									<div class="div_separador_mediano">
										<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
									</div>
									<div class="titulo">
										<font size="5">¿DESEA APLICAR PRECIO POR MILLAR DE IMPRESI&Oacute;N?</font>
									</div>
									<form name="descuento" action="" accept-charset="ISO-8859-1">
										<input type="hidden" name="id_orden_produccion"				value="${ordenProduccion.idOrdenProduccion}"/>
										<input type="hidden" name="id_tipo_trabajo_detalle" 		value=""/>
										<input type="hidden" name="aplica_descuento" 				value=""/>
										<input type="hidden" name="id_tipo_precio" 					value=""/>
										<div class="linea">
											<div class="casilla">
												<div class="columna_izquierda">
													<div class="mitad_columna_izquierda">
														<div class="columna_completa">
															<table>
																<tr>
																	<td width="65%">
																		<span style="cursor: pointer;" onclick="document.descuento.chkbx_aplica_descuento.click()">¿Aplica descuento?:</span></td>
																	<td>
																		<input	type="text"
																				class="input"
																				name="input_aplica_descuento"
																				style="display: inline;"
																				value=""
																				readonly/>
																		<input 	type="checkbox"
																				name="chkbx_aplica_descuento"
																				style="display: none;"/>
																	</td>
																</tr>
															</table>
														</div>
													</div>
													<div class="mitad_columna_derecha">
														<div class="columna_completa">
															<table>
																<tr>
																	<td width="1%">Tabulador:</td>
																	<td>
																		<input	type="text"
																				class="input"
																				name="input_tabulador"
																				style="display: inline;"
																				value=""
																				readonly/>
																		<select name="select_precio_tabulador" 
																				id="select_precio_tabulador"  
																				onchange="document.descuento.precio_tabulador.value = this.value"
																				style="display: none;"></select>
																	</td>
																</tr>
															</table>
														</div>
													</div>
												</div>
												<div class="columna_derecha">
													<div class="mitad_columna_izquierda">
														<div class="columna_completa">
															<table>
																<tr>
																	<td width="69%">Precio seleccionado:</td>
																	<td>
																		<input 	type="text"
																				class="input"
																				name="precio_tabulador"
																				maxlength="5"
																				onkeydown="revisaNumero(true, this.value, event, 'null', 'null')"
																				readonly/>
																	</td>
																</tr>
															</table>
														</div>
													</div>
													<div class="mitad_columna_derecha">
														<div class="columna_completa">
															<table>
																<tr>
																	<td width="41%">Tipo precio:</td>
																	<td>
																		<input type="text"
																				class="input"
																				name="tipo_precio"
																				style="display: inline;"
																				readonly/>
																		<select name="select_tipo_precio" id="select_tipo_precio"
																				style="display: none;">
																			<c:forEach var="tp" items="${listaTipoPrecio}">
																				<option value="${tp.value}">${tp.text}</option>
																			</c:forEach>
																		</select>
																	</td>
																</tr>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
										<c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
											<div class="linea">
												<div class="casilla" style="text-align: right;">
													<div id="div_btn_actualizar_descuento">
														<img id="imgBtnModificarDescuento" alt="" style="cursor: pointer;" onclick="modificaDescuento()" src="<c:url value="/resources/image/boton_modificar.jpg"/>"/>
														<span id="imgBtnCancelaModificarDescuento" style="cursor: pointer; display: none;" onclick="cancelaModificarDescuento()">
															<font color="gray">CANCELAR</font>
														</span>
														<span id="imgBtnAceptaModificarDescuento" style="cursor: pointer; display: none;" onclick="aceptaModificarDescuento()">
															<font color="blue">ACEPTAR</font>
														</span>
													</div>
												</div>
											</div>
										</c:if>
									</form>
								</div>
                                
<!-- div_visualizador_costo_extra_detalle, display:none; -->

								<div id="div_visualizador_costo_extra_detalle" style="display:none;">
	                            	<div class="div_separador_mediano">
	                                    <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
	                                </div>
	                                <div class="titulo">
	                                    <font size="5">LISTA COSTO EXTRA POR DETALLE DE IMPRESI&Oacute;N</font>
	                                </div>
	                                <div style="width:800px; height:100px; margin-left:auto; margin-right:auto; overflow-x:scroll;">
	                                	<div class="columna_completa">
	                                		<div id="div_tabla_costo_extra_tipo_trabajo">
												<table id="tabla_lista_costo_extra_tipo_trabajo">
													<tr>
														<th>No.</th>
														<th>Costo Extra</th>
														<th>Responsable</th>
														<th>Cantidad</th>
														<th>Especificaci&oacute;n</th>
													</tr>
												<c:choose>
													<c:when test="${fn:length(listaCostoExtraDetalle) gt 0}">
														<c:forEach var="costoExtraDetalle" items="${listaCostoExtraDetalle}" varStatus="i">
															<tr class='${i.count%2==0?"l2":"l1"}'  
																onclick="setCampos('${i.count}','${costoExtraDetalle.idCostoExtraDetalle}','${costoExtraDetalle.responsableInsumo.nombre}','${costoExtraDetalle.costoExtra.nombre}','${costoExtraDetalle.cantidad}','${costoExtraDetalle.especificacion}')">
																<td>${i.count}</td>
																<td>${costoExtraDetalle.responsableInsumo.nombre}</td>
																<td>${costoExtraDetalle.costoExtra.nombre}</td>
																<td>${costoExtraDetalle.cantidad}</td>
																<td>${costoExtraDetalle.especificacion}</td>
															</tr>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<tr class="l1">
															<td>&nbsp;</td>
															<td>&nbsp;</td>
															<td>&nbsp;</td>
															<td>&nbsp;</td>
															<td>&nbsp;</td>
														</tr>														
													</c:otherwise>
												</c:choose>
												</table>
											</div>
	                                	</div>
	                                </div>
	                                <c:if test="${historialEstatus.estatusOrden.idEstatusOrden != estatus_finalizado}">
	                                	<div style="width:800px; margin-left:auto; margin-right:auto; overflow-x:scroll;">
		                                	<div class="linea" style="padding-top:5px;">
			                                	<div class="casilla" style="text-align:right;">
			                                		<div id="div_btn_actualizar_costo_extra_detalle">
			                                			<img id="imgBtnModificarCostoExtraDetalle" alt="" style="cursor:pointer;" onclick="modificaTablaCostoExtraDetalle();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
			                                                        			
		                                    			<span id="imgBtnCancelaModificarCostoExtraDetalle" style="cursor:pointer; display:none;" onclick="cancelaModificarCostoExtraDetalle();">
		                                    				<font color="gray">CANCELAR</font>
		                                    			</span>
		                                    			<span id="imgBtnAceptaEliminarCostoExtraDetalle" style="cursor:pointer; display:none;" onclick="aceptaEliminarCostoExtraDetalle();">
		                                               		<font color="#FFCC00">ELIMINAR</font>
		                                               	</span>
		                                    			<span id="imgBtnAceptaModificarCostoExtraDetalle" style="cursor:pointer; display:none;" onclick="aceptaModificarCostoExtraDetalle();">
		                                    				<font color="blue">ACEPTAR</font>
		                                    			</span>
		                                			</div>
		                                		</div>
		                                	</div>
		                                </div>
	                                </c:if>
	                            </div>
	                            
<!-- div_costo_extra_detalle, display:none; -->
	
								<div id="div_costo_extra_detalle" style="display:none;">
									<form name="costo_extra_detalle" action="" accept-charset="ISO-8859-1">
										<input type="hidden" name="id_orden_produccion"		value="${ordenProduccion.idOrdenProduccion}"/>
										<input type="hidden" name="nut" 					value="${ordenProduccion.nut}"/>
										<input type="hidden" name="id_costo_extra_detalle"	value=""/>
										<input type="hidden" name="id_tipo_trabajo_detalle" value=""/>
										<input type="hidden" name="id_responsable_insumo" 	value=""/>
										<input type="hidden" name="id_costo_extra" 			value=""/>
										<div class="div_separador_chico">
											<img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
										</div>
		                                <div class="titulo">
		                                    <font size="5">COSTO EXTRA</font>
		                                </div>
		                                <div class="linea">
		                                	<div class="casilla">
		                                		<div class="columna_izquierda">
		                                			<div class="mitad_columna_izquierda">
		                                				<div class="columna_completa">
			                                				<table>
			                                					<tr>
			                                						<td width="41%">Costo Extra:</td>
			                                						<td>
			                                							<input	type="text"
			                                									class="input"
			                                									name="costo_extra"
			                                									style="display:inline;"
			                                									value=""
			                                									readonly/>
			                                							<select name="select_costo_extra" id="select_costo_extra" style="display:none;" onchange="ajaxUnidadCostoExtra()" disabled></select>
			                                						</td>
			                                					</tr>
			                                				</table>
			                                			</div>
		                                			</div>
		                                			<div class="mitad_columna_derecha">
		                                				<div class="columna_completa">
			                                				<table>
			                                					<tr>
			                                						<td width="1%">Responsable:</td>
			                                						<td>
			                                							<input	type="text"
			                                									class="input"
			                                									name="responsable_insumo_costo_extra"
			                                									style="display:inline;"
			                                									value=""
			                                									readonly/>
			                                							<select name="select_responsable_insumo" style="display:none;" disabled>
																			<c:forEach var="ri" items="${listaResponsableInsumo}">
																				<option value="${ri.value}">${ri.text}</option>
																			</c:forEach>
			                                							</select>
			                                						</td>
			                                					</tr>
			                                				</table>
			                                			</div>
		                                			</div>
		                                		</div>
		                                		<div class="columna_derecha">
		                                			<div class="mitad_columna_izquierda">
		                                				<div class="columna_completa">
		                                					<table>
			                                					<tr>
			                                						<td width="1%">Cantidad:</td>
			                                						<td>
			                                							<input	type="text"
			                                									class="input"
			                                									name="cantidad"
			                                									value=""
			                                									onkeydown="revisaNumero(false, this.value, event, null, null)"
			                                									readonly/>
			                                						</td>
			                                					</tr>
			                                				</table>
		                                				</div>
		                                			</div>
		                                			<div class="mitad_columna_derecha">
		                                				<div class="columna_completa">
		                                					<table>
			                                					<tr>
			                                						<td width="38%">Medido en:</td>
			                                						<td>
			                                							<input	type="text"
			                                									class="input"
			                                									name="nombre_unidad_medida"
			                                									value=""
			                                									readonly/>
			                                						</td>
			                                					</tr>
			                                				</table>
		                                				</div>
		                                			</div>
		                                		</div>
		                                	</div>
		                                </div>
		                                <div class="linea">
		                                	<div class="casilla">
		                                		<div class="columna_izquierda">
		                                			<div class="columna_completa">
		                                				<table>
			                                				<tr>
			                                					<td width="1%">Especificaci&oacute;n:</td>
			                                					<td>
			                                						<input	type="text"
			                                								class="input"
			                                								name="especificacion"
			                                								value=""
			                                								readonly/>
			                                					</td>
			                                				</tr>
			                                			</table>
		                                			</div>
		                                		</div>
		                                	</div>
		                                </div>
		                                <c:if test="${historialEstatus.estatusOrden.idEstatusOrden != estatus_finalizado}">
		                                	<div class="linea">
			                                	<div class="casilla" style="text-align:right;">
			                                		<div id="div_btn_agregar_costo_extra_detalle">
			                                			<img id="imgBtnAgregarCostoExtraDetalle" alt="" style="cursor:pointer;" onclick="agregaCostoExtraDetalle();" src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
			                                            <span id="imgBtnCancelaAgregarCostoExtraDetalle" style="cursor:pointer; display:none" onclick="cancelaAgregarCostoExtraDetalle();">
			                                            	<font color="gray">CANCELAR</font>
			                                            </span>     
			                                            <span id="imgBtnAceptaAgregarCostoExtraDetalle" style="cursor:pointer; display:none;" onclick="aceptaAgregarCostoExtraDetalle();">
			                                            	<font color="blue">ACEPTAR</font>
			                                            </span>
			                                		</div>
			                                	</div>
			                                </div>
		                                </c:if>
	                                </form>
								</div>
								  
<!-- div_pestania, display: none -->
							
                                <div id="div_pestania" style="display:none;">
                                    <div class="div_separador_grande">
                                        <img alt="" src="<c:url value="/resources/image/separador_grande.png"/>"/>
                                    </div>
                                    <div class="titulo">
                                        <font size="5">DETALLE DE &Aacute;REAS POR TRABAJO</font>
                                    </div>
                                    <div id="div_pestania_menu">
                                        <div id="div_pestania_menu_disenio" onclick="menu(this);" style="cursor:pointer; background:#7FAADC;">
                                            Dise&ntilde;o
                                        </div>
                                        <div id="div_pestania_menu_preprensa" onclick="menu(this);" style="cursor:pointer;">
                                            Preprensa
                                        </div>
                                        <div id="div_pestania_menu_transporte" onclick="menu(this);" style="cursor:pointer;">
                                            Transporte
                                        </div>
                                        <div id="div_pestania_menu_acabado" onclick="menu(this);" style="cursor:pointer;">
                                            Acabado
                                        </div>
                                        <div id="div_pestania_menu_offset" onclick="menu(this);" style="cursor:pointer;">
                                            Offset
                                        </div>
                                    </div>
                                    <div id="div_pestania_contenido">
                                        <div id="div_pestania_contenido_disenio" style="display:block;">
                                            <div id="div_disenio">
                                                <div id="div_disenio_general">
                                                    <form name="disenio" action="" accept-charset="utf-8">
                                                        <input type="hidden" name="id_disenio" value="">
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="1%">Indicaciones:</td>
                                                                            <td>
                                                                                <input  type="text" 
                                                                                        class="input" 
                                                                                        name="indicacion_tarea_realizar" 
                                                                                        value="" 
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="15%">Materiales recibe:</td>
                                                                            <td>
                                                                                <input  type="text" 
                                                                                        class="input" 
                                                                                        name="materiales_recibe" 
                                                                                        value="" 
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="1%">Observaciones:</td>
                                                                            <td>
                                                                                <input  type="text" 
                                                                                        class="input" 
                                                                                        name="observaciones" 
                                                                                        value="" 
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <c:choose>
                                                        	<c:when test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
	                                                        	<div class="linea">
		                                                        	<div class="casilla" style="text-align:right;">
		                                                        		<div id="div_btn_modificar_disenio" >
			                                                            	<img id="imgBtnModificaDisenio" alt="" style="cursor:pointer;" onclick="modificaDisenio();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
			                                                            	<span id="imgBtnCancelaModificarDisenio" style="cursor:pointer; display:none;" onclick="cancelaModificarDisenio();">
			                                                            		<font color="gray">CANCELAR</font>
			                                                            	</span>
			                                                            	<span id="imgBtnAceptaModificarDisenio" style="cursor:pointer; display:none;" onclick="aceptaModificarDisenio();">
			                                                            		<font color="blue">ACEPTAR</font>
			                                                            	</span>
			                                                            </div>
		                                                        	</div>
		                                                        </div>
	                                                        </c:when>
	                                                        <c:otherwise>
	                                                        	<div class="linea"></div>
	                                                        </c:otherwise>
                                                        </c:choose>
                                                    </form>
                                                </div>
                                                <div id="div_disenio_particular">
                                                    <div id="div_disenio_panel_izquierdo">
                                                        <form name="disenio_detalle" action="" accept-charset="utf-8">
                                                        	<input type="hidden" name="id_orden_produccion"	value="${ordenProduccion.idOrdenProduccion}">
                                                        	<input type="hidden" name="nut"					value="${ordenProduccion.nut}">
                                                            <input type="hidden" name="id_partida"          value="">
                                                        	<input type="hidden" name="id_disenio_detalle"	value="">
                                                            <input type="hidden" name="id_disenio"          value="">
                                                            <input type="hidden" name="id_proceso_disenio"  value="">
                                                            <div id="div_select_proceso_disenio">
                                                                <select name="select_proceso_disenio" id="select_proceso_disenio" size="5" onclick="selectDisenioDetalleClick(this);" disabled></select>
                                                            </div>
                                                            <div id="div_form_disenio_detalle">
                                                                <div class="linea">
                                                                    <div class="casilla">
                                                                        <div class="columna_completa">
                                                                            <table>
                                                                                <tr>
                                                                                    <td width="1%">Detalle:</td>
                                                                                    <td>
                                                                                        <input  type="text"
                                                                                                class="input"
                                                                                                name="detalle"
                                                                                                value=""
                                                                                                readonly/>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="linea">
                                                                    <div class="casilla">
                                                                        <div class="cuarto_columna_izquierda">
                                                                            <div class="columna_completa">
                                                                                <table>
                                                                                    <tr>
                                                                                        <td width="1%">Cantidad:</td>
                                                                                        <td>
                                                                                            <input  type="text"
                                                                                                    class="input"
                                                                                                    name="cantidad"
                                                                                                    value=""
                                                                                                    onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                                                    readonly/>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                        <div class="cuarto_columna_derecha">
                                                                            <div class="columna_completa">
                                                                                <table>
                                                                                    <tr>
                                                                                        <td width="1%">Precio:</td>
                                                                                        <td>
                                                                                            <input  type="text"
                                                                                                    class="input"
                                                                                                    name="precio_total_pesos"
                                                                                                    title="Precio total en pesos"
                                                                                                    value=""
                                                                                                    onkeydown="revisaNumero(true, this.value, event, null, null)"
                                                                                                    readonly/>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="doble_linea">
                                                                    <div class="casilla_doble_alto">
                                                                        <div class="columna_completa">
                                                                            <table>
                                                                                <tr>
                                                                                    <td width="1%" valign="top" style="padding-top:4px;" >Especif.:</td>
                                                                                    <td>
                                                                                        <textarea   class="textarea_doble"
                                                                                                    name="especificaciones"
                                                                                                    disabled></textarea>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                                	<div class="linea">
	                                                                    <div class="casilla" style="text-align:right;">
	                                                                    	<div id="div_btn_agregar_disenio_detalle">
	                                                                    		<img id="imgBtnAgregarDisenioDetalle" alt="" style="cursor:pointer;" onclick="agregaDisenioDetalle();" src="<c:url value="/resources/image/boton_agregar.jpg"/>">
		                                                                    	<span id="imgBtnCancelaAgregarDisenioDetalle" style="cursor:pointer; display:none" onclick="cancelaAgregarDisenioDetalle();">
		                                                                    		<font color="gray">CANCELAR</font>
		                                                                    	</span>
		                                                                    	<span id="imgBtnAceptaAgregarDisenioDetalle" style="cursor:pointer; display:none;" onclick="aceptaAgregarDisenioDetalle();">
		                                                                    		<font color="blue">ACEPTAR</font>
		                                                                    	</span>
	                                                                    	</div>
	                                                                    </div>
	                                                                </div>
                                                                </c:if>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <div id="div_disenio_panel_derecho">
                                                        <div id="div_contenedor_tabla_disenio_detalle" style=""> <!-- height:165px; -->
                                                            <div class="columna_completa">
                                                                <div id="div_tabla_lista_disenio_detalle">
                                                                    <table>
                                                                        <tr>
                                                                            <th>No.</th>
                                                                            <th>Descripci&oacute;n</th>
                                                                            <th>Cantidad</th>
                                                                            <th>Especificaci&oacute;n</th>
                                                                        </tr>
                                                                    
                                                                        <tr class="l1">
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                        	<div class="linea" style="padding-top:5px;">
	                                                        	<div class="casilla" style="text-align:right;">
	                                                        		<div id="div_btn_actualizar_disenio_detalle">
	                                                        			<img id="imgBtnModificarDisenioDetalle" alt="" style="cursor:pointer;" onclick="modificaTablaDisenioDetalle();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
	                                                        			
	                                                        			<span id="imgBtnCancelaModificarDisenioDetalle" style="cursor:pointer; display:none;" onclick="cancelaModificarDisenioDetalle();">
	                                                        				<font color="gray">CANCELAR</font>
	                                                        			</span>
	                                                        			<span id="imgBtnAceptaEliminarDisenioDetalle" style="cursor:pointer; display:none;" onclick="aceptaEliminarDisenioDetalle();">
	                                                                   		<font color="#FFCC00">ELIMINAR</font>
	                                                                   	</span>
	                                                        			<span id="imgBtnAceptaModificarDisenioDetalle" style="cursor:pointer; display:none;" onclick="aceptaModificarDisenioDetalle();">
	                                                        				<font color="blue">ACEPTAR</font>
	                                                        			</span>
	                                                        		</div>
	                                                        	</div>
	                                                        </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="div_pestania_contenido_preprensa" style="display:none;">
                                            <div id="div_preprensa">
                                                <div id="div_preprensa_general">
                                                    <form name="preprensa" action="" accept-charset="utf-8">
                                                    	<input type="hidden" name="id_preprensa" 	value="">
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="1%">Indicaciones:</td>
                                                                            <td>
                                                                                <input  type="text"
                                                                                        class="input"
                                                                                        name="indicacion_tarea_realizar"
                                                                                        value=""
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="15%">Materiales recibe:</td>
                                                                            <td>
                                                                                <input  type="text"
                                                                                        class="input"
                                                                                        name="materiales_recibe"
                                                                                        value=""
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="1%">Observaciones:</td>
                                                                            <td>
                                                                                <input  type="text"
                                                                                        class="input"
                                                                                        name="observaciones"
                                                                                        value=""
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <c:choose>
                                                        	<c:when test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
	                                                        	<div class="linea">
		                                                            <div class="casilla" style="text-align:right;">
		                                                            	<div id="div_btn_modificar_preprensa">
		                                                            		<img id="imgBtnModificaPreprensa" alt="" style="cursor:pointer;" onclick="modificaPreprensa();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
		                                                            		<span id="imgBtnCancelaModificarPreprensa" style="cursor: pointer; display:none;" onclick="cancelaModificarPreprensa();">
		                                                            			<font color="gray">CANCELAR</font>
		                                                            		</span>
		                                                            		<span id="imgBtnAceptaModificarPreprensa" style="cursor:pointer; display:none;" onclick="aceptaModificarPreprensa();">
		                                                            			<font color="blue">ACEPTAR</font>
		                                                            		</span>
		                                                            	</div>
		                                                            </div>
		                                                        </div>
	                                                        </c:when>
	                                                        <c:otherwise>
	                                                        	<div class="linea"></div>
	                                                        </c:otherwise>
                                                        </c:choose>
                                                        
                                                    </form>
                                                </div>
                                                <div id="div_preprensa_particular">
                                                    <div id="div_preprensa_panel_izquierdo">
                                                        <form name="preprensa_detalle" action="" accept-charset="utf-8">
                                                        	<input type="hidden" name="id_orden_produccion"		value="${ordenProduccion.idOrdenProduccion}">
                                                        	<input type="hidden" name="nut"						value="${ordenProduccion.nut}">
                                                            <input type="hidden" name="id_partida"          	value="">
                                                        	<input type="hidden" name="id_preprensa_detalle"	value="">
                                                            <input type="hidden" name="id_preprensa"            value=""/>
                                                            <input type="hidden" name="id_proceso_preprensa"    value=""/>
                                                            <div id="div_select_proceso_preprensa">
                                                                <select name="select_proceso_preprensa" id="select_proceso_preprensa" size="5" onclick="selectPreprensaDetalleClick(this);" disabled></select>
                                                            </div>
                                                            <div id="div_form_preprensa_detalle">
                                                                <div class="linea">
                                                                    <div class="casilla">
                                                                        <div class="columna_completa">
                                                                            <table>
                                                                                <tr>
                                                                                    <td width="1%">Detalle:</td>
                                                                                    <td>
                                                                                        <input  type="text"
                                                                                                class="input"
                                                                                                name="detalle"
                                                                                                value=""
                                                                                                readonly/>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="linea">
                                                                    <div class="casilla">
                                                                        <div class="cuarto_columna_izquierda">
                                                                            <div class="columna_completa">
                                                                                <table>
                                                                                    <tr>
                                                                                        <td width="1%">Cantidad:</td>
                                                                                        <td>
                                                                                            <input  type="text"
                                                                                                    class="input"
                                                                                                    name="cantidad"
                                                                                                    value=""
                                                                                                    onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                                                    readonly/>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                        <div class="cuarto_columna_derecha">
                                                                            <div class="columna_completa">
                                                                                <table>
                                                                                    <tr>
                                                                                        <td width="1%">Precio:</td>
                                                                                        <td>
                                                                                            <input  type="text"
                                                                                                    class="input"
                                                                                                    name="precio_total_pesos"
                                                                                                    title="Precio total en pesos"
                                                                                                    value=""
                                                                                                    onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                                                    readonly/>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="doble_linea">
                                                                    <div class="casilla_doble_alto">
                                                                        <div class="columna_completa">
                                                                            <table>
                                                                                <tr>
                                                                                    <td width="1%" valign="top" style="padding-top:4px;" >Especif.:</td>
                                                                                    <td>
                                                                                        <textarea   class="textarea_doble"
                                                                                                    name="especificaciones"
                                                                                                    disabled></textarea>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                                	<div class="linea">
	                                                                    <div class="casilla" style="text-align:right;">
	                                                                        <div id="div_btn_agregar_preprensa_detalle">
	                                                                        	<img id="imgBtnAgregarPreprensaDetalle" alt="" style="cursor:pointer;" onclick="agregaPreprensaDetalle();" src="<c:url value="/resources/image/boton_agregar.jpg"/>">
	                                                                        	<span id="imgBtnCancelaAgregarPreprensaDetalle" style="cursor:pointer; display:none" onclick="cancelaAgregarPreprensaDetalle();">
	                                                                        		<font color="gray">CANCELAR</font>
	                                                                        	</span>
	                                                                        	<span id="imgBtnAceptaAgregarPreprensaDetalle" style="cursor:pointer; display:none;" onclick="aceptaAgregarPreprensaDetalle();">
	                                                                        		<font color="blue">ACEPTAR</font>
	                                                                        	</span>
	                                                                        </div>
	                                                                    </div>
	                                                                </div>
                                                                </c:if>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <div id="div_preprensa_panel_derecho">
                                                        <div id="div_contenedor_tabla_preprensa_detalle">
                                                            <div class="columna_completa">
                                                                <div id="div_tabla_lista_preprensa_detalle">
                                                                    <table>
                                                                        <tr>
                                                                            <th>No.</th>
                                                                            <th>Descripci&oacute;n</th>
                                                                            <th>Cantidad</th>
                                                                            <th>Especificaci&oacute;n</th>
                                                                        </tr>
                                                                        <tr class="l1">
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                        	<div class="linea" style="padding-top:5px;">
	                                                        	<div class="casilla" style="text-align:right;">
	                                                        		<div id="div_btn_actualizar_preprensa_detalle">
	                                                        			<img id="imgBtnModificarPreprensaDetalle" alt="" style="cursor:pointer;" onclick="modificaTablaPreprensaDetalle();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
	                                                        			<span id="imgBtnCancelaModificarPreprensaDetalle" style="cursor:pointer; display:none;" onclick="cancelaModificarPreprensaDetalle();">
	                                                        				<font color="gray">CANCELAR</font>
	                                                        			</span>
	                                                        			<span id="imgBtnAceptaEliminarPreprensaDetalle" style="cursor:pointer; display:none;" onclick="aceptaEliminarPreprensaDetalle();">
	                                                        				<font color="#FFCC00">ELIMINAR</font>
	                                                        			</span>
	                                                        			<span id="imgBtnAceptaModificarPreprensaDetalle" style="cursor:pointer; display:none;" onclick="aceptaModificarPreprensaDetalle();">
	                                                        				<font color="blue">ACEPTAR</font>
	                                                        			</span>
	                                                        		</div>
	                                                        	</div>
	                                                        </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="div_pestania_contenido_transporte" style="display:none;">
                                            <div id="div_transporte">
                                                <div id="div_transporte_general">
                                                    <form name="transporte" action="" accept-charset="utf-8">
                                                    	<input type="hidden" name="id_transporte" 	value="">
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="1%">Indicaciones:</td>
                                                                            <td>
                                                                                <input  type="text"
                                                                                        class="input"
                                                                                        name="indicacion_tarea_realizar"
                                                                                        value=""
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="15%">Materiales recibe:</td>
                                                                            <td>
                                                                                <input  type="text"
                                                                                        class="input"
                                                                                        name="materiales_recibe"
                                                                                        value=""
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>       
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="1%">Observaciones:</td>
                                                                            <td>
                                                                                <input  type="text"
                                                                                        class="input"
                                                                                        name="observaciones"
                                                                                        value=""
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <c:choose>
                                                        	<c:when test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
	                                                        	<div class="linea">
		                                                            <div class="casilla" style="text-align:right;">
		                                                            	<div id="div_btn_modificar_transporte">
		                                                            		<img id="imgBtnModificaTransporte" alt="" style="cursor:pointer;" onclick="modificaTransporte();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
		                                                            		<span id="imgBtnCancelaModificarTransporte" style="cursor: pointer; display:none;" onclick="cancelaModificarTransporte();">
		                                                            			<font color="gray">CANCELAR</font>
		                                                            		</span>
		                                                            		<span id="imgBtnAceptaModificarTransporte" style="cursor:pointer; display:none;" onclick="aceptaModificarTransporte();">
		                                                            			<font color="blue">ACEPTAR</font>
		                                                            		</span>
		                                                            	</div>
		                                                            </div>
		                                                        </div>
	                                                        </c:when>
	                                                        <c:otherwise>
	                                                        	<div class="linea"></div>
	                                                        </c:otherwise>
                                                        </c:choose>
                                                    </form>
                                                </div>
                                                <div id="div_transporte_particular">
                                                    <div id="div_transporte_panel_izquierdo">
                                                        <form name="transporte_detalle" action="" accept-charset="utf-8">
                                                        	<input type="hidden" name="id_orden_produccion"		value="${ordenProduccion.idOrdenProduccion}">
                                                        	<input type="hidden" name="nut"						value="${ordenProduccion.nut}">
                                                            <input type="hidden" name="id_partida"          	value="">
                                                        	<input type="hidden" name="id_transporte_detalle"	value="">
                                                            <input type="hidden" name="id_transporte"           value=""/>
                                                            <input type="hidden" name="id_proceso_transporte"   value=""/>
                                                            <div id="div_select_proceso_transporte">
                                                                <select name="select_proceso_transporte" id="select_proceso_transporte" size="5" onclick="selectTransporteDetalleClick(this);" disabled></select>
                                                            </div>
                                                            <div id="div_form_transporte_detalle">
                                                                <div class="linea">
                                                                    <div class="casilla">
                                                                        <div class="columna_completa">
                                                                            <table>
                                                                                <tr>
                                                                                    <td width="1%">Detalle:</td>
                                                                                    <td>
                                                                                        <input  type="text"
                                                                                                class="input"
                                                                                                name="detalle"
                                                                                                value=""
                                                                                                readonly/>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="linea">
                                                                    <div class="casilla">
                                                                        <div class="cuarto_columna_izquierda">
                                                                            <div class="columna_completa">
                                                                                <table>
                                                                                    <tr>
                                                                                        <td width="1%">Cantidad:</td>
                                                                                        <td>
                                                                                            <input  type="text"
                                                                                                    class="input"
                                                                                                    name="cantidad"
                                                                                                    value=""
                                                                                                    onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                                                    readonly/>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                        <div class="cuarto_columna_derecha">
                                                                            <div class="columna_completa">
                                                                                <table>
                                                                                    <tr>
                                                                                        <td width="1%">Precio:</td>
                                                                                        <td>
                                                                                            <input  type="text"
                                                                                                    class="input"
                                                                                                    name="precio_total_pesos"
                                                                                                    title="Precio total en pesos"
                                                                                                    value=""
                                                                                                    onkeydown="revisaNumero(true, this.value, event, null, null)"
                                                                                                    readonly/>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="doble_linea">
                                                                    <div class="casilla_doble_alto">
                                                                        <div class="columna_completa">
                                                                            <table>
                                                                                <tr>
                                                                                    <td width="1%" valign="top" style="padding-top:4px;">Especif.:</td>
                                                                                    <td>
                                                                                        <textarea   class="textarea_doble" 
                                                                                                    name="especificaciones" 
                                                                                                    disabled></textarea>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                                	<div class="linea">
	                                                                    <div class="casilla" style="text-align:right;">
	                                                                        <div id="div_btn_agregar_transporte_detalle">
	                                                                        	<img id="imgBtnAgregarTransporteDetalle" alt="" style="cursor:pointer;" onclick="agregaTransporteDetalle();" src="<c:url value="/resources/image/boton_agregar.jpg"/>">
	                                                                        	<span id="imgBtnCancelaAgregarTransporteDetalle" style="cursor:pointer; display:none" onclick="cancelaAgregarTransporteDetalle();">
	                                                                        		<font color="gray">CANCELAR</font>
	                                                                        	</span>
	                                                                        	<span id="imgBtnAceptaAgregarTransporteDetalle" style="cursor:pointer; display:none;" onclick="aceptaAgregarTransporteDetalle();">
	                                                                        		<font color="blue">ACEPTAR</font>
	                                                                        	</span>
	                                                                        </div>
	                                                                    </div>
	                                                                </div>
                                                                </c:if>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <div id="div_transporte_panel_derecho">
                                                        <div id="div_contenedor_tabla_transporte_detalle">
                                                            <div class="columna_completa">
                                                                <div id="div_tabla_lista_transporte_detalle">
                                                                    <table>
                                                                        <tr>
                                                                            <th>No.</th>
                                                                            <th>Descripci&oacute;n</th>
                                                                            <th>Cantidad</th>
                                                                            <th>Especificaci&oacute;n</th>
                                                                        </tr>
                                                                        <tr class="l1">
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                        	<div class="linea" style="padding-top:5px;">
	                                                        	<div class="casilla" style="text-align:right;">
	                                                        		<div id="div_btn_actualizar_transporte_detalle">
	                                                        			<img id="imgBtnModificarTransporteDetalle" alt="" style="cursor:pointer;" onclick="modificaTablaTransporteDetalle();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
	                                                        			<span id="imgBtnCancelaModificarTransporteDetalle" style="cursor: pointer; display: none;" onclick="cancelaModificarTransporteDetalle();">
	                                                        				<font color="gray">CANCELAR</font>
	                                                        			</span>
	                                                        			<span id="imgBtnAceptaEliminarTransporteDetalle" style="cursor:pointer; display:none;" onclick="aceptaEliminarTransporteDetalle();">
	                                                        				<font color="#FFCC00">ELIMINAR</font>
	                                                        			</span>
	                                                        			<span id="imgBtnAceptaModificarTransporteDetalle" style="cursor:pointer; display:none;" onclick="aceptaModificarTransporteDetalle();">
	                                                        				<font color="blue">ACEPTAR</font>
	                                                        			</span>
	                                                        		</div>
	                                                        	</div>
	                                                        </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="div_pestania_contenido_acabado" style="display:none;">
                                            <div id="div_acabado">
                                                <div id="div_acabado_general">
                                                    <form name="acabado" action="" accept-charset="utf-8">
                                                    	<input type="hidden" name="id_acabado" value="">
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="1%">Indicaciones:</td>
                                                                            <td>
                                                                                <input  type="text"
                                                                                        class="input"
                                                                                        name="indicacion_tarea_realizar"
                                                                                        value=""
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="15%">Materiales recibe:</td>
                                                                            <td>
                                                                                <input  type="text"
                                                                                        class="input"
                                                                                        name="materiales_recibe"
                                                                                        value=""
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="linea">
                                                            <div class="casilla">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="1%">Observaciones:</td>
                                                                            <td>
                                                                                <input  type="text"
                                                                                        class="input"
                                                                                        name="observaciones"
                                                                                        value=""
                                                                                        readOnly/>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <c:choose>
                                                        	<c:when test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
	                                                        	<div class="linea">
		                                                            <div class="casilla" style="text-align:right;">
		                                                                <div id="div_btn_modificar_acabado">
		                                                                	<img id="imgBtnModificaAcabado" alt="" style="cursor:pointer;" onclick="modificaAcabado();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
		                                                                	<span id="imgBtnCancelaModificarAcabado" style="cursor: pointer; display:none;" onclick="cancelaModificarAcabado();">
		                                                                		<font color="gray">CANCELAR</font>
		                                                                	</span>
		                                                                	<span id="imgBtnAceptaModificarAcabado" style="cursor:pointer; display:none;" onclick="aceptaModificarAcabado();">
		                                                                		<font color="blue">ACEPTAR</font>
		                                                                	</span>
		                                                                </div>
		                                                            </div>
		                                                        </div>
	                                                        </c:when>
	                                                        <c:otherwise>
	                                                        	<div class="linea"></div>
	                                                        </c:otherwise>
                                                        </c:choose>
                                                    </form>
                                                </div>
                                                <div id="div_acabado_particular">
                                                    <div id="div_acabado_panel_izquierdo">
                                                        <form name="acabado_detalle" action="" accept-charset="utf-8">
                                                        	<input type="hidden" name="id_orden_produccion"	value="${ordenProduccion.idOrdenProduccion}">
                                                        	<input type="hidden" name="nut"					value="${ordenProduccion.nut}">
                                                            <input type="hidden" name="id_partida"          value="">
                                                        	<input type="hidden" name="id_acabado_detalle"	value="">
                                                            <input type="hidden" name="id_acabado"          value=""/>
                                                            <input type="hidden" name="id_proceso_externo"  value=""/>
                                                            <div id="div_select_proceso_externo">
                                                                <select name="select_proceso_externo" id="select_proceso_externo" size="5" onclick="selectAcabadoDetalleClick(this);" disabled></select>
                                                            </div>
                                                            <div id="div_form_acabado_detalle">
                                                                <div class="linea">
                                                                    <div class="casilla">
                                                                        <div class="columna_completa">
                                                                            <table>
                                                                                <tr>
                                                                                    <td width="1%">Detalle:</td>
                                                                                    <td>
                                                                                        <input  type="text"
                                                                                                class="input"
                                                                                                name="detalle"
                                                                                                value=""
                                                                                                readonly/>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="linea">
                                                                    <div class="casilla">
                                                                        <div class="cuarto_columna_izquierda">
                                                                            <div class="columna_completa">
                                                                                <table>
                                                                                    <tr>
                                                                                        <td width="1%">Alto:</td>
                                                                                        <td>
                                                                                            <input  type="text"
                                                                                                    class="input"
                                                                                                    name="alto"
                                                                                                    value=""
                                                                                                    onkeydown="revisaNumero(true, this.value, event, null, null)"
                                                                                                    readonly/>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                        <div class="cuarto_columna_derecha">
                                                                            <div class="columna_completa">
                                                                            	<table>
                                                                                    <tr>
                                                                                        <td width="1%">Ancho:</td>
                                                                                        <td>
                                                                                            <input  type="text"
                                                                                                    class="input"
                                                                                                    name="ancho"
                                                                                                    value=""
                                                                                                    onkeydown="revisaNumero(true, this.value, event, null, null)"
                                                                                                    readonly/>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="linea">
                                                                    <div class="casilla">
                                                                        <div class="cuarto_columna_izquierda">
                                                                            <div class="columna_completa">
                                                                                <table>
                                                                                    <tr>
                                                                                        <td width="1%">Cantidad:</td>
                                                                                        <td>
                                                                                            <input  type="text"
                                                                                                    class="input"
                                                                                                    name="cantidad_proceso_externo"
                                                                                                    value=""
                                                                                                    onkeydown="revisaNumero(false, this.value, event, null, null)"
                                                                                                    readonly/>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                        <div class="cuarto_columna_derecha">
                                                                            <div class="columna_completa">
                                                                                <table>
                                                                                    <tr>
                                                                                        <td width="1%">Precio:</td>
                                                                                        <td>
                                                                                            <input  type="text"
                                                                                                    class="input"
                                                                                                    name="precio_total_pesos"
                                                                                                    title="Precio total en pesos"
                                                                                                    value=""
                                                                                                    onkeydown="revisaNumero(true, this.value, event, null, null)"
                                                                                                    readonly/>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="doble_linea">
                                                                    <div class="casilla_doble_alto">
                                                                        <div class="columna_completa">
                                                                            <table>
                                                                                <tr>
                                                                                    <td width="1%" valign="top" style="padding-top:4px;">Especif.:</td>
                                                                                    <td>
                                                                                        <textarea   class="textarea_doble"
                                                                                                    name="especificaciones"
                                                                                                    disabled></textarea>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                                	<div class="linea">
	                                                                    <div class="casilla" style="text-align:right;">
	                                                                        <div id="div_btn_agregar_acabado_detalle">
	                                                                        	<img id="imgBtnAgregarAcabadoDetalle" alt="" style="cursor:pointer;" onclick="agregaAcabadoDetalle();" src="<c:url value="/resources/image/boton_agregar.jpg"/>">
	                                                                        	<span id="imgBtnCancelaAgregarAcabadoDetalle" style="cursor:pointer; display:none" onclick="cancelaAgregarAcabadoDetalle();">
	                                                                        		<font color="gray">CANCELAR</font>
	                                                                        	</span>
	                                                                        	<span id="imgBtnAceptaAgregarAcabadoDetalle" style="cursor:pointer; display:none;" onclick="aceptaAgregarAcabadoDetalle();">
	                                                                        		<font color="blue">ACEPTAR</font>
	                                                                        	</span>
	                                                                        </div>
	                                                                    </div>
	                                                                </div>                                                                
                                                                </c:if>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <div id="div_acabado_panel_derecho">
                                                        <div id="div_contenedor_tabla_acabado_detalle">
                                                            <div class="columna_completa">
                                                                <div id="div_tabla_lista_acabado_detalle">
                                                                    <table>
                                                                        <tr>
                                                                            <th>No.</th>
                                                                            <th>Descripci&oacute;n</th>
                                                                            <th>Cantidad</th>
                                                                            <th>Especificaci&oacute;n</th>
                                                                        </tr>
                                                                        <tr class="l1">
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                        	<div class="linea" style="padding-top:5px;">
	                                                        	<div class="casilla" style="text-align:right;">
	                                                        		<div id="div_btn_actualizar_acabado_detalle">
	                                                        			<img id="imgBtnModificarAcabadoDetalle" alt="" style="cursor:pointer;" onclick="modificaTablaAcabadoDetalle();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
	                                                        			<span id="imgBtnCancelaModificarAcabadoDetalle" style="cursor: pointer; display: none;" onclick="cancelaModificarAcabadoDetalle();">
	                                                        				<font color="gray">CANCELAR</font>
	                                                        			</span>
	                                                        			<span id="imgBtnAceptaEliminarAcabadoDetalle" style="cursor:pointer; display:none;" onclick="aceptaEliminarAcabadoDetalle();">
	                                                        				<font color="#FFCC00">ELIMINAR</font>
	                                                        			</span>
	                                                        			<span id="imgBtnAceptaModificarAcabadoDetalle" style="cursor:pointer; display:none;" onclick="aceptaModificarAcabadoDetalle();">
	                                                        				<font color="blue">ACEPTAR</font>
	                                                        			</span>
	                                                        		</div>
	                                                        	</div>
	                                                        </div>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="div_pestania_contenido_offset" style="display:none;">
                                            <div id="div_offset">
                                                <div id="div_offset_general">
                                                    <form name="offset" action="" accept-charset="utf-8">
                                                    	<input type="hidden" name="id_offset" 	value="">
                                                        <div class="doble_linea">
                                                            <div class="casilla_doble_alto">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="1%" valign="top" style="padding-top:4px;">Indicaciones:</td>
                                                                            <td>
                                                                                <textarea   class="textarea_doble"
                                                                                            name="indicacion_tarea_realizar"
                                                                                            disabled></textarea>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="doble_linea">
                                                            <div class="casilla_doble_alto">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="15%" valign="top" style="padding-top:4px;">Materiales recibe:</td>
                                                                            <td>
                                                                                <textarea   class="textarea_doble"
                                                                                            name="materiales_recibe"
                                                                                            disabled></textarea>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="doble_linea">
                                                            <div class="casilla_doble_alto">
                                                                <div class="columna_completa">
                                                                    <table>
                                                                        <tr>
                                                                            <td width="1%" valign="top" style="padding-top:4px;">Observaciones:</td>
                                                                            <td>
                                                                                <textarea   class="textarea_doble"
                                                                                            name="observaciones"
                                                                                            disabled></textarea>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                        	<div class="linea">
	                                                            <div class="casilla" style="text-align:right;">
	                                                                <div id="div_btn_modificar_offset" style="display: inline;">
	                                                                	<img id="imgBtnModificaOffset" alt="" style="cursor:pointer;" onclick="modificaOffset();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
	                                                                	<span id="imgBtnCancelaModificarOffset" style="cursor: pointer; display:none;" onclick="cancelaModificarOffset();">
	                                                                		<font color="gray">CANCELAR</font>
	                                                                	</span>
	                                                                	<span id="imgBtnAceptaModificarOffset" style="cursor:pointer; display:none;" onclick="aceptaModificarOffset();">
	                                                                		<font color="blue">ACEPTAR</font>
	                                                                	</span>
	                                                                </div>
	                                                            </div>
	                                                        </div>
                                                        </c:if>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
<!-- div_material_ayuda, display: none -->
							
                                <div id="div_material_ayuda" style="display:none;">
                                    <form name="material_ayuda" action="" accept-charset="ISO-8859-1">
                                    	<input type="hidden" name="id_material_ayuda_x_partida"	value=""/>
                                        <input type="hidden" name="id_partida"              	value=""/>
                                        <input type="hidden" name="id_material_ayuda"       	value=""/>
                                        <input type="hidden" name="id_responsable_insumo"   	value=""/>
                                        <div class="div_separador_mediano">
                                            <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                        </div>
                                        
                                        <div class="titulo">
                                            <img alt="" src="<c:url value="/resources/image/titulo_material_ayuda.png"/>"/>
                                        </div>
                                        <div id="div_contenido_material_ayuda">
                                            <div class="columna_izquierda">
                                                <div class="linea">
                                                    <div class="casilla">
                                                        <div class="mitad_columna_izquierda">
                                                            <div class="columna_completa">
                                                                <table>
                                                                    <tr>
                                                                        <td width="1%">Material:</td>
                                                                        <td>
                                                                        	<select name="select_material_ayuda" id="select_material_ayuda" disabled></select>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                        <div class="mitad_columna_derecha">
                                                            <div class="columna_completa">
                                                                <table>
                                                                    <tr>
                                                                        <td width="1%">Responsable:</td>
                                                                        <td>
                                                                        	<select name="select_responsable_insumo" id="select_responsable_insumo" disabled>
                                                                        		<c:forEach var="ri" items="${listaResponsableInsumo}">
	                                                                                <option value="${ri.value}">${ri.text}</option>
	                                                                            </c:forEach>
	                                                                        </select>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="linea">
                                                    <div class="casilla">
                                                        <div class="columna_completa">
	                                                        <table>
	                                                            <tr>
	                                                                <td width="1%">Obs:</td>
	                                                                <td>
	                                                                    <input type="text" class="input"
	                                                                           name="observaciones"
	                                                                           value=""
	                                                                           readOnly/>
	                                                                </td>
	                                                            </tr>
	                                                        </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                	<div class="linea">
	                                                    <div class="casilla" style="text-align:right;">
	                                                        <div id="div_btn_agregar_material_ayuda">
	                                                        	<img id="imgBtnAgregarMaterialAyuda" alt="" style="cursor:pointer;" onclick="agregaMaterialAyuda();" src="<c:url value="/resources/image/boton_agregar.jpg"/>">
	                                                        	<span id="imgBtnCancelaAgregarMaterialAyuda" style="cursor:pointer; display:none" onclick="cancelaAgregarMaterialAyuda();">
	                                                        		<font color="gray">CANCELAR</font>
	                                                        	</span>
	                                                        	<span id="imgBtnAceptaAgregarMaterialAyuda" style="cursor:pointer; display:none;" onclick="aceptaAgregarMaterialAyuda();">
	                                                        		<font color="blue">ACEPTAR</font>
	                                                        	</span>
	                                                        </div>
	                                                    </div>
	                                                </div>
                                                </c:if>
                                            </div>
                                            <div class="columna_derecha">
                                                <div id="div_contenedor_tabla_material_ayuda" style="height:105px;">
                                                    <div class="columna_completa">
                                                        <div id="div_tabla_lista_material_ayuda">
                                                            <table id="tabla_material_ayuda">
                                                                <tr>
                                                                    <th>No.</th>
                                                                    <th>Material</th>
                                                                    <th>Responsable</th>
                                                                    <th>Observaciones</th>
                                                                </tr>
                                                                 
                                                                <tr class="l1">
                                                                    <td></td>
                                                                    <td></td>
                                                                    <td></td>
                                                                    <td></td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <c:if test="${historialEstatus.estatusOrden.idEstatusOrden == estatus_cotizacion}">
                                                	<div class="linea" style="padding-top:5px;">
	                                                	<div class="caillas" style="text-align:right;">
	                                                		<div id="div_btn_actualizar_material_ayuda">
	                                                			<img id="imgBtnModificarMaterialAyuda" alt="" style="cursor:pointer;" onclick="modificaTablaMaterialAyuda();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
	                                                			<span id="imgBtnCancelaModificarMaterialAyuda" style="cursor:pointer; display:none;" onclick="cancelaModificarMaterialAyuda();">
	                                                				<font color="gray">CANCELAR</font>
	                                                			</span>
	                                                			<span id="imgBtnAceptaEliminarMaterialAyuda" style="cursor:pointer; display:none;" onclick="aceptaEliminarMaterialAyuda();">
	                                                				<font color="#FFCC00">ELIMINAR</font>
	                                                			</span>
	                                                			<span id="imgBtnAceptaModificarMaterialAyuda" style="cursor:pointer; display:none;" onclick="aceptaModificarMaterialAyuda();">
	                                                				<font color="blue">ACEPTAR</font>
	                                                			</span>
	                                                		</div>
	                                                	</div>
	                                                </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                
<!-- div_cambio_estatus, display: block -->
							
                                <div id="div_cambio_estatus" style="display: block;">
                                	<div class="div_separador_grande">
                                        <img alt="" src="<c:url value="/resources/image/separador_grande.png"/>"/>
                                    </div>
                                	<div class="columna_izquierda">
                                		<form name="cambio_estatus" action="" accept-charset="ISO-8859-1">
	                                		<input type="hidden" name="id_orden_produccion"	value=""/>
	                                		<input type="hidden" name="id_estatus_orden" 	value=""/>
	                                        <div class="titulo">
		                                        <font size="5">CAMBIO DE ESTATUS</font>
		                                    </div>
		                                    <div class="linea">
		                                    	<div class="casilla">
		                                    		<div class="columna_completa">
		                                   				<table>
		                                   					<tr>
		                                   						<td width="1%">Estatus:</td>
		                                   						<td>
		                                    						<select name="select_estatus_orden_produccion" onchange="">
				                                    					<c:forEach var="seop" items="${listaEstatusOrden}">
				                                    						<option value="${seop.value}">${seop.text}</option>
				                                    					</c:forEach>
				                                    				</select>
		                                   						</td>
		                                   					</tr>
		                                    			</table>
		                                    		</div>
		                                    	</div>
		                                    </div>
		                                    <div class="linea">
	                                    		<div class="casilla" style="text-align:right;">
	                                    			<span id="imgBtnModificarEstatus" style="cursor:pointer;" onclick="ajaxCambiaEstatus();">
	                                    				MODIFICAR
	                                    			</span>
		                                    	</div>
		                                    </div>
	                                	</form>
                                	</div>
                                	<div class="columna_derecha">
                                		<form name="precio" action="" accept-charset="ISO-8859-1">
                                			<input type="hidden" name="nut" value="${ordenProduccion.nut}">
	                                		<div class="titulo">
		                                        <font size="5">REVISI&Oacute;N DE COSTOS</font>
		                                    </div>
		                                    <div class="linea">
		                                    	<div class="casilla">
		                                    		<div class="columna_completa">
	                                    				<table>
	                                    					<tr>
	                                    						<td width="1%">Precio:</td>
	                                    						<td>
		                                    						<input	type="text"
		                                    								class="input"
		                                    								style="text-align:right;"
		                                    								name="precio_neto"
		                                    								value="<fmt:formatNumber pattern="$ #,##0.00" value="${precio_neto}" />"
		                                    								readonly>
	                                    						</td>
	                                    					</tr>
	                                    				</table>
		                                    		</div>
		                                    	</div>
		                                    </div>
	                                		<div class="linea">
		                                   		<div class="casilla" style="text-align:right;">
	                                    			<span id="imgBtnRevisarCostos" style="cursor:pointer;" onclick="muestraDetallePrecio();">
	                                    				REVISAR
	                                    			</span>
		                                    	</div>
		                                    </div>
	                                    </form>
	                            	</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="div_derecha3d">
                    <div id="div_fondo_esq_sup"></div>
                    <div id="div_fondo_der"></div>
                </div>
            </div>
            <div id="div_abajo3d">
                <div id="div_fondo_esq_izq"></div>
                <div id="div_fondo_abajo"></div>
                <div id="div_fondo_esq_der"></div>
            </div>
        </div>
        <div id="div_espacio_inf"></div>
    </body>
</html>