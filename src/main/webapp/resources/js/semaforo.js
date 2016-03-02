
function genera_tabla_dom( jsonOrdenesProduccion ) {
	
    var table = document.createElement("table");
    table.setAttribute("id","tabla_registros");
    var tr = document.createElement("tr");
    var td = document.createElement("th");
    td.innerHTML = "NUT";
    td.setAttribute("width","15%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Nombre";
    td.setAttribute("width","15%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Descripci&oacute;n";
    td.setAttribute("width","30%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.setAttribute("width","10%");
    td.innerHTML = "Fecha cotizaci&oacute;n";
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Cliente";
    td.setAttribute("width","20%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Estatus";
    td.setAttribute("width","10%");
    tr.appendChild( td );
    
    table.appendChild( tr );
    
    if( jsonOrdenesProduccion.length > 0 ) {
    	$.each( jsonOrdenesProduccion, function(i, item){
            tr = document.createElement("tr");
            
            tr.setAttribute("onclick","muestra_detalle_nut('" + item.nut + "');")
            tr.setAttribute("class",i%2==0?"l1":"l2");
            
            td = document.createElement("td");
            td.innerHTML = item.nut;
            tr.appendChild( td );
            td = document.createElement("td");
            td.innerHTML = item.nombre;
            tr.appendChild( td );
            td = document.createElement("td");
            td.innerHTML = item.descripcion;
            tr.appendChild( td );
            td = document.createElement("td");
            td.innerHTML = item.fechaCotizacion;
            tr.appendChild( td );
            td = document.createElement("td");
            td.innerHTML = item.nombreMoral;
            tr.appendChild( td );
            td = document.createElement("td");
            td.setAttribute("id","td_" + item.nut);
            td.setAttribute("class","estatus_" + item.idEstatusOrden);
            td.innerHTML = item.nombreEstatus;
            tr.appendChild( td );
            table.appendChild( tr );
        });
    } else {
    	tr = document.createElement("tr");
    	tr.setAttribute("class","l1");
    	for (var i=0; i<6; i++) {
    		td = document.createElement("td");
            td.innerHTML = "&nbsp;";
            tr.appendChild( td );
    	}
        table.appendChild( tr );
    }
    document.getElementById("div_tabla_registros").innerHTML = table.outerHTML;
    delete td;
    delete tr;
    delete table;
} // genera_tabla_dom


function nueva_busqueda() {
	var correcto = true;
	
	if ( correcto ) {
		alert("nueva busqueda correcta");
	}
	
	delete correcto;
}

function realiza_consulta_paginador() {
	document.busqueda_semaforo.numero_pagina.value 					= numero_pagina;
	document.busqueda_semaforo.numero_registros_por_pagina.value 	= numero_registros_por_pagina;
	$.ajax({
		type:"POST",
		url:urlBuscaOrdenesProduccion,
		data:$("[name=busqueda_semaforo]").serialize(),
		success:function( response ) {
			//console.log(response);
			objJson = JSON.parse( response );
			genera_tabla_dom( objJson.listaOrdenesProduccion )
		},
		error:function( e ) {
			alert("\u00A1Algo sali\u00f3 mal! pero todo tiene soluci\u00f3n.");
		}
	});
}


function limpia() {
	// limpia select
	document.busqueda_semaforo.chkbx_busca_por_nut.checked 			= false;
	document.busqueda_semaforo.chkbx_busca_por_nombre_op.checked 	= false;
	document.busqueda_semaforo.chkbx_busca_por_descripcion.checked 	= false;
	document.busqueda_semaforo.chkbx_busca_por_nombre_moral.checked = false;
	// limpia input
	document.busqueda_semaforo.nut.value 			= "";
	document.busqueda_semaforo.nombre.value 		= "";
	document.busqueda_semaforo.descripcion.value 	= "";
	document.busqueda_semaforo.nombre_moral.value 	= "";
	// nueva busqueda
	nueva_busqueda();
}
