package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorExterno;

public interface ProveedorExternoDAO {
	
	public int crea(ProveedorExterno proveedorExterno);
	
	public ProveedorExterno busca(int idProveedorExterno);
	
	public void modifica(ProveedorExterno proveedorExterno);
	
	public List<ProveedorExterno> lista();
	
}
