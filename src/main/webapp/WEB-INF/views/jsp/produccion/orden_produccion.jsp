<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn"%>
<c:url value="/?opc=produccion"	            				var="urlMenu"/>
<c:url value="/cliente/busca_nombre"        				var="urlBuscaNombreCliente"/>
<c:url value="/cliente/busca"               				var="urlBuscaCliente"/>
<c:url value="/orden_produccion/agrega"     				var="urlAgregaOrdenProduccion"/>
<c:url value="/partida/agrega"              				var="urlAgregaPartida"/>
<c:url value="/partida/busca"               				var="urlBuscaPartida"/>
<c:url value="/tipo_placa/busca"            				var="urlBuscaTipoPlaca"/>
<c:url value="/tipo_papel_extendido/ventana/lista"          var="urlBuscaTipoPapel"/>
<c:url value="/tipo_trabajo_detalle/agrega" 				var="urlAgregaTipoTrabajoDetalle"/>
<c:url value="/tipo_trabajo_detalle/elimina"    			var="urlEliminaDetallePartida"/>
<c:url value="/tipo_trabajo_detalle/busca"  				var="urlBuscaTipoTrabajoDetalle"/>
<c:url value="/pliego/calcula"              				var="urlCalculaPliego"/>
<c:url value="/costo_extra_detalle/busca_unidad_medida" 	var="urlBuscaUnidadMedidaCostoExtra"/>
<c:url value="/costo_extra_detalle/agrega_en_op" 			var="urlAgregaCostoExtra"/>
<c:url value="/disenio/modifica"            				var="urlModificaDisenio"/>
<c:url value="/disenio_detalle/agrega"      				var="urlAgregaDisenioDetalle"/>
<c:url value="/preprensa/modifica"          				var="urlModificaPreprensa"/>
<c:url value="/preprensa_detalle/agrega"    				var="urlAgregaPreprensaDetalle"/>
<c:url value="/transporte/modifica"         				var="urlModificaTransporte"/>
<c:url value="/transporte_detalle/agrega"   				var="urlAgregaTransporteDetalle"/>
<c:url value="/acabado/modifica"            				var="urlModificaAcabado"/>
<c:url value="/acabado_detalle/agrega"      				var="urlAgregaAcabadoDetalle"/>
<c:url value="/offset/modifica"             				var="urlModificaOffset"/>
<c:url value="/material_ayuda_x_partida/agrega"				var="urlAgregaMaterialAyuda"/>
<c:url value="/calificacion/produccion"						var="urlCalificacionOrdenProduccion"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Orden Producci&oacute;n</title>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/orden_produccion.css"/>" type="text/css"></link>
        <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/shadowbox/shadowbox.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/orden_produccion_limpia_form.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/orden_produccion_ajax.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/orden_produccion.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/prueba.js"/>"></script>
        <script type="text/javascript">
            // inicializacion jquery
            $(document).ready(function (){});
            // inicializacion shadowbox
            Shadowbox.init({
                //modal: true,
                //overlayOpacity: 0.75
            });
            // iniciacion datepicker
            $(function() {
				$("#datepicker").datepicker({
					dateFormat:'yy-mm-dd',
				});
			});
        </script>
        <script type="text/javascript">
        	var urlMenu							= "${urlMenu}";
            var urlBuscaNombreCliente			= "${urlBuscaNombreCliente}";
            var urlBuscaCliente             	= "${urlBuscaCliente}";
            var urlAgregaOrdenProduccion    	= "${urlAgregaOrdenProduccion}";
            var urlAgregaPartida            	= "${urlAgregaPartida}";
            var urlBuscaPartida             	= "${urlBuscaPartida}";
            var urlBuscaTipoPlaca           	= "${urlBuscaTipoPlaca}";
            var urlBuscaTipoPapel				= "${urlBuscaTipoPapel}";
            var urlAgregaTipoTrabajoDetalle 	= "${urlAgregaTipoTrabajoDetalle}";
            var urlEliminaDetallePartida    	= "${urlEliminaDetallePartida}";
            var urlBuscaTipoTrabajoDetalle  	= "${urlBuscaTipoTrabajoDetalle}";
            var urlCalculaPliego            	= "${urlCalculaPliego}";
            var urlBuscaUnidadMedidaCostoExtra	= "${urlBuscaUnidadMedidaCostoExtra}";
            var urlAgregaCostoExtra				= "${urlAgregaCostoExtra}";
            var urlModificaDisenio            	= "${urlModificaDisenio}";
            var urlAgregaDisenioDetalle     	= "${urlAgregaDisenioDetalle}";
            var urlModificaPreprensa          	= "${urlModificaPreprensa}";
            var urlAgregaPreprensaDetalle   	= "${urlAgregaPreprensaDetalle}";
            var urlModificaTransporte         	= "${urlModificaTransporte}";
            var urlAgregaTransporteDetalle  	= "${urlAgregaTransporteDetalle}";
            var urlModificaAcabado            	= "${urlModificaAcabado}";
            var urlAgregaAcabadoDetalle     	= "${urlAgregaAcabadoDetalle}";
            var urlModificaOffset             	= "${urlModificaOffset}";
            var urlAgregaMaterialAyuda      	= "${urlAgregaMaterialAyuda}";
            var urlCalificacionOrdenProduccion  = "${urlCalificacionOrdenProduccion}";
        </script>
        <script type="text/javascript">
            var strJsonListaProcesoDisenio      = '${jsonListaProcesoDisenio}';
            var strJsonListaProcesoPreprensa    = '${jsonListaProcesoPreprensa}';
            var strJsonListaProcesoTransporte   = '${jsonListaProcesoTransporte}';
            var strJsonListaProcesoExterno      = '${jsonListaProcesoExterno}';
            var strJsonListaMaterialAyuda       = '${jsonListaMaterialAyuda}';
        </script>
        <script type="text/javascript">
            function regresa_menu() {
            	location.replace(urlMenu);
            }
        </script>
        <script type="text/javascript">
        	/*
        	// NO FUNCIONA EN IE8
        	function agregaListener(){
        		document.cliente.nombre_moral.addEventListener("keyup", searchLikeGoogle);
        	}
        	*/
        </script>
    </head>
    <!-- <body onload="agregaListener()"> -->
    <body>
        <div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_cabecera">
                        <div id="div_logo">
                            <img alt="" src="<c:url value="/resources/image/logo.png"/>"></img>
                        </div>
                        <div id="div_encabezado">
                            <img alt="" src="<c:url value="/resources/image/encabezado_orden_produccion.png"/>"></img>
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                            <div id="div_contenido_menu">
                                <div class="div_menu_item">
                                    <img alt="" src="<c:url value="/resources/image/boton_menu_produccion.png"/>"></img>
                                    <ul id="menu_produccion">
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_diseno.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"></img>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_preprensa.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"></img>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_transporte.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"></img>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_acabado.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"></img>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_offset.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"></img>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_procesos.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"></img>
                                        </li>
                                    </ul>
                                </div>
                                <!--
                                <div class="div_menu_item">
                                    <img alt="" src="resources/image/boton_menu_reportes.png"></img>
                                    <ul id="menu_reportes">
                                        <li>
                                            <a href="#">Plantilla</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Clasificaci&oacute;n</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Resultados</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="div_menu_item">
                                    <img alt="" src="resources/image/boton_menu_seguridad.png"></img>
                                    <ul id="menu_seguridad">
                                        <li>
                                            <a href="#">T.V.</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Radio</a>
                                        </li>
                                    </ul>
                                </div>
                                -->
                                <div id="div_cerrar_sesion">
                                    <span style="cursor:pointer;" onclick="regresa_menu();">
                                    	<img alt="" src="<c:url value="/resources/image/boton_regresar_menu.jpg"/>"></img>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div id="div_contenido">


                        
