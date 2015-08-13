package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Perfil;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PerfilService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PerfilDAO;

@Service("perfilService")
public class PerfilServiceImpl implements PerfilService {
	
	@Resource
	private PerfilDAO perfilDAO;

	public int creaPerfil(Perfil perfil) {
		return perfilDAO.crea(perfil);
	}

	public Perfil buscaPerfil(int idPerfil) {
		return perfilDAO.busca(idPerfil);
	}

	public void modificaPerfil(Perfil perfil) {
		perfilDAO.modifica(perfil);
	}

	public List<Perfil> listaPerfil() {
		return perfilDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<Perfil> listaPerfil = perfilDAO.lista();
		for (Perfil perfil : listaPerfil) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(perfil.getIdPerfil());
			comboSelect.setText(perfil.getNombre());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
		}
		listaPerfil = null;
		return listaComboSelect;
	}
	
}