/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos(id_tabulador_precios, nombre_maquina, nombre_insumo, descripcion, inicio_tabulador, fin_tabulador, tipo_complejidad, precio, nombre_precio) {
    
	// busqueda de tipo_complejidad
    var select_complejidad = document.tabulador_precios.id_tipo_complejidad;
    for (i = 0;i < select_complejidad.length;i++) {
        if (select_complejidad.options[i].text == tipo_complejidad) {
        	document.tabulador_precios.id_tipo_complejidad.selectedIndex = i;
            break;
        }
    }
    delete select_complejidad;
    delete index_complejidad;
	
    // busqueda de nombre_tipo_precio
    var select_precio = document.tabulador_precios.id_tipo_precio;
    var index_precio = 0;
    for (i = 0;i < select_precio.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select_precio.options[i].text == nombre_precio) {
        	document.tabulador_precios.id_tipo_precio.selectedIndex = i;
            break;
        }
    }
    delete select_precio;
    delete index_precio;

    // busqueda de nombre_maquina
    var select_maquina = document.tabulador_precios.id_maquina;
    var index_maquina = 0;
    for (i = 0;i < select_maquina.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select_maquina.options[i].text == nombre_maquina) {
        	document.tabulador_precios.id_maquina.selectedIndex = i;
            break;
        }
    }
    delete select_maquina;
    delete index_maquina;
    
    document.tabulador_precios.id_tabulador_precios.value    	= id_tabulador_precios;
    document.tabulador_precios.nombre_insumo.value           	= nombre_insumo;
    document.tabulador_precios.descripcion.value             	= descripcion;
    document.tabulador_precios.inicio_tabulador.value        	= inicio_tabulador;
    document.tabulador_precios.fin_tabulador.value           	= fin_tabulador;
    document.tabulador_precios.precio.value						= precio;    
}

function validaForm() {
	var correcto = true;
	if ( document.tabulador_precios.nombre_insumo.value == "" 
	     || document.tabulador_precios.inicio_tabulador.value == "" 
	     || document.tabulador_precios.fin_tabulador.value == "" 
	     || document.tabulador_precios.precio.value == "" ) {
		correcto = false;
		alert("Los campos nombre, tabulador y precio son obligatorios, favor de informarlos.");
	}
	if ( isNaN(document.tabulador_precios.inicio_tabulador.value)
			|| isNaN(document.tabulador_precios.fin_tabulador.value)
			|| isNaN(document.tabulador_precios.precio.value) ) {
		correcto = false;
		alert("Los campos tabulador inicio y fin, y precio deben ser numeros validos, favor de informarlos.");
	}
	return correcto;
}

function crear() {
    if ( validaForm() )  {
        document.tabulador_precios.action = urlAlta;
        document.tabulador_precios.submit();
    }
}

function modifica() {
    if ( validaForm() )  {
    	$.ajax({
    		type:'POST',
    		url:urlModifica,
    		data:$("[name=tabulador_precios]").serialize(),
    		success:function( response ) {
    			realiza_consulta_paginador();
    		},
    		error:function( e ) {
    			alert("Problemas con el servidor. ¡Es momento de renunciar!");
    		}
    	});
    }
}

function elimina() {
    if (confirm(String.fromCharCode(191) + "Realmente desea eliminar este registro?")) {
    	$.ajax({
    		type:'POST',
    		url:urlElimina,
    		data:$("[name=tabulador_precios]").serialize(),
    		success:function( response ) {
    			realiza_consulta_paginador();
    		},
    		error:function( e ) {
    			alert("Problemas con el servidor. ¡Es momento de renunciar!");
    		}
    	});
    }
}

function limpia() {
    document.tabulador_precios.id_tabulador_precios.value    	= "";
    document.tabulador_precios.id_maquina.selectedIndex      	= 0;
    document.tabulador_precios.nombre_insumo.value           	= "";
    document.tabulador_precios.descripcion.value             	= "";
    document.tabulador_precios.inicio_tabulador.value        	= "";
    document.tabulador_precios.fin_tabulador.value           	= "";
    document.tabulador_precios.id_tipo_complejidad.selectedIndex = 0;
    document.tabulador_precios.precio.value						= "";    
    document.tabulador_precios.id_tipo_precio.selectedIndex  	= 0;
}

/*************************************************************/
//FUNCIONES PARA EL PAGINADOR

