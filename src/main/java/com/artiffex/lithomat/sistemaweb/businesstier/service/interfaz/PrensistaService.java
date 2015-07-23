package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Prensista;

public interface PrensistaService {
	
	public void creaPrensista(Prensista prensista);
	
	public Prensista buscaPrensista(int idPrensista);
	
	public void modificaPrensista(Prensista prensista);
	
	public List<Prensista> listaPrensista();
	
}