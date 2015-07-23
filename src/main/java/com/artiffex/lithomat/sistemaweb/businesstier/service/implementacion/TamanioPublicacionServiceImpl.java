package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TamanioPublicacion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TamanioPublicacionService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TamanioPublicacionDAO;

@Service("tamanioPublicacionService")
public class TamanioPublicacionServiceImpl implements TamanioPublicacionService {
	
	@Resource
	private TamanioPublicacionDAO tamanioPublicacionDAO;

	public void creaTamanioPublicacion(TamanioPublicacion tamanioPublicacion) {
		tamanioPublicacionDAO.crea(tamanioPublicacion);
	}
	
	public TamanioPublicacion buscaTamanioPublicacion(int idTamanioPublicacion) {
		return tamanioPublicacionDAO.busca(idTamanioPublicacion);
	}

	public void modificaTamanioPublicacion(TamanioPublicacion tamanioPublicacion) {
		tamanioPublicacionDAO.modifica(tamanioPublicacion);
	}

	public List<TamanioPublicacion> listaTamanioPublicacion() {
		return tamanioPublicacionDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<TamanioPublicacion> listaTamanioPublicacion = tamanioPublicacionDAO.lista();
		for (TamanioPublicacion tamanioPublicacion : listaTamanioPublicacion) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(tamanioPublicacion.getIdTamanioPublicacion());
			comboSelect.setText(tamanioPublicacion.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			tamanioPublicacion = null;
		}
		return listaComboSelect;
	}

	public List<TamanioPublicacion> listaDecimales() {
		return tamanioPublicacionDAO.listaDecimales();
	}
	
}
