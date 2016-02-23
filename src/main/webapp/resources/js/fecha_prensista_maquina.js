
function limpiaFechas() {
	
}

function generaExcel() {
	
}

function generaTablaDOM( jsonFechaPrensistaMaquina ) {
	console.log( jsonFechaPrensistaMaquina );
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
	td.innerHTML = "H.Requeridas";
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
	
	var generaRegistroVacio = false;
	if ( jsonFechaPrensistaMaquina != null ) {
		if ( jsonFechaPrensistaMaquina.length > 0 ) {
			$.each( jsonFechaPrensistaMaquina, function(i,item){
				tr = document.createElement("tr");
				tr.setAttribute("class","l1");
				
				// no.
				td = document.createElement("td");
	            td.innerHTML = (i + 1);
	            tr.appendChild( td );
				// prensista
	            td = document.createElement("td");
	            td.innerHTML = item.prensista;
	            tr.appendChild( td );
				// turno laboral
	            td = document.createElement("td");
	            td.innerHTML = item.turnoLaboral;
	            tr.appendChild( td );
				// maquina
	            td = document.createElement("td");
	            td.innerHTML = item.maquina;
	            tr.appendChild( td );
				// fecha impresion
	            td = document.createElement("td");
	            td.innerHTML = item.fechaImpresion;
	            tr.appendChild( td );
				// ayudante
	            td = document.createElement("td");
	            td.innerHTML = item.prensistaAyudante;
	            tr.appendChild( td );
				// hojas requeridas
	            td = document.createElement("td");
	            td.innerHTML = item.hojasRequeridas;
	            tr.appendChild( td );
				// hojas buenas
	            td = document.createElement("td");
	            td.innerHTML = item.hojasBuenas;
	            tr.appendChild( td );
				// hojas malas
	            td = document.createElement("td");
	            td.innerHTML = item.hojasMalas;
	            tr.appendChild( td );
				// hojas adicionales
	            td = document.createElement("td");
	            td.innerHTML = item.hojasAdicionales;
	            tr.appendChild( td );
				// hojas limpias
	            td = document.createElement("td");
	            td.innerHTML = item.hojasLimpias;
	            tr.appendChild( td );
				// no. cambio placas
	            td = document.createElement("td");
	            td.innerHTML = item.cambioPlacas;
	            tr.appendChild( td );
				// no. laminas extra
	            td = document.createElement("td");
	            td.innerHTML = item.laminasExtra;
	            tr.appendChild( td );
				// frente kilos tinta
	            td = document.createElement("td");
	            td.innerHTML = item.frenteKilosTinta;
	            tr.appendChild( td );
				// vuelta kilos tinta
	            td = document.createElement("td");
	            td.innerHTML = item.vueltaKilosTinta;
	            tr.appendChild( td );
	            
	            table.appendChild( tr );
			} );
		} else 
			generaRegistroVacio = true;
	} else 
		generaRegistroVacio = true;
	
	if ( generaRegistroVacio ) {
		tr = document.createElement("tr");
		tr.setAttribute("class","l1");
		for ( var i=0; i<15; i++ ) {
			td = document.createElement("td");
			td.innerHTML = "&nbsp;";
			tr.appendChild(td);
		}
		table.appendChild(tr);
	}
	
	document.getElementById("div_tabla_fecha_prensista_maquina").innerHTML = table.outerHTML;
	delete table;
	delete tr;
	delete td;
	delete i;
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
						success:function(response) {
							var jsonResponse = JSON.parse(response);
							console.log(jsonResponse);
							generaTablaDOM( jsonResponse.listaFechaPrensistaMaquina );
							document.body.style.cursor = "default";
						},
						error:function(e) {
							document.body.style.cursor = "default";
							alert("Problemas de conexión con el servidor.");
						}
					});
				} else {
					document.body.style.cursor = "default";
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
	generaTablaDOM(null);
}