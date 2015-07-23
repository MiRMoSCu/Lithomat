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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TamanioPublicacion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TamanioPublicacionService;

@Controller
@RequestMapping("/tamanio_publicacion")
public class TamanioPublicacionController {
	
	private static final Logger log = Logger.getLogger(TamanioPublicacionController.class);
	
	@Resource
	private TamanioPublicacionService tamanioPublicacionService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTamanioPublicacion( Locale locale, Model model ) throws IOException {
		log.info("/lista_tamanio_publicacion");

		List<TamanioPublicacion> listaTamanioPublicacion = tamanioPublicacionService.listaTamanioPublicacion();
		model.addAttribute("listaTamanioPublicacion", listaTamanioPublicacion);

		listaTamanioPublicacion = null;
		
		return "catalogo/tamanio_publicacion";
	}// lista_tamanio_publicacion

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTamanioPublicacion(
			@RequestParam(value = "nombre", 			required = false) String nombre,
			@RequestParam(value = "tamanio_fraccion", 	required = false) String tamanioFraccion,
			@RequestParam(value = "numero_paginas", 	required = false) Integer numeroPaginas,
			@RequestParam(value = "numero_decimal", 	required = false) float numeroDecimal,
			@RequestParam(value = "numero_doblez", 		required = false) Integer numeroDoblez,
			Model model
		) throws IOException {
		log.info("/alta_tamanio_publicacion");

		TamanioPublicacion tamanioPublicacion = new TamanioPublicacion();
		tamanioPublicacion.setNombre(nombre);
		tamanioPublicacion.setTamanioFraccion(tamanioFraccion);
		tamanioPublicacion.setNumeroPaginas(numeroPaginas);
		tamanioPublicacion.setNumeroDecimal(numeroDecimal);
		tamanioPublicacion.setNumeroDoblez(numeroDoblez);
		tamanioPublicacion.setActivo(true);

		tamanioPublicacionService.creaTamanioPublicacion(tamanioPublicacion);

		List<TamanioPublicacion> listaTamanioPublicacion = tamanioPublicacionService.listaTamanioPublicacion();
		model.addAttribute("listaTamanioPublicacion", listaTamanioPublicacion);

		tamanioPublicacion = null;
		listaTamanioPublicacion = null;
		
		return "catalogo/tamanio_publicacion";
	}// alta_tamanio_publicacion

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTamanioPublicacion(
			@RequestParam(value = "id_tamanio_publicacion", required = false) Integer idTamanioPublicacion,
			@RequestParam(value = "nombre", 				required = false) String nombre,
			@RequestParam(value = "tamanio_fraccion", 		required = false) String tamanioFraccion,
			@RequestParam(value = "numero_paginas", 		required = false) Integer numeroPaginas,
			@RequestParam(value = "numero_decimal", 		required = false) float numeroDecimal,
			@RequestParam(value = "numero_doblez", 			required = false) Integer numeroDoblez,
			Model model
		) throws IOException {
		log.info("/modifica_tamanio_publicacion");

		TamanioPublicacion tamanioPublicacion = tamanioPublicacionService.buscaTamanioPublicacion(idTamanioPublicacion);
		tamanioPublicacion.setNombre(nombre);
		tamanioPublicacion.setTamanioFraccion(tamanioFraccion);
		tamanioPublicacion.setNumeroPaginas(numeroPaginas);
		tamanioPublicacion.setNumeroDecimal(numeroDecimal);
		tamanioPublicacion.setNumeroDoblez(numeroDoblez);

		tamanioPublicacionService.modificaTamanioPublicacion(tamanioPublicacion);

		List<TamanioPublicacion> listaTamanioPublicacion = tamanioPublicacionService.listaTamanioPublicacion();
		model.addAttribute("listaTamanioPublicacion", listaTamanioPublicacion);

		tamanioPublicacion = null;
		listaTamanioPublicacion = null;
		
		return "catalogo/tamanio_publicacion";
	}// modifica_tamanio_publicacion

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTamanioPublicacion(
			@RequestParam(value = "id_tamanio_publicacion", required = false) Integer idTamanioPublicacion,
			Model model
		) throws IOException {
		log.info("/elimina_tamanio_publicacion");
		
		TamanioPublicacion tamanioPublicacion = tamanioPublicacionService.buscaTamanioPublicacion(idTamanioPublicacion);
		tamanioPublicacion.setActivo(false);

		tamanioPublicacionService.modificaTamanioPublicacion(tamanioPublicacion);

		List<TamanioPublicacion> listaTamanioPublicacion = tamanioPublicacionService.listaTamanioPublicacion();
		model.addAttribute("listaTamanioPublicacion", listaTamanioPublicacion);

		tamanioPublicacion = null;
		listaTamanioPublicacion = null;
		
		return "catalogo/tamanio_publicacion";
	}// elimina_tamanio_publicacion
	
}
