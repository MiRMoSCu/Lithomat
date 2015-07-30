<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<c:url value="/orden_produccion/" 						var="urlOrdenProduccion" />
<c:url value="/visualizador/" 							var="urlVisualizador" />
<c:url value="/cliente/catalogo/lista" 					var="urlCliente" />
<c:url value="/combinacion_tintas/catalogo/lista" 		var="urlCombinacionTintas" />
<c:url value="/costos_extras/catalogo/lista" 			var="urlCostosExtras" />
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
<c:url value="/tipo_comprobante_fiscal/catalogo/lista" 	var="urlTipoComprobanteFiscal" />
<c:url value="/tipo_forma_trabajo/catalogo/lista" 		var="urlTipoFormaTrabajo" />
<c:url value="/tipo_papel_extendido/catalogo/lista" 	var="urlTipoPapelExtendido" />
<c:url value="/tipo_placa/catalogo/lista" 				var="urlTipoPlaca" />
<c:url value="/tipo_precio/catalogo/lista" 				var="urlTipoPrecio" />
<c:url value="/tipo_trabajo/catalogo/lista" 			var="urlTipoTrabajo" />
<c:url value="/turno_laboral/catalogo/lista" 			var="urlTurnoLaboral" />
<c:url value="/tipo_vuelta/catalogo/lista" 				var="urlTipoVuelta" />
<c:url value="/j_spring_security_logout" 				var="urlSalir" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <style type="text/css">
        	th, td {
        		padding: 0px 7px 0px 7px;
        	}
        	
        </style>
        <script type="text/javascript">
        	var urlOrdenProduccion 			= '${urlOrdenProduccion}';	
        	var urlVisualizador				= '${urlVisualizador}';
            var urlCliente					= '${urlCliente}';
            var urlCombinacionTintas		= '${urlCombinacionTintas}';
            var urlCostosExtras				= '${urlCostosExtras}';
            var urlEstatusOrden				= '${urlEstatusOrden}';
            var urlMaquina					= '${urlMaquina}';
            var urlMaterialAyuda			= '${urlMaterialAyuda}';
            var urlPapelSobrante			= '${urlPapelSobrante}';
            var urlPrensista				= '${urlPrensista}';
            var urlProcesoDisenio			= '${urlProcesoDisenio}';
            var urlProcesoExterno			= '${urlProcesoExterno}';
            var urlProcesoPreprensa			= '${urlProcesoPreprensa}';
            var urlProcesoTransporte		= '${urlProcesoTransporte}';
            var urlProveedorExterno			= '${urlProveedorExterno}';
            var urlProveedorPapel			= '${urlProveedorPapel}';
            var urlResponsableInsumo		= '${urlResponsableInsumo}';
            var urlTabuladorPrecios			= '${urlTabuladorPrecios}';
            var urlTamanioPublicacion		= '${urlTamanioPublicacion}';
            var urlTintaEspecial			= '${urlTintaEspecial}';
            var urlTipoBarniz				= '${urlTipoBarniz}';
            var urlTipoCliente				= '${urlTipoCliente}';
            var urlTipoComprobanteFiscal	= '${urlTipoComprobanteFiscal}';
            var urlTipoFormaTrabajo			= '${urlTipoFormaTrabajo}';
            var urlTipoPapelExtendido		= '${urlTipoPapelExtendido}';
            var urlTipoPlaca				= '${urlTipoPlaca}';
            var urlTipoPrecio				= '${urlTipoPrecio}';
            var urlTipoTrabajo				= '${urlTipoTrabajo}';
            var urlTurnoLaboral				= '${urlTurnoLaboral}';
            var urlTipoVuelta				= '${urlTipoVuelta}';
            var urlSalir					= '${urlSalir}';
            
            function menu( opcion ) {
                switch( opcion ) {
	                case 'visualizador':
	                	document.forms["opcion_menu"].action = urlVisualizador;
	                	break;
                    case 'orden_produccion':
                        document.forms["opcion_menu"].action = urlOrdenProduccion;
                        break;
                    case 'cliente':
                    	document.forms["opcion_menu"].action = urlCliente;
                    	break;
                    case 'combinacion_tintas':
                    	document.forms["opcion_menu"].action = urlCombinacionTintas;
                    	break;
                    case 'costos_extras':
                    	document.forms["opcion_menu"].action = urlCostosExtras;
                    	break;
                    case 'estatus_orden':
                    	document.forms["opcion_menu"].action = urlEstatusOrden;
                    	break;
                    case 'maquina':
                    	document.forms["opcion_menu"].action = urlMaquina;
                    	break;
                    case 'material_ayuda':
                    	document.forms["opcion_menu"].action = urlMaterialAyuda;
                    	break;
                    case 'papel_sobrante':
                    	document.forms["opcion_menu"].action = urlPapelSobrante;
                    	break;
                    case 'prensista':
                    	document.forms["opcion_menu"].action = urlPrensista;
                    	break;
                    case 'proceso_disenio':
                    	document.forms["opcion_menu"].action = urlProcesoDisenio;
                    	break;
                    case 'proceso_externo':
                    	document.forms["opcion_menu"].action = urlProcesoExterno;
                    	break;
                    case 'proceso_preprensa':
                    	document.forms["opcion_menu"].action = urlProcesoPreprensa;
                    	break;
                    case 'proceso_transporte':
                    	document.forms["opcion_menu"].action = urlProcesoTransporte;
                    	break;
                    case 'proveedor_externo':
                    	document.forms["opcion_menu"].action = urlProveedorExterno;
                    	break;
                    case 'proveedor_papel':
                    	document.forms["opcion_menu"].action = urlProveedorPapel;
                    	break;
                    case 'responsable_insumo':
                    	document.forms["opcion_menu"].action = urlResponsableInsumo;
                    	break;
                    case 'tabulador_precios':
                    	document.forms["opcion_menu"].action = urlTabuladorPrecios;
                    	break;
                    case 'tamanio_publicacion':
                    	document.forms["opcion_menu"].action = urlTamanioPublicacion;
                    	break;
                    case 'tinta_especial':
                    	document.forms["opcion_menu"].action = urlTintaEspecial;
                    	break;
                    case 'tipo_barniz':
                    	document.forms["opcion_menu"].action = urlTipoBarniz;
                    	break;
                    case 'tipo_cliente':
                    	document.forms["opcion_menu"].action = urlTipoCliente;
                    	break;
                    case 'tipo_comprobante_fiscal':
                    	document.forms["opcion_menu"].action = urlTipoComprobanteFiscal;
                    	break;
                    case 'tipo_forma_trabajo':
                    	document.forms["opcion_menu"].action = urlTipoFormaTrabajo;
                    	break;
                    case 'tipo_papel_extendido':
                    	document.forms["opcion_menu"].action = urlTipoPapelExtendido;
                    	break;
                    case 'tipo_placa':
                    	document.forms["opcion_menu"].action = urlTipoPlaca;
                    	break;
                    case 'tipo_precio':
                    	document.forms["opcion_menu"].action = urlTipoPrecio;
                    	break;
                    case 'tipo_trabajo':
                    	document.forms["opcion_menu"].action = urlTipoTrabajo;
                    	break;
                    case 'turno_laboral':
                    	document.forms["opcion_menu"].action = urlTurnoLaboral;
                    	break;
                    case 'tipo_vuelta':
                    	document.forms["opcion_menu"].action = urlTipoVuelta;
                    	break;
                    case 'salir':
                    	document.forms["opcion_menu"].action = urlSalir;
                    	break;
                    default:
                    	alert("error en url");
                        break;
                }
                document.forms[0].submit();
            }
        </script>
    </head>
    <body>
        <form name="opcion_menu" action="" method="POST" accept-charset="ISO-8859-1"></form>
        Bienvenido ${user}.<br/>
        <b style="cursor:pointer;" onclick="menu('salir');">Cerrar sesion</b>
        <br/>
        <br/>
        <table border="1">
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th>ROOT</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th>ADMIN</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>COTIZADOR</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>PRODUCCION</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>DISEÑO</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>PREPRENSA</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>TRANSPORTE</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>PROCESO EXTERNO</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>ACABADO</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>CLIENTE</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<th>&nbsp;</th>
        	</tr>
        	<tr>
        		<td>PRODUCCION</td>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('orden_produccion');">Orden Producci&oacute;n</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('orden_produccion');">Orden Producci&oacute;n</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th><b style="cursor:pointer;" onclick="menu('orden_produccion');">Orden Producci&oacute;n</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>PRODUCCION</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>DISEÑO</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>PREPRENSA</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>TRANSPORTE</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>PROCESO EXTERNO</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>ACABADO</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>CLIENTE</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('visualizador');">Visualizador</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('visualizador');">Visualizador</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th><b style="cursor:pointer;" onclick="menu('visualizador');">Visualizador</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>PRODUCCION</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>DISEÑO</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>PREPRENSA</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>TRANSPORTE</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>PROCESO EXTERNO</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>ACABADO</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>CLIENTE</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<th>&nbsp;</th>
        	</tr>
        	<tr>
        		<td>CATALOGOS</td>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('cliente');">Cliente</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('cliente');">Cliente</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th><b style="cursor:pointer;" onclick="menu('cliente');">Cliente</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tipo_papel_extendido');">Tipo papel extendido</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('tipo_papel_extendido');">Tipo papel extendido</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th><b style="cursor:pointer;" onclick="menu('tipo_papel_extendido');">Tipo papel extendido</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('combinacion_tintas');">Combinacion de tintas</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('combinacion_tintas');">Combinacion de tintas</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('costos_extras');">Costos extras</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('costos_extras');">Costos extras</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('maquina');">Maquina</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('maquina');">Maquina</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('material_ayuda');">Material Ayuda</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('material_ayuda');">Material Ayuda</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('papel_sobrante');">Papel sobrante</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('papel_sobrante');">Papel sobrante</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('prensista');">Prensista</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('prensista');">Prensista</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('proceso_disenio');">Proceso disenio</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('proceso_disenio');">Proceso disenio</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('proceso_preprensa');">Proceso preprensa</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('proceso_preprensa');">Proceso preprensa</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('proceso_transporte');">Proceso transporte</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('proceso_transporte');">Proceso transporte</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('proceso_externo');">Proceso externo</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('proceso_externo');">Proceso externo</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('proveedor_externo');">Proveedor externo</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('proveedor_externo');">Proveedor externo</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('proveedor_papel');">Proveedor papel</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('proveedor_papel');">Proveedor papel</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('responsable_insumo');">Responsable insumo</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('responsable_insumo');">Responsable insumo</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tabulador_precios');">Tabulador precios</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('tabulador_precios');">Tabulador precios</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tamanio_publicacion');">Tamanio publicacion</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('tamanio_publicacion');">Tamanio publicacion</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tinta_especial');">Tinta especial</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('tinta_especial');">Tinta especial</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tipo_barniz');">Tipo barniz</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('tipo_barniz');">Tipo barniz</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tipo_cliente');">Tipo cliente</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('tipo_cliente');">Tipo cliente</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tipo_comprobante_fiscal');">Tipo comprobante fiscal</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('tipo_comprobante_fiscal');">Tipo comprobante fiscal</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tipo_forma_trabajo');">Tipo forma trabajo</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('tipo_forma_trabajo');">Tipo forma trabajo</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tipo_placa');">Tipo placa</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('tipo_placa');">Tipo placa</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tipo_vuelta');">Tipo vuelta</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('tipo_vuelta');">Tipo vuelta</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('turno_laboral');">Turno laboral</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th><b style="cursor:pointer;" onclick="menu('turno_laboral');">Turno laboral</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('estatus_orden');">Estatus orden</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tipo_precio');">Tipo precio</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        	<tr>
        		<security:authorize access="hasRole('ROLE_ROOT')">
        			<th><b style="cursor:pointer;" onclick="menu('tipo_trabajo');">Tipo trabajo</b></th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ADMIN')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_COTIZADOR')">
	        		<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PRODUCCION')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_DISEÑO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PREPRENSA')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_TRANSPORTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_PROCESO_EXTERNO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_ACABADO')">
        			<th>&nbsp;</th>
        		</security:authorize>
        		<security:authorize access="hasRole('ROLE_CLIENTE')">
        			<th>&nbsp;</th>
        		</security:authorize>
        	</tr>
        </table>
        <br/>
        
    </body>
</html>