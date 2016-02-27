/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/
// FUNCIONES PARA LA MODIFICACION DEL REGISTRO

/* funciones */
function setCampos( id_cliente, clave, nombre_moral, nombre_representante, puesto, calle, num_exterior, num_interior, colonia, delegacion_municipio, estado, codigo_postal, pais, rfc, telefono_particular, telefono_movil, email, observaciones ) {

    // busqueda de nombre_tipo_precio
    var select = document.cliente.id_tipo_cliente;
    var index = 0;
    for (var i = 0;i < select.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select.options[i].text == clave) {
            index = i;
            break;
        }
    }
    
    document.cliente.id_cliente.value              = id_cliente;
    document.cliente.id_tipo_cliente.selectedIndex = index;
    document.cliente.nombre_moral.value            = nombre_moral;
    document.cliente.nombre_representante.value    = nombre_representante;
    document.cliente.puesto.value                  = puesto;
    document.cliente.calle.value                   = calle;
    document.cliente.num_exterior.value            = num_exterior;
    document.cliente.num_interior.value            = num_interior;
    document.cliente.colonia.value                 = colonia;
    document.cliente.delegacion_municipio.value    = delegacion_municipio;
    document.cliente.estado.value                  = estado;
    document.cliente.codigo_postal.value           = codigo_postal;
    document.cliente.pais.value                    = pais;
    document.cliente.rfc.value                     = rfc;
    document.cliente.telefono_particular.value     = telefono_particular;
    document.cliente.telefono_movil.value          = telefono_movil;
    document.cliente.email.value                   = email;
    document.cliente.observaciones.value           = observaciones;
}

function crear() {
    if (document.cliente.nombre_moral.value == "")
        alert("El campo nombre es obligatorio, favor de informarlo.");
    else {
        document.cliente.action = urlAlta;
        document.cliente.submit();
    }
}

function modifica() {
    if (document.cliente.nombre_moral.value == "")
        alert("El campo nombre es obligatorio, favor de informarlo.");
    else {
        document.cliente.action = urlModifica;
        document.cliente.submit();
    }
}

function elimina() {
    if (confirm(String.fromCharCode(191) + "Realmente desea eliminar este registro?")) {
        document.cliente.action = urlElimina;
        document.cliente.submit();
    }
}

function limpia_form_cliente() {
    document.cliente.id_cliente.value              = "";
    document.cliente.id_tipo_cliente.selectedIndex = 0;
    document.cliente.nombre_moral.value            = "";
    document.cliente.nombre_representante.value    = "";
    document.cliente.puesto.value                  = "";
    document.cliente.calle.value                   = "";
    document.cliente.num_exterior.value            = "";
    document.cliente.num_interior.value            = "";
    document.cliente.colonia.value                 = "";
    document.cliente.delegacion_municipio.value    = "";
    document.cliente.estado.value                  = "";
    document.cliente.codigo_postal.value           = "";
    document.cliente.pais.value                    = "";
    document.cliente.rfc.value                     = "";
    document.cliente.telefono_particular.value     = "";
    document.cliente.telefono_movil.value          = "";
    document.cliente.email.value                   = "";
    document.cliente.observaciones.value           = "";
}

/*************************************************************/
// FUNCIONES PARA EL PAGINADOR

