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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;

@Controller
@RequestMapping("/tipo_precio")
public class TipoPrecioController {
	
	private static final Logger log = Logger.getLogger(TipoPrecioController.class);
	
	@Resource
	private TipoPrecioService tipoPrecioService;

	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoPrecio(Locale locale, Model model) throws IOException {
		log.info("/lista_tipo_precio");

		List<TipoPrecio> listaTipoPrecio = tipoPrecioService.listaTipoPrecio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoPrecio = null;
		
		return "catalogo/tipo_precio";
	}// lista_tipo_precio

	@Secured("ROLE_ROOT")
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

	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoPrecio(
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "factor_divisor", required = false) Integer factorDivisor,
			Model model
		) throws IOException {
		log.info("/modifica_tipo_precio");
		
		// NO SE PUEDE MODIFICAR EL NOMBRE NI EL FACTOR DIVISOR DE LOS TIPOS PRECIO BASE:
		// 1) NO APLICA, 1; NO PUEDE SER CERO POR ERROR EN DIVISION ENTRE CERO
		// 2) UNIDAD, 1
		// 3) CIENTO, 100
		// 4) MILLAR, 1000
		// 5) HORA, 60
		// 6) PORCENTAJE, 100
		// 7) CENTIMETRO CUADRADO, 1
		TipoPrecio tipoPrecio = tipoPrecioService.buscaTipoPrecio(idTipoPrecio);
		if( idTipoPrecio > 0 && idTipoPrecio < 8 ) { // rango VERDADERO incluyente del 1 al 7
			tipoPrecio.setDescripcion(descripcion);
		} else {
			tipoPrecio.setNombre(nombre);
			tipoPrecio.setDescripcion(descripcion);
			tipoPrecio.setFactorDivisor(factorDivisor);
		}
		tipoPrecioService.modificaTipoPrecio(tipoPrecio);

		List<TipoPrecio> listaTipoPrecio = tipoPrecioService.listaTipoPrecio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoPrecio = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_precio";
	}// modifica_tipo_precio

	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoPrecio(
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/elimina_tipo_precio");
		
		// NO SE PUEDE ELIMINAR LOS TIPOS PRECIO BASE: 1 al 7
		// 1) NO APLICA
		// 2) UNIDAD
		// 3) CIENTO
		// 4) MILLAR
		// 5) HORA
		// 6) PORCENTAJE
		// 7) CENTIMETRO CUADRADO
		TipoPrecio tipoPrecio = tipoPrecioService.buscaTipoPrecio(idTipoPrecio);
		if( idTipoPrecio < 1 || idTipoPrecio > 7 ) { // rango VERDADERO excluyente del 1 al 7
			tipoPrecio.setActivo(false);
			tipoPrecioService.modificaTipoPrecio(tipoPrecio);
		}

		List<TipoPrecio> listaTipoPrecio = tipoPrecioService.listaTipoPrecio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoPrecio = null;
		
		return "catalogo/tipo_precio";
	}// elimina_tipo_precio
	
}
