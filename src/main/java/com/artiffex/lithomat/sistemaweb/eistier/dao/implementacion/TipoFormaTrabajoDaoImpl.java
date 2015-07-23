package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoFormaTrabajo;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoFormaTrabajoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tipoFormaTrabajoDAO")
public class TipoFormaTrabajoDaoImpl implements TipoFormaTrabajoDAO {
	
	private static final Logger log = Logger.getLogger(TipoFormaTrabajoDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TipoFormaTrabajoDaoImpl() { }

	public int crea(TipoFormaTrabajo tipoFormaTrabajo) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(tipoFormaTrabajo);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TipoFormaTrabajo busca(int idTipoFormaTrabajo) {
		TipoFormaTrabajo tipoFormaTrabajo = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoFormaTrabajo tft where tft.idTipoFormaTrabajo = :idTipoFormaTrabajo");
			query.setParameter("idTipoFormaTrabajo", idTipoFormaTrabajo);
			tipoFormaTrabajo = (TipoFormaTrabajo)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tipoFormaTrabajo;
	}

	public void modifica(TipoFormaTrabajo tipoFormaTrabajo) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(tipoFormaTrabajo);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoFormaTrabajo> lista() {
		List<TipoFormaTrabajo> lista = new ArrayList<TipoFormaTrabajo>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from TipoFormaTrabajo tft where tft.activo = true order by tft.idTipoFormaTrabajo asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
