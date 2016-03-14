
var obj_ttd = {
	
	descripcion_partida_detalle			: "",
	alto_final 							: "",
	ancho_final 						: "",
	alto_extendido 						: "",
	ancho_extendido 					: "",
	proporciona_papel 					: "",
	proporciona_placas 					: "",
	proporciona_tinta_especial 			: "",
	proporciona_barniz 					: "",
	tipo_papel 							: "",
	repeticiones_x_pliego 				: "",
	numero_paginas_publicacion 			: "",
	tamanio_publicacion 				: "",
	alto_corte_inicial					: "",
	ancho_corte_inicial					: "",
	frente_combinacion_tintas 			: "",
	frente_num_tinta_especial 			: "",
	frente_descripcion_tinta_especial 	: "",
	frente_tipo_barniz 					: "",
	vuelta_combinacion_tintas 			: "",
	vuelta_num_tinta_especial 			: "",
	vuelta_descripcion_tinta_especial 	: "",
	vuelta_tipo_barniz 					: "",
	maquina 							: "",
	tipo_placa 							: "",
	tipo_complejidad					: "",
	listaIdPliegoEliminado				: "",
	htmlListaPliegos					: "",
		
	setObjTTD : function() {
		this.descripcion_partida_detalle		= document.tipo_trabajo_detalle.descripcion_partida_detalle.value;
		this.alto_final 						= document.tipo_trabajo_detalle.alto_final.value;
		this.ancho_final 						= document.tipo_trabajo_detalle.ancho_final.value;
		this.alto_extendido 					= document.tipo_trabajo_detalle.alto_extendido.value;
		this.ancho_extendido 					= document.tipo_trabajo_detalle.ancho_extendido.value;
		this.proporciona_papel 					= document.tipo_trabajo_detalle.proporciona_papel.value;
		this.proporciona_placas 				= document.tipo_trabajo_detalle.proporciona_placas.value;
		this.proporciona_tinta_especial 		= document.tipo_trabajo_detalle.proporciona_tinta_especial.value;
		this.proporciona_barniz 				= document.tipo_trabajo_detalle.proporciona_barniz.value;
		this.tipo_papel 						= document.tipo_trabajo_detalle.tipo_papel.value;
		this.repeticiones_x_pliego 				= document.tipo_trabajo_detalle.repeticiones_x_pliego.value;
		this.numero_paginas_publicacion 		= document.tipo_trabajo_detalle.numero_paginas_publicacion.value;
		this.tamanio_publicacion 				= document.tipo_trabajo_detalle.tamanio_pubicacion.value;
		this.alto_corte_inicial					= document.tipo_trabajo_detalle.alto_corte_inicial.value;
		this.ancho_corte_inicial				= document.tipo_trabajo_detalle.ancho_corte_inicial.value;
		this.frente_combinacion_tintas 			= document.tipo_trabajo_detalle.frente_combinacion_tintas.value;
		this.frente_num_tinta_especial 			= document.tipo_trabajo_detalle.frente_num_tinta_especial.value;
		this.frente_descripcion_tinta_especial 	= document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value;
		this.frente_tipo_barniz 				= document.tipo_trabajo_detalle.frente_tipo_barniz.value;
		this.vuelta_combinacion_tintas 			= document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value;
		this.vuelta_num_tinta_especial 			= document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value;
		this.vuelta_descripcion_tinta_especial 	= document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value;
		this.vuelta_tipo_barniz 				= document.tipo_trabajo_detalle.vuelta_tipo_barniz.value;
		this.maquina 							= document.tipo_trabajo_detalle.maquina.value;
		this.tipo_placa 						= document.tipo_trabajo_detalle.tipo_placa.value;
		this.tipo_complejidad 					= document.tipo_trabajo_detalle.tipo_complejidad.value;
	},
	
	setFormTTD : function() {
		document.tipo_trabajo_detalle.descripcion_partida_detalle.value			= this.descripcion_partida_detalle;
		document.tipo_trabajo_detalle.alto_final.value							= this.alto_final;
		document.tipo_trabajo_detalle.ancho_final.value 						= this.ancho_final;
		document.tipo_trabajo_detalle.alto_extendido.value 						= this.alto_extendido;
		document.tipo_trabajo_detalle.ancho_extendido.value 					= this.ancho_extendido;
		document.tipo_trabajo_detalle.proporciona_papel.value 					= this.proporciona_papel;
		document.tipo_trabajo_detalle.proporciona_placas.value 					= this.proporciona_placas;
		document.tipo_trabajo_detalle.proporciona_tinta_especial.value 			= this.proporciona_tinta_especial;
		document.tipo_trabajo_detalle.proporciona_barniz.value 					= this.proporciona_barniz;
		document.tipo_trabajo_detalle.tipo_papel.value 							= this.tipo_papel;
		document.tipo_trabajo_detalle.repeticiones_x_pliego.value 				= this.repeticiones_x_pliego;
		document.tipo_trabajo_detalle.numero_paginas_publicacion.value 			= this.numero_paginas_publicacion;
		document.tipo_trabajo_detalle.tamanio_pubicacion.value 					= this.tamanio_publicacion;
		document.tipo_trabajo_detalle.alto_corte_inicial.value 					= this.alto_corte_inicial;
		document.tipo_trabajo_detalle.ancho_corte_inicial.value 				= this.ancho_corte_inicial;
		document.tipo_trabajo_detalle.frente_combinacion_tintas.value 			= this.frente_combinacion_tintas;
		document.tipo_trabajo_detalle.frente_num_tinta_especial.value 			= this.frente_num_tinta_especial;
		document.tipo_trabajo_detalle.frente_descripcion_tinta_especial.value 	= this.frente_descripcion_tinta_especial;
		document.tipo_trabajo_detalle.frente_tipo_barniz.value 					= this.frente_tipo_barniz;
		document.tipo_trabajo_detalle.vuelta_combinacion_tintas.value 			= this.vuelta_combinacion_tintas;
		document.tipo_trabajo_detalle.vuelta_num_tinta_especial.value 			= this.vuelta_num_tinta_especial;
		document.tipo_trabajo_detalle.vuelta_descripcion_tinta_especial.value 	= this.vuelta_descripcion_tinta_especial;
		document.tipo_trabajo_detalle.vuelta_tipo_barniz.value 					= this.vuelta_tipo_barniz;
		document.tipo_trabajo_detalle.maquina.value 							= this.maquina;
		document.tipo_trabajo_detalle.tipo_placa.value 							= this.tipo_placa;
		document.tipo_trabajo_detalle.tipo_complejidad.value 					= this.tipo_complejidad;
	}
} // obj_ttd_encabezado
	
