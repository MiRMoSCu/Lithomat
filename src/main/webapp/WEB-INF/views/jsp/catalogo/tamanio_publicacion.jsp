<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/"	               						var="urlMenu"/>
<c:url value="/tamanio_publicacion/catalogo/alta" 		var="urlAlta"/>
<c:url value="/tamanio_publicacion/catalogo/modifica" 	var="urlModifica"/>
<c:url value="/tamanio_publicacion/catalogo/elimina" 	var="urlElimina"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Tama&ntilde;o de Publicaci&oacute;n</title>
        <style type="text/css" media="screen">
        
            table#tabla_tamanio_publicacion {
                overflow-y:scroll;
            }
            
            table#tabla_tamanio_publicacion tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_tamanio_publicacion {
                width: 865px;                
                margin-left: auto;
                margin-right: auto;
                background: transparent; /*green*/
                display: block;
            }
            
            #div_contenedor_tabla {
                width: 100%;
                height: 270px;
            }
            
            #div_tabla_tamanio_publicacion {
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
        <script type="text/javascript" src="<c:url value="/resources/js/tamanio_publicacion.js"/>"></script>
        <script type="text/javascript">
        	var urlMenu		= "${urlMenu}";
            var urlAlta       = '${urlAlta}';
            var urlModifica   = '${urlModifica}';
            var urlElimina    = '${urlElimina}';
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
                            <img alt="" src="<c:url value="/resources/image/logo.png"/>"></img>
                        </div>
                        <div id="div_encabezado">
                            <img alt="" src="<c:url value="/resources/image/encabezado_catalogo.png"/>"></img>
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                            <div id="div_contenido_menu">
                                <div id="div_cerrar_sesion">
                                    <span style="cursor:pointer;" onclick="regresa_menu();">
	                                    <img alt="" src="<c:url value="/resources/image/boton_regresar_menu.jpg"/>"></img>
	                                </span>
                                </div>
                            </div>
                        </div>
                        <div id="div_contenido">
                            <form action="tamanio_publicacion" method="post" accept-charset="ISO-8859-1">
                                <div id="div_tamanio_publicacion">
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_tamanio_publicacion.png"/>"></img>
                                    </div>
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_tamanio_publicacion">
                                                <table id="tabla_tamanio_publicacion">
                                                    <tr>
                                                        <th>Identificador</th>
                                                        <th>Nombre</th>
                                                        <th>Tama&ntilde;o de fracci&oacute;n</th>
                                                        <th>N&uacute;mero de p&aacute;ginas</th>
                                                        <th>N&uacute;mero d&eacute;cimal</th>
                                                        <th>N&uacute;mero de doblez</th>
                                                    </tr>
                                                <c:forEach var="tamanioPublicacion" items="${listaTamanioPublicacion}" varStatus="i">
                                                    <tr class='${i.count%2==0?"l2":"l1"}'
                                                        onclick="setCampos('${tamanioPublicacion.idTamanioPublicacion}','${tamanioPublicacion.nombre}','${tamanioPublicacion.tamanioFraccion}','${tamanioPublicacion.numeroPaginas}','${tamanioPublicacion.numeroDecimal}','${tamanioPublicacion.numeroDoblez}');">
                                                        <td>${tamanioPublicacion.idTamanioPublicacion}</td>
                                                        <td>${tamanioPublicacion.nombre}</td>
                                                        <td>${tamanioPublicacion.tamanioFraccion}</td>
                                                        <td>${tamanioPublicacion.numeroPaginas}</td>
                                                        <td>${tamanioPublicacion.numeroDecimal}</td>
                                                        <td>${tamanioPublicacion.numeroDoblez}</td>
                                                    </tr>
                                                </c:forEach>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_detalle.png"/>"></img>
                                    </div>
                                    <div class="linea">
                                        <div class="casilla">
                                            <div class="columna_izquierda">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="40%">Identificador:</td>
                                                            <td>
                                                                <input type="text" class="input"
                                                                       name="id_tamanio_publicacion" value=""
                                                                       tabindex="1" readonly="readonly"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Nombre:</td>
                                                            <td>
                                                                <input type="text" class="input" name="nombre" value=""
                                                                       tabindex="2"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="67%">Tama&ntilde;o de fracci&oacute;n:</td>
                                                            <td>
                                                                <input type="text" class="input" name="tamanio_fraccion"
                                                                       value="" tabindex="3"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="67%">N&uacute;mero de p&aacute;ginas:</td>
                                                            <td>
                                                                <input type="text" class="input" name="numero_paginas"
                                                                       value="" tabindex="4"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"></input>
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
                                                            <td width="56%">N&uacute;mero d&eacute;cimal:</td>
                                                            <td>
                                                                <input type="text" class="input" name="numero_decimal"
                                                                       value="" tabindex="5"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="61%">N&uacute;mero de doblez:</td>
                                                            <td>
                                                                <input type="text" class="input" name="numero_doblez"
                                                                       value="" tabindex="6"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"></input>
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
                                            	 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"></img>
                                             
                                            <img alt="" style="cursor:pointer;" onclick="elimina();"
                                            	 src="<c:url value="/resources/image/boton_eliminar.jpg"/>"></img>
                                             
                                            <img alt="" style="cursor:pointer;" onclick="modifica();"
                                            	 src="<c:url value="/resources/image/boton_modificar.jpg"/>"></img>
                                             
                                            <img alt="" style="cursor:pointer;" onclick="crear();"
                                            	 src="<c:url value="/resources/image/boton_agregar.jpg"/>"></img>
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