package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Perfil;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface PerfilService {
	
	public int creaPerfil(Perfil perfil);
	
	public Perfil buscaPerfil(int idPerfil);
	
	public void modificaPerfil(Perfil perfil);
	
	public List<Perfil> listaPerfil();
	
	public List<ComboSelect> listaComboSelect();
	
}