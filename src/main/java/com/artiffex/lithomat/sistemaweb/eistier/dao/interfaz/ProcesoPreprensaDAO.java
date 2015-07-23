package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoPreprensa;

public interface ProcesoPreprensaDAO {

	public int crea(ProcesoPreprensa procesoPreprensa);
	
	public ProcesoPreprensa busca(int idProcesoPreprensa);

	public void modifica(ProcesoPreprensa procesoPreprensa);

	public List<ProcesoPreprensa> lista();

}
