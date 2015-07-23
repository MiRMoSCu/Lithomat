package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionTrabajoDetalle;

public interface CalificacionTrabajoDetalleDAO {

	public int crea(CalificacionTrabajoDetalle calificacionTrabajoDetalle);
	
	public CalificacionTrabajoDetalle buscaPorTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public void modifica(CalificacionTrabajoDetalle calificacionTrabajoDetalle);

}
