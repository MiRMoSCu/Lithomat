package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Modulo;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ModuloDAO;

@Repository("moduloDAO")
public class ModuloDaoImpl implements ModuloDAO {
	
	//private static final Logger log = Logger.getLogger(ModuloDaoImpl.class);
	//private Session sesion;
	
	// constructor
	public ModuloDaoImpl() { }

	public int crea(Modulo modulo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifica(Modulo modulo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int elimina(int idModulo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Modulo> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
