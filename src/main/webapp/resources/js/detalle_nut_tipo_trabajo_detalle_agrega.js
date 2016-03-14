
function ocultaDiv() {
	document.getElementById("div_tipo_trabajo_detalle").style.display 				= "none";
	document.getElementById("div_visualizador_pliegos").style.display 				= "none";
	document.getElementById("div_visualizador_costo_extra_detalle").style.display	= "none";
    document.getElementById("div_costo_extra_detalle").style.display				= "none";
	document.getElementById("div_pestania").style.display 							= "none";
	document.getElementById("div_material_ayuda").style.display 					= "none";
}

function muestraDiv() {
	document.getElementById("div_tipo_trabajo_detalle").style.display 				= "block";
	document.getElementById("div_visualizador_pliegos").style.display 				= "block";
	document.getElementById("div_visualizador_costo_extra_detalle").style.display	= "block";
    document.getElementById("div_costo_extra_detalle").style.display				= "block";
	document.getElementById("div_pestania").style.display 							= "block";
	document.getElementById("div_material_ayuda").style.display 					= "block";
}

function limpiaYActivaCamposFormTipoTrabajoDetalle() {
	document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value = "";
	inicializaCheckbox( false );
	inicializaSelect();
	muestraCheckbox();
	muestraSelect();
	buscaTipoPlaca( document.tipo_trabajo_detalle.select_maquina );
	inicializaBlancosCamposVisibles();
	desactivaReadonlyCamposVisibles();
	aplicaColorFFFCamposVisibles();
} // limpiaYActivaCamposFormTipoTrabajoDetalle

function limpiaYDesactivaCamposFormTipoTrabajoDetalle() {
	inicializaCheckbox( false );
	ocultaCheckbox();
	ocultaSelect();
	inicializaBlancosCamposVisibles();
	activaReadonlyCamposVisibles()
	aplicaColorTransparentCamposVisibles();
} // limpiaYDesactivaCamposFormTipoTrabajoDetalle


function activaBotonesAgregarFormTTD() {
	document.getElementById("imgBtnAgregarTTD").style.display 			= "none";
	document.getElementById("imgBtnCancelaAgregarTTD").style.display 	= "inline";
	document.getElementById("imgBtnAceptaAgregarTTD").style.display 	= "inline";
}

function desactivaBotonesAgregarFormTTD() {
	document.getElementById("imgBtnAgregarTTD").style.display 			= "inline";
	document.getElementById("imgBtnCancelaAgregarTTD").style.display 	= "none";
	document.getElementById("imgBtnAceptaAgregarTTD").style.display 	= "none";
}


function agregaTTD() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_agregar_ttd_encabezado").style.display = "inline";
	// ocultar divs que estan abajo de la seccion tipo trabajo detalle
	ocultaDiv();
	// elimina permiso para seleccionar PARTIDA  Y TTD; variable declarada en detalle_nut.js
	puedeSeleccionarPartida				= false;
	puedeSeleccionarTipoTrabajoDetalle 	= false;
	// elimina estilo de tabla que permite seleccionar ttd
	var styleSheetList = document.styleSheets;
	styleSheetList[3].cssRules[19].style.cursor 			= "default";
	styleSheetList[3].cssRules[19].style.backgroundColor 	= "transparent";
	styleSheetList[3].cssRules[19].style.color 				= "#898987";
	delete styleSheetList;
	//NO BORRAR: // console.log( styleSheetList );
	//NO BORRAR: // console.log( styleSheetList[3].cssRules[19].cssText );
	//NO BORRAR: // console.log( "cursor: " + styleSheetList[3].cssRules[19].style.cursor );
	//NO BORRAR: // console.log( "backgroundColor: " + styleSheetList[3].cssRules[19].style.backgroundColor );
	//NO BORRAR: // console.log( "color: " + styleSheetList[3].cssRules[19].style.color );
	// limpia y activa campos del form
	limpiaYActivaCamposFormTipoTrabajoDetalle();
	// muestra el form TTD
	document.getElementById("div_tipo_trabajo_detalle").style.display = "block";
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesAgregarFormTTD()
}


