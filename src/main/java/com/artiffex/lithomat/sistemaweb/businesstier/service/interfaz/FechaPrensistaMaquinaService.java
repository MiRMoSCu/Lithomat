package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTOGrid;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.FechaPrensistaMaquina;

public interface FechaPrensistaMaquinaService {
	
	public int creaFechaPrensistaMaquina(FechaPrensistaMaquina fechaPrensistaMaquina);
	
	public int modificaFechaPrensistaMaquina(FechaPrensistaMaquina fechaPrensistaMaquina);
	
	public int eliminaFechaPrensistaMaquina(int idFechaPrensistaMaquina);
	
	public List<FechaPrensistaMaquina> listaFechaPrensistaMaquina();
	
	public int obtieneNumeroFechaPrensistaMaquinaPorParametros(boolean busquedaPorNut, String nut);
	
	public List<FechaPrensistaMaquinaDTOGrid> listaFechaPrensistaMaquinaPorParametrosEnDTO(boolean busquedaPorNut, String nut, int numeroPagina, int numeroRegistrosPorPagina);
	
}