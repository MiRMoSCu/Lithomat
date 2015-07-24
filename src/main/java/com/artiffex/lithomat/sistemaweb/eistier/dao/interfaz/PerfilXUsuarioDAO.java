package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

public interface PerfilXUsuarioDAO {
	
	public int crea(PerfilXUsuarioDAO perfilXUsuario);
	
	public void modifica(PerfilXUsuarioDAO perfilXUsuario);
	
	public void elimina(int idPerfilXUsuario);
	
	public List<PerfilXUsuarioDAO> lista();

}
