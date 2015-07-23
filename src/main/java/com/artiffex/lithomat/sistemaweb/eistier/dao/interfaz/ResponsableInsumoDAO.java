package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ResponsableInsumo;

public interface ResponsableInsumoDAO {

	public int crea(ResponsableInsumo responsableInsumo);
	
	public ResponsableInsumo busca(int idResponsableInsumo);

	public void modifica(ResponsableInsumo responsableInsumo);

	public List<ResponsableInsumo> lista();
	
}
