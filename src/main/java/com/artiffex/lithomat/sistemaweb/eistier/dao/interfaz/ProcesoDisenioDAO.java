package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoDisenio;

public interface ProcesoDisenioDAO {

	public int crea(ProcesoDisenio procesoDisenio);
	
	public ProcesoDisenio busca(int idProcesoDisenio);

	public void modifica(ProcesoDisenio procesoDisenio);

	public List<ProcesoDisenio> lista();

}
