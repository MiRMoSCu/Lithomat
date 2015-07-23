package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistoricoProduccion;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.HistoricoProduccionDAO;

@Repository("historicoProduccionDAO")
public class HistoricoProduccionDaoImpl implements HistoricoProduccionDAO {
	
	//private static final Logger log = Logger.getLogger(HistoricoProduccionDaoImpl.class);
	//private Session sesion;
	
	// constructor
	public HistoricoProduccionDaoImpl() { }

	public int crea(HistoricoProduccion historicoProduccion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifica(HistoricoProduccion historicoProduccion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int elimina(int idHistoricoProduccion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<HistoricoProduccion> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
