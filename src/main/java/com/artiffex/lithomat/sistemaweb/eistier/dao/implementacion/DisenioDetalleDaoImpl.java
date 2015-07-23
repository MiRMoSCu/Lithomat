package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.DisenioDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.DisenioDetalleDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("disenioDetalleDAO")
public class DisenioDetalleDaoImpl implements DisenioDetalleDAO {
	
	private static final Logger log = Logger.getLogger(DisenioDetalleDaoImpl.class);
	private Session sesion;
	
	// constructor
	public DisenioDetalleDaoImpl() { }

	public int crea(DisenioDetalle disenioDetalle) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(disenioDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public DisenioDetalle busca(int idDisenioDetalle) {
		DisenioDetalle disenioDetalle = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from DisenioDetalle dd where dd.idDisenioDetalle = :idDisenioDetalle");
			query.setParameter("idDisenioDetalle", idDisenioDetalle);
			disenioDetalle = (DisenioDetalle)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return disenioDetalle;
	}

	public void modifica(DisenioDetalle disenioDetalle) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(disenioDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<DisenioDetalle> lista() {
		List<DisenioDetalle> lista = new ArrayList<DisenioDetalle>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from DisenioDetalle dd where dd.activo = true order by dd.idDisenioDetalle asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<DisenioDetalle> listaPorDisenio(int idDisenio) {
		List<DisenioDetalle> lista = new ArrayList<DisenioDetalle>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from DisenioDetalle dd where dd.activo = true and dd.disenio.idDisenio = :idDisenio order by dd.idDisenioDetalle asc");
			query.setParameter("idDisenio", idDisenio); 
			lista = query.list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