var esPrimerInsercionTTD 			= true;
var cerradoOKVentanaListaPliegos 	= false;
function aceptaAgregarTTD() {
	// se copian los datos del html a variables ocultas para poder desactivar los objetos html mas adelante y no perder su valor
	copiaValorDeCheckboxAHidden();
	copiaValorDeSelectAHidden();
	// validacion
	if ( validaDatosFormTTD() ) {
		// realiza ajac
		document.body.style.cursor = "wait";
		desactivaCamposFormTipoTrabajoDetalle();
		desactivaBotonesModificarFormTipoTrabajoDetalle();
		
		$.ajax({
            type: "POST",
            url: esPrimerInsercionTTD ? urlAgregaTipoTrabajoDetalle : urlActualizaTipoTrabajoDetalle,
            data: $("[name='tipo_trabajo_detalle']").serialize(),
            success: function( response ) { 
                //var json = JSON.stringify(eval("(" + response + ")"));    // forma de convertir cadenas a json
                //var json = JSON.parse(response);                          // forma de convertir cadenas a json
                switch( response.estatusOperacion ) {
                    case 0: // error
                        //console.log(e);
                    	console.log("ERROR aceptaAgregarTTD.ajax.switch.case0");
                        document.body.style.cursor = "default";
                        alert("No fue posible generar el detalle de impresion");
                        ocultaDiv();
                        limpiaYDesactivaCamposFormTipoTrabajoDetalle();
                        desactivaBotonesAgregarFormTTD();
        				muestraBotonesModificarPorSeccion();
                        break;
                        
                    default:
                    	// GUARDA RESULTADOS PARTIDA EN OBJETO javascript
        				obj_ttd.setObjTTD();
                    console.log( obj_ttd );
                    	// verifica que sea primera insercion para copiar idttd a los demas devis
                    	if ( esPrimerInsercionTTD ) {
                    		document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value	= response.idTipoTrabajoDetalle;
                            document.visualizador_pliegos.id_tipo_trabajo_detalle.value = response.idTipoTrabajoDetalle;
                        	document.costo_extra_detalle.id_tipo_trabajo_detalle.value 	= response.idTipoTrabajoDetalle;
                    	}
                        // cambia cursor
                        document.body.style.cursor = "default";
                        // abre ventana modal de pliegos
                        Shadowbox.open({
                            content:urlCalculaPliego + "?id_tipo_trabajo_detalle=" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value,
                            //content: "<form method='post' action='" + urlCalculaPliego + "' target='hidden_iframe'><input type='hidden' name='id_tipo_trabajo_detalle' value='" + response.id_tipo_trabajo_detalle + "'></input</form><iframe name='hidden_iframe'></iframe>",
                            player:"iframe",
                            width:630,
                            height:700,
                            options:{ 
                            	modal: true,
                                overlayOpacity: 0.75,
                                onClose: revisaCierreTerceraVentanaModal // al cerrar esta ventana, se manda llamar revisaCierreVentanaModal()
                            }
                        });
                        break;
                }
            },
            error: function(e) {
                //console.log(e);
            	console.log("ERROR aceptaAgregarTTD.ajax");
                document.body.style.cursor = "default";
                alert("No fue posible generar el detalle de impresion");
                ocultaDiv();
                limpiaYDesactivaCamposFormTipoTrabajoDetalle();
                desactivaBotonesAgregarFormTTD();
				muestraBotonesModificarPorSeccion();
            }
        });
	} // if correcto	
} // aceptaAgregarTTD

