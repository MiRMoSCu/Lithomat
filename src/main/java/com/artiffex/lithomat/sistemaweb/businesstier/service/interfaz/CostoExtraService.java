package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtra;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface CostoExtraService {
	
	public void creaCostoExtra(CostoExtra costoExtra);
	
	public CostoExtra buscaCostoExtra(int idCostoExtra);
	
	public void modificaCostoExtra(CostoExtra costoExtra);
	
	public List<CostoExtra> listaCostoExtra();
	
	public List<ComboSelect> listaComboSelect();
	
}