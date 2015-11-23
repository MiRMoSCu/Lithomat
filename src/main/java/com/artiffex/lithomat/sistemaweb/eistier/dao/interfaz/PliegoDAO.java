package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;

public interface PliegoDAO {

	public int crea(Pliego pliego);
	
	public Pliego busca(int idPliego);

	public void modifica(Pliego pliego);

	public List<Pliego> lista();
	
	public List<Pliego> listaPorTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public int numeroPliegosPorTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
}
