package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaSemaforo;

public interface SemaforoService {
	
	public int numeroRegistrosPorCriterioBusqueda(ParametrosBusquedaSemaforo parametros);
	
	public List<VisualizadorDTO> listaPorCriterioBusquedaPorNumeroPagina(ParametrosBusquedaSemaforo parametros, int numeroPagina, int numeroRegistrosPorPagina);

}