<!-- div de ayuda, display: none; -->
                            <div id="div_prueba" style="display:none;">
                                <input type="button" value="presioname" onclick="sb();"/>
                                <br/>
                                <br/>
                                <br/>
                                <div id="div_resultado_prueba"></div>
                                <!--
                                <select name="select_combinacion_tintas" 
                                        tabindex=""
                                        onchange="">
                                    <c:forEach var="ct" items="${listaCombinacionTintas}">
                                        <option value="${ct.value}">${ct.text}</option>
                                    </c:forEach>
                                </select>
                                -->
                            </div>


                            
<!-- div_cliente -->
                            <div id="div_cliente">
                                <form name="cliente" action="" accept-charset="ISO-8859-1">
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_cliente.png"/>"></img>
                                    </div>
                                    <div class="div_cliente_nombre">
                                        <div class="columna_completa">
                                            <table>
                                                <tr>
                                                    <td width="23%">Nombre del Cliente:</td>
                                                    <td>
                                                    	<input 	type="text" 
                                                        		class="input" 
                                                        		name="nombre_moral" 
                                                        		value="" 
                                                        		tabindex="1" 
                                                        		onkeyup="searchLikeGoogle(this.value)"/>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div id="div_search_like_google" style="background:red; width:438px; float:right; display:none;">
                                        	<select name="select_search" size="5" onclick="preparaAjaxBuscaCliente()" onkeyup="enterSearchLikeGoogle()" onblur="closeSearchLikeGoogle()">
                                        		<option></option>
                                        	</select>
                                        </div>
                                        <img alt="" src="<c:url value="/resources/image/separador_nombre.png"/>"></img>
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
                                                                            value="" 
                                                                            tabindex="2"
                                                                            onkeypress="if( event.keyCode == 13 ) ajaxBuscaCliente(); else if( isNaN( String.fromCharCode (event.keyCode) ) ) {return false;}"/>
                                                                </td>
                                                                <td>
                                                                    <img id="imgBtnBuscaCliente" alt="" style="cursor:pointer;" onclick="ajaxBuscaCliente();" src="<c:url value="/resources/image/lupa.png"/>" />
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
                                                                            value="" 
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
                                            <div class="columna_izquierda">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="8%">Calle:</td>
                                                            <td>
                                                                <input type="text" 
                                                                       class="input"
                                                                       name="calle"
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
                                                                <td width="25%">No Ext:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="num_exterior" 
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
                                                                <td width="23%">No Int:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="num_interior" 
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
                                                            <td width="10%">Colonia:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="colonia"
                                                                        value="" 
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
                                            <div class="columna_izquierda">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="10%">Estado:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="estado"
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
                                                                <td width="35%">C. Postal.:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="codigo_postal" 
                                                                            value=""
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
                                                <div class="mitad_columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="10%">Tel&eacute;fono:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="telefono_particular" 
                                                                            value=""
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
                                                                            value=""
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
                                        <div class="casilla" style="text-align:right;">
                                            <img id="imgBtnLimpiaClienteActivo"
                                                 alt="" style="cursor:pointer;" onclick="limpiaFormCliente();"
                                                 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                            <img id="imgBtnLimpiaClienteInactivo"
                                                 alt="" style="display:none;"
                                                 src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            


<!-- div_orden_produccion -->
                            <div id="div_orden_produccion">
                                <form name="orden_produccion" action="" accept-charset="ISO-8859-1">
                                    <input type="hidden" name="id_usuario"                  value=""/>
                                    <input type="hidden" name="id_cliente"                  value=""/>
                                    <input type="hidden" name="id_tipo_comprobante_fiscal"  value=""/>
                                    <div class="div_separador_grande">
                                        <img alt="" src="<c:url value="/resources/image/separador_grande.png"/>"></img>
                                    </div>
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_orden.png"/>"></img>
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
                                                                    value=""
                                                                    tabindex="3"/>
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
                                                                    value=""
                                                                    tabindex="4"/>
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
                                                                <select name="select_comprobante_fiscal" 
                                                                        tabindex="5" 
                                                                        onchange="">
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
                                                            <td width="43%">Fecha aproximada entrega:</td>
                                                            <td>
                                                            	<input 	type="text"
                                                            			class="input"
                                                            			id="datepicker"
                                                            			name="fecha_prometida_entrega"
                                                            			tabindex="6"/>
                                                            	<!-- 
                                                                <input  type="date" 
                                                                        class="input" 
                                                                        name="fecha_prometida_entrega" 
                                                                        tabindex="6"/>
                                                                -->
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla" style="text-align:right;">
                                            <img id="imgBtnLimpiarOrdnProdActivo"
                                                 alt="" style="cursor:pointer;" onclick="limpiaCamposFormOrdenProduccion();"
                                                 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                            <img id="imgBtnLimpiarOrdnProdInactivo"
                                                 alt="" style="display:none;"
                                                 src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                            <img id="imgBtnAgregarOrdnProdActivo"
                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaOrdenProduccion();"
                                                 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                            <img id="imgBtnAgregarOrdnProdInactivo"
                                                 alt="" style="display:none;"
                                                 src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                        </div>
                                    </div>
                                </form>
                            </div>


                            
