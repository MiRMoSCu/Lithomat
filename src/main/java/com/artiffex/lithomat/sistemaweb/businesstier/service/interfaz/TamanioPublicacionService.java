package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TamanioPublicacion;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface TamanioPublicacionService {

	public void creaTamanioPublicacion(TamanioPublicacion tamanioPublicacion);
	
	public TamanioPublicacion buscaTamanioPublicacion(int idTamanioPublicacion);

	public void modificaTamanioPublicacion(TamanioPublicacion tamanioPublicacion);

	public List<TamanioPublicacion> listaTamanioPublicacion();

	public List<ComboSelect> listaComboSelect();

	public List<TamanioPublicacion> listaDecimales();
}