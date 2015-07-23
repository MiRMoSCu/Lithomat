package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorPapel;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface ProveedorPapelService {
	
	public void creaProveedorPapel(ProveedorPapel proveedorPapel);
	
	public ProveedorPapel buscaProveedorPapel(int idProveedorPapel);
	
	public void modificaProveedorPapel(ProveedorPapel proveedorPapel);
	
	public List<ProveedorPapel> listaProveedorPapel();
	
	public List<ComboSelect> listaComboSelect();
	
}