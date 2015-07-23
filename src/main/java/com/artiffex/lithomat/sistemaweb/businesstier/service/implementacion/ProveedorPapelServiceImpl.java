package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorPapel;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProveedorPapelService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProveedorPapelDAO;

@Service("proveedorPapelService")
public class ProveedorPapelServiceImpl implements ProveedorPapelService {
	
	@Resource
	private ProveedorPapelDAO proveedorPapelDAO;

	public void creaProveedorPapel(ProveedorPapel proveedorPapel) {
		proveedorPapelDAO.crea(proveedorPapel);
	}
	
	public ProveedorPapel buscaProveedorPapel(int idProveedorPapel) {
		return proveedorPapelDAO.busca(idProveedorPapel);
	}

	public void modificaProveedorPapel(ProveedorPapel proveedorPapel) {
		proveedorPapelDAO.modifica(proveedorPapel);
	}

	public List<ProveedorPapel> listaProveedorPapel() {
		return proveedorPapelDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<ProveedorPapel> listaProveedorPapel = proveedorPapelDAO.lista();
		for (ProveedorPapel proveedorPapel : listaProveedorPapel) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(proveedorPapel.getIdProveedorPapel());
			comboSelect.setText(proveedorPapel.getRazonSocial());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			proveedorPapel = null;
		}
		listaProveedorPapel = null;
		return listaComboSelect;
	}

}