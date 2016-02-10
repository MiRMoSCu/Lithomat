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
    var select = document.forms["cliente"].id_tipo_cliente;
    var index = 0;
    for (var i = 0;i < select.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select.options[i].text == clave) {
            index = i;
            break;
        }
    }
    
    document.forms["cliente"].id_cliente.value              = id_cliente;
    document.forms["cliente"].id_tipo_cliente.selectedIndex = index;
    document.forms["cliente"].nombre_moral.value            = nombre_moral;
    document.forms["cliente"].nombre_representante.value    = nombre_representante;
    document.forms["cliente"].puesto.value                  = puesto;
    document.forms["cliente"].calle.value                   = calle;
    document.forms["cliente"].num_exterior.value            = num_exterior;
    document.forms["cliente"].num_interior.value            = num_interior;
    document.forms["cliente"].colonia.value                 = colonia;
    document.forms["cliente"].delegacion_municipio.value    = delegacion_municipio;
    document.forms["cliente"].estado.value                  = estado;
    document.forms["cliente"].codigo_postal.value           = codigo_postal;
    document.forms["cliente"].pais.value                    = pais;
    document.forms["cliente"].rfc.value                     = rfc;
    document.forms["cliente"].telefono_particular.value     = telefono_particular;
    document.forms["cliente"].telefono_movil.value          = telefono_movil;
    document.forms["cliente"].email.value                   = email;
    document.forms["cliente"].observaciones.value           = observaciones;
}

function crear() {
    if (document.forms["cliente"].nombre_moral.value == "")
        alert("El campo nombre es obligatorio, favor de informarlo.");
    else {
        document.forms["cliente"].action = urlAlta;
        document.forms["cliente"].submit();
    }
}

function modifica() {
    if (document.forms["cliente"].nombre_moral.value == "")
        alert("El campo nombre es obligatorio, favor de informarlo.");
    else {
        document.forms["cliente"].action = urlModifica;
        document.forms["cliente"].submit();
    }
}

function elimina() {
    if (confirm(String.fromCharCode(191) + "Realmente desea eliminar este registro?")) {
        document.forms["cliente"].action = urlElimina;
        document.forms["cliente"].submit();
    }
}

function limpia_form_cliente() {
    document.forms["cliente"].id_cliente.value              = "";
    document.forms["cliente"].id_tipo_cliente.selectedIndex = 0;
    document.forms["cliente"].nombre_moral.value            = "";
    document.forms["cliente"].nombre_representante.value    = "";
    document.forms["cliente"].puesto.value                  = "";
    document.forms["cliente"].calle.value                   = "";
    document.forms["cliente"].num_exterior.value            = "";
    document.forms["cliente"].num_interior.value            = "";
    document.forms["cliente"].colonia.value                 = "";
    document.forms["cliente"].delegacion_municipio.value    = "";
    document.forms["cliente"].estado.value                  = "";
    document.forms["cliente"].codigo_postal.value           = "";
    document.forms["cliente"].pais.value                    = "";
    document.forms["cliente"].rfc.value                     = "";
    document.forms["cliente"].telefono_particular.value     = "";
    document.forms["cliente"].telefono_movil.value          = "";
    document.forms["cliente"].email.value                   = "";
    document.forms["cliente"].observaciones.value           = "";
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

function carga_datos() {
	
	// define el tamaño del arreglo que se muestra en el paginador
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
} // carga_datos

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
	// limpia selects
	document.busqueda_cliente.chkbx_busca_por_nombre_moral.checked 			= false;
	document.busqueda_cliente.chkbx_busca_por_rfc.checked 					= false;
	document.busqueda_cliente.chkbx_busca_por_clave.checked 				= false;
	document.busqueda_cliente.chkbx_busca_por_nombre_representante.checked 	= false;
	document.busqueda_cliente.chkbx_busca_por_codigo_postal.checked 		= false;
	// limpia input text
	document.busqueda_cliente.nombre_moral.value 			= "";
	document.busqueda_cliente.rfc.value 					= "";
	document.busqueda_cliente.nombre_representante.value 	= "";
	document.busqueda_cliente.codigo_postal.value 			= "";
	document.busqueda_cliente.id_tipo_cliente.selectedIndex = 0;
	// realiza nueva busqueda
	nueva_busqueda();
}



