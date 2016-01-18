<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/?opc=catalogos"				var="urlMenu"/>
<c:url value="/maquina/catalogo/alta" 		var="urlAlta"/>
<c:url value="/maquina/catalogo/modifica" 	var="urlModifica"/>
<c:url value="/maquina/catalogo/elimina" 	var="urlElimina"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Maquina</title>
        <style type="text/css" media="screen">
        
            table#tabla_maquina {
                overflow-y:scroll;
            }
            
            table#tabla_maquina tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_maquina {
                width: 865px;
                margin-left: auto;
                margin-right: auto;
                background: transparent; /*green*/
                display: block;                    
            }
            
            #div_contenedor_tabla {
                width: 100%;
                height: 200px;
            }
            
            #div_tabla_maquina {
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
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/maquina.js"/>"></script>
        <script type="text/javascript">
        	var urlMenu		= "${urlMenu}";
            var urlAlta 	= '${urlAlta}';
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
                        	<img alt="." src="<c:url value="/resources/image/logo.png"/>"/>
                        </div>
                        <div id="div_encabezado">
                        	<img alt="." src="<c:url value="/resources/image/encabezado_catalogo.png"/>"/>
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
                            <form action="maquina" method="post" accept-charset="ISO-8859-1">
                                <div id="div_maquina">
                                    <div class="titulo">
                                    	<img alt="" src="<c:url value="/resources/image/titulo_maquina.png"/>"/>
                                    </div>
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_maquina">
                                                <table id="tabla_maquina">
                                                    <tr>
                                                        <th>Identificador</th>
                                                        <th>Nombre</th>
                                                        <th>Descripci&oacute;n</th>
                                                        <th>Numero colores</th>
                                                        <th>Ancho placa</th>
                                                        <th>Alto placa</th>
                                                        <th>Ancho max papel</th>
                                                        <th>Alto max papel</th>
                                                        <th>Ancho min papel</th>
                                                        <th>Alto min papel</th>
                                                    </tr>
                                                <c:forEach var="maquina" items="${listaMaquina}" varStatus="i">
                                                    <tr class='${i.count%2==0?"l2":"l1"}' onclick="setCampos('${maquina.idMaquina}','${maquina.nombre}', '${maquina.descripcion}', '${maquina.numColores}', '${maquina.anchoPlaca}', '${maquina.altoPlaca}', '${maquina.anchoMaxPapel}', '${maquina.altoMaxPapel}', '${maquina.anchoMinPapel}', '${maquina.altoMinPapel}');">
                                                        <td>${maquina.idMaquina}</td>
                                                        <td>${maquina.nombre}</td>
                                                        <td>${maquina.descripcion}</td>
                                                        <td>${maquina.numColores}</td>
                                                        <td>${maquina.anchoPlaca}</td>
                                                        <td>${maquina.altoPlaca}</td>
                                                        <td>${maquina.anchoMaxPapel}</td>
                                                        <td>${maquina.altoMaxPapel}</td>
                                                        <td>${maquina.anchoMinPapel}</td>
                                                        <td>${maquina.altoMinPapel}</td>
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
                                                            <td width="40%">Identificador:</td>
                                                            <td>
                                                                <input type="text" class="input" name="id_maquina"
                                                                       value="" readonly="readonly"/>
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
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Nombre:</td>
                                                            <td>
                                                                <input type="text" class="input" name="nombre" value=""/>
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
                                                            <td width="54%">N&uacute;mero colores:</td>
                                                            <td>
                                                                <input type="text" class="input" name="num_colores"
                                                                       value="" 
                                                                       onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="35%">Alto placa:</td>
                                                            <td>
                                                                <input type="text" class="input" name="alto_placa"
                                                                       value="" 
                                                                       onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="43%">Ancho placa:</td>
                                                            <td>
                                                                <input type="text" class="input" name="ancho_placa"
                                                                       value="" 
                                                                       onkeydown="revisaNumero(false, this.value, event, null, null)"/>
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
                                                            <td width="49%">Alto min papel:</td>
                                                            <td>
                                                                <input type="text" class="input" name="alto_min_papel"
                                                                       value="" 
                                                                       onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="57%">Ancho min papel:</td>
                                                            <td>
                                                                <input type="text" class="input" name="ancho_min_papel"
                                                                       value="" 
                                                                       onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="51%">Alto max papel:</td>
                                                            <td>
                                                                <input type="text" class="input" name="alto_max_papel"
                                                                       value="" 
                                                                       onkeydown="revisaNumero(false, this.value, event, null, null)"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="59%">Ancho max papel:</td>
                                                            <td>
                                                                <input type="text" class="input" name="ancho_max_papel"
                                                                       value="" 
                                                                       onkeydown="revisaNumero(false, this.value, event, null, null)"/>
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