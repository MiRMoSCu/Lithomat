
function limpiaCamposFormTransporteDetalle() {
	document.transporte_detalle.detalle.value 				= "";
	document.transporte_detalle.cantidad.value 				= "";
	document.transporte_detalle.precio_total_pesos.value 	= "";
	document.transporte_detalle.especificaciones.value 		= "";
	// limpia select
	$("[name='select_proceso_transporte']").empty();
} // limpiaCamposFormTransporteDetalle

function activaCamposFormTransporteDetalle() {
	// activa select
	document.transporte_detalle.select_proceso_transporte.disabled = false;
	// elimina opcion readOnly
	document.transporte_detalle.cantidad.readOnly 			= false;
	document.transporte_detalle.precio_total_pesos.readOnly = false;
	document.transporte_detalle.especificaciones.disabled 	= false;
	// cambia el color
	document.transporte_detalle.cantidad.style.background 			= "#fff";
	document.transporte_detalle.precio_total_pesos.style.background = "#fff";
	document.transporte_detalle.especificaciones.style.background 	= "#fff";
} // activaCamposFormTransporteDetalle

function desactivaCamposFormTransporteDetalle() {
	// desactiva select
	document.transporte_detalle.select_proceso_transporte.disabled = true;
	// activa opcion readOnly
	document.transporte_detalle.cantidad.readOnly 			= true;
	document.transporte_detalle.precio_total_pesos.readOnly = true;
	document.transporte_detalle.especificaciones.disabled 	= true;
	// cambia el color
	document.transporte_detalle.cantidad.style.background 			= "transparent";
	document.transporte_detalle.precio_total_pesos.style.background = "transparent";
	document.transporte_detalle.especificaciones.style.background 	= "transparent";
} // desactivaCamposFormTransporteDetalle

function activaBotonesAgregarFormTransporteDetalle() {
	document.getElementById("imgBtnAgregarTransporteDetalle").style.display 		= "none";
	document.getElementById("imgBtnAgregarTransporteDetalle").style.display 		= "none";
	document.getElementById("imgBtnAceptaAgregarTransporteDetalle").style.display 	= "inline";
	document.getElementById("imgBtnCancelaAgregarTransporteDetalle").style.display	= "inline";
} // activaBotonesAgregarFormTransporteDetalle

function desactivaBotonesAgregarFormTransporteDetalle() {
	document.getElementById("imgBtnAgregarTransporteDetalle").style.display 		= "inline";
	document.getElementById("imgBtnAgregarTransporteDetalle").style.display 		= "inline";
	document.getElementById("imgBtnAceptaAgregarTransporteDetalle").style.display 	= "none";
	document.getElementById("imgBtnCancelaAgregarTransporteDetalle").style.display 	= "none";
} // desactivaBotonesAgregarFormTransporteDetalle

function generaListaTransporteDetalle() {
	// genera el arreglo
	var arregloProcesosTransporte = [];
	// leer una tabla
	var tabla = document.getElementById("tabla_lista_transporte_detalle");
	for(var i=1; i<tabla.rows.length; i++) {
		arregloProcesosTransporte.push(tabla.rows[i].cells[1].innerHTML);
	}
	tabla = null;
	//inicializa select
    $("[name='select_proceso_transporte']").empty();
	// parse del json
    var jsonObject = JSON.parse( strJsonListaProcesoTransporte );
    $.each( jsonObject, function(i, item){
    	if( $.inArray( item.text, arregloProcesosTransporte) < 0 ) {
    		var option = document.createElement("option");
	        option.value = item.value;
	        option.text	 = item.text;
	        document.getElementById("select_proceso_transporte").add( option );
	        delete option;	
    	}
    });
    jsonObject = null;
} // generaListaTransporteDetalle

function selectTransporteDetalleClick(obj) {
	if( obj.selectedIndex != "-1" ) {
		document.transporte_detalle.id_proceso_transporte.value = obj.options[obj.selectedIndex].value;
		document.transporte_detalle.detalle.value 				= obj.options[obj.selectedIndex].text;
    }
} // selectTransporteDetalleClick

function agregaTransporteDetalle() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_agregar_transporte_detalle").style.display = "inline";
	// genera la lista de los procesos de disenio
	generaListaTransporteDetalle();
	// activa campos del form
	activaCamposFormTransporteDetalle();
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesAgregarFormTransporteDetalle();
} // agregaTransporteDetalle

function aceptaAgregarTransporteDetalle() {
	var cantidad            = document.forms["transporte_detalle"].elements["cantidad"].value;
    var especificaciones    = document.forms["transporte_detalle"].elements["especificaciones"].value;
    var precio_total_pesos  = document.forms["transporte_detalle"].elements["precio_total_pesos"].value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( document.transporte_detalle.select_proceso_transporte.selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle del dise\u00f1o");
        document.transporte_detalle.select_proceso_transporte.focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( cantidad == "" || isNaN(cantidad) || parseInt( cantidad ) <= 0  ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.transporte_detalle.cantidad.focus();
    }
    
    // se dan las especificaciones del trabajo
    if( especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.transporte_detalle.especificaciones.focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( !$.isNumeric( precio_total_pesos ) ) {
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.transporte_detalle.precio_total_pesos.focus();
    }
	
	if(correcto) {
		document.body.style.cursor = "wait";
		desactivaCamposFormTransporteDetalle();
		desactivaBotonesAgregarFormTransporteDetalle();
		
		document.transporte_detalle.id_transporte.value = document.transporte.id_transporte.value;
		var data = $("[name=transporte_detalle]").serialize() + "&especificaciones=" + document.transporte_detalle.especificaciones.value; 
		$.ajax({
			type:"POST",
			url:urlAgregaTransporteDetalleOlvidado,
			data:data,
			success:function(response){
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						break;
					default: // exito
						//console.log(response.textoHTML);
    					// actualiza la tabla
    					document.getElementById("div_tabla_lista_transporte_detalle").innerHTML = response.textoHTML; 
    					// actualiza el precio
    					document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
						break;
				}
				// limpoa campos
				cancelaAgregarTransporteDetalle();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaAgregarTransporteDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
		delete data;
	}
	delete cantidad;
    delete especificaciones;
    delete precio_total_pesos;
    delete correcto;
} // aceptaAgregarTransporteDetalle

function cancelaAgregarTransporteDetalle() {
	document.transporte_detalle.id_proceso_transporte.value = "";
	// limpia los campos del formulario disenio_detalle
	limpiaCamposFormTransporteDetalle();
	// desactiva campos del form
	desactivaCamposFormTransporteDetalle();
	// desactiva botones ACEPTAR y CANCELAR
	desactivaBotonesAgregarFormTransporteDetalle();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
} // cancelaAgregarTransporteDetalle