
function setCampos(idPliego, contador, nut, nombreOrdenProduccion, nombrePartida, descripcionTipoTrabajoDetalle, noPliego, hojasRequeridas) {
	if (document.getElementById("pliego:" + idPliego).className != "agregado") {
		document.fecha_prensista_maquina.id_pliego.value 	= idPliego;
		document.registro.contador.value 					= contador;
		document.registro.nut.value 						= nut;
		document.registro.nombre_orden_produccion.value 	= nombreOrdenProduccion;
		document.registro.nombre_partida.value 				= nombrePartida;
		document.registro.nombre_tipo_trabajo_detalle.value = descripcionTipoTrabajoDetalle;
		document.registro.numero_pliego.value 				= noPliego;
		document.registro.hojas_requeridas.value 			= hojasRequeridas;
	} else {
		document.fecha_prensista_maquina.id_pliego.value 	= "";
		document.registro.contador.value 					= "";
		document.registro.nut.value 						= "";
		document.registro.nombre_orden_produccion.value 	= "";
		document.registro.nombre_partida.value 				= "";
		document.registro.nombre_tipo_trabajo_detalle.value = "";
		document.registro.numero_pliego.value 				= "";
		document.registro.hojas_requeridas.value 			= "";
	}
}

function limpia_form_fecha_prensista_maquina() {
	// limpia form registro
	document.registro.contador.value 					= "";
	document.registro.nut.value 						= "";
	document.registro.nombre_orden_produccion.value 	= "";
	document.registro.nombre_partida.value 				= "";
	document.registro.nombre_tipo_trabajo_detalle.value = "";
	document.registro.numero_pliego.value 				= "";
	document.registro.hojas_requeridas.value 			= "";
	
	// limpia form fecha_prensista_maquina
	document.fecha_prensista_maquina.id_pliego.value 						= 0;
	document.fecha_prensista_maquina.id_prensista.selectedIndex 			= 0;
	document.fecha_prensista_maquina.id_turno_laboral.selectedIndex 		= 0;
	document.fecha_prensista_maquina.id_maquina.selectedIndex 				= 0;
	document.fecha_prensista_maquina.fecha_impresion.value					= "";
	document.fecha_prensista_maquina.id_prensista_ayudante.selectedIndex	= 0;
	document.fecha_prensista_maquina.hojas_buenas.value						= "";
	document.fecha_prensista_maquina.hojas_malas.value 						= "";
	document.fecha_prensista_maquina.hojas_limpias.value 					= "";
	document.fecha_prensista_maquina.hojas_adicionales.value 				= "";
	document.fecha_prensista_maquina.cambio_placas.value 					= "";
	document.fecha_prensista_maquina.laminas_extra.value 					= "";
	document.fecha_prensista_maquina.frente_kilos_tinta.value 				= "";
	document.fecha_prensista_maquina.vuelta_kilos_tinta.value 				= "";
}

/*************************************************************/
//FUNCIONES PARA EL PAGINADOR

