package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TurnoLaboral;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TurnoLaboralDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("turnoLaboralDAO")
public class TurnoLaboralDaoImpl implements TurnoLaboralDAO {
	
	private static final Logger log = Logger.getLogger(TurnoLaboralDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TurnoLaboralDaoImpl() { }

	public int crea(TurnoLaboral turnoLaboral) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(turnoLaboral);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TurnoLaboral busca(int idTurnoLaboral) {
		TurnoLaboral turnoLaboral = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TurnoLaboral tl where tl.idTurnoLaboral = :idTurnoLaboral");
			query.setParameter("idTurnoLaboral", idTurnoLaboral);
			turnoLaboral = (TurnoLaboral)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return turnoLaboral;
	}

	public void modifica(TurnoLaboral turnoLaboral) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(turnoLaboral);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TurnoLaboral> lista() {
		List<TurnoLaboral> lista = new ArrayList<TurnoLaboral>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from TurnoLaboral tl where tl.activo = true order by tl.idTurnoLaboral asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}	
	
}
