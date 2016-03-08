<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" 	uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/?opc=produccion"	               				var="urlMenu"/>
<c:url value="/semaforo/busca_ordenes_produccion"   		var="urlBuscaOrdenesProduccion"/>
<c:url value="/semaforo/obtiene_detalle_nut"   				var="urlObtieneDetalleNut"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Sem&aacute;foro por &aacute;rea</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/semaforo_visualizador.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/paginador.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/shadowbox/shadowbox.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/paginador.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/semaforo_visualizador.js"/>"></script>
        <script type="text/javascript">
        	$(document).ready(function (){});
            Shadowbox.init({});
        </script>
        <script type="text/javascript">
            var numero_total_registros	        = ${numeroTotalRegistros};
            var numero_registros_por_pagina		= ${numeroRegistrosPorPagina};
            var tamanio_maximo_arreglo	        = ${tamanioMaximoArreglo};	// DEBE SER MAYOR A 2
            var numero_pagina		        	= 1;						// NO DEBE MODIFICARSE
            
            var tamanio_arreglo		        	= 0; 	// se inicializan en carga_datos()
            var numero_pagina_total	        	= 0; 	// se inicializan en carga_datos()
            var mitad_tamanio_arreglo	        = 0;	// se inicializan en carga_datos()
        </script>
        <script type="text/javascript">
        	var urlMenu 					= "${urlMenu}";
        	var urlBuscaOrdenesProduccion 	= "${urlBuscaOrdenesProduccion}";
        	var urlObtieneDetalleNut		= "${urlObtieneDetalleNut}";
        </script>
        <script type="text/javascript">
	        function regresa_menu() {
	        	location.replace(urlMenu);
	        }
        </script>
	</head>
	<body onload="carga_datos();">
        <div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_cabecera">
                        <div id="div_logo">
                            <img alt="" src="<c:url value="/resources/image/logo.png"/>"/>
                        </div>
                        <div id="div_encabezado">
                            <img alt="" src="<c:url value="/resources/image/encabezado_cotizador.png"/>"/>
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                            <div class="div_menu_item">
                                <img alt="" src="<c:url value="/resources/image/boton_menu_produccion.png"/>"/>
                                <ul id="menu_produccion">
                                    <li>
                                        <a href="#">
                                            <img alt="" src="<c:url value="/resources/image/menu_diseno.png"/>"/>
                                        </a>
                                        <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                    </li>
                                </ul>
                            </div>
                            <div id="div_cerrar_sesion">
                                <span style="cursor:pointer;" onclick="regresa_menu();">
                                    <img alt="" src="<c:url value="/resources/image/boton_regresar_menu.jpg"/>"/>
                                </span>
                            </div>
                        </div>
                        <div id="div_contenido">
                            <div id="div_visualizador">
                                <div class="titulo">
                                    <font size="5">VISUALIZADOR DE ORDENES DE PRODUCCI&Oacute;N</font>
                                </div>
                                <div class="linea">
                                    <div class="casilla">
                                        <div id="div_paginacion_resultados" style="float:right;">
                                        	0 registros encontrados. Mostrando del 0 al 0.
                                        </div>    
                                    </div>
                                </div>
                                <div id="div_grid">
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_registros">
                                                <table id="tabla_registros">
                                                    <tr>
                                                        <th width="15%">NUT</th>
                                                        <th width="15%">Nombre</th>
                                                        <th width="30%">Descripci&oacute;n</th>
                                                        <th width="10%">Fecha cotizaci&oacute;n</th>
                                                        <th width="20%">Cliente</th>
                                                        <th width="10%">Estatus</th>
                                                    </tr>
                                                <c:choose>
                                                	<c:when test="${fn:length(listaOrdenesProduccion) gt 0}">
                                                		<c:forEach var="registro" items="${listaOrdenesProduccion}" varStatus="i">
		                                                    <tr class="${i.count%2==0?'l2':'l1'}" onclick="muestra_detalle_nut('${registro.nut}');">
		                                                        <td>${registro.nut}</td>
		                                                        <td>${registro.nombre}</td>
		                                                        <td>${registro.descripcion}</td>
		                                                        <td><fmt:formatDate value="${registro.fechaCotizacion}" type="both" pattern="MMM dd, yyyy"/></td>
		                                                        <td>${registro.nombreMoral}</td>
		                                                        <td id="td_${registro.nut}" class="estatus_${registro.idEstatusOrden}">${registro.nombreEstatus}</td>
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
                                                			<td>&nbsp;</td>
                                                		</tr>
                                                	</c:otherwise>
                                                </c:choose>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="linea">
                                    <div class="casilla">
                                        <div id="div_paginador"></div>
                                    </div>
                                </div>
                                <form name="busqueda_semaforo" action="" accept-charset="ISO-8859-1">
                                    <input type="hidden" name="numero_pagina"               value=""/>
                                    <input type="hidden" name="numero_registros_por_pagina" value=""/>
                                    <div class="div_separador_mediano">
                                        <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                    </div>
                                    <div class="titulo">
                                        <font size="5">CRITERIOS DE B&Uacute;SQUEDA</font>
                                    </div>
                                    <div class="linea">
                                    	<div class="casilla">
                                    		<div class="columna_izquierda">
                                    			<div class="mitad_columna_izquierda">
                                    				<div class="columna_completa">
                                    					<table>
                                    						<tr>
                                    							<td width="30%">
                                    								<input type="checkbox" name="chkbx_busca_por_nut"/>
                                    								<span onclick="document.busqueda_semaforo.chkbx_busca_por_nut.click()" style="cursor: pointer;">NUT:</span>
                                    							</td>
                                    							<td>
                                    								<input 	type="text"
                                    										class="input"
                                    										name="nut"
                                    										value=""
                                    										maxlength="10"
                                    										onkeydown="revisaNumero(false, this.value, event, 'nueva_busqueda', null)"
                                    								/>
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
                                    						<td width="20%">
                                    							<input type="checkbox" name="chkbx_busca_por_nombre_op"/>
                                    							<span onclick="document.busqueda_semaforo.chkbx_busca_por_nombre_op.click()" style="cursor: pointer;">Nombre:</span>
                                    						</td>
                                    						<td>
                                    							<input 	type="text"
                                    									class="input"
                                    									name="nombre"
                                    									value=""/>
                                    						</td>
                                    					</tr>
                                    				</table>
                                    			</div>
                                    		</div>
                                    		<div class="columna_derecha">
                                    			<div class="columna_completa">
                                    				<table>
                                    					<tr>
                                    						<td width="25%">
                                    							<input type="checkbox" name="chkbx_busca_por_descripcion"/>
                                    							<span onclick="document.busqueda_semaforo.chkbx_busca_por_descripcion.click()" style="cursor: pointer;">Descripci&oacute;n:</span>
                                    						</td>
                                    						<td>
                                    							<input 	type="text"
                                    									class="input"
                                    									name="descripcion"
                                    									value=""/>
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
                                    						<td width="18%">
                                    							<input type="checkbox" name="chkbx_busca_por_nombre_moral"/>
                                    							<span onclick="document.busqueda_semaforo.chkbx_busca_por_nombre_moral.click()" style="cursor: pointer;">Cliente:</span>
                                    						</td>
                                    						<td>
                                    							<input	type="text"
                                    									class="input"
                                    									name="nombre_moral"
                                    									value=""/>
                                    						</td>
                                    					</tr>
                                    				</table>
                                    			</div>
                                    		</div>
                                    	</div>
                                    </div>
                                    <br/>
                                    <div class="linea">
                                        <div class="casilla" style="text-align:right;">
                                            <img alt="" style="cursor:pointer;" onclick="limpia();" src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                            <span style="cursor:pointer;" onclick="nueva_busqueda()">&nbsp;Buscar&nbsp;</span>
                                        </div>
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
    </body>
</html>