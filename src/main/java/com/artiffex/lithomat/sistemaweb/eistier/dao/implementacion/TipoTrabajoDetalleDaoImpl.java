package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoTrabajoDetalleDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tipoTrabajoDetalleDAO")
public class TipoTrabajoDetalleDaoImpl implements TipoTrabajoDetalleDAO {
	
	private static final Logger log = Logger.getLogger(TipoTrabajoDetalleDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TipoTrabajoDetalleDaoImpl() { }

	public int crea(TipoTrabajoDetalle tipoTrabajoDetalle) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(tipoTrabajoDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TipoTrabajoDetalle busca(int idTipoTrabajoDetalle) {
		TipoTrabajoDetalle tipoTrabajoDetalle = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoTrabajoDetalle ttd where ttd.idTipoTrabajoDetalle = :idTipoTrabajoDetalle");
			query.setParameter("idTipoTrabajoDetalle", idTipoTrabajoDetalle);
			tipoTrabajoDetalle = (TipoTrabajoDetalle)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tipoTrabajoDetalle;
	}

	public void modifica(TipoTrabajoDetalle tipoTrabajoDetalle) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(tipoTrabajoDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoTrabajoDetalle> lista() {
		List<TipoTrabajoDetalle> lista = new ArrayList<TipoTrabajoDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from TipoTrabajoDetalle ttd where ttd.activo = true order by ttd.idTipoTrabajoDetalle asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<TipoTrabajoDetalle> listaPorPartida(int idPartida) {
		List<TipoTrabajoDetalle> lista = new ArrayList<TipoTrabajoDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoTrabajoDetalle ttd where ttd.activo = true and ttd.partida.idPartida = :idPartida order by ttd.idTipoTrabajoDetalle asc");
			query.setParameter("idPartida", idPartida);
			lista = query.list();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<TipoTrabajoDetalle> listaPorQuery(String strQuery) {
		List<TipoTrabajoDetalle> lista = new ArrayList<TipoTrabajoDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			query.addEntity( TipoTrabajoDetalle.class );
			lista = query.list();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
