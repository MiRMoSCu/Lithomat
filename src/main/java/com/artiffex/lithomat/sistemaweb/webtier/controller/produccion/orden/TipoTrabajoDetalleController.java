package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.orden;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CombinacionTintas;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TamanioPublicacion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoBarniz;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComplejidad;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPlaca;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PartidaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.google.gson.Gson;

@Controller
@RequestMapping("/tipo_trabajo_detalle")
public class TipoTrabajoDetalleController {
	
	private static final Logger log = Logger.getLogger(TipoTrabajoDetalleController.class);
	
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private PliegoService pliegoService;
	@Resource
	private CalificacionService calificacionService;
	@Resource
	private TabuladorPreciosService tabuladorPreciosService;
	@Resource
	private PartidaService partidaService;
	
	

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse agregaTipoTrabajoDetalle(
			@RequestParam(value = "id_partida", 						required = false) Integer idPartida,
			@RequestParam(value = "descripcion_partida_detalle", 		required = false) String descripcion,
			@RequestParam(value = "alto_final", 						required = false) float altoFinal,
			@RequestParam(value = "ancho_final", 						required = false) float anchoFinal,
			@RequestParam(value = "alto_extendido", 					required = false) float altoExtendido,
			@RequestParam(value = "ancho_extendido", 					required = false) float anchoExtendido,
			@RequestParam(value = "cliente_proporciona_papel", 			required = false) boolean clienteProporcionaPapel,
			@RequestParam(value = "cliente_proporciona_tinta_especial", required = false) boolean clienteProporcionaTintaEspecial,
			@RequestParam(value = "cliente_proporciona_barniz", 		required = false) boolean clienteProporcionaBarniz,
			@RequestParam(value = "cliente_proporciona_placas", 		required = false) boolean clienteProporcionaPlacas,
			@RequestParam(value = "id_tipo_papel_extendido", 			required = false) Integer idTipoPapelExtendido,
			@RequestParam(value = "repeticiones_x_pliego", 				required = false) Integer repeticionesXPliego,
			@RequestParam(value = "numero_paginas_publicacion", 		required = false) Integer numeroPaginasPublicacion,
			@RequestParam(value = "id_tamanio_publicacion", 			required = false) Integer idTamanioPublicacion,
			@RequestParam(value = "alto_corte_inicial", 				required = false) float altoCorteInicial,
			@RequestParam(value = "ancho_corte_inicial", 				required = false) float anchoCorteInicial,
			@RequestParam(value = "frente_id_combinacion_tintas", 		required = false) Integer frenteIdCombinacionTintas,
			@RequestParam(value = "frente_num_tinta_especial", 			required = false) Integer frenteNumTintaEspecial,
			@RequestParam(value = "frente_descripcion_tinta_especial", 	required = false) String frenteDescripcionTintaEspecial,
			@RequestParam(value = "frente_id_tipo_barniz", 				required = false) Integer frenteIdTipoBarniz,
			@RequestParam(value = "vuelta_id_combinacion_tintas", 		required = false) Integer vueltaIdCombinacionTintas,
			@RequestParam(value = "vuelta_num_tinta_especial", 			required = false) Integer vueltaNumTintaEspecial,
			@RequestParam(value = "vuelta_descripcion_tinta_especial", 	required = false) String vueltaDescripcionTintaEspecial,
			@RequestParam(value = "vuelta_id_tipo_barniz", 				required = false) Integer vueltaIdTipoBarniz,
			@RequestParam(value = "id_maquina", 						required = false) Integer idMaquina,
			@RequestParam(value = "id_tipo_placa", 						required = false) Integer idTipoPlaca,
			@RequestParam(value = "id_tipo_complejidad", 				required = false) Integer idTipoComplejidad
		) {
		log.info("/agrega_tipo_trabajo_detalle");
		
		Timestamp fechaGeneracion = new Timestamp(Calendar.getInstance().getTimeInMillis());

		TipoTrabajoDetalle tipoTrabajoDetalle = new TipoTrabajoDetalle();
			Partida partida = new Partida();
			partida.setIdPartida(idPartida);
		tipoTrabajoDetalle.setPartida(partida);
		tipoTrabajoDetalle.setDescripcion(descripcion);
		tipoTrabajoDetalle.setAltoFinal(altoFinal);
		tipoTrabajoDetalle.setAnchoFinal(anchoFinal);
		tipoTrabajoDetalle.setAltoExtendido(altoExtendido);
		tipoTrabajoDetalle.setAnchoExtendido(anchoExtendido);
		tipoTrabajoDetalle.setClienteProporcionaPapel(clienteProporcionaPapel);
		tipoTrabajoDetalle.setClienteProporcionaTinta(false);
		tipoTrabajoDetalle.setClienteProporcionaTintaEspecial(clienteProporcionaTintaEspecial);
		tipoTrabajoDetalle.setClienteProporcionaBarniz(clienteProporcionaBarniz);
		tipoTrabajoDetalle.setClienteProporcionaPlacas(clienteProporcionaPlacas);
			TipoPapelExtendido tipoPapelExtendido = new TipoPapelExtendido();
			tipoPapelExtendido.setIdTipoPapelExtendido(idTipoPapelExtendido);
		tipoTrabajoDetalle.setTipoPapelExtendido(tipoPapelExtendido);
		tipoTrabajoDetalle.setRepeticionesXPliego(repeticionesXPliego==null?0:repeticionesXPliego);
		tipoTrabajoDetalle.setNumeroPaginasPublicacion(numeroPaginasPublicacion==null?0:numeroPaginasPublicacion);
			TamanioPublicacion tamanioPublicacion = new TamanioPublicacion();
			tamanioPublicacion.setIdTamanioPublicacion(idTamanioPublicacion);
		tipoTrabajoDetalle.setTamanioPublicacion(tamanioPublicacion);
		tipoTrabajoDetalle.setAltoCorteInicial(altoCorteInicial);
		tipoTrabajoDetalle.setAnchoCorteInicial(anchoCorteInicial);
			CombinacionTintas frenteCombinacionTintas = new CombinacionTintas();
			frenteCombinacionTintas.setIdCombinacionTintas(frenteIdCombinacionTintas);
		tipoTrabajoDetalle.setFrenteCombinacionTintas(frenteCombinacionTintas);
		tipoTrabajoDetalle.setFrenteNumTintaEspecial(frenteNumTintaEspecial==null?0:frenteNumTintaEspecial);
		tipoTrabajoDetalle.setFrenteDescripcionTintaEspecial(frenteDescripcionTintaEspecial);
			TipoBarniz frenteTipoBarniz = new TipoBarniz();
			frenteTipoBarniz.setIdTipoBarniz(frenteIdTipoBarniz);
		tipoTrabajoDetalle.setFrenteTipoBarniz(frenteTipoBarniz);
			CombinacionTintas vueltaCombinacionTintas = new CombinacionTintas();
			vueltaCombinacionTintas.setIdCombinacionTintas(vueltaIdCombinacionTintas);
		tipoTrabajoDetalle.setVueltaCombinacionTintas(vueltaCombinacionTintas);
		tipoTrabajoDetalle.setVueltaNumTintaEspecial(vueltaNumTintaEspecial==null?0:vueltaNumTintaEspecial);
		tipoTrabajoDetalle.setVueltaDescripcionTintaEspecial(vueltaDescripcionTintaEspecial);
			TipoBarniz vueltaTipoBarniz = new TipoBarniz();
			vueltaTipoBarniz.setIdTipoBarniz(vueltaIdTipoBarniz);
		tipoTrabajoDetalle.setVueltaTipoBarniz(vueltaTipoBarniz);
			Maquina maquina = new Maquina();
			maquina.setIdMaquina(idMaquina);
		tipoTrabajoDetalle.setMaquina(maquina);
			TipoPlaca tipoPlaca = new TipoPlaca();
			tipoPlaca.setIdTipoPlaca(idTipoPlaca);
		tipoTrabajoDetalle.setTipoPlaca(tipoPlaca);
			TipoComplejidad tipoComplejidad = new TipoComplejidad();
			tipoComplejidad.setIdTipoComplejidad(idTipoComplejidad);
		tipoTrabajoDetalle.setTipoComplejidad(tipoComplejidad);
		tipoTrabajoDetalle.setAplicaDescuento(false);
		tipoTrabajoDetalle.setFechaGeneracion(fechaGeneracion);
		tipoTrabajoDetalle.setActivo(true);

		int idTipoTrabajoDetalle = tipoTrabajoDetalleService.creaTipoTrabajoDetalle(tipoTrabajoDetalle);
		
		partida = partidaService.buscaPartida(idPartida);
		List<ComboSelect> listaTabulador = tabuladorPreciosService.listaTabuladorDescendiente(idMaquina, idTipoComplejidad, partida.getCantidad());
		Gson gson = new Gson();

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(idTipoTrabajoDetalle);
		jsonResponse.setIdTipoTrabajoDetalle(idTipoTrabajoDetalle);
		jsonResponse.setTextoJson(gson.toJson(listaTabulador));

		listaTabulador			= null;
		gson					= null;
		fechaGeneracion 		= null;
		partida 				= null;
		tipoPapelExtendido 		= null;
		tamanioPublicacion 		= null;
		frenteCombinacionTintas = null;
		frenteTipoBarniz 		= null;
		vueltaCombinacionTintas = null;
		vueltaTipoBarniz 		= null;
		maquina 				= null;
		tipoPlaca 				= null;
		tipoComplejidad			= null;
		tipoTrabajoDetalle 		= null;
		
		return jsonResponse;
	} // agregaDetallePartida
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/elimina", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse eliminaTipoTrabajoDetalle(
			@RequestParam(value = "id_orden_produccion",		required = false) Integer idOrdenProduccion,
			@RequestParam(value = "id_partida", 				required = false) Integer idPartida,
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle
		) {
		log.info("/elimina_tipo_trabajo_detalle");
		
		// elimina ttd y sus pliegos relacionados
		tipoTrabajoDetalleService.eliminaTipoTrabajoDetalle(idTipoTrabajoDetalle);
		
		// busca nueva informacion
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		jsonResponse.setTextoHTML(tipoTrabajoDetalleService.buscaHTML(idPartida));
		
		// actualiza precio; MEJORA: PUEDE SER UNA UNIDAD LOGICA EN EL SERVICE
		calificacionService.actualizaPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // eliminaDetallePartida
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/busca", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse buscaTipoTrabajoDetalle(
			@RequestParam(value = "id_partida", required = false) Integer idPartida
		) {
		log.info("/busca_tipo_trabajo_detalle");
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		jsonResponse.setTextoHTML(tipoTrabajoDetalleService.buscaHTML(idPartida));

		return jsonResponse;
	} // buscaTipoTrabajoDetalle
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/actualiza", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaTipoTrabajoDetalle(
			@RequestParam(value = "id_orden_produccion", 				required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 								required = false) String nut,
			@RequestParam(value = "id_partida", 						required = false) Integer idPartida,
			@RequestParam(value = "id_tipo_trabajo_detalle", 			required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "descripcion_partida_detalle", 		required = false) String descripcion,
			@RequestParam(value = "alto_final", 						required = false) float altoFinal,
			@RequestParam(value = "ancho_final", 						required = false) float anchoFinal,
			@RequestParam(value = "alto_extendido", 					required = false) float altoExtendido,
			@RequestParam(value = "ancho_extendido", 					required = false) float anchoExtendido,
			@RequestParam(value = "cliente_proporciona_papel", 			required = false) boolean clienteProporcionaPapel,
			@RequestParam(value = "cliente_proporciona_tinta_especial", required = false) boolean clienteProporcionaTintaEspecial,
			@RequestParam(value = "cliente_proporciona_barniz", 		required = false) boolean clienteProporcionaBarniz,
			@RequestParam(value = "cliente_proporciona_placas", 		required = false) boolean clienteProporcionaPlacas,
			@RequestParam(value = "id_tipo_papel_extendido", 			required = false) Integer idTipoPapelExtendido,
			@RequestParam(value = "repeticiones_x_pliego", 				required = false) Integer repeticionesXPliego,
			@RequestParam(value = "numero_paginas_publicacion", 		required = false) Integer numeroPaginasPublicacion,
			@RequestParam(value = "id_tamanio_publicacion", 			required = false) Integer idTamanioPublicacion,
			@RequestParam(value = "alto_corte_inicial", 				required = false) float altoCorteInicial,
			@RequestParam(value = "ancho_corte_inicial", 				required = false) float anchoCorteInicial,
			@RequestParam(value = "frente_id_combinacion_tintas", 		required = false) Integer frenteIdCombinacionTintas,
			@RequestParam(value = "frente_num_tinta_especial", 			required = false) Integer frenteNumTintaEspecial,
			@RequestParam(value = "frente_descripcion_tinta_especial", 	required = false) String frenteDescripcionTintaEspecial,
			@RequestParam(value = "frente_id_tipo_barniz", 				required = false) Integer frenteIdTipoBarniz,
			@RequestParam(value = "vuelta_id_combinacion_tintas", 		required = false) Integer vueltaIdCombinacionTintas,
			@RequestParam(value = "vuelta_num_tinta_especial", 			required = false) Integer vueltaNumTintaEspecial,
			@RequestParam(value = "vuelta_descripcion_tinta_especial", 	required = false) String vueltaDescripcionTintaEspecial,
			@RequestParam(value = "vuelta_id_tipo_barniz", 				required = false) Integer vueltaIdTipoBarniz,
			@RequestParam(value = "id_maquina", 						required = false) Integer idMaquina,
			@RequestParam(value = "id_tipo_placa", 						required = false) Integer idTipoPlaca,
			@RequestParam(value = "id_tipo_complejidad", 				required = false) Integer idTipoComplejidad
		) {
		log.info("/actualiza_tipo_trabajo_detalle");
		
		TipoTrabajoDetalle tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(idTipoTrabajoDetalle);
		tipoTrabajoDetalle.setDescripcion(descripcion);
		tipoTrabajoDetalle.setAltoFinal(altoFinal);
		tipoTrabajoDetalle.setAnchoFinal(anchoFinal);
		tipoTrabajoDetalle.setAltoExtendido(altoExtendido);
		tipoTrabajoDetalle.setAnchoExtendido(anchoExtendido);
		tipoTrabajoDetalle.setClienteProporcionaPapel(clienteProporcionaPapel);
		tipoTrabajoDetalle.setClienteProporcionaTintaEspecial(clienteProporcionaTintaEspecial);
		tipoTrabajoDetalle.setClienteProporcionaBarniz(clienteProporcionaBarniz);
		tipoTrabajoDetalle.setClienteProporcionaPlacas(clienteProporcionaPlacas);
		tipoTrabajoDetalle.getTipoPapelExtendido().setIdTipoPapelExtendido(idTipoPapelExtendido);
		tipoTrabajoDetalle.setRepeticionesXPliego(repeticionesXPliego==null?0:repeticionesXPliego);
		tipoTrabajoDetalle.setNumeroPaginasPublicacion(numeroPaginasPublicacion==null?0:numeroPaginasPublicacion);
		tipoTrabajoDetalle.getTamanioPublicacion().setIdTamanioPublicacion(idTamanioPublicacion);
		tipoTrabajoDetalle.setAltoCorteInicial(altoCorteInicial);
		tipoTrabajoDetalle.setAnchoCorteInicial(anchoCorteInicial);
			CombinacionTintas frenteCombinacionTintas = new CombinacionTintas();
			frenteCombinacionTintas.setIdCombinacionTintas(frenteIdCombinacionTintas);
		tipoTrabajoDetalle.setFrenteCombinacionTintas(frenteCombinacionTintas);
			frenteCombinacionTintas = null;
		tipoTrabajoDetalle.setFrenteNumTintaEspecial(frenteNumTintaEspecial==null?0:frenteNumTintaEspecial);
		tipoTrabajoDetalle.setFrenteDescripcionTintaEspecial(frenteDescripcionTintaEspecial);
			TipoBarniz frenteTipoBarniz = new TipoBarniz();
			frenteTipoBarniz.setIdTipoBarniz(frenteIdTipoBarniz);
		tipoTrabajoDetalle.setFrenteTipoBarniz(frenteTipoBarniz);
			frenteTipoBarniz = null;
			CombinacionTintas vueltaCombinacionTintas = new CombinacionTintas();
			vueltaCombinacionTintas.setIdCombinacionTintas(vueltaIdCombinacionTintas);
		tipoTrabajoDetalle.setVueltaCombinacionTintas(vueltaCombinacionTintas);
			vueltaCombinacionTintas = null;
		tipoTrabajoDetalle.setVueltaNumTintaEspecial(vueltaNumTintaEspecial==null?0:vueltaNumTintaEspecial);
		tipoTrabajoDetalle.setVueltaDescripcionTintaEspecial(vueltaDescripcionTintaEspecial);
			TipoBarniz vueltaTipoBarniz = new TipoBarniz();
			vueltaTipoBarniz.setIdTipoBarniz(vueltaIdTipoBarniz);
		tipoTrabajoDetalle.setVueltaTipoBarniz(vueltaTipoBarniz);
			vueltaTipoBarniz = null;
		tipoTrabajoDetalle.getMaquina().setIdMaquina(idMaquina);
		tipoTrabajoDetalle.getTipoPlaca().setIdTipoPlaca(idTipoPlaca);
		tipoTrabajoDetalle.getTipoComplejidad().setIdTipoComplejidad(idTipoComplejidad);
		tipoTrabajoDetalleService.modificaTipoTrabajoDetalle(tipoTrabajoDetalle);
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		return null;
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/actualiza_con_pliegos", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaTipoTrabajoDetalleConPliegos(
			@RequestParam(value = "id_orden_produccion", 				required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 								required = false) String nut,
			@RequestParam(value = "id_partida", 						required = false) Integer idPartida,
			@RequestParam(value = "id_tipo_trabajo_detalle", 			required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "descripcion_partida_detalle", 		required = false) String descripcion,
			@RequestParam(value = "alto_final", 						required = false) float altoFinal,
			@RequestParam(value = "ancho_final", 						required = false) float anchoFinal,
			@RequestParam(value = "alto_extendido", 					required = false) float altoExtendido,
			@RequestParam(value = "ancho_extendido", 					required = false) float anchoExtendido,
			@RequestParam(value = "cliente_proporciona_papel", 			required = false) boolean clienteProporcionaPapel,
			@RequestParam(value = "cliente_proporciona_tinta_especial", required = false) boolean clienteProporcionaTintaEspecial,
			@RequestParam(value = "cliente_proporciona_barniz", 		required = false) boolean clienteProporcionaBarniz,
			@RequestParam(value = "cliente_proporciona_placas", 		required = false) boolean clienteProporcionaPlacas,
			@RequestParam(value = "id_tipo_papel_extendido", 			required = false) Integer idTipoPapelExtendido,
			@RequestParam(value = "repeticiones_x_pliego", 				required = false) Integer repeticionesXPliego,
			@RequestParam(value = "numero_paginas_publicacion", 		required = false) Integer numeroPaginasPublicacion,
			@RequestParam(value = "id_tamanio_publicacion", 			required = false) Integer idTamanioPublicacion,
			@RequestParam(value = "alto_corte_inicial", 				required = false) float altoCorteInicial,
			@RequestParam(value = "ancho_corte_inicial", 				required = false) float anchoCorteInicial,
			@RequestParam(value = "frente_id_combinacion_tintas", 		required = false) Integer frenteIdCombinacionTintas,
			@RequestParam(value = "frente_num_tinta_especial", 			required = false) Integer frenteNumTintaEspecial,
			@RequestParam(value = "frente_descripcion_tinta_especial", 	required = false) String frenteDescripcionTintaEspecial,
			@RequestParam(value = "frente_id_tipo_barniz", 				required = false) Integer frenteIdTipoBarniz,
			@RequestParam(value = "vuelta_id_combinacion_tintas", 		required = false) Integer vueltaIdCombinacionTintas,
			@RequestParam(value = "vuelta_num_tinta_especial", 			required = false) Integer vueltaNumTintaEspecial,
			@RequestParam(value = "vuelta_descripcion_tinta_especial", 	required = false) String vueltaDescripcionTintaEspecial,
			@RequestParam(value = "vuelta_id_tipo_barniz", 				required = false) Integer vueltaIdTipoBarniz,
			@RequestParam(value = "id_maquina", 						required = false) Integer idMaquina,
			@RequestParam(value = "id_tipo_placa", 						required = false) Integer idTipoPlaca,
			@RequestParam(value = "id_tipo_complejidad", 				required = false) Integer idTipoComplejidad
		) {
		log.info("/actualiza_tipo_trabajo_detalle_con_pliegos");
		
		TipoTrabajoDetalle tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(idTipoTrabajoDetalle);
		tipoTrabajoDetalle.setDescripcion(descripcion);
		tipoTrabajoDetalle.setAltoFinal(altoFinal);
		tipoTrabajoDetalle.setAnchoFinal(anchoFinal);
		tipoTrabajoDetalle.setAltoExtendido(altoExtendido);
		tipoTrabajoDetalle.setAnchoExtendido(anchoExtendido);
		tipoTrabajoDetalle.setClienteProporcionaPapel(clienteProporcionaPapel);
		tipoTrabajoDetalle.setClienteProporcionaTintaEspecial(clienteProporcionaTintaEspecial);
		tipoTrabajoDetalle.setClienteProporcionaBarniz(clienteProporcionaBarniz);
		tipoTrabajoDetalle.setClienteProporcionaPlacas(clienteProporcionaPlacas);
		tipoTrabajoDetalle.getTipoPapelExtendido().setIdTipoPapelExtendido(idTipoPapelExtendido);
		tipoTrabajoDetalle.setRepeticionesXPliego(repeticionesXPliego==null?0:repeticionesXPliego);
		tipoTrabajoDetalle.setNumeroPaginasPublicacion(numeroPaginasPublicacion==null?0:numeroPaginasPublicacion);
		tipoTrabajoDetalle.getTamanioPublicacion().setIdTamanioPublicacion(idTamanioPublicacion);
		tipoTrabajoDetalle.setAltoCorteInicial(altoCorteInicial);
		tipoTrabajoDetalle.setAnchoCorteInicial(anchoCorteInicial);
			CombinacionTintas frenteCombinacionTintas = new CombinacionTintas();
			frenteCombinacionTintas.setIdCombinacionTintas(frenteIdCombinacionTintas);
		tipoTrabajoDetalle.setFrenteCombinacionTintas(frenteCombinacionTintas);
			frenteCombinacionTintas = null;
		tipoTrabajoDetalle.setFrenteNumTintaEspecial(frenteNumTintaEspecial==null?0:frenteNumTintaEspecial);
		tipoTrabajoDetalle.setFrenteDescripcionTintaEspecial(frenteDescripcionTintaEspecial);
			TipoBarniz frenteTipoBarniz = new TipoBarniz();
			frenteTipoBarniz.setIdTipoBarniz(frenteIdTipoBarniz);
		tipoTrabajoDetalle.setFrenteTipoBarniz(frenteTipoBarniz);
			frenteTipoBarniz = null;
			CombinacionTintas vueltaCombinacionTintas = new CombinacionTintas();
			vueltaCombinacionTintas.setIdCombinacionTintas(vueltaIdCombinacionTintas);
		tipoTrabajoDetalle.setVueltaCombinacionTintas(vueltaCombinacionTintas);
			vueltaCombinacionTintas = null;
		tipoTrabajoDetalle.setVueltaNumTintaEspecial(vueltaNumTintaEspecial==null?0:vueltaNumTintaEspecial);
		tipoTrabajoDetalle.setVueltaDescripcionTintaEspecial(vueltaDescripcionTintaEspecial);
			TipoBarniz vueltaTipoBarniz = new TipoBarniz();
			vueltaTipoBarniz.setIdTipoBarniz(vueltaIdTipoBarniz);
		tipoTrabajoDetalle.setVueltaTipoBarniz(vueltaTipoBarniz);
			vueltaTipoBarniz = null;
		tipoTrabajoDetalle.getMaquina().setIdMaquina(idMaquina);
		tipoTrabajoDetalle.getTipoPlaca().setIdTipoPlaca(idTipoPlaca);
		tipoTrabajoDetalle.getTipoComplejidad().setIdTipoComplejidad(idTipoComplejidad);
		tipoTrabajoDetalleService.modificaTipoTrabajoDetalle(tipoTrabajoDetalle);
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// INSTRUCCIONES:
		// elimina los pliegos ya existentes porque hay nueva informacion y deben calcularse nuevos pliegos
		// y se elimina logicamente la calificacion de esos pliegos ya existentes.
		// POR TANTO, SI ACEPTA LOS NUEVOS PLIEGOS:
		// 1) se debe saber cuales son los pliegos eliminados
		// SI acepta los nuevos pliegos, OK
		// SINO, entonces 
		//		a) se debe activar los pliegos anteriores en la tabla PLIEGO (los que se acaban de eliminar)
		// 		b) se debe actualizar el valor anterior modificado de base de datos en la tabla TIPO_TRABAJO_DETALLE 
		//			porque no hay nuevos pliegos insertados con la nueva información porque no se acepto. 
		List<Integer> listaIdPliegosEliminados = pliegoService.eliminaPliegoPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
		jsonResponse.setTextoJson( new Gson().toJson(listaIdPliegosEliminados).toString() );
		
		tipoTrabajoDetalle = null;
		
		return jsonResponse;
	} // actualizaTipoTrabajoDetalle
	
}
