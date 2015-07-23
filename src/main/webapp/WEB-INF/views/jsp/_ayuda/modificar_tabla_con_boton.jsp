<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
		
			function modificaTablaDisenioDeralle() {
				alert("hola");
			}
		
		</script>
	</head>
	<body>
		<br><br><br><br><br><br><br><br>
		<form>
			<table>
				<tr>
					<td>Detalle:</td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td>Cantidad:</td>
					<td><input></td>
				</tr>
				<tr>
					<td>Precio:</td>
					<td><input></td>
				</tr>
				<tr>
					<td>Especif:</td>
					<td><input></td>
				</tr>
			</table>
			<br>
			<br>
		</form>
		<br>
		<div id="div_contenedor_tabla_disenio_detalle">
			<div class="columna_completa">
	           	<div id="div_tabla_disenio_detalle">
					<table border="1px">
	           			<tr>
	           				<th>No.</th>
	           				<th>Descripción</th>
	           				<th>Cantidad</th>
	           				<th>Especificación</th>
	           			</tr>
	           			<tr class="l1">
	           				<td>1</td>
	           				<td>Tipografia</td>
	           				<td>1</td>
	           				<td>111</td>
	           			</tr>
		           	</table>
	           	</div>
	        </div>
		</div>
		<div class="casilla">
			<div class="linea">
				<img id="imgBtnModificarAcabadoDetalle" alt="" style="cursor:pointer;" onclick="modificaTablaDisenioDeralle();" src="resources/image/boton_modificar.jpg">
			</div>
		</div>	
		
		
		
		
		
		
		
		
	</body>
</html>