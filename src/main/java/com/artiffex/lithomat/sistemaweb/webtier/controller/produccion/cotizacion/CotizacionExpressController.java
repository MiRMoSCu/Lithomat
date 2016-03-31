package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.cotizacion;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.CotizadorExpressDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CombinacionTintas;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.PapelSobrante;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TamanioPublicacion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoBarniz;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoCliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPlaca;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CombinacionTintasService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PapelSobranteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TamanioPublicacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TintaEspecialService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoBarnizService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPapelExtendidoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPlacaService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/cotizacion_express")
public class CotizacionExpressController {

	private static final Logger log = Logger.getLogger(CotizacionExpressController.class);
	
	private static final int TIPO_TRABAJO_FLYER 	= 1;
	private static final int TIPO_TRABAJO_REVISTA 	= 2;
	private static final int TIPO_TRABAJO_OTRO 		= 3;
	
	@Resource
	private TipoClienteService tipoClienteService;
	@Resource
	private TipoPapelExtendidoService tipoPapelExtendidoService;
	@Resource
	private CombinacionTintasService combinacionTintasService;
	@Resource
	private TipoBarnizService tipoBarnizService;
	@Resource
	private TabuladorPreciosService tabuladorPreciosService;
	@Resource
	private TintaEspecialService tintaEspecialService;
	@Resource
	private MaquinaService maquinaService;
	@Resource
	private TipoPlacaService tipoPlacaService;
	@Resource
	private TamanioPublicacionService tamanioPublicacionService;
	@Resource
	private PapelSobranteService papelSobranteService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ventanaCotizacion( Locale locale, Model model ) throws IOException {
		log.info("/cotizacion_express");
		
		List<ComboSelect> listaTipoCliente = tipoClienteService.listaComboSelect();
		model.addAttribute("listaTipoCliente", listaTipoCliente);
		listaTipoCliente = null;
		
		List<ComboSelect> listaTamanioPublicacion = tamanioPublicacionService.listaComboSelect();
		model.addAttribute("listaTamanioPublicacion", listaTamanioPublicacion);
		listaTamanioPublicacion = null;
		
		List<ComboSelect> listaTipoPapelExtendido = tipoPapelExtendidoService.listaComboSelect();
		model.addAttribute("listaTipoPapelExtendido", listaTipoPapelExtendido);
		listaTipoPapelExtendido = null;
		
		List<ComboSelect> listaCombinacionTintas = combinacionTintasService.listaComboSelect();
		model.addAttribute("listaCombinacionTintas", listaCombinacionTintas);
		listaCombinacionTintas = null;
		
		List<ComboSelect> listaTipoBarniz = tipoBarnizService.listaComboSelect();
		model.addAttribute("listaTipoBarniz", listaTipoBarniz);
		listaTipoBarniz = null;
		
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		model.addAttribute("listaMaquina", listaMaquina);
		listaMaquina = null;
		
		return "produccion/cotizacion/ventana_cotizacion_express";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/calcula", method = RequestMethod.POST)
	@ResponseBody
	public CotizadorExpressDTO calculaCotizacionExpress(
			@RequestParam(value = "id_tipo_cliente", 				required = false) Integer idTipoCliente,
			@RequestParam(value = "cantidad", 						required = false) Integer cantidad,
			@RequestParam(value = "id_tipo_trabajo", 				required = false) Integer idTipoTrabajo,
			@RequestParam(value = "repeticiones_x_pliego", 			required = false) int repeticionesXPliego,
			@RequestParam(value = "numero_paginas_publicacion", 	required = false) int numeroPaginasPublicacion,
			@RequestParam(value = "id_tamanio_publicacion", 		required = false) int idTamanioPublicacion,
			@RequestParam(value = "numero_pliegos", 				required = false) float numeroPliegos,
			@RequestParam(value = "incluye_costo_papel", 			required = false) boolean incluyeCostoPapel,
			@RequestParam(value = "id_tipo_papel_extendido", 		required = false) int idTipoPapelExtendido,
			@RequestParam(value = "frente_id_combinacion_tintas", 	required = false) Integer frenteIdCombinacionTintas,
			@RequestParam(value = "frente_numero_tinta_especial", 	required = false) Integer frenteNumeroTintaEspecial,
			@RequestParam(value = "frente_id_tipo_barniz", 			required = false) Integer frenteIdTipoBarniz,
			@RequestParam(value = "vuelta_id_combinacion_tintas", 	required = false) Integer vueltaIdCombinacionTintas,
			@RequestParam(value = "vuelta_numero_tinta_especial", 	required = false) Integer vueltaNumeroTintaEspecial,
			@RequestParam(value = "vuelta_id_tipo_barniz", 			required = false) Integer vueltaIdTipoBarniz,
			@RequestParam(value = "id_maquina", 					required = false) Integer idMaquina,
			@RequestParam(value = "incluye_costo_placa", 			required = false) boolean incluyeCostoPlaca,
			@RequestParam(value = "id_tipo_placa", 					required = false) Integer idTipoPlaca,
			@RequestParam(value = "vuelta_mismas_placas", 			required = false) boolean vueltaMismasPlacas
		) {
		log.info("/calcula_cotizacion");
		
		System.out.println("idTipoCliente:" + idTipoCliente);
		System.out.println("cantidad:"+cantidad);
		System.out.println("idTipoTrabajo:" + idTipoTrabajo);
		System.out.println("repeticionesXPliego:"+repeticionesXPliego);
		System.out.println("numeroPaginasPublicacion:"+numeroPaginasPublicacion);
		System.out.println("idTamanioPublicacion:"+idTamanioPublicacion);
		System.out.println("numeroPliegos:"+numeroPliegos);
		System.out.println("incluyeCostoPapel:"+incluyeCostoPapel);
		System.out.println("idTipoPapelExtendido:"+idTipoPapelExtendido);
		System.out.println("frenteIdCombinacionTintas:"+frenteIdCombinacionTintas);
		System.out.println("frenteNumeroTintaEspecial:"+frenteNumeroTintaEspecial);
		System.out.println("frenteIdTipoBarniz:"+frenteIdTipoBarniz);
		System.out.println("vueltaIdCombinacionTintas:"+vueltaIdCombinacionTintas);
		System.out.println("vueltaNumeroTintaEspecial:"+vueltaNumeroTintaEspecial);
		System.out.println("vueltaIdTipoBarniz:"+vueltaIdTipoBarniz);
		System.out.println("idMaquina:"+idMaquina);
		System.out.println("incluyeCostoPlaca:"+incluyeCostoPlaca);
		System.out.println("idTipoPlaca:"+idTipoPlaca);
		System.out.println("vueltaMismasPlacas:"+vueltaMismasPlacas);
		
		// INICIALIZACION DE OBJETOS
		CotizadorExpressDTO cotizadorExpress 			= new CotizadorExpressDTO();
		CombinacionTintas frenteCombinacionTintas 		= combinacionTintasService.buscaCombinacionTintas(frenteIdCombinacionTintas);
		CombinacionTintas vueltaCombinacionTintas 		= combinacionTintasService.buscaCombinacionTintas(vueltaIdCombinacionTintas);
		TipoCliente tipoCliente 						= tipoClienteService.buscaTipoCliente(idTipoCliente);
		PapelSobrante papelSobrante						= null;
		TipoPapelExtendido tipoPapelExtendido 			= null;
		TipoPlaca tipoPlaca								= null;
		HashMap<String, Object> hashTintaEspecialPrecio	= null;
		TipoBarniz frenteTipoBarniz 					= null;
		TipoBarniz vueltaTipoBarniz 					= null;
		
		// INICIALIZACION DE VARIABLES
		float cotizacionCosteTotal				= 0;
		int cantidadImpresion					= 0;
		int hojasSobrantes						= 0;
		int cantidadRedondeada 					= 0;
		float precioUnitarioTabulador			= 0;
		int numeroPlacas 						= 0;
		int tintaNumEntMaq 						= 0;
		float tintaPrecioUnitario 				= 0;
		float tintaCosteTotal 					= 0;
		float precioUnitarioTipoPapelExtendido	= 0;
		float papelCosteTotal	 				= 0;
		int frenteTintaEntradasMaquina 			= 0;
		int vueltaTintaEntradasMaquina	 		= 0;
		int tintaEspecialNumEntMaq				= 0;
		float tintaEspecialPrecioUnitario 		= 0;
		float tintaEspecialCosteTotal			= 0;
		int frenteBarnizNumEnt 					= 0;
		float frenteBarnizPrecioUnitario 		= 0;
		float frenteBarnizCosteTotal 			= 0;
		int vueltaBarnizNumEnt 					= 0;
		float vueltaBarnizPrecioUnitario 		= 0;
		float vueltaBarnizCosteTotal 			= 0;
		float placasPrecioUnitario	 			= 0;
		float placasCosteTotal 					= 0;
		
		// CALCULOS CORRESPONDIENTES A TODOS LOS TIPOS DE TRABAJO
			// TIPO CLIENTE
		float porcentajeGananciaCliente = tipoCliente.getPrecio() / tipoCliente.getTipoPrecio().getFactorDivisor();
		tipoCliente = null;
		
		switch (idTipoTrabajo) {
			case TIPO_TRABAJO_FLYER:
				// INICIALIZACION DE VARIABLES
				// la cantidad de papel verdadera que entrara a impresion es (cantidad/repeticiones); este valor define el precio del tabulador
				
				// CANTIDAD
				cantidadImpresion = (int) Math.ceil( (double) cantidad / (double) repeticionesXPliego );; 
				
				// CANTIDAD REAL
				cantidadRedondeada 	= 0;
				if ( cantidadImpresion <= 100 )
					cantidadRedondeada = 1000;
				else if ( (cantidadImpresion % 1000 ) > 300 )
					cantidadRedondeada = ( ( cantidadImpresion / 1000 ) + 1 ) * 1000;
				else 
					cantidadRedondeada = cantidadImpresion;
				
				// PRECIO TABULADOR
				precioUnitarioTabulador = tabuladorPreciosService.obtienePrecioUnitarioTabulador( 1, idMaquina, cantidadRedondeada );
				precioUnitarioTabulador = precioUnitarioTabulador * (1 + porcentajeGananciaCliente);
				
				// CALCULO PAPEL SOBRANTE
				papelSobrante = new PapelSobrante();
				papelSobrante.setInicioTabulador(cantidadImpresion + 1);
				papelSobrante.setFinTabulador(cantidadImpresion - 1);
				papelSobrante.setFrenteNumTinta(frenteCombinacionTintas.getNumTintas());
				papelSobrante.setVueltaNumTinta(vueltaCombinacionTintas.getNumTintas());
				papelSobrante.setTintaEspecial( frenteNumeroTintaEspecial > 0 || vueltaNumeroTintaEspecial > 0 ? true : false);
				hojasSobrantes = papelSobranteService.buscaHojasSobrante(papelSobrante);
				papelSobrante = null;
				
				// OBTENCION PRECIO PAPEL
				tipoPapelExtendido = tipoPapelExtendidoService.buscaTipoPapelExtendido(idTipoPapelExtendido);
				precioUnitarioTipoPapelExtendido = (tipoPapelExtendido.getPrecio() / tipoPapelExtendido.getTipoPrecio().getFactorDivisor()) * (1 + porcentajeGananciaCliente);
				papelCosteTotal = (cantidadImpresion + hojasSobrantes) * precioUnitarioTipoPapelExtendido;
				tipoPapelExtendido = null;
				if ( incluyeCostoPapel ) 
					cotizacionCosteTotal += papelCosteTotal;
				
				
				// CALCULO TINTA
				if ( vueltaMismasPlacas ) {
					String descripcionTintaFrente = frenteCombinacionTintas.getDescripcion();
					String descripcionTintaVuelta = vueltaCombinacionTintas.getDescripcion();
					StringBuilder cadenaFinal = new StringBuilder();
					if ( frenteCombinacionTintas.getNumTintas() > 0 ) 
						for ( int i = 0; i < descripcionTintaFrente.length(); i++ ) { 
							try {
								cadenaFinal.append(descripcionTintaFrente.charAt(i));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					if ( vueltaCombinacionTintas.getNumTintas() > 0 ) 
						for ( int i = 0; i < descripcionTintaVuelta.length(); i++ ) { 
							try {
								if ( cadenaFinal.toString().indexOf(descripcionTintaVuelta.charAt(i)) == -1 )
									cadenaFinal.append(descripcionTintaVuelta.charAt(i));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					tintaNumEntMaq 	= cadenaFinal.length();
					numeroPlacas 	= cadenaFinal.length();
					cadenaFinal = null;
				} else {
					frenteTintaEntradasMaquina = frenteCombinacionTintas.getNumTintas();
					vueltaTintaEntradasMaquina = vueltaCombinacionTintas.getNumTintas();
					tintaNumEntMaq = frenteTintaEntradasMaquina + vueltaTintaEntradasMaquina;
					numeroPlacas += frenteTintaEntradasMaquina;
					numeroPlacas += vueltaTintaEntradasMaquina;
				}
				// OBTENCION PRECIO TINTA
				tintaPrecioUnitario = precioUnitarioTabulador;
				tintaCosteTotal = cantidadRedondeada * tintaNumEntMaq * tintaPrecioUnitario;
				
				cotizacionCosteTotal += tintaCosteTotal;
				
				
				// CALCULO TINTA ESPECIAL
				hashTintaEspecialPrecio = tintaEspecialService.getHashPrecioYTipoPrecio();
				tintaEspecialNumEntMaq = frenteNumeroTintaEspecial + vueltaNumeroTintaEspecial;
				numeroPlacas += frenteNumeroTintaEspecial;
				if ( !vueltaMismasPlacas )
					numeroPlacas += vueltaNumeroTintaEspecial;
				// OBTENCION PRECIO TINTA ESPECIAL
				tintaEspecialPrecioUnitario = precioUnitarioTabulador * (1 + ((Float)hashTintaEspecialPrecio.get("precio") / Integer.parseInt(hashTintaEspecialPrecio.get("factorDivisor").toString())));
				tintaEspecialCosteTotal = cantidadRedondeada * tintaEspecialNumEntMaq * tintaEspecialPrecioUnitario;
				hashTintaEspecialPrecio = null;
				
				cotizacionCosteTotal += tintaEspecialCosteTotal;
				
				
				// OBTENCION PRECIO BARNIZ FRENTE
				frenteTipoBarniz = tipoBarnizService.buscaTipoBarniz(frenteIdTipoBarniz);
				frenteBarnizNumEnt = frenteTipoBarniz.getNumEntradasMaquina();
				frenteBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (frenteTipoBarniz.getPrecio() / frenteTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
				frenteBarnizCosteTotal = cantidadRedondeada * frenteBarnizNumEnt * frenteBarnizPrecioUnitario;
				
				cotizacionCosteTotal += frenteBarnizCosteTotal;
				
				// OBTENCION PRECIO BARNIZ VUELTA
				vueltaTipoBarniz = tipoBarnizService.buscaTipoBarniz(vueltaIdTipoBarniz);
				vueltaBarnizNumEnt = vueltaTipoBarniz.getNumEntradasMaquina();
				vueltaBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (vueltaTipoBarniz.getPrecio() / vueltaTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
				vueltaBarnizCosteTotal = cantidadRedondeada * vueltaBarnizNumEnt* vueltaBarnizPrecioUnitario;
				
				cotizacionCosteTotal += vueltaBarnizCosteTotal;
				
				// BARNIZ PLACAS
				if ( vueltaMismasPlacas ) {
					if ( frenteTipoBarniz.getIdTipoBarniz() == vueltaTipoBarniz.getIdTipoBarniz() )
						numeroPlacas += frenteTipoBarniz.getNumPlacas();
					else if ( frenteTipoBarniz.getNumPlacas() > 0 )
						numeroPlacas += frenteTipoBarniz.getNumPlacas();
					else if ( vueltaTipoBarniz.getNumPlacas() > 0 )
						numeroPlacas += vueltaTipoBarniz.getNumPlacas();
				} else {
					numeroPlacas += frenteTipoBarniz.getNumPlacas();
					numeroPlacas += vueltaTipoBarniz.getNumPlacas();
				}
				
				frenteTipoBarniz = null;
				vueltaTipoBarniz = null;
				
				
				// OBTENCION PRECIO PLACAS
				tipoPlaca = tipoPlacaService.buscaTipoPlaca(idTipoPlaca);
				placasPrecioUnitario = (tipoPlaca.getPrecio() / tipoPlaca.getTipoPrecio().getFactorDivisor()) * (1 + porcentajeGananciaCliente);
				placasCosteTotal = numeroPlacas * placasPrecioUnitario;
				tipoPlaca = null;
				if ( incluyeCostoPlaca )
					cotizacionCosteTotal += placasCosteTotal;
				
				
				// COTIZACION
				cotizadorExpress.setPapelDescripcion(cantidadImpresion + " + " + hojasSobrantes + " [" + String.format("%.3f", precioUnitarioTipoPapelExtendido) + "]");
				cotizadorExpress.setTintaDescripcion(tintaNumEntMaq + " [" + String.format("%.3f", tintaPrecioUnitario) + "]");
				cotizadorExpress.setTintaEspecialDescripcion(tintaEspecialNumEntMaq + " [" + String.format("%.3f", tintaEspecialPrecioUnitario) + "]" );
				cotizadorExpress.setBarnizDescripcion("F:" + frenteBarnizNumEnt + " [" + String.format("%.3f", frenteBarnizPrecioUnitario) + "] V:" + vueltaBarnizNumEnt + " [" + String.format("%.3f", vueltaBarnizPrecioUnitario) + "]");
				cotizadorExpress.setPlacasDescripcion(numeroPlacas + " [" + String.format("%.2f", placasPrecioUnitario) + "]" );
				
				cotizadorExpress.setPapelCosteTotal(papelCosteTotal);
				cotizadorExpress.setTintaCosteTotal(tintaCosteTotal);
				cotizadorExpress.setTintaEspecialCosteTotal(tintaEspecialCosteTotal);
				cotizadorExpress.setBarnizCosteTotal(frenteBarnizCosteTotal + vueltaBarnizCosteTotal);
				cotizadorExpress.setPlacasCosteTotal(placasCosteTotal);
				cotizadorExpress.setCotizacionCosteTotal(cotizacionCosteTotal);
				
				break;
			case TIPO_TRABAJO_REVISTA:
				StringBuilder tintaDescripcion 			= new StringBuilder();
				StringBuilder tintaEspecialDescripcion 	= new StringBuilder();
				StringBuilder barnizDescripcion			= new StringBuilder();
				int papelCantidadTotal				= 0;
				int papelSobranteCantidadTotal		= 0;
				float cotizacionGranCosteTotal		= 0;
				float tintaGranCosteTotal			= 0;
				float tintaEspecialGranCosteTotal	= 0;
				float barnizGranCosteTotal			= 0;
				
				// conocer el numero de pliegos 40/16 = 2.5
				// 2 pliegos que tienen una tabulador especifico
				// 0.5 pliego que tiene otro tabulador especifico
				
				// INICIALIZACION DE VARIABLES
				List<TamanioPublicacion> listaTamanio = tamanioPublicacionService.listaDecimales();
				TamanioPublicacion tamanioPublicacion = tamanioPublicacionService.buscaTamanioPublicacion(idTamanioPublicacion);
				// CANTIDAD
				float cantidadPliegos = (float)numeroPaginasPublicacion / (float)tamanioPublicacion.getNumeroPaginas();
				
				System.out.println("numeroPaginasPublicacion:"+numeroPaginasPublicacion);
				System.out.println("tamanio:"+tamanioPublicacion.getNumeroPaginas());
				System.out.println("cantidadPliegos:"+cantidadPliegos);
				
				for (TamanioPublicacion tamanio : listaTamanio) {
					do {
						if (cantidadPliegos >= tamanio.getNumeroDecimal()) {
							System.out.println(tamanio.getNumeroDecimal());
							System.out.println("numeroPlacas:"+ numeroPlacas);
							// cantidad impresion = hojas buenas que se necesitan
							cantidadImpresion = (int) Math.ceil(tamanio.getNumeroDecimal() * cantidad);
							
							// PRECIO TABULADOR
							cantidadRedondeada = 0;
							if ( cantidadImpresion <= 100 )
								cantidadRedondeada = 1000;
							else if ( (cantidadImpresion % 1000 ) > 300 )
								cantidadRedondeada = ( ( cantidadImpresion / 1000 ) + 1 ) * 1000;
							else 
								cantidadRedondeada = cantidadImpresion;
							
							precioUnitarioTabulador = tabuladorPreciosService.obtienePrecioUnitarioTabulador( 1, idMaquina, cantidadRedondeada );
							precioUnitarioTabulador = precioUnitarioTabulador * (1 + porcentajeGananciaCliente);
							
							// CALCULO PAPEL SOBRANTE
							papelSobrante = new PapelSobrante();
							papelSobrante.setInicioTabulador(cantidadImpresion + 1);
							papelSobrante.setFinTabulador(cantidadImpresion - 1);
							papelSobrante.setFrenteNumTinta(frenteCombinacionTintas.getNumTintas());
							papelSobrante.setVueltaNumTinta(vueltaCombinacionTintas.getNumTintas());
							papelSobrante.setTintaEspecial( frenteNumeroTintaEspecial > 0 || vueltaNumeroTintaEspecial > 0 ? true : false);
							hojasSobrantes = papelSobranteService.buscaHojasSobrante(papelSobrante);
							papelCantidadTotal += cantidadImpresion;
							papelSobranteCantidadTotal += hojasSobrantes;
							papelSobrante = null;
							
							// CALCULO TINTA
							if ( vueltaMismasPlacas ) {
								if (tamanio.getNumeroDecimal() == (float)1) {
									System.out.println("TINTA: entro a tamanio.getNumeroDecimal() == (float)1");
									frenteTintaEntradasMaquina = frenteCombinacionTintas.getNumTintas();
									vueltaTintaEntradasMaquina = vueltaCombinacionTintas.getNumTintas();
									tintaNumEntMaq = frenteTintaEntradasMaquina + vueltaTintaEntradasMaquina;
									numeroPlacas += frenteTintaEntradasMaquina;
									numeroPlacas += vueltaTintaEntradasMaquina;
								} else {
									String descripcionTintaFrente = frenteCombinacionTintas.getDescripcion();
									String descripcionTintaVuelta = vueltaCombinacionTintas.getDescripcion();
									StringBuilder cadenaFinal = new StringBuilder();
									if ( frenteCombinacionTintas.getNumTintas() > 0 ) 
										for ( int i = 0; i < descripcionTintaFrente.length(); i++ ) { 
											try {
												cadenaFinal.append(descripcionTintaFrente.charAt(i));
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									if ( vueltaCombinacionTintas.getNumTintas() > 0 ) 
										for ( int i = 0; i < descripcionTintaVuelta.length(); i++ ) { 
											try {
												if ( cadenaFinal.toString().indexOf(descripcionTintaVuelta.charAt(i)) == -1 )
													cadenaFinal.append(descripcionTintaVuelta.charAt(i));
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									tintaNumEntMaq 	= cadenaFinal.length() + cadenaFinal.length();
									numeroPlacas 	+= cadenaFinal.length();
									cadenaFinal = null;
								}
							} else {
								frenteTintaEntradasMaquina = frenteCombinacionTintas.getNumTintas();
								vueltaTintaEntradasMaquina = vueltaCombinacionTintas.getNumTintas();
								tintaNumEntMaq = frenteTintaEntradasMaquina + vueltaTintaEntradasMaquina;
								numeroPlacas += frenteTintaEntradasMaquina;
								numeroPlacas += vueltaTintaEntradasMaquina;
							}
							tintaPrecioUnitario = precioUnitarioTabulador;
							tintaCosteTotal = cantidadRedondeada * tintaNumEntMaq * tintaPrecioUnitario;
							// SUMA GRAN TOTAL TINTA
							tintaGranCosteTotal += tintaCosteTotal;
							// tinta descripcion
							tintaDescripcion.append(tintaNumEntMaq + " [" + String.format("%.3f", tintaPrecioUnitario) + "]");
							tintaDescripcion.append(", ");
							
							
							// CALCULO TINTA ESPECIAL
							hashTintaEspecialPrecio = tintaEspecialService.getHashPrecioYTipoPrecio();
							tintaEspecialNumEntMaq = frenteNumeroTintaEspecial + vueltaNumeroTintaEspecial;
							numeroPlacas += frenteNumeroTintaEspecial;
							if ( !vueltaMismasPlacas )
								numeroPlacas += vueltaNumeroTintaEspecial;
							// OBTENCION PRECIO TINTA ESPECIAL
							tintaEspecialPrecioUnitario = precioUnitarioTabulador * (1 + ((Float)hashTintaEspecialPrecio.get("precio") / Integer.parseInt(hashTintaEspecialPrecio.get("factorDivisor").toString())));
							tintaEspecialCosteTotal = cantidadRedondeada * tintaEspecialNumEntMaq * tintaEspecialPrecioUnitario;
							hashTintaEspecialPrecio = null;
							// SUMA GRAN TOTAL TINTA
							tintaEspecialGranCosteTotal += tintaEspecialCosteTotal;
							// tinta especial descripcion
							tintaEspecialDescripcion.append(tintaEspecialNumEntMaq + " [" + String.format("%.3f", tintaEspecialPrecioUnitario) + "]");
							tintaEspecialDescripcion.append(", ");
							
							
							// OBTENCION BARNIZ FRENTE
							frenteTipoBarniz = tipoBarnizService.buscaTipoBarniz(frenteIdTipoBarniz);
							frenteBarnizNumEnt = frenteTipoBarniz.getNumEntradasMaquina();
							frenteBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (frenteTipoBarniz.getPrecio() / frenteTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
							frenteBarnizCosteTotal = cantidadRedondeada * frenteBarnizNumEnt * frenteBarnizPrecioUnitario;
							// SUMA GRAN TOTAL BARNIZ
							barnizGranCosteTotal += frenteBarnizCosteTotal;
							
							vueltaTipoBarniz = tipoBarnizService.buscaTipoBarniz(vueltaIdTipoBarniz);
							vueltaBarnizNumEnt = vueltaTipoBarniz.getNumEntradasMaquina();
							vueltaBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (vueltaTipoBarniz.getPrecio() / vueltaTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
							vueltaBarnizCosteTotal = cantidadRedondeada * vueltaBarnizNumEnt* vueltaBarnizPrecioUnitario;
							// SUMA GRAN TOTAL BARNIZ
							barnizGranCosteTotal += vueltaBarnizCosteTotal;
							
							// barniz descripcion
							barnizDescripcion.append("F:" + frenteBarnizNumEnt + " [" + String.format("%.3f", frenteBarnizPrecioUnitario) + "] V:" + vueltaBarnizNumEnt + " [" + String.format("%.3f", vueltaBarnizPrecioUnitario) + "]");
							barnizDescripcion.append(", ");
							
							
							// BARNIZ PLACAS
							if ( vueltaMismasPlacas ) {
								if (tamanio.getNumeroDecimal() == (float)1) {
									System.out.println("PLACAS: entro a tamanio.getNumeroDecimal() == (float)1");
									numeroPlacas += frenteTipoBarniz.getNumPlacas();
									numeroPlacas += vueltaTipoBarniz.getNumPlacas();
								} else {
									if ( frenteTipoBarniz.getIdTipoBarniz() == vueltaTipoBarniz.getIdTipoBarniz() )
										numeroPlacas += frenteTipoBarniz.getNumPlacas();
									else if ( frenteTipoBarniz.getNumPlacas() > 0 )
										numeroPlacas += frenteTipoBarniz.getNumPlacas();
									else if ( vueltaTipoBarniz.getNumPlacas() > 0 )
										numeroPlacas += vueltaTipoBarniz.getNumPlacas();
								}
							} else {
								numeroPlacas += frenteTipoBarniz.getNumPlacas();
								numeroPlacas += vueltaTipoBarniz.getNumPlacas();
							}
							
							frenteTipoBarniz = null;
							vueltaTipoBarniz = null;
							
							cantidadPliegos -= tamanio.getNumeroDecimal();
						} else 
							break;
					} while (cantidadPliegos > 0);
				}
				
				cotizacionGranCosteTotal += tintaGranCosteTotal;
				cotizacionGranCosteTotal += tintaEspecialGranCosteTotal;
				cotizacionGranCosteTotal += barnizGranCosteTotal;
				
				// OBTENCION PRECIO PAPEL
				tipoPapelExtendido = tipoPapelExtendidoService.buscaTipoPapelExtendido(idTipoPapelExtendido);
				precioUnitarioTipoPapelExtendido = (tipoPapelExtendido.getPrecio() / tipoPapelExtendido.getTipoPrecio().getFactorDivisor()) * (1 + porcentajeGananciaCliente);
				papelCosteTotal = (papelCantidadTotal + papelSobranteCantidadTotal) * precioUnitarioTipoPapelExtendido;
				tipoPapelExtendido = null;
				if (incluyeCostoPapel)
					cotizacionGranCosteTotal += papelCosteTotal;
				
				System.out.println("numeroPlacas:"+ numeroPlacas);
				// OBTENCION PLACAS
				tipoPlaca = tipoPlacaService.buscaTipoPlaca(idTipoPlaca);
				placasPrecioUnitario = (tipoPlaca.getPrecio() / tipoPlaca.getTipoPrecio().getFactorDivisor()) * (1 + porcentajeGananciaCliente);
				placasCosteTotal = numeroPlacas * placasPrecioUnitario;
				tipoPlaca = null;
				if ( incluyeCostoPlaca )
					cotizacionGranCosteTotal += placasCosteTotal;
				
				// COTIZACION
				cotizadorExpress.setPapelDescripcion(papelCantidadTotal + " + " + papelSobranteCantidadTotal + " [" + String.format("%.3f", precioUnitarioTipoPapelExtendido) + "]" );
				cotizadorExpress.setTintaDescripcion(tintaDescripcion.toString());
				cotizadorExpress.setTintaEspecialDescripcion(tintaEspecialDescripcion.toString());
				cotizadorExpress.setBarnizDescripcion(barnizDescripcion.toString());
				cotizadorExpress.setPlacasDescripcion(numeroPlacas + " [" + String.format("%.2f", placasPrecioUnitario) + "]");
				
				cotizadorExpress.setPapelCosteTotal(papelCosteTotal);
				cotizadorExpress.setTintaCosteTotal(tintaGranCosteTotal);
				cotizadorExpress.setTintaEspecialCosteTotal(tintaEspecialGranCosteTotal);
				cotizadorExpress.setBarnizCosteTotal(barnizGranCosteTotal);
				cotizadorExpress.setPlacasCosteTotal(placasCosteTotal);
				cotizadorExpress.setCotizacionCosteTotal(cotizacionGranCosteTotal);
				
				tamanioPublicacion = null;
				break;
			case TIPO_TRABAJO_OTRO:
				break;
			default:
				break;
		}
		
		frenteCombinacionTintas = null;
		vueltaCombinacionTintas = null;
								
		return cotizadorExpress;
	}
	
}
