<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:url value="/semaforo/obtiene_partida"         		var="urlObtienePartida"/>
<c:url value="/semaforo/obtiene_tipo_trabajo_detalle"   var="urlObtieneTipoTrabajoDetalle"/>
<c:url value="/semaforo/cambia_estatus"   				var="urlCambiaEstatus"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Resumen Cotizaci&oacute;n</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/semaforo_detalle_nut.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/master.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/semaforo_detalle_nut.js"/>"></script>
        <script type="text/javascript">
            $(document).ready(function (){});
        </script>
        <script type="text/javascript">
        	var urlObtienePartida 				= "${urlObtienePartida}";
        	var urlObtieneTipoTrabajoDetalle	= "${urlObtieneTipoTrabajoDetalle}";
        	var urlCambiaEstatus				= "${urlCambiaEstatus}";
        </script>
	</head>
	<body>
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
                                    </form>
                                </div>
                            <!-- div_visualizador_partidas -->
                                <div id="div_visualizador_partidas">
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
                            <!-- div_partida, display:none -->
                                <div id="div_partida" style="display:none;">
                                    <form name="partida" action="" accept-charset="ISO-8859-1">
                                    	<input type="hidden" name="id_orden_produccion" 	value="${ordenProduccion.idOrdenProduccion}">
                                    	<input type="hidden" name="nut"						value="${ordenProduccion.nut}">
                                    	<input type="hidden" name="id_partida" 				value="">
                                    	<input type="hidden" name="id_tipo_forma_trabajo" 	value="">
                                        <div class="div_separador_mediano">
                                            <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                        </div>    
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
                                                                    <td width="1%">Tipo:</td>
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
                                    </form>
                                </div>
                            <!-- div_visualizador, display:none -->
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
                                </div>
							<!-- div_tipo_trabajo_detalle, display:none -->                            
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
                                    	
                                        <div class="div_separador_mediano">
                                            <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                        </div>
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
                                                                        		class="input"
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
                                                                        		class="input"
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
                                                                        		class="input"
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
                                                                        		class="input"
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
                                    </form>
                                </div>
							<!-- div_visualizador_pliegos, display:none -->
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
                                    </form>
                                </div>
	<!-- div_costo_extra_detalle, display:none; -->
							<!-- div_pestania -->
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
                                                    </form>
                                                </div>
                                                <div class="linea"></div>
                                                <div id="div_disenio_particular">
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
                                                    </form>
                                                </div>
                                                <div class="linea"></div>
                                                <div id="div_preprensa_particular">
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
                                                    </form>
                                                </div>
                                                <div class="linea"></div>
                                                <div id="div_transporte_particular">
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
                                                    </form>
                                                </div>
                                                <div class="linea"></div>
                                                <div id="div_acabado_particular">
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
	                                        <div id="div_contenedor_tabla_material_ayuda" style=" width:800px; height:105px; margin-left: auto; margin-right: auto;">
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
                                        </div>
                                    </form>
                                </div>
							<!-- div_cambio_estatus -->
                                <div id="div_cambio_estatus">
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
	                                    			<span style="cursor:pointer;" onclick="ajaxCambiaEstatus();">
	                                    				MODIFICAR
	                                    			</span>
		                                    	</div>
		                                    </div>
		                                    <div class="linea"></div>
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