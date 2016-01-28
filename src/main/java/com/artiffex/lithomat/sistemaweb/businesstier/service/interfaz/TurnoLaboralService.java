package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TurnoLaboral;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface TurnoLaboralService {
	
	public void creaTurnoLaboral(TurnoLaboral turnoLaboral);
	
	public TurnoLaboral busca(int idTurnoLaboral);
	
	public void modificaTurnoLaboral(TurnoLaboral turnoLaboral);
	
	public List<TurnoLaboral> listaTurnoLaboral();
	
	public List<ComboSelect> listaComboSelect();
	
}