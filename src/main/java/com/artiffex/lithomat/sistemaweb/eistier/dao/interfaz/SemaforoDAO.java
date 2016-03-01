package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;

public interface SemaforoDAO {
	
	public int numeroRegistros(String strQuery);
	
	public List<VisualizadorDTO> listaPorCriterioBusqueda(String strQuery);

}
