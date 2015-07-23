package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.FechaPrensistaMaquina;

public interface FechaPrensistaMaquinaService {
	
	public int creaFechaPrensistaMaquina(FechaPrensistaMaquina fechaPrensistaMaquina);
	
	public int modificaFechaPrensistaMaquina(FechaPrensistaMaquina fechaPrensistaMaquina);
	
	public int eliminaFechaPrensistaMaquina(int idFechaPrensistaMaquina);
	
	public List<FechaPrensistaMaquina> listaFechaPrensistaMaquina();
	
}