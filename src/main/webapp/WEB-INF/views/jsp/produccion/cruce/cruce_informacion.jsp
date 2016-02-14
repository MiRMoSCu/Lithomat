<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/?opc=produccion"											var="urlMenu"/>
<c:url value="/cruce_informacion/grid/lista_por_pagina_por_parametros"	var="urlBuscaListaPorParametros"/>
<c:url value="/cruce_informacion//grid/agrega_cruce_informacion"		var="urlAgregaCruceInformacion"/>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cruce Informaci&oacute;n</title>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/cruce_informacion.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/paginador.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/shadowbox/shadowbox.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/paginador.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/cruce_informacion.js"/>"></script>
        <script type="text/javascript">
            // inicializacion jquery
            $(document).ready(function (){});
            // inicializacion shadowbox
            Shadowbox.init({});
            // iniciacion datepicker
            $(function() {
				$("[name=fecha_impresion]").datepicker({
					dateFormat:'yy-mm-dd',
				});
			});
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
        	var urlMenu						= "${urlMenu}";
        	var urlBuscaListaPorParametros	= "${urlBuscaListaPorParametros}";
        	var urlAgregaCruceInformacion	= "${urlAgregaCruceInformacion}";
        </script>
        <script type="text/javascript">
        	var urlBotonEliminarRegistro = '<c:url value="/resources/image/boton_chico_eliminar.png"/>';
        </script>
        <script type="text/javascript">
	        function regresa_menu() {
	        	location.replace(urlMenu);
	        }
        </script>
	</head>
	<body onload="carga_datos()">
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
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_preprensa.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_transporte.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_acabado.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_offset.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_procesos.png"/>"/>
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
                        	<div id="div_cruce_informacion">
                        		<div class="titulo">
                        			<font size="5">CRUCE INFORMACI&Oacute;N: FECHA - PRENSISTA - M&Aacute;QUINA</font>
                        		</div>
                        		<div class="linea">
                        			<div class="casilla">
                        				<div id="div_paginacion_resultados" style="float:right;"></div>
                        			</div>
                        		</div>
                       			<div id="div_contenedor_tabla_lista_registros">
                       				<div class="columna_completa">
                       					<div id="div_tabla_lista_registros">
                       						<table id="tabla_lista_registros">
                    							<tr>
                    								<th>No.</th>
                    							 	<th>NUT</th>
                    							 	<th>Nom. Ord.Prod.</th>
                    							 	<th>Nom. Trabajo</th>
                    							 	<th>Nom. Impr.</th>
                    							 	<th>No. Pgo</th>
                    							 	<th>H. Req</th>
                    							</tr>
	                    					<c:choose>
	                    						<c:when test="${fn:length(listaGridPliegos) gt 0}">
	                    							<c:forEach var="pliego" items="${listaGridPliegos}" varStatus="i">
		                   								<tr id="pliego:${pliego.idPliego}"
		                   									class='${i.count%2==0?"l2":"l1"}'
		                   									onclick="setCampos('${pliego.idPliego}','${i.count}','${pliego.nut}','${pliego.nombreOrdenProduccion}','${pliego.nombrePartida}','${pliego.descripcionTipoTrabajoDetalle}','${pliego.noPliego}','${pliego.hojasRequeridas}')">
		                   									<td>${i.count}</td>
		                   									<td>${pliego.nut}</td>
		                   									<td>${pliego.nombreOrdenProduccion}</td>
		                   									<td>${pliego.nombrePartida}</td>
		                   									<td>${pliego.descripcionTipoTrabajoDetalle}</td>
		                   									<td>${pliego.noPliego}</td>
		                   									<td>${pliego.hojasRequeridas}</td>
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
		                    							<td>&nbsp;</td>
		                    						</tr>
		                    					</c:otherwise>
	                    					</c:choose>
                       						</table>
                       					</div>
                       				</div>
                       			</div>
                        		<br/>
                        		<div class="linea">
                        			<div class="casilla">
                        				<div id="div_paginador">
                        					<ul id="paginacion">
                        						<li class="activo bold">Primero</li>
                        						<li class="activo bold">Anterior</li>
                        						<li name="arreglo" class="seleccionado">1</li>
                        						<li class="activo bold">Siguiente</li>
                        						<li class="activo bold">Ultimo</li>
                        					</ul>
                        				</div>
                        			</div>
                        		</div>
                        		<div class="div_separador_mediano">
                                	<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                </div>
                                <div class="titulo">
                                	<font size="5">CRITERIOS DE B&Uacute;SQUEDA</font>
                                </div>
                                <div id="div_formulario_busqueda_fecha_prensista_maquina">
                                	<form name="busqueda_registro_grid" action="" method="post" accept-charset="ISO-8859-1">
                                		<input type="hidden" name="numero_pagina" value=""/>
                                		<input type="hidden" name="numero_registros_por_pagina" value=""/>
                                		<div class="linea">
                                			<div class="casilla">
                                				<div class="columna_izquierda">
                               						<div class="columna_completa">
                               							<table>
                                							<tr>
                                								<td width="14%">
                                									<input type="checkbox" name="chkbx_busca_por_nut"/>
                                									<span style="cursor:pointer;" onclick="document.busqueda_registro_grid.chkbx_busca_por_nut.click()">NUT:</span>
                                								</td>
                                								<td>
                                									<input type="text" class="input" name="nut" value="" maxlength="10" onkeydown="revisaNumero(false, this.value, event, 'nueva_busqueda', null)"/>
                                								</td>
                                							</tr>
                                						</table>
                               						</div>
                                				</div>
                                				<div class="columna_derecha">
                                					<div class="mitad_columna_derecha">
                                						<input type="text" class="input" name="BUG" value="Why does forms with single input field submit upon pressing enter key in input?" style="display: none;">
                                					</div>
                                				</div>
                                			</div>
                                		</div>
                                		<br/>
                                		<div class="linea">
                                			<div class="casilla" style="text-align: right;">
                                				<img alt="" style="cursor:pointer;" onclick="limpia_form_busqueda_registro_grid()" 
                                					 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                				<span style="cursor:pointer;" onclick="nueva_busqueda()">
													&nbsp;Buscar&nbsp;
												</span>
                                			</div>
                                		</div>
                                	</form>
                                </div>
                                <div class="div_separador_mediano">
                                	<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                </div>
                                <div id="div_registro_cruce_informacion">
                                	<form name="registro">
                                		<div class="titulo">
		                                	<font size="5">REGISTRO</font>
		                                </div>
		                                <div class="linea">
		                                	<div class="casilla">
		                                		<div class="columna_izquierda">
		                                			<div class="mitad_columna_izquierda">
		                                				<div class="columna_completa">
		                                					<table>
		                                						<tr>
		                                							<td width="1%">Id:</td>
		                                							<td>
		                                								<input	type="text"
		                                										class="input"
		                                										name="contador"
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
		                                							<td width="1%">NUT:</td>
		                                							<td>
		                                								<input	type="text"
		                                										class="input"
		                                										name="nut"
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
		                                						<td width="27%">Ord. Producci&oacute;n:</td>
		                                						<td>
		                                							<input	type="text"
	                                										class="input"
	                                										name="nombre_orden_produccion"
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
		                                		 				<td width="22%">Nom. Trabajo:</td>
		                                		 				<td>
		                                		 					<input	type="text"
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
		                                		 	<div class="columna_completa">
	                                					<table>
	                                						<tr>
	                                							<td width="26%">Nom. Impresi&oacute;n:</td>
	                                							<td>
	                                								<input	type="text"
	                                										class="input"
	                                										name="nombre_tipo_trabajo_detalle"
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
	                                				<div class="mitad_columna_izquierda">
		                                				<div class="columna_completa">
		                                					<table>
		                                						<tr>
		                                							<td width="36%">No. Pliego:</td>
		                                							<td>
			                                							<input	type="text"
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
		                                							<td width="49%">H. Requeridas:</td>
		                                							<td>
		                                								<input	type="text"
		                                										class="input"
		                                										name="hojas_requeridas"
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
	                                </form>
                                </div>
                                <div class="div_separador_chico">
                                	<img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
                                </div>
                                <div id="div_fecha_prensista_maquina">
                                	<div class="titulo">
	                                    <img alt="" src="<c:url value="/resources/image/titulo_detalle.png"/>"/>
	                                </div>
                                	<form name="fecha_prensista_maquina" action="" method="post" accept-charset="ISO-8859-1">
                                		<input type="hidden" name="id_pliego" value=""/>
                                		<div class="linea">
                                			<div class="casilla">
                                				<div class="columna_izquierda">
                                					<div class="mitad_columna_izquierda">
                                						<div class="columna_completa">
                                							<table>
                                								<tr>
                                									<td width="1%">Prensista:</td>
                                									<td>
                                										<select name="id_prensista">
                                											<c:forEach var="prensista" items="${listaPrensista}">
                                												<option value="${prensista.value}">${prensista.text}</option>
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
                                									<td width="48%">Turno Laboral:</td>
                                									<td>
                                										<select name="id_turno_laboral">
                                											<c:forEach var="turnoLaboral" items="${listaTurnoLaboral}">
                                												<option value="${turnoLaboral.value}">${turnoLaboral.text}</option>
                                											</c:forEach>
                                										</select>
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
                               									<td width="1%">M&aacute;quina:</td>
                               									<td>
                               										<select name="id_maquina">
                               											<c:forEach var="maquina" items="${listaMaquina}">
                               												<option value="${maquina.value}">${maquina.text}</option>
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
                                				<div class="columna_izquierda">
                                					<div class="mitad_columna_izquierda">
                                						<div class="columna_completa">
                                							<table>
                                								<tr>
                                									<td width="57%">Fecha impresi&oacute;n:</td>
                                									<td>
                                										<input 	type="text"
                                												class="input"
                                												name="fecha_impresion"
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
                                									<td width="1%">Ayudante:</td>
                                									<td>
                                										<select name="id_prensista_ayudante">
                                											<c:forEach var="prensista" items="${listaPrensista}">
                                												<option value="${prensista.value}">${prensista.text}</option>
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
                                									<td width="37%">H. Buenas:</td>
                                									<td>
                                										<input 	type="text"
                                												class="input"
                                												name="hojas_buenas"
                                												value=""
                                												onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                									</td>
                                								</tr>
                                							</table>
                                						</div>
                                					</div>
                                					<div class="mitad_columna_derecha">
                                						<div class="columna_completa">
                                							<table>
                                								<tr>
                                									<td width="32%">H. Malas:</td>
                                									<td>
                                										<input	type="text"
                                												class="input"
                                												name="hojas_malas"
                                												value=""
                                												onkeydown="revisaNumero(false, this.value, event, null, null)"/>
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
                                									<td width="38%">H. Limpias:</td>
                                									<td>
                                										<input	type="text"
                                												class="input"
                                												name="hojas_limpias"
                                												value=""
                                												onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                									</td>
                                								</tr>
                                							</table>
                                						</div>                                					
                                					</div>
                                					<div class="mitad_columna_derecha">
                                						<div class="columna_completa">
                                							<table>
                                								<tr>
                                									<td width="48%">H. Adicionales</td>
                                									<td>
                                										<input 	type="text"
                                												class="input"
                                												name="hojas_adicionales"
                                												value=""
                                												onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                									</td>
                                								</tr>
                                							</table>
                                						</div>
                                					</div>
                                				</div>
                                			</div>
                                		</div>
                                		<br/>
                                		<div class="linea">
                                			<div class="casilla">
                                				<div class="columna_izquierda">
                                					<div class="mitad_columna_izquierda">
                                						<div class="columna_completa">
                                							<table>
                                								<tr>
                                									<td width="64%">No. Cambio Placas:</td>
                                									<td>
                                										<input	type="text"
                                												class="input"
                                												name="cambio_placas"
                                												value=""
                                												maxlength="3"
                                												onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                									</td>
                                								</tr>
                                							</table>
                                						</div>
                                					</div>
                                					<div class="mitad_columna_derecha">
                                						<div class="columna_completa">
                                							<table>
                                								<tr>
                                									<td width="62%">No. L&aacute;minas Extra:</td>
                                									<td>
                                										<input	type="text"
                                												class="input"
                                												name="laminas_extra"
                                												value=""
                                												maxlength="3"
                                												onkeydown="revisaNumero(false, this.value, event, null, null)"/>
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
                                									<td width="59%">Frente Kilos Tinta:</td>
                                									<td>
                                										<input	type="text"
                                												class="input"
                                												name="frente_kilos_tinta"
                                												value=""
                                												maxlength="3"
                                												onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                									</td>
                                								</tr>
                                							</table>
                                						</div>
                                					</div>
                                					<div class="mitad_columna_derecha">
                                						<div class="columna_completa">
                                							<table>
                                								<tr>
                                									<td width="58%">Vuelta Kilos Tinta:</td>
                                									<td>
                                										<input	type="text"
                                												class="input"
                                												name="vuelta_kilos_tinta"
                                												value=""
                                												maxlength="3"
                                												onkeydown="revisaNumero(false, this.value, event, null, null)"/>
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
                                <div class="linea"></div>
                           		<div class="linea">
                           			<div class="casilla" style="text-align: right;">
                           				<img alt="" style="cursor:pointer;" onclick="limpia_form_fecha_prensista_maquina()"
                                       	 	 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                        
                                        <img alt="" style="cursor:pointer;" onclick="crea_registro_fpm();"
                                        	 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                           			</div>
                           		</div>
                           		<div class="div_separador_chico">
                           			<img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
                           		</div>
                           		<div id="div_contenedor_tabla_fecha_prensista_maquina">
                           			<div class="columna_completa">
                           				<div id="div_tabla_fecha_prensista_maquina">
                           					<table id="tabla_fecha_prensista_maquina">
                           						<tr>
                           							<th>No.</th>
                           							<th>Prensista</th>
                           							<th>T.Laboral</th>
                           							<th>M&aacute;quina</th>
                           							<th>F.Impresi&oacute;n</th>
                           							<th>Ayudante</th>
                           							<th>H.Buenas</th>
                           							<th>H.Malas</th>
                           							<th>H.Adicionales</th>
                           							<th>H.Limpias</th>
                           							<th>No.CambioPlacas</th>
                           							<th>No.L&aacute;minasExtra</th>
                           							<th>FrenteK.Tinta</th>
                           							<th>VueltaK.Tinta</th>
                           							<th>Eliminar</th>
                           						</tr>
                           						<tr id="fpm:null" class="l1">
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
                           							<td>&nbsp;</td>
                           							<td>&nbsp;</td>
                           							<td>&nbsp;</td>
                           						</tr>
                           					</table>
                           				</div>
                           			</div>
                           		</div>
                           		<br/>
                           		<div id="div_envia_informacion">
                           			<form name="envia_json" action="" method="post" accept-charset="ISO-8859-1">
                        				<input type="hidden" name="json" value=""/>
                        				<div class="div_separador_grande">
                        					<img alt="" src="<c:url value="/resources/image/separador_grande.png"/>"/>
                        				</div>
	                        			<div class="titulo">
	                                        <font size="5">¿DESEA ENVIAR CRUCE DE INFORMACI&Oacute;N?</font>
	                                    </div>
	                                    <div id="div_area_boton_enviar" style="text-align: right;">
	                                        <img alt="" style="cursor:pointer;" onclick="envia_cruce_informacion()"
	                                        	 src="<c:url value="/resources/image/boton_enviar.jpg"/>"/>
	                                    </div>
                           			</form>
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