package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistoricoProduccion;

public interface HistoricoProduccionService {
	
	public int creaHistoricoProduccion(HistoricoProduccion historicoProduccion);
	
	public int modificaHistoricoProduccion(HistoricoProduccion historicoProduccion);
	
	public int eliminaHistoricoProduccion(int idHistoricoProduccion);
	
	public List<HistoricoProduccion> listaHistoricoProduccion();
	
}