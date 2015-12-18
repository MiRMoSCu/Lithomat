
var obj_acabado = {
	indicacion_tarea_realizar	: "",
	materiales_recibe			: "",
	observaciones				: "",
	
	setObjAcabado : function() {
		this.indicacion_tarea_realizar 	= document.acabado.indicacion_tarea_realizar.value;
		this.materiales_recibe 			= document.acabado.materiales_recibe.value;
		this.observaciones 				= document.acabado.observaciones.value;
	},
	
	setFormAcabado : function() {
		document.acabado.indicacion_tarea_realizar.value 	= this.indicacion_tarea_realizar;
		document.acabado.materiales_recibe.value 			= this.materiales_recibe;
		document.acabado.observaciones.value 				= this.observaciones;
	}
} // obj_acabado

function activaCamposFormAcabado() {
	document.acabado.indicacion_tarea_realizar.readOnly	= false;
	document.acabado.materiales_recibe.readOnly 		= false;
	document.acabado.observaciones.readOnly 			= false;
	
	document.acabado.indicacion_tarea_realizar.style.background = "#fff";
	document.acabado.materiales_recibe.style.background 		= "#fff";
	document.acabado.observaciones.style.background 			= "#fff";
} // activaCamposFormAcabado

function desactivaCamposFormAcabado() {
	document.acabado.indicacion_tarea_realizar.readOnly = true;
	document.acabado.materiales_recibe.readOnly 		= true;
	document.acabado.observaciones.readOnly 			= true;
	
	document.acabado.indicacion_tarea_realizar.style.background = "transparent";
	document.acabado.materiales_recibe.style.background 		= "transparent";
	document.acabado.observaciones.style.background 			= "transparent";
} // desactivaCamposFormAcabado

function activaBotonesModificarFormAcabado() {
	document.getElementById("imgBtnModificaAcabado").style.display 			= "none";
	document.getElementById("imgBtnAceptaModificarAcabado").style.display	= "inline";
	document.getElementById("imgBtnCancelaModificarAcabado").style.display	= "inline";
} // activaBotonesModificarFormAcabado

function desactivaBotonesModificarFormAcabado() {
	document.getElementById("imgBtnModificaAcabado").style.display 			= "inline";
	document.getElementById("imgBtnAceptaModificarAcabado").style.display	= "none";
	document.getElementById("imgBtnCancelaModificarAcabado").style.display	= "none";
} // desactivaBotonesModificarFormAcabado

function modificaAcabado() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_modificar_acabado").style.display = "inline";
	
	obj_acabado.setObjAcabado();
	activaCamposFormAcabado();
	activaBotonesModificarFormAcabado();
} // modificaAcabado

function aceptaModificarAcabado() {
	var correcto = true;
	
	if( document.acabado.indicacion_tarea_realizar.value == "" ) {
		correcto = false;
		alert("Es necesario especificar las indicaciones");
        document.acabado.indicacion_tarea_realizar.focus();
	}
	
	if(correcto) {
		document.body.style.cursor = "wait";
		desactivaCamposFormAcabado();
		desactivaBotonesModificarFormAcabado();
		
		$.ajax({
			type:"POST",
			url:urlModificaAcabado,
			data:$("[name=acabado]").serialize(),
			success:function(response){
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						cancelaModificarAcabado();
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
				cancelaModificarAcabado();
				alert("No fue posible actualizar la informaci\u00F3n.");
				muestraBotonesModificarPorSeccion();
			}
		});
	}
	
	delete correcto;
} // aceptaModificarAcabado

function cancelaModificarAcabado() {
	obj_acabado.setFormAcabado();
	desactivaCamposFormAcabado();
	desactivaBotonesModificarFormAcabado();
	
	muestraBotonesModificarPorSeccion();
} // cancelaModificarAcabado