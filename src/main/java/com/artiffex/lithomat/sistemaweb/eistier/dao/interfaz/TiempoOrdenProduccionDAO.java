package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TiempoOrdenProduccion;

public interface TiempoOrdenProduccionDAO {
	
	public int crea(TiempoOrdenProduccion tiempoOrdenProduccion);
	
	public int modifica(TiempoOrdenProduccion tiempoOrdenProduccion);
	
	public int elimina(int idTiempoOrdenProduccion);
	
	public List<TiempoOrdenProduccion> lista();
	
}
