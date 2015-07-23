package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoFormacion;

public interface TipoFormacionService {
	
	public int creaTipoFormacion(TipoFormacion tipoFormacion);
	
	public int modificaTipoFormacion(TipoFormacion tipoFormacion);
	
	public int eliminaTipoFormacion(int idTipoFormacion);
	
	public List<TipoFormacion> listaTipoFormacion();
	
}