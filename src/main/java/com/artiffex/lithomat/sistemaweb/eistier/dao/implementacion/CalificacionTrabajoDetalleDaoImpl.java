package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionTrabajoDetalleDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.GenericJdbcDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("calificacionTrabajoDetalleDAO")
public class CalificacionTrabajoDetalleDaoImpl extends GenericJdbcDAO implements CalificacionTrabajoDetalleDAO {
	
	private static final Logger log = Logger.getLogger(CalificacionTrabajoDetalleDaoImpl.class);
	private Session sesion;
	
	// constructor
	public CalificacionTrabajoDetalleDaoImpl() { }

	public int crea(CalificacionTrabajoDetalle calificacionTrabajoDetalle) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(calificacionTrabajoDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public CalificacionTrabajoDetalle buscaPorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		CalificacionTrabajoDetalle calificacionTrabajoDetalle = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CalificacionTrabajoDetalle ctd where ctd.tipoTrabajoDetalle.idTipoTrabajoDetalle = :idTipoTrabajoDetalle");
			query.setParameter("idTipoTrabajoDetalle", idTipoTrabajoDetalle);
			calificacionTrabajoDetalle = (CalificacionTrabajoDetalle)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return calificacionTrabajoDetalle;
	}

	public void modifica(CalificacionTrabajoDetalle calificacionTrabajoDetalle) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(calificacionTrabajoDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

}
