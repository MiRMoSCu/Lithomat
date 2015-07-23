
var obj_transporte = {
	indicacion_tarea_realizar	: "",
	materiales_recibe			: "",
	observaciones				: "",
	
	setObjTransporte : function() {
		this.indicacion_tarea_realizar 	= document.transporte.indicacion_tarea_realizar.value;
		this.materiales_recibe 			= document.transporte.materiales_recibe.value;
		this.observaciones 				= document.transporte.observaciones.value;
	},
	
	setFormTransporte : function() {
		document.transporte.indicacion_tarea_realizar.value = this.indicacion_tarea_realizar;
		document.transporte.materiales_recibe.value 		= this.materiales_recibe;
		document.transporte.observaciones.value 			= this.observaciones;
	}
} // obj_transporte

function activaCamposFormTransporte() {
	document.transporte.indicacion_tarea_realizar.readOnly 	= false;
	document.transporte.materiales_recibe.readOnly 			= false;
	document.transporte.observaciones.readOnly 				= false;
	
	document.transporte.indicacion_tarea_realizar.style.background 	= "#fff";
	document.transporte.materiales_recibe.style.background 			= "#fff";
	document.transporte.observaciones.style.background 				= "#fff";
} // activaCamposFormTransporte

function desactivaCamposFormTransporte() {
	document.transporte.indicacion_tarea_realizar.readOnly 	= true;
	document.transporte.materiales_recibe.readOnly 			= true;
	document.transporte.observaciones.readOnly 				= true;
	
	document.transporte.indicacion_tarea_realizar.style.background 	= "transparent";
	document.transporte.materiales_recibe.style.background 			= "transparent";
	document.transporte.observaciones.style.background 				= "transparent";
} // desactivaCamposFormTransporte

function activaBotonesModificarFormTransporte() {
	document.getElementById("imgBtnModificaTransporte").style.display 			= "none";
	document.getElementById("imgBtnAceptaModificarTransporte").style.display	= "inline";
	document.getElementById("imgBtnCancelaModificarTransporte").style.display	= "inline";
} // activaBotonesModificarFormTransporte

function desactivaBotonesModificarFormTransporte() {
	document.getElementById("imgBtnModificaTransporte").style.display 			= "inline";
	document.getElementById("imgBtnAceptaModificarTransporte").style.display	= "none";
	document.getElementById("imgBtnCancelaModificarTransporte").style.display	= "none";
} // desactivaBotonesModificarFormTransporte

function modificaTransporte() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_modificar_transporte").style.display = "inline";
	
	obj_transporte.setObjTransporte();
	activaCamposFormTransporte();
	activaBotonesModificarFormTransporte();
} // modificaTransporte

function aceptaModificarTransporte() {
	var correcto = true;
	
	if( document.transporte.indicacion_tarea_realizar.value == "" ) {
		correcto = false;
		alert("Es necesario especificar las indicaciones");
        document.transporte.indicacion_tarea_realizar.focus();
	}
	
	if(correcto) {
		document.body.style.cursor = "wait";
		desactivaCamposFormTransporte();
		desactivaBotonesModificarFormTransporte();
		
		$.ajax({
			type:"POST",
			url:urlModificaTransporte,
			data:$("[name=transporte]").serialize(),
			success:function(response){
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						cancelaModificarTransporte();
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
				cancelaModificarTransporte();
				alert("No fue posible actualizar la informaci\u00F3n.");
				muestraBotonesModificarPorSeccion();
			}
		});
	}
	
	delete correcto;
} // aceptaModificarTransporte

function cancelaModificarTransporte() {
	obj_transporte.setFormTransporte();
	desactivaCamposFormTransporte();
	desactivaBotonesModificarFormTransporte();
	
	muestraBotonesModificarPorSeccion();
} // cancelaModificarTransporte