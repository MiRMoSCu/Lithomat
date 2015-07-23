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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorPapel;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProveedorPapelService;

@Controller
@RequestMapping("/proveedor_papel")
public class ProveedorPapelController {
	
	private static final Logger log = Logger.getLogger(ProveedorPapelController.class);
	
	@Resource
	private ProveedorPapelService proveedorPapelService;

	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaProveedorPapel( Locale locale, Model model ) throws IOException {
		log.info("/lista_proveedor_papel");

		List<ProveedorPapel> listaProveedorPapel = proveedorPapelService.listaProveedorPapel();
		model.addAttribute("listaProveedorPapel", listaProveedorPapel);

		listaProveedorPapel = null;
		
		return "catalogo/proveedor_papel";
	}// lista_proveedor_papel

	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaProveedorPapel(
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
		log.info("/alta_proveedor_papel");

		ProveedorPapel proveedorPapel = new ProveedorPapel();
		proveedorPapel.setRazonSocial(razonSocial);
		proveedorPapel.setCalle(calle);
		proveedorPapel.setNumExterior(numExterior);
		proveedorPapel.setNumInterior(numInterior);
		proveedorPapel.setColonia(colonia);
		proveedorPapel.setDelegacionMunicipio(delegacionMunicipio);
		proveedorPapel.setEstado(estado);
		proveedorPapel.setCodigoPostal(codigoPostal);
		proveedorPapel.setTelefono(telefono);
		proveedorPapel.setObservaciones(observaciones);
		proveedorPapel.setActivo(true);

		proveedorPapelService.creaProveedorPapel(proveedorPapel);

		List<ProveedorPapel> listaProveedorPapel = proveedorPapelService.listaProveedorPapel();
		model.addAttribute("listaProveedorPapel", listaProveedorPapel);

		proveedorPapel = null;
		listaProveedorPapel = null;
		
		return "catalogo/proveedor_papel";
	}// alta_proveedor_papel

	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaPProveedorPapel(
			@RequestParam(value = "id_proveedor_papel", required = false) Integer idProveedorPapel,
			@RequestParam(value = "razon_social", 		required = false) String razonSocial,
			@RequestParam(value = "calle", 				required = false) String calle,
			@RequestParam(value = "num_exterior", 		required = false) String numExterior,
			@RequestParam(value = "num_interior", 		required = false) String numInterior,
			@RequestParam(value = "colonia", 			required = false) String colonia,
			@RequestParam(value = "delegacion", 		required = false) String delegacionMunicipio,
			@RequestParam(value = "estado", 			required = false) String estado,
			@RequestParam(value = "codigo_postal", 		required = false) String codigoPostal,
			@RequestParam(value = "telefono", 			required = false) String telefono,
			@RequestParam(value = "observaciones", 		required = false) String observaciones,
			Model model
		) throws IOException {
		log.info("/modifica_proveedor_papel");

		ProveedorPapel proveedorPapel = proveedorPapelService.buscaProveedorPapel(idProveedorPapel);
		proveedorPapel.setRazonSocial(razonSocial);
		proveedorPapel.setCalle(calle);
		proveedorPapel.setNumExterior(numExterior);
		proveedorPapel.setNumInterior(numInterior);
		proveedorPapel.setColonia(colonia);
		proveedorPapel.setDelegacionMunicipio(delegacionMunicipio);
		proveedorPapel.setEstado(estado);
		proveedorPapel.setCodigoPostal(codigoPostal);
		proveedorPapel.setTelefono(telefono);
		proveedorPapel.setObservaciones(observaciones);

		proveedorPapelService.modificaProveedorPapel(proveedorPapel);

		List<ProveedorPapel> listaProveedorPapel = proveedorPapelService.listaProveedorPapel();
		model.addAttribute("listaProveedorPapel", listaProveedorPapel);

		proveedorPapel = null;
		listaProveedorPapel = null;
		
		return "catalogo/proveedor_papel";
	}// modifica_proveedor_papel

	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaProveedorPapel(
			@RequestParam(value = "id_proveedor_papel", required = false) Integer idProveedorPapel,
			Model model
		) throws IOException {
		log.info("/elimina_proveedor_papel");
		
		ProveedorPapel proveedorPapel = proveedorPapelService.buscaProveedorPapel(idProveedorPapel);
		proveedorPapel.setActivo(false);

		proveedorPapelService.modificaProveedorPapel(proveedorPapel);

		List<ProveedorPapel> listaProveedorPapel = proveedorPapelService.listaProveedorPapel();
		model.addAttribute("listaProveedorPapel", listaProveedorPapel);

		proveedorPapel = null;
		listaProveedorPapel = null;
		
		return "catalogo/proveedor_papel";
	}// elimina_proveedor_papel
	
}
