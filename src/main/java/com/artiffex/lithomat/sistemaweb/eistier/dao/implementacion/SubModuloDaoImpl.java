package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.SubModulo;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.SubModuloDAO;

@Repository("subModuloDAO")
public class SubModuloDaoImpl implements SubModuloDAO {
	
	//private static final Logger log = Logger.getLogger(SubModuloDaoImpl.class);
	//private Session sesion;
	
	// constructor
	public SubModuloDaoImpl() { }

	public int crea(SubModulo subModulo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifica(SubModulo subModulo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int elimina(int idSubModulo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<SubModulo> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
