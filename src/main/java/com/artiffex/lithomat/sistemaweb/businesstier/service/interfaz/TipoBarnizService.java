package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoBarniz;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface TipoBarnizService {

	public void creaTipoBarniz(TipoBarniz tipoBarniz);
	
	public TipoBarniz buscaTipoBarniz(int idTipoBarniz);

	public void modificaTipoBarniz(TipoBarniz tipoBarniz);

	public List<TipoBarniz> listaTipoBarniz();

	public List<ComboSelect> listaComboSelect();
	
}