package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.ClienteDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaCliente;

public interface ClienteService {

	public void creaCliente(Cliente cliente);
	
	public ClienteDTO buscaClienteDTO(int idCliente);
	
	public Cliente buscaCliente(int idCliente);

	public void modificaCliente(Cliente cliente);

	public List<Cliente> listaCliente();
	
	public List<ComboSelect> buscaClientePorNombre(String nombreMoral);
	
	public int numeroRegistrosPorCriterioBusqueda(ParametrosBusquedaCliente parametros);
	
	public List<ClienteDTO> listaPorCriterioBusquedaPorNumeroPagina(ParametrosBusquedaCliente parametros, int numeroPagina, int numeroRegistrosPorPagina);
		
}