package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TamanioPublicacion;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TamanioPublicacionDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tamanioPublicacion")
public class TamanioPublicacionDaoImpl implements TamanioPublicacionDAO {
	
	private static final Logger log = Logger.getLogger(TamanioPublicacionDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TamanioPublicacionDaoImpl() { }

	public int crea(TamanioPublicacion tamanioPublicacion) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(tamanioPublicacion);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TamanioPublicacion busca(int idTamanioPublicacion) {
		TamanioPublicacion tamanioPublicacion = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TamanioPublicacion tp where tp.idTamanioPublicacion = :idTamanioPublicacion");
			query.setParameter("idTamanioPublicacion", idTamanioPublicacion);
			tamanioPublicacion = (TamanioPublicacion)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tamanioPublicacion;
	}

	public void modifica(TamanioPublicacion tamanioPublicacion) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(tamanioPublicacion);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TamanioPublicacion> lista() {
		List<TamanioPublicacion> lista = new ArrayList<TamanioPublicacion>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from TamanioPublicacion tp where tp.activo = true order by tp.numeroPaginas asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<TamanioPublicacion> listaDecimales() {
		List<TamanioPublicacion> lista = new ArrayList<TamanioPublicacion>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from TamanioPublicacion tp where tp.activo = true and tp.numeroDecimal <> 0 order by tp.numeroPaginas asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
