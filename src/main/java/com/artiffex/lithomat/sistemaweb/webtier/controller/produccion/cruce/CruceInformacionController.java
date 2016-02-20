package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.cruce;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTOGrid;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.FechaPrensistaMaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PrensistaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TurnoLaboralService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cruce_informacion")
public class CruceInformacionController {
	
	private static final Logger log = Logger.getLogger(CruceInformacionController.class);
	
	@Resource
	private FechaPrensistaMaquinaService fechaPrensistaMaquinaService;
	@Resource
	private PrensistaService prensistaService;
	@Resource
	private TurnoLaboralService turnoLaboralService;
	@Resource
	private MaquinaService maquinaService;

	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/grid/lista", method = RequestMethod.POST)
	public String ventanaCruceInformacion( Model model ) {
		log.info("/ventana_cruce_informacion");
		
		// configuracion de controles de la pagina (select)
		List<ComboSelect> listaPrensista = prensistaService.listaComboSelect();
		model.addAttribute("listaPrensista",listaPrensista);
		listaPrensista = null;

		List<ComboSelect> listaTurnoLaboral = turnoLaboralService.listaComboSelect();
		model.addAttribute("listaTurnoLaboral",listaTurnoLaboral);
		listaTurnoLaboral = null;

		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		model.addAttribute("listaMaquina",listaMaquina);
		listaMaquina = null;
		
		// variables de configuracion del paginador
		int numeroRegistrosPorPagina 	= 10;
		int tamanioMaximoArreglo 		= 7;
		int numeroPagina 				= 1;
		
		model.addAttribute("numeroRegistrosPorPagina", numeroRegistrosPorPagina);
		model.addAttribute("tamanioMaximoArreglo", tamanioMaximoArreglo);
		model.addAttribute("numeroPagina", numeroPagina);
		
		// numero total de registros
		int numeroTotalRegistros = fechaPrensistaMaquinaService.obtieneNumeroFechaPrensistaMaquinaPorParametros(false, null);
		model.addAttribute("numeroTotalRegistros", numeroTotalRegistros);
		
		// Lista de registros DTO
		List<FechaPrensistaMaquinaDTOGrid> listaGridPliegos = fechaPrensistaMaquinaService.listaFechaPrensistaMaquinaPorParametrosEnDTO(false, null, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaGridPliegos",listaGridPliegos);
		listaGridPliegos = null;
		
		return "produccion/cruce/cruce_informacion";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/grid/lista_por_pagina_por_parametros", method = RequestMethod.POST)
	@ResponseBody
	public String buscaRegistrosGridPorParametros(
			@RequestParam(value = "numero_pagina", 					required = false) Integer numeroPagina,
			@RequestParam(value = "numero_registros_por_pagina", 	required = false) Integer numeroRegistrosPorPagina,
			@RequestParam(value = "chkbx_busca_por_nut", 			required = false) boolean busquedaPorNut,
			@RequestParam(value = "nut", 							required = false) String nut
		) {
		log.info("/ventana_cruce_informacion");
		
		StringBuilder sb = new StringBuilder();
		Gson gson = new Gson();
		
		int numeroTotalRegistros = fechaPrensistaMaquinaService.obtieneNumeroFechaPrensistaMaquinaPorParametros(busquedaPorNut, nut);
		
		List<FechaPrensistaMaquinaDTOGrid> listaGridPliegos = fechaPrensistaMaquinaService.listaFechaPrensistaMaquinaPorParametrosEnDTO(busquedaPorNut, nut, numeroPagina, numeroRegistrosPorPagina);
		
		sb.append("{");
		sb.append("\"numeroTotalRegistros\":");
		sb.append(numeroTotalRegistros);
		sb.append(",");
		sb.append("\"listaGridPliegos\":");
		sb.append(gson.toJson(listaGridPliegos));
		sb.append("}");
		
		listaGridPliegos 	= null;
		gson 				= null;
		
		return sb.toString();
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/grid/agrega_cruce_informacion", method = RequestMethod.POST)
	@ResponseBody
	public int agregaCruceInformacion(
			@RequestParam(value = "json", required = false) String jsonFechaPrensistaMaquina
		) {
		log.info("/agrega_cruce_informacion");
		
		// agrega registros fecha_prensista_maquina
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String usuario = principal.toString();
		if ( principal instanceof UserDetails ) {
			usuario = ((UserDetails)principal).getUsername();
		}
		principal = null;
		
		//System.out.println(jsonFechaPrensistaMaquina);
		fechaPrensistaMaquinaService.creaFechaPrensistaMaquina(jsonFechaPrensistaMaquina, usuario);
		
		return 1;
	}
	
}
