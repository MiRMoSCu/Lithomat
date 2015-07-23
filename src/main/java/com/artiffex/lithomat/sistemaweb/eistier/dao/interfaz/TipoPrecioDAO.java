package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;

public interface TipoPrecioDAO {

	public int crea(TipoPrecio tipoPrecio);
	
	public TipoPrecio busca(int idTipoPrecio);

	public void modifica(TipoPrecio tipoPrecio);

	public List<TipoPrecio> lista();

}
