package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.FechaPrensistaMaquina;

public interface FechaPrensistaMaquinaDAO {
	
	public int crea(FechaPrensistaMaquina fechaPrensistaMaquina);
	
	public int modifica(FechaPrensistaMaquina fechaPrensistaMaquina);
	
	public int elimina(int idFechaPrensistaMaquina);
	
	public List<FechaPrensistaMaquina> lista();
	
}
