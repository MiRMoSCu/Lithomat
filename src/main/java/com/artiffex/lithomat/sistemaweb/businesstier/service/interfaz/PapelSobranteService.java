package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PapelSobrante;

public interface PapelSobranteService {

	public void creaPapelSobrante(PapelSobrante papelSobrante);
	
	public PapelSobrante buscaPapelSobrante(int idPapelSobrante);

	public void modificaPapelSobrante(PapelSobrante papelSobrante);

	public List<PapelSobrante> listaPapelSobrante();
	
	public int buscaHojasSobrante(PapelSobrante papelSobrante);

}
