

// funciones
function searchLikeGoogle(str,event){
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
} // searchLikeGoogle


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


function enterSearchLikeGoogle(event) {
	//console.log(event);
	//console.log("entro a enterSearchLikeGoogle");
	document.cliente.nombre_moral.value = document.cliente.select_search.options[document.cliente.select_search.selectedIndex].text;
	if( event.keyCode == 13 ) {
		preparaAjaxBuscaCliente();
	}
}


function ajaxBuscaCliente() {
    //alert( $('#form_cliente').serialize() );
    document.cliente.id_cliente.blur();
    var id_cliente = document.cliente.id_cliente.value;
    var correcto = true;
    if ( correcto 
    		&& id_cliente == "" ) {
    	correcto = false;
    	alert("Campo Id. Cliente no puede estar vac\u00edo. Favor de informarlo.");
    }
    if( correcto 
    		&& isNaN( id_cliente ) ) {
    	correcto = false;
    	alert("Campo Id. Cliente debe ser un numero.");
    }
    if ( correcto ) {
    	document.body.style.cursor = "wait";
        $.ajax({
            type:"POST",
            url:urlBuscaCliente,
            data:{id_cliente:id_cliente}, //$('[name=form_cliente]').serialize(), //$('#form_cliente').serialize(),
            success:function( response ) {
                //console.log(response);
                //var JSONObject = { "id_cliente":"1","id_tipo_cliente":"8","clave_cliente":"ME","nombre_representante":"Gerardo Nieto Lopez" };
                document.cliente.nombre_moral.value           = response.nombreMoral;
                document.cliente.clave.value                  = response.tipoCliente;
                document.cliente.nombre_representante.value   = response.nombreRepresentante;
                document.cliente.calle.value                  = response.calle;
                document.cliente.num_exterior.value           = response.numExterior;
                document.cliente.num_interior.value           = response.numInterior;
                document.cliente.colonia.value                = response.colonia;
                document.cliente.delegacion_municipio.value   = response.delegacionMunicipio;
                document.cliente.estado.value                 = response.estado;
                document.cliente.codigo_postal.value          = response.codigoPostal;
                document.cliente.rfc.value                    = response.rfc;
                document.cliente.telefono_particular.value    = response.telefonoParticular;
                document.cliente.telefono_movil.value         = response.telefonoMovil;
                document.cliente.observaciones.value          = response.observaciones;
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
    }
    delete id_cliente;
} // ajaxBuscaCliente()


function ajaxAgregaOrdenProduccion() {
    
    document.orden_produccion.id_cliente.value                 = document.cliente.id_cliente.value;;
    document.orden_produccion.id_tipo_comprobante_fiscal.value = document.orden_produccion.select_comprobante_fiscal.value;
    
    // VALIDACIONES
    var correcto = true;
    
    // revisa que el campo id_cliente no este vacio
    if( correcto 
    		&& document.cliente.id_cliente.value == "" ) {
        correcto = false;
        alert("Campo Id. Cliente no puede estar vac\u00edo. Favor de informarlo.");
        document.cliente.id_cliente.focus();
    }
    
    // revisa que el nombre y la descripcion de la orden no esten vacios
    if( correcto 
    		&& ( document.orden_produccion.nombre.value == "" 
    			|| document.orden_produccion.descripcion.value == "") ) {
        correcto = false;
        alert("Campos Nombre y Descripcion de la orden de procducci\u00f3n no pueden estar vac\u00edos. Favor de informarlos.");
    }
    
    if ( correcto
    		&& document.orden_produccion.fecha_prometida_entrega.value == "" ) {
    	correcto = false;
    	alert("Campo Fecha de Entrega no puede estar vac\u00EDo. Favor de informarlo");
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // form cliente desactiva campos
        document.cliente.id_cliente.readOnly 	= true;
        document.cliente.nombre_moral.readOnly  = true;
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
                        document.cliente.id_cliente.readOnly   = false;
                        document.cliente.nombre_moral.readOnly = false;
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
                    	document.orden_produccion.id_orden_produccion.value = response.idOrdenProduccion;
                        document.partida.id_orden_produccion.value     		= response.idOrdenProduccion;
                        document.cotizacion.id_orden_produccion.value  		= response.idOrdenProduccion;
                        document.getElementById("div_partida").style.display = "block";
                        break;
                }
            },
            error:function(e) {
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible generar la orden de producci\u00f3n.");
                // form cliente activa botones
                document.cliente.id_cliente.readOnly   = false;
                document.cliente.nombre_moral.readOnly = false;
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
} // ajaxAgregaOrdenProduccion()

function ajaxAgregaPartida() {
    //alert('si entro a la funcion ajax');
    document.partida.id_tipo_trabajo.value         = $("input:radio[name=tipo_trabajo]:checked").val(); 
    document.partida.id_tipo_forma_trabajo.value   = document.partida.select_forma_trabajo.value;
    
    // VALIDACIONES
    var correcto = true;
    
    // Revisa que nombre de partida, cantidad y descripcion no sean vacios
    if( correcto 
    		&& ( document.partida.nombre_partida.value == "" 
    			|| document.partida.descripcion_partida.value == "" ) ) {
        correcto = false;
        alert("Los campos nombre y descripci\u00f3n no pueden estar vac\u00edos. Favor de informarlos.");
    }
    
    if ( correcto 
    		&& ( document.partida.cantidad.value == "" 
    			|| isNaN(document.partida.cantidad.value ) ) ) {
    	correcto = false;
    	alert("El campo cantidad deber ser un n\u00FAmero válido.");
    }
    
    if( correcto && ( window.FormData !== undefined ) ) { // puede utiliza FormData
    	//console.log("entro aqui, al existente form data");
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        desactivaCamposPartida();
        desactivaBtnPartida();
        
        // para enviar file input con ajax se usa formData
        var formData = new FormData( document.partida );
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
                        buscaTipoPlaca( document.tipo_trabajo_detalle.select_maquina ); // orden_produccion.js
                        //console.log( response );
                        document.partida.diagrama_formacion.disabled   = true; // si se desactiva arriba, entonces ya no lleva datos al hacer el ajax, por eso se desactiva aqui
                        // se llenan todos los forms que necesitan saber id_partida
                        document.partida.id_partida.value				= response.idPartida;
                        document.tipo_trabajo_detalle.id_partida.value 	= response.idPartida;
                        document.disenio.id_partida.value              	= response.idPartida;
                        document.preprensa.id_partida.value            	= response.idPartida;
                        document.transporte.id_partida.value           	= response.idPartida;
                        document.acabado.id_partida.value              	= response.idPartida;
                        document.offset.id_partida.value               	= response.idPartida;
                        document.material_ayuda.id_partida.value       	= response.idPartida;
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
    } else if( correcto ) { // no puede usar FormData
    	alert("Por favor actualice su navegador.");
    }
    	
    
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


//variables globales
var esPrimerInsercionTTD 			= true;		// VARIABLE UTILIZADA PARA FLUJO DE PROCESO EN AJAX
var cerradoOKVentanaListaPliegos 	= false;	// VARIABLE UTILIZADA PARA GENERAR PLIEGOS
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
    document.tipo_trabajo_detalle.cliente_proporciona_papel.value          = document.tipo_trabajo_detalle.proporciona_papel.checked;
    document.tipo_trabajo_detalle.cliente_proporciona_tinta_especial.value = document.tipo_trabajo_detalle.proporciona_tinta_especial.checked;
    document.tipo_trabajo_detalle.cliente_proporciona_barniz.value         = document.tipo_trabajo_detalle.proporciona_barniz.checked;
    document.tipo_trabajo_detalle.cliente_proporciona_placas.value         = document.tipo_trabajo_detalle.proporciona_placas.checked;
    document.tipo_trabajo_detalle.id_tamanio_publicacion.value             = document.tipo_trabajo_detalle.select_tamanio_publicacion.value;
    document.tipo_trabajo_detalle.frente_id_combinacion_tintas.value       = document.tipo_trabajo_detalle.select_frente_combinacion_tintas.value;
    document.tipo_trabajo_detalle.frente_id_tipo_barniz.value              = document.tipo_trabajo_detalle.select_frente_tipo_barniz.value;
    document.tipo_trabajo_detalle.vuelta_id_combinacion_tintas.value       = document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.value;
    document.tipo_trabajo_detalle.vuelta_id_tipo_barniz.value              = document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.value;
    document.tipo_trabajo_detalle.id_maquina.value                         = document.tipo_trabajo_detalle.select_maquina.value;
    document.tipo_trabajo_detalle.id_tipo_placa.value                      = document.tipo_trabajo_detalle.select_tipo_placa.value;
    document.tipo_trabajo_detalle.id_tipo_complejidad.value                = document.tipo_trabajo_detalle.select_tipo_complejidad.value;
    
    // VALIDACIONES
    var correcto = true;
    
    // Revisa que descripcion, ancho y alto no este vacios
    if( correcto 
    		&& document.tipo_trabajo_detalle.descripcion_partida_detalle.value == "" ) {
        correcto = false;
        alert("El campo descripci\u00f3n no puede estar vac\u00edo. Favor de informarlos.");
        document.tipo_trabajo_detalle.descripcion_partida_detalle.focus();
    }
    if ( correcto
			&& ( document.tipo_trabajo_detalle.alto_final.value == ""
				|| isNaN( document.tipo_trabajo_detalle.alto_final.value ) ) ) {
    	 correcto = false;
    	 alert("El campo alto final debe ser num\u00E9rico");
    	 document.tipo_trabajo_detalle.alto_final.value = "";
    	 document.tipo_trabajo_detalle.alto_final.focus();
    }
    if ( correcto
			&& ( document.tipo_trabajo_detalle.ancho_final.value == ""
				|| isNaN( document.tipo_trabajo_detalle.ancho_final.value ) ) ) {
    	 correcto = false;
    	 alert("El campo ancho final debe ser num\u00E9rico");
    	 document.tipo_trabajo_detalle.ancho_final.value = "";
    	 document.tipo_trabajo_detalle.ancho_final.focus();
    }
    if ( correcto 
    		&& ( document.tipo_trabajo_detalle.alto_extendido.value == ""
    			|| isNaN( document.tipo_trabajo_detalle.alto_extendido.value ) ) ) {
    	 correcto = false;
    	 alert("El campo alto extendido debe ser num\u00E9rico");
    	 document.tipo_trabajo_detalle.alto_extendido.value = "";
    	 document.tipo_trabajo_detalle.alto_extendido.focus();
    }
    if ( correcto 
    		&& ( document.tipo_trabajo_detalle.ancho_extendido.value == ""
    			|| isNaN( document.tipo_trabajo_detalle.ancho_extendido.value ) ) ) {
    	 correcto = false;
    	 alert("El campo ancho extendido debe ser num\u00E9rico");
    	 document.ipo_trabajo_detalle.ancho_extendido.value = "";
    	 document.tipo_trabajo_detalle.ancho_extendido.focus();
    }
    
    // corte inicial
    if ( correcto
    		&& ( document.tipo_trabajo_detalle.alto_corte_inicial.value == "" 
    				|| isNaN( document.tipo_trabajo_detalle.alto_corte_inicial.value ) ) ) {
    	correcto = false;
    	alert("El campo Alto Corte Inicial debe ser num\u00E9rico");
    	document.tipo_trabajo_detalle.alto_corte_inicial.value = "";
    	document.tipo_trabajo_detalle.alto_corte_inicial.focus();
    }
    if ( correcto
    		&& ( document.tipo_trabajo_detalle.ancho_corte_inicial.value == ""
    				|| isNaN(document.tipo_trabajo_detalle.ancho_corte_inicial.value) ) ) {
    	correcto = false;
    	alert("El campo Ancho Corte Inicial debe ser num\u00E9rico");
    	document.tipo_trabajo_detalle.ancho_corte_inicial.value = ""
    	document.tipo_trabajo_detalle.ancho_corte_inicial.focus();
    }
    
    // Valida que el numero de repeticiones por flyer o paginas de revista sea mayor que cero
    switch( parseInt( document.partida.id_tipo_trabajo.value ) ) {
        case 1:
            if( correcto 
            		&& ( document.tipo_trabajo_detalle.repeticiones_x_pliego.value == "" 
            			|| isNaN( document.tipo_trabajo_detalle.repeticiones_x_pliego.value ) 
            			|| parseInt( document.tipo_trabajo_detalle.repeticiones_x_pliego.value ) <= 0 ) ) {
                correcto = false;
                alert("El n\u00famero de repeticiones deber ser un n\u00famero positivo mayor de cero");
                document.tipo_trabajo_detalle.repeticiones_x_pliego.focus();
            }
            break;
        
        case 2:
            if( correcto
            		&& ( document.tipo_trabajo_detalle.numero_paginas_publicacion.value == ""
            			|| isNaN( document.tipo_trabajo_detalle.numero_paginas_publicacion.value )
            			|| parseInt( document.tipo_trabajo_detalle.numero_paginas_publicacion.value ) <= 0 
            			|| parseInt( document.tipo_trabajo_detalle.numero_paginas_publicacion.value )%4 != 0 ) ) {
                correcto = false;
                alert("El n\u00famero de p\u00e1ginas deber ser un n\u00famero positivo mayor de cero y multiplo de 4");
                document.tipo_trabajo_detalle.numero_paginas_publicacion.focus();
            }
            
            if( correcto
            		&& document.tipo_trabajo_detalle.select_tamanio_publicacion.value == "1" ) {
                correcto = false;
                alert("El tama\u00f1o de la publicaci\u00f3n debe ser especificado");
                document.tipo_trabajo_detalle.select_tamanio_publicacion.focus();
            }
            break;
            
        case 3:
            break;
            
        default:
            break;
    } // switch validacion tipo trabajo
    
    
    // valida que existe papel
    if( correcto 
    		&& document.tipo_trabajo_detalle.tipo_papel_extendido.value == "" ) {
    	correcto = false;
    	alert("Favor de especificar el tipo de papel");
    	document.tipo_trabajo_detalle.tipo_papel_extendido.focus();
    }
    
    // valida que si no hay tinta normal en frente, debe forzosamente haber tinta especial en frente
    if( correcto 
    		&& document.tipo_trabajo_detalle.select_frente_combinacion_tintas.value == "16" ) {
        // valida en frente si la tinta especial es mayor a cero, exista obligatoriamente una descripcion.
        if( document.tipo_trabajo_detalle.frente_num_tinta_especial.value == "" 
        		|| isNaN( document.tipo_trabajo_detalle.frente_num_tinta_especial.value )
        		|| parseInt( document.tipo_trabajo_detalle.frente_num_tinta_especial.value ) <= 0 ) {
            correcto = false;
            alert("Es necesario que exista al menos tinta especial en el frente");
            document.tipo_trabajo_detalle.frente_num_tinta_especial.focus();
        }   
    }
   
    // valida informacion de frente num tinta especial
    if ( correcto 
    		&& document.tipo_trabajo_detalle.frente_num_tinta_especial.value == "" ) {
    	correcto = false;
    	alert("El numero de frente tinta especial debe ser cero");
    	document.tipo_trabajo_detalle.frente_num_tinta_especial.focus();
    }
    if ( correcto 
    		&& document.tipo_trabajo_detalle.frente_num_tinta_especial.value != ""
    		&& isNaN( document.tipo_trabajo_detalle.frente_num_tinta_especial.value ) ) {
    	correcto = false;
    	alert("El dato de frente tinta especial debe ser un numero");
    	document.tipo_trabajo_detalle.frente_num_tinta_especial.focus();
    }
    if ( correcto 
    		&& parseInt( document.tipo_trabajo_detalle.frente_num_tinta_especial.value ) > 0 
    		&& document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value == "" ) {
    	correcto = false;
    	alert("El numero de frente tinta especial es mayor a cero; debe especificar la descripcion de frente tinta especial");
    	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.focus();
    }
    if ( correcto
    		&& document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value != "" 
    		&& ( parseInt( document.tipo_trabajo_detalle.frente_num_tinta_especial.value ) == 0 
    				|| parseInt( document.tipo_trabajo_detalle.frente_num_tinta_especial.value ) < 0 ) ) {
    	correcto = false;
    	alert("Tiene especificada una descripcion de frente tinta especial; debe especificar que frente tinta especial es al menos 1");
    	document.tipo_trabajo_detalle.frente_num_tinta_especial.focus();
    }
    
    // valida que informacion de vuelta num tinta especial
    if ( correcto 
    		&& document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value == "" ) {
    	correcto = false;
    	alert("El numero de vuelta tinta especial debe ser cero");
    	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.focus();
    }
    if ( correcto 
    		&& document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value != ""
    		&& isNaN( document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value ) ) {
    	correcto = false;
    	alert("El dato de vuelta tinta especial debe ser un numero");
    	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.focus();
    }
    if ( correcto 
    		&& parseInt( document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value ) > 0 
    		&& document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value == "" ) {
    	correcto = false;
    	alert("El numero de vuelta tinta especial es mayor a cero; debe especificar la descripcion de vuelta tinta especial");
    	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.focus();
    }
    if ( correcto
    		&& document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value != "" 
    		&& ( parseInt( document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value ) == 0 
    				|| parseInt( document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value ) < 0 ) ) {
    	correcto = false;
    	alert("Tiene especificada una descripcion de vuelta tinta especial; debe especificar que vuelta tinta especial es al menos 1");
    	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        desactivaCamposTipoTrabajoDetalle();
        desactivaBtnTipoTrabajoDetalle();
        
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
                        document.body.style.cursor = "default";
                        alert("No fue posible generar el detalle de partida");
                        // activa campos y botones
                        activaCamposTipoTrabajoDetalle();
                        activaBtnTipoTrabajoDetalle();
                        break;
                        
                    default:
                    	if ( esPrimerInsercionTTD ) {
                    		document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value	= response.idTipoTrabajoDetalle;
                            document.visualizador_pliegos.id_tipo_trabajo_detalle.value = response.idTipoTrabajoDetalle;
                        	document.costo_extra_detalle.id_tipo_trabajo_detalle.value 	= response.idTipoTrabajoDetalle;
                    	}
                        // cambia cursor
                        document.body.style.cursor = "default";
                        // abre ventana modal
                        Shadowbox.open({
                            content:urlCalculaPliego + "?id_tipo_trabajo_detalle=" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value,
                            //content: "<form method='post' action='" + urlCalculaPliego + "' target='hidden_iframe'><input type='hidden' name='id_tipo_trabajo_detalle' value='" + response.id_tipo_trabajo_detalle + "'></input</form><iframe name='hidden_iframe'></iframe>",
                            player:"iframe",
                            width:630,
                            height:700,
                            options:{ 
                            	modal: true,
                                overlayOpacity: 0.75,
                                onClose: revisaCierreVentanaModal // al cerrar esta ventana, se manda llamar revisaCierreVentanaModal()
                            }
                        });
                        break;
                }
            },
            error: function(e) {
                //console.log(e);
                document.body.style.cursor = "default";
                alert("No fue posible generar el detalle de partida");
                // activa campos y botones
                activaCamposTipoTrabajoDetalle();
                activaBtnTipoTrabajoDetalle();
            }
        });
    } // if correcto
    
} // ajaxAgregaDetallePartida()


