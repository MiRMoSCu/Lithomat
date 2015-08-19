<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/?opc=produccion"	               			var="urlMenu"/>
<c:url value="/visualizador/busca_ordenes_produccion"   var="urlBuscaOrdenesProduccion"/>
<c:url value="/visualizador/obtiene_detalle_nut"        var="urlObtieneDetalleNut"/>
<fmt:setLocale value="en_US" scope="session" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Visuallzador</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/visualizador.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/paginador.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/shadowbox/shadowbox.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/visualizador.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/paginador.js"/>"></script>
        <script type="text/javascript">
            Shadowbox.init({ });
        </script>
        <script type="text/javascript">
            var numero_total_registros	        = ${numeroTotalRegistros};
            var numero_registros_por_pagina		= ${numeroRegistrosPorPagina};
            var tamanio_maximo_arreglo	        = ${tamanioMaximoArreglo};	// DEBE SER MAYOR A 2
            var numero_pagina		        	= 1;	// NO DEBE MODIFICARSE
            
            var tamanio_arreglo		        	= 0; 	// se inicializan en carga_datos()
            var numero_pagina_total	        	= 0; 	// se inicializan en carga_datos()
            var mitad_tamanio_arreglo	        = 0;	// se inicializan en carga_datos()
        </script>
        <script type="text/javascript">
        	var urlMenu						= "${urlMenu}";
            var urlBuscaOrdenesProduccion   = '${urlBuscaOrdenesProduccion}';
            var urlObtieneDetalleNut        = '${urlObtieneDetalleNut}';
        </script>
        <script type="text/javascript">
	        function regresa_menu() {
	        	location.replace(urlMenu);
	        }
        </script>
    </head>
    <body onload="carga_datos();">
        <div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_cabecera">
                        <div id="div_logo">
                            <img alt="" src="<c:url value="/resources/image/logo.png"/>"/>
                        </div>
                        <div id="div_encabezado">
                            <img alt="" src="<c:url value="/resources/image/encabezado_cotizador.png"/>"/>
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                            <div class="div_menu_item">
                                <img alt="" src="<c:url value="/resources/image/boton_menu_produccion.png"/>"/>
                                <ul id="menu_produccion">
                                    <li>
                                        <a href="#">
                                            <img alt="" src="<c:url value="/resources/image/menu_diseno.png"/>"/>
                                        </a>
                                        <img alt="" src="<c:url value="/resources/image/menu_separador.png"/>"/>
                                    </li>
                                </ul>
                            </div>
                            <div id="div_cerrar_sesion">
                                <span style="cursor:pointer;" onclick="regresa_menu();">
                                    <img alt="" src="<c:url value="/resources/image/boton_regresar_menu.jpg"/>"/>
                                </span>
                            </div>
                        </div>
                        <div id="div_contenido">
                            <div id="div_visualizador">
                                <div class="titulo">
                                    <font size="5">VISUALIZADOR DE ORDENES DE PRODUCCI&Oacute;N</font>
                                </div>
                                <div class="linea">
                                    <div class="casilla">
                                        <div id="div_paginacion_resultados" style="float:right;"></div>    
                                    </div>
                                </div>
                                <div id="div_grid">
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_registros">
                                                <table id="tabla_registros">
                                                    <tr>
                                                        <th width="15%">NUT</th>
                                                        <th width="15%">Nombre</th>
                                                        <th width="30%">Descripci&oacute;n</th>
                                                        <th width="10%">Fecha cotizaci&oacute;n</th>
                                                        <th width="20%">Cliente</th>
                                                        <th width="10%">Estatus</th>
                                                    </tr>
                                                <c:forEach var="registro" items="${listaOrdenesProduccion}" varStatus="i">
                                                    <tr class="${i.count%2==0?'l2':'l1'}" onclick="muestra_detalle_nut('${registro.nut}');">
                                                        <td>${registro.nut}</td>
                                                        <td>${registro.nombre}</td>
                                                        <td>${registro.descripcion}</td>
                                                        <td><fmt:formatDate value="${registro.fecha_cotizacion}" type="both" pattern="MMM dd, yyyy"/></td>
                                                        <td>${registro.nombre_moral}</td>
                                                        <td id="td_${registro.nut}" class="estatus_${registro.id_estatus_orden}">${registro.nombre_estatus}</td>
                                                    </tr>
                                                </c:forEach>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="linea">
                                    <div class="casilla">
                                        <div id="div_paginador"></div>
                                    </div>
                                </div>
                                <form name="visualizador" action="" accept-charset="ISO-8859-1">
                                    <input type="hidden" name="tipo_busqueda"               value=""/>
                                    <input type="hidden" name="numero_pagina"               value=""/>
                                    <input type="hidden" name="numero_registros_por_pagina" value=""/>
                                    <div class="div_separador_mediano">
                                        <img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
                                    </div>
                                    <div class="titulo">
                                        <font size="5">CRITERIOS DE B&Uacute;SQUEDA</font>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="29%">
                                                                    <input  id="radio_nut"
                                                                            type="radio"
                                                                            name="radio_tipo_busqueda"
                                                                            value="1"
                                                                            onclick=""/>
                                                                    <label for="radio_nut">NUT:</label>
                                                                </td>
                                                                <td>
                                                                    <input  type="text"
                                                                            class="input"
                                                                            name="nut"
                                                                            value=""
                                                                            maxlength="12"
                                                                            tabindex=""
                                                                            onkeypress=""/>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <div class="columna_completa">
                                                        <table>
                                                            <tr>
                                                                <td width="40%">
                                                                    <input  id="radio_estatus"
                                                                            type="radio"
                                                                            name="radio_tipo_busqueda"
                                                                            value="2"/>
                                                                    <label for="radio_estatus">Estatus:</label>
                                                                </td>
                                                                <td>
                                                                    <select name="id_estatus_orden" tabindex="" onchange="">
                                                                        <c:forEach var="lteo" items="${listaEstatusOrden}">
                                                                            <option value="${lteo.value}">${lteo.text}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="12%">
                                                            <input  id="radio_nombre_op"
                                                                    type="radio"
                                                                    name="radio_tipo_busqueda"
                                                                    value="3"/>
                                                            <label for="radio_nombre_op">Nombre OP:</label>
                                                        </td>
                                                        <td>
                                                            <input  type="text"
                                                                    class="input"
                                                                    name="nombre"
                                                                    value=""
                                                                    tabindex=""
                                                                    onkeypress=""/>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_completa">
                                                <table>
                                                    <tr>
                                                        <td width="15%">
                                                            <input  id="radio_descripcion_op"
                                                                    type="radio"
                                                                    name="radio_tipo_busqueda"
                                                                    value="4"/>
                                                            <label for="radio_descripcion_op">Descripci&oacute;n OP:</label>
                                                        </td>
                                                        <td>
                                                            <input  type="text"
                                                                    class="input"
                                                                    name="descripcion"
                                                                    value=""
                                                                    tabindex=""
                                                                    onkeypress=""/>
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
                                                            <td width="17%">
                                                                <input  id="radio_fecha_cotizacion"
                                                                        type="radio"
                                                                        name="radio_tipo_busqueda"
                                                                        value="5"/>
                                                                <label for="radio_fecha_cotizacion">Fecha:</label>
                                                            </td>
                                                            <td>
                                                                <table>
                                                                    <tr>
                                                                        <td>
                                                                            <input  type="date"
                                                                                    class="input"
                                                                                    name="fecha_cotizacion_inicio"
                                                                                    value=""
                                                                                    tabindex=""
                                                                                    onkeypress=""/>
                                                                        </td>
                                                                        <td width="1%">a:</td>
                                                                        <td>
                                                                            <input  type="date"
                                                                                    class="input"
                                                                                    name="fecha_cotizacion_fin"
                                                                                    value=""
                                                                                    tabindex=""
                                                                                    onkeypress=""/>
                                                                        </td>
                                                                    </tr>
                                                                </table>
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
                                                                <input  id="radio_cliente"
                                                                        type="radio"
                                                                        name="radio_tipo_busqueda"
                                                                        value="6"/>
                                                                <label for="radio_cliente">Cliente:</label>
                                                            </td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="cliente"
                                                                        value=""
                                                                        tabindex=""
                                                                        onkeypress=""/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea"></div>
                                    <div class="linea">
                                        <div class="casilla" style="text-align:right;">
                                            <img alt="" style="cursor:pointer;" onclick="limpia();" src="<c:url value="/resources/image/boton_limpiar.jpg"/>"></img>
                                            <span style="cursor:pointer;" onclick="nueva_busqueda();">&nbsp;Buscar&nbsp;</span>
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
    </body>
</html>