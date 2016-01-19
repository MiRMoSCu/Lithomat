package com.artiffex.lithomat.sistemaweb.webtier.controller.visualizador;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
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
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistorialEstatus;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CombinacionTintasService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.EstatusOrdenService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.HistorialEstatusService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaterialAyudaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaterialAyudaXPartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OffsetService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoDisenioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoExternoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoPreprensaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoTransporteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ResponsableInsumoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TamanioPublicacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoBarnizService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoComplejidadService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoComprobanteFiscalService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoFormaTrabajoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPapelExtendidoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.VisualizadorService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.google.gson.Gson;

@Controller
@RequestMapping("/visualizador")
public class VisualizadorController {
	
	private static final Logger log = Logger.getLogger(VisualizadorController.class);
	
	private static final int BUSQUEDA_DEFAULT = 0;
	
	@Resource
	private VisualizadorService visualizadorService;
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
	private CostoExtraService costoExtraService;
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
	private CostoExtraDetalleService costoExtraDetalleService;
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
	@Resource
	private CalificacionService calificacionService;
	@Resource
	private TipoComprobanteFiscalService tipoComprobanteFiscalService;
	@Resource
	private TipoFormaTrabajoService tipoFormaTrabajoService;
	@Resource
	private TipoPapelExtendidoService tipoPapelExtendidoService;
	@Resource
	private TamanioPublicacionService tamanioPublicacionService;
	@Resource
	private CombinacionTintasService combinacionTintasService;
	@Resource
	private TipoBarnizService tipoBarnizService;
	@Resource
	private MaquinaService maquinaService;
	@Resource
	private TipoComplejidadService tipoComplejidadService;
	@Resource
	private ProcesoDisenioService procesoDisenioService;
	@Resource
	private ProcesoPreprensaService procesoPreprensaService;
	@Resource
	private ProcesoTransporteService procesoTransporteService;
	@Resource
	private ProcesoExternoService procesoExternoService;
	@Resource
	private MaterialAyudaService materialAyudaService;
	@Resource
	private ResponsableInsumoService responsableInsumoService;
	
	
	/*
	 * inicializa la pantalla del visualizador con los registos base
	 */
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String visualizador(Model model) {
		log.info("/visualizador");
		
		// configuracion de controles de pantalla
		List<ComboSelect> listaEstatusOrden = estatusOrdenService.listaComboSelect();
		model.addAttribute("listaEstatusOrden", listaEstatusOrden);
		listaEstatusOrden = null;
		
		// configuracion busqueda
		int tipoBusqueda = BUSQUEDA_DEFAULT;

		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 3;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);

