package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.ayuda.CalificacionTrabajoDetalleDTOAyuda;
import com.artiffex.lithomat.sistemaweb.ayuda.OrdenProduccionDTOAyuda;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.AcabadoDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.AcabadoDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.DisenioDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.DisenioDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.MaterialAyudaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.OffsetDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.PreprensaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.PreprensaDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.ReporteCotizacionDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.TransporteDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.TransporteDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaterialAyudaXPartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OffsetService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TintaEspecialService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.OrdenTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.OrdenTrabajoPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.OrdenTrabajoPliego;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.OrdenTrabajoTipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.RemisionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.RemisionPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.RemisionPliego;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.RemisionTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionOrdenProduccionDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionPartidaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionPliegoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionTrabajoDetalleDAO;
import com.google.gson.Gson;

@Service("resumenCalificacionService")
public class CalificacionServiceImpl implements CalificacionService {

	// DAO
	@Resource
	private CalificacionOrdenProduccionDAO calificacionOrdenProduccionDAO;
	@Resource
	private CalificacionPartidaDAO calificacionPartidaDAO;
	@Resource
	private CalificacionTrabajoDetalleDAO calificacionTrabajoDetalleDAO;
	@Resource
	private CalificacionPliegoDAO calificacionPliegoDAO;
	// Service
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private PartidaService partidaService;
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private PliegoService pliegoService;
	@Resource
	private TabuladorPreciosService tabuladorPreciosService;
	@Resource
	private DisenioService disenioService;
	@Resource
	private DisenioDetalleService disenioDetalleService;
	@Resource
	private PreprensaService preprensaService;
	@Resource
	private PreprensaDetalleService preprensaDetalleService;
	@Resource
	private TransporteService transporteService;
	@Resource
	private TransporteDetalleService transporteDetalleService;
	@Resource
	private AcabadoService acabadoService;
	@Resource
	private AcabadoDetalleService acabadoDetalleService;
	@Resource
	private OffsetService offsetService;
	@Resource
	private MaterialAyudaXPartidaService materialAyudaXPartidaService;
	@Resource
	private TintaEspecialService tintaEspecialService;
	
	
	
