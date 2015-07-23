package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoFormacion;

public interface TipoFormacionDAO {
	
	public int crea(TipoFormacion tipoFormacion);
	
	public int modifica(TipoFormacion tipoFormacion);
	
	public int elimina(int idTipoFormacion);
	
	public List<TipoFormacion> lista();
	
}
