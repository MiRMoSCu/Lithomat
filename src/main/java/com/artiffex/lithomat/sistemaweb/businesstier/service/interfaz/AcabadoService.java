package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.AcabadoDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Acabado;

public interface AcabadoService {

	public int creaAcabado(Acabado acabado);
	
	public Acabado buscaAcabado(int idAcabado);
	
	public Acabado buscaAcabadoPorPartida(int idPartida);
	
	public AcabadoDTO buscaAcabadoPorPartidaEnDTO(int idPartida);

	public void modificaAcabado(Acabado acabado);

	public List<Acabado> listaAcabado();
	
}