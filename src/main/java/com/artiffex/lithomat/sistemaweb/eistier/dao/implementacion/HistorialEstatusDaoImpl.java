package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistorialEstatus;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.HistorialEstatusDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("historialEstatusDAO")
public class HistorialEstatusDaoImpl implements HistorialEstatusDAO {
	
	private static final Logger log = Logger.getLogger(HistorialEstatusDaoImpl.class);
	private Session sesion;
	
	// constructor
	public HistorialEstatusDaoImpl() { }

	public int crea(HistorialEstatus historialEstatus) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(historialEstatus);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public HistorialEstatus busca(int idHistorialEstatus) {
		HistorialEstatus historialEstatus = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from HistorialEstatus he where he.idHistorialEstatus = :idHistorialEstatus");
			query.setParameter("idHistorialEstatus", idHistorialEstatus);
			historialEstatus = (HistorialEstatus)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return historialEstatus;
	}
	
	public HistorialEstatus buscaPorOrdenProduccion(int idOrdenProduccion) {
		HistorialEstatus historialEstatus = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from HistorialEstatus he where he.ordenProduccion.idOrdenProduccion = :idOrdenProduccion order by he.idHistorialEstatus desc limit 1");
			query.setParameter("idOrdenProduccion", idOrdenProduccion);
			historialEstatus = (HistorialEstatus)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return historialEstatus;
	}

	public void modifica(HistorialEstatus historialEstatus) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(historialEstatus);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<HistorialEstatus> lista(int idOrdenProduccion) {
		List<HistorialEstatus> lista = new ArrayList<HistorialEstatus>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from HistorialEstatus he where he.activo = true order by he.idHistorialEstatus asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<HistorialEstatus> listaPorOrdenProduccion(int idOrdenProduccion) {
		List<HistorialEstatus> lista = new ArrayList<HistorialEstatus>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from HistorialEstatus he where he.activo = true and he.ordenProduccion.idOrdenProduccion = :idOrdenProduccion order by he.idHistorialEstatus asc"); 
			query.setParameter("idOrdenProduccion", idOrdenProduccion);
			lista = query.list(); 
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
