package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.DisenioDetalle;

public interface DisenioDetalleDAO {

	public int crea(DisenioDetalle disenioDetalle);
	
	public DisenioDetalle busca(int idDisenioDetalle);

	public void modifica(DisenioDetalle disenioDetalle);
	
	public List<DisenioDetalle> lista();
	
	public List<DisenioDetalle> listaPorDisenio(int idDisenio);
	
	
	

	//public List<DisenioDetalle> listaPorIdPartida(int idPartida);
	
	//public float getSumatoriaPrecioTotalPesos(int idPartida);
	
}
