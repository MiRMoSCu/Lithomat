package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPliego;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionPliegoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.GenericJdbcDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("calificacionPliegoDAO")
public class CalificacionPliegoDaoImpl extends GenericJdbcDAO implements CalificacionPliegoDAO {
	
	private static final Logger log = Logger.getLogger(CalificacionPliegoDaoImpl.class);
	private Session sesion;
	
	// consructor
	public CalificacionPliegoDaoImpl() { };

	public int crea(CalificacionPliego calificacionPliego) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(calificacionPliego);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public CalificacionPliego buscaPorPliego(int idPliego) {
		CalificacionPliego calificacionPliego = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CalificacionPliego cp where cp.pliego.idPliego = :idPliego");
			query.setParameter("idPliego", idPliego);
			calificacionPliego = (CalificacionPliego)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return calificacionPliego;
	}

	public void modifica(CalificacionPliego calificacionPliego) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(calificacionPliego);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

}
