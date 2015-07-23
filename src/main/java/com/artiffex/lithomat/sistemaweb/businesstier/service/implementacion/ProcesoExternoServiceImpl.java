package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoExterno;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoExternoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProcesoExternoDAO;

@Service("procesoExternoService")
public class ProcesoExternoServiceImpl implements ProcesoExternoService {
	
	@Resource
	private ProcesoExternoDAO procesoExternoDAO;

	public void creaProcesoExterno(ProcesoExterno procesoExterno) {
		procesoExternoDAO.crea(procesoExterno);
	}
	
	public ProcesoExterno buscaProcesoExterno(int idProcesoExterno) {
		return procesoExternoDAO.busca(idProcesoExterno);
	}

	public void modificaProcesoExterno(ProcesoExterno procesoExterno) {
		procesoExternoDAO.modifica(procesoExterno);
	}

	public List<ProcesoExterno> listaProcesoExterno() {
		return procesoExternoDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<ProcesoExterno> listaProcesoExterno = procesoExternoDAO.lista();
		for (ProcesoExterno procesoExterno : listaProcesoExterno) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(procesoExterno.getIdProcesoExterno());
			comboSelect.setText(procesoExterno.getNombreProceso() + " (" + procesoExterno.getTipoPrecio().getNombre() + ")" );
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			procesoExterno = null;
		}
		listaProcesoExterno = null;
		return listaComboSelect;
	}

}
