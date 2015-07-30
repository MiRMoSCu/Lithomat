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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoCliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/tipo_cliente")
public class TipoClienteController {
	
	private static final Logger log = Logger.getLogger(TipoClienteController.class);
	
	@Resource
	private TipoClienteService tipoClienteService;
	@Resource
	private TipoPrecioService tipoPrecioService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaTipoCliente( Locale locale, Model model ) throws IOException {
		log.info("/lista_tipo_cliente");

		List<TipoCliente> listaTipoCliente = tipoClienteService.listaTipoCliente();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoCliente", listaTipoCliente);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoCliente = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_cliente";
	}// lista_tipo_cliente

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaTipoCliente(
			@RequestParam(value = "clave", 			required = false) String clave,
			@RequestParam(value = "descripcion", 	required = false) String descripcion,
			@RequestParam(value = "precio", 		required = false) float precio,
			@RequestParam(value = "id_tipo_precio", required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/alta_tipo_cliente");

		TipoCliente tipoCliente = new TipoCliente();
		tipoCliente.setClave(clave);
		tipoCliente.setDescripcion(descripcion);
		tipoCliente.setPrecio(precio);
			TipoPrecio tipoPrecio = new TipoPrecio();
			tipoPrecio.setIdTipoPrecio(idTipoPrecio);
		tipoCliente.setTipoPrecio(tipoPrecio);
		tipoCliente.setActivo(true);

		tipoClienteService.creaTipoCliente(tipoCliente);

		List<TipoCliente> listaTipoCliente = tipoClienteService.listaTipoCliente();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoCliente", listaTipoCliente);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoCliente = null;
		tipoPrecio = null;
		listaTipoCliente = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_cliente";
	}// alta_tipo_cliente

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaTipoCliente(
			@RequestParam(value = "id_tipo_cliente", 	required = false) Integer idTipoCliente,
			@RequestParam(value = "clave", 				required = false) String clave,
			@RequestParam(value = "descripcion", 		required = false) String descripcion,
			@RequestParam(value = "precio", 			required = false) float precio,
			@RequestParam(value = "id_tipo_precio", 	required = false) Integer idTipoPrecio,
			Model model
		) throws IOException {
		log.info("/modifica_tipo_cliente");

		TipoCliente tipoCliente = tipoClienteService.buscaTipoCliente(idTipoCliente);
		tipoCliente.setClave(clave);
		tipoCliente.setDescripcion(descripcion);
		tipoCliente.setPrecio(precio);
		tipoCliente.getTipoPrecio().setIdTipoPrecio(idTipoPrecio);
		
		tipoClienteService.modificaTipoCliente(tipoCliente);

		List<TipoCliente> listaTipoCliente = tipoClienteService.listaTipoCliente();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoCliente", listaTipoCliente);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		tipoCliente = null;
		listaTipoCliente = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_cliente";
	}// modifica_tipo_cliente

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaTipoCliente(
			@RequestParam(value = "id_tipo_cliente", required = false) Integer idTipoCliente,
			Model model
		) throws IOException {
		log.info("/elimina_tipo_cliente");
		
		TipoCliente tipoCliente = tipoClienteService.buscaTipoCliente(idTipoCliente);
		tipoCliente.setActivo(false);

		tipoClienteService.modificaTipoCliente(tipoCliente);

		List<TipoCliente> listaTipoCliente = tipoClienteService.listaTipoCliente();
		List<ComboSelect> listaTipoPrecio = tipoPrecioService.listaComboSelect();
		model.addAttribute("listaTipoCliente", listaTipoCliente);
		model.addAttribute("listaTipoPrecio", listaTipoPrecio);

		listaTipoCliente = null;
		listaTipoPrecio = null;
		
		return "catalogo/tipo_cliente";
	}// elimina_tipo_cliente
	
}
