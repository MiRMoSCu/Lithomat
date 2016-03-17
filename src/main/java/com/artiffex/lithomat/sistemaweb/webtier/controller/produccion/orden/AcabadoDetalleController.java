package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.orden;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Acabado;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.AcabadoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoExterno;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;

@Controller
@RequestMapping("/acabado_detalle")
public class AcabadoDetalleController {
	
	private static final Logger log = Logger.getLogger(AcabadoDetalleController.class);
	
	@Resource
	private AcabadoDetalleService acabadoDetalleService;
	@Resource
	private CalificacionService calificacionService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public JsonResponse agregaAcabadoDetalle(
			@RequestParam(value = "id_acabado", 				required = false) Integer idAcabado,
			@RequestParam(value = "id_proceso_externo", 		required = false) Integer idProcesoExterno,
			@RequestParam(value = "ancho", 						required = false) float ancho,
			@RequestParam(value = "alto", 						required = false) float alto,
			@RequestParam(value = "cantidad_proceso_externo", 	required = false) Integer cantidadProcesoExterno,
			@RequestParam(value = "precio_total_pesos", 		required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 			required = false) String especificaciones
		) {
		log.info("/agrega_acabado_detalle");

		AcabadoDetalle acabadoDetalle = new AcabadoDetalle();
			Acabado acabado = new Acabado();
			acabado.setIdAcabado(idAcabado);
		acabadoDetalle.setAcabado(acabado);
			ProcesoExterno procesoExterno = new ProcesoExterno();
			procesoExterno.setIdProcesoExterno(idProcesoExterno);
		acabadoDetalle.setProcesoExterno(procesoExterno);
		acabadoDetalle.setAncho(ancho);
		acabadoDetalle.setAlto(alto);
		acabadoDetalle.setCantidadProcesoExterno(cantidadProcesoExterno);
		acabadoDetalle.setEspecificaciones(especificaciones.replaceAll("\\r\\n|\\r|\\n", " "));
		acabadoDetalle.setPrecioTotalPesos(precioTotalPesos);
		acabadoDetalle.setActivo(true);

		int idAcabadoDetalle = acabadoDetalleService.creaAcabadoDetalle(acabadoDetalle);

		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(idAcabadoDetalle);
		jsonResponse.setTextoHTML(acabadoDetalleService.listaHTML(idAcabado));

		acabado = null;
		procesoExterno = null;
		acabadoDetalle = null;
		
		return jsonResponse;
	} // agregaAcabadoDetalle
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega_olvidado", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse agregaAcabadoDetalleOlvidado(
			@RequestParam(value = "id_orden_produccion",		required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_acabado", 				required = false) Integer idAcabado,
			@RequestParam(value = "id_proceso_externo", 		required = false) Integer idProcesoExterno,
			@RequestParam(value = "ancho", 						required = false) Integer ancho,
			@RequestParam(value = "alto", 						required = false) Integer alto,
			@RequestParam(value = "cantidad_proceso_externo", 	required = false) Integer cantidadProcesoExterno,
			@RequestParam(value = "precio_total_pesos", 		required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 			required = false) String especificaciones
		) {
		log.info("/agrega_acabado_detalle_olvidado");
		
		AcabadoDetalle acabadoDetalle = new AcabadoDetalle();
			Acabado acabado = new Acabado();
			acabado.setIdAcabado(idAcabado);
		acabadoDetalle.setAcabado(acabado);
			ProcesoExterno procesoExterno = new ProcesoExterno();
			procesoExterno.setIdProcesoExterno(idProcesoExterno);
		acabadoDetalle.setProcesoExterno(procesoExterno);
		acabadoDetalle.setAncho(ancho);
		acabadoDetalle.setAlto(alto);
		acabadoDetalle.setCantidadProcesoExterno(cantidadProcesoExterno);
		acabadoDetalle.setEspecificaciones(especificaciones.replaceAll("\\r\\n|\\r|\\n", " "));
		acabadoDetalle.setPrecioTotalPesos(precioTotalPesos);
		acabadoDetalle.setActivo(true);
		int resultado = acabadoDetalleService.creaAcabadoDetalle(acabadoDetalle);
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(resultado);
		
		if( resultado > 0 ) {
			// obtiene actualizacion de la tabla
			jsonResponse.setTextoHTML(acabadoDetalleService.listaHTMLModificacionPorAcabado(idAcabado));
			// actualiza precio
			calificacionService.actualizaProcesosPartida(idOrdenProduccion);
			CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
			jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
			calificacionOrdenProduccion = null;
		}
		
		acabado = null;
		procesoExterno = null;
		acabadoDetalle = null;
		
		return jsonResponse;
	} // agregaAcabadoDetalleOlvidado
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/actualiza", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaAcabadoDetalle(
			@RequestParam(value = "id_orden_produccion", 		required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_acabado", 				required = false) Integer idAcabado,
			@RequestParam(value = "id_acabado_detalle", 		required = false) Integer idAcabadoDetalle,
			@RequestParam(value = "ancho", 						required = false) float ancho,
			@RequestParam(value = "alto", 						required = false) float alto,
			@RequestParam(value = "cantidad_proceso_externo", 	required = false) Integer cantidadProcesoExterno,
			@RequestParam(value = "precio_total_pesos", 		required = false) float precioTotalPesos,
			@RequestParam(value = "especificaciones", 			required = false) String especificaciones
		) {
		log.info("/actualiza_acabado_detalle");
		
		AcabadoDetalle acabadoDetalle = acabadoDetalleService.buscaAcabadoDetalle(idAcabadoDetalle);
		acabadoDetalle.setAncho(ancho);
		acabadoDetalle.setAlto(alto);
		acabadoDetalle.setCantidadProcesoExterno(cantidadProcesoExterno);
		acabadoDetalle.setEspecificaciones(especificaciones.replaceAll("\\r\\n|\\r|\\n", " "));
		acabadoDetalle.setPrecioTotalPesos(precioTotalPesos);
		acabadoDetalleService.modificaAcabadoDetalle(acabadoDetalle);
		acabadoDetalle = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML(acabadoDetalleService.listaHTMLModificacionPorAcabado(idAcabado));
		// actualiza precio
		calificacionService.actualizaProcesosPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // actualizaAcabadoDetalle
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/elimina", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse eliminaAcabadoDetalle(
			@RequestParam(value = "id_orden_produccion", 	required = false) Integer idOrdenProduccion,
			@RequestParam(value = "id_acabado_detalle", 	required = false) Integer idAcabadoDetalle,
			@RequestParam(value = "id_acabado",				required = false) Integer idAcabado
		) {
		log.info("/elimina_acabado_detalle");
		
		AcabadoDetalle acabadoDetalle = acabadoDetalleService.buscaAcabadoDetalle(idAcabadoDetalle);
		acabadoDetalle.setActivo(false);
		acabadoDetalleService.modificaAcabadoDetalle(acabadoDetalle);
		acabadoDetalle = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML(acabadoDetalleService.listaHTMLModificacionPorAcabado(idAcabado));
		// actualiza precio
		calificacionService.actualizaProcesosPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	} // eliminaAcabadoDetalle

}
