package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoPrecioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoPrecioDAO;

@Service("tipoPrecioService")
public class TipoPrecioServiceImpl implements TipoPrecioService {

	@Resource
	private TipoPrecioDAO tipoPrecioDAO;

	public void creaTipoPrecio(TipoPrecio tipoPrecio) {
		tipoPrecioDAO.crea(tipoPrecio);
	}
	
	public TipoPrecio buscaTipoPrecio(int idTipoPrecio) {
		return tipoPrecioDAO.busca(idTipoPrecio);
	}

	public void modificaTipoPrecio(TipoPrecio tipoPrecio) {
		tipoPrecioDAO.modifica(tipoPrecio);
	}

	public List<TipoPrecio> listaTipoPrecio() {
		return tipoPrecioDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<TipoPrecio> listaTipoPrecio = tipoPrecioDAO.lista();
		for (TipoPrecio tipoPrecio : listaTipoPrecio) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(tipoPrecio.getIdTipoPrecio());
			comboSelect.setText(tipoPrecio.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
		}
		listaTipoPrecio = null;
		return listaComboSelect;
	}
	
}
