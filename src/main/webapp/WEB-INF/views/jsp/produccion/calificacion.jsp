<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/"										var="urlMenu"/>
<c:url value="/calificacion/resumen_partida"			var="urlResumenCalificacionPartida"/>
<c:url value="/calificacion/resumen_trabajo_detalle"	var="urlResumenCalificacionTrabajoDetalle"/>
<c:url value="/calificacion/resumen_procesos"			var="urlResumenCalificacionProcesos"/>
<c:url value="/reporte/condiciones_produccion"			var="urlCondicionesProduccion"/>
<fmt:setLocale value="en_US" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Resumen Orden Producci&oacute;n</title>
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/jstree.style.min.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/calificacion.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/jstree.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/shadowbox/shadowbox.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/calificacion.js"/>"></script>
        <script type="text/javascript">
            Shadowbox.init({ });
        </script>
        <script type="text/javascript">
        	var urlMenu 								= "${urlMenu}";
        	var urlResumenCalificacionTrabajoDetalle 	= "${urlResumenCalificacionTrabajoDetalle}";
        	var urlResumenCalificacionPartida			= "${urlResumenCalificacionPartida}";
        	var urlResumenCalificacionProcesos			= "${urlResumenCalificacionProcesos}";
        	var urlCondicionesProduccion				= "${urlCondicionesProduccion}";
        </script>
        <script type="text/javascript">
        	var jsonArbol = '${jsonArbol}';
        </script>
        <script type="text/javascript">
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
                            <img alt="" src="<c:url value="/resources/image/encabezado_orden_produccion.png"/>"/>
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                            <div id="div_contenido_menu">
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
                        </div>
                        <div id="div_contenido">
                        
                        	<div id="div_cliente">
                        		<form name="cliente" action="" accept-charset="ISO-8859-1">
                        			<div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_cliente.png"/>"/>
                                    </div>
                        			<div class="linea">
                        				<div class="casilla">
                        					<div class="columna_izquierda">
                        						<div class="columna_completa">
                        							<table>
                        								<tr>
                        									<td width="1%">Cliente:</td>
                        									<td>
                        										<input	type="text"
                        												class="input"
                        												name="nombre_moral"
                        												value="${cliente.nombreMoral}"
                        												tabindex=""
                        												onkeypress=""
                        												readOnly>
                        									</td>
                        								</tr>
                        							</table>
                        						</div>
                        					</div>
                        					<div class="columna_derecha">
                        						<div class="columna_completa">
                        							<table>
                        								<tr>
                        									<td width="1%">Representante:</td>
                        									<td>
                        										<input	type="text"
                        												class="input"
                        												name="nombre_representante"
                        												value="${cliente.nombreRepresentante}"
                        												tabindex=""
                        												onkeypress=""
                        												readOnly>
                        									</td>
                        								</tr>
                        							</table>
                        						</div>
                        					</div>
                        				</div>
                        			</div>
                        		</form>
                        	</div>
                        	<div id="div_orden_produccion">
                        		<form name="orden_produccion" action="" accept-charset="ISO-8859-1">
                        			<input type="hidden" name="id_orden_produccion" value="${ordenProduccion.idOrdenProduccion}">
                        			<div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_orden.png"/>"/>
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
                                                                        name="nombre"
                                                                        value="${ordenProduccion.nombre}"
                                                                        tabindex=""
                                                                        onkeypress=""
                                                                        readonly>
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
                                                                <td width="1%">NUT:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="nut"
                                                                            value="${ordenProduccion.nut}"
                                                                            tabindex=""
                                                                            onkeypress=""
                                                                            readonly>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="1%">Fecha:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            name="fecha_generacion"
                                                                            value="<fmt:formatDate value="${ordenProduccion.fechaGeneracion}" type="both" pattern="MMM dd, yyyy"/>"
                                                                            tabindex=""
                                                                            onkeypress=""
                                                                            readonly>
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
                                                                    name="descripcion"
                                                                    value="${ordenProduccion.descripcion}"
                                                                    tabindex=""
                                                                    onkeypress=""
                                                                    readonly>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                        		</form>
                        	</div>
                            <div id="div_calificacion_orden_produccion">
                                <form name="calificacion_orden_produccion" action="" accept-charset="ISO-8859-1">
                                    <div class="titulo">
                                        <font size="5">CALIFICACI&Oacute;N</font>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="50%">Precio maquila:</td>
                                                                <td>
                                                                    <input  type="text"
                                                                            class="input"
                                                                            style="text-align:right;"
                                                                            name="precio_bruto"
                                                                            value="<fmt:formatNumber pattern="$ #,##0.00" value="${calificacionOrdenProduccion.precioBruto}" />"
                                                                            tabindex=""
                                                                            onkeypress=""
                                                                            readonly>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="46%">Precio cliente:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            style="text-align:right;"
                                                                            name="precio_cliente"
                                                                            value="<fmt:formatNumber pattern="$ #,##0.00" value="${calificacionOrdenProduccion.precioCliente}" />"
                                                                            tabindex=""
                                                                            onkeypress=""
                                                                            readonly>
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
                                                				<td width="1%">Comprobante:</td>
                                                				<td>
                                                					<input	type="text"
                                                							class="input"
                                                							name="nombre_comprobante_fiscal"
                                                							value="${calificacionOrdenProduccion.ordenProduccion.tipoComprobanteFiscal.nombre}"
                                                							tabindex=""
                                                							onkeypress=""
                                                							readOnly>
                                                				</td>
                                                			</tr>
                                                		</table>
                                                	</div>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="40%">Precio neto:</td>
                                                                <td>
                                                                    <input  type="text" 
                                                                            class="input"
                                                                            style="text-align:right;"
                                                                            name="precio_neto"
                                                                            value="<fmt:formatNumber pattern="$ #,##0.00" value="${calificacionOrdenProduccion.precioNeto}" />"
                                                                            tabindex=""
                                                                            onkeypress=""
                                                                            readonly>
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
                            <div id="div_resumen_partida">
                                <div class="div_separador_grande">
                                    <img alt="" src="<c:url value="/resources/image/separador_grande.png"/>"/>
                                </div>
                                <div class="titulo">
                                    <font size="5">DETALLE DE ORDEN DE PRODUCCI&Oacute;N</font>
                                </div>
                                <div style="height:763px; margin:0px 0px 5px 0px;">
                                    <div class="mitad_columna_izquierda">
                                        <div class="columna_completa">
                                            <div id="arbol_partidas" style="height:100%; overflow:auto;"></div>
                                        </div>
                                    </div>
                                    <div class="columna_derecha_tres_cuartos" style="background:#fff;">
