package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaquinaService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.MaquinaDAO;

@Service("maquinaService")
public class MaquinaServiceImpl implements MaquinaService {
	
	@Resource
	private MaquinaDAO maquinaDAO;

	public void creaMaquina(Maquina maquina) {
		maquinaDAO.crea(maquina);
	}
	
	public Maquina buscaMaquina(int idMaquina) {
		return maquinaDAO.busca(idMaquina);
	}

	public void modificaMaquina(Maquina maquina) {
		maquinaDAO.modifica(maquina);
	}

	public List<Maquina> listaMaquina() {
		return maquinaDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<Maquina> listaMaquina = maquinaDAO.lista();
		for (Maquina maquina : listaMaquina) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(maquina.getIdMaquina());
			comboSelect.setText(maquina.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			maquina = null;
		}
		listaMaquina = null;
		return listaComboSelect;
	}
	
}
