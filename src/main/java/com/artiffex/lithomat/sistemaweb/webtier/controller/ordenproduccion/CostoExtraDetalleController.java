package com.artiffex.lithomat.sistemaweb.webtier.controller.ordenproduccion;

import java.io.IOException;
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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtra;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtraDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.ResponsableInsumo;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ResponsableInsumoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/costo_extra_detalle")
public class CostoExtraDetalleController {

	private static final Logger log = Logger.getLogger(CostoExtraDetalleController.class);
	
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private ResponsableInsumoService responsableInsumoService;
	@Resource
	private CostoExtraService costoExtraService;
	@Resource
	private CostoExtraDetalleService costoExtraDetalleService;
	@Resource
	private CalificacionService calificacionService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/busca_unidad_medida", method = RequestMethod.POST)
	@ResponseBody
	public String buscaUnidadMedidaCostoExtra(
			@RequestParam(value = "id_costo_extra", required = false) Integer idCostoExtra
		){
		CostoExtra costoExtra = costoExtraService.buscaCostoExtra(idCostoExtra);
		String unidadMedida = costoExtra.getTipoPrecio().getNombre();
		costoExtra = null;
		return unidadMedida;
	}
	
	//***********
	// Metodos utilizados en OrdenProduccion
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega_en_op", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse agregaCostoExtraDetalleEnOrdenProduccion(
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "id_responsable_insumo", 		required = false) Integer idResponsableInsumo,
			@RequestParam(value = "id_costo_extra", 			required = false) Integer idCostoExtra,
			@RequestParam(value = "cantidad", 					required = false) Integer cantidad,
			@RequestParam(value = "especificacion", 			required = false) String especificacion
		) throws IOException {
		log.info("/agrega_costo_extra_detalle_en_orden_produccion");
		
		CostoExtraDetalle costoExtraDetalle = new CostoExtraDetalle();
			TipoTrabajoDetalle tipoTrabajoDetalle = new TipoTrabajoDetalle();
			tipoTrabajoDetalle.setIdTipoTrabajoDetalle(idTipoTrabajoDetalle);
		costoExtraDetalle.setTipoTrabajoDetalle(tipoTrabajoDetalle);
			ResponsableInsumo responsableInsumo = new ResponsableInsumo();
			responsableInsumo.setIdResponsableInsumo(idResponsableInsumo);
		costoExtraDetalle.setResponsableInsumo(responsableInsumo);
			CostoExtra costoExtra = new CostoExtra();
			costoExtra.setIdCostoExtra(idCostoExtra);
		costoExtraDetalle.setCostoExtra(costoExtra);
		costoExtraDetalle.setCantidad(cantidad);
		costoExtraDetalle.setEspecificacion(especificacion);
		costoExtraDetalle.setActivo(true);
		
		costoExtraDetalleService.creaCostoExtraDetalle(costoExtraDetalle);
			
		tipoTrabajoDetalle 	= null;
		responsableInsumo	= null;
		costoExtra			= null;
		costoExtraDetalle	= null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setTextoHTML(costoExtraDetalleService.buscaHTML(idTipoTrabajoDetalle));
		return jsonResponse;
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega_olvidado", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse agregaCostoExtraDetalleOlvidado(
			@RequestParam(value = "id_orden_produccion",		required = false) Integer idOrdenProduccion,
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "id_responsable_insumo", 		required = false) Integer idResponsableInsumo,
			@RequestParam(value = "id_costo_extra", 			required = false) Integer idCostoExtra,
			@RequestParam(value = "cantidad", 					required = false) Integer cantidad,
			@RequestParam(value = "especificacion", 			required = false) String especificacion
		) throws IOException {
		log.info("/agrega_costo_extra_detalle_olvidado");
		
		CostoExtraDetalle costoExtraDetalle = new CostoExtraDetalle();
			TipoTrabajoDetalle tipoTrabajoDetalle = new TipoTrabajoDetalle();
			tipoTrabajoDetalle.setIdTipoTrabajoDetalle(idTipoTrabajoDetalle);
		costoExtraDetalle.setTipoTrabajoDetalle(tipoTrabajoDetalle);
			ResponsableInsumo responsableInsumo = new ResponsableInsumo();
			responsableInsumo.setIdResponsableInsumo(idResponsableInsumo);
		costoExtraDetalle.setResponsableInsumo(responsableInsumo);
			CostoExtra costoExtra = new CostoExtra();
			costoExtra.setIdCostoExtra(idCostoExtra);
		costoExtraDetalle.setCostoExtra(costoExtra);
		costoExtraDetalle.setCantidad(cantidad);
		costoExtraDetalle.setEspecificacion(especificacion);
		costoExtraDetalle.setActivo(true);
		
		int resultado = costoExtraDetalleService.creaCostoExtraDetalle(costoExtraDetalle);
		
		tipoTrabajoDetalle 	= null;
		responsableInsumo	= null;
		costoExtra			= null;
		costoExtraDetalle 	= null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(resultado);
		if( resultado > 0 ) {
			// obtiene actualizacion de la tabla
			jsonResponse.setTextoHTML( costoExtraDetalleService.listaHTMLModificacion(idTipoTrabajoDetalle) );
			// actualiza el precio
			calificacionService.actualizaProcesosPartida(idOrdenProduccion);
			CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
			jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
			calificacionOrdenProduccion = null;
		}
		
		return jsonResponse;
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/actualiza_en_op", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaCostoExtraDetalle(
			@RequestParam(value = "id_orden_produccion", 		required = false) Integer idOrdenProduccion,
			@RequestParam(value = "id_costo_extra_detalle", 	required = false) Integer idCostoExtraDetalle,
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "cantidad", 					required = false) Integer cantidad,
			@RequestParam(value = "especificacion", 			required = false) String especificacion
		) throws IOException {
		log.info("/actualiza_costo_extra_detalle");
		
		CostoExtraDetalle costoExtraDetalle = costoExtraDetalleService.buscaCostoExtraDetalle(idCostoExtraDetalle);
		costoExtraDetalle.setCantidad(cantidad);
		costoExtraDetalle.setEspecificacion(especificacion);
		costoExtraDetalleService.modificaCostoExtraDetalle(costoExtraDetalle);
		costoExtraDetalle = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML( costoExtraDetalleService.listaHTMLModificacion(idTipoTrabajoDetalle) );
		// actualiza el precio
		calificacionService.actualizaProcesosPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/elimina_en_op", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse eliminaCostoExtraDetalle(
			@RequestParam(value = "id_orden_produccion", 		required = false) Integer idOrdenProduccion,
			@RequestParam(value = "id_costo_extra_detalle", 	required = false) Integer idCostoExtraDetalle,
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle
		) {
		log.info("/elimina_costo_extra_detalle");
		
		CostoExtraDetalle costoExtraDetalle = costoExtraDetalleService.buscaCostoExtraDetalle(idCostoExtraDetalle);
		costoExtraDetalle.setActivo(false);
		costoExtraDetalleService.modificaCostoExtraDetalle(costoExtraDetalle);
		costoExtraDetalle = null;
		
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		// obtiene actualizacion de la tabla
		jsonResponse.setTextoHTML( costoExtraDetalleService.listaHTMLModificacion(idTipoTrabajoDetalle) );
		// actualiza el precio
		calificacionService.actualizaProcesosPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( calificacionOrdenProduccion.getPrecioNeto() );
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	}
	
	//***********
	// Metodos para utilizar en CostoExtra al finalizar la orden de produccion
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String costoExtraDetalle(
			@RequestParam(value = "nut", required = false) String nut,
			Model model
		) throws IOException {
		log.info("/costo_extra_detalle");

		// nut
		model.addAttribute("nut",nut);
		
		// lista responsable insumo
		List<ComboSelect> listaResponsableInsumo = responsableInsumoService.listaComboSelect();
		model.addAttribute("listaResponsableInsumo",listaResponsableInsumo);
		listaResponsableInsumo = null;
		
		// lista costo extra
		List<ComboSelect> listaCostoExtra = costoExtraService.listaComboSelect();
		model.addAttribute("listaCostoExtra",listaCostoExtra);
		if( listaCostoExtra.size() > 0 ) {
			ComboSelect cs = listaCostoExtra.get(0);
			CostoExtra costoExtra = costoExtraService.buscaCostoExtra(cs.getValue());
			model.addAttribute("nombre_unidad_medida",costoExtra.getTipoPrecio().getNombre());
			costoExtra 	= null;
			cs 			= null;
		}
		listaCostoExtra = null;
		
		// lista de costo extra detalle
		List<CostoExtraDetalle> listaCostoExtraDetalle = costoExtraDetalleService.listaCostoExtraDetallePorNut(nut);
		model.addAttribute("listaCostoExtraDetalle",listaCostoExtraDetalle);
		listaCostoExtraDetalle = null;
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		String jsonArbol = ordenProduccionService.generaJsonArbolOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		model.addAttribute("jsonArbol", jsonArbol);
		jsonArbol 		= null;
		ordenProduccion = null;
		
		return "visualizador/costo_extra_detalle";
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega", method = RequestMethod.POST)
	public String agregaCostoExtraDetalle(
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "id_responsable_insumo", 		required = false) Integer idResponsableInsumo,
			@RequestParam(value = "id_costo_extra", 			required = false) Integer idCostoExtra,
			@RequestParam(value = "cantidad", 					required = false) Integer cantidad,
			@RequestParam(value = "especificacion", 			required = false) String especificacion,
			Model model
		) throws IOException {
		log.info("/agrega_costo_extra_detalle");
		
		CostoExtraDetalle costoExtraDetalle = new CostoExtraDetalle();
			TipoTrabajoDetalle tipoTrabajoDetalle = new TipoTrabajoDetalle();
			tipoTrabajoDetalle.setIdTipoTrabajoDetalle(idTipoTrabajoDetalle);
		costoExtraDetalle.setTipoTrabajoDetalle(tipoTrabajoDetalle);
			ResponsableInsumo responsableInsumo = new ResponsableInsumo();
			responsableInsumo.setIdResponsableInsumo(idResponsableInsumo);
		costoExtraDetalle.setResponsableInsumo(responsableInsumo);
			CostoExtra costoExtra = new CostoExtra();
			costoExtra.setIdCostoExtra(idCostoExtra);
		costoExtraDetalle.setCostoExtra(costoExtra);
		costoExtraDetalle.setCantidad(cantidad);
		costoExtraDetalle.setEspecificacion(especificacion);
		costoExtraDetalle.setActivo(true);
		
		costoExtraDetalleService.creaCostoExtraDetalle(costoExtraDetalle);
		
		responsableInsumo = null;
		tipoTrabajoDetalle = null;
		costoExtraDetalle = null;
		
		// nut
		model.addAttribute("nut",nut);
		
		// lista responsable insumo
		List<ComboSelect> listaResponsableInsumo = responsableInsumoService.listaComboSelect();
		model.addAttribute("listaResponsableInsumo",listaResponsableInsumo);
		listaResponsableInsumo = null;
		
		// lista costo extra
		List<ComboSelect> listaCostoExtra = costoExtraService.listaComboSelect();
		model.addAttribute("listaCostoExtra",listaCostoExtra);
		if( listaCostoExtra.size() > 0 ) {
			ComboSelect cs = listaCostoExtra.get(0);
			CostoExtra ce = costoExtraService.buscaCostoExtra(cs.getValue());
			model.addAttribute("nombre_unidad_medida",ce.getTipoPrecio().getNombre());
			ce 	= null;
			cs 	= null;
		}
		listaCostoExtra = null;
		
		// lista de costo extra detalle
		List<CostoExtraDetalle> listaCostoExtraDetalle = costoExtraDetalleService.listaCostoExtraDetallePorNut(nut);
		model.addAttribute("listaCostoExtraDetalle",listaCostoExtraDetalle);
		listaCostoExtraDetalle = null;
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		String jsonArbol = ordenProduccionService.generaJsonArbolOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		model.addAttribute("jsonArbol", jsonArbol);
		jsonArbol 		= null;
		ordenProduccion = null;
		
		return "visualizador/costo_extra_detalle";
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/modifica", method = RequestMethod.POST)
	public String modificaCostoExtraDetalle(
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_costo_extra_detalle", 	required = false) Integer idCostoExtraDetalle,
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "id_responsable_insumo", 		required = false) Integer idResponsableInsumo,
			@RequestParam(value = "id_costo_extra", 			required = false) Integer idCostoExtra,
			@RequestParam(value = "cantidad", 					required = false) Integer cantidad,
			@RequestParam(value = "especificacion", 			required = false) String especificacion,
			Model model
		) throws IOException {
		log.info("/modifica_costo_extra_detalle");
		
		// MODIFICACION
		CostoExtraDetalle costoExtraDetalle = costoExtraDetalleService.buscaCostoExtraDetalle(idCostoExtraDetalle);
		costoExtraDetalle.getResponsableInsumo().setIdResponsableInsumo(idResponsableInsumo);
		costoExtraDetalle.getCostoExtra().setIdCostoExtra(idCostoExtra);
		costoExtraDetalle.setCantidad(cantidad);
		costoExtraDetalle.setEspecificacion(especificacion);
		costoExtraDetalleService.modificaCostoExtraDetalle(costoExtraDetalle);
		costoExtraDetalle = null;
		
		// ACTUALIZA INFORMACION DE LA PAGINA
		// nut
		model.addAttribute("nut",nut);
		
		// lista responsable insumo
		List<ComboSelect> listaResponsableInsumo = responsableInsumoService.listaComboSelect();
		model.addAttribute("listaResponsableInsumo",listaResponsableInsumo);
		listaResponsableInsumo = null;
		
		// lista costo extras
		List<ComboSelect> listaCostoExtra = costoExtraService.listaComboSelect();
		model.addAttribute("listaCostoExtra",listaCostoExtra);
		if( listaCostoExtra.size() > 0 ) {
			ComboSelect cs = listaCostoExtra.get(0);
			CostoExtra ce = costoExtraService.buscaCostoExtra(cs.getValue());
			model.addAttribute("nombre_unidad_medida",ce.getTipoPrecio().getNombre());
			ce 	= null;
			cs 	= null;
		}
		listaCostoExtra = null;
		
		// lista de costo extra detalle
		List<CostoExtraDetalle> listaCostoExtraDetalle = costoExtraDetalleService.listaCostoExtraDetallePorNut(nut);
		model.addAttribute("listaCostoExtraDetalle",listaCostoExtraDetalle);
		listaCostoExtraDetalle = null;
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		String jsonArbol = ordenProduccionService.generaJsonArbolOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		model.addAttribute("jsonArbol", jsonArbol);
		jsonArbol 		= null;
		ordenProduccion = null;
		
		return "visualizador/costo_extra_detalle";
	}
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/elimina", method = RequestMethod.POST)
	public String eliminaCostoExtraDetalle(
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_costo_extra_detalle", 	required = false) Integer idCostoExtraDetalle,
			Model model
		) throws IOException {
		log.info("/elimina_costo_extra_detalle");
		
		// ELIMINACION
		CostoExtraDetalle costoExtraDetalle = costoExtraDetalleService.buscaCostoExtraDetalle(idCostoExtraDetalle);
		costoExtraDetalle.setActivo(false);
		costoExtraDetalleService.modificaCostoExtraDetalle(costoExtraDetalle);
		costoExtraDetalle = null;
		
		// ACTUALIZA INFORMACION DE LA PAGINA
		// nut
		model.addAttribute("nut",nut);
		
		// lista responsable insumo
		List<ComboSelect> listaResponsableInsumo = responsableInsumoService.listaComboSelect();
		model.addAttribute("listaResponsableInsumo",listaResponsableInsumo);
		listaResponsableInsumo = null;
		
		// lista costo extra
		List<ComboSelect> listaCostoExtra = costoExtraService.listaComboSelect();
		model.addAttribute("listaCostoExtra",listaCostoExtra);
		if( listaCostoExtra.size() > 0 ) {
			ComboSelect cs = listaCostoExtra.get(0);
			CostoExtra ce = costoExtraService.buscaCostoExtra(cs.getValue());
			model.addAttribute("nombre_unidad_medida",ce.getTipoPrecio().getNombre());
			ce 	= null;
			cs 	= null;
		}
		listaCostoExtra = null;
		
		// lista de costo extra detalle
		List<CostoExtraDetalle> listaCostoExtraDetalle = costoExtraDetalleService.listaCostoExtraDetallePorNut(nut);
		model.addAttribute("listaCostoExtraDetalle",listaCostoExtraDetalle);
		listaCostoExtraDetalle = null;
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		String jsonArbol = ordenProduccionService.generaJsonArbolOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		model.addAttribute("jsonArbol", jsonArbol);
		jsonArbol 		= null;
		ordenProduccion = null;
		
		return "visualizador/costo_extra_detalle";
	}
	
}
