
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
		document.getElementById("div_visualizador_costo_extra_detalle").style.display	= "none";
	    document.getElementById("div_costo_extra_detalle").style.display				= "none";
		document.getElementById("div_pestania").style.display 							= "none";
		document.getElementById("div_material_ayuda").style.display 					= "none";
		
	    $.ajax({
	        type:"POST",
	        url:urlObtienePartida,
	        data:{id_partida:id_partida},
	        success:function( response ) {
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
	            for( var j=0; j < document.getElementsByName("tipo_trabajo").length; j++ ) {
	                if( document.getElementsByName("tipo_trabajo")[j].value == partidaJson.descripcion_partida.idTipoTrabajo ) 
	                    document.getElementsByName("tipo_trabajo")[j].click();
	                document.getElementsByName("tipo_trabajo")[j].disabled = true;
	            }
	            document.getElementsByName("tipo_trabajo").disabled = true;
	            
	            // completa campos
	            document.forms["partida"].elements["nombre_partida"].value                  = partidaJson.descripcion_partida.nombrePartida;
	            document.forms["partida"].elements["cantidad"].value                        = partidaJson.descripcion_partida.cantidad;
	            document.forms["partida"].elements["forma_trabajo"].value                   = partidaJson.descripcion_partida.nombreTipoFormaTrabajo;
	            document.forms["partida"].elements["descripcion_partida"].value             = partidaJson.descripcion_partida.descripcionPartida;
	            document.forms["partida"].elements["observaciones_generales"].value         = partidaJson.descripcion_partida.observacionesGenerales;
	            document.forms["partida"].elements["observaciones_aprobacion"].value        = partidaJson.descripcion_partida.observacionesAprobacion;
	            document.forms["disenio"].elements["id_disenio"].value       				= partidaJson.disenio.idDisenio;
	            document.forms["disenio"].elements["indicacion_tarea_realizar"].value       = partidaJson.disenio.indicacionTareaRealizar;
	            document.forms["disenio"].elements["materiales_recibe"].value               = partidaJson.disenio.materialesRecibe;
	            document.forms["disenio"].elements["observaciones"].value                   = partidaJson.disenio.observaciones;
	            document.forms["preprensa"].elements["id_preprensa"].value     				= partidaJson.preprensa.idPreprensa;
	            document.forms["preprensa"].elements["indicacion_tarea_realizar"].value     = partidaJson.preprensa.indicacionTareaRealizar;
	            document.forms["preprensa"].elements["materiales_recibe"].value             = partidaJson.preprensa.materialesRecibe;
	            document.forms["preprensa"].elements["observaciones"].value                 = partidaJson.preprensa.observaciones;
	            document.forms["transporte"].elements["id_transporte"].value    			= partidaJson.transporte.idTransporte;
	            document.forms["transporte"].elements["indicacion_tarea_realizar"].value    = partidaJson.transporte.indicacionTareaRealizar;
	            document.forms["transporte"].elements["materiales_recibe"].value            = partidaJson.transporte.materialesRecibe;
	            document.forms["transporte"].elements["observaciones"].value                = partidaJson.transporte.observaciones;
	            document.forms["acabado"].elements["id_acabado"].value       				= partidaJson.acabado.idAcabado;
	            document.forms["acabado"].elements["indicacion_tarea_realizar"].value       = partidaJson.acabado.indicacionTareaRealizar;
	            document.forms["acabado"].elements["materiales_recibe"].value               = partidaJson.acabado.materialesRecibe;
	            document.forms["acabado"].elements["observaciones"].value                   = partidaJson.acabado.observaciones;
	            document.forms["offset"].elements["id_offset"].value        				= partidaJson.offset.idOffset;
	            document.forms["offset"].elements["indicacion_tarea_realizar"].value        = partidaJson.offset.indicacionTareaRealizar;
	            document.forms["offset"].elements["materiales_recibe"].value                = partidaJson.offset.materialesRecibe;
	            document.forms["offset"].elements["observaciones"].value                    = partidaJson.offset.observaciones;
	          
	            // asignacion de las tablas de detalle_partida
	            document.getElementById("div_tabla_lista_disenio_detalle").innerHTML		= partidaJson.disenio_detalle;
	            document.getElementById("div_tabla_lista_preprensa_detalle").innerHTML      = partidaJson.preprensa_detalle;
	            document.getElementById("div_tabla_lista_transporte_detalle").innerHTML     = partidaJson.transporte_detalle;
	            document.getElementById("div_tabla_lista_acabado_detalle").innerHTML        = partidaJson.acabado_detalle;
	            document.getElementById("div_tabla_lista_material_ayuda").innerHTML         = partidaJson.material_ayuda;
	            
	            // asignacion de la tabla subpartidas.
	            document.getElementById("div_tabla_lista_tipo_trabajo_detalle").innerHTML   = partidaJson.lista_subpartidas;
	            
	            // limpia campos de tipo_trabajo_detalle
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_papel"].disabled               = false;
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_placas"].disabled              = false;
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_tinta_especial"].disabled      = false;
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_barniz"].disabled              = false;
	            document.forms["tipo_trabajo_detalle"].elements["descripcion_partida_detalle"].value        = "";
	            document.forms["tipo_trabajo_detalle"].elements["alto_final"].value                         = "";
	            document.forms["tipo_trabajo_detalle"].elements["ancho_final"].value                        = "";
	            document.forms["tipo_trabajo_detalle"].elements["alto_extendido"].value                     = "";
	            document.forms["tipo_trabajo_detalle"].elements["ancho_extendido"].value                    = "";
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_papel"].checked                = false;
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_placas"].checked               = false;
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_tinta_especial"].checked       = false;
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_barniz"].checked               = false;
	            document.forms["tipo_trabajo_detalle"].elements["tipo_papel"].value                         = "";
	            document.forms["tipo_trabajo_detalle"].elements["repeticiones_x_pliego"].value              = "";
	            document.forms["tipo_trabajo_detalle"].elements["numero_paginas_publicacion"].value         = "";
	            document.forms["tipo_trabajo_detalle"].elements["tamanio_pubicacion"].value                 = "";
	            document.forms["tipo_trabajo_detalle"].elements["alto_corte_inicial"].value                 = "";
	            document.forms["tipo_trabajo_detalle"].elements["ancho_corte_inicial"].value                = "";
	            document.forms["tipo_trabajo_detalle"].elements["frente_combinacion_tintas"].value          = "";
	            document.forms["tipo_trabajo_detalle"].elements["frente_num_tinta_especial"].value          = "";
	            document.forms["tipo_trabajo_detalle"].elements["frente_descripcion_tinta_especial"].value  = "";
	            document.forms["tipo_trabajo_detalle"].elements["frente_tipo_barniz"].value                 = "";
	            document.forms["tipo_trabajo_detalle"].elements["vuelta_combinacion_tintas"].value          = "";
	            document.forms["tipo_trabajo_detalle"].elements["vuelta_num_tinta_especial"].value          = "";
	            document.forms["tipo_trabajo_detalle"].elements["vuelta_descripcion_tinta_especial"].value  = "";
	            document.forms["tipo_trabajo_detalle"].elements["vuelta_tipo_barniz"].value                 = "";
	            document.forms["tipo_trabajo_detalle"].elements["maquina"].value                            = "";
	            document.forms["tipo_trabajo_detalle"].elements["tipo_placa"].value                         = "";
	            
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_papel"].disabled               = true;
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_placas"].disabled              = true;
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_tinta_especial"].disabled      = true;
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_barniz"].disabled              = true;
	            
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
	            obj_partida.setObjPartida();
	            
	            document.getElementById("div_partida").style.display 							= "block";
	            document.getElementById("div_visualizador_tipo_trabajo_detalle").style.display 	= "block";
	            
	        },
	        error:function( e ) {
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
	        type:"POST",
	        url:urlObtieneTipoTrabajoDetalle,
	        data:{id_tipo_trabajo_detalle:id_tipo_trabajo_detalle},
	        success:function( response ) {
	        	//console.log(response);
	        	// set id_tipo_trabajo_detalle
	        	document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value = id_tipo_trabajo_detalle;
	        	document.visualizador_pliegos.id_tipo_trabajo_detalle.value	= id_tipo_trabajo_detalle;
	        	document.costo_extra_detalle.id_tipo_trabajo_detalle.value 	= id_tipo_trabajo_detalle;
	        	
	            var detallePartidaJson = JSON.parse( response.textoJson );
	            document.forms["tipo_trabajo_detalle"].elements["descripcion_partida_detalle"].value        = detallePartidaJson.tipo_trabajo_detalle.descripcion;
	            document.forms["tipo_trabajo_detalle"].elements["alto_final"].value                         = detallePartidaJson.tipo_trabajo_detalle.altoFinal;
	            document.forms["tipo_trabajo_detalle"].elements["ancho_final"].value                        = detallePartidaJson.tipo_trabajo_detalle.anchoFinal;
	            document.forms["tipo_trabajo_detalle"].elements["alto_extendido"].value                     = detallePartidaJson.tipo_trabajo_detalle.altoExtendido;
	            document.forms["tipo_trabajo_detalle"].elements["ancho_extendido"].value                    = detallePartidaJson.tipo_trabajo_detalle.anchoExtendido;
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_papel"].value                	= detallePartidaJson.tipo_trabajo_detalle.clienteProporcionaPapel==true?"Si":"No";
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_placas"].value               	= detallePartidaJson.tipo_trabajo_detalle.clienteProporcionaPlacas==true?"Si":"No";
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_tinta_especial"].value       	= detallePartidaJson.tipo_trabajo_detalle.clienteProporcionaTintaEspecial==true?"Si":"No";
	            document.forms["tipo_trabajo_detalle"].elements["proporciona_barniz"].value               	= detallePartidaJson.tipo_trabajo_detalle.clienteProporcionaBarniz==true?"Si":"No";
	            document.forms["tipo_trabajo_detalle"].elements["tipo_papel"].value                         = detallePartidaJson.tipo_trabajo_detalle.descripcionTipoPapelExtendido;
	            document.forms["tipo_trabajo_detalle"].elements["repeticiones_x_pliego"].value              = detallePartidaJson.tipo_trabajo_detalle.repeticionesXPliego;
	            document.forms["tipo_trabajo_detalle"].elements["numero_paginas_publicacion"].value         = detallePartidaJson.tipo_trabajo_detalle.numeroPaginasPublicacion;
	            document.forms["tipo_trabajo_detalle"].elements["tamanio_pubicacion"].value                 = detallePartidaJson.tipo_trabajo_detalle.descripcionTamanioPublicacion;
	            document.forms["tipo_trabajo_detalle"].elements["alto_corte_inicial"].value                 = detallePartidaJson.tipo_trabajo_detalle.altoCorteInicial;
	            document.forms["tipo_trabajo_detalle"].elements["ancho_corte_inicial"].value                = detallePartidaJson.tipo_trabajo_detalle.anchoCorteInicial;
	            document.forms["tipo_trabajo_detalle"].elements["frente_combinacion_tintas"].value          = detallePartidaJson.tipo_trabajo_detalle.frenteDescripcionNumTintas;
	            document.forms["tipo_trabajo_detalle"].elements["frente_num_tinta_especial"].value          = detallePartidaJson.tipo_trabajo_detalle.frenteNumTintaEspecial;
	            document.forms["tipo_trabajo_detalle"].elements["frente_descripcion_tinta_especial"].value  = detallePartidaJson.tipo_trabajo_detalle.frenteDescripcionTintaEspecial;
	            document.forms["tipo_trabajo_detalle"].elements["frente_tipo_barniz"].value                 = detallePartidaJson.tipo_trabajo_detalle.frenteDescripcionTipoBarniz;
	            document.forms["tipo_trabajo_detalle"].elements["vuelta_combinacion_tintas"].value          = detallePartidaJson.tipo_trabajo_detalle.vueltaDescripcionNumTintas;
	            document.forms["tipo_trabajo_detalle"].elements["vuelta_num_tinta_especial"].value          = detallePartidaJson.tipo_trabajo_detalle.vueltaNumTintaEspecial;
	            document.forms["tipo_trabajo_detalle"].elements["vuelta_descripcion_tinta_especial"].value  = detallePartidaJson.tipo_trabajo_detalle.vueltaDescripcionTintaEspecial;
	            document.forms["tipo_trabajo_detalle"].elements["vuelta_tipo_barniz"].value                 = detallePartidaJson.tipo_trabajo_detalle.vueltaDescripcionTipoBarniz;
	            document.forms["tipo_trabajo_detalle"].elements["maquina"].value                            = detallePartidaJson.tipo_trabajo_detalle.nombreMaquina;
	            document.forms["tipo_trabajo_detalle"].elements["tipo_placa"].value                         = detallePartidaJson.tipo_trabajo_detalle.descripcionPlaca;
	            document.forms["tipo_trabajo_detalle"].elements["tipo_complejidad"].value                   = detallePartidaJson.tipo_trabajo_detalle.descripcionComplejidad;
	            
	            document.getElementById("div_tabla_lista_pliegos").innerHTML                    = detallePartidaJson.lista_pliegos;
	            document.getElementById("div_tabla_costo_extra_tipo_trabajo").innerHTML         = detallePartidaJson.lista_costo_extra_detalle;
	            document.getElementById("div_tipo_trabajo_detalle").style.display 				= "block";
	            document.getElementById("div_visualizador_pliegos").style.display				= "block";
	            document.getElementById("div_visualizador_costo_extra_detalle").style.display	= "block";
	            document.getElementById("div_costo_extra_detalle").style.display				= "block";
	            document.getElementById("div_pestania").style.display							= "block";
	            document.getElementById("div_material_ayuda").style.display						= "block";
	            
	            delete detallePartidaJson;
	            
	            // GUARDA RESULTADOS TTD EN OBJETO javascript
	            obj_ttd.setObjTTD();
	        },
	        error:function( e ) {
	            console.log( e );
	            alert("No fue posible encontrar informaci\u00f3n");
	        }
	    });
	}
} // buscaTrabajoDetalle

