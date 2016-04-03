<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn"%>
<c:url value="/tipo_placa/busca"            				var="urlBuscaTipoPlaca"/>
<c:url value="/cotizacion_express/calcula"        			var="urlCalculaCotizacion"/>
<c:url value="/cotizacion_express/reporte_excel"        	var="urlReporteExcel"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cotizaci&oacute;n Express</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/cotizacion_ventana_cotizacion_express.css"/>" type="text/css"></link>
        <style type="text/css">
        	.columna_izquierda {
				width: 211px;
				height: 100%;
				float: left;
			}
			
			.columna_derecha {
				width: 211px;
				height: 100%;
				float: right;
			}
        </style>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/cotizacion_ventana_cotizacion_express.js"/>"></script>
        <script type="text/javascript">
	     	// inicializacion jquery
			$(document).ready(function () {
				var radioBotonAnterior = $("input[type='radio'][name='id_tipo_trabajo']:checked").val();
				$(":radio[name='id_tipo_trabajo']").click(function(event) {
					var radioBotonActual = event.currentTarget.value;
					if( radioBotonActual != radioBotonAnterior ) {
						if ($("input[type=radio][name='id_tipo_trabajo']:checked").val() == "1") {
							document.getElementById("div_tipo_trabajo_flyer").style.display = "inline";
							document.getElementById("div_tipo_trabajo_revista").style.display = "none";
							document.getElementById("div_tipo_trabajo_otro").style.display = "none";
						} else if ($("input[type=radio][name='id_tipo_trabajo']:checked").val() == "2") {
							document.getElementById("div_tipo_trabajo_flyer").style.display = "none";
							document.getElementById("div_tipo_trabajo_revista").style.display = "inline";
							document.getElementById("div_tipo_trabajo_otro").style.display = "none";
						} else if ($("input[type=radio][name='id_tipo_trabajo']:checked").val() == "3") {
							document.getElementById("div_tipo_trabajo_flyer").style.display = "none";
							document.getElementById("div_tipo_trabajo_revista").style.display = "none";
							document.getElementById("div_tipo_trabajo_otro").style.display = "inline";
						}
		        		radioBotonAnterior = $("input[type='radio'][name='id_tipo_trabajo']:checked").val();
		        		// limpia campos descuento por abulador
		        		document.cotizador_express.aplica_precio_tabulador.checked  = false;
		        		document.cotizador_express.precio_tabulador.value 			= "0";
					}
	        	});
			});
        </script>
        <script type="text/javascript">
        	var urlBuscaTipoPlaca		= "${urlBuscaTipoPlaca}";
        	var urlCalculaCotizacion 	= "${urlCalculaCotizacion}";
        	var urlReporteExcel			= "${urlReporteExcel}";
        </script>
	</head>
	<body onload="buscaTipoPlaca(document.cotizador_express.id_maquina)">
		<div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_contenido">
                    	<br/>
                       	<div id="div_cotizacion_express">
                       		<form name="cotizador_express" action="" accept-charset="ISO-8859-1">
                       			<div class="titulo">
	                        		<font size="5">COTIZACI&Oacute;N EXPRESS: IMPRESI&Oacute;N</font>
	                        	</div>
	                        	<div class="linea">
	                        		<div class="casilla">
	                        			<div class="columna_izquierda">
	                        				<div class="columna_completa">
	                        					<table>
		                        					<tr>
		                        						<td width="1%">Cliente:</td>
		                        						<td>
		                        							<select name="id_tipo_cliente" id="id_tipo_cliente">
		                        								<c:forEach var="tc" items="${listaTipoCliente}">
		                        									<option value="${tc.value}">${tc.text}</option>
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
	                        							<td width="1%">Cantidad:</td>
	                        							<td>
	                        								<input	type="text"
	                        										class="input"
	                        										name="cantidad"
	                        										value=""
	                        										onkeydown="revisaNumero(false, this.value, event, null, null)"
	                        										onfocus="this.select()"/>
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
	                        						<td width="33%">
	                        							<div style=" width: 78%; margin-left: auto; margin-right: auto;">
	                        								<table>
		                        								<tr>
		                        									<td width="1%">
		                        										<input type="radio" name="id_tipo_trabajo" value="1" checked/>
		                        									</td>
		                        									<td>
		                        										<span style="cursor: pointer;" onclick="document.getElementsByName('id_tipo_trabajo')[0].click()">Flyer/P&oacute;ster</span>
		                        									</td>
		                        								</tr>
		                        							</table>
	                        							</div>
	                        						</td>
	                        						<td width="33%">
	                        							<div style="width: 80%; margin-left: auto; margin-right: auto;">
	                        								<table>
		                        								<tr>
		                        									<td width="1%">
		                        										<input type="radio" name="id_tipo_trabajo" value="2"/>
		                        									</td>
		                        									<td>
		                        										<span style="cursor: pointer;" onclick="document.getElementsByName('id_tipo_trabajo')[1].click()">Revista/Libro</span>
		                        									</td>
		                        								</tr>
		                        							</table>
	                        							</div>
	                        						</td>
	                        						<td width="33%">
	                        							<div style="width: 45%; margin-left: auto; margin-right: auto;">
	                        								<table>
		                        								<tr>
		                        									<td width="1%">
		                        										<input type="radio" name="id_tipo_trabajo" value="3"/>
		                        									</td>
		                        									<td>
		                        										<span style="cursor: pointer;" onclick="document.getElementsByName('id_tipo_trabajo')[2].click()">Otro</span>
		                        									</td>
		                        								</tr>
		                        							</table>
	                        							</div>
	                        						</td>
	                        					</tr>
	                        				</table>
	                        			</div>
	                        		</div>
	                        	</div>
	                        	<div id="div_tipo_trabajo_flyer" style="display: inline;">
	                        		<div class="linea">
			                        	<div class="casilla">
			                        		<div class="columna_izquierda">
			                        			<div class="columna_completa">
			                        				<table>
			                        					<tr>
			                        						<td width="1%">Repeticiones:</td>
			                        						<td>
			                        							<input	type="text"
			                        									class="input"
			                        									name="repeticiones_x_pliego"
			                        									value="0"
			                        									onfocus="this.select()"
			                        									onkeydown="revisaNumero(false, this.value, event, null, null)"/>
			                        						</td>
			                        					</tr>
			                        				</table>
			                        			</div>
			                        		</div>
			                        		<div class="columna_derecha">
			                        			<div class="columna_completa"></div>
			                        		</div>
			                        	</div>
			                        </div>
	                        	</div>
	                        	<div id="div_tipo_trabajo_revista" style="display: none;">
	                        		<div class="linea">
			                        	<div class="casilla">
			                        		<div class="columna_izquierda">
			                        			<div class="columna_completa">
			                        				<table>
			                        					<tr>
			                        						<td width="55%">N&uacute;mero P&aacute;ginas:</td>
			                        						<td>
			                        							<input 	type="text"
			                        									class="input"
			                        									name="numero_paginas_publicacion"
			                        									value="0"
			                        									onfocus="this.select()"
			                        									onkeydown="revisaNumero(false, this.value, event, null, null)"/>
			                        						</td>
			                        					</tr>
			                        				</table>
			                        			</div>
			                        		</div>
			                        		<div class="columna_derecha">
			                        			<div class="columna_completa">
			                        				<table>
			                        					<tr>
			                        						<td width="1%">Tama&ntilde;o:</td>
			                        						<td>
			                        							<select name="id_tamanio_publicacion" id="id_tamanio_publicacion">
			                        								<c:forEach var="ltp" items="${listaTamanioPublicacion}">
			                        									<option value="${ltp.value}">${ltp.text}</option>
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
	                        	<div id="div_tipo_trabajo_otro" style="display: none;">
	                        		<div class="linea">
		                        		<div class="casilla">
		                        			<div class="columna_izquierda">
		                        				<div class="columna_completa">
		                        					<table>
		                        						<tr>
		                        							<td width="40%">No. Pliegos:</td>
		                        							<td>
		                        								<input	type="text"
		                        										class="input"
		                        										name="numero_pliegos"
		                        										value="0"
		                        										onfocus="this.select()"
		                        										onkeydown="revisaNumero(true, this.value, event, null, null)"/>
		                        							</td>
		                        						</tr>
	                        						</table>
		                        				</div>
		                        			</div>
		                        			<div class="columna_derecha">
			                        			<div class="columna_completa"></div>
			                        		</div>
		                        		</div>
		                        	</div>
	                        	</div>
	                        	<div class="linea">
	                        		<div class="casilla">
	                        			<div class="columna_completa">
	                        				<table>
	                        					<tr>
	                        						<td width="1%">
	                        							<input type="checkbox" name="incluye_costo_papel" checked/>
	                        						</td>
	                        						<td width="1%">
	                        							<span style="cursor: pointer;" onclick="document.cotizador_express.incluye_costo_papel.click()">Papel:</span>
	                        						</td>
	                        						<td>
	                        							<select name="id_tipo_papel_extendido" id="id_tipo_papel_extendido">
	                        								<c:forEach var="ltpe" items="${listaTipoPapelExtendido}">
	                        									<option value="${ltpe.value}">${ltpe.text}</option>
	                        								</c:forEach>
	                        							</select>
	                        						</td>
	                        						<!-- 
	                        						<td>
	                        							<input	type="text"
	                        									class="input"
	                        									name="descripcion_papel"
	                        									value=""
	                        									readonly/>
	                        						</td>
	                        						<td>
	                        							<img id="imgBtnBuscaPapelExtendido" alt="" style="cursor: pointer;" onclick="alert('hola papel')" src="<c:url value="/resources/image/lupa.png"/>"/>
	                        						</td>
	                        						-->
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
	                        							<td width="57%">No. Tintas Frente:</td>
	                        							<td>
	                        								<select name="frente_id_combinacion_tintas" id="frente_id_combinacion_tintas">
	                        									<c:forEach var="ct" items="${listaCombinacionTintas}">
	                        										<option value="${ct.value}">${ct.text}</option>
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
	                        							<td width="57%">No. Tintas Vuelta:</td>
	                        							<td>
	                        								<select name="vuelta_id_combinacion_tintas" id="vuelta_id_combinacion_tintas">
	                        									<c:forEach var="ct" items="${listaCombinacionTintas}">
	                        										<option value="${ct.value}">${ct.text}</option>
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
	                        				<div class="columna_completa">
	                        					<table>
	                        						<tr>
	                        							<td width="67%">No. Tint. Esp. Frente:</td>
	                        							<td>
	                        								<input	type="text"
	                        										class="input"
	                        										name="frente_numero_tinta_especial"
	                        										value="0"
	                        										onfocus="this.select()"
	                        										onkeydown="revisaNumero(false, this.value, event, null, null)"/>
	                        							</td>
	                        						</tr>
	                        					</table>
	                        				</div>
	                        			</div>
	                        			<div class="columna_derecha">
	                        				<div class="columna_completa">
	                        					<table>
	                        						<tr>
	                        							<td width="67%">No. Tint. Esp. Vuelta:</td>
	                        							<td>
	                        								<input	type="text"
	                        										class="input"
	                        										name="vuelta_numero_tinta_especial"
	                        										value="0"
	                        										onfocus="this.select()"
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
	                        				<div class="columna_completa">
	                        					<table>
	                        						<tr>
	                        							<td width="45%">Barniz Frente:</td>
	                        							<td>
	                        								<select name="frente_id_tipo_barniz" id="frente_id_tipo_barniz">
	                        									<c:forEach var="ct" items="${listaTipoBarniz}">
	                        										<option value="${ct.value}">${ct.text}</option>
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
	                        							<td width="45%">Barniz Vuelta:</td>
	                        							<td>
	                        								<select name="vuelta_id_tipo_barniz" id="vuelta_id_tipo_barniz">
	                        									<c:forEach var="ct" items="${listaTipoBarniz}">
	                        										<option value="${ct.value}">${ct.text}</option>
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
	                        				<div class="columna_completa">
	                        					<table>
	                        						<tr>
	                        							<td width="1%">M&aacute;quina:</td>
	                        							<td>
	                        								<select name="id_maquina" id="id_maquina" onchange="buscaTipoPlaca(this)">
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
	                        							<td width="1%">
	                        								<input type="checkbox" name="incluye_costo_placa" checked/>
	                        							</td>
	                        							<td width="1%">
	                        								<span style="cursor: pointer;" onclick="document.cotizador_express.incluye_costo_placa.click()">Placa:</span>
	                        							</td>
	                        							<td>
	                        								<select name="id_tipo_placa" id="id_tipo_placa"></select>
	                        							</td>
	                        						</tr>
	                        					</table>
	                        				</div>
	                        			</div>
	                        		</div>
	                        	</div>
	                        	<div class="linea">
		                        	<div class="casilla">
		                        		<div class="columna_derecha">
		                        			<div class="columna_completa">
		                        				<table>
	                        						<tr>
	                        							<td width="78%">
	                        								<span style="cursor:pointer;" onclick="document.cotizador_express.vuelta_mismas_placas.click()">¿Vuelta mismas placas?:</span>
	                        							</td>
	                        							<td>
	                        								<input	type="checkbox"
	                        										name="vuelta_mismas_placas"/>
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
			                        					<td width="1%">Tabulador:</td>
		                        						<td>
		                        							<select 	name="select_precio_tabulador" 
		                        										id="select_precio_tabulador"
		                        										onchange="document.cotizador_express.precio_tabulador.value = this.value"></select>
		                        						</td>
			                        				</tr>
			                        			</table>
		                        			</div>
		                        		</div>
		                        		<div class="columna_derecha">
		                        			<div class="columna_completa">
		                        				<table>
		                        					<tr>
		                        						<td width="1%">
		                        							<input 	type="checkbox"
		                        									name="aplica_precio_tabulador"/>
		                        						</td>
		                        						<td width="63%">
		                        							<span style="cursor: pointer;" onclick="document.cotizador_express.aplica_precio_tabulador.click()">Aplica Precio Millar:</span>
		                        						</td>
			                        					<td>
			                        						<input	type="text"
		                        									class="input"
		                        									name="precio_tabulador"
		                        									value="0"
		                        									maxlength="3"
		                        									onkeydown="revisaNumero(false, this.value, event, null, null)"
		                        									onfocus="this.select()"/>
			                        					</td>
		                        					</tr>
		                        				</table>
		                        			</div>
		                        		</div>
		                        	</div>
		                        </div>
		                        <div class="linea">
		                        	<div class="casilla">
		                        		<div class="columna_derecha">
		                        			<div class="columna_completa">
		                        				<table>
		                        					<tr>
		                        						<td width="43%">Costos Extra:</td>
		                        						<td>
		                        							<input 	type="text"
			                        								class="input"
			                        								name="costos_extra"
			                        								value="0"
			                        								onfocus="this.select()"
			                        								onkeydown="revisaNumero(true, this.value, event, null, null)"/>
		                        						</td>
		                        					</tr>
		                        				</table>
		                        			</div>
		                        		</div>
		                        	</div>
		                        </div>
	                        	<br/>
	                        	<div>
	                        		<div style="text-align: right;">
	                        			<span style="cursor: pointer;" onclick="cierraVentana()">
	                        				<font color="gray">&nbsp;CANCELAR&nbsp;</font>
	                        			</span>
	                        			<span style="cursor: pointer;" onclick="limpiaForm()">
	                        				<font color="gray">&nbsp;LIMPIAR&nbsp;</font>
	                        			</span>
	                        			<span style="cursor: pointer;" onclick="buscaCotizacionExpress()">
	                        				<font color="blue">&nbsp;ACEPTAR&nbsp;</font>
	                        			</span>
	                        		</div>
	                        	</div>
	                        	<div class="div_separador_chico">
		                        	<img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
		                        </div>
		                        
		                        <div class="linea">
		                        	<div class="casilla">
		                        		<div class="columna_izquierda">
		                        			<div class="columna_completa">
		                        				<table>
		                        					<tr>
		                        						<td width="1%">Papel:</td>
		                        						<td>
		                        							<input 	type="text"
		                        									class="input"
		                        									name="papel_descripcion"
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
		                        						<td width="39%">Total Papel:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="papel_coste_total"
		                        									value="$ 0.00"
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
		                        						<td width="1%">Tinta:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									name="tinta_descripcion"
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
	                        							<td width="37%">Total Tinta:</td>
	                        							<td>
	                        								<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="tinta_coste_total"
		                        									value="$ 0.00"
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
		                        						<td width="1%">TintaEsp:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									name="tinta_especial_descripcion"
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
	                        							<td width="50%">Total Tinta Esp:</td>
	                        							<td>
	                        								<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="tinta_especial_coste_total"
		                        									value="$ 0.00"
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
		                        						<td width="1%">Barniz:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									name="barniz_descripcion"
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
	                        							<td width="41%">Total Barniz:</td>
	                        							<td>
	                        								<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="barniz_coste_total"
		                        									value="$ 0.00"
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
		                        						<td width="1%">Placas:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									name="placas_descripcion"
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
	                        							<td width="42%">Total Placas:</td>
	                        							<td>
	                        								<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="placas_coste_total"
		                        									value="$ 0.00"
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
	                        			<div class="columna_derecha">
	                        				<div class="columna_completa">
	                        					<table>
	                        						<tr>
	                        							<td width="61%">Total Costos Extra:</td>
	                        							<td>
	                        								<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="costos_extra_coste_total"
		                        									value="$ 0.00"
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
	                        			<div class="columna_derecha">
	                        				<div class="columna_completa">
	                        					<table>
	                        						<tr>
	                        							<td width="1%">TOTAL:</td>
	                        							<td>
	                        								<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="cotizacion_coste_total"
		                        									value="$ 0.00"
		                        									readonly/>
	                        							</td>
	                        						</tr>
	                        					</table>
	                        				</div>
	                        			</div>
	                        		</div>
	                        	</div>
	                        	<br/>
	                        	<div>
	                        		<div style="text-align: right;">
	                        			<span style="cursor: pointer;" onclick="impresionCotizacionExpress()">
	                        				<font color="gray">&nbsp;IMPRIMIR&nbsp;</font>
	                        			</span>
	                        		</div>
	                        	</div>
                       		</form>
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
	</body>
</html>