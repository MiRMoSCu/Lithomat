package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;

public interface MaquinaDAO {

	public int crea(Maquina maquina);
	
	public Maquina busca(int idMaquina);

	public void modifica(Maquina maquina);

	public List<Maquina> lista();

}