function genera_tabla_dom( jsonListaGridPliegos ) {
	
	//console.log( jsonListaGridPliegos );
	
	var table = document.createElement("table");
    table.setAttribute("id","tabla_lista_registros");
    var tr = document.createElement("tr");
    var td = document.createElement("th");
    td.innerHTML = "No.";
    //td.setAttribute("width","1%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "NUT";
    //td.setAttribute("width","1%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Nom. Ord.Prod.";
    //td.setAttribute("width","1%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Nom. Trabajo";
    //td.setAttribute("width","60%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Nom. Impr.";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "No. Pgo";
    //td.setAttribute("width","20%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "H. Req";
    //td.setAttribute("width","15%");
    tr.appendChild( td );
        
    table.appendChild( tr );
    
    //console.log( jsonListaClientes );
    if( jsonListaGridPliegos.length > 0 ) {
    	//console.log("entro");
    	var cont = 0;
    	$.each( jsonListaGridPliegos, function(i, item){
    		var id = ( ( (numero_pagina - 1 ) * numero_registros_por_pagina ) + 1 ) + cont++;
    		
            tr = document.createElement("tr");
            
            tr.setAttribute("id","pliego:" + item.idPliego);
            tr.setAttribute("onclick","setCampos('" + item.idPliego + "','" + id + "','" + item.nut + "','" + item.nombreOrdenProduccion + "','" + item.nombrePartida + "','" + item.descripcionTipoTrabajoDetalle + "','" + item.noPliego + "','" + item.hojasRequeridas + "');")
            tr.setAttribute("class",document.getElementById("fpm:"+item.idPliego)?"agregado":i%2==0?"l1":"l2");
            
            td = document.createElement("td");
            td.innerHTML = id 
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.nut;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.nombreOrdenProduccion;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.nombrePartida;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.descripcionTipoTrabajoDetalle;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.noPliego;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.hojasRequeridas;
            tr.appendChild( td );
            
            table.appendChild( tr );
        });
    } else {
    	//console.log("no entro");
    	tr = document.createElement("tr");
        tr.setAttribute("class","l1");
        
        td = document.createElement("td");
        td.innerHTML = "&nbsp;";
        tr.appendChild( td );
        
        td = document.createElement("td");
        td.innerHTML = "&nbsp;";
        tr.appendChild( td );
        
        td = document.createElement("td");
        td.innerHTML = "&nbsp;";
        tr.appendChild( td );
        
        td = document.createElement("td");
        td.innerHTML = "&nbsp;";
        tr.appendChild( td );
        
        td = document.createElement("td");
        td.innerHTML = "&nbsp;";
        tr.appendChild( td );
        
        td = document.createElement("td");
        td.innerHTML = "&nbsp;";
        tr.appendChild( td );
        
        td = document.createElement("td");
        td.innerHTML = "&nbsp;";
        tr.appendChild( td );
        
        table.appendChild( tr );
    }
    document.getElementById("div_tabla_lista_registros").innerHTML = table.outerHTML;
    delete td;
    delete tr;
    delete table;
    delete cont;
    delete id;
}

function realiza_consulta_paginador() {
	document.busqueda_registro_grid.numero_pagina.value 				= numero_pagina;
	document.busqueda_registro_grid.numero_registros_por_pagina.value 	= numero_registros_por_pagina;
	// limpia campos
	limpia_form_fecha_prensista_maquina();
	// realiza ajax con el nuevo numero de pagina solicitada; el tipo de busqueda es el mismo
	$.ajax({
		type:"POST",
		url:urlBuscaListaPorParametros,
		data:$("[name='busqueda_registro_grid']").serialize(),
		success:function(response) {
			//console.log(response);
			objJson = JSON.parse(response);
			genera_tabla_dom( objJson.listaGridPliegos );
			objJson = null;
		},
		error:function(e) {
			alert("\u00A1Algo sali\u00f3 mal! pero no pasa nada, todo tiene soluci\u00f3n.");
		}
	});
}

