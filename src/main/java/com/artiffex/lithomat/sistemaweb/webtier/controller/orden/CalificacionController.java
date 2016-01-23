package com.artiffex.lithomat.sistemaweb.webtier.controller.orden;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.CalificacionPartidaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.CalificacionPliegoDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.CalificacionProcesosDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.CalificacionTrabajoDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteDetalleService;

@Controller
@RequestMapping("/calificacion")
public class CalificacionController {
	
	private static final Logger log = Logger.getLogger(CalificacionController.class);
	
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private PartidaService partidaService;
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
		
		return "produccion/orden/calificacion";
	} // calificacionOrdenProduccion
	

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/resumen_partida", method = RequestMethod.POST)
	@ResponseBody
	public CalificacionPartidaDTO resumenCalificacionPartida(
			@RequestParam(value = "nut", 		required = false) String nut,
			@RequestParam(value = "id_partida", required = false) Integer idPartida
		) {
		log.info("/resumen_calificacion_partida");
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		float porcentajeCliente = calificacionOrdenProduccion.getTipoClientePrecio() / calificacionOrdenProduccion.getTipoClienteFactorDivisor();
		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;
		
		CalificacionPartida cp = calificacionService.buscaCalificacionPartida(idPartida);;
		Partida partida = partidaService.buscaPartida(idPartida);
		
		double impresionPartidaCosteTotal 	= cp.getImpresionPartidaCosteTotal() * (1 + porcentajeCliente);
		double procesosPartidaCosteTotal	= cp.getProcesosPartidaCosteTotal() * (1 + porcentajeCliente);
		double partidaCosteTotal			= cp.getPartidaCosteTotal() * (1 + porcentajeCliente);
		
		CalificacionPartidaDTO cpDTO = new CalificacionPartidaDTO();
		
		cpDTO.setNombreTipoTrabajo(partida.getTipoTrabajo().getNombre());
		cpDTO.setNombrePartida(partida.getNombrePartida());
		cpDTO.setCantidad(partida.getCantidad());
		cpDTO.setDescripcionPartida(partida.getDescripcionPartida());
		cpDTO.setImpresionPartidaCosteTotal(impresionPartidaCosteTotal);
		cpDTO.setProcesosPartidaCosteTotal(procesosPartidaCosteTotal);
		cpDTO.setPartidaCosteTotal(partidaCosteTotal);
		
		partida	= null;
		cp		= null;
		
		return cpDTO;
	} // resumenCalificacionPartida
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/resumen_trabajo_detalle", method = RequestMethod.POST)
	@ResponseBody
	public CalificacionTrabajoDetalleDTO resumenCalificacionTrabajoDetalle(
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle
		) {
		log.info("/resumen_calificacion_trabajo_detalle");
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		float porcentajeCliente = calificacionOrdenProduccion.getTipoClientePrecio() / calificacionOrdenProduccion.getTipoClienteFactorDivisor();
		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;
		
		CalificacionTrabajoDetalle ctd = calificacionService.buscaCalificacionTrabajoDetalle(idTipoTrabajoDetalle);
		TipoTrabajoDetalle tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(idTipoTrabajoDetalle);
		
		double tipoTrabajoDetalleCosteTotal = ctd.getTipoTrabajoDetalleCosteTotal() * (1 + porcentajeCliente);
		double papelCosteTotal				= ctd.getPapelCosteTotal() * (1 + porcentajeCliente);
		double placasCosteTotal				= ctd.getPlacasCosteTotal() * (1 + porcentajeCliente);
		double tintaCosteTotal				= ctd.getTintaCosteTotal() * (1 + porcentajeCliente);
		double tintaEspecialCosteTotal		= ctd.getTintaEspecialCosteTotal() * (1 + porcentajeCliente);
		double frenteBarnizCosteTotal		= ctd.getFrenteBarnizCosteTotal() * (1 + porcentajeCliente);
		double vueltaBarnizCosteTotal		= ctd.getVueltaBarnizCosteTotal() * (1 + porcentajeCliente);
		
		CalificacionTrabajoDetalleDTO ctdDTO = new CalificacionTrabajoDetalleDTO();
		
		ctdDTO.setTipoTrabajoDetalleCosteTotal(tipoTrabajoDetalleCosteTotal);
		ctdDTO.setPapelCosteTotal(papelCosteTotal);
		ctdDTO.setPlacasCosteTotal(placasCosteTotal);
		ctdDTO.setTintaCosteTotal(tintaCosteTotal);
		ctdDTO.setTintaEspecialCosteTotal(tintaEspecialCosteTotal);
		ctdDTO.setFrenteBarnizCosteTotal(frenteBarnizCosteTotal);
		ctdDTO.setVueltaBarnizCosteTotal(vueltaBarnizCosteTotal);
		ctdDTO.setDescripcion(tipoTrabajoDetalle.getDescripcion());
		ctdDTO.setMaquinaDescripcion(tipoTrabajoDetalle.getMaquina().getNombre());
		ctdDTO.setRepeticionesXPliego(tipoTrabajoDetalle.getRepeticionesXPliego());
		ctdDTO.setNumeroPaginasPublicacion(tipoTrabajoDetalle.getNumeroPaginasPublicacion());
		ctdDTO.setTamanioPublicacion(tipoTrabajoDetalle.getTamanioPublicacion().getNombre());
		ctdDTO.setClienteProporcionaPapel(tipoTrabajoDetalle.isClienteProporcionaPapel());
		ctdDTO.setClienteProporcionaTinta(tipoTrabajoDetalle.isClienteProporcionaTinta());
		ctdDTO.setClienteProporcionaTintaEspecial(tipoTrabajoDetalle.isClienteProporcionaTintaEspecial());
		ctdDTO.setClienteProporcionaBarniz(tipoTrabajoDetalle.isClienteProporcionaBarniz());
		ctdDTO.setClienteProporcionaPlacas(tipoTrabajoDetalle.isClienteProporcionaPlacas());
		
		tipoTrabajoDetalle	= null;
		ctd 				= null;
		
		return ctdDTO;
	} // buscaCalificacionTrabajoDetalle
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/resumen_pliego", method = RequestMethod.POST)
	@ResponseBody
	public CalificacionPliegoDTO resumenCalificacionPliego(
			@RequestParam(value = "nut", 		required = false) String nut,
			@RequestParam(value = "id_pliego", 	required = false) Integer idPliego
		) {
		log.info("/resumen_calificacion_pliego");
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		float porcentajeCliente = calificacionOrdenProduccion.getTipoClientePrecio() / calificacionOrdenProduccion.getTipoClienteFactorDivisor();
		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;
		
		CalificacionPliego cp = calificacionService.buscaCalificacionPliego(idPliego);
		Pliego pliego = pliegoService.buscaPliego(idPliego);
		TipoTrabajoDetalle tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(pliego.getTipoTrabajoDetalle().getIdTipoTrabajoDetalle());
		StringBuilder sb = new StringBuilder();
		
		double pliegoCosteTotal 			= cp.getPliegoCosteTotal() * (1 + porcentajeCliente);
		sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getNombre());
		sb.append(" ");
		sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getGramaje());
		sb.append(" gr. ");
		sb.append((int)tipoTrabajoDetalle.getTipoPapelExtendido().getAlto());
		sb.append(" x ");
		sb.append((int)tipoTrabajoDetalle.getTipoPapelExtendido().getAncho());
		sb.append(" cm. (");
		sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getKilogramos());
		sb.append(" kg.) [");
		sb.append(tipoTrabajoDetalle.getTipoPapelExtendido().getProveedorPapel().getRazonSocial());
		sb.append("]");
		String papelDescripcion 			= sb.toString();
		float papelPrecioUnitario 			= cp.getPapelPrecioUnitario() * (1 + porcentajeCliente);
		double papelCosteTotal				= cp.getPapelCosteTotal() * (1 + porcentajeCliente);
		
		String placasDescripcion			= sb.toString();
		float placasPrecioUnitario			= cp.getPlacasPrecioUnitario() * (1 + porcentajeCliente);
		double placasCosteTotal				= cp.getPlacasCosteTotal() * (1 + porcentajeCliente);
		
		sb.delete(0, sb.length());
		sb.append("F: ");
		sb.append(tipoTrabajoDetalle.getFrenteCombinacionTintas().getDescripcion());
		sb.append(" -- V: ");
		sb.append(tipoTrabajoDetalle.getVueltaCombinacionTintas().getDescripcion());
		String tintaDescripcion				= sb.toString();
		float tintaPrecioUnitario			= cp.getTintaPrecioUnitario() * (1 + porcentajeCliente);
		double tintaCosteTotal				= cp.getTintaCosteTotal() * (1 + porcentajeCliente);
		
		sb.delete(0, sb.length());
		sb.append("F: ");
		sb.append(tipoTrabajoDetalle.getFrenteDescripcionTintaEspecial());
		sb.append(" -- V: ");
		sb.append(tipoTrabajoDetalle.getVueltaDescripcionTintaEspecial());
		String tintaEspecialDescripcion		= sb.toString();
		float tintaEspecialPrecioUnitario	= cp.getTintaEspecialPrecioUnitario() * (1 + porcentajeCliente);
		double tintaEspecialCosteTotal		= cp.getTintaEspecialCosteTotal() * (1+ porcentajeCliente);
		
		sb.delete(0, sb.length());
		sb.append("F: ");
		sb.append(tipoTrabajoDetalle.getFrenteTipoBarniz().getDescripcion());
		sb.append(" -- V: ");
		sb.append(tipoTrabajoDetalle.getVueltaTipoBarniz().getDescripcion());
		String barnizDescripcion			= sb.toString();
		float frenteBarnizPrecioUnitario	= cp.getFrenteBarnizPrecioUnitario() * (1 + porcentajeCliente);
		double frenteBarnizCosteTotal		= cp.getFrenteBarnizCosteTotal() * (1 + porcentajeCliente);
		float vueltaBarnizPrecioUnitario	= cp.getVueltaBarnizPrecioUnitario() * (1 + porcentajeCliente);
		double vueltaBarnizCosteTotal		= cp.getVueltaBarnizCosteTotal() * (1 + porcentajeCliente);
		
		CalificacionPliegoDTO cpDTO = new CalificacionPliegoDTO();
		
		cpDTO.setIdCalificacionPliego(cp.getIdCalificacionPliego());
		cpDTO.setPliegoCosteTotal(pliegoCosteTotal);
		cpDTO.setPapelDescripcion(papelDescripcion);
		cpDTO.setPapelCantidadTotal(cp.getPapelCantidadTotal());
		cpDTO.setPapelPrecioUnitario(papelPrecioUnitario);
		cpDTO.setPapelCosteTotal(papelCosteTotal);
		cpDTO.setPlacasDescripcion(placasDescripcion);
		cpDTO.setPlacasNumPlacas(cp.getPlacasNumPlacas());
		cpDTO.setPlacasPrecioUnitario(placasPrecioUnitario);
		cpDTO.setPlacasCosteTotal(placasCosteTotal);
		cpDTO.setTintaDescripcion(tintaDescripcion);
		cpDTO.setTintaNumEntMaq(cp.getTintaNumEntMaq());
		cpDTO.setTintaPrecioUnitario(tintaPrecioUnitario);
		cpDTO.setTintaCosteTotal(tintaCosteTotal);
		cpDTO.setTintaEspecialDescripcion(tintaEspecialDescripcion);
		cpDTO.setTintaEspecialNumEntMaq(cp.getTintaEspecialNumEntMaq());
		cpDTO.setTintaEspecialPrecioUnitario(tintaEspecialPrecioUnitario);
		cpDTO.setTintaEspecialCosteTotal(tintaEspecialCosteTotal);
		cpDTO.setBarnizDescripcion(barnizDescripcion);
		cpDTO.setFrenteBarnizNumEntMaq(cp.getFrenteBarnizNumEntMaq());
		cpDTO.setFrenteBarnizPrecioUnitario(frenteBarnizPrecioUnitario);
		cpDTO.setFrenteBarnizCosteTotal(frenteBarnizCosteTotal);
		cpDTO.setVueltaBarnizNumEntMaq(cp.getVueltaBarnizNumEntMaq());
		cpDTO.setVueltaBarnizPrecioUnitario(vueltaBarnizPrecioUnitario);
		cpDTO.setVueltaBarnizCosteTotal(vueltaBarnizCosteTotal);
		cpDTO.setClienteProporcionaPapel(tipoTrabajoDetalle.isClienteProporcionaPapel());
		cpDTO.setClienteProporcionaTinta(tipoTrabajoDetalle.isClienteProporcionaTinta());
		cpDTO.setClienteProporcionaTintaEspecial(tipoTrabajoDetalle.isClienteProporcionaTintaEspecial());
		cpDTO.setClienteProporcionaBarniz(tipoTrabajoDetalle.isClienteProporcionaBarniz());
		cpDTO.setClienteProporcionaPlacas(tipoTrabajoDetalle.isClienteProporcionaPlacas());
		
		sb					= null;
		tipoTrabajoDetalle	= null;
		pliego 				= null;
		cp					= null;
		
		return cpDTO;
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/resumen_procesos", method = RequestMethod.POST)
	@ResponseBody
	public CalificacionProcesosDTO resumenCalificacionProcesos(
			@RequestParam(value = "nut", 		required = false) String nut,
			@RequestParam(value = "id_partida", required = false) Integer idPartida
		) {
		log.info("/resumen_calificacion_procesos");
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		float porcentajeCliente = calificacionOrdenProduccion.getTipoClientePrecio() / calificacionOrdenProduccion.getTipoClienteFactorDivisor();
		calificacionOrdenProduccion	= null;
		ordenProduccion 			= null;
		
		CalificacionPartida calificacionPartida = calificacionService.buscaCalificacionPartida(idPartida);
		
		double procesosPartidaCosteTotal = calificacionPartida.getProcesosPartidaCosteTotal() * (1 + porcentajeCliente);
		
		CalificacionProcesosDTO cpp = new CalificacionProcesosDTO();
		
		cpp.setProcesosPartidaCosteTotal(procesosPartidaCosteTotal);
		cpp.setHtmlTablaCostosExtras( costosExtrasDetalleService.listaHTMLProcesosYPrecioConPorcentajeCliente(idPartida, porcentajeCliente) );
		cpp.setHtmlTablaProcesosDisenio( disenioDetalleService.listaHTMLProcesosYPrecioConPorcentajeCliente(idPartida, porcentajeCliente) );
		cpp.setHtmlTablaProcesosPreprensa( preprensaDetalleService.listaHTMLProcesosYPrecioConPorcentajeCliente(idPartida, porcentajeCliente) );
		cpp.setHtmlTablaProcesosTransporte( transporteDetalleService.listaHTMLProcesosYPrecioConPorcentajeCliente(idPartida, porcentajeCliente) );
		cpp.setHtmlTablaProcesosAcabado( acabadoDetalleService.listaHTMLProcesosYPrecioConPorcentajeCliente(idPartida, porcentajeCliente) );
		
		calificacionPartida = null;
		
		return cpp;
	} // resumenCalificacionProcesosPartida
	
}
