package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.InsumoCalificacion;

public interface InsumoCalificacionDAO {
	
	public int crea(InsumoCalificacion insumoCalificacion);
	
	public int modifica(InsumoCalificacion insumoCalificacion);
	
	public int elimina(int idEstatusOrden);
	
	public List<InsumoCalificacion> lista();
	
}
