package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoTransporte;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ProcesoTransporteService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProcesoTransporteDAO;

@Service("procesoTransporteService")
public class ProcesoTransporteServiceImpl implements ProcesoTransporteService {
	
	@Resource
	private ProcesoTransporteDAO procesoTransporteDAO;

	public void creaProcesoTransporte(ProcesoTransporte procesoTransporte) {
		procesoTransporteDAO.crea(procesoTransporte);
	}
	
	public ProcesoTransporte buscaProcesoTransporte(int idProcesoTransporte) {
		return procesoTransporteDAO.busca(idProcesoTransporte);
	}

	public void modificaProcesoTransporte(ProcesoTransporte procesoTransporte) {
		procesoTransporteDAO.modifica(procesoTransporte);
	}

	public List<ProcesoTransporte> listaProcesoTransporte() {
		return procesoTransporteDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<ProcesoTransporte> listaProcesoTransporte = procesoTransporteDAO.lista();
		for (ProcesoTransporte procesoTransporte : listaProcesoTransporte) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(procesoTransporte.getIdProcesoTransporte());
			comboSelect.setText(procesoTransporte.getNombreProceso());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			procesoTransporte = null;
		}
		listaProcesoTransporte = null;
		return listaComboSelect;
	}

}
