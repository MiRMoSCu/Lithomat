package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyuda;

public interface MaterialAyudaDAO {

	public int crea(MaterialAyuda materialAyuda);
	
	public MaterialAyuda busca(int idMaterialAyuda);

	public void modifica(MaterialAyuda materialAyuda);

	public List<MaterialAyuda> lista();

}
