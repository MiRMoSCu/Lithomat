<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/reporte/existe_nut"			var="urlExisteNut"/>
<c:url value="/descuento_general/busca"		var="urlBuscaPrecios"/>
<c:url value="/descuento_general/acepta"	var="urlCreaDescuento"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Descuento</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/seguridad_ventana_descuento.css"/>" type="text/css"></link>
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
        <script type="text/javascript" src="<c:url value="/resources/js/seguridad_ventana_descuento.js"/>"></script>
        <script type="text/javascript">
	     	// inicializacion jquery
			$(document).ready(function (){});
        </script>
        <script type="text/javascript">
        	var urlExisteNut 		= '${urlExisteNut}';
        	var urlBuscaPrecios		= '${urlBuscaPrecios}';
        	var urlCreaDescuento	= '${urlCreaDescuento}';
        </script>
	</head>
	<body>
		<div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_contenido">
                    	<div id="div_descuento">
                    		<br/>
                    		<form name="descuento" method="post">
	                    		<input type="hidden" name="precio_cliente_original" 		value=""/>
	                    		<input type="hidden" name="precio_tipo_comprobante_fiscal" 	value=""/>
		                        <div class="titulo">
		                        	<font size=5>DESCUENTO</font>
		                        </div>
		                        <div class="linea">
		                        	<div class="casilla">
		                        		<div class="columna_completa">
		                        			<table>
		                        				<tr>
		                        					<td width="1%">NUT:</td>
		                        					<td>
		                        						<input	type="text"
		                        								class="input"
		                        								name="nut"
		                        								maxlength="10"
		                        								onkeydown="revisaNumero(false, this.value, event, 'buscarNut', null)"
		                        								value=""/>
		                        					</td>
		                        				</tr>
		                        			</table>
		                        		</div>
		                        	</div>
		                        </div>
		                        <div style="display: none;">
		                        	<input type="text" value="" name="bug"/>
		                        </div>
		                        <div class="linea">
		                        	<div class="casilla" style="text-align:right;">
		                        		<span style="cursor:pointer;" onclick="buscarNut()">
		                        			<font color="gray">&nbsp;BUSCAR&nbsp;</font>
		                        		</span>
		                        	</div>
		                        </div>
		                        <div class="linea">
		                        	<div class="casilla">
		                        		<div class="columna_completa">
		                        			<table>
		                        				<tr>
		                        					<td width="1%">Cliente:</td>
		                        					<td>
		                        						<input 	type="text" 
		                        								class="input"
		                        								name="nombre_moral"
		                        								readonly />
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
		                        						<td width="40%">Tipo Cliente:</td>
		                        						<td>
		                        							<input	type="text" 
		                        									class="input"
		                        									name="tipo_cliente"
		                        									readonly />
		                        						</td>
		                        					</tr>
		                        				</table>
		                        			</div>
		                        		</div>
		                        		<div class="columna_derecha">
		                        			<div class="columna_completa">
		                        				<table>
		                        					<tr>
		                        						<td width="1%">Estatus:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									name="estatus"
		                        									readonly />
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
		                        						<td width="41%">Precio bruto:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									name="precio_bruto"
		                        									readonly />
		                        						</td>
		                        					</tr>
		                        				</table>
		                        				
		                        			</div>
		                        		</div>
		                        		<div class="columna_derecha">
		                        			<div class="columna_completa">
		                        				<table>
		                        					<tr>
		                        						<td width="45%">Precio cliente:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									name="precio_cliente"
		                        									readonly />
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
		                        						<td width="49%">Descuento (%):</td>
		                        						<td>
		                        							<input 	type="text"
		                        									class="input"
		                        									name="porcentaje_descuento"
		                        									readonly />
		                        							
		                        						</td>
		                        					</tr>
		                        				</table>
		                        			</div>
		                        		</div>
		                        		<div class="columna_derecha">
		                        			<div class="columna_completa">
		                        				<table>
		                        					<tr>
		                        						<td width="37%">P. Cte final:</td>
		                        						<td>
		                        							<input 	type="text"
		                        									class="input"
		                        									name="precio_cliente_con_descuento"
		                        									readonly />
		                        							
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
		                        						<td width="1%">T.Comprob:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									name="tipo_comprobante"
		                        									readonly />
		                        						</td>
		                        					</tr>
		                        				</table>
		                        			</div>
		                        		</div>
		                        		<div class="columna_derecha">
		                        			<div class="columna_completa">
		                        				<table>
		                        					<tr>
		                        						<td width="39%">Precio neto:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									name="precio_neto"
		                        									readonly />
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
		                        <div class="linea">
		                        	<div class="casilla">
		                        		<div class="columna_izquierda">
		                        			<div class="columna_completa">
		                        				<table>
		                        					<tr>
		                        						<td width="49%">Descuento (%):</td>
		                        						<td>
		                        							<input 	type="text"
		                        									class="input"
		                        									name="porcentaje_descuento_modificado_porcentaje"
		                        									onkeydown="revisaNumero(false, this.value, event, 'calculaDescuento', null)" 
		                        									title="Numeros enteros unicamente"
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
		                        						<td width="49%">Descuento ($):</td>
		                        						<td>
		                        							<input type="text"
		                        									class="input"
		                        									name="porcentaje_descuento_modificado_pesos"
		                        									readonly />
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
		                        						<td width="37%">P. Cte final:</td>
		                        						<td>
		                        							<input	type="text"
		                        									class="input"
		                        									name="precio_cliente_con_descuento_modificado"
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
		                        						<td width="39%">Precio neto:</td>
		                        						<td>
		                        							<input 	type="text"
		                        									class="input"
		                        									name="precio_neto_modificado"
		                        									readonly />
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
		                        		<span style="cursor:pointer;" onclick="cerrarVentana()">
		                        			<font color="gray">&nbsp;CANCELAR&nbsp;</font>
		                        		</span>
		                        		<span style="cursor:pointer;" onclick="limpiarFormulario()">
		                        			<font color="gray">&nbsp;LIMPIAR&nbsp;</font>
		                        		</span>
		                        		<span style="cursor:pointer;" onclick="enviarFormulario()">
		                        			<font color="blue">&nbsp;ACEPTAR&nbsp;</font>
		                        		</span>
		                        	</div>
		                        </div>
	                        </form>
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
	</body>
</html>