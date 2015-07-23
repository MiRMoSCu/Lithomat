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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoExterno;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorExterno;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoExternoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProveedorExternoService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/proceso_externo")
public class ProcesoExternoController {
	
	private static final Logger log = Logger.getLogger(ProcesoExternoController.class);
	
	@Resource
	private ProcesoExternoService procesoExternoService;
	@Resource
	private ProveedorExternoService proveedorExternoService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaProcesoExterno( Locale locale, Model model ) throws IOException {
		log.info("/lista_proceso_externo");

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ComboSelect> listaProveedorExterno = proveedorExternoService.listaComboSelect();
		List<ProcesoExterno> listaProcesoExterno = procesoExternoService.listaProcesoExterno();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProveedorExterno", listaProveedorExterno);
		model.addAttribute("listaProcesoExterno", listaProcesoExterno);

		listaTipoPrecio = null;
		listaProveedorExterno = null;
		listaProcesoExterno = null;
		
		return "catalogo/proceso_externo";
	}// lista_proceso_externo

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaProcesoExterno(
			@RequestParam(value = "id_proveedor_externo", 	required = false) Integer idProveedorExterno,
			@RequestParam(value = "nombre_proceso", 		required = false) String nombreProceso,
			@RequestParam(value = "observaciones", 			required = false) String observaciones,
			@RequestParam(value = "precio", 				required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 		required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_proceso_externo");

		ProcesoExterno procesoExterno = new ProcesoExterno();
			ProveedorExterno proveedorExterno = new ProveedorExterno();
			proveedorExterno.setIdProveedorExterno(idProveedorExterno);
		procesoExterno.setProveedorExterno(proveedorExterno);
		procesoExterno.setNombreProceso(nombreProceso);
		procesoExterno.setObservaciones(observaciones);
		procesoExterno.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		procesoExterno.setTipoPrecio(tipoPrecio);
		procesoExterno.setActivo(true);

		procesoExternoService.creaProcesoExterno(procesoExterno);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ComboSelect> listaProveedorExterno = proveedorExternoService.listaComboSelect();
		List<ProcesoExterno> listaProcesoExterno = procesoExternoService.listaProcesoExterno();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProveedorExterno", listaProveedorExterno);
		model.addAttribute("listaProcesoExterno", listaProcesoExterno);

		procesoExterno = null;
		proveedorExterno = null;
		tipoPrecio = null;
		listaTipoPrecio = null;
		listaProveedorExterno = null;
		listaProcesoExterno = null;
		
		return "catalogo/proceso_externo";
	}// alta_proceso_externo

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaProcesoExterno(
			@RequestParam(value = "id_proceso_externo", 	required = false) Integer idProcesoExterno,
			@RequestParam(value = "id_proveedor_externo", 	required = false) Integer idProveedorExterno,
			@RequestParam(value = "nombre_proceso", 		required = false) String nombreProceso,
			@RequestParam(value = "observaciones", 			required = false) String observaciones,
			@RequestParam(value = "precio", 				required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 		required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_proceso_externo");

		System.out.println("entro a modifica_proceso_externo");

		ProcesoExterno procesoExterno = procesoExternoService.buscaProcesoExterno(idProcesoExterno);
		procesoExterno.getProveedorExterno().setIdProveedorExterno(idProveedorExterno);
		procesoExterno.setNombreProceso(nombreProceso);
		procesoExterno.setObservaciones(observaciones);
		procesoExterno.setPrecio(precio);
		procesoExterno.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);

		procesoExternoService.modificaProcesoExterno(procesoExterno);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ComboSelect> listaProveedorExterno = proveedorExternoService.listaComboSelect();
		List<ProcesoExterno> listaProcesoExterno = procesoExternoService.listaProcesoExterno();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProveedorExterno", listaProveedorExterno);
		model.addAttribute("listaProcesoExterno", listaProcesoExterno);

		procesoExterno = null;
		listaTipoPrecio = null;
		listaProveedorExterno = null;
		listaProcesoExterno = null;
		
		return "catalogo/proceso_externo";
	}// modifica_proceso_externo

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaProcesoExterno(
			@RequestParam(value = "id_proceso_externo", required = false) Integer idProcesoExterno,
			Model model
		) throws IOException {
		log.info("/elimina_proceso_externo");
		
		ProcesoExterno procesoExterno = procesoExternoService.buscaProcesoExterno(idProcesoExterno);
		procesoExterno.setActivo(false);

		procesoExternoService.modificaProcesoExterno(procesoExterno);

		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		List<ComboSelect> listaProveedorExterno = proveedorExternoService.listaComboSelect();
		List<ProcesoExterno> listaProcesoExterno = procesoExternoService.listaProcesoExterno();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaProveedorExterno", listaProveedorExterno);
		model.addAttribute("listaProcesoExterno", listaProcesoExterno);

		procesoExterno = null;
		listaTipoPrecio = null;
		listaProveedorExterno = null;
		listaProcesoExterno = null;
		
		return "catalogo/proceso_externo";
	}// elimina_proceso_externo
	
}
