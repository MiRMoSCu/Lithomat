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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TintaEspecial;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TintaEspecialService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/tinta_especial")
public class TintaEspecialController {
	
	private static final Logger log = Logger.getLogger(TintaEspecialController.class);
	
	@Resource
	private TintaEspecialService tintaEspecialService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTintaEspecial( Locale locale, Model model ) throws IOException {
		log.info("/lista_tinta_especial");

		List<TintaEspecial> listaTintaEspecial = tintaEspecialService.listaTintaEspecial();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTintaEspecial", listaTintaEspecial);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		
		listaTintaEspecial = null;
		listaTipoPrecio = null;
		
		return "catalogo/tinta_especial";
	}// lista_tinta_especial

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTintaEspecial(
			@RequestParam(value = "id_tinta_especial", 	required = false) Integer idTintaEspecial,
			@RequestParam(value = "precio", 			required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 	required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_tinta_especial");

		TintaEspecial tintaEspecial = new TintaEspecial();
		tintaEspecial.setIdTintaEspecial(idTintaEspecial);
		tintaEspecial.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		tintaEspecial.setTipoPrecio(tipoPrecio);
		tintaEspecial.setActivo(true);

		tintaEspecialService.modificaTintaEspecial(tintaEspecial);

		List<TintaEspecial> listaTintaEspecial = tintaEspecialService.listaTintaEspecial();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTintaEspecial", listaTintaEspecial);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tintaEspecial = null;
		tipoPrecio = null;
		listaTintaEspecial = null;
		listaTipoPrecio = null;
		
		return "catalogo/tinta_especial";
	}// modifica_tinta_especial
	
}
