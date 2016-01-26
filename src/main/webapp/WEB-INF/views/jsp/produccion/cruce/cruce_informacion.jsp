<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/?opc=produccion"	var="urlMenu"/>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cruce Informaci&oacute;n</title>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/cruce_informacion.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/paginador.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/shadowbox/shadowbox.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/paginador.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/cruce_informacion.js"/>"></script>
        <script type="text/javascript">
            // inicializacion jquery
            $(document).ready(function (){});
            // inicializacion shadowbox
            Shadowbox.init({
                //modal: true,
                //overlayOpacity: 0.75
            });
            // iniciacion datepicker
            $(function() {
				$("#datepicker").datepicker({
					dateFormat:'yy-mm-dd',
				});
			});
        </script>
        <script type="text/javascript">
        	var urlMenu	= "${urlMenu}";
        </script>
        <script type="text/javascript">
	        function regresa_menu() {
	        	location.replace(urlMenu);
	        }
        </script>
	</head>
	<body>
		<div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_cabecera">
                        <div id="div_logo">
                            <img alt="" src="<c:url value="/resources/image/logo.png"/>"/>
                        </div>
                        <div id="div_encabezado">
                            <img alt="" src="<c:url value="/resources/image/encabezado_orden_produccion.png"/>"/>
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                            <div id="div_contenido_menu">
                                <div class="div_menu_item">
                                    <img alt="" src="<c:url value="/resources/image/boton_menu_produccion.png"/>"/>
                                    <ul id="menu_produccion">
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_diseno.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_preprensa.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_transporte.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_acabado.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_offset.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                        </li>
                                         
                                        <li>
                                            <a href="#">
                                            	<img alt="" src="<c:url value="/resources/image/menu_procesos.png"/>"/>
                                            </a>
                                            <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                        </li>
                                    </ul>
                                </div>
                                <!--
                                <div class="div_menu_item">
                                    <img alt="" src="resources/image/boton_menu_reportes.png"/>
                                    <ul id="menu_reportes">
                                        <li>
                                            <a href="#">Plantilla</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Clasificaci&oacute;n</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Resultados</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Calendario</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="div_menu_item">
                                    <img alt="" src="resources/image/boton_menu_seguridad.png"/>
                                    <ul id="menu_seguridad">
                                        <li>
                                            <a href="#">T.V.</a>
                                        </li>
                                         
                                        <li>
                                            <a href="#">Radio</a>
                                        </li>
                                    </ul>
                                </div>
                                -->
                                <div id="div_cerrar_sesion">
                                    <span style="cursor:pointer;" onclick="regresa_menu();">
                                    	<img alt="" src="<c:url value="/resources/image/boton_regresar_menu.jpg"/>"/>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div id="div_contenido">
                        	<div id="div_cruce_informacion">
                        		<div class="titulo">
                        			<font size="5">CRUCE INFORMACI&Oacute;N: FECHA - PRENSISTA - M&Aacute;QUINA</font>
                        		</div>
                        		<div class="linea">
                        			<div class="casilla">
                        				<div id="div_paginacion_resultados" style="float:right;">100 registros encontrados. Mostrando del 1 al 10.</div>
                        			</div>
                        		</div>
                       			<div id="div_contenedor_tabla">
                       				<div class="columna_completa">
                       					<div id="div_tabla_registros">
                       						<table id="tabla_registros">
                       							 <tr>
                       							 	<th>No.</th>
                       							 	<th>NUT</th>
                       							 	<th>Nom. Ord.Prod.</th>
                       							 	<th>Nom. Trabajo</th>
                       							 	<th>Nom. Impr.</th>
                       							 	<th>No. Pgo</th>
                       							 	<th>H. Req</th>
                       							 </tr>
                       							 <tr class="l1">
                       							 	<td>1</td>
                       							 	<td>1602500018</td>
                       							 	<td>revista</td>
                       							 	<td>revista</td>
                       							 	<td>contenido interior</td>
                       							 	<td>1</td>
                       							 	<td>1000</td>
                       							 </tr>
                       							 <tr class="l2">
                       							 	<td>2</td>
                       							 	<td>1602500018</td>
                       							 	<td>revista</td>
                       							 	<td>revista</td>
                       							 	<td>contenido interior</td>
                       							 	<td>2</td>
                       							 	<td>1000</td>
                       							 </tr>
                       							 <tr class="l1">
                       							 	<td>3</td>
                       							 	<td>1602500018</td>
                       							 	<td>revista</td>
                       							 	<td>revista</td>
                       							 	<td>contenido interior</td>
                       							 	<td>3</td>
                       							 	<td>1000</td>
                       							 </tr>
                       							 <tr class="l2">
                       							 	<td>4</td>
                       							 	<td>1602500018</td>
                       							 	<td>revista</td>
                       							 	<td>revista</td>
                       							 	<td>portadillas</td>
                       							 	<td>1</td>
                       							 	<td>250</td>
                       							 </tr>
                       							 <tr class="l1">
                       							 	<td>5</td>
                       							 	<td>1602500007</td>
                       							 	<td>usuario</td>
                       							 	<td>usuario</td>
                       							 	<td>usuario</td>
                       							 	<td>1</td>
                       							 	<td>1000</td>
                       							 </tr>
                       						</table>
                       					</div>
                       				</div>
                       			</div>
                        		<br/>
                        		<div class="linea">
                        			<div class="casilla">
                        				<div id="div_paginador">
                        					<ul id="paginacion">
                        						<li class="activo bold">Primero</li>
                        						<li class="activo bold">Anterior</li>
                        						<li name="arreglo" class="seleccionado">1</li>
                        						<li class="activo bold">Siguiente</li>
                        						<li class="activo bold">Ultimo</li>
                        					</ul>
                        				</div>
                        			</div>
                        		</div>
                        		<div class="div_separador_mediano">
                                	<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                </div>
                                <div class="titulo">
                                	<font size="5">CRITERIOS DE B&Uacute;SQUEDA</font>
                                </div>
                                <div id="div_formulario_busqueda_fecha_prensista_maquina">
                                	<form action=""></form>
                                </div>
                                <div class="div_separador_mediano">
                                	<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                </div>
                                <div class="titulo">
                                    <img alt="" src="<c:url value="/resources/image/titulo_detalle.png"/>"/>
                                </div>
                                <div id="div_fecha_prensista_maquina">
                                	<form action=""></form>
                                </div>
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
	</body>
</html>