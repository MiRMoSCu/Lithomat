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
import com.artiffex.lithomat.sistemaweb.businesstier.entity.DescuentoTabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.JsonResponse;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DescuentoTabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoDetalleService;

@Controller
@RequestMapping("/descuento_por_tabulador")
public class DescuentoPorTabuladorController {
	
	private static final Logger log = Logger.getLogger(DescuentoPorTabuladorController.class);
	
	@Resource
	private DescuentoTabuladorPreciosService descuentoTabuladorPreciosService;
	@Resource
	private TipoTrabajoDetalleService tipoTrabajoDetalleService;
	@Resource
	private CalificacionService calificacionService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/agrega", method = RequestMethod.POST)
	@ResponseBody
	public int agregaDescuento(
			@RequestParam(value = "id_tipo_trabajo_detalle", 	required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "aplica_descuento", 			required = false) boolean aplicaDescuento,
			@RequestParam(value = "precio_tabulador", 			required = false) Float precioTabulador,
			@RequestParam(value = "id_tipo_precio", 			required = false) Integer idTipoPrecio
		) {
		log.info("/agrega_descuento");
		
		DescuentoTabuladorPrecios descuentoTabuladorPrecios = new DescuentoTabuladorPrecios();
			TipoTrabajoDetalle tipoTrabajoDetalle = new TipoTrabajoDetalle();
			tipoTrabajoDetalle.setIdTipoTrabajoDetalle(idTipoTrabajoDetalle);
		descuentoTabuladorPrecios.setTipoTrabajoDetalle(tipoTrabajoDetalle);
		descuentoTabuladorPrecios.setPrecioTabulador(precioTabulador);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		descuentoTabuladorPrecios.setTipoPrecio(tipoPrecio);
		descuentoTabuladorPrecios.setActivo(true);
		descuentoTabuladorPreciosService.crea(descuentoTabuladorPrecios);
		
		tipoTrabajoDetalle = tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(idTipoTrabajoDetalle);
		tipoTrabajoDetalle.setAplicaDescuento(true);
		tipoTrabajoDetalleService.modificaTipoTrabajoDetalle(tipoTrabajoDetalle);
		
		tipoPrecio 					= null;
		tipoTrabajoDetalle 			= null;
		descuentoTabuladorPrecios 	= null;
		
		return 1;
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/actualiza", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse actualizaDescuento(
			@RequestParam(value = "id_orden_produccion",			required = false) Integer idOrdenProduccion,
			@RequestParam(value = "id_tipo_trabajo_detalle", 		required = false) Integer idTipoTrabajoDetalle,
			@RequestParam(value = "aplica_descuento", 				required = false) boolean aplicaDescuento,
			@RequestParam(value = "precio_tabulador", 				required = false) Float precioTabulador,
			@RequestParam(value = "id_tipo_precio", 				required = false) Integer idTipoPrecio
		) {
		log.info("/actualiza_descuento");
		
		System.out.println("idTipoTrabajoDetalle: " + idTipoTrabajoDetalle);
		System.out.println("aplicaDescuento:" + aplicaDescuento);
		System.out.println("precioTabulador: " + precioTabulador);
		System.out.println("idTipoPrecio: " + idTipoPrecio);
		
		TipoTrabajoDetalle tipoTrabajoDetalle 				= tipoTrabajoDetalleService.buscaTipoTrabajoDetalle(idTipoTrabajoDetalle);
		DescuentoTabuladorPrecios descuentoTabuladorPrecios = descuentoTabuladorPreciosService.buscaPorTipoTrabajoDetalle(idTipoTrabajoDetalle);
		
		if ( aplicaDescuento ) {
			if ( !tipoTrabajoDetalle.isAplicaDescuento() ) {
				tipoTrabajoDetalle.setAplicaDescuento(true);
				tipoTrabajoDetalleService.modificaTipoTrabajoDetalle(tipoTrabajoDetalle);
			}
			if ( descuentoTabuladorPrecios == null ) {
				descuentoTabuladorPrecios = new DescuentoTabuladorPrecios();
				descuentoTabuladorPrecios.setTipoTrabajoDetalle(tipoTrabajoDetalle);
				descuentoTabuladorPrecios.setPrecioTabulador(precioTabulador);
					TipoPrecio tipoPrecio = new TipoPrecio();
					tipoPrecio.setIdTipoPrecio(idTipoPrecio);
				descuentoTabuladorPrecios.setTipoPrecio(tipoPrecio);
					tipoPrecio = null;
				descuentoTabuladorPrecios.setActivo(true);
				descuentoTabuladorPreciosService.crea(descuentoTabuladorPrecios);
			} else {
				descuentoTabuladorPrecios.setPrecioTabulador(precioTabulador);
				descuentoTabuladorPrecios.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);
				descuentoTabuladorPrecios.setActivo(true);
				descuentoTabuladorPreciosService.modifica(descuentoTabuladorPrecios);
			}
		} else {
			if ( tipoTrabajoDetalle.isAplicaDescuento() ) {
				tipoTrabajoDetalle.setAplicaDescuento(false);
				tipoTrabajoDetalleService.modificaTipoTrabajoDetalle(tipoTrabajoDetalle);
			}
			if ( descuentoTabuladorPrecios != null ) {
				descuentoTabuladorPrecios.setActivo(false);
				descuentoTabuladorPreciosService.modifica(descuentoTabuladorPrecios);
			}
		}
		
		descuentoTabuladorPrecios = null;
		tipoTrabajoDetalle = null;
		
		// actualiza precio
		JsonResponse jsonResponse = new JsonResponse();
		jsonResponse.setEstatusOperacion(1);
		
		calificacionService.actualizaPartida(idOrdenProduccion);
		CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(idOrdenProduccion);
		jsonResponse.setPrecioNeto( (float)calificacionOrdenProduccion.getPrecioNeto() );
		
		calificacionOrdenProduccion = null;
		
		return jsonResponse;
	}

}
