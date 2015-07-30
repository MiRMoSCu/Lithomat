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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorExterno;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProveedorExternoService;

@Controller
@RequestMapping("/proveedor_externo")
public class ProveedorExternoController {
	
	private static final Logger log = Logger.getLogger(ProveedorExternoController.class);
	
	@Resource
	private ProveedorExternoService proveedorExternoService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaProveedorExterno( Locale locale, Model model ) throws IOException {
		log.info("/lista_proveedor_externo");

		System.out.println("lista proveedor externo");
		List<ProveedorExterno> listaProveedorExterno = proveedorExternoService.listaProveedorExterno();
		model.addAttribute("listaProveedorExterno", listaProveedorExterno);

		listaProveedorExterno = null;
		
		return "catalogo/proveedor_externo";
	}// lista_proveedor_externo

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaProveedorExterno(
			@RequestParam(value = "razon_social", 	required = false) String razonSocial,
			@RequestParam(value = "calle", 			required = false) String calle,
			@RequestParam(value = "num_exterior", 	required = false) String numExterior,
			@RequestParam(value = "num_interior", 	required = false) String numInterior,
			@RequestParam(value = "colonia", 		required = false) String colonia,
			@RequestParam(value = "delegacion", 	required = false) String delegacionMunicipio,
			@RequestParam(value = "estado", 		required = false) String estado,
			@RequestParam(value = "codigo_postal", 	required = false) String codigoPostal,
			@RequestParam(value = "telefono", 		required = false) String telefono,
			@RequestParam(value = "observaciones", 	required = false) String observaciones,
			Model model
		) throws IOException {
		log.info("/alta_proveedor_externo");

		ProveedorExterno proveedorExterno = new ProveedorExterno();
		proveedorExterno.setRazonSocial(razonSocial);
		proveedorExterno.setCalle(calle);
		proveedorExterno.setNumExterior(numExterior);
		proveedorExterno.setNumInterior(numInterior);
		proveedorExterno.setColonia(colonia);
		proveedorExterno.setDelegacionMunicipio(delegacionMunicipio);
		proveedorExterno.setEstado(estado);
		proveedorExterno.setCodigoPostal(codigoPostal);
		proveedorExterno.setTelefono(telefono);
		proveedorExterno.setObservaciones(observaciones);
		proveedorExterno.setActivo(true);

		proveedorExternoService.creaProveedorExterno(proveedorExterno);

		List<ProveedorExterno> listaProveedorExterno = proveedorExternoService.listaProveedorExterno();
		model.addAttribute("listaProveedorExterno", listaProveedorExterno);

		proveedorExterno = null;
		listaProveedorExterno = null;
		
		return "catalogo/proveedor_externo";
	}// alta_proveedor_externo

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaProveedorExterno(
			@RequestParam(value = "id_proveedor_externo", 	required = false) Integer idProveedorExterno,
			@RequestParam(value = "razon_social", 			required = false) String razonSocial,
			@RequestParam(value = "calle", 					required = false) String calle,
			@RequestParam(value = "num_exterior", 			required = false) String numExterior,
			@RequestParam(value = "num_interior", 			required = false) String numInterior,
			@RequestParam(value = "colonia", 				required = false) String colonia,
			@RequestParam(value = "delegacion", 			required = false) String delegacionMunicipio,
			@RequestParam(value = "estado", 				required = false) String estado,
			@RequestParam(value = "codigo_postal", 			required = false) String codigoPostal,
			@RequestParam(value = "telefono", 				required = false) String telefono,
			@RequestParam(value = "observaciones", 			required = false) String observaciones,
			Model model
		) throws IOException {
		log.info("/modifica_proveedor_externo");

		ProveedorExterno proveedorExterno = proveedorExternoService.buscaProveedorExterno(idProveedorExterno);
		proveedorExterno.setRazonSocial(razonSocial);
		proveedorExterno.setCalle(calle);
		proveedorExterno.setNumExterior(numExterior);
		proveedorExterno.setNumInterior(numInterior);
		proveedorExterno.setColonia(colonia);
		proveedorExterno.setDelegacionMunicipio(delegacionMunicipio);
		proveedorExterno.setEstado(estado);
		proveedorExterno.setCodigoPostal(codigoPostal);
		proveedorExterno.setTelefono(telefono);
		proveedorExterno.setObservaciones(observaciones);

		proveedorExternoService.modificaProveedorExterno(proveedorExterno);

		List<ProveedorExterno> listaProveedorExterno = proveedorExternoService.listaProveedorExterno();
		model.addAttribute("listaProveedorExterno", listaProveedorExterno);

		proveedorExterno = null;
		listaProveedorExterno = null;
		
		return "catalogo/proveedor_externo";
	}// modifica_proveedor_externo

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaProveedorExterno(
			@RequestParam(value = "id_proveedor_externo", required = false) Integer idProveedorExterno,
			Model model
		) throws IOException {
		log.info("/elimina_proveedor_externo");
		
		ProveedorExterno proveedorExterno = proveedorExternoService.buscaProveedorExterno(idProveedorExterno);
		proveedorExterno.setActivo(false);

		proveedorExternoService.modificaProveedorExterno(proveedorExterno);

		List<ProveedorExterno> listaProveedorExterno = proveedorExternoService.listaProveedorExterno();
		model.addAttribute("listaProveedorExterno", listaProveedorExterno);

		proveedorExterno = null;
		listaProveedorExterno = null;
		
		return "catalogo/proveedor_externo";
	}// elimina_proveedor_externo
	
}
