package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.semaforo;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.AcabadoDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.DisenioDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.OffsetDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.PartidaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.PreprensaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.TipoTrabajoDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.TransporteDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistorialEstatus;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.EstatusOrdenService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.HistorialEstatusService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaterialAyudaXPartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OffsetService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.SemaforoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaSemaforo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/semaforo")
public class SemaforoController {
	
	private static final Logger log = Logger.getLogger(SemaforoController.class);
	
	@Resource
	private SemaforoService semaforoService;
	@Resource
	private EstatusOrdenService estatusOrdenService;
	@Resource
	private ClienteService clienteService;
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private PartidaService partidaService;
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private PliegoService pliegoService;
	@Resource
	private HistorialEstatusService historialEstatusService;
	@Resource
	private DisenioService disenioService;
	@Resource
	private PreprensaService preprensaService;
	@Resource
	private TransporteService transporteService;
	@Resource
	private AcabadoService acabadoService;
	@Resource
	private OffsetService offsetService;
	@Resource
	private DisenioDetalleService disenioDetalleService;
	@Resource
	private PreprensaDetalleService preprensaDetalleService;
	@Resource
	private TransporteDetalleService transporteDetalleService;
	@Resource
	private AcabadoDetalleService acabadoDetalleService;
	@Resource
	private MaterialAyudaXPartidaService materialAyudaXPartidaService;
	
	
	
	@Secured({"ROLE_DISENIO","ROLE_PREPRENSA","ROLE_TRANSPORTE","ROLE_PROCESO_EXTERNO","ROLE_ACABADO"})
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String semaforo(Model model) {
		log.info("/semaforo");
		
		ParametrosBusquedaSemaforo parametros = new ParametrosBusquedaSemaforo();
		// determina el estatus que puede ser visible segun usuario
		SecurityContext context = SecurityContextHolder.getContext();
		if ( context != null ) {
			Authentication authentication = context.getAuthentication();
			if ( authentication != null ) {
				//System.out.println( authentication.getName() );
				for ( GrantedAuthority authority : authentication.getAuthorities() ) { 
					// spring permite que usuario pueda tener varios roles
					// EL SISTEMA DEBE REVISAR QUE SOLO SE TENGA UN ROL POR UN USUARIO
					parametros.setRole( authority.getAuthority() );
				}
			}
		}
		parametros.setBusquedaPorNut(false);
		parametros.setBusquedaPorNombreOrdenProduccion(false);
		parametros.setBusquedaPorDescripcionOrdenProduccion(false);
		parametros.setBusquedaPorNombreMoral(false);
		parametros.setNut("");
		parametros.setNombreOrdenProduccion("");
		parametros.setDescripcionOrdenProduccion("");
		parametros.setNombreMoral("");
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 3;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);

