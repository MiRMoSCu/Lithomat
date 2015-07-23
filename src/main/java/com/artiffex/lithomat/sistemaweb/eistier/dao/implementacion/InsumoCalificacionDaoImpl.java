package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.InsumoCalificacion;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.InsumoCalificacionDAO;

@Repository("insumoCalificacionDAO")
public class InsumoCalificacionDaoImpl implements InsumoCalificacionDAO {
	
	//private static final Logger log = Logger.getLogger(InsumoCalificacionDaoImpl.class);
	//private Session sesion;
	
	// constructor
	public InsumoCalificacionDaoImpl() { }

	public int crea(InsumoCalificacion insumoCalificacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifica(InsumoCalificacion insumoCalificacion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int elimina(int idEstatusOrden) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<InsumoCalificacion> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
