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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoTransporte;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoTransporteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/proceso_transporte")
public class ProcesoTransporteController {
	
	private static final Logger log = Logger.getLogger(ProcesoTransporteController.class);
	
	@Resource
	private ProcesoTransporteService procesoTransporteService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String lista( Locale locale, Model model ) throws IOException {
		log.info("/lista_proceso_transporte");

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoTransporte> listaProcesoTransporte = procesoTransporteService.listaProcesoTransporte();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoTransporte", listaProcesoTransporte);

		listaTipoPrecio = null;
		listaProcesoTransporte = null;
		
		return "catalogo/proceso_transporte";
	}// lista_proceso_transporte

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String alta(
			@RequestParam(value = "nombre_proceso", required = false) String nombreProceso,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "precio", 		required = false) float precio,
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_proceso_transporte");

		ProcesoTransporte procesoTransporte = new ProcesoTransporte();
		procesoTransporte.setNombreProceso(nombreProceso);
		procesoTransporte.setDescripcion(descripcion);
		procesoTransporte.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		procesoTransporte.setTipoPrecio(tipoPrecio);
		procesoTransporte.setActivo(true);

		procesoTransporteService.creaProcesoTransporte(procesoTransporte);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoTransporte> listaProcesoTransporte = procesoTransporteService.listaProcesoTransporte();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoTransporte", listaProcesoTransporte);

		procesoTransporte = null;
		tipoPrecio = null;
		listaTipoPrecio = null;
		listaProcesoTransporte = null;
		
		return "catalogo/proceso_transporte";
	}// alta_proceso_transporte

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modifica(
			@RequestParam(value = "id_proceso_transporte", 	required = false) Integer idProcesoTransporte,
			@RequestParam(value = "nombre_proceso", 		required = false) String nombreProceso,
			@RequestParam(value = "descripcion", 			required = false) String descripcion,
			@RequestParam(value = "precio", 				required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 		required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_proceso_transporte");

		ProcesoTransporte procesoTransporte = procesoTransporteService.buscaProcesoTransporte(idProcesoTransporte);
		procesoTransporte.setNombreProceso(nombreProceso);
		procesoTransporte.setDescripcion(descripcion);
		procesoTransporte.setPrecio(precio);
		procesoTransporte.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);
		
		procesoTransporteService.modificaProcesoTransporte(procesoTransporte);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoTransporte> listaProcesoTransporte = procesoTransporteService.listaProcesoTransporte();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoTransporte", listaProcesoTransporte);

		procesoTransporte = null;
		listaTipoPrecio = null;
		listaProcesoTransporte = null;
		
		return "catalogo/proceso_transporte";
	}// modifica_proceso_transporte

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String elimina(
			@RequestParam(value = "id_proceso_transporte", required = false) Integer idProcesoTransporte,
			Model model
		) throws IOException {
		log.info("/elimina_proceso_transporte");
		
		ProcesoTransporte procesoTransporte = procesoTransporteService.buscaProcesoTransporte(idProcesoTransporte);
		procesoTransporte.setActivo(false);

		procesoTransporteService.modificaProcesoTransporte(procesoTransporte);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ProcesoTransporte> listaProcesoTransporte = procesoTransporteService.listaProcesoTransporte();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProcesoTransporte", listaProcesoTransporte);

		procesoTransporte = null;
		listaTipoPrecio = null;
		listaProcesoTransporte = null;
		
		return "catalogo/proceso_transporte";
	}// elimina_proceso_transporte
	
}
