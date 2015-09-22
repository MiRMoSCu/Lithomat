package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.PartidaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Partida;

public interface PartidaService {

	public int creaPartida(Partida partida);
	
	public Partida buscaPartida(int idPartida);
	
	public PartidaDTO buscaPartidaEnDTO(int idPartida);

	public void modificaPartida(Partida partida);

	public List<Partida> listaPartida();
	
	public List<Partida> listaPartidaPorOrdenProduccion(int idOrdenProduccion);
	
	public float obtieneDisenioCosteTotal(int idPartida);
	
	public float obtienePreprensaCosteTotal(int idPartida);
	
	public float obtieneTransporteCosteTotal(int idPartida);
	
	public float obtieneAcabadoCosteTotal(int idPartida);
	
	public float obtieneCostoExtraCosteTotal(int idPartida);
	
	public String buscaHTML(int idOrdenProduccion);
	
	public void actualizaPartida(Partida partida);
	
}