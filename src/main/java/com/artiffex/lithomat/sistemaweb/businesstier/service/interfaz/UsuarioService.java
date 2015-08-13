package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface UsuarioService {
	
	public void creaUsuario(Usuario usuario);
	
	public Usuario buscaUsuario(int idUsuario);
	
	public void modificaUsuario(Usuario usuario);
	
	public List<Usuario> listaUsuario();
	
	public List<ComboSelect> listaComboSelect();
	
}// UsuarioService
