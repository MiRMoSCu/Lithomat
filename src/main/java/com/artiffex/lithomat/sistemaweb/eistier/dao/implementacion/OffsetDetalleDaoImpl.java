package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.OffsetDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.GenericJdbcDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.OffsetDetalleDAO;

@Repository("offsetDetalleDAO")
public class OffsetDetalleDaoImpl extends GenericJdbcDAO implements OffsetDetalleDAO {
	
	//private static final Logger log = Logger.getLogger(OffsetDetalleDaoImpl.class);
	//private Session sesion;
	
	// constructor
	public OffsetDetalleDaoImpl() { }

	public int crea(OffsetDetalle offsetDetalle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifica(OffsetDetalle offsetDetalle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int elimina(int idOffsetDetalle) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<OffsetDetalle> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
