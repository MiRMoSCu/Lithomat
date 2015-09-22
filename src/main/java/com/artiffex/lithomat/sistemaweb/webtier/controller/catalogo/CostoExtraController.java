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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtra;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/costo_extra")
public class CostoExtraController {
	
	private static final Logger log = Logger.getLogger(CostoExtraController.class);
	
	@Resource
	private CostoExtraService costoExtraService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaCostoExtra( Locale locale, Model model ) {
		log.info("/lista_costo_extra");
		
		List<CostoExtra> listaCostoExtra = costoExtraService.listaCostoExtra();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaCostoExtra", listaCostoExtra);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoPrecio = null;
		listaCostoExtra = null;
		
		return "catalogo/costo_extra";
	} // lista_costo_extra

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaCostoExtra(
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "precio", 		required = false) float precio,
			@RequestParam(value = "id_tipo_precio", required = false) int idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_costo_extra");

		CostoExtra costoExtra = new CostoExtra();
		costoExtra.setNombre(nombre);
		costoExtra.setDescripcion(descripcion);
		costoExtra.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		costoExtra.setTipoPrecio(tipoPrecio);
		costoExtra.setActivo(true);

		costoExtraService.creaCostoExtra(costoExtra);

		List<CostoExtra> listaCostoExtra = costoExtraService.listaCostoExtra();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);
		model.addAttribute("listaCostoExtra", listaCostoExtra);

		costoExtra = null;
		tipoPrecio = null;
		listaTipoPrecio = null;
		listaCostoExtra = null;
		
		return "catalogo/costo_extra";
	}// alta_costo_extra

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaCostoExtra(
			@RequestParam(value = "id_costo_extra", 	required = false) Integer idCostoExtra,
			@RequestParam(value = "nombre", 			required = false) String nombre,
			@RequestParam(value = "descripcion", 		required = false) String descripcion,
			@RequestParam(value = "precio", 			required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 	required = false) int idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_costo_extra");

		CostoExtra costoExtra = costoExtraService.buscaCostoExtra(idCostoExtra);
		costoExtra.setNombre(nombre);
		costoExtra.setDescripcion(descripcion);
		costoExtra.setPrecio(precio);
		costoExtra.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);

		costoExtraService.modificaCostoExtra(costoExtra);

		List<CostoExtra> listaCostoExtra = costoExtraService.listaCostoExtra();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaCostoExtra", listaCostoExtra);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		costoExtra = null;
		listaTipoPrecio = null;
		listaCostoExtra = null;
		
		return "catalogo/costo_extra";
	}// modifica_costo_extra

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaCostoExtra(
			@RequestParam(value = "id_costo_extra", required = false) Integer idCostoExtra,
			Model model
		) throws IOException {
		log.info("/elimina_costo_extra");

		CostoExtra costoExtra = costoExtraService.buscaCostoExtra(idCostoExtra);
		costoExtra.setActivo(false);
		
		costoExtraService.modificaCostoExtra(costoExtra);

		List<CostoExtra> listaCostoExtra = costoExtraService.listaCostoExtra();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaCostoExtra", listaCostoExtra);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		costoExtra = null;
		listaTipoPrecio = null;
		listaCostoExtra = null;
		
		return "catalogo/costo_extra";
	}// elimina_costo_extra
	
}
