package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoFormaTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoFormaTrabajoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoFormaTrabajoDAO;

@Service("tipoFormaTrabajoService")
public class TipoFormaTrabajoServiceImpl implements TipoFormaTrabajoService {

	@Resource
	private TipoFormaTrabajoDAO tipoFormaTrabajoDAO;

	public void creaTipoFormaTrabajo(TipoFormaTrabajo tipoFormaTrabajo) {
		tipoFormaTrabajoDAO.crea(tipoFormaTrabajo);
	}
	
	public TipoFormaTrabajo buscaTipoFormaTrabajo(int idTipoFormaTrabajo) {
		return tipoFormaTrabajoDAO.busca(idTipoFormaTrabajo);
	}

	public void modificaTipoFormaTrabajo(TipoFormaTrabajo tipoFormaTrabajo) {
		tipoFormaTrabajoDAO.modifica(tipoFormaTrabajo);
	}

	public List<TipoFormaTrabajo> listaTipoFormaTrabajo() {
		return tipoFormaTrabajoDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<TipoFormaTrabajo> listaTipoFormaTrabajo = tipoFormaTrabajoDAO.lista();
		for (TipoFormaTrabajo tipoFormaTrabajo : listaTipoFormaTrabajo) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(tipoFormaTrabajo.getIdTipoFormaTrabajo());
			comboSelect.setText(tipoFormaTrabajo.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			tipoFormaTrabajo = null;
		}
		listaTipoFormaTrabajo = null;
		return listaComboSelect;
	}

}
