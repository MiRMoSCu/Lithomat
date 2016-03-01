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

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.SemaforoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaSemaforo;

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

}
