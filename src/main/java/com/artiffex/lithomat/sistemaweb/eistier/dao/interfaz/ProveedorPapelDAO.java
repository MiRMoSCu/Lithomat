package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorPapel;

public interface ProveedorPapelDAO {
	
	public int crea(ProveedorPapel proveedorPapel);
	
	public ProveedorPapel busca(int idProveedorPapel);
	
	public void modifica(ProveedorPapel proveedorPapel);
	
	public List<ProveedorPapel> lista();
	
}
