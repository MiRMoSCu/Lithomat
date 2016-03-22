
var obj_descuento = {
		aplica_descuento: "",
		precio_seleccionado: "",
		tipo_precio: "",
		
		setObjDescuento: function() {
			this.aplica_descuento 		= document.descuento.input_aplica_descuento.value;
			this.precio_seleccionado 	= document.descuento.precio_tabulador.value;
			this.tipo_precio 			= document.descuento.tipo_precio.value;
		},
		
		setFormDescuento: function() {
			document.descuento.input_aplica_descuento.value = this.aplica_descuento;
			document.descuento.precio_tabulador.value 		= this.precio_seleccionado;
			document.descuento.tipo_precio.value 			= this.tipo_precio;
		}
}

function activaCamposFormDescuento() {
	// copia valores de text a checkbox
	document.descuento.chkbx_aplica_descuento.checked = document.descuento.input_aplica_descuento.value=="Si"?true:false;
	// copia valores de text a select
	var clave, select;
	clave = document.descuento.tipo_precio.value;
	select = document.descuento.select_tipo_precio;
	for ( var i=0; i<select.length; i++ ) {
		if ( select.options[i].text == clave ) {
			select.selectedIndex = i;
			break;
		}
	}
	delete clave, select;
	// muestra checkbox
	document.descuento.input_aplica_descuento.style.display = "none";
	document.descuento.chkbx_aplica_descuento.style.display = "inline";
	// muestra select
	document.descuento.input_tabulador.style.display 	= "none";
	document.descuento.tipo_precio.style.display 		= "none";
	document.descuento.select_precio_tabulador.style.display 	= "inline";
	document.descuento.select_tipo_precio.style.display 		= "inline";
	// desactiva readonly campos visibles
	document.descuento.precio_tabulador.readOnly = false;
	// aplica cambio de color a campos visibles
	document.descuento.precio_tabulador.style.background = "#fff";
}

function desactivaCamposFormDescuento() {
	// oculta checkbox
	document.descuento.input_aplica_descuento.style.display = "inline";
	document.descuento.chkbx_aplica_descuento.style.display = "none";
	// oculta select
	document.descuento.input_tabulador.style.display 	= "inline";
	document.descuento.tipo_precio.style.display 		= "inline";
	document.descuento.select_precio_tabulador.style.display 	= "none";
	document.descuento.select_tipo_precio.style.display 		= "none";
	// activa readonly campos visibles
	document.descuento.precio_tabulador.readOnly = true;
	// elimina cambio de color a campos visibles
	document.descuento.precio_tabulador.style.background = "transparent";
}

function activaBotonesModificarFormDescuento() {
	document.getElementById("imgBtnModificarDescuento").style.display 			= "none";
	document.getElementById("imgBtnCancelaModificarDescuento").style.display 	= "inline";
	document.getElementById("imgBtnAceptaModificarDescuento").style.display 	= "inline";
}

function desactivaBotonesModificarFormDescuento() {
	document.getElementById("imgBtnModificarDescuento").style.display 			= "inline";
	document.getElementById("imgBtnCancelaModificarDescuento").style.display 	= "none";
	document.getElementById("imgBtnAceptaModificarDescuento").style.display 	= "none";
}

function modificaDescuento() {
	obj_descuento.setObjDescuento();
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_descuento").style.display = "inline";
	activaBotonesModificarFormDescuento();
	activaCamposFormDescuento();
}

function cancelaModificarDescuento() {
	obj_descuento.setFormDescuento();
	desactivaCamposFormDescuento();
	desactivaBotonesModificarFormDescuento();
	muestraBotonesModificarPorSeccion();
}

function aceptaModificarDescuento() {
	// copia valores
	document.descuento.aplica_descuento.value 	= document.descuento.chkbx_aplica_descuento.checked;
	document.descuento.id_tipo_precio.value		= document.descuento.select_tipo_precio.value;
	// validacion
	var correcto = true;
	
	if ( correcto 
			&& ( document.descuento.precio_tabulador.value == "" 
				|| isNaN(document.descuento.precio_tabulador.value)
				|| parseInt( document.descuento.precio_tabulador.value ) <= 0 ) ) {
		correcto = false;
		alert("En necesario que el precio seleccionado sea numero entero mayor que cero");
		document.descuento.precio_tabulador.focus();
		document.descuento.precio_tabulador.select();
	}
	
	if ( correcto ){
		// realiza ajax
		$.ajax({
			type:"POST",
			url:urlActualizaDescuento,
			data:$("[name=descuento]").serialize(),
			success:function( response ) {
				//console.log(response);
				if ( document.descuento.aplica_descuento.value == "false" ) {
					document.descuento.input_aplica_descuento.value = "No";
					document.descuento.precio_tabulador.value 		= "";
				} else 
					document.descuento.input_aplica_descuento.value = "Si";
				// congela input
				desactivaCamposFormDescuento();
				desactivaBotonesModificarFormDescuento();
				muestraBotonesModificarPorSeccion();
				// actualiza precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
			},
			error:function( e ) {
				console.log("error");
				alert("No fue posible comunicarse con el servidor");
			}
		});
	}
	delete correcto;
}