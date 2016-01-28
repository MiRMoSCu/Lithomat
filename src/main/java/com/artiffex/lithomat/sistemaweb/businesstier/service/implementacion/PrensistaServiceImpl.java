package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Prensista;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PrensistaService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PrensistaDAO;

@Service("prensistaService")
public class PrensistaServiceImpl implements PrensistaService {
	
	@Resource
	private PrensistaDAO prensistaDAO;

	public void creaPrensista(Prensista prensista) {
		prensistaDAO.crea(prensista);
	}
	
	public Prensista buscaPrensista(int idPrensista) {
		return prensistaDAO.busca(idPrensista);
	}

	public void modificaPrensista(Prensista prensista) {
		prensistaDAO.modifica(prensista);
	}
	
	public List<Prensista> listaPrensista() {
		return prensistaDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<Prensista> listaPrensista = prensistaDAO.lista();
		for (Prensista prensista : listaPrensista) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(prensista.getIdPrensista());
			comboSelect.setText(prensista.getNombre() + " " + prensista.getApPaterno() + " " + prensista.getApMaterno());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
			prensista	= null;
		}
		listaPrensista = null;
		return listaComboSelect;
	}

}