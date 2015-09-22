package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtra;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostoExtraService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CostoExtraDAO;

@Service("costoExtraService")
public class CostoExtraServiceImpl implements CostoExtraService {
	
	@Resource
	private CostoExtraDAO costoExtraDAO;

	public void creaCostoExtra(CostoExtra costoExtra) {
		costoExtraDAO.crea(costoExtra);
	}
	
	public CostoExtra buscaCostoExtra(int idCostoExtra) {
		return costoExtraDAO.busca(idCostoExtra);
	}

	public void modificaCostoExtra(CostoExtra costoExtra) {
		costoExtraDAO.modifica(costoExtra);
	}

	public List<CostoExtra> listaCostoExtra() {
		return costoExtraDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<CostoExtra> listaCostoExtra = costoExtraDAO.lista();
		for (CostoExtra costoExtra : listaCostoExtra) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(costoExtra.getIdCostoExtra());
			comboSelect.setText(costoExtra.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			costoExtra 	= null;
		}
		listaCostoExtra = null;
		return listaComboSelect;
	}
}