function genera_tabla_dom( jsonListaClientes ) {
	//console.log( jsonListaClientes );
	
    var table = document.createElement("table");
    table.setAttribute("id","tabla_cliente");
    var tr = document.createElement("tr");
    var td = document.createElement("th");
    td.innerHTML = "Id.";
    //td.setAttribute("width","1%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Cve";
    //td.setAttribute("width","1%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Nombre";
    td.setAttribute("width","60%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Representante";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Puesto";
    //td.setAttribute("width","20%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Calle";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "No.Ext";
    //td.setAttribute("width","15%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "No.Int";
    //td.setAttribute("width","15%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Colonia";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Delegaci&oacute;n";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Estado";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "C.P.";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Pa&iacute;s";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "RFC";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Tel&eacute;fono";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "M&oacute;vil";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Email";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Observaciones";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    table.appendChild( tr );
    
    //console.log( jsonListaClientes );
    if( jsonListaClientes.length > 0 ) {
    	//console.log("entro");
    	$.each( jsonListaClientes, function(i, item){
            tr = document.createElement("tr");
            
            tr.setAttribute("onclick","setCampos('" + item.idCliente + "','"  + item.clave + "','"  + item.nombreMoral + "','"  + item.nombreRepresentante + "','"  + item.puesto + "','"  + item.calle + "','"  + item.numExterior + "','"  + item.numInterior + "','"  + item.colonia + "','"  + item.delegacionMunicipio + "','"  + item.estado + "','"  + item.codigoPostal + "','"  + item.pais + "','"  + item.rfc + "','"  + item.telefonoParticular + "','"  + item.telefonoMovil + "','"  + item.email + "','" + item.observaciones + "');")
            tr.setAttribute("class",i%2==0?"l1":"l2");
            
            td = document.createElement("td");
            td.innerHTML = item.idCliente;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.clave;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.nombreMoral;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.nombreRepresentante;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.puesto;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.calle;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.numExterior;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.numInterior;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.colonia;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.delegacionMunicipio;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.estado;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.codigoPostal;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.pais;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.rfc;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.telefonoParticular;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.telefonoMovil;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.email;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.observaciones;
            tr.appendChild( td );
            
            table.appendChild( tr );
        });
    } else {
    	//console.log("no entro");
    	tr = document.createElement("tr");
        tr.setAttribute("class","l1");
        for (var i=0; i<18; i++) {
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
    document.getElementById("div_tabla_cliente").innerHTML = table.outerHTML;
    delete td;
    delete tr;
    delete table;
} // genera_tabla_dom

function realiza_consulta_paginador() {
	document.busqueda_cliente.numero_pagina.value 				= numero_pagina;
	document.busqueda_cliente.numero_registros_por_pagina.value = numero_registros_por_pagina;
	// limpia campos
	limpia_form_cliente();
	// realiza ajax con el nuevo numero de pagina solicitada; el tipo de busqueda es el mismo
    $.ajax({
        type:"POST",
        url:urlBuscaListaPorParametros,
        data:$("[name='busqueda_cliente']").serialize(),
        success:function( response ) {
        	//console.log(response);
        	objJson = JSON.parse(response);
        	genera_tabla_dom( objJson.listaClientes );
        	objJson = null;
        },
        error:function( e ) {
            alert("\u00A1Algo sali\u00f3 mal! pero no pasa nada, todo tiene soluci\u00f3n.");
        }
    });
}

/*************************************************************/
// FUNCIONES PARA LA BUSQUEDA ESPECIALIZADA

function nueva_busqueda() {
	
	var correcto = true;
	
	if( correcto
			&& document.busqueda_cliente.chkbx_busca_por_nombre_moral.checked
			&& document.busqueda_cliente.nombre_moral.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda NOMBRE no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if( correcto
			&& document.busqueda_cliente.chkbx_busca_por_rfc.checked
			&& document.busqueda_cliente.rfc.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda RFC no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if( correcto
			&& document.busqueda_cliente.chkbx_busca_por_nombre_representante.checked
			&& document.busqueda_cliente.nombre_representante.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda REPRESENTANTE no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if( correcto
			&& document.busqueda_cliente.chkbx_busca_por_codigo_postal.checked
			&& document.busqueda_cliente.codigo_postal.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda C.P. no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if( correcto ) {
		//alert("realiza la nueva busqueda");
		numero_pagina = 1;
		document.busqueda_cliente.numero_pagina.value 				= numero_pagina;
		document.busqueda_cliente.numero_registros_por_pagina.value = numero_registros_por_pagina;
		document.body.style.cursor = "wait";
		$.ajax({
			type:"POST",
			url:urlBuscaListaPorParametros,
			data:$("[name='busqueda_cliente']").serialize(),
			success:function(response){
				//console.log(response);
				objJson = JSON.parse(response);
	        	genera_tabla_dom( objJson.listaClientes );
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

function limpia_form_busqueda_cliente() {
	// limpia form modificar registro
	limpia_form_cliente();
	// limpia checkbox
	document.busqueda_cliente.chkbx_busca_por_nombre_moral.checked 			= false;
	document.busqueda_cliente.chkbx_busca_por_rfc.checked 					= false;
	document.busqueda_cliente.chkbx_busca_por_clave.checked 				= false;
	document.busqueda_cliente.chkbx_busca_por_nombre_representante.checked 	= false;
	document.busqueda_cliente.chkbx_busca_por_codigo_postal.checked 		= false;
	// limpia input text y selects
	document.busqueda_cliente.nombre_moral.value 			= "";
	document.busqueda_cliente.rfc.value 					= "";
	document.busqueda_cliente.nombre_representante.value 	= "";
	document.busqueda_cliente.codigo_postal.value 			= "";
	document.busqueda_cliente.id_tipo_cliente.selectedIndex = 0;
	// realiza nueva busqueda
	nueva_busqueda();
}



