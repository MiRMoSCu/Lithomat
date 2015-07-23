package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.PreprensaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Preprensa;

public interface PreprensaService {

	public int creaPreprensa(Preprensa preprensa);
	
	public Preprensa buscaPreprensa(int idPreprensa);
	
	public Preprensa buscaPreprensaPorPartida(int idPartida);
	
	public PreprensaDTO buscaPreprensaPorPartidaEnDTO(int idPartida);

	public void modificaPreprensa(Preprensa preprensa);

	public List<Preprensa> listaPreprensa();

}