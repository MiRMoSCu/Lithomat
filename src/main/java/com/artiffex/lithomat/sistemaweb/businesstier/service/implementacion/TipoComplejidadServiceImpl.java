package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComplejidad;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoComplejidadService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoComplejidadDAO;

@Service("tipoComplejidadService")
public class TipoComplejidadServiceImpl implements TipoComplejidadService {
	
	@Resource
	private TipoComplejidadDAO tipoComplejidadDAO;

	public void creaTipoComplejidad(TipoComplejidad tipoComplejidad) {
		tipoComplejidadDAO.crea(tipoComplejidad);
	}

	public TipoComplejidad buscaTipoComplejidad(int idTipoComplejidad) {
		return tipoComplejidadDAO.busca(idTipoComplejidad);
	}

	public void modificaTipoComplejidad(TipoComplejidad tipoComplejidad) {
		// TODO Auto-generated method stub
		tipoComplejidadDAO.modifica(tipoComplejidad);
	}
	
	public List<TipoComplejidad> listaTipoComplejidad() {
		return tipoComplejidadDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<TipoComplejidad> listaTipoComplejidad = tipoComplejidadDAO.lista();
		for (TipoComplejidad tipoComplejidad : listaTipoComplejidad) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(tipoComplejidad.getIdTipoComplejidad());
			comboSelect.setText(tipoComplejidad.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			tipoComplejidad = null;
		}
		listaTipoComplejidad = null;
		return listaComboSelect;
	}

}
