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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyuda;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaterialAyudaService;

@Controller
@RequestMapping("/material_ayuda")
public class MaterialAyudaController {
	
	private static final Logger log = Logger.getLogger(MaterialAyudaController.class);
	
	@Resource
	private MaterialAyudaService materialAyudaService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaMaterialAyuda( Locale locale, Model model ) throws IOException {
		log.info("/lista_material_ayuda");

		List<MaterialAyuda> listaMaterialAyuda = materialAyudaService.listaMaterialAyuda();
		model.addAttribute("listaMaterialAyuda", listaMaterialAyuda);

		listaMaterialAyuda = null;
		
		return "catalogo/material_ayuda";
	}// lista_material_ayuda

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaMaterialAyuda(
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/alta_material_ayuda");

		MaterialAyuda materialAyuda = new MaterialAyuda();
		materialAyuda.setNombre(nombre);
		materialAyuda.setDescripcion(descripcion);
		materialAyuda.setActivo(true);

		materialAyudaService.creaMaterialAyuda(materialAyuda);

		List<MaterialAyuda> listaMaterialAyuda = materialAyudaService.listaMaterialAyuda();
		model.addAttribute("listaMaterialAyuda", listaMaterialAyuda);

		materialAyuda = null;
		listaMaterialAyuda = null;
		
		return "catalogo/material_ayuda";
	}// alta_material_ayuda

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaMaterialAyuda(
			@RequestParam(value = "id_material_ayuda", 	required = false) Integer idMaterialAyuda,
			@RequestParam(value = "nombre", 			required = false) String nombre,
			@RequestParam(value = "descripcion", 		required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/modifica_material_ayuda");

		MaterialAyuda materialAyuda = materialAyudaService.buscaMaterialAyuda(idMaterialAyuda);
		materialAyuda.setNombre(nombre);
		materialAyuda.setDescripcion(descripcion);

		materialAyudaService.modificaMaterialAyuda(materialAyuda);

		List<MaterialAyuda> listaMaterialAyuda = materialAyudaService.listaMaterialAyuda();
		model.addAttribute("listaMaterialAyuda", listaMaterialAyuda);

		materialAyuda = null;
		listaMaterialAyuda = null;
		
		return "catalogo/material_ayuda";
	}// modifica_material_ayuda

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaMaterialAyuda(
			@RequestParam(value = "id_material_ayuda", required = false) Integer idMaterialAyuda,
			Model model
		) throws IOException {
		log.info("/elimina_material_ayuda");
		
		MaterialAyuda materialAyuda = materialAyudaService.buscaMaterialAyuda(idMaterialAyuda);
		materialAyuda.setActivo(false);

		materialAyudaService.modificaMaterialAyuda(materialAyuda);

		List<MaterialAyuda> listaMaterialAyuda = materialAyudaService.listaMaterialAyuda();
		model.addAttribute("listaMaterialAyuda", listaMaterialAyuda);
		
		materialAyuda = null;
		listaMaterialAyuda = null;
		
		return "catalogo/material_ayuda";
	}// elimina_material_ayuda
	
}
