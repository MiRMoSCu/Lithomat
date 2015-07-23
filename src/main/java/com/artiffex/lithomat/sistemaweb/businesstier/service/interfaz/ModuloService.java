package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Modulo;

public interface ModuloService {
	
	public int creaModulo(Modulo modulo);
	
	public int modificaModulo(Modulo modulo);
	
	public int eliminaModulo(int idModulo);
	
	public List<Modulo> listaModulo();
	
}