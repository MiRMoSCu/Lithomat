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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoPreprensa;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoPreprensaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/proceso_preprensa")
public class ProcesoPreprensaController {
	
	private static final Logger log = Logger.getLogger(ProcesoPreprensaController.class);
	
	@Resource
	private ProcesoPreprensaService procesoPreprensaService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaProcesoPreprensa( Locale locale, Model model ) throws IOException {
		log.info("/lista_proceso_preprensa");
		
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoPreprensa> listaProcesoPreprensa = procesoPreprensaService.listaProcesoPreprensa();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoPreprensa", listaProcesoPreprensa);

		listaTipoPrecio = null;
		listaProcesoPreprensa = null;
		
		return "catalogo/proceso_preprensa";
	} // lista_proceso_preprensa

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaProcesoPreprensa(
			@RequestParam(value = "nombre_proceso", required = false) String nombreProceso,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "precio", 		required = false) float precio,
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_proceso_preprensa");

		ProcesoPreprensa procesoPreprensa = new ProcesoPreprensa();
		procesoPreprensa.setNombreProceso(nombreProceso);
		procesoPreprensa.setDescripcion(descripcion);
		procesoPreprensa.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		procesoPreprensa.setTipoPrecio(tipoPrecio);
		procesoPreprensa.setActivo(true);

		procesoPreprensaService.creaProcesoPreprensa(procesoPreprensa);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoPreprensa> listaProcesoPreprensa = procesoPreprensaService.listaProcesoPreprensa();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoPreprensa", listaProcesoPreprensa);

		procesoPreprensa = null;
		tipoPrecio = null;
		listaTipoPrecio = null;
		listaProcesoPreprensa = null;
		
		return "catalogo/proceso_preprensa";
	} // alta_proceso_preprensa

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaProcesoPreprensa(
			@RequestParam(value = "id_proceso_preprensa", 	required = false) Integer idProcesoPreprensa,
			@RequestParam(value = "nombre_proceso", 		required = false) String nombreProceso,
			@RequestParam(value = "descripcion", 			required = false) String descripcion,
			@RequestParam(value = "precio", 				required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 		required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_proceso_preprensa");

		ProcesoPreprensa procesoPreprensa = procesoPreprensaService.buscaProcesoPreprensa(idProcesoPreprensa);
		procesoPreprensa.setNombreProceso(nombreProceso);
		procesoPreprensa.setDescripcion(descripcion);
		procesoPreprensa.setPrecio(precio);
		procesoPreprensa.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);

		procesoPreprensaService.modificaProcesoPreprensa(procesoPreprensa);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoPreprensa> listaProcesoPreprensa = procesoPreprensaService.listaProcesoPreprensa();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoPreprensa", listaProcesoPreprensa);

		procesoPreprensa = null;
		listaTipoPrecio = null;
		listaProcesoPreprensa = null;
		
		return "catalogo/proceso_preprensa";
	} // modifica_proceso_preprensa

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaProcesoPreprensa(
			@RequestParam(value = "id_proceso_preprensa", required = false) Integer idProcesoPreprensa,
			Model model
		) throws IOException {
		log.info("/elimina_proceso_preprensa");
		
		ProcesoPreprensa procesoPreprensa = procesoPreprensaService.buscaProcesoPreprensa(idProcesoPreprensa);
		procesoPreprensa.setActivo(false);

		procesoPreprensaService.modificaProcesoPreprensa(procesoPreprensa);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoPreprensa> listaProcesoPreprensa = procesoPreprensaService.listaProcesoPreprensa();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoPreprensa", listaProcesoPreprensa);

		procesoPreprensa = null;
		listaTipoPrecio = null;
		listaProcesoPreprensa = null;
		
		return "catalogo/proceso_preprensa";
	} // elimina_proceso_preprensa
	
}
