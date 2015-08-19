<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/?opc=catalogos"	            var="urlMenu"/>
<c:url value="/cliente/catalogo/alta"       var="urlAlta"/>
<c:url value="/cliente/catalogo/modifica"   var="urlModifica"/>
<c:url value="/cliente/catalogo/elimina"    var="urlElimina"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Clientes</title>
        <style type="text/css" media="screen">
        
            table#tabla_cliente {
                overflow-y:scroll;
            }
            
            table#tabla_cliente tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_cliente {
                width: 865px;
                margin-left: auto;
                margin-right: auto;
                background: transparent; /*green*/
                display: block;
            }
            
            #div_contenedor_tabla {
                width: 100%;
                height: 210px;
            }
            
            #div_tabla_cliente {
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
        <script type="text/javascript" src="<c:url value="/resources/js/cliente.js"/>"></script>
        <script type="text/javascript">
        	var urlMenu		= "${urlMenu}";
            var urlAlta 	= '${urlAlta}';
            var urlModifica = '${urlModifica}';
            var urlElimina 	= '${urlElimina}';
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
                            <form action="cliente" method="post" accept-charset="ISO-8859-1">
                                <div id="div_cliente">
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_cliente.png"/>"></img>
                                    </div>
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_cliente">
                                                <table id="tabla_cliente">
                                                    <tr>
                                                        <th>Identificador</th>
                                                        <th>Clave</th>
                                                        <th>Nombre</th>
                                                        <th>Representante</th>
                                                        <th>Puesto</th>
                                                        <th>Calle</th>
                                                        <th>No. Ext</th>
                                                        <th>No. Int</th>
                                                        <th>Colonia</th>
                                                        <th>Delegaci&oacute;n</th>
                                                        <th>Estado</th>
                                                        <th>C.P.</th>
                                                        <th>Pa&iacute;s</th>
                                                        <th>RFC</th>
                                                        <th>Tel&eacute;fono</th>
                                                        <th>M&oacute;vil</th>
                                                        <th>Email</th>
                                                        <th>Observaciones</th>
                                                    </tr>
                                                <c:forEach var="cliente" items="${listaCliente}" varStatus="i">
                                                    <tr class='${i.count%2==0?"l2":"l1"}' 
                                                        onclick="setCampos('${cliente.idCliente}','${cliente.tipoCliente.clave}','${cliente.nombreMoral}','${cliente.nombreRepresentante}','${cliente.puesto}','${cliente.calle}','${cliente.numExterior}','${cliente.numInterior}','${cliente.colonia}','${cliente.delegacionMunicipio}','${cliente.estado}','${cliente.codigoPostal}','${cliente.pais}','${cliente.rfc}','${cliente.telefonoParticular}','${cliente.telefonoMovil}','${cliente.email}','${cliente.observaciones}');">
                                                        <td>${cliente.idCliente}</td>
                                                        <td>${cliente.tipoCliente.clave}</td>
                                                        <td>${cliente.nombreMoral}</td>
                                                        <td>${cliente.nombreRepresentante}</td>
                                                        <td>${cliente.puesto}</td>
                                                        <td>${cliente.calle}</td>
                                                        <td>${cliente.numExterior}</td>
                                                        <td>${cliente.numInterior}</td>
                                                        <td>${cliente.colonia}</td>
                                                        <td>${cliente.delegacionMunicipio}</td>
                                                        <td>${cliente.estado}</td>
                                                        <td>${cliente.codigoPostal}</td>
                                                        <td>${cliente.pais}</td>
                                                        <td>${cliente.rfc}</td>
                                                        <td>${cliente.telefonoParticular}</td>
                                                        <td>${cliente.telefonoMovil}</td>
                                                        <td>${cliente.email}</td>
                                                        <td>${cliente.observaciones}</td>
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
                                                            <td width="1%">Identificador:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="id_cliente"
                                                                        value="" 
                                                                        tabindex="1" 
                                                                        readonly="readonly">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Clave:</td>
                                                            <td>
                                                                <select name="id_tipo_cliente" tabindex="2" onchange="">
                                                                    <c:forEach var="tipoCliente" items="${listaTipoCliente}">
                                                                        <option value="${tipoCliente.value}">${tipoCliente.text}</option>
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
                                                            <td width="1%">Nombre:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="nombre_moral" 
                                                                        value=""
                                                                        tabindex="3">
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
                                                            <td width="1%">Representante:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="nombre_representante"
                                                                        value="" 
                                                                        tabindex="4">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="columna_completa">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Puesto:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="puesto"
                                                                        value=""
                                                                        tabindex="5">
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
                                                            <td width="1%">Calle:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="calle" 
                                                                        value=""
                                                                        tabindex="6">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="27%">No. Ext:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="num_exterior" 
                                                                        value=""
                                                                        tabindex="7">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="25%">No. Int:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="num_interior" 
                                                                        value=""
                                                                        tabindex="8">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Colonia:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="colonia" 
                                                                        value=""
                                                                        tabindex="9">
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
                                                            <td width="1%">Delegaci&oacute;n:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="delegacion_municipio" 
                                                                        value=""
                                                                        tabindex="10">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Estado:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="estado" 
                                                                        value=""
                                                                        tabindex="11">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">C.P.:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="codigo_postal" 
                                                                        value=""
                                                                        tabindex="12">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Pa&iacute;s:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="pais"
                                                                        value=""
                                                                        tabindex="13">
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
                                                            <td width="1%">RFC:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="rfc" 
                                                                        value=""
                                                                        tabindex="14">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Tel&eacute;fono:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="telefono_particular"
                                                                        value=""
                                                                        tabindex="15">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">M&oacute;vil:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="telefono_movil"
                                                                        value=""
                                                                        tabindex="16">
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Email:</td>
                                                            <td>
                                                                <input  type="text"
                                                                        class="input"
                                                                        name="email"
                                                                        value=""
                                                                        tabindex="17">
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
                                                            <td width="1%">Observaciones:</td>
                                                            <td>
                                                                <input  type="text" 
                                                                        class="input" 
                                                                        name="observaciones" 
                                                                        value=""
                                                                        tabindex="18">
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