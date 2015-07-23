package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.sql.Timestamp;
import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;

public interface OrdenProduccionService {
	
	public String generaNut(Timestamp fechaGeneracion);

	public int creaOrdenProduccion(OrdenProduccion ordenProduccion);
	
	public OrdenProduccion buscaOrdenProduccion(int idOrdenProduccion);
	
	public OrdenProduccion buscaOrdenProduccionPorNut(String nut);

	public void modificaOrdenProduccion(OrdenProduccion ordenProduccion);

	public List<OrdenProduccion> listaOrdenProduccion();
	
	public int buscaEstatusOrdenProduccionPorNut(String nut);

	public String generaJsonArbolOrdenProduccion(int idOrdenProduccion);
	
	

	
	
	
	//public OrdenProduccion busca(int idOrdenProduccion);

	//public OrdenProduccion busca(String nut);
	
	//public int obtieneIdOrdenProduccion(String nut);
	
}