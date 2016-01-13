<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" scope="session" />
<c:url value="/?opc=catalogos"	               	var="urlMenu"/>
<c:url value="/tipo_placa/catalogo/alta" 		var="urlAlta"/>
<c:url value="/tipo_placa/catalogo/modifica" 	var="urlModifica"/>
<c:url value="/tipo_placa/catalogo/elimina" 	var="urlElimina"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Tipo de placas</title>
        <style type="text/css" media="screen">
 
            table#tabla_tipo_placa {
                overflow-y:scroll;
            }
        
            table#tabla_tipo_placa tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_tipo_placa {
                width: 865px;
                margin-left: auto;
                margin-right: auto;
                background: transparent; /*green*/
                display: block;                
            }
            
            #div_contenedor_tabla {
                width: 100%;
                height: 250px;
            }
            
            #div_tabla_tipo_placa {
                width: 100%;
                height: 100%;
                overflow-x: scroll;
            }
        
        </style>
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/catalogo.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/tipo_placa.js"/>"></script>
        <script type="text/javascript">
        	var urlMenu		= "${urlMenu}";
            var urlAlta     = '${urlAlta}';
            var urlModifica = '${urlModifica}';
            var urlElimina  = '${urlElimina}';
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
                            <img alt="" src="<c:url value="/resources/image/encabezado_catalogo.png"/>"/>
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                            <div id="div_contenido_menu">
                                <div id="div_cerrar_sesion">
                                    <span style="cursor:pointer;" onclick="regresa_menu();">
	                                    <img alt="" src="<c:url value="/resources/image/boton_regresar_menu.jpg"/>"/>
	                                </span>
                                </div>
                            </div>
                        </div>
                        <div id="div_contenido">
                            <form action="tipo_placa" method="post" accept-charset="ISO-8859-1">
                                <div id="div_tipo_placa">
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_tipo_placa.png"/>"/>
                                    </div>
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_tipo_placa">
                                                <table id="tabla_tipo_placa">
                                                    <tr>
                                                        <th>Identificador</th>
                                                        <th>Maquina</th>
                                                        <th>Descripci&oacute;n</th>
                                                        <th>Precio</th>
                                                        <th>Unidad</th>
                                                    </tr>
                                                <c:forEach var="tipoPlaca" items="${listaTipoPlaca}" varStatus="i">
                                                    <tr class='${i.count%2==0?"l2":"l1"}'
                                                        onclick="setCampos('${tipoPlaca.idTipoPlaca}', '${tipoPlaca.maquina.nombre}', '${tipoPlaca.descripcion}', '${tipoPlaca.precio}', '${tipoPlaca.tipoPrecio.nombre}');">
                                                        <td>${tipoPlaca.idTipoPlaca}</td>
                                                        <td>${tipoPlaca.maquina.nombre}</td>
                                                        <td>${tipoPlaca.descripcion}</td>
                                                        <td><fmt:formatNumber pattern="#,##0.00" value="${tipoPlaca.precio}"/></td>
                                                        <td>${tipoPlaca.tipoPrecio.nombre}</td>
                                                    </tr>
                                                </c:forEach>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_detalle.png"/>"/>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Identificador:</td>
                                                            <td>
                                                                <input type="text" class="input" name="id_tipo_placa"
                                                                       value="" readonly="readonly"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">M&aacute;quina:</td>
                                                            <td>
                                                                <select name="id_maquina" onchange="">
                                                                    <c:forEach var="maquina" items="${listaMaquina}">
                                                                        <option value="${maquina.value}">${maquina.text}</option>
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
                                                            <td width="1%">Descripci&oacute;n:</td>
                                                            <td>
                                                                <input type="text" class="input" name="descripcion" value=""/>
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
                                                            <td width="1%">Precio:</td>
                                                            <td>
                                                                <input type="text" class="input" name="precio" value=""
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Unidad:</td>
                                                            <td>
                                                                <select name="id_tipo_precio" onchange="">
                                                                    <c:forEach var="precio" items="${listaTipoPrecio}">
                                                                        <option value="${precio.value}">${precio.text}</option>
                                                                    </c:forEach>
                                                                </select>
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
                                            <img alt="" style="cursor:pointer;" onclick="limpia();"
                                            	 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
                                             
                                            <img alt="" style="cursor:pointer;" onclick="elimina();"
                                            	 src="<c:url value="/resources/image/boton_eliminar.jpg"/>"/>
                                             
                                            <img alt="" style="cursor:pointer;" onclick="modifica();"
                                            	 src="<c:url value="/resources/image/boton_modificar.jpg"/>"/>
                                             
                                            <img alt="" style="cursor:pointer;" onclick="crear();"
                                            	 src="<c:url value="/resources/image/boton_agregar.jpg"/>"/>
                                        </div>
                                    </div>
                                </div>
                            </form>
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
        <div id="notificacion_tipo_growl">
            <span id="cerrar_notificacion_growl" style="cursor:pointer;">CLOSE
                <br></br>Aviso.</span>
        </div>
    </body>
</html>