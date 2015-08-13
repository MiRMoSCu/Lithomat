package com.artiffex.lithomat.sistemaweb.webtier.controller.catalogo;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Perfil;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

	private static final Logger log = Logger.getLogger(PerfilController.class);
	
	@Resource
	private PerfilService perfilService;
	
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaPerfil( Locale locale, Model model ) throws IOException {
		log.info("/lista_perfil");
		
		List<Perfil> listaPerfil = perfilService.listaPerfil();
		model.addAttribute("listaPerfil", listaPerfil);
		listaPerfil = null;
		
		return "catalogo/perfil";
	}
	
	@Secured("ROLE_ROOT")
	public String altaPerfil() {
		return "";
	}
	
	@Secured("ROLE_ROOT")
	public String modificaPerfil() {
		return "";
	}
	
	@Secured("ROLE_ROOT")
	public String eliminaPerfil() {
		return "";
	}
	
}
