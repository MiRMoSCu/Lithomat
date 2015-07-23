package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Transporte;

public interface TransporteDAO {

	public int crea(Transporte transporte);
	
	public Transporte busca(int idTransporte);
	
	public Transporte buscaPorPartida(int idPartida);

	public void modifica(Transporte transporte);

	public List<Transporte> lista();
	
}
