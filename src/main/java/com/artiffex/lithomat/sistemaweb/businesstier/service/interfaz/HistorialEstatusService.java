package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistorialEstatus;

public interface HistorialEstatusService {

	public int creaHistorialEstatus(HistorialEstatus historialEstatus);
	
	public HistorialEstatus buscaHistorialEstatus(int idHistorialEstatus);
	
	public HistorialEstatus buscaUltimoHistorialEstatus(int idOrdenProduccion);

	public void modificaHistorialEstatus(HistorialEstatus historialEstatus);

	public List<HistorialEstatus> listaHistorialEstatus(int idOrdenProduccion);
	
}