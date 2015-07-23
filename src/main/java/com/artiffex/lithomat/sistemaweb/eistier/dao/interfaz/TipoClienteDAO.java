package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoCliente;

public interface TipoClienteDAO {

	public int crea(TipoCliente tipoCliente);
	
	public TipoCliente busca(int idTipoCliente);

	public void modifica(TipoCliente tipoCliente);

	public List<TipoCliente> lista();
	
}
