

function genera_tabla( strJson ) {
	
}

function regresa_menu() {
	location.replace(urlMenu);
}

Number.prototype.formatMoney = function(c, d, t) {
	var n = this, 
	    c = isNaN(c = Math.abs(c)) ? 2 : c, 
	    d = d == undefined ? "." : d, 
	    t = t == undefined ? "," : t, 
	    s = n < 0 ? "-" : "", 
	    i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", 
	    j = (j = i.length) > 3 ? j % 3 : 0;
	return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
};
	
function convertDate(inputFormat) {
	function pad(s) { return (s < 10) ? '0' + s : s; }
	var d = new Date(inputFormat);
	return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
}

function limpiaFormSubPartida() {
	document.resumen_tipo_trabajo_detalle.descripcion.value 						= "";
	document.resumen_tipo_trabajo_detalle.maquina_descripcion.value 				= "";
	document.resumen_tipo_trabajo_detalle.cantidad_redondeada.value 				= "";
	document.resumen_tipo_trabajo_detalle.repeticiones_x_pliego.value 				= "";
	document.resumen_tipo_trabajo_detalle.numero_paginas_publicacion.value 			= "";
	document.resumen_tipo_trabajo_detalle.tamanio_publicacion.value 				= "";
	document.resumen_tipo_trabajo_detalle.numero_pliegos.value 						= "";
	document.resumen_tipo_trabajo_detalle.papel_descripcion.value 					= "";
	document.resumen_tipo_trabajo_detalle.papel_cantidad_total.value 				= "";
	document.resumen_tipo_trabajo_detalle.papel_precio_unitario.value 				= "";
	document.resumen_tipo_trabajo_detalle.papel_coste_total.value 					= "";
	document.resumen_tipo_trabajo_detalle.tinta_descripcion.value 					= "";
	document.resumen_tipo_trabajo_detalle.tinta_num_ent_maq.value 					= "";
	document.resumen_tipo_trabajo_detalle.tinta_precio_unitario.value 				= "";
	document.resumen_tipo_trabajo_detalle.tinta_coste_total.value 					= "";
	document.resumen_tipo_trabajo_detalle.tinta_especial_descripcion.value 			= "";
	document.resumen_tipo_trabajo_detalle.tinta_especial_num_ent_maq.value 			= "";
	document.resumen_tipo_trabajo_detalle.tinta_especial_precio_unitario.value 		= "";
	document.resumen_tipo_trabajo_detalle.tinta_especial_coste_total.value 			= "";
	document.resumen_tipo_trabajo_detalle.barniz_descripcion.value 					= "";
	document.resumen_tipo_trabajo_detalle.frente_barniz_num_ent_maq.value 			= "";
	document.resumen_tipo_trabajo_detalle.frente_barniz_precio_unitario.value 		= "";
	document.resumen_tipo_trabajo_detalle.frente_barniz_coste_total.value 			= "";
	document.resumen_tipo_trabajo_detalle.vuelta_barniz_num_ent_maq.value 			= "";
	document.resumen_tipo_trabajo_detalle.vuelta_barniz_precio_unitario.value 		= "";
	document.resumen_tipo_trabajo_detalle.vuelta_barniz_coste_total.value 			= "";
	document.resumen_tipo_trabajo_detalle.placas_descripcion.value 					= "";
	document.resumen_tipo_trabajo_detalle.placas_num_placas.value 					= "";
	document.resumen_tipo_trabajo_detalle.placas_precio_unitario.value 				= "";
	document.resumen_tipo_trabajo_detalle.placas_coste_total.value 					= "";
	document.resumen_tipo_trabajo_detalle.tipo_trabajo_detalle_coste_total.value 	= "";
} // limpiaFormSubPartida

