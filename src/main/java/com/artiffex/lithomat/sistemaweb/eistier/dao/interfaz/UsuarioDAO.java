package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;

public interface UsuarioDAO {
	
	public int crea(Usuario usuario);
	
	public Usuario busca(int idUsuario);
	
	public void modifica(Usuario usuario);
	
	public List<Usuario> lista();
	
}