<!-- div_orden_produccion_detalle -->
                                    	<div id="div_orden_produccion_detalle" style="width:100px; height:100px; background:transparent; float:left; display:none;"></div>
<!-- div_partida_detalle -->                           	
                                    	<div id="div_partida_detalle" style="width:100%; height:100%; background:#fff; float:left; display:none;">
                                    		<form name="resumen_partida" action="" accept-charset="ISO-8859-1">
	                                    		<div class="titulo">
	                                    			<font size="4">CALIFICACI&Oacute;N DE PARTIDA</font>
	                                    		</div>
	                                    		<div class="linea">
	                                    			<div class="casilla">
	                                    				<div class="mitad_columna_izquierda">
	                                    					<div class="columna_completa">
	                                    						<table>
	                                    							<tr>
	                                    								<td width="1%">Tipo:</td>
	                                    								<td>
	                                    									<input	type="text"
	                                    											class="input"
	                                    											name="nombre_tipo_trabajo"
	                                    											value=""
	                                    											tabindex=""
	                                    											onkeypress=""
	                                    											readonly>
	                                    								</td>
	                                    							</tr>
	                                    						</table>
	                                    					</div>
	                                    				</div>
	                                    			</div>
	                                    		</div>
	                                    		<div class="linea">
	                                    			<div class="casilla">
	                                    				<div class="columna_centrales_juntas">
	                                    					<div class="columna_completa">
	                                    						<table>
	                                    							<tr>
	                                    								<td width="1%">Nombre:</td>
	                                    								<td>
	                                    									<input	type="text"
	                                    											class="input"
	                                    											name="nombre_partida"
	                                    											value=""
	                                    											tabindex=""
	                                    											onkeypress=""
	                                    											readonly>
	                                    								</td>
	                                    							</tr>
	                                    						</table>
	                                    					</div>
	                                    				</div>
	                                    				<div class="mitad_columna_derecha">
	                                    					<div class="columna_completa">
	                                    						<table>
	                                    							<tr>
	                                    								<td width="1%">Cantidad:</td>
	                                    								<td>
	                                    									<input	type="text"
	                                    											class="input"
	                                    											name="cantidad"
	                                    											value=""
	                                    											tabindex=""
	                                    											onkeypress=""
	                                    											readonly>
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
	                                   								<td width="1%">Descripci&oacute;n:</td>
	                                   								<td>
	                                   									<input	type="text"
	                                   											class="input"
	                                   											name="descripcion_partida"
	                                   											value=""
	                                   											tabindex=""
	                                   											onkeypress=""
	                                   											readonly>
	                                   								</td>
	                                   							</tr>
	                                   						</table>
	                                    				</div>
	                                    			</div>
	                                    		</div>
	                                    		<div class="div_separador_chico">
	                                            	<img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
	                                            </div>
	                                    		<div class="linea">
	                                    			<div class="casilla">
	                                    				<div class="mitad_columna_derecha">
	                                    					<div class="columna_completa">
	                                    						<table>
		                                   							<tr>
		                                   								<td width="1%">Total:</td>
		                                   								<td>
		                                   									<input	type="text"
		                                   											class="input"
		                                   											style="text-align:right;"
		                                   											name="coste_total"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
		                                   											
		                                   								</td>
		                                   							</tr>
		                                   						</table>
	                                    					</div>
	                                    				</div>
	                                    			</div>
	                                    		</div>
                                    		</form>
                                    	</div>
