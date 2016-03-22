
function menu(obj) {
    // funcion utilizada en el menu de detalle por area, en las pestanias del menu
    switch( obj.id ) {
        case "div_pestania_menu_disenio":
            document.getElementById("div_pestania_menu_disenio").style.backgroundColor      = "#7FAADC";
            document.getElementById("div_pestania_menu_preprensa").style.backgroundColor    = "#E2E2E2";
            document.getElementById("div_pestania_menu_transporte").style.backgroundColor   = "#E2E2E2";
            document.getElementById("div_pestania_menu_acabado").style.backgroundColor 		= "#E2E2E2";
            document.getElementById("div_pestania_menu_offset").style.backgroundColor       = "#E2E2E2";
            
            document.getElementById("div_pestania_contenido_disenio").style.display         = "block";
            document.getElementById("div_pestania_contenido_preprensa").style.display       = "none";
            document.getElementById("div_pestania_contenido_transporte").style.display      = "none";
            document.getElementById("div_pestania_contenido_acabado").style.display         = "none";
            document.getElementById("div_pestania_contenido_offset").style.display          = "none";
            break;
            
        case "div_pestania_menu_preprensa":
            document.getElementById("div_pestania_menu_disenio").style.backgroundColor      = "#E2E2E2";
            document.getElementById("div_pestania_menu_preprensa").style.backgroundColor    = "#7FAADC";
            document.getElementById("div_pestania_menu_transporte").style.backgroundColor   = "#E2E2E2";
            document.getElementById("div_pestania_menu_acabado").style.backgroundColor 		= "#E2E2E2";
            document.getElementById("div_pestania_menu_offset").style.backgroundColor       = "#E2E2E2";
            
            document.getElementById("div_pestania_contenido_disenio").style.display         = "none";
            document.getElementById("div_pestania_contenido_preprensa").style.display       = "block";
            document.getElementById("div_pestania_contenido_transporte").style.display      = "none";
            document.getElementById("div_pestania_contenido_acabado").style.display         = "none";
            document.getElementById("div_pestania_contenido_offset").style.display          = "none";
            break;
            
        case "div_pestania_menu_transporte":
            document.getElementById("div_pestania_menu_disenio").style.backgroundColor      = "#E2E2E2";
            document.getElementById("div_pestania_menu_preprensa").style.backgroundColor    = "#E2E2E2";
            document.getElementById("div_pestania_menu_transporte").style.backgroundColor   = "#7FAADC";
            document.getElementById("div_pestania_menu_acabado").style.backgroundColor 		= "#E2E2E2";
            document.getElementById("div_pestania_menu_offset").style.backgroundColor       = "#E2E2E2";
            
            document.getElementById("div_pestania_contenido_disenio").style.display         = "none";
            document.getElementById("div_pestania_contenido_preprensa").style.display       = "none";
            document.getElementById("div_pestania_contenido_transporte").style.display      = "block";
            document.getElementById("div_pestania_contenido_acabado").style.display         = "none";
            document.getElementById("div_pestania_contenido_offset").style.display          = "none";
            break;
            
        case "div_pestania_menu_acabado":
            document.getElementById("div_pestania_menu_disenio").style.backgroundColor      = "#E2E2E2";
            document.getElementById("div_pestania_menu_preprensa").style.backgroundColor    = "#E2E2E2";
            document.getElementById("div_pestania_menu_transporte").style.backgroundColor   = "#E2E2E2";
            document.getElementById("div_pestania_menu_acabado").style.backgroundColor 		= "#7FAADC";
            document.getElementById("div_pestania_menu_offset").style.backgroundColor       = "#E2E2E2";
            
            document.getElementById("div_pestania_contenido_disenio").style.display         = "none";
            document.getElementById("div_pestania_contenido_preprensa").style.display       = "none";
            document.getElementById("div_pestania_contenido_transporte").style.display      = "none";
            document.getElementById("div_pestania_contenido_acabado").style.display         = "block";
            document.getElementById("div_pestania_contenido_offset").style.display          = "none";
            break;
            
        case "div_pestania_menu_offset":
            document.getElementById("div_pestania_menu_disenio").style.backgroundColor      = "#E2E2E2";
            document.getElementById("div_pestania_menu_preprensa").style.backgroundColor    = "#E2E2E2";
            document.getElementById("div_pestania_menu_transporte").style.backgroundColor   = "#E2E2E2";
            document.getElementById("div_pestania_menu_acabado").style.backgroundColor 		= "#E2E2E2";
            document.getElementById("div_pestania_menu_offset").style.backgroundColor       = "#7FAADC";
            
            document.getElementById("div_pestania_contenido_disenio").style.display         = "none";
            document.getElementById("div_pestania_contenido_preprensa").style.display       = "none";
            document.getElementById("div_pestania_contenido_transporte").style.display      = "none";
            document.getElementById("div_pestania_contenido_acabado").style.display         = "none";
            document.getElementById("div_pestania_contenido_offset").style.display          = "block";
            break;
            
        default:
            break;
    }
} // menu

