package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;

public interface PartidaDAO {

	public int crea(Partida partida);
	
	public Partida busca(int idPartida);

	public void modifica(Partida partida);

	public List<Partida> lista();
	
	public List<Partida> listaPorOrdenProduccion(int idOrdenProduccion);
	
	
	
	
	


	

	//public List<Partida> listaPorNut(String nut);

	//public int getIdTipoTrabajo(int idPartida);
	
	//public List<Partida> listaPrecioPartida(String nut);
	
}