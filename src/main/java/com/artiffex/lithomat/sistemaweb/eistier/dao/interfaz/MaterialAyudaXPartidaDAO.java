package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyudaXPartida;

public interface MaterialAyudaXPartidaDAO {

	public int crea(MaterialAyudaXPartida materialAyudaXPartida);
	
	public MaterialAyudaXPartida busca(int idMaterialAyudaXPartida);

	public void modifica(MaterialAyudaXPartida materialAyudaXPartida);

	public List<MaterialAyudaXPartida> lista();
	
	public List<MaterialAyudaXPartida> lista(int idPartida);
	
}
