package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTO;
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
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(fechaPrensistaMaquina);
			sesion.getTransaction().commit();
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public int modifica(FechaPrensistaMaquina fechaPrensistaMaquina) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void eliminaPorIdPliego(int idPliego) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from FechaPrensistaMaquina fpm where fpm.activo = true and fpm.pliego.idPliego = :idPliego");
			query.setParameter("idPliego", idPliego);
			sesion.delete( (FechaPrensistaMaquina)query.uniqueResult() );
			sesion.getTransaction().commit();
			query = null;
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	public List<FechaPrensistaMaquina> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<FechaPrensistaMaquinaDTO> buscaFechaPrensistaMaquinaDTO(String strQuery) {
		List<FechaPrensistaMaquinaDTO> lista = new ArrayList<FechaPrensistaMaquinaDTO>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			query.setResultTransformer(Transformers.aliasToBean(FechaPrensistaMaquinaDTO.class));
			lista = query.list();
			sesion.getTransaction().commit();
			query = null;
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
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
			query.setResultTransformer(Transformers.aliasToBean(FechaPrensistaMaquinaDTOGrid.class));
			lista = query.list();
			sesion.getTransaction().commit();
			query = null;
		} catch( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