<!-- div_visualizador_partidas, display:none; -->
                            <div id="div_visualizador_partidas" style="display:none;">
                                <div class="div_separador_mediano">
                                    <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"></img>
                                </div>
                                <div class="titulo">
                                    <font size="5">LISTA DE PARTIDAS</font>
                                </div>
                                <div style="width:800px; height:150px; margin-left:auto; margin-right:auto; overflow-x:scroll;">
                                    <div class="columna_completa">
                                        <div id="div_tabla_lista_partidas">        
                                            <table id="tabla_lista_partidas">
                                                <tr>
                                                    <th>No.</th>
                                                    <th>Tipo trabajo</th>
                                                    <th>Nombre</th>
                                                    <th>Cantidad</th>
                                                    <th>Descripci&oacute;n</th>
                                                    
                                                </tr>
                                                <tr class="l1">
                                                    <td>1</td>
                                                    <td>Flyer/P&oacute;ster</td>
                                                    <td>Flyer</td>
                                                    <td>10000</td>
                                                    <td>Monster High</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            
<!-- div_partida, display:none; -->
                            <div id="div_partida" style="display:none;">
                                <form name="partida" action="" accept-charset="ISO-8859-1" enctype="multipart/form-data">
                                    <input type="hidden" name="id_orden_produccion"     value=""/>
                                    <input type="hidden" name="id_tipo_trabajo"         value=""/>
                                    <input type="hidden" name="id_tipo_forma_trabajo"   value=""/>
                                    <div class="div_separador_mediano">
                                        <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                    </div>    
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_descripcion_partida.png"/>"/>
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
                                                                            checked="checked"
                                                                            tabindex="7"/>
                                                                </td>
                                                                <td>
                                                                    <img alt=""
                                                                         src="<c:url value="/resources/image/titulo_flyer.png"/>"
                                                                         style="cursor:pointer;"
                                                                         onclick="document.getElementsByName('tipo_trabajo')[0].click();"/>
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
                                                                            value="2"/>
                                                                </td>
                                                                <td>
                                                                    <img alt=""
                                                                         src="<c:url value="/resources/image/titulo_revista.png"/>"
                                                                         style="cursor:pointer;"
                                                                         onclick="document.getElementsByName('tipo_trabajo')[1].click();"/>
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
                                                                            value="3"/>
                                                                </td>
                                                                <td>
                                                                    <img alt=""
                                                                         src="<c:url value="/resources/image/titulo_otros.png"/>"
                                                                         style="padding-top:5px;cursor:pointer;"
                                                                         onclick="document.getElementsByName('tipo_trabajo')[2].click();"/>
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
                                                                        tabindex="8"/>
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
                                                                            tabindex="9"
                                                                            onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="1%">Tipo:</td>
                                                                <td>
                                                                    <select name="select_forma_trabajo" tabindex="10">
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
                                                                    tabindex="11"/>
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
                                                            <input  type="file" 
                                                                    class="input" 
                                                                    name="diagrama_formacion"
                                                                    value=""
                                                                    tabindex="12"/>
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
                                                                          tabindex="13"></textarea>
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
                                                                          tabindex="14"></textarea>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla" style="text-align:right;">
                                            <img id="imgBtnLimpiarPartidaActivo"
                                                 alt="" style="cursor:pointer;" onclick="limpiaCamposFormPartida();"
                                                src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                            <img id="imgBtnLimpiarPartidaInactivo"
                                                 alt="" style="display:none;"
                                                 src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                            <img id="imgBtnAgregarPartidaActivo"
                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaPartida();"
                                                 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                            <img id="imgBtnAgregarPartidaInactivo"
                                                 alt="" style="display:none;"
                                                 src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                        </div>
                                    </div>
                                </form>
                            </div>



