<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" scope="session" />
<c:url value="/?opc=catalogos"	               									var="urlMenu"/>
<c:url value="/tipo_papel_extendido/catalogo/lista_por_pagina_por_parametros" 	var="urlBuscaListaPorParametros"/>
<c:url value="/tipo_papel_extendido/catalogo/alta" 								var="urlAlta"/>
<c:url value="/tipo_papel_extendido/catalogo/modifica" 							var="urlModifica"/>
<c:url value="/tipo_papel_extendido/catalogo/elimina" 							var="urlElimina"/>
<c:url value="/tipo_papel_extendido/catalogo/exporta" 							var="urlExporta"/>
<c:url value="/tipo_papel_extendido/catalogo/ventana" 							var="urlVentanaModal"/>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1"></meta>
        <title>Tipo papel extendido</title>
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
                height: 240px;
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
        <link rel="stylesheet" href="<c:url value="/resources/css/catalogo_tipo_papel_extendido.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/css/paginador.css"/>" type="text/css"></link>
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1_9_1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/utilidades.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/paginador.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/tipo_papel_extendido.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/shadowbox/shadowbox.js"/>"></script>
        <script type="text/javascript">
        	Shadowbox.init({});
        </script>
        <script type="text/javascript">
            var numero_total_registros	        = ${numeroTotalRegistros};
            var numero_registros_por_pagina		= ${numeroRegistrosPorPagina};
            var tamanio_maximo_arreglo	        = ${tamanioMaximoArreglo};	// DEBE SER MAYOR A 2
            var numero_pagina		        	= 1;						// NO DEBE MODIFICARSE
            
            var tamanio_arreglo		        	= 0; 	// se inicializan en carga_datos()
            var numero_pagina_total	        	= 0; 	// se inicializan en carga_datos()
            var mitad_tamanio_arreglo	        = 0;	// se inicializan en carga_datos()
        </script>
        <script type="text/javascript">
        	var urlMenu						= "${urlMenu}";
        	var urlBuscaListaPorParametros	= "${urlBuscaListaPorParametros}";
            var urlAlta 					= "${urlAlta}";
            var urlModifica 				= "${urlModifica}";
            var urlElimina  				= "${urlElimina}";
            var urlExporta					= "${urlExporta}";
            var urlImporta					= "${urlVentanaModal}";
        </script>
        <script type="text/javascript">
	        function regresa_menu() {
	        	location.replace(urlMenu);
	        }
        </script>
    </head>
    <body onload="carga_datos()">
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
	                        <div id="div_tipo_papel_extendido">
	                            <div class="titulo">
	                                <img alt="" src="<c:url value="/resources/image/titulo_tipo_papel_extendido.png"/>"/>
	                            </div>
	                            <div class="linea">
	                            	<div class="casilla">
	                            		<div id="div_paginacion_resultados" style="float:right;"></div>
	                            	</div>
	                            </div>
	                            <div id="div_contenedor_tabla">
	                                <div class="columna_completa">
	                                    <div id="div_tabla_tipo_papel_extendido">
	                                        <table id="tabla_tipo_papel_extendido">
	                                            <tr>
	                                                <th>Id.</th>
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
						<fmt:formatNumber var="formatAncho" value="${tipoPapelExtendido.ancho}" maxFractionDigits="0" />
						<fmt:formatNumber var="formatAlto" value="${tipoPapelExtendido.alto}" maxFractionDigits="0" />
						<tr class='${i.count%2==0?"l2":"l1"}'
	                                                onclick="setCampos('${tipoPapelExtendido.idTipoPapelExtendido}', '${tipoPapelExtendido.razonSocial}', '${tipoPapelExtendido.nombre}', '${tipoPapelExtendido.gramaje}', '${tipoPapelExtendido.kilogramos}','${formatAlto}', '${formatAncho}', '${tipoPapelExtendido.descripcion}', '${tipoPapelExtendido.precio}', '${tipoPapelExtendido.nombrePrecio}');">
	                                                <td>${tipoPapelExtendido.idTipoPapelExtendido}</td>
	                                                <td>${tipoPapelExtendido.razonSocial}</td>
	                                                <td>${tipoPapelExtendido.nombre}</td>
	                                                <td>${tipoPapelExtendido.gramaje}</td>
	                                                <td>${tipoPapelExtendido.kilogramos}</td>
	                                                <td>${formatAlto}</td>
	                                                <td>${formatAncho}</td>
	                                                <td>${tipoPapelExtendido.descripcion}</td>
	                                                <td><fmt:formatNumber pattern="#,##0.00" value="${tipoPapelExtendido.precio}"/></td>
	                                                <td>${tipoPapelExtendido.nombrePrecio}</td>
	                                            </tr>
	                                        </c:forEach>
	                                        </table>
	                                    </div>
	                                </div>
	                            </div>
	                            <br/>
	                            <div class="linea">
	                         	<div class="casilla">
	                         		<div id="div_paginador">
	                         			<ul id="paginacion"></ul>
	                         		</div>
	                         	</div>
	                         </div>
	                         <div class="div_separador_mediano">
	                         	<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
	                         </div>
	                         <div class="titulo">
	                         	<font size="5">CRITERIOS DE B&Uacute;SQUEDA</font>
	                         </div>
	                         <div id="div_formulario_busqueda_cliente">
	                         	<form name="busqueda_tipo_papel_extendido" action="" method="post" accept-charset="ISO-8859-1">
	                         		<!-- campos para uso del paginador -->
	                          	<input type="hidden" name="numero_pagina"               value=""/>
	                          	<input type="hidden" name="numero_registros_por_pagina" value=""/>
	                          	<div class="linea">
	                          		<div class="casilla">
	                          			<div class="columna_izquierda">
	                          				<div class="columna_completa">
	                          					<table>
	                          						<tr>
	                          							<td width="20%">
	                          								<input type="checkbox" name="chkbx_busca_por_nombre"/>
	                          								<span style="cursor:pointer;" onclick="document.busqueda_tipo_papel_extendido.chkbx_busca_por_nombre.click()">Nombre:</span>
	                          							</td>
	                          							<td>
	                          								<input type="text" class="input" name="nombre" value=""
	                          										onkeydown="aceptaIntro(event, 'nueva_busqueda', null)"/>
	                          							</td>
	                          						</tr>
	                          					</table>
	                          				</div>
	                          			</div>
	                          			<div class="columna_derecha">
	                          				<div class="mitad_columna_izquierda">
	                          					<table>
	                          						<tr>
	                          							<td width="45%">
	                          								<input type="checkbox" name="chkbx_busca_por_gramaje"/>
	                          								<span style="cursor:pointer;" onclick="document.busqueda_tipo_papel_extendido.chkbx_busca_por_gramaje.click()">Gramaje:</span>
	                          							</td>
	                          							<td>
	                          								<input type="text" class="input" name="gramaje" value=""
	                          										onkeydown="revisaNumero(false, this.value, event, 'nueva_busqueda', null)"/>
	                          							</td>
	                          						</tr>
	                          					</table>	
	                          				</div>
	                          				<div class="mitad_columna_derecha">
	                          					<table>
	                          						<tr>
	                          							<td width="51%">
	                          								<input type="checkbox" name="chkbx_busca_por_kilogramos"/>
	                          								<span style="cursor:pointer;" onclick="document.busqueda_tipo_papel_extendido.chkbx_busca_por_kilogramos.click()">Kilogramos:</span>
	                          							</td>
	                          							<td>
	                          								<input type="text" class="input" name="kilogramos" value=""
	                          										onkeydown="revisaNumero(true, this.value, event, 'nueva_busqueda', null)"/>
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
	                         								<td width="28%">
	                         									<input type="checkbox" name="chkbx_busca_por_alto"/>
	                         									<span style="cursor:pointer;" onclick="document.busqueda_tipo_papel_extendido.chkbx_busca_por_alto.click()">Alto:</span>
	                         								</td>
	                         								<td>
	                         									<input type="text" class="input" name="alto" 
	                         									onkeydown="revisaNumero(true, this.value, event, 'nueva_busqueda', null)"/>
	                         								</td>
	                         							</tr>
	                         						</table>
	                         					</div>
	                         					<div class="mitad_columna_derecha">
	                         						<table>
	                         							<tr>
	                         								<td width="35%">
	                         									<input type="checkbox" name="chkbx_busca_por_ancho"/>
	                         									<span style="cursor:pointer;" onclick="document.busqueda_tipo_papel_extendido.chkbx_busca_por_ancho.click()">Ancho:</span>
	                         								</td>
	                         								<td>
	                         									<input type="text" class="input" name="ancho" 
	                         									onkeydown="revisaNumero(true, this.value, event, 'nueva_busqueda', null)"/>
	                         								</td>
	                         							</tr>
	                         						</table>
	                         					</div>
	                         				</div>
	                         				<div class="columna_derecha">
	                         					<div class="mitad_columna_izquierda">
	                         						<!-- proveedor -->
	                         						<table>
	                         							<tr>
	                         								<td width="50%">
	                         									<input type="checkbox" name="chkbx_busca_por_proveedor"/>
	                         									<span style="cursor:pointer;" onclick="document.busqueda_tipo_papel_extendido.chkbx_busca_por_proveedor.click()">Proveedor:</span>
	                         								</td>
	                         								<td>
	                         									<select name="id_proveedor_papel" onchange="">
	                                                              <c:forEach var="proveedorPapel" items="${listaProveedorPapel}">
	                                                                  <option value="${proveedorPapel.value}">${proveedorPapel.text}</option>
	                                                              </c:forEach>
	                                                          </select>
	                         								</td>
	                         							</tr>
	                         						</table>
	                         					</div>
	                         				</div>
	                         			</div>
	                         		</div>
	                         		<br/>
	                         		<div class="linea">
	                         			<div class="casilla" style="text-align:right;">
	                         				<img alt="" style="cursor:pointer;" onclick="limpia_form_busqueda_tipo_papel_sobrante()" 
	                         					 src="<c:url value="/resources/image/boton_limpiar.jpg"/>"/>
	                         				<span style="cursor:pointer;" onclick="nueva_busqueda()">&nbsp;Buscar&nbsp;</span>
	                         			</div>
	                         		</div>
	                         	</form>
	                         </div>
	                         <div class="div_separador_mediano">
	                         	<img alt="" src="<c:url value="/resources/image/separador_mediano.jpg"/>"/>
	                         </div>
	                         <form name="tipo_papel_extendido" method="post" accept-charset="ISO-8859-1">
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
	                                                         <input type="text" class="input"
	                                                                name="id_tipo_papel_extendido" value=""
	                                                                readonly="readonly"></input>
	                                                     </td>
	                                                 </tr>
	                                             </table>
	                                         </div>
	                                         <div class="mitad_columna_derecha">
	                                             <table>
	                                                 <tr>
	                                                     <td width="1%">Proveedor:</td>
	                                                     <td>
	                                                         <select name="id_proveedor_papel" onchange="">
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
	                                                         <input type="text" class="input" name="nombre" maxlength="45" value=""/>
	                                                     </td>
	                                                 </tr>
	                                             </table>
	                                         </div>
	                                         <div class="mitad_columna_derecha">
	                                             <table>
	                                                 <tr>
	                                                     <td width="1%">Gramaje:</td>
	                                                     <td>
	                                                         <input type="text" class="input" name="gramaje" maxlength="3" value=""
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
	                                                     <td width="1%">Kilogramos:</td>
	                                                     <td>
	                                                         <input type="text" class="input" name="kilogramos" maxlength="6"
	                                                                value="" onkeydown="revisaNumero(true, this.value, event, null, null)"/>
	                                                     </td>
	                                                 </tr>
	                                             </table>
	                                         </div>
	                                         <div class="mitad_columna_derecha">
	                                         	<table>
	                                             	<tr>
	                                                     <td width="1%">Alto:</td>
	                                                     <td>
	                                                         <input type="text" class="input" name="alto" value="" maxlength="3"
												onkeydown="revisaNumero(true, this.value, event, null, null)"/>
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
	                                                         <input type="text" class="input" name="ancho" value="" maxlength="3"
	                                                         		onkeydown="revisaNumero(true, this.value, event, null, null)"/>
	                                                     </td>
	                                                 </tr>
	                                             </table>
	                                         </div>
	                                         <div class="mitad_columna_derecha">
	                                             <table>
	                                                 <tr>
	                                                     <td width="35%">Descripci&oacute;n:</td>
	                                                     <td>
	                                                         <input type="text" class="input" name="descripcion" maxlength="80" value=""/></input>
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
	                                                         <input type="text" class="input" name="precio" maxlength="10" value="" 
	                                                         		onkeydown="revisaNumero(true, this.value, event, null, null)"/>
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
	                           	</form>
	                            <div class="linea"></div>
	                            <div class="linea">
	                                <div class="casilla" style="text-align:right;">
	                                	<span id="imgBtnExportarPrecios" style="cursor:pointer;" onclick="exportarPrecios()">
	                                		<font color="blue">EXPORTAR PRECIOS</font>
	                                	</span>
	                                	&nbsp;
	                                	<span id="imgBtnImportarPrecios" style="cursor:pointer;" onclick="importarPrecios()">
	                                		<font color="blue">IMPORTAR PRECIOS</font>
	                                	</span>
	                                	&nbsp;
	                                    <img alt="" style="cursor:pointer;" onclick="limpia_form_tipo_papel_extendido();"
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