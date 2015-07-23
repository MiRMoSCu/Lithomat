package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoBarniz;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoBarnizDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tipoBarnizDAO")
public class TipoBarnizDaoImpl implements TipoBarnizDAO {
	
	private static final Logger log = Logger.getLogger(TipoBarnizDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TipoBarnizDaoImpl() { }

	public int crea(TipoBarniz tipoBarniz) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(tipoBarniz);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TipoBarniz busca(int idTipoBarniz) {
		TipoBarniz tipoBarniz = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoBarniz tb where tb.idTipoBarniz = :idTipoBarniz");
			query.setParameter("idTipoBarniz", idTipoBarniz);
			tipoBarniz = (TipoBarniz)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tipoBarniz;
	}

	public void modifica(TipoBarniz tipoBarniz) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(tipoBarniz);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoBarniz> lista() {
		List<TipoBarniz> lista = new ArrayList<TipoBarniz>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from TipoBarniz tb where tb.activo = true order by tb.numEntradasMaquina asc, tb.numPlacas asc, tb.idTipoBarniz asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
