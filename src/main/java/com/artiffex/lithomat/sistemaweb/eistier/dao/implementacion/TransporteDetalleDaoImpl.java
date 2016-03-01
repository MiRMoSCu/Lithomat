package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TransporteDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TransporteDetalleDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("transporteDetalleDAO")
public class TransporteDetalleDaoImpl implements TransporteDetalleDAO {
	
	private static final Logger log = Logger.getLogger(TransporteDetalleDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TransporteDetalleDaoImpl() { }

	public int crea(TransporteDetalle transporteDetalle) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(transporteDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public TransporteDetalle busca(int idTransporteDetalle) {
		TransporteDetalle transporteDetalle = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TransporteDetalle td where td.idTransporteDetalle = :idTransporteDetalle");
			query.setParameter("idTransporteDetalle", idTransporteDetalle);
			transporteDetalle = (TransporteDetalle)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return transporteDetalle;
	}

	public void modifica(TransporteDetalle transporteDetalle) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(transporteDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TransporteDetalle> lista() {
		List<TransporteDetalle> lista = new ArrayList<TransporteDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from TransporteDetalle td where td.activo = true order by td.idTransporteDetalle asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<TransporteDetalle> listaPorTransporte(int idTransporte) {
		List<TransporteDetalle> lista = new ArrayList<TransporteDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TransporteDetalle td where td.activo = true and td.transporte.idTransporte = :idTransporte order by td.idTransporteDetalle asc");
			query.setParameter("idTransporte", idTransporte); 
			lista = query.list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
