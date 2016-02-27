<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="en_US" scope="session" />
<c:url value="/?opc=catalogos"	               						var="urlMenu"/>
<c:url value="/tabulador_precios/catalogo/lista_por_pagina_por_parametros" 	var="urlBuscaListaPorParametros"/>
<c:url value="/tabulador_precios/catalogo/alta" 					var="urlAlta"/>
<c:url value="/tabulador_precios/catalogo/modifica" 				var="urlModifica"/>
<c:url value="/tabulador_precios/catalogo/elimina" 					var="urlElimina"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Tabulador de precios</title>
        <style type="text/css" media="screen">
        
            table#tabla_tabulador_precios {
                overflow-y:scroll;
            }
            
            table#tabla_tabulador_precios tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_tabulador_precios {
                width: 865px;
                margin-left: auto;
                margin-right: auto;
                background: transparent; /*green*/
                display: block;                    
            }
            
            #div_contenedor_tabla {
                width: 100%;
                height: 240px;
            }
            
            #div_tabla_tabulador_precios {
                width: 100%;
                height: 100%;
                overflow-x: scroll;
            }
        
        </style>
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/catalogo_tabulador_precios.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/paginador.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/paginador.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/tabulador_precios.js"/>"></script>
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
        	var urlBuscaListaPorParametros 	= "${urlBuscaListaPorParametros}";
            var urlAlta     				= '${urlAlta}';
            var urlModifica 				= '${urlModifica}';
            var urlElimina  				= '${urlElimina}';
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
                            <img alt="" src="<c:url value="/resources/image/encabezado_catalogo.png"/>"/>
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                            <div id="div_contenido_menu">
                                <div id="div_cerrar_sesion">
                                    <span style="cursor:pointer;" onclick="regresa_menu();">
	                                    <img alt="" src="<c:url value="/resources/image/boton_regresar_menu.jpg"/>"/>
	                                </span>
                                </div>
                            </div>
                        </div>
                        <div id="div_contenido">
                            
							<div id="div_tabulador_precios">
							    <div class="titulo">
							        <img alt="" src="<c:url value="/resources/image/titulo_tabulador_precios.png"/>"/>
							    </div>
							    <div class="linea">
							    	<div class="casilla">
							    		<div id="div_paginacion_resultados" style="float: right;">0 registros encontrados. Mostrando del 0 al 0.</div>
							    	</div>
							    </div>
							    <div id="div_contenedor_tabla">
							        <div class="columna_completa">
							            <div id="div_tabla_tabulador_precios">
							                <table id="tabla_tabulador_precios">
							                    <tr>
							                        <th>Id.</th>
							                        <th>M&aacute;quina</th>
							                        <th>Nombre insumo</th>
							                        <th>Descripci&oacute;n</th>
							                        <th>Inicio</th>
							                        <th>Fin</th>
							                        <th>Complejidad</th>
							                        <th>Precio</th>
							                        <th>Unidad</th>
							                    </tr>
							                <c:forEach var="tabuladorPrecios" items="${listaTabuladorPrecios}" varStatus="i">
							                    <tr class='${i.count%2==0?"l2":"l1"}'
							                        onclick="setCampos('${tabuladorPrecios.idTabuladorPrecios}','${tabuladorPrecios.maquina}','${tabuladorPrecios.nombreInsumo}','${tabuladorPrecios.descripcion}','${tabuladorPrecios.inicioTabulador}','${tabuladorPrecios.finTabulador}','${tabuladorPrecios.tipoComplejidad}','${tabuladorPrecios.precio}','${tabuladorPrecios.tipoPrecio}');">
							                        <td>${tabuladorPrecios.idTabuladorPrecios}</td>
							                        <td>${tabuladorPrecios.maquina}</td>
							                        <td>${tabuladorPrecios.nombreInsumo}</td>
							                        <td>${tabuladorPrecios.descripcion}</td>
							                        <td><fmt:formatNumber pattern="#,###" value="${tabuladorPrecios.inicioTabulador}"/></td>
							                        <td><fmt:formatNumber pattern="#,###" value="${tabuladorPrecios.finTabulador}"/></td>
							                        <td>${tabuladorPrecios.tipoComplejidad}</td>
							                        <td><fmt:formatNumber pattern="#,##0.00" value="${tabuladorPrecios.precio}"/></td>
							                        <td>${tabuladorPrecios.tipoPrecio}</td>
							                    </tr>
							                </c:forEach>
							                </table>
							            </div>
							        </div>
							    </div>
							    <br/>
							    <div class="linea">
							    	<div class="casilla">
							    		<div id="div_paginador"></div>
							    	</div>
							    </div>
							    <div class="div_separador_mediano">
							    	<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
							    </div>
							    <div class="titulo">
                                    <font size="5">CRITERIOS DE B&Uacute;SQUEDA</font>
                                </div>
							    <div id="div_criterios_busqueda_tabulador_precios">
							    	<form name="busqueda_tabulador_precios" action="" method="post" accept-charset="ISO-8859-1">
							    		<!-- capos para el uso del paginador -->
							    		<input type="hidden" name="numero_pagina" value=""/>
							    		<input type="hidden" name="numero_registros_por_pagina" value=""/>
							    		<div class="linea">
							    			<div class="casilla">
							    				<div class="columna_izquierda">
							    					<div class="columna_completa">
							    						<table>
							    							<tr>
							    								<td width="20%">
							    									<input type="checkbox" name="chkbx_busca_por_maquina"/>
							    									<span style="cursor: pointer;" onclick="document.busqueda_tabulador_precios.chkbx_busca_por_maquina.click()">M&aacute;quina:</span>
							    								</td>
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
							    				<div class="columna_derecha">
							    					<div class="mitad_columna_izquierda">
							    						<div class="columna_completa">
							    							<table>
							    								<tr>
							    									<td width="55%">
							    										<input type="checkbox" name="chkbx_busca_por_complejidad"/>
							    										<span style="cursor: pointer;" onclick="document.busqueda_tabulador_precios.chkbx_busca_por_complejidad.click()">Complejidad:</span>
							    									</td>
							    									<td>
							    										<select name="id_tipo_complejidad">
							    											<c:forEach var="complejidad" items="${listaTipoComplejidad}">
										                                        <option value="${complejidad.value}">${complejidad.text}</option>
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
							    		<br/>
							    		<div class="linea">
							    			<div class="casilla" style="text-align: right;">
							    				<img alt="" style="cursor: pointer;" onclick="limpia_form_criterios_busqueda()" 
	                                				 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
												<span style="cursor:pointer;" onclick="nueva_busqueda()">&nbsp;Buscar&nbsp;</span>
							    			</div>
							    		</div>
							    		<div class="div_separador_mediano">
		                                	<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
		                                </div>
							    	</form>
							    </div>
							    <div id="div_detalle_tabulador_precios">
							    	<form name="tabulador_precios" action="" method="post" accept-charset="ISO-8859-1">
									    <div class="titulo">
									        <img alt="" src="<c:url value="/resources/image/titulo_detalle.png"/>"/>
									    </div>
									    <div class="linea">
									        <div class="casilla">
									            <div class="columna_izquierda">
									                <div class="mitad_columna_izquierda">
									                    <table>
									                        <tr>
									                            <td width="40%">Identificador:</td>
									                            <td>
									                                <input type="text" class="input"
									                                       name="id_tabulador_precios" value="" 
									                                       readonly="readonly"/>
									                            </td>
									                        </tr>
									                    </table>
									                </div>
									                <div class="mitad_columna_derecha">
									                    <table>
									                        <tr>
									                            <td width="1%">M&aacute;quina:</td>
									                            <td>
									                                <select name="id_maquina" onchange="">
									                                    <c:forEach var="maquina" items="${listaMaquina}">
									                                        <option value="${maquina.value}">${maquina.text}</option>
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
									                            <td width="26%">Nombre insumo:</td>
									                            <td>
									                                <input type="text" class="input" name="nombre_insumo" value=""/>
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
									                            <td width="1%">Descripci&oacute;n:</td>
									                            <td>
									                                <input type="text" class="input" name="descripcion" value=""/>
									                            </td>
									                        </tr>
									                    </table>
									                </div>
									            </div>
									            <div class="columna_derecha">
									                <div class="mitad_columna_izquierda">
									                    <table>
									                        <tr>
									                            <td width="1%">Inicio:</td>
									                            <td>
									                                <input type="text" class="input" name="inicio_tabulador" value=""
									                                onkeydown="revisaNumero(false, this.value, event, null, null)"/>
									                            </td>
									                        </tr>
									                    </table>
									                </div>
									                <div class="mitad_columna_derecha">
									                    <table>
									                        <tr>
									                            <td width="1%">Fin:</td>
									                            <td>
									                                <input type="text" class="input" name="fin_tabulador" value=""
									                                onkeydown="revisaNumero(false, this.value, event, null, null)"/>
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
									                    <table>
									                        <tr>
									                            <td width="1%">Complejidad:</td>
									                            <td>
									                                <select name="id_tipo_complejidad" onchange="">
									                                    <c:forEach var="complejidad" items="${listaTipoComplejidad}">
									                                        <option value="${complejidad.value}">${complejidad.text}</option>
									                                    </c:forEach>
									                                </select>
									                            </td>
									                        </tr>
									                    </table>
									                </div>
									                <div class="mitad_columna_derecha">
									                    <table>
									                        <tr>
									                            <td width="1%">Precio:</td>
									                            <td>
									                                <input type="text" class="input" name="precio" value=""
									                                       onkeydown="revisaNumero(true, this.value, event, null, null)"/>
									                            </td>
									                        </tr>
									                    </table>
									                </div>
									            </div>
									        	<div class="columna_derecha">
									        		<div class="mitad_columna_izquierda">
									        			<table>
									        				<tr>
									        					<td width="1%">Unidad:</td>
									                            <td>
									                                <select name="id_tipo_precio" onchange="">
									                                    <c:forEach var="precio" items="${listaTipoPrecio}">
									                                        <option value="${precio.value}">${precio.text}</option>
									                                    </c:forEach>
									                                </select>
									                            </td>
									        				</tr>
									        			</table>
									        		</div>
									        	</div>
									        </div>
									    </div>
									    <div class="linea"></div>
									    <div class="linea">
									        <div class="casilla" style="text-align:right;">
									            <img alt="" style="cursor:pointer;" onclick="limpia();"
									            	 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
									             
									            <img alt="" style="cursor:pointer;" onclick="elimina();"
									            	 src="<c:url value="/resources/image/boton_eliminar.jpg"/>"/>
									             
									            <img alt="" style="cursor:pointer;" onclick="modifica();"
									            	 src="<c:url value="/resources/image/boton_modificar.jpg"/>"/>
									             
									            <img alt="" style="cursor:pointer;" onclick="crear();"
									            	 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
									        </div>
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
        <div id="notificacion_tipo_growl">
            <span id="cerrar_notificacion_growl" style="cursor:pointer;">CLOSE
                <br></br>Aviso.</span>
        </div>
    </body>
</html>