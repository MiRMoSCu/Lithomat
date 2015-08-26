package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.ayuda.CalificacionTrabajoDetalleDTOAyuda;
import com.artiffex.lithomat.sistemaweb.ayuda.OrdenProduccionDTOAyuda;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.ReporteCotizacionDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionProcesosPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TintaEspecialService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.Precio;
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
				float papelPrecioUnitario = Precio.conversionRespectoTipoPrecio(
													tipoTrabajoDetalle.getTipoPapelExtendido().getPrecio(),
													tipoTrabajoDetalle.getTipoPapelExtendido().getTipoPrecio().getIdTipoPrecio() 
												);
				float papelCosteTotal = papelCantidadTotal * papelPrecioUnitario;
				
				// *** ***** ***
				// PLACAS
				int placasNumPlacas = (Integer)sumatorias.get("placasNumPlacas");
				float placasPrecioUnitario = Precio.conversionRespectoTipoPrecio(
													tipoTrabajoDetalle.getTipoPlaca().getPrecio(),
													tipoTrabajoDetalle.getTipoPlaca().getTipoPrecio().getIdTipoPrecio() 
												);
				float placasCosteTotal = placasNumPlacas * placasPrecioUnitario;
				
				// *** ***** ***
				// TIRO (TINTA)
				int tintaNumEntMaq = (Integer)sumatorias.get("tintaNumEntMaq");
				float tintaCosteTotal = cantidadRedondeada * tintaNumEntMaq * precioUnitarioTabulador;
				
				// *** ***** ***
				// TIRO (TINTA ESPECIAL)
				int tintaEspecialNumEntMaq = (Integer)sumatorias.get("tintaEspecialNumEntMaq");
				HashMap<String, Object> hashTintaEspecialPrecio = tintaEspecialService.getHashPrecioYTipoPrecio();
				float tintaEspecialPrecioUnitario = Precio.conversionRespectoTipoPrecio(
														(Float)hashTintaEspecialPrecio.get("precio"), 
														Integer.parseInt(hashTintaEspecialPrecio.get("idTipoPrecio").toString())
													);
				float tintaEspecialCosteTotal = cantidadRedondeada * tintaEspecialNumEntMaq * tintaEspecialPrecioUnitario;
				
				// *** ***** ***
				// TIRO (BARNIZ FRENTE)
				int frenteBarnizNumEntMaq = (Integer)sumatorias.get("frenteBarnizNumEntMaq");
				float frenteBarnizPrecioUnitario = Precio.conversionRespectoTipoPrecio(
														tipoTrabajoDetalle.getFrenteTipoBarniz().getPrecio(), 
														tipoTrabajoDetalle.getFrenteTipoBarniz().getTipoPrecio().getIdTipoPrecio()
													);
				float frenteBarnizCosteTotal = cantidadRedondeada * frenteBarnizNumEntMaq * frenteBarnizPrecioUnitario;
				
				// *** ***** ***
				// TIRO (BARNIZ VUELTA)
				int vueltaBarnizNumEntMaq = (Integer)sumatorias.get("vueltaBarnizNumEntMaq");
				float vueltaBarnizPrecioUnitario = Precio.conversionRespectoTipoPrecio(
														tipoTrabajoDetalle.getVueltaTipoBarniz().getPrecio(), 
														tipoTrabajoDetalle.getVueltaTipoBarniz().getTipoPrecio().getIdTipoPrecio()
													);
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
			float costoExtraTotal 		= partidaService.obtieneCostosExtrasCosteTotal(partida.getIdPartida());
			
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
		float porcentajeTipoCliente = Precio.conversionRespectoTipoPrecio(
											ordenProduccion.getCliente().getTipoCliente().getPrecio(), 
											ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getIdTipoPrecio()
										);
		float precioCliente = (float)precioBruto * (1 + porcentajeTipoCliente);
		
			
		// *** ***** ***
		// PRECIO TIPO COMPROBANTE
		float porcentajeTipoComprobante = Precio.conversionRespectoTipoPrecio(
												ordenProduccion.getTipoComprobanteFiscal().getPrecio(), 
												ordenProduccion.getTipoComprobanteFiscal().getTipoPrecio().getIdTipoPrecio()
											);
		float porcentajeComprobante = precioCliente * (1 + porcentajeTipoComprobante);
		float precioNeto = porcentajeTipoComprobante == 0 ? precioCliente : porcentajeComprobante;

		
		// *** ***** ***
		// creacion de registro
		CalificacionOrdenProduccion calificacionOrdenProduccion = new CalificacionOrdenProduccion();
			
		calificacionOrdenProduccion.setOrdenProduccion(ordenProduccion);
		calificacionOrdenProduccion.setPrecioBruto(precioBruto);
		calificacionOrdenProduccion.setTipoClientePrecio(ordenProduccion.getCliente().getTipoCliente().getPrecio());
		calificacionOrdenProduccion.setTipoClienteIdTipoPrecio(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getIdTipoPrecio());
		calificacionOrdenProduccion.setPrecioCliente(precioCliente);
		calificacionOrdenProduccion.setPrecioNeto(precioNeto);
		calificacionOrdenProduccion.setFechaGeneracion(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		calificacionOrdenProduccion.setActivo(true);

		calificacionOrdenProduccionDAO.crea(calificacionOrdenProduccion);

		precioBruto					= 0;
		porcentajeTipoCliente 		= 0;
		precioCliente 				= 0;
		porcentajeTipoComprobante 	= 0;
		porcentajeComprobante 		= 0;
		precioNeto 					= 0;
		calificacionOrdenProduccion	= null;

		return 1;
	} // creaCalificacion
	
	/********* PANTALLA *********/
	
	public CalificacionOrdenProduccion buscaCalificacionOrdenProduccion(int idOrdenProduccion) {
		return calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(idOrdenProduccion);
	} // buscaCalificacionOrdenProduccion
	
	
	public CalificacionTrabajoDetalle buscaCalificacionTrabajoDetalle(int idTipoTrabajoDetalle) {
		return calificacionTrabajoDetalleDAO.buscaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
	} // buscaCalificacionTrabajoDetalle
	
	
	public _CalificacionPartida buscaCalificacionPartida(int idPartida) {
		return calificacionPartidaDAO.busca(idPartida);
	} // buscaCalificacionPartida
	
	
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
		double precioBruto = cop.getPrecioBruto();
		
		// *** ***** ***
		// PRECIO CLIENTE
		float porcentajeTipoCliente = Precio.conversionRespectoTipoPrecio(
						ordenProduccion.getCliente().getTipoCliente().getPrecio(), 
						ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getIdTipoPrecio()
					);
		float precioCliente = (float)precioBruto * (1 + porcentajeTipoCliente);
		
		// *** ***** ***
		// PRECIO TIPO COMPROBANTE
		float porcentajeTipoComprobante = Precio.conversionRespectoTipoPrecio(
						ordenProduccion.getTipoComprobanteFiscal().getPrecio(), 
						ordenProduccion.getTipoComprobanteFiscal().getTipoPrecio().getIdTipoPrecio()
					);
		float porcentajeComprobante = precioCliente * (1 + porcentajeTipoComprobante);
		float precioNeto = porcentajeTipoComprobante == 0 ? precioCliente : porcentajeComprobante;
		
		// *** ***** ***
		// actualizacion de registro
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());

		calificacionOrdenProduccion.setPrecioBruto(precioBruto);
		calificacionOrdenProduccion.setTipoClientePrecio(ordenProduccion.getCliente().getTipoCliente().getPrecio());
		calificacionOrdenProduccion.setTipoClienteIdTipoPrecio(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getIdTipoPrecio());
		calificacionOrdenProduccion.setPrecioCliente(precioCliente);
		calificacionOrdenProduccion.setPrecioNeto(precioNeto);
		calificacionOrdenProduccion.setFechaGeneracion(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		calificacionOrdenProduccion.setObservaciones("registro modificado en la fecha: fecha_generacion");

		calificacionOrdenProduccionDAO.modifica(calificacionOrdenProduccion); // UPDATE
		
		ordenProduccion				= null;
		cop 						= null;
		calificacionOrdenProduccion	= null;
		
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
				float papelPrecioUnitario = Precio.conversionRespectoTipoPrecio(
													tipoTrabajoDetalle.getTipoPapelExtendido().getPrecio(),
													tipoTrabajoDetalle.getTipoPapelExtendido().getTipoPrecio().getIdTipoPrecio() 
												);
				float papelCosteTotal = papelCantidadTotal * papelPrecioUnitario;

				// *** ***** ***
				// PLACAS
				int placasNumPlacas = (Integer)sumatorias.get("placasNumPlacas");
				float placasPrecioUnitario = Precio.conversionRespectoTipoPrecio(
													tipoTrabajoDetalle.getTipoPlaca().getPrecio(),
													tipoTrabajoDetalle.getTipoPlaca().getTipoPrecio().getIdTipoPrecio() 
												);
				float placasCosteTotal = placasNumPlacas * placasPrecioUnitario;
				
				// *** ***** ***
				// TIRO (TINTA)
				int tintaNumEntMaq = (Integer)sumatorias.get("tintaNumEntMaq");
				float tintaCosteTotal = cantidadRedondeada * tintaNumEntMaq * precioUnitarioTabulador;
				
				// *** ***** ***
				// TIRO (TINTA ESPECIAL)
				int tintaEspecialNumEntMaq = (Integer)sumatorias.get("tintaEspecialNumEntMaq");
				HashMap<String, Object> hashTintaEspecialPrecio = tintaEspecialService.getHashPrecioYTipoPrecio();
				float tintaEspecialPrecioUnitario = Precio.conversionRespectoTipoPrecio(
														(Float)hashTintaEspecialPrecio.get("precio"), 
														Integer.parseInt(hashTintaEspecialPrecio.get("idTipoPrecio").toString())
													);
				float tintaEspecialCosteTotal = cantidadRedondeada * tintaEspecialNumEntMaq * tintaEspecialPrecioUnitario;
				
				// *** ***** ***
				// TIRO (BARNIZ FRENTE)
				int frenteBarnizNumEntMaq = (Integer)sumatorias.get("frenteBarnizNumEntMaq");
				float frenteBarnizPrecioUnitario = Precio.conversionRespectoTipoPrecio(
														tipoTrabajoDetalle.getFrenteTipoBarniz().getPrecio(), 
														tipoTrabajoDetalle.getFrenteTipoBarniz().getTipoPrecio().getIdTipoPrecio()
													);
				float frenteBarnizCosteTotal = cantidadRedondeada * frenteBarnizNumEntMaq * frenteBarnizPrecioUnitario;
				
				// *** ***** ***
				// TIRO (BARNIZ VUELTA)
				int vueltaBarnizNumEntMaq = (Integer)sumatorias.get("vueltaBarnizNumEntMaq");
				float vueltaBarnizPrecioUnitario = Precio.conversionRespectoTipoPrecio(
														tipoTrabajoDetalle.getVueltaTipoBarniz().getPrecio(), 
														tipoTrabajoDetalle.getVueltaTipoBarniz().getTipoPrecio().getIdTipoPrecio()
													);
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
			float costoExtraTotal 		= partidaService.obtieneCostosExtrasCosteTotal(partida.getIdPartida());
			
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
		// PRECIO CLIENTE
		float porcentajeTipoCliente = Precio.conversionRespectoTipoPrecio(
						ordenProduccion.getCliente().getTipoCliente().getPrecio(), 
						ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getIdTipoPrecio()
					);
		float precioCliente = (float)precioBruto * (1 + porcentajeTipoCliente);

		// *** ***** ***
		// PRECIO TIPO COMPROBANTE
		float porcentajeTipoComprobante = Precio.conversionRespectoTipoPrecio(
						ordenProduccion.getTipoComprobanteFiscal().getPrecio(), 
						ordenProduccion.getTipoComprobanteFiscal().getTipoPrecio().getIdTipoPrecio()
					);
		float porcentajeComprobante = precioCliente * (1 + porcentajeTipoComprobante);
		float precioNeto = porcentajeTipoComprobante == 0 ? precioCliente : porcentajeComprobante;
		
		// *** ***** ***
		// creacion de registro
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
			
		calificacionOrdenProduccion.setOrdenProduccion(ordenProduccion);
		calificacionOrdenProduccion.setPrecioBruto(precioBruto);
		calificacionOrdenProduccion.setTipoClientePrecio(ordenProduccion.getCliente().getTipoCliente().getPrecio());
		calificacionOrdenProduccion.setTipoClienteIdTipoPrecio(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getIdTipoPrecio());
		calificacionOrdenProduccion.setPrecioCliente(precioCliente);
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
			float costoExtraTotal 		= partidaService.obtieneCostosExtrasCosteTotal(partida.getIdPartida());
			
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
		// PRECIO CLIENTE
		float porcentajeTipoCliente = Precio.conversionRespectoTipoPrecio(
						ordenProduccion.getCliente().getTipoCliente().getPrecio(), 
						ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getIdTipoPrecio()
					);
		float precioCliente = (float)precioBruto * (1 + porcentajeTipoCliente);
		
			
		// *** ***** ***
		// PRECIO TIPO COMPROBANTE
		float porcentajeTipoComprobante = Precio.conversionRespectoTipoPrecio(
						ordenProduccion.getTipoComprobanteFiscal().getPrecio(), 
						ordenProduccion.getTipoComprobanteFiscal().getTipoPrecio().getIdTipoPrecio()
					);
		float porcentajeComprobante = precioCliente * (1 + porcentajeTipoComprobante);
		float precioNeto = porcentajeTipoComprobante == 0 ? precioCliente : porcentajeComprobante;

		
		// *** ***** ***
		// creacion de registro
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionOrdenProduccionDAO.buscaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
			
		calificacionOrdenProduccion.setOrdenProduccion(ordenProduccion);
		calificacionOrdenProduccion.setPrecioBruto(precioBruto);
		calificacionOrdenProduccion.setTipoClientePrecio(ordenProduccion.getCliente().getTipoCliente().getPrecio());
		calificacionOrdenProduccion.setTipoClienteIdTipoPrecio(ordenProduccion.getCliente().getTipoCliente().getTipoPrecio().getIdTipoPrecio());
		calificacionOrdenProduccion.setPrecioCliente(precioCliente);
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
				float porcentajeTipoCliente = Precio.conversionRespectoTipoPrecio(
						partida.getOrdenProduccion().getCliente().getTipoCliente().getPrecio(), 
						partida.getOrdenProduccion().getCliente().getTipoCliente().getTipoPrecio().getIdTipoPrecio()
					);
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
		float gananciaCliente = Precio.conversionRespectoTipoPrecio(
				calificacionOrdenProduccion.getTipoClientePrecio(), 
				calificacionOrdenProduccion.getTipoClienteIdTipoPrecio()
			);
			
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
					sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getAlto());
					sb.append(" x ");
					sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getAncho());
					sb.append("  cm. (");
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
		
		return listaRemision;
	}
	
	
	public List<OrdenProduccionDTOAyuda> obtieneVOPruebaJasper(int idOrdenProduccion) {
		return calificacionOrdenProduccionDAO.obtieneVOPruebaJasper(idOrdenProduccion);
	}

	
	public List<CalificacionTrabajoDetalleDTOAyuda> obtieneEjemploVOPapel() {
		return calificacionOrdenProduccionDAO.ejemploListaPapel();
	}
	
}

