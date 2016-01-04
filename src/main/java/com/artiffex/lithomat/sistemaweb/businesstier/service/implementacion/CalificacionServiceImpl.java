package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.sql.Timestamp;
import java.text.DecimalFormat;
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
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionProcesosPartida;
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
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.Remision;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades._CalificacionPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades._CalificacionTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionOrdenProduccionDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionPartidaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionProcesosPartidaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionTrabajoDetalleDAO;

@Service("resumenCalificacionService")
public class CalificacionServiceImpl implements CalificacionService {

	// DAO
	@Resource
	private CalificacionTrabajoDetalleDAO calificacionTrabajoDetalleDAO;
	@Resource
	private CalificacionPartidaDAO calificacionPartidaDAO;
	@Resource
	private CalificacionProcesosPartidaDAO calificacionProcesosPartidaDAO;
	@Resource
	private CalificacionOrdenProduccionDAO calificacionOrdenProduccionDAO;
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
			double subpartidasCosteTotal 	= 0;
			
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for(TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle ) {
				
				// *** INICIALIZACION ***
				// coste_total_tipo_trabajo_detalle = papel_coste + placas_coste + tinta_coste + tinta_especial_coste + barniz_coste
				double costeTotalTipoTrabajoDetalle	= 0.0;
				
				// * cantidad original y cantidad redondeada
				int cantidadOriginal 	= tipoTrabajoDetalle.getPartida().getCantidad();
				int cantidadRedondeada = 0;
				
				if (cantidadOriginal <= 1000)
					cantidadRedondeada = 1000;
				else if ((cantidadOriginal % 1000) > 300)
					cantidadRedondeada = ((cantidadOriginal / 1000) + 1) * 1000;
				else
					cantidadRedondeada = (cantidadOriginal / 1000) * 1000;
				
				// * tipo complejidad
				int idTipoComplejidad = tipoTrabajoDetalle.getTipoComplejidad().getIdTipoComplejidad();
				
				// * maquina
				int idMaquina = tipoTrabajoDetalle.getMaquina().getIdMaquina();
				
				// * precio tabulador
				float precioUnitarioTabulador = tabuladorPreciosService.obtienePrecioUnitarioTabulador(idTipoComplejidad, idMaquina, cantidadRedondeada);
				
				// *** COMPONENTES IMPRESION ***
				HashMap<String, Object> sumatorias = tipoTrabajoDetalleService.obtieneSumatorias(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				
				// *** ***** ***
				// PAPEL
				int papelCantidadTotal = (Integer)sumatorias.get("papelCantidadTotal");
				float papelPrecioUnitario = tipoTrabajoDetalle.getTipoPapelExtendido().getPrecio() / tipoTrabajoDetalle.getTipoPapelExtendido().getTipoPrecio().getFactorDivisor(); 
				float papelCosteTotal = papelCantidadTotal * papelPrecioUnitario;
				
				// *** ***** ***
				// PLACAS
				int placasNumPlacas = (Integer)sumatorias.get("placasNumPlacas");
				float placasPrecioUnitario = tipoTrabajoDetalle.getTipoPlaca().getPrecio() / tipoTrabajoDetalle.getTipoPlaca().getTipoPrecio().getFactorDivisor();
				float placasCosteTotal = placasNumPlacas * placasPrecioUnitario;
				
				// *** ***** ***
				// TIRO (TINTA)
				int tintaNumEntMaq = (Integer)sumatorias.get("tintaNumEntMaq");
				float tintaCosteTotal = cantidadRedondeada * tintaNumEntMaq * precioUnitarioTabulador;
				
				// *** ***** ***
				// TIRO (TINTA ESPECIAL)
				int tintaEspecialNumEntMaq = (Integer)sumatorias.get("tintaEspecialNumEntMaq");
				HashMap<String, Object> hashTintaEspecialPrecio = tintaEspecialService.getHashPrecioYTipoPrecio();
				float tintaEspecialPrecioUnitario = precioUnitarioTabulador * (1 + ((Float)hashTintaEspecialPrecio.get("precio") / Integer.parseInt(hashTintaEspecialPrecio.get("factorDivisor").toString())));  
				float tintaEspecialCosteTotal = cantidadRedondeada * tintaEspecialNumEntMaq * tintaEspecialPrecioUnitario;
				
				// *** ***** ***
				// TIRO (BARNIZ FRENTE)
				int frenteBarnizNumEntMaq = (Integer)sumatorias.get("frenteBarnizNumEntMaq");
				float frenteBarnizPrecioUnitario = precioUnitarioTabulador * (1 + (tipoTrabajoDetalle.getFrenteTipoBarniz().getPrecio() / tipoTrabajoDetalle.getFrenteTipoBarniz().getTipoPrecio().getFactorDivisor()));
				float frenteBarnizCosteTotal = cantidadRedondeada * frenteBarnizNumEntMaq * frenteBarnizPrecioUnitario;
				
				// *** ***** ***
				// TIRO (BARNIZ VUELTA)
				int vueltaBarnizNumEntMaq = (Integer)sumatorias.get("vueltaBarnizNumEntMaq");
				float vueltaBarnizPrecioUnitario = precioUnitarioTabulador * (1 + (tipoTrabajoDetalle.getVueltaTipoBarniz().getPrecio() / tipoTrabajoDetalle.getVueltaTipoBarniz().getTipoPrecio().getFactorDivisor()));
				float vueltaBarnizCosteTotal = cantidadRedondeada * vueltaBarnizNumEntMaq * vueltaBarnizPrecioUnitario;
				
				// SUMATORIA DE COSTES
				if (!tipoTrabajoDetalle.isClienteProporcionaPapel()) {
					costeTotalTipoTrabajoDetalle += papelCosteTotal;
				}
				if (!tipoTrabajoDetalle.isClienteProporcionaPlacas()) {
					costeTotalTipoTrabajoDetalle += placasCosteTotal;
				}
				if (!tipoTrabajoDetalle.isClienteProporcionaTinta()) {
					costeTotalTipoTrabajoDetalle += tintaCosteTotal;
				}
				if (!tipoTrabajoDetalle.isClienteProporcionaTintaEspecial()) {
					costeTotalTipoTrabajoDetalle += tintaEspecialCosteTotal;
				}
				if (!tipoTrabajoDetalle.isClienteProporcionaBarniz()) {
					costeTotalTipoTrabajoDetalle += frenteBarnizCosteTotal;
					costeTotalTipoTrabajoDetalle += vueltaBarnizCosteTotal;
				}
				
				
				// *** ***** ***
				// creacion de registro
				CalificacionTrabajoDetalle calificacionTrabajoDetalle = new CalificacionTrabajoDetalle();

				calificacionTrabajoDetalle.setTipoTrabajoDetalle(tipoTrabajoDetalle);
				calificacionTrabajoDetalle.setCosteTotalTipoTrabajoDetalle((float)costeTotalTipoTrabajoDetalle);
					
				calificacionTrabajoDetalle.setCantidadOriginal(cantidadOriginal);
				calificacionTrabajoDetalle.setCantidadRedondeada(cantidadRedondeada);
				calificacionTrabajoDetalle.setPrecioUnitarioTabulador(precioUnitarioTabulador);
				
				calificacionTrabajoDetalle.setPapelCantidadTotal(papelCantidadTotal);
				calificacionTrabajoDetalle.setPapelPrecioUnitario(papelPrecioUnitario);
				calificacionTrabajoDetalle.setPapelCosteTotal(papelCosteTotal);
				
				calificacionTrabajoDetalle.setPlacasNumPlacas(placasNumPlacas);
				calificacionTrabajoDetalle.setPlacasPrecioUnitario(placasPrecioUnitario);
				calificacionTrabajoDetalle.setPlacasCosteTotal(placasCosteTotal);
				
				calificacionTrabajoDetalle.setTintaNumEntMaq(tintaNumEntMaq);
				calificacionTrabajoDetalle.setTintaPrecioUnitario(precioUnitarioTabulador);
				calificacionTrabajoDetalle.setTintaCosteTotal(tintaCosteTotal);
				
				calificacionTrabajoDetalle.setTintaEspecialNumEntMaq(tintaEspecialNumEntMaq);
				calificacionTrabajoDetalle.setTintaEspecialPrecioUnitario(tintaEspecialPrecioUnitario);
				calificacionTrabajoDetalle.setTintaEspecialCosteTotal(tintaEspecialCosteTotal);
				
				calificacionTrabajoDetalle.setFrenteBarnizNumEntMaq(frenteBarnizNumEntMaq);
				calificacionTrabajoDetalle.setFrenteBarnizPrecioUnitario(frenteBarnizPrecioUnitario);
				calificacionTrabajoDetalle.setFrenteBarnizCosteTotal(frenteBarnizCosteTotal);
				
				calificacionTrabajoDetalle.setVueltaBarnizNumEntMaq(vueltaBarnizNumEntMaq);
				calificacionTrabajoDetalle.setVueltaBarnizPrecioUnitario(vueltaBarnizPrecioUnitario);
				calificacionTrabajoDetalle.setVueltaBarnizCosteTotal(vueltaBarnizCosteTotal);
				
				calificacionTrabajoDetalle.setActivo(true);

				calificacionTrabajoDetalleDAO.crea(calificacionTrabajoDetalle);
				
				// SUMATORIA SUBPARTIDAS_COSTE_TOTAL
				subpartidasCosteTotal 	+= costeTotalTipoTrabajoDetalle;
				
				// limpieza variables
				costeTotalTipoTrabajoDetalle	= 0; 
				idMaquina 						= 0;
				cantidadOriginal 				= 0;
				cantidadRedondeada 				= 0;
				precioUnitarioTabulador 		= 0;
				papelCantidadTotal 				= 0;
				papelPrecioUnitario 			= 0;
				papelCosteTotal 				= 0;
				placasNumPlacas 				= 0;
				placasPrecioUnitario 			= 0;
				placasCosteTotal 				= 0;
				tintaNumEntMaq 					= 0;
				tintaCosteTotal 				= 0;
				tintaEspecialNumEntMaq 			= 0;
				hashTintaEspecialPrecio 		= null;
				tintaEspecialPrecioUnitario 	= 0;
				tintaEspecialCosteTotal 		= 0;
				frenteBarnizNumEntMaq 			= 0;
				frenteBarnizPrecioUnitario 		= 0;
				frenteBarnizCosteTotal 			= 0;
				vueltaBarnizNumEntMaq 			= 0;
				vueltaBarnizPrecioUnitario 		= 0;
				vueltaBarnizCosteTotal 			= 0;
				tipoTrabajoDetalle				= null;
				calificacionTrabajoDetalle		= null;
			}
			
			listaTipoTrabajoDetalle = null;
			
			float disenioCosteTotal 	= partidaService.obtieneDisenioCosteTotal(partida.getIdPartida());
			float preprensaCosteTotal 	= partidaService.obtienePreprensaCosteTotal(partida.getIdPartida());
			float transporteCosteTotal 	= partidaService.obtieneTransporteCosteTotal(partida.getIdPartida());
			float acabadoCosteTotal 	= partidaService.obtieneAcabadoCosteTotal(partida.getIdPartida());
			float offsetCosteTotal 		= 0;
			float costoExtraTotal 		= partidaService.obtieneCostoExtraCosteTotal(partida.getIdPartida());
			
			// SUMATORIA PARA CALCULO PRECIO BRUTO
			// coste_total_procesos_partida = subpartidas_coste_total + sumatoria(disenio.coste_total + preprensa_coste_total + transporte_coste_total + acabado_coste_total + offset_coste_total + costo_extra)
			double costeTotalProcesosPartida = 0;
			
			costeTotalProcesosPartida += subpartidasCosteTotal;
			costeTotalProcesosPartida += disenioCosteTotal;
			costeTotalProcesosPartida += preprensaCosteTotal;
			costeTotalProcesosPartida += transporteCosteTotal;
			costeTotalProcesosPartida += acabadoCosteTotal;
			costeTotalProcesosPartida += offsetCosteTotal;
			costeTotalProcesosPartida += costoExtraTotal;

			//creacion de registro
			CalificacionProcesosPartida calificacionProcesosPartida = new CalificacionProcesosPartida();
			
			calificacionProcesosPartida.setPartida(partida);
			calificacionProcesosPartida.setCosteTotalProcesosPartida((float)costeTotalProcesosPartida);
			calificacionProcesosPartida.setSubpartidasCosteTotal((float)subpartidasCosteTotal);
			calificacionProcesosPartida.setDisenioCosteTotal(disenioCosteTotal);
			calificacionProcesosPartida.setPreprensaCosteTotal(preprensaCosteTotal);
			calificacionProcesosPartida.setTransporteCosteTotal(transporteCosteTotal);
			calificacionProcesosPartida.setAcabadoCosteTotal(acabadoCosteTotal);
			calificacionProcesosPartida.setOffsetCosteTotal(offsetCosteTotal);
			calificacionProcesosPartida.setCostoExtraTotal(costoExtraTotal);
			calificacionProcesosPartida.setActivo(true);
			
			calificacionProcesosPartidaDAO.crea(calificacionProcesosPartida);
			
			// SUMATORIA PRECIO_BRUTO
			precioBruto += costeTotalProcesosPartida;
			
			//limpieza variables
			partida						= null;
			costeTotalProcesosPartida 	= 0;
			disenioCosteTotal 			= 0;
			preprensaCosteTotal 		= 0;
			transporteCosteTotal 		= 0;
			acabadoCosteTotal 			= 0;
			offsetCosteTotal 			= 0;
			costoExtraTotal 			= 0;
			calificacionProcesosPartida	= null;
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

		precioBruto					= 0;
		precioCliente 				= 0;
		porcentajeComprobante 		= 0;
		precioNeto 					= 0;
		calificacionOrdenProduccion	= null;

		return 1;
	} // creaCalificacion
	
