package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface TipoPrecioService {
	
	public void creaTipoPrecio(TipoPrecio tipoPrecio);
	
	public TipoPrecio buscaTipoPrecio(int idTipoPrecio);
	
	public void modificaTipoPrecio(TipoPrecio tipoPrecio);
	
	public List<TipoPrecio> listaTipoPrecio();
	
	public List<ComboSelect> listaComboSelect();
	
	public List<ComboSelect> listaComboSelect(int[] idTipoPrecioDeseado);
	
}