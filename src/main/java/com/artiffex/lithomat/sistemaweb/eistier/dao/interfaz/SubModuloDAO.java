package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.SubModulo;

public interface SubModuloDAO {
	
	public int crea(SubModulo subModulo);
	
	public int modifica(SubModulo subModulo);
	
	public int elimina(int idSubModulo);
	
	public List<SubModulo> lista();
	
}
