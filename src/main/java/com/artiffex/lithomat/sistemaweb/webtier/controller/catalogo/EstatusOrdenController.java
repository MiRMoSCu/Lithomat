package com.artiffex.lithomat.sistemaweb.webtier.controller.catalogo;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.EstatusOrdenService;

@Controller
@RequestMapping("/estatus_orden")
public class EstatusOrdenController {
	
	private static final Logger log = Logger.getLogger(EstatusOrdenController.class);
	
	@Resource
	private EstatusOrdenService estatusOrdenService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaEstatusOrden( Locale locale, Model model ) throws IOException {
		log.info("/lista_estatus_orden");

		List<EstatusOrden> listaEstatusOrden = estatusOrdenService.listaEstatusOrden();
		model.addAttribute("listaEstatusOrden", listaEstatusOrden);
		listaEstatusOrden = null;
		
		return "catalogo/estatus_orden";
	}// lista_estatus_orden

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaEstatusOrden(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/alta_estatus_orden");

		EstatusOrden estatusOrden = new EstatusOrden();
		estatusOrden.setNombre(nombre);
		estatusOrden.setDescripcion(descripcion);
		estatusOrden.setActivo(true);

		estatusOrdenService.creaEstatusOrden(estatusOrden);

		List<EstatusOrden> listaEstatusOrden = estatusOrdenService.listaEstatusOrden();
		model.addAttribute("listaEstatusOrden", listaEstatusOrden);

		estatusOrden = null;
		listaEstatusOrden = null;
		
		return "catalogo/estatus_orden";
	}// alta_estatus_orden

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaEstatusOrden(
			@RequestParam(value = "id_estatus_orden", 	required = false) Integer idEstatusOrden,
			@RequestParam(value = "nombre", 			required = false) String nombre,
			@RequestParam(value = "descripcion", 		required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/modifica_estatus_orden");

		EstatusOrden estatusOrden = estatusOrdenService.buscaEstatusOrden(idEstatusOrden);
		estatusOrden.setNombre(nombre);
		estatusOrden.setDescripcion(descripcion);

		estatusOrdenService.modificaEstatusOrden(estatusOrden);

		List<EstatusOrden> listaEstatusOrden = estatusOrdenService.listaEstatusOrden();
		model.addAttribute("listaEstatusOrden", listaEstatusOrden);

		estatusOrden = null;
		listaEstatusOrden = null;
		
		return "catalogo/estatus_orden";
	}// modifica_estatus_orden

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaEstatusOren(
			@RequestParam(value = "id_estatus_orden", required = false) Integer idEstatusOrden,
			Model model
		) throws IOException {
		log.info("/elimina_estatus_orden");
		
		EstatusOrden estatusOrden = estatusOrdenService.buscaEstatusOrden(idEstatusOrden);
		estatusOrden.setActivo(false);
		
		estatusOrdenService.modificaEstatusOrden(estatusOrden);

		List<EstatusOrden> listaEstatusOrden = estatusOrdenService.listaEstatusOrden();
		model.addAttribute("listaEstatusOrden", listaEstatusOrden);

		estatusOrden = null;
		listaEstatusOrden = null;
		
		return "catalogo/estatus_orden";
	}// elimina_estatus_orden
	
}
