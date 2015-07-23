package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoCliente;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoClienteService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoClienteDAO;

@Service("tipoClienteService")
public class TipoClienteServiceImpl implements TipoClienteService {
	
	@Resource
	private TipoClienteDAO tipoClienteDAO;

	public void creaTipoCliente(TipoCliente tipoCliente) {
		tipoClienteDAO.crea(tipoCliente);
	}
	
	public TipoCliente buscaTipoCliente(int idTipoCliente) {
		return tipoClienteDAO.busca(idTipoCliente);
	}

	public void modificaTipoCliente(TipoCliente tipoCliente) {
		tipoClienteDAO.modifica(tipoCliente);
	}

	public List<TipoCliente> listaTipoCliente() {
		return tipoClienteDAO.lista();
	}
	
	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<TipoCliente> listaTipoCliente = tipoClienteDAO.lista();
		for (TipoCliente tipoCliente : listaTipoCliente) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(tipoCliente.getIdTipoCliente());
			comboSelect.setText(tipoCliente.getClave());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			tipoCliente = null;
		}
		listaTipoCliente = null;
		return listaComboSelect;
	}
	
}