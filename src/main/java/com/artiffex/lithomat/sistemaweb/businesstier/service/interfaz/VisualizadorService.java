package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;

public interface VisualizadorService {

	public int getNumeroOrdenesProduccion(
			int tipoBusqueda, 
			String nut,
			String nombre, 
			String descripcion, 
			String fechaCotizacionInicio,
			String fechaCotizacionFin, 
			String cliente, 
			int idEstatusOrden
		);

	public List<VisualizadorDTO> getListaOrdenesProduccion(
			int tipoBusqueda,
			int numeroPagina, 
			int numeroRegistrosPorPagina, 
			String nut,
			String nombre, 
			String descripcion, 
			String fechaCotizacionInicio,
			String fechaCotizacionFin, 
			String cliente, 
			int idEstatusOrden
		);

}
