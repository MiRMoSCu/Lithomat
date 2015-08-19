/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos( id_tipo_papel_extendido, razon_social, nombre, gramaje, kilogramos, alto, ancho, descripcion, precio, nombre_precio ) {

    //Busqueda de proveedor_papel
    var select_proveedor = document.forms[0].id_proveedor_papel;
    var index_razon_social = 0;
    for (i = 0;i < select_proveedor.length;i++) {
        if (select_proveedor.options[i].innerText == razon_social) {
            index_razon_social = i;
            break;
        }
    }
    
    // busqueda de nombre_precio
    var select_precio = document.forms[0].id_tipo_precio;
    var index_precio = 0;
    for (i = 0;i < select_precio.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_precio );
        if (select_precio.options[i].innerText == nombre_precio) {
            index_precio = i;
            break;
        }
    }
    
    document.forms[0].id_tipo_papel_extendido.value     = id_tipo_papel_extendido;
    document.forms[0].id_proveedor_papel.selectedIndex  = index_razon_social;
    document.forms[0].nombre.value                      = nombre;
    document.forms[0].gramaje.value                     = gramaje;
    document.forms[0].kilogramos.value                  = kilogramos;
    document.forms[0].alto.value                        = alto;
    document.forms[0].ancho.value                       = ancho;
    document.forms[0].descripcion.value                 = descripcion;
    document.forms[0].precio.value                      = precio;
    document.forms[0].id_tipo_precio.selectedIndex      = index_precio;
}

function crear() {
    if (document.forms[0].nombre.value == "" 
     || document.forms[0].gramaje.value == ""
     || document.forms[0].kilogramos.value == ""
     || document.forms[0].alto.value == ""
     || document.forms[0].ancho.value == ""
     || document.forms[0].precio.value == "" )
        alert("Todos los campos son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].nombre.value == "" 
     || document.forms[0].gramaje.value == ""
     || document.forms[0].kilogramos.value == ""
     || document.forms[0].alto.value == ""
     || document.forms[0].ancho.value == ""
     || document.forms[0].precio.value == "")
        alert("Todos los campos son obligatorios, favor de informarlos.");
    else {
        document.forms[0].action = urlModifica;
        document.forms[0].submit();
    }
}

function elimina() {
    if (confirm(String.fromCharCode(191) + "Realmente desea eliminar este registro?")) {
        document.forms[0].action = urlElimina;
        document.forms[0].submit();
    }
}

function limpia() {
    document.forms[0].id_tipo_papel_extendido.value     = "";
    document.forms[0].id_proveedor_papel.selectedIndex  = 0;
    document.forms[0].nombre.value                      = "";
    document.forms[0].gramaje.value                     = "";
    document.forms[0].kilogramos.value                  = "";
    document.forms[0].alto.value                        = "";
    document.forms[0].ancho.value                       = "";
    document.forms[0].descripcion.value                 = "";
    document.forms[0].precio.value                      = "";
    document.forms[0].id_tipo_precio.selectedIndex      = 0;
}