package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.AcabadoDetalle;

public interface AcabadoDetalleDAO {

	public int crea(AcabadoDetalle acabadoDetalle);
	
	public AcabadoDetalle busca(int idAcabadoDetalle);

	public void modifica(AcabadoDetalle acabadoDetalle);

	public List<AcabadoDetalle> lista();
	
	public List<AcabadoDetalle> listaPorAcabado(int idAcabado);
	
	

	
	
	//public List<AcabadoDetalle> listaPorIdPartida(int idPartida);

	//public float getSumatoriaPrecioTotalPesos(int idPartida);
	
}
