package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPlaca;

public interface TipoPlacaDAO {

	public int crea(TipoPlaca tipoPlaca);
	
	public TipoPlaca busca(int idTipoPlaca);

	public void modifica(TipoPlaca tipoPlaca);

	public List<TipoPlaca> lista();
	
	public List<TipoPlaca> lista(int idMaquina);
	
	public void borradoLogico(String strQuery);

}