function limpiaFormProcesos(){
	
	document.resumen_procesos.procesos_coste_total.value = "";
	
	document.getElementById("div_tabla_lista_procesos_disenio").innerHTML = 
		"<table>" + 
			"<tr>" +
				"<th>No.</th>" +
				"<th>Descripci&oacute;n</th>" +
				"<th>Precio</th>" +
				"<th>Especificaci&oacute;n</th>" +
			"</tr>" +
			"<tr class=\"l1\">" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
			"</tr>" +
		"</table>";
			
	document.getElementById("div_tabla_lista_procesos_preprensa").innerHTML = 
		"<table>" + 
			"<tr>" +
				"<th>No.</th>" +
				"<th>Descripci&oacute;n</th>" +
				"<th>Precio</th>" +
				"<th>Especificaci&oacute;n</th>" +
			"</tr>" +
			"<tr class=\"l1\">" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
			"</tr>" +
		"</table>";
		
	document.getElementById("div_tabla_lista_procesos_transporte").innerHTML = 
		"<table>" + 
			"<tr>" +
				"<th>No.</th>" +
				"<th>Descripci&oacute;n</th>" +
				"<th>Precio</th>" +
				"<th>Especificaci&oacute;n</th>" +
			"</tr>" +
			"<tr class=\"l1\">" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
			"</tr>" +
		"</table>";
		
	document.getElementById("div_tabla_lista_procesos_acabado").innerHTML = 
		"<table>" + 
			"<tr>" +
				"<th>No.</th>" +
				"<th>Descripci&oacute;n</th>" +
				"<th>Precio</th>" +
				"<th>Especificaci&oacute;n</th>" +
			"</tr>" +
			"<tr class=\"l1\">" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
				"<td>&nbsp;</td>" +
			"</tr>" +
		"</table>";
} // limpiaFormProcesos

function limpiaFormPartida(){
	document.resumen_partida.nombre_tipo_trabajo.value	= "";
	document.resumen_partida.nombre_partida.value		= "";
	document.resumen_partida.cantidad.value				= "";
	document.resumen_partida.descripcion_partida.value	= "";
	document.resumen_partida.coste_total.value			= "";
} // limpiaFormPartida

function limpiaCampos(){
	limpiaFormSubPartida();
	limpiaFormProcesos();
	limpiaFormPartida();
} // limpiaCampos

function ajaxPartida( id_partida ) {
	limpiaFormPartida();
	var nut = document.orden_produccion.nut.value;
	$.ajax({
		type:'POST',
		url:urlResumenCalificacionPartida,
		data:{nut:nut, id_partida:id_partida},
		success:function(response){
			//console.log(response);
			document.resumen_partida.nombre_tipo_trabajo.value	= response.nombreTipoTrabajo;
			document.resumen_partida.nombre_partida.value		= response.nombrePartida;
			document.resumen_partida.cantidad.value				= response.cantidad;
			document.resumen_partida.descripcion_partida.value	= response.descripcionPartida;
			document.resumen_partida.coste_total.value			= "$ " + (response.costeTotal).formatMoney(2);
		},
		error:function(e){
			alert("Error. No fue posible conectarse con el servidor");
		}
	});
} // ajaxPartida

