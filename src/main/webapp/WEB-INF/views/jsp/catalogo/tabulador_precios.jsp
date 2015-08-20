<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/?opc=catalogos"	               		var="urlMenu"/>
<c:url value="/tabulador_precios/catalogo/alta" 	var="urlAlta"/>
<c:url value="/tabulador_precios/catalogo/modifica" var="urlModifica"/>
<c:url value="/tabulador_precios/catalogo/elimina" 	var="urlElimina"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Tabulador de precios</title>
        <style type="text/css" media="screen">
        
            table#tabla_tabulador_precios {
                overflow-y:scroll;
            }
            
            table#tabla_tabulador_precios tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_tabulador_precios {
                width: 865px;
                margin-left: auto;
                margin-right: auto;
                background: transparent; /*green*/
                display: block;                    
            }
            
            #div_contenedor_tabla {
                width: 100%;
                height: 240px;
            }
            
            #div_tabla_tabulador_precios {
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
        <script type="text/javascript" src="<c:url value="/resources/js/tabulador_precios.js"/>"></script>
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
                            <form action="tabulador_precios" method="post" accept-charset="ISO-8859-1">
                                <div id="div_tabulador_precios">
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_tabulador_precios.png"/>"></img>
                                    </div>
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_tabulador_precios">
                                                <table id="tabla_tabulador_precios">
                                                    <tr>
                                                        <th>Id.</th>
                                                        <th>Maquina</th>
                                                        <th>Nombre insumo</th>
                                                        <th>Descripci&oacute;n</th>
                                                        <th>Inicio</th>
                                                        <th>Fin</th>
                                                        <th>P.C. Senc.</th>
                                                        <th>P.C. Reg</th>
                                                        <th>P.C. Dif.</th>
                                                        <th>Unidad</th>
                                                    </tr>
                                                <c:forEach var="tabuladorPrecios" items="${listaTabuladorPrecios}" varStatus="i">
                                                    <tr class='${i.count%2==0?"l2":"l1"}'
                                                        onclick="setCampos('${tabuladorPrecios.idTabuladorPrecios}','${tabuladorPrecios.maquina.nombre}','${tabuladorPrecios.nombreInsumo}','${tabuladorPrecios.descripcion}','${tabuladorPrecios.inicioTabulador}','${tabuladorPrecios.finTabulador}','${tabuladorPrecios.precioComplejidadSencilla}','${tabuladorPrecios.precioComplejidadRegular}','${tabuladorPrecios.precioComplejidadDificil}','${tabuladorPrecios.tipoPrecio.nombre}');">
                                                        <td>${tabuladorPrecios.idTabuladorPrecios}</td>
                                                        <td>${tabuladorPrecios.maquina.nombre}</td>
                                                        <td>${tabuladorPrecios.nombreInsumo}</td>
                                                        <td>${tabuladorPrecios.descripcion}</td>
                                                        <td>${tabuladorPrecios.inicioTabulador}</td>
                                                        <td>${tabuladorPrecios.finTabulador}</td>
                                                        <td>${tabuladorPrecios.precioComplejidadSencilla}</td>
                                                        <td>${tabuladorPrecios.precioComplejidadRegular}</td>
                                                        <td>${tabuladorPrecios.precioComplejidadDificil}</td>
                                                        <td>${tabuladorPrecios.tipoPrecio.nombre}</td>
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
                                                                       name="id_tabulador_precios" value="" tabindex="1"
                                                                       readonly="readonly"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">M&aacute;quina:</td>
                                                            <td>
                                                                <select name="id_maquina" tabindex="2" onchange="">
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
                                                            <td width="26%">Nombre insumo:</td>
                                                            <td>
                                                                <input type="text" class="input" name="nombre_insumo"
                                                                       value="" tabindex="3"></input>
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
                                                            <td width="1%">Descripci&oacute;n:</td>
                                                            <td>
                                                                <input type="text" class="input" name="descripcion"
                                                                       value="" tabindex="4"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="26%">Inicio:</td>
                                                            <td>
                                                                <input type="text" class="input" name="inicio_tabulador"
                                                                       value="" tabindex="5"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="26%">Fin:</td>
                                                            <td>
                                                                <input type="text" class="input" name="fin_tabulador"
                                                                       value="" tabindex="6"></input>
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
                                                            <td width="60%">Precio C. Sencilla:</td>
                                                            <td>
                                                                <input type="text" class="input" name="precio_complejidad_sencilla" value=""
                                                                       tabindex="7"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="60%">Precio C. Regular:</td>
                                                            <td>
                                                                <input type="text" class="input" name="precio_complejidad_regular" value=""
                                                                       tabindex="8"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        	<div class="columna_derecha">
                                        		<div class="mitad_columna_izquierda">
                                        			<table>
                                        				<tr>
                                        					<td width="56%">Precio C. Dificil:</td>
                                                            <td>
                                                                <input type="text" class="input" name="precio_complejidad_dificil" value=""
                                                                       tabindex="9"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"></input>
                                                            </td>
                                        				</tr>
                                        			</table>
                                        		</div>
                                        		<div class="mitad_columna_derecha">
                                        			<table>
                                        				<tr>
                                        					<td width="1%">Unidad:</td>
                                                            <td>
                                                                <select name="id_tipo_precio" tabindex="10" onchange="">
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