<!-- div_visualizador_partidas, display:none; -->
                            <div id="div_visualizador_tipo_trabajo_detalle" style="display:none;">
                                <div class="div_separador_mediano">
                                    <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                </div>
                                <div class="titulo">
                                    <font size="5">LISTA DE DETALLE DE PARTIDA ACTUAL</font>
                                </div>
                                <div style="width:800px; height:150px; margin-left:auto; margin-right:auto; overflow-x:scroll;">
                                    <div class="columna_completa">
                                        <div id="div_tabla_lista_tipo_trabajo_detalle">
                                            <table id="tabla_lista_tipo_trabajo_detalle">
                                                <tr>
                                                    <th>No.</th>
                                                    <th>Descripci&oacute;n</th>
                                                    <th>Repeticiones pliego</th>
                                                    <th>No. p&aacute;ginas</th>
                                                    <th>Tama&ntilde;io publicaci&oacute;n</th>
                                                    <th>M&aacute;quina</th>
                                                </tr>
                                                <tr class="l1">
                                                    <td>1</td>
                                                    <td>Contenido interior revista</td>
                                                    <td>N/A</td>
                                                    <td>52</td>
                                                    <td>Carta - Oficio (16 pag.)</td>
                                                    <td>Heidelberg Speed Master 6</td>
                                                </tr>
                                                <!--
                                                <tr class="l1">
                                                    <td>2</td>
                                                    <td>Publicaci&oacute;n/Revista/Libro</td>
                                                    <td>Heidelberg Speed Master 6</td>
                                                    <td>Publicaci&oacute;n</td>
                                                    <td>5000</td>
                                                    <td>Libro El Chapopote</td>
                                                </tr>
                                                -->
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            
<!-- div_detalle_partida = tipo_trabajo_detalle,  display:none; -->
                            <div id="div_tipo_trabajo_detalle" style="display:none;">
                                <form name="tipo_trabajo_detalle" action="" accept-charset="ISO-8859-1">
                                    <input type="hidden" name="id_partida"                          value=""/>
                                    <input type="hidden" name="cliente_proporciona_papel"           value=""/>
                                    <input type="hidden" name="cliente_proporciona_tinta"           value=""/>
                                    <input type="hidden" name="cliente_proporciona_tinta_especial"  value=""/>
                                    <input type="hidden" name="cliente_proporciona_barniz"          value=""/>
                                    <input type="hidden" name="cliente_proporciona_placas"          value=""/>
                                    <input type="hidden" name="id_tipo_papel_extendido"             value=""/>
                                    <input type="hidden" name="id_tamanio_publicacion"              value=""/>
                                    <input type="hidden" name="frente_id_combinacion_tintas"        value=""/>
                                    <input type="hidden" name="frente_id_tipo_barniz"               value=""/>
                                    <input type="hidden" name="vuelta_id_combinacion_tintas"        value=""/>
                                    <input type="hidden" name="vuelta_id_tipo_barniz"               value=""/>
                                    <input type="hidden" name="id_maquina"                          value=""/>
                                    <input type="hidden" name="id_tipo_placa"                       value=""/>
                                    <input type="hidden" name="id_tipo_complejidad"                 value=""/>
                                    
                                    <div class="div_separador_mediano">
                                        <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                    </div>
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_detalle_partida.png"/>"/>
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
                                                                    tabindex="15"/>
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
                                                                <td width="40%">Ancho (cm):</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input" 
                                                                            name="ancho" 
                                                                            value=""
                                                                            tabindex="16"
                                                                            onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
                                                                            onkeyup="document.getElementsByName('ancho_extendido')[0].value=value;"
                                                                            onblur="javascript:calculaHojas();"/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="32%">Alto (cm):</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input" 
                                                                            name="alto" 
                                                                            value=""
                                                                            tabindex="17"
                                                                            onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
                                                                            onkeyup="document.getElementsByName('alto_extendido')[0].value=value;"
                                                                            onblur="javascript:calculaHojas();"/>
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
                                                                <td width="74%">Ancho extendido (cm):</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input" 
                                                                            name="ancho_extendido" 
                                                                            value=""
                                                                            tabindex="18"
                                                                            onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
                                                                            onblur="document.getElementsByName('ancho_extendido')[0].value=value;"/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="65%">Alto extendido (cm):</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input" 
                                                                            name="alto_extendido" 
                                                                            value=""
                                                                            tabindex="19"
                                                                            onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
                                                                            onblur="document.getElementsByName('alto_extendido')[0].value=value;"/>
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
                                                                    <input  type="checkbox" 
                                                                            class="input"
                                                                            name="proporciona_papel"
                                                                            tabindex="20"/>
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
                                                                    <input  type="checkbox" 
                                                                            class="input"
                                                                            name="proporciona_placas"
                                                                            tabindex="21"/>
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
                                                                    <input  type="checkbox" 
                                                                            class="input"
                                                                            name="proporciona_tinta_especial"
                                                                            tabindex="22"/>
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
                                                                    <input  type="checkbox" 
                                                                            class="input"
                                                                            name="proporciona_barniz"
                                                                            tabindex="23"/>
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
                                                            			name="tipo_papel_extendido"
                                                            			value=""
                                                            			readonly/>
                                                            	<!-- 
                                                                <select name="select_tipo_papel_extendido" 
                                                                        tabindex="24"
                                                                        onchange="javascrip:obtieneDatosPapel(this.value)">
                                                                </select>
                                                                -->
                                                            </td>
                                                            <td>
                                                            	<img id="imgBtnBuscaPapelExtendido" alt="" style="cursor:pointer;" onclick="ajaxBuscaPapelExtendido()" src="<c:url value="/resources/image/lupa.png"/>"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div id="repeticiones_flyer" class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="66%">N&uacute;mero de flyer por pliego
                                                                            (Repeticiones):</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input"
                                                                        name="repeticiones_x_pliego" 
                                                                        value=""
                                                                        tabindex="25"
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
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
                                                                            tabindex="25"
                                                                            onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
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
                                                                    <select name="select_tamanio_publicacion" tabindex="25">
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
                                    
                                    <div id="div_especificaciones_papel">
                                        
                                        <div id="div_especificaciones_papel_tipo_flyer">
                                            
                                        </div>
                                        <div id="div_especificaciones_papel_tipo_revista">
                                            
                                        </div>
                                        <div id="div_especificaciones_papel_tipo_otro">
                                        
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
                                                                    <select name="select_frente_combinacion_tintas" tabindex="26">
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
                                                                            value="0"
                                                                            tabindex="27"
                                                                            onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
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
                                                                        tabindex="28"/>
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
                                                                <select name="select_frente_tipo_barniz" tabindex="29">
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
                                                                    <select name="select_vuelta_combinacion_tintas" tabindex="30">
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
                                                                            value="0"
                                                                            tabindex="31"
                                                                            onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
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
                                                                        tabindex="32"/>
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
                                                                <select name="select_vuelta_tipo_barniz" tabindex="33">
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
                                                                <select name="select_maquina" 
                                                                        tabindex="34"
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
                                                                <select name="select_tipo_placa" tabindex="35"></select>
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
                                    						<td width="32%">Tipo de Complejidad</td>
                                    						<td>
                                    							<select name="select_tipo_complejidad"
                                    									tabindex="36">
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
                                    <div class="linea">
                                        <div class="casilla" style="text-align:right;">
                                            <img id="imgBtnLimpiarDetallePartidaActivo"
                                                 alt="" style="cursor:pointer;" onclick="limpiaCamposFormTipoTrabajoDetalle();"
                                                 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                            <img id="imgBtnLimpiarDetallePartidaInactivo"
                                                 alt="" style="display:none;"
                                                 src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                            <img id="imgBtnAgregarDetallePartidaActivo"
                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaTipoTrabajoDetalle();"
                                                 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                            <img id="imgBtnAgregarDetallePartidaInactivo"
                                                 alt="" style="display:none;"
                                                 src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                        </div>
                                    </div>
                                </form>
                            </div>



