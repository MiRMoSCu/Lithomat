package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Pliego;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PliegoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("pliegoDAO")
public class PliegoDaoImpl implements PliegoDAO {
	
	private static final Logger log = Logger.getLogger(PliegoDaoImpl.class);
	private Session sesion;
	
	// constructor
	public PliegoDaoImpl() { }

	public int crea(Pliego pliego) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(pliego);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public Pliego busca(int idPliego) {
		Pliego pliego = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from Pliego p where p.idPliego = :idPliego");
			query.setParameter("idPliego", idPliego);
			pliego = (Pliego)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return pliego;
	}

	public void modifica(Pliego pliego) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(pliego);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pliego> lista() {
		List<Pliego> lista = new ArrayList<Pliego>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from Pliego p where p.activo = true order by p.idPliego asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pliego> listaPorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		List<Pliego> lista = new ArrayList<Pliego>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from Pliego p where p.activo = true and p.tipoTrabajoDetalle.idTipoTrabajoDetalle = :idTipoTrabajoDetalle order by p.idPliego asc");
			query.setParameter("idTipoTrabajoDetalle", idTipoTrabajoDetalle);
			lista = query.list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	public int numeroPliegosPorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		int contador = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery("SELECT COUNT(*) FROM pliego p WHERE p.activo = TRUE AND p.id_tipo_trabajo_detalle = :idTipoTrabajoDetalle");
			query.setParameter("idTipoTrabajoDetalle", idTipoTrabajoDetalle);
			contador = ((BigInteger)query.uniqueResult()).intValue();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return contador;
	}
	
}
