
// busca tipo placa segun objeto tipo maquina
function buscaTipoPlaca( obj ) {
    var id = obj.options[obj.selectedIndex].value;
    $.ajax({
        type:"POST",
        url:urlBuscaTipoPlaca,
        data:{id_maquina:id},
        success:function(response) {
            // jquery limpia select tipo_trabajo_detalle
            $("[name='select_tipo_placa']").empty();
            // parsea la informacion
            var jsonObject = JSON.parse( response.textoJson );
            $.each( jsonObject, function(i, item) {
                //alert( item.id_tipo_placa + ' ' + item.descripcion );
                var option = document.createElement("option");
                option.text     = item.descripcion;
                option.value    = item.id_tipo_placa;
                document.forms["tipo_trabajo_detalle"].elements["select_tipo_placa"].add( option );
                delete option;
                // coloca opcion del tipo de placas
                var clave			= document.tipo_trabajo_detalle.tipo_placa.value;
       			var select 			= document.tipo_trabajo_detalle.select_tipo_placa;
       			var encontroOpcion 	= false;
       			for( var i=0; i<select.length; i++ ) {
       				if( select.options[i].innerText == clave ) {
       					select.selectedIndex	= i;
       					encontroOpcion = true;
       					break;
       				}
       			}
       			if( !encontroOpcion ) {
       				select.selectedIndex = 0;
       			}
                delete clave;
       			delete select;
            } );
            delete jsonObject;
        },
        error:function(e) {
            alert("No fue posible cargar lista de placas por maquina");
        }
    });
    delete id;
}

// chkbx
function inicializaCheckbox( valor ) {
	document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked 			= valor;
	document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked 			= valor;
	document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked 	= valor;
	document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked 			= valor;
}

function copiaValorDeTextACheckbox() {
	document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked 			= document.tipo_trabajo_detalle.proporciona_papel.value=="Si"?true:false;
	document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked 			= document.tipo_trabajo_detalle.proporciona_placas.value=="Si"?true:false;
	document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked 	= document.tipo_trabajo_detalle.proporciona_tinta_especial.value=="Si"?true:false;
	document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked 			= document.tipo_trabajo_detalle.proporciona_barniz.value=="Si"?true:false;
}

function copiaValorDeCheckboxAText() {
	document.tipo_trabajo_detalle.proporciona_papel.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked?"Si":"No";
	document.tipo_trabajo_detalle.proporciona_placas.value			= document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked?"Si":"No";
	document.tipo_trabajo_detalle.proporciona_tinta_especial.value	= document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked?"Si":"No";
	document.tipo_trabajo_detalle.proporciona_barniz.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked?"Si":"No";
}

function copiaValorDeCheckboxAHidden() {
	document.tipo_trabajo_detalle.cliente_proporciona_papel.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_papel.checked;
	document.tipo_trabajo_detalle.cliente_proporciona_placas.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_placas.checked;
	document.tipo_trabajo_detalle.cliente_proporciona_tinta_especial.value 	= document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.checked;
	document.tipo_trabajo_detalle.cliente_proporciona_barniz.value 			= document.tipo_trabajo_detalle.checkbox_proporciona_barniz.checked;
}

function muestraCheckbox() {
	document.tipo_trabajo_detalle.proporciona_papel.style.display 					= "none";
	document.tipo_trabajo_detalle.proporciona_placas.style.display 					= "none";
	document.tipo_trabajo_detalle.proporciona_tinta_especial.style.display 			= "none";
	document.tipo_trabajo_detalle.proporciona_barniz.style.display 					= "none";
	
	document.tipo_trabajo_detalle.checkbox_proporciona_papel.style.display 			= "inline";
	document.tipo_trabajo_detalle.checkbox_proporciona_placas.style.display 		= "inline";
	document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.style.display = "inline";
	document.tipo_trabajo_detalle.checkbox_proporciona_barniz.style.display 		= "inline";
}

