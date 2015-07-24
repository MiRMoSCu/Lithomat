package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Perfil;

public interface PerfilDAO {
	
	public int crea(Perfil perfil);
	
	public void modifica(Perfil perfil);
	
	public void elimina(int idPerfil);
	
	public List<Perfil> lista();
	
}
