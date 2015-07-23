package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.DisenioDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Disenio;

public interface DisenioService {

	public int creaDisenio(Disenio disenio);
	
	public Disenio buscaDisenio(int idDisenio);
	
	public Disenio buscaDisenioPorPartida(int idPartida);
	
	public DisenioDTO buscaDisenioPorPartidaEnDTO(int idPartida);

	public void modificaDisenio(Disenio disenio);

	public List<Disenio> listaDisenio();
	
}