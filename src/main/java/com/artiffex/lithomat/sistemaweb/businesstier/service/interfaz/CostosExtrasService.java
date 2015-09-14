package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtras;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface CostosExtrasService {
	
	public void creaCostosExtras(CostosExtras costosExtras);
	
	public CostosExtras buscaCostosExtras(int idCostosExtras);
	
	public void modificaCostosExtras(CostosExtras costosExtras);
	
	public List<CostosExtras> listaCostosExtras();
	
	public List<ComboSelect> listaComboSelect();
	
}