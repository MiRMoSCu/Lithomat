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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PapelSobrante;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PapelSobranteService;

@Controller
@RequestMapping("/papel_sobrante")
public class PapelSobranteController {
	
	private static final Logger log = Logger.getLogger(PapelSobranteController.class);
	
	@Resource
	private PapelSobranteService papelSobranteService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaPapelSobrante( Locale locale, Model model ) throws IOException {
		log.info("/lista_papel_sobrante");

		List<PapelSobrante> listaPapelSobrante = papelSobranteService.listaPapelSobrante();
		model.addAttribute("listaPapelSobrante", listaPapelSobrante);
		
		listaPapelSobrante = null;
		
		return "catalogo/papel_sobrante";
	}// listaPapelSobrante

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaPapelSobrante(
			@RequestParam(value = "inicio_tabulador", 	required = false) Integer inicioTabulador,
			@RequestParam(value = "fin_tabulador", 		required = false) Integer finTabulador,
			@RequestParam(value = "num_tinta_frente", 	required = false) Integer frenteNumTinta,
			@RequestParam(value = "num_tinta_vuelta", 	required = false) Integer vueltaNumTinta,
			@RequestParam(value = "tinta_especial", 	required = false) boolean tintaEspecial,
			@RequestParam(value = "hojas_sobrante", 	required = false) Integer hojasSobrante,
			Model model
		) {
		log.info("/alta_papel_sobrante");
		
		PapelSobrante papelSobrante = new PapelSobrante();
		papelSobrante.setInicioTabulador(inicioTabulador);
		papelSobrante.setFinTabulador(finTabulador);
		papelSobrante.setFrenteNumTinta(frenteNumTinta);
		papelSobrante.setVueltaNumTinta(vueltaNumTinta);
		papelSobrante.setTintaEspecial(tintaEspecial);
		papelSobrante.setHojasSobrante(hojasSobrante);
		papelSobrante.setActivo(true);

		papelSobranteService.creaPapelSobrante(papelSobrante);

		List<PapelSobrante> listaPapelSobrante = papelSobranteService.listaPapelSobrante();
		model.addAttribute("listaPapelSobrante", listaPapelSobrante);

		papelSobrante = null;
		listaPapelSobrante = null;
		
		return "catalogo/papel_sobrante";
	}// altaPapelSobrante

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaPapelSobrante(
			@RequestParam(value = "id_papel_sobrante", 	required = false) Integer idPapelSobrante,
			@RequestParam(value = "inicio_tabulador", 	required = false) Integer inicioTabulador,
			@RequestParam(value = "fin_tabulador", 		required = false) Integer finTabulador,
			@RequestParam(value = "num_tinta_frente", 	required = false) Integer frenteNumTinta,
			@RequestParam(value = "num_tinta_vuelta", 	required = false) Integer vueltaNumTinta,
			@RequestParam(value = "tinta_especial", 	required = false) boolean tintaEspecial,
			@RequestParam(value = "hojas_sobrante", 	required = false) Integer hojasSobrante,
			Model model
		) {
		log.info("/modifica_papel_sobrante");

		PapelSobrante papelSobrante = papelSobranteService.buscaPapelSobrante(idPapelSobrante);
		papelSobrante.setInicioTabulador(inicioTabulador);
		papelSobrante.setFinTabulador(finTabulador);
		papelSobrante.setFrenteNumTinta(frenteNumTinta);
		papelSobrante.setVueltaNumTinta(vueltaNumTinta);
		papelSobrante.setTintaEspecial(tintaEspecial);
		papelSobrante.setHojasSobrante(hojasSobrante);

		papelSobranteService.modificaPapelSobrante(papelSobrante);

		List<PapelSobrante> listaPapelSobrante = papelSobranteService.listaPapelSobrante();
		model.addAttribute("listaPapelSobrante", listaPapelSobrante);

		papelSobrante = null;
		listaPapelSobrante = null;
		
		return "catalogo/papel_sobrante";
	}// modificaPapelSobrante

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaPapelSobrante(
			@RequestParam(value = "id_papel_sobrante", required = false) Integer idPapelSobrante,
			Model model
		) {
		log.info("/elimina_papel_sobrante");
		
		PapelSobrante papelSobrante = papelSobranteService.buscaPapelSobrante(idPapelSobrante);
		papelSobrante.setActivo(false);

		papelSobranteService.modificaPapelSobrante(papelSobrante);

		List<PapelSobrante> listaPapelSobrante = papelSobranteService.listaPapelSobrante();
		model.addAttribute("listaPapelSobrante", listaPapelSobrante);

		papelSobrante = null;
		listaPapelSobrante = null;
		
		return "catalogo/papel_sobrante";
	}// eliminaPapelSobrante
	
}
