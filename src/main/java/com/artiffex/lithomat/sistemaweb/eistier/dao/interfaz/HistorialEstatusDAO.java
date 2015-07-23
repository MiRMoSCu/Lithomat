package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistorialEstatus;

public interface HistorialEstatusDAO {
	
	public int crea(HistorialEstatus historialEstatus);
	
	public HistorialEstatus busca(int idHistorialEstatus);
	
	public HistorialEstatus buscaPorOrdenProduccion(int idOrdenProduccion);
	
	public void modifica(HistorialEstatus historialEstatus);
	
	public List<HistorialEstatus> lista(int idOrdenProduccion);
	
	public List<HistorialEstatus> listaPorOrdenProduccion(int idOrdenProduccion);
	
}
