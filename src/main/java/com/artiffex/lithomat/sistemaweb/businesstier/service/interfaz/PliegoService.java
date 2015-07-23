package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;

public interface PliegoService {

	public List<Pliego> calculaListaPliegos(int idTipoTrabajoDetalle);
	
	public int creaPliego(Pliego pliego, String json);
	
	public Pliego buscaPliego(int idPliego);

	public void modificaPliego(Pliego pliego);

	public List<Pliego> listaPliego();
	
	public List<Pliego> listaPliegoPorTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public String buscaHTML(int idTipoTrabajoDetalle);
	
	public List<Integer> eliminaPliegoPorTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public void activaPliego(int idPliego);
	
	public int cuentaPliegosPorTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
}
