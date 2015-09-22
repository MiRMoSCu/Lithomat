
function limpiaCamposFormPreprensaDetalle() {
	document.preprensa_detalle.detalle.value 			= "";
	document.preprensa_detalle.cantidad.value 			= "";
	document.preprensa_detalle.precio_total_pesos.value = "";
	document.preprensa_detalle.especificaciones.value 	= "";
	// limpia select
	$("[name='select_proceso_preprensa']").empty();
} // limpiaCamposFormPreprensaDetalle

function activaCamposFormPreprensaDetalle() {
	// activa select
	document.preprensa_detalle.select_proceso_preprensa.disabled = false;
	// elimina opcion readOnly
	document.preprensa_detalle.cantidad.readOnly 			= false;
	document.preprensa_detalle.precio_total_pesos.readOnly 	= false;
	document.preprensa_detalle.especificaciones.disabled 	= false;
	// cambia el color
	document.preprensa_detalle.cantidad.style.background 			= "#fff";
	document.preprensa_detalle.precio_total_pesos.style.background 	= "#fff";
	document.preprensa_detalle.especificaciones.style.background 	= "#fff";
} // activaCamposFormPreprensaDetalle
	
function desactivaCamposFormPreprensaDetalle() {
	// desactiva select
	document.preprensa_detalle.select_proceso_preprensa.disabled = true;
	// activa opcion readOnly
	document.preprensa_detalle.cantidad.readOnly 			= true;
	document.preprensa_detalle.precio_total_pesos.readOnly 	= true;
	document.preprensa_detalle.especificaciones.disabled 	= true;
	// cambia el color
	document.preprensa_detalle.cantidad.style.background 			= "transparent";
	document.preprensa_detalle.precio_total_pesos.style.background 	= "transparent";
	document.preprensa_detalle.especificaciones.style.background 	= "transparent";
} // desactivaCamposFormPreprensaDetalle

function activaBotonesAgregarFormPreprensaDetalle() {
	document.getElementById("imgBtnAgregarPreprensaDetalle").style.display 			= "none";
	document.getElementById("imgBtnAgregarPreprensaDetalle").style.display 			= "none";
	document.getElementById("imgBtnAceptaAgregarPreprensaDetalle").style.display 	= "inline";
	document.getElementById("imgBtnCancelaAgregarPreprensaDetalle").style.display	= "inline";
} // activaBotonesAgregarFormPreprensaDetalle
	
function desactivaBotonesAgregarFormPreprensaDetalle() {
	document.getElementById("imgBtnAgregarPreprensaDetalle").style.display 		= "inline";
	document.getElementById("imgBtnAgregarPreprensaDetalle").style.display 			= "inline";
	document.getElementById("imgBtnAceptaAgregarPreprensaDetalle").style.display 	= "none";
	document.getElementById("imgBtnCancelaAgregarPreprensaDetalle").style.display 	= "none";
} // desactivaBotonesAgregarFormPreprensaDetalle

function generaListaPreprensaDetalle() {
	// genera el arreglo
	var arregloProcesosPreprensa = [];
	// leer una tabla
	var tabla = document.getElementById("tabla_lista_preprensa_detalle");
	for(var i=1; i<tabla.rows.length; i++) {
		arregloProcesosPreprensa.push(tabla.rows[i].cells[1].innerHTML);
	}
	tabla = null;
	//inicializa select
    $("[name='select_proceso_preprensa']").empty();
	// parse del json
    var jsonObject = JSON.parse( strJsonListaProcesoPreprensa );
    $.each( jsonObject, function(i, item){
    	if( $.inArray( item.text, arregloProcesosPreprensa) < 0 ) {
    		var option = document.createElement("option");
	        option.value = item.value;
	        option.text	 = item.text;
	        document.getElementById("select_proceso_preprensa").add( option );
	        delete option;	
    	}
    });
    jsonObject = null;
} // generaListaPreprensaDetalle

function selectPreprensaDetalleClick(obj) {
	if( obj.selectedIndex != "-1" ) {
		document.preprensa_detalle.id_proceso_preprensa.value 	= obj.options[obj.selectedIndex].value;
		document.preprensa_detalle.detalle.value 				= obj.options[obj.selectedIndex].text;
    }
} // selectPreprensaDetalleClick

function agregaPreprensaDetalle() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_agregar_preprensa_detalle").style.display = "inline";
	// genera la lista de los procesos de disenio
	generaListaPreprensaDetalle();
	// activa campos del form
	activaCamposFormPreprensaDetalle();
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesAgregarFormPreprensaDetalle();
} // agregaPreprensaDetalle

function aceptaAgregarPreprensaDetalle() {
	var cantidad            = document.forms["preprensa_detalle"].elements["cantidad"].value;
    var especificaciones    = document.forms["preprensa_detalle"].elements["especificaciones"].value;
    var precio_total_pesos  = document.forms["preprensa_detalle"].elements["precio_total_pesos"].value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( document.preprensa_detalle.select_proceso_preprensa.selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle del dise\u00f1o");
        document.preprensa_detalle.select_proceso_preprensa.focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( cantidad == "" || parseInt( cantidad ) <= 0  ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.preprensa_detalle.cantidad.focus();
    }
    
    // se dan las especificaciones del trabajo
    if( especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.preprensa_detalle.especificaciones.focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( !$.isNumeric( precio_total_pesos ) ) {
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.preprensa_detalle.precio_total_pesos.focus();
    }
	
	if(correcto) {
		document.body.style.cursor = "wait";
		desactivaCamposFormPreprensaDetalle();
		desactivaBotonesAgregarFormPreprensaDetalle();
		
		document.preprensa_detalle.id_preprensa.value = document.preprensa.id_preprensa.value;
		var data = $("[name=preprensa_detalle]").serialize() + "&especificaciones=" + document.preprensa_detalle.especificaciones.value; 
		$.ajax({
			type:"POST",
			url:urlAgregaPreprensaDetalleOlvidado,
			data:data,
			success:function(response){
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						break;
					default: // exito
						//console.log(response.textoHTML);
    					// actualiza la tabla
    					document.getElementById("div_tabla_lista_preprensa_detalle").innerHTML = response.textoHTML; 
    					// actualiza el precio
    					document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
						break;
				}
				// limpoa campos
				cancelaAgregarPreprensaDetalle();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaAgregarPreprensaDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
		delete data;
	}
	delete cantidad;
    delete especificaciones;
    delete precio_total_pesos;
    delete correcto;
} // aceptaAgregarPreprensaDetalle

function cancelaAgregarPreprensaDetalle() {
	document.preprensa_detalle.id_proceso_preprensa.value = "";
	// limpia los campos del formulario disenio_detalle
	limpiaCamposFormPreprensaDetalle();
	// desactiva campos del form
	desactivaCamposFormPreprensaDetalle();
	// desactiva botones ACEPTAR y CANCELAR
	desactivaBotonesAgregarFormPreprensaDetalle();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
} // cancelaAgregarPreprensaDetalle