package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.UnidadMedida;

public interface UnidadMedidaService {
	
	public int creaUnidadMedida(UnidadMedida unidadMedida);
	
	public void modificaUnidadMedida(UnidadMedida unidadMedida);
	
	public void eliminaUnidadMedida(UnidadMedida unidadMedida);
	
	public List<UnidadMedida> listaUnidadMedida();
	
}