function activaBotonesModificarFormTipoTrabajoDetalle() {
	document.getElementById("imgBtnModificarTTD").style.display 		= "none";
	document.getElementById("imgBtnCancelaModificarTTD").style.display	= "inline";
	document.getElementById("imgBtnAceptaEliminarTTD").style.display	= "inline";
	document.getElementById("imgBtnAceptaModificarTTD").style.display	= "inline";
}

function desactivaBotonesModificarFormTipoTrabajoDetalle() {
	document.getElementById("imgBtnCancelaModificarTTD").style.display	= "none";
	document.getElementById("imgBtnAceptaEliminarTTD").style.display	= "none";
	document.getElementById("imgBtnAceptaModificarTTD").style.display	= "none";
	document.getElementById("imgBtnModificarTTD").style.display 		= "inline";
}

function activaCamposFormTipoTrabajoDetalle() {
	copiaValorDeTextACheckbox();
	copiaValorDeTextASelect();
	muestraCheckbox();
	muestraSelect();
	desactivaReadonlyCamposVisibles();
	aplicaColorFFFCamposVisibles();
}

function desactivaCamposFormTipoTrabajoDetalle() {
	ocultaCheckbox();
	ocultaSelect();
	activaReadonlyCamposVisibles();
	aplicaColorTransparentCamposVisibles();
}

function modificaTTD() {
	ocultaBotonesModificarPorSeccion();
	document.getElementById("div_btn_actualizar_ttd_encabezado").style.display = "inline";
	activaCamposFormTipoTrabajoDetalle();
	activaBotonesModificarFormTipoTrabajoDetalle();
}

function aceptaEliminarTTD() {
	if ( confirm("¿Esta seguro de querer eliminar este registro?") ) {
		$.ajax({
			type: "POST",
			url: urlEliminaTipoTrabajoDetalle,
			data: {
				id_orden_produccion: document.tipo_trabajo_detalle.id_orden_produccion.value,
				id_partida: document.tipo_trabajo_detalle.id_partida.value,
				id_tipo_trabajo_detalle: document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value
			},
			success: function(response) {
				// actualiza la tabla
				document.getElementById("div_tabla_lista_tipo_trabajo_detalle").innerHTML = response.textoHTML;
				// actualiza el precio
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				// deactiva todo
				cancelaModificarTTD();
				// oculta divs
				document.getElementById("div_tipo_trabajo_detalle").style.display 				= "none";
				document.getElementById("div_visualizador_pliegos").style.display 				= "none";
				document.getElementById("div_visualizador_costo_extra_detalle").style.display	= "none";
			    document.getElementById("div_costo_extra_detalle").style.display				= "none";
				document.getElementById("div_pestania").style.display 							= "none";
				document.getElementById("div_material_ayuda").style.display 					= "none";
			},
			error: function(e) {
				console.log("ERROR aceptaEliminarTTD.ajax");
				cancelaModificarTTD();
				alert("No fue posible actualizar la informaci\u00F3n.");
				muestraBotonesModificarPorSeccion();
			}
		});
	}
}

