package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoPreprensa;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoPreprensaService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProcesoPreprensaDAO;

@Service("procesoPreprensaService")
public class ProcesoPreprensaServiceImpl implements ProcesoPreprensaService {

	@Resource
	private ProcesoPreprensaDAO procesoPreprensaDAO;

	public void creaProcesoPreprensa(ProcesoPreprensa procesoPreprensa) {
		procesoPreprensaDAO.crea(procesoPreprensa);
	}
	
	public ProcesoPreprensa buscaProcesoPreprensa(int idProcesoPreprensa) {
		return procesoPreprensaDAO.busca(idProcesoPreprensa);
	}

	public void modificaProcesoPreprensa(ProcesoPreprensa procesoPreprensa) {
		procesoPreprensaDAO.modifica(procesoPreprensa);
	}

	public List<ProcesoPreprensa> listaProcesoPreprensa() {
		return procesoPreprensaDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<ProcesoPreprensa> listaProcesoPreprensa = procesoPreprensaDAO.lista();
		for (ProcesoPreprensa procesoPreprensa : listaProcesoPreprensa) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(procesoPreprensa.getIdProcesoPreprensa());
			comboSelect.setText(procesoPreprensa.getNombreProceso());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			procesoPreprensa = null;
		}
		listaProcesoPreprensa = null;
		return listaComboSelect;
	}

}
