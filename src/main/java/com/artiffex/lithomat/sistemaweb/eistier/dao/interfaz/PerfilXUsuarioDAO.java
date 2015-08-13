package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PerfilXUsuario;

public interface PerfilXUsuarioDAO {
	
	public int crea(PerfilXUsuario perfilXUsuario);
	
	public PerfilXUsuario busca(int idPerfilXUsuario);
	
	public PerfilXUsuario buscaPorUsuario( int idUsuario );
	
	public void modifica(PerfilXUsuario perfilXUsuario);
	
	public List<PerfilXUsuario> lista();

}
