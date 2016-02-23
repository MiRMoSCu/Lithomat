package com.artiffex.lithomat.sistemaweb.webtier.controller.reporte;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.FechaPrensistaMaquinaService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/fecha_prensista_maquina")
public class FechaPrensistaMaquinaController {
	
	private static final Logger log = Logger.getLogger(FechaPrensistaMaquinaController.class);
	
	@Resource
	private FechaPrensistaMaquinaService fechaPrensistaMaquinaService;
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ventanaFechaImpresionMaquina() {
		log.info("/ventana_fecha_impresion_maquina");
		return "reporte/fecha_prensista_maquina";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/lista", method = RequestMethod.POST)
	@ResponseBody
	public String listaFechaPrensistaMaquina(
			@RequestParam(value = "", required = false) String nut
		) {
		System.out.println("entro a lista fecha prensista maquina");
		
		List<FechaPrensistaMaquinaDTO> listaFechaPrensistaMaquina = fechaPrensistaMaquinaService.listaFechaPrensistaMaquinaPorNut(nut);
		
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