function cambiaCampos( obj ) {
    if( obj.value == "1" ) {
        document.getElementById("numero_paginas_publicacion").style.display = "none";
        document.getElementById("tamanio_publicacion").style.display        = "none";
        document.getElementById("repeticiones_flyer").style.display         = "block";
    }else if( obj.value == "2" ) {
        document.getElementById("repeticiones_flyer").style.display         = "none";
        document.getElementById("numero_paginas_publicacion").style.display = "block";
        document.getElementById("tamanio_publicacion").style.display        = "block";
    } else {
        //document.getElementById("repeticiones_flyer").style.display         = "none";
        //document.getElementById("numero_paginas_publicacion").style.display = "none";
        //document.getElementById("tamanio_publicacion").style.display        = "none";
    }
} // cambiaCampos

//VARIABLE UTILIZADA PARA PERMITIR QUE SE SELECCIONEN PARTIDA
var puedeSeleccionarPartida = true;
function buscaPartida( id_partida ){
	
    //alert("busca_detalle_partida: " + id);
	if ( puedeSeleccionarPartida ) {
		// oculta divs
		document.getElementById("div_tipo_trabajo_detalle").style.display 				= "none";
		document.getElementById("div_visualizador_pliegos").style.display 				= "none";
		document.getElementById("div_descuento_tabulador_precios").style.display 		= "none";
		document.getElementById("div_visualizador_costo_extra_detalle").style.display	= "none";
	    document.getElementById("div_costo_extra_detalle").style.display				= "none";
		document.getElementById("div_pestania").style.display 							= "none";
		document.getElementById("div_material_ayuda").style.display 					= "none";
		
	    $.ajax({
	        type: "POST",
	        url: urlObtienePartida,
	        data: {id_partida:id_partida},
	        success: function( response ) {
	        	/* var json =  '{"descripcion_partida":{"id_tipo_trabajo":1,"nombre":"abc"},' +
	                            '"disenio":{"indicaciones":"a1","materiales_recibe":"a2","observaciones":"a3","tabla_disenio":"<table><tr><td>exito</td></tr></table>"}}'; */
	        	//console.log(response);
	            var partidaJson = JSON.parse( response.textoJson );
	            
	            // set id_partida en todos los forms
	            document.partida.id_partida.value 				= partidaJson.descripcion_partida.idPartida;
	            document.tipo_trabajo_detalle.id_partida.value 	= partidaJson.descripcion_partida.idPartida;
	            document.disenio_detalle.id_partida.value		= partidaJson.descripcion_partida.idPartida;
	            document.preprensa_detalle.id_partida.value		= partidaJson.descripcion_partida.idPartida;
	            document.transporte_detalle.id_partida.value	= partidaJson.descripcion_partida.idPartida;
	            document.acabado_detalle.id_partida.value		= partidaJson.descripcion_partida.idPartida;
	            document.material_ayuda.id_partida.value 		= partidaJson.descripcion_partida.idPartida;
	            
	            // activa radio botones tipo_trabajo
	            for( var i=0; i < document.getElementsByName("tipo_trabajo").length; i++ ) 
	                document.getElementsByName("tipo_trabajo")[i].disabled = false;
	            
	            // desactiva radio botones tipo_trabajo
	            document.partida.id_tipo_trabajo.value = partidaJson.descripcion_partida.idTipoTrabajo;
	            for( var j=0; j < document.getElementsByName("tipo_trabajo").length; j++ ) {
	                if( document.getElementsByName("tipo_trabajo")[j].value == partidaJson.descripcion_partida.idTipoTrabajo ) 
	                    document.getElementsByName("tipo_trabajo")[j].click();
	                document.getElementsByName("tipo_trabajo")[j].disabled = true;
	            }
	            document.getElementsByName("tipo_trabajo").disabled = true;
	            
	            // completa campos
	            document.partida.nombre_partida.value 				= partidaJson.descripcion_partida.nombrePartida;
	            document.partida.cantidad.value						= partidaJson.descripcion_partida.cantidad;
	            document.partida.forma_trabajo.value 				= partidaJson.descripcion_partida.nombreTipoFormaTrabajo;
	            document.partida.descripcion_partida.value 			= partidaJson.descripcion_partida.descripcionPartida;
	            document.partida.observaciones_generales.value		= partidaJson.descripcion_partida.observacionesGenerales;
	            document.partida.observaciones_aprobacion.value		= partidaJson.descripcion_partida.observacionesAprobacion;
	            document.disenio.id_disenio.value					= partidaJson.disenio.idDisenio;
	            document.disenio.indicacion_tarea_realizar.value	= partidaJson.disenio.indicacionTareaRealizar;
	            document.disenio.materiales_recibe.value			= partidaJson.disenio.materialesRecibe;
	            document.disenio.observaciones.value				= partidaJson.disenio.observaciones;
	            document.preprensa.id_preprensa.value				= partidaJson.preprensa.idPreprensa;
	            document.preprensa.indicacion_tarea_realizar.value  = partidaJson.preprensa.indicacionTareaRealizar;
	            document.preprensa.materiales_recibe.value			= partidaJson.preprensa.materialesRecibe;
	            document.preprensa.observaciones.value				= partidaJson.preprensa.observaciones;
	            document.transporte.id_transporte.value				= partidaJson.transporte.idTransporte;
	            document.transporte.indicacion_tarea_realizar.value	= partidaJson.transporte.indicacionTareaRealizar;
	            document.transporte.materiales_recibe.value			= partidaJson.transporte.materialesRecibe;
	            document.transporte.observaciones.value				= partidaJson.transporte.observaciones;
	            document.acabado.id_acabado.value					= partidaJson.acabado.idAcabado;
	            document.acabado.indicacion_tarea_realizar.value	= partidaJson.acabado.indicacionTareaRealizar;
	            document.acabado.materiales_recibe.value			= partidaJson.acabado.materialesRecibe;
	            document.acabado.observaciones.value				= partidaJson.acabado.observaciones;
	            document.offset.id_offset.value						= partidaJson.offset.idOffset;
	            document.offset.indicacion_tarea_realizar.value		= partidaJson.offset.indicacionTareaRealizar;
	            document.offset.materiales_recibe.value				= partidaJson.offset.materialesRecibe;
	            document.offset.observaciones.value					= partidaJson.offset.observaciones;
	          
	            // asignacion de las tablas de detalle_partida
	            document.getElementById("div_tabla_lista_disenio_detalle").innerHTML		= partidaJson.disenio_detalle;
	            document.getElementById("div_tabla_lista_preprensa_detalle").innerHTML      = partidaJson.preprensa_detalle;
	            document.getElementById("div_tabla_lista_transporte_detalle").innerHTML     = partidaJson.transporte_detalle;
	            document.getElementById("div_tabla_lista_acabado_detalle").innerHTML        = partidaJson.acabado_detalle;
	            document.getElementById("div_tabla_lista_material_ayuda").innerHTML         = partidaJson.material_ayuda;
	            
	            // asignacion de la tabla subpartidas.
	            document.getElementById("div_tabla_lista_tipo_trabajo_detalle").innerHTML   = partidaJson.lista_subpartidas;
	            
	            // limpia campos de tipo_trabajo_detalle
	            document.tipo_trabajo_detalle.proporciona_papel.disabled               = false;
	            document.tipo_trabajo_detalle.proporciona_placas.disabled              = false;
	            document.tipo_trabajo_detalle.proporciona_tinta_especial.disabled      = false;
	            document.tipo_trabajo_detalle.proporciona_barniz.disabled              = false;
	            document.tipo_trabajo_detalle.descripcion_partida_detalle.value        = "";
	            document.tipo_trabajo_detalle.alto_final.value                         = "";
	            document.tipo_trabajo_detalle.ancho_final.value                        = "";
	            document.tipo_trabajo_detalle.alto_extendido.value                     = "";
	            document.tipo_trabajo_detalle.ancho_extendido.value                    = "";
	            document.tipo_trabajo_detalle.proporciona_papel.checked                = false;
	            document.tipo_trabajo_detalle.proporciona_placas.checked               = false;
	            document.tipo_trabajo_detalle.proporciona_tinta_especial.checked       = false;
	            document.tipo_trabajo_detalle.proporciona_barniz.checked               = false;
	            document.tipo_trabajo_detalle.tipo_papel.value                         = "";
	            document.tipo_trabajo_detalle.repeticiones_x_pliego.value              = "";
	            document.tipo_trabajo_detalle.numero_paginas_publicacion.value         = "";
	            document.tipo_trabajo_detalle.tamanio_pubicacion.value                 = "";
	            document.tipo_trabajo_detalle.alto_corte_inicial.value                 = "";
	            document.tipo_trabajo_detalle.ancho_corte_inicial.value                = "";
	            document.tipo_trabajo_detalle.frente_combinacion_tintas.value          = "";
	            document.tipo_trabajo_detalle.frente_num_tinta_especial.value          = "";
	            document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value  = "";
	            document.tipo_trabajo_detalle.frente_tipo_barniz.value                 = "";
	            document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value          = "";
	            document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value          = "";
	            document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value  = "";
	            document.tipo_trabajo_detalle.vuelta_tipo_barniz.value                 = "";
	            document.tipo_trabajo_detalle.maquina.value                            = "";
	            document.tipo_trabajo_detalle.tipo_placa.value                         = "";
	            
	            document.tipo_trabajo_detalle.proporciona_papel.disabled               = true;
	            document.tipo_trabajo_detalle.proporciona_placas.disabled              = true;
	            document.tipo_trabajo_detalle.proporciona_tinta_especial.disabled      = true;
	            document.tipo_trabajo_detalle.proporciona_barniz.disabled              = true;
	            
	            document.getElementById("div_tabla_lista_pliegos").innerHTML = 
	            	"<table id=\"tabla_lista_pliegos\">" +
	                "<tr><th>No. Pgo<\/th><th>Rebase (mm.)<\/th>" +
	                "<th>Medianiles (mm.)<\/th>" +
	                "<th>Pinzas (cm.)<\/th>" +
	                "<th>H. Requeridas<\/th>" +
	                "<th>H. Sobrantes<\/th>" +
	                "<th>H. Totales<\/th>" +
	                "<th width=\"20%\">Observaciones<\/th>" +
	                "<th>Frente Ent. M&aacute;quina<\/th>" +
	                "<th>Frente Num. Placas<\/th>" +
	                "<th>Vuelta Ent. M&aacute;quina<\/th>" +
	                "<th>Vuelta Num. Placas<\/th><\/tr>" +
	                "<tr class=\"l1\">" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td><\/tr>" +
	                "<tr class=\"l2\">" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td><\/tr>" +
	                "<tr>" +
	                "<td><i>TOTAL<\/i><\/td>" +
	                "<td><\/td><td><\/td>" +
	                "<td><\/td><td><i>&nbsp;<\/i><\/td>" +
	                "<td><i>&nbsp;<\/i><\/td>" +
	                "<td><i>&nbsp;<\/i><\/td>" +
	                "<td><\/td><td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<td>&nbsp;<\/td>" +
	                "<\/tr>" +
	                "<\/table>";
	            
	            delete partidaJson;
	            
	            // GUARDA RESULTADOS PARTIDA EN OBJETO javascript
	            obj_ttd.setObjTTD();
	            
	            document.getElementById("div_partida").style.display 							= "block";
	            document.getElementById("div_visualizador_tipo_trabajo_detalle").style.display 	= "block";
	            
	        },
	        error: function( e ) {
	            console.log( e );
	            alert("No fue posible encontrar informaci\u00f3n");
	        }
	    });
	}
} // buscaDetallePartida