//esta funciona se manda llamar en la funcion response ok de la funcion ajax de ajaxAgregaTipoTrabajoDetalle()
function revisaCierreVentanaModal() { 
	// la variable evaluada en este if, se modifica en pliego.js
    if( cerradoOKVentanaListaPliegos ) {
        document.getElementById("div_visualizador_pliegos").style.display       		= "block";
        document.getElementById("div_costo_extra_detalle").style.display 				= "block";
        document.getElementById("div_visualizador_costo_extra_detalle").style.display 	= "block";
        document.getElementById("div_nuevo_tipo_trabajo_detalle").style.display 		= "block";
    } else {
        // la ventana no se cerro con el boton agregar
    	// se debe permitir la modificacion del registro TTD
    	esPrimerInsercionTTD = false;
    	// activa campos y botones
        activaCamposTipoTrabajoDetalle();
        activaBtnTipoTrabajoDetalle();
    } // if cerradoCorrectamente
    cerradoOKVentanaListaPliegos = false;
}

function setCamposPliego( idPliego, noPliego, rebases, medianiles, pinzas, hojasSobrantes, observaciones ) { } // para que la pagina no marque error de javascript


function ajaxUnidadCostoExtra() {
	$.ajax({
		type:"POST",
		url:urlBuscaUnidadMedidaCostoExtra,
		data:{id_costo_extra:$("[name=select_costo_extra]").val()},
		success:function(response) {
			//alert(response);
			document.costo_extra_detalle.nombre_unidad_medida.value = response;
		},
		error:function(e) {
			console.log(e);
			document.costo_extra_detalle.nombre_unidad_medida.value = "-";
		}
	});
}


