package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;

public interface UsuarioDAO {
	
	public boolean creaUsuario(Usuario u);
	
	public boolean existeUsuario(Usuario u);
	
	public boolean modificaUsuario(Usuario u);
	
	public String getRol(Usuario u);
	
	public int getLastUser();
	
	public boolean validaUsuario(Usuario u);
	
	public Error bajaUsuario(int id);
	
}
