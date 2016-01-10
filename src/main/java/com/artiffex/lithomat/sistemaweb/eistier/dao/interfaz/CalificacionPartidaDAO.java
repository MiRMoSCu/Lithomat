package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPartida;

public interface CalificacionPartidaDAO {

	public int crea(CalificacionPartida calificacionPartida);
	
	public CalificacionPartida busca(int idCalificacionPartida);

	public CalificacionPartida buscaPorPartida(int idPartida);
	
	public void modifica(CalificacionPartida calificacionPartida);
	
}
