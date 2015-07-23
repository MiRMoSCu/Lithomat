/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
    $("#div_especificaciones_papel_tipo_flyer").addClass("activo");
    $("#div_especificaciones_papel_tipo_revista").hide();
    $("#div_especificaciones_papel_tipo_otro").hide();

    // listener radio boton
    var radioBotonAnterior = $("input[type='radio'][name='tipo_trabajo']:checked").val();

    $(":radio[name='tipo_trabajo']").click(function () {
        // busca el div class=activo 
        var radioBotonActual = event.currentTarget.value;
        var divActivo = $("#div_especificaciones_papel").find("div.activo");
        //alert( divActivo.parent().size() ); // busca dentro del objeto DOM
        if (radioBotonAnterior != radioBotonActual) {
            divActivo.slideUp("slow", function () {
                divActivo.removeClass("activo");
                //alert( 'name:' +  $('input[type=radio][name=tipo_trabajo]:checked').val() );
                if ($("input[type=radio][name='tipo_trabajo']:checked").val() == "1") {
                    $("#div_especificaciones_papel_tipo_flyer").addClass("activo");
                    $("#div_especificaciones_papel_tipo_flyer").slideDown("slow");
                    radioBotonAnterior = $("input[type=radio][name='tipo_trabajo']:checked").val();
                    document.getElementById("numero_paginas_publicacion").style.display = "none";
                    document.getElementById("tamanio_publicacion").style.display        = "none";
                    document.getElementById("repeticiones_flyer").style.display         = "block";
                    
                }
                else if ($("input[type=radio][name='tipo_trabajo']:checked").val() == "2") {
                    $("#div_especificaciones_papel_tipo_revista").addClass("activo");
                    $("#div_especificaciones_papel_tipo_revista").slideDown("slow");
                    radioBotonAnterior = $("input[type=radio][name='tipo_trabajo']:checked").val();
                    document.getElementById("repeticiones_flyer").style.display         = "none";
                    document.getElementById("numero_paginas_publicacion").style.display = "block";
                    document.getElementById("tamanio_publicacion").style.display        = "block";
                }
                else if ($("input[type=radio][name='tipo_trabajo']:checked").val() == "3") {
                    $("#div_especificaciones_papel_tipo_otro").addClass("activo");
                    $("#div_especificaciones_papel_tipo_otro").slideDown("slow");
                    radioBotonAnterior = $("input[type=radio][name='tipo_trabajo']:checked").val();
                    document.getElementById("repeticiones_flyer").style.display         = "none";
                    document.getElementById("numero_paginas_publicacion").style.display = "none";
                    document.getElementById("tamanio_publicacion").style.display        = "none";
                }

            });
        }
    });

    // listener recomendación ancho y alto 
    $("input[name='ancho_final']").focus(function () {
        $("#notificacion_tipo_growl").fadeIn(1500);
        //$("#notificacion_tipo_growl").fadeIn(1000).delay(5000).fadeOut(1000);
        //$("contenido").delay(10000);
        //$("#notificacion_tipo_growl").fadeOut(1000);
    });

    $("input[name='ancho_final']").focusout(function () {
        $("#notificacion_tipo_growl").fadeOut(1500);
        //$("#notificacion_tipo_growl").fadeIn(1000).delay(5000).fadeOut(1000);
        //$("contenido").delay(10000);
        //$("#notificacion_tipo_growl").fadeOut(1000);
    });

    $("#cerrar_notificacion_growl").click(function () {
        $("#notificacion_tipo_growl").fadeOut(1500);
        //alert("hola");
    });

});

/*************************************************************/

/* funciones */

