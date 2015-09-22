package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtraDetalle;

public interface CostoExtraDetalleDAO {
	
	public int crea(CostoExtraDetalle costoExtraDetalle);
	
	public CostoExtraDetalle busca(int idCostoExtraDetalle);
	
	public void modifica(CostoExtraDetalle costoExtraDetalle);
	
	public List<CostoExtraDetalle> lista();
	
	public List<CostoExtraDetalle> listaPorTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
}