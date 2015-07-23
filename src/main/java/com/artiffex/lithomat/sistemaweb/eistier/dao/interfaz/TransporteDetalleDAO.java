package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TransporteDetalle;

public interface TransporteDetalleDAO {

	public int crea(TransporteDetalle transporteDetalle);
	
	public TransporteDetalle busca(int idTransporteDetalle);

	public void modifica(TransporteDetalle transporteDetalle);

	public List<TransporteDetalle> lista();
	
	public List<TransporteDetalle> listaPorTransporte(int idTransporte);
	
	

	

	//public float getSumatoriaPrecioTotalPesos(int idPartida);
	
	//public List<TransporteDetalle> listaPorIdPartida(int idPartida);
	
}
