
function limpiaFechasExcel() {
	document.busqueda_concentrado_excel.fecha_excel_inicio.value 	= "";
	document.busqueda_concentrado_excel.fecha_excel_fin.value 		= "";
}

function generaExcel() {
	var correcto = true;
	
	if  ( correcto
			&& ( document.busqueda_concentrado_excel.fecha_excel_inicio.value == "" 
				|| document.busqueda_concentrado_excel.fecha_excel_fin.value == "" ) ) {
		correcto = false;
		alert("Favor de especificar las fechas correctamente");
		if ( document.busqueda_concentrado_excel.fecha_excel_inicio.value == "" 
			&& document.busqueda_concentrado_excel.fecha_excel_fin.value == "" )
			document.busqueda_concentrado_excel.fecha_excel_inicio.focus();
		else if ( document.busqueda_concentrado_excel.fecha_excel_inicio.value == "" )
			document.busqueda_concentrado_excel.fecha_excel_inicio.focus();
		else
			document.busqueda_concentrado_excel.fecha_excel_fin.focus();
	}
	
	if ( correcto
			&& (new Date(document.busqueda_concentrado_excel.fecha_excel_fin.value) < new Date(document.busqueda_concentrado_excel.fecha_excel_inicio.value) ) ) {
		correcto = false;
		alert("La fecha de busqueda inicial deber ser menor a la fecha de busqueda final");
		limpiaFechasExcel();
		document.busqueda_concentrado_excel.fecha_excel_inicio.focus();
	}
	
	if ( correcto )
		location.href = urlExportaReporte 
						+ "?fecha_excel_inicio=" + document.busqueda_concentrado_excel.fecha_excel_inicio.value 
						+ "&fecha_excel_fin=" + document.busqueda_concentrado_excel.fecha_excel_fin.value;
}

