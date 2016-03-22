package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.DescuentoTabuladorPreciosDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.DescuentoTabuladorPrecios;

public interface DescuentoTabuladorPreciosDAO {
	
	public int crea(DescuentoTabuladorPrecios descuentoTabuladorPrecios);
	
	public DescuentoTabuladorPrecios busca(int idDescuentoTabuladorPrecios);
	
	public DescuentoTabuladorPrecios buscaPorTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public DescuentoTabuladorPreciosDTO buscaPorQuery(String queryString);
		
	public void modifica(DescuentoTabuladorPrecios descuentoTabuladorPrecios);
	
	public List<DescuentoTabuladorPrecios> lista();
	
	public float buscaFloatPorQuery(String queryString);

}
