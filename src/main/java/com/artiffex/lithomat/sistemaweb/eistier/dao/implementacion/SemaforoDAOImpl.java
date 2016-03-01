package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.SemaforoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("semaforoDAO")
public class SemaforoDAOImpl implements SemaforoDAO {
	
	private static final Logger log = Logger.getLogger(SemaforoDAOImpl.class);
	private Session sesion;
	
	// constructor
	public SemaforoDAOImpl() { }

	public int numeroRegistros(String strQuery) {
		int numeroRegistros = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			numeroRegistros = ((BigInteger)query.uniqueResult()).intValue();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return numeroRegistros;
	}

	@SuppressWarnings("unchecked")
	public List<VisualizadorDTO> listaPorCriterioBusqueda(String strQuery) {
		List<VisualizadorDTO> lista = new ArrayList<VisualizadorDTO>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			query.setResultTransformer(Transformers.aliasToBean(VisualizadorDTO.class));
			lista = query.list();
			sesion.getTransaction().commit();
		} catch( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
