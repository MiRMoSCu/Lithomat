package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TiempoOrdenProduccion;

public interface TiempoOrdenProduccionService {
	
	public int creaTiempoOrdenProduccion(TiempoOrdenProduccion tiempoOrdenProduccion);
	
	public int modificaTiempoOrdenProduccion(TiempoOrdenProduccion tiempoOrdenProduccion);
	
	public int eliminaTiempoOrdenProduccion(int idTiempoOrdenProduccion);
	
	public List<TiempoOrdenProduccion> listaTiempoOrdenProduccion();
	
}