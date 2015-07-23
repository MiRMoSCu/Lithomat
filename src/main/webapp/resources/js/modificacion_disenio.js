
var obj_disenio = {
	indicacion_tarea_realizar	: "",
	materiales_recibe			: "",
	observaciones				: "",
	
	setObjDisenio : function() {
		this.indicacion_tarea_realizar 	= document.disenio.indicacion_tarea_realizar.value;
		this.materiales_recibe 			= document.disenio.materiales_recibe.value;
		this.observaciones 				= document.disenio.observaciones.value;
	},
	
	setFormDisenio : function() {
		document.disenio.indicacion_tarea_realizar.value 	= this.indicacion_tarea_realizar;
		document.disenio.materiales_recibe.value 			= this.materiales_recibe;
		document.disenio.observaciones.value 				= this.observaciones;
	}
} // obj_disenio

function activaCamposFormDisenio() {
	document.disenio.indicacion_tarea_realizar.readOnly = false;
	document.disenio.materiales_recibe.readOnly 		= false;
	document.disenio.observaciones.readOnly 			= false;
	
	document.disenio.indicacion_tarea_realizar.style.background = "#fff";
	document.disenio.materiales_recibe.style.background 		= "#fff";
	document.disenio.observaciones.style.background 			= "#fff";
} // activaCamposFormDisenio

function desactivaCamposFormDisenio() {
	document.disenio.indicacion_tarea_realizar.readOnly = true;
	document.disenio.materiales_recibe.readOnly 		= true;
	document.disenio.observaciones.readOnly 			= true;
	
	document.disenio.indicacion_tarea_realizar.style.background = "transparent";
	document.disenio.materiales_recibe.style.background 		= "transparent";
	document.disenio.observaciones.style.background 			= "transparent";
} // desactivaCamposFormDisenio

function activaBotonesModificarFormDisenio() {
	document.getElementById("imgBtnModificaDisenio").style.display 			= "none";
	document.getElementById("imgBtnAceptaModificarDisenio").style.display	= "inline";
	document.getElementById("imgBtnCancelaModificarDisenio").style.display	= "inline";
} // activaBotonesModificarFormDisenio

function desactivaBotonesModificarFormDisenio() {
	document.getElementById("imgBtnModificaDisenio").style.display 			= "inline";
	document.getElementById("imgBtnAceptaModificarDisenio").style.display	= "none";
	document.getElementById("imgBtnCancelaModificarDisenio").style.display	= "none";
} // desactivaBotonesModificarFormDisenio

function modificaDisenio() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_modificar_disenio").style.display = "inline";
	
	obj_disenio.setObjDisenio();
	activaCamposFormDisenio();
	activaBotonesModificarFormDisenio();
} // modificaDisenio

function aceptaModificarDisenio() {
	var correcto = true;
	
	if( document.disenio.indicacion_tarea_realizar.value == "" ) {
		correcto = false;
		alert("Es necesario especificar las indicaciones");
        document.disenio.indicacion_tarea_realizar.focus();
	}
	
	if(correcto) {
		document.body.style.cursor = "wait";
		desactivaCamposFormDisenio();
		desactivaBotonesModificarFormDisenio();
		
		$.ajax({
			type:"POST",
			url:urlModificaDisenio,
			data:$("[name=disenio]").serialize(),
			success:function(response){
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						cancelaModificarDisenio();
						alert("No fue posible actualizar la informaci\u00F3n.");
						break;
					default: // exito
						//solo actualizo informacion que no modifica precio
						break;
				}
				muestraBotonesModificarPorSeccion();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaModificarDisenio();
				alert("No fue posible actualizar la informaci\u00F3n.");
				muestraBotonesModificarPorSeccion();
			}
		});
	}
	
	delete correcto;
} // aceptaModificarDisenio 

function cancelaModificarDisenio() {
	obj_disenio.setFormDisenio();
	desactivaCamposFormDisenio();
	desactivaBotonesModificarFormDisenio();
	
	muestraBotonesModificarPorSeccion();
} // cancelaModificarDisenio