
function cerrarVentana() {
	window.parent.Shadowbox.close();
}

function limpiarFormulario() {
	document.cambio_contrasenia.contrasenia1.value = "";
	document.cambio_contrasenia.contrasenia2.value = "";
}

function enviarFormulario() {
	// validaciones
	var correcto = true;
	if ( correcto
			&& document.cambio_contrasenia.contrasenia1.value == "" ) {
		correcto = false;
		alert("Debe escribir la nueva contrase\u00f1a por duplicado");
		document.cambio_contrasenia.contrasenia1.focus();
	}
	
	if ( correcto
			&& document.cambio_contrasenia.contrasenia2.value == "" ) {
		correcto = false;
		alert("Debe escribir la nueva contrase\u00f1a por duplicado");
		document.cambio_contrasenia.contrasenia2.focus();
	}
	if ( correcto
			&& document.cambio_contrasenia.contrasenia1.value != document.cambio_contrasenia.contrasenia2.value ) {
		correcto = false;
		alert("La contrase\u00f1a no coincide");
		limpiarFormulario();
		document.cambio_contrasenia.contrasenia1.focus();
	}
	if ( correcto ) {
		document.body.style.cursor = "wait";
		$.ajax({
			type:'POST',
			url:urlCambioContrasenia,
			data:{contrasenia:document.cambio_contrasenia.contrasenia1.value},
			success:function(response) {
				if (response)
					window.parent.Shadowbox.close();
			},
			error:function(e) {
				document.body.style.cursor = "default";
				alert("Problemas de comunicacion con el servidor.");
			}
		});
	}
	delete correcto;
}

