package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion;

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
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PliegoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/tipo_trabajo_detalle")
public class TipoTrabajoDetalleController {
	
	private static final Logger log = Logger.getLogger(TipoTrabajoDetalleController.class);
	
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private PliegoService pliegoService;
	

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse agregaTipoTrabajoDetalle(
			@RequestParam(value = "id_partida", 						required = false) Integer idPartida,
			@RequestParam(value = "descripcion_partida_detalle", 		required = false) String descripcion,
			@RequestParam(value = "ancho", 								required = false) float ancho,
			@RequestParam(value = "alto", 								required = false) float alto,
			@RequestParam(value = "ancho_extendido", 					required = false) float anchoExtendido,
			@RequestParam(value = "alto_extendido", 					required = false) float altoExtendido,
			@RequestParam(value = "cliente_proporciona_papel", 			required = false) boolean clienteProporcionaPapel,
			@RequestParam(value = "cliente_proporciona_tinta_especial", required = false) boolean clienteProporcionaTintaEspecial,
			@RequestParam(value = "cliente_proporciona_barniz", 		required = false) boolean clienteProporcionaBarniz,
			@RequestParam(value = "cliente_proporciona_placas", 		required = false) boolean clienteProporcionaPlacas,
			@RequestParam(value = "id_tipo_papel_extendido", 			required = false) Integer idTipoPapelExtendido,
			@RequestParam(value = "repeticiones_x_pliego", 				required = false) Integer repeticionesXPliego,
			@RequestParam(value = "numero_paginas_publicacion", 		required = false) Integer numeroPaginasPublicacion,
			@RequestParam(value = "id_tamanio_publicacion", 			required = false) Integer idTamanioPublicacion,
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
		tipoTrabajoDetalle.setAncho(ancho);
		tipoTrabajoDetalle.setAlto(alto);
		tipoTrabajoDetalle.setAnchoExtendido(anchoExtendido);
		tipoTrabajoDetalle.setAltoExtendido(altoExtendido);
		tipoTrabajoDetalle.setClienteProporcionaPapel(clienteProporcionaPapel);
		tipoTrabajoDetalle.setClienteProporcionaTinta(false);
		tipoTrabajoDetalle.setClienteProporcionaTintaEspecial(clienteProporcionaTintaEspecial);
		tipoTrabajoDetalle.setClienteProporcionaBarniz(clienteProporcionaBarniz);
		tipoTrabajoDetalle.setClienteProporcionaPlacas(clienteProporcionaPlacas);
			TipoPapelExtendido tipoPapelExtendido = new TipoPapelExtendido();
			tipoPapelExtendido.setIdTipoPapelExtendido(idTipoPapelExtendido);
		tipoTrabajoDetalle.setTipoPapelExtendido(tipoPapelExtendido);
		tipoTrabajoDetalle.setRepeticionesXPliego(repeticionesXPliego == null ? 0 : repeticionesXPliego);
		tipoTrabajoDetalle.setNumeroPaginasPublicacion(numeroPaginasPublicacion == null ? 0 : numeroPaginasPublicacion);
			TamanioPublicacion tamanioPublicacion = new TamanioPublicacion();
			tamanioPublicacion.setIdTamanioPublicacion(idTamanioPublicacion);
		tipoTrabajoDetalle.setTamanioPublicacion(tamanioPublicacion);
			CombinacionTintas frenteCombinacionTintas = new CombinacionTintas();
			frenteCombinacionTintas.setIdCombinacionTintas(frenteIdCombinacionTintas);
		tipoTrabajoDetalle.setFrenteCombinacionTintas(frenteCombinacionTintas);
		tipoTrabajoDetalle.setFrenteNumTintaEspecial(frenteNumTintaEspecial == null ? 0 : frenteNumTintaEspecial);
		tipoTrabajoDetalle.setFrenteDescripcionTintaEspecial(frenteDescripcionTintaEspecial);
			TipoBarniz frenteTipoBarniz = new TipoBarniz();
			frenteTipoBarniz.setIdTipoBarniz(frenteIdTipoBarniz);
		tipoTrabajoDetalle.setFrenteTipoBarniz(frenteTipoBarniz);
			CombinacionTintas vueltaCombinacionTintas = new CombinacionTintas();
			vueltaCombinacionTintas.setIdCombinacionTintas(vueltaIdCombinacionTintas);
		tipoTrabajoDetalle.setVueltaCombinacionTintas(vueltaCombinacionTintas);
		tipoTrabajoDetalle.setVueltaNumTintaEspecial(vueltaNumTintaEspecial == null ? 0 : vueltaNumTintaEspecial);
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
		tipoTrabajoDetalle.setFechaGeneracion(fechaGeneracion);
		tipoTrabajoDetalle.setActivo(true);

		int idTipoTrabajoDetalle = tipoTrabajoDetalleService.creaTipoTrabajoDetalle(tipoTrabajoDetalle);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(idTipoTrabajoDetalle);
		jsonResponse.setIdTipoTrabajoDetalle(idTipoTrabajoDetalle);

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
	public String eliminaTipoTrabajoDetalle(
			@RequestParam(value = "id_tipo_trabajo_detalle", required = false) Integer idTipoTrabajoDetalle
		) {
		log.info("/elimina_detalle_partida");
		
		TipoTrabajoDetalle tipoTrabajoDetalle =tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(idTipoTrabajoDetalle);
		tipoTrabajoDetalle.setActivo(false);
		
		tipoTrabajoDetalleService.modificaTipoTrabajoDetalle(tipoTrabajoDetalle);
		
		tipoTrabajoDetalle = null;
		
		return "1";
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
			@RequestParam(value = "ancho", 								required = false) float ancho,
			@RequestParam(value = "alto", 								required = false) float alto,
			@RequestParam(value = "ancho_extendido", 					required = false) float anchoExtendido,
			@RequestParam(value = "alto_extendido", 					required = false) float altoExtendido,
			@RequestParam(value = "cliente_proporciona_papel", 			required = false) boolean clienteProporcionaPapel,
			@RequestParam(value = "cliente_proporciona_tinta_especial", required = false) boolean clienteProporcionaTintaEspecial,
			@RequestParam(value = "cliente_proporciona_barniz", 		required = false) boolean clienteProporcionaBarniz,
			@RequestParam(value = "cliente_proporciona_placas", 		required = false) boolean clienteProporcionaPlacas,
			@RequestParam(value = "id_tipo_papel_extendido", 			required = false) Integer idTipoPapelExtendido,
			@RequestParam(value = "repeticiones_x_pliego", 				required = false) Integer repeticionesXPliego,
			@RequestParam(value = "numero_paginas_publicacion", 		required = false) Integer numeroPaginasPublicacion,
			@RequestParam(value = "id_tamanio_publicacion", 			required = false) Integer idTamanioPublicacion,
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
		tipoTrabajoDetalle.setAncho(anchoExtendido);
		tipoTrabajoDetalle.setAlto(altoExtendido);
		tipoTrabajoDetalle.setAnchoExtendido(anchoExtendido);
		tipoTrabajoDetalle.setAltoExtendido(altoExtendido);
		tipoTrabajoDetalle.setClienteProporcionaPapel(clienteProporcionaPapel);
		tipoTrabajoDetalle.setClienteProporcionaTintaEspecial(clienteProporcionaTintaEspecial);
		tipoTrabajoDetalle.setClienteProporcionaBarniz(clienteProporcionaBarniz);
		tipoTrabajoDetalle.setClienteProporcionaPlacas(clienteProporcionaPlacas);
		tipoTrabajoDetalle.getTipoPapelExtendido().setIdTipoPapelExtendido(idTipoPapelExtendido);
		tipoTrabajoDetalle.setRepeticionesXPliego(repeticionesXPliego);
		tipoTrabajoDetalle.setNumeroPaginasPublicacion(numeroPaginasPublicacion);
		tipoTrabajoDetalle.getTamanioPublicacion().setIdTamanioPublicacion(idTamanioPublicacion);
		tipoTrabajoDetalle.getFrenteCombinacionTintas().setIdCombinacionTintas(frenteIdCombinacionTintas);
		tipoTrabajoDetalle.setFrenteNumTintaEspecial(frenteNumTintaEspecial);
		tipoTrabajoDetalle.setFrenteDescripcionTintaEspecial(frenteDescripcionTintaEspecial);
		tipoTrabajoDetalle.getFrenteTipoBarniz().setIdTipoBarniz(frenteIdTipoBarniz);
		tipoTrabajoDetalle.getVueltaCombinacionTintas().setIdCombinacionTintas(vueltaIdCombinacionTintas);
		tipoTrabajoDetalle.setVueltaNumTintaEspecial(vueltaNumTintaEspecial);
		tipoTrabajoDetalle.setVueltaDescripcionTintaEspecial(vueltaDescripcionTintaEspecial);
		tipoTrabajoDetalle.getVueltaTipoBarniz().setIdTipoBarniz(vueltaIdTipoBarniz);
		tipoTrabajoDetalle.getMaquina().setIdMaquina(idMaquina);
		tipoTrabajoDetalle.getTipoPlaca().setIdTipoPlaca(idTipoPlaca);
		tipoTrabajoDetalle.getTipoComplejidad().setIdTipoComplejidad(idTipoComplejidad);
		
		tipoTrabajoDetalleService.modificaTipoTrabajoDetalle(tipoTrabajoDetalle);
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// INSTRUCCIONES:
		// elimina los pliegos ya existentes porque hay nueva informacion y debe calculrse  nuevos pliegos.
		// POR TANTO:
		// 1) se debe saber cuales son los pliegos eliminados
		// SI acepta los nuevos pliegos, OK
		// SINO acepta los nuevos pliegos, entonces 
		//		a) se debe activar los pliegos anteriores en la tabla PLIEGO (los que se acaban de eliminar)
		// 		b) se debe actualizar el valor anterior modificado de base de datos en la tabla TIPO_TRABAJO_DETALLE 
		//			porque no hay nuevos pliegos insertados con la nueva información porque no se acepto. 
		List<Integer> listaIdPliegosEliminados = pliegoService.eliminaPliegoPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
		jsonResponse.setTextoJson( new Gson().toJson(listaIdPliegosEliminados) );
		
		tipoTrabajoDetalle = null;
		
		return jsonResponse;
	} // actualizaTipoTrabajoDetalle
	
}
