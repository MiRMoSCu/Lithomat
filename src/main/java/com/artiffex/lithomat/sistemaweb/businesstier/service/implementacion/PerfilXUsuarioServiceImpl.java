package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PerfilXUsuario;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PerfilXUsuarioService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PerfilXUsuarioDAO;

@Service("perfilXUsuarioService")
public class PerfilXUsuarioServiceImpl implements PerfilXUsuarioService {

	@Resource
	private PerfilXUsuarioDAO perfilXUsuarioDAO;
	
	
	public void creaPerfilXUsuario(PerfilXUsuario perfilXUsuario) {
		perfilXUsuarioDAO.crea(perfilXUsuario);
	}

	public PerfilXUsuario buscaPerfilXUsuario(int idPerfilXUsuario) {
		return perfilXUsuarioDAO.busca(idPerfilXUsuario);
	}
	
	public PerfilXUsuario buscaPerfilXUsuarioPorUsuario(int idUsuario) {
		return perfilXUsuarioDAO.buscaPorUsuario(idUsuario);
	}

	public void modificaPerfilXUsuario(PerfilXUsuario perfilXUsuario) {
		perfilXUsuarioDAO.modifica(perfilXUsuario);
	}

	public List<PerfilXUsuario> listaPerfilXUsuario() {
		return perfilXUsuarioDAO.lista();
	}

}
