package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.DescuentoTabuladorPreciosDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.DescuentoTabuladorPrecios;

public interface DescuentoTabuladorPreciosService {
	
	public int crea(DescuentoTabuladorPrecios descuentoTabuladorPrecios);
	
	public void modifica(DescuentoTabuladorPrecios descuentoTabuladorPrecios);
	
	public DescuentoTabuladorPrecios busca(int idDescuentoTabuladorPrecios);
	
	public DescuentoTabuladorPrecios buscaPorTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public DescuentoTabuladorPreciosDTO buscaPorTipoTrabajoDetalleEnDTO(int idTipoTrabajoDetalle);
	
	public float buscaPrecioPorTipoTrabajoDetalle(int idTipoTrabajoDetalle);

}
