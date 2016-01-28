package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTOGrid;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.FechaPrensistaMaquina;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.FechaPrensistaMaquinaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("fechaPrensistaMaquinaDAO")
public class FechaPrensistaMaquinaDaoImpl implements FechaPrensistaMaquinaDAO {
	
	private static final Logger log = Logger.getLogger(FechaPrensistaMaquinaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public FechaPrensistaMaquinaDaoImpl() { }

	public int crea(FechaPrensistaMaquina fechaPrensistaMaquina) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifica(FechaPrensistaMaquina fechaPrensistaMaquina) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int elimina(int idFechaPrensistaMaquina) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<FechaPrensistaMaquina> lista() {
		// TODO Auto-generated method stub
		return null;
	}

	public int numeroRegistrosFechaPrensistaMaquina(String strQuery) {
		int numeroRegistros = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			numeroRegistros = ((BigInteger)query.uniqueResult()).intValue();
			sesion.getTransaction().commit();
			query = null;
		} catch (Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return numeroRegistros;
	}

	@SuppressWarnings("unchecked")
	public List<FechaPrensistaMaquinaDTOGrid> listaPorRango(String strQuery) {
		List<FechaPrensistaMaquinaDTOGrid> lista = new ArrayList<FechaPrensistaMaquinaDTOGrid>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			query.addEntity(FechaPrensistaMaquinaDTOGrid.class);
			lista = query.list();
			sesion.getTransaction().commit();
		} catch( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
