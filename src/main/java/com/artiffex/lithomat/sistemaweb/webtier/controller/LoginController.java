package com.artiffex.lithomat.sistemaweb.webtier.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	private static final Logger log = Logger.getLogger(LoginController.class);

	
	@RequestMapping("/")
	public String welcomeFile( Model model ) {
		log.info("/");
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user",user.getUsername());
		return "menu/menu";
	}
	
	@RequestMapping("/pagina_estatica")
	public String paginaEstatica() {
		log.info("/pagina_estatica");
		return "redirect:pages/pagina_estatica.html";
	}
	
}
