package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoTransporte;

public interface ProcesoTransporteDAO {

	public int crea(ProcesoTransporte procesoTransporte);
	
	public ProcesoTransporte busca(int idProcesoTransporte);

	public void modifica(ProcesoTransporte procesoTransporte);

	public List<ProcesoTransporte> lista();

}
