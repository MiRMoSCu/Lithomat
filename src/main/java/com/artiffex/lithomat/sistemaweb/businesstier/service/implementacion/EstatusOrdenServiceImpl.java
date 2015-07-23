package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.EstatusOrdenService;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.EstatusOrdenDAO;

@Service("estatusOrdenService")
public class EstatusOrdenServiceImpl implements EstatusOrdenService {
	
	private static final int ESTATUS_CANCELADO 	= 3;
	private static final int ESTATUS_FINALIZADO = 10;
	
	@Resource
	private EstatusOrdenDAO estatusOrdenDAO;
	
	@Resource
	private OrdenProduccionService ordenProduccionService;

	public void creaEstatusOrden(EstatusOrden estatusOrden) {
		estatusOrdenDAO.crea(estatusOrden);
	}
	
	public EstatusOrden buscaEstatusOrden(int idEstatusOrden) {
		return estatusOrdenDAO.busca(idEstatusOrden);
	}

	public void modificaEstatusOrden(EstatusOrden estatusOrden) {
		estatusOrdenDAO.modifica(estatusOrden);
	}

	public List<EstatusOrden> listaEstatusOrden() {
		return estatusOrdenDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<EstatusOrden> listaEstatusOrden = estatusOrdenDAO.lista();
		for (EstatusOrden estatusOrden : listaEstatusOrden) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(estatusOrden.getIdEstatusOrden());
			comboSelect.setText(estatusOrden.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
		}
		listaEstatusOrden = null;
		return listaComboSelect;
	}

	public List<ComboSelect> listaComboSelectEstatusPosiblePorNut(String nut) {
		// si estatus == cancelado, ya no se puede modificar.
		// sino, solo puede escoger los estatus que continuan ya que estan en orden creciente
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		int idEstatusOrden = ordenProduccionService.buscaEstatusOrdenProduccionPorNut(nut);
		if( idEstatusOrden == ESTATUS_CANCELADO ) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(ESTATUS_CANCELADO);
			comboSelect.setText("Cancelado");
			listaComboSelect.add(comboSelect);
			comboSelect = null;
		} else if( idEstatusOrden == ESTATUS_FINALIZADO ) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(ESTATUS_FINALIZADO);
			comboSelect.setText("Finalizado");
			listaComboSelect.add(comboSelect);
			comboSelect = null;
		} else {
			List<EstatusOrden> listaEstatusOrden = estatusOrdenDAO.listaEstatusPosible(nut);
			for (EstatusOrden estatusOrden : listaEstatusOrden) {
				ComboSelect comboSelect = new ComboSelect();
				comboSelect.setValue(estatusOrden.getIdEstatusOrden());
				comboSelect.setText(estatusOrden.getNombre());
				listaComboSelect.add(comboSelect);
				comboSelect = null;
				estatusOrden = null;
			}
			listaEstatusOrden = null;
		}
		return listaComboSelect;
	}
	
}
