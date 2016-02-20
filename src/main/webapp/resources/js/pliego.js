function limpiaRebase() {
    document.forms[0].rebase_en_milimetros.value        = "0";
    document.forms[0].medianiles_en_milimetros.value    = "0";
    document.forms[0].pinzas_en_milimetros.value       	= "0";
}


function limpiaPliego() {
    document.forms[0].numero_pliego.value       = "";
    document.forms[0].hojas_requeridas.value    = "";
    document.forms[0].hojas_sobrantes.value     = "";
    document.forms[0].hojas_totales.value       = "";
    document.forms[0].mismos_sobrantes.checked  = false;
    document.forms[0].observaciones.value       = "";
    document.forms[0].mismas_placas.checked     = false;
    document.forms[0].tipo_vuelta.selectedIndex = 0;
}


function setCampos( numero_pliego, hojas_requeridas, hojas_sobrantes, hojas_totales, observaciones, vuelta_mismas_placas, descripcion_tipo_vuelta ) {
    document.forms[0].numero_pliego.value       = numero_pliego;
    document.forms[0].hojas_requeridas.value    = hojas_requeridas;
    document.forms[0].hojas_sobrantes.value     = hojas_sobrantes;
    document.forms[0].hojas_totales.value       = hojas_totales;
    document.forms[0].observaciones.value       = observaciones;
    document.forms[0].mismas_placas.checked 	= vuelta_mismas_placas=="true"?true:false;
    for( var i=0; i<document.forms[0].tipo_vuelta.length; i++ ) {
        if( document.forms[0].tipo_vuelta.options[i].text == descripcion_tipo_vuelta ) {
            document.forms[0].tipo_vuelta.selectedIndex = i;
            break;
        }
    }
}


function sumatoria() {
    if( document.forms["pliego"].elements["numero_pliego"].value != "" ) {
        document.forms["pliego"].elements["hojas_totales"].value = parseInt( document.forms["pliego"].elements["hojas_requeridas"].value ) + parseInt( document.forms["pliego"].elements["hojas_sobrantes"].value );
    }
}


function modificaRegistro() {

    var correcto = true;
    
    if( document.forms["pliego"].elements["numero_pliego"].value == "" ) {
        correcto = false;
    }
    
    if ( correcto 
    		&& document.forms["pliego"].elements["hojas_sobrantes"].value == "" 
    			|| isNaN(document.forms["pliego"].elements["hojas_sobrantes"].value) ) {
    	correcto = false;
        alert("La cantidad de hojas sobrantes es incorrecta. Favor de corregir.");
    }
    
    if( correcto 
    		&& (document.forms["pliego"].elements["hojas_totales"].value == "NaN"
    			|| isNaN(document.forms["pliego"].elements["hojas_totales"].value) ) ) {
        correcto = false;
        alert("La sumatoria de hojas requeridas y hojas sobrantes es incorrecta. Favor de corregir.");
    }
    
    if( correcto ) {
        var numero_pliego           = document.forms[0].elements["numero_pliego"].value;
        var hojas_requeridas        = document.forms[0].elements["hojas_requeridas"].value;
        var hojas_sobrantes         = document.forms[0].elements["hojas_sobrantes"].value;
        var hojas_totales           = document.forms[0].elements["hojas_totales"].value;
        var mismos_sobrantes		= document.forms[0].elements["mismos_sobrantes"].checked == true ? true : false;
        var observaciones           = document.forms[0].elements["observaciones"].value;
        var vuelta_mismas_placas    = document.forms[0].elements["mismas_placas"].checked == true ? true : false;
        var tipo_vuelta             = document.forms[0].elements["tipo_vuelta"].options[ document.forms[0].elements["tipo_vuelta"].selectedIndex ].text;

        var tableDOM = document.getElementById("tabla_hojas_pliego");
        var hojas_sobrantes_original;
        // busca en tabla el registro que corresponde a la modificacion
        for( var i = 0; i < tableDOM.rows.length; i++ ) {
            if( tableDOM.rows[i].cells[0].innerHTML == numero_pliego ) {
            	hojas_sobrantes_original = tableDOM.rows[i].cells[2].innerHTML
                tableDOM.rows[i].removeAttribute("onclick");
                tableDOM.rows[i].cells[2].innerHTML = hojas_sobrantes;
                tableDOM.rows[i].cells[3].innerHTML = hojas_totales;
                tableDOM.rows[i].cells[4].innerHTML = observaciones;
                tableDOM.rows[i].cells[5].innerHTML = vuelta_mismas_placas == true ? "Si" : "No";
                tableDOM.rows[i].cells[6].innerHTML = tipo_vuelta;
                var stringFuncion = "setCampos(\'" + i + "\', \'" + hojas_requeridas + "\', \'" + hojas_sobrantes + "\', \'" + hojas_totales + "\', \'" + observaciones + "\', \'" + vuelta_mismas_placas + "\', \'" + tipo_vuelta + "\');";
                tableDOM.rows[i].setAttribute("onclick",stringFuncion);
                delete stringFuncion;
            }
        }
        // si mismos_sobrantes == true 
        // entonces modifica entre todos los pliegos los sobrantes que son identicos al primer registro modificado 
        if( mismos_sobrantes ) {
        	for( var i = 0; i < tableDOM.rows.length; i++ ) {
        		if( tableDOM.rows[i].cells[2].innerHTML == hojas_sobrantes_original ) {
        			tableDOM.rows[i].removeAttribute("onclick");
        			hojas_totales = parseInt(tableDOM.rows[i].cells[1].innerHTML) + parseInt(hojas_sobrantes);
        			tableDOM.rows[i].cells[2].innerHTML = hojas_sobrantes;
        			tableDOM.rows[i].cells[3].innerHTML = hojas_totales;
        			vuelta_mismas_placas = tableDOM.rows[i].cells[5].innerHTML.trim() == "Si" ? true : false;
        			//setCampos( pgo, h_req, h_sob, h_tot, obs, ¿mismas_placas?, tipo_vuelta )
        			var stringFuncion = "setCampos(\'" + i + "\', \'" + tableDOM.rows[i].cells[1].innerHTML + "\', \'" + tableDOM.rows[i].cells[2].innerHTML + "\', \'" + tableDOM.rows[i].cells[3].innerHTML + "\', \'" + tableDOM.rows[i].cells[4].innerHTML + "\', \'" + vuelta_mismas_placas + "\', \'" + tableDOM.rows[i].cells[6].innerHTML + "\');";
        			tableDOM.rows[i].setAttribute("onclick",stringFuncion);
        			delete stringFuncion;
        		}
        	}
    	}
        
        limpiaPliego();
        
        delete numero_pliego;
        delete hojas_requeridas;
        delete hojas_sobrantes;
        delete hojas_totales;
        delete observaciones;
        delete vuelta_mismas_placas;
        delete tipo_vuelta;
        delete tableDOM;
    }
}


