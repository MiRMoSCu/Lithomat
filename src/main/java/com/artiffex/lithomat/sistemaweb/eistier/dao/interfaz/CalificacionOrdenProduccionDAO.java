package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.ayuda.OrdenProduccionDTOAyuda;
import com.artiffex.lithomat.sistemaweb.ayuda.CalificacionTrabajoDetalleDTOAyuda;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;

public interface CalificacionOrdenProduccionDAO {
	
	public int crea(CalificacionOrdenProduccion calificacionOrdenProduccion);
	
	public CalificacionOrdenProduccion buscaPorOrdenProduccion(int idOrdenProduccion);
		
	public void modifica(CalificacionOrdenProduccion calificacionOrdenProduccion);
	
	//**************************
	
	public List<OrdenProduccionDTOAyuda> obtieneVOPruebaJasper(int idOrdenProduccion);
	
	public List<CalificacionTrabajoDetalleDTOAyuda> ejemploListaPapel();

}