function carga_datos() {
	// define el tamaño del arreglo que se muetra en el paginador
	if( numero_total_registros < tamanio_maximo_arreglo * numero_registros_por_pagina ) 
        tamanio_arreglo = Math.ceil( numero_total_registros / numero_registros_por_pagina );
    else 
        tamanio_arreglo = tamanio_maximo_arreglo;
	// actualiza variables: define el numero de paginas que dependen del numero de registros encontrados
    actualiza_variables();
    
    // limpia div
    $("#div_paginador").empty();
    
    // Obtiene elemento div_paginador
    var objDiv 	= document.getElementById("div_paginador");
    
    // crea objeto ul
    var objUl 	= document.createElement("ul");
    objUl.setAttribute("id","paginacion");
    document.getElementById("div_paginacion_resultados").innerHTML = string_elementos_encontrados();
    
    // crea boton primero
    var objLi = document.createElement("li");
    objLi.setAttribute("onclick","paginador( this );");
    objLi.setAttribute("class","activo bold");
    objLi.innerHTML = "Primero";
    objUl.appendChild( objLi );
    delete objLi;
    
    // crea boton anterior
    objLi = document.createElement("li");
    objLi.setAttribute("onclick","paginador( this );");
    objLi.setAttribute("class","activo bold");
    objLi.innerHTML = "Anterior";
    objUl.appendChild( objLi );
    delete objLi;
    
    // crea botones
    for( var i = 0; i < tamanio_arreglo; i++ ) {
        objLi = document.createElement("li");
        objLi.setAttribute("onclick","paginador( this );");
        objLi.setAttribute("name","arreglo");
        objLi.innerHTML = parseInt(i + 1);
        if( i == 0 ) {
            objLi.setAttribute("class","seleccionado");
        } else {
            objLi.setAttribute("class","activo");
        }
        objUl.appendChild( objLi );
        delete objLi;
    }
    
    // crea boton siguiente
    objLi = document.createElement("li");
    objLi.setAttribute("onclick","paginador( this );");
    objLi.setAttribute("class","activo bold");
    objLi.innerHTML = "Siguiente";
    objUl.appendChild( objLi );
    delete objLi;
    
    // crea boton ultimo
    objLi = document.createElement("li");
    objLi.setAttribute("onclick","paginador( this );");
    objLi.setAttribute("class","activo bold");
    objLi.innerHTML = "Ultimo";
    objUl.appendChild( objLi );
    delete objLi;
    
    // agrega ul a div
    objDiv.appendChild( objUl );
    
    // elimina objetos
    delete objUl;
    delete objDiv;
}

/*************************************************************/
//FUNCIONES PARA LA BUSQUEDA ESPECIALIZADA

