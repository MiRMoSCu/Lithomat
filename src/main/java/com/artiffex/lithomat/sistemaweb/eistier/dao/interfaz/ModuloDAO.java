package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Modulo;

public interface ModuloDAO {
	
	public int crea(Modulo modulo);
	
	public int modifica(Modulo modulo);
	
	public int elimina(int idModulo);
	
	public List<Modulo> lista();
	
}
