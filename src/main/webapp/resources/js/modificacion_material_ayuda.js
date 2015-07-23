
var modificaMaterialAyuda 	= false;
var clickEnRegistro			= false;

function activaBotonesModificarFormMaterialAyuda() {
	document.getElementById("imgBtnModificarMaterialAyuda").style.display 			= "none";
	document.getElementById("imgBtnAceptaEliminarMaterialAyuda").style.display 		= "inline";
	document.getElementById("imgBtnAceptaModificarMaterialAyuda").style.display 	= "inline";
	document.getElementById("imgBtnCancelaModificarMaterialAyuda").style.display 	= "inline";
} // activaBotonesModificarFormMaterialAyuda

function desactivaBotonesModificarFormMaterialAyuda() {
	document.getElementById("imgBtnModificarMaterialAyuda").style.display 			= "inline";
	document.getElementById("imgBtnAceptaEliminarMaterialAyuda").style.display 		= "none";
	document.getElementById("imgBtnAceptaModificarMaterialAyuda").style.display 	= "none";
	document.getElementById("imgBtnCancelaModificarMaterialAyuda").style.display 	= "none";
} // desactivaBotonesModificarFormMaterialAyuda

function setCamposMaterialAyuda( id_material_ayuda_x_partida, id_material_ayuda, nombre_material_ayuda, id_responsable_insumo, observaciones ) {
	if( modificaMaterialAyuda ) {
		// llena el select_material_ayuda con su unica opcion: la que desea modificar
		$("[name='select_material_ayuda']").empty();
        var jsonObject = JSON.parse( strJsonListaMaterialAyuda );
        $.each( jsonObject, function(i, item){
        	if( item.text == nombre_material_ayuda ) {
        		var option = document.createElement("option");
    	        option.value = item.value;
    	        option.text	 = item.text;
    	        document.getElementById("select_material_ayuda").add( option );
    	        delete option;
        	}
        });
        jsonObject = null;
        // posiciona el select de responsable de insumo en la opcion correcta
        var select = document.material_ayuda.select_responsable_insumo;
	    for (var i = 0;i < select.length;i++) {
	        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
	        if (select.options[i].value == id_responsable_insumo) {
	        	document.material_ayuda.select_responsable_insumo.selectedIndex = i;
	            break;
	        }
	    }
		document.material_ayuda.id_material_ayuda_x_partida.value	= id_material_ayuda_x_partida;
		document.material_ayuda.observaciones.value					= observaciones;
		activaCamposFormMaterialAyuda();
		clickEnRegistro = true;
	}
} // setCamposMaterialAyuda

function modificaTablaMaterialAyuda() {
	// oculta botones de modificar en las demas areas
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_material_ayuda").style.display = "inline";
	// activa bandera
	modificaMaterialAyuda = true;
	// crea estilo
	var css = "table#tabla_lista_material_ayuda tr:hover td {cursor:pointer; color:#000; background-color:#99CCFF;}";
	style = document.createElement("style");
	if( style.styleSheet )
		style.styleSheet.cssText = css;
	else
		style.appendChild(document.createTextNode(css));
	document.getElementsByTagName("head")[0].appendChild(style);
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesModificarFormMaterialAyuda();
} // modificaTablaMaterialAyuda

function aceptaModificarMaterialAyuda() {
	
	if( clickEnRegistro ) {
		document.body.style.cursor = "wait";
		// guarda los valores antes de desactivar los select
		document.material_ayuda.id_material_ayuda.value 	= document.material_ayuda.select_material_ayuda.value;
		document.material_ayuda.id_responsable_insumo.value = document.material_ayuda.select_responsable_insumo.value;
		// desactiva los campos
		desactivaCamposFormMaterialAyuda();
		desactivaBotonesModificarFormMaterialAyuda();
		// realiza ajax
		$.ajax({
			type:"POST",
			url:urlActualizaMaterialAyudaXPartida,
			data:$("[name=material_ayuda]").serialize(),
			success:function(response) {
				document.body.style.cursor = "default";
				// actualiza la tabla
				document.getElementById("div_tabla_lista_material_ayuda").innerHTML = response.textoHTML;
				// desactiva todo
				cancelaModificarMaterialAyuda();
				muestraBotonesModificarPorSeccion();
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaModificarMaterialAyuda();
				alert("No fue posible actualizar la informaci\u00F3n");
				muestraBotonesModificarPorSeccion();
			}
		});
	} else {
		alert("Es necesario especificar el registro");
	}
	clickEnRegistro = false;
} // aceptaModificarMaterialAyuda

function aceptaEliminarMaterialAyuda() {
	if( clickEnRegistro ) {
		if( confirm("¿Esta seguro de querer eliminar este registro?") ) {
			$.ajax({
				type:"POST",
				url:urlEliminaMaterialAyudaXPartida,
				data:$("[name=material_ayuda]").serialize(),
				success:function(response){
					// actualiza la tabla
					document.getElementById("div_tabla_lista_material_ayuda").innerHTML = response.textoHTML;
					// desactiva todo
					cancelaModificarMaterialAyuda();
				},
				error:function(e){
					cancelaModificarMaterialAyuda();
					alert("No fue posible actualizar la informaci&oacute;n");
				}
			});
		}
	} else {
		alert("Es necesario especificar el registro");
	}
	clickEnRegistro = false;
} // aceptaEliminarMaterialAyuda

function cancelaModificarMaterialAyuda() {
	// desactiva bandera
	modificaMaterialAyuda = false;
	// elimina estilos
	document.getElementsByTagName("style")[0].remove();
	//limpia campos
	limpiaCamposFormMaterialAyuda();
	// desactiva botones
	desactivaCamposFormMaterialAyuda();
	desactivaBotonesModificarFormMaterialAyuda();
	// muestra botones Modificar
	muestraBotonesModificarPorSeccion();
	clickEnRegistro = false;
} // cancelaModificarMaterialAyuda