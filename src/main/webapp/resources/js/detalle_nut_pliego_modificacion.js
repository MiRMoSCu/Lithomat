var modificaPliego = false;

function limpiaCamposFormPliego() {
	document.visualizador_pliegos.id_pliego.value 		= "";
	document.visualizador_pliegos.numero_pliego.value 	= "";
	document.visualizador_pliegos.rebases.value 		= "";
	document.visualizador_pliegos.medianiles.value 		= "";
	document.visualizador_pliegos.pinzas.value 			= "";
	document.visualizador_pliegos.hojas_sobrantes.value = "";
	document.visualizador_pliegos.observaciones.value 	= "";
}

function activaCamposFormPliego() {
	// desactiva propiedad readonly
	document.visualizador_pliegos.rebases.readOnly 			= false;
	document.visualizador_pliegos.medianiles.readOnly 		= false;
	document.visualizador_pliegos.pinzas.readOnly 			= false;
	document.visualizador_pliegos.hojas_sobrantes.readOnly 	= false;
	document.visualizador_pliegos.observaciones.readOnly 	= false;
	// cambia el color de los readonly
	document.visualizador_pliegos.rebases.style.background 			= "#fff";
	document.visualizador_pliegos.medianiles.style.background 		= "#fff";
	document.visualizador_pliegos.pinzas.style.background 			= "#fff";
	document.visualizador_pliegos.hojas_sobrantes.style.background 	= "#fff";
	document.visualizador_pliegos.observaciones.style.background 	= "#fff";
}

function desactivaCamposFormPliego() {
	// activa propiedad readonly
	document.visualizador_pliegos.rebases.readOnly 			= true;
	document.visualizador_pliegos.medianiles.readOnly 		= true;
	document.visualizador_pliegos.pinzas.readOnly 			= true;
	document.visualizador_pliegos.hojas_sobrantes.readOnly 	= true;
	document.visualizador_pliegos.observaciones.readOnly 	= true;
	// cambia el color de los readonly
	document.visualizador_pliegos.rebases.style.background 			= "transparent";
	document.visualizador_pliegos.medianiles.style.background 		= "transparent";
	document.visualizador_pliegos.pinzas.style.background 			= "transparent";
	document.visualizador_pliegos.hojas_sobrantes.style.background 	= "transparent";
	document.visualizador_pliegos.observaciones.style.background 	= "transparent";
}

function activaBotonesModificarPliego(){
	document.getElementById("imgBtnModificarPliego").style.display 			= "none";
	document.getElementById("imgBtnCancelaModificarPliego").style.display 	= "inline";
	document.getElementById("imgBtnAceptaModificarPliego").style.display 	= "inline";
}

function desactivaBotonesModificarPliego() {
	document.getElementById("imgBtnModificarPliego").style.display 			= "inline";
	document.getElementById("imgBtnCancelaModificarPliego").style.display 	= "none";
	document.getElementById("imgBtnAceptaModificarPliego").style.display 	= "none";
}

function setCamposPliego( id_pliego, consecutivo, rebase_en_milimetros, medianiles_en_milimetros, pinzas_en_centimetros, hojas_sobrantes, observaciones ) {
	if ( modificaPliego ) {
		document.visualizador_pliegos.id_pliego.value 		= id_pliego;
		document.visualizador_pliegos.numero_pliego.value 	= consecutivo;
		document.visualizador_pliegos.rebases.value 		= rebase_en_milimetros;
		document.visualizador_pliegos.medianiles.value 		= medianiles_en_milimetros;
		document.visualizador_pliegos.pinzas.value 			= pinzas_en_centimetros;
		document.visualizador_pliegos.hojas_sobrantes.value = hojas_sobrantes;
		document.visualizador_pliegos.observaciones.value 	= observaciones;
		// activa campos
		activaCamposFormPliego();
	}
}

function modificaTablaPliego() {
	// oculta botones de modificar en las demas areas
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_pliego").style.display = "inline";
	// activa bandera
	modificaPliego = true;
	// crea estilo y agrega a la página
	var css = "table#tabla_lista_pliegos tr:hover td {cursor:pointer; color:#000; background-color:#99CCFF;}";
	style = document.createElement("style");
	if( style.styleSheet )
		style.styleSheet.cssText = css;
	else
		style.appendChild(document.createTextNode(css));
	document.getElementsByTagName("head")[0].appendChild(style);
	// muestra botones ACEPTAR y CANCELAR
	activaBotonesModificarPliego();
}

function aceptaModificarPliego() {
	// validaciones
	var correcto = true;
	if ( correcto 
			&& document.visualizador_pliegos.numero_pliego.value == "" ) {
		correcto = false;
		alert("No se ha seleccionado ningun pliego a modificar");
	}
	if ( correcto
			&& (document.visualizador_pliegos.rebases.value == ""
					|| document.visualizador_pliegos.medianiles.value == ""
					|| document.visualizador_pliegos.pinzas.value == ""
					|| document.visualizador_pliegos.hojas_sobrantes.value == "" ) ) {
		correcto = false;
		alert("Los campos Rebases, Medianiles, Pinzas y Hojas Sobrantes son obligatorios. Favor de informarlos.");
	}
	
	if ( correcto 
			&& ( isNaN(document.visualizador_pliegos.rebases.value)
					|| isNaN(document.visualizador_pliegos.medianiles.value)
					|| isNaN(document.visualizador_pliegos.pinzas.value)
					|| isNaN(document.visualizador_pliegos.hojas_sobrantes.value) ) ) {
		correcto = false;
		alert("Los campos Rebases, Medianiles, Pinzas y Hojas Sobrantes deben ser un numero valido. Favor de informarlos.");
	}
	if ( correcto ) {
		document.body.style.cursor = "wait";
		$.ajax({
			type:"POST",
			url:urlActualizaPliego,
			data:$("[name=visualizador_pliegos]").serialize(),
			success:function(response){
				// actualiza tabla pliego
				document.getElementById("div_tabla_lista_pliegos").innerHTML = response.textoHTML;
				// actualiza precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				// regresa todo al inicio
				cancelaModificarPliego();
				// cambia el cursor
				document.body.style.cursor = "default";
			},
			error:function(e){
				document.body.style.cursor = "default";
				cancelaModificarPliego();
				alert("No fue posible actualizar la informaci\u00F3n");
			}
		});
	}
	delete correcto;
}

function cancelaModificarPliego() {
	// desactiva bandera
	modificaPliego = false;
	// elimina estilos
	$($("style").get(0)).remove();
	// limpia campos
	limpiaCamposFormPliego();
	// desactiva botones
	desactivaCamposFormPliego();
	desactivaBotonesModificarPliego();
	// muestra botones modificar por seccion
	muestraBotonesModificarPorSeccion();
}