function ocultaCheckbox() {
	document.tipo_trabajo_detalle.checkbox_proporciona_papel.style.display 			= "none";
	document.tipo_trabajo_detalle.checkbox_proporciona_placas.style.display 		= "none";
	document.tipo_trabajo_detalle.checkbox_proporciona_tinta_especial.style.display = "none";
	document.tipo_trabajo_detalle.checkbox_proporciona_barniz.style.display 		= "none";
	
	document.tipo_trabajo_detalle.proporciona_papel.style.display 					= "inline";
	document.tipo_trabajo_detalle.proporciona_placas.style.display 					= "inline";
	document.tipo_trabajo_detalle.proporciona_tinta_especial.style.display 			= "inline";
	document.tipo_trabajo_detalle.proporciona_barniz.style.display 					= "inline";
}

// input select
function inicializaSelect() {
	document.tipo_trabajo_detalle.select_tipo_papel_extendido.selectedIndex 		= 0;
	document.tipo_trabajo_detalle.select_tamanio_publicacion.selectedIndex 			= 0;
	document.tipo_trabajo_detalle.select_frente_combinacion_tintas.selectedIndex 	= 0;
	document.tipo_trabajo_detalle.select_frente_tipo_barniz.selectedIndex 			= 0;
	document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.selectedIndex 	= 0;
	document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.selectedIndex 			= 0;
	document.tipo_trabajo_detalle.select_maquina.selectedIndex 						= 0;
	document.tipo_trabajo_detalle.select_tipo_placa.selectedIndex 					= 0;
	document.tipo_trabajo_detalle.select_tipo_complejidad.selectedIndex 			= 0;
}

function copiaValorDeTextASelect() {
	var clave;
	var select;
	
	clave	= document.tipo_trabajo_detalle.tipo_papel.value;
	select 	= document.tipo_trabajo_detalle.select_tipo_papel_extendido;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// select tamanio_publicacion
	clave	= document.tipo_trabajo_detalle.tamanio_pubicacion.value;
	select 	= document.tipo_trabajo_detalle.select_tamanio_publicacion;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// select frente_combinacion_tintas
	clave	= document.tipo_trabajo_detalle.frente_combinacion_tintas.value;
	select 	= document.tipo_trabajo_detalle.select_frente_combinacion_tintas;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// select frente_tipo_barniz
	clave	= document.tipo_trabajo_detalle.frente_tipo_barniz.value;
	select 	= document.tipo_trabajo_detalle.select_frente_tipo_barniz;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// select vuelta_combinacion_tintas
	clave	= document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value;
	select 	= document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// select vuelta_tipo_barniz
	clave	= document.tipo_trabajo_detalle.vuelta_tipo_barniz.value;
	select 	= document.tipo_trabajo_detalle.select_vuelta_tipo_barniz;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	//  select maquina
	clave	= document.tipo_trabajo_detalle.maquina.value;
	select 	= document.tipo_trabajo_detalle.select_maquina;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	// ajax para buscar tipo_placa	
	buscaTipoPlaca( document.tipo_trabajo_detalle.select_maquina );
	clave 	= document.tipo_trabajo_detalle.tipo_placa.value;
	select	= document.tipo_trabajo_detalle.select_tipo_placa;
	var encontroOpcion 	= false;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			encontroOpcion = true;
			break;
		}
	}
	if( !encontroOpcion ) 
		select.selectedIndex	= 0;
	delete encontroOpcion;
	
	// select tipo_complejidad
	clave 	= document.tipo_trabajo_detalle.tipo_complejidad.value;
	select 	= document.tipo_trabajo_detalle.select_tipo_complejidad;
	for( var i=0; i<select.length; i++ ) {
		if( select.options[i].text == clave ) {
			select.selectedIndex	= i;
			break;
		}
	}
	
	delete clave;
	delete select;
}

