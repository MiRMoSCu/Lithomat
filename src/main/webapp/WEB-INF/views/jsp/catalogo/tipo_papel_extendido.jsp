<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/?opc=catalogos"	               			var="urlMenu"/>
<c:url value="/tipo_papel_extendido/catalogo/alta" 		var="urlAlta"/>
<c:url value="/tipo_papel_extendido/catalogo/modifica" 	var="urlModifica"/>
<c:url value="/tipo_papel_extendido/catalogo/elimina" 	var="urlElimina"/>
<c:url value="/tipo_papel_extendido/catalogo/exporta" 	var="urlExporta"/>
<c:url value="/tipo_papel_extendido/catalogo/ventana" 	var="urlVentanaModal"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Tipo de papel extendido</title>
        <style type="text/css" media="screen">
        
            table#tabla_tipo_papel_extendido {
                overflow-y:scroll;
            }
            
            table#tabla_tipo_papel_extendido tr:hover td  {
                cursor: pointer;
                color:#000;
                background-color: #99CCFF;
            }
            
            #div_tipo_papel_extendido {
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
            
            #div_tabla_tipo_papel_extendido {
                width: 100%;
                height: 100%;
                overflow-x: scroll;
            }
        
        </style>
        
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/font.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/catalogo.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/tipo_papel_extendido.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/shadowbox/shadowbox.js"/>"></script>
        <script type="text/javascript">
        	Shadowbox.init({});
        </script>
        <script type="text/javascript">
        	var urlMenu		= "${urlMenu}";
            var urlAlta     = "${urlAlta}";
            var urlModifica = "${urlModifica}";
            var urlElimina  = "${urlElimina}";
            var urlExporta	= "${urlExporta}";
        </script>
        <script type="text/javascript">
	        function regresa_menu() {
	        	location.replace(urlMenu);
	        }
        </script>
        <script type="text/javascript">
        	
        	function exportarPrecios() {
        		location.href = urlExporta;
        	}
        	
        	function importarPrecios() {
        		//alert("");
        		var url = "${urlVentanaModal}"; 
        		Shadowbox.open({
        			content:url,
        			player:"iframe",
        			width:630, 
        			height:305
        		});
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
                            <form action="tipo_papel_extendido" method="post" accept-charset="ISO-8859-1">
                                <div id="div_tipo_papel_extendido">
                                    <div class="titulo">
                                        <img alt="" src="<c:url value="/resources/image/titulo_tipo_papel_extendido.png"/>"></img>
                                    </div>
                                    <div id="div_contenedor_tabla">
                                        <div class="columna_completa">
                                            <div id="div_tabla_tipo_papel_extendido">
                                                <table id="tabla_tipo_papel_extendido">
                                                    <tr>
                                                        <th>Identificador</th>
                                                        <th>Proveedor</th>
                                                        <th>Nombre</th>
                                                        <th>Gramaje</th>
                                                        <th>Kilogramos</th>
                                                        <th>Alto</th>
                                                        <th>Ancho</th>
                                                        <th>Descripci&oacute;n</th>
                                                        <th>Precio</th>
                                                        <th>Unidad</th>
                                                    </tr>
                                                <c:forEach var="tipoPapelExtendido" items="${listaTipoPapelExtendido}" varStatus="i">
                                                    <tr class='${i.count%2==0?"l2":"l1"}'
                                                        onclick="setCampos('${tipoPapelExtendido.idTipoPapelExtendido}', '${tipoPapelExtendido.proveedorPapel.razonSocial}', '${tipoPapelExtendido.nombre}', '${tipoPapelExtendido.gramaje}', '${tipoPapelExtendido.kilogramos}', '${tipoPapelExtendido.alto}', '${tipoPapelExtendido.ancho}', '${tipoPapelExtendido.descripcion}', '${tipoPapelExtendido.precio}', '${tipoPapelExtendido.tipoPrecio.nombre}');">
                                                        <td>${tipoPapelExtendido.idTipoPapelExtendido}</td>
                                                        <td>${tipoPapelExtendido.proveedorPapel.razonSocial}</td>
                                                        <td>${tipoPapelExtendido.nombre}</td>
                                                        <td>${tipoPapelExtendido.gramaje}</td>
                                                        <td>${tipoPapelExtendido.kilogramos}</td>
                                                        <td>${tipoPapelExtendido.alto}</td>
                                                        <td>${tipoPapelExtendido.ancho}</td>
                                                        <td>${tipoPapelExtendido.descripcion}</td>
                                                        <td>${tipoPapelExtendido.precio}</td>
                                                        <td>${tipoPapelExtendido.tipoPrecio.nombre}</td>
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
                                                                       name="id_tipo_papel_extendido" value=""
                                                                       tabindex="1" readonly="readonly"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Proveedor:</td>
                                                            <td>
                                                                <select name="id_proveedor_papel" tabindex="2" onchange="">
                                                                    <c:forEach var="proveedorPapel" items="${listaProveedorPapel}">
                                                                        <option value="${proveedorPapel.value}">${proveedorPapel.text}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="columna_derecha">
                                                <div class="mitad_columna_izquierda">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Nombre:</td>
                                                            <td>
                                                                <input type="text" class="input" name="nombre" value=""
                                                                       tabindex="3"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="1%">Gramaje:</td>
                                                            <td>
                                                                <input type="text" class="input" name="gramaje" value=""
                                                                       tabindex="4"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))) return false;"
                                                                       ></input>
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
                                                            <td width="1%">Kilogramos:</td>
                                                            <td>
                                                                <input type="text" class="input" name="kilogramos"
                                                                       value="" tabindex="5"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                    	<tr>
                                                            <td width="1%">Alto:</td>
                                                            <td>
                                                                <input type="text" class="input" name="alto" value=""
                                                                       tabindex="7"
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
                                                            <td width="1%">Ancho:</td>
                                                            <td>
                                                                <input type="text" class="input" name="ancho" value=""
                                                                       tabindex="6"
                                                                       onkeypress="if(isNaN(String.fromCharCode(event.keyCode))){if(event.keyCode==46){return true;}return false;}"></input>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <div class="mitad_columna_derecha">
                                                    <table>
                                                        <tr>
                                                            <td width="35%">Descripci&oacute;n:</td>
                                                            <td>
                                                                <input type="text" class="input" name="descripcion"
                                                                       value="" tabindex="8"></input>
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
                                        	<span id="imgBtnExportarPrecios" style="cursor:pointer;" onclick="exportarPrecios()">
                                        		<font color="blue">EXPORTAR PRECIOS</font>
                                        	</span>
                                        	
                                        	<span id="imgBtnImportarPrecios" style="cursor:pointer;" onclick="importarPrecios()">
                                        		<font color="blue">IMPORTAR PRECIOS</font>
                                        	</span>
                                        
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