package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.DescuentoTabuladorPrecios;

public interface DescuentoTabuladorPreciosDAO {
	
	public int crea(DescuentoTabuladorPrecios descuentoTabuladorPrecios);
	
	public DescuentoTabuladorPrecios busca(int idDescuentoTabuladorPrecios);
	
	public void modifica(DescuentoTabuladorPrecios descuentoTabuladorPrecios);
	
	public List<DescuentoTabuladorPrecios> lista();

}
