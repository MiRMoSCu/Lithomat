package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionProcesosPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades._CalificacionPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades._CalificacionProcesosPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades._CalificacionTrabajoDetalle;

@Controller
@RequestMapping("/calificacion")
public class CalificacionController {
	
	private static final Logger log = Logger.getLogger(CalificacionController.class);
	
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private PliegoService pliegoService;
	@Resource
	private CalificacionService calificacionService;
	@Resource
	private ClienteService clienteService;
	@Resource
	private DisenioDetalleService disenioDetalleService;
	@Resource
	private PreprensaDetalleService preprensaDetalleService;
	@Resource
	private TransporteDetalleService transporteDetalleService;
	@Resource
	private AcabadoDetalleService acabadoDetalleService;
	@Resource
	private CostoExtraDetalleService costosExtrasDetalleService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/produccion", method = RequestMethod.POST)
	public String calificacionOrdenProduccion(
			@RequestParam(value = "id_orden_produccion", required = false) Integer idOrdenProduccion,
			Model model
		) {
		log.info("/calificacion_produccion");
		
		// I M P O R T A N T E
		// VERIFICAR QUE NO ES UN REFRESH DE LA PAGINA y POR TANTO AGREGARIA OTRO REGISTRO A BD Y ROMPERIA INTEGRIDAD
		// activa estatus orden de produccion para que sea visible en el visualizador y se puedan realizar los calculos de calificacion
		// estatus activo tabla orden produccion != estatus tabla historial_estatus de la orden de produccion
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccion(idOrdenProduccion);
		if( !ordenProduccion.isActivo() ) {
			ordenProduccion.setActivo(true);
			ordenProduccionService.modificaOrdenProduccion(ordenProduccion);
			model.addAttribute("ordenProduccion", ordenProduccion);
			
			// realiza calculo de calificacion
			calificacionService.creaCalificacion(idOrdenProduccion);
			
			// obtiene informacion para enviarla en el jsp
			Cliente cliente = clienteService.buscaCliente(ordenProduccion.getCliente().getIdCliente());
			model.addAttribute("cliente",cliente);
			
			CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
			model.addAttribute("calificacionOrdenProduccion",calificacionOrdenProduccion);
			
			String jsonArbol = ordenProduccionService.generaJsonArbolOrdenProduccion(idOrdenProduccion);
			model.addAttribute("jsonArbol", jsonArbol);
			
			ordenProduccion 			= null;
			cliente						= null;
			calificacionOrdenProduccion	= null;
			jsonArbol					= null;
		}
		
		return "produccion/calificacion";
	} // calificacionOrdenProduccion
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/resumen_partida", method = RequestMethod.POST)
	@ResponseBody
	public _CalificacionPartida resumenCalificacionPartida(
			@RequestParam(value = "nut", required = false) String nut,
			@RequestParam(value = "id_partida", required = false) Integer idPartida
		) {
		log.info("/resumen_calificacion_partida");
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		float porcentajeCliente = calificacionOrdenProduccion.getTipoClientePrecio() / calificacionOrdenProduccion.getTipoClienteFactorDivisor();
		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;
		
		_CalificacionPartida calificacionPartida = calificacionService.buscaCalificacionPartida(idPartida);
		float costeTotal = calificacionPartida.getCosteTotal();
		calificacionPartida.setCosteTotal( costeTotal * (1 + porcentajeCliente) );
		
		return calificacionPartida;
	} // resumenCalificacionPartida
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/resumen_trabajo_detalle", method = RequestMethod.POST)
	@ResponseBody
	public _CalificacionTrabajoDetalle resumenCalificacionTrabajoDetalle(
			@RequestParam(value = "nut", required = false) String nut,
			@RequestParam(value = "id_tipo_trabajo_detalle", required = false) Integer idTipoTrabajoDetalle
		) {
		log.info("/resumen_calificacion_trabajo_detalle");
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		float porcentajeCliente = calificacionOrdenProduccion.getTipoClientePrecio() / calificacionOrdenProduccion.getTipoClienteFactorDivisor();
		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;
		
		_CalificacionTrabajoDetalle ctd = new _CalificacionTrabajoDetalle();
		
		CalificacionTrabajoDetalle calificacionTrabajoDetalle = calificacionService.buscaCalificacionTrabajoDetalle(idTipoTrabajoDetalle);
		ctd.setCantidadRedondeada(calificacionTrabajoDetalle.getCantidadRedondeada());
		ctd.setPapelCantidadTotal(calificacionTrabajoDetalle.getPapelCantidadTotal());
		ctd.setPapelPrecioUnitario(calificacionTrabajoDetalle.getPapelPrecioUnitario() * (1 + porcentajeCliente));
		ctd.setPapelCosteTotal(calificacionTrabajoDetalle.getPapelCosteTotal() * (1 + porcentajeCliente));
		ctd.setPlacasNumPlacas(calificacionTrabajoDetalle.getPlacasNumPlacas());
		ctd.setPlacasPrecioUnitario(calificacionTrabajoDetalle.getPlacasPrecioUnitario() * (1 + porcentajeCliente));
		ctd.setPlacasCosteTotal(calificacionTrabajoDetalle.getPlacasCosteTotal() * (1 + porcentajeCliente));
		ctd.setTintaNumEntMaq(calificacionTrabajoDetalle.getTintaNumEntMaq());
		ctd.setTintaPrecioUnitario(calificacionTrabajoDetalle.getTintaPrecioUnitario() * (1 + porcentajeCliente));
		ctd.setTintaCosteTotal(calificacionTrabajoDetalle.getTintaCosteTotal() * (1 + porcentajeCliente));
		ctd.setTintaEspecialNumEntMaq(calificacionTrabajoDetalle.getTintaEspecialNumEntMaq());
		ctd.setTintaEspecialPrecioUnitario(calificacionTrabajoDetalle.getTintaEspecialPrecioUnitario() * (1 + porcentajeCliente));
		ctd.setTintaEspecialCosteTotal(calificacionTrabajoDetalle.getTintaEspecialCosteTotal() * (1 + porcentajeCliente));
		ctd.setFrenteBarnizNumEntMaq(calificacionTrabajoDetalle.getFrenteBarnizNumEntMaq());
		ctd.setFrenteBarnizPrecioUnitario(calificacionTrabajoDetalle.getFrenteBarnizPrecioUnitario() * (1 + porcentajeCliente));
		ctd.setFrenteBarnizCosteTotal(calificacionTrabajoDetalle.getFrenteBarnizCosteTotal() * (1 + porcentajeCliente));
		ctd.setVueltaBarnizNumEntMaq(calificacionTrabajoDetalle.getVueltaBarnizNumEntMaq());
		ctd.setVueltaBarnizPrecioUnitario(calificacionTrabajoDetalle.getVueltaBarnizPrecioUnitario() * (1 + porcentajeCliente));
		ctd.setVueltaBarnizCosteTotal(calificacionTrabajoDetalle.getVueltaBarnizCosteTotal() * (1 + porcentajeCliente));
		
		calificacionTrabajoDetalle = null;
		
		TipoTrabajoDetalle tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(idTipoTrabajoDetalle);
		ctd.setDescripcion(tipoTrabajoDetalle.getDescripcion());
		ctd.setMaquinaDescripcion(tipoTrabajoDetalle.getMaquina().getNombre());
		ctd.setRepeticionesXPliego(tipoTrabajoDetalle.getRepeticionesXPliego());
		ctd.setNumeroPaginasPublicacion(tipoTrabajoDetalle.getNumeroPaginasPublicacion());
		ctd.setTamanioPublicacion(tipoTrabajoDetalle.getTamanioPublicacion().getNombre());
		ctd.setNumeroPliegos(pliegoService.cuentaPliegosPorTipoTrabajoDetalle(idTipoTrabajoDetalle));
			StringBuilder sb = new StringBuilder();
			sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getNombre());
			sb.append(" ");
			sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getGramaje());
			sb.append(" gr. ");
			sb.append((int)tipoTrabajoDetalle.getTipoPapelExtendido().getAncho());
			sb.append(" x ");
			sb.append((int)tipoTrabajoDetalle.getTipoPapelExtendido().getAlto());
			sb.append(" cm. (");
			sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getKilogramos());
			sb.append(" kg.) [");
			sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getProveedorPapel().getRazonSocial());
			sb.append("]");
		ctd.setPapelDescripcion(sb.toString());
			sb.delete(0, sb.length());
			sb.append("F: ");
			sb.append(tipoTrabajoDetalle.getFrenteCombinacionTintas().getDescripcion());
			sb.append(" -- V: ");
			sb.append(tipoTrabajoDetalle.getVueltaCombinacionTintas().getDescripcion());
		ctd.setTintaDescripcion(sb.toString());
			sb.delete(0, sb.length());
			sb.append("F: ");
			sb.append(tipoTrabajoDetalle.getFrenteDescripcionTintaEspecial());
			sb.append(" -- V: ");
			sb.append(tipoTrabajoDetalle.getVueltaDescripcionTintaEspecial());
		ctd.setTintaEspecialDescripcion(sb.toString());
			sb.delete(0, sb.length());
			sb.append("F: ");
			sb.append(tipoTrabajoDetalle.getFrenteTipoBarniz().getDescripcion());
			sb.append(" -- V: ");
			sb.append(tipoTrabajoDetalle.getVueltaTipoBarniz().getDescripcion());
		ctd.setBarnizDescripcion(sb.toString());
		ctd.setPlacasDescripcion(tipoTrabajoDetalle.getTipoPlaca().getDescripcion());
			sb = null;
		ctd.setClienteProporcionaPapel(tipoTrabajoDetalle.isClienteProporcionaPapel());
		ctd.setClienteProporcionaTinta(tipoTrabajoDetalle.isClienteProporcionaTinta());
		ctd.setClienteProporcionaTintaEspecial(tipoTrabajoDetalle.isClienteProporcionaTintaEspecial());
		ctd.setClienteProporcionaBarniz(tipoTrabajoDetalle.isClienteProporcionaBarniz());
		ctd.setClienteProporcionaPlacas(tipoTrabajoDetalle.isClienteProporcionaPlacas());
		
		tipoTrabajoDetalle 			= null;
		
		return ctd;
	} // buscaCalificacionTrabajoDetalle
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/resumen_procesos", method = RequestMethod.POST)
	@ResponseBody
	public _CalificacionProcesosPartida resumenCalificacionProcesosPartida(
			@RequestParam(value = "nut", required = false) String nut,
			@RequestParam(value = "id_partida", required = false) Integer idPartida
		) {
		log.info("/resumen_calificacion_procesos");
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		float porcentajeCliente = calificacionOrdenProduccion.getTipoClientePrecio() / calificacionOrdenProduccion.getTipoClienteFactorDivisor();
		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;
		
		CalificacionProcesosPartida calificacionProcesosPartida = calificacionService.buscaCalificacionProcesos(idPartida);
		
		_CalificacionProcesosPartida cpp = new _CalificacionProcesosPartida();
		cpp.setIdCalificacionProcesosPartida(calificacionProcesosPartida.getIdCalificacionProcesosPartida());
		cpp.setCosteTotalProcesosPartida(calificacionProcesosPartida.getCosteTotalProcesosPartida() * (1 + porcentajeCliente));
		cpp.setSubpartidasCosteTotal(calificacionProcesosPartida.getSubpartidasCosteTotal() * (1 + porcentajeCliente));
		cpp.setDisenioCosteTotal(calificacionProcesosPartida.getDisenioCosteTotal() * (1 + porcentajeCliente));
		cpp.setPreprensaCosteTotal(calificacionProcesosPartida.getPreprensaCosteTotal() * (1 + porcentajeCliente));
		cpp.setTransporteCosteTotal(calificacionProcesosPartida.getTransporteCosteTotal() * (1 + porcentajeCliente));
		cpp.setAcabadoCosteTotal(calificacionProcesosPartida.getAcabadoCosteTotal() * (1 + porcentajeCliente));
		cpp.setOffsetCosteTotal(calificacionProcesosPartida.getOffsetCosteTotal() * (1 + porcentajeCliente));
		cpp.setCostoExtraTotal(calificacionProcesosPartida.getCostoExtraTotal() * (1 + porcentajeCliente));
		
		calificacionProcesosPartida = null;
		
		cpp.setHtmlTablaCostosExtras( costosExtrasDetalleService.listaHTMLProcesosYPrecioConPorcentajeCliente(idPartida, porcentajeCliente) );
		cpp.setHtmlTablaProcesosDisenio( disenioDetalleService.listaHTMLProcesosYPrecioConPorcentajeCliente(idPartida, porcentajeCliente) );
		cpp.setHtmlTablaProcesosPreprensa( preprensaDetalleService.listaHTMLProcesosYPrecioConPorcentajeCliente(idPartida, porcentajeCliente) );
		cpp.setHtmlTablaProcesosTransporte( transporteDetalleService.listaHTMLProcesosYPrecioConPorcentajeCliente(idPartida, porcentajeCliente) );
		cpp.setHtmlTablaProcesosAcabado( acabadoDetalleService.listaHTMLProcesosYPrecioConPorcentajeCliente(idPartida, porcentajeCliente) );
		
		return cpp;
	} // resumenCalificacionProcesosPartida

}
