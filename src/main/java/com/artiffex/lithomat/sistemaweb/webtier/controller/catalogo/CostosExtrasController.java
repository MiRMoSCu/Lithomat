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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtras;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostosExtrasService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/costos_extras")
public class CostosExtrasController {
	
	private static final Logger log = Logger.getLogger(CostosExtrasController.class);
	
	@Resource
	private CostosExtrasService costosExtrasService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaCostosExtras( Locale locale, Model model ) {
		log.info("/lista_costos_extras");
		
		List<CostosExtras> listaCostosExtras = costosExtrasService.listaCostosExtras();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaCostosExtras", listaCostosExtras);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoPrecio = null;
		listaCostosExtras = null;
		
		return "catalogo/costos_extras";
	} // lista_costos_extras

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaCostosExtras(
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "precio", 		required = false) float precio,
			@RequestParam(value = "id_tipo_precio", required = false) int idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_costos_extras");

		CostosExtras costosExtras = new CostosExtras();
		costosExtras.setNombre(nombre);
		costosExtras.setDescripcion(descripcion);
		costosExtras.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		costosExtras.setTipoPrecio(tipoPrecio);
		costosExtras.setActivo(true);

		costosExtrasService.creaCostosExtras(costosExtras);

		List<CostosExtras> listaCostosExtras = costosExtrasService.listaCostosExtras();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaCostosExtras", listaCostosExtras);

		costosExtras = null;
		tipoPrecio = null;
		listaTipoPrecio = null;
		listaCostosExtras = null;
		
		return "catalogo/costos_extras";
	}// alta_costos_extras

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaCostosExtras(
			@RequestParam(value = "id_costos_extras", 	required = false) Integer idCostosExtras,
			@RequestParam(value = "nombre", 			required = false) String nombre,
			@RequestParam(value = "descripcion", 		required = false) String descripcion,
			@RequestParam(value = "precio", 			required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 	required = false) int idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_costos_extras");

		CostosExtras costosExtras = costosExtrasService.buscaCostosExtras(idCostosExtras);
		costosExtras.setNombre(nombre);
		costosExtras.setDescripcion(descripcion);
		costosExtras.setPrecio(precio);
		costosExtras.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);

		costosExtrasService.modificaCostosExtras(costosExtras);

		List<CostosExtras> listaCostosExtras = costosExtrasService.listaCostosExtras();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaCostosExtras", listaCostosExtras);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		costosExtras = null;
		listaTipoPrecio = null;
		listaCostosExtras = null;
		
		return "catalogo/costos_extras";
	}// modifica_costos_extras

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaCostosExtras(
			@RequestParam(value = "id_costos_extras", required = false) Integer idCostosExtras,
			Model model
		) throws IOException {
		log.info("/elimina_costos_extras");

		CostosExtras costosExtras = costosExtrasService.buscaCostosExtras(idCostosExtras);
		costosExtras.setActivo(false);
		
		costosExtrasService.modificaCostosExtras(costosExtras);

		List<CostosExtras> listaCostosExtras = costosExtrasService.listaCostosExtras();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaCostosExtras", listaCostosExtras);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		costosExtras = null;
		listaTipoPrecio = null;
		listaCostosExtras = null;
		
		return "catalogo/costos_extras";
	}// elimina_costos_extras
	
}
