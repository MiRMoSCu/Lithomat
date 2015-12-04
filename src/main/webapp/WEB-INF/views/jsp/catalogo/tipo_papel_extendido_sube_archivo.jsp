<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/tipo_papel_extendido/catalogo/importa" 	var="urlImportaExcel"/>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
	<link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
	<link rel="stylesheet" href="<c:url value="/resources/css/modal_sube_archivo_excel.css"/>" type="text/css"></link>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
	<script type="text/javascript">
	
		
		function cierraVentanaModal() {
			window.parent.Shadowbox.close();
		}
	
		function ajaxCargaExcel() {
			var obj = document.cargaExcel.submit();
		}
		
		/*
		function actualizaHtml() {
			var res = frames["upload_target"].document.getElementsByTagName("body")[0].innerHTML;
			if( res != "" ) {
				window.parent.document.getElementsByTagName("body")[0].innerHTML = res;
				window.parent.Shadowbox.setup();
				window.parent.Shadowbox.close();
			}
		}
		*/
	
	</script>
</head>
	<body>
		<div id="div_area">
			<div id="div_ancho">
				<div id="div_hoja">
					<div id="div_cuerpo">
						<div id="div_contenido">
							<div id="div_formulario">
								<br>
								<div class="titulo">
									<font size="5">ARCHIVO EXCEL</font>
								</div>
								<!-- <form name="cargaExcel" method="POST" enctype="multipart/form-data" action="${urlImportaExcel}" target="upload_target">-->
								<form name="cargaExcel" method="POST" enctype="multipart/form-data" action="${urlImportaExcel}" accept-charset="ISO-8859-1" target="_parent">
									<div class="linea">
										<div class="casilla">
											<div class="columna_completa">
												<table>
													<tr>
														<td width="1%">Excel:</td>
														<td>
															<input type="file" class="input" name="upfile"/><br/>
														</td>	
													</tr>
												</table>
											</div>
										</div>
									</div>
									<div class="linea">
										<div class="casilla" style="text-align:right;">
											<span style="cursor:pointer;" onclick="cierraVentanaModal()">
												<font color="gray">CANCELAR</font>
											</span>
											<span style="cursor:pointer;" onclick="ajaxCargaExcel()">
												<font color="blue">ACEPTAR</font>
											</span>
										</div>
									</div>
								</form>
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
		<!-- 
		<div style="display:none;">
			<iframe id="upload_target" name="upload_target" style="width:0px; height:0px; border:0px solid #fff;" onload="actualizaHtml()"></iframe>
		</div>
		-->
	</body>
</html>