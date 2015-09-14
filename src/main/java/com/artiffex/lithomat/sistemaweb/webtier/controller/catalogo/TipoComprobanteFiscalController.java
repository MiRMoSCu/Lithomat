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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComprobanteFiscal;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoComprobanteFiscalService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/tipo_comprobante_fiscal")
public class TipoComprobanteFiscalController {
	
	private static final Logger log = Logger.getLogger(TipoComprobanteFiscalController.class);
	
	@Resource
	private TipoComprobanteFiscalService tipoComprobanteFiscalService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoComprobanteFiscal( Locale locale, Model model ) throws IOException {
		log.info("/lista_tipo_comprobante_fiscal");

		List<TipoComprobanteFiscal> listaTipoComprobanteFiscal = tipoComprobanteFiscalService.listaTipoComprobanteFiscal();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoComprobanteFiscal",listaTipoComprobanteFiscal);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoComprobanteFiscal = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_comprobante_fiscal";
	}// lista_tipo_comprobante_fiscal

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTipoComprobanteFiscal(
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "precio", 		required = false) float precio,
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_tipo_comprobante_fiscal");

		TipoComprobanteFiscal tipoComprobanteFiscal = new TipoComprobanteFiscal();
		tipoComprobanteFiscal.setNombre(nombre);
		tipoComprobanteFiscal.setDescripcion(descripcion);
		tipoComprobanteFiscal.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		tipoComprobanteFiscal.setTipoPrecio(tipoPrecio);
		tipoComprobanteFiscal.setActivo(true);

		tipoComprobanteFiscalService.creaTipoComprobanteFiscal(tipoComprobanteFiscal);

		List<TipoComprobanteFiscal> listaTipoComprobanteFiscal = tipoComprobanteFiscalService.listaTipoComprobanteFiscal();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoComprobanteFiscal",listaTipoComprobanteFiscal);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoComprobanteFiscal = null;
		tipoPrecio = null;
		listaTipoComprobanteFiscal = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_comprobante_fiscal";
	}// alta_tipo_comprobante_fiscal

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoComprobanteFiscal(
			@RequestParam(value = "id_tipo_comprobante_fiscal", required = false) Integer idTipoComprobanteFiscal,
			@RequestParam(value = "nombre", 					required = false) String nombre,
			@RequestParam(value = "descripcion", 				required = false) String descripcion,
			@RequestParam(value = "precio", 					required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 			required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_tipo_comprobante_fiscal");
		
		// NO SE PUEDE MODIFICAR EL NOMBRE NI PORCENTAJE DE LOS COMPROBANTES BASE:
		// 1) NOTA DE REMISION
		// 2) NOTA DE FACTURA
		TipoComprobanteFiscal tipoComprobanteFiscal = tipoComprobanteFiscalService.buscaTipoComprobanteFiscal(idTipoComprobanteFiscal);
		if( idTipoComprobanteFiscal > 0 && idTipoComprobanteFiscal < 3) { // rango VERDADERO incluyente del 1 al 2
			tipoComprobanteFiscal.setDescripcion(descripcion);
			tipoComprobanteFiscal.setPrecio(precio);
		} else {
			tipoComprobanteFiscal.setNombre(nombre);
			tipoComprobanteFiscal.setDescripcion(descripcion);
			tipoComprobanteFiscal.setPrecio(precio);
			tipoComprobanteFiscal.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);
		}
		tipoComprobanteFiscalService.modificaTipoComprobanteFiscal(tipoComprobanteFiscal);

		List<TipoComprobanteFiscal> listaTipoComprobanteFiscal = tipoComprobanteFiscalService.listaTipoComprobanteFiscal();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoComprobanteFiscal",listaTipoComprobanteFiscal);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoComprobanteFiscal = null;
		listaTipoComprobanteFiscal = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_comprobante_fiscal";
	}// modifica_tipo_comprobante_fiscal

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoComprobanteFiscal(
			@RequestParam(value = "id_tipo_comprobante_fiscal", required = false) Integer idTipoComprobanteFiscal,
			Model model
		) throws IOException {
		log.info("/elimina_tipo_comprobante_fiscal");

		// NO SE PUEDE ELIMINAR LOS COMPROBANTES BASE:
		// 1) NOTA DE REMISION
		// 2) NOTA DE FACTURA
		TipoComprobanteFiscal tipoComprobanteFiscal = tipoComprobanteFiscalService.buscaTipoComprobanteFiscal(idTipoComprobanteFiscal);
		if( idTipoComprobanteFiscal < 1 || idTipoComprobanteFiscal > 2 ) { // rango VERDADERO excluyente del 1 al 2
			tipoComprobanteFiscal.setActivo(false);
			tipoComprobanteFiscalService.modificaTipoComprobanteFiscal(tipoComprobanteFiscal);
		}

		List<TipoComprobanteFiscal> listaTipoComprobanteFiscal = tipoComprobanteFiscalService.listaTipoComprobanteFiscal();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoComprobanteFiscal",listaTipoComprobanteFiscal);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoComprobanteFiscal = null;
		listaTipoComprobanteFiscal = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_comprobante_fiscal";
	}// elimina_tipo_comprobante_fiscal
	
}