	public int creaCalificacion(int idOrdenProduccion) {

		// orden produccion: 	2
		// partidas: 			2.1 	y 	2.2
		// subpartidas: 		2.1.1	y 	2.2.1, 2.2.2

		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccion(idOrdenProduccion);
		
		// precio_bruto = sumatoria(partida[n].coste_total_procesos_partida) donde n = 1,...,m
		double precioBruto	= 0;
		
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(idOrdenProduccion);
		for (Partida partida : listaPartida) {
			
			// subpartidas_coste_total = sumatoria(trabajo_detalle[n].coste_total_tipo_trabajo_detalle) donde n = 1,...,m
			double partidaCosteTotal		 	= 0;
			double impresionPartidaCosteTotal	= 0;
			double procesosPartidaCosteTotal 	= 0;
			double disenioCosteTotal 			= 0;
			double preprensaCosteTotal 			= 0;
			double transporteCosteTotal 		= 0;
			double acabadoCosteTotal			= 0;
			double offsetCosteTotal 			= 0;
			double costoExtraTotal 				= 0;
			
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for(TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle ) {
				
				// *** INICIALIZACION ***
				// tipo_trabajo_detalle_coste_total = (papel_coste + placas_coste + tinta_coste + tinta_especial_coste + barniz_coste) POR CADA PLIEGO
				double tipoTrabajoDetalleCosteTotal				= 0;
				double trabajoDetallePapelCosteTotal			= 0;
				double trabajoDetallePlacasCosteTotal			= 0;
				double trabajoDetalleTintaCosteTotal			= 0;
				double trabajoDetalleTintaEspecialCosteTotal	= 0;
				double trabajoDetalleFrenteBarnizCosteTotal		= 0;
				double trabajoDetalleVueltaBarnizCosteTotal		= 0;
				// * tipo complejidad
				int idTipoComplejidad = tipoTrabajoDetalle.getTipoComplejidad().getIdTipoComplejidad();
				// * maquina
				int idMaquina = tipoTrabajoDetalle.getMaquina().getIdMaquina();
				
				List<Pliego> listaPliego = pliegoService.listaPliegoPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				for (Pliego pliego : listaPliego) {
					
					// hojas requeridas original 
					int hojasRequeridasOriginal 		= pliego.getHojasRequeridas();
					
					// hojas requeridas redondeo --> para buscar el tabulador de precio correcto
					int hojasRequeridasRedondeo 		= 0;
					if (hojasRequeridasOriginal <= 1000)
						hojasRequeridasRedondeo = 1000;
					else if ((hojasRequeridasOriginal % 1000) > 300)
						hojasRequeridasRedondeo = ((hojasRequeridasOriginal / 1000) + 1) * 1000;
					else
						hojasRequeridasRedondeo = (hojasRequeridasOriginal / 1000) * 1000;
					
					// precio_tabulador correspondiente a las hojas requeridas redondeadas
					float precioUnitarioTabulador 		= tabuladorPreciosService.obtienePrecioUnitarioTabulador(idTipoComplejidad, idMaquina, hojasRequeridasRedondeo);
					
					// papel
					int papelCantidadTotal 				= pliego.getHojasTotales();
					float papelPrecioUnitario 			= tipoTrabajoDetalle.getTipoPapelExtendido().getPrecio() / tipoTrabajoDetalle.getTipoPapelExtendido().getTipoPrecio().getFactorDivisor();
					double papelCosteTotal 				= papelCantidadTotal * papelPrecioUnitario;
					trabajoDetallePapelCosteTotal		+= papelCosteTotal;
					
					// placas
					int placasNumPlacas					= pliego.getFrenteNumTotalPlacas() + pliego.getVueltaNumTotalPlacas();
					float placasPrecioUnitario			= tipoTrabajoDetalle.getTipoPlaca().getPrecio() / tipoTrabajoDetalle.getTipoPlaca().getTipoPrecio().getFactorDivisor();
					double placasCosteTotal				= placasNumPlacas * placasPrecioUnitario;
					trabajoDetallePlacasCosteTotal		+= placasCosteTotal;
					
					// tiro tinta
					int tintaNumEntMaq					= pliego.getFrenteNumEntradasMaquinaTinta() + pliego.getVueltaNumEntradasMaquinaTinta();
					float tintaPrecioUnitario			= precioUnitarioTabulador;
					double tintaCosteTotal				= hojasRequeridasRedondeo * tintaNumEntMaq * tintaPrecioUnitario;
					trabajoDetalleTintaCosteTotal		+= tintaCosteTotal;
					
					// tiro tinta especial	// SE PUEDE HACER MAS FACIL AL BUSCAR EL UNICO REGISTRO
					HashMap<String, Object> hashTintaEspecialPrecio = tintaEspecialService.getHashPrecioYTipoPrecio();
					int tintaEspecialNumEntMaq			= pliego.getFrenteNumEntradasMaquinaTintaEspecial() + pliego.getVueltaNumEntradasMaquinaTintaEspecial();
					float tintaEspecialPrecioUnitario	= precioUnitarioTabulador * (1 + ((Float)hashTintaEspecialPrecio.get("precio") / Integer.parseInt(hashTintaEspecialPrecio.get("factorDivisor").toString())));
					double tintaEspecialCosteTotal		= hojasRequeridasRedondeo * tintaEspecialNumEntMaq * tintaEspecialPrecioUnitario;
					hashTintaEspecialPrecio 			= null;
					trabajoDetalleTintaEspecialCosteTotal	+= tintaEspecialCosteTotal;
					
					// tiro frente barniz
					int frenteBarnizNumEntMaq			= pliego.getFrenteNumEntradasMaquinaBarniz();
					float frenteBarnizPrecioUnitario	= precioUnitarioTabulador * (1 + (tipoTrabajoDetalle.getFrenteTipoBarniz().getPrecio() / tipoTrabajoDetalle.getFrenteTipoBarniz().getTipoPrecio().getFactorDivisor()));
					double frenteBarnizCosteTotal		= hojasRequeridasRedondeo * frenteBarnizNumEntMaq * frenteBarnizPrecioUnitario;
					trabajoDetalleFrenteBarnizCosteTotal += frenteBarnizCosteTotal;
					
					// tipo vuelta barniz
					int vueltaBarnizNumEntMaq			= pliego.getVueltaNumEntradasMaquinaBarniz();
					float vueltaBarnizPrecioUnitario	= precioUnitarioTabulador * (1 + (tipoTrabajoDetalle.getVueltaTipoBarniz().getPrecio() / tipoTrabajoDetalle.getVueltaTipoBarniz().getTipoPrecio().getFactorDivisor()));
					double vueltaBarnizCosteTotal		= hojasRequeridasRedondeo * vueltaBarnizNumEntMaq * vueltaBarnizPrecioUnitario;
					trabajoDetalleVueltaBarnizCosteTotal += vueltaBarnizCosteTotal;
					
					// SUMATORIA DE COSTES
					double pliegoCosteTotal				= 0;
					if (!tipoTrabajoDetalle.isClienteProporcionaPapel()) {
						pliegoCosteTotal += papelCosteTotal;
					}
					if (!tipoTrabajoDetalle.isClienteProporcionaPlacas()) {
						pliegoCosteTotal += placasCosteTotal;
					}
					if (!tipoTrabajoDetalle.isClienteProporcionaTinta()) {
						pliegoCosteTotal += tintaCosteTotal;
					}
					if (!tipoTrabajoDetalle.isClienteProporcionaTintaEspecial()) {
						pliegoCosteTotal += tintaEspecialCosteTotal;
					}
					if (!tipoTrabajoDetalle.isClienteProporcionaBarniz()) {
						pliegoCosteTotal += frenteBarnizCosteTotal;
						pliegoCosteTotal += vueltaBarnizCosteTotal;
					}
					
					// sumatoria de costes pliegos
					tipoTrabajoDetalleCosteTotal += pliegoCosteTotal;
					
					CalificacionPliego calificacionPliego = new CalificacionPliego();
					
					calificacionPliego.setPliego(pliego);
					calificacionPliego.setPliegoCosteTotal(pliegoCosteTotal);
					calificacionPliego.setHojasRequeridasOriginal(hojasRequeridasOriginal);
					calificacionPliego.setHojasRequeridasRedondeo(hojasRequeridasRedondeo);
					calificacionPliego.setPrecioUnitarioTabulador(precioUnitarioTabulador);
					calificacionPliego.setPapelCantidadTotal(papelCantidadTotal);
					calificacionPliego.setPapelPrecioUnitario(papelPrecioUnitario);
					calificacionPliego.setPapelCosteTotal(papelCosteTotal);
					calificacionPliego.setPlacasNumPlacas(placasNumPlacas);
					calificacionPliego.setPlacasPrecioUnitario(placasPrecioUnitario);
					calificacionPliego.setPlacasCosteTotal(placasCosteTotal);
					calificacionPliego.setTintaNumEntMaq(tintaNumEntMaq);
					calificacionPliego.setTintaPrecioUnitario(tintaPrecioUnitario);
					calificacionPliego.setTintaCosteTotal(tintaCosteTotal);
					calificacionPliego.setTintaEspecialNumEntMaq(tintaEspecialNumEntMaq);
					calificacionPliego.setTintaEspecialPrecioUnitario(tintaEspecialPrecioUnitario);
					calificacionPliego.setTintaEspecialCosteTotal(tintaEspecialCosteTotal);
					calificacionPliego.setFrenteBarnizNumEntMaq(frenteBarnizNumEntMaq);
					calificacionPliego.setFrenteBarnizPrecioUnitario(frenteBarnizPrecioUnitario);
					calificacionPliego.setFrenteBarnizCosteTotal(frenteBarnizCosteTotal);
					calificacionPliego.setVueltaBarnizNumEntMaq(vueltaBarnizNumEntMaq);
					calificacionPliego.setVueltaBarnizPrecioUnitario(vueltaBarnizPrecioUnitario);
					calificacionPliego.setVueltaBarnizCosteTotal(vueltaBarnizCosteTotal);
					calificacionPliego.setActivo(true);
					
					calificacionPliegoDAO.crea(calificacionPliego);
					
					calificacionPliego 	= null;
					pliego 				= null;
				}
				listaPliego = null;
				
				// sumatoria coste impresion
				impresionPartidaCosteTotal += tipoTrabajoDetalleCosteTotal;
				
				// creacion de registro calificacion trabajo detalle
				CalificacionTrabajoDetalle calificacionTrabajoDetalle = new CalificacionTrabajoDetalle();

				calificacionTrabajoDetalle.setTipoTrabajoDetalle(tipoTrabajoDetalle);
				calificacionTrabajoDetalle.setTipoTrabajoDetalleCosteTotal(tipoTrabajoDetalleCosteTotal);
				calificacionTrabajoDetalle.setPapelCosteTotal(trabajoDetallePapelCosteTotal);
				calificacionTrabajoDetalle.setPlacasCosteTotal(trabajoDetallePlacasCosteTotal);
				calificacionTrabajoDetalle.setTintaCosteTotal(trabajoDetalleTintaCosteTotal);
				calificacionTrabajoDetalle.setTintaEspecialCosteTotal(trabajoDetalleTintaEspecialCosteTotal);
				calificacionTrabajoDetalle.setFrenteBarnizCosteTotal(trabajoDetalleFrenteBarnizCosteTotal);
				calificacionTrabajoDetalle.setVueltaBarnizCosteTotal(trabajoDetalleVueltaBarnizCosteTotal);
				calificacionTrabajoDetalle.setActivo(true);

				calificacionTrabajoDetalleDAO.crea(calificacionTrabajoDetalle);
				
				calificacionTrabajoDetalle 	= null;
				tipoTrabajoDetalle			= null;
			}
			listaTipoTrabajoDetalle = null;
			
			// obtencion del precio de impresion
			partidaCosteTotal			= impresionPartidaCosteTotal;
			
			disenioCosteTotal 			= partidaService.obtieneDisenioCosteTotal(partida.getIdPartida());
			preprensaCosteTotal 		= partidaService.obtienePreprensaCosteTotal(partida.getIdPartida());
			transporteCosteTotal 		= partidaService.obtieneTransporteCosteTotal(partida.getIdPartida());
			acabadoCosteTotal 			= partidaService.obtieneAcabadoCosteTotal(partida.getIdPartida());
			offsetCosteTotal 			= 0;
			costoExtraTotal 			= partidaService.obtieneCostoExtraCosteTotal(partida.getIdPartida());
			
			// obtencion del precio total procesos
			procesosPartidaCosteTotal += disenioCosteTotal;
			procesosPartidaCosteTotal += preprensaCosteTotal;
			procesosPartidaCosteTotal += transporteCosteTotal;
			procesosPartidaCosteTotal += acabadoCosteTotal;
			procesosPartidaCosteTotal += offsetCosteTotal;
			procesosPartidaCosteTotal += costoExtraTotal;

			// obtencion del precio total: impresion + procesos
			partidaCosteTotal += procesosPartidaCosteTotal;
			
			// SUMATORIA PRECIO_BRUTO
			precioBruto += partidaCosteTotal;
			
			// creacion de registro
			CalificacionPartida calificacionPartida = new CalificacionPartida();
			
			calificacionPartida.setPartida(partida);
			calificacionPartida.setCantidadOriginal(partida.getCantidad());
			calificacionPartida.setPartidaCosteTotal(partidaCosteTotal);
			calificacionPartida.setImpresionPartidaCosteTotal(impresionPartidaCosteTotal);
			calificacionPartida.setProcesosPartidaCosteTotal(procesosPartidaCosteTotal);
			calificacionPartida.setDisenioCosteTotal(disenioCosteTotal);
			calificacionPartida.setPreprensaCosteTotal(preprensaCosteTotal);
			calificacionPartida.setTransporteCosteTotal(transporteCosteTotal);
			calificacionPartida.setAcabadoCosteTotal(acabadoCosteTotal);
			calificacionPartida.setOffsetCosteTotal(offsetCosteTotal);
			calificacionPartida.setCostoExtraTotal(costoExtraTotal);
			calificacionPartida.setActivo(true);
			
			calificacionPartidaDAO.crea(calificacionPartida);
			
			calificacionPartida = null;
			partida				= null;
		}
		listaPartida = null;
		
		// *** ***** ***
		// PRECIO CLIENTE
		float porcentajeTipoCliente = ordenProduccion.getCliente().getTipoCliente().getPrecio() / ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor();
		float precioCliente = (float)precioBruto * (1 + porcentajeTipoCliente);
		
		// *** ***** ***
		// PRECIO TIPO COMPROBANTE
		float porcentajeTipoComprobante = ordenProduccion.getTipoComprobanteFiscal().getPrecio() / ordenProduccion.getTipoComprobanteFiscal().getTipoPrecio().getFactorDivisor();
		float porcentajeComprobante = precioCliente * (1 + porcentajeTipoComprobante);
		float precioNeto = porcentajeTipoComprobante == 0 ? precioCliente : porcentajeComprobante;
		
		// *** ***** ***
		// creacion de registro
		CalificacionOrdenProduccion calificacionOrdenProduccion = new CalificacionOrdenProduccion();
			
		calificacionOrdenProduccion.setOrdenProduccion(ordenProduccion);
		calificacionOrdenProduccion.setPrecioBruto(precioBruto);
		calificacionOrdenProduccion.setTipoClientePrecio(ordenProduccion.getCliente().getTipoCliente().getPrecio());
		calificacionOrdenProduccion.setTipoClienteFactorDivisor(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor());
		calificacionOrdenProduccion.setPrecioCliente(precioCliente);
		calificacionOrdenProduccion.setPorcentajeDescuento(0);
		calificacionOrdenProduccion.setPrecioClienteConDescuento(precioCliente);
		calificacionOrdenProduccion.setPrecioNeto(precioNeto);
		calificacionOrdenProduccion.setFechaGeneracion(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		calificacionOrdenProduccion.setActivo(true);

		calificacionOrdenProduccionDAO.crea(calificacionOrdenProduccion);
		
		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;

		return 1;
	} // creaCalificacion
	
	/********* PANTALLA *********/
	
	public CalificacionOrdenProduccion buscaCalificacionOrdenProduccion(int idOrdenProduccion) {
		return calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(idOrdenProduccion);
	} // buscaCalificacionOrdenProduccion
	
	public CalificacionPartida buscaCalificacionPartida(int idPartida) {
		return calificacionPartidaDAO.buscaPorPartida(idPartida);
	} // buscaCalificacionPartida

	public CalificacionTrabajoDetalle buscaCalificacionTrabajoDetalle(int idTipoTrabajoDetalle) {
		return calificacionTrabajoDetalleDAO.buscaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
	} // buscaCalificacionTrabajoDetalle
	
	public CalificacionPliego buscaCalificacionPliego(int idPliego) {
		return calificacionPliegoDAO.buscaPorPliego(idPliego);
	} // buscaCalificacionPliego
	
	/********* ACTUALIZACION *********/
	
	public void actualizaOrdenProduccion(int idOrdenProduccion) {
		System.out.println("CalificacionService.actualizaOrdenProduccion");
		
		// UNICAMENTE se ha modificado datos en la tabla orden_produccion.
		// no es necesario hacer el calculo de toda la informacion en las tablas:
		// calificacion_procesos_partida
		// calificacion_trabajo_detalle
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccion(idOrdenProduccion);
		CalificacionOrdenProduccion cop = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(idOrdenProduccion);
		float precioBruto = (float)cop.getPrecioBruto();
		
		// *** ***** ***
		// PRECIO CLIENTE
		float porcentajeTipoCliente = ordenProduccion.getCliente().getTipoCliente().getPrecio() / ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor();
		float precioCliente = precioBruto * (1 + porcentajeTipoCliente);
		
		// *** ***** ***
		// PRECIO CLIENTE CON DESCUENTO
		float precioClienteConDescuento = precioCliente;
		if ( cop.getPorcentajeDescuento() > 0 ) 
			precioClienteConDescuento = precioCliente - (precioCliente * ((float)cop.getPorcentajeDescuento() / 100));
		
		// *** ***** ***
		// PRECIO TIPO COMPROBANTE
		float porcentajeTipoComprobante = ordenProduccion.getTipoComprobanteFiscal().getPrecio() / ordenProduccion.getTipoComprobanteFiscal().getTipoPrecio().getFactorDivisor();
		float porcentajeComprobante = precioClienteConDescuento * (1 + porcentajeTipoComprobante);
		float precioNeto = porcentajeTipoComprobante == 0 ? precioClienteConDescuento : porcentajeComprobante;
		
		// *** ***** ***
		// actualización de datos
		cop.setPrecioBruto(precioBruto);
		cop.setTipoClientePrecio(ordenProduccion.getCliente().getTipoCliente().getPrecio());
		cop.setTipoClienteFactorDivisor(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor());
		cop.setPrecioCliente(precioCliente);
		cop.setPrecioClienteConDescuento(precioClienteConDescuento);
		cop.setPrecioNeto(precioNeto);
		cop.setFechaGeneracion(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		cop.setObservaciones("registro modificado en la fecha: fecha_generacion");

		calificacionOrdenProduccionDAO.modifica(cop); // UPDATE
		
		ordenProduccion				= null;
		cop 						= null;
		
	} // actualizaOrdenProduccion
	
	
	public void actualizaPartida(int idOrdenProduccion) {
		
		// DEBIDO a que se han modificado datos en la tabla partida,
		// como puede ser el campo cantidad, esto
		// modifica el numero total de hojas a comprar,
		// modifica el numero de entradas a maquina, porque cambia el tabulador, etc.
		// POR LO TANTO, es necesario hacer el calculo del proceso completo 
		// en la tabla: calificacion_trabajo_detalle.
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccion(idOrdenProduccion);
		
		// precio_bruto = sumatoria(partida[n].coste_total_procesos_partida) donde n = 1,...,m
		double precioBruto = 0;
		
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(idOrdenProduccion);
		for (Partida partida : listaPartida) {
			
			// subpartidas_coste_total = sumatoria(trabajo_detalle[n].coste_total_tipo_trabajo_detalle) donde n = 1,...,m
			double partidaCosteTotal		 	= 0;
			double impresionPartidaCosteTotal	= 0;
			double procesosPartidaCosteTotal 	= 0;
			double disenioCosteTotal 			= 0;
			double preprensaCosteTotal 			= 0;
			double transporteCosteTotal 		= 0;
			double acabadoCosteTotal			= 0;
			double offsetCosteTotal 			= 0;
			double costoExtraTotal 				= 0;
			
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for(TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle ) {
				
				// *** INICIALIZACION ***
				// coste_total_tipo_trabajo_detalle = papel_coste + placas_coste + tinta_coste + tinta_especial_coste + barniz_coste
				double tipoTrabajoDetalleCosteTotal				= 0;
				double trabajoDetallePapelCosteTotal			= 0;
				double trabajoDetallePlacasCosteTotal			= 0;
				double trabajoDetalleTintaCosteTotal			= 0;
				double trabajoDetalleTintaEspecialCosteTotal	= 0;
				double trabajoDetalleFrenteBarnizCosteTotal		= 0;
				double trabajoDetalleVueltaBarnizCosteTotal		= 0;
				// * tipo complejidad
				int idTipoComplejidad = tipoTrabajoDetalle.getTipoComplejidad().getIdTipoComplejidad();
				// * maquina
				int idMaquina = tipoTrabajoDetalle.getMaquina().getIdMaquina();
				
				List<Pliego> listaPliego = pliegoService.listaPliegoPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				for (Pliego pliego : listaPliego) {
					
					// hojas requeridas original 
					int hojasRequeridasOriginal 		= pliego.getHojasRequeridas();
					
					// hojas requeridas redondeo --> para buscar el tabulador de precio correcto
					int hojasRequeridasRedondeo 		= 0;
					if (hojasRequeridasOriginal <= 1000)
						hojasRequeridasRedondeo = 1000;
					else if ((hojasRequeridasOriginal % 1000) > 300)
						hojasRequeridasRedondeo = ((hojasRequeridasOriginal / 1000) + 1) * 1000;
					else
						hojasRequeridasRedondeo = (hojasRequeridasOriginal / 1000) * 1000;
					
					// precio_tabulador correspondiente a las hojas requeridas redondeadas
					float precioUnitarioTabulador 		= tabuladorPreciosService.obtienePrecioUnitarioTabulador(idTipoComplejidad, idMaquina, hojasRequeridasRedondeo);
					
					// papel
					int papelCantidadTotal 				= pliego.getHojasTotales();
					float papelPrecioUnitario 			= tipoTrabajoDetalle.getTipoPapelExtendido().getPrecio() / tipoTrabajoDetalle.getTipoPapelExtendido().getTipoPrecio().getFactorDivisor();
					double papelCosteTotal 				= papelCantidadTotal * papelPrecioUnitario;
					trabajoDetallePapelCosteTotal		+= papelCosteTotal;
					
					// placas
					int placasNumPlacas					= pliego.getFrenteNumTotalPlacas() + pliego.getVueltaNumTotalPlacas();
					float placasPrecioUnitario			= tipoTrabajoDetalle.getTipoPlaca().getPrecio() / tipoTrabajoDetalle.getTipoPlaca().getTipoPrecio().getFactorDivisor();
					double placasCosteTotal				= placasNumPlacas * placasPrecioUnitario;
					trabajoDetallePlacasCosteTotal		+= placasCosteTotal;
					
					// tiro tinta
					int tintaNumEntMaq					= pliego.getFrenteNumEntradasMaquinaTinta() + pliego.getVueltaNumEntradasMaquinaTinta();
					float tintaPrecioUnitario			= precioUnitarioTabulador;
					double tintaCosteTotal				= hojasRequeridasRedondeo * tintaNumEntMaq * tintaPrecioUnitario;
					trabajoDetalleTintaCosteTotal		+= tintaCosteTotal;
					
					// tiro tinta especial	// SE PUEDE HACER MAS FACIL AL BUSCAR EL UNICO REGISTRO
					HashMap<String, Object> hashTintaEspecialPrecio = tintaEspecialService.getHashPrecioYTipoPrecio();
					int tintaEspecialNumEntMaq			= pliego.getFrenteNumEntradasMaquinaTintaEspecial() + pliego.getVueltaNumEntradasMaquinaTintaEspecial();
					float tintaEspecialPrecioUnitario	= precioUnitarioTabulador * (1 + ((Float)hashTintaEspecialPrecio.get("precio") / Integer.parseInt(hashTintaEspecialPrecio.get("factorDivisor").toString())));
					double tintaEspecialCosteTotal		= hojasRequeridasRedondeo * tintaEspecialNumEntMaq * tintaEspecialPrecioUnitario;
					hashTintaEspecialPrecio 			= null;
					trabajoDetalleTintaEspecialCosteTotal	+= tintaEspecialCosteTotal;
					
					// tiro frente barniz
					int frenteBarnizNumEntMaq			= pliego.getFrenteNumEntradasMaquinaBarniz();
					float frenteBarnizPrecioUnitario	= precioUnitarioTabulador * (1 + (tipoTrabajoDetalle.getFrenteTipoBarniz().getPrecio() / tipoTrabajoDetalle.getFrenteTipoBarniz().getTipoPrecio().getFactorDivisor()));
					double frenteBarnizCosteTotal		= hojasRequeridasRedondeo * frenteBarnizNumEntMaq * frenteBarnizPrecioUnitario;
					trabajoDetalleFrenteBarnizCosteTotal += frenteBarnizCosteTotal;
					
					// tipo vuelta barniz
					int vueltaBarnizNumEntMaq			= pliego.getVueltaNumEntradasMaquinaBarniz();
					float vueltaBarnizPrecioUnitario	= precioUnitarioTabulador * (1 + (tipoTrabajoDetalle.getVueltaTipoBarniz().getPrecio() / tipoTrabajoDetalle.getVueltaTipoBarniz().getTipoPrecio().getFactorDivisor()));
					double vueltaBarnizCosteTotal		= hojasRequeridasRedondeo * vueltaBarnizNumEntMaq * vueltaBarnizPrecioUnitario;
					trabajoDetalleVueltaBarnizCosteTotal += vueltaBarnizCosteTotal;
					
					// SUMATORIA DE COSTES
					double pliegoCosteTotal				= 0;
					if (!tipoTrabajoDetalle.isClienteProporcionaPapel()) {
						pliegoCosteTotal += papelCosteTotal;
					}
					if (!tipoTrabajoDetalle.isClienteProporcionaPlacas()) {
						pliegoCosteTotal += placasCosteTotal;
					}
					if (!tipoTrabajoDetalle.isClienteProporcionaTinta()) {
						pliegoCosteTotal += tintaCosteTotal;
					}
					if (!tipoTrabajoDetalle.isClienteProporcionaTintaEspecial()) {
						pliegoCosteTotal += tintaEspecialCosteTotal;
					}
					if (!tipoTrabajoDetalle.isClienteProporcionaBarniz()) {
						pliegoCosteTotal += frenteBarnizCosteTotal;
						pliegoCosteTotal += vueltaBarnizCosteTotal;
					}
					
					// sumatoria de todos los costes de pliegos
					tipoTrabajoDetalleCosteTotal += pliegoCosteTotal;
					
					CalificacionPliego calificacionPliego = calificacionPliegoDAO.buscaPorPliego(pliego.getIdPliego());
					
					calificacionPliego.setPliegoCosteTotal(pliegoCosteTotal);
					calificacionPliego.setHojasRequeridasOriginal(hojasRequeridasOriginal);
					calificacionPliego.setHojasRequeridasRedondeo(hojasRequeridasRedondeo);
					calificacionPliego.setPrecioUnitarioTabulador(precioUnitarioTabulador);
					calificacionPliego.setPapelCantidadTotal(papelCantidadTotal);
					calificacionPliego.setPapelPrecioUnitario(papelPrecioUnitario);
					calificacionPliego.setPapelCosteTotal(papelCosteTotal);
					calificacionPliego.setPlacasNumPlacas(placasNumPlacas);
					calificacionPliego.setPlacasPrecioUnitario(placasPrecioUnitario);
					calificacionPliego.setPlacasCosteTotal(placasCosteTotal);
					calificacionPliego.setTintaNumEntMaq(tintaNumEntMaq);
					calificacionPliego.setTintaPrecioUnitario(tintaPrecioUnitario);
					calificacionPliego.setTintaCosteTotal(tintaCosteTotal);
					calificacionPliego.setTintaEspecialNumEntMaq(tintaEspecialNumEntMaq);
					calificacionPliego.setTintaEspecialPrecioUnitario(tintaEspecialPrecioUnitario);
					calificacionPliego.setTintaEspecialCosteTotal(tintaEspecialCosteTotal);
					calificacionPliego.setFrenteBarnizNumEntMaq(frenteBarnizNumEntMaq);
					calificacionPliego.setFrenteBarnizPrecioUnitario(frenteBarnizPrecioUnitario);
					calificacionPliego.setFrenteBarnizCosteTotal(frenteBarnizCosteTotal);
					calificacionPliego.setVueltaBarnizNumEntMaq(vueltaBarnizNumEntMaq);
					calificacionPliego.setVueltaBarnizPrecioUnitario(vueltaBarnizPrecioUnitario);
					calificacionPliego.setVueltaBarnizCosteTotal(vueltaBarnizCosteTotal);
					
					calificacionPliegoDAO.modifica(calificacionPliego);
					
					calificacionPliego	= null;
					pliego 				= null;
				}
				listaPliego = null;
				
				// sumatoria coste impresion
				impresionPartidaCosteTotal += tipoTrabajoDetalleCosteTotal;
				
				// modificacion de registro
				CalificacionTrabajoDetalle calificacionTrabajoDetalle = calificacionTrabajoDetalleDAO.buscaPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				
				calificacionTrabajoDetalle.setTipoTrabajoDetalleCosteTotal(tipoTrabajoDetalleCosteTotal);
				calificacionTrabajoDetalle.setPapelCosteTotal(trabajoDetallePapelCosteTotal);
				calificacionTrabajoDetalle.setPlacasCosteTotal(trabajoDetallePlacasCosteTotal);
				calificacionTrabajoDetalle.setTintaCosteTotal(trabajoDetalleTintaCosteTotal);
				calificacionTrabajoDetalle.setTintaEspecialCosteTotal(trabajoDetalleTintaEspecialCosteTotal);
				calificacionTrabajoDetalle.setFrenteBarnizCosteTotal(trabajoDetalleFrenteBarnizCosteTotal);
				calificacionTrabajoDetalle.setVueltaBarnizCosteTotal(trabajoDetalleVueltaBarnizCosteTotal);
				
				calificacionTrabajoDetalleDAO.modifica(calificacionTrabajoDetalle);
				
				calificacionTrabajoDetalle 	= null;
				tipoTrabajoDetalle			= null;
			}
			listaTipoTrabajoDetalle = null;
			
			// obtencion del precio de impresion
			partidaCosteTotal			= impresionPartidaCosteTotal;
			
			disenioCosteTotal 			= partidaService.obtieneDisenioCosteTotal(partida.getIdPartida());
			preprensaCosteTotal 		= partidaService.obtienePreprensaCosteTotal(partida.getIdPartida());
			transporteCosteTotal 		= partidaService.obtieneTransporteCosteTotal(partida.getIdPartida());
			acabadoCosteTotal 			= partidaService.obtieneAcabadoCosteTotal(partida.getIdPartida());
			offsetCosteTotal 			= 0;
			costoExtraTotal 			= partidaService.obtieneCostoExtraCosteTotal(partida.getIdPartida());
			
			// obtencion del precio total procesos
			procesosPartidaCosteTotal += disenioCosteTotal;
			procesosPartidaCosteTotal += preprensaCosteTotal;
			procesosPartidaCosteTotal += transporteCosteTotal;
			procesosPartidaCosteTotal += acabadoCosteTotal;
			procesosPartidaCosteTotal += offsetCosteTotal;
			procesosPartidaCosteTotal += costoExtraTotal;
			
			// obtencion del precio total: impresion + procesos
			partidaCosteTotal += procesosPartidaCosteTotal;
			
			// SUMATORIA PRECIO_BRUTO
			precioBruto += partidaCosteTotal;
			
			// modificacionn de registro
			CalificacionPartida calificacionPartida = calificacionPartidaDAO.buscaPorPartida(partida.getIdPartida());
			
			calificacionPartida.setCantidadOriginal(partida.getCantidad());
			calificacionPartida.setPartidaCosteTotal(partidaCosteTotal);
			calificacionPartida.setImpresionPartidaCosteTotal(impresionPartidaCosteTotal);
			calificacionPartida.setProcesosPartidaCosteTotal(procesosPartidaCosteTotal);
			calificacionPartida.setDisenioCosteTotal(disenioCosteTotal);
			calificacionPartida.setPreprensaCosteTotal(preprensaCosteTotal);
			calificacionPartida.setTransporteCosteTotal(transporteCosteTotal);
			calificacionPartida.setAcabadoCosteTotal(acabadoCosteTotal);
			calificacionPartida.setOffsetCosteTotal(offsetCosteTotal);
			calificacionPartida.setCostoExtraTotal(costoExtraTotal);
			
			calificacionPartidaDAO.modifica(calificacionPartida);
			
			calificacionPartida = null;
			partida				= null;
		}
		listaPartida = null;
		
		// *** ***** ***
		// búsqueda de registro
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		
		// *** ***** ***
		// PRECIO CLIENTE
		float porcentajeTipoCliente = ordenProduccion.getCliente().getTipoCliente().getPrecio() / ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor();
		float precioCliente = (float)precioBruto * (1 + porcentajeTipoCliente);
		
		// *** ***** ***
		// PRECIO CLIENTE CON DESCUENTO
		float precioClienteConDescuento = precioCliente;
		if ( calificacionOrdenProduccion.getPorcentajeDescuento() > 0 ) 
			precioClienteConDescuento = precioCliente - (precioCliente * ((float)calificacionOrdenProduccion.getPorcentajeDescuento() / 100));

		// *** ***** ***
		// PRECIO TIPO COMPROBANTE
		float porcentajeTipoComprobante = ordenProduccion.getTipoComprobanteFiscal().getPrecio() / ordenProduccion.getTipoComprobanteFiscal().getTipoPrecio().getFactorDivisor();
		float porcentajeComprobante = precioClienteConDescuento * (1 + porcentajeTipoComprobante);
		float precioNeto = porcentajeTipoComprobante == 0 ? precioClienteConDescuento : porcentajeComprobante;
			
		calificacionOrdenProduccion.setPrecioBruto(precioBruto);
		calificacionOrdenProduccion.setTipoClientePrecio(ordenProduccion.getCliente().getTipoCliente().getPrecio());
		calificacionOrdenProduccion.setTipoClienteFactorDivisor(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor());
		calificacionOrdenProduccion.setPrecioCliente(precioCliente);
		calificacionOrdenProduccion.setPrecioClienteConDescuento(precioClienteConDescuento);
		calificacionOrdenProduccion.setPrecioNeto(precioNeto);
		calificacionOrdenProduccion.setFechaGeneracion(new Timestamp(Calendar.getInstance().getTimeInMillis()));

		calificacionOrdenProduccionDAO.modifica(calificacionOrdenProduccion);

		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;

	} // actualizaPartida
	
	
	public void actualizaProcesosPartida(int idOrdenProduccion) {
		
		// DEBIDO a que es posible que modifique el precio de algun proceso
		// es necesario obtener la sumatoria de: 
		// costos totales de disenio
		// costos totales de preprensa
		// costos totales de transporte
		// costos totales de acabado
		// costos totales de offset
		// costos totales de costo extra
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccion(idOrdenProduccion);
		
		double precioBruto = 0;
		
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(idOrdenProduccion);
		for (Partida partida : listaPartida) {
			
			// partida_coste_total = 
			//		impresion_partida_coste_total + (
			//			disenio + preprensa + transporte + acabado + offset + cosot_extra
			//		)
			
			//busqueda de registro
			CalificacionPartida calificacionPartida = calificacionPartidaDAO.buscaPorPartida(partida.getIdPartida());
			
			double partidaCosteTotal		 	= calificacionPartida.getImpresionPartidaCosteTotal();
			double procesosPartidaCosteTotal 	= 0;
			
			double disenioCosteTotal 			= partidaService.obtieneDisenioCosteTotal(partida.getIdPartida());
			double preprensaCosteTotal 			= partidaService.obtienePreprensaCosteTotal(partida.getIdPartida());
			double transporteCosteTotal 		= partidaService.obtieneTransporteCosteTotal(partida.getIdPartida());
			double acabadoCosteTotal 			= partidaService.obtieneAcabadoCosteTotal(partida.getIdPartida());
			double offsetCosteTotal 			= 0;
			double costoExtraTotal 				= partidaService.obtieneCostoExtraCosteTotal(partida.getIdPartida());
			
			// obtencion del precio total procesos
			procesosPartidaCosteTotal += disenioCosteTotal;
			procesosPartidaCosteTotal += preprensaCosteTotal;
			procesosPartidaCosteTotal += transporteCosteTotal;
			procesosPartidaCosteTotal += acabadoCosteTotal;
			procesosPartidaCosteTotal += offsetCosteTotal;
			procesosPartidaCosteTotal += costoExtraTotal;
			
			// obtencion del precio total: impresion + procesos
			partidaCosteTotal += procesosPartidaCosteTotal;
			
			// SUMATORIA PARA CALCULO PRECIO BRUTO
			precioBruto += partidaCosteTotal;
			
			// modificacion del registro
			calificacionPartida.setPartidaCosteTotal(partidaCosteTotal);
			calificacionPartida.setProcesosPartidaCosteTotal(procesosPartidaCosteTotal);
			calificacionPartida.setDisenioCosteTotal(disenioCosteTotal);
			calificacionPartida.setPreprensaCosteTotal(preprensaCosteTotal);
			calificacionPartida.setTransporteCosteTotal(transporteCosteTotal);
			calificacionPartida.setAcabadoCosteTotal(acabadoCosteTotal);
			calificacionPartida.setOffsetCosteTotal(offsetCosteTotal);
			calificacionPartida.setCostoExtraTotal(costoExtraTotal);
			
			calificacionPartidaDAO.modifica(calificacionPartida); // UPDATE
			
			calificacionPartida = null;
			partida				= null;
		}
		listaPartida = null;
		
		// *** ***** ***
		// busqueda de registro
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		
		// *** ***** ***
		// PRECIO CLIENTE
		float porcentajeTipoCliente = ordenProduccion.getCliente().getTipoCliente().getPrecio() / ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor();
		float precioCliente = (float)precioBruto * (1 + porcentajeTipoCliente);
		
		// *** ***** ***
		// PRECIO CLIENTE CON DESCUENTO
		float precioClienteConDescuento = precioCliente;
		if ( calificacionOrdenProduccion.getPorcentajeDescuento() > 0 ) 
			precioClienteConDescuento = precioCliente - (precioCliente * ((float)calificacionOrdenProduccion.getPorcentajeDescuento() / 100));
			
		// *** ***** ***
		// PRECIO TIPO COMPROBANTE
		float porcentajeTipoComprobante = ordenProduccion.getTipoComprobanteFiscal().getPrecio() / ordenProduccion.getTipoComprobanteFiscal().getTipoPrecio().getFactorDivisor();
		float porcentajeComprobante = precioClienteConDescuento * (1 + porcentajeTipoComprobante);
		float precioNeto = porcentajeTipoComprobante == 0 ? precioClienteConDescuento : porcentajeComprobante;
			
		calificacionOrdenProduccion.setPrecioBruto(precioBruto);
		calificacionOrdenProduccion.setTipoClientePrecio(ordenProduccion.getCliente().getTipoCliente().getPrecio());
		calificacionOrdenProduccion.setTipoClienteFactorDivisor(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor());
		calificacionOrdenProduccion.setPrecioCliente(precioCliente);
		calificacionOrdenProduccion.setPrecioClienteConDescuento(precioClienteConDescuento);
		calificacionOrdenProduccion.setPrecioNeto(precioNeto);
		calificacionOrdenProduccion.setFechaGeneracion(new Timestamp(Calendar.getInstance().getTimeInMillis()));

		calificacionOrdenProduccionDAO.modifica(calificacionOrdenProduccion);

		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;
	}
	
	
	public void actualizaDescuento(String nut, int porcentajeDescuento) {
		// busqueda de informacion
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		
		// modificacion de informacion
		System.out.println(porcentajeDescuento);
		calificacionOrdenProduccion.setPorcentajeDescuento(porcentajeDescuento);
			// calculo de precio_cliente_con_descuento
			float precioCliente = (float)calificacionOrdenProduccion.getPrecioCliente();
		
			// *** ***** ***
			// PRECIO CLIENTE CON DESCUENTO
			float precioClienteConDescuento = precioCliente - (precioCliente * ((float)porcentajeDescuento/100));
		calificacionOrdenProduccion.setPrecioClienteConDescuento(precioClienteConDescuento);
		
			// *** ***** ***
			// PRECIO TIPO COMPROBANTE
			float porcentajeTipoComprobante = ordenProduccion.getTipoComprobanteFiscal().getPrecio() / ordenProduccion.getTipoComprobanteFiscal().getTipoPrecio().getFactorDivisor();
			float porcentajeComprobante = precioClienteConDescuento * (1 + porcentajeTipoComprobante);
			float precioNeto = porcentajeTipoComprobante == 0 ? precioClienteConDescuento : porcentajeComprobante;
			System.out.println(precioNeto);
		calificacionOrdenProduccion.setPrecioNeto(precioNeto);
		
		calificacionOrdenProduccionDAO.modifica(calificacionOrdenProduccion); // UPDATE
		
		calificacionOrdenProduccion = null;
		ordenProduccion				= null;
	}
	
	/********* CONDICIONES PRODUCCION *********/
	
	public String obtieneCondicionesProduccion(String nut) {
		String condicionesProduccion = "";
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		condicionesProduccion = calificacionOrdenProduccion.getCondicionesProduccion();
		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;
		return condicionesProduccion;
	}
	
	
	public void guardaCondicionesProduccion(String nut, String condicionesProduccion) {
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		calificacionOrdenProduccion.setCondicionesProduccion(condicionesProduccion);
		calificacionOrdenProduccionDAO.modifica(calificacionOrdenProduccion);
		calificacionOrdenProduccion = null;
		ordenProduccion 			= null;
	}
	
	/********* REPORTES *********/
	
	public List<ReporteCotizacionDTO> obtieneListaPrecioCotizacionPartida(String nut) {
		List<ReporteCotizacionDTO> listaPartidaReporte = new ArrayList<ReporteCotizacionDTO>();
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		// obtiene el porcentaje de ganancia del cliente guardado en el registro de la base de datos y es != del que tiene el cliente actualmente
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		float porcentajeTipoCliente = calificacionOrdenProduccion.getTipoClientePrecio() / calificacionOrdenProduccion.getTipoClienteFactorDivisor();
		calificacionOrdenProduccion	= null;
		// busca las partidas
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		for (Partida partida : listaPartida) {
			ReporteCotizacionDTO partidaReporte = new ReporteCotizacionDTO();
			partidaReporte.setCantidad(partida.getCantidad());
			partidaReporte.setDescripcion(partida.getDescripcionPartida());
				CalificacionPartida cpp 				= calificacionPartidaDAO.buscaPorPartida(partida.getIdPartida());
				double costeTotalProcesosPartida 		= cpp.getPartidaCosteTotal();
				double costeGananciaRespectoTipoCliente = (double)(costeTotalProcesosPartida * (1 + porcentajeTipoCliente));
			partidaReporte.setPrecioUnitario( (double)(costeGananciaRespectoTipoCliente / partida.getCantidad()) );
			partidaReporte.setPrecioCliente( (double)costeGananciaRespectoTipoCliente );
			listaPartidaReporte.add(partidaReporte);
			cpp				= null;
			partidaReporte	= null;
			partida 		= null;
		}
		listaPartida				= null;
		ordenProduccion 			= null;
		
		return listaPartidaReporte;
	}
	
	
	public List<RemisionOrdenProduccion> obtieneRemisionPorNut(String nut) {
		
		// obtencion de informacion
		List<RemisionOrdenProduccion> listaRemisionOrdenProduccion = new ArrayList<RemisionOrdenProduccion>();
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		
		float porcentajeGananciaCliente 	= calificacionOrdenProduccion.getTipoClientePrecio() / calificacionOrdenProduccion.getTipoClienteFactorDivisor();
		String nombreCliente 				= ordenProduccion.getCliente().getNombreMoral();
		String nombreOrdenProduccion		= ordenProduccion.getNombre();
		double precioCliente				= calificacionOrdenProduccion.getPrecioCliente();
		int porcentajeDescuento				= calificacionOrdenProduccion.getPorcentajeDescuento();
		double precioClienteConDescuento	= calificacionOrdenProduccion.getPrecioClienteConDescuento();
		double precioNeto					= calificacionOrdenProduccion.getPrecioNeto();
		
		calificacionOrdenProduccion 	= null;
		
		RemisionOrdenProduccion remisionOrdenProduccion = new RemisionOrdenProduccion();
		remisionOrdenProduccion.setNut(nut);
		remisionOrdenProduccion.setNombreCliente(nombreCliente);
		remisionOrdenProduccion.setNombreOrdenProduccion(nombreOrdenProduccion);
		remisionOrdenProduccion.setPrecioCliente(precioCliente);
		remisionOrdenProduccion.setPorcentajeDescuento(porcentajeDescuento);
		remisionOrdenProduccion.setPrecioClienteConDescuento(precioClienteConDescuento);
		remisionOrdenProduccion.setPrecioNeto(precioNeto);
		
		// lista de remision necesaria para el reporte
		List<RemisionPartida> listaRemisionPartida = new ArrayList<RemisionPartida>();
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		for (Partida partida : listaPartida) {
			
			CalificacionPartida calificacionPartida = calificacionPartidaDAO.buscaPorPartida(partida.getIdPartida());
			
			String nombre						= partida.getNombrePartida();
			int cantidad						= partida.getCantidad();
			double procesosPartidaCosteTotal	= calificacionPartida.getProcesosPartidaCosteTotal() * (1 + porcentajeGananciaCliente);
			double disenioCosteTotal			= calificacionPartida.getDisenioCosteTotal() * (1 + porcentajeGananciaCliente);
			double preprensaCosteTotal			= calificacionPartida.getPreprensaCosteTotal() * (1 + porcentajeGananciaCliente);
			double transporteCosteTotal			= calificacionPartida.getTransporteCosteTotal() * (1 + porcentajeGananciaCliente);
			double acabadoCosteTotal			= calificacionPartida.getAcabadoCosteTotal() * (1 + porcentajeGananciaCliente);
			double offsetCosteTotal				= calificacionPartida.getOffsetCosteTotal() * (1 + porcentajeGananciaCliente);
			double costoExtraTotal				= calificacionPartida.getCostoExtraTotal() * (1 + porcentajeGananciaCliente);
			
			calificacionPartida = null;
			
			RemisionPartida remisionPartida = new RemisionPartida();
			remisionPartida.setNombre(nombre);
			remisionPartida.setCantidad(cantidad);
			remisionPartida.setProcesosPartidaCosteTotal(procesosPartidaCosteTotal);
			remisionPartida.setDisenioCosteTotal(disenioCosteTotal);
			remisionPartida.setPreprensaCosteTotal(preprensaCosteTotal);
			remisionPartida.setTransporteCosteTotal(transporteCosteTotal);
			remisionPartida.setAcabadoCosteTotal(acabadoCosteTotal);
			remisionPartida.setOffsetCosteTotal(offsetCosteTotal);
			remisionPartida.setCostoExtraTotal(costoExtraTotal);
			
			List<RemisionTrabajoDetalle> listaRemisionTrabajoDetalle = new ArrayList<RemisionTrabajoDetalle>();
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle) {
				
				CalificacionTrabajoDetalle calificacionTrabajoDetalle = calificacionTrabajoDetalleDAO.buscaPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				
				String descripcion 					= tipoTrabajoDetalle.getDescripcion();
				double tipoTrabajoDetalleCosteTotal	= calificacionTrabajoDetalle.getTipoTrabajoDetalleCosteTotal() * (1 + porcentajeGananciaCliente);
				
				calificacionTrabajoDetalle	= null;
				
				RemisionTrabajoDetalle remisionTrabajoDetalle = new RemisionTrabajoDetalle();
				remisionTrabajoDetalle.setDescripcion(descripcion);
				remisionTrabajoDetalle.setTipoTrabajoDetalleCosteTotal(tipoTrabajoDetalleCosteTotal);
				
				List<RemisionPliego> listaRemisionPliego = new ArrayList<RemisionPliego>();
				List<Pliego> listaPliego = pliegoService.listaPliegoPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				for (Pliego pliego : listaPliego) {
					
						StringBuffer sb = new StringBuffer();
						sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getNombre());
						sb.append(" ");
						sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getGramaje());
						sb.append(" gr. ");
						sb.append((int)tipoTrabajoDetalle.getTipoPapelExtendido().getAlto());
						sb.append(" x ");
						sb.append((int)tipoTrabajoDetalle.getTipoPapelExtendido().getAncho());
						sb.append(" cm. (");
						sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getKilogramos());
						sb.append(" kg.)");
					String papelDescripcion	= sb.toString();
						sb.delete(0, sb.length());
						sb.append("Tinta fte: ");
						sb.append(tipoTrabajoDetalle.getFrenteCombinacionTintas().getDescripcion());
						sb.append("; vta: ");
						sb.append(tipoTrabajoDetalle.getVueltaCombinacionTintas().getDescripcion());
					String tintaDescripcion = sb.toString();
						sb.delete(0, sb.length());
						sb.append("Tinta especial fte: ");
						sb.append(tipoTrabajoDetalle.getFrenteDescripcionTintaEspecial());
						sb.append("; vta; ");
						sb.append(tipoTrabajoDetalle.getVueltaDescripcionTintaEspecial());
					String tintaEspecialDescripcion = sb.toString();
						sb.delete(0, sb.length());
						sb.append("Barniz fte: ");
						sb.append(tipoTrabajoDetalle.getFrenteTipoBarniz().getDescripcion());
						sb.append("; vta: ");
						sb.append(tipoTrabajoDetalle.getVueltaTipoBarniz().getDescripcion());
					String barnizDescripcion = sb.toString();
					String placasDescripcion = tipoTrabajoDetalle.getTipoPlaca().getDescripcion();
						sb = null;
					
					CalificacionPliego calificacionPliego = calificacionPliegoDAO.buscaPorPliego(pliego.getIdPliego());
					
					int		hojasRequeridasRedondeo		= calificacionPliego.getHojasRequeridasRedondeo();
					double 	pliegoCosteTotal 			= calificacionPliego.getPliegoCosteTotal() * (1 + porcentajeGananciaCliente);
					int 	papelCantidadTotal			= calificacionPliego.getPapelCantidadTotal();
					float 	papelPrecioUnitario			= calificacionPliego.getPapelPrecioUnitario() * (1 + porcentajeGananciaCliente);
					double 	papelCosteTotal				= calificacionPliego.getPapelCosteTotal() * (1 + porcentajeGananciaCliente);
					int 	placasNumPlacas				= calificacionPliego.getPlacasNumPlacas();
					float 	placasPrecioUnitario		= calificacionPliego.getPlacasPrecioUnitario() * (1 + porcentajeGananciaCliente);
					double 	placasCosteTotal			= calificacionPliego.getPlacasCosteTotal() * (1 + porcentajeGananciaCliente);
					int 	tintaNumEntMaq				= calificacionPliego.getTintaNumEntMaq();
					float 	tintaPrecioUnitario			= calificacionPliego.getTintaPrecioUnitario() * (1 + porcentajeGananciaCliente);
					double 	tintaCosteTotal				= calificacionPliego.getTintaCosteTotal() * (1 + porcentajeGananciaCliente);
					int 	tintaEspecialNumEntMaq		= calificacionPliego.getTintaEspecialNumEntMaq();
					float 	tintaEspecialPrecioUnitario	= calificacionPliego.getTintaEspecialPrecioUnitario() * (1 + porcentajeGananciaCliente);
					double 	tintaEspecialCosteTotal		= calificacionPliego.getTintaEspecialCosteTotal() * (1 + porcentajeGananciaCliente);
					int 	frenteBarnizNumEntMaq		= calificacionPliego.getFrenteBarnizNumEntMaq();
					float 	frenteBarnizPrecioUnitario	= calificacionPliego.getFrenteBarnizPrecioUnitario() * (1 + porcentajeGananciaCliente);
					double 	frenteBarnizCosteTotal		= calificacionPliego.getFrenteBarnizCosteTotal() * (1 + porcentajeGananciaCliente);
					int 	vueltaBarnizNumEntMaq		= calificacionPliego.getVueltaBarnizNumEntMaq();
					float 	vueltaBarnizPrecioUnitario	= calificacionPliego.getVueltaBarnizPrecioUnitario() * (1 + porcentajeGananciaCliente);
					double 	vueltaBarnizCosteTotal		= calificacionPliego.getVueltaBarnizCosteTotal() * (1 + porcentajeGananciaCliente);
					
					calificacionPliego 	= null;
					
					RemisionPliego remisionPliego = new RemisionPliego();
					remisionPliego.setHojasRequeridasRedondeo(hojasRequeridasRedondeo);
					remisionPliego.setPliegoCosteTotal(pliegoCosteTotal);
					remisionPliego.setPapelDescripcion(papelDescripcion);
					remisionPliego.setPapelCantidadTotal(papelCantidadTotal);
					remisionPliego.setPapelPrecioUnitario(papelPrecioUnitario);
					remisionPliego.setPapelCosteTotal(papelCosteTotal);
					remisionPliego.setPlacasDescripcion(placasDescripcion);
					remisionPliego.setPlacasNumPlacas(placasNumPlacas);
					remisionPliego.setPlacasPrecioUnitario(placasPrecioUnitario);
					remisionPliego.setPlacasCosteTotal(placasCosteTotal);
					remisionPliego.setTintaDescripcion(tintaDescripcion);
					remisionPliego.setTintaNumEntMaq(tintaNumEntMaq);
					remisionPliego.setTintaPrecioUnitario(tintaPrecioUnitario);
					remisionPliego.setTintaCosteTotal(tintaCosteTotal);
					remisionPliego.setTintaEspecialDescripcion(tintaEspecialDescripcion);
					remisionPliego.setTintaEspecialNumEntMaq(tintaEspecialNumEntMaq);
					remisionPliego.setTintaEspecialPrecioUnitario(tintaEspecialPrecioUnitario);
					remisionPliego.setTintaEspecialCosteTotal(tintaEspecialCosteTotal);
					remisionPliego.setBarnizDescripcion(barnizDescripcion);
					remisionPliego.setFrenteBarnizNumEntMaq(frenteBarnizNumEntMaq);
					remisionPliego.setFrenteBarnizPrecioUnitario(frenteBarnizPrecioUnitario);
					remisionPliego.setFrenteBarnizCosteTotal(frenteBarnizCosteTotal);
					remisionPliego.setVueltaBarnizNumEntMaq(vueltaBarnizNumEntMaq);
					remisionPliego.setVueltaBarnizPrecioUnitario(vueltaBarnizPrecioUnitario);
					remisionPliego.setVueltaBarnizCosteTotal(vueltaBarnizCosteTotal);
					remisionPliego.setClienteProporcionaPapel(tipoTrabajoDetalle.isClienteProporcionaPapel());
					remisionPliego.setClienteProporcionaTinta(tipoTrabajoDetalle.isClienteProporcionaTinta());
					remisionPliego.setClienteProporcionaTintaEspecial(tipoTrabajoDetalle.isClienteProporcionaTintaEspecial());
					remisionPliego.setClienteProporcionaBarniz(tipoTrabajoDetalle.isClienteProporcionaBarniz());
					remisionPliego.setClienteProporcionaPlacas(tipoTrabajoDetalle.isClienteProporcionaPlacas());
					
					listaRemisionPliego.add(remisionPliego);
					
					remisionPliego 				= null;
					papelDescripcion			= null;
					placasDescripcion 			= null;
					tintaDescripcion 			= null;
					tintaEspecialDescripcion 	= null;
					barnizDescripcion 			= null;
					pliego 						= null;
				}
				listaPliego 			= null;
				remisionTrabajoDetalle.setListaRemisionPliego(listaRemisionPliego);
				listaRemisionPliego		= null;
				listaRemisionTrabajoDetalle.add(remisionTrabajoDetalle);
				descripcion				= null;
				remisionTrabajoDetalle	= null;
				tipoTrabajoDetalle 		= null;
			}
			listaTipoTrabajoDetalle 		= null;
			remisionPartida.setListaRemisionTrabajoDetalle(listaRemisionTrabajoDetalle);
			listaRemisionTrabajoDetalle	 	= null;
			listaRemisionPartida.add(remisionPartida);
			remisionPartida 				= null;
			nombre							= null;
			partida 						= null;
		}
		listaPartida 					= null;
		remisionOrdenProduccion.setListaRemisionPartida(listaRemisionPartida);
		listaRemisionOrdenProduccion.add(remisionOrdenProduccion);
		listaRemisionPartida 			= null;
		remisionOrdenProduccion			= null;
		nombreCliente 					= null;
		nombreOrdenProduccion			= null;
		ordenProduccion 				= null;
		
		//Gson gson = new Gson();
		//String json = gson.toJson( listaRemisionOrdenProduccion );
		//System.out.println("JSON:\n" + json);
		
		return listaRemisionOrdenProduccion;
	}
	
	
	public List<OrdenTrabajo> obtieneOrdenTrabajo(String nut) {
		List<OrdenTrabajo> listaOrdenTrabajo = new ArrayList<OrdenTrabajo>();
		
		OrdenTrabajo ot = new OrdenTrabajo();
		List<OrdenTrabajoPartida> listaOrdenTrabajoPartida = new ArrayList<OrdenTrabajoPartida>();
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		for (Partida partida : listaPartida) {
			//System.out.println("PARTIDA: " + partida.getDescripcionPartida());
			OrdenTrabajoPartida otp = new OrdenTrabajoPartida();
			List<OrdenTrabajoTipoTrabajoDetalle> listaOrdenTrabajoTipoTrabajoDetalle = new ArrayList<OrdenTrabajoTipoTrabajoDetalle>();
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle) {
				//System.out.println("TIPO TRABAJO DETALLE: " + tipoTrabajoDetalle.getDescripcion());
				OrdenTrabajoTipoTrabajoDetalle otttd = new OrdenTrabajoTipoTrabajoDetalle();
				List<OrdenTrabajoPliego> listaOrdenTrabajoPliego = new ArrayList<OrdenTrabajoPliego>();
				List<Pliego> listaPliegos = pliegoService.listaPliegoPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				int cont = 1;
				for (Pliego pliego : listaPliegos) {
					//System.out.println("PLIEGO: " + pliego.getIdPliego());
					OrdenTrabajoPliego otpl = new OrdenTrabajoPliego();
					otpl.setId(cont++);
					otpl.setPapel(tipoTrabajoDetalleService.obtienePapelDescripcionBasica(tipoTrabajoDetalle.getIdTipoTrabajoDetalle()));
					otpl.setHojasRequeridas(pliego.getHojasRequeridas());
					otpl.setHojasSobrantes(pliego.getHojasSobrantes());
					otpl.setHojasTotales(pliego.getHojasTotales());
						StringBuilder descripcionEntMaq = new StringBuilder();
						descripcionEntMaq.append(tipoTrabajoDetalle.getFrenteCombinacionTintas().getNumTintas());
						descripcionEntMaq.append(": ");
						descripcionEntMaq.append(tipoTrabajoDetalle.getFrenteCombinacionTintas().getDescripcion());
						if( tipoTrabajoDetalle.getFrenteNumTintaEspecial() > 0 ) {
							descripcionEntMaq.append(" + ");
							descripcionEntMaq.append(tipoTrabajoDetalle.getFrenteNumTintaEspecial() + tipoTrabajoDetalle.getVueltaNumTintaEspecial());
							descripcionEntMaq.append(" esp");
						}
						if( tipoTrabajoDetalle.getFrenteTipoBarniz().getNumEntradasMaquina() > 0 )
							descripcionEntMaq.append(" + B");
					otpl.setFrenteEntMaq(descripcionEntMaq.toString());
						descripcionEntMaq.delete(0, descripcionEntMaq.length());
						descripcionEntMaq.append(tipoTrabajoDetalle.getVueltaCombinacionTintas().getNumTintas());
						descripcionEntMaq.append(": ");
						descripcionEntMaq.append(tipoTrabajoDetalle.getVueltaCombinacionTintas().getDescripcion());
						if( tipoTrabajoDetalle.getVueltaNumTintaEspecial() > 0 ) {
							descripcionEntMaq.append(" + ");
							descripcionEntMaq.append(tipoTrabajoDetalle.getVueltaNumTintaEspecial());
							descripcionEntMaq.append(" esp");
						}
						if( tipoTrabajoDetalle.getVueltaTipoBarniz().getNumEntradasMaquina() > 0 )
							descripcionEntMaq.append(" + B");
					otpl.setVueltaEntMaq(descripcionEntMaq.toString());
						descripcionEntMaq = null;
					otpl.setRebases(pliego.getRebaseEnMilimetros());
					otpl.setMedianiles(pliego.getMedianilesEnMilimetros());
					otpl.setPinzas(pliego.getPinzasEnCentimetros());
					listaOrdenTrabajoPliego.add(otpl);
					otpl	 = null;
					pliego	 = null;
				}
				otttd.setMaquina(tipoTrabajoDetalle.getMaquina().getNombre());
				otttd.setTipoPlaca(tipoTrabajoDetalle.getTipoPlaca().getDescripcion());
				otttd.setDescripcion(tipoTrabajoDetalle.getDescripcion());
				otttd.setAncho(tipoTrabajoDetalle.getAncho());
				otttd.setAlto(tipoTrabajoDetalle.getAlto());
				otttd.setAnchoExtendido(tipoTrabajoDetalle.getAnchoExtendido());
				otttd.setAltoExtendido(tipoTrabajoDetalle.getAltoExtendido());
				otttd.setTipoPapel(tipoTrabajoDetalleService.obtienePapelDescripcionBasica(tipoTrabajoDetalle.getIdTipoTrabajoDetalle()));
				otttd.setNumeroPaginas(tipoTrabajoDetalle.getNumeroPaginasPublicacion());
				otttd.setTamanioPublicacion(tipoTrabajoDetalle.getTamanioPublicacion().getNombre());
				otttd.setRepeticionesPorPliego(tipoTrabajoDetalle.getRepeticionesXPliego());
				otttd.setFrenteCombinacionTintas(tipoTrabajoDetalle.getFrenteCombinacionTintas().getDescripcion());
				if( tipoTrabajoDetalle.getFrenteNumTintaEspecial() > 0 ) 
					otttd.setFrenteTintaEspecial(tipoTrabajoDetalle.getFrenteNumTintaEspecial() + " : " + tipoTrabajoDetalle.getFrenteDescripcionTintaEspecial());
				else
					otttd.setFrenteTintaEspecial("0");
				otttd.setFrenteTipoBarniz(tipoTrabajoDetalle.getFrenteTipoBarniz().getDescripcion());
				otttd.setVueltaCombinacionTintas(tipoTrabajoDetalle.getVueltaCombinacionTintas().getDescripcion());
				if( tipoTrabajoDetalle.getVueltaNumTintaEspecial() > 0 )
					otttd.setVueltaTintaEspecial(tipoTrabajoDetalle.getVueltaNumTintaEspecial() + " : " + tipoTrabajoDetalle.getVueltaDescripcionTintaEspecial());
				else
					otttd.setVueltaTintaEspecial("0");
				otttd.setVueltaTipoBarniz(tipoTrabajoDetalle.getVueltaTipoBarniz().getDescripcion());
				otttd.setListaOrdenTrabajoPliego(listaOrdenTrabajoPliego); 
				listaOrdenTrabajoPliego = null;
				listaOrdenTrabajoTipoTrabajoDetalle.add(otttd);
				otttd 				= null;
				listaPliegos 		= null;
				tipoTrabajoDetalle	= null;
			}
			otp.setTipoTrabajo(partida.getTipoTrabajo().getNombre());
			otp.setCantidad(partida.getCantidad());
			otp.setNombrePartida(partida.getNombrePartida());
			otp.setDescripcionPartida(partida.getDescripcionPartida());
			otp.setTipoFormaTrabajo(partida.getTipoFormaTrabajo().getNombre());
			otp.setObservacionesGenerales(partida.getObservacionesGenerales());
			otp.setObservacionesAprobacion(partida.getObservacionesAprobacion());
			
			// informacion del area DISENIO
			List<DisenioDTO> listaDisenioDTO = new ArrayList<DisenioDTO>();
			DisenioDTO disenioDTO = disenioService.buscaDisenioPorPartidaEnDTO(partida.getIdPartida());
			List<DisenioDetalleDTO> listaDisenioDetalleDTO = disenioDetalleService.listaDisenioDetallePorDisenioEnDTO(disenioDTO.getIdDisenio());
			disenioDTO.setListaDisenioDetalleDTO(listaDisenioDetalleDTO);
			listaDisenioDTO.add(disenioDTO);
			otp.setListaDisenioDTO(listaDisenioDTO);
			listaDisenioDetalleDTO 	= null;
			disenioDTO 				= null;
			listaDisenioDTO 		= null;
			
			// informacion del area PREPRENSA
			List<PreprensaDTO> listaPreprensaDTO = new ArrayList<PreprensaDTO>();
			PreprensaDTO preprensaDTO = preprensaService.buscaPreprensaPorPartidaEnDTO(partida.getIdPartida());
			List<PreprensaDetalleDTO> listaPreprensaDetalleDTO = preprensaDetalleService.listaPreprensaDetallePorPreprensaEnDTO(preprensaDTO.getIdPreprensa());
			preprensaDTO.setListaPreprensaDetalleDTO(listaPreprensaDetalleDTO);
			listaPreprensaDTO.add(preprensaDTO);
			otp.setListaPreprensaDTO(listaPreprensaDTO);
			listaPreprensaDetalleDTO 	= null;
			preprensaDTO 				= null;
			listaPreprensaDTO 			= null;
			
			// informacion del area TRANSPORTE
			List<TransporteDTO> listaTransporteDTO = new ArrayList<TransporteDTO>();
			TransporteDTO transporteDTO = transporteService.buscaTransportePorPartidaEnDTO(partida.getIdPartida());
			List<TransporteDetalleDTO> listaTransporteDetalleDTO = transporteDetalleService.listaTransporteDetallePorTransporteEnDTO(transporteDTO.getIdTransporte());
			transporteDTO.setListaTransporteDetalleDTO(listaTransporteDetalleDTO);
			listaTransporteDTO.add(transporteDTO);
			otp.setListaTransporteDTO(listaTransporteDTO);
			listaTransporteDetalleDTO 	= null;
			transporteDTO 				= null;
			listaTransporteDTO 			= null;
			
			// informacion del area ACABADO
			List<AcabadoDTO> listaAcabadoDTO = new ArrayList<AcabadoDTO>();
			AcabadoDTO acabadoDTO = acabadoService.buscaAcabadoPorPartidaEnDTO(partida.getIdPartida());
			List<AcabadoDetalleDTO> listaAcabadoDetalleDTO = acabadoDetalleService.listaAcabadoDetallePorAcabadoEnDTO(acabadoDTO.getIdAcabado());
			acabadoDTO.setListaAcabadoDetalleDTO(listaAcabadoDetalleDTO);
			listaAcabadoDTO.add(acabadoDTO);
			otp.setListaAcabadoDTO(listaAcabadoDTO);
			listaAcabadoDetalleDTO  = null;
			acabadoDTO				= null;
			listaAcabadoDTO	 		= null;
			
			// informacion del area OFFSET
			List<OffsetDTO> listaOffsetDTO = new ArrayList<OffsetDTO>();
			OffsetDTO offsetDTO = offsetService.buscaOffsetPorPartidaEnDTO(partida.getIdPartida());
			listaOffsetDTO.add(offsetDTO);
			otp.setListaOffsetDTO(listaOffsetDTO);
			offsetDTO 		= null;
			listaOffsetDTO	= null;
			
			// informacion de MATERIAL DE AYUDA
			List<MaterialAyudaDTO> listaMaterialAyudaDTO = materialAyudaXPartidaService.buscaListaMaterialAyudaPorPartidaEnDTO(partida.getIdPartida());
			otp.setListaMaterialAyudaDTO(listaMaterialAyudaDTO);
			listaMaterialAyudaDTO	= null;
			
			// lista de TipoTrabajoDetalle
			otp.setListaOrdenTrabajoTipoTrabajoDetalle(listaOrdenTrabajoTipoTrabajoDetalle);
			listaOrdenTrabajoTipoTrabajoDetalle = null;
			listaOrdenTrabajoPartida.add(otp);
			otp 					= null;
			listaTipoTrabajoDetalle = null;
			partida 				= null;
		}
		ot.setNombreCliente(ordenProduccion.getCliente().getNombreMoral());
		ot.setNombreRepresentante(ordenProduccion.getCliente().getNombreRepresentante());
		ot.setTelefonoParticular(ordenProduccion.getCliente().getTelefonoParticular());
		ot.setTelefonoMovil(ordenProduccion.getCliente().getTelefonoMovil());
		ot.setNut(ordenProduccion.getNut());
		ot.setNombreTrabajo(ordenProduccion.getNombre());
		ot.setDescripcion(ordenProduccion.getDescripcion());
		ot.setFechaEntrega(new SimpleDateFormat("dd MMM yyyy").format(ordenProduccion.getFechaPrometidaEntrega()));
		ot.setListaOrdenTrabajoPartida(listaOrdenTrabajoPartida);
		listaOrdenTrabajoPartida = null;
		listaOrdenTrabajo.add(ot);
		ot 				= null;
		listaPartida 	= null;
		ordenProduccion = null;
		
		Gson gson = new Gson();
		String json = gson.toJson( listaOrdenTrabajo );
		System.out.println("JSON:\n" + json);
		
		return listaOrdenTrabajo;
	}
	
	
	public List<OrdenProduccionDTOAyuda> obtieneVOPruebaJasper(int idOrdenProduccion) {
		return calificacionOrdenProduccionDAO.obtieneVOPruebaJasper(idOrdenProduccion);
	}

	
	public List<CalificacionTrabajoDetalleDTOAyuda> obtieneEjemploVOPapel() {
		return calificacionOrdenProduccionDAO.ejemploListaPapel();
	}

	

	
	
}

