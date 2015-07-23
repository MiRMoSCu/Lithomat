package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoFormacion;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoFormacionDAO;

@Repository("tipoFormacionDAO")
public class TipoFormacionDaoImpl implements TipoFormacionDAO {
	
	//private static final Logger log = Logger.getLogger(TipoFormacionDaoImpl.class);
	//private Session sesion;
	
	// constructor
	public TipoFormacionDaoImpl() { }

	public int crea(TipoFormacion tipoFormacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifica(TipoFormacion tipoFormacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int elimina(int idTipoFormacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<TipoFormacion> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
