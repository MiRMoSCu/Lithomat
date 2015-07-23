package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComprobanteFiscal;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoComprobanteFiscalService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoComprobanteFiscalDAO;

@Service("tipoComprobanteFiscalService")
public class TipoComprobanteFiscalServiceImpl implements TipoComprobanteFiscalService {
	
	@Resource
	private TipoComprobanteFiscalDAO tipoComprobanteFiscalDAO;

	public void creaTipoComprobanteFiscal(TipoComprobanteFiscal tipoComprobanteFiscal) {
		tipoComprobanteFiscalDAO.crea(tipoComprobanteFiscal);
	}
	
	public TipoComprobanteFiscal buscaTipoComprobanteFiscal(int idTipoComprobanteFiscal) {
		return tipoComprobanteFiscalDAO.busca(idTipoComprobanteFiscal);
	}

	public void modificaTipoComprobanteFiscal(TipoComprobanteFiscal tipoComprobanteFiscal) {
		tipoComprobanteFiscalDAO.modifica(tipoComprobanteFiscal);
	}

	public List<TipoComprobanteFiscal> listaTipoComprobanteFiscal() {
		return tipoComprobanteFiscalDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<TipoComprobanteFiscal> listaTipoComprobanteFiscal = tipoComprobanteFiscalDAO.lista();
		for (TipoComprobanteFiscal tipoComprobanteFiscal : listaTipoComprobanteFiscal) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(tipoComprobanteFiscal.getIdTipoComprobanteFiscal());
			comboSelect.setText(tipoComprobanteFiscal.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			tipoComprobanteFiscal = null;
		}
		listaTipoComprobanteFiscal = null;
		return listaComboSelect;
	}

}
