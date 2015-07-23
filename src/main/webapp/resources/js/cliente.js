/*************************************************************/

/* jQuery */

$(document).ready(function () {

    // inicializacion
});

/*************************************************************/

/* funciones */
function setCampos( id_cliente, clave, nombre_moral, nombre_representante, puesto, calle, num_exterior, num_interior, colonia, delegacion_municipio, estado, codigo_postal, pais, rfc, telefono_particular, telefono_movil, email, observaciones ) {

    // busqueda de nombre_tipo_precio
    var select = document.forms[0].id_tipo_cliente;
    var index = 0;
    for (var i = 0;i < select.length;i++) {
        //alert( select.options[i].innerText + " " + nombre_tipo_precio );
        if (select.options[i].innerText == clave) {
            index = i;
            break;
        }
    }
    
    document.forms[0].id_cliente.value              = id_cliente;
    document.forms[0].id_tipo_cliente.selectedIndex = index;
    document.forms[0].nombre_moral.value            = nombre_moral;
    document.forms[0].nombre_representante.value    = nombre_representante;
    document.forms[0].puesto.value                  = puesto;
    document.forms[0].calle.value                   = calle;
    document.forms[0].num_exterior.value            = num_exterior;
    document.forms[0].num_interior.value            = num_interior;
    document.forms[0].colonia.value                 = colonia;
    document.forms[0].delegacion_municipio.value    = delegacion_municipio;
    document.forms[0].estado.value                  = estado;
    document.forms[0].codigo_postal.value           = codigo_postal;
    document.forms[0].pais.value                    = pais;
    document.forms[0].rfc.value                     = rfc;
    document.forms[0].telefono_particular.value     = telefono_particular;
    document.forms[0].telefono_movil.value          = telefono_movil;
    document.forms[0].email.value                   = email;
    document.forms[0].observaciones.value           = observaciones;
}

function crear() {
    if (document.forms[0].nombre_moral.value == "")
        alert("El campo nombre es obligatorio, favor de informarlo.");
    else {
        document.forms[0].action = urlAlta;
        document.forms[0].submit();
    }
}

function modifica() {
    if (document.forms[0].nombre_moral.value == "")
        alert("El campo nombre es obligatorio, favor de informarlo.");
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
    document.forms[0].id_cliente.value              = "";
    document.forms[0].id_tipo_cliente.selectedIndex = 0;
    document.forms[0].nombre_moral.value            = "";
    document.forms[0].nombre_representante.value    = "";
    document.forms[0].puesto.value                  = "";
    document.forms[0].calle.value                   = "";
    document.forms[0].num_exterior.value            = "";
    document.forms[0].num_interior.value            = "";
    document.forms[0].colonia.value                 = "";
    document.forms[0].delegacion_municipio.value    = "";
    document.forms[0].estado.value                  = "";
    document.forms[0].codigo_postal.value           = "";
    document.forms[0].pais.value                    = "";
    document.forms[0].rfc.value                     = "";
    document.forms[0].telefono_particular.value     = "";
    document.forms[0].telefono_movil.value          = "";
    document.forms[0].email.value                   = "";
    document.forms[0].observaciones.value           = "";
}