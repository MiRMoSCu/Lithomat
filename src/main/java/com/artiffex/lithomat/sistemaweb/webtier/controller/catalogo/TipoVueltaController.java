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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoVuelta;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoVueltaService;

@Controller
@RequestMapping("/tipo_vuelta")
public class TipoVueltaController {
	
	private static final Logger log = Logger.getLogger(TipoVueltaController.class);
	
	@Resource
	private TipoVueltaService tipoVueltaService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoVuelta( Locale locale, Model model ) throws IOException {
		log.info("/lista_tipo_vuelta");

		List<TipoVuelta> listaTipoVuelta = tipoVueltaService.listaTipoVuelta();
		model.addAttribute("listaTipoVuelta", listaTipoVuelta);

		listaTipoVuelta = null;
		
		return "catalogo/tipo_vuelta";
	}// lista_tipo_vuelta

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTipoVuelta(
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/lista_tipo_vuelta");

		TipoVuelta tipoVuelta = new TipoVuelta();
		tipoVuelta.setNombre(nombre);
		tipoVuelta.setDescripcion(descripcion);
		tipoVuelta.setActivo(true);

		tipoVueltaService.creaTipoVuelta(tipoVuelta);

		List<TipoVuelta> listaTipoVuelta = tipoVueltaService.listaTipoVuelta();
		model.addAttribute("listaTipoVuelta", listaTipoVuelta);

		tipoVuelta = null;
		listaTipoVuelta = null;
		
		return "catalogo/tipo_vuelta";
	}// alta_tipo_vuelta

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoVuelta(
			@RequestParam(value = "id_tipo_vuelta", required = false) Integer idTipoVuelta,
			@RequestParam(value = "nombre",			required = false) String nombre,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/lista_tipo_vuelta");

		TipoVuelta tipoVuelta = tipoVueltaService.buscaTipoVuelta(idTipoVuelta);
		tipoVuelta.setNombre(nombre);
		tipoVuelta.setDescripcion(descripcion);

		tipoVueltaService.modificaTipoVuelta(tipoVuelta);

		List<TipoVuelta> listaTipoVuelta = tipoVueltaService.listaTipoVuelta();
		model.addAttribute("listaTipoVuelta", listaTipoVuelta);

		tipoVuelta = null;
		listaTipoVuelta = null;
		
		return "catalogo/tipo_vuelta";
	}// modifica_tipo_vuelta

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoVuelta(
			@RequestParam(value = "id_tipo_vuelta", required = false) Integer idTipoVuelta,
			Model model
		) throws IOException {
		log.info("/lista_tipo_vuelta");
		
		TipoVuelta tipoVuelta = tipoVueltaService.buscaTipoVuelta(idTipoVuelta);
		tipoVuelta.setActivo(false);

		tipoVueltaService.modificaTipoVuelta(tipoVuelta);

		List<TipoVuelta> listaTipoVuelta = tipoVueltaService.listaTipoVuelta();
		model.addAttribute("listaTipoVuelta", listaTipoVuelta);

		tipoVuelta= null;
		listaTipoVuelta = null;
		
		return "catalogo/tipo_vuelta";
	}// elimina_tipo_vuelta
	
}
