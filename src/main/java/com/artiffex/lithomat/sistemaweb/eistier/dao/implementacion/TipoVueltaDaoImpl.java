package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoVuelta;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoVueltaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tipoVueltaDAO")
public class TipoVueltaDaoImpl implements TipoVueltaDAO {
	
	private static final Logger log = Logger.getLogger(TipoVueltaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TipoVueltaDaoImpl() { }

	public int crea(TipoVuelta tipoVuelta) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(tipoVuelta);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TipoVuelta busca(int idTipoVuelta) {
		TipoVuelta tipoVuelta = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoVuelta tv where tv.idTipoVuelta = :idTipoVuelta");
			query.setParameter("idTipoVuelta", idTipoVuelta);
			tipoVuelta = (TipoVuelta)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tipoVuelta;
	}

	public void modifica(TipoVuelta tipoVuelta) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(tipoVuelta);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoVuelta> lista() {
		List<TipoVuelta> lista = new ArrayList<TipoVuelta>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from TipoVuelta tv where tv.activo = true order by tv.idTipoVuelta asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
