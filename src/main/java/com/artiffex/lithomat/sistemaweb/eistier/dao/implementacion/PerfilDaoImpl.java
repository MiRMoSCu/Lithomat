package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Perfil;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PerfilDAO;

@Repository("perfilDAO")
public class PerfilDaoImpl implements PerfilDAO {
	
	//private static final Logger log = Logger.getLogger(PerfilDaoImpl.class);
	//private Session sesion;
	
	// constructor
	public PerfilDaoImpl() { }

	public int crea(Perfil perfil) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void modifica(Perfil perfil) {
		// TODO Auto-generated method stub
	}

	public void elimina(int idPerfil) {
		// TODO Auto-generated method stub
	}

	public List<Perfil> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
