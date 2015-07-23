package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Perfil;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PerfilService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PerfilDAO;

@Service("perfilService")
public class PerfilServiceImpl implements PerfilService {
	
	@Resource
	private PerfilDAO perfilDAO;

	public int creaPerfil(Perfil perfil) {
		return perfilDAO.crea(perfil);
	}

	public int modificaPerfil(Perfil perfil) {
		return perfilDAO.modifica(perfil);
	}

	public int eliminaPerfil(int idPerfil) {
		return perfilDAO.elimina(idPerfil);
	}

	public List<Perfil> listaPerfil() {
		return perfilDAO.lista();
	}
}