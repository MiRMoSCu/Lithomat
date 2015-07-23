package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoVuelta;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoVueltaService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoVueltaDAO;

@Service("tipoVueltaService")
public class TipoVueltaServiceImpl implements TipoVueltaService {

	@Resource
	private TipoVueltaDAO tipoVueltaDAO;

	public void creaTipoVuelta(TipoVuelta tipoVuelta) {
		tipoVueltaDAO.crea(tipoVuelta);
	}
	
	public TipoVuelta buscaTipoVuelta(int idTipoVuelta) {
		return tipoVueltaDAO.busca(idTipoVuelta);
	}

	public void modificaTipoVuelta(TipoVuelta tipoVuelta) {
		tipoVueltaDAO.modifica(tipoVuelta);
	}

	public List<TipoVuelta> listaTipoVuelta() {
		return tipoVueltaDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<TipoVuelta> listaTipoVuelta = tipoVueltaDAO.lista();
		for (TipoVuelta tipoVuelta : listaTipoVuelta) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(tipoVuelta.getIdTipoVuelta());
			comboSelect.setText(tipoVuelta.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			tipoVuelta = null;
		}
		listaTipoVuelta = null;
		return listaComboSelect;
		
	}

}