// VARIABLE UTILIZADA PARA PERMITIR QUE SE SELECCIONEN TTD
var puedeSeleccionarTipoTrabajoDetalle = true;
function buscaTrabajoDetalle( id_tipo_trabajo_detalle ) {
	
	if ( puedeSeleccionarTipoTrabajoDetalle ) {
	    //alert( id_tipo_trabajo_detalle );
	    $.ajax({
	        type: "POST",
	        url: urlObtieneTipoTrabajoDetalle,
	        data: {id_tipo_trabajo_detalle:id_tipo_trabajo_detalle},
	        success: function( response ) {
	        	//console.log(response);
	        	// set id_tipo_trabajo_detalle
	        	document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value = id_tipo_trabajo_detalle;
	        	document.visualizador_pliegos.id_tipo_trabajo_detalle.value	= id_tipo_trabajo_detalle;
	        	document.descuento.id_tipo_trabajo_detalle.value			= id_tipo_trabajo_detalle;
	        	document.costo_extra_detalle.id_tipo_trabajo_detalle.value 	= id_tipo_trabajo_detalle;
	        	
	            var tipoTrabajoDetalleJson = JSON.parse( response.textoJson );
	            
	            // actualizacion form tipo_trabajo_detalle
	            document.tipo_trabajo_detalle.descripcion_partida_detalle.value			= tipoTrabajoDetalleJson.tipo_trabajo_detalle.descripcion;
	            document.tipo_trabajo_detalle.alto_final.value							= tipoTrabajoDetalleJson.tipo_trabajo_detalle.altoFinal;
	            document.tipo_trabajo_detalle.ancho_final.value							= tipoTrabajoDetalleJson.tipo_trabajo_detalle.anchoFinal;
	            document.tipo_trabajo_detalle.alto_extendido.value						= tipoTrabajoDetalleJson.tipo_trabajo_detalle.altoExtendido;
	            document.tipo_trabajo_detalle.ancho_extendido.value						= tipoTrabajoDetalleJson.tipo_trabajo_detalle.anchoExtendido;
	            document.tipo_trabajo_detalle.proporciona_papel.value					= tipoTrabajoDetalleJson.tipo_trabajo_detalle.clienteProporcionaPapel==true?"Si":"No";
	            document.tipo_trabajo_detalle.proporciona_placas.value					= tipoTrabajoDetalleJson.tipo_trabajo_detalle.clienteProporcionaPlacas==true?"Si":"No";
	            document.tipo_trabajo_detalle.proporciona_tinta_especial.value			= tipoTrabajoDetalleJson.tipo_trabajo_detalle.clienteProporcionaTintaEspecial==true?"Si":"No";
	            document.tipo_trabajo_detalle.proporciona_barniz.value					= tipoTrabajoDetalleJson.tipo_trabajo_detalle.clienteProporcionaBarniz==true?"Si":"No";
	            document.tipo_trabajo_detalle.tipo_papel.value							= tipoTrabajoDetalleJson.tipo_trabajo_detalle.descripcionTipoPapelExtendido;
	            document.tipo_trabajo_detalle.repeticiones_x_pliego.value				= tipoTrabajoDetalleJson.tipo_trabajo_detalle.repeticionesXPliego;
	            document.tipo_trabajo_detalle.numero_paginas_publicacion.value			= tipoTrabajoDetalleJson.tipo_trabajo_detalle.numeroPaginasPublicacion;
	            document.tipo_trabajo_detalle.tamanio_pubicacion.value					= tipoTrabajoDetalleJson.tipo_trabajo_detalle.descripcionTamanioPublicacion;
	            document.tipo_trabajo_detalle.alto_corte_inicial.value					= tipoTrabajoDetalleJson.tipo_trabajo_detalle.altoCorteInicial;
	            document.tipo_trabajo_detalle.ancho_corte_inicial.value					= tipoTrabajoDetalleJson.tipo_trabajo_detalle.anchoCorteInicial;
	            document.tipo_trabajo_detalle.frente_combinacion_tintas.value			= tipoTrabajoDetalleJson.tipo_trabajo_detalle.frenteDescripcionNumTintas;
	            document.tipo_trabajo_detalle.frente_num_tinta_especial.value			= tipoTrabajoDetalleJson.tipo_trabajo_detalle.frenteNumTintaEspecial;
	            document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value	= tipoTrabajoDetalleJson.tipo_trabajo_detalle.frenteDescripcionTintaEspecial;
	            document.tipo_trabajo_detalle.frente_tipo_barniz.value					= tipoTrabajoDetalleJson.tipo_trabajo_detalle.frenteDescripcionTipoBarniz;
	            document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value			= tipoTrabajoDetalleJson.tipo_trabajo_detalle.vueltaDescripcionNumTintas;
	            document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value			= tipoTrabajoDetalleJson.tipo_trabajo_detalle.vueltaNumTintaEspecial;
	            document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value	= tipoTrabajoDetalleJson.tipo_trabajo_detalle.vueltaDescripcionTintaEspecial;
	            document.tipo_trabajo_detalle.vuelta_tipo_barniz.value					= tipoTrabajoDetalleJson.tipo_trabajo_detalle.vueltaDescripcionTipoBarniz;
	            document.tipo_trabajo_detalle.maquina.value								= tipoTrabajoDetalleJson.tipo_trabajo_detalle.nombreMaquina;
	            document.tipo_trabajo_detalle.tipo_placa.value							= tipoTrabajoDetalleJson.tipo_trabajo_detalle.descripcionPlaca;
	            document.tipo_trabajo_detalle.tipo_complejidad.value					= tipoTrabajoDetalleJson.tipo_trabajo_detalle.descripcionComplejidad;
	            
	            // actualizacion del form descuento
	            	// llena el select tabulador precios
	            $("[name='select_tabulador_precios']").empty();
	            $.each( tipoTrabajoDetalleJson.lista_tabulador_precios, function(i, item){
        			var option = document.createElement("option");
        			option.value = item.value;
        			option.text	 = item.text;
        			document.getElementById("select_precio_tabulador").add(option);
        			delete option;
            	});
	            	// llena form descuento
	            if ( tipoTrabajoDetalleJson.aplica_descuento != null ) {
		            document.descuento.input_aplica_descuento.value 		= tipoTrabajoDetalleJson.tipo_trabajo_detalle.aplicaDescuento==true?"Si":"No";
		            document.descuento.precio_tabulador.value 				= tipoTrabajoDetalleJson.aplica_descuento.precioTabulador;
		            document.descuento.tipo_precio.value 					= tipoTrabajoDetalleJson.aplica_descuento.tipoPrecio;
	            } else {
	            	document.descuento.input_aplica_descuento.value 		= "No";
	            }
	            
	            // actualiza listas
	            document.getElementById("div_tabla_lista_pliegos").innerHTML                    = tipoTrabajoDetalleJson.lista_pliegos;
	            document.getElementById("div_tabla_costo_extra_tipo_trabajo").innerHTML         = tipoTrabajoDetalleJson.lista_costo_extra_detalle;
	            
	            // muestra divs
	            document.getElementById("div_tipo_trabajo_detalle").style.display 				= "block";
	            document.getElementById("div_visualizador_pliegos").style.display				= "block";
	            document.getElementById("div_descuento_tabulador_precios").style.display 		= "block";
	            document.getElementById("div_visualizador_costo_extra_detalle").style.display	= "block";
	            document.getElementById("div_costo_extra_detalle").style.display				= "block";
	            document.getElementById("div_pestania").style.display							= "block";
	            document.getElementById("div_material_ayuda").style.display						= "block";
	            
	            delete tipoTrabajoDetalleJson;
	            
	            // GUARDA RESULTADOS TTD EN OBJETO javascript PARA NO OLVIDARLOS
	            obj_ttd.setObjTTD();
	        },
	        error: function( e ) {
	            console.log( e );
	            alert("No fue posible encontrar informaci\u00f3n");
	        }
	    });
	}
} // buscaTrabajoDetalle