// variable global
var cerradoOKVentanaListaPliegos = false;
function aceptaModificarTTD() {
	// guarda informacion en los campos ocultos
	copiaValorDeCheckboxAHidden();
	copiaValorDeSelectAHidden();
	copiaValorDeCheckboxAText();
	copiaValorDeSelectAText();
	// validacion
	if( validaDatosFormTTD() ) {
		// realiza ajax
		document.body.style.cursor = "wait";
		desactivaCamposFormTipoTrabajoDetalle();
		desactivaBotonesModificarFormTipoTrabajoDetalle();
		
		// PARA ABRIR VENTANA MODAL DE CALCULO DE PLIEGOS NUEVAMENTE
		var modificarPliegosNuevamente = false;
		switch( parseInt( document.partida.id_tipo_trabajo.value ) ) {
			case 1:  // flyer/poster
				if ( document.tipo_trabajo_detalle.repeticiones_x_pliego.value != obj_ttd.repeticiones_x_pliego )
					modificarPliegosNuevamente = true;
				break;
			case 2: // publicacion/revista/libro
				if ( document.tipo_trabajo_detalle.numero_paginas_publicacion.value != obj_ttd.numero_paginas_publicacion
						|| document.tipo_trabajo_detalle.tamanio_pubicacion.value != obj_ttd.tamanio_publicacion )
					modificarPliegosNuevamente = true;
				break;
			case 3:	// otro
				break;
			default:
				console.log("No entro al switch");
				break;
		}
		
		if ( modificarPliegosNuevamente ) {
			// es necesario modificar la cantidad de pliegos y papel porque:
			// a) modifico el numero de repeticiones que caben en cada papel
			// b) modifico el numero de hojas de la publicacion
			// c) modifico el tamaño de la publicacion
			$.ajax({
				type: "POST",
				url: urlActualizaTipoTrabajoDetalleConPliegos,
				data: $("[name=tipo_trabajo_detalle]").serialize(),
				success: function(response) {
					//console.log(response);
					document.body.style.cursor = "default";
					switch(response.estatusOperacion) {
						case 0: // error
							console.log("ERROR aceptaModificarTTD.if.ajax.switch.case0");
							cancelaModificarTTD();
							alert("No fue posible actualizar la informacion.");
							break;
						default: // exito
							// guarda informacion de pliegos
							obj_ttd.listaIdPliegoEliminado = response.textoJson;
							// guarda html ista de pliegos anterior
							obj_ttd.htmlListaPliegos = document.getElementById("div_tabla_lista_pliegos").innerHTML;
							// abre ventana creacion de pliegos para nueva informacion 
							Shadowbox.open({
		                        content:urlCalculaPliego + "?id_tipo_trabajo_detalle=" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value,
		                        player:"iframe",
		                        width:861,
		                        height:704,
		                        options:{ 
		                        	modal: true,
		                            overlayOpacity: 0.75,
		                            onClose: revisaCierreSegundaVentanaModal
		                        }
		                    });
							break;
					}
					muestraBotonesModificarPorSeccion();
				},
				error: function() {
					console.log("ERROR aceptaModificarTTD.if.ajax");
					document.body.style.cursor = "default";
					cancelaModificarTTD()
					alert("No fue posible actualizar la informaci\u00F3n.");
					muestraBotonesModificarPorSeccion();
				}
			});
		} else {
			// no es necesario modificar informacion respecto a cantidad de pliegos
			// no es necesario modificar informacion respecto a cantidad de papel
			$.ajax({
				type: "POST",
				url: urlActualizaTipoTrabajoDetalle,
				data: $("[name=tipo_trabajo_detalle]").serialize(),
				success: function(response) {
					//console.log(response);
					document.body.style.cursor = "default";
					switch(response.estatusOperacion) {
						case 0: // error
							console.log("ERROR aceptaModificarTTD.else.ajax.switch.case0");
							cancelaModificarTTD();
							alert("No fue posible actualizar la informacion.");
							break;
						default: // exito
							// GUARDA RESULTADOS PARTIDA EN OBJETO javascript
							obj_ttd.setObjTTD();
							document.body.style.cursor = "default";
							// obtiene el precio neto
							$.ajax({
								type:"POST",
								url:urlObtienePrecioNeto,
								data:{
									id_orden_produccion:document.tipo_trabajo_detalle.id_orden_produccion.value,
									nut:document.tipo_trabajo_detalle.nut.value
								},
								success:function(response){
									// GUARDA RESULTADOS TTD EN OBJETO javascript PARA NO OLVIDARLOS, porque todo salio correcto
						            obj_ttd.setObjTTD();
									// actualiza html
									var descripcion				= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_descripcion";
									var repeticiones_x_pliego 	= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_repeticiones_x_pliego";
									var numero_paginas 			= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_numero_paginas_publicacion";
									var tamanio_publicacion 	= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_tamanio_publicacion";
									var nombre_maquina 			= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_nombre_maquina";
									document.getElementById(descripcion).innerHTML 				= document.tipo_trabajo_detalle.descripcion_partida_detalle.value;
									document.getElementById(repeticiones_x_pliego).innerHTML 	= document.tipo_trabajo_detalle.repeticiones_x_pliego.value==""?"0":document.tipo_trabajo_detalle.repeticiones_x_pliego.value;
									document.getElementById(numero_paginas).innerHTML 			= document.tipo_trabajo_detalle.numero_paginas_publicacion.value==""?"0":document.tipo_trabajo_detalle.numero_paginas_publicacion.value;
									document.getElementById(tamanio_publicacion).innerHTML 		= document.tipo_trabajo_detalle.tamanio_pubicacion.value==""?"null":document.tipo_trabajo_detalle.tamanio_pubicacion.value;
									document.getElementById(nombre_maquina).innerHTML 			= document.tipo_trabajo_detalle.maquina.value;
									delete descripcion;
									delete repeticiones_x_pliego;
									delete numero_paginas;
									delete tamanio_publicacion;
									delete nombre_maquina;
									// actualiza precio
									//alert("regreso bien del segundo ajax en revisaCierreSegundaVentanaModal");
									document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
									muestraBotonesModificarPorSeccion();
								},
								error:function(e){
									alert("No fue posible obtener precio neto");
									muestraBotonesModificarPorSeccion();
								}
							});
							break;
					}
					muestraBotonesModificarPorSeccion();
				},
				error: function() {
					console.log("ERROR aceptaModificarTTD.if.ajax");
					document.body.style.cursor = "default";
					cancelaModificarTTD();
					alert("No fue posible actualizar la informaci\u00F3n.");
					muestraBotonesModificarPorSeccion();
				}
			});
		}
		delete modificarPliegosNuevamente;
	}
	delete correcto;
} // aceptaModificarTTDEncabezado


