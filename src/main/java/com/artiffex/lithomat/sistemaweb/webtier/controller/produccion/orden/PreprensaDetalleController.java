package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.orden;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Preprensa;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.PreprensaDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoPreprensa;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaDetalleService;

@Controller
@RequestMapping("/preprensa_detalle")
public class PreprensaDetalleController {
	
	private static final Logger log = Logger.getLogger(PreprensaDetalleController.class);
	
	@Resource
	private PreprensaDetalleService preprensaDetalleService;
	@Resource
	private CalificacionService calificacionService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse agregaPreprensaDetalle(
			@RequestParam(value = "id_preprensa", 			required = false) Integer idPreprensa,
			@RequestParam(value = "id_proceso_preprensa", 	required = false) Integer idProcesoPreprensa,
			@RequestParam(value = "cantidad", 				required = false) Integer cantidad,
			@RequestParam(value = "precio_total_pesos", 	required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 		required = false) String especificaciones
		) {
		log.info("/agrega_preprensa_detalle");
		
		PreprensaDetalle preprensaDetalle = new PreprensaDetalle();
			Preprensa preprensa = new Preprensa();
			preprensa.setIdPreprensa(idPreprensa);
		preprensaDetalle.setPreprensa(preprensa);			
			ProcesoPreprensa procesoPreprensa = new ProcesoPreprensa();
			procesoPreprensa.setIdProcesoPreprensa(idProcesoPreprensa);
		preprensaDetalle.setProcesoPreprensa(procesoPreprensa);
		preprensaDetalle.setCantidad(cantidad);
		preprensaDetalle.setEspecificaciones(especificaciones.replaceAll("\\r\\n|\\r|\\n", " "));
		preprensaDetalle.setPrecioTotalPesos(precioTotalPesos);
		preprensaDetalle.setActivo(true);

		int idPreprensaDetalle = preprensaDetalleService.creaPreprensaDetalle(preprensaDetalle);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(idPreprensaDetalle);
		jsonResponse.setTextoHTML(preprensaDetalleService.listaHTML(idPreprensa));

		preprensa 			= null;
		procesoPreprensa 	= null;
		preprensaDetalle 	= null;
		
		return jsonResponse;
	} // agregaPreprensaDetalle
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega_olvidado", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse agregaPreprensaDetalleOlvidado(
			@RequestParam(value = "id_orden_produccion",	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 					required = false) String nut,
			@RequestParam(value = "id_preprensa", 			required = false) Integer idPreprensa,
			@RequestParam(value = "id_proceso_preprensa", 	required = false) Integer idProcesoPreprensa,
			@RequestParam(value = "cantidad", 				required = false) Integer cantidad,
			@RequestParam(value = "precio_total_pesos", 	required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 		required = false) String especificaciones
		) {
		log.info("/agrega_preprensa_detalle_olvidado");
		
		PreprensaDetalle preprensaDetalle = new PreprensaDetalle();
			Preprensa preprensa = new Preprensa();
			preprensa.setIdPreprensa(idPreprensa);
		preprensaDetalle.setPreprensa(preprensa);
			ProcesoPreprensa procesoPreprensa = new ProcesoPreprensa();
			procesoPreprensa.setIdProcesoPreprensa(idProcesoPreprensa);
		preprensaDetalle.setProcesoPreprensa(procesoPreprensa);
		preprensaDetalle.setCantidad(cantidad);
		preprensaDetalle.setEspecificaciones(especificaciones.replaceAll("\\r\\n|\\r|\\n", " "));
		preprensaDetalle.setPrecioTotalPesos(precioTotalPesos);
		preprensaDetalle.setActivo(true);
		
		int resultado = preprensaDetalleService.creaPreprensaDetalle(preprensaDetalle);
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(resultado);
		
		if( resultado > 0 ) {
			// obtiene actualizacion de la tabla
			jsonResponse.setTextoHTML(preprensaDetalleService.listaHTMLModificacionPorPreprensa(idPreprensa));
			// actualiza precio
			calificacionService.actualizaProcesosPartida(idOrdenProduccion);
			CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
			jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
			calificacionOrdenProduccion = null;
		}
		
		preprensa = null;
		procesoPreprensa = null;
		preprensaDetalle = null;
		
		return jsonResponse;
	} // agregaPreprensaDetalleOlvidado
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/actualiza", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaPreprensaDetalle(
			@RequestParam(value = "id_orden_produccion", 	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 					required = false) String nut,
			@RequestParam(value = "id_preprensa", 			required = false) Integer idPreprensa,
			@RequestParam(value = "id_preprensa_detalle", 	required = false) Integer idPreprensaDetalle,
			@RequestParam(value = "cantidad", 				required = false) Integer cantidad,
			@RequestParam(value = "precio_total_pesos", 	required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 		required = false) String especificaciones
		) {
		log.info("/actualiza_preprensa_detalle");
		
		PreprensaDetalle preprensaDetalle = preprensaDetalleService.buscaPreprensaDetalle(idPreprensaDetalle);
		preprensaDetalle.setCantidad(cantidad);
		preprensaDetalle.setEspecificaciones(especificaciones.replaceAll("\\r\\n|\\r|\\n", " "));
		preprensaDetalle.setPrecioTotalPesos(precioTotalPesos);
		preprensaDetalleService.modificaPreprensaDetalle(preprensaDetalle);
		preprensaDetalle = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML(preprensaDetalleService.listaHTMLModificacionPorPreprensa(idPreprensa));
		// actualiza precio
		calificacionService.actualizaProcesosPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // actualizaPreprensaDetalle

	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/elimina", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse eliminaPreprensaDetalle(
			@RequestParam(value = "id_orden_produccion", 	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "id_preprensa_detalle", 	required = false) Integer idPreprensaDetalle,
			@RequestParam(value = "id_preprensa",			required = false) Integer idPreprensa
		) {
		log.info("/elimina_preprensa_detalle");
		
		PreprensaDetalle preprensaDetalle = preprensaDetalleService.buscaPreprensaDetalle(idPreprensaDetalle);
		preprensaDetalle.setActivo(false);
		preprensaDetalleService.modificaPreprensaDetalle(preprensaDetalle);
		preprensaDetalle = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML(preprensaDetalleService.listaHTMLModificacionPorPreprensa(idPreprensa));
		// actualiza precio
		calificacionService.actualizaProcesosPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // eliminaPreprensaDetalle

}
