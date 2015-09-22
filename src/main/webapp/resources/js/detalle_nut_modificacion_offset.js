
var obj_offset = {
	indicacion_tarea_realizar	: "",
	materiales_recibe			: "",
	observaciones				: "",
	
	setObjOffset : function() {
		this.indicacion_tarea_realizar 	= document.offset.indicacion_tarea_realizar.value;
		this.materiales_recibe 			= document.offset.materiales_recibe.value;
		this.observaciones 				= document.offset.observaciones.value;
	},
	
	setFormOffset : function() {
		document.offset.indicacion_tarea_realizar.value = this.indicacion_tarea_realizar;
		document.offset.materiales_recibe.value 		= this.materiales_recibe;
		document.offset.observaciones.value 			= this.observaciones;
	}
} // obj_offset

function activaCamposFormOffset() {
	document.offset.indicacion_tarea_realizar.disabled	= false;
	document.offset.materiales_recibe.disabled 			= false;
	document.offset.observaciones.disabled 				= false;
	
	document.offset.indicacion_tarea_realizar.style.background 	= "#fff";
	document.offset.materiales_recibe.style.background 			= "#fff";
	document.offset.observaciones.style.background 				= "#fff";
} // activaCamposFormOffset

function desactivaCamposFormOffset() {
	document.offset.indicacion_tarea_realizar.disabled 	= true;
	document.offset.materiales_recibe.disabled 			= true;
	document.offset.observaciones.disabled 				= true;
	
	document.offset.indicacion_tarea_realizar.style.background 	= "transparent";
	document.offset.materiales_recibe.style.background 			= "transparent";
	document.offset.observaciones.style.background 				= "transparent";
} // desactivaCamposFormOffset

function activaBotonesModificarFormOffset() {
	document.getElementById("imgBtnModificaOffset").style.display 			= "none";
	document.getElementById("imgBtnAceptaModificarOffset").style.display	= "inline";
	document.getElementById("imgBtnCancelaModificarOffset").style.display	= "inline";
} // activaBotonesModificarFormOffset

function desactivaBotonesModificarFormOffset() {
	document.getElementById("imgBtnModificaOffset").style.display 			= "inline";
	document.getElementById("imgBtnAceptaModificarOffset").style.display	= "none";
	document.getElementById("imgBtnCancelaModificarOffset").style.display	= "none";
} // desactivaBotonesModificarFormOffset

function modificaOffset() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_modificar_offset").style.display = "inline";
	
	obj_offset.setObjOffset();
	activaCamposFormOffset();
	activaBotonesModificarFormOffset();
} // modificaOffset

function aceptaModificarOffset() {
	var correcto = true;
	
	if( document.offset.indicacion_tarea_realizar.value == "" ) {
		correcto = false;
		alert("Es necesario especificar las indicaciones");
        document.offset.indicacion_tarea_realizar.focus();
	}
	
	if(correcto) {
		document.body.style.cursor = "wait";
		desactivaCamposFormOffset();
		desactivaBotonesModificarFormOffset();
		
		var data = $("[name=offset]").serialize() + 
					"&indicacion_tarea_realizar=" + document.offset.indicacion_tarea_realizar.value +
					"&materiales_recibe=" + document.offset.materiales_recibe.value +
					"&observaciones=" + document.offset.observaciones.value;
		
		$.ajax({
			type:"POST",
			url:urlModificaOffset,
			data:data,
			success:function(response){
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						cancelaModificarOffset();
						alert("No fue posible actualizar la informacion.");
						break;
					default: // exito
						//solo actualizo informacion que no modifica precio
						break;
				}
				muestraBotonesModificarPorSeccion();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaModificarOffset();
				alert("No fue posible actualizar la informaci\u00F3n.");
				muestraBotonesModificarPorSeccion();
			}
		});
	}
	
	delete correcto;
} // aceptaModificarOffset

function cancelaModificarOffset() {
	obj_offset.setFormOffset();
	desactivaCamposFormOffset();
	desactivaBotonesModificarFormOffset();
	
	muestraBotonesModificarPorSeccion();
} // cancelaModificarOffset