function ajaxCambiaEstatus() {
	document.forms["cambio_estatus"].elements["id_orden_produccion"].value 	= document.forms["orden_produccion"].elements["id_orden_produccion"].value;
	document.forms["cambio_estatus"].elements["id_estatus_orden"].value 	= document.forms["cambio_estatus"].elements["select_estatus_orden_produccion"].value;
	
	// evitar el doble ingreso de registros en finalizado
	if( document.orden_produccion.estatus.value.toUpperCase() != "FINALIZADO" ) {
		$.ajax({
			type:"POST",
			url:urlCambiaEstatus,
			data:$("[name='cambio_estatus']").serialize(),
			success:function(response){
				//console.log(response);
				if(response.estatusOperacion != 0) {
					var index = document.forms["cambio_estatus"].elements["select_estatus_orden_produccion"].selectedIndex;
					document.forms["orden_produccion"].elements["estatus"].value = document.forms["cambio_estatus"].elements["select_estatus_orden_produccion"].options[index].text;
					// modifica texto en la ventana padre
					var id_td = "td_" + document.forms["orden_produccion"].elements["nut"].value;
					window.parent.document.getElementById(id_td).innerHTML = document.forms["cambio_estatus"].elements["select_estatus_orden_produccion"].options[index].text;
					// modifica color en la ventana padre
					window.parent.document.getElementById(id_td).removeAttribute("class");
					window.parent.document.getElementById(id_td).setAttribute("class","estatus_" + document.forms["cambio_estatus"].elements["select_estatus_orden_produccion"].value);
					// elimina la opcion de modificar la informacion.
					document.getElementById("div_btn_actualizar_orden_produccion").style.display 		= "none";
					document.getElementById("div_btn_actualizar_partida").style.display 				= "none";
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
		                document.forms["cambio_estatus"].elements["select_estatus_orden_produccion"].add( option );
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
							content:urlCostoExtraDetalle + "?nut=" + document.orden_produccion.nut.value,
							player:"iframe",
							width:830,
							height:580,
							options:{
								modal:true, // IMPERATIVO CERRAR MANUALMENTE
								overlayOpacity:0.75
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
