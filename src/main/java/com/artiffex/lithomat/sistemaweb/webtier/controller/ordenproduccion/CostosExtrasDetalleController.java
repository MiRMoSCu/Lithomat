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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtras;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtrasDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.ResponsableInsumo;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostosExtrasDetalleService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostosExtrasService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ResponsableInsumoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/costos_extras_detalle")
public class CostosExtrasDetalleController {

	private static final Logger log = Logger.getLogger(CostosExtrasDetalleController.class);
	
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private ResponsableInsumoService responsableInsumoService;
	@Resource
	private CostosExtrasService costosExtrasService;
	@Resource
	private CostosExtrasDetalleService costosExtrasDetalleService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/busca_unidad_medida", method = RequestMethod.POST)
	@ResponseBody
	public String buscaUnidadMedidaCostoExtra(
			@RequestParam(value = "id_costos_extras", required = false) Integer idCostosExtras
		){
		CostosExtras costosExtras = costosExtrasService.buscaCostosExtras(idCostosExtras);
		String unidadMedida = costosExtras.getTipoPrecio().getNombre();
		costosExtras = null;
		return unidadMedida;
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String costosExtrasDetalle(
			@RequestParam(value = "nut", required = false) String nut,
			Model model
		) throws IOException {
		log.info("/costos_extras_detalle");

		// nut
		model.addAttribute("nut",nut);
		
		// lista responsable insumo
		List<ComboSelect> listaResponsableInsumo = responsableInsumoService.listaComboSelect();
		model.addAttribute("listaResponsableInsumo",listaResponsableInsumo);
		listaResponsableInsumo = null;
		
		// lista costos extras
		List<ComboSelect> listaCostosExtras = costosExtrasService.listaComboSelect();
		model.addAttribute("listaCostosExtras",listaCostosExtras);
		if( listaCostosExtras.size() > 0 ) {
			ComboSelect cs = listaCostosExtras.get(0);
			CostosExtras costosExtras = costosExtrasService.buscaCostosExtras(cs.getValue());
			model.addAttribute("nombre_unidad_medida",costosExtras.getTipoPrecio().getNombre());
			costosExtras 	= null;
			cs 				= null;
		}
		listaCostosExtras = null;
		
		// lista de costos extras detalle
		List<CostosExtrasDetalle> listaCostosExtrasDetalle = costosExtrasDetalleService.listaCostosExtrasDetallePorNut(nut);
		model.addAttribute("listaCostosExtrasDetalle",listaCostosExtrasDetalle);
		listaCostosExtrasDetalle = null;
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		String jsonArbol = ordenProduccionService.generaJsonArbolOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		model.addAttribute("jsonArbol", jsonArbol);
		jsonArbol 		= null;
		ordenProduccion = null;
		
		return "visualizador/costos_extras_detalle";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega_costos_extras_detalle", method = RequestMethod.POST)
	public String agregaCostosExtrasDetalle(
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "id_responsable_insumo", 		required = false) Integer idResponsableInsumo,
			@RequestParam(value = "id_costos_extras", 			required = false) Integer idCostosExtras,
			@RequestParam(value = "cantidad", 					required = false) Integer cantidad,
			@RequestParam(value = "especificacion", 			required = false) String especificacion,
			Model model
		) throws IOException {
		log.info("/agrega_costos_extra_detalle");
		
		CostosExtrasDetalle costosExtrasDetalle = new CostosExtrasDetalle();
			TipoTrabajoDetalle tipoTrabajoDetalle = new TipoTrabajoDetalle();
			tipoTrabajoDetalle.setIdTipoTrabajoDetalle(idTipoTrabajoDetalle);
		costosExtrasDetalle.setTipoTrabajoDetalle(tipoTrabajoDetalle);
			ResponsableInsumo responsableInsumo = new ResponsableInsumo();
			responsableInsumo.setIdResponsableInsumo(idResponsableInsumo);
		costosExtrasDetalle.setResponsableInsumo(responsableInsumo);
			CostosExtras costosExtras = new CostosExtras();
			costosExtras.setIdCostosExtras(idCostosExtras);
		costosExtrasDetalle.setCostosExtras(costosExtras);
		costosExtrasDetalle.setCantidad(cantidad);
		costosExtrasDetalle.setEspecificacion(especificacion);
		costosExtrasDetalle.setActivo(true);
		
		costosExtrasDetalleService.creaCostosExtrasDetalle(costosExtrasDetalle);
		
		responsableInsumo = null;
		tipoTrabajoDetalle = null;
		costosExtrasDetalle = null;
		
		// nut
		model.addAttribute("nut",nut);
		
		// lista responsable insumo
		List<ComboSelect> listaResponsableInsumo = responsableInsumoService.listaComboSelect();
		model.addAttribute("listaResponsableInsumo",listaResponsableInsumo);
		listaResponsableInsumo = null;
		
		// lista costos extras
		List<ComboSelect> listaCostosExtras = costosExtrasService.listaComboSelect();
		model.addAttribute("listaCostosExtras",listaCostosExtras);
		if( listaCostosExtras.size() > 0 ) {
			ComboSelect cs = listaCostosExtras.get(0);
			CostosExtras ce = costosExtrasService.buscaCostosExtras(cs.getValue());
			model.addAttribute("nombre_unidad_medida",ce.getTipoPrecio().getNombre());
			ce 	= null;
			cs 	= null;
		}
		listaCostosExtras = null;
		
		// lista de costos extras detalle
		List<CostosExtrasDetalle> listaCostosExtrasDetalle = costosExtrasDetalleService.listaCostosExtrasDetallePorNut(nut);
		model.addAttribute("listaCostosExtrasDetalle",listaCostosExtrasDetalle);
		listaCostosExtrasDetalle = null;
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		String jsonArbol = ordenProduccionService.generaJsonArbolOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		model.addAttribute("jsonArbol", jsonArbol);
		jsonArbol 		= null;
		ordenProduccion = null;
		
		return "visualizador/costos_extras_detalle";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/modifica_costos_extras_detalle", method = RequestMethod.POST)
	public String modificaCostosExtrasDetalle(
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_costos_extras_detalle", 	required = false) Integer idCostosExtrasDetalle,
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "id_responsable_insumo", 		required = false) Integer idResponsableInsumo,
			@RequestParam(value = "id_costos_extras", 			required = false) Integer idCostosExtras,
			@RequestParam(value = "cantidad", 					required = false) Integer cantidad,
			@RequestParam(value = "especificacion", 			required = false) String especificacion,
			Model model
		) throws IOException {
		log.info("/modifica_costos_extra_detalle");
		
		// MODIFICACION
		CostosExtrasDetalle costosExtrasDetalle = costosExtrasDetalleService.buscaCostosExtrasDetalle(idCostosExtrasDetalle);
		costosExtrasDetalle.getResponsableInsumo().setIdResponsableInsumo(idResponsableInsumo);
		costosExtrasDetalle.getCostosExtras().setIdCostosExtras(idCostosExtras);
		costosExtrasDetalle.setCantidad(cantidad);
		costosExtrasDetalle.setEspecificacion(especificacion);
		costosExtrasDetalleService.modificaCostosExtrasDetalle(costosExtrasDetalle);
		costosExtrasDetalle = null;
		
		// ACTUALIZA INFORMACION DE LA PAGINA
		// nut
		model.addAttribute("nut",nut);
		
		// lista responsable insumo
		List<ComboSelect> listaResponsableInsumo = responsableInsumoService.listaComboSelect();
		model.addAttribute("listaResponsableInsumo",listaResponsableInsumo);
		listaResponsableInsumo = null;
		
		// lista costos extras
		List<ComboSelect> listaCostosExtras = costosExtrasService.listaComboSelect();
		model.addAttribute("listaCostosExtras",listaCostosExtras);
		if( listaCostosExtras.size() > 0 ) {
			ComboSelect cs = listaCostosExtras.get(0);
			CostosExtras ce = costosExtrasService.buscaCostosExtras(cs.getValue());
			model.addAttribute("nombre_unidad_medida",ce.getTipoPrecio().getNombre());
			ce 	= null;
			cs 	= null;
		}
		listaCostosExtras = null;
		
		// lista de costos extras detalle
		List<CostosExtrasDetalle> listaCostosExtrasDetalle = costosExtrasDetalleService.listaCostosExtrasDetallePorNut(nut);
		model.addAttribute("listaCostosExtrasDetalle",listaCostosExtrasDetalle);
		listaCostosExtrasDetalle = null;
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		String jsonArbol = ordenProduccionService.generaJsonArbolOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		model.addAttribute("jsonArbol", jsonArbol);
		jsonArbol 		= null;
		ordenProduccion = null;
		
		return "visualizador/costos_extras_detalle";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/elimina_costos_extras_detalle", method = RequestMethod.POST)
	public String eliminaCostosExtrasDetalle(
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "id_costos_extras_detalle", 	required = false) Integer idCostosExtrasDetalle,
			Model model
		) throws IOException {
		log.info("/elimina_costos_extra_detalle");
		
		// ELIMINACION
		CostosExtrasDetalle costosExtrasDetalle = costosExtrasDetalleService.buscaCostosExtrasDetalle(idCostosExtrasDetalle);
		costosExtrasDetalle.setActivo(false);
		costosExtrasDetalleService.modificaCostosExtrasDetalle(costosExtrasDetalle);
		costosExtrasDetalle = null;
		
		// ACTUALIZA INFORMACION DE LA PAGINA
		// nut
		model.addAttribute("nut",nut);
		
		// lista responsable insumo
		List<ComboSelect> listaResponsableInsumo = responsableInsumoService.listaComboSelect();
		model.addAttribute("listaResponsableInsumo",listaResponsableInsumo);
		listaResponsableInsumo = null;
		
		// lista costos extras
		List<ComboSelect> listaCostosExtras = costosExtrasService.listaComboSelect();
		model.addAttribute("listaCostosExtras",listaCostosExtras);
		if( listaCostosExtras.size() > 0 ) {
			ComboSelect cs = listaCostosExtras.get(0);
			CostosExtras ce = costosExtrasService.buscaCostosExtras(cs.getValue());
			model.addAttribute("nombre_unidad_medida",ce.getTipoPrecio().getNombre());
			ce 	= null;
			cs 	= null;
		}
		listaCostosExtras = null;
		
		// lista de costos extras detalle
		List<CostosExtrasDetalle> listaCostosExtrasDetalle = costosExtrasDetalleService.listaCostosExtrasDetallePorNut(nut);
		model.addAttribute("listaCostosExtrasDetalle",listaCostosExtrasDetalle);
		listaCostosExtrasDetalle = null;
		
		OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		String jsonArbol = ordenProduccionService.generaJsonArbolOrdenProduccion(ordenProduccion.getIdOrdenProduccion());
		model.addAttribute("jsonArbol", jsonArbol);
		jsonArbol 		= null;
		ordenProduccion = null;
		
		return "visualizador/costos_extras_detalle";
	}
	
}
