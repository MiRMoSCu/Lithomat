package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoPreprensa;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface ProcesoPreprensaService {

	public void creaProcesoPreprensa(ProcesoPreprensa procesoPreprensa);
	
	public ProcesoPreprensa buscaProcesoPreprensa(int idProcesoPreprensa); 

	public void modificaProcesoPreprensa(ProcesoPreprensa procesoPreprensa);

	public List<ProcesoPreprensa> listaProcesoPreprensa();

	public List<ComboSelect> listaComboSelect();

}
