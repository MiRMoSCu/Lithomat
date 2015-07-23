package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.UnidadMedida;

public interface UnidadMedidaDAO {
	
	public int crea(UnidadMedida unidadMedida);
	
	public int modifica(UnidadMedida unidadMedida);
	
	public int elimina(UnidadMedida unidadMedida);
	
	public List<UnidadMedida> lista();
	
}
