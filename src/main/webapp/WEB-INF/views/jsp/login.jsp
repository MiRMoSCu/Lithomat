<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/login" var="url" />
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Log in</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>" type="text/css"></link>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/login.js"/>"></script>
	</head>
	<body>
		<form name="login" action="${url}" method="post">
			<div id="div_login">
				<div id="div_cuadro_formulario">
					<div id="div_espacio"></div>
					<div id="div_usuario">
						<div id="div_imagen_usuario">
							<img alt="" src="<c:url value="/resources/image/usuario.png"/>"/>
						</div>
						<div id="div_contenedor_input_usuario">
							<div id="div_input_usuario">
								<input type="text" name="usuario" value="Usuario"
									onfocus="this.value='';"
									onblur="javascript:revisaUsuario(this);">
							</div>
						</div>
						<div id="div_curva_derecha">
							<img name="esquina_derecha" alt=".." src="<c:url value="/resources/image/esquina_derecha.png"/>">
						</div>
					</div>
					<div id="div_contrasenia">
						<div id="div_curva_izquierda">
							<img name="esquina_izquierda" alt=".." src="<c:url value="/resources/image/esquina_izquierda.png"/>">
						</div>
						<div id="div_contenedor_input_contrasenia">
							<div id="div_input_contrasenia">
								<input type="text" name="contrasenia" value="Contraseña"
									onblur="javascript:revisaContrasenia(this);">
							</div>
						</div>
						<div id="div_imagen_contrasenia">
							<img alt="" src="<c:url value="/resources/image/contrasenia.png"/>"/>
						</div>
					</div>
					<div id="div_enviar">
						<div id="div_mensajes">
							<div id="mensaje_contraseña_incorrecta" style="display: block;">
								<p>${error}</p>
							</div>
						</div>
						<div id="div_boton_enviar">
							<img name="boton_inicio_sesion" alt=".."
								src="<c:url value="/resources/image/boton_inicio_sesion.png"/>"
								style="cursor: pointer;" onclick="javascript:enviaFormulario();">
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>