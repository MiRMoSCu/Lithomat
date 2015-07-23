package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Disenio;

public interface DisenioDAO {

	public int crea(Disenio disenio);
	
	public Disenio busca(int idDisenio);
	
	public Disenio buscaPorPartida(int idPartida);

	public void modifica(Disenio disenio);

	public List<Disenio> lista();
	
}
