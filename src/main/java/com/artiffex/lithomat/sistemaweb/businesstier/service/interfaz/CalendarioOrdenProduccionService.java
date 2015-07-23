package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalendarioOrdenProduccion;

public interface CalendarioOrdenProduccionService {
	
	public int creaCalendarioOrdenProduccion(CalendarioOrdenProduccion calendarioOrdenProduccion);
	
	public int modificaCalendarioOrdenProduccion(CalendarioOrdenProduccion calendarioOrdenProduccion);
	
	public int eliminaCalendarioOrdenProduccion(int idCalendarioOrdenProduccion);
	
	public List<CalendarioOrdenProduccion> listaCalendarioOrdenProduccion();
	
}