function copiaValorDeSelectAText() {
	document.tipo_trabajo_detalle.tipo_papel.value 					= document.tipo_trabajo_detalle.select_tipo_papel_extendido.options[document.tipo_trabajo_detalle.select_tipo_papel_extendido.selectedIndex].text;
	document.tipo_trabajo_detalle.tamanio_pubicacion.value 			= document.tipo_trabajo_detalle.select_tamanio_publicacion.options[document.tipo_trabajo_detalle.select_tamanio_publicacion.selectedIndex].text;;
	document.tipo_trabajo_detalle.frente_combinacion_tintas.value 	= document.tipo_trabajo_detalle.select_frente_combinacion_tintas.options[document.tipo_trabajo_detalle.select_frente_combinacion_tintas.selectedIndex].text;
	document.tipo_trabajo_detalle.frente_tipo_barniz.value 			= document.tipo_trabajo_detalle.select_frente_tipo_barniz.options[document.tipo_trabajo_detalle.select_frente_tipo_barniz.selectedIndex].text;
	document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value 	= document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.options[document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.selectedIndex].text;
	document.tipo_trabajo_detalle.vuelta_tipo_barniz.value 			= document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.options[document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.selectedIndex].text;
	document.tipo_trabajo_detalle.maquina.value 					= document.tipo_trabajo_detalle.select_maquina.options[document.tipo_trabajo_detalle.select_maquina.selectedIndex].text;
	document.tipo_trabajo_detalle.tipo_placa.value 					= document.tipo_trabajo_detalle.select_tipo_placa.options[document.tipo_trabajo_detalle.select_tipo_placa.selectedIndex].text;
	document.tipo_trabajo_detalle.tipo_complejidad.value 			= document.tipo_trabajo_detalle.select_tipo_complejidad.options[document.tipo_trabajo_detalle.select_tipo_complejidad.selectedIndex].text;
}

function copiaValorDeSelectAHidden() {
	document.tipo_trabajo_detalle.id_tipo_papel_extendido.value			= document.tipo_trabajo_detalle.select_tipo_papel_extendido.value;
	document.tipo_trabajo_detalle.id_tamanio_publicacion.value			= document.tipo_trabajo_detalle.select_tamanio_publicacion.value;
	document.tipo_trabajo_detalle.frente_id_combinacion_tintas.value	= document.tipo_trabajo_detalle.select_frente_combinacion_tintas.value;
	document.tipo_trabajo_detalle.frente_id_tipo_barniz.value			= document.tipo_trabajo_detalle.select_frente_tipo_barniz.value;
	document.tipo_trabajo_detalle.vuelta_id_combinacion_tintas.value	= document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.value;
	document.tipo_trabajo_detalle.vuelta_id_tipo_barniz.value			= document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.value;
	document.tipo_trabajo_detalle.id_maquina.value						= document.tipo_trabajo_detalle.select_maquina.value;
	document.tipo_trabajo_detalle.id_tipo_placa.value					= document.tipo_trabajo_detalle.select_tipo_placa.value;
	document.tipo_trabajo_detalle.id_tipo_complejidad.value				= document.tipo_trabajo_detalle.select_tipo_complejidad.value;
}

function muestraSelect() {
	document.tipo_trabajo_detalle.tipo_papel.style.display 							= "none";
	document.tipo_trabajo_detalle.tamanio_pubicacion.style.display 					= "none";
	document.tipo_trabajo_detalle.frente_combinacion_tintas.style.display 			= "none";
	document.tipo_trabajo_detalle.frente_tipo_barniz.style.display 					= "none";
	document.tipo_trabajo_detalle.vuelta_combinacion_tintas.style.display 			= "none";
	document.tipo_trabajo_detalle.vuelta_tipo_barniz.style.display 					= "none";
	document.tipo_trabajo_detalle.maquina.style.display 							= "none";
	document.tipo_trabajo_detalle.tipo_placa.style.display 							= "none";
	document.tipo_trabajo_detalle.tipo_complejidad.style.display 					= "none";
	
	document.tipo_trabajo_detalle.select_tipo_papel_extendido.style.display 		= "inline";
	document.tipo_trabajo_detalle.select_tamanio_publicacion.style.display 			= "inline";
	document.tipo_trabajo_detalle.select_frente_combinacion_tintas.style.display 	= "inline";
	document.tipo_trabajo_detalle.select_frente_tipo_barniz.style.display 			= "inline";
	document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.style.display 	= "inline";
	document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.style.display 			= "inline";
	document.tipo_trabajo_detalle.select_maquina.style.display 						= "inline";
	document.tipo_trabajo_detalle.select_tipo_placa.style.display 					= "inline";
	document.tipo_trabajo_detalle.select_tipo_complejidad.style.display 			= "inline";
}

