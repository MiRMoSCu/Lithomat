package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPartida;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionPartidaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("calificacionPartidaDAO")
public class CalificacionPartidaDaoImpl implements CalificacionPartidaDAO {
	
	private static final Logger log = Logger.getLogger(CalificacionPartidaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public CalificacionPartidaDaoImpl() { }

	public int crea(CalificacionPartida calificacionPartida) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(calificacionPartida);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public CalificacionPartida busca(int idCalificacionPartida) {
		CalificacionPartida calificacionProcesosPartida = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CalificacionPartida cp where cp.idCalificacionPartida = :idCalificacionPartida");
			query.setParameter("idCalificacionPartida", idCalificacionPartida);
			calificacionProcesosPartida = (CalificacionPartida)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return calificacionProcesosPartida;
	}

	public CalificacionPartida buscaPorPartida(int idPartida) {
		CalificacionPartida calificacionProcesosPartida = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CalificacionPartida cp where cp.activo = true and cp.partida.idPartida = :idPartida");
			query.setParameter("idPartida", idPartida);
			calificacionProcesosPartida = (CalificacionPartida)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return calificacionProcesosPartida;
	}

	public void modifica(CalificacionPartida calificacionPartida) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(calificacionPartida);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}
	
}