function agregaRegistro() {
    // NO BORRAR
    //var responseObject = { "name":"Gerardo", "calle":"Azucenas", "numero":25 }; // Este es un objeto.
    //var responseObject = { "arreglo":[{"name":"gerardo", "calle":"azucenas", "numero":25},{"name":"Sarah", "calle":"rue de prevoyants", "numero":25},{"name":"Lucia", "calle":"camarones", "numero":109}] };  // Este es un objeto con la estructura de un json
    //var responseObjectJSON = JSON.stringify( responseObject ); // Este es un json
    //console.log( responseObjectJSON );
    
    // definiciones de objetos en javascript
    function ListaObject() {
        this.pliegos = new Array();
    }
    
    function Pliego() {
        this.id_pliego                  = "";
        this.numero_decimal				= "";
        this.hojas_requeridas           = "";
        this.hojas_sobrantes            = "";
        this.hojas_totales              = "";
        this.observaciones              = "";
        this.vuelta_mismas_placas       = "";
        this.id_tipo_vuelta             = "";
    }
    
    // declaraciones
    var listaObject = new ListaObject();
    var tableDOM    = document.getElementById("tabla_hojas_pliego");
    
    for( var i=1; i<tableDOM.rows.length; i++ ) { // i=0 es el encabezado de la tabla
        var pliego = new Pliego();
        pliego.id_pliego            = tableDOM.rows[i].cells[0].innerHTML;
        pliego.hojas_requeridas     = tableDOM.rows[i].cells[1].innerHTML;
        pliego.hojas_sobrantes      = tableDOM.rows[i].cells[2].innerHTML;
        pliego.hojas_totales        = tableDOM.rows[i].cells[3].innerHTML;
        pliego.observaciones        = tableDOM.rows[i].cells[4].innerHTML;
        pliego.vuelta_mismas_placas = tableDOM.rows[i].cells[5].innerHTML.trim() == "Si" ? true : false ;
        $(document.getElementsByName("tipo_vuelta")[0].options).each( function(index, value){
			if ( tableDOM.rows[i].cells[6].innerHTML == $(this).text() ) {
				pliego.id_tipo_vuelta = $(this).val();
				return false;
			}
		} );
        /*// CUIDADO: NO FUNCIONA EN BROWSER ANTIGUOS
        for( var j=0; j<document.forms[0].tipo_vuelta.length; j++ ) {
            if( tableDOM.rows[i].cells[6].innerHTML == document.forms[0].tipo_vuelta.options[j].text ) {
                pliego.id_tipo_vuelta = document.forms[0].tipo_vuelta.options[j].value;
                break;
            }
        }
        */
        pliego.numero_decimal		= tableDOM.rows[i].cells[7].innerHTML;
        listaObject.pliegos.push( pliego );
        delete pliego;
    }
    //console.log( listaObject );
    //console.log( JSON.stringify( listaObject ) );
    document.forms["pliego"].elements["json"].value = JSON.stringify( listaObject );
    document.forms["pliego"].action = urlAgregaPliego;
    // cambia cursor
    document.body.style.cursor = "wait";
    delete listaObject;
    delete tableDOM;
    document.forms["pliego"].submit();
}


function actualizaHtml() {
    var res = frames["upload_target"].document.getElementsByTagName("body")[0].innerHTML;
    if( res != "" ) {
        document.body.style.cursor = "default";
        window.parent.document.getElementById("div_tabla_lista_pliegos").innerHTML = res;
        window.parent.cerradoOKVentanaListaPliegos = true; // variable global que se utiliza en: cotizador_ajax:ajaxAgregaDetallePartida();
        window.parent.Shadowbox.setup();
        window.parent.Shadowbox.close();
    }
}