package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TabuladorPrecios;

public interface TabuladorPreciosService {
	
	public void creaTabuladorPrecios(TabuladorPrecios tabuladorPrecios);
	
	public TabuladorPrecios buscaTabuladorPrecios(int idTabuladorPrecios);
	
	public void modificaTabuladorPrecios(TabuladorPrecios tabuladorPrecios);
	
	public List<TabuladorPrecios> listaTabuladorPrecios();
	
	public float obtienePrecioUnitarioTabulador(int idMaquina, int cantidad);
	
}