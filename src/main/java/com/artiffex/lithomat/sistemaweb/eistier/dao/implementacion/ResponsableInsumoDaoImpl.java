package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ResponsableInsumo;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ResponsableInsumoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("responsableInsumoDAO")
public class ResponsableInsumoDaoImpl implements ResponsableInsumoDAO {
	
	private static final Logger log = Logger.getLogger(ResponsableInsumoDaoImpl.class);
	private Session sesion;
	
	// constructor
	public ResponsableInsumoDaoImpl() { }

	public int crea(ResponsableInsumo responsableInsumo) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(responsableInsumo);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public ResponsableInsumo busca(int idResponsableInsumo) {
		ResponsableInsumo responsableInsumo = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from ResponsableInsumo ri where ri.idResponsableInsumo = :idResponsableInsumo");
			query.setParameter("idResponsableInsumo", idResponsableInsumo);
			responsableInsumo = (ResponsableInsumo)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return responsableInsumo;
	}

	public void modifica(ResponsableInsumo responsableInsumo) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(responsableInsumo);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ResponsableInsumo> lista() {
		List<ResponsableInsumo> lista = new ArrayList<ResponsableInsumo>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from ResponsableInsumo ri where ri.activo = true order by ri.idResponsableInsumo asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
