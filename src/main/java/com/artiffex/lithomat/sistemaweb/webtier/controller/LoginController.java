package com.artiffex.lithomat.sistemaweb.webtier.controller;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;

@Controller
public class LoginController {
	
	private static final Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(
			@RequestParam(value = "usuario", 		required = false) String usuario,
			@RequestParam(value = "contrasenia", 	required = false) String contrasenia,
			Model model
		) throws IOException {
		log.info("/login");

		/*
		 * VALIDAR: 1) existe usuario. 2) la contrasenia es correcta.
		 */

		Usuario u = new Usuario();
		u.setUsuario(usuario);
		u.setContrasenia(contrasenia);

		boolean ok = false;

		// ok = usuarioService.existeUsuario(u);
		ok = true;
		System.out.println("*loggeado?: " + ok);

		if (ok) {

		} else {
			model.addAttribute("error", "Error.");
		}

		HashMap<Boolean, String> hmPagina = new HashMap<Boolean, String>();
		hmPagina.put(false, "login");
		hmPagina.put(true, "menu/menu");

		String pagina = "";
		pagina = hmPagina.get(ok);
		System.out.println("***pagina: " + pagina);

		u = null;
		return pagina;
	} // login

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu() {
		return "menu/menu";
	}
	
}
