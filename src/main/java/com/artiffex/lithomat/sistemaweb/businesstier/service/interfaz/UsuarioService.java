package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;

public interface UsuarioService {
	
	boolean creaUsuario(Usuario usuario);
	
	boolean validaUsuario(Usuario usuario);
	
	boolean existeUsuario(Usuario usuario);
	
}// UsuarioService
