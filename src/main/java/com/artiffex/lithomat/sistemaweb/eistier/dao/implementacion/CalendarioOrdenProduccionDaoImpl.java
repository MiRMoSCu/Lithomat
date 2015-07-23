package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalendarioOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalendarioOrdenProduccionDAO;

@Repository("calendarioOrdenProduccionDAO")
public class CalendarioOrdenProduccionDaoImpl implements CalendarioOrdenProduccionDAO {
	
	//private static final Logger log = Logger.getLogger(CalendarioOrdenProduccionDaoImpl.class);
	//private Session sesion;
	
	// constructor
	public CalendarioOrdenProduccionDaoImpl() { }

	public int crea(CalendarioOrdenProduccion calendarioOrdenProduccion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifica(CalendarioOrdenProduccion calendarioOrdenProduccion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int elimina(int idCalendarioOrdenProduccion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<CalendarioOrdenProduccion> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
