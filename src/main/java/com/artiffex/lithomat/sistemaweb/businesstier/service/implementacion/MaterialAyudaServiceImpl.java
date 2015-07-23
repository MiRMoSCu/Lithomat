package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyuda;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.MaterialAyudaService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.MaterialAyudaDAO;

@Service("materialAyudaService")
public class MaterialAyudaServiceImpl implements MaterialAyudaService {
	
	@Resource
	private MaterialAyudaDAO materialAyudaDAO;

	public void creaMaterialAyuda(MaterialAyuda materialAyuda) {
		materialAyudaDAO.crea(materialAyuda);
	}
	
	public MaterialAyuda buscaMaterialAyuda(int idMaterialAyuda) {
		return materialAyudaDAO.busca(idMaterialAyuda);
	}

	public void modificaMaterialAyuda(MaterialAyuda materialAyuda) {
		materialAyudaDAO.modifica(materialAyuda);
	}

	public List<MaterialAyuda> listaMaterialAyuda() {
		return materialAyudaDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<MaterialAyuda> listaMaterialAyuda = materialAyudaDAO.lista();
		for (MaterialAyuda materialAyuda : listaMaterialAyuda) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(materialAyuda.getIdMaterialAyuda());
			comboSelect.setText(materialAyuda.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			materialAyuda = null;
		}
		listaMaterialAyuda = null;
		return listaComboSelect;
	}

}
