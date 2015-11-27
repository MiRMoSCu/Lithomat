// inicializacion jQuery
$(document).ready(function(){});

function setCamposTipoPapelExtendido( id_tipo_papel_extendido, nombre_proveedor, nombre_papel, gramaje, kilogramos, ancho, alto, precio ) {
	document.tipo_trabajo_detalle.descripcion_completa.value = nombre_papel + " " + gramaje + " gr. " + ancho + " x " + alto + " cm. (" + kilogramos + " kg.) ($" + precio + ") [" + nombre_proveedor + "]";
	window.parent.document.tipo_trabajo_detalle.id_tipo_papel_extendido.value 	= id_tipo_papel_extendido;
	window.parent.document.tipo_trabajo_detalle.tipo_papel_extendido.value 		= document.tipo_trabajo_detalle.descripcion_completa.value;
}

function limpia() {
	// limpia campos ocultos
	document.tipo_trabajo_detalle.id_tipo_papel_extendido.value = "";
	// limpia selects
	document.tipo_trabajo_detalle.chkbx_busca_por_nombre.checked 		= true;
	document.tipo_trabajo_detalle.chkbx_busca_por_ancho.checked			= false;
	document.tipo_trabajo_detalle.chkbx_busca_por_alto.checked			= false;
	document.tipo_trabajo_detalle.chkbx_busca_por_gramaje.checked		= false;
	document.tipo_trabajo_detalle.chkbx_busca_por_kilogramos.checked	= false;
	document.tipo_trabajo_detalle.chkbx_busca_por_proveedor.checked		= false;
	// limpia campo descripcion completa
	document.tipo_trabajo_detalle.descripcion_completa.value = "";
	// limpia input text
	document.tipo_trabajo_detalle.nombre.value 		= "";
	document.tipo_trabajo_detalle.ancho.value 		= "";
	document.tipo_trabajo_detalle.alto.value		= "";
	document.tipo_trabajo_detalle.gramaje.value		= "";
	document.tipo_trabajo_detalle.kilogramos.value	= "";
	// limpia tabla
	document.getElementById("tabla_tipo_papel_extendido").innerHTML = "<table><tr><th>Id.</th><th>Proveedor</th><th>Nombre</th><th>Gramaje</th><th>Kilogramos</th><th>Ancho</th><th>Alto</th><th>Precio</th><th>Unidad</th></tr><tr class=\"l1\"><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></table>";
	// limpia campos de la ventana padre
	window.parent.document.tipo_trabajo_detalle.id_tipo_papel_extendido.value 	= "";
	window.parent.document.tipo_trabajo_detalle.tipo_papel_extendido.value 		= "";
}

function busca() {
	// limpia campo papel seleccionado
	document.tipo_trabajo_detalle.descripcion_completa.value = "";
	
	// validacion
	var correcto = true;
	
	if( document.tipo_trabajo_detalle.chkbx_busca_por_nombre.checked
			&& document.tipo_trabajo_detalle.nombre.value == "" ) {
		correcto = false;
		alert("Favor de informar nombre.");
		document.tipo_trabajo_detalle.nombre.focus();
	}
	
	if( correcto
			&& document.tipo_trabajo_detalle.chkbx_busca_por_ancho.checked
			&& document.tipo_trabajo_detalle.ancho.value == "" ) {
		correcto = false;
		alert("Favor de informar ancho de papel.");
		document.tipo_trabajo_detalle.ancho.focus();
	}
	
	if( correcto
			&& document.tipo_trabajo_detalle.chkbx_busca_por_alto.checked
			&& document.tipo_trabajo_detalle.alto.value == "" ) {
		correcto = false;
		alert("Favor de informar alto de papel.");
		document.tipo_trabajo_detalle.alto.focus();
	}
	
	if( correcto
			&& document.tipo_trabajo_detalle.chkbx_busca_por_gramaje.checked
			&& document.tipo_trabajo_detalle.gramaje.value == "" ) {
		correcto = false;
		alert("Favor de informar gramaje de papel.");
		document.tipo_trabajo_detalle.gramaje.focus();
	}
	
	if( correcto
			&& document.tipo_trabajo_detalle.chkbx_busca_por_kilogramos.checked
			&& document.tipo_trabajo_detalle.kilogramos.value == "" ) {
		correcto = false;
		alert("Favor de informar kilogramos de papel.");
		document.tipo_trabajo_detalle.kilogramos.focus();
	}
	
	if(correcto){
		
		document.body.style.cursor = "wait";
		$.ajax({
			type:"POST",
			url:urlBusca,
			data:$("[name='tipo_trabajo_detalle']").serialize(),
			success:function(response){
				document.getElementById("tabla_tipo_papel_extendido").innerHTML = response.textoHTML;
				document.body.style.cursor = "default";
			},
			error:function(e){
				console.log(e);
				alert("No fue posible realizar la consulta");
				document.body.style.cursor = "default";
			}
		});	
	}
	delete correcto;
}