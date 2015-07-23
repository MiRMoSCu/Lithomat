package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionProcesosPartida;

public interface CalificacionProcesosPartidaDAO {

	public int crea(CalificacionProcesosPartida calificacionProcesosPartida);
	
	public CalificacionProcesosPartida busca(int idCalificacionProcesosPartida);

	public CalificacionProcesosPartida buscaPorPartida(int idPartida);
	
	public void modifica(CalificacionProcesosPartida resumenCalificacionPartida);
	
}