function ajaxSubPartida( id_tipo_trabajo_detalle ) {
	limpiaFormSubPartida();
	var nut = document.orden_produccion.nut.value;
	$.ajax({
		type:'POST',
		url:urlResumenCalificacionTrabajoDetalle,
		data:{nut:nut, id_tipo_trabajo_detalle:id_tipo_trabajo_detalle},
		success:function(response) {
			//console.log(response);
			document.resumen_tipo_trabajo_detalle.descripcion.value 						= response.descripcion;
			document.resumen_tipo_trabajo_detalle.maquina_descripcion.value 				= response.maquinaDescripcion;
			document.resumen_tipo_trabajo_detalle.cantidad_redondeada.value 				= response.cantidadRedondeada;
			document.resumen_tipo_trabajo_detalle.repeticiones_x_pliego.value 				= response.repeticionesXPliego;
			document.resumen_tipo_trabajo_detalle.numero_paginas_publicacion.value 			= response.numeroPaginasPublicacion;
			document.resumen_tipo_trabajo_detalle.tamanio_publicacion.value 				= response.tamanioPublicacion;
        	document.resumen_tipo_trabajo_detalle.numero_pliegos.value 						= response.numeroPliegos;
        	document.resumen_tipo_trabajo_detalle.papel_descripcion.value 					= response.papelDescripcion;
        	document.resumen_tipo_trabajo_detalle.papel_cantidad_total.value 				= response.papelCantidadTotal;
        	document.resumen_tipo_trabajo_detalle.papel_precio_unitario.value 				= "$ " + (response.papelPrecioUnitario).formatMoney(4);
        	document.resumen_tipo_trabajo_detalle.papel_coste_total.value 					= "$ " + (response.papelCosteTotal).formatMoney(2);
        	document.resumen_tipo_trabajo_detalle.tinta_descripcion.value 					= response.tintaDescripcion;
        	document.resumen_tipo_trabajo_detalle.tinta_num_ent_maq.value 					= response.tintaNumEntMaq;
        	document.resumen_tipo_trabajo_detalle.tinta_precio_unitario.value 				= "$ " + (response.tintaPrecioUnitario).formatMoney(3);
        	document.resumen_tipo_trabajo_detalle.tinta_coste_total.value 					= "$ " + (response.tintaCosteTotal).formatMoney(2);
        	document.resumen_tipo_trabajo_detalle.tinta_especial_descripcion.value 			= response.tintaEspecialDescripcion;
        	document.resumen_tipo_trabajo_detalle.tinta_especial_num_ent_maq.value 			= response.tintaEspecialNumEntMaq;
        	document.resumen_tipo_trabajo_detalle.tinta_especial_precio_unitario.value 		= "$ " + (response.tintaEspecialPrecioUnitario).formatMoney(3);
        	document.resumen_tipo_trabajo_detalle.tinta_especial_coste_total.value 			= "$ " + (response.tintaEspecialCosteTotal).formatMoney(2);
        	document.resumen_tipo_trabajo_detalle.barniz_descripcion.value 					= response.barnizDescripcion;
        	document.resumen_tipo_trabajo_detalle.frente_barniz_num_ent_maq.value 			= response.frenteBarnizNumEntMaq;
        	document.resumen_tipo_trabajo_detalle.frente_barniz_precio_unitario.value 		= "$ " + (response.frenteBarnizPrecioUnitario).formatMoney(3);
        	document.resumen_tipo_trabajo_detalle.frente_barniz_coste_total.value 			= "$ " + (response.frenteBarnizCosteTotal).formatMoney(2);
        	document.resumen_tipo_trabajo_detalle.vuelta_barniz_num_ent_maq.value 			= response.vueltaBarnizNumEntMaq;
        	document.resumen_tipo_trabajo_detalle.vuelta_barniz_precio_unitario.value 		= "$ " + (response.vueltaBarnizPrecioUnitario).formatMoney(3);
        	document.resumen_tipo_trabajo_detalle.vuelta_barniz_coste_total.value 			= "$ " + (response.vueltaBarnizCosteTotal).formatMoney(2);
        	document.resumen_tipo_trabajo_detalle.placas_descripcion.value 					= response.placasDescripcion;
        	document.resumen_tipo_trabajo_detalle.placas_num_placas.value 					= response.placasNumPlacas;
        	document.resumen_tipo_trabajo_detalle.placas_precio_unitario.value 				= "$ " + (response.placasPrecioUnitario).formatMoney(2);
        	document.resumen_tipo_trabajo_detalle.placas_coste_total.value 					= "$ " + (response.placasCosteTotal).formatMoney(2);
        	
        	var sumatoria = 0;
        	// papel
        	if( response.clienteProporcionaPapel )
        		document.resumen_tipo_trabajo_detalle.papel_coste_total.style.textDecoration = "line-through";
        	else {
        		document.resumen_tipo_trabajo_detalle.papel_coste_total.style.textDecoration = "none";
        		sumatoria += response.papelCosteTotal;
        	}
        	// tinta
        	if( response.clienteProporcionaTinta )
        		document.resumen_tipo_trabajo_detalle.tinta_coste_total.style.textDecoration = "line-through";
        	else {
        		document.resumen_tipo_trabajo_detalle.tinta_coste_total.style.textDecoration = "none";
        		sumatoria += response.tintaCosteTotal;
        	}
        	// tinta especial
        	if( response.clienteProporcionaTintaEspecial )
        		document.resumen_tipo_trabajo_detalle.tinta_especial_coste_total.style.textDecoration = "line-through";
        	else {
        		document.resumen_tipo_trabajo_detalle.tinta_especial_coste_total.style.textDecoration = "none";
        		sumatoria += response.tintaEspecialCosteTotal;
        	}
        	// barniz
        	if( response.clienteProporcionaBarniz ) {
        		document.resumen_tipo_trabajo_detalle.frente_barniz_coste_total.style.textDecoration = "line-through";
        		document.resumen_tipo_trabajo_detalle.vuelta_barniz_coste_total.style.textDecoration = "line-through";
        	} else {
        		document.resumen_tipo_trabajo_detalle.frente_barniz_coste_total.style.textDecoration = "none";
        		document.resumen_tipo_trabajo_detalle.vuelta_barniz_coste_total.style.textDecoration = "none";
        		sumatoria += response.frenteBarnizCosteTotal;
        		sumatoria += response.vueltaBarnizCosteTotal;
        	}
        	// placas
        	if( response.clienteProporcionaPlacas )
        		document.resumen_tipo_trabajo_detalle.placas_coste_total.style.textDecoration = "line-through";
        	else {
        		document.resumen_tipo_trabajo_detalle.placas_coste_total.style.textDecoration = "none";
        		sumatoria += response.placasCosteTotal;
        	}
        		
        		
        	document.resumen_tipo_trabajo_detalle.tipo_trabajo_detalle_coste_total.value 		= "$ " + (sumatoria).formatMoney(2);
        	delete sumatoria;
        	delete response;
		},
		error:function(e) {
			alert("Error. No fue posible conectarse con el servidor");
		}
	});
} // ajaxSubPartida

