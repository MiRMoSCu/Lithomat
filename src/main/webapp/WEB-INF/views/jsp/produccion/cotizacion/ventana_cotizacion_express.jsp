<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 	prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 			prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cotizaci&oacute;n Express</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/ventana_cotizacion_express.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/ventana_cotizacion_express.js"/>"></script>
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
        <script type="text/javascript" src="<c:url value="/resources/js/ventana_cotizacion_express.js"/>"></script>
        <script type="text/javascript">
	     	// inicializacion jquery
			$(document).ready(function (){});
        </script>
	</head>
	<body>
		<div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_contenido">
                    	<br/>
                       	<div id="div_cotizacion_express">
                       		<form name="cotizador" action="" accept-charset="ISO-8859-1">
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
	                        		</div>
	                        	</div>
	                        	<div class="linea">
	                        		<div class="casilla">
	                        			<div class="columna_izquierda">
	                        				<div class="columna_completa">
	                        					<table>
	                        						<tr>
	                        							<td width="1%">Cantidad:</td>
	                        							<td>
	                        								<input	type="text"
	                        										class="input"
	                        										name="cantidad"
	                        										value="1"
	                        										onkeydown="revisaNumero(false, this.value, event, 'buscarNut', null)"/>
	                        							</td>
	                        						</tr>
	                        					</table>
	                        				</div>
	                        			</div>
	                        			<div class="columna_derecha">
	                        				<div class="columna_completa">
	                        					<table>
	                        						<tr>
	                        							<td width="40%">No. Pliegos:</td>
	                        							<td>
	                        								<input	type="text"
	                        										class="input"
	                        										name="numero_pliegos"
	                        										value="2"
	                        										onkeydown="revisaNumero(true, this.value, event, 'buscarNut', null)"/>
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
	                        							<td width="57%">No. Tintas Frente:</td>
	                        							<td>
	                        								<input	type="text"
	                        										class="input"
	                        										name="frente_numero_tintas"
	                        										value="3"
	                        										onkeydown="revisaNumero(false, this.value, event, 'buscarNut', null)"/>
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
	                        								<input	type="text"
	                        										class="input"
	                        										name="vuelta_numero_tintas"
	                        										value="4"
	                        										onkeydown="revisaNumero(false, this.value, event, 'buscarNut', null)"/>
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
	                        										onkeydown="revisaNumero(false, this.value, event, 'buscarNut', null)"/>
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
	                        										onkeydown="revisaNumero(false, this.value, event, 'buscarNut', null)"/>
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
	                        								<select name="frente_id_combinacion_tintas" id="frente_id_oombinacion_tintas">
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
	                        								<select name="vuelta_id_combinacion_tintas" id="vuelta_id_combinacion_tintas">
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
	                        			<div class="columna_derecha">
	                        				<div class="columna_completa">
	                        					<table>
	                        						<tr>
	                        							<td width="78%">¿Vuelta mismas placas?:</td>
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
	                        	<br/>
	                        	<div class="linea">
	                        		<div class="casilla" style="text-align: right;">
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
		                        						<td width="43%">P. Unit. Tinta:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="tinta_precio_unitario"
		                        									value="$ 0.00"
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
		                        									name="tinta_precio_total"
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
		                        						<td width="57%">P. Unit. Tinta Esp:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="tinta_especial_precio_unitario"
		                        									value="$ 0.00"
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
		                        									name="tinta_especial_precio_total"
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
		                        						<td width="48%">P. Unit. Barniz:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="barniz_precio_unitario"
		                        									value="$ 0.00"
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
		                        									name="barniz_precio_total"
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
		                        						<td width="50%">P. Unit. Placas:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									style="text-align: right;"
		                        									name="placas_precio_unitario"
		                        									value="$ 0.00"
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
		                        									name="placas_precio_total"
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
		                        									name="coste_total"
		                        									value="$ 0.00"
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