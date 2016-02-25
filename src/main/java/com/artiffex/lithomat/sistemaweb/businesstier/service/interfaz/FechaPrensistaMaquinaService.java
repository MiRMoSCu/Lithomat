package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTOGrid;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaFechaPrensistaMaquina;

public interface FechaPrensistaMaquinaService {
	
	public int creaFechaPrensistaMaquina(String jsonFechaPrensistaMaquina, String usuario);
	
	//public void modificaFechaPrensistaMaquina(FechaPrensistaMaquina fechaPrensistaMaquina);
	
	//public void eliminaFechaPrensistaMaquina(int idFechaPrensistaMaquina);
	
	public void eliminaFechaPrensistaMaquinaPorNut(String nut);
	
	public List<FechaPrensistaMaquinaDTO> listaFechaPrensistaMaquinaPorConsulta(ParametrosBusquedaFechaPrensistaMaquina parametros);
	
	public int obtieneNumeroFechaPrensistaMaquinaPorParametros(boolean busquedaPorNut, String nut);
	
	public List<FechaPrensistaMaquinaDTOGrid> listaFechaPrensistaMaquinaPorParametrosEnDTO(boolean busquedaPorNut, String nut, int numeroPagina, int numeroRegistrosPorPagina);
	
}