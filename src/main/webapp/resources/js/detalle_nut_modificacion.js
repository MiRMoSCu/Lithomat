/**
 * 
 */

function buscaTipoPlaca( obj ) {
    var id = obj.options[obj.selectedIndex].value;
    $.ajax({
        type:"POST",
        url:urlBuscaTipoPlaca,
        data:{id_maquina:id},
        success:function(response) {
            // jquery limpia select tipo_trabajo_detalle
            $("[name='select_tipo_placa']").empty();
            // parsea la informacion
            var jsonObject = JSON.parse( response.textoJson );
            $.each( jsonObject, function(i, item) {
                //alert( item.id_tipo_placa + ' ' + item.descripcion );
                var option = document.createElement("option");
                option.text     = item.descripcion;
                option.value    = item.id_tipo_placa;
                document.forms["tipo_trabajo_detalle"].elements["select_tipo_placa"].add( option );
                delete option;
                // coloca opcion del tipo de placas
                var clave			= document.tipo_trabajo_detalle.tipo_placa.value;
       			var select 			= document.tipo_trabajo_detalle.select_tipo_placa;
       			var encontroOpcion 	= false;
       			for( var i=0; i<select.length; i++ ) {
       				if( select.options[i].innerText == clave ) {
       					select.selectedIndex	= i;
       					encontroOpcion = true;
       					break;
       				}
       			}
       			if( !encontroOpcion ) {
       				select.selectedIndex	= 0;
       			}
                delete clave;
       			delete select;
            } );
            delete jsonObject;
        },
        error:function(e) {
            alert("No fue posible cargar lista de placas por maquina");
        }
    });
    delete id;
} // buscaTipoPlaca

function ocultaBotonesModificarPorSeccion() {
	if ( document.getElementById("div_btn_actualizar_orden_produccion") )
		document.getElementById("div_btn_actualizar_orden_produccion").style.display 	= "none";
	if ( document.getElementById("div_btn_actualizar_partida") )
		document.getElementById("div_btn_actualizar_partida").style.display 			= "none";
	if ( document.getElementById("div_btn_actualizar_ttd_encabezado") )
		document.getElementById("div_btn_actualizar_ttd_encabezado").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_pliego") )
		document.getElementById("div_btn_actualizar_pliego").style.display 				= "none";
	if ( document.getElementById("div_btn_actualizar_costo_extra_detalle") )
		document.getElementById("div_btn_actualizar_costo_extra_detalle").style.display = "none";
	if ( document.getElementById("div_btn_agregar_costo_extra_detalle") )
		document.getElementById("div_btn_agregar_costo_extra_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_modificar_disenio") )
		document.getElementById("div_btn_modificar_disenio").style.display 				= "none";
	if ( document.getElementById("div_btn_agregar_disenio_detalle") )
		document.getElementById("div_btn_agregar_disenio_detalle").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_disenio_detalle") )
		document.getElementById("div_btn_actualizar_disenio_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_modificar_preprensa") )
		document.getElementById("div_btn_modificar_preprensa").style.display 			= "none";
	if ( document.getElementById("div_btn_agregar_preprensa_detalle") )
		document.getElementById("div_btn_agregar_preprensa_detalle").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_preprensa_detalle") )
		document.getElementById("div_btn_actualizar_preprensa_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_modificar_transporte") )
		document.getElementById("div_btn_modificar_transporte").style.display 			= "none";
	if ( document.getElementById("div_btn_agregar_transporte_detalle") )
		document.getElementById("div_btn_agregar_transporte_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_actualizar_transporte_detalle") )
		document.getElementById("div_btn_actualizar_transporte_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_modificar_acabado") )
		document.getElementById("div_btn_modificar_acabado").style.display 				= "none";
	if ( document.getElementById("div_btn_agregar_acabado_detalle") )
		document.getElementById("div_btn_agregar_acabado_detalle").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_acabado_detalle") )
		document.getElementById("div_btn_actualizar_acabado_detalle").style.display 	= "none";
	if ( document.getElementById("div_btn_modificar_offset") )
		document.getElementById("div_btn_modificar_offset").style.display 				= "none";
	if ( document.getElementById("div_btn_agregar_material_ayuda") )
		document.getElementById("div_btn_agregar_material_ayuda").style.display 		= "none";
	if ( document.getElementById("div_btn_actualizar_material_ayuda") )
		document.getElementById("div_btn_actualizar_material_ayuda").style.display 		= "none";
} // ocultaBotonesModificarPorSeccion

function muestraBotonesModificarPorSeccion() {
	if ( document.getElementById("div_btn_actualizar_orden_produccion") )
		document.getElementById("div_btn_actualizar_orden_produccion").style.display 	= "inline";
	if ( document.getElementById("div_btn_actualizar_partida") )
		document.getElementById("div_btn_actualizar_partida").style.display 			= "inline";
	if ( document.getElementById("div_btn_actualizar_ttd_encabezado") )
		document.getElementById("div_btn_actualizar_ttd_encabezado").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_pliego") )
		document.getElementById("div_btn_actualizar_pliego").style.display 				= "inline";
	if ( document.getElementById("div_btn_actualizar_costo_extra_detalle") )
		document.getElementById("div_btn_actualizar_costo_extra_detalle").style.display = "inline";
	if ( document.getElementById("div_btn_agregar_costo_extra_detalle") )
		document.getElementById("div_btn_agregar_costo_extra_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_modificar_disenio") )
		document.getElementById("div_btn_modificar_disenio").style.display 				= "inline";
	if ( document.getElementById("div_btn_agregar_disenio_detalle") )
		document.getElementById("div_btn_agregar_disenio_detalle").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_disenio_detalle") )
		document.getElementById("div_btn_actualizar_disenio_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_modificar_preprensa") )
		document.getElementById("div_btn_modificar_preprensa").style.display 			= "inline";
	if ( document.getElementById("div_btn_agregar_preprensa_detalle") )
		document.getElementById("div_btn_agregar_preprensa_detalle").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_preprensa_detalle") )
		document.getElementById("div_btn_actualizar_preprensa_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_modificar_transporte") )
		document.getElementById("div_btn_modificar_transporte").style.display 			= "inline";
	if ( document.getElementById("div_btn_agregar_transporte_detalle") )
		document.getElementById("div_btn_agregar_transporte_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_actualizar_transporte_detalle") )
		document.getElementById("div_btn_actualizar_transporte_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_modificar_acabado") )
		document.getElementById("div_btn_modificar_acabado").style.display 				= "inline";
	if ( document.getElementById("div_btn_agregar_acabado_detalle") )
		document.getElementById("div_btn_agregar_acabado_detalle").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_acabado_detalle") )
		document.getElementById("div_btn_actualizar_acabado_detalle").style.display 	= "inline";
	if ( document.getElementById("div_btn_modificar_offset") )
		document.getElementById("div_btn_modificar_offset").style.display 				= "inline";
	if ( document.getElementById("div_btn_agregar_material_ayuda") )
		document.getElementById("div_btn_agregar_material_ayuda").style.display 		= "inline";
	if ( document.getElementById("div_btn_actualizar_material_ayuda") )
		document.getElementById("div_btn_actualizar_material_ayuda").style.display 		= "inline";
} // muestraBotonesModificarPorSeccion

