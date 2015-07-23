package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoDisenio;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface ProcesoDisenioService {

	public void creaProcesoDisenio(ProcesoDisenio procesoDisenio);
	
	public ProcesoDisenio buscaProcesoDisenio(int idProcesoDisenio);

	public void modificaProcesoDisenio(ProcesoDisenio procesoDisenio);

	public List<ProcesoDisenio> listaProcesoDisenio();

	public List<ComboSelect> listaComboSelect();
}