package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPliego;

public interface CalificacionPliegoDAO {
	
	public int crea(CalificacionPliego calificacionPliego);
	
	public CalificacionPliego buscaPorPliego(int idPliego);
	
	public void modifica(CalificacionPliego calificacionPliego);

}
