// limpia formulario
function limpia() {
    //console.log( document.forms["visualizador"].elements["radio_tipo_busqueda"] );

    // limpia campos ocultos
    document.forms["visualizador"].elements["radio_tipo_busqueda"].value        = "";
    
    // limpia radios del formulario
    for( var i=0; i<document.forms["visualizador"].elements["radio_tipo_busqueda"].length; i++)
        document.forms["visualizador"].elements["radio_tipo_busqueda"][i].checked = false;
    
    // limpia campos
    document.forms["visualizador"].elements["nut"].value                        = "";
    document.forms["visualizador"].elements["id_estatus_orden"].selectedIndex   = 0;
    document.forms["visualizador"].elements["nombre"].value                     = "";
    document.forms["visualizador"].elements["descripcion"].value                = "";
    document.forms["visualizador"].elements["fecha_cotizacion_inicio"].value    = "";
    document.forms["visualizador"].elements["fecha_cotizacion_fin"].value       = "";
    document.forms["visualizador"].elements["cliente"].value                    = "";
    
    nueva_busqueda();
} // limpia

function muestra_detalle_nut( nut ) {
    //alert("muestra detalle nut: " + nut);
    Shadowbox.open({
        content: urlObtieneDetalleNut + "?nut=" + nut,
        player: "iframe",
        width: 1278,
        height: 804,
        options: { modal: true, // IMPERATIVO CERRAR MANUALMENTE
                   overlayOpacity: 0.75 }
    });
} // muestra_detalle_nut

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
    //console.log( table );
    //console.log( table.outerHTML );
    //console.log( table.innerHTML );
    //console.log( table.textContent );
    //console.log( table.toString() );
    //console.log( document.getElementById("div_tabla_registros") );
    //console.log( document.getElementById("div_tabla_registros").innerHTML );
    //document.getElementById("div_tabla_registros").appendChild( table ); // INCORRECTO
    document.getElementById("div_tabla_registros").innerHTML = table.outerHTML;
    delete td;
    delete tr;
    delete table;
} // genera_tabla_dom

function nueva_busqueda() {
    
    var correcto = true;
    
    if( document.getElementById("radio_nut").checked == true
        && document.forms["visualizador"].elements["nut"].value == "" ) {
            correcto = false;
            alert("El campo de b\u00fasqueda NUT no puede estar vac\u00edo. Favor de reportarlo.");
        }
        
    if( document.getElementById("radio_nombre_op").checked == true
        && document.forms["visualizador"].elements["nombre"] == "" ) {
            correcto = false;
            alert("El campo de b\u00fasqueda NOMBRE no puede estar vac\u00edo. Favor de reportarlo.");
        }
        
    if( document.getElementById("radio_descripcion_op").checked == true
        && document.forms["visualizador"].elements["descripcion"] == "" ) {
            correcto = false;
            alert("El campo de b\u00fasqueda DESCRIPCI\u00d3N no puede estar vac\u00edo. Favor de reportarlo.");
        }
        
    if( document.getElementById("radio_fecha_cotizacion").checked == true
        && ( document.forms["visualizador"].elements["fecha_cotizacion_inicio"] == "" 
             || document.forms["visualizador"].elements["fecha_cotizacion_fin"] == "") ) {
            correcto = false;
            alert("Los campoa de b\u00fasqueda FECHA COITIZACI\u00d3N no pueden estar vac\u00edos. Favor de reportarlos.");
        }
        
    if( document.getElementById("radio_cliente").checked == true
        && document.forms["visualizador"].elements["cliente"] == "" ) {
            correcto = false;
            alert("El campo de b\u00fasqueda CLIENTE no puede estar vac\u00edo. Favor de reportarlo.");
    }
    
    if( correcto ) {
        // realiza ajax; como es una nueva busqueda, se debe inicializar el paginador a 1 = numero de pagina
        numero_pagina = 1;
        document.forms["visualizador"].elements["numero_pagina"].value                  = numero_pagina;
        document.forms["visualizador"].elements["numero_registros_por_pagina"].value    = numero_registros_por_pagina;
        document.forms["visualizador"].elements["tipo_busqueda"].value                  = document.forms["visualizador"].elements["radio_tipo_busqueda"].value;
        $.ajax({
            type:"POST",
            url:urlBuscaOrdenesProduccion,
            data:$("[name='visualizador']").serialize(),
            success:function( response ) {
            	var jsonResponse = JSON.parse(response);
                // generacion de tabla con registros
                genera_tabla_dom( jsonResponse.listaOrdenesProduccion );
                // inicializacion de variables
                numero_total_registros = jsonResponse.numeroTotalRegistros;
                carga_datos();
                jsonResponse = null;
            },
            error:function( e ) {
                alert("\u00A1Algo sali\u00f3 mal! pero todo tiene soluci\u00f3n.");
            }
        });    
    }
} // nueva_busqueda

function realiza_consulta_paginador(){
	// realiza ajax con el nuevo numero de pagina solicitada; el tipo de busqueda es el mismo
    document.forms["visualizador"].elements["numero_pagina"].value                  = numero_pagina;
    document.forms["visualizador"].elements["numero_registros_por_pagina"].value    = numero_registros_por_pagina;
    $.ajax({
        type:"POST",
        url:urlBuscaOrdenesProduccion,
        data:$("[name='visualizador']").serialize(),
        success:function( response ) {
        	//console.log(response);
        	objJson = JSON.parse( response )
        	genera_tabla_dom( objJson.listaOrdenesProduccion );
        	objJson = null;
        },
        error:function( e ) {
            alert("\u00A1Algo sali\u00f3 mal! pero no pasa nada, todo tiene soluci\u00f3n.");
        }
    });
} // realiza_consulta (del paginador)

