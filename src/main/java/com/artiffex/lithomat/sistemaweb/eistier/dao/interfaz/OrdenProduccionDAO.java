package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.sql.Timestamp;
import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;

public interface OrdenProduccionDAO {

	public int crea(OrdenProduccion ordenProduccion);
	
	public OrdenProduccion busca(int idOrdenProduccion);
	
	public OrdenProduccion buscaPorNut(String nut);

	public void modifica(OrdenProduccion ordenProduccion);

	public List<OrdenProduccion> lista();
	
	public int contador(Timestamp fechaGeneracion);
	
	public int buscaIdEstatusOrden(String nut);
			
}
