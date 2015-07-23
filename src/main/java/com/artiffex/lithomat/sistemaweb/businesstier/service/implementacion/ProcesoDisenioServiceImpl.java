package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoDisenio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoDisenioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProcesoDisenioDAO;

@Service("procesoDisenioService")
public class ProcesoDisenioServiceImpl implements ProcesoDisenioService {

	@Resource
	private ProcesoDisenioDAO procesoDisenioDAO;

	public void creaProcesoDisenio(ProcesoDisenio procesoDisenio) {
		procesoDisenioDAO.crea(procesoDisenio);
	}
	
	public ProcesoDisenio buscaProcesoDisenio(int idProcesoDisenio) {
		return procesoDisenioDAO.busca(idProcesoDisenio);
	}

	public void modificaProcesoDisenio(ProcesoDisenio procesoDisenio) {
		procesoDisenioDAO.modifica(procesoDisenio);
	}

	public List<ProcesoDisenio> listaProcesoDisenio() {
		return procesoDisenioDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<ProcesoDisenio> listaProcesoDisenio = procesoDisenioDAO.lista();
		for (ProcesoDisenio procesoDisenio : listaProcesoDisenio) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(procesoDisenio.getIdProcesoDisenio());
			comboSelect.setText(procesoDisenio.getNombreProceso());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			procesoDisenio = null;
		}
		listaProcesoDisenio = null;
		return listaComboSelect;
	}

}
