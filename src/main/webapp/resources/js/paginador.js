
// funciones del paginador
function actualiza_variables() {
    numero_pagina_total		= Math.ceil( numero_total_registros / numero_registros_por_pagina );
    mitad_tamanio_arreglo	= Math.floor( tamanio_arreglo / 2 );
}


function string_elementos_encontrados() {
    var cadena = numero_total_registros + " registros encontrados. Mostrando del " + ( ( (numero_pagina - 1 ) * numero_registros_por_pagina ) + 1 ) + " al ";
    if( parseInt(numero_pagina * numero_registros_por_pagina) < numero_total_registros ) {
        cadena = cadena + parseInt(numero_pagina * numero_registros_por_pagina) + ".";
    } else {
        cadena = cadena + numero_total_registros + ".";
    }
    return cadena;
}


function cambia_selector( numPag ) {
    document.getElementsByClassName("seleccionado")[0].setAttribute("class","activo");
    
    var limite_inferior 	= parseInt(numPag) - mitad_tamanio_arreglo;
    var limite_superior		= parseInt(numPag) + mitad_tamanio_arreglo;
    var modifica_arreglo	= true;
    
    if( limite_inferior <= 0 ) {
        modifica_arreglo = false;
        for( var i = 0; i < document.getElementsByName("arreglo").length; i++ ) {
            document.getElementsByName("arreglo")[i].innerHTML = parseInt(i) + 1;
        }
    }
    
    if( limite_superior >= ( parseInt(numero_pagina_total) + 1 ) ) {
        modifica_arreglo = false;
        for( var i = 0; i < document.getElementsByName("arreglo").length; i++ ) {
            document.getElementsByName("arreglo")[i].innerHTML =  parseInt(numero_pagina_total - tamanio_arreglo + 1) + parseInt(i);
        }					
    }
    
    if( modifica_arreglo ) {
        for( var i = 0; i < document.getElementsByName("arreglo").length; i++ ) {
            document.getElementsByName("arreglo")[i].innerHTML = parseInt(limite_inferior) + parseInt(i);
        }
    }
    
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
    // realiza ajax con el nuevo numero de pagina solicitada; el tipo de busqueda es el mismo
    document.forms["visualizador"].elements["numero_pagina"].value                  = numero_pagina;
    document.forms["visualizador"].elements["numero_registros_por_pagina"].value    = numero_registros_por_pagina;
    $.ajax({
        type:"POST",
        url:urlBuscaOrdenesProduccion,
        data:$("[name='visualizador']").serialize(),
        success:function( response ) {
        	//console.log(response);
        	genera_tabla_dom( response.ordenesProduccion );
        	//jsonResponse = JSON.parse(response);
            //genera_tabla_dom( jsonResponse.ordenesProduccion );
            //jsonResponse = null;
        },
        error:function( e ) {
            alert("\u00A1Algo sali\u00f3 mal! pero no pasa nada, todo tiene soluci\u00f3n.");
        }
    });
}