<!-- div_visualizador_pliegos, display:none; -->
                            <div id="div_visualizador_pliegos" style="display:none;">
                                <form name="visualizador_pliegos" action="" accept-charset="ISO-8859-1">
                                    <input type="hidden" name="id_tipo_trabajo_detalle" value=""/>
                                    <div class="div_separador_chico">
                                        <img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
                                    </div>                                
                                    <div class="titulo">
                                        <font size="5">LISTA DE PLIEGOS</font>
                                    </div>
                                    <div style="width:800px; height:150px; margin-left:auto; margin-right:auto; overflow-x:scroll;">
                                        <div class="columna_completa">
                                            <div id="div_tabla_lista_pliegos">
                                                <table id="tabla_lista_pliegos">
                                                    <tr>
                                                        <th>No. Pgo</th>
                                                        <th>Rebase (mm.)</th>
                                                        <th>Medianiles (mm.)</th>
                                                        <th>Pinzas (cm.)</th>
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
                                                        <td>1</td>
                                                        <td>0</td>
                                                        <td>0</td>
                                                        <td>0</td>
                                                        <td>1</td>
                                                        <td>250</td>
                                                        <td>251</td>
                                                        <td>Ninguna</td>
                                                        <td>4</td>
                                                        <td>4</td>
                                                        <td>4</td>
                                                        <td>4</td>
                                                    </tr>
                                                    <tr class="l2">
                                                        <td>2</td>
                                                        <td>0</td>
                                                        <td>0</td>
                                                        <td>0</td>
                                                        <td>1</td>
                                                        <td>250</td>
                                                        <td>251</td>
                                                        <td>Pag: 193 - 200.</td>
                                                        <td>4</td>
                                                        <td>4</td>
                                                        <td>4</td>
                                                        <td>4</td>
                                                    </tr>
                                                    <tr>
                                                        <td><i>TOTAL</i></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td><i>2</i></td>
                                                        <td><i>500</i></td>
                                                        <td><i>502</i></td>
                                                        <td></td>
                                                        <td>4</td>
                                                        <td>4</td>
                                                        <td>8</td>
                                                        <td>8</td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            
                            
                            
                            
<!-- div_visualizador_costo_extra_detalle, display:none; -->
                            <div id="div_visualizador_costo_extra_detalle" style="display:none;">
                            	<div class="div_separador_mediano">
                                    <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                </div>
                                <div class="titulo">
                                    <font size="5">LISTA COSTO EXTRA POR DETALLE PARTIDA</font>
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
                            </div>
                            
                            
   							
                            
                                                        
<!-- div_costo_extra_detalle, display:none; -->
							<div id="div_costo_extra_detalle" style="display:none;">
								<form name="costo_extra_detalle" action="" accept-charset="ISO-8859-1">
									<input type="hidden" name="id_tipo_trabajo_detalle" value=""/>
									<input type="hidden" name="id_costo_extra" 			value=""/>
									<input type="hidden" name="id_responsable_insumo" 	value=""/>
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
		                                							<select name="select_costo_extra" tabindex="37" onchange="ajaxUnidadCostoExtra()">
		                                								<c:forEach var="costoExtra" items="${listaCostoExtra}">
	                                                                        <option value="${costoExtra.value}">${costoExtra.text}</option>
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
		                                						<td width="1%">Responsable:</td>
		                                						<td>
		                                							<select name="select_responsable_insumo" tabindex="38">
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
		                                									tabindex="39"
		                                									onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
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
		                                									value="${nombre_unidad_medida}"
		                                									tabindex=""
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
		                                								tabindex="40"/>
		                                					</td>
		                                				</tr>
		                                			</table>
	                                			</div>
	                                		</div>
	                                	</div>
	                                </div>
	                                <div class="linea">
	                                	<div class="casilla" style="text-align:right;">
	                                		<img id="imgBtnLimpiarCostoExtraDetalleActivo"
                                                 alt="" style="cursor:pointer;" onclick="limpiaCamposCostoExtraDetalle();"
                                                 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                            <img id="imgBtnLimpiarCostoExtraDetalleInactivo"
                                                 alt="" style="display:none;"
                                                 src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                            <img id="imgBtnAgregarCostoExtraDetalleActivo"
                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaCostoExtraDetalle();"
                                                 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                            <img id="imgBtnAgregarCostoExtraDetalleInactivo"
                                                 alt="" style="display:none;"
                                                 src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
	                                	</div>
	                                </div>
                                </form>
							</div>                           
                         

                            

                            
<!-- div_nueva_partida, display:none;  -->
                            <div id="div_nuevo_tipo_trabajo_detalle" style="display:none;">
                                <div class="div_separador_mediano">
                                    <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                </div>
                                <div class="titulo">
                                    <font size="5">¿DESEA AGREGAR OTRO COMPLEMENTO DE LA PARTIDA?</font>
                                </div>
                                <div class="linea" style="text-align:right;">
                                    <img id="imgBtnAgregarTipoTrabajoDetalleActivo"
                                        alt="" style="cursor:pointer;" onclick="preparaNuevoTipoTrabajoDetalle();"
                                        src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                    <img id="imgBtnAgregarTipoTrabajoDetalleInactivo"
                                        alt="" style="display:none;"
                                        src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                    <span style="width:82px; cursor:pointer;" onclick="muestraDetalleArea();">&nbsp;NO&nbsp;</span>
                                </div>
                            </div>

                            
                            
