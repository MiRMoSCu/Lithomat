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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;

@Controller
@RequestMapping("/maquina")
public class MaquinaController {
	
	private static final Logger log = Logger.getLogger(MaquinaController.class);
	
	@Resource
	private MaquinaService maquinaService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaMaquina( Locale locale, Model model ) throws IOException {
		log.info("/lista_maquina");

		List<Maquina> listaMaquina = maquinaService.listaMaquina();
		model.addAttribute("listaMaquina", listaMaquina);

		listaMaquina = null;
		
		return "catalogo/maquina";
	}// lista_maquina

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaMaquina(
			@RequestParam(value = "nombre", 			required = false) String nombre,
			@RequestParam(value = "descripcion", 		required = false) String descripcion,
			@RequestParam(value = "num_colores", 		required = false) Integer numColores,
			@RequestParam(value = "ancho_placa", 		required = false) Integer anchoPlaca,
			@RequestParam(value = "alto_placa", 		required = false) Integer altoPlaca,
			@RequestParam(value = "ancho_max_papel", 	required = false) Integer anchoMaxPapel,
			@RequestParam(value = "alto_max_papel", 	required = false) Integer altoMaxPapel,
			@RequestParam(value = "ancho_min_papel", 	required = false) Integer anchoMinPapel,
			@RequestParam(value = "alto_min_papel", 	required = false) Integer altoMinPapel,
			Model model
		) throws IOException {
		log.info("/alta_maquina");

		Maquina maquina = new Maquina();
		maquina.setNombre(nombre);
		maquina.setDescripcion(descripcion);
		maquina.setNumColores(numColores);
		maquina.setAnchoPlaca(anchoPlaca);
		maquina.setAltoPlaca(altoPlaca);
		maquina.setAnchoMaxPapel(anchoMaxPapel);
		maquina.setAltoMaxPapel(altoMaxPapel);
		maquina.setAnchoMinPapel(anchoMinPapel);
		maquina.setAltoMinPapel(altoMinPapel);
		maquina.setActivo(true);

		maquinaService.creaMaquina(maquina);

		List<Maquina> listaMaquina = maquinaService.listaMaquina();
		model.addAttribute("listaMaquina", listaMaquina);

		maquina = null;
		listaMaquina = null;
		
		return "catalogo/maquina";
	}// alta_maquina

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaMaquina(
			@RequestParam(value = "id_maquina", 		required = false) Integer idMaquina,
			@RequestParam(value = "nombre", 			required = false) String nombre,
			@RequestParam(value = "descripcion", 		required = false) String descripcion,
			@RequestParam(value = "num_colores", 		required = false) Integer numColores,
			@RequestParam(value = "ancho_placa", 		required = false) Integer anchoPlaca,
			@RequestParam(value = "alto_placa", 		required = false) Integer altoPlaca,
			@RequestParam(value = "ancho_max_papel", 	required = false) Integer anchoMaxPapel,
			@RequestParam(value = "alto_max_papel", 	required = false) Integer altoMaxPapel,
			@RequestParam(value = "ancho_min_papel", 	required = false) Integer anchoMinPapel,
			@RequestParam(value = "alto_min_papel", 	required = false) Integer altoMinPapel,
			Model model
		) throws IOException {
		log.info("/modifica_maquina");

		Maquina maquina = maquinaService.buscaMaquina(idMaquina);
		maquina.setNombre(nombre);
		maquina.setDescripcion(descripcion);
		maquina.setNumColores(numColores);
		maquina.setAnchoPlaca(anchoPlaca);
		maquina.setAltoPlaca(altoPlaca);
		maquina.setAnchoMaxPapel(anchoMaxPapel);
		maquina.setAltoMaxPapel(altoMaxPapel);
		maquina.setAnchoMinPapel(anchoMinPapel);
		maquina.setAltoMinPapel(altoMinPapel);

		maquinaService.modificaMaquina(maquina);

		List<Maquina> listaMaquina = maquinaService.listaMaquina();
		model.addAttribute("listaMaquina", listaMaquina);

		maquina = null;
		listaMaquina = null;
		
		return "catalogo/maquina";
	}// modifica_maquina

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaMaquina(
			@RequestParam(value = "id_maquina", required = false) Integer idMaquina,
			Model model
		) throws IOException {
		log.info("/elimina_maquina");
		
		Maquina maquina = maquinaService.buscaMaquina(idMaquina);
		maquina.setActivo(false);

		maquinaService.modificaMaquina(maquina);

		List<Maquina> listaMaquina = maquinaService.listaMaquina();
		model.addAttribute("listaMaquina", listaMaquina);
		
		maquina = null;
		listaMaquina = null;
		
		return "catalogo/maquina";
	}// elimina_maquina
	
}
