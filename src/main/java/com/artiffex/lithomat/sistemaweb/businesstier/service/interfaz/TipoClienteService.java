package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoCliente;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface TipoClienteService {
	
	public void creaTipoCliente(TipoCliente tipoCliente);
	
	public TipoCliente buscaTipoCliente(int idTipoCliente);
	
	public void modificaTipoCliente(TipoCliente tipoCliente);
	
	public List<TipoCliente> listaTipoCliente();
	
	public List<ComboSelect> listaComboSelect();
	
}