package com.artiffex.lithomat.sistemaweb.webtier.controller.cotizador;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cotizador")
public class CotizadorController {
	
	private static final Logger log = Logger.getLogger(CotizadorController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String cotizador(Locale locale, Model model) {
		log.trace("/cotizador");
		return "cotizador/cotizador";
	}
	
}