<!-- div_tipo_trabajo_detalle -->
                                    	<div id="div_tipo_trabajo_detalle" style="width:100%; height:100%; background:#fff; float:left; display:none;">
                                    		<form name="resumen_tipo_trabajo_detalle" action="" accept-charset="ISO-8859-1">
	                                    		<div class="titulo">
	                                    			<font size="4">CALIFICACI&Oacute;N DE SUBPARTIDA</font>
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
	                                                                            tabindex=""
	                                                                            onkeypress=""
	                                                                            readonly>
	                                                                </td>
	                                                            </tr>
	                                                        </table>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                            <div class="linea">
	                                                <div class="casilla">
	                                                	<div class="columna_centrales_juntas">
	                                                		<div class="columna_completa">
	                                                			<table>
		                                                            <tr>
		                                                                <td width="1%">M&aacute;quina:</td>
		                                                                <td>
		                                                                    <input  type="text"
		                                                                            class="input"
		                                                                            name="maquina_descripcion"
		                                                                            value=""
		                                                                            tabindex=""
		                                                                            onkeypress=""
		                                                                            readonly>
		                                                                </td>
		                                                            </tr>
		                                                        </table>
	                                                		</div>
	                                                	</div>
	                                                	<div class="mitad_columna_derecha">
	                                                		<div class="columna_completa">
	                                                        	<table>
	                                                        		<tr>
	                                                        			<td width="60%">Cant. redondeada:</td>
	                                                        			<td>
	                                                        				<input	type="text"
	                                                        						class="input"
	                                                        						name="cantidad_redondeada"
	                                                        						value=""
	                                                        						tabindex=""
	                                                        						onkeypress=""
	                                                        						readonly>
	                                                        			</td>
	                                                        		</tr>
	                                                        	</table>
	                                                    	</div>
	                                                	</div>
	                                                </div>
	                                            </div>
	                                            <div class="linea">
	                                            	<div class="casilla">
	                                            		<div class="mitad_columna_izquierda">
	                                            			<div class="columna_completa">
	                                            				<table>
	                                            					<tr>
	                                            						<td width="57%">No. Repeticiones:</td>
	                                            						<td>
	                                            							<input	type="text"
	                                            									class="input"
	                                            									name="repeticiones_x_pliego"
	                                            									value=""
	                                            									tabindex=""
	                                            									onkeypress=""
	                                            									readOnly>
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
	                                            						<td width="43%">No. P&aacute;ginas:</td>
	                                            						<td>
	                                            							<input	type="text"
	                                            									class="input"
	                                            									name="numero_paginas_publicacion"
	                                            									value=""
	                                            									tabindex=""
	                                            									onkeypress=""
	                                            									readOnly>
	                                            						</td>
	                                            					</tr>
	                                            				</table>
	                                            				</div>
	                                            			</div>
	                                            			<div class="mitad_columna_derecha">
	                                            				<div class="columna_completa">
	                                            					<table>
		                                            					<tr>
		                                            						<td width="1%">Tama&ntilde;o:</td>
		                                            						<td>
		                                            							<input	type="text"
		                                            									class="input"
		                                            									name="tamanio_publicacion"
		                                            									value=""
		                                            									tabindex=""
		                                            									onkeypress=""
		                                            									readOnly>
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
	                                            		<div class="mitad_columna_izquierda">
	                                            			<div class="columna_completa">
	                                            				<table>
	                                            					<tr>
	                                            						<td width="40%">No. Pliegos:</td>
	                                            						<td>
	                                            							<input	type="text"
	                                                        						class="input"
	                                                        						name="numero_pliegos"
	                                                        						value=""
	                                                        						tabindex=""
	                                                        						onkeypress=""
	                                                        						readonly>
	                                            						</td>
	                                            					</tr>
	                                            				</table>
	                                            			</div>
	                                            		</div>
	                                            	</div>
	                                            </div>
	                              <!-- PAPEL -->
	                                            <div class="titulo">
	                                            	<font size="4">PAPEL</font>
	                                            </div>
	                                            <div class="linea">
	                                            	<div class="casilla">
	                                            		<div class="columna_centrales_juntas">
	                                            			<div class="columna_completa">
		                                            			<table>
		                                   							<tr>
		                                   								<td width="1%">Descripci&oacute;n:</td>
		                                   								<td>
		                                   									<input	type="text"
		                                   											class="input"
		                                   											name="papel_descripcion"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
		                                   								</td>
		                                   							</tr>
		                                   						</table>
	                                            			</div>
	                                            		</div>
	                                            	</div>
	                                            </div>
	                                   			<div class="linea">
	                                   				<div class="casilla">
	                                   					<div class="mitad_columna_izquierda">
	                                   						<div class="columna_completa">
		                                   						<table>
		                                   							<tr>
		                                   								<td width="46%">Cantidad req.:</td>
		                                   								<td>
		                                   									<input	type="text"
		                                   											class="input"
		                                   											name="papel_cantidad_total"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
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
		                                   									<td width="49%">Precio unitario:</td>
		                                   									<td>
		                                   										<input	type="text"
		                                   												class="input"
		                                   												style="text-align:right;"
		                                   												name="papel_precio_unitario"
		                                   												value=""
		                                   												tabindex=""
		                                   												onkeypress=""
		                                   												readonly>
		                                   									</td>
		                                   								</tr>
		                                   							</table>
	                                   							</div>
	                                   						</div>
	                                   						<div class="mitad_columna_derecha">
	                                   							<div class="columna_completa">
		                                   							<table>
		                                   								<tr>
		                                   									<td width="1%">Precio:</td>
		                                   									<td>
		                                   										<input	type="text"
		                                   												class="input"
		                                   												style="text-align:right;"
		                                   												name="papel_coste_total"
		                                   												value=""
		                                   												tabindex=""
		                                   												onkeypress=""
		                                   												readonly>
		                                   									</td>
		                                   								</tr>
		                                   							</table>
		                                   						</div>
	                                   						</div>
	                                   					</div>
	                                   				</div>
	                                   			</div>
	                              <!-- TINTA -->
	                                            <div class="titulo">
	                                            	<font size="4">TINTA</font>
	                                            </div>
	                                            <div class="linea">
	                                            	<div class="casilla">
	                                            		<div class="columna_centrales_juntas">
	                                            			<div class="columna_completa">
	                                            				<table>
	                                            					<tr>
	                                            						<td width="1%">Descripci&oacute;n:</td>
	                                            						<td>
	                                            							<input	type="text"
	                                            									class="input"
	                                            									name="tinta_descripcion"
	                                            									value=""
	                                            									tabindex=""
	                                            									onkeypress=""
	                                            									readonly>
	                                            						</td>
	                                            					</tr>
	                                            				</table>
	                                            			</div>
	                                            		</div>
	                                            	</div>
	                                            </div>
	                                   			<div class="linea">
	                                   				<div class="casilla">
	                                   					<div class="mitad_columna_izquierda">
	                                   						<div class="columna_completa">
	                                   							<table>
	                                   								<tr>
	                                   									<td width="61%">Entradas m&aacute;quina:</td>
	                                   									<td>
	                                   										<input	type="text"
		                                   											class="input"
		                                   											name="tinta_num_ent_maq"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
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
		                                   									<td width="49%">Precio unitario:</td>	
		                                   									<td>
		                                   										<input	type="text"
		                                   												class="input"
		                                   												style="text-align:right;"
		                                   												name="tinta_precio_unitario"
		                                   												value=""
		                                   												tabindex=""
		                                   												onkeypress=""
		                                   												readonly>
		                                   									</td>
		                                   								</tr>
		                                   							</table>
	                                   							</div>
	                                   						</div>
	                                   						<div class="mitad_columna_derecha">
	                                   							<div class="columna_completa">
	                                   								<table>
		                                   								<tr>
		                                   									<td width="1%">Precio:</td>
		                                   									<td>
		                                   										<input	type="text"
		                                   												class="input"
		                                   												style="text-align:right;"
		                                   												name="tinta_coste_total"
		                                   												value=""
		                                   												tabindex=""
		                                   												onkeypress=""
		                                   												readonly>
		                                   									</td>
		                                   								</tr>
		                                   							</table>
	                                   							</div>
	                                   						</div>
	                                   					</div>
	                                   				</div>
	                                   			</div>
	                            <!-- TINTA ESPECIAL -->
	                                   			<div class="titulo">
	                                            	<font size="4">TINTA ESPECIAL</font>
	                                            </div>
	                                            <div class="linea">
	                                            	<div class="casilla">
	                                            		<div class="columna_centrales_juntas">
	                                            			<div class="columna_completa">
	                                            				<table>
	                                            					<tr>
	                                            						<td width="1%">Descripci&oacute;n:</td>
	                                            						<td>
	                                            							<input	type="text"
	                                            									class="input"
	                                            									name="tinta_especial_descripcion"
	                                            									value=""
	                                            									tabindex=""
	                                            									onkeypress=""
	                                            									readonly>
	                                            						</td>
	                                            					</tr>
	                                            				</table>
	                                            			</div>
	                                            		</div>
	                                            	</div>
	                                            </div>
	                                            <div class="linea">
	                                   				<div class="casilla">
	                                   					<div class="mitad_columna_izquierda">
	                                   						<div class="columna_completa">
	                                   							<table>
	                                   								<tr>
	                                   									<td width="61%">Entradas m&aacute;quina:</td>
	                                   									<td>
	                                   										<input	type="text"
		                                   											class="input"
		                                   											name="tinta_especial_num_ent_maq"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
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
		                                   									<td width="49%">Precio unitario:</td>	
		                                   									<td>
		                                   										<input	type="text"
		                                   											class="input"
		                                   											style="text-align:right;"
		                                   											name="tinta_especial_precio_unitario"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
		                                   									</td>
		                                   								</tr>
		                                   							</table>
	                                   							</div>
	                                   						</div>
	                                   						<div class="mitad_columna_derecha">
	                                   							<div class="columna_completa">
	                                   								<table>
		                                   								<tr>
		                                   									<td width="1%">Precio:</td>
		                                   									<td>
		                                   										<input	type="text"
		                                   											class="input"
		                                   											style="text-align:right;"
		                                   											name="tinta_especial_coste_total"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
		                                   									</td>
		                                   								</tr>
		                                   							</table>
	                                   							</div>
	                                   						</div>
	                                   					</div>
	                                   				</div>
	                                   			</div>
	                              <!-- BARNIZ -->
	                                            <div class="titulo">
	                                            	<font size="4">BARNIZ</font>
	                                            </div>
	                                            <div class="linea">
	                                            	<div class="casilla">
	                                            		<div class="columna_centrales_juntas">
	                                            			<div class="columna_completa">
	                                            				<table>
	                                            					<tr>
	                                            						<td width="1%">Descripci&oacute;n:</td>
	                                            						<td>
	                                            							<input	type="text"
	                                            									class="input"
	                                            									name="barniz_descripcion"
	                                            									value=""
	                                            									tabindex=""
	                                            									onkeypress=""
	                                            									readonly>
	                                            						</td>
	                                            					</tr>
	                                            				</table>
	                                            			</div>
	                                            		</div>
	                                            	</div>
	                                            </div>
	                                            <div class="linea">
	                                   				<div class="casilla">
	                                   					<div class="mitad_columna_izquierda">
	                                   						<div class="columna_completa">
	                                   							<table>
	                                   								<tr>
	                                   									<td width="68%">Frente ent. m&aacute;quina:</td>
	                                   									<td>
	                                   										<input	type="text"
		                                   											class="input"
		                                   											name="frente_barniz_num_ent_maq"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
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
		                                   									<td width="49%">Precio unitario:</td>	
		                                   									<td>
		                                   										<input	type="text"
		                                   											class="input"
		                                   											style="text-align:right;"
		                                   											name="frente_barniz_precio_unitario"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
		                                   									</td>
		                                   								</tr>
		                                   							</table>
	                                   							</div>
	                                   						</div>
	                                   						<div class="mitad_columna_derecha">
	                                   							<div class="columna_completa">
	                                   								<table>
		                                   								<tr>
		                                   									<td width="1%">Precio:</td>
		                                   									<td>
		                                   										<input	type="text"
		                                   											class="input"
		                                   											style="text-align:right;"
		                                   											name="frente_barniz_coste_total"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
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
	                                   					<div class="mitad_columna_izquierda">
	                                   						<div class="columna_completa">
	                                   							<table>
	                                   								<tr>
	                                   									<td width="68%">Vuelta ent. m&aacute;quina:</td>
	                                   									<td>
	                                   										<input	type="text"
		                                   											class="input"
		                                   											name="vuelta_barniz_num_ent_maq"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
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
		                                   									<td width="49%">Precio unitario:</td>	
		                                   									<td>
		                                   										<input	type="text"
		                                   											class="input"
		                                   											style="text-align:right;"
		                                   											name="vuelta_barniz_precio_unitario"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
		                                   									</td>
		                                   								</tr>
		                                   							</table>
	                                   							</div>
	                                   						</div>
	                                   						<div class="mitad_columna_derecha">
	                                   							<div class="columna_completa">
	                                   								<table>
		                                   								<tr>
		                                   									<td width="1%">Precio:</td>
		                                   									<td>
		                                   										<input	type="text"
		                                   												class="input"
		                                   												style="text-align:right;"
		                                   												name="vuelta_barniz_coste_total"
		                                   												value=""
		                                   												tabindex=""
		                                   												onkeypress=""
		                                   												readonly>
		                                   									</td>
		                                   								</tr>
		                                   							</table>
	                                   							</div>
	                                   						</div>
	                                   					</div>
	                                   				</div>
	                                   			</div>
	                              <!-- PLACAS -->
	                                            <div class="titulo">
	                                            	<font size="4">PLACAS</font>
	                                            </div>
	                                            <div class="linea">
	                                            	<div class="casilla">
	                                            		<div class="columna_centrales_juntas">
	                                            			<div class="columna_completa">
	                                            				<table>
	                                            					<tr>
	                                            						<td width="1%">Descripci&oacute;n:</td>
	                                            						<td>
	                                            							<input	type="text"
	                                            									class="input"
	                                            									name="placas_descripcion"
	                                            									value=""
	                                            									tabindex=""
	                                            									onkeypress=""
	                                            									readonly>
	                                            						</td>
	                                            					</tr>
	                                            				</table>
	                                            			</div>
	                                            		</div>
	                                            	</div>
	                                            </div>
	                                            <div class="linea">
	                                   				<div class="casilla">
	                                   					<div class="mitad_columna_izquierda">
	                                   						<div class="columna_completa">
	                                   							<table>
	                                   								<tr>
	                                   									<td width="52%">N&uacute;mero placas:</td>
	                                   									<td>
	                                   										<input	type="text"
		                                   											class="input"
		                                   											name="placas_num_placas"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
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
		                                   									<td width="49%">Precio unitario:</td>
		                                   									<td>
		                                   										<input	type="text"
		                                   												class="input"
		                                   												style="text-align:right;"
		                                   												name="placas_precio_unitario"
		                                   												value=""
		                                   												tabindex=""
		                                   												onkeypress=""
		                                   												readonly>
		                                   									</td>
		                                   								</tr>
		                                   							</table>
	                                   							</div>
	                                   						</div>
	                                   						<div class="mitad_columna_derecha">
	                                   							<div class="columna_completa">
	                                   								<table>
		                                   								<tr>
		                                   									<td width="1%">Precio:</td>
		                                   									<td>
		                                   										<input	type="text"
		                                   												class="input"
		                                   												style="text-align:right;"
		                                   												name="placas_coste_total"
		                                   												value=""
		                                   												tabindex=""
		                                   												onkeypress=""
		                                   												readonly>
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
	                                   			<div class="linea">
	                                   				<div class="casilla">
	                                   					<div class="mitad_columna_derecha">
	                                   						<div class="columna_completa">
	                                   							<table>
	                                   								<tr>
	                                   									<td width="1%">Total:</td>
	                                   									<td>
	                                   										<input	type="text"
		                                   											class="input"
		                                   											style="text-align:right;"
		                                   											name="tipo_trabajo_detalle_coste_total"
		                                   											value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
	                                   									</td>
	                                   								</tr>
	                                   							</table>
	                                   						</div>
	                                   					</div>
	                                   				</div>
	                                   			</div>
                                   			</form>
                                    	</div>