function ajaxProcesos( id_partida ) {
	limpiaFormProcesos();
	var nut = document.orden_produccion.nut.value;
	$.ajax({
		type:'POST',
		url:urlResumenCalificacionProcesos,
		data:{nut:nut, id_partida:id_partida},
		success:function(response){
			//console.log(response);
			document.getElementById("div_tabla_lista_procesos_disenio").innerHTML 		= response.htmlTablaProcesosDisenio;
			document.getElementById("div_tabla_lista_procesos_preprensa").innerHTML 	= response.htmlTablaProcesosPreprensa;
			document.getElementById("div_tabla_lista_procesos_transporte").innerHTML 	= response.htmlTablaProcesosTransporte;
			document.getElementById("div_tabla_lista_procesos_acabado").innerHTML 		= response.htmlTablaProcesosAcabado;
			var costeProcesosTotal = 
				response.disenioCosteTotal +
				response.preprensaCosteTotal +
				response.transporteCosteTotal +
				response.acabadoCosteTotal + 
				response.costoExtraTotal;
			document.resumen_procesos.procesos_coste_total.value = "$ " + (costeProcesosTotal).formatMoney(2);
			delete costeProcesosTotal;
		},
		error:function(response){
			alert("Error. No fue posible conectarse con el servidor");
		}
	});
} // ajaxProcesos


function carga_datos() {
	
	$("#arbol_partidas").on("changed.jstree", function(e, data){
        if( data.selected.length ) {
            //console.log( data );
            //alert( data.instance.get_node( data.selected[0] ).id );
            var identificador = "" + data.instance.get_node( data.selected[0] ).id + "";
            //console.log(identificador);
            var arreglo = identificador.split(":");
            if( arreglo[0] == "IdOrdProd" ) {
            	//console.log("entro a idOrdProd")
            	document.getElementById("div_orden_produccion_detalle").style.display 	= "block";
            	document.getElementById("div_partida_detalle").style.display 			= "none";
            	document.getElementById("div_tipo_trabajo_detalle").style.display 		= "none";
            	document.getElementById("div_procesos_acabado_detalle").style.display 	= "none";
            	
            } else if( arreglo[0] == "IdPartida" ) {
                //console.log("entro a IdPartida");
            	document.getElementById("div_orden_produccion_detalle").style.display 	= "none";
            	document.getElementById("div_partida_detalle").style.display 			= "block";
            	document.getElementById("div_tipo_trabajo_detalle").style.display 		= "none";
            	document.getElementById("div_procesos_acabado_detalle").style.display 	= "none";
                ajaxPartida( arreglo[1] );
            } else if( arreglo[0] == "IdSubpartida" ) {
                //console.log("entro a IdSubpartida");
            	document.getElementById("div_orden_produccion_detalle").style.display 	= "none";
            	document.getElementById("div_partida_detalle").style.display 			= "none";
            	document.getElementById("div_tipo_trabajo_detalle").style.display 		= "block";
            	document.getElementById("div_procesos_acabado_detalle").style.display 	= "none";
            	ajaxSubPartida( arreglo[1] );
            } else if(arreglo[0] == "IdProcExt") {
            	//console.log("entro a IdProcExt");
            	document.getElementById("div_orden_produccion_detalle").style.display 	= "none";
            	document.getElementById("div_partida_detalle").style.display 			= "none";
            	document.getElementById("div_tipo_trabajo_detalle").style.display 		= "none";
            	document.getElementById("div_procesos_acabado_detalle").style.display 	= "block";
            	ajaxProcesos( arreglo[1] );
            }
        }
    }).jstree({
        "core":{
            "data":JSON.parse(jsonArbol)
        }
    });
} // carga_datos


function condicionesProduccion() {
	Shadowbox.open({
        content:urlCondicionesProduccion + "?nut=" + document.orden_produccion.nut.value,
        player:"iframe",
        width:730,
        height:510,
        options:{ 
        	modal: false,
        	overlayOpacity: 0.75 
        }
    });
} // condicionesProduccion