function menu(obj) {
    // funcion utilizada en el menu de detalle por area, en las pestanias del menu
    switch( obj.id ) {
        case "div_pestania_menu_disenio":
            document.getElementById("div_pestania_menu_disenio").style.backgroundColor      = "#7FAADC";
            document.getElementById("div_pestania_menu_preprensa").style.backgroundColor    = "#E2E2E2";
            document.getElementById("div_pestania_menu_transporte").style.backgroundColor   = "#E2E2E2";
            document.getElementById("div_pestania_menu_acabado").style.backgroundColor 	    = "#E2E2E2";
            document.getElementById("div_pestania_menu_offset").style.backgroundColor       = "#E2E2E2";
            
            document.getElementById("div_pestania_contenido_disenio").style.display         = "block";
            document.getElementById("div_pestania_contenido_preprensa").style.display       = "none";
            document.getElementById("div_pestania_contenido_transporte").style.display      = "none";
            document.getElementById("div_pestania_contenido_acabado").style.display         = "none";
            document.getElementById("div_pestania_contenido_offset").style.display          = "none";
            break;
            
        case "div_pestania_menu_preprensa":
            document.getElementById("div_pestania_menu_disenio").style.backgroundColor      = "#E2E2E2";
            document.getElementById("div_pestania_menu_preprensa").style.backgroundColor    = "#7FAADC";
            document.getElementById("div_pestania_menu_transporte").style.backgroundColor   = "#E2E2E2";
            document.getElementById("div_pestania_menu_acabado").style.backgroundColor 	    = "#E2E2E2";
            document.getElementById("div_pestania_menu_offset").style.backgroundColor       = "#E2E2E2";
            
            document.getElementById("div_pestania_contenido_disenio").style.display         = "none";
            document.getElementById("div_pestania_contenido_preprensa").style.display       = "block";
            document.getElementById("div_pestania_contenido_transporte").style.display      = "none";
            document.getElementById("div_pestania_contenido_acabado").style.display         = "none";
            document.getElementById("div_pestania_contenido_offset").style.display          = "none";
            break;
            
        case "div_pestania_menu_transporte":
            document.getElementById("div_pestania_menu_disenio").style.backgroundColor      = "#E2E2E2";
            document.getElementById("div_pestania_menu_preprensa").style.backgroundColor    = "#E2E2E2";
            document.getElementById("div_pestania_menu_transporte").style.backgroundColor   = "#7FAADC";
            document.getElementById("div_pestania_menu_acabado").style.backgroundColor 	    = "#E2E2E2";
            document.getElementById("div_pestania_menu_offset").style.backgroundColor       = "#E2E2E2";
            
            document.getElementById("div_pestania_contenido_disenio").style.display         = "none";
            document.getElementById("div_pestania_contenido_preprensa").style.display       = "none";
            document.getElementById("div_pestania_contenido_transporte").style.display      = "block";
            document.getElementById("div_pestania_contenido_acabado").style.display         = "none";
            document.getElementById("div_pestania_contenido_offset").style.display          = "none";
            break;
            
        case "div_pestania_menu_acabado":
            document.getElementById("div_pestania_menu_disenio").style.backgroundColor      = "#E2E2E2";
            document.getElementById("div_pestania_menu_preprensa").style.backgroundColor    = "#E2E2E2";
            document.getElementById("div_pestania_menu_transporte").style.backgroundColor   = "#E2E2E2";
            document.getElementById("div_pestania_menu_acabado").style.backgroundColor 	    = "#7FAADC";
            document.getElementById("div_pestania_menu_offset").style.backgroundColor       = "#E2E2E2";
            
            document.getElementById("div_pestania_contenido_disenio").style.display         = "none";
            document.getElementById("div_pestania_contenido_preprensa").style.display       = "none";
            document.getElementById("div_pestania_contenido_transporte").style.display      = "none";
            document.getElementById("div_pestania_contenido_acabado").style.display         = "block";
            document.getElementById("div_pestania_contenido_offset").style.display          = "none";
            break;
            
        case "div_pestania_menu_offset":
            document.getElementById("div_pestania_menu_disenio").style.backgroundColor      = "#E2E2E2";
            document.getElementById("div_pestania_menu_preprensa").style.backgroundColor    = "#E2E2E2";
            document.getElementById("div_pestania_menu_transporte").style.backgroundColor   = "#E2E2E2";
            document.getElementById("div_pestania_menu_acabado").style.backgroundColor 	    = "#E2E2E2";
            document.getElementById("div_pestania_menu_offset").style.backgroundColor       = "#7FAADC";
            
            document.getElementById("div_pestania_contenido_disenio").style.display         = "none";
            document.getElementById("div_pestania_contenido_preprensa").style.display       = "none";
            document.getElementById("div_pestania_contenido_transporte").style.display      = "none";
            document.getElementById("div_pestania_contenido_acabado").style.display         = "none";
            document.getElementById("div_pestania_contenido_offset").style.display          = "block";
            break;
            
        default:
            break;
    }
}


function selectDisenioDetalleClick( obj ) {
    if( obj.selectedIndex != "-1" ) {
        document.forms["disenio_detalle"].elements["id_proceso_disenio"].value  = obj.options[obj.selectedIndex].value;
        document.forms["disenio_detalle"].elements["detalle"].value             = obj.options[obj.selectedIndex].text;
    }
} // selectDisenioDetalleClick()


function selectPreprensaDetalleClick( obj ) {
    if( obj.selectedIndex != "-1" ) {
        document.forms["preprensa_detalle"].elements["id_proceso_preprensa"].value  = obj.options[obj.selectedIndex].value;
        document.forms["preprensa_detalle"].elements["detalle"].value               = obj.options[obj.selectedIndex].text;
    }
} // selectPreprensaDetalleClick()


function selectTransporteDetalleClick( obj ) {
    if( obj.selectedIndex != "-1" ) {
        document.forms["transporte_detalle"].elements["id_proceso_transporte"].value    = obj.options[obj.selectedIndex].value;
        document.forms["transporte_detalle"].elements["detalle"].value                  = obj.options[obj.selectedIndex].text;
    }
} // selectTransporteDetalleClick()


function selectAcabadoDetalleClick( obj ) {
    if( obj.selectedIndex != "-1" ) {
        document.forms["acabado_detalle"].elements["id_proceso_externo"].value  = obj.options[obj.selectedIndex].value;
        document.forms["acabado_detalle"].elements["detalle"].value             = obj.options[obj.selectedIndex].text;
    }
} // selectAcabadoDetalleClick()

