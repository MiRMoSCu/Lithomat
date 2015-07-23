package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CombinacionTintas;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface CombinacionTintasService {

	public void creaCombinacionTintas(CombinacionTintas combinacionTintas);
	
	public CombinacionTintas buscaCombinacionTintas(int idCombinacionTintas);

	public void modificaCombinacionTintas(CombinacionTintas combinacionTintas);
	
	public List<CombinacionTintas> listaCombinacionTintas();

	public List<ComboSelect> listaComboSelect();

}
