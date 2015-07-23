package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoVuelta;

public interface TipoVueltaDAO {

	public int crea(TipoVuelta tipoVuelta);
	
	public TipoVuelta busca(int idTipoVuelta);

	public void modifica(TipoVuelta tipoVuelta);

	public List<TipoVuelta> lista();

}
