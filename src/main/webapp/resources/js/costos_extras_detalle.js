/*************************************************************/
/* funciones */

function carga_datos() {
	$("#arbol_tipo_trabajo")
	.on("changed.jstree",function(e,data){
			var arreglo = ("" + data.instance.get_node( data.selected[0] ).id + "").split(":");
			if( arreglo[0] == "IdSubpartida" ) {
				document.costos_extras_detalle.id_tipo_trabajo_detalle.value = arreglo[1];
				document.costos_extras_detalle.tipo_trabajo_detalle.value = data.instance.get_node( data.selected[0] ).text;
			}
		}
	)
	.jstree({
		"core":{
			"data":JSON.parse(jsonArbol)
		}
	});
}


function setCampos( identificador, id_costos_extras_detalle, nombre_ttd, nombre_responsable, nombre_costo_extra, cantidad, especificacion  ) {
	// input
	document.costos_extras_detalle.id.value = identificador;
	document.costos_extras_detalle.id_costos_extras_detalle.value = id_costos_extras_detalle;
	document.costos_extras_detalle.tipo_trabajo_detalle.value = nombre_ttd;
	document.costos_extras_detalle.cantidad.value = cantidad;
	document.costos_extras_detalle.especificacion.value = especificacion;

	// select
	var select_responsable = document.costos_extras_detalle.select_responsable_insumo;
	for( i=0; i<select_responsable.length; i++ ) {
		if( select_responsable.options[i].innertText == nombre_responsable ) {
			document.costos_extras_detalle.select_responsable_insumo.selectedIndex = i;
			break;
		}
	}
	delete select_responsable;
	
	// select
	var select_costo = document.costos_extras_detalle.select_costos_extras;
	for( i=0; i<select_costo.length; i++ ) {
		if( select_costo.options[i].innerText == nombre_costo_extra ) {
			document.costos_extras_detalle.select_costos_extras.selectedIndex = i;
			ajaxUnidadCostoExtra();
			break;
		}
	}
	delete select_costo;
}


function ajaxUnidadCostoExtra() {
	//alert( $("[name=select_costos_extras]").val() );
	$.ajax({
		type:"POST",
		url:urlBuscaUnidadMedida,
		data:{id_costos_extras:$("[name=select_costos_extras]").val()},
		success:function(response) {
			document.costos_extras_detalle.nombre_unidad_medida.value = response;
		},
		error:function(e) {
			console.log(e);
			document.costos_extras_detalle.nombre_unidad_medida.value = "-";
		}
	});
}


function limpiaFormCostosExtras() {
	document.costos_extras_detalle.id.value 								= "";
	document.costos_extras_detalle.id_costos_extras_detalle.value 			= "";
	document.costos_extras_detalle.id_tipo_trabajo_detalle.value 			= "";
	document.costos_extras_detalle.tipo_trabajo_detalle.value 				= "";
	document.costos_extras_detalle.id_responsable_insumo.value 				= "";
	document.costos_extras_detalle.select_responsable_insumo.selectedIndex 	= 0;
	document.costos_extras_detalle.id_costos_extras.value 					= "";
	document.costos_extras_detalle.select_costos_extras.selectedIndex 		= 0;
	document.costos_extras_detalle.cantidad.value 							= "";
	document.costos_extras_detalle.especificacion.value 					= "";
}


function eliminaCostosExtras() {
	var correcto = true;
	
	if( document.costos_extras_detalle.id.value == "" ) {
		correcto = false;
		alert("Favor de seleccionar el registro a eliminar");
	}
	
	if( correcto ) {
		if (confirm(String.fromCharCode(191) + "Realmente desea eliminar este registro?")) {
			document.forms[0].action = urlElimina;
	        document.forms[0].submit();
	    }
	}
}


function modificaCostosExtras() {
	var correcto = true;
	
	if( document.costos_extras_detalle.id.value == "" ) {
		correcto = false;
		alert("Favor de seleccionar el registro a modificar");
	}
	
	if( correcto && document.costos_extras_detalle.cantidad.value == "" ) {
		correcto = false;
		alert("Favor de indicar la cantidad");
	}
	
	if( correcto ) {
		document.costos_extras_detalle.id_costos_extras.value 		= $("[name=select_costos_extras]").val();
		document.costos_extras_detalle.id_responsable_insumo.value 	= $("[name=select_responsable_insumo]").val();
		document.forms[0].action = urlModifica;
        document.forms[0].submit();
	}
}


function creaCostosExtras() {
	var correcto = true;
	
	if( document.costos_extras_detalle.id_tipo_trabajo_detalle.value == "" ) {
		correcto = false;
		alert("Favor de seleccionar la subpartida");
	}
		
	if( correcto && document.costos_extras_detalle.cantidad.value == "" ) {
		correcto = false;
		alert("Favor de indicar la cantidad");
	}
	
	if( correcto ) {
		document.costos_extras_detalle.id_costos_extras.value 		= $("[name=select_costos_extras]").val();
		document.costos_extras_detalle.id_responsable_insumo.value 	= $("[name=select_responsable_insumo]").val();
		document.costos_extras_detalle.action = urlAlta;
		document.costos_extras_detalle.submit();
	}
}


function finalizaCostosExtras() {
	window.parent.Shadowbox.close();
}