function buscaTipoPlaca( obj ) {
    var id = obj.options[obj.selectedIndex].value;
    $.ajax({
        type:"POST",
        url:urlBuscaTipoPlaca,
        data:{id_maquina:id},
        success:function( response ) {
            // jquery limpia select tipo_trabajo_detalle
            $("[name='select_tipo_placa']").empty();
            // parsea la informacion
            var jsonObject = JSON.parse( response.textoJson );
            $.each( jsonObject, function(i, item) {
                //alert( item.id_tipo_placa + ' ' + item.descripcion );
                var option = document.createElement("option");
                option.text     = item.descripcion;
                option.value    = item.id_tipo_placa;
                document.forms["tipo_trabajo_detalle"].elements["select_tipo_placa"].add( option );
                delete option;
            } );
            delete jsonObject;
        },
        error:function( response ) {
            alert("No fue posible cargar lista de placas por maquina");
        }
    });
    delete id;
} // buscaTipoPlaca











/*************************************************************/



function calculaHojas() {

    if ($("input[type=radio][name='tipo_trabajo']:checked").val() == "flyer") {
        var anchoFinal  = parseInt(document.getElementsByName("ancho_final")[0].value);
        var altoFinal   = parseInt(document.getElementsByName("alto_final")[0].value);
        if (anchoFinal != 0 && altoFinal != 0) {
            obtieneDatosPapel(document.getElementsByName("select_tipo_papel")[0].value);
        }
    }
    else if ($("input[type=radio][name='tipo_trabajo']:checked").val() == "revista") {

    }
    else if ($("input[type=radio][name='tipo_trabajo']:checked").val() == "otro") {

    }
} // calculaHojas()

/* NO BORRAR, funciones de prueba que pueden servir mas adelante */

function obtieneDatosPapel(id) {

    // aquí llamada ajax que regrese los datos del papel en formato JSON 
    //alert(id);
    var pliegoPapel = {
        "ancho" : "87", "alto" : "57"
    }
    //alert( datosPapel.ancho );
    if ($("input[type=radio][name='tipo_trabajo']:checked").val() == "flyer") {

        // Pasos para el calculo de papel de un flyer 
        //	1) conocer el ancho y alto del papel a utlizar.
        //	2) conocer el ancho y alto de cada volante.
        //	3) realizar el calculo de saber cuantos volantes caben en cada pliego de papel.
        //	4) al dividir cantidad de volantes totales entre la cantidad de volantes que tengo en cada pliego.
        //	 	el resultado es el numero total de pliegos que necesito.
        //	5) acercar el resultado al numero entero superior mas proximo.
        // PASO 1)
        var anchoPliegoPapel    = parseInt(pliegoPapel.ancho);
        var altoPliegoPapel     = parseInt(pliegoPapel.alto);

        // PASO 2)
        var anchoFinal  = parseInt(document.getElementsByName("ancho_final")[0].value);
        var altoFinal   = parseInt(document.getElementsByName("alto_final")[0].value);

        if (anchoFinal != 0 && altoFinal != 0) {
            // PASO 3)
            var numeroVolantesAnchoHorizontal   = Math.floor(anchoPliegoPapel / anchoFinal);
            var numeroVolantesAltoHorizontal    = Math.floor(altoPliegoPapel / altoFinal);
            var numeroVolantesHorizontal        = numeroVolantesAnchoHorizontal * numeroVolantesAltoHorizontal

            var numeroVolantesAnchoVertical     = Math.floor(anchoPliegoPapel / altoFinal);
            var numeroVolantesAltoVertical      = Math.floor(altoPliegoPapel / anchoFinal);
            var numeroVolantesVertical          = numeroVolantesAnchoVertical * numeroVolantesAltoVertical

            var numeroVolantesPorPliego         = numeroVolantesHorizontal > numeroVolantesVertical ? numeroVolantesHorizontal : numeroVolantesVertical;
            document.getElementsByName("numero_flyer_por_pliego")[0].value = numeroVolantesPorPliego;

            // PASO 4)
            var numeroVolantesTotal = parseInt(document.getElementsByName("cantidad")[0].value);
            var numeroHojasRequeridas = Math.ceil(numeroVolantesTotal / numeroVolantesPorPliego);
            document.getElementsByName("numero_hojas_requeridas_flyer")[0].value = numeroHojasRequeridas;
        }

    }
    else if ($("input[type=radio][name='tipo_trabajo']:checked").val() == "revista") {
        // cálculo de papel 
    }
    else if ($("input[type=radio][name='tipo_trabajo']:checked").val() == "otro") {
        // cálculo de papel 
    }

    sumaHTotalesHSobrantes();

}


function sumaHTotalesHSobrantes() {
    if( document.getElementsByName("hojas_requeridas")[0].value != "" &&
        document.getElementsByName("hojas_sobrantes")[0].value  != "" ) {
        var hojasTotales = parseInt(document.getElementsByName("hojas_requeridas")[0].value) + parseInt(document.getElementsByName("hojas_sobrantes")[0].value);
        document.getElementsByName("hojas_totales")[0].value = hojasTotales;
        delete hojasTotales;
    }
}

function buscaTrabajoDetalle( id_tipo_trabajo_detalle ) {
    // se usa en el resumen.
}