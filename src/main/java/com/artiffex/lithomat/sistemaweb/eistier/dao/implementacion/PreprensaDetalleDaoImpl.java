package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PreprensaDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PreprensaDetalleDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("preprensaDetalleDAO")
public class PreprensaDetalleDaoImpl implements PreprensaDetalleDAO {
	
	private static final Logger log = Logger.getLogger(PreprensaDetalleDaoImpl.class);
	private Session sesion;
	
	// constructor 
	public PreprensaDetalleDaoImpl () { }

	public int crea(PreprensaDetalle preprensaDetalle) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(preprensaDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public PreprensaDetalle busca(int idPreprensaDetalle) {
		PreprensaDetalle preprensaDetalle = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from PreprensaDetalle pd where pd.idPreprensaDetalle = :idPreprensaDetalle");
			query.setParameter("idPreprensaDetalle", idPreprensaDetalle);
			preprensaDetalle = (PreprensaDetalle)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return preprensaDetalle;
	}

	public void modifica(PreprensaDetalle preprensaDetalle) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(preprensaDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<PreprensaDetalle> lista() {
		List<PreprensaDetalle> lista = new ArrayList<PreprensaDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from PreprensaDetalle pd where pd.activo = true order by pd.idPreprensaDetalle asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<PreprensaDetalle> listaPorPreprensa(int idPreprensa) {
		List<PreprensaDetalle> lista = new ArrayList<PreprensaDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from PreprensaDetalle pd where pd.activo = true and pd.preprensa.idPreprensa = :idPreprensa order by pd.idPreprensaDetalle asc");
			query.setParameter("idPreprensa", idPreprensa); 
			lista = query.list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
