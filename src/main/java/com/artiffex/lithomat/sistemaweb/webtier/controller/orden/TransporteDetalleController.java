package com.artiffex.lithomat.sistemaweb.webtier.controller.orden;

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
import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoTransporte;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Transporte;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TransporteDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteDetalleService;

@Controller
@RequestMapping("/transporte_detalle")
public class TransporteDetalleController {
	
	private static final Logger log = Logger.getLogger(TransporteDetalleController.class);
	
	@Resource
	private TransporteDetalleService transporteDetalleService;
	@Resource
	private CalificacionService calificacionService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse agregaTransporteDetalle(
			@RequestParam(value = "id_transporte", 			required = false) Integer idTransporte,
			@RequestParam(value = "id_proceso_transporte", 	required = false) Integer idProcesoTransporte,
			@RequestParam(value = "cantidad", 				required = false) Integer cantidad,
			@RequestParam(value = "precio_total_pesos", 	required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 		required = false) String especificaciones
		) {
		log.info("/agrega_transporte_detalle");
		
		TransporteDetalle transporteDetalle = new TransporteDetalle();
			Transporte transporte = new Transporte();
			transporte.setIdTransporte(idTransporte);
		transporteDetalle.setTransporte(transporte);
			ProcesoTransporte procesoTransporte = new ProcesoTransporte();
			procesoTransporte.setIdProcesoTransporte(idProcesoTransporte);
		transporteDetalle.setProcesoTransporte(procesoTransporte);
		transporteDetalle.setCantidad(cantidad);
		transporteDetalle.setEspecificaciones(especificaciones);
		transporteDetalle.setPrecioTotalPesos(precioTotalPesos);
		transporteDetalle.setActivo(true);

		int idTransporteDetalle = transporteDetalleService.creaTransporteDetalle(transporteDetalle);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(idTransporteDetalle);
		jsonResponse.setTextoHTML(transporteDetalleService.listaHTML(idTransporte));

		transporte			= null;
		procesoTransporte 	= null;
		transporteDetalle 	= null;
		
		return jsonResponse;
	} // agregaTransporteDetalle
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega_olvidado", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse agregaTransporteDetalleOlvidado(
			@RequestParam(value = "id_orden_produccion",	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 					required = false) String nut,
			@RequestParam(value = "id_transporte", 			required = false) Integer idTransporte,
			@RequestParam(value = "id_proceso_transporte", 	required = false) Integer idProcesoTransporte,
			@RequestParam(value = "cantidad", 				required = false) Integer cantidad,
			@RequestParam(value = "precio_total_pesos", 	required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 		required = false) String especificaciones
		) {
		log.info("/agrega_transporte_detalle_olvidado");
		
		TransporteDetalle transporteDetalle = new TransporteDetalle();
			Transporte transporte = new Transporte();
			transporte.setIdTransporte(idTransporte);
		transporteDetalle.setTransporte(transporte);
			ProcesoTransporte procesoTransporte = new ProcesoTransporte();
			procesoTransporte.setIdProcesoTransporte(idProcesoTransporte);
		transporteDetalle.setProcesoTransporte(procesoTransporte);
		transporteDetalle.setCantidad(cantidad);
		transporteDetalle.setEspecificaciones(especificaciones);
		transporteDetalle.setPrecioTotalPesos(precioTotalPesos);
		transporteDetalle.setActivo(true);
		
		int resultado = transporteDetalleService.creaTransporteDetalle(transporteDetalle);
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(resultado);
		
		if( resultado > 0 ) {
			// obtiene actualizacion de la tabla
			jsonResponse.setTextoHTML(transporteDetalleService.listaHTMLModificacionPorTransporte(idTransporte));
			// actualiza precio
			calificacionService.actualizaProcesosPartida(idOrdenProduccion);
			CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
			jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
			calificacionOrdenProduccion = null;
		}
		
		transporte = null;
		procesoTransporte = null;
		transporteDetalle = null;
		
		return jsonResponse;
	} // agregaTransporteDetalleOlvidado
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/actualiza", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaTransporteDetalle(
			@RequestParam(value = "id_orden_produccion", 	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 					required = false) String nut,
			@RequestParam(value = "id_transporte", 			required = false) Integer idTransporte,
			@RequestParam(value = "id_transporte_detalle", 	required = false) Integer idTransporteDetalle,
			@RequestParam(value = "cantidad", 				required = false) Integer cantidad,
			@RequestParam(value = "precio_total_pesos", 	required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 		required = false) String especificaciones
		) {
		log.info("/actualiza_transporte_detalle");
		
		TransporteDetalle transporteDetalle = transporteDetalleService.buscaTransporteDetalle(idTransporteDetalle);
		transporteDetalle.setCantidad(cantidad);
		transporteDetalle.setEspecificaciones(especificaciones);
		transporteDetalle.setPrecioTotalPesos(precioTotalPesos);
		transporteDetalleService.modificaTransporteDetalle(transporteDetalle);
		transporteDetalle = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML(transporteDetalleService.listaHTMLModificacionPorTransporte(idTransporte));
		// actualiza precio
		calificacionService.actualizaProcesosPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // actualizaTransporteDetalle
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/elimina", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse eliminaTransporteDetalle(
			@RequestParam(value = "id_orden_produccion", 	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 					required = false) String nut,
			@RequestParam(value = "id_transporte_detalle", 	required = false) Integer idTransporteDetalle,
			@RequestParam(value = "id_transporte",			required = false) Integer idTransporte
		) {
		log.info("/elimina_transporte_detalle");
		
		TransporteDetalle transporteDetalle = transporteDetalleService.buscaTransporteDetalle(idTransporteDetalle);
		transporteDetalle.setActivo(false);
		transporteDetalleService.modificaTransporteDetalle(transporteDetalle);
		transporteDetalle = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML(transporteDetalleService.listaHTMLModificacionPorTransporte(idTransporte));
		// actualiza precio
		calificacionService.actualizaProcesosPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // eliminaTransporteDetalle

}
