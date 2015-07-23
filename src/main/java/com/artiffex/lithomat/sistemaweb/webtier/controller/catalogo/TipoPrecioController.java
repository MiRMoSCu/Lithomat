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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;

@Controller
@RequestMapping("/tipo_precio")
public class TipoPrecioController {
	
	private static final Logger log = Logger.getLogger(TipoPrecioController.class);
	
	@Resource
	private TipoPrecioService tipoPrecioService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoPrecio(Locale locale, Model model) throws IOException {
		log.info("/lista_tipo_precio");

		List<TipoPrecio> listaTipoPrecio = tipoPrecioService.listaTipoPrecio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoPrecio = null;
		
		return "catalogo/tipo_precio";
	}// lista_tipo_precio

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTipoPrecio(
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "factor_divisor", required = false) Integer factorDivisor,
			Model model
		) throws IOException {
		log.info("/alta_tipo_precio");

		TipoPrecio tipoPrecio = new TipoPrecio();
		tipoPrecio.setNombre(nombre);
		tipoPrecio.setDescripcion(descripcion);
		tipoPrecio.setFactorDivisor(factorDivisor);
		tipoPrecio.setActivo(true);

		tipoPrecioService.creaTipoPrecio(tipoPrecio);

		List<TipoPrecio> listaTipoPrecio = tipoPrecioService.listaTipoPrecio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoPrecio = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_precio";
	}// alta_tipo_precio

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoPrecio(
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "factor_divisor", required = false) Integer factorDivisor,
			Model model
		) throws IOException {
		log.info("/modifica_tipo_precio");

		TipoPrecio tipoPrecio = tipoPrecioService.buscaTipoPrecio(idTipoPrecio);
		tipoPrecio.setNombre(nombre);
		tipoPrecio.setDescripcion(descripcion);
		tipoPrecio.setFactorDivisor(factorDivisor);

		tipoPrecioService.modificaTipoPrecio(tipoPrecio);

		List<TipoPrecio> listaTipoPrecio = tipoPrecioService.listaTipoPrecio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoPrecio = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_precio";
	}// modifica_tipo_precio

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoPrecio(
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/elimina_tipo_precio");
		
		TipoPrecio tipoPrecio = tipoPrecioService.buscaTipoPrecio(idTipoPrecio);
		tipoPrecio.setActivo(false);

		tipoPrecioService.modificaTipoPrecio(tipoPrecio);

		List<TipoPrecio> listaTipoPrecio = tipoPrecioService.listaTipoPrecio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoPrecio = null;
		
		return "catalogo/tipo_precio";
	}// elimina_tipo_precio
	
}
