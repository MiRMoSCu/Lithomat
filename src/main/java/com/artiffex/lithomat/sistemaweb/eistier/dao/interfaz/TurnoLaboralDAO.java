package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TurnoLaboral;

public interface TurnoLaboralDAO {
	
	public int crea(TurnoLaboral turnoLaboral);
	
	public TurnoLaboral busca(int idTurnoLaboral);
	
	public void modifica(TurnoLaboral turnoLaboral);
	
	public List<TurnoLaboral> lista();
	
}
