package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.semaforo;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.SemaforoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaSemaforo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/semaforo")
public class SemaforoController {
	
	private static final Logger log = Logger.getLogger(SemaforoController.class);
	
	@Resource
	private SemaforoService semaforoService;
	
	@Secured({"ROLE_DISENIO","ROLE_PREPRENSA","ROLE_TRANSPORTE","ROLE_PROCESO_EXTERNO","ROLE_ACABADO","ROLE_CLIENTE"})
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String semaforo(Model model) {
		log.info("/semaforo");
		
		ParametrosBusquedaSemaforo parametros = new ParametrosBusquedaSemaforo();
		// determina el estatus que puede ser visible segun usuario
		SecurityContext context = SecurityContextHolder.getContext();
		if ( context != null ) {
			Authentication authentication = context.getAuthentication();
			if ( authentication != null ) {
				//System.out.println( authentication.getName() );
				for ( GrantedAuthority authority : authentication.getAuthorities() ) { 
					// spring permite que usuario pueda tener varios roles
					// EL SISTEMA DEBE REVISAR QUE SOLO SE TENGA UN ROL POR UN USUARIO
					parametros.setRole( authority.getAuthority() );
				}
			}
		}
		parametros.setBusquedaPorNut(false);
		parametros.setBusquedaPorNombreOrdenProduccion(false);
		parametros.setBusquedaPorDescripcionOrdenProduccion(false);
		parametros.setBusquedaPorNombreMoral(false);
		parametros.setNut("");
		parametros.setNombreOrdenProduccion("");
		parametros.setDescripcionOrdenProduccion("");
		parametros.setNombreMoral("");
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 3;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;

		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);

		// numero total de registros
		int numeroTotalRegistros = semaforoService.numeroRegistrosPorCriterioBusqueda(parametros);
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);
		
		List<VisualizadorDTO> listaOrdenesProduccion = semaforoService.listaPorCriterioBusquedaPorNumeroPagina(parametros, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaOrdenesProduccion", listaOrdenesProduccion);
		listaOrdenesProduccion = null;
		
		parametros = null;
		
		return "produccion/semaforo/visualizador_semaforo";
	}
	
	@Secured({"ROLE_DISENIO","ROLE_PREPRENSA","ROLE_TRANSPORTE","ROLE_PROCESO_EXTERNO","ROLE_ACABADO","ROLE_CLIENTE"})
	@RequestMapping(value = "/busca_ordenes_produccion", method = RequestMethod.POST)
	@ResponseBody
	public String buscaOrdenesProduccion(
			@RequestParam(value = "numero_pagina", 					required = false) Integer numeroPagina,
			@RequestParam(value = "numero_registros_por_pagina", 	required = false) Integer numeroRegistrosPorPagina,
			@RequestParam(value = "chkbx_busca_por_nut", 			required = false) boolean busquedaPorNut,
			@RequestParam(value = "chkbx_busca_por_nombre_op", 		required = false) boolean busquedaPorNombreOrdenProduccion,
			@RequestParam(value = "chkbx_busca_por_descripcion", 	required = false) boolean busquedaPorDescripcionOrdenProduccion,
			@RequestParam(value = "chkbx_busca_por_nombre_moral", 	required = false) boolean busquedaPorNombreMoral,
			@RequestParam(value = "nut", 							required = false) String nut,
			@RequestParam(value = "nombre", 						required = false) String nombreOrdenProduccion,
			@RequestParam(value = "descripcion", 					required = false) String descripcionOrdenProduccion,
			@RequestParam(value = "nombre_moral", 					required = false) String nombreMoral
		) {
		log.info("/semaforo_busca_ordenes_produccion");
		
		ParametrosBusquedaSemaforo parametros = new ParametrosBusquedaSemaforo();
		// determina el estatus que puede ser visible segun usuario
		SecurityContext context = SecurityContextHolder.getContext();
		if ( context != null ) {
			Authentication authentication = context.getAuthentication();
			if ( authentication != null ) {
				//System.out.println( authentication.getName() );
				for ( GrantedAuthority authority : authentication.getAuthorities() ) { 
					// spring permite que usuario pueda tener varios roles
					// EL SISTEMA DEBE REVISAR QUE SOLO SE TENGA UN ROL POR UN USUARIO
					parametros.setRole( authority.getAuthority() );
				}
			}
		}
		parametros.setBusquedaPorNut(busquedaPorNut);
		parametros.setBusquedaPorNombreOrdenProduccion(busquedaPorNombreOrdenProduccion);
		parametros.setBusquedaPorDescripcionOrdenProduccion(busquedaPorDescripcionOrdenProduccion);
		parametros.setBusquedaPorNombreMoral(busquedaPorNombreMoral);
		parametros.setNut(nut);
		parametros.setNombreOrdenProduccion(nombreOrdenProduccion);
		parametros.setDescripcionOrdenProduccion(descripcionOrdenProduccion);
		parametros.setNombreMoral(nombreMoral);
		
		int numeroTotalRegistros = semaforoService.numeroRegistrosPorCriterioBusqueda(parametros);
		List<VisualizadorDTO> listaOrdenesProduccion = semaforoService.listaPorCriterioBusquedaPorNumeroPagina(parametros, numeroPagina, numeroRegistrosPorPagina);
		
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"numeroTotalRegistros\":");
		sb.append(numeroTotalRegistros);
		sb.append(",");
		sb.append("\"listaOrdenesProduccion\":");
		sb.append(gson.toJson(listaOrdenesProduccion));
		sb.append("}");
		
		gson 					= null;
		listaOrdenesProduccion 	= null;
		parametros 				= null;
		
		return sb.toString();
	}

}
