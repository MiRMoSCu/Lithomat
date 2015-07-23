package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPrecio;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoPrecioDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tipoPrecioDAO")
@Transactional
public class TipoPrecioDaoImpl implements TipoPrecioDAO {
	
	private static final Logger log = Logger.getLogger(TipoPrecioDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TipoPrecioDaoImpl() { }

	public int crea(TipoPrecio tipoPrecio) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(tipoPrecio);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TipoPrecio busca(int idTipoPrecio) {
		TipoPrecio tipoPrecio = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoPrecio tp where tp.idTipoPrecio = :idTipoPrecio");
			query.setParameter("idTipoPrecio", idTipoPrecio);
			tipoPrecio = (TipoPrecio)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tipoPrecio;
	}

	public void modifica(TipoPrecio tipoPrecio) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(tipoPrecio);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoPrecio> lista() {
		List<TipoPrecio> lista = new ArrayList<TipoPrecio>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from TipoPrecio tp where tp.activo = true").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
