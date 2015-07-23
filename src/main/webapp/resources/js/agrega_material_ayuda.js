
function limpiaCamposFormMaterialAyuda() {
	document.material_ayuda.id_material_ayuda.value 	= "";
	document.material_ayuda.id_responsable_insumo.value = "";
	document.material_ayuda.observaciones.value 		= "";
	// limpia select
	$("[name='select_material_ayuda']").empty();
} // limpiaCamposFormMaterialAyuda

function activaCamposFormMaterialAyuda() {
	// activa select
	document.material_ayuda.select_material_ayuda.disabled 		= false;
	document.material_ayuda.select_responsable_insumo.disabled 	= false;
	// elimina opcion readOnly
	document.material_ayuda.observaciones.readOnly = false;
	// cambia el color
	document.material_ayuda.observaciones.style.background = "#fff";
} // activaCamposFormMaterialAyuda

function desactivaCamposFormMaterialAyuda() {
	// desactiva select
	document.material_ayuda.select_material_ayuda.disabled 		= true;
	document.material_ayuda.select_responsable_insumo.disabled 	= true;
	// inicializa select
	document.material_ayuda.select_responsable_insumo.selectedIndex = 0;
	// activa opcion readOnly
	document.material_ayuda.observaciones.readOnly = true;
	// cambia el color
	document.material_ayuda.observaciones.style.background = "transparent";
} // desactivaCamposFormAcabadoDetalle

function activaBotonesAgregarFormMaterialAyuda() {
	document.getElementById("imgBtnAgregarMaterialAyuda").style.display 		= "none";
	document.getElementById("imgBtnAgregarMaterialAyuda").style.display 		= "none";
	document.getElementById("imgBtnAceptaAgregarMaterialAyuda").style.display 	= "inline";
	document.getElementById("imgBtnCancelaAgregarMaterialAyuda").style.display	= "inline";
} // activaBotonesAgregarFormMaterialAyuda

function desactivaBotonesAgregarFormMaterialAyuda() {
	document.getElementById("imgBtnAgregarMaterialAyuda").style.display 		= "inline";
	document.getElementById("imgBtnAgregarMaterialAyuda").style.display 		= "inline";
	document.getElementById("imgBtnAceptaAgregarMaterialAyuda").style.display 	= "none";
	document.getElementById("imgBtnCancelaAgregarMaterialAyuda").style.display 	= "none";
} // desactivaBotonesAgregarFormMaterialAyuda

function generaListaMaterialAyuda() {
	// genera el arreglo
	var arregloMaterialAyuda = [];
	// leer una tabla
	var tabla = document.getElementById("tabla_lista_material_ayuda");
	for(var i=1; i<tabla.rows.length; i++) {
		arregloMaterialAyuda.push(tabla.rows[i].cells[1].innerHTML);
	}
	tabla = null;
	//inicializa select
    $("[name='select_material_ayuda']").empty();
	// parse del json
    var jsonObject = JSON.parse( strJsonListaMaterialAyuda );
    $.each( jsonObject, function(i, item){
    	if( $.inArray( item.text, arregloMaterialAyuda) < 0 ) {
    		var option = document.createElement("option");
	        option.value = item.value;
	        option.text	 = item.text;
	        document.getElementById("select_material_ayuda").add( option );
	        delete option;	
    	}
    });
    jsonObject = null;
} // generaListaMaterialAyuda

function agregaMaterialAyuda() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_agregar_material_ayuda").style.display = "inline";
	// genera la lista de los procesos de disenio
	generaListaMaterialAyuda();
	// activa campos del form
	activaCamposFormMaterialAyuda();
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesAgregarFormMaterialAyuda();
} // agregaMaterialAyuda

function aceptaAgregarMaterialAyuda() {
	
	document.body.style.cursor = "wait";
	desactivaCamposFormMaterialAyuda();
	desactivaBotonesAgregarFormMaterialAyuda();
	
	document.material_ayuda.id_material_ayuda.value 	= document.material_ayuda.select_material_ayuda.value;
	document.material_ayuda.id_responsable_insumo.value = document.material_ayuda.select_responsable_insumo.value;
	$.ajax({
		type:"POST",
		url:urlAgregaMaterialAyudaXPartidaOlvidado,
		data:$("[name=material_ayuda]").serialize(),
		success:function(response){
			document.body.style.cursor = "default";
			switch(response.estatusOperacion) {
				case 0: // error
					break;
				default: // exito
					//console.log(response.textoHTML);
					// actualiza la tabla
					document.getElementById("div_tabla_lista_material_ayuda").innerHTML = response.textoHTML; 
					break;
			}
			// limpoa campos
			cancelaAgregarMaterialAyuda();
		},
		error:function(e){
			document.body.style.cursor = "default";
			cancelaAgregarMaterialAyuda();
			alert("No fue posible actualizar la informaci&oacute;n");
		}
	});
	delete data;
} // aceptaAgregarMaterialAyuda

function cancelaAgregarMaterialAyuda() {
	// limpia los campos del formulario disenio_detalle
	limpiaCamposFormMaterialAyuda();
	// desactiva campos del form
	desactivaCamposFormMaterialAyuda();
	// desactiva botones ACEPTAR y CANCELAR
	desactivaBotonesAgregarFormMaterialAyuda();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
} // cancelaAgregarMaterialAyuda