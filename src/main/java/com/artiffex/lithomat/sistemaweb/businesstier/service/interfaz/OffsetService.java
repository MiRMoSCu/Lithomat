package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.OffsetDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Offset;

public interface OffsetService {

	public int creaOffset(Offset offset);
	
	public Offset buscaOffset(int idOffset);
	
	public Offset buscaOffsetPorPartida(int idPartida);
	
	public OffsetDTO buscaOffsetPorPartidaEnDTO(int idPartida);

	public void modificaOffset(Offset offset);

	public List<Offset> listaOffset();
	
}