<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/cotizacion/exporta_reporte"	var="urlExportaReporte"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/condiciones_produccion.css"/>" type="text/css"></link>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/condiciones_produccion.js"/>"></script>
        <script type="text/javascript">
            //inicializacion jquery
            $(document).ready(function (){});
        </script>
		<script type="text/javascript">
			var urlExportaReporte 	= "${urlExportaReporte}";
		</script>
	</head>
	<body>
		<div id="div_area">
			<div id="div_ancho">
				<div id="div_hoja">
					<div id="div_cuerpo">
						<div id="div_contenido">
							<div id="div_condiciones_produccion">
								<br>
								<div class="titulo">
									<font size="5">CONDICIONES PRODUCCI&Oacute;N:</font>
								</div>
								<form name="condiciones_produccion" action="" method="post" accept-charset="ISO-8859-1" target="_blank">
									<input type="hidden" name="nut" 			value="">
									<input type="hidden" name="tipo_formato"	value="">
									<div style="margin: 0px 0px 5px 0px">
										<textarea id="condiciones_produccion" name="condiciones_produccion" rows="" cols="" maxlength="1000">${condiciones_produccion}</textarea>									
									</div>
									<div class="linea">
										<div class="casilla" style="text-align:right;">
											<span style="cursor:pointer;" onclick="cierraVentanaModal()">
												<font color="gray">CANCELAR</font>
											</span>
											<span style="cursor:pointer;" onclick="limpiaVentana()">
												<font color="gray">LIMPIAR</font>
											</span>
											<span style="cursor:pointer;" onclick="exportaReporte(0)">
												<font color="blue">VER EN PANTALLA</font>
											</span>
											<span style="cursor:pointer;" onclick="exportaReporte(1)">
												<font color="blue">PDF</font>
											</span>
											<span style="cursor:pointer;" onclick="exportaReporte(2)">
												<font color="blue">RTF</font>
											</span>
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