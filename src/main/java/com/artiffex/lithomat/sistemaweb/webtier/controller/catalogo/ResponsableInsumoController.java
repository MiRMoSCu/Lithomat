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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ResponsableInsumo;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ResponsableInsumoService;

@Controller
@RequestMapping("/responsable_insumo")
public class ResponsableInsumoController {
	
	private static final Logger log = Logger.getLogger(ResponsableInsumoController.class);
	
	@Resource
	private ResponsableInsumoService responsableInsumoService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaResponsableInsumo( Locale locale, Model model ) throws IOException {
		log.info("/lista_responsable_insumo");

		List<ResponsableInsumo> listaResponsableInsumo = responsableInsumoService.listaResponsableInsumo();
		model.addAttribute("listaResponsableInsumo", listaResponsableInsumo);

		listaResponsableInsumo = null;
		
		return "catalogo/responsable_insumo";
	}// lista_reponsable_insumo

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaResponsableInsumo(
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/alta_responsable_insumo");

		ResponsableInsumo responsableInsumo = new ResponsableInsumo();
		responsableInsumo.setNombre(nombre);
		responsableInsumo.setDescripcion(descripcion);
		responsableInsumo.setActivo(true);

		responsableInsumoService.creaResponsableInsumo(responsableInsumo);

		List<ResponsableInsumo> listaResponsableInsumo = responsableInsumoService.listaResponsableInsumo();
		model.addAttribute("listaResponsableInsumo", listaResponsableInsumo);

		responsableInsumo = null;
		listaResponsableInsumo = null;
		
		return "catalogo/responsable_insumo";
	}// alta_reponsable_insumo

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaResponsableInsumo(
			@RequestParam(value = "id_responsable_insumo", 	required = false) Integer idResponsableInsumo,
			@RequestParam(value = "nombre", 				required = false) String nombre,
			@RequestParam(value = "descripcion", 			required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/modifica_responsable_insumo");

		ResponsableInsumo responsableInsumo = responsableInsumoService.buscaResponsableInsumo(idResponsableInsumo);
		responsableInsumo.setNombre(nombre);
		responsableInsumo.setDescripcion(descripcion);

		responsableInsumoService.modificaResponsableInsumo(responsableInsumo);

		List<ResponsableInsumo> listaResponsableInsumo = responsableInsumoService.listaResponsableInsumo();
		model.addAttribute("listaResponsableInsumo", listaResponsableInsumo);

		responsableInsumo = null;
		listaResponsableInsumo = null;
		
		return "catalogo/responsable_insumo";
	}// modifica

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaResponsableInsumo(
			@RequestParam(value = "id_responsable_insumo", required = false) Integer idResponsableInsumo,
			Model model
		) throws IOException {
		log.info("/elimina_responsable_insumo");
		
		ResponsableInsumo responsableInsumo = responsableInsumoService.buscaResponsableInsumo(idResponsableInsumo);
		responsableInsumo.setActivo(false);

		responsableInsumoService.modificaResponsableInsumo(responsableInsumo);

		List<ResponsableInsumo> listaResponsableInsumo = responsableInsumoService.listaResponsableInsumo();
		model.addAttribute("listaResponsableInsumo", listaResponsableInsumo);

		responsableInsumo = null;
		listaResponsableInsumo = null;
		
		return "catalogo/responsable_insumo";
	}// elimina_reponsable_insumo

}
