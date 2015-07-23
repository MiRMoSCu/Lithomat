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
	

	
	
	
	
	

	// Metodos abajo son utilizados para ResumenCalificacionService


	//public int getTotalPlacas(int idTipoTrabajoDetalle);

	//public int getTotalEntradasMaquinaTinta(int idTipoTrabajoDetalle);

	//public int getTotalEntradasMaquinaTintaEspecial(int idTipoTrabajoDetalle);

	//public int getTotalEntradasMaquinaBarnizFrente(int idTipoTrabajoDetalle);

	//public int getTotalEntradasMaquinaBarnizVuelta(int idTipoTrabajoDetalle);
	
	//public int actualiza(Pliego pliego);
	
	//public List<Integer> listaIdPliego(int idTipoTrabajoDetalle);
	
	//public float getNumeroDecimal(int idPliego);
	
	//public int activaPliego(int idPliego);

}
