<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/?opc=seguridad"	            var="urlMenu"/>
<c:url value="/usuario/catalogo/alta" 		var="urlAlta"/>
<c:url value="/usuario/catalogo/modifica" 	var="urlModifica"/>
<c:url value="/usuario/catalogo/elimina" 	var="urlElimina"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Usuario</title>
        <style type="text/css" media="screen">
        
            table#tabla_usuario {
                overflow-y:scroll;
            }
        
            table#tabla_usuario tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_usuario {
                width: 865px;
                margin-left: auto;
                margin-right: auto;
                background: transparent; /*green*/
                display: block;                
            }
            
            #div_contenedor_tabla {
                width: 100%;
                height: 220px;
            }
            
            #div_tabla_usuario {
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
        <script type="text/javascript" src="<c:url value="/resources/js/usuario.js"/>"></script>
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
                            <form action="usuario" method="post" accept-charset="ISO-8859-1">
                                <div id="div_usuario">
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_usuario.png"/>"></img>Usuario
                                    </div>
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_usuario">
                                                <table id="tabla_usuario">
                                                    <tr>
                                                        <th>Identificador</th>
                                                        <th>Nombre</th>
                                                        <th>Ap. Paterno</th>
                                                        <th>Ap. Materno</th>
                                                        <th>Usuario</th>
                                                        <th>Contrasenia</th>
                                                    </tr>
                                                <c:forEach var="usuario" items="${listaUsuario}" varStatus="i">
                                                    <tr class='${i.count%2==0?"l2":"l1"}'
                                                        onclick="setCampos('${usuario.idUsuario}','${usuario.nombre}', '${usuario.apPaterno}', '${usuario.apMaterno}','${usuario.usuario}', '${usuario.contrasenia}' );">
                                                        <td>${usuario.idUsuario}</td>
                                                        <td>${usuario.nombre}</td>
                                                        <td>${usuario.apPaterno}</td>
                                                        <td>${usuario.apMaterno}</td>
                                                        <td>${usuario.usuario}</td>
                                                        <td>${usuario.contrasenia}</td>
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
                                                                <input type="text" class="input" name="id_usuario"
                                                                       value="" tabindex="1" readonly="readonly"></input>
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
                                                                <input type="text" class="input" name="nombre"
                                                                       value="" tabindex="2"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                            	<div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="42%">Ap. Paterno:</td>
                                                            <td>
                                                                <input  type="text" class="input" name="ap_paterno" 
                                                                        value="" tabindex="3"/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="42%">Ap. Materno:</td>
                                                            <td>
                                                                <input type="text" class="input" name="ap_materno"
                                                                       value="" tabindex="4"></input>
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
                                                            <td width="1%">Usuario:</td>
                                                            <td>
                                                                <input type="text" class="input" name="usuario" value=""
                                                                       tabindex="5"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Contraseña:</td>
                                                            <td>
                                                            	<input type="text" class="input" name="contrasenia"
                                                                       value="" tabindex="6"></input>
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