package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PerfilXUsuario;

public interface PerfilXUsuarioService {
	
	public void creaPerfilXUsuario(PerfilXUsuario perfilXUsuario);
	
	public PerfilXUsuario buscaPerfilXUsuario(int idPerfilXUsuario);
	
	public PerfilXUsuario buscaPerfilXUsuarioPorUsuario(int idUsuario);
	
	public void modificaPerfilXUsuario(PerfilXUsuario perfilXUsuario);
	
	public List<PerfilXUsuario> listaPerfilXUsuario();

}
