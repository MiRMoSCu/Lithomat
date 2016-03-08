
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


function buscaPartida( id_partida ){
	
    //alert("busca_detalle_partida: " + id);
	
	// oculta divs
	document.getElementById("div_tipo_trabajo_detalle").style.display 				= "none";
	document.getElementById("div_visualizador_pliegos").style.display 				= "none";
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
            document.material_ayuda.id_partida.value 		= partidaJson.descripcion_partida.idPartida;
            
            // activa radio botones tipo_trabajo
            for( var i=0; i < document.getElementsByName("tipo_trabajo").length; i++ ) {
                document.getElementsByName("tipo_trabajo")[i].disabled = false;
            }
            
            // desactiva radio botones tipo_trabajo
            for( var j=0; j < document.getElementsByName("tipo_trabajo").length; j++ ) {
                if( document.getElementsByName("tipo_trabajo")[j].value == partidaJson.descripcion_partida.idTipoTrabajo ) {
                    document.getElementsByName("tipo_trabajo")[j].click();
                }
                document.getElementsByName("tipo_trabajo")[j].disabled = true;
            }
            document.getElementsByName("tipo_trabajo").disabled = true;
            
            // completa campos
            document.partida.nombre_partida.value 				= partidaJson.descripcion_partida.nombrePartida;
            document.partida.cantidad.value                     = partidaJson.descripcion_partida.cantidad;
            document.partida.forma_trabajo.value                = partidaJson.descripcion_partida.nombreTipoFormaTrabajo;
            document.partida.descripcion_partida.value          = partidaJson.descripcion_partida.descripcionPartida;
            document.partida.observaciones_generales.value      = partidaJson.descripcion_partida.observacionesGenerales;
            document.partida.observaciones_aprobacion.value     = partidaJson.descripcion_partida.observacionesAprobacion;
            
            document.disenio.id_disenio.value       			= partidaJson.disenio.idDisenio;
            document.disenio.indicacion_tarea_realizar.value    = partidaJson.disenio.indicacionTareaRealizar;
            document.disenio.materiales_recibe.value            = partidaJson.disenio.materialesRecibe;
            document.disenio.observaciones.value                = partidaJson.disenio.observaciones;
            
            document.preprensa.id_preprensa.value     			= partidaJson.preprensa.idPreprensa;
            document.preprensa.indicacion_tarea_realizar.value  = partidaJson.preprensa.indicacionTareaRealizar;
            document.preprensa.materiales_recibe.value          = partidaJson.preprensa.materialesRecibe;
            document.preprensa.observaciones.value              = partidaJson.preprensa.observaciones;
            
            document.transporte.id_transporte.value    			= partidaJson.transporte.idTransporte;
            document.transporte.indicacion_tarea_realizar.value = partidaJson.transporte.indicacionTareaRealizar;
            document.transporte.materiales_recibe.value         = partidaJson.transporte.materialesRecibe;
            document.transporte.observaciones.value             = partidaJson.transporte.observaciones;
            
            document.acabado.id_acabado.value       			= partidaJson.acabado.idAcabado;
            document.acabado.indicacion_tarea_realizar.value    = partidaJson.acabado.indicacionTareaRealizar;
            document.acabado.materiales_recibe.value            = partidaJson.acabado.materialesRecibe;
            document.acabado.observaciones.value                = partidaJson.acabado.observaciones;
            
            document.offset.id_offset.value        				= partidaJson.offset.idOffset;
            document.offset.indicacion_tarea_realizar.value     = partidaJson.offset.indicacionTareaRealizar;
            document.offset.materiales_recibe.value             = partidaJson.offset.materialesRecibe;
            document.offset.observaciones.value                 = partidaJson.offset.observaciones;
          
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
            
            document.getElementById("div_partida").style.display 							= "block";
            document.getElementById("div_visualizador_tipo_trabajo_detalle").style.display 	= "block";
            
        },
        error:function( e ) {
            console.log( e );
            alert("No fue posible encontrar informaci\u00f3n");
        }
    });
} // buscaDetallePartida


