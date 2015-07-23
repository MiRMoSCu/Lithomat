package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TiempoOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TiempoOrdenProduccionDAO;

@Repository("tiempoOrdenProduccion")
public class TiempoOrdenProduccionDaoImpl implements TiempoOrdenProduccionDAO {
	
	//private static final Logger log = Logger.getLogger(TiempoOrdenProduccionDaoImpl.class);
	//private Session sesion;
	
	// constructor
	public TiempoOrdenProduccionDaoImpl() { }

	public int crea(TiempoOrdenProduccion tiempoOrdenProduccion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifica(TiempoOrdenProduccion tiempoOrdenProduccion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int elimina(int idTiempoOrdenProduccion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<TiempoOrdenProduccion> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
