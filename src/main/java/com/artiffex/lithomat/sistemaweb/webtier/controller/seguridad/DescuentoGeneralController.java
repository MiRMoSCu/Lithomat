package com.artiffex.lithomat.sistemaweb.webtier.controller.seguridad;

import java.io.IOException;
import java.util.HashMap;

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
import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistorialEstatus;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalificacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.HistorialEstatusService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/descuento_general")
public class DescuentoGeneralController {
	
	private static final Logger log = Logger.getLogger(DescuentoGeneralController.class);
	
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private HistorialEstatusService historialEstatusService;
	@Resource
	private CalificacionService calificacionService;
	
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/ventana", method = RequestMethod.GET)
	public String ventanaDescuento( Model model ) throws IOException {
		log.info("/ventana_descuento");
		return "seguridad/ventana_seguridad_descuento";
	}
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/busca", method = RequestMethod.POST)
	@ResponseBody
	public String buscaPrecios( 
			@RequestParam(value = "nut", required = false) String nut
		) throws IOException {
		log.info("/busca_informacion_descuento");
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
			OrdenProduccion op = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		hashMap.put("nombre_moral", op.getCliente().getNombreMoral());
		hashMap.put("tipo_cliente", op.getCliente().getTipoCliente().getClave());
			HistorialEstatus historialEstatus = historialEstatusService.buscaUltimoHistorialEstatus(op.getIdOrdenProduccion());
		hashMap.put("estatus", historialEstatus.getEstatusOrden().getNombre());	
			historialEstatus	= null;
			CalificacionOrdenProduccion calificacionOrdenProduccion = calificacionService.buscaCalificacionOrdenProduccion(op.getIdOrdenProduccion());
		hashMap.put("precio_bruto", calificacionOrdenProduccion.getPrecioBruto());
		hashMap.put("precio_cliente", calificacionOrdenProduccion.getPrecioCliente());
		hashMap.put("porcentaje_descuento", calificacionOrdenProduccion.getPorcentajeDescuento());
		hashMap.put("precio_cliente_con_descuento", calificacionOrdenProduccion.getPrecioClienteConDescuento());
		hashMap.put("tipo_comprobante", op.getTipoComprobanteFiscal().getNombre());
		hashMap.put("precio_tipo_comprobante_fiscal", op.getTipoComprobanteFiscal().getPrecio());
		hashMap.put("precio_neto", calificacionOrdenProduccion.getPrecioNeto());
			calificacionOrdenProduccion = null;
			op 							= null;
			
		Gson gson = new Gson();
		String json = gson.toJson(hashMap);
		gson 	= null;
		hashMap = null;
		
		return json;
	}
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/acepta", method = RequestMethod.POST)
	@ResponseBody
	public boolean generaDescuento(
			@RequestParam(value = "nut", required = false) String nut,
			@RequestParam(value = "porcentaje_descuento", required = false) Integer porcentajeDescuento
		){
		log.info("/agrega_descuento");
		calificacionService.actualizaDescuento(nut, porcentajeDescuento);
		return true;
	}

}