		// numero total de registros
		int numeroTotalRegistros = semaforoService.numeroRegistrosPorCriterioBusqueda(parametros);
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);
		
		List<VisualizadorDTO> listaOrdenesProduccion = semaforoService.listaPorCriterioBusquedaPorNumeroPagina(parametros, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaOrdenesProduccion", listaOrdenesProduccion);
		listaOrdenesProduccion = null;
		
		parametros = null;
		
		return "produccion/semaforo/semaforo_visualizador";
	}
	
	
	@Secured({"ROLE_DISENIO","ROLE_PREPRENSA","ROLE_TRANSPORTE","ROLE_PROCESO_EXTERNO","ROLE_ACABADO"})
	@RequestMapping(value = "/busca_ordenes_produccion", method = RequestMethod.POST)
	@ResponseBody
	public String buscaOrdenesProduccion(
			@RequestParam(value = "numero_pagina", 					required = false) Integer numeroPagina,
			@RequestParam(value = "numero_registros_por_pagina", 	required = false) Integer numeroRegistrosPorPagina,
			@RequestParam(value = "chkbx_busca_por_nut", 			required = false) boolean busquedaPorNut,
			@RequestParam(value = "chkbx_busca_por_nombre_op", 		required = false) boolean busquedaPorNombreOrdenProduccion,
			@RequestParam(value = "chkbx_busca_por_descripcion", 	required = false) boolean busquedaPorDescripcionOrdenProduccion,
			@RequestParam(value = "chkbx_busca_por_nombre_moral", 	required = false) boolean busquedaPorNombreMoral,
			@RequestParam(value = "nut", 							required = false) String nut,
			@RequestParam(value = "nombre", 						required = false) String nombreOrdenProduccion,
			@RequestParam(value = "descripcion", 					required = false) String descripcionOrdenProduccion,
			@RequestParam(value = "nombre_moral", 					required = false) String nombreMoral
		) {
		log.info("/semaforo_busca_ordenes_produccion");
		
		ParametrosBusquedaSemaforo parametros = new ParametrosBusquedaSemaforo();
		// determina el estatus que puede ser visible segun usuario
		SecurityContext context = SecurityContextHolder.getContext();
		if ( context != null ) {
			Authentication authentication = context.getAuthentication();
			if ( authentication != null ) {
				//System.out.println( authentication.getName() );
				for ( GrantedAuthority authority : authentication.getAuthorities() ) { 
					// spring permite que usuario pueda tener varios roles
					// EL SISTEMA DEBE REVISAR QUE SOLO SE TENGA UN ROL POR UN USUARIO
					parametros.setRole( authority.getAuthority() );
				}
			}
		}
		parametros.setBusquedaPorNut(busquedaPorNut);
		parametros.setBusquedaPorNombreOrdenProduccion(busquedaPorNombreOrdenProduccion);
		parametros.setBusquedaPorDescripcionOrdenProduccion(busquedaPorDescripcionOrdenProduccion);
		parametros.setBusquedaPorNombreMoral(busquedaPorNombreMoral);
		parametros.setNut(nut);
		parametros.setNombreOrdenProduccion(nombreOrdenProduccion);
		parametros.setDescripcionOrdenProduccion(descripcionOrdenProduccion);
		parametros.setNombreMoral(nombreMoral);
		
		int numeroTotalRegistros = semaforoService.numeroRegistrosPorCriterioBusqueda(parametros);
		List<VisualizadorDTO> listaOrdenesProduccion = semaforoService.listaPorCriterioBusquedaPorNumeroPagina(parametros, numeroPagina, numeroRegistrosPorPagina);
		
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"numeroTotalRegistros\":");
		sb.append(numeroTotalRegistros);
		sb.append(",");
		sb.append("\"listaOrdenesProduccion\":");
		sb.append(gson.toJson(listaOrdenesProduccion));
		sb.append("}");
		
		gson 					= null;
		listaOrdenesProduccion 	= null;
		parametros 				= null;
		
		return sb.toString();
	}
	
	
	@Secured({"ROLE_DISENIO","ROLE_PREPRENSA","ROLE_TRANSPORTE","ROLE_PROCESO_EXTERNO","ROLE_ACABADO"})
	@RequestMapping(value = "/obtiene_detalle_nut", method = RequestMethod.GET)
	public String obtieneDetalleNut(
			@RequestParam(value = "nut", required = false) String nut,
			Model model
		) {
		log.info("/semaforo_obtiene_detalle_nut");
		
		// informacion del jsp
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		model.addAttribute("ordenProduccion", ordenProduccion);
		
		HistorialEstatus historialEstatus = historialEstatusService.buscaUltimoHistorialEstatus(ordenProduccion.getIdOrdenProduccion());
		model.addAttribute("historialEstatus",historialEstatus);
		historialEstatus = null;
		
		Cliente cliente = clienteService.buscaCliente(ordenProduccion.getCliente().getIdCliente());
		model.addAttribute("cliente", cliente);
		cliente = null;

		List<Partida> listaPartida = partidaService.listaPartidaPorOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		model.addAttribute("listaPartida", listaPartida);
		listaPartida = null;

		List<ComboSelect> listaEstatusOrden = estatusOrdenService.listaComboSelectEstatusPosiblePorNut(nut);
		// remueve estatus finalizado porque estos usuarios no pueden finalizar la OP.
		listaEstatusOrden.remove( listaEstatusOrden.size() - 1 );
		model.addAttribute("listaEstatusOrden", listaEstatusOrden);
		listaEstatusOrden = null;
		
		ordenProduccion = null;
		
		return "produccion/semaforo/semaforo_detalle_nut";
	}
	
	
	@Secured({"ROLE_DISENIO","ROLE_PREPRENSA","ROLE_TRANSPORTE","ROLE_PROCESO_EXTERNO","ROLE_ACABADO"})
	@RequestMapping(value = "/obtiene_partida", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse obtienePartida(
			@RequestParam(value = "id_partida", required = false) Integer idPartida
		) {
		log.info("/semaforo_obtiene_partida");
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);

		PartidaDTO partida 			= partidaService.buscaPartidaEnDTO(idPartida);
		DisenioDTO disenio 			= disenioService.buscaDisenioPorPartidaEnDTO(idPartida);
		PreprensaDTO preprensa		= preprensaService.buscaPreprensaPorPartidaEnDTO(idPartida);
		TransporteDTO transporte 	= transporteService.buscaTransportePorPartidaEnDTO(idPartida);
		AcabadoDTO acabado 			= acabadoService.buscaAcabadoPorPartidaEnDTO(idPartida);
		OffsetDTO offset 			= offsetService.buscaOffsetPorPartidaEnDTO(idPartida);

		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();
		
		sb.append("{");
		sb.append("\"descripcion_partida\":");
		sb.append(gson.toJson(partida));
		sb.append(",");
		sb.append("\"disenio\":");
		sb.append(gson.toJson(disenio));
		sb.append(",");
		sb.append("\"preprensa\":");
		sb.append(gson.toJson(preprensa));
		sb.append(",");
		sb.append("\"transporte\":");
		sb.append(gson.toJson(transporte));
		sb.append(",");
		sb.append("\"acabado\":");
		sb.append(gson.toJson(acabado));
		sb.append(",");
		sb.append("\"offset\":");
		sb.append(gson.toJson(offset));
		sb.append(",");
		sb.append("\"lista_subpartidas\":");
		sb.append("\"" + tipoTrabajoDetalleService.buscaHTML(idPartida) + "\"");
		sb.append(",");
		sb.append("\"disenio_detalle\":");
		sb.append("\"" + disenioDetalleService.listaHTMLModificacionPorDisenio(disenio.getIdDisenio()) + "\"");
		sb.append(",");
		sb.append("\"preprensa_detalle\":");
		sb.append("\"" + preprensaDetalleService.listaHTMLModificacionPorPreprensa(preprensa.getIdPreprensa()) + "\"");
		sb.append(",");
		sb.append("\"transporte_detalle\":");
		sb.append("\"" + transporteDetalleService.listaHTMLModificacionPorTransporte(transporte.getIdTransporte()) + "\"");
		sb.append(",");
		sb.append("\"acabado_detalle\":");
		sb.append("\"" + acabadoDetalleService.listaHTMLModificacionPorAcabado(acabado.getIdAcabado()) + "\"");
		sb.append(",");
		sb.append("\"material_ayuda\":");
		sb.append("\"" + materialAyudaXPartidaService.listaHTMLModificacion(idPartida) + "\"");
		sb.append("}");

		jsonResponse.setTextoJson(sb.toString());

		partida 	= null;
		disenio 	= null;
		preprensa 	= null;
		transporte 	= null;
		acabado 	= null;
		offset 		= null;
		gson 		= null;
		sb 			= null;

		return jsonResponse;
	} // obtienePartida
	
	
	@Secured({"ROLE_DISENIO","ROLE_PREPRENSA","ROLE_TRANSPORTE","ROLE_PROCESO_EXTERNO","ROLE_ACABADO"})
	@RequestMapping(value = "/obtiene_tipo_trabajo_detalle", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse obtieneTipoTrabajoDetalle(
			@RequestParam(value = "id_tipo_trabajo_detalle", required = false) Integer idTipoTrabajoDetalle
		) {
		log.info("/obtiene_tipo_trabajo_detalle");
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);

		TipoTrabajoDetalleDTO tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalleEnDTO(idTipoTrabajoDetalle);

		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();

		sb.append("{");
		sb.append("\"tipo_trabajo_detalle\":");
		sb.append(gson.toJson(tipoTrabajoDetalle));
		sb.append(",");
		sb.append("\"lista_pliegos\":");
		sb.append("\"" + pliegoService.listaHTMLModificacion(idTipoTrabajoDetalle) + "\"");
		sb.append("}");

		jsonResponse.setTextoJson(sb.toString());
		
		tipoTrabajoDetalle = null;
		gson = null;
		sb = null;

		return jsonResponse;
	} // obtieneTipoTrabajoDetalle
	
	
	@Secured({"ROLE_DISENIO","ROLE_PREPRENSA","ROLE_TRANSPORTE","ROLE_PROCESO_EXTERNO","ROLE_ACABADO"})
	@RequestMapping(value = "/cambia_estatus", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse cambiaEstatusOrdenProduccion(
			@RequestParam(value = "id_orden_produccion",	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "id_estatus_orden", 		required = false) Integer idEstatusOrden
		){
		log.info("/cambia_estatus_orden_produccion");
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String usuario = principal.toString();
		if ( principal instanceof UserDetails ) {
			usuario = ((UserDetails)principal).getUsername();
		}
		
		HistorialEstatus historialEstatus = new HistorialEstatus();
			OrdenProduccion ordenProduccion = new OrdenProduccion();
			ordenProduccion.setIdOrdenProduccion(idOrdenProduccion);
		historialEstatus.setOrdenProduccion(ordenProduccion);
			EstatusOrden estatusOrden = new EstatusOrden();
			estatusOrden.setIdEstatusOrden(idEstatusOrden);
		historialEstatus.setEstatusOrden(estatusOrden);
		historialEstatus.setFecha(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		historialEstatus.setUsuario(usuario);
		historialEstatus.setObservaciones("");
		historialEstatus.setActivo(true);
		
		int resultado = historialEstatusService.creaHistorialEstatus(historialEstatus);
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(resultado);
		
		ordenProduccion = ordenProduccionService.buscaOrdenProduccion(idOrdenProduccion);
		List<ComboSelect> listaEstatusOrden = estatusOrdenService.listaComboSelectEstatusPosiblePorNut(ordenProduccion.getNut());
		// remueve estatus finalizado porque estos usuarios no pueden finalizar la OP.
		listaEstatusOrden.remove( listaEstatusOrden.size() - 1 );
		jsonResponse.setTextoJson(new Gson().toJson(listaEstatusOrden));
		
		ordenProduccion 	= null;
		estatusOrden		= null;
		historialEstatus 	= null;
		listaEstatusOrden	= null;
		principal 			= null;
		
		return jsonResponse;
	} // cambiaEstatusOrdenProduccion
	
}
