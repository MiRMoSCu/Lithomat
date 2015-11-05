
//variables globales
var cerradoOKVentanaListaPliegos = false;


// funciones

function searchLikeGoogle(str){
	//console.log(event);
	//alert(str);
	if( str.trim() != "" ) {
		
		var input = String.fromCharCode(event.keyCode);
		if (/[a-zA-Z0-9-_]/.test(input)) {
			$.ajax({
				type:'POST',
				url:urlBuscaNombreCliente,
				data:{nombre_moral:str},
				success:function(response){
					//console.log(response);
					var existeRegistro = false;
					$("[name='select_search']").empty();
		            $.each( response, function(i, item) {
		                //alert( item.id_tipo_placa + ' ' + item.descripcion );
		                //console.log(item);
		                var option = document.createElement("option");
		                option.text     = item.text;
		                option.value    = item.value;
		                document.cliente.select_search.add(option);
		                delete option;
		                existeRegistro = true;
		            } );
		            delete jsonObject;
		            
					if( existeRegistro ) {
						document.cliente.select_search.options[0].selected = true;
	    				$("#div_search_like_google").slideDown();
					}
					existeRegistro = null;
				},
				error:function(e){
					console.log(e);
				}
			});
		}
		
		if( event.keyCode == 40 ) { // key Down
			document.cliente.select_search.focus();
			document.cliente.nombre_moral.value = document.cliente.select_search.options[document.cliente.select_search.selectedIndex].text;
		}
		if( event.keyCode == 13) {
			//alert("entro al enter");
			document.cliente.select_search.options[0].selected = true;
			preparaAjaxBuscaCliente()
		}	
	}
}


function closeSearchLikeGoogle(){
	$("#div_search_like_google").slideUp(function(){
		document.cliente.select_search.options[0].selected = true;
	});
}


function preparaAjaxBuscaCliente() {
	//console.log("esta en: preparaAjaxBuscaCliente");
	document.cliente.id_cliente.value = document.cliente.select_search.value;
	ajaxBuscaCliente()
}


function enterSearchLikeGoogle() {
	//console.log("entro a enterSearchLikeGoogle");
	document.cliente.nombre_moral.value = document.cliente.select_search.options[document.cliente.select_search.selectedIndex].text;
	if( event.keyCode == 13 ) {
		preparaAjaxBuscaCliente();
	}
}


function ajaxBuscaCliente() {
    //alert( $('#form_cliente').serialize() );
    document.forms["cliente"].elements["id_cliente"].blur();
    var id_cliente = document.forms["cliente"].elements["id_cliente"].value;
    if( id_cliente != "" ) {
        document.body.style.cursor = "wait";
        $.ajax({
            type:"POST",
            url:urlBuscaCliente,
            data:{id_cliente:id_cliente}, //$('[name=form_cliente]').serialize(), //$('#form_cliente').serialize(),
            success:function( response ) {
                //console.log(response);
                //var JSONObject = { "id_cliente":"1","id_tipo_cliente":"8","clave_cliente":"ME","nombre_representante":"Gerardo Nieto Lopez" };
                document.forms["cliente"].elements["nombre_moral"].value           = response.nombreMoral;
                document.forms["cliente"].elements["clave"].value                  = response.clave;
                document.forms["cliente"].elements["nombre_representante"].value   = response.nombreRepresentante;
                document.forms["cliente"].elements["calle"].value                  = response.calle;
                document.forms["cliente"].elements["num_exterior"].value           = response.numExterior;
                document.forms["cliente"].elements["num_interior"].value           = response.numInterior;
                document.forms["cliente"].elements["colonia"].value                = response.colonia;
                document.forms["cliente"].elements["delegacion_municipio"].value   = response.delegacionMunicipio;
                document.forms["cliente"].elements["estado"].value                 = response.estado;
                document.forms["cliente"].elements["codigo_postal"].value          = response.codigoPostal;
                document.forms["cliente"].elements["rfc"].value                    = response.rfc;
                document.forms["cliente"].elements["telefono_particular"].value    = response.telefonoParticular;
                document.forms["cliente"].elements["telefono_movil"].value         = response.telefonoMovil;
                document.forms["cliente"].elements["observaciones"].value          = response.observaciones;
                closeSearchLikeGoogle();
                document.body.style.cursor = "default";
            },
            error:function(e) {
            	//console.log("error en ajaxBuscaCliente");
                console.log(e);
                document.body.style.cursor = "default";
                alert("No existe cliente con Id = " + id_cliente + ".");
                limpiaFormCliente();
            }
        });
        delete id_cliente;
    } else {
    	alert("Campo Id. Cliente no puede estar vac\u00edo. Favor de informarlo.");
    }
} // ajaxBuscaCliente()


