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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComplejidad;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoComplejidadService;

@Controller
@RequestMapping("/tipo_complejidad")
public class TipoComplejidadController {
	
	private static final Logger log = Logger.getLogger(TipoComplejidadController.class);
	
	@Resource
	private TipoComplejidadService tipoComplejidadService;
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoComlejidad( Locale locale, Model model ) throws IOException {
		log.info("/lista_tipo_complejidad");
		
		List<TipoComplejidad> listaTipoComplejidad = tipoComplejidadService.listaTipoComplejidad();
		model.addAttribute("listaTipoComplejidad", listaTipoComplejidad);
		listaTipoComplejidad = null;
		
		return "catalogo/tipo_complejidad";
	}
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTipoComlejidad(
			@RequestParam(value = "nombre",  required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			Model model
		) throws IOException {
		log.info("/alta_tipo_complejidad");
		
		TipoComplejidad tipoComplejidad = new TipoComplejidad();
		tipoComplejidad.setNombre(nombre);
		tipoComplejidad.setDescripcion(descripcion);
		tipoComplejidad.setActivo(true);
		
		tipoComplejidadService.creaTipoComplejidad(tipoComplejidad);
		
		List<TipoComplejidad> listaTipoComplejidad = tipoComplejidadService.listaTipoComplejidad();
		model.addAttribute("listaTipoComplejidad", listaTipoComplejidad);
		
		tipoComplejidad 		= null;
		listaTipoComplejidad 	= null;
		
		return "catalogo/tipo_complejidad";
	}
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoComlejidad(
			@RequestParam(value = "id_tipo_complejidad",  required = true) Integer idTipoComplejidad,
			@RequestParam(value = "nombre",  required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			Model model
		) throws IOException {
		log.info("/modifica_tipo_complejidad");
		
		TipoComplejidad tipoComplejidad = tipoComplejidadService.buscaTipoComplejidad(idTipoComplejidad);
		tipoComplejidad.setNombre(nombre);
		tipoComplejidad.setDescripcion(descripcion);
		
		tipoComplejidadService.modificaTipoComplejidad(tipoComplejidad);
		
		List<TipoComplejidad> listaTipoComplejidad = tipoComplejidadService.listaTipoComplejidad();
		model.addAttribute("listaTipoComplejidad", listaTipoComplejidad);
		
		tipoComplejidad = null;
		listaTipoComplejidad = null;
		
		return "catalogo/tipo_complejidad";
	}
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoComlejidad(
			@RequestParam(value = "id_tipo_complejidad",  required = true) Integer idTipoComplejidad,
			Model model
		) throws IOException {
		log.info("/elimina_tipo_complejidad");
		
		TipoComplejidad tipoComplejidad = tipoComplejidadService.buscaTipoComplejidad(idTipoComplejidad);
		tipoComplejidad.setActivo(false);
		
		tipoComplejidadService.modificaTipoComplejidad(tipoComplejidad);
		
		List<TipoComplejidad> listaTipoComplejidad = tipoComplejidadService.listaTipoComplejidad();
		model.addAttribute("listaTipoComplejidad", listaTipoComplejidad);
		
		tipoComplejidad = null;
		listaTipoComplejidad = null;
		
		return "catalogo/tipo_complejidad";
	}

}
