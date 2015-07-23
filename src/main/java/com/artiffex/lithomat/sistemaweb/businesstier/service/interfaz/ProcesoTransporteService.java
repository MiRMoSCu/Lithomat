package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoTransporte;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface ProcesoTransporteService {

	public void creaProcesoTransporte(ProcesoTransporte procesoTransporte);
	
	public ProcesoTransporte buscaProcesoTransporte(int idProcesoTransporte);

	public void modificaProcesoTransporte(ProcesoTransporte procesoTransporte);

	public List<ProcesoTransporte> listaProcesoTransporte();

	public List<ComboSelect> listaComboSelect();
}