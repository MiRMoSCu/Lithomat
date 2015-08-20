package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComplejidad;

public interface TipoComplejidadDAO {
	
	public int crea(TipoComplejidad tipoComplejidad);
	
	public TipoComplejidad busca(int idTipoComplejidad);
	
	public void modifica(TipoComplejidad tipoComplejidad);
	
	public List<TipoComplejidad> lista();

}
