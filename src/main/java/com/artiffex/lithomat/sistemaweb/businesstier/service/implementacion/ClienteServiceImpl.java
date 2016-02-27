package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.ClienteDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaCliente;
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
		clienteDTO.setTipoCliente(cliente.getTipoCliente().getClave());
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

	public int numeroRegistrosPorCriterioBusqueda(ParametrosBusquedaCliente parametros) {
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT ");
		query.append("    COUNT(*)");
		query.append(" FROM");
		query.append("    cliente c");
		query.append(" WHERE");
		
		if ( parametros.isBusquedaPorNombreMoral() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("    c.nombre_moral LIKE '%");
			query.append(parametros.getNombreMoral());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorRfc() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("        c.rfc LIKE '%");
			query.append(parametros.getRfc());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorTipoCliente() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("        c.id_tipo_cliente = ");
			query.append(parametros.getIdTipoCliente());
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorNombreRepresentante() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("        c.nombre_representante LIKE '%");
			query.append(parametros.getNombreRepresentante());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorCodigoPostal() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("        c.codigo_postal LIKE '%");
			query.append(parametros.getCodigoPostal());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( existeParametro )
			query.append(" AND ");
		
		query.append("        c.activo = TRUE; ");
		
		int numRegistros = clienteDAO.numeroRegistros( query.toString() );
		
		query = null;
		
		return numRegistros;
	}
	
	public List<ClienteDTO> listaPorCriterioBusquedaPorNumeroPagina(ParametrosBusquedaCliente parametros, int numeroPagina, int numeroRegistrosPorPagina ) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT ");
		query.append("    c.id_cliente idCliente,");
		query.append("    tc.clave tipoCliente,");
		query.append("    c.nombre_moral nombreMoral,");
		query.append("    c.nombre_representante nombreRepresentante,");
		query.append("    c.puesto puesto,");
		query.append("    c.calle calle,");
		query.append("    c.num_exterior numExterior,");
		query.append("    c.num_interior numInterior,");
		query.append("    c.colonia colonia,");
		query.append("    c.delegacion_municipio delegacionMunicipio,");
		query.append("    c.estado estado,");
		query.append("    c.codigo_postal codigoPostal,");
		query.append("    c.pais pais,");
		query.append("    c.rfc rfc,");
		query.append("    c.telefono_particular telefonoParticular,");
		query.append("    c.telefono_movil telefonoMovil,");
		query.append("    c.email email,");
		query.append("    c.observaciones observaciones,");
		query.append("    c.activo activo");
		query.append(" FROM");
		query.append("    cliente c,");
		query.append("    tipo_cliente tc");
		query.append(" WHERE");
		
		if ( parametros.isBusquedaPorNombreMoral() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("    c.nombre_moral LIKE '%");
			query.append(parametros.getNombreMoral());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorRfc() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("        c.rfc LIKE '%");
			query.append(parametros.getRfc());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorTipoCliente() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("        c.id_tipo_cliente = ");
			query.append(parametros.getIdTipoCliente());
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorNombreRepresentante() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("        c.nombre_representante LIKE '%");
			query.append(parametros.getNombreRepresentante());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorCodigoPostal() ) {
			if ( existeParametro ) 
				query.append(" AND ");
			query.append("        c.codigo_postal LIKE '%");
			query.append(parametros.getCodigoPostal());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( existeParametro )
			query.append(" AND ");
		
		query.append("        c.activo = TRUE ");
		query.append("        AND tc.id_tipo_cliente = c.id_tipo_cliente");
		query.append(" ORDER BY c.id_cliente ASC");
		query.append(" LIMIT ");
		query.append(numeroRegistrosPorPagina * (numeroPagina - 1));
		query.append(" , ");
		query.append(numeroRegistrosPorPagina);
		query.append(";");
		
		List<ClienteDTO> lista = clienteDAO.listaPorCriteriosBusqueda(query.toString());
		
		query = null;
		
		return lista;
	}
	
}
