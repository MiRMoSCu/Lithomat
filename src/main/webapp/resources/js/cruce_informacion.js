



function limpia_form_fecha_prensista_maquina() {
	document.fecha_prensista_maquina.id_prensista.selectedIndex 			= 0;
	document.fecha_prensista_maquina.id_turno_laboral.selectedIndex 		= 0;
	document.fecha_prensista_maquina.id_maquina.selectedIndex 				= 0;
	document.fecha_prensista_maquina.fecha_impresion.value					= "";
	document.fecha_prensista_maquina.id_prensista_ayudante.selectedIndex	= 0;
	document.fecha_prensista_maquina.hojas_buenas.value						= "";
	document.fecha_prensista_maquina.hojas_malas.value 						= "";
	document.fecha_prensista_maquina.hojas_limpias.value 					= "";
	document.fecha_prensista_maquina.cambio_placas.value 					= "";
	document.fecha_prensista_maquina.laminas_extras.value 					= "";
	document.fecha_prensista_maquina.frente_kilos_tinta.value 				= "";
	document.fecha_prensista_maquina.vuelta_kilos_tinta.value 				= "";
}

/*************************************************************/
//FUNCIONES PARA EL PAGINADOR

function genera_tabla_dom( jsonListaGridPliegos ) {
	
	var table = document.createElement("table");
    table.setAttribute("id","tabla_registros");
    var tr = document.createElement("tr");
    var td = document.createElement("th");
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
    	$.each( jsonListaGridPliegos, function(i, item){
            tr = document.createElement("tr");
            
            tr.setAttribute("onclick","setCampos('');")
            if( i%2 == 0 )
                tr.setAttribute("class","l1");
            else
                tr.setAttribute("class","l2");
            
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
            td.innerHTML = 0;
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
        
        table.appendChild( tr );
    }
    document.getElementById("div_tabla_registros").innerHTML = table.outerHTML;
    delete td;
    delete tr;
    delete table;
	
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
	if( numero_total_registros < tamanio_maximo_arreglo * numero_registros_por_pagina ) {
        tamanio_arreglo = Math.ceil( numero_total_registros / numero_registros_por_pagina );
    } else {
        tamanio_arreglo = tamanio_maximo_arreglo;
    }
	
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
	
	var correcto = true;
	
	if (correcto 
			&& document.busqueda_registro_grid.chkbx_busca_por_nut.checked 
			&& document.busqueda_registro_grid.nut.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda NUT no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if (correcto) {
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