package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TintaEspecial;

public interface TintaEspecialDAO {

	public void modifica(TintaEspecial tintaEspecial);

	public List<TintaEspecial> lista();
	
}
