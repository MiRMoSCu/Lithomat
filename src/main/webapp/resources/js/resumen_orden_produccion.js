
Number.prototype.formatMoney = function(c, d, t){
var n = this, 
    c = isNaN(c = Math.abs(c)) ? 2 : c, 
    d = d == undefined ? "." : d, 
    t = t == undefined ? "," : t, 
    s = n < 0 ? "-" : "", 
    i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", 
    j = (j = i.length) > 3 ? j % 3 : 0;
   return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
};


function convertDate(inputFormat) {
  function pad(s) { return (s < 10) ? '0' + s : s; }
  var d = new Date(inputFormat);
  return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
}


function limpiaFormPartidaSubpartida() {
    document.forms["detalle_partida"].elements["tipo_trabajo"].value            = "";
    document.forms["detalle_partida"].elements["nombre_partida"].value          = "";
    document.forms["detalle_partida"].elements["cantidad"].value                = "";
    document.forms["detalle_partida"].elements["descripcion_partida"].value     = "";
    document.forms["detalle_partida"].elements["disenio_coste_total"].value     = "";
    document.forms["detalle_partida"].elements["preprensa_coste_total"].value   = "";
    document.forms["detalle_partida"].elements["transporte_coste_total"].value  = "";
    document.forms["detalle_partida"].elements["acabado_coste_total"].value     = "";
    document.forms["detalle_partida"].elements["offset_coste_total"].value      = "";
    document.forms["detalle_partida"].elements["subtotal_partida"].value        = "";
    
    document.forms["detalle_subpartida"].elements["descripcion"].value                          = "";
    document.forms["detalle_subpartida"].elements["papel_coste_total"].value                    = "";
    document.forms["detalle_subpartida"].elements["tinta_coste_total"].value                    = "";
    document.forms["detalle_subpartida"].elements["tinta_especial_coste_total"].value           = "";
    document.forms["detalle_subpartida"].elements["frente_barniz_coste_total"].value            = "";
    document.forms["detalle_subpartida"].elements["vuelta_barniz_coste_total"].value            = "";
    document.forms["detalle_subpartida"].elements["placas_coste_total"].value                   = "";
    document.forms["detalle_subpartida"].elements["subtotal_subpartida"].value                  = "";
    document.forms["detalle_subpartida"].elements["detalle_papel_coste_total"].value            = "";
    document.forms["detalle_subpartida"].elements["detalle_tinta_coste_total"].value            = "";
    document.forms["detalle_subpartida"].elements["detalle_tinta_especial_coste_total"].value   = "";
    document.forms["detalle_subpartida"].elements["detalle_frente_barniz_coste_total"].value    = "";
    document.forms["detalle_subpartida"].elements["detalle_vuelta_barniz_coste_total"].value    = "";
    document.forms["detalle_subpartida"].elements["detalle_placas_coste_total"].value           = "";
}


