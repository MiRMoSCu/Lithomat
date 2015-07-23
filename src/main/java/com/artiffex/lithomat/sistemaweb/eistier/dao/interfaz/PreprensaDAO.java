package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Preprensa;

public interface PreprensaDAO {

	public int crea(Preprensa preprensa);
	
	public Preprensa busca(int idPreprensa);
	
	public Preprensa buscaPorPartida(int idPartida);

	public void modifica(Preprensa preprensa);

	public List<Preprensa> lista();

}
