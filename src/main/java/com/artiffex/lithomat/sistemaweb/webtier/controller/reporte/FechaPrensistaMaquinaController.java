package com.artiffex.lithomat.sistemaweb.webtier.controller.reporte;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/fecha_prensista_maquina")
public class FechaPrensistaMaquinaController {
	
	private static final Logger log = Logger.getLogger(FechaPrensistaMaquinaController.class);
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String ventanaFechaImpresionMaquina() {
		log.info("/ventana_fecha_impresion_maquina");
		
		return "reporte/fecha_prensista_maquina";
	}
	
	

}