		// numero total de registros
		int numeroTotalRegistros = 
				visualizadorService.getNumeroOrdenesProduccion(
						tipoBusqueda, 	// tipo busqueda
						null,			// nut
						null,			// nombre
						null,			// descripcion
						null,			// fecha_cotizacion_inicio
						null,			// fecha_cotizacion_fin
						null,			// cliente
						0				// id_estatus_orden
					);
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);

		// realiza busquedas
		List<VisualizadorDTO> listaOrdenesProduccion = 
				visualizadorService.getListaOrdenesProduccion(
						tipoBusqueda,				// tipo_busqueda
						numeroPagina,				// numeroPagina
						numeroRegistrosPorPagina,	// numeroRegistrosPorPagina
						null,						// nut
						null,						// nombre
						null,						// descripcion
						null,						// fecha_cotizacion_inicio
						null,						// fecha_cotizacion_fin
						null,						// cliente
						0							// id_estatus_orden
					);
		model.addAttribute("listaOrdenesProduccion", listaOrdenesProduccion);
		listaOrdenesProduccion = null;

		return "visualizador/visualizador";
	} // visualizador
	
	/*
	 * busca orden de produccion con los parametros especificados
	 */
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/busca_ordenes_produccion", method = RequestMethod.POST /*, headers = "Accept=application/json"*/)
	@ResponseBody
	public String buscaOrdenesProduccion(
			@RequestParam(value = "tipo_busqueda", 					required = false) Integer tipoBusqueda,
			@RequestParam(value = "numero_pagina", 					required = false) Integer numeroPagina,
			@RequestParam(value = "numero_registros_por_pagina", 	required = false) Integer numeroRegistrosPorPagina,
			@RequestParam(value = "nut", 							required = false) String nut,
			@RequestParam(value = "nombre", 						required = false) String nombre,
			@RequestParam(value = "descripcion", 					required = false) String descripcion,
			@RequestParam(value = "fecha_cotizacion_inicio", 		required = false) String fechaCotizacionInicio,
			@RequestParam(value = "fecha_cotizacion_fin", 			required = false) String fechaCotizacionFin,
			@RequestParam(value = "cliente", 						required = false) String cliente,
			@RequestParam(value = "id_estatus_orden", 				required = false) Integer idEstatusOrden
		) {
		log.info("/busca_ordenes_produccion");
		
		StringBuilder sb = new StringBuilder();
		Gson gson = new Gson();
		
		tipoBusqueda = tipoBusqueda == null ? 0 : tipoBusqueda;
		// *
		// * {"numeroTotalRegistros":13, 
		// *  "ordenesProduccion": [ {
		// *  	"nut":"",
		// * 		"nombre":"", 
		// * 		"descripcion":"", 
		// * 		"fecha_cotizacion":"", 
		// * 		"cliente":"",
		// * 		"estatus":""}, {"...":"...", ...}, {"":""}. ] }
		// *
		int numeroTotalRegistros = visualizadorService.getNumeroOrdenesProduccion(tipoBusqueda, nut, nombre, descripcion, fechaCotizacionInicio, fechaCotizacionFin, cliente, idEstatusOrden);
		List<VisualizadorDTO> listaOrdenesProduccion = visualizadorService.getListaOrdenesProduccion(tipoBusqueda, numeroPagina, numeroRegistrosPorPagina, nut, nombre, descripcion, fechaCotizacionInicio, fechaCotizacionFin, cliente, idEstatusOrden );

		sb.append("{");
		sb.append("\"numeroTotalRegistros\":");
		sb.append(numeroTotalRegistros);
		sb.append(",");
		sb.append("\"listaOrdenesProduccion\":");
		sb.append(gson.toJson(listaOrdenesProduccion));
		sb.append("}");
		
		listaOrdenesProduccion	= null;
		gson 					= null;

		return sb.toString();
	} // buscaOrdenesProduccion
	
	/*
	 * obtiene jsp con resumen del nut solicitado
	 */
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/obtiene_detalle_nut", method = RequestMethod.GET)
	public String obtieneDetalleNut(
			@RequestParam(value = "nut", required = false) String nut,
			Model model
		) {
		log.info("/obtiene_detalle_nut");
		
		// configuracion de los select
		
		List<ComboSelect> listaTipoComprobanteFiscal = tipoComprobanteFiscalService.listaComboSelect();
		model.addAttribute("listaTipoComprobanteFiscal",listaTipoComprobanteFiscal);
		listaTipoComprobanteFiscal = null;
		
		List<ComboSelect> listaTipoFormaTrabajo = tipoFormaTrabajoService.listaComboSelect();
		model.addAttribute("listaTipoFormaTrabajo", listaTipoFormaTrabajo);
		listaTipoFormaTrabajo = null;
		
		List<ComboSelect> listaTipoPapelExtendido = tipoPapelExtendidoService.listaComboSelect();
		model.addAttribute("listaTipoPapelExtendido", listaTipoPapelExtendido);
		listaTipoPapelExtendido = null;
		
		List<ComboSelect> listaTamanioPublicacion = tamanioPublicacionService.listaComboSelect();
		model.addAttribute("listaTamanioPublicacion", listaTamanioPublicacion);
		listaTamanioPublicacion = null;
		
		List<ComboSelect> listaCombinacionTintas = combinacionTintasService.listaComboSelect();
		model.addAttribute("listaCombinacionTintas", listaCombinacionTintas);
		listaCombinacionTintas = null;
		
		List<ComboSelect> listaTipoBarniz = tipoBarnizService.listaComboSelect();
		model.addAttribute("listaTipoBarniz", listaTipoBarniz);
		listaTipoBarniz = null;
		
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		model.addAttribute("listaMaquina", listaMaquina);
		listaMaquina = null;
		
		List<ComboSelect> listaTipoComplejidad = tipoComplejidadService.listaComboSelect();
		model.addAttribute("listaTipoComplejidad", listaTipoComplejidad);
		listaTipoComplejidad = null;
		
		List<ComboSelect> listaResponsableInsumo = responsableInsumoService.listaComboSelect();
		model.addAttribute("listaResponsableInsumo", listaResponsableInsumo);
		listaResponsableInsumo = null;
		
		// lista procesos por seccion
		
		Gson gson = new Gson();
		
		List<ComboSelect> listaProcesoDisenio = procesoDisenioService.listaComboSelect();
		String jsonListaProcesoDisenio = gson.toJson(listaProcesoDisenio);
		model.addAttribute("jsonListaProcesoDisenio",jsonListaProcesoDisenio.toString());
		listaProcesoDisenio = null;
		
		List<ComboSelect> listaProcesoPreprensa = procesoPreprensaService.listaComboSelect();
		String jsonListaProcesoPreprensa = gson.toJson(listaProcesoPreprensa);
		model.addAttribute("jsonListaProcesoPreprensa",jsonListaProcesoPreprensa.toString());
		listaProcesoPreprensa = null;
		
		List<ComboSelect> listaProcesoTransporte = procesoTransporteService.listaComboSelect();
		String jsonListaProcesoTransporte = gson.toJson(listaProcesoTransporte);
		model.addAttribute("jsonListaProcesoTransporte",jsonListaProcesoTransporte.toString());
		listaProcesoTransporte = null;
		
		List<ComboSelect> listaProcesoExterno = procesoExternoService.listaComboSelect();
		String jsonListaProcesoExterno = gson.toJson(listaProcesoExterno);
		model.addAttribute("jsonListaProcesoExterno",jsonListaProcesoExterno.toString());
		listaProcesoExterno = null;
		
		List<ComboSelect> listaMaterialAyuda = materialAyudaService.listaComboSelect();
		String jsonListaMaterialAyuda = gson.toJson(listaMaterialAyuda);
		model.addAttribute("jsonListaMaterialAyuda",jsonListaMaterialAyuda.toString());
		listaMaterialAyuda = null;
		
		List<ComboSelect> listaCostoExtra = costoExtraService.listaComboSelect();
		String jsonListaCostoExtra = gson.toJson(listaCostoExtra);
		model.addAttribute("jsonListaCostoExtra",jsonListaCostoExtra.toString());
		listaCostoExtra = null;
		
		gson = null;
		
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
		model.addAttribute("listaEstatusOrden", listaEstatusOrden);
		listaEstatusOrden = null;
		
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(ordenProduccion.getIdOrdenProduccion()); 
		model.addAttribute("precio_neto", calificacionOrdenProduccion.getPrecioNeto());
		calificacionOrdenProduccion	= null;
		
		ordenProduccion 			= null;

		return "visualizador/detalle_nut";
	} // obtieneDetalleNut
	
	/*
	 * genera html de la lista de procesos de partida
	 */
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/obtiene_partida", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse obtienePartida(
			@RequestParam(value = "id_partida", required = false) Integer idPartida
		) {
		log.info("/obtiene_partida");
		
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
	
	/*
	 * obtiene lista de subpartida
	 */
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
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
		sb.append(",");
		sb.append("\"lista_costo_extra_detalle\":");
		sb.append("\"" + costoExtraDetalleService.listaHTMLModificacion(idTipoTrabajoDetalle) + "\"");
		sb.append("}");

		jsonResponse.setTextoJson(sb.toString());
		
		tipoTrabajoDetalle = null;
		gson = null;
		sb = null;

		return jsonResponse;
	} // obtieneTipoTrabajoDetalle
	
	/*
	 * obtiene jsp que muestra el detalle de los precios
	 */
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/obtiene_precio_detalle", method = RequestMethod.GET)
	public String obtienePrecioDetalle(
			@RequestParam(value = "nut", required = false) String nut,
			Model model
		) {
		log.info("/obtiene_precio_detalle");
		
		OrdenProduccion op = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		model.addAttribute("op", op);
		
		// obtiene informacion para enviarla en el jsp
		Cliente c = clienteService.buscaCliente(op.getCliente().getIdCliente());
		model.addAttribute("c",c);
		
		CalificacionOrdenProduccion cop = calificacionService.buscaCalificacionOrdenProduccion(op.getIdOrdenProduccion());
		model.addAttribute("cop",cop);
		
		String jsonArbol = ordenProduccionService.generaJsonArbolOrdenProduccion(op.getIdOrdenProduccion());
		model.addAttribute("jsonArbol", jsonArbol);
		
		op 			= null;
		c 			= null;
		cop			= null;
		jsonArbol	= null;
		
		return "visualizador/detalle_precio";
	} // obtienePrecioDetalle
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/obtiene_precio_neto", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse obtienePrecioNeto(
			@RequestParam(value = "id_orden_produccion", 	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 					required = false) String nut
		) {
		log.info("/obtiene_precio_neto");
		
		JsonResponse jsonResponse = new JsonResponse();
		calificacionService.actualizaPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // obtienePrecioNeto
	
}
