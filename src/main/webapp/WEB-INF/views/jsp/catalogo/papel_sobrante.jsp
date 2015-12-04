<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/?opc=catalogos"	               		var="urlMenu"/>
<c:url value="/papel_sobrante/catalogo/alta"     	var="urlAlta"/>
<c:url value="/papel_sobrante/catalogo/modifica" 	var="urlModifica"/>
<c:url value="/papel_sobrante/catalogo/elimina" 	var="urlElimina"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Cliente</title>
        <style type="text/css" media="screen">
        
            table#tabla_papel_sobrante {
                overflow-y:scroll;
            }
            
            table#tabla_papel_sobrante tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_papel_sobrante {
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
            
            #div_tabla_papel_sobrante {
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
        <script type="text/javascript" src="<c:url value="/resources/js/papel_sobrante.js"/>"></script>
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
                            <form action="" method="post" accept-charset="ISO-8859-1">
                                <div id="div_papel_sobrante">
                                    <div class="titulo">
                                    	<img alt="" src="<c:url value="/resources/image/titulo_papel_sobrante.png"/>"/>PAPEL SOBRANTE
                                    </div>
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_papel_sobrante">
                                                <table id="tabla_papel_sobrante">
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Tab inicio</th>
                                                        <th>Tab fin</th>
                                                        <th>No. tinta frente</th>
                                                        <th>No. tinta vuelta</th>
                                                        <th>Tiene tinta especial</th>
                                                        <th>Hojas sobrante</th>
                                                    </tr>
                                                <c:forEach var="papelSobrante" items="${listaPapelSobrante}" varStatus="i">
                                                    <tr class='${i.count%2==0?"l2":"l1"}' 
                                                        onclick="setCampos('${papelSobrante.idPapelSobrante}','${papelSobrante.inicioTabulador}','${papelSobrante.finTabulador}','${papelSobrante.frenteNumTinta}','${papelSobrante.vueltaNumTinta}','${papelSobrante.tintaEspecial}','${papelSobrante.hojasSobrante}');">
                                                        <td>${papelSobrante.idPapelSobrante}</td>
                                                        <td>${papelSobrante.inicioTabulador}</td>
                                                        <td>${papelSobrante.finTabulador}</td>
                                                        <td>${papelSobrante.frenteNumTinta}</td>
                                                        <td>${papelSobrante.vueltaNumTinta}</td>
                                                        <td>${papelSobrante.tintaEspecial}</td>
                                                        <td>${papelSobrante.hojasSobrante}</td>
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
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="id_papel_sobrante" 
                                                                        value=""
                                                                        readonly="readonly"/>
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
                                                            <td width="34%">Tab inicio:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="inicio_tabulador"
                                                                        value=""
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="26%">Tab fin:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="fin_tabulador"
                                                                        value=""
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="51%">No. tinta frente:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="num_tinta_frente"
                                                                        value=""
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="51%">No. tinta vuelta:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="num_tinta_vuelta"
                                                                        value=""
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
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
                                                            <td width="35%">¿Tiene tinta especial?</td>
                                                            <td>
                                                                <table>
                                                                    <tr>
                                                                        <td width="1%">
                                                                            <input  type="radio"
                                                                                    name="tinta_especial"
                                                                                    value="true"/>S&iacute;
                                                                        </td>
                                                                        <td width="1%">
                                                                            <input  type="radio"
                                                                                    name="tinta_especial"
                                                                                    value="false"
                                                                                    checked/>No
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="52%">Hojas sobrante:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="hojas_sobrante"
                                                                        value=""
                                                                        onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"/>
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

