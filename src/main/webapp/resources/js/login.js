/** jQuery **/

$(document).ready(function () {
    $("input[name='contrasenia']").focus(function () {
        $(this).val("");
        $(this).get(0).type = "password";
    });

    $("input[name='contrasenia']").focusout(function () {
        var value = $(this).val();
        if (value == '') {
            $(this).get(0).type = "text";
            $(this).val("Contrase\u00F1a");
        }
    });

});

/** javascript **/

function getWindowHeight() {
    var windowHeight = 0;
    if (typeof (window.innerHeight) == "number") {
        windowHeight = window.innerHeight;
    }
    else {
        if (document.documentElement && document.documentElement.clientHeight) {
            windowHeight = document.documentElement.clientHeight;
        }
        else {
            if (document.body && document.body.clientHeight) {
                windowHeight = document.body.clientHeight;
            }
        }
    }
    return windowHeight;
}

function setContent() {
    if (document.getElementById) {
        var windowHeight = getWindowHeight();
        if (windowHeight > 0) {
            var contentElement = document.getElementById("div_login");// Aqui se coloca el ID del elemento a centrar en la pagina
            var contentHeight = contentElement.offsetHeight;
            if (windowHeight - contentHeight > 0) {
                contentElement.style.position = "relative";
                contentElement.style.top = ((windowHeight / 2) - (contentHeight / 2)) + "px";
            }
            else {
                contentElement.style.position = "static";
            }
        }
    }
}

window.onload = function () {
    setContent();
}

window.onresize = function () {
    setContent();
}

function revisaUsuario(obj) {
    if (obj.value == "")
        obj.value = "Usuario";
}

function revisaContrasenia(obj) {
    if (obj.value == "")
        obj.value = "Contrase–a";
}

function enviaFormulario() {
    //document.location.href = "/cotizador/cotizador.html";
    if( document.forms["login"].elements["usuario"].value == "Usuario" ||
        document.forms["login"].elements["contrasenia"].value == "Contrase–a" ||
        document.forms["login"].elements["contrasenia"].value == "Contrase\u00F1a" ) {
            alert("Favor de informar los campos de Usuario y Contrase\u00F1a.");
        } else {
            document.forms[0].submit();
        }
}