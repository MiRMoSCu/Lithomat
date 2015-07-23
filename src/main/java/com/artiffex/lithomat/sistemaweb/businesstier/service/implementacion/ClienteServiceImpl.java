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
}
