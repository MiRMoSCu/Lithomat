<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/?opc=seguridad"	var="urlMenu"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Perfil</title>
        <style type="text/css" media="screen">
        
            table#tabla_perfil {
                overflow-y:scroll;
            }
        
            table#tabla_perfil tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_perfil {
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
            
            #div_tabla_perfil {
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
        <script type="text/javascript" src="<c:url value="/resources/js/perfil.js"/>"></script>
        <script type="text/javascript">
        	var urlMenu		= "${urlMenu}";
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
                            <form action="perfil" method="post" accept-charset="ISO-8859-1">
                                <div id="div_perfil">
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_perfil.png"/>"/>PERFIL
                                    </div>
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_perfil">
                                                <table id="tabla_perfil">
                                                    <tr>
                                                        <th>Identificador</th>
                                                        <th>Nombre</th>
                                                        <th>Descripci&oacute;n</th>
                                                    </tr>
                                                <c:forEach var="perfil" items="${listaPerfil}" varStatus="i">
                                                    <tr class='${i.count%2==0?"l2":"l1"}'
                                                        onclick="setCampos( '${perfil.idPerfil}', '${perfil.nombre}', '${perfil.descripcion}');">
                                                        <td>${perfil.idPerfil}</td>
                                                        <td>${perfil.nombre}</td>
                                                        <td>${perfil.descripcion}</td>
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
                                                                <input type="text" class="input" name="id_perfil"
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
                                                                <input type="text" class="input" name="nombre" maxlength="45" value=""/>
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
                                                                <input type="text" class="input" name="descripcion" maxlength="80"
                                                                       value=""/>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="linea"></div>
                                    
                                    <div class="linea">
                                        <!-- 
                                            Los estados de la aplicacion no pueden modificarse porque
                                            la aplicacion depende de ellos en el código.
                                            CalificacionServiceImpl
                                        -->
                                        <!-- 
                                        <div class="casilla" style="text-align:right;">
                                            <img alt="" style="cursor:pointer;" onclick="limpia();"
                                                 src="resources/image/boton_limpiar.jpg"/>
                                             
                                            <img alt="" style="cursor:pointer;" onclick="elimina();"
                                                 src="resources/image/boton_eliminar.jpg"/>
                                             
                                            <img alt="" style="cursor:pointer;" onclick="modifica();"
                                                 src="resources/image/boton_modificar.jpg"/>
                                             
                                            <img alt="" style="cursor:pointer;" onclick="crear();"
                                                 src="resources/image/boton_agregar.jpg"/>
                                        </div>
                                        -->
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