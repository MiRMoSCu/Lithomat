package com.artiffex.lithomat.sistemaweb.webtier.controller.catalogo;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoService;

@Controller
@RequestMapping("/tipo_trabajo")
public class TipoTrabajoController {
	
	private static final Logger log = Logger.getLogger(TipoTrabajoController.class);
	
	@Resource
	private TipoTrabajoService tipoTrabajoService;

	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoTrabajo( Locale locale, Model model ) throws IOException {
		log.info("/lista_tipo_trabajo");

		List<TipoTrabajo> listaTipoTrabajo = tipoTrabajoService.listaTipoTrabajo();
		model.addAttribute("listaTipoTrabajo", listaTipoTrabajo);

		listaTipoTrabajo = null;
		
		return "catalogo/tipo_trabajo";
	}// lista_tipo_trabajo

	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTipoTrabajo(
			@RequestParam(value = "nombre", required = false) String nombre,
			Model model
		) throws IOException {
		log.info("/alta_tipo_trabajo");

		TipoTrabajo tipoTrabajo = new TipoTrabajo();
		tipoTrabajo.setNombre(nombre);
		tipoTrabajo.setActivo(true);

		tipoTrabajoService.creaTipoTrabajo(tipoTrabajo);

		List<TipoTrabajo> listaTipoTrabajo = tipoTrabajoService.listaTipoTrabajo();
		model.addAttribute("listaTipoTrabajo", listaTipoTrabajo);

		tipoTrabajo = null;
		listaTipoTrabajo = null;
		
		return "catalogo/tipo_trabajo";
	}// alta_tipo_trabajo

	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoTrabajo(
			@RequestParam(value = "id_tipo_trabajo", 	required = false) Integer idTipoTrabajo,
			@RequestParam(value = "nombre", 			required = false) String nombre,
			Model model
		) throws IOException {
		log.info("/modifica_tipo_trabajo");

		TipoTrabajo tipoTrabajo = tipoTrabajoService.buscaTipoTrabajo(idTipoTrabajo);
		tipoTrabajo.setNombre(nombre);

		tipoTrabajoService.modificaTipoTrabajo(tipoTrabajo);

		List<TipoTrabajo> listaTipoTrabajo = tipoTrabajoService.listaTipoTrabajo();
		model.addAttribute("listaTipoTrabajo", listaTipoTrabajo);

		tipoTrabajo = null;
		listaTipoTrabajo = null;
		
		return "catalogo/tipo_trabajo";
	}// modifica_tipo_trabajo

	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoTrabajo(
			@RequestParam(value = "id_tipo_trabajo", required = false) Integer idTipoTrabajo,
			Model model
		) throws IOException {
		log.info("/elimina_tipo_trabajo");
		
		TipoTrabajo tipoTrabajo = tipoTrabajoService.buscaTipoTrabajo(idTipoTrabajo);
		tipoTrabajo.setActivo(false);

		tipoTrabajoService.modificaTipoTrabajo(tipoTrabajo);

		List<TipoTrabajo> listaTipoTrabajo = tipoTrabajoService.listaTipoTrabajo();
		model.addAttribute("listaTipoTrabajo", listaTipoTrabajo);

		listaTipoTrabajo = null;
		
		return "catalogo/tipo_trabajo";
	}// elimina_tipo_trabajo
	
}