function ajaxAgregaCostoExtraDetalle() {
	
	// VALIDACIONES
	var correcto = true;
	
	if( correcto 
			&& document.costo_extra_detalle.cantidad.value == "" ) {
		correcto = false;
		alert("Es necesario especificar la cantidad de costo extra");
		document.costo_extra_detalle.cantidad.focus();
	}
	
	if ( correcto 
			&& isNaN(document.costo_extra_detalle.cantidad.value) ) {
		correcto = false;
		alert("La cantidad de costo extra debe ser un n\u00FAmero entero");
		document.costo_extra_detalle.cantidad.focus();
	}
	
	if( correcto 
			&& document.costo_extra_detalle.select_costo_extra.selectedIndex == "-1" ) {
		correcto = false;
		alert("Es necesario especificar el costo extra");
		document.costo_extra_detalle.select_costo_extra.focus();
	}
	
	if( correcto 
			&& document.costo_extra_detalle.select_responsable_insumo.selectedIndex == "-1" ) {
		correcto = false;
		alert("Es necesario especificar el responsable del insumo");
		document.costo_extra_detalle.select_costo_extra.focus();
	}
	
	if( correcto ) {
		document.body.style.cursor = "wait";
		// desactiva campos y botones
		desactivaBtnCostoExtraDetalle();
		// copia valores a input hidden
		document.costo_extra_detalle.id_costo_extra.value 			= $("[name=select_costo_extra]").val();
		document.costo_extra_detalle.id_responsable_insumo.value 	= $("[name=select_responsable_insumo]").val();
		
		$.ajax({
			type:"POST",
			url:urlAgregaCostoExtra,
			data:$("[name='costo_extra_detalle']").serialize(),
			success:function(response) {
				// actualiza tabla html
				document.getElementById("div_tabla_costo_extra_tipo_trabajo").innerHTML = response.textoHTML;
				// elimina la opcion del select
				document.costo_extra_detalle.select_costo_extra.remove( document.costo_extra_detalle.select_costo_extra.selectedIndex );
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
}


function ajaxAgregaDisenio() {
	// EL REGISTRO EN BASE DE DATOS YA SE INGRESO, SOLO ES NECESARIO MODIFICAR SU CONTENIDO
	
    var indicacion_tarea = document.disenio.indicacion_tarea_realizar.value;
    
    // VALIDACIONES
    var correcto = true;
    
    // indicacion no este vacia
    if( correcto 
    		&& indicacion_tarea == "" ) {
        correcto = false;
        alert("Es necesario especificar las indicaciones");
        document.disenio.indicacion_tarea_realizar.focus();
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
                        document.disenio_detalle.id_disenio.value = response.idDisenio;
                        // activa campos y botones
                        activaCamposDisenioDetalle();
                        activaBtnDisenioDetalle();
                        // focus campo
                        document.disenio_detalle.select_proceso_disenio.focus();
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
    
    var cantidad            = document.disenio_detalle.cantidad.value;
    var especificaciones    = document.disenio_detalle.especificaciones.value;
    var precio_total_pesos  = document.disenio_detalle.precio_total_pesos.value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( correcto 
    		&& document.disenio_detalle.select_proceso_disenio.selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle del dise\u00f1o");
        document.disenio_detalle.select_proceso_disenio.focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( correcto 
    		&& ( cantidad == "" || isNaN(cantidad) || parseInt( cantidad ) <= 0 )  ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.disenio_detalle.cantidad.focus();
    }
    
    // se dan las especificaciones del trabajo
    if( correcto 
    		&& especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.disenio_detalle.especificaciones.focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if ( correcto 
    		&& isNaN(precio_total_pesos) ) {
    	correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.disenio_detalle.precio_total_pesos.focus();
    }
    if( correcto 
    		&& ( !$.isNumeric( precio_total_pesos ) || isNaN(precio_total_pesos) ) ) {
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.disenio_detalle.precio_total_pesos.focus();
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
                        document.disenio_detalle.select_proceso_disenio.remove( document.disenio_detalle.select_proceso_disenio.selectedIndex );
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
	
    var indicacion_tarea = document.preprensa.indicacion_tarea_realizar.value;
    
    // VALIDACIONES
    var correcto = true;
    
    if( correcto
    		&& indicacion_tarea == "" ) {
        correcto = false;
        alert("Es necesario especificar las indicaciones");
        document.preprensa.indicacion_tarea_realizar.focus();
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
                        document.preprensa_detalle.id_preprensa.value = response.idPreprensa;
                        // activa campos y botones
                        activaCamposPreprensaDetalle();
                        activaBtnPreprensaDetalle();
                        // focus campo
                        document.preprensa_detalle.select_proceso_preprensa.focus();
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
    
    var cantidad            = document.preprensa_detalle.cantidad.value;
    var especificaciones    = document.preprensa_detalle.especificaciones.value;
    var precio_total_pesos  = document.preprensa_detalle.precio_total_pesos.value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( correcto
    		&& document.preprensa_detalle.select_proceso_preprensa.selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle de preprensa");
        document.preprensa_detalle.select_proceso_preprensa.focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if ( correcto 
    		&& isNaN(cantidad) ) {
    	correcto = false;
        alert("Es necesario especificar un n\u00FAmero correcto en cantidad");
        document.preprensa_detalle.cantidad.focus();
    }
    if( correcto 
    		&& ( cantidad == "" || isNaN(cantidad) || parseInt( cantidad ) <= 0 ) ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.preprensa_detalle.cantidad.focus();
    }
    
    // se dan las especificaciones del trabajo
    if( correcto 
    		&& especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.preprensa_detalle.especificaciones.focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( correcto 
    		&& ( !$.isNumeric( precio_total_pesos || isNaN(precio_total_pesos ) ) ) ) {
        correcto = false;
        alert("Es necesario un n\u00FAmero correcto en precio");
        document.preprensa_detalle.precio_total_pesos.focus();
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
                        document.preprensa_detalle.select_proceso_preprensa.remove( document.preprensa_detalle.select_proceso_preprensa.selectedIndex );
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
    delete precio_total_pesos;
    delete correcto;
} // ajaxAgregaDisenioDetalle()


function ajaxAgregaTransporte() {
	// EL REGISTRO EN BASE DE DATOS YA SE INGRESO, SOLO ES NECESARIO MODIFICAR SU CONTENIDO
	
    var indicacion_tarea = document.transporte.indicacion_tarea_realizar.value;
    
    // VALIDACIONES
    var correcto = true;
    
    if( correcto 
    		&& indicacion_tarea == "" ) {
        correcto = false;
        alert("Es necesario especificar las indicaciones");
        document.transporte.indicacion_tarea_realizar.focus();
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
                        document.transporte_detalle.id_transporte.value = response.idTransporte;
                        // activa botones del form
                        activaCamposTransporteDetalle();
                        activaBtnTransporteDetalle();
                        // focus campo
                        document.transporte_detalle.select_proceso_transporte.focus();
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
    
    var cantidad            = document.transporte_detalle.cantidad.value;
    var especificaciones    = document.transporte_detalle.especificaciones.value;
    var precio_total_pesos  = document.transporte_detalle.precio_total_pesos.value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( correcto 
    		&& document.transporte_detalle.select_proceso_transporte.selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle del transporte");
        document.transporte_detalle.select_proceso_transporte.focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( correcto 
    		&& ( cantidad == "" || isNaN(cantidad) || parseInt( cantidad ) <= 0 ) ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.transporte_detalle.cantidad.focus();
    }
    
    // se dan las especifiaciones del trabajo
    if( correcto 
    		&& especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.transporte_detalle.especificaciones.focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( correcto 
    		&& ( !$.isNumeric( precio_total_pesos || isNaN(precio_total_pesos)) ) ) {
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.transporte_detalle.precio_total_pesos.focus();
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
                        document.transporte_detalle.select_proceso_transporte.remove( document.transporte_detalle.select_proceso_transporte.selectedIndex );
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
    delete precio_total_pesos;
    delete correcto;
} // ajaxAgregaDetalleTransporte()


function ajaxAgregaAcabado() {
	// EL REGISTRO EN BASE DE DATOS YA SE INGRESO, SOLO ES NECESARIO MODIFICAR SU CONTENIDO
	
    var indicacion_tarea = document.acabado.indicacion_tarea_realizar.value;
    
    // VALIDACIONES
    var correcto = true;
    
    if( indicacion_tarea == "" ) {
        correcto = false;
        alert("Es necesario especificar las indicaciones");
        document.acabado.indicacion_tarea_realizar.focus();
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
                        document.acabado_detalle.id_acabado.value = response.idAcabado;
                        // activa botones del form
                        activaCamposAcabadoDetalle();
                        activaBtnAcabadoDetalle();
                        // focus campo
                        document.acabado_detalle.select_proceso_externo.focus();
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

    var cantidad            = document.acabado_detalle.cantidad_proceso_externo.value;
    var especificaciones    = document.acabado_detalle.especificaciones.value;
    var precio_total_pesos  = document.acabado_detalle.precio_total_pesos.value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( correcto
    		&& document.acabado_detalle.select_proceso_externo.selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle del acabado");
        document.acabado_detalle.select_proceso_acabado.focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( correcto 
    		&& ( cantidad == "" || isNaN(cantidad) || parseInt( cantidad ) <= 0 ) ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.acabado_detalle.cantidad_proceso_externo.focus();
    }
    
    // se dan las especifiaciones del trabajo
    if( correcto 
    		&& especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.acabado_detalle.especificaciones.focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( correcto 
    		&& ( !$.isNumeric( precio_total_pesos || isNaN(precio_total_pesos) ) ) ){
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.acabado_detalle.precio_total_pesos.focus();
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
                        document.acabado_detalle.select_proceso_externo.remove( document.acabado_detalle.select_proceso_externo.selectedIndex );
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
    delete precio_total_pesos;
    delete correcto;
} // ajaxAgregaAcabadoDetalle()


function ajaxAgregaOffset() {
	// EL REGISTRO EN BASE DE DATOS YA SE INGRESO, SOLO ES NECESARIO MODIFICAR SU CONTENIDO
	
    var indicacion_tarea = document.offset.indicacion_tarea_realizar.value;
    
    // VALIDACIONES
    var correcto = true;
    
    if( indicacion_tarea == "" ) {
        correcto = false;
        alert("Es necesario especificar las indicaciones");
        document.offset.indicacion_tarea_realizar.focus();
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
    
    var observaciones = document.material_ayuda.observaciones.value;
    
    // VALIDACIONES
    var correcto = true;
    
    if( correcto 
    		&& document.material_ayuda.select_material_ayuda.selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo de material de ayuda");
        document.material_ayuda.select_material_ayuda.focus();
    }
    
    if( correcto 
    		&& document.material_ayuda.select_responsable_insumo.selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el responsable del material de ayuda");
        document.material_ayuda.select_responsable_insumo.focus();
    }
    
    if( correcto 
    		&& observaciones == "" ) {
        correcto = false;
        alert("Es necesario especificar las observaciones del material de ayuda");
        document.material_ayuda.observaciones.focus();
    }
    
    if( correcto ) {
        document.body.style.cursor = "wait";
        // desactiva campos y botones
        desactivaBtnMaterialAyuda();
        
        // copia de valores aqui porque quiza no haya un click antes
        var index_select_material_ayuda = document.material_ayuda.select_material_ayuda.selectedIndex;
        document.material_ayuda.id_material_ayuda.value = document.material_ayuda.select_material_ayuda.options[index_select_material_ayuda].value;
        delete index_select_material_ayuda;
        
        var index_select_responsable_insumo = document.material_ayuda.select_responsable_insumo.selectedIndex;
        document.material_ayuda.id_responsable_insumo.value = document.material_ayuda.select_responsable_insumo.options[index_select_responsable_insumo].value;
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
                        document.material_ayuda.select_material_ayuda.remove( document.material_ayuda.select_material_ayuda.selectedIndex );
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


function preparaNuevoTipoTrabajoDetalle() {
    // busca la informacion del div div_visualizador_tipo_trabajo_detalle 
    ajaxBuscaListaTipoTrabajoDetalle();
    // se guarda la informacion id_partida antes de limpiar todo
    var id_partida = document.tipo_trabajo_detalle.id_partida.value;
    // limpia form div_tipo_trabajo_detalle y div_costo_extra_detalle
    limpiaFormTipoTrabajoDetalle();
    limpiaFormCostoExtraDetalle();
    // oculta divs no necesarios
    document.getElementById("div_visualizador_pliegos").style.display       		= "none";
    document.getElementById("div_visualizador_costo_extra_detalle").style.display 	= "none";
    document.getElementById("div_costo_extra_detalle").style.display       			= "none";
    document.getElementById("div_nuevo_tipo_trabajo_detalle").style.display 		= "none";
    // inicializa el form tipo_trabajo_detalle
    document.tipo_trabajo_detalle.id_partida.value = id_partida;
    document.tipo_trabajo_detalle.descripcion_partida_detalle.focus();
    // elimina variable de inicializacion
    delete id_partida;
}


function ajaxBuscaListaTipoTrabajoDetalle() {
    $.ajax({
        type:"POST",
        url:urlBuscaListaTipoTrabajoDetalle,
        data:{id_partida:document.tipo_trabajo_detalle.id_partida.value},
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


function ajaxBuscaListaPartidas() {
    $.ajax({
        type:"POST",
        url:urlBuscaListaPartida,
        data:{id_orden_produccion:document.partida.id_orden_produccion.value},
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
}


function preparaNuevaPartida() {
    // busca la informacion del div_tabla_lista_partidas
    ajaxBuscaListaPartidas();
    
    // se guarda la informacion de id_orden_produccion antes de limpiar todo
    var id_orden_produccion = document.partida.id_orden_produccion.value;
    
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
    document.partida.id_orden_produccion.value = id_orden_produccion;
    document.partida.tipo_trabajo[0].click();
    document.partida.nombre_partida.focus();
    
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
    document.cotizacion.action = urlCalificacionOrdenProduccion;
    //document.forms['cotizacion'].method = "POST";
    document.cotizacion.submit();
}
