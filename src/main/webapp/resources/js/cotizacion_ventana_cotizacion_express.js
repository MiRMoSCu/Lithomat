
function buscaTipoPlaca( obj ) {
    var id = obj.options[obj.selectedIndex].value;
    $.ajax({
        type:"POST",
        url:urlBuscaTipoPlaca,
        data:{id_maquina:id},
        success:function(response) {
            // jquery limpia select tipo_trabajo_detalle
            $("[name='id_tipo_placa']").empty();
            // parsea la informacion
            var jsonObject = JSON.parse( response.textoJson );
            $.each( jsonObject, function(i, item) {
                //alert( item.id_tipo_placa + ' ' + item.descripcion );
                var option = document.createElement("option");
                option.text     = item.descripcion;
                option.value    = item.id_tipo_placa;
                document.cotizador_express.id_tipo_placa.add( option );
                delete option;
            } );
            delete jsonObject;
        },
        error:function(e) {
            alert("No fue posible cargar lista de placas por maquina");
        }
    });
    delete id;
}



function cierraVentana() {
	window.parent.Shadowbox.close();
}

function limpiaForm() {
	// campos generacion
	document.cotizador_express.id_tipo_trabajo.value 						= 1;
	document.cotizador_express.id_tipo_cliente.selectedIndex 				= 0;
	document.cotizador_express.cantidad.value 								= "0";
	document.cotizador_express.repeticiones_x_pliego.value 					= "0";
	document.cotizador_express.numero_paginas_publicacion.value 			= "0";
	document.cotizador_express.id_tamanio_publicacion.selectedIndex 		= 0;
	document.cotizador_express.numero_pliegos.value 						= "0";
	document.cotizador_express.incluye_costo_papel.checked 					= true;
	document.cotizador_express.id_tipo_papel_extendido.selectedIndex 		= 0;
	document.cotizador_express.frente_id_combinacion_tintas.selectedIndex 	= 0;
	document.cotizador_express.frente_numero_tinta_especial.value 			= "0";
	document.cotizador_express.frente_id_tipo_barniz.selectedIndex 			= 0;
	document.cotizador_express.vuelta_id_combinacion_tintas.selectedIndex 	= 0;
	document.cotizador_express.vuelta_numero_tinta_especial.value 			= "0";
	document.cotizador_express.vuelta_id_tipo_barniz.selectedIndex 			= 0;
	document.cotizador_express.id_maquina.selectedIndex 					= 0;
	document.cotizador_express.incluye_costo_placa.checked 					= true;
	document.cotizador_express.id_tipo_placa.selectedIndex 					= 0;
	document.cotizador_express.vuelta_mismas_placas.checked 				= false;
	// campos resultado
	document.cotizador_express.papel_descripcion.value 				= "";
	document.cotizador_express.tinta_descripcion.value 				= "";
	document.cotizador_express.tinta_especial_descripcion.value 	= "";
	document.cotizador_express.barniz_descripcion.value 			= "";
	document.cotizador_express.placas_descripcion.value 			= "";
	
	document.cotizador_express.papel_coste_total.value 				= "$ 0.00";
	document.cotizador_express.tinta_coste_total.value 				= "$ 0.00";
	document.cotizador_express.tinta_especial_coste_total.value 	= "$ 0.00";
	document.cotizador_express.barniz_coste_total.value 			= "$ 0.00";
	document.cotizador_express.placas_coste_total.value 			= "$ 0.00";
	
	document.cotizador_express.cotizacion_coste_total.value 		= "$ 0.00";
}

function limpiaCamposCosteTotal() {
	document.cotizador_express.papel_descripcion.value 				= "";
	document.cotizador_express.tinta_descripcion.value 				= "";
	document.cotizador_express.tinta_especial_descripcion.value 	= "";
	document.cotizador_express.barniz_descripcion.value 			= "";
	document.cotizador_express.placas_descripcion.value 			= "";
	
	document.cotizador_express.papel_coste_total.value 				= "";
	document.cotizador_express.tinta_coste_total.value 				= "";
	document.cotizador_express.tinta_especial_coste_total.value 	= "";
	document.cotizador_express.barniz_coste_total.value 			= "";
	document.cotizador_express.placas_coste_total.value 			= "";
	
	document.cotizador_express.cotizacion_coste_total.value 		= "";
}

function muestraInformacionCosto(response) {
	document.cotizador_express.papel_descripcion.value				= response.papelDescripcion;
	document.cotizador_express.tinta_descripcion.value 				= response.tintaDescripcion;
	document.cotizador_express.tinta_especial_descripcion.value 	= response.tintaEspecialDescripcion;
	document.cotizador_express.barniz_descripcion.value 			= response.barnizDescripcion;
	document.cotizador_express.placas_descripcion.value 			= response.placasDescripcion;
	
	document.cotizador_express.papel_coste_total.value				= "$ " + (response.papelCosteTotal).formatMoney(2);
	document.cotizador_express.tinta_coste_total.value 				= "$ " + (response.tintaCosteTotal).formatMoney(2);
	document.cotizador_express.tinta_especial_coste_total.value 	= "$ " + (response.tintaEspecialCosteTotal).formatMoney(2);
	document.cotizador_express.barniz_coste_total.value 			= "$ " + (response.barnizCosteTotal).formatMoney(2);
	document.cotizador_express.placas_coste_total.value 			= "$ " + (response.placasCosteTotal).formatMoney(2);
	document.cotizador_express.cotizacion_coste_total.value 		= "$ " + (response.cotizacionCosteTotal).formatMoney(2);
	
	// estilo papel
	if (!document.cotizador_express.incluye_costo_papel.checked) 
		document.cotizador_express.papel_coste_total.style.textDecoration = "line-through";
	else
		document.cotizador_express.papel_coste_total.style.textDecoration = "none";
	// estilo placa
	if (!document.cotizador_express.incluye_costo_placa.checked)
		document.cotizador_express.placas_coste_total.style.textDecoration = "line-through";
	else
		document.cotizador_express.placas_coste_total.style.textDecoration = "none";
		
}