function revisaCierreSegundaVentanaModal() {
	// alert("cerro la segunda ventana modal");
	// alert("el valor de la bandera es: " + cerradoOKVentanaListaPliegos);
	if( cerradoOKVentanaListaPliegos ) {
		// Ok.
		//alert("entro al if");
		$.ajax({
			type:"POST",
			url:urlObtienePrecioNeto,
			data:{
				id_orden_produccion:document.tipo_trabajo_detalle.id_orden_produccion.value,
				nut:document.tipo_trabajo_detalle.nut.value
			},
			success:function(response){
				// GUARDA RESULTADOS PARTIDA EN OBJETO javascript
				obj_ttd.setObjTTD();
				// actualiza html
				var descripcion				= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_descripcion";
				var repeticiones_x_pliego 	= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_repeticiones_x_pliego";
				var numero_paginas 			= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_numero_paginas_publicacion";
				var tamanio_publicacion 	= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_tamanio_publicacion";
				var nombre_maquina 			= "td_" + document.tipo_trabajo_detalle.id_tipo_trabajo_detalle.value + "_nombre_maquina";
				document.getElementById(descripcion).innerHTML 				= document.tipo_trabajo_detalle.descripcion_partida_detalle.value;
				document.getElementById(repeticiones_x_pliego).innerHTML 	= document.tipo_trabajo_detalle.repeticiones_x_pliego.value==""?"0":document.tipo_trabajo_detalle.repeticiones_x_pliego.value;
				document.getElementById(numero_paginas).innerHTML 			= document.tipo_trabajo_detalle.numero_paginas_publicacion.value==""?"0":document.tipo_trabajo_detalle.numero_paginas_publicacion.value;
				document.getElementById(tamanio_publicacion).innerHTML 		= document.tipo_trabajo_detalle.tamanio_pubicacion.value==""?"null":document.tipo_trabajo_detalle.tamanio_pubicacion.value;
				document.getElementById(nombre_maquina).innerHTML 			= document.tipo_trabajo_detalle.maquina.value;
				delete descripcion;
				delete repeticiones_x_pliego;
				delete numero_paginas;
				delete tamanio_publicacion;
				delete nombre_maquina;
				// actualiza precio
				//alert("regreso bien del segundo ajax en revisaCierreSegundaVentanaModal");
				document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);
				muestraBotonesModificarPorSeccion();
			},
			error:function(e){
				console.log("ERROR revisaCierreSegundaVentanaModal.if.ajax");
				alert("No fue posible obtener precio neto");
				muestraBotonesModificarPorSeccion();
			}
		});
		// inicializa variable
		cerradoOKVentanaListaPliegos = false;
	} else {
		// 1) Debe copiar en pantalla el valor anterior
		// 2) Debe hacer update en base de datos con el registro anterior tipo_trabajo_detalle
		// 3) Debe activar los pliegoe eliminados
		// 4) Busca el precio
		//alert("entro al else");
		
		// 1)
		obj_ttd.setFormTTD();
		// 2)
		activaCamposFormTipoTrabajoDetalle();
		// copia la informacion en campos ocultos
		copiaValorDeCheckboxAHidden();
		copiaValorDeSelectAHidden();
		copiaValorDeCheckboxAText();
		copiaValorDeSelectAText();
		desactivaCamposFormTipoTrabajoDetalle();
		desactivaBotonesModificarFormTipoTrabajoDetalle();
		// realiza ajax
		// 3)
		$.ajax({
			type:'POST',
			url:urlActualizaTipoTrabajoDetalle,
			data:$("[name=tipo_trabajo_detalle]").serialize(),
			success:function(response) {
				document.body.style.cursor = "default";
				switch(response.estatusOperacion) {
					case 0: // error
						console.log("ERROR revisaCierreSegundaVentanaModal.else.ajax1.switch.case0");
						cancelaModificarTTD();
						alert("No fue posible actualizar la informaci\u00F3n.");
						break;
						
					default: // exito
	        			//alert("activa pliegos eliminados");
	        			$.ajax({
	        				type:"POST",
	        				url:urlActivaListaPliegos,
	        				data:{json:obj_ttd.listaIdPliegoEliminado},
	        				success:function(response){
	        					//alert("exito activando pliegos");
	        					document.getElementById("div_tabla_lista_pliegos").innerHTML = obj_ttd.htmlListaPliegos;
	// 4)
		             			$.ajax({
		             				type:"POST",
		             				url:urlObtienePrecioNeto,
		             				data:{
		             					id_orden_produccion:document.tipo_trabajo_detalle.id_orden_produccion.value,
		             					nut:document.tipo_trabajo_detalle.nut.value
		             				},
		             				success:function(response){
		             					// actualiza precio
		             					//alert("regreso bien del segundo ajax en revisaCierreSegundaVentanaModal");
		             					document.precio.precio_neto.value = "$ " + (response.precioNeto).formatMoney(2);		
		             				},
		             				error:function(e){
		             					console.log("ERROR revisaCierreSegundaVentanaModal.else.ajax3");
		             					alert("No fue posible obtener precio neto");
		             				}
		             			});
	        				},
	        				error:function(e){
	        					console.log("ERROR revisaCierreSegundaVentanaModal.else.ajax2");
	        					alert("error activando pliegos");
	        				}
	        			});
	       				break;
				}
				muestraBotonesModificarPorSeccion();
			},
			error: function() {
				console.log("ERROR revisaCierreSegundaVentanaModal.else.ajax1");
				document.body.style.cursor = "default";
				cancelaModificarTTD();
				// oculta DIVS
				ocultaDiv(); // funcion en detalle_ttd_agrega.js
				alert("No fue posible actualizar la informaci\u00F3n.");
				muestraBotonesModificarPorSeccion();
			}
		});
	}
} // revisaCierreSegundaVentanaModal

function cancelaModificarTTD() {
	obj_ttd.setFormTTD();
	desactivaBotonesModificarFormTipoTrabajoDetalle();
	desactivaCamposFormTipoTrabajoDetalle();
	muestraBotonesModificarPorSeccion();
}

