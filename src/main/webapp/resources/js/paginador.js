
// funciones del paginador
function actualiza_variables() {
    numero_pagina_total		= Math.ceil( numero_total_registros / numero_registros_por_pagina );
    mitad_tamanio_arreglo	= Math.floor( tamanio_arreglo / 2 );
}


function string_elementos_encontrados() {
    var cadena = numero_total_registros + " registros encontrados. Mostrando del " + ( ( (numero_pagina - 1 ) * numero_registros_por_pagina ) + 1 ) + " al ";
    if( parseInt(numero_pagina * numero_registros_por_pagina) < numero_total_registros ) 
        cadena = cadena + parseInt(numero_pagina * numero_registros_por_pagina) + ".";
    else 
        cadena = cadena + numero_total_registros + ".";
    return cadena;
}


function cambia_selector( numPag ) {
    document.getElementsByClassName("seleccionado")[0].setAttribute("class","activo");
    var limite_inferior 	= parseInt(numPag) - mitad_tamanio_arreglo;
    var limite_superior		= parseInt(numPag) + mitad_tamanio_arreglo;
    var modifica_arreglo	= true;
    if( limite_inferior <= 0 ) {
        modifica_arreglo = false;
        for( var i = 0; i < document.getElementsByName("arreglo").length; i++ ) 
            document.getElementsByName("arreglo")[i].innerHTML = parseInt(i) + 1;
    }
    if( limite_superior >= ( parseInt(numero_pagina_total) + 1 ) ) {
        modifica_arreglo = false;
        for( var i = 0; i < document.getElementsByName("arreglo").length; i++ ) 
            document.getElementsByName("arreglo")[i].innerHTML =  parseInt(numero_pagina_total - tamanio_arreglo + 1) + parseInt(i);
    }
    if( modifica_arreglo ) 
        for( var i = 0; i < document.getElementsByName("arreglo").length; i++ ) 
            document.getElementsByName("arreglo")[i].innerHTML = parseInt(limite_inferior) + parseInt(i);
    for( var i = 0; i < document.getElementsByName("arreglo").length; i++ ) {
        if( document.getElementsByName("arreglo")[i].innerHTML == numPag ) {
            document.getElementsByName("arreglo")[i].setAttribute("class","seleccionado");
            break;
        }
    }
    delete limite_inferior;
    delete limite_superior;
    delete modifica_arreglo;
}


function paginador( obj ) {	
    //console.log( obj );
    if( obj.className != "seleccionado" ) {
        switch( obj.innerHTML ) {
            case "Primero":
                numero_pagina = 1;
                // aqui hace el ajax;
                document.getElementById("div_paginacion_resultados").innerHTML = string_elementos_encontrados();
                cambia_selector( numero_pagina );
                break;
            case "Anterior":
                if( (numero_pagina - 1) > 0 ) {
                    numero_pagina = numero_pagina - 1;
                        // aqui hace el ajax;
                    document.getElementById("div_paginacion_resultados").innerHTML = string_elementos_encontrados();
                    cambia_selector( numero_pagina );
                }
                break;
            case "Siguiente":
                if( parseInt(numero_pagina) + 1 <= numero_pagina_total ) {
                    numero_pagina = parseInt(numero_pagina) + 1;
                        // aqui hace el ajax;
                    document.getElementById("div_paginacion_resultados").innerHTML = string_elementos_encontrados();
                    cambia_selector( numero_pagina );
                }
                break;
            case "Ultimo":
                numero_pagina = numero_pagina_total;
                    // aqui hace el ajax;
                document.getElementById("div_paginacion_resultados").innerHTML = string_elementos_encontrados();
                cambia_selector( numero_pagina );
                break;
            default:
                numero_pagina = obj.innerHTML;
                    // aqui hace el ajax;
                document.getElementById("div_paginacion_resultados").innerHTML = string_elementos_encontrados();
                cambia_selector( obj.innerHTML );
                break;
        }	
    }
    // la definicion de esta funcion esta en el archivo principal que usa el servicio del paginador
    realiza_consulta_paginador();
} // paginador


function carga_datos() {
	// define el tamaño del arreglo que se muestra en el paginador
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
} // carga_datos


