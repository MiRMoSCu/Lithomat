package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtra;

public interface CostoExtraDAO {
	
	public int crea(CostoExtra costoExtra);
	
	public CostoExtra busca(int idCostoExtra);
	
	public void modifica(CostoExtra costoExtra);
	
	public List<CostoExtra> lista();
	
}
