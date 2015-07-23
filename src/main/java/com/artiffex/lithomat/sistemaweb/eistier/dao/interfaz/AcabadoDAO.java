package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Acabado;

public interface AcabadoDAO {
	
	public int crea(Acabado acabado);
	
	public Acabado busca(int idAcabado);
	
	public Acabado buscaPorPartida(int idPartida);

	public void modifica(Acabado acabado);

	public List<Acabado> lista();

}
