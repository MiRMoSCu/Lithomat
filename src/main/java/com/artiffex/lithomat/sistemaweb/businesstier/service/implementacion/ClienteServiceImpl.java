package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.ClienteDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ClienteDAO;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

	@Resource
	private ClienteDAO clienteDAO;

	public void creaCliente(Cliente cliente) {
		clienteDAO.crea(cliente);
	}
	
	public ClienteDTO buscaClienteDTO(int idCliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		Cliente cliente = clienteDAO.busca(idCliente);
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setClave(cliente.getTipoCliente().getClave());
		clienteDTO.setNombreMoral(cliente.getNombreMoral());
		clienteDTO.setNombreRepresentante(cliente.getNombreRepresentante());
		clienteDTO.setCalle(cliente.getCalle());
		clienteDTO.setNumExterior(cliente.getNumExterior());
		clienteDTO.setNumInterior(cliente.getNumInterior());
		clienteDTO.setColonia(cliente.getColonia());
		clienteDTO.setDelegacionMunicipio(cliente.getDelegacionMunicipio());
		clienteDTO.setEstado(cliente.getEstado());
		clienteDTO.setCodigoPostal(cliente.getCodigoPostal());
		clienteDTO.setPais(cliente.getPais());
		clienteDTO.setRfc(cliente.getRfc());
		clienteDTO.setTelefonoParticular(cliente.getTelefonoParticular());
		clienteDTO.setTelefonoMovil(cliente.getTelefonoMovil());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setObservaciones(cliente.getObservaciones());
		clienteDTO.setActivo(cliente.isActivo());
		return clienteDTO;
	}
	
	public Cliente buscaCliente(int idCliente) {
		return clienteDAO.busca(idCliente);
	}

	public void modificaCliente(Cliente cliente) {
		clienteDAO.modifica(cliente);
	}

	public List<Cliente> listaCliente() {
		return clienteDAO.lista();
	}
	
	public List<ComboSelect> buscaClientePorNombre(String nombreMoral) {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<Cliente> listaCliente = clienteDAO.buscaPorNombre(nombreMoral);
		for (Cliente cliente : listaCliente) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(cliente.getIdCliente());
			comboSelect.setText(cliente.getNombreMoral());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			cliente = null;
		}
		listaCliente = null;
		return listaComboSelect;
	}

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
			String codigoPostal) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT COUNT(*)");
		query.append(" ");
		query.append("FROM cliente c");
		query.append(" ");
		query.append("WHERE");
		query.append(" ");
		
		if( busquedaPorNombreMoral ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("c.nombre_moral LIKE '%");
			query.append(nombreMoral);
			query.append("%'");
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorRFC ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("c.rfc LIKE '%");
			query.append(rfc);
			query.append("%'");
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorClave ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("c.id_tipo_cliente = ");
			query.append(idTipoCliente);
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorNombreRepresentante ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("c.nombre_representante LIKE '%");
			query.append(nombreRepresentante);
			query.append("%'");
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorCodigoPostal ) {
			if( existeParametro ) 
				query.append(" AND ");
			query.append("c.codigo_postal LIKE '%");
			query.append(codigoPostal);
			query.append("%'");
			query.append(" ");
			existeParametro = true;
		}
	
		if( existeParametro )
			query.append("AND c.activo = TRUE; ");
		else
			query.append("c.activo = TRUE; ");
		
		int numRegistros = clienteDAO.numeroClientes( query.toString() );
		
		query = null;
		
		return numRegistros;
	}

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
			int numeroRegistrosPorPagina ) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT *");
		query.append(" ");
		query.append("FROM cliente c");
		query.append(" ");
		query.append("WHERE");
		query.append(" ");
		
		if( busquedaPorNombreMoral ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("c.nombre_moral LIKE '%");
			query.append(nombreMoral);
			query.append("%'");
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorRFC ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("c.rfc LIKE '%");
			query.append(rfc);
			query.append("%'");
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorClave ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("c.id_tipo_cliente = ");
			query.append(idTipoCliente);
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorNombreRepresentante ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("c.nombre_representante LIKE '%");
			query.append(nombreRepresentante);
			query.append("%'");
			query.append(" ");
			existeParametro = true;
		}
		
		if( busquedaPorCodigoPostal ) {
			if( existeParametro ) {
				query.append("AND");
				query.append(" ");
			}
			query.append("c.codigo_postal LIKE '%");
			query.append(codigoPostal);
			query.append("%'");
			query.append(" ");
			existeParametro = true;
		}
	
		if( existeParametro )
			query.append("AND c.activo = TRUE");
		else
			query.append("c.activo = TRUE");
		
		query.append(" ");
		query.append("ORDER BY c.id_cliente ASC");
		query.append(" ");
		query.append("LIMIT");
		query.append(" ");
		query.append(numeroRegistrosPorPagina * (numeroPagina - 1));
		query.append(" , ");
		query.append(numeroRegistrosPorPagina);
		query.append(";");
		
		List<Cliente> lista = clienteDAO.listaPorRango( query.toString() );
		
		query = null;
		
		return lista;
	}
	
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
			int numeroRegistrosPorPagina ) {
		
		List<Cliente> listaCliente = listaClientePorParametrosPorNumeroPagina(busquedaPorNombreMoral, busquedaPorRFC, busquedaPorClave, busquedaPorNombreRepresentante, busquedaPorCodigoPostal, nombreMoral, rfc, idTipoCliente, nombreRepresentante, codigoPostal, numeroPagina, numeroRegistrosPorPagina);
		
		List<ClienteDTO> listaClienteDTO = new ArrayList<ClienteDTO>();
		for (Cliente cliente : listaCliente) {
			ClienteDTO clienteDTO = new ClienteDTO();
			clienteDTO.setIdCliente(cliente.getIdCliente());
			clienteDTO.setClave(cliente.getTipoCliente().getClave());
			clienteDTO.setNombreMoral(cliente.getNombreMoral());
			clienteDTO.setNombreRepresentante(cliente.getNombreRepresentante());
			clienteDTO.setPuesto(cliente.getPuesto());
			clienteDTO.setCalle(cliente.getCalle());
			clienteDTO.setNumExterior(cliente.getNumExterior());
			clienteDTO.setNumInterior(cliente.getNumInterior());
			clienteDTO.setColonia(cliente.getColonia());
			clienteDTO.setDelegacionMunicipio(cliente.getDelegacionMunicipio());
			clienteDTO.setEstado(cliente.getEstado());
			clienteDTO.setCodigoPostal(cliente.getCodigoPostal());
			clienteDTO.setPais(cliente.getPais());
			clienteDTO.setRfc(cliente.getRfc());
			clienteDTO.setTelefonoParticular(cliente.getTelefonoParticular());
			clienteDTO.setTelefonoMovil(cliente.getTelefonoMovil());
			clienteDTO.setEmail(cliente.getEmail());
			clienteDTO.setObservaciones(cliente.getObservaciones());
			clienteDTO.setActivo(cliente.isActivo());
			listaClienteDTO.add(clienteDTO);
			clienteDTO 	= null;
			cliente 	= null;
		}
		listaCliente = null;
		return listaClienteDTO;
	}
	
}