<!-- div_procesos_acabado_detalle -->
                                    	<div id="div_procesos_acabado_detalle" style="width:100%; height:100%; background:#fff; float:left; display:none;">
                                    		<form name="resumen_procesos" action="" accept-charset="ISO-8859-1">
                                    			
                                    			
                                    			<div class="titulo">
                                    				<font size="4">COSTOS EXTRAS</font>
                                    			</div>
                                    			<div style="width:80%; height:100px; margin-left:auto; margin-right:auto;">
                                    				<div class="columna_completa">
                                    					<div id="div_tabla_lista_costos_extras_detalle" style="width:100%; height:100%; overflow-x:scroll;">
                                    						<table>
                                    							<tr>
                                    								<th>No.</th>
                                    								<th>Costo Extra</th>
                                    								<th>Responsable</th>
                                    								<th>Precio</th>
                                    								<th>Especificaci&oacute;n</th>
                                    							</tr>
                                    							<tr class="l1">
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
                                    			<br/>
                                    		
                                    		
	                                    		<div class="titulo">
	                                    			<font size="4">DISE&Ntilde;O</font>
	                                    		</div>
	                                    		<div style="width:80%; height:100px; margin-left:auto; margin-right:auto;">
	                                    			<div class="columna_completa">
	                                    				<div id="div_tabla_lista_procesos_disenio" style="width:100%; height:100%; overflow-x:scroll;">
	                                    					<table>
	                                    						<tr>
	                                    							<th>No.</th>
	                                    							<th>Descripci&oacute;n</th>
	                                    							<th>Precio</th>
	                                    							<th>Especificaci&oacute;n</th>
	                                    						</tr>
	                                    						<tr class="l1">
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    						</tr>
	                                    					</table>
	                                    				</div>
	                                    			</div>
	                                    		</div>
	                                    		<br/>
	                                    		
	                                    		
	                                    		<div class="titulo">
	                                    			<font size="4">PREPRENSA</font>
	                                    		</div>
	                                    		<div style="width:80%; height:100px; margin-left:auto; margin-right:auto;">
	                                    			<div class="columna_completa">
	                                    				<div id="div_tabla_lista_procesos_preprensa" style="width:100%; height:100%; overflow-x:scroll;">
	                                    					<table>
	                                    						<tr>
	                                    							<th>No.</th>
	                                    							<th>Descripci&oacute;n</th>
	                                    							<th>Precio</th>
	                                    							<th>Especificaci&oacute;n</th>
	                                    						</tr>
	                                    						<tr class="l1">
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    						</tr>
	                                    					</table>
	                                    				</div>
	                                    			</div>
	                                    		</div>
	                                    		<br/>
	                                    		
	                                    		
	                                    		<div class="titulo">
	                                    			<font size="4">TRANSPORTE</font>
	                                    		</div>
	                                    		<div style="width:80%; height:100px; margin-left:auto; margin-right:auto;">
	                                    			<div class="columna_completa">
	                                    				<div id="div_tabla_lista_procesos_transporte" style="width:100%; height:100%; overflow-x:scroll;">
	                                    					<table>
	                                    						<tr>
	                                    							<th>No.</th>
	                                    							<th>Descripci&oacute;n</th>
	                                    							<th>Precio</th>
	                                    							<th>Especificaci&oacute;n</th>
	                                    						</tr>
	                                    						<tr class="l1">
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    						</tr>
	                                    					</table>
	                                    				</div>
	                                    			</div>
	                                    		</div>
	                                    		<br/>
	                                    		
	                                    		
	                                    		<div class="titulo">
	                                    			<font size="4">ACABADO</font>
	                                    		</div>
	                                    		<div style="width:80%; height:100px; margin-left:auto; margin-right:auto;">
	                                    			<div class="columna_completa">
	                                    				<div id="div_tabla_lista_procesos_acabado" style="width:100%; height:100%; overflow-x:scroll;">
	                                    					<table>
	                                    						<tr>
	                                    							<th>No.</th>
	                                    							<th>Descripci&oacute;n</th>
	                                    							<th>Precio</th>
	                                    							<th>Especificaci&oacute;n</th>
	                                    						</tr>
	                                    						<tr class="l1">
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    							<td>&nbsp;</td>
	                                    						</tr>
	                                    					</table>
	                                    				</div>
	                                    			</div>
	                                    		</div>
	                                    		
	                                    		
	                                    		<div class="div_separador_chico">
	                                            	<img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
	                                            </div>
	                                    		<div class="linea">
	                                   				<div class="casilla">
	                                   					<div class="mitad_columna_derecha">
	                                   						<div class="columna_completa">
	                                   							<table>
	                                   								<tr>
	                                   									<td width="1%">Total:</td>
	                                   									<td>
	                                   										<input	type="text"
	                                   												class="input"
	                                   												style="text-align:right;"
	                                   												name="procesos_coste_total"
	                                   												value=""
		                                   											tabindex=""
		                                   											onkeypress=""
		                                   											readonly>
	                                   									</td>
	                                   								</tr>
	                                   							</table>
	                                   						</div>
	                                   					</div>
	                                   				</div>
	                                   			</div>
	                                   		</form>
	                                    </div>
                                    </div>
                                    
                                </div>
                                <br/>
                                <br/>
                                <div class="linea">
                                    <div class="casilla" style="text-align:right;">
                                        <img id="imgBtnLimpiaFormulariosActivo"  alt="" style="cursor:pointer;" onclick="limpiaCampos();" src="<c:url value="/resources/image/boton_limpiar.jpg"/>">
                                        <span style="cursor:pointer;" onclick="condicionesProduccion()">Impresi&oacute;n</span>
                                        <!-- <span style="cursor:pointer;" onclick="alert('email')">&nbsp;Email&nbsp;</span> -->
                                    </div>
                                </div>
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