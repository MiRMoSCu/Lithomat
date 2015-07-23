package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtrasDetalle;

public interface CostosExtrasDetalleService {
	
	public int creaCostosExtrasDetalle(CostosExtrasDetalle costosExtrasDetalle);
	
	public CostosExtrasDetalle buscaCostosExtrasDetalle(int idCostosExtrasDetalle);
	
	public void modificaCostosExtrasDetalle(CostosExtrasDetalle costosExtrasDetalle);
	
	public List<CostosExtrasDetalle> listaCostosExtrasDetalle();
	
	public List<CostosExtrasDetalle> listaCostosExtrasDetallePorPartida(int idPartida);
	
}