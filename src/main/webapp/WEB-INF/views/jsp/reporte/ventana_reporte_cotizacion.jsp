<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/reporte/busca_condiciones_produccion"	var="urlBuscaCondicionesProduccion"/>
<c:url value="/reporte/existe_nut"						var="urlExisteNut"/>
<c:url value="/reporte/cotizacion"						var="urlExportaReporteCotizacion"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Reporte Cotizaci&oacute;n</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/ventana_reporte_cotizacion.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/ventana_reporte_cotizacion.js"/>"></script>
        <script type="text/javascript">
			// inicializacion jquery
			$(document).ready(function (){});
        </script>
        <script type="text/javascript">
        	var urlBuscaCondicionesProduccion	= '${urlBuscaCondicionesProduccion}';
        	var urlExisteNut					= '${urlExisteNut}';
        	var urlExportaReporteCotizacion 	= '${urlExportaReporteCotizacion}';
        </script>
	</head>
	<body>
		<div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_contenido">
                    	<br/>
                    	<form name="reporte_cotizacion" method="post" target="_blank" accept-charset="ISO-8859-1">
                    		<input type="hidden" name="id_tipo_formato_impresion" value="" />
	                        <div class="titulo">
	                        	<font size=5>REPORTE COTIZACI&Oacute;N</font>
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
	                        								onkeydown="revisaNumero(false, this.value, event, 'enviarFormulario', null)"
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
	                        		<span style="cursor:pointer;" onclick="buscaCondicionesProduccion()">
	                        			<font color="blue">&nbsp;BUSCAR&nbsp;</font>
	                        		</span>
	                        	</div>
	                        </div>
	                        <div class="titulo">
	                        	<font size=5>CONDICIONES PRODUCCI&Oacute;N</font>
	                        </div>
	                        <div style="margin: 0px 0px 5px 0px">
	                        	<textarea id="condiciones_produccion" name="condiciones_produccion" rows="" cols="" maxlength="1000"></textarea>
	                        </div>
	                        <div class="linea">
	                        	<div class="casilla">
	                        		<div class="columna_completa">
	                        			<table>
	                        				<tr>
	                        					<td width="27%">Opci&oacute;n impresi&oacute;n:</td>
	                        					<td>
	                        						<select name="select_tipo_formato_impresion">
	                        							<c:forEach var="c" items="${listaTipoFormatoImpresion}">
	                        								<option value="${c.value}">${c.text}</option>
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