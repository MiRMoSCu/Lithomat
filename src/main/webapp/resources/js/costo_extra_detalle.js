/*************************************************************/
/* funciones */

function carga_datos() {
	$("#arbol_tipo_trabajo")
	.on("changed.jstree",function(e,data){
			var arreglo = ("" + data.instance.get_node( data.selected[0] ).id + "").split(":");
			if( arreglo[0] == "IdTipoTrabajoDetalle" ) {
				document.costo_extra_detalle.id_tipo_trabajo_detalle.value = arreglo[1];
				document.costo_extra_detalle.tipo_trabajo_detalle.value = data.instance.get_node( data.selected[0] ).text;
			}
		}
	)
	.jstree({
		"core":{
			"data":JSON.parse(jsonArbol)
		}
	});
}


function setCampos( identificador, id_costo_extra_detalle, nombre_ttd, nombre_costo_extra, nombre_responsable, cantidad, especificacion  ) {
	// input
	document.costo_extra_detalle.id.value 						= identificador;
	document.costo_extra_detalle.id_costo_extra_detalle.value 	= id_costo_extra_detalle;
	document.costo_extra_detalle.tipo_trabajo_detalle.value 	= nombre_ttd;
	document.costo_extra_detalle.cantidad.value 				= cantidad;
	document.costo_extra_detalle.especificacion.value 			= especificacion;

	// select
	var select_responsable = document.costo_extra_detalle.select_responsable_insumo;
	for( i=0; i<select_responsable.length; i++ ) {
		if( select_responsable.options[i].innertText == nombre_responsable ) {
			document.costo_extra_detalle.select_responsable_insumo.selectedIndex = i;
			break;
		}
	}
	delete select_responsable;
	
	// select
	var select_costo = document.costo_extra_detalle.select_costo_extra;
	for( i=0; i<select_costo.length; i++ ) {
		if( select_costo.options[i].innerText == nombre_costo_extra ) {
			document.costo_extra_detalle.select_costo_extra.selectedIndex = i;
			ajaxUnidadCostoExtra();
			break;
		}
	}
	delete select_costo;
}


function ajaxUnidadCostoExtra() {
	//alert( $("[name=select_costo_extra]").val() );
	$.ajax({
		type:"POST",
		url:urlBuscaUnidadMedida,
		data:{id_costo_extra:$("[name=select_costo_extra]").val()},
		success:function(response) {
			document.costo_extra_detalle.nombre_unidad_medida.value = response;
		},
		error:function(e) {
			console.log(e);
			document.costo_extra_detalle.nombre_unidad_medida.value = "-";
		}
	});
}


function limpiaFormCostoExtra() {
	document.costo_extra_detalle.id.value 									= "";
	document.costo_extra_detalle.id_costo_extra_detalle.value 				= "";
	document.costo_extra_detalle.id_tipo_trabajo_detalle.value 				= "";
	document.costo_extra_detalle.tipo_trabajo_detalle.value 				= "";
	document.costo_extra_detalle.id_responsable_insumo.value 				= "";
	document.costo_extra_detalle.select_responsable_insumo.selectedIndex 	= 0;
	document.costo_extra_detalle.id_costo_extra.value 						= "";
	document.costo_extra_detalle.select_costo_extra.selectedIndex 			= 0;
	document.costo_extra_detalle.cantidad.value 							= "";
	document.costo_extra_detalle.especificacion.value 						= "";
}


function eliminaCostoExtra() {
	var correcto = true;
	
	if( document.costo_extra_detalle.id.value == "" ) {
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


function modificaCostoExtra() {
	var correcto = true;
	
	if( document.costo_extra_detalle.id.value == "" ) {
		correcto = false;
		alert("Favor de seleccionar el registro a modificar");
	}
	
	if( correcto && document.costo_extra_detalle.cantidad.value == "" ) {
		correcto = false;
		alert("Favor de indicar la cantidad");
		document.costo_extra_detalle.cantidad.focus();
	}
	
	if( correcto ) {
		document.costo_extra_detalle.id_costo_extra.value 			= $("[name=select_costo_extra]").val();
		document.costo_extra_detalle.id_responsable_insumo.value 	= $("[name=select_responsable_insumo]").val();
		document.forms[0].action 									= urlModifica;
        document.forms[0].submit();
	}
}


function creaCostoExtra() {
	var correcto = true;
	
	if( document.costo_extra_detalle.id_tipo_trabajo_detalle.value == "" ) {
		correcto = false;
		alert("Favor de seleccionar la subpartida");
	}
		
	if( correcto && document.costo_extra_detalle.cantidad.value == "" ) {
		correcto = false;
		alert("Favor de indicar la cantidad");
		document.costo_extra_detalle.cantidad.focus();
	}
	
	if( correcto ) {
		document.costo_extra_detalle.id_costo_extra.value 			= $("[name=select_costo_extra]").val();
		document.costo_extra_detalle.id_responsable_insumo.value 	= $("[name=select_responsable_insumo]").val();
		document.costo_extra_detalle.action = urlAlta;
		document.costo_extra_detalle.submit();
	}
}


function finalizaCostoExtra() {
	window.parent.Shadowbox.close();
}