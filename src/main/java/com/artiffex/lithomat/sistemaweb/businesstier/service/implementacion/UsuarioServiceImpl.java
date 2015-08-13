package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.UsuarioService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.UsuarioDAO;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Resource
	private UsuarioDAO usuarioDAO;
	

	public void creaUsuario(Usuario usuario) {
		usuarioDAO.crea(usuario);
	}

	public void modificaUsuario(Usuario usuario) {
		usuarioDAO.modifica(usuario);
	}

	public Usuario buscaUsuario(int idUsuario) {
		return usuarioDAO.busca(idUsuario);
	}

	public List<Usuario> listaUsuario() {
		return usuarioDAO.lista();
	}

	public List<ComboSelect> listaComboSelect() {
		List<ComboSelect> listaComboSelect = new ArrayList<ComboSelect>();
		List<Usuario> listaUsuario = usuarioDAO.lista();
		for (Usuario usuario : listaUsuario) {
			ComboSelect comboSelect = new ComboSelect();
			comboSelect.setValue(usuario.getIdUsuario());
			comboSelect.setText(usuario.getNombre() + " " + usuario.getApPaterno() + " " + usuario.getApMaterno());
			listaComboSelect.add(comboSelect);
			comboSelect = null;
		}
		listaUsuario = null;
		return listaComboSelect;
	}
	
}// UsuarioServiceImpl
