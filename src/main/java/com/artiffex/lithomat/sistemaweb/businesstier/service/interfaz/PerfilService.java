package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Perfil;

public interface PerfilService {
	
	public int creaPerfil(Perfil perfil);
	
	public void modificaPerfil(Perfil perfil);
	
	public void eliminaPerfil(int idPerfil);
	
	public List<Perfil> listaPerfil();
	
}