function buscaTrabajoDetalle( id_tipo_trabajo_detalle ) {
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
        	
            var detallePartidaJson = JSON.parse( response.textoJson );
            document.tipo_trabajo_detalle.descripcion_partida_detalle.value        	= detallePartidaJson.tipo_trabajo_detalle.descripcion;
            document.tipo_trabajo_detalle.alto_final.value                         	= detallePartidaJson.tipo_trabajo_detalle.altoFinal;
            document.tipo_trabajo_detalle.ancho_final.value                        	= detallePartidaJson.tipo_trabajo_detalle.anchoFinal;
            document.tipo_trabajo_detalle.alto_extendido.value                     	= detallePartidaJson.tipo_trabajo_detalle.altoExtendido;
            document.tipo_trabajo_detalle.ancho_extendido.value                    	= detallePartidaJson.tipo_trabajo_detalle.anchoExtendido;
            document.tipo_trabajo_detalle.proporciona_papel.value 					= detallePartidaJson.tipo_trabajo_detalle.clienteProporcionaPapel==true?"Si":"No";
            document.tipo_trabajo_detalle.proporciona_placas.value               	= detallePartidaJson.tipo_trabajo_detalle.clienteProporcionaPlacas==true?"Si":"No";
            document.tipo_trabajo_detalle.proporciona_tinta_especial.value       	= detallePartidaJson.tipo_trabajo_detalle.clienteProporcionaTintaEspecial==true?"Si":"No";
            document.tipo_trabajo_detalle.proporciona_barniz.value               	= detallePartidaJson.tipo_trabajo_detalle.clienteProporcionaBarniz==true?"Si":"No";
            document.tipo_trabajo_detalle.tipo_papel.value                         	= detallePartidaJson.tipo_trabajo_detalle.descripcionTipoPapelExtendido;
            document.tipo_trabajo_detalle.repeticiones_x_pliego.value              	= detallePartidaJson.tipo_trabajo_detalle.repeticionesXPliego;
            document.tipo_trabajo_detalle.numero_paginas_publicacion.value         	= detallePartidaJson.tipo_trabajo_detalle.numeroPaginasPublicacion;
            document.tipo_trabajo_detalle.tamanio_pubicacion.value                 	= detallePartidaJson.tipo_trabajo_detalle.descripcionTamanioPublicacion;
            document.tipo_trabajo_detalle.alto_corte_inicial.value                 	= detallePartidaJson.tipo_trabajo_detalle.altoCorteInicial;
            document.tipo_trabajo_detalle.ancho_corte_inicial.value                	= detallePartidaJson.tipo_trabajo_detalle.anchoCorteInicial;
            document.tipo_trabajo_detalle.frente_combinacion_tintas.value          	= detallePartidaJson.tipo_trabajo_detalle.frenteDescripcionNumTintas;
            document.tipo_trabajo_detalle.frente_num_tinta_especial.value          	= detallePartidaJson.tipo_trabajo_detalle.frenteNumTintaEspecial;
            document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value  	= detallePartidaJson.tipo_trabajo_detalle.frenteDescripcionTintaEspecial;
            document.tipo_trabajo_detalle.frente_tipo_barniz.value                 	= detallePartidaJson.tipo_trabajo_detalle.frenteDescripcionTipoBarniz;
            document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value          	= detallePartidaJson.tipo_trabajo_detalle.vueltaDescripcionNumTintas;
            document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value          	= detallePartidaJson.tipo_trabajo_detalle.vueltaNumTintaEspecial;
            document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value  	= detallePartidaJson.tipo_trabajo_detalle.vueltaDescripcionTintaEspecial;
            document.tipo_trabajo_detalle.vuelta_tipo_barniz.value                 	= detallePartidaJson.tipo_trabajo_detalle.vueltaDescripcionTipoBarniz;
            document.tipo_trabajo_detalle.maquina.value                            	= detallePartidaJson.tipo_trabajo_detalle.nombreMaquina;
            document.tipo_trabajo_detalle.tipo_placa.value                         	= detallePartidaJson.tipo_trabajo_detalle.descripcionPlaca;
            document.tipo_trabajo_detalle.tipo_complejidad.value                   	= detallePartidaJson.tipo_trabajo_detalle.descripcionComplejidad;
            
            document.getElementById("div_tabla_lista_pliegos").innerHTML                    = detallePartidaJson.lista_pliegos;
            document.getElementById("div_tipo_trabajo_detalle").style.display 				= "block";
            document.getElementById("div_visualizador_pliegos").style.display				= "block";
            document.getElementById("div_pestania").style.display							= "block";
            document.getElementById("div_material_ayuda").style.display						= "block";
            
            delete detallePartidaJson;
        },
        error:function( e ) {
            console.log( e );
            alert("No fue posible encontrar informaci\u00f3n");
        }
    });
} // buscaTrabajoDetalle


function ajaxCambiaEstatus() {
	document.cambio_estatus.id_orden_produccion.value 	= document.orden_produccion.id_orden_produccion.value;
	document.cambio_estatus.id_estatus_orden.value 		= document.cambio_estatus.select_estatus_orden_produccion.value;
	
	// evitar el doble ingreso de registros en finalizado
	if( document.orden_produccion.estatus.value.toUpperCase() != "FINALIZADO" ) {
		$.ajax({
			type:"POST",
			url:urlCambiaEstatus,
			data:$("[name='cambio_estatus']").serialize(),
			success:function(response){
				//console.log(response);
				if(response.estatusOperacion != 0) {
					// actualiza la busqueda del visualizador_semaforo para solo mostrar los registros correctos de la misma pagina
					window.parent.realiza_consulta_paginador();
					// cierra ventana modal
					window.parent.Shadowbox.close();
				}
			},
			error:function(e){
				alert("NO fue posible actualizar el estado de la Orden de Produccion");
				console.log(e);
			}
		});
	}
} // ajaxCambiaEstatus


