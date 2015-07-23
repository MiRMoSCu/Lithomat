package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionProcesosPartida;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionProcesosPartidaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("calificacionProcesosPartidaDAO")
public class CalificacionProcesosPartidaDaoImpl implements CalificacionProcesosPartidaDAO {
	
	private static final Logger log = Logger.getLogger(CalificacionProcesosPartidaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public CalificacionProcesosPartidaDaoImpl() { }

	public int crea(CalificacionProcesosPartida calificacionProcesosPartida) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(calificacionProcesosPartida);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public CalificacionProcesosPartida busca(int idCalificacionProcesosPartida) {
		CalificacionProcesosPartida calificacionProcesosPartida = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CalificacionProcesosPartida cpp where cpp.idCalificacionProcesosPartida = :idCalificacionProcesosPartida");
			query.setParameter("idCalificacionProcesosPartida", idCalificacionProcesosPartida);
			calificacionProcesosPartida = (CalificacionProcesosPartida)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return calificacionProcesosPartida;
	}

	public CalificacionProcesosPartida buscaPorPartida(int idPartida) {
		CalificacionProcesosPartida calificacionProcesosPartida = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CalificacionProcesosPartida cpp where cpp.activo = true and cpp.partida.idPartida = :idPartida");
			query.setParameter("idPartida", idPartida);
			calificacionProcesosPartida = (CalificacionProcesosPartida)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return calificacionProcesosPartida;
	}

	public void modifica(CalificacionProcesosPartida resumenCalificacionPartida) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(resumenCalificacionPartida);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}
	
}
