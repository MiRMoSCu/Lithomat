
function limpiaCamposFormAcabadoDetalle() {
	document.acabado_detalle.detalle.value 						= "";
	document.acabado_detalle.ancho.value 						= "";
	document.acabado_detalle.alto.value 						= "";
	document.acabado_detalle.cantidad_proceso_externo.value 	= "";
	document.acabado_detalle.precio_total_pesos.value 			= "";
	document.acabado_detalle.especificaciones.value 			= "";
	// limpia select
	$("[name='select_proceso_externo']").empty();
} // limpiaCamposFormAcabadoDetalle

function activaCamposFormAcabadoDetalle() {
	// activa select
	document.acabado_detalle.select_proceso_externo.disabled = false;
	// elimina opcion readOnly
	document.acabado_detalle.ancho.readOnly 					= false;
	document.acabado_detalle.alto.readOnly 						= false;
	document.acabado_detalle.cantidad_proceso_externo.readOnly 	= false;
	document.acabado_detalle.precio_total_pesos.readOnly 		= false;
	document.acabado_detalle.especificaciones.disabled 			= false;
	// cambia el color
	document.acabado_detalle.ancho.style.background 					= "#fff";
	document.acabado_detalle.alto.style.background 						= "#fff";
	document.acabado_detalle.cantidad_proceso_externo.style.background 	= "#fff";
	document.acabado_detalle.precio_total_pesos.style.background 		= "#fff";
	document.acabado_detalle.especificaciones.style.background 			= "#fff";
} // activaCamposFormAcabadoDetalle

function desactivaCamposFormAcabadoDetalle() {
	// desactiva select
	document.acabado_detalle.select_proceso_externo.disabled = true;
	// activa opcion readOnly
	document.acabado_detalle.ancho.readOnly 					= true;
	document.acabado_detalle.alto.readOnly 						= true;
	document.acabado_detalle.cantidad_proceso_externo.readOnly 	= true;
	document.acabado_detalle.precio_total_pesos.readOnly 		= true;
	document.acabado_detalle.especificaciones.disabled 			= true;
	// cambia el color
	document.acabado_detalle.ancho.style.background 					= "transparent";
	document.acabado_detalle.alto.style.background 						= "transparent";
	document.acabado_detalle.cantidad_proceso_externo.style.background 	= "transparent";
	document.acabado_detalle.precio_total_pesos.style.background 		= "transparent";
	document.acabado_detalle.especificaciones.style.background 			= "transparent";
} // desactivaCamposFormAcabadoDetalle

function activaBotonesAgregarFormAcabadoDetalle() {
	document.getElementById("imgBtnAgregarAcabadoDetalle").style.display 		= "none";
	document.getElementById("imgBtnAgregarAcabadoDetalle").style.display 		= "none";
	document.getElementById("imgBtnAceptaAgregarAcabadoDetalle").style.display 	= "inline";
	document.getElementById("imgBtnCancelaAgregarAcabadoDetalle").style.display	= "inline";
} // activaBotonesAgregarFormAcabadoDetalle

function desactivaBotonesAgregarFormAcabadoDetalle() {
	document.getElementById("imgBtnAgregarAcabadoDetalle").style.display 		= "inline";
	document.getElementById("imgBtnAgregarAcabadoDetalle").style.display 		= "inline";
	document.getElementById("imgBtnAceptaAgregarAcabadoDetalle").style.display 	= "none";
	document.getElementById("imgBtnCancelaAgregarAcabadoDetalle").style.display = "none";
} // desactivaBotonesAgregarFormAcabadoDetalle

function generaListaAcabadoDetalle() {
	// genera el arreglo
	var arregloProcesoExterno = [];
	// leer una tabla
	var tabla = document.getElementById("tabla_lista_acabado_detalle");
	for(var i=1; i<tabla.rows.length; i++) {
		arregloProcesoExterno.push(tabla.rows[i].cells[1].innerHTML);
	}
	tabla = null;
	//inicializa select
    $("[name='select_proceso_externo']").empty();
	// parse del json
    var jsonObject = JSON.parse( strJsonListaProcesoExterno );
    $.each( jsonObject, function(i, item){
    	if( $.inArray( item.text, arregloProcesoExterno) < 0 ) {
    		var option = document.createElement("option");
	        option.value = item.value;
	        option.text	 = item.text;
	        document.getElementById("select_proceso_externo").add( option );
	        delete option;	
    	}
    });
    jsonObject = null;
} // generaListaAcabadoDetalle

function selectAcabadoDetalleClick(obj) {
	if( obj.selectedIndex != "-1" ) {
		document.acabado_detalle.id_proceso_externo.value 	= obj.options[obj.selectedIndex].value;
		document.acabado_detalle.detalle.value 				= obj.options[obj.selectedIndex].text;
    }
} // selectAcabadoDetalleClick

function agregaAcabadoDetalle() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_agregar_acabado_detalle").style.display = "inline";
	// genera la lista de los procesos de disenio
	generaListaAcabadoDetalle();
	// activa campos del form
	activaCamposFormAcabadoDetalle();
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesAgregarFormAcabadoDetalle();
} // agregaAcabadoDetalle

function aceptaAgregarAcabadoDetalle() {
	
	var cantidad            = document.forms["acabado_detalle"].elements["cantidad_proceso_externo"].value;
    var especificaciones    = document.forms["acabado_detalle"].elements["especificaciones"].value;
    var precio_total_pesos  = document.forms["acabado_detalle"].elements["precio_total_pesos"].value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( document.acabado_detalle.select_proceso_externo.selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle del dise\u00f1o");
        document.acabado_detalle.select_proceso_externo.focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( cantidad == "" || parseInt( cantidad ) <= 0  ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.acabado_detalle.cantidad_proceso_externo.focus();
    }
    
    // se dan las especificaciones del trabajo
    if( especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.acabado_detalle.especificaciones.focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( !$.isNumeric( precio_total_pesos ) ) {
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.acabado_detalle.precio_total_pesos.focus();
    }
	
	if(correcto) {
		document.body.style.cursor = "wait";
		desactivaCamposFormAcabadoDetalle();
		desactivaBotonesAgregarFormAcabadoDetalle();
		
		document.acabado_detalle.id_acabado.value = document.acabado.id_acabado.value;
		var data = $("[name=acabado_detalle]").serialize() + "&especificaciones=" + document.acabado_detalle.especificaciones.value; 
		$.ajax({
			type:"POST",
			url:urlAgregaAcabadoDetalleOlvidado,
			data:data,
			success:function(response){
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						break;
					default: // exito
						//console.log(response.textoHTML);
    					// actualiza la tabla
    					document.getElementById("div_tabla_lista_acabado_detalle").innerHTML = response.textoHTML; 
    					// actualiza el precio
    					document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
						break;
				}
				// limpoa campos
				cancelaAgregarAcabadoDetalle();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaAgregarAcabadoDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
		delete data;
	}
	delete cantidad;
    delete especificaciones;
    delete precio_total_pesos;
    delete correcto;
} // aceptaAgregarAcabadoDetalle

function cancelaAgregarAcabadoDetalle() {
	document.acabado_detalle.id_proceso_externo.value = "";
	// limpia los campos del formulario disenio_detalle
	limpiaCamposFormAcabadoDetalle();
	// desactiva campos del form
	desactivaCamposFormAcabadoDetalle();
	// desactiva botones ACEPTAR y CANCELAR
	desactivaBotonesAgregarFormAcabadoDetalle();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
} // cancelaAgregarAcabadoDetalle