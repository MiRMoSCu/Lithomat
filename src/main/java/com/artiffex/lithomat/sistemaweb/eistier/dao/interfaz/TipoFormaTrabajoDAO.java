package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoFormaTrabajo;

public interface TipoFormaTrabajoDAO {

	public int crea(TipoFormaTrabajo tipoFormaTrabajo);
	
	public TipoFormaTrabajo busca(int idTipoFormaTrabajo);

	public void modifica(TipoFormaTrabajo tipoFormaTrabajo);

	public List<TipoFormaTrabajo> lista();

}
