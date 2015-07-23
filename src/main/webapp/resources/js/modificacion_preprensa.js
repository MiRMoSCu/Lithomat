
var obj_preprensa = {
	indicacion_tarea_realizar	: "",
	materiales_recibe			: "",
	observaciones				: "",
	
	setObjPreprensa : function() {
		this.indicacion_tarea_realizar 	= document.preprensa.indicacion_tarea_realizar.value;
		this.materiales_recibe 			= document.preprensa.materiales_recibe.value;
		this.observaciones 				= document.preprensa.observaciones.value;
	},
	
	setFormPreprensa : function() {
		document.preprensa.indicacion_tarea_realizar.value 	= this.indicacion_tarea_realizar;
		document.preprensa.materiales_recibe.value 			= this.materiales_recibe;
		document.preprensa.observaciones.value 				= this.observaciones;
	}
} // obj_preprensa

function activaCamposFormPreprensa() {
	document.preprensa.indicacion_tarea_realizar.readOnly 	= false;
	document.preprensa.materiales_recibe.readOnly 			= false;
	document.preprensa.observaciones.readOnly 				= false;
	
	document.preprensa.indicacion_tarea_realizar.style.background 	= "#fff";
	document.preprensa.materiales_recibe.style.background 			= "#fff";
	document.preprensa.observaciones.style.background 				= "#fff";
} // activaCamposFormPreprensa

function desactivaCamposFormPreprensa() {
	document.preprensa.indicacion_tarea_realizar.readOnly 	= true;
	document.preprensa.materiales_recibe.readOnly 			= true;
	document.preprensa.observaciones.readOnly 				= true;
	
	document.preprensa.indicacion_tarea_realizar.style.background 	= "transparent";
	document.preprensa.materiales_recibe.style.background 			= "transparent";
	document.preprensa.observaciones.style.background 				= "transparent";
} // desactivaCamposFormPreprensa

function activaBotonesModificarFormPreprensa() {
	document.getElementById("imgBtnModificaPreprensa").style.display 			= "none";
	document.getElementById("imgBtnAceptaModificarPreprensa").style.display		= "inline";
	document.getElementById("imgBtnCancelaModificarPreprensa").style.display	= "inline";
} // activaBotonesModificarFormPreprensa

function desactivaBotonesModificarFormPreprensa() {
	document.getElementById("imgBtnModificaPreprensa").style.display 			= "inline";
	document.getElementById("imgBtnAceptaModificarPreprensa").style.display		= "none";
	document.getElementById("imgBtnCancelaModificarPreprensa").style.display	= "none";
} // desactivaBotonesModificarFormPreprensa

function modificaPreprensa() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_modificar_preprensa").style.display = "inline";
	
	obj_preprensa.setObjPreprensa();
	activaCamposFormPreprensa();
	activaBotonesModificarFormPreprensa();
} // modificaPreprensa

function aceptaModificarPreprensa() {
	var correcto = true;
	
	if( document.preprensa.indicacion_tarea_realizar.value == "" ) {
		correcto = false;
		alert("Es necesario especificar las indicaciones");
        document.preprensa.indicacion_tarea_realizar.focus();
	}
	
	if(correcto) {
		document.body.style.cursor = "wait";
		desactivaCamposFormPreprensa();
		desactivaBotonesModificarFormPreprensa();
		
		$.ajax({
			type:"POST",
			url:urlModificaPreprensa,
			data:$("[name=preprensa]").serialize(),
			success:function(response){
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						cancelaModificarPreprensa();
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
				cancelaModificarPreprensa();
				alert("No fue posible actualizar la informaci\u00F3n.");
				muestraBotonesModificarPorSeccion();
			}
		});
	}
	
	delete correcto;
} // aceptaModificarPreprensa

function cancelaModificarPreprensa() {
	obj_preprensa.setFormPreprensa();
	desactivaCamposFormPreprensa();
	desactivaBotonesModificarFormPreprensa();
	
	muestraBotonesModificarPorSeccion();
} // cancelaModificarPreprensa