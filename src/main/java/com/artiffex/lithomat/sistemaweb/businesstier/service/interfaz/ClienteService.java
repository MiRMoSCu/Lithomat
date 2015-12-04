package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.ClienteDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface ClienteService {

	public void creaCliente(Cliente cliente);
	
	public ClienteDTO buscaClienteDTO(int idCliente);
	
	public Cliente buscaCliente(int idCliente);

	public void modificaCliente(Cliente cliente);

	public List<Cliente> listaCliente();
	
	public List<ComboSelect> buscaClientePorNombre(String nombreMoral);
	
	public int obtieneNumeroClientesPorParamatros(
			boolean busquedaPorNombreMoral,
			boolean busquedaPorRFC,
			boolean busquedaPorClave,
			boolean busquedaPorNombreRepresentante,
			boolean busquedaPorCodigoPostal,
			String nombreMoral,
			String rfc,
			Integer idTipoCliente,
			String nombreRepresentante,
			String codigoPostal
		);
	
	public List<Cliente> listaClientePorParametrosPorNumeroPagina(
			boolean busquedaPorNombreMoral,
			boolean busquedaPorRFC,
			boolean busquedaPorClave,
			boolean busquedaPorNombreRepresentante,
			boolean busquedaPorCodigoPostal,
			String nombreMoral,
			String rfc,
			Integer idTipoCliente,
			String nombreRepresentante,
			String codigoPostal,
			int numeroPagina, 
			int numeroRegistrosPorPagina);
	
	public List<ClienteDTO> listaClientePorParametrosPorNumeroPaginaEnDTO(
			boolean busquedaPorNombreMoral,
			boolean busquedaPorRFC,
			boolean busquedaPorClave,
			boolean busquedaPorNombreRepresentante,
			boolean busquedaPorCodigoPostal,
			String nombreMoral,
			String rfc,
			Integer idTipoCliente,
			String nombreRepresentante,
			String codigoPostal,
			int numeroPagina, 
			int numeroRegistrosPorPagina);
		
}