package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Offset;

public interface OffsetDAO {

	public int crea(Offset offset);
	
	public Offset busca(int idPartida);
	
	public Offset buscaPorPartida(int idPartida);

	public void modifica(Offset offset);

	public List<Offset> lista();

}
