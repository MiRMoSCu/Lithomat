package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoExterno;

public interface ProcesoExternoDAO {

	public int crea(ProcesoExterno procesoExterno);
	
	public ProcesoExterno busca(int idProcesoExterno);

	public void modifica(ProcesoExterno procesoExterno);

	public List<ProcesoExterno> lista();

}
