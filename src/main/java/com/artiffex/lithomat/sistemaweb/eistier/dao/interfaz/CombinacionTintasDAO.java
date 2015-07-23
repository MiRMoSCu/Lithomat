package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CombinacionTintas;

public interface CombinacionTintasDAO {

	public int crea(CombinacionTintas combinacionTintas);
	
	public CombinacionTintas busca(int idCombinacionTintas);

	public void modifica(CombinacionTintas combinacionTintas);
	
	public List<CombinacionTintas> lista();

}