function revisaCierreTerceraVentanaModal() {
	// alert("cerro la tercera ventana modal");
	// alert("el valor de la bandera es: " + cerradoOKVentanaListaPliegos);
	if( cerradoOKVentanaListaPliegos ) {
		// Ok.
		// ACTUALIZA TABLA TTD
		$.ajax({
			type: "POST",
			url: urlBuscaTipoTrabajoDetalle,
			data: {id_partida: document.tipo_trabajo_detalle.id_partida.value},
			success: function( response ) {
				// actualiza tabla
				document.getElementById("div_tabla_lista_tipo_trabajo_detalle").innerHTML = response.textoHTML;
	            // ACTUALIZA PRECIO
	            $.ajax({
	    			type: "POST",
	    			url: urlObtienePrecioNeto,
	    			data: {
	    				id_orden_produccion: document.tipo_trabajo_detalle.id_orden_produccion.value,
	    				nut: document.tipo_trabajo_detalle.nut.value
	    			},
	    			success: function( response ){
	    				// GUARDA RESULTADOS TTD EN OBJETO javascript PARA NO OLVIDARLOS, porque todo fue correcto
	    	            obj_ttd.setObjTTD();
	    				// se acaba de agregar registro, entonces ya no es primera insercion.
	    				esPrimerInsercionTTD = false;
	    				// actualiza precio
	    				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
	    				copiaValorDeCheckboxAText();
	    				// guarda la informacion de los select en los input correspondientes
	    				copiaValorDeSelectAText();
	    				// muestra secciones
	    				muestraDiv();
	    				// desctiva botones cancelar y aceptar
	    				desactivaBotonesAgregarFormTTD();
	    				// muestra botones modificacion
	    				muestraBotonesModificarPorSeccion();
	    				// activa estilos para permitir seleccionar el registro
	    				var styleSheetList = document.styleSheets;
	    				styleSheetList[3].cssRules[19].style.cursor 			= "pointer";
	    				styleSheetList[3].cssRules[19].style.backgroundColor 	= "#99CCFF";
	    				styleSheetList[3].cssRules[19].style.color 				= "#000";
	    				delete styleSheetList;
	    				// activa permiso para seleccionar TTD; variable declarada en detalle_nut.js
	    				puedeSeleccionarPartida				= true;
	    				puedeSeleccionarTipoTrabajoDetalle 	= true;
	    			},
	    			error: function(e){
	    				console.log("ERROR revisaCierreTerceraVentanaModal.ajax2");
	    				alert("No fue posible obtener precio neto");
	    				muestraBotonesModificarPorSeccion();
	    			}
	    		});
			},
			error: function( e ) {
				console.log("ERROR revisaCierreTerceraVentanaModal.ajax1");
				document.body.style.cursor = "default";
                alert("No fue posible comunicarse con el servidor");
			}
		});
		// inicializa variable
		cerradoOKVentanaListaPliegos = false;
	} else {
		// la ventana no se cerro con el boton agregar
    	// se debe permitir la modificacion del registro TTD
    	esPrimerInsercionTTD = false;
    	// permite modificar nuevamente la informacion
    	activaCamposFormTipoTrabajoDetalle();
	}
} // revisaCierreTerceraVentanaModal

function cancelaAgregarTTD() {
	ocultaDiv();
	limpiaYDesactivaCamposFormTipoTrabajoDetalle();
	desactivaBotonesAgregarFormTTD();
	// activa permiso para seleccionar TTD; variable declarada en detalle_nut.js
	puedeSeleccionarPartida				= true;
	puedeSeleccionarTipoTrabajoDetalle 	= true;
	// activa estilos para permitir seleccionar el registro
	var styleSheetList = document.styleSheets;
	styleSheetList[3].cssRules[19].style.cursor 			= "pointer";
	styleSheetList[3].cssRules[19].style.backgroundColor 	= "#99CCFF";
	styleSheetList[3].cssRules[19].style.color 				= "#000";
	delete styleSheetList;
	muestraBotonesModificarPorSeccion();
}
