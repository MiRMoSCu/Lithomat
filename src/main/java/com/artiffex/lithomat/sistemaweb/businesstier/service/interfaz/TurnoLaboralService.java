package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TurnoLaboral;

public interface TurnoLaboralService {
	
	public void creaTurnoLaboral(TurnoLaboral turnoLaboral);
	
	public TurnoLaboral busca(int idTurnoLaboral);
	
	public void modificaTurnoLaboral(TurnoLaboral turnoLaboral);
	
	public List<TurnoLaboral> listaTurnoLaboral();
	
}