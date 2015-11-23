<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/reporte/cola_impresion"	var="urlExportaReporteColaImpresion"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cola Impresi&oacute;n</title>
		<!-- DATEPICKER -->
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
		<!-- PERSONALES -->
		<link rel="stylesheet" href="<c:url value="/resources/css/ventana_cola_impresion.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/ventana_cola_impresion.js"/>"></script>
        <script type="text/javascript">
			// inicializacion jquery
			$(document).ready(function (){});
			// inicializacion datepicker
			$(function() {
				$("#datepicker").datepicker({
					dateFormat:'dd/mm/yy',
				});
			});
        </script>
        <script type="text/javascript">
        	var urlExportaReporteColaImpresion = '${urlExportaReporteColaImpresion}';
        </script>
	</head>
	<body>
		<div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_contenido">
                    	<br/>
                    	<form name="reporte_cola_impresion" method="post">
                    		<input type="hidden" name="id_estatus_orden" 	value="" />
	                        <div class="titulo">
	                        	<font size=5>REPORTE COLA IMPRESI&Oacute;N</font>
	                        </div>
	                        <div class="linea">
	                        	<div class="casilla">
	                        		<div class="columna_completa">
	                        			<table>
	                        				<tr>
	                        					<td width="1%">Estatus:</td>
	                        					<td>
	                        						<select name="select_estatus_orden">
	                        							<c:forEach var="eo" items="${listaEstatusOrden}">
	                        								<option value="${eo.value}">${eo.text}</option>
	                        							</c:forEach>
	                        						</select>
	                        					</td>
	                        				</tr>
	                        			</table>
	                        		</div>
	                        	</div>
	                        </div>
	                        <!-- 
	                        <div class="linea">
	                        	<div class="casilla">
	                        		<div class="columna_completa">
	                        			<table>
	                        				<tr>
	                        					<td width="1%">Fecha:</td>
	                        					<td>
	                        						<input 	type="text" 
	                        								class="input"
	                        								name="fecha_impresion"
	                        								id="datepicker">
	                        					</td>
	                        				</tr>
	                        			</table>
	                        		</div>
	                        	</div>
	                        </div>
	                        -->
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