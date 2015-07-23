package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.UsuarioService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.UsuarioDAO;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Resource
	private UsuarioDAO usuarioDAO;

	/*
	 * @Override public boolean creaUsuario(Usuario usuario) { boolean existe =
	 * false; existe = usuarioDAO.creaUsuario(usuario); return existe; }
	 */

	public boolean validaUsuario(Usuario usuario) {
		boolean existe = false;
		existe = usuarioDAO.validaUsuario(usuario);
		return existe;
	}

	public boolean existeUsuario(Usuario usuario) {
		boolean existe = false;
		existe = usuarioDAO.existeUsuario(usuario);
		return existe;
	}

	public boolean creaUsuario(Usuario usuario) {
		return false;
	}
}// UsuarioServiceImpl