function ocultaSelect() {
	document.tipo_trabajo_detalle.select_tipo_papel_extendido.style.display 		= "none";
	document.tipo_trabajo_detalle.select_tamanio_publicacion.style.display 			= "none";
	document.tipo_trabajo_detalle.select_frente_combinacion_tintas.style.display 	= "none";
	document.tipo_trabajo_detalle.select_frente_tipo_barniz.style.display 			= "none";
	document.tipo_trabajo_detalle.select_vuelta_combinacion_tintas.style.display 	= "none";
	document.tipo_trabajo_detalle.select_vuelta_tipo_barniz.style.display 			= "none";
	document.tipo_trabajo_detalle.select_maquina.style.display 						= "none";
	document.tipo_trabajo_detalle.select_tipo_placa.style.display 					= "none";
	document.tipo_trabajo_detalle.select_tipo_complejidad.style.display 			= "none";
	
	document.tipo_trabajo_detalle.tipo_papel.style.display 							= "inline";
	document.tipo_trabajo_detalle.tamanio_pubicacion.style.display 					= "inline";
	document.tipo_trabajo_detalle.frente_combinacion_tintas.style.display 			= "inline";
	document.tipo_trabajo_detalle.frente_tipo_barniz.style.display 					= "inline";
	document.tipo_trabajo_detalle.vuelta_combinacion_tintas.style.display 			= "inline";
	document.tipo_trabajo_detalle.vuelta_tipo_barniz.style.display 					= "inline";
	document.tipo_trabajo_detalle.maquina.style.display 							= "inline";
	document.tipo_trabajo_detalle.tipo_placa.style.display 							= "inline";
	document.tipo_trabajo_detalle.tipo_complejidad.style.display 					= "inline";
}

// Readonly campos visibles
function desactivaReadonlyCamposVisibles() {
	document.tipo_trabajo_detalle.descripcion_partida_detalle.readOnly 			= false;
	document.tipo_trabajo_detalle.alto_final.readOnly 							= false;
	document.tipo_trabajo_detalle.ancho_final.readOnly 							= false;
	document.tipo_trabajo_detalle.alto_extendido.readOnly 						= false;
	document.tipo_trabajo_detalle.ancho_extendido.readOnly 						= false;
	document.tipo_trabajo_detalle.repeticiones_x_pliego.readOnly 				= false;
	document.tipo_trabajo_detalle.numero_paginas_publicacion.readOnly 			= false;
	document.tipo_trabajo_detalle.alto_corte_inicial.readOnly					= false;
	document.tipo_trabajo_detalle.ancho_corte_inicial.readOnly					= false;
	document.tipo_trabajo_detalle.frente_num_tinta_especial.readOnly 			= false;
	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.readOnly 	= false;
	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.readOnly 			= false;
	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.readOnly 	= false;
}

function activaReadonlyCamposVisibles() {
	document.tipo_trabajo_detalle.descripcion_partida_detalle.readOnly 			= true;
	document.tipo_trabajo_detalle.alto_final.readOnly 							= true;
	document.tipo_trabajo_detalle.ancho_final.readOnly 							= true;
	document.tipo_trabajo_detalle.alto_extendido.readOnly 						= true;
	document.tipo_trabajo_detalle.ancho_extendido.readOnly 						= true;
	document.tipo_trabajo_detalle.repeticiones_x_pliego.readOnly 				= true;
	document.tipo_trabajo_detalle.numero_paginas_publicacion.readOnly 			= true;
	document.tipo_trabajo_detalle.alto_corte_inicial.readOnly					= true;
	document.tipo_trabajo_detalle.ancho_corte_inicial.readOnly					= true;
	document.tipo_trabajo_detalle.frente_num_tinta_especial.readOnly 			= true;
	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.readOnly 	= true;
	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.readOnly 			= true;
	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.readOnly 	= true;
}

