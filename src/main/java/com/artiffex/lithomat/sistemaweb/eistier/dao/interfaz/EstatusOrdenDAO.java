package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;

public interface EstatusOrdenDAO {

	public int crea(EstatusOrden estatusOrden);
	
	public EstatusOrden busca(int idEstatusOrden);

	public void modifica(EstatusOrden estatusOrden);

	public List<EstatusOrden> lista();
	
	public List<EstatusOrden> listaEstatusPosible(String nut);
}
