package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaVisualizador;

public interface VisualizadorService {

	public int getNumeroOrdenesProduccion(ParametrosBusquedaVisualizador parametros);

	public List<VisualizadorDTO> getListaOrdenesProduccion(ParametrosBusquedaVisualizador parametros, int numeroPagina, int numeroRegistrosPorPagina);

}
