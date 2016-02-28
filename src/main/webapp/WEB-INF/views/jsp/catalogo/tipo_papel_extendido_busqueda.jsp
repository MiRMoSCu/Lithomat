<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:url value="/tipo_papel_extendido/ventana/busca" 		var="urlBusca"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Busqueda Tipo papel extendido</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/tipo_papel_extendido_busqueda.css"/>" type="text/css"></link>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/tipo_papel_extendido_busqueda.js"/>"></script>
		<script type="text/javascript">
			var urlBusca = "${urlBusca}";
		</script>
	</head>
	<body onload="document.tipo_trabajo_detalle.nombre.focus()">
 		<div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_contenido">
                        <div id="div_tipo_papel_extendido">
                        	<br/>
							<div class="titulo">
								<img alt="" src="<c:url value="/resources/image/titulo_tipo_papel_extendido.png"/>"/>
							</div>
							<div id="div_contenedor_tabla">
								<div class="columna_completa">
									<div id="div_tabla_tipo_papel_extendido">
										<table id="tabla_tipo_papel_extendido">
											<tr>
												<th>Id.</th>
												<th>Proveedor</th>
												<th>Nombre</th>
												<th>Gramaje</th>
												<th>Kilogramos</th>
												<th>Alto</th>
												<th>Ancho</th>
												<th>Precio</th>
												<th>Unidad</th>
											</tr>
										<c:choose>
											<c:when test="${fn:length(listaTipoPapelExtendido) gt 0}">
												<c:forEach var="tipoPapelExtendido" items="${listaTipoPapelExtendido}" varStatus="i">
													<fmt:parseNumber var="formatAncho" type="number" integerOnly="true" value="${tipoPapelExtendido.ancho}" />
													<fmt:parseNumber var="formatAlto" type="number" integerOnly="true" value="${tipoPapelExtendido.alto}" />
													<tr class='${i.count%2==0?"l2":"l1"}'
														onclick="setCampos('${tipoPapelExtendido.idTipoPapelExtendido}', '${tipoPapelExtendido.razonSocial}', '${tipoPapelExtendido.nombre}', '${tipoPapelExtendido.gramaje}', '${tipoPapelExtendido.kilogramos}', '${tipoPapelExtendido.alto}', '${tipoPapelExtendido.ancho}', '${tipoPapelExtendido.descripcion}', '${tipoPapelExtendido.precio}', '${tipoPapelExtendido.nombrePrecio}');"
														ondblclick="this.click(); window.parent.Shadowbox.close();">
														<td>${tipoPapelExtendido.idTipoPapelExtendido}</td>
														<td>${tipoPapelExtendido.razonSocial}</td>
														<td>${tipoPapelExtendido.nombre}</td>
														<td>${tipoPapelExtendido.gramaje}</td>
														<td>${tipoPapelExtendido.kilogramos}</td>
														<td>${formatAlto}</td>
														<td>${formatAncho}</td>
														<td>${tipoPapelExtendido.precio}</td>
														<td>${tipoPapelExtendido.nombrePrecio}</td>
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
													<td>&nbsp;</td>
													<td>&nbsp;</td>
												</tr>														
											</c:otherwise>
										</c:choose>
										</table>
									</div>
								</div>
							</div>
							<form name="tipo_trabajo_detalle" action="" method="POST">
								<input type="hidden" name="id_tipo_papel_extendido"	value="">
								<div class="div_separador_mediano">
									<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
								</div>
								<div class="linea">
									<div class="casilla">
										<div class="columna_completa">
											<table>
												<tr>
													<td width="16%">Papel seleccionado:</td>
													<td>
														<input 	type="text"
																class="input"
																name="descripcion_completa"
																value=""
																readonly/>
													</td>
												</tr>
											</table>
										</div>
									</div>
								</div>
								<div class="div_separador_chico">
									<img alt="" src="<c:url value="/resources/image/separador_chico.jpg"/>"/>
								</div>
								<div class="titulo">
									<font size="5">CRITERIOS DE B&Uacute;SQUEDA</font>
								</div>
								<div class="linea">
									<div class="casilla">
										<div class="columna_izquierda">
											<div class="columna_completa">
												<table>
													<tr>
														<td width="20%">
															<input type="checkbox" name="chkbx_busca_por_nombre" checked/>
															<span style="cursor:pointer;" onclick="document.tipo_trabajo_detalle.chkbx_busca_por_nombre.click()">Nombre:</span>
														</td>
														<td>
															<input 	type="text" 
																	class="input" 
																	name="nombre"
																	onkeydown="aceptaIntro(event, 'busca', null)" 
																	value=""/>
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div class="columna_derecha">
											<div class="mitad_columna_izquierda">
												<table>
													<tr>
														<td width="28%">
															<input type="checkbox" name="chkbx_busca_por_alto"/>
															<span style="cursor:pointer;" onclick="document.tipo_trabajo_detalle.chkbx_busca_por_alto.click()">Alto:</span>
														</td>
														<td>
															<input 	type="text" 
																	class="input" 
																	name="alto" 
																	value="" 
																	onkeydown="revisaNumero(false, this.value, event, 'busca', null)"/>
														</td>
													</tr>
												</table>
											</div>
											<div class="mitad_columna_derecha">
												<table>
													<tr>
														<td width="35%">
															<input type="checkbox" name="chkbx_busca_por_ancho"/>
															<span style="cursor:pointer;" onclick="document.tipo_trabajo_detalle.chkbx_busca_por_ancho.click()">Ancho:</span>
														</td>
														<td>
															<input 	type="text" 
																	class="input" 
																	name="ancho" 
																	value="" 
																	onkeydown="revisaNumero(false, this.value, event, 'busca', null)"/>
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
														<td width="43%">
															<input type="checkbox" name="chkbx_busca_por_gramaje"/>
															<span style="cursor:pointer;" onclick="document.tipo_trabajo_detalle.chkbx_busca_por_gramaje.click()">Gramaje:</span>
														</td>
														<td>
															<input 	type="text" 
																	class="input" 
																	name="gramaje" 
																	value="" 
																	onkeydown="revisaNumero(false, this.value, event, 'busca', null)"/>
														</td>
													</tr>
												</table>
											</div>
											<div class="mitad_columna_derecha">
												<table>
													<tr>
														<td width="51%">
															<input type="checkbox" name="chkbx_busca_por_kilogramos"/>
															<span style="cursor:pointer;" onclick="document.tipo_trabajo_detalle.chkbx_busca_por_kilogramos.click()">Kilogramos:</span>
														</td>
														<td>
															<input 	type="text" 
																	class="input" 
																	name="kilogramos" 
																	value="" 
																	onkeydown="revisaNumero(true, this.value, event, 'busca', null)"/>
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div class="columna_derecha">
											<div class="columna_completa">
												<table>
													<tr>
														<td width="23%">
															<input type="checkbox" name="chkbx_busca_por_proveedor"/>
															<span style="cursor:pointer;" onclick="document.tipo_trabajo_detalle.chkbx_busca_por_proveedor.click()">Proveedor:</span>
															
														</td>
														<td>
															<select name="id_proveedor_papel" onchange="">
																<c:forEach var="proveedorPapel"
																	items="${listaProveedorPapel}">
																	<option value="${proveedorPapel.value}">${proveedorPapel.text}</option>
																</c:forEach>
															</select>
														</td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</div>
								<br/>
								<!-- <div class="linea"></div> -->
								<div class="linea">
									<div class="casilla" style="text-align: right;">
										<img alt="" style="cursor: pointer;" onclick="limpia()" src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
										<span style="cursor:pointer;" onclick="busca()">
											&nbsp;Buscar&nbsp;
										</span>
										<span style="cursor:pointer;" onclick="window.parent.Shadowbox.close()">
											&nbsp;Aceptar&nbsp;
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