function ajaxAgregaOrdenProduccion() {
    
    document.forms["orden_produccion"].elements["id_usuario"].value                 = "1"; // aqui debe colocarse el usuario correcto de sesion
    document.forms["orden_produccion"].elements["id_cliente"].value                 = document.forms["cliente"].elements["id_cliente"].value;;
    document.forms["orden_produccion"].elements["id_tipo_comprobante_fiscal"].value = document.forms["orden_produccion"].elements["select_comprobante_fiscal"].value;
    
    var id_cliente      = document.forms["cliente"].elements["id_cliente"].value;
    var nombre_orden    = document.forms["orden_produccion"].elements["nombre"].value;
    var descripcion     = document.forms["orden_produccion"].elements["descripcion"].value;
    
    // VALIDACIONES
    var correcto = true;
    
    // revisa que el campo id_cliente no este vacio
    if( correcto && id_cliente == "" ) {
        correcto = false;
        alert("Campo Id. Cliente no puede estar vac\u00edo. Favor de informarlo.");
        document.forms["cliente"].elements["id_cliente"].focus();
    }
    
    // revisa que el nombre y la descripcion de la orden no esten vacios
    if( correcto && nombre_orden == "" || descripcion == "" ) {
        correcto = false;
        alert("Campos Nombre y Descripcion de la orden de procducci\u00f3n no pueden estar vac\u00edos. Favor de informarlos.");
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // form cliente desactiva campos
        document.forms["cliente"].elements["id_cliente"].readOnly               = true;
        document.forms["cliente"].elements["nombre_moral"].readOnly             = true;
        // muestra botones desactivados
        document.getElementById("imgBtnBuscaCliente").style.cursor              = "auto";
        document.getElementById("imgBtnBuscaCliente").removeAttribute("onclick");
        document.getElementById("imgBtnLimpiaClienteActivo").style.display      = "none";
        document.getElementById("imgBtnLimpiaClienteInactivo").style.display    = "inline";
        // desactiva campos y botones
        desactivaCamposOrdenProduccion();
        desactivaBtnOrdenProduccion();
        
        $.ajax({
            type:"POST",
            url:urlAgregaOrdenProduccion,
            data:$("[name='orden_produccion']").serialize(), //{nombre:'Gera'},
            success:function( response ) {
                //console.log(response);
            	document.body.style.cursor = "default";
                switch( response.estatusOperacion ) {
                    case 0: // error
                        //console.log(e);
                        alert("No fue posible generar la orden de producci\u00f3n.");
                        // form cliente activa botones
                        document.forms["cliente"].elements["id_cliente"].readOnly   = false;
                        document.forms["cliente"].elements["nombre_moral"].readOnly = false;
                        // muestra botones originales
                        document.getElementById("imgBtnLimpiaClienteActivo").style.display      = "inline";
                        document.getElementById("imgBtnLimpiaClienteInactivo").style.display    = "none";
                        document.getElementById("imgBtnBuscaCliente").style.cursor              = "auto";
                        document.getElementById("imgBtnBuscaCliente").setAttribute("onclick","ajaxBuscaCliente();");
                        // activa campos y botones
                        activaCamposOrdenProduccion();
                        activaBtnOrdenProduccion();
                        break;
                
                    default: // exito
                        // llena el campo id_orden_produccion en el form partida porque es necesario
                        document.forms["partida"].elements["id_orden_produccion"].value     = response.idOrdenProduccion;
                        document.forms["cotizacion"].elements["id_orden_produccion"].value  = response.idOrdenProduccion;
                        document.getElementById("div_partida").style.display = "block";
                        break;
                }
            },
            error:function(e) {
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible generar la orden de producci\u00f3n.");
                // form cliente activa botones
                document.forms["cliente"].elements["id_cliente"].readOnly   = false;
                document.forms["cliente"].elements["nombre_moral"].readOnly = false;
                // muestra botones originales
                document.getElementById("imgBtnLimpiaClienteActivo").style.display      = "inline";
                document.getElementById("imgBtnLimpiaClienteInactivo").style.display    = "none";
                document.getElementById("imgBtnBuscaCliente").style.cursor              = "auto";
                document.getElementById("imgBtnBuscaCliente").setAttribute("onclick","ajaxBuscaCliente();");
                // activa campos y botones
                activaCamposOrdenProduccion();
                activaBtnOrdenProduccion();
            }
        });
    } // if correcto
    
    delete id_cliente;
    delete nombre_orden;
    delete descripcion;
} // ajaxAgregaOrdenProduccion()


