package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorExterno;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProveedorExternoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProveedorExternoDAO;

@Service("proveedorExternoService")
public class ProveedorExternoServiceImpl implements ProveedorExternoService {
	
	@Resource
	private ProveedorExternoDAO proveedorExternoDAO;

	public void creaProveedorExterno(ProveedorExterno proveedorExterno) {
		proveedorExternoDAO.crea(proveedorExterno);
	}
	
	public ProveedorExterno buscaProveedorExterno(int idProveedorExterno) {
		return proveedorExternoDAO.busca(idProveedorExterno);
	}

	public void modificaProveedorExterno(ProveedorExterno proveedorExterno) {
		proveedorExternoDAO.modifica(proveedorExterno);
	}

	public List<ProveedorExterno> listaProveedorExterno() {
		return proveedorExternoDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<ProveedorExterno> listaProveedorExterno = proveedorExternoDAO.lista();
		for (ProveedorExterno proveedorExterno : listaProveedorExterno) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(proveedorExterno.getIdProveedorExterno());
			comboSelect.setText(proveedorExterno.getRazonSocial());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			proveedorExterno = null;
		}
		listaProveedorExterno = null;
		return listaComboSelect;
	}

}