<!-- div_pestania, display:none; -->
                            <div id="div_pestania" style="display:none;">
                                <div class="div_separador_grande">
                                    <img alt="" src="<c:url value="/resources/image/separador_grande.png"/>"/>
                                </div>
                                <div class="titulo">
                                    <font size="5">DETALLE DE &Aacute;REAS POR PARTIDA</font>
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
                                                    <input type="hidden" name="id_partida" value="">
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
                                                                                    tabindex=""/>
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
                                                                                    tabindex=""/>
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
                                                                                    tabindex=""/>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="linea">
                                                        <div class="casilla" style="text-align:right;">
                                                            <img id="imgBtnLimpiarDisenioActivo"
                                                                 alt="" style="cursor:pointer;" onclick="limpiaCamposFormDisenio();"
                                                                 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                                            <img id="imgBtnLimpiarDisenioInactivo"
                                                                 alt="" style="display:none;"
                                                                 src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                                            <img id="imgBtnAgregarDisenioActivo"
                                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaDisenio();"
                                                                 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                                            <img id="imgBtnAgregarDisenioInactivo"
                                                                 alt="" style="display:none;"
                                                                 src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div id="div_disenio_particular">
                                                <div id="div_disenio_panel_izquierdo">
                                                    <form name="disenio_detalle" action="" accept-charset="utf-8">
                                                        <input type="hidden" name="id_disenio"          value=""/>
                                                        <input type="hidden" name="id_proceso_disenio"  value=""/>
                                                        <div id="div_select_proceso_disenio">
                                                            <select name="select_proceso_disenio" id="select_proceso_disenio" size="5" onclick="selectDisenioDetalleClick(this);" disabled>
                                                                <c:forEach var="pd" items="${listaProcesoDisenio}">
                                                                    <option value="${pd.value}">${pd.text}</option>
                                                                </c:forEach>
                                                            </select>
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
                                                                                            tabindex=""
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
                                                                                                tabindex=""
                                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"
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
                                                                                                value=""
                                                                                                tabindex=""
                                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
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
                                                                                                tabindex=""
                                                                                                disabled></textarea>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="linea">
                                                                <div class="casilla" style="text-align:right;">
                                                                    <img id="imgBtnLimpiarDisenioDetalleActivo"
                                                                         alt="" style="cursor:pointer; display:none;" onclick="limpiaCamposFormDisenioDetalle();"
                                                                         src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                                                    <img id="imgBtnLimpiarDisenioDetalleInactivo"
                                                                         alt="" style="display:inline;"
                                                                         src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                                                    <img id="imgBtnAgregarDisenioDetalleActivo"
                                                                         alt="" style="cursor:pointer; display:none;" onclick="ajaxAgregaDisenioDetalle();"
                                                                         src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                                                    <img id="imgBtnAgregarDisenioDetalleInactivo"
                                                                         alt="" style="display:inline;"
                                                                         src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div id="div_disenio_panel_derecho">
                                                    <div id="div_contenedor_tabla_disenio_detalle"> <!-- height:165px; -->
                                                        <div class="columna_completa">
                                                            <div id="div_tabla_disenio_detalle">
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
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="div_pestania_contenido_preprensa" style="display:none;">
                                        <div id="div_preprensa">
                                            <div id="div_preprensa_general">
                                                <form name="preprensa" action="" accept-charset="utf-8">
                                                	<input type="hidden" name="id_preprensa" 	value=""/>
                                                    <input type="hidden" name="id_partida" 		value=""/>
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
                                                                                    tabindex=""/>
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
                                                                                    tabindex=""/>
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
                                                                                    tabindex=""/>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="linea">
                                                        <div class="casilla" style="text-align:right;">
                                                            <img id="imgBtnLimpiarPreprensaActivo"
                                                                 alt="" style="cursor:pointer;" onclick="limpiaCamposFormPreprensa();"
                                                                 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                                            <img id="imgBtnLimpiarPreprensaInactivo"
                                                                 alt="" style="display:none;"
                                                                 src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                                            <img id="imgBtnAgregarPreprensaActivo"
                                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaPreprensa();"
                                                                 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                                            <img id="imgBtnAgregarPreprensaInactivo"
                                                                 alt="" style="display:none;"
                                                                 src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div id="div_preprensa_particular">
                                                <div id="div_preprensa_panel_izquierdo">
                                                    <form name="preprensa_detalle" action="" accept-charset="utf-8">
                                                        <input type="hidden" name="id_preprensa"            value=""/>
                                                        <input type="hidden" name="id_proceso_preprensa"    value=""/>
                                                        <div id="div_select_proceso_preprensa">
                                                            <select name="select_proceso_preprensa" id="select_proceso_preprensa" size="5" onclick="selectPreprensaDetalleClick(this);" disabled>
                                                                <c:forEach var="pp" items="${listaProcesoPreprensa}">
                                                                    <option value="${pp.value}">${pp.text}</option>
                                                                </c:forEach>
                                                            </select>
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
                                                                                            tabindex=""
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
                                                                                                tabindex=""
                                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"
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
                                                                                                value=""
                                                                                                tabindex=""
                                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
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
                                                                                                tabindex=""
                                                                                                disabled></textarea>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="linea">
                                                                <div class="casilla" style="text-align:right;">
                                                                    <img id="imgBtnLimpiarPreprensaDetalleActivo" alt="" style="cursor:pointer; display:none;" onclick="limpiaCamposFormPreprensaDetalle();" src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                                                    <img id="imgBtnLimpiarPreprensaDetalleInactivo" alt="" style="display:inline;" src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                                                    <img id="imgBtnAgregarPreprensaDetalleActivo" alt="" style="cursor:pointer; display:none;" onclick="ajaxAgregaPreprensaDetalle();" src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                                                    <img id="imgBtnAgregarPreprensaDetalleInactivo" alt="" style="display:inline;" src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div id="div_preprensa_panel_derecho">
                                                    <div id="div_contenedor_tabla_preprensa_detalle">
                                                        <div class="columna_completa">
                                                            <div id="div_tabla_preprensa_detalle">
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
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="div_pestania_contenido_transporte" style="display:none;">
                                        <div id="div_transporte">
                                            <div id="div_transporte_general">
                                                <form name="transporte" action="" accept-charset="utf-8">
                                                    <input type="hidden" name="id_transporte" 	value=""/>
                                                    <input type="hidden" name="id_partida" 		value=""/>
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
                                                                                    tabindex=""/>
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
                                                                                    tabindex=""/>
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
                                                                                    tabindex=""/>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="linea">
                                                        <div class="casilla" style="text-align:right;">
                                                            <img id="imgBtnLimpiarTransporteActivo"
                                                                 alt="" style="cursor:pointer;" onclick="limpiaCamposFormTransporte();"
                                                                 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                                            <img id="imgBtnLimpiarTransporteInactivo"
                                                                 alt="" style="display:none;"
                                                                 src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                                            <img id="imgBtnAgregarTransporteActivo"
                                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaTransporte();"
                                                                 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                                            <img id="imgBtnAgregarTransporteInactivo"
                                                                 alt="" style="display:none;"
                                                                 src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div id="div_transporte_particular">
                                                <div id="div_transporte_panel_izquierdo">
                                                    <form name="transporte_detalle" action="" accept-charset="utf-8">
                                                        <input type="hidden" name="id_transporte"           value=""/>
                                                        <input type="hidden" name="id_proceso_transporte"   value=""/>
                                                        <div id="div_select_proceso_transporte">
                                                            <select name="select_proceso_transporte" id="select_proceso_transporte" size="5" onclick="selectTransporteDetalleClick(this);" disabled>
                                                                <c:forEach var="pt" items="${listaProcesoTransporte}">
                                                                    <option value="${pt.value}">${pt.text}</option>
                                                                </c:forEach>
                                                            </select>
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
                                                                                            tabindex=""
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
                                                                                                tabindex=""
                                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"
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
                                                                                                value=""
                                                                                                tabindex=""
                                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
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
                                                                                                tabindex="" 
                                                                                                disabled></textarea>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="linea">
                                                                <div class="casilla" style="text-align:right;">
                                                                    <img id="imgBtnLimpiarTransporteDetalleActivo"
                                                                         alt="" style="cursor:pointer; display:none;" onclick="limpiaCamposFormTransporteDetalle();"
                                                                         src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                                                    <img id="imgBtnLimpiarTransporteDetalleInactivo"
                                                                         alt="" style="display:inline;"
                                                                         src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                                                    <img id="imgBtnAgregarTransporteDetalleActivo"
                                                                         alt="" style="cursor:pointer; display:none;" onclick="ajaxAgregaTransporteDetalle();"
                                                                         src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                                                    <img id="imgBtnAgregarTransporteDetalleInactivo"
                                                                         alt="" style="display:inline;"
                                                                         src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div id="div_transporte_panel_derecho">
                                                    <div id="div_contenedor_tabla_transporte_detalle">
                                                        <div class="columna_completa">
                                                            <div id="div_tabla_transporte_detalle">
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
                                                </div>
                                            </div>
                                        </div>
                                        
                                    </div>
                                    <div id="div_pestania_contenido_acabado" style="display:none;">
                                        <div id="div_acabado">
                                            <div id="div_acabado_general">
                                                <form name="acabado" action="" accept-charset="utf-8">
                                                    <input type="hidden" name="id_acabado" value=""/>
                                                    <input type="hidden" name="id_partida" value=""/>
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
                                                                                    tabindex=""/>
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
                                                                                    tabindex=""/>
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
                                                                                    tabindex=""/>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="linea">
                                                        <div class="casilla" style="text-align:right;">
                                                            <img id="imgBtnLimpiarAcabadoActivo"
                                                                 alt="" style="cursor:pointer;" onclick="limpiaCamposFormAcabado();"
                                                                 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                                            <img id="imgBtnLimpiarAcabadoInactivo"
                                                                 alt="" style="display:none;"
                                                                 src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                                            <img id="imgBtnAgregarAcabadoActivo"
                                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaAcabado();"
                                                                 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                                            <img id="imgBtnAgregarAcabadoInactivo"
                                                                 alt="" style="display:none;"
                                                                 src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div id="div_acabado_particular">
                                                <div id="div_acabado_panel_izquierdo">
                                                    <form name="acabado_detalle" action="" accept-charset="utf-8">
                                                        <input type="hidden" name="id_acabado"          value=""/>
                                                        <input type="hidden" name="id_proceso_externo"  value=""/>
                                                        <div id="div_select_proceso_externo">
                                                            <select name="select_proceso_externo" id="select_proceso_externo" size="5" onclick="selectAcabadoDetalleClick(this);" disabled>
                                                                <c:forEach var="pe" items="${listaProcesoExterno}">
                                                                    <option value="${pe.value}">${pe.text}</option>
                                                                </c:forEach>
                                                            </select>
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
                                                                                            tabindex=""
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
                                                                                    <td width="1%">Ancho:</td>
                                                                                    <td>
                                                                                        <input  type="text"
                                                                                                class="input"
                                                                                                name="ancho"
                                                                                                value=""
                                                                                                tabindex=""
                                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
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
                                                                                    <td width="1%">Alto:</td>
                                                                                    <td>
                                                                                        <input  type="text"
                                                                                                class="input"
                                                                                                name="alto"
                                                                                                value=""
                                                                                                tabindex=""
                                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
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
                                                                                                tabindex=""
                                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"
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
                                                                                                value=""
                                                                                                tabindex=""
                                                                                                onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"
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
                                                                                                tabindex=""
                                                                                                disabled></textarea>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="linea">
                                                                <div class="casilla" style="text-align:right;">
                                                                    <img id="imgBtnLimpiarAcabadoDetalleActivo"
                                                                         alt="" style="cursor:pointer; display:none;" onclick="limpiaCamposFormAcabadoDetalle();"
                                                                         src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                                                    <img id="imgBtnLimpiarAcabadoDetalleInactivo"
                                                                         alt="" style="display:inline;"
                                                                         src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                                                    <img id="imgBtnAgregarAcabadoDetalleActivo"
                                                                         alt="" style="cursor:pointer; display:none;" onclick="ajaxAgregaAcabadoDetalle();"
                                                                         src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                                                    <img id="imgBtnAgregarAcabadoDetalleInactivo"
                                                                         alt="" style="display:inline;"
                                                                         src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div id="div_acabado_panel_derecho">
                                                    <div id="div_contenedor_tabla_acabado_detalle">
                                                        <div class="columna_completa">
                                                            <div id="div_tabla_acabado_detalle">
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
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="div_pestania_contenido_offset" style="display:none;">
                                        <div id="div_offset">
                                            <div id="div_offset_general">
                                                <form name="offset" action="" accept-charset="utf-8">
                                                    <input type="hidden" name="id_offset" 	value=""/>
                                                    <input type="hidden" name="id_partida" 	value=""/>
                                                    <div class="doble_linea">
                                                        <div class="casilla_doble_alto">
                                                            <div class="columna_completa">
                                                                <table>
                                                                    <tr>
                                                                        <td width="1%" valign="top" style="padding-top:4px;">Indicaciones:</td>
                                                                        <td>
                                                                            <textarea   class="textarea_doble"
                                                                                        name="indicacion_tarea_realizar"
                                                                                        tabindex=""></textarea>
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
                                                                                        tabindex=""></textarea>
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
                                                                                        tabindex=""></textarea>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="linea">
                                                        <div class="casilla" style="text-align:right;">
                                                            <img id="imgBtnLimpiarOffsetActivo"
                                                                 alt="" style="cursor:pointer;" onclick="limpiaCamposFormOffset();"
                                                                 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                                            <img id="imgBtnLimpiarOffsetInactivo"
                                                                 alt="" style="display:none;"
                                                                 src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                                            <img id="imgBtnAgregarOffsetActivo"
                                                                 alt="" style="cursor:pointer;" onclick="ajaxAgregaOffset();"
                                                                 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                                            <img id="imgBtnAgregarOffsetInactivo"
                                                                 alt="" style="display:none;"
                                                                 src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                                
