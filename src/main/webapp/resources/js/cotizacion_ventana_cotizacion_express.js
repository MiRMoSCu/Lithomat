
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
	document.cotizador_express.id_tipo_cliente.selectedIndex 				= 0;
	document.cotizador_express.id_maquina.selectedIndex 					= 0;
	document.cotizador_express.cantidad.value 								= "";
	document.cotizador_express.numero_pliegos.value 						= "";
	document.cotizador_express.frente_id_combinacion_tintas.selectedIndex 	= 0;
	document.cotizador_express.vuelta_id_combinacion_tintas.selectedIndex 	= 0;
	document.cotizador_express.frente_numero_tinta_especial.value 			= "0";
	document.cotizador_express.vuelta_numero_tinta_especial.value 			= "0";
	document.cotizador_express.frente_id_tipo_barniz.selectedIndex 			= 0;
	document.cotizador_express.vuelta_id_tipo_barniz.selectedIndex 			= 0;
	document.cotizador_express.id_tipo_placa.selectedIndex 					= 0;
	document.cotizador_express.vuelta_mismas_placas.checked 				= false;
	// campos resultado
	document.cotizador_express.tinta_descripcion.value 				= "";
	document.cotizador_express.tinta_especial_descripcion.value 	= "";
	document.cotizador_express.barniz_descripcion.value 			= "";
	document.cotizador_express.placas_descripcion.value 			= "";
	
	document.cotizador_express.tinta_coste_total.value 				= "$ 0.00";
	document.cotizador_express.tinta_especial_coste_total.value 	= "$ 0.00";
	document.cotizador_express.barniz_coste_total.value 			= "$ 0.00";
	document.cotizador_express.placas_coste_total.value 			= "$ 0.00";
	
	document.cotizador_express.cotizacion_coste_total.value 		= "$ 0.00";
}

function muestraInformacionCosto(response) {
	document.cotizador_express.tinta_descripcion.value 				= response.tintaDescripcion;
	document.cotizador_express.tinta_especial_descripcion.value 	= response.tintaEspecialDescripcion;
	document.cotizador_express.barniz_descripcion.value 			= response.barnizDescripcion;
	document.cotizador_express.placas_descripcion.value 			= response.placasDescripcion;
	
	document.cotizador_express.tinta_coste_total.value 				= "$ " + (response.tintaCosteTotal).formatMoney(2);
	document.cotizador_express.tinta_especial_coste_total.value 	= "$ " + (response.tintaEspecialCosteTotal).formatMoney(2);
	document.cotizador_express.barniz_coste_total.value 			= "$ " + (response.barnizCosteTotal).formatMoney(2);
	document.cotizador_express.placas_coste_total.value 			= "$ " + (response.placasCosteTotal).formatMoney(2);
	document.cotizador_express.cotizacion_coste_total.value 		= "$ " + (response.cotizacionCosteTotal).formatMoney(2);
}

function buscaCotizacionExpress() {
	// validacion
	var correcto = true;
	
	if ( correcto
			&& (document.cotizador_express.cantidad.value == ""
				|| isNaN(document.cotizador_express.cantidad.value) 
				|| document.cotizador_express.cantidad.value <= 0) ) {
		correcto = false;
		alert("La cantidad debe ser un número entero mayor a cero");
		document.cotizador_express.cantidad.focus();
		document.cotizador_express.cantidad.selected();
	}
	
	if ( correcto
			&& (document.cotizador_express.numero_pliegos.value == ""
				|| isNaN(document.cotizador_express.numero_pliegos.value)
				|| document.cotizador_express.numero_pliegos.value <=0 ) ) {
		correcto = false;
		alert("El numero de pliegos debe ser un número mayor a cero");
		document.cotizador_express.numero_pliegos.focus();
		document.cotizador_express.numero_pliegos.selected();
	}
	
	if ( correcto ) {
		$.ajax({
			type:"POST",
			url:urlCalculaCotizacion,
			data:$("[name=cotizador_express]").serialize(),
			success:function( response ) {
				//console.log(response);
				muestraInformacionCosto(response);
			},
			error: function( e ) {
				console.log(e);
				alert("No fue posible conectarse con el servidor");
			}
		});
	}
	
	delete correcto;
}