function genera_tabla_dom( jsonListaTabuladorPrecios ) {
	//console.log( jsonListaTabuladorPrecios );
	var table = document.createElement("table");
    
	table.setAttribute("id","tabla_tabulador_precios");
    
    var tr = document.createElement("tr");
    
    var td = document.createElement("th");
    td.innerHTML = "Id.";
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "M&aacute;quina";
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Nombre Insumo";
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Descripci&oacute;n";
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Inicio";
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Fin";
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Complejidad";
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Precio";
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Unidad";
    tr.appendChild( td );
    
    table.appendChild( tr );
    
    //console.log( jsonListaClientes );
    if( jsonListaTabuladorPrecios.length > 0 ) {
    	//console.log("entro");
    	$.each( jsonListaTabuladorPrecios, function(i, item){
            tr = document.createElement("tr");
            
            tr.setAttribute("onclick","setCampos('" + item.idTabuladorPrecios + "','"  + item.maquina + "','"  + item.nombreInsumo + "','"  + item.descripcion + "','"  + item.inicioTabulador + "','"  + item.finTabulador + "','"  + item.tipoComplejidad + "','"  + item.precio + "','"  + item.tipoPrecio + "');")
            tr.setAttribute("class",i%2==0?"l1":"l2");
            
            td = document.createElement("td");
            td.innerHTML = item.idTabuladorPrecios;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.maquina;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.nombreInsumo;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.descripcion;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = (item.inicioTabulador).formatMoney(0);
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = (item.finTabulador).formatMoney(0);
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.tipoComplejidad;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = (item.precio).formatMoney(2);
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.tipoPrecio;
            tr.appendChild( td );
            
            table.appendChild( tr );
        });
    } else {
    	//console.log("no entro");
    	tr = document.createElement("tr");
        tr.setAttribute("class","l1");
        for (var i=0; i<9; i++) {
        	td = document.createElement("td");
            td.innerHTML = "&nbsp;";
            tr.appendChild( td );
        }
        table.appendChild( tr );
    }
    document.getElementById("tabla_tabulador_precios").innerHTML = table.outerHTML;
    delete td;
    delete tr;
    delete table;
}

function realiza_consulta_paginador() {
	document.busqueda_tabulador_precios.numero_pagina.value 				= numero_pagina;
	document.busqueda_tabulador_precios.numero_registros_por_pagina.value 	= numero_registros_por_pagina;
	// limpia campos formulario tabulador
	limpia();
	// realiza ajax con el nuevo numero de pagina solicitada; el tipo de busqueda es el mismo
    $.ajax({
        type:"POST",
        url:urlBuscaListaPorParametros,
        data:$("[name='busqueda_tabulador_precios']").serialize(),
        success:function( response ) {
        	//console.log(response);
        	objJson = JSON.parse(response);
        	genera_tabla_dom( objJson.listaTabuladorPrecios );
        	objJson = null;
        },
        error:function( e ) {
            alert("\u00A1Algo sali\u00f3 mal! pero no pasa nada, todo tiene soluci\u00f3n.");
        }
    });
}

/*************************************************************/
//FUNCIONES PARA LA BUSQUEDA ESPECIALIZADA


function nueva_busqueda() {
	var correcto = true;
	
	if ( correcto ) {
		numero_pagina 															= 1;
		document.busqueda_tabulador_precios.numero_pagina.value 				= numero_pagina;
		document.busqueda_tabulador_precios.numero_registros_por_pagina.value 	= numero_registros_por_pagina;
		document.body.style.cursor = "wait";
		$.ajax({
			type:"POST",
			url:urlBuscaListaPorParametros,
			data:$("[name='busqueda_tabulador_precios']").serialize(),
			success:function(response){
				//console.log(response);
				objJson = JSON.parse(response);
	        	genera_tabla_dom( objJson.listaTabuladorPrecios );
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

function limpia_form_criterios_busqueda() {
	// limpia form tabulador precios
	limpia();
	// limpia checkbox
	document.busqueda_tabulador_precios.chkbx_busca_por_maquina.checked 	= false;
	document.busqueda_tabulador_precios.chkbx_busca_por_complejidad.checked = false;
	// limpia selects
	document.busqueda_tabulador_precios.id_maquina.selectedIndex 			= 0;
	document.busqueda_tabulador_precios.id_tipo_complejidad.selectedIndex 	= 0;
	// realiza nueva busqueda
	nueva_busqueda();
}





