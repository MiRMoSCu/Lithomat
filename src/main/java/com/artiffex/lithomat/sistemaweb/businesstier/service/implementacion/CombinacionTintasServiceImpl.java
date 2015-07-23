package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CombinacionTintas;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CombinacionTintasService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CombinacionTintasDAO;

@Service("combinacionTintasService")
public class CombinacionTintasServiceImpl implements CombinacionTintasService {
	
	@Resource
	private CombinacionTintasDAO combinacionTintasDAO;

	public void creaCombinacionTintas(CombinacionTintas combinacionTintas) {
		combinacionTintasDAO.crea(combinacionTintas);
	}
	
	public CombinacionTintas buscaCombinacionTintas(int idCombinacionTintas) {
		return combinacionTintasDAO.busca(idCombinacionTintas);
	}

	public void modificaCombinacionTintas(CombinacionTintas combinacionTintas) {
		combinacionTintasDAO.modifica(combinacionTintas);
	}

	public List<CombinacionTintas> listaCombinacionTintas() {
		return combinacionTintasDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<CombinacionTintas> listaCombinacionTintas = combinacionTintasDAO.lista();
		for (CombinacionTintas combinacionTintas : listaCombinacionTintas) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(combinacionTintas.getIdCombinacionTintas());
			comboSelect.setText(combinacionTintas.getDescripcion());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			combinacionTintas = null;
		}
		listaCombinacionTintas = null;
		return listaComboSelect;
	}

}
