package com.artiffex.lithomat.sistemaweb.webtier.controller.reporte;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.FechaPrensistaMaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PrensistaService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaFechaPrensistaMaquina;
import com.google.gson.Gson;

@Controller
@RequestMapping("/fecha_prensista_maquina")
public class FechaPrensistaMaquinaController {
	
	private static final Logger log = Logger.getLogger(FechaPrensistaMaquinaController.class);
	
	@Resource
	private FechaPrensistaMaquinaService fechaPrensistaMaquinaService;
	@Resource
	private PrensistaService prensistaService;
	@Resource
	private MaquinaService maquinaService;
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ventanaFechaImpresionMaquina( Model model ) {
		log.info("/ventana_fecha_impresion_maquina");
		
		// prensista
		List<ComboSelect> listaPrensista  = prensistaService.listaComboSelect();
		model.addAttribute("listaPrensista", listaPrensista);
		listaPrensista = null;
		
		// maquina
		List<ComboSelect> listaMaquina = maquinaService.listaComboSelect();
		model.addAttribute("listaMaquina", listaMaquina);
		listaMaquina = null;
		
		return "reporte/fecha_prensista_maquina";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/lista", method = RequestMethod.POST)
	@ResponseBody
	public String listaFechaPrensistaMaquina(
			@RequestParam(value = "chkbx_busca_por_nut", 		required = false) boolean busquedaPorNut,
			@RequestParam(value = "chkbx_busca_por_fecha", 		required = false) boolean busquedaPorFecha,
			@RequestParam(value = "chkbx_busca_por_prensista", 	required = false) boolean busquedaPorPrensista,
			@RequestParam(value = "chkbx_busca_por_maquina", 	required = false) boolean busquedaPorMaquina,
			@RequestParam(value = "nut", 						required = false) String nut,
			@RequestParam(value = "fecha_busqueda_inicio", 		required = false) String fechaBusquedaInicio,
			@RequestParam(value = "fecha_busqueda_fin", 		required = false) String fechaBusquedaFin,
			@RequestParam(value = "id_prensista", 				required = false) Integer idPrensista,
			@RequestParam(value = "id_maquina", 				required = false) Integer idMaquina
		) {
		log.info("/lista_fecha_impresion_maquina");
		
		ParametrosBusquedaFechaPrensistaMaquina parametros = new ParametrosBusquedaFechaPrensistaMaquina();
		parametros.setBusquedaPorNut(busquedaPorNut);
		parametros.setBusquedaPorFecha(busquedaPorFecha);
		parametros.setBusquedaPorPrensista(busquedaPorPrensista);
		parametros.setBusquedaPorMaquina(busquedaPorMaquina);
		parametros.setNut(nut);
		parametros.setFechaBusquedaInicio(fechaBusquedaInicio);
		parametros.setFechaBusquedaFin(fechaBusquedaFin);
		parametros.setIdPrensista(idPrensista);
		parametros.setIdMaquina(idMaquina);
		
		List<FechaPrensistaMaquinaDTO> listaFechaPrensistaMaquina = fechaPrensistaMaquinaService.listaFechaPrensistaMaquinaPorConsulta(parametros);
		
		Gson gson = new Gson();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"listaFechaPrensistaMaquina\":");
		sb.append(gson.toJson(listaFechaPrensistaMaquina));
		sb.append("}");
		gson = null;
		
		return sb.toString();
	}

}
