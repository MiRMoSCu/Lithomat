<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/fecha_prensista_maquina/exporta_reporte_concentrado"	var="urlExportaReporte"/>
<c:url value="/reporte/existe_nut"									var="urlExisteNut"/>
<c:url value="/fecha_prensista_maquina/lista"						var="urlListaFechaPrensistaMaquina"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Fecha Prensista M&aacute;quina</title>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/fecha_prensista_maquina.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/master.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/fecha_prensista_maquina.js"/>"></script>
        <script type="text/javascript">
	    	//inicializacion jquery
	        $(document).ready(function (){});
	    	// inicializacion input fecha
	    	$(function() {
				$("[name=fecha_excel_inicio]").datepicker({
					dateFormat:'yy-mm-dd',
				});
			});
            $(function() {
				$("[name=fecha_excel_fin]").datepicker({
					dateFormat:'yy-mm-dd',
				});
			});
	    	$(function() {
				$("[name=fecha_busqueda_inicio]").datepicker({
					dateFormat:'yy-mm-dd',
				});
			});
            $(function() {
				$("[name=fecha_busqueda_fin]").datepicker({
					dateFormat:'yy-mm-dd',
				});
			});
        </script>
        <script type="text/javascript">
        	var urlExportaReporte				= "${urlExportaReporte}";
        	var urlExisteNut 					= "${urlExisteNut}";
        	var urlListaFechaPrensistaMaquina	= "${urlListaFechaPrensistaMaquina}";
        </script>
	</head>
	<body>
		<div id="div_area">
			<div id="div_ancho">
				<div id="div_hoja">
					<div id="div_cuerpo">
						<div id="div_contenido">
							<div id="div_fecha_prensista_maquina">
								<br/>
								<div id="div_reporte_consolidado_excel_fecha_prensista_maquina">
									<form name="busqueda_concentrado_excel" action="" method="post" accept-charset="ISO-8859-1">
										<div class="titulo">
											<font size="5">REPORTE CONCENTRADO FECHA - PRENSISTA - M&Aacute;QUINA</font>
										</div>
										<div class="linea">
											<div class="casilla">
												<div class="columna_izquierda">
													<div class="columna_completa">
														<table>
															<tr>
																<td width="22%">Fecha Inicial:</td>
																<td>
																	<input 	type="text"
																			class="input"
																			name="fecha_excel_inicio"
																			value=""
																			readonly/>
																</td>
																<td width="1%">a:</td>
																<td>
																	<input	type="text"
																			class="input"
																			name="fecha_excel_fin"
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
												<div class="columna_izquierda" style="text-align: right;">
													<span style="cursor:pointer;" onclick="limpiaFechasExcel()">
														<font color="gray">&nbsp;LIMPIAR&nbsp;</font>
													</span>
													<span style="cursor:pointer;" onclick="generaExcel()">
														<font color="blue">&nbsp;ACEPTAR&nbsp;</font>
													</span>
												</div>
											</div>
										</div>
									</form>
								</div>
								<div class="div_separador_mediano" style="clear: both;">
									<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
								</div>
								<div id="div_reporte_visual_fecha_prensista_maquina">
									<form name="busqueda_fecha_prensista_maquina" action="" method="post" accept-charset="ISO-8859-1">
										<div class="titulo">
											<font size="5">RESUMEN FECHA - PRENSISTA - M&Aacute;QUINA POR NUT</font>
										</div>
										<div class="linea">
											<div class="casilla">
												<div class="columna_izquierda">
													<div class="columna_completa">
														<table>
															<tr>
																<td width="15%">
																	<input type="checkbox" name="chkbx_busca_por_nut"/>
																	<span style="cursor: pointer;" onclick="document.busqueda_fecha_prensista_maquina.chkbx_busca_por_nut.click()">NUT:</span>
																</td>
																<td>
																	<input 	type="text"
																			class="input"
																			name="nut"
																			value=""
																			maxlength="10"
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
																<td width="18%">
																	<input type="checkbox" name="chkbx_busca_por_fecha"/>
																	<span style="cursor: pointer;" onclick="document.busqueda_fecha_prensista_maquina.chkbx_busca_por_fecha.click()">Fecha:</span>
																</td>
																<td>
																	<input 	type="text"
																			class="input"
																			name="fecha_busqueda_inicio"
																			value=""
																			readonly/>
																</td>
																<td width="1%">a:</td>
																<td>
																	<input 	type="text"
																			class="input"
																			name="fecha_busqueda_fin"
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
																<td width="22%">
																	<input type="checkbox" name="chkbx_busca_por_prensista"/>
																	<span style="cursor: pointer;" onclick="document.busqueda_fecha_prensista_maquina.chkbx_busca_por_prensista.click()">Prensista:</span>
																</td>
																<td>
																	<select name="id_prensista">
																		<c:forEach items="${listaPrensista}" var="prensista">
																			<option value="${prensista.value}">${prensista.text}</option>
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
																<td width="21%">
																	<input type="checkbox" name="chkbx_busca_por_maquina"/>
																	<span style="cursor: pointer;" onclick="document.busqueda_fecha_prensista_maquina.chkbx_busca_por_maquina.click()">M&aacute;quina:</span>
																</td>
																<td>
																	<select name="id_maquina">
																		<c:forEach items="${listaMaquina}" var="maquina">
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
												<div class="columna_derecha" style="text-align: right;">
													<span style="cursor:pointer;" onclick="limpiaCriteriosBusqueda()">
														<font color="gray">&nbsp;LIMPIAR&nbsp;</font>
													</span>
													<span style="cursor:pointer;" onclick="buscaRegistros()">
														<font color="gray">&nbsp;BUSCAR&nbsp;</font>
													</span>
												</div>
											</div>
										</div>
									</form>
								</div>
								<!-- 
								<div class="div_separador_chico">
									<img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
								</div>
								-->
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
													<th>H.Requeridas</th>
													<th>H.Buenas</th>
													<th>H.Malas</th>
													<th>H.Adicionales</th>
													<th>H.Limpias</th>
													<th>No.CambioPlacas</th>
													<th>No.L&aacute;minasExtra</th>
													<th>FrenteK.TintaCyan</th>
													<th>FrenteK.TintaMagenta</th>
													<th>FrenteK.TintaYellow</th>
													<th>FrenteK.TintaBlack</th>
													<th>VueltaK.TintaCyan</th>
													<th>VueltaK.TintaMagenta</th>
													<th>VueltaK.TintaYellow</th>
													<th>VueltaK.TintaBlack</th>
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
								<div class="linea">
									<div class="casilla" style="text-align: right;">
										<span style="cursor: pointer;" onclick="window.parent.Shadowbox.close()">
											<font color="gray">&nbsp;CANCELAR&nbsp;</font>
										</span>
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