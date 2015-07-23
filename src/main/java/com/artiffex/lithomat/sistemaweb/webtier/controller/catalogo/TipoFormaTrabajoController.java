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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoFormaTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoFormaTrabajoService;

@Controller
@RequestMapping("/tipo_forma_trabajo")
public class TipoFormaTrabajoController {
	
	private static final Logger log = Logger.getLogger(TipoFormaTrabajoController.class);
	
	@Resource
	private TipoFormaTrabajoService tipoFormaTrabajoService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoFormaTrabajo( Locale local, Model model ) throws IOException {
		log.info("/lista_tipo_forma_trabajo");

		List<TipoFormaTrabajo> listaTipoFormaTrabajo = tipoFormaTrabajoService.listaTipoFormaTrabajo();
		model.addAttribute("listaTipoFormaTrabajo", listaTipoFormaTrabajo);

		listaTipoFormaTrabajo = null;
		
		return "catalogo/tipo_forma_trabajo";
	} // lista_tipo_forma_trabajo

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTipoFormaTrabajo(
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/alta_tipo_forma_trabajo");

		TipoFormaTrabajo tipoFormaTrabajo = new TipoFormaTrabajo();
		tipoFormaTrabajo.setNombre(nombre);
		tipoFormaTrabajo.setDescripcion(descripcion);
		tipoFormaTrabajo.setActivo(true);

		tipoFormaTrabajoService.creaTipoFormaTrabajo(tipoFormaTrabajo);

		List<TipoFormaTrabajo> listaTipoFormaTrabajo = tipoFormaTrabajoService.listaTipoFormaTrabajo();
		
		model.addAttribute("listaTipoFormaTrabajo", listaTipoFormaTrabajo);

		tipoFormaTrabajo = null;
		listaTipoFormaTrabajo = null;
		
		return "catalogo/tipo_forma_trabajo";
	} // alta_tipo_forma_trabajo

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoFormaTrabajo(
			@RequestParam(value = "id_tipo_forma_trabajo", 	required = false) Integer idTipoFormaTrabajo,
			@RequestParam(value = "nombre", 				required = false) String nombre,
			@RequestParam(value = "descripcion", 			required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/modifica_tipo_forma_trabajo");

		TipoFormaTrabajo tipoFormaTrabajo = tipoFormaTrabajoService.buscaTipoFormaTrabajo(idTipoFormaTrabajo);
		tipoFormaTrabajo.setNombre(nombre);
		tipoFormaTrabajo.setDescripcion(descripcion);

		tipoFormaTrabajoService.modificaTipoFormaTrabajo(tipoFormaTrabajo);

		List<TipoFormaTrabajo> listaTipoFormaTrabajo = tipoFormaTrabajoService.listaTipoFormaTrabajo();
		model.addAttribute("listaTipoFormaTrabajo", listaTipoFormaTrabajo);

		tipoFormaTrabajo = null;
		listaTipoFormaTrabajo = null;
		
		return "catalogo/tipo_forma_trabajo";
	} // modifica_tipo_forma_trabajo

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoFormaTrabajo(
			@RequestParam(value = "id_tipo_forma_trabajo", required = false) Integer idTipoFormaTrabajo,
			Model model
		) throws IOException {
		log.info("/elimina_tipo_forma_trabajo");
		
		TipoFormaTrabajo tipoFormaTrabajo = tipoFormaTrabajoService.buscaTipoFormaTrabajo(idTipoFormaTrabajo);
		tipoFormaTrabajo.setActivo(false);

		tipoFormaTrabajoService.modificaTipoFormaTrabajo(tipoFormaTrabajo);

		List<TipoFormaTrabajo> listaTipoFormaTrabajo = tipoFormaTrabajoService.listaTipoFormaTrabajo();
		model.addAttribute("listaTipoFormaTrabajo", listaTipoFormaTrabajo);

		listaTipoFormaTrabajo = null;
		
		return "catalogo/tipo_forma_trabajo";
	} // elimina_tipo_forma_trabajo
	
}