function genera_tabla( strJson ) {

    var objJson = JSON.parse( strJson );
    console.log( objJson );

    // llena campos resumen
    document.forms["calificacion_orden_produccion"].elements["nombre"].value                = objJson.nombre;
    document.forms["calificacion_orden_produccion"].elements["nut"].value                   = objJson.nut;
    document.forms["calificacion_orden_produccion"].elements["fecha_generacion"].value      = convertDate(objJson.fecha_generacion);
    document.forms["calificacion_orden_produccion"].elements["descripcion"].value           = objJson.descripcion;
    document.forms["calificacion_orden_produccion"].elements["nombre_moral"].value          = objJson.nombre_moral;
    document.forms["calificacion_orden_produccion"].elements["nombre_representante"].value  = objJson.nombre_representante;
    document.forms["calificacion_orden_produccion"].elements["precio_bruto"].value          = "$ " + (objJson.precio_bruto).formatMoney(2);
    document.forms["calificacion_orden_produccion"].elements["precio_cliente"].value        = "$ " + (objJson.precio_cliente).formatMoney(2);
    document.forms["calificacion_orden_produccion"].elements["precio_neto"].value           = "$ " + (objJson.precio_neto).formatMoney(2);
    
    // formacion del json dela arbol con los datos necesarios
    /*
     * [
     *  {   
     *      "id":"1",
     *      "text":"Orden Produccion",
     *      "state":{"opened":true},
     *      "children":[
     *          {   
     *              "id":"1.2",
     *              "text":"Partida 1",
     *              "children":[
     *                  {   
     *                      "id":"1.2.1",
     *                      "text":"Subpartida 1"
     *                  },{ 
     *                      "id":"1.2.2",
     *                      "text":"Subpartida 2"
     *                  }
     *              ]
     *          },{
     *              "id":"1.3",
     *              "text":"Partida 2"
     *          },{
     *              "id":"1.4",
     *              "text":"Partida 3"
     *          }
     *          
     *      ]
     *  }
     * ]
     */
    // variable json con datos del arbol
    //var jsonTreeString_2 = '[{"id":"1","text":"Orden Produccion","state":{"opened":true},"children":[{"id":"1.2","text":"Partida 1","children":[{"id":"1.2.1","text":"Subpartida 1"},{"id":"1.2.2","text":"Subpartida 2"}]},{"id":"1.3","text":"Partida 2"},{"id":"1.4","text":"Partida 3"},{"id":"1.5","text":"Partida 4"},{"id":"1.6","text":"Partida 5"},{"id":"1.7","text":"Partida 6"},{"id":"1.8","text":"Partida 7"},{"id":"1.9","text":"Partida 8"}]}]';
    
    // generacion json con datos del arbol
    var jsonTreeString = "[{";
    jsonTreeString += "\"id\":\"OrdProdId:"+ objJson.id_orden_produccion + "\",";
    jsonTreeString += "\"text\":\"Orden de Produccion\",";
    jsonTreeString += "\"state\":{\"opened\":true},";
    jsonTreeString += "\"children\":[";
    //alert( objJson.partidas.length );
    for(var i=0; i < objJson.partidas.length; i++) {
        jsonTreeString += "{";
        jsonTreeString += "\"id\":\"IndicePartida:" + i + "\",";
        jsonTreeString += "\"text\":\"" + objJson.partidas[i].nombre_partida + "\",";
        jsonTreeString += "\"children\":[";
        for( var j=0; j < objJson.partidas[i].subpartidas.length; j++ ) {
            jsonTreeString += "{";
            jsonTreeString += "\"id\":\"IndiceSubpartida:" + i + ":" + j + "\",";
            jsonTreeString += "\"text\":\"" + objJson.partidas[i].subpartidas[j].descripcion + "\"";
            jsonTreeString += "}";
            if( j+1 < objJson.partidas[i].subpartidas.length )
                jsonTreeString += ",";
        }
        jsonTreeString += "]";
        jsonTreeString += "}";
        if( i+1 < objJson.partidas.length )
            jsonTreeString += ",";
    }
    jsonTreeString += "]";
    jsonTreeString = jsonTreeString + "}]";
    //alert( jsonTreeString );
    //console.log( JSON.parse(jsonTreeString) );
    
    // genera arbol
    $("#arbol_partidas")
        .on("changed.jstree", function(e, data){
            if( data.selected.length ) {
                //console.log( data );
                //alert( data.instance.get_node( data.selected[0] ).id );
                var identificador = "" + data.instance.get_node( data.selected[0] ).id + "";
                var arreglo = identificador.split(":");
                //alert( arreglo.length );
                
                if( arreglo[0] == "IndicePartida" ) {
                    
                } else if( arreglo[0] == "IndiceSubpartida" ) {
                
                    // completa campos de PARTIDA
                    document.forms["detalle_partida"].elements["tipo_trabajo"].value            = objJson.partidas[ arreglo[1] ].nombre_tipo_trabajo;
                    document.forms["detalle_partida"].elements["nombre_partida"].value          = objJson.partidas[ arreglo[1] ].nombre_partida;
                    document.forms["detalle_partida"].elements["cantidad"].value                = (objJson.partidas[ arreglo[1] ].cantidad).formatMoney(0);
                    document.forms["detalle_partida"].elements["descripcion_partida"].value     = objJson.partidas[ arreglo[1] ].descripcion;
                    document.forms["detalle_partida"].elements["disenio_coste_total"].value     = "$ " + (objJson.partidas[ arreglo[1] ].disenio_coste_total).formatMoney(2);
                    document.forms["detalle_partida"].elements["preprensa_coste_total"].value   = "$ " + (objJson.partidas[ arreglo[1] ].preprensa_coste_total).formatMoney(2);
                    document.forms["detalle_partida"].elements["transporte_coste_total"].value  = "$ " + (objJson.partidas[ arreglo[1] ].transporte_coste_total).formatMoney(2);
                    document.forms["detalle_partida"].elements["acabado_coste_total"].value     = "$ " + (objJson.partidas[ arreglo[1] ].acabado_coste_total).formatMoney(2);
                    document.forms["detalle_partida"].elements["offset_coste_total"].value      = "$ " + (objJson.partidas[ arreglo[1] ].offset_coste_total).formatMoney(2);
                    
                    var sumatoria_partida = objJson.partidas[ arreglo[1] ].disenio_coste_total + 
                                            objJson.partidas[ arreglo[1] ].preprensa_coste_total + 
                                            objJson.partidas[ arreglo[1] ].transporte_coste_total + 
                                            objJson.partidas[ arreglo[1] ].acabado_coste_total + 
                                            objJson.partidas[ arreglo[1] ].offset_coste_total;
                    
                    document.forms["detalle_partida"].elements["subtotal_partida"].value        = "$ " + (sumatoria_partida).formatMoney(2);
                    
                    // llena campos DETALLE de partida
                    
                    // completa campos de SUBPARTIDA
                    document.forms["detalle_subpartida"].elements["descripcion"].value                  = objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].descripcion;
                    document.forms["detalle_subpartida"].elements["papel_coste_total"].value            = "$ " + ( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].papel_coste_total ).formatMoney(2);
                    document.forms["detalle_subpartida"].elements["tinta_coste_total"].value            = "$ " + ( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].tinta_coste_total ).formatMoney(2);
                    document.forms["detalle_subpartida"].elements["tinta_especial_coste_total"].value   = "$ " + ( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].tinta_especial_coste_total ).formatMoney(2);
                    document.forms["detalle_subpartida"].elements["frente_barniz_coste_total"].value    = "$ " + ( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].frente_barniz_coste_total ).formatMoney(2);
                    document.forms["detalle_subpartida"].elements["vuelta_barniz_coste_total"].value    = "$ " + ( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].vuelta_barniz_coste_total ).formatMoney(2);
                    document.forms["detalle_subpartida"].elements["placas_coste_total"].value           = "$ " + ( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].placas_coste_total ).formatMoney(2);
                    
                    var sumatoria_subpartida = 0;
                    // papel
                    if( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].cliente_proporciona_papel ) 
                        document.forms["detalle_subpartida"].elements["papel_coste_total"].style.textDecoration = "line-through";
                    else
                        sumatoria_subpartida += objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].papel_coste_total;
                    
                    // tinta
                    if( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].cliente_proporciona_tinta )
                        document.forms["detalle_subpartida"].elements["tinta_coste_total"].style.textDecoration = "line-through";
                    else
                        sumatoria_subpartida += objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].tinta_coste_total;
                
                    // tinta especial
                    if( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].cliente_proporciona_tinta_especial )
                        document.forms["detalle_subpartida"].elements["tinta_especial_coste_total"].style.textDecoration = "line-through";
                    else
                        sumatoria_subpartida += objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].tinta_especial_coste_total;
                    
                    // barniz
                    if( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].cliente_proporciona_barniz ) {
                        document.forms["detalle_subpartida"].elements["frente_barniz_coste_total"].style.textDecoration = "line-through";
                        document.forms["detalle_subpartida"].elements["vuelta_barniz_coste_total"].style.textDecoration = "line-through";
                    } else {
                        sumatoria_subpartida += objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].frente_barniz_coste_total;
                        sumatoria_subpartida += objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].vuelta_barniz_coste_total;
                    }
                    
                    // placas
                    if( objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].cliente_proporciona_placas )
                        document.forms["detalle_subpartida"].elements["placas_coste_total"].style.textDecoration = "line-through";
                    else
                        sumatoria_subpartida += objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].placas_coste_total;
                    
                        
                    document.forms["detalle_subpartida"].elements["subtotal_subpartida"].value          = "$ " + (sumatoria_subpartida).formatMoney(2);
                    delete sumatoria_subpartida;
                    
                    // llena campos DETALLE de subpartida
                    var texto = "";
                    texto = "Cantidad total: " + (objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].papel_cantidad_total).formatMoney(0) + "; ";
                    texto += "Precio unitario: $" + (objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].papel_precio_unitario).formatMoney(5);
                    document.forms["detalle_subpartida"].elements["detalle_papel_coste_total"].value = texto;
                    
                    texto = "";
                    texto = "Entradas m\u00e1quina: " + objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].tinta_num_ent_maq + "; ";
                    texto += "Precio unitario: $" + (objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].tinta_precio_unitario).formatMoney(5);
                    document.forms["detalle_subpartida"].elements["detalle_tinta_coste_total"].value = texto;
                    
                    texto = "";
                    texto = "Entradas m\u00e1quina: " + objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].tinta_especial_num_ent_maq + "; ";
                    texto += "Precio unitario: $" + (objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].tinta_especial_precio_unitario).formatMoney(5);
                    document.forms["detalle_subpartida"].elements["detalle_tinta_especial_coste_total"].value = texto;
                    
                    texto = "";
                    texto = "Entradas m\u00e1quina: " + objJson.partidas[ arreglo[1] ].subpartidas[arreglo[2] ].frente_barniz_num_ent_maq + "; ";
                    texto += "Precio unitario: $" + (objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].frente_barniz_precio_unitario).formatMoney(5);
                    document.forms["detalle_subpartida"].elements["detalle_frente_barniz_coste_total"].value = texto;
                    
                    texto = "";
                    texto = "Entradas m\u00e1quina: " + objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].vuelta_barniz_num_ent_maq + "; ";
                    texto += "Precio unitario: $" + (objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].vuelta_barniz_precio_unitario).formatMoney(5);
                    document.forms["detalle_subpartida"].elements["detalle_vuelta_barniz_coste_total"].value = texto;
                    
                    texto = "";
                    texto = "N\u00famero placas: " + objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].placas_num_placas + "; ";
                    texto += "Precio unitario: $" + (objJson.partidas[ arreglo[1] ].subpartidas[ arreglo[2] ].placas_precio_unitario).formatMoney(2);
                    document.forms["detalle_subpartida"].elements["detalle_placas_coste_total"].value = texto;
                    
                    delete texto;
                }
            }
        })
        .jstree({
            "core":{
                "data":JSON.parse(jsonTreeString)
            }
        });
    
    /*
    //tr titulo
    tr = document.createElement("tr");
    tr.setAttribute("class","titulo_tabla");
    
    th = document.createElement("th");
    th.colSpan = "8";
    th.innerHTML = "ORDEN DE PRODUCCI&Oacute;N";
    tr.appendChild( th );
    
    table.appendChild( tr );
    */    
}