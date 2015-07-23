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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CombinacionTintas;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CombinacionTintasService;

@Controller
@RequestMapping("/combinacion_tintas")
public class CombinacionTintasController {
	
	private static final Logger log = Logger.getLogger(CombinacionTintasController.class);
	
	@Resource
	private CombinacionTintasService combinacionTintasService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaCombinacionTintas( Locale locale, Model model ) {
		log.info("/lista_combinacion_tintas");
		
		List<CombinacionTintas> listaCombinacionTintas = combinacionTintasService.listaCombinacionTintas();
		model.addAttribute("listaCombinacionTintas", listaCombinacionTintas);
		listaCombinacionTintas = null;
		
		return "catalogo/combinacion_tintas";
	} // listaCombinacionTintas

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaCombinacionTintas(
			@RequestParam(value = "num_tintas",  required = true) Integer numTintas,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			Model model
		) throws IOException {
		log.info("/alta_combinacion_tintas");

		CombinacionTintas ct = new CombinacionTintas();
		ct.setNumTintas(numTintas);
		ct.setDescripcion(descripcion);
		ct.setActivo(true);

		combinacionTintasService.creaCombinacionTintas(ct);

		List<CombinacionTintas> listaCombinacionTintas = combinacionTintasService.listaCombinacionTintas();
		model.addAttribute("listaCombinacionTintas", listaCombinacionTintas);

		ct = null;
		listaCombinacionTintas = null;
		
		return "catalogo/combinacion_tintas";
	} // altaCombinacionTintas

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaCombinacionTintas(
			@RequestParam(value = "id_combinacion_tintas", 	required = false) Integer idCombinacionTintas,
			@RequestParam(value = "num_tintas", 			required = false) Integer numTintas,
			@RequestParam(value = "descripcion", 			required = false) String descripcion,
			Model model
		) throws IOException {
		log.info("/modifica_combinacion_tintas");

		CombinacionTintas ct = combinacionTintasService.buscaCombinacionTintas(idCombinacionTintas);
		ct.setIdCombinacionTintas(idCombinacionTintas);
		ct.setNumTintas(numTintas);
		ct.setDescripcion(descripcion);

		combinacionTintasService.modificaCombinacionTintas(ct);
		
		List<CombinacionTintas> listaCombinacionTintas = combinacionTintasService.listaCombinacionTintas();
		model.addAttribute("listaCombinacionTintas", listaCombinacionTintas);

		ct = null;
		listaCombinacionTintas = null;
		
		return "catalogo/combinacion_tintas";
	} // modificaCombinacionTintas

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaCombinacionTintas(
			@RequestParam(value = "id_combinacion_tintas", required = false) Integer idCombinacionTintas,
			Model model
		) throws IOException {
		log.info("/elimina_combinacion_tintas");
		
		CombinacionTintas ct = combinacionTintasService.buscaCombinacionTintas(idCombinacionTintas);
		ct.setActivo(false);

		combinacionTintasService.modificaCombinacionTintas(ct);
		
		List<CombinacionTintas> listaCombinacionTintas;
		listaCombinacionTintas = combinacionTintasService.listaCombinacionTintas();
		model.addAttribute("listaCombinacionTintas", listaCombinacionTintas);

		ct = null;
		listaCombinacionTintas = null;
		
		return "catalogo/combinacion_tintas";
	} // eliminaCombinacionTintas
	
}
