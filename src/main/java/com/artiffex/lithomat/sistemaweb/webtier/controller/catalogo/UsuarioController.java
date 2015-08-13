package com.artiffex.lithomat.sistemaweb.webtier.controller.catalogo;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private static final Logger log = Logger.getLogger(PerfilController.class);
	
	@Resource
	private UsuarioService usuarioService;
	
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaUsuario( Model model ) throws IOException {
		log.info("/lista_usuario");
		
		List<Usuario> listaUsuario = usuarioService.listaUsuario();
		model.addAttribute("listaUsuario", listaUsuario);
		listaUsuario = null;
		
		return "catalogo/usuario";
	} // listaUsuario
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaUsuario(
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "ap_paterno", 	required = false) String apPaterno,
			@RequestParam(value = "ap_materno", 	required = false) String apMaterno,
			@RequestParam(value = "usuario", 		required = false) String usuario,
			@RequestParam(value = "contrasenia", 	required = false) String contrasenia,
			Model model
		) throws IOException {
		log.info("/alta_usuario");
		
		Usuario usr = new Usuario();
		usr.setNombre(nombre);
		usr.setApPaterno(apPaterno);
		usr.setApMaterno(apMaterno);
		usr.setUsuario(usuario);
		usr.setContrasenia(contrasenia);
		usr.setActivo(true);
		
		usuarioService.creaUsuario(usr);
		
		List<Usuario> listaUsuario = usuarioService.listaUsuario();
		model.addAttribute("listaUsuario", listaUsuario);
		
		usr				= null;
		listaUsuario 	= null;
		
		return "catalogo/usuario";
	} // altaUsuario
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaUsuario(
			@RequestParam(value = "id_usuario", 	required = false) Integer idUsuario,
			@RequestParam(value = "nombre", 		required = false) String nombre,
			@RequestParam(value = "ap_paterno", 	required = false) String apPaterno,
			@RequestParam(value = "ap_materno", 	required = false) String apMaterno,
			@RequestParam(value = "usuario", 		required = false) String usuario,
			@RequestParam(value = "contrasenia", 	required = false) String contrasenia,
			Model model
		) throws IOException {
		log.info("/modifica_usuario");
		
		Usuario usr = usuarioService.buscaUsuario(idUsuario);
		usr.setNombre(nombre);
		usr.setApPaterno(apPaterno);
		usr.setApMaterno(apMaterno);
		usr.setUsuario(usuario);
		usr.setContrasenia(contrasenia);
		
		usuarioService.modificaUsuario(usr);
		
		List<Usuario> listaUsuario = usuarioService.listaUsuario();
		model.addAttribute("listaUsuario", listaUsuario);
		
		usr				= null;
		listaUsuario 	= null;
		
		return "catalogo/usuario";
	} // modificaUsuario
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaUsuario(
			@RequestParam(value = "id_usuario", required = false) Integer idUsuario,
			Model model
		) throws IOException {
		log.info("/elimina_usuario");
		
		Usuario usr = usuarioService.buscaUsuario(idUsuario);
		usr.setActivo(false);
		
		usuarioService.modificaUsuario(usr);
		
		List<Usuario> listaUsuario = usuarioService.listaUsuario();
		model.addAttribute("listaUsuario", listaUsuario);
		
		usr				= null;
		listaUsuario 	= null;
		
		return "catalogo/usuario";
	} // eliminaUsuario

}
