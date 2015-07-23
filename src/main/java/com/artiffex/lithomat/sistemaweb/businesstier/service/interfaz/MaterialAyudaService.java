package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyuda;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface MaterialAyudaService {

	public void creaMaterialAyuda(MaterialAyuda materialAyuda);
	
	public MaterialAyuda buscaMaterialAyuda(int idMaterialAyuda);

	public void modificaMaterialAyuda(MaterialAyuda materialAyuda);

	public List<MaterialAyuda> listaMaterialAyuda();

	public List<ComboSelect> listaComboSelect();
}