package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.cruce;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTOGrid;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.FechaPrensistaMaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PrensistaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TurnoLaboralService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

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
	@RequestMapping(value = "/creacion/lista", method = RequestMethod.POST)
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
		List<FechaPrensistaMaquinaDTOGrid> listaFechaPrensistaMaquina = fechaPrensistaMaquinaService.listaFechaPrensistaMaquinaPorParametrosEnDTO(false, null, numeroPagina, numeroRegistrosPorPagina);
		model.addAttribute("listaFechaPrensistaMaquina",listaFechaPrensistaMaquina);
		listaFechaPrensistaMaquina = null;
		
		return "produccion/cruce/cruce_informacion";
	}
	
}
