package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtras;

public interface CostosExtrasDAO {
	
	public int crea(CostosExtras costosExtras);
	
	public CostosExtras busca(int idCostosExtras);
	
	public void modifica(CostosExtras costosExtras);
	
	public List<CostosExtras> lista();
	
}
