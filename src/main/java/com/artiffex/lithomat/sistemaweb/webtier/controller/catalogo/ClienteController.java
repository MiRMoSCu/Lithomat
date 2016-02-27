package com.artiffex.lithomat.sistemaweb.webtier.controller.catalogo;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.ClienteDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoCliente;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaCliente;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	private static final Logger log = Logger.getLogger(ClienteController.class);
	
	@Resource
	private ClienteService clienteService;
	@Resource
	private TipoClienteService tipoClienteService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaCliente( Locale locale, Model model ) throws IOException {
		log.info("/lista_cliente");
		
		// configuracion de controles de la pagina (select)
		List<ComboSelect> listaComboSelect = tipoClienteService.listaComboSelect();
		model.addAttribute("listaTipoCliente", listaComboSelect);
		listaComboSelect = null;
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 10;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);
		
		ParametrosBusquedaCliente parametros = new ParametrosBusquedaCliente();
		parametros.setBusquedaPorTipoCliente(false);
		parametros.setBusquedaPorNombreMoral(false);
		parametros.setBusquedaPorNombreRepresentante(false);
		parametros.setBusquedaPorCodigoPostal(false);
		parametros.setBusquedaPorRfc(false);
		parametros.setIdTipoCliente(0);
		parametros.setNombreMoral(null);
		parametros.setNombreRepresentante(null);
		parametros.setCodigoPostal(null);
		parametros.setRfc(null);
		
		// numero total de registros // BUSQUEDA DEFAULT
		int numeroTotalRegistros = clienteService.numeroRegistrosPorCriterioBusqueda( parametros );
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);

		// lista de registros // BUSQUEDA DEFAULT
		List<ClienteDTO> listaCliente = clienteService.listaPorCriterioBusquedaPorNumeroPagina( parametros, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaCliente", listaCliente);
		listaCliente = null;
		
		return "catalogo/cliente";
	}// lista_cliente
		
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/lista_por_pagina_por_parametros", method = RequestMethod.POST)
	@ResponseBody
	public String buscaClientesPorParametros(
			@RequestParam(value = "numero_pagina", 							required = false) Integer numeroPagina,
			@RequestParam(value = "numero_registros_por_pagina", 			required = false) Integer numeroRegistrosPorPagina,
			@RequestParam(value = "chkbx_busca_por_nombre_moral", 			required = false) boolean busquedaPorNombreMoral,
			@RequestParam(value = "chkbx_busca_por_rfc", 					required = false) boolean busquedaPorRfc,
			@RequestParam(value = "chkbx_busca_por_tipo_cliente", 			required = false) boolean busquedaPorTipoCliente,
			@RequestParam(value = "chkbx_busca_por_nombre_representante", 	required = false) boolean busquedaPorNombreRepresentante,
			@RequestParam(value = "chkbx_busca_por_codigo_postal", 			required = false) boolean busquedaPorCodigoPostal,
			@RequestParam(value = "nombre_moral", 							required = false) String nombreMoral,
			@RequestParam(value = "rfc", 									required = false) String rfc,
			@RequestParam(value = "id_tipo_cliente", 						required = false) Integer idTipoCliente,
			@RequestParam(value = "nombre_representante", 					required = false) String nombreRepresentante,
			@RequestParam(value = "codigo_postal", 							required = false) String codigoPostal
		) {
		log.info("/catalogo/lista_por_pagina");
		
		StringBuilder sb = new StringBuilder();
		Gson gson = new Gson();
		
		ParametrosBusquedaCliente parametros = new ParametrosBusquedaCliente();
		parametros.setBusquedaPorTipoCliente(busquedaPorTipoCliente);
		parametros.setBusquedaPorNombreMoral(busquedaPorNombreMoral);
		parametros.setBusquedaPorNombreRepresentante(busquedaPorNombreRepresentante);
		parametros.setBusquedaPorCodigoPostal(busquedaPorCodigoPostal);
		parametros.setBusquedaPorRfc(busquedaPorRfc);
		parametros.setIdTipoCliente(idTipoCliente);
		parametros.setNombreMoral(nombreMoral);
		parametros.setNombreRepresentante(nombreRepresentante);
		parametros.setCodigoPostal(codigoPostal);
		parametros.setRfc(rfc);
		
		int numeroTotalRegistros = clienteService.numeroRegistrosPorCriterioBusqueda(parametros);
		
		List<ClienteDTO> listaClientes = clienteService.listaPorCriterioBusquedaPorNumeroPagina(parametros, numeroPagina, numeroRegistrosPorPagina);
		
		sb.append("{");
		sb.append("\"numeroTotalRegistros\":");
		sb.append(numeroTotalRegistros);
		sb.append(",");
		sb.append("\"listaClientes\":");
		sb.append(gson.toJson(listaClientes));
		sb.append("}");

		listaClientes 	= null;
		gson 			= null;
		
		return sb.toString();		
	}

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaCliente(
			@RequestParam(value = "id_tipo_cliente", 		required = false) Integer idTipoCliente,
			@RequestParam(value = "nombre_moral", 			required = false) String nombreMoral,
			@RequestParam(value = "nombre_representante", 	required = false) String nombreRepresentante,
			@RequestParam(value = "puesto", 				required = false) String puesto,
			@RequestParam(value = "calle", 					required = false) String calle,
			@RequestParam(value = "num_exterior", 			required = false) String numExterior,
			@RequestParam(value = "num_interior", 			required = false) String numInterior,
			@RequestParam(value = "colonia", 				required = false) String colonia,
			@RequestParam(value = "delegacion_municipio", 	required = false) String delegacionMunicipio,
			@RequestParam(value = "estado", 				required = false) String estado,
			@RequestParam(value = "codigo_postal", 			required = false) String codigoPostal,
			@RequestParam(value = "pais", 					required = false) String pais,
			@RequestParam(value = "rfc", 					required = false) String rfc,
			@RequestParam(value = "telefono_particular",	required = false) String telefonoParticular,
			@RequestParam(value = "telefono_movil", 		required = false) String telefonoMovil,
			@RequestParam(value = "email", 					required = false) String email,
			@RequestParam(value = "observaciones", 			required = false) String observaciones,
			Model model
		) throws IOException {
		log.info("/alta_cliente");

		Cliente cliente = new Cliente();
			TipoCliente tipoCliente = new TipoCliente();
			tipoCliente.setIdTipoCliente(idTipoCliente);
		cliente.setTipoCliente(tipoCliente);
		cliente.setNombreMoral(nombreMoral);
		cliente.setNombreRepresentante(nombreRepresentante);
		cliente.setPuesto(puesto);
		cliente.setCalle(calle);
		cliente.setNumExterior(numExterior);
		cliente.setNumInterior(numInterior);
		cliente.setColonia(colonia);
		cliente.setDelegacionMunicipio(delegacionMunicipio);
		cliente.setEstado(estado);
		cliente.setCodigoPostal(codigoPostal);
		cliente.setPais(pais);
		cliente.setRfc(rfc);
		cliente.setTelefonoParticular(telefonoParticular);
		cliente.setTelefonoMovil(telefonoMovil);
		cliente.setEmail(email);
		cliente.setObservaciones(observaciones);
		cliente.setActivo(true);

		clienteService.creaCliente(cliente);

		// configuracion de controles de la pagina (select)
		List<ComboSelect> listaComboSelect = tipoClienteService.listaComboSelect();
		model.addAttribute("listaTipoCliente", listaComboSelect);
		listaComboSelect = null;
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 10;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);
		
		ParametrosBusquedaCliente parametros = new ParametrosBusquedaCliente();
		parametros.setBusquedaPorTipoCliente(false);
		parametros.setBusquedaPorNombreMoral(false);
		parametros.setBusquedaPorNombreRepresentante(false);
		parametros.setBusquedaPorCodigoPostal(false);
		parametros.setBusquedaPorRfc(false);
		parametros.setIdTipoCliente(0);
		parametros.setNombreMoral(null);
		parametros.setNombreRepresentante(null);
		parametros.setCodigoPostal(null);
		parametros.setRfc(null);
		
		// numero total de registros // BUSQUEDA DEFAULT
		int numeroTotalRegistros	= clienteService.numeroRegistrosPorCriterioBusqueda(parametros);
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);

		// lista de registros // BUSQUEDA DEFAULT
		List<ClienteDTO> listaCliente = clienteService.listaPorCriterioBusquedaPorNumeroPagina( parametros, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaCliente", listaCliente);
		listaCliente = null;
		
		return "catalogo/cliente";
	}// alta_cliente

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	@ResponseBody
	public void modificaCliente(
			@RequestParam(value = "id_cliente", 			required = false) Integer idCliente,
			@RequestParam(value = "id_tipo_cliente", 		required = false) Integer idTipoCliente,
			@RequestParam(value = "nombre_moral", 			required = false) String nombreMoral,
			@RequestParam(value = "nombre_representante", 	required = false) String nombreRepresentante,
			@RequestParam(value = "puesto", 				required = false) String puesto,
			@RequestParam(value = "calle", 					required = false) String calle,
			@RequestParam(value = "num_exterior", 			required = false) String numExterior,
			@RequestParam(value = "num_interior", 			required = false) String numInterior,
			@RequestParam(value = "colonia", 				required = false) String colonia,
			@RequestParam(value = "delegacion_municipio", 	required = false) String delegacionMunicipio,
			@RequestParam(value = "estado", 				required = false) String estado,
			@RequestParam(value = "codigo_postal", 			required = false) String codigoPostal,
			@RequestParam(value = "pais", 					required = false) String pais,
			@RequestParam(value = "rfc", 					required = false) String rfc,
			@RequestParam(value = "telefono_particular", 	required = false) String telefonoParticular,
			@RequestParam(value = "telefono_movil", 		required = false) String telefonoMovil,
			@RequestParam(value = "email", 					required = false) String email,
			@RequestParam(value = "observaciones", 			required = false) String observaciones,
			Model model
		) throws IOException {
		log.info("/modifica_cliente");
		Cliente cliente = clienteService.buscaCliente(idCliente);
			TipoCliente tipoCliente = new TipoCliente();
			tipoCliente.setIdTipoCliente(idTipoCliente);
		cliente.setTipoCliente(tipoCliente);
		cliente.setNombreMoral(nombreMoral);
		cliente.setNombreRepresentante(nombreRepresentante);
		cliente.setPuesto(puesto);
		cliente.setCalle(calle);
		cliente.setNumExterior(numExterior);
		cliente.setNumInterior(numInterior);
		cliente.setColonia(colonia);
		cliente.setDelegacionMunicipio(delegacionMunicipio);
		cliente.setEstado(estado);
		cliente.setCodigoPostal(codigoPostal);
		cliente.setPais(pais);
		cliente.setRfc(rfc);
		cliente.setTelefonoParticular(telefonoParticular);
		cliente.setTelefonoMovil(telefonoMovil);
		cliente.setEmail(email);
		cliente.setObservaciones(observaciones);
		clienteService.modificaCliente(cliente);
		tipoCliente = null;
		cliente 	= null;
	}// modifica_cliente

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR"})
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	@ResponseBody
	public void eliminaCliente(
			@RequestParam(value = "id_cliente", required = false) Integer idCliente,
			Model model
		) throws IOException {
		log.info("/elimina_cliente");
		Cliente cliente = clienteService.buscaCliente(idCliente);
		cliente.setActivo(false);
		clienteService.modificaCliente(cliente);
		cliente = null;
	}// elimina_cliente
	
	
	@RequestMapping(value = "/busca_nombre", method = RequestMethod.POST)
	@ResponseBody
	public List<ComboSelect> buscaNombreCliente(
			@RequestParam(value = "nombre_moral", required = false) String nombreMoral
		) {
		log.info("/busca_nombre_cliente");
		List<ComboSelect> list = clienteService.buscaClientePorNombre(nombreMoral);
		return list;
	} // buscaNombreCliente

	
	@RequestMapping(value = "/busca", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ClienteDTO buscaCliente(
			@RequestParam(value = "id_cliente", required = false) Integer idCliente,
			HttpServletResponse response
		) {
		log.info("/busca_cliente");
		ClienteDTO cliente = clienteService.buscaClienteDTO(idCliente);
		return cliente;
	} // busca_cliente
	
}
