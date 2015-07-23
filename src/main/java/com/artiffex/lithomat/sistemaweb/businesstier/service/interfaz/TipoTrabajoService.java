package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajo;

public interface TipoTrabajoService {
	
	public void creaTipoTrabajo(TipoTrabajo tipoTrabajo);
	
	public TipoTrabajo buscaTipoTrabajo(int idTipoTrabajo);
	
	public void modificaTipoTrabajo(TipoTrabajo tipoTrabajo);
	
	public List<TipoTrabajo> listaTipoTrabajo();
	
}