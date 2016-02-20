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

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Perfil;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.PerfilXUsuario;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PerfilService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PerfilXUsuarioService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.UsuarioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

@Controller
@RequestMapping("/perfil_x_usuario")
public class PerfilXUsuarioController {
	
	private static final Logger log = Logger.getLogger(PerfilXUsuarioController.class);
	
	@Resource
	private PerfilXUsuarioService perfilXUsuarioService;
	@Resource
	private UsuarioService usuarioService;
	@Resource
	private PerfilService perfilService;
	
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/lista", method = RequestMethod.POST)
	public String listaPerfilXUsuario( Model model ) throws IOException {
		log.info("/lista_perfil_x_usuario");
		
		List<PerfilXUsuario> listaPerfilXUsuario = perfilXUsuarioService.listaPerfilXUsuario();
		List<ComboSelect> listaUsuario = usuarioService.listaComboSelect();
		List<ComboSelect> listaPerfil = perfilService.listaComboSelect();
		model.addAttribute("listaPerfilXUsuario", listaPerfilXUsuario);
		model.addAttribute("listaUsuario", listaUsuario);
		model.addAttribute("listaPerfil", listaPerfil);
		listaPerfilXUsuario = null;
		listaUsuario		= null;
		listaPerfil			= null;
		
		return "catalogo/perfil_x_usuario";
	}
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/alta", method = RequestMethod.POST)
	public String altaPerfilXUsuario(
			@RequestParam(value = "id_usuario", required = false) Integer idUsuario,
			@RequestParam(value = "id_perfil", 	required = false) Integer idPerfil,
			Model model 
		) throws IOException {
		log.info("/alta_perfil_x_usuario");
		
		// NO PUEDEN EXISTIR USUARIOS CON VARIOS PERFILES
		// verifica que no exista el registro, entonces crea; si existe, entonces actualiza
		PerfilXUsuario perfilXUsuario = perfilXUsuarioService.buscaPerfilXUsuarioPorUsuario(idUsuario);
		if( perfilXUsuario == null ) {
			// crea
			perfilXUsuario = new PerfilXUsuario();
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(idUsuario);
			perfilXUsuario.setUsuario(usuario);
				Perfil perfil = new Perfil();
				perfil.setIdPerfil(idPerfil);
			perfilXUsuario.setPerfil(perfil);
			perfilXUsuario.setActivo(true);
			
			perfilXUsuarioService.creaPerfilXUsuario(perfilXUsuario);
			
			perfilXUsuario 	= null;
			usuario			= null;
			perfil			= null;
		} else {
			// actualiza
			perfilXUsuario.getPerfil().setIdPerfil(idPerfil);
			
			perfilXUsuarioService.modificaPerfilXUsuario(perfilXUsuario);
		}
		
		
		List<PerfilXUsuario> listaPerfilXUsuario = perfilXUsuarioService.listaPerfilXUsuario();
		List<ComboSelect> listaUsuario = usuarioService.listaComboSelect();
		List<ComboSelect> listaPerfil = perfilService.listaComboSelect();
		model.addAttribute("listaPerfilXUsuario", listaPerfilXUsuario);
		model.addAttribute("listaUsuario", listaUsuario);
		model.addAttribute("listaPerfil", listaPerfil);
		perfilXUsuario		= null;
		listaPerfilXUsuario = null;
		listaUsuario		= null;
		listaPerfil			= null;
		
		return "catalogo/perfil_x_usuario";
	}
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/modifica", method = RequestMethod.POST)
	public String modificaPerfilXUsuario(
			@RequestParam(value = "id_perfil_x_usuario", 	required = false) Integer idPerfilXUsuario,
			@RequestParam(value = "id_usuario", 			required = false) Integer idUsuario,
			@RequestParam(value = "id_perfil", 				required = false) Integer idPerfil,
			Model model 
		) throws IOException {
		log.info("/modifica_perfil_x_usuario");
		
		PerfilXUsuario perfilXUsuario = perfilXUsuarioService.buscaPerfilXUsuario(idPerfilXUsuario);
		//System.out.println("idPerfilXUsuario:" + idPerfilXUsuario);
		//System.out.println("idUsuario:" + idUsuario);
		//System.out.println("idPerfil:" + idPerfil);
		perfilXUsuario.getPerfil().setIdPerfil(idPerfil);
		
		perfilXUsuarioService.modificaPerfilXUsuario(perfilXUsuario);
		
		List<PerfilXUsuario> listaPerfilXUsuario = perfilXUsuarioService.listaPerfilXUsuario();
		List<ComboSelect> listaUsuario = usuarioService.listaComboSelect();
		List<ComboSelect> listaPerfil = perfilService.listaComboSelect();
		model.addAttribute("listaPerfilXUsuario", listaPerfilXUsuario);
		model.addAttribute("listaUsuario", listaUsuario);
		model.addAttribute("listaPerfil", listaPerfil);
		perfilXUsuario		= null;
		listaPerfilXUsuario = null;
		listaUsuario		= null;
		listaPerfil			= null;
		
		return "catalogo/perfil_x_usuario";
	}
	
	@Secured("ROLE_ROOT")
	@RequestMapping(value = "/catalogo/elimina", method = RequestMethod.POST)
	public String eliminaPerfilXUsuario( 
			@RequestParam(value = "id_perfil_x_usuario", required = false) Integer idPerfilXUsuario,
			Model model 
		) throws IOException {
		log.info("/elimina_perfil_x_usuario");
		
		PerfilXUsuario perfilXUsuario = perfilXUsuarioService.buscaPerfilXUsuario(idPerfilXUsuario);
		perfilXUsuario.setActivo(false);
		
		perfilXUsuarioService.modificaPerfilXUsuario(perfilXUsuario);
		
		List<PerfilXUsuario> listaPerfilXUsuario = perfilXUsuarioService.listaPerfilXUsuario();
		List<ComboSelect> listaUsuario = usuarioService.listaComboSelect();
		List<ComboSelect> listaPerfil = perfilService.listaComboSelect();
		model.addAttribute("listaPerfilXUsuario", listaPerfilXUsuario);
		model.addAttribute("listaUsuario", listaUsuario);
		model.addAttribute("listaPerfil", listaPerfil);
		perfilXUsuario		= null;
		listaPerfilXUsuario = null;
		listaUsuario		= null;
		listaPerfil			= null;
		
		return "catalogo/perfil_x_usuario";
	}

}
