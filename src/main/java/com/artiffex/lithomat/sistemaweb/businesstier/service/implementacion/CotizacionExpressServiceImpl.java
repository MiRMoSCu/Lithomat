package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.CotizacionExpressDTOResultado;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.CotizacionExpressDTOVariables;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CombinacionTintas;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.PapelSobrante;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TamanioPublicacion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoBarniz;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoCliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPlaca;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CombinacionTintasService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CotizacionExpressService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PapelSobranteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TamanioPublicacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TintaEspecialService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoBarnizService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPapelExtendidoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPlacaService;

@Service("cotizacionExpressService")
public class CotizacionExpressServiceImpl implements CotizacionExpressService {
	
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
	private TipoPlacaService tipoPlacaService;
	@Resource
	private TamanioPublicacionService tamanioPublicacionService;
	@Resource
	private PapelSobranteService papelSobranteService;

		
	public CotizacionExpressDTOResultado calculaCotizacionExpress(CotizacionExpressDTOVariables cotizacionExpressDTOVariables) {
		
		// INICIALIZACION DE OBJETOS
		CotizacionExpressDTOResultado cotizadorExpress 	= new CotizacionExpressDTOResultado();
		CombinacionTintas frenteCombinacionTintas 		= combinacionTintasService.buscaCombinacionTintas(cotizacionExpressDTOVariables.getFrenteIdCombinacionTintas());
		CombinacionTintas vueltaCombinacionTintas 		= combinacionTintasService.buscaCombinacionTintas(cotizacionExpressDTOVariables.getVueltaIdCombinacionTintas());
		TipoCliente tipoCliente 						= tipoClienteService.buscaTipoCliente(cotizacionExpressDTOVariables.getIdTipoCliente());
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
		
		// INICIALIZACION VARIABLES REVISTA/OTRO 
		StringBuilder tintaDescripcion 			= new StringBuilder();
		StringBuilder tintaEspecialDescripcion 	= new StringBuilder();
		StringBuilder barnizDescripcion			= new StringBuilder();
		List<TamanioPublicacion> listaTamanio 	= null;
		TamanioPublicacion tamanioPublicacion 	= null;
		int papelCantidadTotal				= 0;
		int papelSobranteCantidadTotal		= 0;
		float cotizacionGranCosteTotal		= 0;
		float tintaGranCosteTotal			= 0;
		float tintaEspecialGranCosteTotal	= 0;
		float barnizGranCosteTotal			= 0;
		
		// CALCULOS CORRESPONDIENTES A TODOS LOS TIPOS DE TRABAJO
			// TIPO CLIENTE
		float porcentajeGananciaCliente = tipoCliente.getPrecio() / tipoCliente.getTipoPrecio().getFactorDivisor();
		tipoCliente = null;
		
		switch (cotizacionExpressDTOVariables.getIdTipoTrabajo()) {
			case TIPO_TRABAJO_FLYER:
				// INICIALIZACION DE VARIABLES
				// la cantidad de papel verdadera que entrara a impresion es (cantidad/repeticiones); este valor define el precio del tabulador
				
				// CANTIDAD
				cantidadImpresion = (int) Math.ceil( (double) cotizacionExpressDTOVariables.getCantidad() / (double) cotizacionExpressDTOVariables.getRepeticionesXPliego() ); 
				
				// CANTIDAD REAL
				cantidadRedondeada 	= 0;
				if ( cantidadImpresion <= 100 )
					cantidadRedondeada = 1000;
				else if ( (cantidadImpresion % 1000 ) > 300 )
					cantidadRedondeada = ( ( cantidadImpresion / 1000 ) + 1 ) * 1000;
				else 
					cantidadRedondeada = cantidadImpresion;
				
				// PRECIO TABULADOR
				precioUnitarioTabulador = tabuladorPreciosService.obtienePrecioUnitarioTabulador( 1, cotizacionExpressDTOVariables.getIdMaquina(), cantidadRedondeada );
				precioUnitarioTabulador = precioUnitarioTabulador * (1 + porcentajeGananciaCliente);
				
				// CALCULO PAPEL SOBRANTE
				papelSobrante = new PapelSobrante();
				papelSobrante.setInicioTabulador(cantidadImpresion + 1);
				papelSobrante.setFinTabulador(cantidadImpresion - 1);
				papelSobrante.setFrenteNumTinta(frenteCombinacionTintas.getNumTintas());
				papelSobrante.setVueltaNumTinta(vueltaCombinacionTintas.getNumTintas());
				papelSobrante.setTintaEspecial( cotizacionExpressDTOVariables.getFrenteNumeroTintaEspecial() > 0 || cotizacionExpressDTOVariables.getVueltaNumeroTintaEspecial() > 0 ? true : false);
				hojasSobrantes = papelSobranteService.buscaHojasSobrante(papelSobrante);
				papelSobrante = null;
				
				// OBTENCION PRECIO PAPEL
				tipoPapelExtendido = tipoPapelExtendidoService.buscaTipoPapelExtendido(cotizacionExpressDTOVariables.getIdTipoPapelExtendido());
				precioUnitarioTipoPapelExtendido = (tipoPapelExtendido.getPrecio() / tipoPapelExtendido.getTipoPrecio().getFactorDivisor()) * (1 + porcentajeGananciaCliente);
				papelCosteTotal = (cantidadImpresion + hojasSobrantes) * precioUnitarioTipoPapelExtendido;
				tipoPapelExtendido = null;
				if (cotizacionExpressDTOVariables.isIncluyeCostoPapel()) 
					cotizacionCosteTotal += papelCosteTotal;
				
				
				// CALCULO TINTA
				if ( cotizacionExpressDTOVariables.isVueltaMismasPlacas() ) {
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
				tintaEspecialNumEntMaq = cotizacionExpressDTOVariables.getFrenteNumeroTintaEspecial() + cotizacionExpressDTOVariables.getVueltaNumeroTintaEspecial();
				numeroPlacas += cotizacionExpressDTOVariables.getFrenteNumeroTintaEspecial();
				if ( !cotizacionExpressDTOVariables.isVueltaMismasPlacas() )
					numeroPlacas += cotizacionExpressDTOVariables.getVueltaNumeroTintaEspecial();
				// OBTENCION PRECIO TINTA ESPECIAL
				tintaEspecialPrecioUnitario = precioUnitarioTabulador * (1 + ((Float)hashTintaEspecialPrecio.get("precio") / Integer.parseInt(hashTintaEspecialPrecio.get("factorDivisor").toString())));
				tintaEspecialCosteTotal = cantidadRedondeada * tintaEspecialNumEntMaq * tintaEspecialPrecioUnitario;
				hashTintaEspecialPrecio = null;
				
				cotizacionCosteTotal += tintaEspecialCosteTotal;
				
				
				// OBTENCION PRECIO BARNIZ FRENTE
				frenteTipoBarniz = tipoBarnizService.buscaTipoBarniz(cotizacionExpressDTOVariables.getFrenteIdTipoBarniz());
				frenteBarnizNumEnt = frenteTipoBarniz.getNumEntradasMaquina();
				frenteBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (frenteTipoBarniz.getPrecio() / frenteTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
				frenteBarnizCosteTotal = cantidadRedondeada * frenteBarnizNumEnt * frenteBarnizPrecioUnitario;
				
				cotizacionCosteTotal += frenteBarnizCosteTotal;
				
				// OBTENCION PRECIO BARNIZ VUELTA
				vueltaTipoBarniz = tipoBarnizService.buscaTipoBarniz(cotizacionExpressDTOVariables.getVueltaIdTipoBarniz());
				vueltaBarnizNumEnt = vueltaTipoBarniz.getNumEntradasMaquina();
				vueltaBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (vueltaTipoBarniz.getPrecio() / vueltaTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
				vueltaBarnizCosteTotal = cantidadRedondeada * vueltaBarnizNumEnt* vueltaBarnizPrecioUnitario;
				
				cotizacionCosteTotal += vueltaBarnizCosteTotal;
				
				// BARNIZ PLACAS
				if (cotizacionExpressDTOVariables.isVueltaMismasPlacas()) {
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
				tipoPlaca = tipoPlacaService.buscaTipoPlaca(cotizacionExpressDTOVariables.getIdTipoPlaca());
				placasPrecioUnitario = (tipoPlaca.getPrecio() / tipoPlaca.getTipoPrecio().getFactorDivisor()) * (1 + porcentajeGananciaCliente);
				placasCosteTotal = numeroPlacas * placasPrecioUnitario;
				tipoPlaca = null;
				if (cotizacionExpressDTOVariables.isIncluyeCostoPlaca())
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
				// conocer el numero de pliegos 40/16 = 2.5
				// 2 pliegos que tienen una tabulador especifico
				// 0.5 pliego que tiene otro tabulador especifico
				
				// INICIALIZACION DE VARIABLES
				listaTamanio = tamanioPublicacionService.listaDecimales();
				tamanioPublicacion = tamanioPublicacionService.buscaTamanioPublicacion(cotizacionExpressDTOVariables.getIdTamanioPublicacion());
				// CANTIDAD
				float cantidadPliegos = (float)cotizacionExpressDTOVariables.getNumeroPaginasPublicacion() / (float)tamanioPublicacion.getNumeroPaginas();
				
				for (TamanioPublicacion tamanio : listaTamanio) {
					if (cantidadPliegos > 0) {
						do {
							if (cantidadPliegos >= tamanio.getNumeroDecimal()) {
								// cantidad impresion = hojas buenas que se necesitan
								cantidadImpresion = (int) Math.ceil(tamanio.getNumeroDecimal() * cotizacionExpressDTOVariables.getCantidad());
								
								// PRECIO TABULADOR
								cantidadRedondeada = 0;
								if ( cantidadImpresion <= 100 )
									cantidadRedondeada = 1000;
								else if ( (cantidadImpresion % 1000 ) > 300 )
									cantidadRedondeada = ( ( cantidadImpresion / 1000 ) + 1 ) * 1000;
								else 
									cantidadRedondeada = cantidadImpresion;
								
								precioUnitarioTabulador = tabuladorPreciosService.obtienePrecioUnitarioTabulador( 1, cotizacionExpressDTOVariables.getIdMaquina(), cantidadRedondeada );
								precioUnitarioTabulador = precioUnitarioTabulador * (1 + porcentajeGananciaCliente);
								
								// CALCULO PAPEL SOBRANTE
								papelSobrante = new PapelSobrante();
								papelSobrante.setInicioTabulador(cantidadImpresion + 1);
								papelSobrante.setFinTabulador(cantidadImpresion - 1);
								papelSobrante.setFrenteNumTinta(frenteCombinacionTintas.getNumTintas());
								papelSobrante.setVueltaNumTinta(vueltaCombinacionTintas.getNumTintas());
								papelSobrante.setTintaEspecial( cotizacionExpressDTOVariables.getFrenteNumeroTintaEspecial() > 0 || cotizacionExpressDTOVariables.getVueltaNumeroTintaEspecial() > 0 ? true : false);
								hojasSobrantes = papelSobranteService.buscaHojasSobrante(papelSobrante);
								papelCantidadTotal += cantidadImpresion;
								papelSobranteCantidadTotal += hojasSobrantes;
								papelSobrante = null;
								
								// CALCULO TINTA
								if (cotizacionExpressDTOVariables.isVueltaMismasPlacas()) {
									if (tamanio.getNumeroDecimal() == (float)1) {
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
								tintaEspecialNumEntMaq = cotizacionExpressDTOVariables.getFrenteNumeroTintaEspecial() + cotizacionExpressDTOVariables.getVueltaNumeroTintaEspecial();
								numeroPlacas += cotizacionExpressDTOVariables.getFrenteNumeroTintaEspecial();
								if (!cotizacionExpressDTOVariables.isVueltaMismasPlacas())
									numeroPlacas += cotizacionExpressDTOVariables.getVueltaNumeroTintaEspecial();
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
								frenteTipoBarniz = tipoBarnizService.buscaTipoBarniz(cotizacionExpressDTOVariables.getFrenteIdTipoBarniz());
								frenteBarnizNumEnt = frenteTipoBarniz.getNumEntradasMaquina();
								frenteBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (frenteTipoBarniz.getPrecio() / frenteTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
								frenteBarnizCosteTotal = cantidadRedondeada * frenteBarnizNumEnt * frenteBarnizPrecioUnitario;
								// SUMA GRAN TOTAL BARNIZ
								barnizGranCosteTotal += frenteBarnizCosteTotal;
								
								vueltaTipoBarniz = tipoBarnizService.buscaTipoBarniz(cotizacionExpressDTOVariables.getVueltaIdTipoBarniz());
								vueltaBarnizNumEnt = vueltaTipoBarniz.getNumEntradasMaquina();
								vueltaBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (vueltaTipoBarniz.getPrecio() / vueltaTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
								vueltaBarnizCosteTotal = cantidadRedondeada * vueltaBarnizNumEnt* vueltaBarnizPrecioUnitario;
								// SUMA GRAN TOTAL BARNIZ
								barnizGranCosteTotal += vueltaBarnizCosteTotal;
								
								// barniz descripcion
								barnizDescripcion.append("F:" + frenteBarnizNumEnt + " [" + String.format("%.3f", frenteBarnizPrecioUnitario) + "] V:" + vueltaBarnizNumEnt + " [" + String.format("%.3f", vueltaBarnizPrecioUnitario) + "]");
								barnizDescripcion.append(", ");
								
								
								// BARNIZ PLACAS
								if (cotizacionExpressDTOVariables.isVueltaMismasPlacas()) {
									if (tamanio.getNumeroDecimal() == (float)1) {
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
					} else
						break;
				} // for
				
				cotizacionGranCosteTotal += tintaGranCosteTotal;
				cotizacionGranCosteTotal += tintaEspecialGranCosteTotal;
				cotizacionGranCosteTotal += barnizGranCosteTotal;
				
				// OBTENCION PRECIO PAPEL
				tipoPapelExtendido = tipoPapelExtendidoService.buscaTipoPapelExtendido(cotizacionExpressDTOVariables.getIdTipoPapelExtendido());
				precioUnitarioTipoPapelExtendido = (tipoPapelExtendido.getPrecio() / tipoPapelExtendido.getTipoPrecio().getFactorDivisor()) * (1 + porcentajeGananciaCliente);
				papelCosteTotal = (papelCantidadTotal + papelSobranteCantidadTotal) * precioUnitarioTipoPapelExtendido;
				tipoPapelExtendido = null;
				if (cotizacionExpressDTOVariables.isIncluyeCostoPapel())
					cotizacionGranCosteTotal += papelCosteTotal;
				
				// OBTENCION PLACAS
				tipoPlaca = tipoPlacaService.buscaTipoPlaca(cotizacionExpressDTOVariables.getIdTipoPlaca());
				placasPrecioUnitario = (tipoPlaca.getPrecio() / tipoPlaca.getTipoPrecio().getFactorDivisor()) * (1 + porcentajeGananciaCliente);
				placasCosteTotal = numeroPlacas * placasPrecioUnitario;
				tipoPlaca = null;
				if (cotizacionExpressDTOVariables.isIncluyeCostoPlaca())
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
				// ya conocemos el numero de pliegos
				// INICIALIZACION DE VARIABLES
				float numeroPliegos = cotizacionExpressDTOVariables.getNumeroPliegos();
				listaTamanio = tamanioPublicacionService.listaDecimales();
				for (TamanioPublicacion tamanio : listaTamanio) {
					if (numeroPliegos > 0) {
						do {
							if (numeroPliegos >= tamanio.getNumeroDecimal()) {
								cantidadImpresion = (int) Math.ceil(tamanio.getNumeroDecimal() * cotizacionExpressDTOVariables.getCantidad());
								
								// PRECIO TABULADOR
								cantidadRedondeada = 0;
								if ( cantidadImpresion <= 100 )
									cantidadRedondeada = 1000;
								else if ( (cantidadImpresion % 1000 ) > 300 )
									cantidadRedondeada = ( ( cantidadImpresion / 1000 ) + 1 ) * 1000;
								else 
									cantidadRedondeada = cantidadImpresion;
								
								precioUnitarioTabulador = tabuladorPreciosService.obtienePrecioUnitarioTabulador( 1, cotizacionExpressDTOVariables.getIdMaquina(), cantidadRedondeada );
								precioUnitarioTabulador = precioUnitarioTabulador * (1 + porcentajeGananciaCliente);
								
								// CALCULO PAPEL SOBRANTE
								papelSobrante = new PapelSobrante();
								papelSobrante.setInicioTabulador(cantidadImpresion + 1);
								papelSobrante.setFinTabulador(cantidadImpresion - 1);
								papelSobrante.setFrenteNumTinta(frenteCombinacionTintas.getNumTintas());
								papelSobrante.setVueltaNumTinta(vueltaCombinacionTintas.getNumTintas());
								papelSobrante.setTintaEspecial( cotizacionExpressDTOVariables.getFrenteNumeroTintaEspecial() > 0 || cotizacionExpressDTOVariables.getVueltaNumeroTintaEspecial() > 0 ? true : false);
								hojasSobrantes = papelSobranteService.buscaHojasSobrante(papelSobrante);
								papelCantidadTotal += cantidadImpresion;
								papelSobranteCantidadTotal += hojasSobrantes;
								papelSobrante = null;
								
								// CALCULO TINTA
								if (cotizacionExpressDTOVariables.isVueltaMismasPlacas()) {
									if (tamanio.getNumeroDecimal() == (float)1) {
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
								tintaEspecialNumEntMaq = cotizacionExpressDTOVariables.getFrenteNumeroTintaEspecial() + cotizacionExpressDTOVariables.getVueltaNumeroTintaEspecial();
								numeroPlacas += cotizacionExpressDTOVariables.getFrenteNumeroTintaEspecial();
								if (!cotizacionExpressDTOVariables.isVueltaMismasPlacas())
									numeroPlacas += cotizacionExpressDTOVariables.getVueltaNumeroTintaEspecial();
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
								frenteTipoBarniz = tipoBarnizService.buscaTipoBarniz(cotizacionExpressDTOVariables.getFrenteIdTipoBarniz());
								frenteBarnizNumEnt = frenteTipoBarniz.getNumEntradasMaquina();
								frenteBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (frenteTipoBarniz.getPrecio() / frenteTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
								frenteBarnizCosteTotal = cantidadRedondeada * frenteBarnizNumEnt * frenteBarnizPrecioUnitario;
								// SUMA GRAN TOTAL BARNIZ
								barnizGranCosteTotal += frenteBarnizCosteTotal;
								
								vueltaTipoBarniz = tipoBarnizService.buscaTipoBarniz(cotizacionExpressDTOVariables.getVueltaIdTipoBarniz());
								vueltaBarnizNumEnt = vueltaTipoBarniz.getNumEntradasMaquina();
								vueltaBarnizPrecioUnitario = precioUnitarioTabulador * ( 1 + (vueltaTipoBarniz.getPrecio() / vueltaTipoBarniz.getTipoPrecio().getFactorDivisor() ) );
								vueltaBarnizCosteTotal = cantidadRedondeada * vueltaBarnizNumEnt* vueltaBarnizPrecioUnitario;
								// SUMA GRAN TOTAL BARNIZ
								barnizGranCosteTotal += vueltaBarnizCosteTotal;
								
								// barniz descripcion
								barnizDescripcion.append("F:" + frenteBarnizNumEnt + " [" + String.format("%.3f", frenteBarnizPrecioUnitario) + "] V:" + vueltaBarnizNumEnt + " [" + String.format("%.3f", vueltaBarnizPrecioUnitario) + "]");
								barnizDescripcion.append(", ");
								
								
								// BARNIZ PLACAS
								if (cotizacionExpressDTOVariables.isVueltaMismasPlacas()) {
									if (tamanio.getNumeroDecimal() == (float)1) {
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
								
								numeroPliegos -= tamanio.getNumeroDecimal();
							} else
								break;
						} while (numeroPliegos > 0);
					} else
						break;
				}
				cotizacionGranCosteTotal += tintaGranCosteTotal;
				cotizacionGranCosteTotal += tintaEspecialGranCosteTotal;
				cotizacionGranCosteTotal += barnizGranCosteTotal;
				
				// OBTENCION PRECIO PAPEL
				tipoPapelExtendido = tipoPapelExtendidoService.buscaTipoPapelExtendido(cotizacionExpressDTOVariables.getIdTipoPapelExtendido());
				precioUnitarioTipoPapelExtendido = (tipoPapelExtendido.getPrecio() / tipoPapelExtendido.getTipoPrecio().getFactorDivisor()) * (1 + porcentajeGananciaCliente);
				papelCosteTotal = (papelCantidadTotal + papelSobranteCantidadTotal) * precioUnitarioTipoPapelExtendido;
				tipoPapelExtendido = null;
				if (cotizacionExpressDTOVariables.isIncluyeCostoPapel())
					cotizacionGranCosteTotal += papelCosteTotal;
				
				// OBTENCION PLACAS
				tipoPlaca = tipoPlacaService.buscaTipoPlaca(cotizacionExpressDTOVariables.getIdTipoPlaca());
				placasPrecioUnitario = (tipoPlaca.getPrecio() / tipoPlaca.getTipoPrecio().getFactorDivisor()) * (1 + porcentajeGananciaCliente);
				placasCosteTotal = numeroPlacas * placasPrecioUnitario;
				tipoPlaca = null;
				if (cotizacionExpressDTOVariables.isIncluyeCostoPlaca())
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
			default:
				break;
		}
		
		frenteCombinacionTintas 	= null;
		vueltaCombinacionTintas 	= null;
		tipoCliente 				= null;
		papelSobrante				= null;
		tipoPapelExtendido 			= null;
		tipoPlaca					= null;
		hashTintaEspecialPrecio		= null;
		frenteTipoBarniz 			= null;
		vueltaTipoBarniz 			= null;
		tintaDescripcion 			= null;
		tintaEspecialDescripcion 	= null;
		barnizDescripcion			= null;
		
		return cotizadorExpress;
	}

}
