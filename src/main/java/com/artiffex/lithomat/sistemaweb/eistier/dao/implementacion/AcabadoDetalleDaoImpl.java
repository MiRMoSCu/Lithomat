package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.AcabadoDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.AcabadoDetalleDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("acabadoDetalleDAO")
public class AcabadoDetalleDaoImpl implements AcabadoDetalleDAO {
	
	private static final Logger log = Logger.getLogger(AcabadoDetalleDaoImpl.class);
	private Session sesion;
	
	// constructor
	public AcabadoDetalleDaoImpl() { }

	public int crea(AcabadoDetalle acabadoDetalle) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(acabadoDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public AcabadoDetalle busca(int idAcabadoDetalle) {
		AcabadoDetalle acabadoDetalle = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from AcabadoDetalle ad where ad.idAcabadoDetalle = :idAcabadoDetalle");
			query.setParameter("idAcabadoDetalle", idAcabadoDetalle);
			acabadoDetalle = (AcabadoDetalle)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return acabadoDetalle;
	}

	public void modifica(AcabadoDetalle acabadoDetalle) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(acabadoDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<AcabadoDetalle> lista() {
		List<AcabadoDetalle> lista = new ArrayList<AcabadoDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from AcabadoDetalle ad where ad.activo = true order by ad.idAcabadoDetalle asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<AcabadoDetalle> listaPorAcabado(int idAcabado) {
		List<AcabadoDetalle> lista = new ArrayList<AcabadoDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from AcabadoDetalle ad where ad.activo = true and ad.acabado.idAcabado = :idAcabado order by ad.idAcabadoDetalle asc");
			query.setParameter("idAcabado", idAcabado); 
			lista = query.list();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	
}
