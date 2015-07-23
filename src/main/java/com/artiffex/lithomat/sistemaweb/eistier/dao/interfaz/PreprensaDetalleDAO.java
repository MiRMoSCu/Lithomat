package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PreprensaDetalle;

public interface PreprensaDetalleDAO {

	public int crea(PreprensaDetalle preprensaDetalle);
	
	public PreprensaDetalle busca(int idPreprensaDetalle);

	public void modifica(PreprensaDetalle preprensaDetalle);
	
	public List<PreprensaDetalle> lista();
	
	public List<PreprensaDetalle> listaPorPreprensa(int idPreprensa);
	
	
	
	
	
	//public List<PreprensaDetalle> listaPorIdPartida(int idPartida);

	//public float getSumatoriaPrecioTotalPesos(int idPartida);
	
}