	/********* PANTALLA *********/
	
	public CalificacionOrdenProduccion buscaCalificacionOrdenProduccion(int idOrdenProduccion) {
		return calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(idOrdenProduccion);
	} // buscaCalificacionOrdenProduccion
	
	
	public _CalificacionPartida buscaCalificacionPartida(int idPartida) {
		return calificacionPartidaDAO.busca(idPartida);
	} // buscaCalificacionPartida
	
	
	public CalificacionTrabajoDetalle buscaCalificacionTrabajoDetalle(int idTipoTrabajoDetalle) {
		return calificacionTrabajoDetalleDAO.buscaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
	} // buscaCalificacionTrabajoDetalle
	
	
	public CalificacionProcesosPartida buscaCalificacionProcesos(int idPartida) {
		return calificacionProcesosPartidaDAO.buscaPorPartida(idPartida);
	} // buscaCalificacionProcesos
	
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
		double precioBruto	= 0;
		
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(idOrdenProduccion);
		for (Partida partida : listaPartida) {
			
			// subpartidas_coste_total = sumatoria(trabajo_detalle[n].coste_total_tipo_trabajo_detalle) donde n = 1,...,m
			double subpartidasCosteTotal 	= 0;
			
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for(TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle ) {
				
				// *** INICIALIZACION ***
				// coste_total_tipo_trabajo_detalle = papel_coste + placas_coste + tinta_coste + tinta_especial_coste + barniz_coste
				double costeTotalTipoTrabajoDetalle	= 0;
				
				// * cantidad original y cantidad redondeada
				int cantidadOriginal 	= tipoTrabajoDetalle.getPartida().getCantidad();
				int cantidadRedondeada = 0;
				
				if (cantidadOriginal <= 1000)
					cantidadRedondeada = 1000;
				else if ((cantidadOriginal % 1000) > 300)
					cantidadRedondeada = ((cantidadOriginal / 1000) + 1) * 1000;
				else
					cantidadRedondeada = (cantidadOriginal / 1000) * 1000;
				
				// * tipo complejidad
				int idTipoComplejidad = tipoTrabajoDetalle.getTipoComplejidad().getIdTipoComplejidad();
				
				// * maquina
				int idMaquina = tipoTrabajoDetalle.getMaquina().getIdMaquina();
				
				// * precio tabulador
				float precioUnitarioTabulador = tabuladorPreciosService.obtienePrecioUnitarioTabulador(idTipoComplejidad, idMaquina, cantidadRedondeada);
				
				// *** COMPONENTES IMPRESION ***
				HashMap<String, Object> sumatorias = tipoTrabajoDetalleService.obtieneSumatorias(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				
				// *** ***** ***
				// PAPEL
				int papelCantidadTotal = (Integer)sumatorias.get("papelCantidadTotal");
				float papelPrecioUnitario = tipoTrabajoDetalle.getTipoPapelExtendido().getPrecio() / tipoTrabajoDetalle.getTipoPapelExtendido().getTipoPrecio().getFactorDivisor();
				float papelCosteTotal = papelCantidadTotal * papelPrecioUnitario;

				// *** ***** ***
				// PLACAS
				int placasNumPlacas = (Integer)sumatorias.get("placasNumPlacas");
				float placasPrecioUnitario = tipoTrabajoDetalle.getTipoPlaca().getPrecio() / tipoTrabajoDetalle.getTipoPlaca().getTipoPrecio().getFactorDivisor();
				float placasCosteTotal = placasNumPlacas * placasPrecioUnitario;
				
				// *** ***** ***
				// TIRO (TINTA)
				int tintaNumEntMaq = (Integer)sumatorias.get("tintaNumEntMaq");
				float tintaCosteTotal = cantidadRedondeada * tintaNumEntMaq * precioUnitarioTabulador;
				
				// *** ***** ***
				// TIRO (TINTA ESPECIAL)
				int tintaEspecialNumEntMaq = (Integer)sumatorias.get("tintaEspecialNumEntMaq");
				HashMap<String, Object> hashTintaEspecialPrecio = tintaEspecialService.getHashPrecioYTipoPrecio();
				float tintaEspecialPrecioUnitario = precioUnitarioTabulador * (1 + ((Float)hashTintaEspecialPrecio.get("precio") / Integer.parseInt(hashTintaEspecialPrecio.get("factorDivisor").toString())));
				float tintaEspecialCosteTotal = cantidadRedondeada * tintaEspecialNumEntMaq * tintaEspecialPrecioUnitario;
				
				// *** ***** ***
				// TIRO (BARNIZ FRENTE)
				int frenteBarnizNumEntMaq = (Integer)sumatorias.get("frenteBarnizNumEntMaq");
				float frenteBarnizPrecioUnitario = precioUnitarioTabulador * (1 + (tipoTrabajoDetalle.getFrenteTipoBarniz().getPrecio() /  tipoTrabajoDetalle.getFrenteTipoBarniz().getTipoPrecio().getFactorDivisor()));
				float frenteBarnizCosteTotal = cantidadRedondeada * frenteBarnizNumEntMaq * frenteBarnizPrecioUnitario;
				
				// *** ***** ***
				// TIRO (BARNIZ VUELTA)
				int vueltaBarnizNumEntMaq = (Integer)sumatorias.get("vueltaBarnizNumEntMaq");
				float vueltaBarnizPrecioUnitario = precioUnitarioTabulador * (1 + (tipoTrabajoDetalle.getVueltaTipoBarniz().getPrecio() / tipoTrabajoDetalle.getVueltaTipoBarniz().getTipoPrecio().getFactorDivisor()));
				float vueltaBarnizCosteTotal = cantidadRedondeada * vueltaBarnizNumEntMaq * vueltaBarnizPrecioUnitario;

				
				// SUMATORIA DE COSTES
				if (!tipoTrabajoDetalle.isClienteProporcionaPapel()) {
					costeTotalTipoTrabajoDetalle += papelCosteTotal;
				}
				if (!tipoTrabajoDetalle.isClienteProporcionaPlacas()) {
					costeTotalTipoTrabajoDetalle += placasCosteTotal;
				}
				if (!tipoTrabajoDetalle.isClienteProporcionaTinta()) {
					costeTotalTipoTrabajoDetalle += tintaCosteTotal;
				}
				if (!tipoTrabajoDetalle.isClienteProporcionaTintaEspecial()) {
					costeTotalTipoTrabajoDetalle += tintaEspecialCosteTotal;
				}
				if (!tipoTrabajoDetalle.isClienteProporcionaBarniz()) {
					costeTotalTipoTrabajoDetalle += frenteBarnizCosteTotal;
					costeTotalTipoTrabajoDetalle += vueltaBarnizCosteTotal;
				}
				
				
				// *** ***** ***
				// modificacion de registro
				CalificacionTrabajoDetalle calificacionTrabajoDetalle = calificacionTrabajoDetalleDAO.buscaPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());

				calificacionTrabajoDetalle.setTipoTrabajoDetalle(tipoTrabajoDetalle);
				calificacionTrabajoDetalle.setCosteTotalTipoTrabajoDetalle((float)costeTotalTipoTrabajoDetalle);
					
				calificacionTrabajoDetalle.setCantidadOriginal(cantidadOriginal);
				calificacionTrabajoDetalle.setCantidadRedondeada(cantidadRedondeada);
				calificacionTrabajoDetalle.setPrecioUnitarioTabulador(precioUnitarioTabulador);
				
				calificacionTrabajoDetalle.setPapelCantidadTotal(papelCantidadTotal);
				calificacionTrabajoDetalle.setPapelPrecioUnitario(papelPrecioUnitario);
				calificacionTrabajoDetalle.setPapelCosteTotal(papelCosteTotal);
				
				calificacionTrabajoDetalle.setPlacasNumPlacas(placasNumPlacas);
				calificacionTrabajoDetalle.setPlacasPrecioUnitario(placasPrecioUnitario);
				calificacionTrabajoDetalle.setPlacasCosteTotal(placasCosteTotal);
				
				calificacionTrabajoDetalle.setTintaNumEntMaq(tintaNumEntMaq);
				calificacionTrabajoDetalle.setTintaPrecioUnitario(precioUnitarioTabulador);
				calificacionTrabajoDetalle.setTintaCosteTotal(tintaCosteTotal);
				
				calificacionTrabajoDetalle.setTintaEspecialNumEntMaq(tintaEspecialNumEntMaq);
				calificacionTrabajoDetalle.setTintaEspecialPrecioUnitario(tintaEspecialPrecioUnitario);
				calificacionTrabajoDetalle.setTintaEspecialCosteTotal(tintaEspecialCosteTotal);
				
				calificacionTrabajoDetalle.setFrenteBarnizNumEntMaq(frenteBarnizNumEntMaq);
				calificacionTrabajoDetalle.setFrenteBarnizPrecioUnitario(frenteBarnizPrecioUnitario);
				calificacionTrabajoDetalle.setFrenteBarnizCosteTotal(frenteBarnizCosteTotal);
				
				calificacionTrabajoDetalle.setVueltaBarnizNumEntMaq(vueltaBarnizNumEntMaq);
				calificacionTrabajoDetalle.setVueltaBarnizPrecioUnitario(vueltaBarnizPrecioUnitario);
				calificacionTrabajoDetalle.setVueltaBarnizCosteTotal(vueltaBarnizCosteTotal);
				
				calificacionTrabajoDetalleDAO.modifica(calificacionTrabajoDetalle);
				
				// SUMATORIA SUBPARTIDAS_COSTE_TOTAL
				subpartidasCosteTotal 	+= costeTotalTipoTrabajoDetalle;
				
				// limpieza variables
				costeTotalTipoTrabajoDetalle	= 0; 
				idMaquina 						= 0;
				cantidadOriginal 				= 0;
				cantidadRedondeada 				= 0;
				precioUnitarioTabulador 		= 0;
				papelCantidadTotal 				= 0;
				papelPrecioUnitario 			= 0;
				papelCosteTotal 				= 0;
				placasNumPlacas 				= 0;
				placasPrecioUnitario 			= 0;
				placasCosteTotal 				= 0;
				tintaNumEntMaq 					= 0;
				tintaCosteTotal 				= 0;
				tintaEspecialNumEntMaq 			= 0;
				hashTintaEspecialPrecio 		= null;
				tintaEspecialPrecioUnitario 	= 0;
				tintaEspecialCosteTotal 		= 0;
				frenteBarnizNumEntMaq 			= 0;
				frenteBarnizPrecioUnitario 		= 0;
				frenteBarnizCosteTotal 			= 0;
				vueltaBarnizNumEntMaq 			= 0;
				vueltaBarnizPrecioUnitario 		= 0;
				vueltaBarnizCosteTotal 			= 0;
				tipoTrabajoDetalle				= null;
				calificacionTrabajoDetalle		= null;
			}
			
			listaTipoTrabajoDetalle = null;
			
			float disenioCosteTotal 	= partidaService.obtieneDisenioCosteTotal(partida.getIdPartida());
			float preprensaCosteTotal 	= partidaService.obtienePreprensaCosteTotal(partida.getIdPartida());
			float transporteCosteTotal 	= partidaService.obtieneTransporteCosteTotal(partida.getIdPartida());
			float acabadoCosteTotal 	= partidaService.obtieneAcabadoCosteTotal(partida.getIdPartida());
			float offsetCosteTotal 		= 0;
			float costoExtraTotal 		= partidaService.obtieneCostoExtraCosteTotal(partida.getIdPartida());
			
			// SUMATORIA PARA CALCULO PRECIO BRUTO
			// coste_total_procesos_partida = subpartidas_coste_total + sumatoria(disenio.coste_total + preprensa_coste_total + transporte_coste_total + acabado_coste_total + offset_coste_total + costo_extra)
			double costeTotalProcesosPartida = 0;
			
			costeTotalProcesosPartida += subpartidasCosteTotal;
			costeTotalProcesosPartida += disenioCosteTotal;
			costeTotalProcesosPartida += preprensaCosteTotal;
			costeTotalProcesosPartida += transporteCosteTotal;
			costeTotalProcesosPartida += acabadoCosteTotal;
			costeTotalProcesosPartida += offsetCosteTotal;
			costeTotalProcesosPartida += costoExtraTotal;

			//creacion de registro
			CalificacionProcesosPartida calificacionProcesosPartida = calificacionProcesosPartidaDAO.buscaPorPartida(partida.getIdPartida());
			
			calificacionProcesosPartida.setPartida(partida);
			calificacionProcesosPartida.setCosteTotalProcesosPartida((float)costeTotalProcesosPartida);
			calificacionProcesosPartida.setSubpartidasCosteTotal((float)subpartidasCosteTotal);
			calificacionProcesosPartida.setDisenioCosteTotal(disenioCosteTotal);
			calificacionProcesosPartida.setPreprensaCosteTotal(preprensaCosteTotal);
			calificacionProcesosPartida.setTransporteCosteTotal(transporteCosteTotal);
			calificacionProcesosPartida.setAcabadoCosteTotal(acabadoCosteTotal);
			calificacionProcesosPartida.setOffsetCosteTotal(offsetCosteTotal);
			calificacionProcesosPartida.setCostoExtraTotal(costoExtraTotal);
			
			calificacionProcesosPartidaDAO.modifica(calificacionProcesosPartida);
			
			// SUMATORIA PRECIO_BRUTO
			precioBruto += costeTotalProcesosPartida;
			
			//limpieza variables
			partida						= null;
			costeTotalProcesosPartida 	= 0;
			disenioCosteTotal 			= 0;
			preprensaCosteTotal 		= 0;
			transporteCosteTotal 		= 0;
			acabadoCosteTotal 			= 0;
			offsetCosteTotal 			= 0;
			costoExtraTotal 			= 0;
			calificacionProcesosPartida	= null;
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
			
		calificacionOrdenProduccion.setOrdenProduccion(ordenProduccion);
		calificacionOrdenProduccion.setPrecioBruto(precioBruto);
		calificacionOrdenProduccion.setTipoClientePrecio(ordenProduccion.getCliente().getTipoCliente().getPrecio());
		calificacionOrdenProduccion.setTipoClienteFactorDivisor(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor());
		calificacionOrdenProduccion.setPrecioCliente(precioCliente);
		calificacionOrdenProduccion.setPrecioClienteConDescuento(precioClienteConDescuento);
		calificacionOrdenProduccion.setPrecioNeto(precioNeto);
		calificacionOrdenProduccion.setFechaGeneracion(new Timestamp(Calendar.getInstance().getTimeInMillis()));

		calificacionOrdenProduccionDAO.modifica(calificacionOrdenProduccion);

		precioBruto					= 0;
		porcentajeTipoCliente		= 0;
		precioCliente 				= 0;
		porcentajeTipoComprobante	= 0;
		porcentajeComprobante 		= 0;
		precioNeto 					= 0;
		calificacionOrdenProduccion	= null;

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
			
			// coste_total_procesos_partida = 
			//		subpartidas_coste_total + (
			//			disenio + preprensa + transporte + acabado + offset + cosot_extra
			//		)
			
			//busqueda de registro
			CalificacionProcesosPartida calificacionProcesosPartida = calificacionProcesosPartidaDAO.buscaPorPartida(partida.getIdPartida());
			
			double subpartidasCosteTotal 	= calificacionProcesosPartida.getSubpartidasCosteTotal();
			
			float disenioCosteTotal 	= partidaService.obtieneDisenioCosteTotal(partida.getIdPartida());
			float preprensaCosteTotal 	= partidaService.obtienePreprensaCosteTotal(partida.getIdPartida());
			float transporteCosteTotal 	= partidaService.obtieneTransporteCosteTotal(partida.getIdPartida());
			float acabadoCosteTotal 	= partidaService.obtieneAcabadoCosteTotal(partida.getIdPartida());
			float offsetCosteTotal 		= 0;
			float costoExtraTotal 		= partidaService.obtieneCostoExtraCosteTotal(partida.getIdPartida());
			
			// SUMATORIA PARA CALCULO PRECIO BRUTO
			double costeTotalProcesosPartida = 0;
			
			costeTotalProcesosPartida += subpartidasCosteTotal;
			costeTotalProcesosPartida += disenioCosteTotal;
			costeTotalProcesosPartida += preprensaCosteTotal;
			costeTotalProcesosPartida += transporteCosteTotal;
			costeTotalProcesosPartida += acabadoCosteTotal;
			costeTotalProcesosPartida += offsetCosteTotal;
			costeTotalProcesosPartida += costoExtraTotal;
			
			calificacionProcesosPartida.setPartida(partida);
			calificacionProcesosPartida.setCosteTotalProcesosPartida((float)costeTotalProcesosPartida);
			calificacionProcesosPartida.setDisenioCosteTotal(disenioCosteTotal);
			calificacionProcesosPartida.setPreprensaCosteTotal(preprensaCosteTotal);
			calificacionProcesosPartida.setTransporteCosteTotal(transporteCosteTotal);
			calificacionProcesosPartida.setAcabadoCosteTotal(acabadoCosteTotal);
			calificacionProcesosPartida.setOffsetCosteTotal(offsetCosteTotal);
			calificacionProcesosPartida.setCostoExtraTotal(costoExtraTotal);
			
			calificacionProcesosPartidaDAO.modifica(calificacionProcesosPartida); // UPDATE
			
			// SUMATORIA PRECIO_BRUTO
			precioBruto += costeTotalProcesosPartida;
			
			//limpieza variables
			partida						= null;
			costeTotalProcesosPartida 	= 0;
			subpartidasCosteTotal		= 0;
			calificacionProcesosPartida	= null;
			
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
			
		calificacionOrdenProduccion.setOrdenProduccion(ordenProduccion);
		calificacionOrdenProduccion.setPrecioBruto(precioBruto);
		calificacionOrdenProduccion.setTipoClientePrecio(ordenProduccion.getCliente().getTipoCliente().getPrecio());
		calificacionOrdenProduccion.setTipoClienteFactorDivisor(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor());
		calificacionOrdenProduccion.setPrecioCliente(precioCliente);
		calificacionOrdenProduccion.setPrecioClienteConDescuento(precioClienteConDescuento);
		calificacionOrdenProduccion.setPrecioNeto(precioNeto);
		calificacionOrdenProduccion.setFechaGeneracion(new Timestamp(Calendar.getInstance().getTimeInMillis()));

		calificacionOrdenProduccionDAO.modifica(calificacionOrdenProduccion);

		precioBruto					= 0;
		porcentajeTipoCliente		= 0;
		precioCliente 				= 0;
		porcentajeTipoComprobante	= 0;
		porcentajeComprobante 		= 0;
		precioNeto 					= 0;
		calificacionOrdenProduccion	= null;

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
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		for (Partida partida : listaPartida) {
			
			ReporteCotizacionDTO partidaReporte = new ReporteCotizacionDTO();
			partidaReporte.setCantidad(partida.getCantidad());
			partidaReporte.setDescripcion(partida.getDescripcionPartida());
				
				CalificacionProcesosPartida cpp 		= calificacionProcesosPartidaDAO.buscaPorPartida(partida.getIdPartida());
				float porcentajeTipoCliente = partida.getOrdenProduccion().getCliente().getTipoCliente().getPrecio() / partida.getOrdenProduccion().getCliente().getTipoCliente().getTipoPrecio().getFactorDivisor();
				double costeTotalProcesosPartida 		= cpp.getCosteTotalProcesosPartida();
				double costeGananciaRespectoTipoCliente = (double)(costeTotalProcesosPartida * (1 + porcentajeTipoCliente));
			
			partidaReporte.setPrecioUnitario( (double)(costeGananciaRespectoTipoCliente / partida.getCantidad()) );
			partidaReporte.setPrecioCliente( (double)costeGananciaRespectoTipoCliente );
			listaPartidaReporte.add(partidaReporte);
			
			cpp				= null;
			partidaReporte	= null;
			partida 		= null;
		}
		
		listaPartida	= null;
		ordenProduccion = null;
		
		return listaPartidaReporte;
	}
	
	
	public List<Remision> obtieneRemisionPorNut(String nut) {
		
		// lista de remision necesaria para el reporte
		List<Remision> listaRemision = new ArrayList<Remision>();
		
		// objetos para dar formato a cantidades
		DecimalFormat dfCuatroDecimales = new DecimalFormat("0.0000");
		DecimalFormat dfDosDecimales = new DecimalFormat("0.00");
		
		// obtencion de informacion
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
			
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		float gananciaCliente = calificacionOrdenProduccion.getTipoClientePrecio() / calificacionOrdenProduccion.getTipoClienteFactorDivisor();
			
		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		for (Partida partida : listaPartida) {
			CalificacionProcesosPartida calificacionProcesosPartida = calificacionProcesosPartidaDAO.buscaPorPartida(partida.getIdPartida());
			
			Remision remision = new Remision();
			List<_CalificacionTrabajoDetalle> listaCalificacionTrabajoDetalle = new ArrayList<_CalificacionTrabajoDetalle>();
			
			remision.setNombre(partida.getNombrePartida());
			remision.setGananciaClientePorcentaje(gananciaCliente);
			remision.setCosteTotalProcesosPartida(calificacionProcesosPartida.getCosteTotalProcesosPartida() * (1 + gananciaCliente));
			remision.setSubpartidasCosteTotal(calificacionProcesosPartida.getSubpartidasCosteTotal() * (1 + gananciaCliente));
			remision.setDisenioCosteTotal(Double.valueOf(dfDosDecimales.format(calificacionProcesosPartida.getDisenioCosteTotal() * (1 + gananciaCliente))));
			remision.setPreprensaCosteTotal(Double.valueOf(dfDosDecimales.format(calificacionProcesosPartida.getPreprensaCosteTotal() * (1 + gananciaCliente))));
			remision.setTransporteCosteTotal(Double.valueOf(dfDosDecimales.format(calificacionProcesosPartida.getTransporteCosteTotal() * (1 + gananciaCliente))));
			remision.setAcabadoCosteTotal(Double.valueOf(dfDosDecimales.format(calificacionProcesosPartida.getAcabadoCosteTotal() * (1 + gananciaCliente))));
			remision.setOffsetCosteTotal(Double.valueOf(dfDosDecimales.format(calificacionProcesosPartida.getOffsetCosteTotal() * (1 + gananciaCliente))));
			remision.setCostoExtraTotal(Double.valueOf(dfDosDecimales.format(calificacionProcesosPartida.getCostoExtraTotal() * (1 + gananciaCliente))));
			
			List<TipoTrabajoDetalle> listaTipoTrabajoDetalle = tipoTrabajoDetalleService.listaTipoTrabajoDetallePorPartida(partida.getIdPartida());
			for (TipoTrabajoDetalle tipoTrabajoDetalle : listaTipoTrabajoDetalle) {
				CalificacionTrabajoDetalle ctd = calificacionTrabajoDetalleDAO.buscaPorTipoTrabajoDetalle(tipoTrabajoDetalle.getIdTipoTrabajoDetalle());
				
				// No es DTO porque contiene más informacion que la copia de un Entity en un DTO
				_CalificacionTrabajoDetalle calificacionTrabajoDetalle = new _CalificacionTrabajoDetalle();
				calificacionTrabajoDetalle.setDescripcion(tipoTrabajoDetalle.getDescripcion());
				calificacionTrabajoDetalle.setCantidadOriginal(partida.getCantidad());
				calificacionTrabajoDetalle.setCantidadRedondeada(ctd.getCantidadRedondeada());
				calificacionTrabajoDetalle.setClienteProporcionaPapel(tipoTrabajoDetalle.isClienteProporcionaPapel());
				calificacionTrabajoDetalle.setClienteProporcionaTinta(tipoTrabajoDetalle.isClienteProporcionaTinta());
				calificacionTrabajoDetalle.setClienteProporcionaTintaEspecial(tipoTrabajoDetalle.isClienteProporcionaTintaEspecial());
				calificacionTrabajoDetalle.setClienteProporcionaBarniz(tipoTrabajoDetalle.isClienteProporcionaBarniz());
				calificacionTrabajoDetalle.setClienteProporcionaPlacas(tipoTrabajoDetalle.isClienteProporcionaPlacas());
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
				calificacionTrabajoDetalle.setPapelDescripcion(sb.toString());
					sb.delete(0, sb.length());
				calificacionTrabajoDetalle.setPapelCantidadTotal(ctd.getPapelCantidadTotal());
				calificacionTrabajoDetalle.setPapelPrecioUnitario(Float.valueOf(dfCuatroDecimales.format(ctd.getPapelPrecioUnitario() * (1 + gananciaCliente))));
				calificacionTrabajoDetalle.setPapelCosteTotal(ctd.getPapelCosteTotal() * (1 + gananciaCliente));
					sb.append("Tinta fte: ");
					sb.append(tipoTrabajoDetalle.getFrenteCombinacionTintas().getDescripcion());
					sb.append("; vta: ");
					sb.append(tipoTrabajoDetalle.getVueltaCombinacionTintas().getDescripcion());
				calificacionTrabajoDetalle.setTintaDescripcion(sb.toString());
					sb.delete(0, sb.length());
				calificacionTrabajoDetalle.setTintaNumEntMaq(ctd.getTintaNumEntMaq());
				calificacionTrabajoDetalle.setTintaPrecioUnitario(ctd.getTintaPrecioUnitario() * (1 + gananciaCliente));
				calificacionTrabajoDetalle.setTintaCosteTotal(ctd.getTintaCosteTotal() * (1 + gananciaCliente));
					sb.append("Tinta especial fte: ");
					sb.append(tipoTrabajoDetalle.getFrenteDescripcionTintaEspecial());
					sb.append("; vta; ");
					sb.append(tipoTrabajoDetalle.getVueltaDescripcionTintaEspecial());
				calificacionTrabajoDetalle.setTintaEspecialDescripcion(sb.toString());
					sb.delete(0, sb.length());
				calificacionTrabajoDetalle.setTintaEspecialNumEntMaq(ctd.getTintaEspecialNumEntMaq());
				calificacionTrabajoDetalle.setTintaEspecialPrecioUnitario(ctd.getTintaEspecialPrecioUnitario() * (1 + gananciaCliente));
				calificacionTrabajoDetalle.setTintaEspecialCosteTotal(ctd.getTintaEspecialCosteTotal() * (1 + gananciaCliente));
					sb.append("Barniz fte: ");
					sb.append(tipoTrabajoDetalle.getFrenteTipoBarniz().getDescripcion());
					sb.append("; vta: ");
					sb.append(tipoTrabajoDetalle.getVueltaTipoBarniz().getDescripcion());
				calificacionTrabajoDetalle.setBarnizDescripcion(sb.toString());
					sb.delete(0, sb.length());
				calificacionTrabajoDetalle.setFrenteBarnizNumEntMaq(ctd.getFrenteBarnizNumEntMaq());
				calificacionTrabajoDetalle.setFrenteBarnizPrecioUnitario(ctd.getFrenteBarnizPrecioUnitario() * (1 + gananciaCliente));
				calificacionTrabajoDetalle.setFrenteBarnizCosteTotal(ctd.getFrenteBarnizCosteTotal() * (1 + gananciaCliente));
				calificacionTrabajoDetalle.setVueltaBarnizNumEntMaq(ctd.getVueltaBarnizNumEntMaq());
				calificacionTrabajoDetalle.setVueltaBarnizPrecioUnitario(ctd.getVueltaBarnizPrecioUnitario() * (1 + gananciaCliente));
				calificacionTrabajoDetalle.setVueltaBarnizCosteTotal(ctd.getVueltaBarnizCosteTotal() * (1 + gananciaCliente));
				calificacionTrabajoDetalle.setPlacasDescripcion(tipoTrabajoDetalle.getTipoPlaca().getDescripcion());
				calificacionTrabajoDetalle.setPlacasNumPlacas(ctd.getPlacasNumPlacas());
				calificacionTrabajoDetalle.setPlacasPrecioUnitario(Float.valueOf(dfDosDecimales.format(ctd.getPlacasPrecioUnitario() * (1 + gananciaCliente))));
				calificacionTrabajoDetalle.setPlacasCosteTotal(ctd.getPlacasCosteTotal() * (1 + gananciaCliente));
				
				listaCalificacionTrabajoDetalle.add(calificacionTrabajoDetalle);
				
				sb								= null;
				calificacionTrabajoDetalle 		= null;
				ctd 							= null;
				tipoTrabajoDetalle 				= null;
			}
			remision.setListaCalificacionTrabajoDetalle(listaCalificacionTrabajoDetalle);
			listaRemision.add(remision);
			
			listaTipoTrabajoDetalle 		= null;
			listaCalificacionTrabajoDetalle	= null;
			remision 						= null;
			calificacionProcesosPartida 	= null;
			partida 						= null;
		}
		
		listaPartida 					= null;
		calificacionOrdenProduccion 	= null;
		ordenProduccion 				= null;
		dfDosDecimales 					= null;
		dfCuatroDecimales 				= null;
		
		//Gson gson = new Gson();
		//String json = gson.toJson( listaRemision );
		//System.out.println("JSON:\n" + json);
		
		return listaRemision;
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
		
		//Gson gson = new Gson();
		//String json = gson.toJson( listaOrdenTrabajo );
		//System.out.println("JSON:\n" + json);
		
		return listaOrdenTrabajo;
	}
	
	
	public List<OrdenProduccionDTOAyuda> obtieneVOPruebaJasper(int idOrdenProduccion) {
		return calificacionOrdenProduccionDAO.obtieneVOPruebaJasper(idOrdenProduccion);
	}

	
	public List<CalificacionTrabajoDetalleDTOAyuda> obtieneEjemploVOPapel() {
		return calificacionOrdenProduccionDAO.ejemploListaPapel();
	}
	
}

