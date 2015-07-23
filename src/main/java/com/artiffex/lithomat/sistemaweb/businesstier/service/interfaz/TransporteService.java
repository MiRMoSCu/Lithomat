package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TransporteDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Transporte;

public interface TransporteService {

	public int creaTransporte(Transporte transporte);
	
	public Transporte buscaTransporte(int idTransporte);
	
	public Transporte buscaTransportePorPartida(int idPartida);
	
	public TransporteDTO buscaTransportePorPartidaEnDTO(int idPartida);

	public void modificaTransporte(Transporte transporte);

	public List<Transporte> listaTransporte();
	
}