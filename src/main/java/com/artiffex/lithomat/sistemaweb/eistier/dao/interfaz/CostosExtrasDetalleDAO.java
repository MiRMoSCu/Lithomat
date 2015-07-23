package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtrasDetalle;

public interface CostosExtrasDetalleDAO {
	
	public int crea(CostosExtrasDetalle costosExtrasDetalle);
	
	public CostosExtrasDetalle busca(int idCostosExtrasDetalle);
	
	public void modifica(CostosExtrasDetalle costosExtrasDetalle);
	
	public List<CostosExtrasDetalle> lista();
	
	public List<CostosExtrasDetalle> listaPorPartida(int idPartida);
	

	
	
	//public float getSumatoriaPrecioTotalPesos(int idPartida); // FALTA CORREGIR

}