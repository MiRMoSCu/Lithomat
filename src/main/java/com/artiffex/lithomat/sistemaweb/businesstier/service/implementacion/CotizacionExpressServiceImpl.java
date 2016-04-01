package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
		CotizacionExpressDTOResultado cotizadorExpressDTOResultado 	= new CotizacionExpressDTOResultado();
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
				cotizadorExpressDTOResultado.setPapelDescripcion(cantidadImpresion + " + " + hojasSobrantes + " [" + String.format("%.3f", precioUnitarioTipoPapelExtendido) + "]");
				cotizadorExpressDTOResultado.setTintaDescripcion(tintaNumEntMaq + " [" + String.format("%.3f", tintaPrecioUnitario) + "]");
				cotizadorExpressDTOResultado.setTintaEspecialDescripcion(tintaEspecialNumEntMaq + " [" + String.format("%.3f", tintaEspecialPrecioUnitario) + "]" );
				cotizadorExpressDTOResultado.setBarnizDescripcion("F:" + frenteBarnizNumEnt + " [" + String.format("%.3f", frenteBarnizPrecioUnitario) + "] V:" + vueltaBarnizNumEnt + " [" + String.format("%.3f", vueltaBarnizPrecioUnitario) + "]");
				cotizadorExpressDTOResultado.setPlacasDescripcion(numeroPlacas + " [" + String.format("%.2f", placasPrecioUnitario) + "]" );
				
				cotizadorExpressDTOResultado.setPapelCosteTotal(papelCosteTotal);
				cotizadorExpressDTOResultado.setTintaCosteTotal(tintaCosteTotal);
				cotizadorExpressDTOResultado.setTintaEspecialCosteTotal(tintaEspecialCosteTotal);
				cotizadorExpressDTOResultado.setBarnizCosteTotal(frenteBarnizCosteTotal + vueltaBarnizCosteTotal);
				cotizadorExpressDTOResultado.setPlacasCosteTotal(placasCosteTotal);
				cotizadorExpressDTOResultado.setCotizacionCosteTotal(cotizacionCosteTotal);
				
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
				cotizadorExpressDTOResultado.setPapelDescripcion(papelCantidadTotal + " + " + papelSobranteCantidadTotal + " [" + String.format("%.3f", precioUnitarioTipoPapelExtendido) + "]" );
				cotizadorExpressDTOResultado.setTintaDescripcion(tintaDescripcion.toString());
				cotizadorExpressDTOResultado.setTintaEspecialDescripcion(tintaEspecialDescripcion.toString());
				cotizadorExpressDTOResultado.setBarnizDescripcion(barnizDescripcion.toString());
				cotizadorExpressDTOResultado.setPlacasDescripcion(numeroPlacas + " [" + String.format("%.2f", placasPrecioUnitario) + "]");
				
				cotizadorExpressDTOResultado.setPapelCosteTotal(papelCosteTotal);
				cotizadorExpressDTOResultado.setTintaCosteTotal(tintaGranCosteTotal);
				cotizadorExpressDTOResultado.setTintaEspecialCosteTotal(tintaEspecialGranCosteTotal);
				cotizadorExpressDTOResultado.setBarnizCosteTotal(barnizGranCosteTotal);
				cotizadorExpressDTOResultado.setPlacasCosteTotal(placasCosteTotal);
				cotizadorExpressDTOResultado.setCotizacionCosteTotal(cotizacionGranCosteTotal);
				
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
				cotizadorExpressDTOResultado.setPapelDescripcion(papelCantidadTotal + " + " + papelSobranteCantidadTotal + " [" + String.format("%.3f", precioUnitarioTipoPapelExtendido) + "]" );
				cotizadorExpressDTOResultado.setTintaDescripcion(tintaDescripcion.toString());
				cotizadorExpressDTOResultado.setTintaEspecialDescripcion(tintaEspecialDescripcion.toString());
				cotizadorExpressDTOResultado.setBarnizDescripcion(barnizDescripcion.toString());
				cotizadorExpressDTOResultado.setPlacasDescripcion(numeroPlacas + " [" + String.format("%.2f", placasPrecioUnitario) + "]");
				
				cotizadorExpressDTOResultado.setPapelCosteTotal(papelCosteTotal);
				cotizadorExpressDTOResultado.setTintaCosteTotal(tintaGranCosteTotal);
				cotizadorExpressDTOResultado.setTintaEspecialCosteTotal(tintaEspecialGranCosteTotal);
				cotizadorExpressDTOResultado.setBarnizCosteTotal(barnizGranCosteTotal);
				cotizadorExpressDTOResultado.setPlacasCosteTotal(placasCosteTotal);
				cotizadorExpressDTOResultado.setCotizacionCosteTotal(cotizacionGranCosteTotal);
				
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
		
		return cotizadorExpressDTOResultado;
	}


	public byte[] obtieneExcelCotizacionExpress(CotizacionExpressDTOVariables cotizacionExpressDTOVariables) {
		CotizacionExpressDTOResultado cotizadorExpressDTOResultado = calculaCotizacionExpress(cotizacionExpressDTOVariables);
		
		// generacion del excel
		HSSFWorkbook wb = new HSSFWorkbook();
		try {
			// estilos
				// alineacion izquierda
			HSSFCellStyle cellStyle_izquierda = wb.createCellStyle();
			cellStyle_izquierda.setAlignment((short)HSSFCellStyle.ALIGN_LEFT);
				// alineacion centro
			HSSFCellStyle cellStyle_centro = wb.createCellStyle();
			cellStyle_centro.setAlignment((short)HSSFCellStyle.ALIGN_CENTER);
			
			// crecion de la hoja
			HSSFSheet sheet = wb.createSheet("Cotizacion Express");
			
			// CREACION FILA 1
			HSSFRow row_0 = sheet.createRow(0);
			// CREACION DE COLUMNAS
			row_0.createCell(1).setCellValue( "DESCRIPCION" );
			row_0.createCell(2).setCellValue( "PRECIO" );
						
			
			// CREACION FILA 1
			HSSFRow row_1 = sheet.createRow(1);
			// CREACION DE COLUMNAS
			HSSFCell cell_papel = row_1.createCell(0);
			cell_papel.setCellValue("PAPEL:");
			cell_papel.setCellStyle(cellStyle_izquierda);
			row_1.createCell(1).setCellValue( cotizadorExpressDTOResultado.getPapelDescripcion() );
			//row_1.createCell(2).setCellValue( String.format("%.2f", cotizadorExpressDTOResultado.getPapelCosteTotal() ) );
			row_1.createCell(2).setCellValue( cotizadorExpressDTOResultado.getPapelCosteTotal() );
			if (!cotizacionExpressDTOVariables.isIncluyeCostoPapel())
				row_1.createCell(3).setCellValue("ESTE PRECIO NO APLICA EN LA SUMATORIA");
			
			// CREACION FILA 2
			HSSFRow row_2 = sheet.createRow(2);
			// CREACION DE COLUMNAS
			HSSFCell cell_tinta = row_2.createCell(0);
			cell_tinta.setCellValue("TINTA:");
			cell_tinta.setCellStyle(cellStyle_izquierda);
			row_2.createCell(1).setCellValue( cotizadorExpressDTOResultado.getTintaDescripcion() );
			//row_2.createCell(2).setCellValue( String.format("%.2f", cotizadorExpressDTOResultado.getTintaCosteTotal() ) );
			row_2.createCell(2).setCellValue( cotizadorExpressDTOResultado.getTintaCosteTotal() );
			
			// CREACION FILA 3
			HSSFRow row_3 = sheet.createRow(3);
			// CREACION DE COLUMNAS
			HSSFCell cell_tinta_esp = row_3.createCell(0);
			cell_tinta_esp.setCellValue("TINTA ESPECIAL:");
			cell_tinta_esp.setCellStyle(cellStyle_izquierda);
			row_3.createCell(1).setCellValue( cotizadorExpressDTOResultado.getTintaEspecialDescripcion() );
			//row_3.createCell(2).setCellValue( String.format("%.2f", cotizadorExpressDTOResultado.getTintaEspecialCosteTotal() ) );
			row_3.createCell(2).setCellValue( cotizadorExpressDTOResultado.getTintaEspecialCosteTotal() );
			
			// CREACION FILA 4
			HSSFRow row_4 = sheet.createRow(4);
			// CREACION DE COLUMNAS
			HSSFCell cell_tinta_barniz = row_4.createCell(0);
			cell_tinta_barniz.setCellValue("BARNIZ:");
			cell_tinta_barniz.setCellStyle(cellStyle_izquierda);
			row_4.createCell(1).setCellValue( cotizadorExpressDTOResultado.getBarnizDescripcion() );
			//row_4.createCell(2).setCellValue( String.format("%.2f", cotizadorExpressDTOResultado.getBarnizCosteTotal() ) );
			row_4.createCell(2).setCellValue( cotizadorExpressDTOResultado.getBarnizCosteTotal() );
			
			// CREACION FILA 5
			HSSFRow row_5 = sheet.createRow(5);
			// CREACION DE COLUMNAS
			HSSFCell cell_tinta_placas = row_5.createCell(0);
			cell_tinta_placas.setCellValue("PLACAS:");
			cell_tinta_placas.setCellStyle(cellStyle_izquierda);
			row_5.createCell(1).setCellValue( cotizadorExpressDTOResultado.getPlacasDescripcion() );
			//row_5.createCell(2).setCellValue( String.format("%.2f", cotizadorExpressDTOResultado.getPlacasCosteTotal() ) );
			row_5.createCell(2).setCellValue(cotizadorExpressDTOResultado.getPlacasCosteTotal() );
			if (!cotizacionExpressDTOVariables.isIncluyeCostoPlaca())
				row_5.createCell(3).setCellValue("ESTE PRECIO NO APLICA EN LA SUMATORIA");
			
			// CREACION FILA 6
			HSSFRow row_6 = sheet.createRow(6);
			// CREACION DE COLUMNAS
			HSSFCell cell_tinta_precio_total = row_6.createCell(0);
			cell_tinta_precio_total.setCellValue("PRECIO TOTAL:");
			cell_tinta_precio_total.setCellStyle(cellStyle_izquierda);
			//row_6.createCell(2).setCellValue( String.format("%.2f", cotizadorExpressDTOResultado.getCotizacionCosteTotal() ) );
			row_6.createCell(2).setCellValue( cotizadorExpressDTOResultado.getCotizacionCosteTotal() );
			
			wb.close();
		} catch( Exception e ) {
			System.out.println("obtieneExcelCotizacionExpress:Error al generar el archivo de excel");
		}
		
		// creacion del stream
		ByteArrayOutputStream os;
		try {
			os = new ByteArrayOutputStream();
			wb.write(os);
			return os.toByteArray();
		} catch( Exception e ) {
			System.out.println("obtieneExcelCotizacionExpress:Error al convertir a stream");
			e.printStackTrace();
			return null;
		}
	}

}
