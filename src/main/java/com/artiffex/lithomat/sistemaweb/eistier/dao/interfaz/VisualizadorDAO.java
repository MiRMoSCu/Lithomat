package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;

public interface VisualizadorDAO {

	public int numeroOrdenesProduccion(String query, Object[] parametros);

	public List<VisualizadorDTO> listaOrdenesProduccion(String query, Object[] parametros);

}