// color de campos visibles
function aplicaColorFFFCamposVisibles() {
	document.tipo_trabajo_detalle.descripcion_partida_detalle.style.background 			= "#fff";
	document.tipo_trabajo_detalle.alto_final.style.background 							= "#fff";
	document.tipo_trabajo_detalle.ancho_final.style.background 							= "#fff";
	document.tipo_trabajo_detalle.alto_extendido.style.background 						= "#fff";
	document.tipo_trabajo_detalle.ancho_extendido.style.background 						= "#fff";
	document.tipo_trabajo_detalle.repeticiones_x_pliego.style.background 				= "#fff";
	document.tipo_trabajo_detalle.numero_paginas_publicacion.style.background 			= "#fff";
	document.tipo_trabajo_detalle.alto_corte_inicial.style.background					= "#fff";
	document.tipo_trabajo_detalle.ancho_corte_inicial.style.background					= "#fff";
	document.tipo_trabajo_detalle.frente_num_tinta_especial.style.background 			= "#fff";
	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.style.background 	= "#fff";
	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.style.background 			= "#fff";
	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.style.background 	= "#fff";
}

function aplicaColorTransparentCamposVisibles() {
	document.tipo_trabajo_detalle.descripcion_partida_detalle.style.background 			= "transparent";
	document.tipo_trabajo_detalle.alto_final.style.background 							= "transparent";
	document.tipo_trabajo_detalle.ancho_final.style.background 							= "transparent";
	document.tipo_trabajo_detalle.alto_extendido.style.background 						= "transparent";
	document.tipo_trabajo_detalle.ancho_extendido.style.background 						= "transparent";
	document.tipo_trabajo_detalle.repeticiones_x_pliego.style.background 				= "transparent";
	document.tipo_trabajo_detalle.numero_paginas_publicacion.style.background 			= "transparent";
	document.tipo_trabajo_detalle.alto_corte_inicial.style.background					= "transparent";
	document.tipo_trabajo_detalle.ancho_corte_inicial.style.background					= "transparent";
	document.tipo_trabajo_detalle.frente_num_tinta_especial.style.background 			= "transparent";
	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.style.background 	= "transparent";
	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.style.background 			= "transparent";
	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.style.background 	= "transparent";
}

// inicializa a blancos campos visibles
function inicializaBlancosCamposVisibles() {
	document.tipo_trabajo_detalle.descripcion_partida_detalle.value 		= "";
	document.tipo_trabajo_detalle.alto_final.value 							= "";
	document.tipo_trabajo_detalle.ancho_final.value 						= "";
	document.tipo_trabajo_detalle.alto_extendido.value 						= "";
	document.tipo_trabajo_detalle.ancho_extendido.value 					= "";
	document.tipo_trabajo_detalle.repeticiones_x_pliego.value 				= "";
	document.tipo_trabajo_detalle.numero_paginas_publicacion.value 			= "";
	document.tipo_trabajo_detalle.alto_corte_inicial.value 					= "0";
	document.tipo_trabajo_detalle.ancho_corte_inicial.value 				= "0";
	document.tipo_trabajo_detalle.frente_num_tinta_especial.value 			= "0";
	document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value 	= "";
	document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value 			= "0";
	document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value 	= "";
}

// VALIDACION
function validaDatosFormTTD() {
	var correcto = true;
	
	if ( correcto
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
    	document.tipo_trabajo_detalle.ancho_corte_inicial.value = "";
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
	        		&& document.tipo_trabajo_detalle.elementsselect_tamanio_publicacion.value == "1" ) {
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
	
	// valida que exista papel
    // AQUI NO ES NECESARIO PORQUE EXISTE UN INPUT SELECT
	
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
    
    return correcto;
}

