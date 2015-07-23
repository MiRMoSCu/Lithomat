package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.SubModulo;

public interface SubModuloService {
	
	public int creaSubModulo(SubModulo subModulo);
	
	public int modificaSubModulo(SubModulo subModulo);
	
	public int eliminaSubModulo(int idSubModulo);
	
	public List<SubModulo> listaSubModulo();
	
}