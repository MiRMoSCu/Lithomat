<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/"	               						var="urlMenu"/>
<c:url value="/combinacion_tintas/catalogo/alta" 		var="urlAlta"/>
<c:url value="/combinacion_tintas/catalogo/modifica" 	var="urlModifica"/>
<c:url value="/combinacion_tintas/catalogo/elimina" 	var="urlElimina"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Combinaci&oacute;n de Tintas</title>
        <style type="text/css" media="screen">
        
            table#tabla_combinacion_tintas {
                overflow-y:scroll;
            }
            
            table#tabla_combinacion_tintas tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_combinacion_tintas {
                width: 865px;
                margin-left: auto;
                margin-right: auto;
                background: transparent; /*green*/
                display: block;                    
            }
            
            #div_contenedor_tabla {
                width: 100%;
                height: 350px;
            }
            
            #div_tabla_combinacion_tintas {
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
        <script type="text/javascript" src="<c:url value="/resources/js/combinacion_tintas.js"/>"></script>
        <script type="text/javascript">
        	var urlMenu		= "${urlMenu}";
            var urlAlta 	= '${urlAlta}';
            var urlModifica = '${urlModifica}';
            var urlElimina 	= '${urlElimina}';
          /*
            function setCampos( tr ) {
                    var arr = tr.childNodes;
                    //console.log( arr ); // MUESTRA EL CONTENIDO DEL ARREGLO EN CONSOLA
                    //alert( arr[0].baseURI );
                    document.forms[0].id_combinacion_tintas.value 	= arr[1].innerHTML;
                    document.forms[0].num_tintas.value 				= arr[3].innerHTML;
                    document.forms[0].descripcion.value 			= arr[5].innerHTML;
            }
            */
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
                            <img alt="." src="<c:url value="/resources/image/logo.png"/>">
                        </div>
                        <div id="div_encabezado">
                            <img alt="." src="<c:url value="/resources/image/encabezado_catalogo.png"/>"></img>
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                            <div id="div_contenido_menu">
                                <div id="div_cerrar_sesion">
                                    <span style="cursor:pointer;" onclick="regresa_menu();">
	                                    <img alt="" src="<c:url value="/resources/image/boton_regresar_menu.jpg"/>">
	                                </span>
                                </div>
                            </div>
                        </div>
                        <div id="div_contenido">
                            <form:form action="${urlAlta}" method="post" modelAttribute="combinacionTintas" acceptCharset="ISO-8859-1">
                                <div id="div_combinacion_tintas">
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_combinacion_tintas.png"/>"></img>
                                    </div>
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_combinacion_tintas">
                                                <table id="tabla_combinacion_tintas">
                                                    <tr>
                                                        <th>Identificador</th>
                                                        <th>N&uacute;mero de tintas</th>
                                                        <th>Descripci&oacute;n</th>
                                                    </tr>
                                                <c:forEach var="combinacionTintas" items="${listaCombinacionTintas}" varStatus="i">
                                                    <tr class='${i.count%2==0?"l2":"l1"}'
                                                        onclick="setCampos('${combinacionTintas.idCombinacionTintas}','${combinacionTintas.numTintas}', '${combinacionTintas.descripcion}','${combinacionTintas.activo}');">
                                                        <td>${combinacionTintas.idCombinacionTintas}</td>
                                                        <td>${combinacionTintas.numTintas}</td>
                                                        <td>${combinacionTintas.descripcion}</td>
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
                                                                       name="id_combinacion_tintas" value=""
                                                                       tabindex="1" readonly="readonly"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="58%">N&uacute;mero de tintas:</td>
                                                            <td>
                                                                <input type="text" class="input" name="num_tintas"
                                                                       value="" tabindex="2"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"></input>
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
                                                                <input type="text" class="input" name="descripcion"
                                                                       value="" tabindex="3"></input>
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
                            </form:form>
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