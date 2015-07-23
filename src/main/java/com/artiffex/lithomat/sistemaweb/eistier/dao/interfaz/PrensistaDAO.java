package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Prensista;

public interface PrensistaDAO {
	
	public int crea(Prensista prensista);
	
	public Prensista busca(int idPrensista);
	
	public void modifica(Prensista prensista);
	
	public List<Prensista> lista();
	
}
