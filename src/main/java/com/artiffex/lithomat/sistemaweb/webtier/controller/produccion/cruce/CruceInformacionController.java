package com.artiffex.lithomat.sistemaweb.webtier.controller.produccion.cruce;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cruce_informacion")
public class CruceInformacionController {
	
	private static final Logger log = Logger.getLogger(CruceInformacionController.class);

	@Secured({"ROLE_ROOT","ROLE_ADMIN"})
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String ventanaCruceInformacion() {
		log.info("/ventana_cruce_informacion");
		
		return "produccion/cruce/cruce_informacion";
	}
	
}
