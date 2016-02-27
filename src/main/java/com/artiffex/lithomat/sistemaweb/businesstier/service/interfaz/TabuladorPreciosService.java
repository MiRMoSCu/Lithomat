package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TabuladorPreciosDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaTabuladorPrecios;

public interface TabuladorPreciosService {
	
	public void creaTabuladorPrecios(TabuladorPrecios tabuladorPrecios);
	
	public TabuladorPrecios buscaTabuladorPrecios(int idTabuladorPrecios);
	
	public void modificaTabuladorPrecios(TabuladorPrecios tabuladorPrecios);
	
	public List<TabuladorPrecios> listaTabuladorPrecios();
	
	public int numeroRegistrosPorCriterioBusqueda(ParametrosBusquedaTabuladorPrecios parametros);
	
	public List<TabuladorPreciosDTO> listaPorCriterioBusquedaPorNumeroPagina(ParametrosBusquedaTabuladorPrecios parametros, int numeroPagina, int numeroRegistrosPorPagina);
	
	public float obtienePrecioUnitarioTabulador(int idTipoComplejidad, int idMaquina, int cantidad);
	
}