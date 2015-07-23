package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.UsuarioDAO;

@Repository("usuarioDAO")
public class UsuarioDaoImpl implements UsuarioDAO {
	
	//private static final Logger log = Logger.getLogger(UsuarioDaoImpl.class);
	//private Session sesion;
	
	// constructor
	public UsuarioDaoImpl() { }

	public boolean creaUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existeUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modificaUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getRol(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLastUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean validaUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	public Error bajaUsuario(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}// UsuarioDAOImpl
