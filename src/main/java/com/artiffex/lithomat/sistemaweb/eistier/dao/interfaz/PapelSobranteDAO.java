package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PapelSobrante;

public interface PapelSobranteDAO {

	public int crea(PapelSobrante papelSobrante);
	
	public PapelSobrante busca(int idPapelSobrante);

	public void modifica(PapelSobrante papelSobrante);

	public List<PapelSobrante> lista();

	public int buscaHojasSobrante(PapelSobrante papelSobrante);
}
