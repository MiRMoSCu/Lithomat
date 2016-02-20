
function limpiaFechas() {
	
}

function generaExcel() {
	
}

function buscaRegistros() {
	var correcto = true;
	if ( correcto 
			&& ( document.busqueda_fecha_prensista_maquina.nut.value == "" 
				|| isNaN( document.busqueda_fecha_prensista_maquina.nut.value ) ) ) {
		correcto = false;
		alert("Favor de especificar el NUT");
		document.busqueda_fecha_prensista_maquina.nut.focus();
	}
	if ( correcto ) {
		// verifica que exista NUT
		document.body.style.cursor = "wait";
		$.ajax({
			type:'POST',
			url:urlExisteNut,
			data:{nut:document.busqueda_fecha_prensista_maquina.nut.value},
			success:function(response) {
				if ( response ) {
					// obtiene la lista de registros
					$.ajax({
						type:'POST',
						url:urlListaFechaPrensistaMaquina,
						data:{nut:document.busqueda_fecha_prensista_maquina.nut.value},
						succcess:function(response) {
							alert(response);
						},
						error:function(e) {
							
						}
					});
				} else {
					alert("NUT no encontrado; favor de verificarlo.");
					document.busqueda_fecha_prensista_maquina.nut.focus();
				}
			},
			error:function(e) {
				
			}
		});
	}
	
	delete correcto;
}

function limpiaTabla() {
	document.busqueda_fecha_prensista_maquina.nut.value = "";
	
	var table = document.createElement("table");
	table.setAttribute("id","tabla_fecha_prensista_maquina");
	var tr = document.createElement("tr");
	var td = document.createElement("th");
	td.innerHTML = "No.";
	tr.appendChild( td );
	
	td = document.createElement("th");
	td.innerHTML = "Prensista";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "T.Laboral";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "M&aacute;quina";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "F.Impresi&oacute;n";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "Ayudante";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "H.Buenas";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "H.Malas";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "H.Adicionales";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "H.Limpias";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "No.CambioPlacas";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "No.L&aacute;minasExtra";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "FrenteK.Tinta";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "VueltaK.Tinta";
	tr.appendChild(td);
	
	table.appendChild(tr);
	
	tr = document.createElement("tr");
	tr.setAttribute("class","l1");
	for ( var i=0; i<14; i++ ) {
		td = document.createElement("td");
		td.innerHTML = "&nbsp;";
		tr.appendChild(td);
	}
	table.appendChild(tr);
	
	document.getElementById("div_tabla_fecha_prensista_maquina").innerHTML = table.outerHTML;
	
	delete table;
	delete tr;
	delete td;
	delete i;
}