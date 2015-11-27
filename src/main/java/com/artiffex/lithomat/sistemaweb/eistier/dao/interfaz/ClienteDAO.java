package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;

public interface ClienteDAO {

	public int crea(Cliente cliente);
	
	public Cliente busca(int idCliente);

	public void modifica(Cliente cliente);
	
	public List<Cliente> lista();
	
	public List<Cliente> buscaPorNombre(String nombreMoral);
	
	public int numeroClientes(String strQuery);
	
	public List<Cliente> listaPorRango(String strQuery);
		
}
