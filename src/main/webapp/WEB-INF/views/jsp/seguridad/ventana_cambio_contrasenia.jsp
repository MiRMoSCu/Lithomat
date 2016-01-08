<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/contrasenia/cambio"		var="urlCambioContrasenia"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cambio contrae&ntilde;ia</title>
		<link rel="stylesheet" href="<c:url value="/resources/css/ventana_cambio_contrasenia.css"/>" type="text/css"></link>
		<link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
	    <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
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
        <script type="text/javascript" src="<c:url value="/resources/js/ventana_cambio_contrasenia.js"/>"></script>
        <script type="text/javascript">
	     	// inicializacion jquery
			$(document).ready(function (){});
        </script>
        <script type="text/javascript">
        	var urlCambioContrasenia	= '${urlCambioContrasenia}';
        </script>
	</head>
	<body>
		<div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_contenido">
                    	<br/>
                    	<form name="cambio_contrasenia" method="post">
	                        <div class="titulo">
	                        	<font size=5>CAMBIO DE CONTRASE&Ntilde;A</font>
	                        </div>
	                        <div class="linea">
	                        	<div class="casilla">
	                        		<div class="columna_completa">
	                        			<table>
	                        				<tr>
	                        					<td width="1%">Usuario:</td>
	                        					<td>
	                        						<input 	type="text"
	                        								class="input"
	                        								name="nombre_completo"
	                        								value="${nombreCompleto}"
	                        								readonly/>
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
                        							<td width="1%">Contrase&ntilde;a</td>
                        							<td>
                        								<input 	type="password"
                        										class="input"
                        										name="contrasenia1" />
                        							</td>
                        						</tr>
                        					</table>
                        				</div>
                        			</div>
                        			<div class="columna_derecha">
                        				<div class="columna_completa">
                        					<table>
                        						<tr>
                        							<td width="1%">Contrase&ntilde;a</td>
                        							<td>
                        								<input 	type="password"
                        										class="input"
                        										name="contrasenia2" />
                        							</td>
                        						</tr>
                        					</table>
                        				</div>
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