<!-- div_material_ayuda, display:none; -->
                            <div id="div_material_ayuda" style="display:none;">
                                <form name="material_ayuda" action="" accept-charset="ISO-8859-1">
                                    <input type="hidden" name="id_partida"              value=""/>
                                    <input type="hidden" name="id_material_ayuda"       value=""/>
                                    <input type="hidden" name="id_responsable_insumo"   value=""/>
                                    
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
                                                                        <select name="select_material_ayuda" id="select_material_ayuda" tabindex="">
                                                                            <c:forEach var="ma" items="${listaMaterialAyuda}">
                                                                                <option value="${ma.value}">${ma.text}</option>
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
                                                                    <td width="1%">Responsable:</td>
                                                                    <td>
                                                                        <select name="select_responsable_insumo" id="select_responsable_insumo" tabindex="">
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
                                                        <div class="columna_completa">
                                                            <table>
                                                                <tr>
                                                                    <td width="1%">Obs:</td>
                                                                    <td>
                                                                        <input type="text" class="input"
                                                                               name="observaciones"
                                                                               value=""
                                                                               tabindex=""/>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="linea">
                                                <div class="casilla" style="text-align:right;">
                                                    <img id="imgBtnLimpiarMatAyudaActivo"
                                                         alt="" style="cursor:pointer;" onclick="limpiaCamposFormMaterialAyuda();"
                                                         src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                                    <img id="imgBtnLimpiarMatAyudaInactivo"
                                                         alt="" style="display:none;"
                                                         src="<c:url value="/resources/image/boton_limpiar_des.jpg"/>"/>
                                                    <img id="imgBtnAgregarMatAyudaActivo"
                                                         alt="" style="cursor:pointer;" onclick="ajaxAgregaMaterialAyuda();"
                                                         src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                                    <img id="imgBtnAgregarMatAyudaInactivo"
                                                         alt="" style="display:none;"
                                                         src="<c:url value="/resources/image/boton_agregar_des.jpg"/>"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="columna_derecha">
                                            <div style="height:97px;">
                                                <div class="columna_completa">
                                                    <div id="div_tabla_material_ayuda">
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
                                        </div>
                                    </div>
                                </form>
                            </div>
                            
                            
                            

