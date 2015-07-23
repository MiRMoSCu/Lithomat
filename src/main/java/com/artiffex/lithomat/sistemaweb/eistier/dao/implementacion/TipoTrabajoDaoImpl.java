package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajo;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoTrabajoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tipoTrabajoDAO")
public class TipoTrabajoDaoImpl implements TipoTrabajoDAO {
	
	private static final Logger log = Logger.getLogger(TipoTrabajoDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TipoTrabajoDaoImpl() { }

	public int crea(TipoTrabajo tipoTrabajo) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(tipoTrabajo);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TipoTrabajo busca(int idTipoTrabajo) {
		TipoTrabajo tipoTrabajo = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoTrabajo tt where tt.idTipoTrabajo = :v");
			query.setParameter("idTipoTrabajo", idTipoTrabajo);
			tipoTrabajo = (TipoTrabajo)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tipoTrabajo;
	}

	public void modifica(TipoTrabajo tipoTrabajo) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(tipoTrabajo);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoTrabajo> lista() {
		List<TipoTrabajo> lista = new ArrayList<TipoTrabajo>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from TipoTrabajo tt where tt.activo = true order by tt.idTipoTrabajo asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