function nueva_busqueda() {
	// bandera
	var correcto = true;
	// validaciones
	if ( correcto 
			&& document.busqueda_registro_grid.chkbx_busca_por_nut.checked 
			&& document.busqueda_registro_grid.nut.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda NUT no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if ( correcto ) {
		// limpia tabla fecha_prensista_maquina
		if ( document.getElementById("fpm:null") == null ) { // es porque NO EXISTE, porque existe al menos un registro en fecha_prensista_maquina
			var tabla_fecha_prensista_maquina 		= document.getElementById("tabla_fecha_prensista_maquina");
			var contador_registros_tabla 			= tabla_fecha_prensista_maquina.rows.length;
			for ( var i=contador_registros_tabla-1; i>0; i--) 
				tabla_fecha_prensista_maquina.deleteRow(i);
			var row = tabla_fecha_prensista_maquina.insertRow(1);
			row.id			= "fpm:null";
			row.className 	= "l1";
			for ( var i=0; i<15; i++ ) {
				cell 			= row.insertCell(i);
				cell.innerHTML 	= "&nbsp";
			}
			delete i;
			delete row;
			delete tabla_fecha_prensista_maquina;
			delete contador_registros_tabla;
		}
		// inicializa paginador
		numero_pagina = 1;
		document.busqueda_registro_grid.numero_pagina.value 			  = numero_pagina;
		document.busqueda_registro_grid.numero_registros_por_pagina.value = numero_registros_por_pagina;
		document.body.style.cursor = "wait";
		$.ajax({
			type:"POST",
			url:urlBuscaListaPorParametros,
			data:$("[name='busqueda_registro_grid']").serialize(),
			success:function(response){
				//console.log(response);
				objJson = JSON.parse(response);
				genera_tabla_dom( objJson.listaGridPliegos );
	        	numero_total_registros = objJson.numeroTotalRegistros;
	        	carga_datos();
	        	objJson = null;
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

function limpia_form_busqueda_registro_grid() {
	// limpia form fecha prensista maquina
	limpia_form_fecha_prensista_maquina();
	// limpia campos check form bsuqueda
	document.busqueda_registro_grid.chkbx_busca_por_nut.checked = false;
	// limpia input text
	document.busqueda_registro_grid.nut.value = "";
	// realiza nueva busqueda
	nueva_busqueda();
}

/*************************************************************/
// FUNCIONES PARA CREAR REGISTRO

function elimina_registro_fpm(obj) {
	var rowNumber = obj.rowIndex
	// activa registro en la tabla tabla_lista_registros si es que esta mostrado actualmente
	if ( document.getElementById("pliego:" + obj.id.split(":")[1]) )
		document.getElementById("pliego:" + obj.id.split(":")[1]).className = obj.id.split(":")[1]%2 == 0?"l2":"l1";
	var table = document.getElementById("tabla_fecha_prensista_maquina");
	table.deleteRow(obj.rowIndex);
	if ( table.rows.length > 1 ) 
		for (var i=rowNumber; i<table.rows.length; i++)
			table.rows[i].className = table.rows[i].className=="l1"?"l2":"l1";
	else {
		var row = table.insertRow(1);
		row.id			= "fpm:null";
		row.className 	= "l1";
		for ( var i=0; i<15; i++ ) {
			cell 			= row.insertCell(i);
			cell.innerHTML 	= "&nbsp";
		}
	}
	delete i;
	delete rowNumber;
	delete obj;
}

function crea_registro_fpm() {
	var correcto = true;
	
	// realiza validaciones
	if ( correcto 
			&& document.fecha_prensista_maquina.fecha_impresion.value == "" ) {
		correcto = false;
		alert("El campo Fecha Impresion no puede estar vacio. Favor de informarlo.");
		document.fecha_prensista_maquina.fecha_impresion.focus();
	}
	
	if ( correcto
			&& ( document.fecha_prensista_maquina.hojas_buenas.value == ""
				|| isNaN( document.fecha_prensista_maquina.hojas_buenas.value ) ) ) {
		correcto = false;
		alert("El campo Hojas Buenas debe ser un numero valido. Favor de informarlo.");
		document.fecha_prensista_maquina.hojas_buenas.focus();
	}
	
	if ( correcto
			&& ( document.fecha_prensista_maquina.hojas_malas.value == ""
				|| isNaN( document.fecha_prensista_maquina.hojas_malas.value ) )  ) {
		correcto = false;
		alert("El campo Hojas Malas debe ser un numero valido. Favor de informarlo.");
		document.fecha_prensista_maquina.hojas_malas.focus();
	}
	
	if ( correcto 
			&& ( document.fecha_prensista_maquina.hojas_limpias.value == ""
				|| isNaN( document.fecha_prensista_maquina.hojas_limpias.value ) ) ) {
		correcto = false;
		alert("El campo Hojas Limpias debe ser un numero valido. Favor de informarlo.");
		document.fecha_prensista_maquina.hojas_limpias.focus();
	}
	
	if ( correcto 
			&& ( document.fecha_prensista_maquina.hojas_adicionales.value == ""
				|| isNaN( document.fecha_prensista_maquina.hojas_adicionales.value ) ) ) {
		correcto = false;
		alert("El campo Hojas Adicionales debe ser un numero valido. Favor de informarlo.");
		document.fecha_prensista_maquina.hojas_limpias.focus();
	}
	
	if ( correcto 
			&& ( document.fecha_prensista_maquina.cambio_placas.value == ""
				|| isNaN( document.fecha_prensista_maquina.cambio_placas.value ) ) ) {
		correcto = false;
		alert("El campo No. Cambio de Placas debe ser un numero valido. Favor de informarlo.");
		document.fecha_prensista_maquina.cambio_placas.focus();
	}
	
	if ( correcto
			&& ( document.fecha_prensista_maquina.laminas_extra.value == ""
				|| isNaN( document.fecha_prensista_maquina.laminas_extra.value ) ) ) {
		correcto = false;
		alert("El campo No. Laminas Extras debe ser un numero valido. Favor de informarlo.");
		document.fecha_prensista_maquina.laminas_extras.focus();
	}
	
	if ( correcto
			&& ( document.fecha_prensista_maquina.frente_kilos_tinta.value == ""
				|| isNaN( document.fecha_prensista_maquina.frente_kilos_tinta.value ) ) ) {
		correcto = false;
		alert("El campo Frente Kilos Tinta debe ser un numero valido. Favor de informarlo.");
		document.fecha_prensista_maquina.frente_kilos_tinta.focus();
	}
	
	if ( correcto
			&& ( document.fecha_prensista_maquina.vuelta_kilos_tinta.value == ""
				|| isNaN( document.fecha_prensista_maquina.vuelta_kilos_tinta.value ) ) ) {
		correcto = false;
		alert("El campo Vuelta Kilos Tinta debe ser un numero valido. Favor de informarlo.");
		document.fecha_prensista_maquina.vuelta_kilos_tinta.focus();
	}
	
	if ( correcto ) {
		// si existe registro en la tabla de pliegos
		var tabla_pliego_td = document.getElementById("pliego:" + document.fecha_prensista_maquina.id_pliego.value);
		if ( tabla_pliego_td ) {
			// crea registro en la tabla fecha_prensista_maquina
			var table_fecha_prensista_maquina = document.getElementById("tabla_fecha_prensista_maquina");
			// obtiene el numero registros en la tabla
			var count = table_fecha_prensista_maquina.rows.length;
			// si el contados == 2 && existe el registro vacio
			if ( count <= 2 && document.getElementById("fpm:null") ) { // existe registro vacio
				table_fecha_prensista_maquina.deleteRow(--count);
			}
			// crea el nuevo registro
			var row = table_fecha_prensista_maquina.insertRow(count);
			row.id = "fpm:" + document.fecha_prensista_maquina.id_pliego.value;
			row.className = count%2==0?"l2":"l1";
			// oculta el nuevo registro
			row.style.display = "none";
			// crea las celdas del registro:
				// id
			var cell = null;
			cell = row.insertCell(0);
			cell.innerHTML = document.registro.contador.value;
				// prensista
			cell = row.insertCell(1);
			cell.innerHTML = $("[name=id_prensista] option:selected").text();
				// turno laboral
			cell = row.insertCell(2);
			cell.innerHTML = $("[name=id_turno_laboral] option:selected").text();
				// maquina
			cell = row.insertCell(3);
			cell.innerHTML = $("[name=id_maquina] option:selected").text();
				// fecha impresion
			cell = row.insertCell(4);
			cell.innerHTML = $("[name=fecha_impresion]").val();
				// ayudante
			cell = row.insertCell(5);
			cell.innerHTML = $("[name=id_prensista_ayudante] option:selected").text();
				// hojas buenas
			cell = row.insertCell(6);
			cell.innerHTML = $("[name=hojas_buenas]").val();
				// hojas malas
			cell = row.insertCell(7);
			cell.innerHTML = $("[name=hojas_malas]").val();
				// hojas limpias
			cell = row.insertCell(8);
			cell.innerHTML = $("[name=hojas_limpias]").val();
				// hojas adicionales
			cell = row.insertCell(9);
			cell.innerHTML = $("[name=hojas_adicionales]").val();
				// numero cambio placas
			cell = row.insertCell(10);
			cell.innerHTML = $("[name=cambio_placas]").val();
				// numero laminas extra
			cell = row.insertCell(11);
			cell.innerHTML = $("[name=laminas_extra]").val();
				// frente kilos tinta
			cell = row.insertCell(12);
			cell.innerHTML = $("[name=frente_kilos_tinta]").val();
				// vuelta kilos tinta
			cell = row.insertCell(13);
			cell.innerHTML = $("[name=vuelta_kilos_tinta]").val();
				// eliminar
			cell = row.insertCell(14);
			cell.innerHTML = "<img alt='' src='" + urlBotonEliminarRegistro + "' style='cursor:pointer;' onclick='elimina_registro_fpm(this.parentElement.parentElement)' )' />";
			// muestra el registro
			row.style.display = "";
			// limpia los campos del form
			limpia_form_fecha_prensista_maquina();
			// modifica visualizacion de la tabla pliego
			tabla_pliego_td.setAttribute("class","agregado");
			
			delete cell;
			delete row;
			delete count;
			delete table_fecha_prensista_maquina;
		}
		delete tabla_pliego_td;
	}
	delete correcto;
}

function envia_cruce_informacion() {
	
	// definiciones de objetos
	function ListaObject() {
		this.registros = new Array();
	}
	
	function FechaPrensistaMaquina() {
		this.id_pliego 				= "";
		this.id_prensista 			= "";
		this.id_turno_laboral 		= "";
		this.id_maquina 			= "";
		this.fecha_impresion 		= "";
		this.id_prensista_ayudante 	= "";
		this.hojas_buenas 			= "";
		this.hojas_malas 			= "";
		this,hojas_limpias 			= "";
		this.hojas_adicionales 		= "";
		this.cambio_placas 			= "";
		this.laminas_extra 			= "";
		this.frente_kilos_tinta 	= "";
		this.vuelta_kilos_tinta 	= "";			
	}
	
	var listaObject = new ListaObject();
	var tableDOM 	= document.getElementById("tabla_fecha_prensista_maquina");
	// existe al menos un registro
	if ( document.getElementById("fpm:null") == null ) { // es pprque NO EXISTE porque existe al menos un registro en fecha_prensista_maquina
		for ( var i=1; i<tableDOM.rows.length; i++ ) { // i=0 es el encabezado de la tabla 
			var fpm = new FechaPrensistaMaquina();
			// id_pliego
			fpm.id_pliego = (tableDOM.rows[i].id).split(":")[1];
			// id_prensista
			$(document.getElementsByName("id_prensista")[0].options).each( function(index, value){
				if ( tableDOM.rows[i].cells[1].innerHTML == $(this).text() ){
					fpm.id_prensista = $(this).val();
					return false;
				}
			} );
			// id_turno_laboral
			$(document.getElementsByName("id_turno_laboral")[0].options).each( function(index, value){
				if ( tableDOM.rows[i].cells[2].innerHTML == $(this).text() ) {
					fpm.id_turno_laboral = $(this).val();
					return false;
				}
			} );
			// id_maquina
			$(document.getElementsByName("id_maquina")[0].options).each( function(index, value){
				if ( tableDOM.rows[i].cells[3].innerHTML == $(this).text() ) {
					fpm.id_maquina = $(this).val();
					return false;
				}
			} );
			// fecha_impresion
			fpm.fecha_impresion = tableDOM.rows[i].cells[4].innerHTML;
			// id_prensista_ayudante
			$(document.getElementsByName("id_prensista_ayudante")[0].options).each( function(index, value){
				if ( tableDOM.rows[i].cells[5].innerHTML == $(this).text() ) {
					fpm.id_prensista_ayudante = $(this).val();
					return false;
				}
			} );
			// hojas_buenas
			fpm.hojas_buenas = tableDOM.rows[i].cells[6].innerHTML;
			// hojas_malas
			fpm.hojas_malas = tableDOM.rows[i].cells[7].innerHTML;
			// hojas_limpias
			fpm.hojas_limpias = tableDOM.rows[i].cells[8].innerHTML;
			// hojas_adicionales
			fpm.hojas_adicionales = tableDOM.rows[i].cells[9].innerHTML;
			// cambio_placas
			fpm.cambio_placas = tableDOM.rows[i].cells[10].innerHTML;
			// laminas_extra
			fpm.laminas_extra = tableDOM.rows[i].cells[11].innerHTML;
			// frente_kilos_tinta
			fpm.frente_kilos_tinta = tableDOM.rows[i].cells[12].innerHTML;
			// vuelta_kilos_tinta
			fpm.vuelta_kilos_tinta = tableDOM.rows[i].cells[13].innerHTML;
			// GUARDA REGISTRO EN ARREGLO
			listaObject.registros.push( fpm );
			delete fpm;
		}
		// envia informacion con ajax
		console.log( listaObject );
	}
	delete i;
	delete tableDOM;
	delete listaObject;
}

