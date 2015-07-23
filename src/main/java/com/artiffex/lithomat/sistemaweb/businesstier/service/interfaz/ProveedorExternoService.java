package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorExterno;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface ProveedorExternoService {
	
	public void creaProveedorExterno(ProveedorExterno proveedorExterno);
	
	public ProveedorExterno buscaProveedorExterno(int idProveedorExterno);
	
	public void modificaProveedorExterno(ProveedorExterno proveedorExterno);
	
	public List<ProveedorExterno> listaProveedorExterno();
	
	public List<ComboSelect> listaComboSelect();
	
}