<!-- div_nueva_partida, display:none;  -->
                            <div id="div_nueva_partida" style="display:none;">
                                <div class="div_separador_mediano">
                                    <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                </div>
                                <div class="titulo">
                                    <font size="5">¿DESEA AGREGAR OTRA PARTIDA?</font>
                                </div>
                                <div class="linea" style="text-align:right;">
                                    <img id="imgBtnAgregarPartida"
                                        alt="" style="cursor:pointer;" onclick="preparaNuevaPartida();"
                                        src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                </div>
                            </div>
                            
                            
                            
                            

<!-- div_cotizar, display:none;  -->
                            <div id="div_cotizar" style="display:none;">
                                <form name="cotizacion" action="" accept-charset="ISO-8859-1" method="POST">
                                    <input type="hidden" name="id_orden_produccion" value=""/>
                                    <div class="div_separador_grande">
                                        <img alt="" src="<c:url value="/resources/image/separador_grande.png"/>"/>
                                    </div>
                                    <div class="titulo">
                                        <font size="5">¿DESEA COTIZAR?</font>
                                    </div>
                                    <div id="div_area_boton_enviar">
                                        <img alt="" style="cursor:pointer;" onclick="cotizar();"
                                        	 src="<c:url value="/resources/image/boton_enviar.jpg"/>"/>
                                    </div>
                                </form>
                            </div>
                            
                            
                            
                            
                        </div>
                    </div>
                    <div id="div_pie"></div>
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
        <div id="notificacion_tipo_growl">
            <span id="cerrar_notificacion_growl" style="cursor:pointer;">CLOSE
                <br></br>Se recomienda que el ancho sea mayor que el alto.</span>
        </div>
    
        <!-- NO BORRAR: FORM DE MUESTRA PARA SUBIR UN ARCHIVO AL SERVIDOR
        <div>
            <form name="upload_file" action="upload_file_example" method="POST" enctype="multipart/form-data">
                File to upload: <input type="file" name="file"><br/>
                Notes about the file: <input type="text" name="note"><br/>
                <br/>
                <input  type="submit" value="Press"> to upload file!
            </form>
        </div>
        -->
    </body>
</html>