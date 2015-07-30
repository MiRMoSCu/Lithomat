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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Prensista;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PrensistaService;

@Controller
@RequestMapping("/prensista")
public class PrensistaController {
	
	private static final Logger log = Logger.getLogger(PrensistaController.class);
	
	@Resource
	private PrensistaService prensistaService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaPrensista( Locale locale, Model model ) throws IOException {
		log.info("/lista_prensista");

		List<Prensista> listaPrensista = prensistaService.listaPrensista();
		model.addAttribute("listaPrensista", listaPrensista);

		listaPrensista = null;
		
		return "catalogo/prensista";
	}// lista_prensista

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaPrensista(
			@RequestParam(value = "nombre", 	required = false) String nombre,
			@RequestParam(value = "ap_paterno", required = false) String apPaterno,
			@RequestParam(value = "ap_materno", required = false) String apMaterno,
			Model model
		) throws IOException {
		log.info("/alta_prensista");

		Prensista prensista = new Prensista();
		prensista.setNombre(nombre);
		prensista.setApPaterno(apPaterno);
		prensista.setApMaterno(apMaterno);
		prensista.setActivo(true);

		prensistaService.creaPrensista(prensista);

		List<Prensista> listaPrensista = prensistaService.listaPrensista();
		model.addAttribute("listaPrensista", listaPrensista);

		prensista = null;
		listaPrensista = null;
		
		return "catalogo/prensista";
	}// alta_prensista

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaPrensista(
			@RequestParam(value = "id_prensista", 	required = false) Integer idPrensista,
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "ap_paterno", 	required = false) String apPaterno,
			@RequestParam(value = "ap_materno", 	required = false) String apMaterno,
			Model model
		) throws IOException {
		log.info("/modifica_prensista");

		Prensista prensista = prensistaService.buscaPrensista(idPrensista);
		prensista.setNombre(nombre);
		prensista.setApPaterno(apPaterno);
		prensista.setApMaterno(apMaterno);

		prensistaService.modificaPrensista(prensista);

		List<Prensista> listaPrensista = prensistaService.listaPrensista();
		model.addAttribute("listaPrensista", listaPrensista);

		prensista = null;
		listaPrensista = null;
		
		return "catalogo/prensista";
	}// modifica_prensista

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaPrensista(
			@RequestParam(value = "id_prensista", required = false) Integer idPrensista,
			Model model
		) throws IOException {
		log.info("/elimina_prensista");
		
		Prensista prensista = prensistaService.buscaPrensista(idPrensista);
		prensista.setActivo(false);

		prensistaService.modificaPrensista(prensista);

		List<Prensista> listaPrensista = prensistaService.listaPrensista();
		model.addAttribute("listaPrensista", listaPrensista);
		
		prensista = null;
		listaPrensista = null;
		
		return "catalogo/prensista";
	}// elimina_prensista
	
}
