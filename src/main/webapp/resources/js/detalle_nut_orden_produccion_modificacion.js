
var obj_orden_produccion = {
	nombre					: "",
	descripcion				: "",
	comprobante_fiscal		: "",
	
	setObjOrdenProduccion : function() {
		this.nombre 					= document.orden_produccion.nombre.value;
		this.descripcion				= document.orden_produccion.descripcion.value;
		this.comprobante_fiscal			= document.orden_produccion.comprobante_fiscal.value;
	}, // setObjOrdenProduccion:function
	
	setFormOrdenProduccion : function() {
		document.orden_produccion.nombre.value 					= this.nombre;
		document.orden_produccion.descripcion.value 			= this.descripcion;
		document.orden_produccion.comprobante_fiscal.value 		= this.comprobante_fiscal;
	} // setFormOrdenProduccion:function
} // objeto obj_orden_produccion
	
function activaCamposFormOrdenProduccion() {
	// coloca el select en la opcion correcta
	var index 	= 0;
	var clave	= document.orden_produccion.comprobante_fiscal.value;
	var select 	= document.orden_produccion.select_comprobante_fiscal;
	for( var i=0; i < select.length; i++ ) {
		if( select.options[i].innerText == clave ) {
			index = i;
			break;
		}
	}
	document.orden_produccion.select_comprobante_fiscal.selectedIndex	= index;
	// muestra el select
	document.orden_produccion.comprobante_fiscal.style.display			= "none";
	document.orden_produccion.select_comprobante_fiscal.style.display	= "inline";
	delete index;
	delete clave;
	delete select;

	// quita opcion readOnly
	document.orden_produccion.nombre.readOnly 							= false;
	document.orden_produccion.descripcion.readOnly 						= false;
	// cambia el color
	document.orden_produccion.nombre.style.background 					= "#fff";
	document.orden_produccion.descripcion.style.background 				= "#fff";
	document.orden_produccion.comprobante_fiscal.style.background 		= "#fff";
} // activaCamposFormOrdenProduccion:function

function desactivaCamposFormOrdenProduccion() {
	document.orden_produccion.nombre.readOnly 							= true;
	document.orden_produccion.descripcion.readOnly 						= true;
	document.orden_produccion.comprobante_fiscal.style.display			= "inline";
	document.orden_produccion.select_comprobante_fiscal.style.display	= "none";
	
	document.orden_produccion.nombre.style.background 					= "transparent";
	document.orden_produccion.descripcion.style.background 				= "transparent";
	document.orden_produccion.comprobante_fiscal.style.background 		= "transparent";
} // desactivaCamposFormOrdenProduccion:function

function activaBotonesModificarFormOrdenProduccion() {
	document.getElementById("imgBtnModificarOrdenProduccion").style.display 		= "none";
	document.getElementById("imgBtnAceptaModificarOrdenProduccion").style.display	= "inline";
	document.getElementById("imgBtnCancelaModificarOrdenProduccion").style.display	= "inline";
} // activaBotonesModificarFormOrdenProduccion:function

function desactivaBotonesModificarFormOrdenProduccion() {
	document.getElementById("imgBtnModificarOrdenProduccion").style.display 		= "inline";
	document.getElementById("imgBtnAceptaModificarOrdenProduccion").style.display 	= "none";
	document.getElementById("imgBtnCancelaModificarOrdenProduccion").style.display	= "none";
} // desactivaBotonesModificarFormOrdenProduccion:function

function modificaOrdenProduccion() {
	// desctiva botones de modificar en las areas restantes
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_orden_produccion").style.display = "inline";
	
	obj_orden_produccion.setObjOrdenProduccion();
	activaBotonesModificarFormOrdenProduccion();
	activaCamposFormOrdenProduccion();
} // modificaOrdenProduccion

function aceptaModificarOrdenProduccion() {
	
	document.orden_produccion.id_tipo_comprobante_fiscal.value = document.orden_produccion.select_comprobante_fiscal.value;
	document.orden_produccion.comprobante_fiscal.value = document.orden_produccion.select_comprobante_fiscal.options[document.orden_produccion.select_comprobante_fiscal.selectedIndex].text;
	
	var correcto = true;
	
	if( document.orden_produccion.nombre.value == "" ) {
		alert("Favor de informar el campo Nombre.");
		correcto = false;
	}
	if( document.orden_produccion.descripcion.value == "" ) {
		alert("Favor de informar el campo Descripcion");
		correcto = false;
	}
	
	if( correcto ) {
		document.body.style.cursor = "wait";
		desactivaCamposFormOrdenProduccion();
		desactivaBotonesModificarFormOrdenProduccion();
		$.ajax({
			type:"POST",
			url:urlActualizaOrdenProduccion,
			data:$("[name=orden_produccion]").serialize(),
			success:function(response) {
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0:
						cancelaModificarOrdenProduccion();
						alert("No fue posible actualizar la informacion.");
						break;
					default:
						// actualiza campos
						document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
						break;
				}
				//muestra los botones de modificar
				muestraBotonesModificarPorSeccion();
			},
			error:function(e) {
				document.body.style.cursor = "default";
				cancelaModificarOrdenProduccion();
				alert("No fue posible actualizar la informacion.");
				//muestra los botones de modificar
				muestraBotonesModificarPorSeccion();
			}
		});	
		
	}
	
	delete correcto;
} // aceptaModificarOrdenProduccion

function cancelaModificarOrdenProduccion() {
	obj_orden_produccion.setFormOrdenProduccion();
	desactivaBotonesModificarFormOrdenProduccion();
	desactivaCamposFormOrdenProduccion();
	// activa botones de modificar en las areas restantes
	muestraBotonesModificarPorSeccion();
} // cancelaModificarOrdenProduccion