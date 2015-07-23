package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyudaXPartida;

public interface MaterialAyudaXPartidaService {

	public int creaMaterialAyudaXPartida(MaterialAyudaXPartida materialAyudaXPartida);
	
	public MaterialAyudaXPartida buscaMaterialAyudaXPartida(int idMaterialAyudaXPartida);

	public void modificaMaterialAyudaXPartida(MaterialAyudaXPartida materialAyudaXPartida);

	public List<MaterialAyudaXPartida> listaMaterialAyudaXPartida();

	public String listaHTML(int idPartida);
	
	public String listaHTMLModificacion(int idPartida);
	
}