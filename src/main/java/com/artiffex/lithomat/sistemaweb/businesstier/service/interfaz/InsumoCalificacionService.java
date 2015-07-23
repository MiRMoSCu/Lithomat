package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.InsumoCalificacion;

public interface InsumoCalificacionService {
	
	public int creaInsumoCalificacion(InsumoCalificacion insumoCalificacion);
	
	public int modificaInsumoCalificacion(InsumoCalificacion insumoCalificacion);
	
	public int eliminaInsumoCalificacion(int idInsumoCalificacion);
	
	public List<InsumoCalificacion> listaInsumoCalificacion();
	
}