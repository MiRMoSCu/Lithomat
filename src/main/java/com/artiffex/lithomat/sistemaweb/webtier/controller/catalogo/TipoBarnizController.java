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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoBarniz;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoBarnizService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/tipo_barniz")
public class TipoBarnizController {
	
	private static final Logger log = Logger.getLogger(TipoBarnizController.class);
	
	@Resource
	private TipoBarnizService tipoBarnizService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoBarniz( Locale locale, Model model ) throws IOException {
		log.info("/lista_tipo_barniz");

		List<TipoBarniz> listaTipoBarniz = tipoBarnizService.listaTipoBarniz();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoBarniz", listaTipoBarniz);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoBarniz = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_barniz";
	}// lista_tipo_barniz

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTipoBarniz(
			@RequestParam(value = "descripcion", 			required = false) String descripcion,
			@RequestParam(value = "num_entradas_maquina", 	required = false) Integer numEntradasmaquina,
			@RequestParam(value = "num_placas", 			required = false) Integer numPlacas,
			@RequestParam(value = "precio", 				required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 		required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_tipo_barniz");

		TipoBarniz tipoBarniz = new TipoBarniz();
		tipoBarniz.setDescripcion(descripcion);
		tipoBarniz.setNumEntradasMaquina(numEntradasmaquina);
		tipoBarniz.setNumPlacas(numPlacas);
		tipoBarniz.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		tipoBarniz.setTipoPrecio(tipoPrecio);
		tipoBarniz.setActivo(true);

		tipoBarnizService.creaTipoBarniz(tipoBarniz);

		List<TipoBarniz> listaTipoBarniz = tipoBarnizService.listaTipoBarniz();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoBarniz", listaTipoBarniz);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoBarniz = null;
		tipoPrecio = null;
		listaTipoBarniz = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_barniz";
	}// alta_tipo_barniz

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoBarniz(
			@RequestParam(value = "id_tipo_barniz", 		required = false) Integer idTipoBarniz,
			@RequestParam(value = "descripcion", 			required = false) String descripcion,
			@RequestParam(value = "num_entradas_maquina", 	required = false) Integer numEntradasMaquina,
			@RequestParam(value = "num_placas", 			required = false) Integer numPlacas,
			@RequestParam(value = "precio", 				required = false) float precio,
			@RequestParam(value = "id_tipo_precio",			required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_tipo_barniz");

		TipoBarniz tipoBarniz = tipoBarnizService.buscaTipoBarniz(idTipoBarniz);
		tipoBarniz.setDescripcion(descripcion);
		tipoBarniz.setNumEntradasMaquina(numEntradasMaquina);
		tipoBarniz.setNumPlacas(numPlacas);
		tipoBarniz.setPrecio(precio);
		tipoBarniz.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);

		tipoBarnizService.modificaTipoBarniz(tipoBarniz);

		List<TipoBarniz> listaTipoBarniz = tipoBarnizService.listaTipoBarniz();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoBarniz", listaTipoBarniz);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoBarniz = null;
		listaTipoBarniz = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_barniz";
	}// modifica_tipo_barniz

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoBarniz(
			@RequestParam(value = "id_tipo_barniz", required = false) Integer idTipoBarniz,
			Model model
		) throws IOException {
		log.info("/elimina_tipo_barniz");
		
		TipoBarniz tipoBarniz = tipoBarnizService.buscaTipoBarniz(idTipoBarniz);
		tipoBarniz.setActivo(false);

		tipoBarnizService.modificaTipoBarniz(tipoBarniz);

		List<TipoBarniz> listaTipoBarniz = tipoBarnizService.listaTipoBarniz();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoBarniz", listaTipoBarniz);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoBarniz = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_barniz";
	}// elimina_tipo_barniz
	
}
