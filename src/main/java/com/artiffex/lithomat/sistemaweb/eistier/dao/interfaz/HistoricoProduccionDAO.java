package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistoricoProduccion;

public interface HistoricoProduccionDAO {
	
	public int crea(HistoricoProduccion historicoProduccion);
	
	public int modifica(HistoricoProduccion historicoProduccion);
	
	public int elimina(int idHistoricoProduccion);
	
	public List<HistoricoProduccion> lista();
	
}
