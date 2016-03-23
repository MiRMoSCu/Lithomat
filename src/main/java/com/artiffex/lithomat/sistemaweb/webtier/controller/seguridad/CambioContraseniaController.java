package com.artiffex.lithomat.sistemaweb.webtier.controller.seguridad;

import java.io.IOException;

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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.UsuarioService;

@Controller
@RequestMapping("/contrasenia")
public class CambioContraseniaController {
	
	private static final Logger log = Logger.getLogger(CambioContraseniaController.class);
	
	@Resource
	private UsuarioService usuarioService;
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR","ROLE_PRODUCCION","ROLE_DISENIO","ROLE_PREPRENSA","ROLE_TRANSPORTE","ROLE_PROCESO_EXTERNO","ROLE_ACABADO","ROLE_CLIENTE"})
	@RequestMapping(value = "/ventana", method = RequestMethod.GET)
	public String ventanaCambioContrasenia( Model model ) throws IOException {
		log.info("/cambio_contrasenia/ventana_cambio_contrasenia");
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = principal.toString();
		if ( principal instanceof UserDetails ) {
			username = ((UserDetails)principal).getUsername();
		}
		Usuario usuario = usuarioService.buscaUsuario(username);
		String nombreCompleto = usuario.getNombre()+ " " + usuario.getApPaterno() + " " + usuario.getApMaterno();
		model.addAttribute("nombreCompleto", nombreCompleto);
		usuario = null;
		
		return "seguridad/ventana_seguridad_cambio_contrasenia";
	}
	
	@Secured({"ROLE_ROOT","ROLE_ADMIN","ROLE_COTIZADOR","ROLE_PRODUCCION","ROLE_DISENIO","ROLE_PREPRENSA","ROLE_TRANSPORTE","ROLE_PROCESO_EXTERNO","ROLE_ACABADO","ROLE_CLIENTE"})
	@RequestMapping(value = "/cambio", method = RequestMethod.POST)
	@ResponseBody
	public boolean modificaContrasenia(
		@RequestParam(value="contrasenia", required = false) String contrasenia	
		) {
		log.info("/cambio_contrasenia_acepta");
		
		// usado por la configuracion de SpringSecurity
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = principal.toString();
		if ( principal instanceof UserDetails ) {
			username = ((UserDetails)principal).getUsername();
		}
		// busqueda de usuario
		Usuario usuario = usuarioService.buscaUsuario(username);
		usuario.setContrasenia(contrasenia);
		usuarioService.modificaUsuario(usuario);
		usuario = null;
		// actualizacion de contexto; borra informacion
		//SecurityContextHolder.clearContext();
		return true;
	}

}
