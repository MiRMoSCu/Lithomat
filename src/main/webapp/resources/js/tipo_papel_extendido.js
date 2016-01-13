/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/
//FUNCIONES PARA LA MODIFICACION DEL REGISTRO
Number.prototype.formatMoney = function(c, d, t) {
	var n = this, 
	    c = isNaN(c = Math.abs(c)) ? 2 : c, 
	    d = d == undefined ? "." : d, 
	    t = t == undefined ? "," : t, 
	    s = n < 0 ? "-" : "", 
	    i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", 
	    j = (j = i.length) > 3 ? j % 3 : 0;
	return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
};


/* funciones */
function setCampos( id_tipo_papel_extendido, razon_social, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, nombre_precio ) {

    //Busqueda de proveedor_papel
    var select_proveedor = document.forms["tipo_papel_extendido"].id_proveedor_papel;
    var index_razon_social = 0;
    for (i = 0;i < select_proveedor.length;i++) {
        if (select_proveedor.options[i].innerText == razon_social) {
            index_razon_social = i;
            break;
        }
    }
    
    // busqueda de nombre_precio
    var select_precio = document.forms["tipo_papel_extendido"].id_tipo_precio;
    var index_precio = 0;
    for (i = 0;i < select_precio.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_precio );
        if (select_precio.options[i].innerText == nombre_precio) {
            index_precio = i;
            break;
        }
    }
    
    document.forms["tipo_papel_extendido"].id_tipo_papel_extendido.value     = id_tipo_papel_extendido;
    document.forms["tipo_papel_extendido"].id_proveedor_papel.selectedIndex  = index_razon_social;
    document.forms["tipo_papel_extendido"].nombre.value                      = nombre;
    document.forms["tipo_papel_extendido"].gramaje.value                     = gramaje;
    document.forms["tipo_papel_extendido"].kilogramos.value                  = kilogramos;
    document.forms["tipo_papel_extendido"].alto.value                        = alto;
    document.forms["tipo_papel_extendido"].ancho.value                       = ancho;
    document.forms["tipo_papel_extendido"].descripcion.value                 = descripcion;
    document.forms["tipo_papel_extendido"].precio.value                      = precio;
    document.forms["tipo_papel_extendido"].id_tipo_precio.selectedIndex      = index_precio;
}

function crear() {
    if (document.forms["tipo_papel_extendido"].nombre.value == "" 
     || document.forms["tipo_papel_extendido"].gramaje.value == ""
     || document.forms["tipo_papel_extendido"].kilogramos.value == ""
     || document.forms["tipo_papel_extendido"].alto.value == ""
     || document.forms["tipo_papel_extendido"].ancho.value == ""
     || document.forms["tipo_papel_extendido"].precio.value == "" )
        alert("Todos los campos son obligatorios, favor de informarlos.");
    else {
        document.forms["tipo_papel_extendido"].action = urlAlta;
        document.forms["tipo_papel_extendido"].submit();
    }
}

function modifica() {
    if (document.forms["tipo_papel_extendido"].nombre.value == "" 
    	|| document.forms["tipo_papel_extendido"].gramaje.value == ""
    	|| document.forms["tipo_papel_extendido"].kilogramos.value == ""
    	|| document.forms["tipo_papel_extendido"].alto.value == ""
    	|| document.forms["tipo_papel_extendido"].ancho.value == ""
    	|| document.forms["tipo_papel_extendido"].precio.value == "")
        alert("Todos los campos son obligatorios, favor de informarlos.");
    else {
        document.forms["tipo_papel_extendido"].action = urlModifica;
        document.forms["tipo_papel_extendido"].submit();
    }
}

function elimina() {
    if (confirm(String.fromCharCode(191) + "Realmente desea eliminar este registro?")) {
        document.forms["tipo_papel_extendido"].action = urlElimina;
        document.forms["tipo_papel_extendido"].submit();
    }
}

function limpia_form_tipo_papel_extendido() {
    document.forms["tipo_papel_extendido"].id_tipo_papel_extendido.value     = "";
    document.forms["tipo_papel_extendido"].id_proveedor_papel.selectedIndex  = 0;
    document.forms["tipo_papel_extendido"].nombre.value                      = "";
    document.forms["tipo_papel_extendido"].gramaje.value                     = "";
    document.forms["tipo_papel_extendido"].kilogramos.value                  = "";
    document.forms["tipo_papel_extendido"].alto.value                        = "";
    document.forms["tipo_papel_extendido"].ancho.value                       = "";
    document.forms["tipo_papel_extendido"].descripcion.value                 = "";
    document.forms["tipo_papel_extendido"].precio.value                      = "";
    document.forms["tipo_papel_extendido"].id_tipo_precio.selectedIndex      = 0;
}

/*************************************************************/
//FUNCIONES PARA EL PAGINADOR

