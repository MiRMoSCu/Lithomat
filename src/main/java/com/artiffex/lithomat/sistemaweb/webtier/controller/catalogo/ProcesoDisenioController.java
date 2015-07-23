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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoDisenio;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoDisenioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/proceso_disenio")
public class ProcesoDisenioController {
	
	private static final Logger log = Logger.getLogger(ProcesoDisenioController.class);
	
	@Resource
	private ProcesoDisenioService procesoDisenioService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaProcesoDisenio( Locale locale, Model model ) throws IOException {
		log.info("/lista_proceso_disenio");

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoDisenio> listaProcesoDisenio = procesoDisenioService.listaProcesoDisenio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoDisenio", listaProcesoDisenio);

		listaTipoPrecio = null;
		listaProcesoDisenio = null;
		
		return "catalogo/proceso_disenio";
	}// lista_proceso_disenio

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaProcesoDisenio(
			@RequestParam(value = "nombre_proceso", required = false) String nombreProceso,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "precio", 		required = false) float precio,
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_proceso_disenio");

		ProcesoDisenio procesoDisenio = new ProcesoDisenio();
		procesoDisenio.setNombreProceso(nombreProceso);
		procesoDisenio.setDescripcion(descripcion);
		procesoDisenio.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		procesoDisenio.setTipoPrecio(tipoPrecio);
		procesoDisenio.setActivo(true);

		procesoDisenioService.creaProcesoDisenio(procesoDisenio);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoDisenio> listaProcesoDisenio = procesoDisenioService.listaProcesoDisenio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoDisenio", listaProcesoDisenio);

		procesoDisenio = null;
		tipoPrecio = null;
		listaTipoPrecio = null;
		listaProcesoDisenio = null;
		
		return "catalogo/proceso_disenio";
	}// alta_proceso_disenio

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaProcesoDisenio(
			@RequestParam(value = "id_proceso_disenio", required = false) Integer idProcesoDisenio,
			@RequestParam(value = "nombre_proceso", 	required = false) String nombreProceso,
			@RequestParam(value = "descripcion", 		required = false) String descripcion,
			@RequestParam(value = "precio", 			required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 	required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_proceso_disenio");

		ProcesoDisenio procesoDisenio = procesoDisenioService.buscaProcesoDisenio(idProcesoDisenio);
		procesoDisenio.setNombreProceso(nombreProceso);
		procesoDisenio.setDescripcion(descripcion);
		procesoDisenio.setPrecio(precio);
		procesoDisenio.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);

		procesoDisenioService.modificaProcesoDisenio(procesoDisenio);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoDisenio> listaProcesoDisenio = procesoDisenioService.listaProcesoDisenio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoDisenio", listaProcesoDisenio);

		procesoDisenio = null;
		listaTipoPrecio = null;
		listaProcesoDisenio = null;
		
		return "catalogo/proceso_disenio";
	}// modifica_proceso_disenio

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaProcesoDisenio(
			@RequestParam(value = "id_proceso_disenio", required = false) Integer idProcesoDisenio,
			Model model
		) throws IOException {
		log.info("/elimina_proceso_disenio");
		
		ProcesoDisenio procesoDisenio = procesoDisenioService.buscaProcesoDisenio(idProcesoDisenio);
		procesoDisenio.setActivo(false);

		procesoDisenioService.modificaProcesoDisenio(procesoDisenio);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoDisenio> listaProcesoDisenio = procesoDisenioService.listaProcesoDisenio();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoDisenio", listaProcesoDisenio);

		listaTipoPrecio = null;
		listaProcesoDisenio = null;
		
		return "catalogo/proceso_disenio";
	}// elimina_proceso_disenio
	
}
