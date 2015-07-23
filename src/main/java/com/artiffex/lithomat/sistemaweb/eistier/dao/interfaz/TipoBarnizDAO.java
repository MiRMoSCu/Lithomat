package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoBarniz;

public interface TipoBarnizDAO {

	public int crea(TipoBarniz tipoBarniz);
	
	public TipoBarniz busca(int idTipoBarniz);

	public void modifica(TipoBarniz tipoBarniz);

	public List<TipoBarniz> lista();

}
