package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TabuladorPrecios;

public interface TabuladorPreciosDAO {

	public int crea(TabuladorPrecios tabuladorPrecios);
	
	public TabuladorPrecios busca(int idTabuladorPrecios);
	
	public float buscaPrecioTabulador(String sqlQuery);

	public void modifica(TabuladorPrecios tabuladorPrecios);

	public List<TabuladorPrecios> lista();
	
}