function ajaxAgregaPartida() {
    //alert('si entro a la funcion ajax');
    document.forms["partida"].elements["id_tipo_trabajo"].value         = document.forms["partida"].elements["tipo_trabajo"].value;
    document.forms["partida"].elements["id_tipo_forma_trabajo"].value   = document.forms["partida"].elements["select_forma_trabajo"].value;
    
    var nombre_partida  = document.forms["partida"].elements["nombre_partida"].value;
    var cantidad        = document.forms["partida"].elements["cantidad"].value;
    var descripcion     = document.forms["partida"].elements["descripcion_partida"].value;
    
    // VALIDACIONES
    var correcto = true;
    
    // Revisa que nombre de partida, cantidad y descripcion no sean vacios
    if( nombre_partida == "" || cantidad == "" || descripcion == "" ) {
        correcto = false;
        alert("Los campos nombre, cantidad y descripci\u00f3n no pueden estar vac\u00edos. Favor de informarlos.");
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        desactivaCamposPartida();
        desactivaBtnPartida();
        
        // para enviar file input con ajax se usa formData
        var formData = new FormData( document.forms["partida"] ); 
        $.ajax({
            type:"POST",
            url:urlAgregaPartida,
            data:formData,
            processData: false,  // NO BORRAR: lo utiliza FormData; tell jQuery not to process the data
            contentType: false,  // NO BORRAR: lo utiliza FormData; tell jQuery not to set contentType
            success:function( response ) {
                switch( response.estatusOperacion ) {
                    case 0: // error
                        //console.log(e);
                        document.body.style.cursor = "default";
                        alert("No fue posible generar la partida.");
                        // activa campos y botones
                        activaCamposPartida();
                        activaBtnPartida();
                        break;
                        
                    default:
                        // se llena el select tipo_placa con la primer opcion del select_maquina
                        buscaTipoPlaca( document.forms["tipo_trabajo_detalle"].elements["select_maquina"] ); // orden_produccion.js
                        //console.log( response );
                        document.forms["partida"].elements["diagrama_formacion"].disabled   = true; // si se dsactiva arriba, entonces ya no lleva datos al hacer el ajax, por eso se desactiva aqu�
                        // se llenan todos los forms que necesitan saber id_partida
                        document.forms["tipo_trabajo_detalle"].elements["id_partida"].value = response.idPartida;
                        document.forms["disenio"].elements["id_partida"].value              = response.idPartida;
                        document.forms["preprensa"].elements["id_partida"].value            = response.idPartida;
                        document.forms["transporte"].elements["id_partida"].value           = response.idPartida;
                        document.forms["acabado"].elements["id_partida"].value              = response.idPartida;
                        document.forms["offset"].elements["id_partida"].value               = response.idPartida;
                        document.forms["material_ayuda"].elements["id_partida"].value       = response.idPartida;
                        // se llena los id correspondientes a disenio, preprensa, transporte, acabado y offset
                        document.disenio.id_disenio.value 		= response.idDisenio;
                        document.preprensa.id_preprensa.value 	= response.idPreprensa;
                        document.transporte.id_transporte.value = response.idTransporte;
                        document.acabado.id_acabado.value 		= response.idAcabado;
                        document.offset.id_offset.value 		= response.idOffset;
                        // se despliega el div
                        document.getElementById("div_tipo_trabajo_detalle").style.display = "block";
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error:function(e) {
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible generar la partida.");
                // activa campos y botones
                activaCamposPartida();
                activaBtnPartida();
            }
        });
        delete formData;
    } // if correcto
    
    delete nombre_partida;
    delete cantidad;
    delete descripcion;
} // ajaxAgregaPartida()


function ajaxBuscaPapelExtendido() {
	Shadowbox.open({
        content:urlBuscaTipoPapel,
        player:'iframe',
        width:1024,     //966
        height:800,    //600
        options:{ 
        	modal:true,
        	overlayOpacity: 0.75 }
    });
}


function ajaxAgregaTipoTrabajoDetalle() {

    /*
    Shadowbox.open({
        content: urlCalculaPliego + '?id_tipo_trabajo_detalle=4',
        player: 'iframe',
        width: 861,     //966
        height: 604,    //600
        options: { modal:true,
                   overlayOpacity: 0.75 }
    });
    */
    
    // se copian los datos del html a variables ocultas para poder desactivar los objetos html mas adelante y no perder su valor
    document.forms["tipo_trabajo_detalle"].elements["cliente_proporciona_papel"].value          = document.forms["tipo_trabajo_detalle"].elements["proporciona_papel"].checked;
    document.forms["tipo_trabajo_detalle"].elements["cliente_proporciona_tinta_especial"].value = document.forms["tipo_trabajo_detalle"].elements["proporciona_tinta_especial"].checked;
    document.forms["tipo_trabajo_detalle"].elements["cliente_proporciona_barniz"].value         = document.forms["tipo_trabajo_detalle"].elements["proporciona_barniz"].checked;
    document.forms["tipo_trabajo_detalle"].elements["cliente_proporciona_placas"].value         = document.forms["tipo_trabajo_detalle"].elements["proporciona_placas"].checked;
    document.forms["tipo_trabajo_detalle"].elements["id_tamanio_publicacion"].value             = document.forms["tipo_trabajo_detalle"].elements["select_tamanio_publicacion"].value;
    document.forms["tipo_trabajo_detalle"].elements["frente_id_combinacion_tintas"].value       = document.forms["tipo_trabajo_detalle"].elements["select_frente_combinacion_tintas"].value;
    document.forms["tipo_trabajo_detalle"].elements["frente_id_tipo_barniz"].value              = document.forms["tipo_trabajo_detalle"].elements["select_frente_tipo_barniz"].value;
    document.forms["tipo_trabajo_detalle"].elements["vuelta_id_combinacion_tintas"].value       = document.forms["tipo_trabajo_detalle"].elements["select_vuelta_combinacion_tintas"].value;
    document.forms["tipo_trabajo_detalle"].elements["vuelta_id_tipo_barniz"].value              = document.forms["tipo_trabajo_detalle"].elements["select_vuelta_tipo_barniz"].value;
    document.forms["tipo_trabajo_detalle"].elements["id_maquina"].value                         = document.forms["tipo_trabajo_detalle"].elements["select_maquina"].value;
    document.forms["tipo_trabajo_detalle"].elements["id_tipo_placa"].value                      = document.forms["tipo_trabajo_detalle"].elements["select_tipo_placa"].value;
    document.forms["tipo_trabajo_detalle"].elements["id_tipo_complejidad"].value                = document.forms["tipo_trabajo_detalle"].elements["select_tipo_complejidad"].value;
    
    var id_tipo_trabajo                     = document.forms["partida"].elements["id_tipo_trabajo"].value;
    var descripcion_partida_detalle         = document.forms["tipo_trabajo_detalle"].elements["descripcion_partida_detalle"].value;
    var ancho                               = document.forms["tipo_trabajo_detalle"].elements["ancho"].value;
    var alto                                = document.forms["tipo_trabajo_detalle"].elements["alto"].value;
    var repeticiones_x_pliego               = document.forms["tipo_trabajo_detalle"].elements["repeticiones_x_pliego"].value;
    var numero_paginas_publicacion          = document.forms["tipo_trabajo_detalle"].elements["numero_paginas_publicacion"].value;
    var descripcion_tipo_papel_extendido	= document.forms["tipo_trabajo_detalle"].elements["tipo_papel_extendido"].value;
    var frente_id_combinacion_tintas        = document.forms["tipo_trabajo_detalle"].elements["select_frente_combinacion_tintas"].value;
    var frente_num_tinta_especial           = document.forms["tipo_trabajo_detalle"].elements["frente_num_tinta_especial"].value;
    var frente_descripcion_tinta_especial   = document.forms["tipo_trabajo_detalle"].elements["frente_descripcion_tinta_especial"].value;
    var vuelta_id_combinacion_tintas        = document.forms["tipo_trabajo_detalle"].elements["select_vuelta_combinacion_tintas"].value;
    var vuelta_num_tinta_especial           = document.forms["tipo_trabajo_detalle"].elements["vuelta_num_tinta_especial"].value;
    var vuelta_descripcion_tinta_especial   = document.forms["tipo_trabajo_detalle"].elements["vuelta_descripcion_tinta_especial"].value;
    
    // VALIDACIONES
    var correcto = true;
    
    // Revisa que descripcion, ancho y alto no este vacios
    if( descripcion_partida_detalle == "" || ancho == "" || alto == "" ) {
        correcto = false;
        alert("Los campos descripci\u00f3n, ancho y alto no pueden estar vac\u00edos. Favor de informarlos.");
    }
    
    // Valida que el numero de repeticiones por flyer o paginas de revista sea mayor que cero
    switch( parseInt( id_tipo_trabajo ) ) {
        case 1:
            if( repeticiones_x_pliego == "" || parseInt( repeticiones_x_pliego ) <= 0 ) {
                correcto = false;
                alert("El n\u00famero de repeticiones deber ser un n\u00famero positivo mayor de cero");
                document.forms["tipo_trabajo_detalle"].elements["repeticiones_x_pliego"].focus();
            }
            break;
        
        case 2:
            if( numero_paginas_publicacion == "" || parseInt( numero_paginas_publicacion ) <= 0 || parseInt( numero_paginas_publicacion )%4 != 0 ) {
                correcto = false;
                alert("El n\u00famero de p\u00e1ginas deber ser un n\u00famero positivo mayor de cero y multiplo de 4");
                document.forms["tipo_trabajo_detalle"].elements["numero_paginas_publicacion"].focus();
            }
            
            if( document.forms["tipo_trabajo_detalle"].elements["select_tamanio_publicacion"].value == "1" ) {
                correcto = false;
                alert("El tama\u00f1o de la publicaci\u00f3n debe ser especificado");
                document.forms["tipo_trabajo_detalle"].elements["select_tamanio_publicacion"].focus();
            }
            break;
            
        case 3:
            break;
            
        default:
            break;
    } // switch validacion tipo trabajo
    
    // valida que existe papel
    if( correcto && descripcion_tipo_papel_extendido == "" ) {
    	correcto = false;
    	alert("Favor de especificar el tipo de papel");
    	document.forms["tipo_trabajo_detalle"].elements["tipo_papel_extendido"].focus();
    }
    
    // valida que si no hay tinta normal en frente, debe forzosamente haber tinta especial en frente
    if( correcto && frente_id_combinacion_tintas == "16" ) {
        // valida en frente si la tinta especial es mayor a cero, exista obligatoriamente una descripcion.
        if( frente_num_tinta_especial == "" || parseInt( frente_num_tinta_especial ) <= 0 ) {
            correcto = false;
            alert("Es necesario que exista al menos tinta especial en el frente");
            document.forms["tipo_trabajo_detalle"].elements["frente_num_tinta_especial"].focus();
        }   
    }
    
    /*
    // valida que si no hay tinta normal en vuelta, debe forzosamente haber tinta especial en vuelta
    if( vuelta_id_combinacion_tintas == "16" ) {
        // valida en vuelta si la tinta especial es mayor a cero, exista obligatoriamente una descripcion.
        if( vuelta_num_tinta_especial == '' || parseInt( vuelta_num_tinta_especial ) <= 0 ) {
            correcto = false;
            alert('Es necesario que exista al menos tinta especial en la vuelta');
            document.forms['tipo_trabajo_detalle'].elements['vuelta_num_tinta_especial'].focus();
        }
    }
    */
    
    // valida en frente si la tinta especial es mayor a cero, exista obligatoriamente una descripcion.
    if( correcto && (frente_num_tinta_especial == "" || parseInt( frente_num_tinta_especial ) < 0 || ( parseInt( frente_num_tinta_especial ) > 0 && frente_descripcion_tinta_especial == "" ) ) ) {
        correcto = false;
        alert("Es necesario que la cantidad de tinta sea mayor a cero, o especificar la desrcipci\u00f3n de la tinta especial en el frente");
        document.forms["tipo_trabajo_detalle"].elements["frente_descripcion_tinta_especial"].focus();
    }
    
    // valida en vuelta si la tinta especial es mayor a cero, exista obligatoriamente una descripcion.
    if( correcto && (vuelta_num_tinta_especial == "" || parseInt( vuelta_num_tinta_especial ) < 0 || ( parseInt( vuelta_num_tinta_especial ) > 0 && vuelta_descripcion_tinta_especial == "" ) ) ) {
        correcto = false;
        alert("Es necesario que la cantidad de tinta sea mayor a cero, o especificar la desrcipci\u00f3n de la tinta especial en la vuelta");
        document.forms["tipo_trabajo_detalle"].elements["vuelta_descripcion_tinta_especial"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        desactivaCamposTipoTrabajoDetalle();
        desactivaBtnTipoTrabajoDetalle();
        
        $.ajax({
            type:"POST",
            url:urlAgregaTipoTrabajoDetalle,
            data:$("[name='tipo_trabajo_detalle']").serialize(),
            success:function( response ) { 
                //var json = JSON.stringify(eval("(" + response + ")"));    // forma de convertir cadenas a json
                //var json = JSON.parse(response);                          // forma de convertir cadenas a json
                switch( response.estatusOperacion ) {
                    case 0: // error
                        //console.log(e);
                        document.body.style.cursor = "default";
                        alert("No fue posible generar el detalle de partida");
                        // activa campos y botones
                        activaCamposTipoTrabajoDetalle();
                        activaBtnTipoTrabajoDetalle();
                        break;
                        
                    default:
                        document.forms["visualizador_pliegos"].elements["id_tipo_trabajo_detalle"].value = response.idTipoTrabajoDetalle;
                    	document.forms["costo_extra_detalle"].elements["id_tipo_trabajo_detalle"].value = response.idTipoTrabajoDetalle;
                        // cambia cursor
                        document.body.style.cursor = "default";
                        
                        // abre ventana modal
                        Shadowbox.open({
                            content:urlCalculaPliego + "?id_tipo_trabajo_detalle=" + response.idTipoTrabajoDetalle,
                            //content: "<form method='post' action='" + urlCalculaPliego + "' target='hidden_iframe'><input type='hidden' name='id_tipo_trabajo_detalle' value='" + response.id_tipo_trabajo_detalle + "'></input</form><iframe name='hidden_iframe'></iframe>",
                            player:"iframe",
                            width:630,
                            height:769,
                            options:{ 
                            	modal: true,
                                overlayOpacity: 0.75,
                                onClose: revisaCierreVentanaModal 
                            }
                        });
                        break;
                }
            },
            error:function(e) {
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible generar el detalle de partida");
                // activa campos y botones
                activaCamposTipoTrabajoDetalle();
                activaBtnTipoTrabajoDetalle();
            }
        });
    } // if correcto
    
    delete descripcion_partida_detalle;
    delete ancho;
    delete alto;
    delete id_tipo_trabajo;
    delete repeticiones_x_pliego;
    delete numero_paginas_publicacion;
    delete frente_id_combinacion_tintas;
    delete frente_num_tinta_especial;
    delete frente_descripcion_tinta_especial;
    delete vuelta_id_combinacion_tintas;
    delete vuelta_num_tinta_especial;
    delete vuelta_descripcion_tinta_especial;        
} // ajaxAgregaDetallePartida()


function revisaCierreVentanaModal() { 
// esta funciona se manda llamar en la funcion response ok de la funcion ajax de ajaxAgregaDetallePartida()
    if( cerradoOKVentanaListaPliegos ) {
        document.getElementById("div_visualizador_pliegos").style.display       		= "block";
        document.getElementById("div_costo_extra_detalle").style.display 				= "block";
        document.getElementById("div_visualizador_costo_extra_detalle").style.display 	= "block";
        document.getElementById("div_nuevo_tipo_trabajo_detalle").style.display 		= "block";
    } else {
        // la ventana no se cerro con el boton agregar
        // 1) se debe eliminar el registro de tipo_trabajo_detalle, porque fue insertado, pero no es correcto
        $.ajax({
            type:"POST",
            url:urlEliminaDetallePartida,
            data:{id_tipo_trabajo_detalle:document.forms["visualizador_pliegos"].elements["id_tipo_trabajo_detalle"].value},
            success:function( response ) { 
                switch( response ) {
                    case 0: // error, no se pudo eliminar registro tipo_trabajo_detalle
                        alert("No fue posible eliminar el detalle de partida");
                        break;
                    default:
                        // activa campos y botones
                        activaCamposTipoTrabajoDetalle();
                        activaBtnTipoTrabajoDetalle();
                        break;
                }
            },
            error:function(e) {
                //console.log(e);
                alert("No fue posible ejecutar eliminacion de detalle de partida");
            }
        });
    } // if cerradoCorrectamente
    cerradoOKVentanaListaPliegos = false;
} // revisaVentanaModal()


function ajaxUnidadCostoExtra() {
	$.ajax({
		type:"POST",
		url:urlBuscaUnidadMedidaCostoExtra,
		data:{id_costo_extra:$("[name=select_costo_extra]").val()},
		success:function(response) {
			//alert(response);
			document.forms["costo_extra_detalle"].elements["nombre_unidad_medida"].value = response;
		},
		error:function(e) {
			console.log(e);
			document.costo_extra_detalle.nombre_unidad_medida.value = "-";
		}
	});
} // ajaxUnidadCostoExtra


function ajaxAgregaCostoExtraDetalle() {
	
	// VALIDACIONES
	var correcto = true;
	
	if( document.forms["costo_extra_detalle"].elements["cantidad"].value == "" ) {
		correcto = false;
		alert("Es necesario especificar la cantidad de costo extra");
		document.forms["costo_extra_detalle"].elements["cantidad"].focus();
	}
	
	if( correcto && document.forms["costo_extra_detalle"].elements["select_costo_extra"].selectedIndex == "-1" ) {
		correcto = false;
		alert("Es necesario especificar el costo extra");
		document.forms["costo_extra_detalle"].elements["select_costo_extra"].focus();
	}
	
	if( correcto && document.forms["costo_extra_detalle"].elements["select_responsable_insumo"].selectedIndex == "-1" ) {
		correcto = false;
		alert("Es necesario especificar el responsable del insumo");
		document.forms["costo_extra_detalle"].elements["select_costo_extra"].focus();
	}
	
	if( correcto ) {
		document.body.style.cursor = "wait";
		// desactiva campos y botones
		desactivaBtnCostoExtraDetalle();
		// copia valores a input hidden
		document.forms["costo_extra_detalle"].elements["id_costo_extra"].value 		= $("[name=select_costo_extra]").val();
		document.forms["costo_extra_detalle"].elements["id_responsable_insumo"].value = $("[name=select_responsable_insumo]").val();
		
		$.ajax({
			type:"POST",
			url:urlAgregaCostoExtra,
			data:$("[name='costo_extra_detalle']").serialize(),
			success:function(response) {
				// actualiza tabla html
				document.getElementById("div_tabla_costo_extra_tipo_trabajo").innerHTML = response.textoHTML;
				// elimina la opcion del select
				document.forms["costo_extra_detalle"].elements["select_costo_extra"].remove( document.forms["costo_extra_detalle"].elements["select_costo_extra"].selectedIndex );
				// limpia los campos
				limpiaCamposCostoExtraDetalle();
				activaBtnCostoExtraDetalle();
				// cambia cursor
                document.body.style.cursor = "default";
			},
			error:function(e) {
				console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar costo extra");
			}
		});
	}
	
} // ajaxAgregaCostoExtraDetalle


function preparaNuevoTipoTrabajoDetalle() {
    // busca la informacion del div div_visualizador_tipo_trabajo_detalle 
    ajaxBuscaTipoTrabajoDetalle();
    // se guarda la informacion id_partida antes de limpiar todo
    var id_partida = document.forms["tipo_trabajo_detalle"].elements["id_partida"].value;
    // limpia form div_tipo_trabajo_detalle y div_costo_extra_detalle
    limpiaFormTipoTrabajoDetalle();
    limpiaFormCostoExtraDetalle();
    // oculta divs no necesarios
    document.getElementById("div_visualizador_pliegos").style.display       		= "none";
    document.getElementById("div_visualizador_costo_extra_detalle").style.display 	= "none";
    document.getElementById("div_costo_extra_detalle").style.display       		= "none";
    document.getElementById("div_nuevo_tipo_trabajo_detalle").style.display 		= "none";
    // inicializa el form tipo_trabajo_detalle
    document.forms["tipo_trabajo_detalle"].elements["id_partida"].value = id_partida;
    document.forms["tipo_trabajo_detalle"].elements["descripcion_partida_detalle"].focus();
    // elimina variable de inicializacion
    delete id_partida;
} // preparaNuevoTipoTrabajoDetalle()


function muestraDetalleArea() {
	// desactiva campos del formulario costo extra detalle y desactiva boton agregar costo extra detalle
	desactivaCamposCostoExtraDetalle();
	desactivaBtnCostoExtraDetalle();
	
	// desactiva boton agregar tipo trabajo detalle
    document.getElementById("imgBtnAgregarTipoTrabajoDetalleActivo").style.display     = "none";
    document.getElementById("imgBtnAgregarTipoTrabajoDetalleInactivo").style.display   = "inline";

    document.getElementById("div_visualizador_pliegos").style.display       = "block";
    document.getElementById("div_pestania").style.display                   = "block";
    document.getElementById("div_material_ayuda").style.display             = "block";
    document.getElementById("div_nueva_partida").style.display              = "block";
    document.getElementById("div_cotizar").style.display                    = "block";
} // muestra_detalle_area()


function ajaxAgregaDisenio() {
	// EL REGISTRO EN BASE DE DATOS YA SE INGRESO, SOLO ES NECESARIO MODIFICAR SU CONTENIDO
	
    var indicacion_tarea = document.forms["disenio"].elements["indicacion_tarea_realizar"].value;
    
    // VALIDACIONES
    var correcto = true;
    
    // indicacion no este vacia
    if( indicacion_tarea == "" ) {
        correcto = false;
        alert("Es necesario especificar las indicaciones");
        document.forms["disenio"].elements["indicacion_tarea_realizar"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        desactivaCamposDisenio();
        desactivaBtnDisenio();
        
        $.ajax({
            type:"POST",
            url:urlModificaDisenio,
            data:$("[name='disenio']").serialize(),
            success: function( response ) { 
                //console.log( response );
                switch( response.estatusOperacion ) {
                    case 0: // error
                        document.body.style.cursor = "default";
                        alert("No fue posible insertar indicaciones de dise\u00f1o");
                        // activa campos y botones
                        activaCamposDisenio();
                        activaBtnDisenio();
                        break;
                        
                    default:
                        // establece id_disenio
                        document.forms["disenio_detalle"].elements["id_disenio"].value = response.idDisenio;
                        // activa campos y botones
                        activaCamposDisenioDetalle();
                        activaBtnDisenioDetalle();
                        // focus campo
                        document.forms["disenio_detalle"].elements["select_proceso_disenio"].focus();
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error: function(e) {
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar indicaciones de dise\u00f1o");
                // activa campos y botones
                activaCamposDisenio();
                activaBtnDisenio();
            }
        });
    } // if correcto
    
    delete indicacion_tarea;
    delete correcto;
} // ajaxAgregaDisenio()


function ajaxAgregaDisenioDetalle() {
    
    var cantidad            = document.forms["disenio_detalle"].elements["cantidad"].value;
    var especificaciones    = document.forms["disenio_detalle"].elements["especificaciones"].value;
    var precio_total_pesos  = document.forms["disenio_detalle"].elements["precio_total_pesos"].value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( document.forms["disenio_detalle"].elements["select_proceso_disenio"].selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle del dise\u00f1o");
        document.forms["disenio_detalle"].elements["select_proceso_disenio"].focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( correcto && ( cantidad == "" || parseInt( cantidad ) <= 0 )  ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.forms["disenio_detalle"].elements["cantidad"].focus();
    }
    
    // se dan las especificaciones del trabajo
    if( correcto && especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.forms["disenio_detalle"].elements["especificaciones"].focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( correcto && !$.isNumeric( precio_total_pesos ) ) {
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.forms["disenio_detalle"].elements["precio_total_pesos"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva botones
        desactivaBtnDisenioDetalle();
        
        $.ajax({
            type:"POST",
            url:urlAgregaDisenioDetalle,
            data:$("[name='disenio_detalle']").serialize(),
            success:function( response ) {
                switch( response.estatusOperacion ) {
                    case 0: // error
                        document.body.style.cursor = "default";
                        alert("No fue posible insertar indicaciones de detalle dise\u00f1o");
                        // activa botones
                        activaBtnDisenioDetalle();
                        break;
                        
                    default:
                        //console.log( response.textoHTML );
                        // actualiza la tabla html
                        document.getElementById("div_tabla_disenio_detalle").innerHTML = response.textoHTML;
                        // elimina la opcion del select
                        document.forms["disenio_detalle"].elements["select_proceso_disenio"].remove( document.forms["disenio_detalle"].elements["select_proceso_disenio"].selectedIndex );
                        // limpia campos y avtiva botones
                        limpiaCamposFormDisenioDetalle();
                        activaBtnDisenioDetalle();
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error:function( e ) {
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar indicaciones de detalle dise\u00f1o");
            }
        });
    }
    
    delete cantidad;
    delete especificaciones;
    delete precio_total_pesos;
    delete correcto;
} // ajaxAgregaDisenioDetalle()


function ajaxAgregaPreprensa() {
	// EL REGISTRO EN BASE DE DATOS YA SE INGRESO, SOLO ES NECESARIO MODIFICAR SU CONTENIDO
	
    var indicacion_tarea = document.forms["preprensa"].elements["indicacion_tarea_realizar"].value;
    
    // VALIDACIONES
    var correcto = true;
    
    if( indicacion_tarea == "" ) {
        correcto = false;
        alert("Es necesario especificar las indicaciones");
        document.forms["preprensa"].elements["indicacion_tarea_realizar"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        desactivaCamposPreprensa();
        desactivaBtnPreprensa();
        
        $.ajax({
            type:"POST",
            url:urlModificaPreprensa,
            data:$("[name='preprensa']").serialize(),
            success:function( response ) {
                switch( response.estatusOperacion ) {
                    case 0: // error
                        //console.log(e);
                        document.body.style.cursor = "default";
                        alert("No fue posible insertar indicaciones de preprensa");
                        // activa campos y botones
                        activaCamposPreprensa();
                        activaBtnPreprensa();
                        break;
                
                    default:
                        // establece id_preprensa
                        document.forms["preprensa_detalle"].elements["id_preprensa"].value = response.idPreprensa;
                        // activa campos y botones
                        activaCamposPreprensaDetalle();
                        activaBtnPreprensaDetalle();
                        // focus campo
                        document.forms["preprensa_detalle"].elements["select_proceso_preprensa"].focus();
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error:function( e ) {
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar indicaciones de preprensa");
                // activa campos y botones
                activaCamposPreprensa();
                activaBtnPreprensa();
            }
        });
    }
    
    delete indicacion_tarea;
    delete correcto;
} // ajaxAgregaPreprensa()


function ajaxAgregaPreprensaDetalle() {
    
    var cantidad            = document.forms["preprensa_detalle"].elements["cantidad"].value;
    var especificaciones    = document.forms["preprensa_detalle"].elements["especificaciones"].value;
    var precio_total_pesos  = document.forms["preprensa_detalle"].elements["precio_total_pesos"].value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( document.forms["preprensa_detalle"].elements["select_proceso_preprensa"].selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle de preprensa");
        document.forms["preprensa_detalle"].elements["select_proceso_preprensa"].focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( correcto && ( cantidad == "" || parseInt( cantidad ) <= 0 )  ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.forms["preprensa_detalle"].elements["cantidad"].focus();
    }
    
    // se dan las especificaciones del trabajo
    if( correcto && especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.forms["preprensa_detalle"].elements["especificaciones"].focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( correcto && !$.isNumeric( precio_total_pesos ) ) {
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.forms["preprensa_detalle"].elements["precio_total_pesos"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva botones
        desactivaBtnPreprensaDetalle();
        
        $.ajax({
            type:"POST",
            url:urlAgregaPreprensaDetalle,
            data:$("[name='preprensa_detalle']").serialize(),
            success:function( response ) {
                switch( response.estatusOperacion ) {
                    case 0: // error
                        document.body.style.cursor = "default";
                        alert("No fue posible insertar indicaciones de detalle preprensa");
                        // activa botones
                        activaBtnPreprensaDetalle();
                        break;
                        
                    default:
                        //console.log( response.textoHTML );
                        // actualiza la tabla html
                        document.getElementById("div_tabla_preprensa_detalle").innerHTML = response.textoHTML;
                        // elimina la opcion del select
                        document.forms["preprensa_detalle"].elements["select_proceso_preprensa"].remove( document.forms["preprensa_detalle"].elements["select_proceso_preprensa"].selectedIndex );
                        // limpia campos y avtiva botones
                        limpiaCamposFormPreprensaDetalle();
                        activaBtnPreprensaDetalle();
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error:function( e ) {
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar indicaciones de detalle preprensa");
            }
        });
    }
    
    delete cantidad;
    delete especificaciones;
    delete correcto;
} // ajaxAgregaDisenioDetalle()


function ajaxAgregaTransporte() {
	// EL REGISTRO EN BASE DE DATOS YA SE INGRESO, SOLO ES NECESARIO MODIFICAR SU CONTENIDO
	
    var indicacion_tarea = document.forms["transporte"].elements["indicacion_tarea_realizar"].value;
    
    // VALIDACIONES
    var correcto = true;
    
    if( indicacion_tarea == "" ) {
        correcto = false;
        alert("Es necesario especificar las indicaciones");
        document.forms["transporte"].elements["indicacion_tarea_realizar"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        desactivaCamposTransporte();
        desactivaBtnTransporte();
        
        $.ajax({
            type:"POST",
            url:urlModificaTransporte,
            data:$("[name='transporte']").serialize(),
            success:function( response ) {
                switch( response.estatusOperacion ) {
                    case 0: // error
                        //console.log(e);
                        document.body.style.cursor = "default";
                        alert("No fue posible insertar indicaciones de transporte");
                        // activa campos y botones
                        activaCamposTransporte();
                        activaBtnTransporte();
                        break;
                    
                    default:
                        // establece id_transporte
                        document.forms["transporte_detalle"].elements["id_transporte"].value = response.idTransporte;
                        // activa botones del form
                        activaCamposTransporteDetalle();
                        activaBtnTransporteDetalle();
                        // focus campo
                        document.forms["transporte_detalle"].elements["select_proceso_transporte"].focus();
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error:function( e ) {
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar indicaciones de transporte");
                // activa campos y botones
                activaCamposTransporte();
                activaBtnTransporte();
            }
        });
    }
    
    delete indicacion_tarea;
    delete correcto;
} // ajaxAgregaTransporte()


function ajaxAgregaTransporteDetalle() {
    
    var cantidad            = document.forms["transporte_detalle"].elements["cantidad"].value;
    var especificaciones    = document.forms["transporte_detalle"].elements["especificaciones"].value;
    var precio_total_pesos  = document.forms["transporte_detalle"].elements["precio_total_pesos"].value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( document.forms["transporte_detalle"].elements["select_proceso_transporte"].selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle del transporte");
        document.forms["transporte_detalle"].elements["select_proceso_transporte"].focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( correcto && ( cantidad == "" || parseInt( cantidad ) <= 0 ) ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.forms["transporte_detalle"].elements["cantidad"].focus();
    }
    
    // se dan las especifiaciones del trabajo
    if( correcto && especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.forms["transporte_detalle"].elements["especificaciones"].focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( correcto && !$.isNumeric( precio_total_pesos ) ) {
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.forms["transporte_detalle"].elements["precio_total_pesos"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva botones
        desactivaBtnTransporteDetalle();
        
        $.ajax({
            type:"POST",
            url:urlAgregaTransporteDetalle,
            data:$("[name='transporte_detalle']").serialize(),
            success:function( response ) {
                switch( response.estatusOperacion ) {
                    case 0: // error
                        document.body.style.cursor = "default";
                        alert("No fue posible insertar indicaciones de detalle transporte");
                        // activa botones
                        activaBtnTransporteDetalle();
                        break;
                
                    default:
                        // console.log( response.textoHTML );
                        // actualiza la tabla html
                        document.getElementById("div_tabla_transporte_detalle").innerHTML = response.textoHTML;
                        // elimina la opcion del select
                        document.forms["transporte_detalle"].elements["select_proceso_transporte"].remove( document.forms["transporte_detalle"].elements["select_proceso_transporte"].selectedIndex );
                        // limpia campos y activa botones
                        limpiaCamposFormTransporteDetalle();
                        activaBtnTransporteDetalle();
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error:function( e ) {
                console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar indicaciones de detalle transporte");
            }
        });
    }
    
    delete cantidad;
    delete especificaciones;
    delete correcto;
} // ajaxAgregaDetalleTransporte()


function ajaxAgregaAcabado() {
	// EL REGISTRO EN BASE DE DATOS YA SE INGRESO, SOLO ES NECESARIO MODIFICAR SU CONTENIDO
	
    var indicacion_tarea = document.forms["acabado"].elements["indicacion_tarea_realizar"].value;
    
    // VALIDACIONES
    var correcto = true;
    
    if( indicacion_tarea == "" ) {
        correcto = false;
        alert("Es necesario especificar las indicaciones");
        document.forms["acabado"].elements["indicacion_tarea_realizar"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        desactivaCamposAcabado();
        desactivaBtnAcabado();
        
        $.ajax({
            type:"POST",
            url:urlModificaAcabado,
            data:$("[name='acabado']").serialize(),
            success:function( response ) { 
                switch( response.estatusOperacion ) {
                    case 0: // error
                        //console.log(e);
                        document.body.style.cursor = "default";
                        alert("No fue posible insertar indicaciones de acabado");
                        // activa campos y botones
                        activaCamposAcabado();
                        activaBtnAcabado();
                        break;
                
                    default:
                        // establece id_acabado
                        document.forms["acabado_detalle"].elements["id_acabado"].value = response.idAcabado;
                        // activa botones del form
                        activaCamposAcabadoDetalle();
                        activaBtnAcabadoDetalle();
                        // focus campo
                        document.forms["acabado_detalle"].elements["select_proceso_externo"].focus();
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error:function( e ){ 
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar indicaciones de acabado");
                // activa campos y botones
                activaCamposAcabado();
                activaBtnAcabado();
            }
        });
    }
    
    delete indicacion_tarea;
    delete correcto;
} // ajaxAgregaAcabado()


function ajaxAgregaAcabadoDetalle() {

    var cantidad            = document.forms["acabado_detalle"].elements["cantidad_proceso_externo"].value;
    var especificaciones    = document.forms["acabado_detalle"].elements["especificaciones"].value;
    var precio_total_pesos  = document.forms["acabado_detalle"].elements["precio_total_pesos"].value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( document.forms["acabado_detalle"].elements["select_proceso_externo"].selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle del acabado");
        document.forms["acabado_detalle"].elements["select_proceso_acabado"].focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( correcto && ( cantidad == "" || parseInt( cantidad ) <= 0 ) ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.forms["acabado_detalle"].elements["cantidad_proceso_externo"].focus();
    }
    
    // se dan las especifiaciones del trabajo
    if( correcto && especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.forms["acabado_detalle"].elements["especificaciones"].focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( correcto && !$.isNumeric( precio_total_pesos ) ) {
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.forms["acabado_detalle"].elements["precio_total_pesos"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva botones
        desactivaBtnAcabadoDetalle();
        
        $.ajax({
            type:"POST",
            url:urlAgregaAcabadoDetalle,
            data:$("[name='acabado_detalle']").serialize(),
            success:function( response ) {
                switch( response.estatusOperacion ) {
                    case 0: // error
                        document.body.style.cursor = "default";
                        alert("No fue posible insertar indicaciones de acabado detalle");
                        // activa botones
                        activaBtnAcabadoDetalle();
                        break;
                        
                    default:
                        // console.log( response.textoHTML );
                        // actualiza la tabla html
                        document.getElementById("div_tabla_acabado_detalle").innerHTML = response.textoHTML;
                        // elimina la opcion del select
                        document.forms["acabado_detalle"].elements["select_proceso_externo"].remove( document.forms["acabado_detalle"].elements["select_proceso_externo"].selectedIndex );
                        // limpia form y activa botones
                        limpiaCamposFormAcabadoDetalle();
                        activaBtnAcabadoDetalle();
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error:function( e ){
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar indicaciones de acabado detalle");
            }
        });
    }
    
    delete cantidad;
    delete especificaciones;
    delete correcto;
} // ajaxAgregaAcabadoDetalle()


function ajaxAgregaOffset() {
	// EL REGISTRO EN BASE DE DATOS YA SE INGRESO, SOLO ES NECESARIO MODIFICAR SU CONTENIDO
	
    var indicacion_tarea = document.forms["offset"].elements["indicacion_tarea_realizar"].value;
    
    // VALIDACIONES
    var correcto = true;
    
    if( indicacion_tarea == "" ) {
        correcto = false;
        alert("Es necesario especificar las indicaciones");
        document.forms["offset"].elements["indicacion_tarea_realizar"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        // CUIDADO: si se desactiva un textarea antes de enviar un formulario, el valor que envia es nulo.
        desactivaBtnOffset();
        
        $.ajax({
            type:"POST",
            url:urlModificaOffset,
            data:$("[name='offset']").serialize(),
            success:function( response ) { 
                switch( response.estatusOperacion ) {
                    case 0: // error
                        //console.log(e);
                        document.body.style.cursor = "default";
                        alert("No fue posible insertar indicaciones de offset");
                        // activa campos y botones
                        activaCamposOffset();
                        activaBtnOffset();
                        break;
                
                    default:
                        // desactica campos
                        desactivaCamposOffset();
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error:function( e ) { 
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar indicaciones de offset");
                // activa campos y botones
                activaCamposOffset();
                activaBtnOffset();
            }
        });
    }
    
    delete indicacion_tarea;
    delete correcto;
} // ajaxAgregaOffset()


function ajaxAgregaMaterialAyuda() {
    
    var observaciones = document.forms["material_ayuda"].elements["observaciones"].value;
    
    // VALIDACIONES
    var correcto = true;
    
    if( document.forms["material_ayuda"].elements["select_material_ayuda"].selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo de material de ayuda");
        document.forms["material_ayuda"].elements["select_material_ayuda"].focus();
    }
    
    if( correcto && document.forms["material_ayuda"].elements["select_responsable_insumo"].selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el responsable del material de ayuda");
        document.forms["material_ayuda"].elements["select_responsable_insumo"].focus();
    }
    
    if( correcto && observaciones == "" ) {
        correcto = false;
        alert("Es necesario especificar las observaciones del material de ayuda");
        document.forms["material_ayuda"].elements["observaciones"].focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        desactivaBtnMaterialAyuda();
        
        // copia de valores aqui porque quiza no haya un click antes
        var index_select_material_ayuda = document.forms["material_ayuda"].elements["select_material_ayuda"].selectedIndex;
        document.forms["material_ayuda"].elements["id_material_ayuda"].value = document.forms["material_ayuda"].elements["select_material_ayuda"].options[index_select_material_ayuda].value;
        delete index_select_material_ayuda;
        
        var index_select_responsable_insumo = document.forms["material_ayuda"].elements["select_responsable_insumo"].selectedIndex;
        document.forms["material_ayuda"].elements["id_responsable_insumo"].value = document.forms["material_ayuda"].elements["select_responsable_insumo"].options[index_select_responsable_insumo].value;
        delete index_select_responsable_insumo;
        
        $.ajax({
            type:"POST",
            url:urlAgregaMaterialAyuda,
            data:$("[name='material_ayuda']").serialize(),
            success:function( response ){
                switch( response.estatusOperacion ) {
                    case 0:
                        document.body.style.cursor = "default";
                        alert("No fue posible insertar material de ayuda");
                        activaBtnMaterialAyuda();
                        break;
                
                    default:
                        // actualiza la tabla html
                        document.getElementById("div_tabla_material_ayuda").innerHTML = response.textoHTML;
                        // elimina la opcion del select
                        document.forms["material_ayuda"].elements["select_material_ayuda"].remove( document.forms["material_ayuda"].elements["select_material_ayuda"].selectedIndex );
                        // limpia el campo de observaciones
                        limpiaCamposFormMaterialAyuda();
                        activaBtnMaterialAyuda();
                        // cambia cursor
                        document.body.style.cursor = "default";
                        break;
                }
            },
            error:function( e ) {
                console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible insertar material de ayuda");
            }
        });
    }
    
    delete observaciones;
    delete correcto;
} // ajaxAgregaMaterialAyuda()


function ajaxBuscaTipoTrabajoDetalle() {
    $.ajax({
        type:"POST",
        url:urlBuscaTipoTrabajoDetalle,
        data:{id_partida:document.forms["tipo_trabajo_detalle"].elements["id_partida"].value},
        success:function( response ) {
            switch( response.estatusOperacion ) {
                case 1:
                    // actualiza tabla html
                    document.getElementById("div_tabla_lista_tipo_trabajo_detalle").innerHTML = response.textoHTML;
                    // despliega div_visaulizador partidas
                    document.getElementById("div_visualizador_tipo_trabajo_detalle").style.display = "block";
                    break;
                default:
                    break;    
            }
        },
        error:function( e ) {
            alert("Error, no fue posible mostrar los trabajos detalle");
        }
    }); 
} // ajaxBuscaTipoTrabajoDetalle()


function ajaxBuscaPartidas() {
    $.ajax({
        type:"POST",
        url:urlBuscaPartida,
        data:{id_orden_produccion:document.forms["partida"].elements["id_orden_produccion"].value},
        success:function( response ) {
            switch( response.estatusOperacion ) {
                case 1:
                    // actualiza a tabla html
                    document.getElementById("div_tabla_lista_partidas").innerHTML = response.textoHTML;
                    // despliega div_visualizador_partidas
                    document.getElementById("div_visualizador_partidas").style.display = "block";
                    break;
                default:
                    break;
            }
        },
        error:function( e ){
            alert("Error, no fue posible mostrar las partidas");
        }
    });
} // ajaxBuscaPartidas()


function preparaNuevaPartida() {
    // busca la informacion del div_tabla_lista_partidas
    ajaxBuscaPartidas();
    
    // se guarda la informacion de id_orden_produccion antes de limpiar todo
    var id_orden_produccion = document.forms["partida"].elements["id_orden_produccion"].value;
    
    // limpia el form partida
    limpiaFormPartida();
    
    // oculta divs no necesarios
    document.getElementById("div_visualizador_tipo_trabajo_detalle").style.display  = "none";
    document.getElementById("div_tipo_trabajo_detalle").style.display               = "none";
    document.getElementById("div_visualizador_pliegos").style.display               = "none";
    document.getElementById("div_visualizador_costo_extra_detalle").style.display  	= "none";
    document.getElementById("div_costo_extra_detalle").style.display              	= "none";
    document.getElementById("div_pestania").style.display                           = "none";
    document.getElementById("div_material_ayuda").style.display                     = "none";
    document.getElementById("div_nuevo_tipo_trabajo_detalle").style.display         = "none";
    document.getElementById("div_nueva_partida").style.display                      = "none";
    document.getElementById("div_cotizar").style.display                            = "none";
    
    // limpia los campos de los forms ocultos
    limpiaFormTipoTrabajoDetalle();
    limpiaFormCostoExtraDetalle();
    limpiaFormDisenio();
    limpiaFormDisenioDetalle();
    limpiaFormPreprensa();
    limpiaFormPreprensaDetalle();
    limpiaFormTransporte();
    limpiaFormTransporteDetalle();
    limpiaFormAcabado();
    limpiaFormAcabadoDetalle();
    limpiaFormOffset();
    limpiaFormMaterialAyuda();
    
    // inicializa el form partida
    document.forms["partida"].elements["id_orden_produccion"].value = id_orden_produccion;
    document.forms["partida"].elements["tipo_trabajo"][0].click();
    document.forms["partida"].elements["nombre_partida"].focus();
    
    // elimina variable de inicializacion
    delete id_orden_produccion;

    // inicializa pestanias area detalle
    var obj = { id:"div_pestania_menu_disenio" };
    menu( obj );
    
    // activa botones de subpartida
    document.getElementById("imgBtnAgregarTipoTrabajoDetalleInactivo").style.display   = "none";
    document.getElementById("imgBtnAgregarTipoTrabajoDetalleActivo").style.display     = "inline";
    
} // agregaPartida()


function cotizar() {
    document.forms["cotizacion"].action = urlCalificacionOrdenProduccion;
    //document.forms['cotizacion'].method = "POST";
    document.forms["cotizacion"].submit();
} // cotizar()