function generaTablaDOM( jsonFechaPrensistaMaquina ) {
	//console.log( jsonFechaPrensistaMaquina );
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
	td.innerHTML = "FrenteK.TintaCyan";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "FrenteK.TintaMagenta";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "FrenteK.TintaYellow";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "FrenteK.TintaBlack";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "VueltaK.TintaCyan";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "VueltaK.TintaMagenta";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "VueltaK.TintaYellow";
	tr.appendChild(td);
	
	td = document.createElement("th");
	td.innerHTML = "VueltaK.TintaBlack";
	tr.appendChild(td);
	
	table.appendChild(tr);
	
	var generaRegistroVacio = false;
	if ( jsonFechaPrensistaMaquina != null ) {
		if ( jsonFechaPrensistaMaquina.length > 0 ) {
			$.each( jsonFechaPrensistaMaquina, function(i,item){
				tr = document.createElement("tr");
				tr.setAttribute("class",i%2==0?"l1":"l2");
				
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
				// frente kilos tinta cyan
	            td = document.createElement("td");
	            td.innerHTML = item.frenteKilosTintaCyan;
	            tr.appendChild( td );
	            // frente kilos tinta magenta
	            td = document.createElement("td");
	            td.innerHTML = item.frenteKilosTintaMagenta;
	            tr.appendChild( td );
	            // frente kilos tinta yellow
	            td = document.createElement("td");
	            td.innerHTML = item.frenteKilosTintaYellow;
	            tr.appendChild( td );
	            // frente kilos tinta black
	            td = document.createElement("td");
	            td.innerHTML = item.frenteKilosTintaBlack;
	            tr.appendChild( td );
				// vuelta kilos tinta cyan
	            td = document.createElement("td");
	            td.innerHTML = item.vueltaKilosTintaCyan;
	            tr.appendChild( td );
	            // vuelta kilos tinta magenta
	            td = document.createElement("td");
	            td.innerHTML = item.vueltaKilosTintaMagenta;
	            tr.appendChild( td );
	            // vuelta kilos tinta yellow
	            td = document.createElement("td");
	            td.innerHTML = item.vueltaKilosTintaYellow;
	            tr.appendChild( td );
	            // vuelta kilos tinta black
	            td = document.createElement("td");
	            td.innerHTML = item.vueltaKilosTintaBlack;
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
		for ( var i=0; i<21; i++ ) {
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

function busquedaFechaPrensistaMaquina(){
	$.ajax({
		type:"POST",
		url:urlListaFechaPrensistaMaquina,
		data:$("[name='busqueda_fecha_prensista_maquina']").serialize(),
		success:function(response){
			var jsonResponse = JSON.parse(response);
			//console.log(jsonResponse);
			generaTablaDOM( jsonResponse.listaFechaPrensistaMaquina );
			document.body.style.cursor = "default";
		},
		error:function(e){
			console.log(e);
			alert("No fue posible realizar la consulta");
			document.body.style.cursor = "default";
		}
	});
}


function buscaRegistros() {
	var correcto = true;
	
	// valida nut
	if ( correcto
			&& document.busqueda_fecha_prensista_maquina.chkbx_busca_por_nut.checked
			&& ( document.busqueda_fecha_prensista_maquina.nut.value == "" 
				|| isNaN( document.busqueda_fecha_prensista_maquina.nut.value ) ) ) {
		correcto = false;
		alert("Favor de especificar el NUT");
		document.busqueda_fecha_prensista_maquina.nut.focus();
	}
	
	// valida fecha
	if ( correcto 
			&& document.busqueda_fecha_prensista_maquina.chkbx_busca_por_fecha.checked
			&& ( document.busqueda_fecha_prensista_maquina.fecha_busqueda_inicio.value == ""
				|| document.busqueda_fecha_prensista_maquina.fecha_busqueda_fin.value == "" ) ) {
		correcto = false;
		alert("Favor de especificar correctamente ambas fechas");
		if ( document.busqueda_fecha_prensista_maquina.fecha_busqueda_inicio.value == "" 
			&& document.busqueda_fecha_prensista_maquina.fecha_busqueda_fin.value == "" )
			document.busqueda_fecha_prensista_maquina.fecha_busqueda_inicio.focus();
		else if ( document.busqueda_fecha_prensista_maquina.fecha_busqueda_inicio.value == "" )
			document.busqueda_fecha_prensista_maquina.fecha_busqueda_inicio.focus();
		else
			document.busqueda_fecha_prensista_maquina.fecha_busqueda_fin.focus();
	}
	
	if ( correcto ) {
		// verifica que exista NUT
		document.body.style.cursor = "wait";
		if ( document.busqueda_fecha_prensista_maquina.chkbx_busca_por_nut.checked ) { // busca por nut
			$.ajax({
				type:'POST',
				url:urlExisteNut,
				data:{nut:document.busqueda_fecha_prensista_maquina.nut.value},
				success:function(response){
					if ( response ) {
						busquedaFechaPrensistaMaquina();
					}
				},
				error:function(e){
					document.body.style.cursor = "default";
					alert("NUT no encontrado; favor de verificarlo.");
					document.busqueda_fecha_prensista_maquina.nut.focus();
				}
			});
		} else  // busca por otros campos que no sean nut //console.log( $("[name='busqueda_fecha_prensista_maquina']").serialize() );
			busquedaFechaPrensistaMaquina();
	}
	
	delete correcto;
}

function limpiaCriteriosBusqueda() {
	// limpia checkbox
	document.busqueda_fecha_prensista_maquina.chkbx_busca_por_nut.checked 		= false;
	document.busqueda_fecha_prensista_maquina.chkbx_busca_por_fecha.checked 	= false;
	document.busqueda_fecha_prensista_maquina.chkbx_busca_por_prensista.checked = false;
	document.busqueda_fecha_prensista_maquina.chkbx_busca_por_maquina.checked 	= false;
	// limpia input
	document.busqueda_fecha_prensista_maquina.nut.value 					= "";
	document.busqueda_fecha_prensista_maquina.fecha_busqueda_inicio.value 	= "";
	document.busqueda_fecha_prensista_maquina.fecha_busqueda_fin.value 		= "";
	document.busqueda_fecha_prensista_maquina.id_prensista.selectedIndex 	= 0;
	document.busqueda_fecha_prensista_maquina.id_maquina.selectedIndex 		= 0;
	
	generaTablaDOM(null);
}