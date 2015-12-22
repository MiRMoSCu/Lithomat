package com.artiffex.lithomat.sistemaweb.webtier.controller.seguridad;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistorialEstatus;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.EstatusOrdenService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.HistorialEstatusService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/seguridad")
public class SeguridadController {
	
	private static final Logger log = Logger.getLogger(SeguridadController.class);
	
	@Resource
	private EstatusOrdenService estatusOrdenService;
	@Resource
	private OrdenProduccionService ordenProduccionService;
	@Resource
	private HistorialEstatusService historialEstatusService;
	
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/cambio_estatus", method = RequestMethod.POST)
	@ResponseBody
	public boolean cambioEstatus( 
			@RequestParam(value = "nut", 				required = false) String nut,
			@RequestParam(value = "id_estatus_orden",	required = false) Integer idEstatusOrden
		) throws IOException {
		log.info("/seguridad/cambio_estatus");
		
		Timestamp fechaGeneracion = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		HistorialEstatus historialEstatus = new HistorialEstatus();
			OrdenProduccion ordenProduccion = ordenProduccionService.buscaOrdenProduccionPorNut(nut);
		historialEstatus.setOrdenProduccion(ordenProduccion);
			EstatusOrden estatusOrden = new EstatusOrden();
			estatusOrden.setIdEstatusOrden(idEstatusOrden);
		historialEstatus.setEstatusOrden(estatusOrden);
		historialEstatus.setFecha(fechaGeneracion);
		historialEstatus.setActivo(true);
		
		historialEstatusService.creaHistorialEstatus(historialEstatus);
		
		estatusOrden		= null;
		ordenProduccion 	= null;
		historialEstatus 	= null;
		fechaGeneracion		= null;

		return true;
	}
	
	
	// URL de ventanas
	//******************************************************************************************
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/ventana_cambio_estatus", method = RequestMethod.GET)
	public String ventanaCambioEstatus( Model model ) throws IOException {
		log.info("/seguridad/ventana_cambio_estatus");
		
		List<ComboSelect> listaEstatusOrden = estatusOrdenService.listaComboSelect();
		model.addAttribute("listaEstatusOrden", listaEstatusOrden);
		listaEstatusOrden = null;
		
		return "seguridad/ventana_cambio_estatus";
	}

}