function genera_tabla_dom( jsonListaTipoPapelExtendido ) {
	//console.log( jsonListaClientes );
	
    var table = document.createElement("table");
    table.setAttribute("id","tabla_tipo_papel_extendido");
    var tr = document.createElement("tr");
    var td = document.createElement("th");
    td.innerHTML = "Id.";
    //td.setAttribute("width","1%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Proveedor";
    //td.setAttribute("width","1%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Nombre";
    //td.setAttribute("width","60%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Gramaje";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Kilogramos";
    //td.setAttribute("width","20%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Alto";
    //td.setAttribute("width","15%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Ancho";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Descripci&oacute;n";
    //td.setAttribute("width","15%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Precio";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    td = document.createElement("th");
    td.innerHTML = "Unidad";
    //td.setAttribute("width","10%");
    tr.appendChild( td );
    
    table.appendChild( tr );
    
    //console.log( jsonListaClientes );
    if( jsonListaTipoPapelExtendido.length > 0 ) {
    	//console.log("entro");
    	$.each( jsonListaTipoPapelExtendido, function(i, item){
            tr = document.createElement("tr");
            
            tr.setAttribute("onclick","setCampos('" + item.idTipoPapelExtendido + "','"  + item.razonSocial + "','"  + item.nombre + "','"  + item.gramaje + "','"  + item.kilogramos.toFixed(1) + "','" + item.alto + "','" + item.ancho + "','" + item.descripcion + "','"  + item.precio.toFixed(1) + "','"  + item.nombrePrecio + "');")
            if( i%2 == 0 )
                tr.setAttribute("class","l1");
            else
                tr.setAttribute("class","l2");
            
            td = document.createElement("td");
            td.innerHTML = item.idTipoPapelExtendido;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.razonSocial;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.nombre;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.gramaje;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.kilogramos.toFixed(1);
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.alto;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.ancho;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.descripcion;
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = (parseInt(item.precio.toFixed(1))).formatMoney(2);
            tr.appendChild( td );
            
            td = document.createElement("td");
            td.innerHTML = item.nombrePrecio;
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
    document.getElementById("div_tabla_tipo_papel_extendido").innerHTML = table.outerHTML;
    delete td;
    delete tr;
    delete table;
} // genera_tabla_dom

function realiza_consulta_paginador() {
	document.busqueda_tipo_papel_extendido.numero_pagina.value 				 = numero_pagina;
	document.busqueda_tipo_papel_extendido.numero_registros_por_pagina.value = numero_registros_por_pagina;
	// limpia campos
	limpia_form_tipo_papel_extendido();
	// realiza ajax con el nuevo numero de pagina solicitada; el tipo de busqueda es el mismo
    $.ajax({
        type:"POST",
        url:urlBuscaListaPorParametros,
        data:$("[name='busqueda_tipo_papel_extendido']").serialize(),
        success:function( response ) {
        	//console.log(response);
        	objJson = JSON.parse(response);
        	genera_tabla_dom( objJson.listaTipoPapelExtendido );
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
			&& document.busqueda_tipo_papel_extendido.chkbx_busca_por_nombre.checked
			&& document.busqueda_tipo_papel_extendido.nombre.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda NOMBRE no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if( correcto
			&& document.busqueda_tipo_papel_extendido.chkbx_busca_por_gramaje.checked
			&& document.busqueda_tipo_papel_extendido.gramaje.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda GRANAJE no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if( correcto
			&& document.busqueda_tipo_papel_extendido.chkbx_busca_por_kilogramos.checked
			&& document.busqueda_tipo_papel_extendido.kilogramos.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda KILOGRAMOS no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if( correcto
			&& document.busqueda_tipo_papel_extendido.chkbx_busca_por_ancho.checked
			&& document.busqueda_tipo_papel_extendido.ancho.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda ANCHO no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if( correcto
			&& document.busqueda_tipo_papel_extendido.chkbx_busca_por_alto.checked
			&& document.busqueda_tipo_papel_extendido.alto.value == "" ) {
		correcto = false;
		alert("El campo de b\u00FAsqueda ALTO no puede estar vac\u00EDo. Favor de reportarlo.");
	}
	
	if( correcto ) {
		//alert("realiza la nueva busqueda");
		numero_pagina = 1;
		document.busqueda_tipo_papel_extendido.numero_pagina.value 				 = numero_pagina;
		document.busqueda_tipo_papel_extendido.numero_registros_por_pagina.value = numero_registros_por_pagina;
		document.body.style.cursor = "wait";
		$.ajax({
			type:"POST",
			url:urlBuscaListaPorParametros,
			data:$("[name='busqueda_tipo_papel_extendido']").serialize(),
			success:function(response){
				//console.log(response);
				objJson = JSON.parse(response);
	        	genera_tabla_dom( objJson.listaTipoPapelExtendido );
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

function limpia_form_busqueda_tipo_papel_sobrante() {
	// limpia form modificar registro
	limpia_form_tipo_papel_extendido();
	// limpia selects
	document.busqueda_tipo_papel_extendido.chkbx_busca_por_nombre.checked 		= false;
	document.busqueda_tipo_papel_extendido.chkbx_busca_por_gramaje.checked 		= false;
	document.busqueda_tipo_papel_extendido.chkbx_busca_por_kilogramos.checked 	= false;
	document.busqueda_tipo_papel_extendido.chkbx_busca_por_alto.checked 		= false;
	document.busqueda_tipo_papel_extendido.chkbx_busca_por_ancho.checked 		= false;
	document.busqueda_tipo_papel_extendido.chkbx_busca_por_proveedor.checked 	= false;
	// limpia input text
	document.busqueda_tipo_papel_extendido.nombre.value 					= "";
	document.busqueda_tipo_papel_extendido.gramaje.value 					= "";
	document.busqueda_tipo_papel_extendido.kilogramos.value 				= "";
	document.busqueda_tipo_papel_extendido.alto.value 						= "";
	document.busqueda_tipo_papel_extendido.ancho.value 						= "";
	document.busqueda_tipo_papel_extendido.id_proveedor_papel.selectedIndex = 0;
	// realiza nueva busqueda
	nueva_busqueda();
}

