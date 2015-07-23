package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoBarniz;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoBarnizService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoBarnizDAO;

@Service("tipoBarnizService")
public class TipoBarnizServiceImpl implements TipoBarnizService {
	
	@Resource
	private TipoBarnizDAO tipoBarnizDAO;

	public void creaTipoBarniz(TipoBarniz tipoBarniz) {
		tipoBarnizDAO.crea(tipoBarniz);
	}
	
	public TipoBarniz buscaTipoBarniz(int idTipoBarniz) {
		return tipoBarnizDAO.busca(idTipoBarniz);
	}

	public void modificaTipoBarniz(TipoBarniz tipoBarniz) {
		tipoBarnizDAO.modifica(tipoBarniz);
	}

	public List<TipoBarniz> listaTipoBarniz() {
		return tipoBarnizDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<TipoBarniz> listaTipoBarniz = tipoBarnizDAO.lista();
		for (TipoBarniz tipoBarniz : listaTipoBarniz) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(tipoBarniz.getIdTipoBarniz());
			comboSelect.setText(tipoBarniz.getDescripcion());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			tipoBarniz = null;
		}
		listaTipoBarniz = null;
		return listaComboSelect;
	}

}
