function limpiaCamposFormDisenioDetalle() {
	document.disenio_detalle.id_proceso_disenio.value 	= "";
	document.disenio_detalle.detalle.value 				= "";
	document.disenio_detalle.cantidad.value 			= "";
	document.disenio_detalle.precio_total_pesos.value 	= "";
	document.disenio_detalle.especificaciones.value 	= "";
	// limpia select
	$("[name='select_proceso_disenio']").empty();
} // limpiaCamposFormDisenioDetalle

function activaCamposFormDisenioDetalle() {
	// activa select
	document.disenio_detalle.select_proceso_disenio.disabled = false;
	// elimina opcion readOnly
	document.disenio_detalle.cantidad.readOnly 				= false;
	document.disenio_detalle.precio_total_pesos.readOnly 	= false;
	document.disenio_detalle.especificaciones.disabled 		= false;
	// cambia el color
	document.disenio_detalle.cantidad.style.background 				= "#fff";
	document.disenio_detalle.precio_total_pesos.style.background 	= "#fff";
	document.disenio_detalle.especificaciones.style.background 		= "#fff";
} // activaCamposFormDisenioDetalle
	
function desactivaCamposFormDisenioDetalle() {
	// desactiva select
	document.disenio_detalle.select_proceso_disenio.disabled = true;
	// activa opcion readOnly
	document.disenio_detalle.cantidad.readOnly 				= true;
	document.disenio_detalle.precio_total_pesos.readOnly 	= true;
	document.disenio_detalle.especificaciones.disabled 		= true;
	// cambia el color
	document.disenio_detalle.cantidad.style.background 				= "transparent";
	document.disenio_detalle.precio_total_pesos.style.background 	= "transparent";
	document.disenio_detalle.especificaciones.style.background 		= "transparent";
} // desactivaCamposFormDisenioDetalle

function activaBotonesAgregarFormDisenioDetalle() {
	document.getElementById("imgBtnAgregarDisenioDetalle").style.display 		= "none";
	document.getElementById("imgBtnAgregarDisenioDetalle").style.display 		= "none";
	document.getElementById("imgBtnAceptaAgregarDisenioDetalle").style.display 	= "inline";
	document.getElementById("imgBtnCancelaAgregarDisenioDetalle").style.display = "inline";
} // activaBotonesModificarFormDisenioDetalle
	
function desactivaBotonesAgregarFormDisenioDetalle() {
	document.getElementById("imgBtnAgregarDisenioDetalle").style.display 		= "inline";
	document.getElementById("imgBtnAgregarDisenioDetalle").style.display 		= "inline";
	document.getElementById("imgBtnAceptaAgregarDisenioDetalle").style.display 	= "none";
	document.getElementById("imgBtnCancelaAgregarDisenioDetalle").style.display = "none";
} // desactivaBotonesModificarFormDisenioDetalle

function generaListaDisenioDetalle() {
	// genera el arreglo
	var arregloProcesosDisenio = [];
	// leer una tabla
	var tabla = document.getElementById("tabla_lista_disenio_detalle");
	for(var i=1; i<tabla.rows.length; i++) {
		arregloProcesosDisenio.push(tabla.rows[i].cells[1].innerHTML);
	}
	tabla = null;
	//inicializa select
    $("[name='select_proceso_disenio']").empty();
	// parse del json
    var jsonObject = JSON.parse( strJsonListaProcesoDisenio );
    $.each( jsonObject, function(i, item){
    	if( $.inArray( item.text, arregloProcesosDisenio) < 0 ) {
    		var option = document.createElement("option");
	        option.value = item.value;
	        option.text	 = item.text;
	        document.getElementById("select_proceso_disenio").add( option );
	        delete option;	
    	}
    });
    jsonObject = null;
} // generaListaDisenioDetalle

function selectDisenioDetalleClick(obj) {
	if( obj.selectedIndex != "-1" ) {
		document.disenio_detalle.id_proceso_disenio.value 	= obj.options[obj.selectedIndex].value;
		document.disenio_detalle.detalle.value 				= obj.options[obj.selectedIndex].text;
    }	
} // selectDisenioDetalleClick

function agregaDisenioDetalle() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_agregar_disenio_detalle").style.display = "inline";
	// genera la lista de los procesos de disenio
	generaListaDisenioDetalle();
	// activa campos del form
	activaCamposFormDisenioDetalle();
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesAgregarFormDisenioDetalle();
} // agregaDisenioDetalle

function aceptaAgregarDisenioDetalle() {
	
	var cantidad            = document.forms["disenio_detalle"].elements["cantidad"].value;
    var especificaciones    = document.forms["disenio_detalle"].elements["especificaciones"].value;
    var precio_total_pesos  = document.forms["disenio_detalle"].elements["precio_total_pesos"].value.trim();
    
    // VALIDACIONES
    var correcto = true;
    
    // esta seleccionado alguna opcion del select
    if( document.disenio_detalle.select_proceso_disenio.selectedIndex == "-1" ) {
        correcto = false;
        alert("Es necesario especificar el tipo detalle del dise\u00f1o");
        document.disenio_detalle.select_proceso_disenio.focus();
    }
    
    // se especifica la cantidad y debe ser mayor a cero
    if( cantidad == "" || isNaN(cantidad) || parseInt( cantidad ) <= 0  ) {
        correcto = false;
        alert("Es necesario especificar la cantidad mayor a cero");
        document.disenio_detalle.cantidad.focus();
    }
    
    // se dan las especificaciones del trabajo
    if( especificaciones == "" ) {
        correcto = false;
        alert("Es necesario dar alguna especificaci\u00f3n");
        document.disenio_detalle.especificaciones.focus();
    }
    
    // valida que sea obligatorio el campo y ademas numero flotante
    if( !$.isNumeric( precio_total_pesos ) ) {
        correcto = false;
        alert("Es necesario un numero correcto en precio");
        document.disenio_detalle.precio_total_pesos.focus();
    }
	
	if(correcto) {
		document.body.style.cursor = "wait";
		desactivaCamposFormDisenioDetalle();
		desactivaBotonesAgregarFormDisenioDetalle();
		
		document.disenio_detalle.id_disenio.value = document.disenio.id_disenio.value;
		var data = $("[name=disenio_detalle]").serialize() + "&especificaciones=" + document.disenio_detalle.especificaciones.value; 
		$.ajax({
			type:"POST",
			url:urlAgregaDisenioDetalleOlvidado,
			data:data,
			success:function(response){
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						break;
					default: // exito
						//console.log(response.textoHTML);
    					// actualiza la tabla
    					document.getElementById("div_tabla_lista_disenio_detalle").innerHTML = response.textoHTML; 
    					// actualiza el precio
    					document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
						break;
				}
				// limpia campos
				cancelaAgregarDisenioDetalle();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaAgregarDisenioDetalle();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
		delete data;
	}
	delete cantidad;
    delete especificaciones;
    delete precio_total_pesos;
    delete correcto;
} // aceptaAgregarDisenioDetalle

function cancelaAgregarDisenioDetalle() {
	// limpia los campos del formulario disenio_detalle
	limpiaCamposFormDisenioDetalle();
	// desactiva campos del form
	desactivaCamposFormDisenioDetalle();
	// desactiva botones ACEPTAR y CANCELAR
	desactivaBotonesAgregarFormDisenioDetalle();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
} // cancelaAgregarDisenioDetalle
