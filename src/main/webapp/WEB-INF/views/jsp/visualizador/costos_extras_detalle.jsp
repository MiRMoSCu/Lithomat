<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:url value="/costos_extras_detalle/busca_unidad_medida" 				var="urlBuscaUnidadMedida"/>
<c:url value="/costos_extras_detalle/agrega_costos_extras_detalle" 		var="urlAlta"/>
<c:url value="/costos_extras_detalle/modifica_costos_extras_detalle" 	var="urlModifica"/>
<c:url value="/costos_extras_detalle/elimina_costos_extras_detalle" 	var="urlElimina"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Costos extras</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/jstree.style.min.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/costos_extras_detalle.css"/>" type="text/css"></link>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jstree.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/costos_extras_detalle.js"/>"></script>
		<script type="text/javascript">
            //inicializacion jquery
            $(document).ready(function (){});
        </script>
		<script type="text/javascript">
			var jsonArbol = '${jsonArbol}';
		
			var urlBuscaUnidadMedida 	= '${urlBuscaUnidadMedida}';
			var urlAlta 				= '${urlAlta}';
			var urlModifica				= '${urlModifica}';
			var urlElimina				= '${urlElimina}';
		</script>
	</head>
	<body onload="carga_datos();">
		<div id="div_area">
			<div id="div_ancho">
				<div id="div_hoja">
					<div id="div_cuerpo">
						<div id="div_contenido">
							<br/>
							<div id="div_costos_extras_detalle">
								<form name="costos_extras_detalle" action="" accept-charset="ISO-8859-1" method="post">
									<input type="hidden" name="nut" 						value="${nut}"/>
									<input type="hidden" name="id_costos_extras_detalle" 	value=""/>
									<input type="hidden" name="id_tipo_trabajo_detalle" 	value=""/>
									<input type="hidden" name="id_responsable_insumo" 		value=""/>
									<input type="hidden" name="id_costos_extras" 			value=""/>
									<div class="titulo">
										<font size="5">COSTOS EXTRAS POR TIPO TRABAJO</font>
									</div>
									<div>
										<div id="div_arbol_tipo_trabajo">
											<div class="columna_completa">
												<div id="arbol_tipo_trabajo" style="height:100%; overflow:auto;"></div>
											</div>
										</div>
										<div id="div_costos_extras_tipo_trabajo">
											<div class="linea">
												<div class="casilla" style="text-align:right;">
													<span id="" style="cursor:pointer; display:inline" onclick="finalizaCostosExtras()">
														<font color="blue">FINALIZAR</font>
													</span>
												</div>
											</div>
											<div style="width:400px; margin-left:auto;">
												<div class="columna_completa">
													<div id="div_tabla_costos_extras_tipo_trabajo">
														<table id="tabla_lista_costos_extras_tipo_trabajo">
															<tr>
																<th>Id.</th>
																<th>Subpartida</th>
																<th>Resp.</th>
																<th>Costo Extra</th>
																<th>Cant.</th>
																<th>Especif.</th>
															</tr>
														<c:choose>
															<c:when test="${fn:length(listaCostosExtrasDetalle) gt 0}">
																<c:forEach var="costosExtrasDetalle" items="${listaCostosExtrasDetalle}" varStatus="i">
																	<tr class='${i.count%2==0?"l2":"l1"}'  
																		onclick="setCampos('${i.count}','${costosExtrasDetalle.idCostosExtrasDetalle}','${costosExtrasDetalle.tipoTrabajoDetalle.descripcion}','${costosExtrasDetalle.responsableInsumo.nombre}','${costosExtrasDetalle.costosExtras.nombre}','${costosExtrasDetalle.cantidad}','${costosExtrasDetalle.especificacion}')">
																		<td>${i.count}</td>
																		<td>${costosExtrasDetalle.tipoTrabajoDetalle.descripcion}</td>
																		<td>${costosExtrasDetalle.responsableInsumo.nombre}</td>
																		<td>${costosExtrasDetalle.costosExtras.nombre}</td>
																		<td>${costosExtrasDetalle.cantidad}</td>
																		<td>${costosExtrasDetalle.especificacion}</td>
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
												<br>
													
												<div class="linea">
													<div class="casilla">
														<div style="width:189px; height:100%; float:left;">
															<div class="columna_completa">
																<table>
																	<tr>
																		<td width="1%">Identificador:</td>
																		<td>
																			<input	type="text"
																					class="input"
																					name="id"
																					value=""
																					readonly/>
																		</td>
																	</tr>
																</table>
															</div>
														</div>
														<div style="width:189px; height:100%; float:right;">
															<div class="columna_completa">
																<table>
																	<tr>
																		<td width="1%">Subpartida:</td>
																		<td>
																			<input	type="text"
																					class="input"
																					name="tipo_trabajo_detalle"
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
														<div style="width:189px; height:100%; float:left;">
															<div class="columna_completa">
																<table>
																	<tr>
																		<td width="44%">Costo Extra:</td>
																		<td>
																			<select name="select_costos_extras" onchange="ajaxUnidadCostoExtra()">
																				<c:forEach var="costosExtras" items="${listaCostosExtras}">
			                                                                        <option value="${costosExtras.value}">${costosExtras.text}</option>
			                                                                    </c:forEach>
																			</select>
																		</td>
																	</tr>
																</table>
															</div>
														</div>
														<div style="width:189px; height:100%; float:right;">
															<div class="columna_completa">
																<table>
																	<tr>
																		<td width="1%">Responsable:</td>
																		<td>
																			<select name="select_responsable_insumo">
																				<c:forEach var="responsableInsumo" items="${listaResponsableInsumo}">
			                                                                        <option value="${responsableInsumo.value}">${responsableInsumo.text}</option>
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
														<div style="width:189px; height:100%; float:left;">
															<div class="columna_completa">
																<table>
																	<tr>
																		<td width="1%">Cantidad:</td>
																		<td>
																			<input 	type="text" 
																					class="input"
																					name="cantidad"
																					value=""
																					tabindex=""
																					onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
																		</td>
																	</tr>
																</table>
															</div>
														</div>
														<div style="width:189px; height:100%; float:right;">
															<div class="columna_completa">
																<table>
																	<tr>
																		<td width="58%">Especificado en:</td>
																		<td>
																			<input	type="text"
																					class="input"
																					name="nombre_unidad_medida"
																					value="${nombre_unidad_medida}"
																					tabindex=""
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
														<div class="columna_completa">
															<table>
																<tr>
																	<td width="1%">Especificaci&oacute;n:</td>
																	<td>
																		<input	type="text"
																				class="input"
																				name="especificacion"
																				value=""
																				tabindex=""/>
																	</td>
																</tr>
															</table>
														</div>
													</div>
												</div>
											</div>
											<div class="linea">
												<div class="casilla" style="text-align:right;">
													<img id="" alt="" style="cursor:pointer;" onclick="limpiaFormCostosExtras()" src="<c:url value="/resources/image/boton_limpiar.jpg"/>">
													<img id="" alt="" style="cursor:pointer;" onclick="eliminaCostosExtras();" src="<c:url value="/resources/image/boton_eliminar.jpg"/>">
													<img id="" alt="" style="cursor:pointer;" onclick="modificaCostosExtras();" src="<c:url value="/resources/image/boton_modificar.jpg"/>">
													<img id="" alt="" style="cursor:pointer;" onclick="creaCostosExtras();" src="<c:url value="/resources/image/boton_agregar.jpg"/>">
												</div>
											</div>
										</div>
									</div>
								</form>
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