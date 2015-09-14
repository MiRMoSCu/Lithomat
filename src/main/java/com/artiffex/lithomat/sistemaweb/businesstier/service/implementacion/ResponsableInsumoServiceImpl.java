package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ResponsableInsumo;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ResponsableInsumoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ResponsableInsumoDAO;

@Service("responsableInsumoService")
public class ResponsableInsumoServiceImpl implements ResponsableInsumoService {
	
	@Resource
	private ResponsableInsumoDAO responsableInsumoDAO;

	public void creaResponsableInsumo(ResponsableInsumo responsableInsumo) {
		responsableInsumoDAO.crea(responsableInsumo);
	}
	
	public ResponsableInsumo buscaResponsableInsumo(int idResponsableInsumo) {
		return responsableInsumoDAO.busca(idResponsableInsumo);
	}

	public void modificaResponsableInsumo(ResponsableInsumo responsableInsumo) {
		responsableInsumoDAO.modifica(responsableInsumo);
	}

	public List<ResponsableInsumo> listaResponsableInsumo() {
		return responsableInsumoDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<ResponsableInsumo> listaResponsableInsumo = responsableInsumoDAO.lista();
		for (ResponsableInsumo responsableInsumo : listaResponsableInsumo) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(responsableInsumo.getIdResponsableInsumo());
			comboSelect.setText(responsableInsumo.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			responsableInsumo = null;
		}
		listaResponsableInsumo = null;
		return listaComboSelect;
	}

}
