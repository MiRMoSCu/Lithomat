package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTOGrid;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.FechaPrensistaMaquina;

public interface FechaPrensistaMaquinaDAO {
	
	public int crea(FechaPrensistaMaquina fechaPrensistaMaquina);
	
	public int modifica(FechaPrensistaMaquina fechaPrensistaMaquina);
	
	public void eliminaPorIdPliego(int idPliego);
	
	public List<FechaPrensistaMaquina> lista();
	
	public List<FechaPrensistaMaquinaDTO> buscaFechaPrensistaMaquinaDTO(String query); 
	
	public int numeroRegistrosFechaPrensistaMaquina(String strQuery);
	
	public List<FechaPrensistaMaquinaDTOGrid> listaPorRango(String strQuery);
	
}