function ajaxCambiaEstatus() {
	document.cambio_estatus.id_orden_produccion.value 	= document.orden_produccion.id_orden_produccion.value;
	document.cambio_estatus.id_estatus_orden.value 	= document.cambio_estatus.select_estatus_orden_produccion.value;
	
	// evitar el doble ingreso de registros en finalizado
	if( document.orden_produccion.estatus.value.toUpperCase() != "FINALIZADO" ) {
		$.ajax({
			type:"POST",
			url:urlCambiaEstatus,
			data:$("[name='cambio_estatus']").serialize(),
			success:function(response){
				//console.log(response);
				if(response.estatusOperacion != 0) {
					var index = document.cambio_estatus.select_estatus_orden_produccion.selectedIndex;
					document.orden_produccion.estatus.value = document.cambio_estatus.select_estatus_orden_produccion.options[index].text;
					// modifica texto en la ventana padre
					var id_td = "td_" + document.orden_produccion.nut.value;
					window.parent.document.getElementById(id_td).innerHTML = document.cambio_estatus.select_estatus_orden_produccion.options[index].text;
					// modifica color en la ventana padre
					window.parent.document.getElementById(id_td).removeAttribute("class");
					window.parent.document.getElementById(id_td).setAttribute("class","estatus_" + document.cambio_estatus.select_estatus_orden_produccion.value);
					// elimina la opcion de modificar la informacion.
					document.getElementById("div_btn_actualizar_orden_produccion").style.display 		= "none";
					document.getElementById("div_btn_actualizar_partida").style.display 				= "none";
					document.getElementById("div_btn_agregar_ttd_encabezado").style.display 			= "none";
					document.getElementById("div_btn_actualizar_ttd_encabezado").style.display 			= "none";
					document.getElementById("div_btn_agregar_costo_extra_detalle").style.display 		= "none";
					document.getElementById("div_btn_actualizar_costo_extra_detalle").style.display 	= "none";
					document.getElementById("div_btn_modificar_disenio").style.display 					= "none";
					document.getElementById("div_btn_agregar_disenio_detalle").style.display 			= "none";
					document.getElementById("div_btn_actualizar_disenio_detalle").style.display 		= "none";
					document.getElementById("div_btn_modificar_preprensa").style.display 				= "none";
					document.getElementById("div_btn_agregar_preprensa_detalle").style.display 			= "none";
					document.getElementById("div_btn_actualizar_preprensa_detalle").style.display 		= "none";
					document.getElementById("div_btn_modificar_transporte").style.display 				= "none";
					document.getElementById("div_btn_agregar_transporte_detalle").style.display 		= "none";
					document.getElementById("div_btn_actualizar_transporte_detalle").style.display 		= "none";
					document.getElementById("div_btn_modificar_acabado").style.display 					= "none";
					document.getElementById("div_btn_agregar_acabado_detalle").style.display 			= "none";
					document.getElementById("div_btn_actualizar_acabado_detalle").style.display 		= "none";
					document.getElementById("div_btn_modificar_offset").style.display 					= "none";
					document.getElementById("div_btn_agregar_material_ayuda").style.display 			= "none";
					document.getElementById("div_btn_actualizar_material_ayuda").style.display 			= "none";
					// modifica select de cambio de estatus
					$("[name='select_estatus_orden_produccion']").empty();
					var jsonObject = JSON.parse(response.textoJson);
					$.each( jsonObject, function(i, item) {
		                //alert( item.id_tipo_placa + ' ' + item.descripcion );
		                var option = document.createElement("option");
		                option.text     = item.text;
		                option.value    = item.value;
		                document.cambio_estatus.select_estatus_orden_produccion.add( option );
		                delete option;
		            } );
		            delete jsonObject;
					// elimina variables
					delete index;
					delete id_td;
					
					// SI CAMBIO ESTATUS == FINALIZADO ENTONCES ABRE VENTANA DE COSTO EXTRA
					if( document.cambio_estatus.id_estatus_orden.value == 10 ) {
						//abre ventana modal para guardar costo extra
						Shadowbox.open({
							content: urlCostoExtraDetalle + "?nut=" + document.orden_produccion.nut.value,
							player: "iframe",
							width: 830,
							height: 580,
							options: {
								modal: true, // IMPERATIVO CERRAR MANUALMENTE
								overlayOpacity: 0.75,
							}
						});
					}
				}
			},
			error:function(e){
				alert("NO fue posible actualizar el estado de la Orden de Produccion");
				console.log(e);
			}
		});
	}
} // ajaxCambiaEstatus

function muestraDetallePrecio() {
	document.precio.action 	= urlObtienePrecioDetalle;
	document.precio.submit();
} // muestraDetallePrecio
