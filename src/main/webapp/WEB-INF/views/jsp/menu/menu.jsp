<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!-- PRODUCCION -->
<c:url value="/orden_produccion/" 						var="urlOrdenProduccion" />
<c:url value="/visualizador/" 							var="urlVisualizador" />
<!-- REPORTES -->
<c:url value="/reporte/ventana_orden_produccion" 		var="urlVentanaOrdenProduccion" />
<c:url value="/reporte/ventana_cotizacion" 				var="urlVentanaCotizacion" />
<c:url value="/reporte/ventana_nota_remision_factura" 	var="urlVentanaNotaRemisionFactura" />
<c:url value="/reporte/ventana_cola_impresion" 			var="urlVentanaColaImpresion" />
<!-- CATALOGOS -->
<c:url value="/cliente/catalogo/lista" 					var="urlCliente" />
<c:url value="/combinacion_tintas/catalogo/lista" 		var="urlCombinacionTintas" />
<c:url value="/costo_extra/catalogo/lista" 				var="urlCostoExtra" />
<c:url value="/estatus_orden/catalogo/lista" 			var="urlEstatusOrden" />
<c:url value="/maquina/catalogo/lista" 					var="urlMaquina" />
<c:url value="/material_ayuda/catalogo/lista" 			var="urlMaterialAyuda" />
<c:url value="/papel_sobrante/catalogo/lista" 			var="urlPapelSobrante" />
<c:url value="/prensista/catalogo/lista" 				var="urlPrensista" />
<c:url value="/proceso_disenio/catalogo/lista" 			var="urlProcesoDisenio" />
<c:url value="/proceso_externo/catalogo/lista" 			var="urlProcesoExterno" />
<c:url value="/proceso_preprensa/catalogo/lista" 		var="urlProcesoPreprensa" />
<c:url value="/proceso_transporte/catalogo/lista" 		var="urlProcesoTransporte" />
<c:url value="/proveedor_externo/catalogo/lista" 		var="urlProveedorExterno" />
<c:url value="/proveedor_papel/catalogo/lista" 			var="urlProveedorPapel" />
<c:url value="/responsable_insumo/catalogo/lista" 		var="urlResponsableInsumo" />
<c:url value="/tabulador_precios/catalogo/lista" 		var="urlTabuladorPrecios" />
<c:url value="/tamanio_publicacion/catalogo/lista" 		var="urlTamanioPublicacion" />
<c:url value="/tinta_especial/catalogo/lista" 			var="urlTintaEspecial" />
<c:url value="/tipo_barniz/catalogo/lista" 				var="urlTipoBarniz" />
<c:url value="/tipo_cliente/catalogo/lista" 			var="urlTipoCliente" />
<c:url value="/tipo_complejidad/catalogo/lista" 		var="urlTipoComplejidad" />
<c:url value="/tipo_comprobante_fiscal/catalogo/lista" 	var="urlTipoComprobanteFiscal" />
<c:url value="/tipo_forma_trabajo/catalogo/lista" 		var="urlTipoFormaTrabajo" />
<c:url value="/tipo_papel_extendido/catalogo/lista" 	var="urlTipoPapelExtendido" />
<c:url value="/tipo_placa/catalogo/lista" 				var="urlTipoPlaca" />
<c:url value="/tipo_precio/catalogo/lista" 				var="urlTipoPrecio" />
<c:url value="/tipo_trabajo/catalogo/lista" 			var="urlTipoTrabajo" />
<c:url value="/turno_laboral/catalogo/lista" 			var="urlTurnoLaboral" />
<c:url value="/tipo_vuelta/catalogo/lista" 				var="urlTipoVuelta" />
<!-- SEGURIDAD -->
<c:url value="/perfil/catalogo/lista" 					var="urlPerfil" />
<c:url value="/perfil_x_usuario/catalogo/lista" 		var="urlPerfilXUsuario" />
<c:url value="/usuario/catalogo/lista" 					var="urlUsuario" />
<!-- CERRAR SESION -->
<c:url value="/j_spring_security_logout" 				var="urlSalir" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/master.css"/>" 			type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/menu_inicio.css"/>" 		type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/pagina_menu.css"/>" 		type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/resources/shadowbox/shadowbox.css"/>" 	type="text/css"></link>
        <script type="text/javascript" src="<c:url value="/resources/shadowbox/shadowbox.js"/>"></script>
        <script type="text/javascript">
	     	// inicializacion shadowbox
	        Shadowbox.init({});
        </script>
        <script type="text/javascript">
        	var urlOrdenProduccion 				= '${urlOrdenProduccion}';	
        	var urlVisualizador					= '${urlVisualizador}';
        // ***
        	var urlVentanaOrdenProduccion		= '${urlVentanaOrdenProduccion}';
        	var urlVentanaCotizacion			= '${urlVentanaCotizacion}';
        	var urlVentanaNotaRemisionFactura	= '${urlVentanaNotaRemisionFactura}';
        	var urlVentanaColaImpresion			= '${urlVentanaColaImpresion}';
        // ***
            var urlCliente						= '${urlCliente}';
            var urlCombinacionTintas			= '${urlCombinacionTintas}';
            var urlCostoExtra					= '${urlCostoExtra}';
            var urlEstatusOrden					= '${urlEstatusOrden}';
            var urlMaquina						= '${urlMaquina}';
            var urlMaterialAyuda				= '${urlMaterialAyuda}';
            var urlPapelSobrante				= '${urlPapelSobrante}';
            var urlPrensista					= '${urlPrensista}';
            var urlProcesoDisenio				= '${urlProcesoDisenio}';
            var urlProcesoExterno				= '${urlProcesoExterno}';
            var urlProcesoPreprensa				= '${urlProcesoPreprensa}';
            var urlProcesoTransporte			= '${urlProcesoTransporte}';
            var urlProveedorExterno				= '${urlProveedorExterno}';
            var urlProveedorPapel				= '${urlProveedorPapel}';
            var urlResponsableInsumo			= '${urlResponsableInsumo}';
            var urlTabuladorPrecios				= '${urlTabuladorPrecios}';
            var urlTamanioPublicacion			= '${urlTamanioPublicacion}';
            var urlTintaEspecial				= '${urlTintaEspecial}';
            var urlTipoBarniz					= '${urlTipoBarniz}';
            var urlTipoCliente					= '${urlTipoCliente}';
            var urlTipoComplejidad				= '${urlTipoComplejidad}';
            var urlTipoComprobanteFiscal		= '${urlTipoComprobanteFiscal}';
            var urlTipoFormaTrabajo				= '${urlTipoFormaTrabajo}';
            var urlTipoPapelExtendido			= '${urlTipoPapelExtendido}';
            var urlTipoPlaca					= '${urlTipoPlaca}';
            var urlTipoPrecio					= '${urlTipoPrecio}';
            var urlTipoTrabajo					= '${urlTipoTrabajo}';
            var urlTurnoLaboral					= '${urlTurnoLaboral}';
            var urlTipoVuelta					= '${urlTipoVuelta}';
         // ***
            var urlPerfil						= '${urlPerfil}';
            var urlPerfilXUsuario				= '${urlPerfilXUsuario}';
            var urlUsuario						= '${urlUsuario}';
         // ***
            var urlSalir						= '${urlSalir}';
            
            function menu_principal( opcion_principal ) {
            	switch( opcion_principal ) {
            		case 'produccion':
            			document.getElementById("div_pestania_reportes").style.display 		= "none";
            			document.getElementById("div_pestania_catalogos").style.display 	= "none";
            			document.getElementById("div_pestania_seguridad").style.display 	= "none";
            			document.getElementById("div_pestania_produccion").style.display 	= "block";
            			break;
            		case 'reportes':
            			document.getElementById("div_pestania_catalogos").style.display 	= "none";
            			document.getElementById("div_pestania_seguridad").style.display 	= "none";
            			document.getElementById("div_pestania_produccion").style.display 	= "none";
            			document.getElementById("div_pestania_reportes").style.display 		= "block";
            			break;
            		case 'catalogos':
            			document.getElementById("div_pestania_seguridad").style.display 	= "none";
            			document.getElementById("div_pestania_produccion").style.display 	= "none";
            			document.getElementById("div_pestania_reportes").style.display 		= "none";
            			document.getElementById("div_pestania_catalogos").style.display 	= "block";
            			break;
            		case 'seguridad':
            			document.getElementById("div_pestania_produccion").style.display 	= "none";
            			document.getElementById("div_pestania_reportes").style.display 		= "none";
            			document.getElementById("div_pestania_catalogos").style.display 	= "none";
            			document.getElementById("div_pestania_seguridad").style.display 	= "block";
            			break;
            		default:
            			//alert("error");
            			break;
            	}
            }
            
            function menu( opcion ) {
                switch( opcion ) {
	                case 'visualizador':
	                	document.forms["opcion_menu"].action = urlVisualizador;
	                	document.forms["opcion_menu"].method = "post";
	                	document.forms[0].submit();
	                	break;
                    case 'orden_produccion':
                        document.forms["opcion_menu"].action = urlOrdenProduccion;
                        document.forms["opcion_menu"].method = "post";
                        document.forms[0].submit();
                        break;
                // *******************
                    case 'ventana_reporte_orden_produccion':
                    	Shadowbox.open({
                    		content:urlVentanaOrdenProduccion,
                    		player:'iframe',
                    		width:600,
                    		height:300,
                    		options:{
                    			modal:true,
                    			overlayOpacity:0.75
                    		}
                    	});
                    	break;
                    case 'ventana_reporte_cotizacion':
                    	Shadowbox.open({
                    		content:urlVentanaCotizacion,
                    		player:'iframe',
                    		width:800,
                    		height:550,
                    		options:{
                    			modal:true,
                    			overlayOpacity:0.75
                    		}
                    	});
                    	break;
                    case 'ventana_reporte_nota_remision':
                    	Shadowbox.open({
                    		content:urlVentanaNotaRemisionFactura,
                    		player:'iframe',
                    		width:600,
                    		height:300,
                    		options:{
                    			modal:true,
                    			overlayOpacity:0.75
                    		}
                    	});
                    	break;
                    case 'ventana_reporte_cola_impresion':
                    	Shadowbox.open({
                    		content:urlVentanaColaImpresion,
                    		player:'iframe',
                    		width:600,
                    		height:280,
                    		options:{
                    			modal:true,
                    			overlayOpacity:0.75
                    		}
                    	});
                    	break;
                // *******************
                    case 'cliente':
                    	document.forms["opcion_menu"].action = urlCliente;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'combinacion_tintas':
                    	document.forms["opcion_menu"].action = urlCombinacionTintas;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'costo_extra':
                    	document.forms["opcion_menu"].action = urlCostoExtra;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'estatus_orden':
                    	document.forms["opcion_menu"].action = urlEstatusOrden;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'maquina':
                    	document.forms["opcion_menu"].action = urlMaquina;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'material_ayuda':
                    	document.forms["opcion_menu"].action = urlMaterialAyuda;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'papel_sobrante':
                    	document.forms["opcion_menu"].action = urlPapelSobrante;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'prensista':
                    	document.forms["opcion_menu"].action = urlPrensista;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'proceso_disenio':
                    	document.forms["opcion_menu"].action = urlProcesoDisenio;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'proceso_externo':
                    	document.forms["opcion_menu"].action = urlProcesoExterno;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'proceso_preprensa':
                    	document.forms["opcion_menu"].action = urlProcesoPreprensa;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'proceso_transporte':
                    	document.forms["opcion_menu"].action = urlProcesoTransporte;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'proveedor_externo':
                    	document.forms["opcion_menu"].action = urlProveedorExterno;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'proveedor_papel':
                    	document.forms["opcion_menu"].action = urlProveedorPapel;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'responsable_insumo':
                    	document.forms["opcion_menu"].action = urlResponsableInsumo;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tabulador_precios':
                    	document.forms["opcion_menu"].action = urlTabuladorPrecios;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tamanio_publicacion':
                    	document.forms["opcion_menu"].action = urlTamanioPublicacion;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tinta_especial':
                    	document.forms["opcion_menu"].action = urlTintaEspecial;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tipo_barniz':
                    	document.forms["opcion_menu"].action = urlTipoBarniz;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tipo_cliente':
                    	document.forms["opcion_menu"].action = urlTipoCliente;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tipo_complejidad':
                    	document.forms["opcion_menu"].action = urlTipoComplejidad;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tipo_comprobante_fiscal':
                    	document.forms["opcion_menu"].action = urlTipoComprobanteFiscal;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tipo_forma_trabajo':
                    	document.forms["opcion_menu"].action = urlTipoFormaTrabajo;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tipo_papel_extendido':
                    	document.forms["opcion_menu"].action = urlTipoPapelExtendido;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tipo_placa':
                    	document.forms["opcion_menu"].action = urlTipoPlaca;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tipo_precio':
                    	document.forms["opcion_menu"].action = urlTipoPrecio;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tipo_trabajo':
                    	document.forms["opcion_menu"].action = urlTipoTrabajo;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'turno_laboral':
                    	document.forms["opcion_menu"].action = urlTurnoLaboral;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'tipo_vuelta':
                    	document.forms["opcion_menu"].action = urlTipoVuelta;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                // *******************
                    case 'perfil':
                    	document.forms["opcion_menu"].action = urlPerfil;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'perfil_x_usuario':
                    	document.forms["opcion_menu"].action = urlPerfilXUsuario;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    case 'usuario':
                    	document.forms["opcion_menu"].action = urlUsuario;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                // *******************
                    case 'salir':
                    	document.forms["opcion_menu"].action = urlSalir;
                    	document.forms["opcion_menu"].method = "post";
                    	document.forms[0].submit();
                    	break;
                    default:
                    	alert("error en url");
                        break;
                }
            }
            
            function revisaParametroMenu() {
            	var opcion = location.search.split("opc=")[1] ? location.search.split("opc=")[1] : "produccion";
            	menu_principal(opcion);
            }
            
        </script>
    </head>
    <body onload="revisaParametroMenu()">
    	<div id="div_area">
            <div id="div_ancho">
                <div id="div_hoja">
                    <div id="div_cabecera">
                        <div id="div_logo">
                            <img alt="" src="<c:url value="/resources/image/logo.png"/>">
                        </div>
                        <div id="div_encabezado">
                            <img alt="" src="<c:url value="/resources/image/encabezado_menu.png"/>">
                        </div>
                    </div>
                    <div id="div_cuerpo">
                        <div id="div_menu">
                        	<div class="div_menu_inicio">
                        		<div class="div_submenu_inicio">
                        			<img alt="Producci&oacute;n" src="<c:url value="/resources/image/menu_inicio_produccion.png"/>" title="Producci&oacute;n" onclick="menu_principal('produccion')">
                        		</div>
                        		<div class="div_submenu_inicio">
                        			<img alt="Reportes" src="<c:url value="/resources/image/menu_inicio_reportes.png"/>" title="Reportes" onclick="menu_principal('reportes')">
                        		</div>
                        		<div class="div_submenu_inicio">
                        			<img alt="Cat&aacute;logos" src="<c:url value="/resources/image/menu_inicio_catalogos.png"/>" title="Cat&aacute;logos" onclick="menu_principal('catalogos')">
                        		</div>
                        		<div class="div_submenu_inicio">
                        			<img alt="Seguridad" src="<c:url value="/resources/image/menu_inicio_seguridad.png"/>" title="Seguridad" onclick="menu_principal('seguridad')">
                        		</div>
                        		<div class="div_submenu_inicio_cerrar_sesion">
                        			<img alt="" src="<c:url value="/resources/image/boton_cerrar.jpg"/>" onclick="menu('salir');">
                        		</div>
                        	</div>
                            <div id="div_cerrar_sesion">
                                
                            </div>
                        </div>
                        <div id="div_contenido">
                            <div id="div_formulario">
                                <form name="opcion_menu" action="" accept-charset="ISO-8859-1"></form>
                                	<div id="div_pestania">
						<!-- PESTAÑA PRODUCCION -->
                                		<div id="div_pestania_produccion" style="display:block; background-color: transparent;">
                                			<div class="titulo_menu">
                                				PRODUCCI&Oacute;N
                                			</div>
                                			<security:authorize access="hasRole('ROLE_ROOT')">
                                				<div id="div_opcion_orden_produccion" class="boton_dinamico" onclick="menu('orden_produccion');">
                                					<span class="texto_boton">Orden Producci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_visualizador" class="boton_dinamico" onclick="menu('visualizador');">
	                                				<span class="texto_boton">Visualizador</span>
	                                			</div>
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_ADMIN')">
							        			<div id="div_opcion_orden_produccion" class="boton_dinamico" onclick="menu('orden_produccion');">
                                					<span class="texto_boton">Orden Producci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_visualizador" class="boton_dinamico" onclick="menu('visualizador');">
	                                				<span class="texto_boton">Visualizador</span>
	                                			</div>
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
							        			<div id="div_opcion_orden_produccion" class="boton_dinamico" onclick="menu('orden_produccion');">
                                					<span class="texto_boton">Orden Producci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_visualizador" class="boton_dinamico" onclick="menu('visualizador');">
	                                				<span class="texto_boton">Visualizador</span>
	                                			</div>
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_DISEÑO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_ACABADO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_CLIENTE')">
							        		
							        		</security:authorize>
	                                	</div>
						<!-- PESTAÑA REPORTES -->
	                                	<div id="div_pestania_reportes" style="display:none; background-color: transparent;">
	                                		<div class="titulo_menu">
                                				REPORTES
                                			</div>
	                                		<security:authorize access="hasRole('ROLE_ROOT')">
                                				<div id="div_opcion_reporte_orden_produccion" class="boton_dinamico" onclick="menu('ventana_reporte_orden_produccion');">
                                					<span class="texto_boton">Orden Producci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_reporte_cotizacion" class="boton_dinamico" onclick="menu('ventana_reporte_cotizacion');">
                                					<span class="texto_boton">Cotizaci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_reporte_nota_remision" class="boton_dinamico" onclick="menu('ventana_reporte_nota_remision');">
                                					<span class="texto_boton">Nota <br/> Remisi&oacute;n / Factura</span>
	                                			</div>
	                                			<div id="div_opcion_reporte_cola_impresion" class="boton_dinamico" onclick="menu('ventana_reporte_cola_impresion');">
                                					<span class="texto_boton">Cola Impresi&oacute;n</span>
	                                			</div>
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_ADMIN')">
							        			<div id="div_opcion_reporte_orden_produccion" class="boton_dinamico" onclick="menu('ventana_reporte_orden_produccion');">
                                					<span class="texto_boton">Orden Producci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_reporte_cotizacion" class="boton_dinamico" onclick="menu('ventana_reporte_cotizacion');">
                                					<span class="texto_boton">Cotizaci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_reporte_nota_remision" class="boton_dinamico" onclick="menu('ventana_reporte_nota_remision');">
                                					<span class="texto_boton">Nota <br/> Remisi&oacute;n / Factura</span>
	                                			</div>
	                                			<div id="div_opcion_reporte_cola_impresion" class="boton_dinamico" onclick="menu('ventana_reporte_cola_impresion');">
                                					<span class="texto_boton">Cola Impresi&oacute;n</span>
	                                			</div>
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
							        			<div id="div_opcion_reporte_orden_produccion" class="boton_dinamico" onclick="menu('ventana_reporte_orden_produccion');">
                                					<span class="texto_boton">Orden Producci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_reporte_cotizacion" class="boton_dinamico" onclick="menu('ventana_reporte_cotizacion');">
                                					<span class="texto_boton">Cotizaci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_reporte_nota_remision" class="boton_dinamico" onclick="menu('ventana_reporte_nota_remision');">
                                					<span class="texto_boton">Nota <br/> Remisi&oacute;n / Factura</span>
	                                			</div>
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_DISEÑO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_ACABADO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_CLIENTE')">
							        		
							        		</security:authorize>
	                                	</div>
						<!-- PESTAÑA CATALOGOS -->
	                                	<div id="div_pestania_catalogos" style="display:none; background-color: transparent;">
	                                		<div class="titulo_menu">
                                				CAT&Aacute;LOGOS
                                			</div>
	                                		<security:authorize access="hasRole('ROLE_ROOT')">
                                				<div id="div_opcion_cliente" class="boton_dinamico" onclick="menu('cliente');">
	                                				<span class="texto_boton">Cliente</span>
	                                			</div>
	                                			<div id="div_opcion_combinacion_de_tintas" class="boton_dinamico" onclick="menu('combinacion_tintas');">
	                                				<span class="texto_boton">Combinaci&oacute;n de tintas</span>
	                                			</div>
	                                			<div id="div_opcion_costo_extra" class="boton_dinamico" onclick="menu('costo_extra');">
	                                				<span class="texto_boton">Costo extra</span>
	                                			</div>
	                                			<div id="div_opcion_estatus_orden" class="boton_dinamico" onclick="menu('estatus_orden');">
	                                				<span class="texto_boton">(+) Estatus orden</span>
	                                			</div>
	                                			<div id="div_opcion_maquina" class="boton_dinamico" onclick="menu('maquina');">
	                                				<span class="texto_boton">M&aacute;quina</span>
	                                			</div>
	                                			<div id="div_opcion_material_ayuda" class="boton_dinamico" onclick="menu('material_ayuda');">
	                                				<span class="texto_boton">Material ayuda</span>
	                                			</div>
	                                			<div id="div_opcion_papel_sobrante" class="boton_dinamico" onclick="menu('papel_sobrante');">
	                                				<span class="texto_boton">Papel sobrante</span>
	                                			</div>
	                                			<div id="div_opcion_prensista" class="boton_dinamico" onclick="menu('prensista');">
	                                				<span class="texto_boton">Prensista</span>
	                                			</div>
	                                			<div id="div_opcion_proceso_disenio" class="boton_dinamico" onclick="menu('proceso_disenio');">
	                                				<span class="texto_boton">Proceso dise&ntilde;o</span>
	                                			</div>
	                                			<div id="div_opcion_proceso_preprensa" class="boton_dinamico" onclick="menu('proceso_preprensa');">
	                                				<span class="texto_boton">Proceso preprensa</span>
	                                			</div>
	                                			<div id="div_opcion_proceso_transporte" class="boton_dinamico" onclick="menu('proceso_transporte');">
	                                				<span class="texto_boton">Proceso transporte</span>
	                                			</div>
	                                			<div id="div_opcion_proceso_externo" class="boton_dinamico" onclick="menu('proceso_externo');">
	                                				<span class="texto_boton">Proceso externo</span>
	                                			</div>
	                                			<div id="div_opcion_proveedor_externo" class="boton_dinamico" onclick="menu('proveedor_externo');">
	                                				<span class="texto_boton">Proveedor externo</span>
	                                			</div>
	                                			<div id="div_opcion_proveedor_papel" class="boton_dinamico" onclick="menu('proveedor_papel');">
	                                				<span class="texto_boton">Proveedor papel</span>
	                                			</div>
	                                			<div id="div_opcion_responsable_insumo" class="boton_dinamico" onclick="menu('responsable_insumo');">
	                                				<span class="texto_boton">Responsable insumo</span>
	                                			</div>
	                                			<div id="div_opcion_tabulador_precios" class="boton_dinamico" onclick="menu('tabulador_precios');">
	                                				<span class="texto_boton">Tabulador precios</span>
	                                			</div>
	                                			<div id="div_opcion_tamanio_publicacion" class="boton_dinamico" onclick="menu('tamanio_publicacion');">
	                                				<span class="texto_boton">Tama&ntilde;o publicaci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_tinta_especial" class="boton_dinamico" onclick="menu('tinta_especial');">
	                                				<span class="texto_boton">Tinta especial</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_barniz" class="boton_dinamico" onclick="menu('tipo_barniz');">
	                                				<span class="texto_boton">Tipo barniz</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_cliente" class="boton_dinamico" onclick="menu('tipo_cliente');">
	                                				<span class="texto_boton">Tipo cliente</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_complejidad" class="boton_dinamico" onclick="menu('tipo_complejidad');">
	                                				<span class="texto_boton">(+) Tipo complejidad</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_comprobante_fiscal" class="boton_dinamico" onclick="menu('tipo_comprobante_fiscal');">
	                                				<span class="texto_boton">Tipo comprobante fiscal</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_forma_trabajo" class="boton_dinamico" onclick="menu('tipo_forma_trabajo');">
	                                				<span class="texto_boton">Tipo forma trabajo</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_papel_extendido" class="boton_dinamico" onclick="menu('tipo_papel_extendido');">
	                                				<span class="texto_boton">Tipo papel extendido</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_placa" class="boton_dinamico" onclick="menu('tipo_placa');">
	                                				<span class="texto_boton">Tipo placa</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_vuelta" class="boton_dinamico" onclick="menu('tipo_vuelta');">
	                                				<span class="texto_boton">Tipo vuelta</span>
	                                			</div>
	                                			<div id="div_opcion_turno_laboral" class="boton_dinamico" onclick="menu('turno_laboral');">
	                                				<span class="texto_boton">Turno laboral</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_precio" class="boton_dinamico" onclick="menu('tipo_precio');">
	                                				<span class="texto_boton">(+) Tipo precio</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_trabajo" class="boton_dinamico" onclick="menu('tipo_trabajo');">
	                                				<span class="texto_boton">(+) Tipo trabajo</span>
	                                			</div>
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_ADMIN')">
							        			<div id="div_opcion_cliente" class="boton_dinamico" onclick="menu('cliente');">
	                                				<span class="texto_boton">Cliente</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_papel_extendido" class="boton_dinamico" onclick="menu('tipo_papel_extendido');">
	                                				<span class="texto_boton">Tipo papel extendido</span>
	                                			</div>
	                                			<div id="div_opcion_combinacion_de_tintas" class="boton_dinamico" onclick="menu('combinacion_tintas');">
	                                				<span class="texto_boton">Combinaci&oacute;n de tintas</span>
	                                			</div>
	                                			<div id="div_opcion_costo_extra" class="boton_dinamico" onclick="menu('costo_extra');">
	                                				<span class="texto_boton">Costo extra</span>
	                                			</div>
	                                			<div id="div_opcion_maquina" class="boton_dinamico" onclick="menu('maquina');">
	                                				<span class="texto_boton">M&aacute;quina</span>
	                                			</div>
	                                			<div id="div_opcion_material_ayuda" class="boton_dinamico" onclick="menu('material_ayuda');">
	                                				<span class="texto_boton">Material ayuda</span>
	                                			</div>
	                                			<div id="div_opcion_papel_sobrante" class="boton_dinamico" onclick="menu('papel_sobrante');">
	                                				<span class="texto_boton">Papel sobrante</span>
	                                			</div>
	                                			<div id="div_opcion_prensista" class="boton_dinamico" onclick="menu('prensista');">
	                                				<span class="texto_boton">Prensista</span>
	                                			</div>
	                                			<div id="div_opcion_proceso_disenio" class="boton_dinamico" onclick="menu('proceso_disenio');">
	                                				<span class="texto_boton">Proceso dise&ntilde;o</span>
	                                			</div>
	                                			<div id="div_opcion_proceso_preprensa" class="boton_dinamico" onclick="menu('proceso_preprensa');">
	                                				<span class="texto_boton">Proceso preprensa</span>
	                                			</div>
	                                			<div id="div_opcion_proceso_transporte" class="boton_dinamico" onclick="menu('proceso_transporte');">
	                                				<span class="texto_boton">Proceso transporte</span>
	                                			</div>
	                                			<div id="div_opcion_proceso_externo" class="boton_dinamico" onclick="menu('proceso_externo');">
	                                				<span class="texto_boton">Proceso externo</span>
	                                			</div>
	                                			<div id="div_opcion_proveedor_externo" class="boton_dinamico" onclick="menu('proveedor_externo');">
	                                				<span class="texto_boton">Proveedor externo</span>
	                                			</div>
	                                			<div id="div_opcion_proveedor_papel" class="boton_dinamico" onclick="menu('proveedor_papel');">
	                                				<span class="texto_boton">Proveedor papel</span>
	                                			</div>
	                                			<div id="div_opcion_responsable_insumo" class="boton_dinamico" onclick="menu('responsable_insumo');">
	                                				<span class="texto_boton">Responsable insumo</span>
	                                			</div>
	                                			<div id="div_opcion_tabulador_precios" class="boton_dinamico" onclick="menu('tabulador_precios');">
	                                				<span class="texto_boton">Tabulador precios</span>
	                                			</div>
	                                			<div id="div_opcion_tamanio_publicacion" class="boton_dinamico" onclick="menu('tamanio_publicacion');">
	                                				<span class="texto_boton">Tama&ntilde;o publicaci&oacute;n</span>
	                                			</div>
	                                			<div id="div_opcion_tinta_especial" class="boton_dinamico" onclick="menu('tinta_especial');">
	                                				<span class="texto_boton">Tinta especial</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_barniz" class="boton_dinamico" onclick="menu('tipo_barniz');">
	                                				<span class="texto_boton">Tipo barniz</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_cliente" class="boton_dinamico" onclick="menu('tipo_cliente');">
	                                				<span class="texto_boton">Tipo cliente</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_comprobante_fiscal" class="boton_dinamico" onclick="menu('tipo_comprobante_fiscal');">
	                                				<span class="texto_boton">Tipo comprobante fiscal</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_forma_trabajo" class="boton_dinamico" onclick="menu('tipo_forma_trabajo');">
	                                				<span class="texto_boton">Tipo forma trabajo</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_placa" class="boton_dinamico" onclick="menu('tipo_placa');">
	                                				<span class="texto_boton">Tipo placa</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_vuelta" class="boton_dinamico" onclick="menu('tipo_vuelta');">
	                                				<span class="texto_boton">Tipo vuelta</span>
	                                			</div>
	                                			<div id="div_opcion_turno_laboral" class="boton_dinamico" onclick="menu('turno_laboral');">
	                                				<span class="texto_boton">Turno laboral</span>
	                                			</div>
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
							        			<div id="div_opcion_cliente" class="boton_dinamico" onclick="menu('cliente');">
	                                				<span class="texto_boton">Cliente</span>
	                                			</div>
	                                			<div id="div_opcion_tipo_papel_extendido" class="boton_dinamico" onclick="menu('tipo_papel_extendido');">
	                                				<span class="texto_boton">Tipo papel extendido</span>
	                                			</div>
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_DISEÑO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_ACABADO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_CLIENTE')">
							        		
							        		</security:authorize>
	                                	</div>
						<!-- PESTAÑA SEGURIDAD -->
	                                	<div id="div_pestania_seguridad" style="display:none; background-color: transparent;">
	                                		<div class="titulo_menu">
                                				SEGURIDAD
                                			</div>
	                                		<security:authorize access="hasRole('ROLE_ROOT')">
                                				<div id="div_opcion_perfil" class="boton_dinamico" onclick="menu('perfil');">
	                                				<span class="texto_boton">(+) Perfil</span>
	                                			</div>
	                                			<div id="div_opcion_perfil_por_usuario" class="boton_dinamico" onclick="menu('perfil_x_usuario');">
	                                				<span class="texto_boton">(+) Perfil por usuario</span>
	                                			</div>
	                                			<div id="div_opcion_usuario" class="boton_dinamico" onclick="menu('usuario');">
	                                				<span class="texto_boton">(+) Usuario</span>
	                                			</div>
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_ADMIN')">
							        			
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_DISEÑO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_ACABADO')">
							        		
							        		</security:authorize>
							        		<security:authorize access="hasRole('ROLE_CLIENTE')">
							        		
							        		</security:authorize>
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
    </body>
</html>