function validaFormulario() {
	// validacion
	var correcto = true;
	
	// validacion cantidad
	if ( correcto
			&& (document.cotizador_express.cantidad.value == ""
				|| isNaN(document.cotizador_express.cantidad.value) 
				|| document.cotizador_express.cantidad.value <= 0) ) {
		correcto = false;
		alert("La cantidad debe ser un número entero mayor a cero. Favor de informalo.");
		document.cotizador_express.cantidad.focus();
		document.cotizador_express.cantidad.selected();
	}
	
	// validaciones por tipo trabajo
	switch (document.cotizador_express.id_tipo_trabajo.value) {
		case "1":
			document.cotizador_express.numero_paginas_publicacion.value = 0;
			document.cotizador_express.numero_pliegos.value 			= 0;
			if (correcto 
					&& (document.cotizador_express.repeticiones_x_pliego.value == ""
						|| isNaN(document.cotizador_express.repeticiones_x_pliego.value)
						|| parseInt(document.cotizador_express.repeticiones_x_pliego.value) <= 0)) {
				correcto = false;
				alert("El número de repeticiones deber ser un numero mayor a cero. Favor de informarlo.");
				document.cotizador_express.repeticiones_x_pliego.focus();
				document.cotizador_express.repeticiones_x_pliego.select();
			}
			break;
		case "2":
			document.cotizador_express.repeticiones_x_pliego.value 	= 0;
			document.cotizador_express.numero_pliegos.value 		= 0;
			if (correcto
					&& (document.cotizador_express.numero_paginas_publicacion.value == ""
						|| isNaN(document.cotizador_express.numero_paginas_publicacion.value)
						|| parseInt(document.cotizador_express.numero_paginas_publicacion.value) <= 0)
						|| parseInt(document.cotizador_express.numero_paginas_publicacion.value)%4 != 0) {
				correcto = false;
				alert("El número de páginas deber ser un numero mayor a cero y multiplo de 4. Favor de informarlo.");
				document.cotizador_express.numero_paginas_publicacion.focus();
				document.cotizador_express.numero_paginas_publicacion.select();
			}
			if (correcto
					&& document.cotizador_express.id_tamanio_publicacion.value == "1") {
				correcto = false;
				alert("El tamaño de la publicaci&oacute;n no puede ser 'No Aplica'");
				document.cotizador_express.id_tamanio_publicacion.focus();
			}
			break;
		case "3":
			document.cotizador_express.repeticiones_x_pliego.value 		= 0;
			document.cotizador_express.numero_paginas_publicacion.value = 0;
			if (correcto
					&& (document.cotizador_express.numero_pliegos.value == ""
						|| isNaN(document.cotizador_express.numero_pliegos.value)
						|| parseInt(document.cotizador_express.numero_pliegos.value) <= 0)) {
				correcto = false;
				alert("El número de pliegos deber ser un numero mayor a cero. Favor de informarlo.");
				document.cotizador_express.numero_pliegos.focus();
				document.cotizador_express.numero_pliegos.select();
			}
			
			var arr_tamanio_publicacion = ["1", "0.5", "0.25", "0.125", "0.0625", "0.03125"];
			var n_pliegos = parseFloat(document.cotizador_express.numero_pliegos.value);
			var index, tamanio_publicacion;
			for (index = 0; index < arr_tamanio_publicacion.length; index++) {
				if (n_pliegos > 0) {
					do {
						tamanio_publicacion = parseFloat(arr_tamanio_publicacion[index]);
						if (n_pliegos >= tamanio_publicacion) 
							n_pliegos -= tamanio_publicacion;
						else
							break;
					} while (n_pliegos > 0);
				} else
					break;
			}
			if ( n_pliegos != 0 ) {
				correcto = false;
				alert("El número de pliegos no es válido");
				document.cotizador_express.numero_pliegos.focus();
				document.cotizador_express.numero_pliegos.select();
			}
			break;
	}
	
	/*
	// validacion papel
	if (correcto
			&& document.cotizador_express.incluye_costo_papel.checked
			&& document.cotizador_express.descripcion_papel.value == "") {
		correcto = false;
		alert("La descripcion de papel no puede estar vacía. Favor de informarlo.");
	}
	*/
	return correcto;
}

function buscaCotizacionExpress() {
		
	if (validaFormulario()) {
		document.body.style.cursor="wait";
		$.ajax({
			type:"POST",
			url:urlCalculaCotizacion,
			data:$("[name=cotizador_express]").serialize(),
			success:function( response ) {
				//console.log(response);
				limpiaCamposCosteTotal();
				setTimeout(function(){
					muestraInformacionCosto(response);
				},50);
				document.body.style.cursor="default";
			},
			error: function( e ) {
				console.log(e);
				alert("No fue posible conectarse con el servidor");
				document.body.style.cursor="default";
			}
		});
	}
	
	delete correcto;
}

function impresionCotizacionExpress() {
	if (validaFormulario()) {
		document.cotizador_express.method = "POST";
		document.cotizador_express.action = urlReporteExcel;
		document.cotizador_express.submit();
	}
}







