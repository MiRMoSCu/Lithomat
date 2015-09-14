package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtras;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostosExtrasService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CostosExtrasDAO;

@Service("costosExtrasService")
public class CostosExtrasServiceImpl implements CostosExtrasService {
	
	@Resource
	private CostosExtrasDAO costosExtrasDAO;

	public void creaCostosExtras(CostosExtras costosExtras) {
		costosExtrasDAO.crea(costosExtras);
	}
	
	public CostosExtras buscaCostosExtras(int idCostosExtras) {
		return costosExtrasDAO.busca(idCostosExtras);
	}

	public void modificaCostosExtras(CostosExtras costosExtras) {
		costosExtrasDAO.modifica(costosExtras);
	}

	public List<CostosExtras> listaCostosExtras() {
		return costosExtrasDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<CostosExtras> listaCostosExtras = costosExtrasDAO.lista();
		for (CostosExtras costosExtras : listaCostosExtras) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(costosExtras.getIdCostosExtras());
			comboSelect.setText(costosExtras.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			costosExtras = null;
		}
		listaCostosExtras = null;
		return listaComboSelect;
	}
	
}
