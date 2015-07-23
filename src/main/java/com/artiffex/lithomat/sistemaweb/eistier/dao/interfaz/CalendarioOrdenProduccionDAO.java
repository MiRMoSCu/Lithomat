package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalendarioOrdenProduccion;

public interface CalendarioOrdenProduccionDAO {
	
	public int crea(CalendarioOrdenProduccion calendarioOrdenProduccion);
	
	public int modifica(CalendarioOrdenProduccion calendarioOrdenProduccion);
	
	public int elimina(int idCalendarioOrdenProduccion);
	
	public List<CalendarioOrdenProduccion> lista();
	
}
