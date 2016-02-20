
function limpiaFechas() {
	
}

function generaExcel() {
	
}

function buscaRegistros() {
	alert("busca registros");
}

function limpiaTabla() {
	document.busqueda_Fecha_prensista_maquina.nut.value = "";
	
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
		console.log(i);
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