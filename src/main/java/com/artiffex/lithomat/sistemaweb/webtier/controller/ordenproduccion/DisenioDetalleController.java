package com.artiffex.lithomat.sistemaweb.webtier.controller.ordenproduccion;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Disenio;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.DisenioDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoDisenio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioDetalleService;

@Controller
@RequestMapping("/disenio_detalle")
public class DisenioDetalleController {

	private static final Logger log = Logger.getLogger(DisenioController.class);
	
	@Resource
	private DisenioDetalleService disenioDetalleService;
	@Resource
	private CalificacionService calificacionService;
	
	
	@RequestMapping(value = "/agrega_disenio_detalle", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse agregaDisenioDetalle(
			@RequestParam(value = "id_disenio", 		required = false) Integer idDisenio,
			@RequestParam(value = "id_proceso_disenio", required = false) Integer idProcesoDisenio,
			@RequestParam(value = "cantidad", 			required = false) Integer cantidad,
			@RequestParam(value = "precio_total_pesos", required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 	required = false) String especificaciones
		) {
		log.info("/agrega");

		DisenioDetalle disenioDetalle = new DisenioDetalle();
			Disenio disenio = new Disenio();
			disenio.setIdDisenio(idDisenio);
		disenioDetalle.setDisenio(disenio);
			ProcesoDisenio procesoDisenio = new ProcesoDisenio();
			procesoDisenio.setIdProcesoDisenio(idProcesoDisenio);
		disenioDetalle.setProcesoDisenio(procesoDisenio);
		disenioDetalle.setCantidad(cantidad);
		disenioDetalle.setEspecificaciones(especificaciones);
		disenioDetalle.setPrecioTotalPesos(precioTotalPesos);
		disenioDetalle.setActivo(true);

		int idDisenioDetalle = disenioDetalleService.creaDisenioDetalle(disenioDetalle);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(idDisenioDetalle);
		jsonResponse.setTextoHTML(disenioDetalleService.listaHTML(idDisenio));

		disenio			= null;
		procesoDisenio 	= null;
		disenioDetalle 	= null;
		
		return jsonResponse;
	} // agregaDisenioDetalle
	
	@RequestMapping(value = "/agrega_olvidado", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse agregaDisenioDetalleOlvidado(
			@RequestParam(value = "id_orden_produccion",	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 					required = false) String nut,
			@RequestParam(value = "id_disenio", 			required = false) Integer idDisenio,
			@RequestParam(value = "id_proceso_disenio", 	required = false) Integer idProcesoDisenio,
			@RequestParam(value = "cantidad", 				required = false) Integer cantidad,
			@RequestParam(value = "precio_total_pesos", 	required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 		required = false) String especificaciones
		) {
		log.info("/agrega_disenio_detalle_olvidado");
		
		DisenioDetalle disenioDetalle = new DisenioDetalle();
			Disenio disenio = new Disenio();
			disenio.setIdDisenio(idDisenio);
		disenioDetalle.setDisenio(disenio);
			ProcesoDisenio procesoDisenio = new ProcesoDisenio();
			procesoDisenio.setIdProcesoDisenio(idProcesoDisenio);
		disenioDetalle.setProcesoDisenio(procesoDisenio);
		disenioDetalle.setCantidad(cantidad);
		disenioDetalle.setEspecificaciones(especificaciones);
		disenioDetalle.setPrecioTotalPesos(precioTotalPesos);
		disenioDetalle.setActivo(true);
		
		int resultado = disenioDetalleService.creaDisenioDetalle(disenioDetalle);
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(resultado);
		
		if( resultado > 0 ) {
			// obtiene actualizacion de la tabla
			jsonResponse.setTextoHTML(disenioDetalleService.listaHTMLModificacionPorDisenio(idDisenio));
			// actualiza precio
			calificacionService.actualizaProcesosPartida(idOrdenProduccion);
			
			CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
			
			jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
			
			calificacionOrdenProduccion = null;
		}
		
		disenio = null;
		procesoDisenio = null;
		disenioDetalle = null;
		
		return jsonResponse;
	} // agregaDisenioDetalleOlvidado

	@RequestMapping(value = "/actualiza", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaDisenioDetalle(
			@RequestParam(value = "id_orden_produccion", 	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 					required = false) String nut,
			@RequestParam(value = "id_disenio", 			required = false) Integer idDisenio,
			@RequestParam(value = "id_disenio_detalle", 	required = false) Integer idDisenioDetalle,
			@RequestParam(value = "cantidad", 				required = false) Integer cantidad,
			@RequestParam(value = "precio_total_pesos", 	required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 		required = false) String especificaciones
		) {
		log.info("/actualiza_disenio_detalle");
		
		DisenioDetalle disenioDetalle = disenioDetalleService.buscaDisenioDetalle(idDisenioDetalle);
		disenioDetalle.setCantidad(cantidad);
		disenioDetalle.setEspecificaciones(especificaciones);
		disenioDetalle.setPrecioTotalPesos(precioTotalPesos);
		disenioDetalleService.modificaDisenioDetalle(disenioDetalle);
		disenioDetalle = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML(disenioDetalleService.listaHTMLModificacionPorDisenio(idDisenio));
		// actualiza precio
		calificacionService.actualizaProcesosPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // actualizaDisenioDetalle
	
	@RequestMapping(value = "/elimina", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse eliminaDisenioDetalle(
			@RequestParam(value = "id_orden_produccion", 	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 					required = false) String nut,
			@RequestParam(value = "id_disenio_detalle", 	required = false) Integer idDisenioDetalle,
			@RequestParam(value = "id_disenio",				required = false) Integer idDisenio
		) {
		log.info("/elimina_disenio_detalle");
		
		DisenioDetalle disenioDetalle = disenioDetalleService.buscaDisenioDetalle(idDisenioDetalle);
		disenioDetalle.setActivo(false);
		disenioDetalleService.modificaDisenioDetalle(disenioDetalle);
		disenioDetalle = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML(disenioDetalleService.listaHTMLModificacionPorDisenio(idDisenio));
		// actualiza precio
		calificacionService.actualizaProcesosPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // eliminaDisenioDetalle
	
}
