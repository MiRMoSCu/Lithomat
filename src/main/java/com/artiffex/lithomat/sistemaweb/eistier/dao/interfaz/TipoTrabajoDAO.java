package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajo;

public interface TipoTrabajoDAO {
	
	public int crea(TipoTrabajo tipoTrabajo);
	
	public TipoTrabajo busca(int idTipoTrabajo);
	
	public void modifica(TipoTrabajo tipoTrabajo);
	
	public List<TipoTrabajo> lista();
	
}
