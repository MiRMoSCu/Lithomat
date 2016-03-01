package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtraDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CostoExtraDetalleDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("costoExtraDetalleDAO")
public class CostoExtraDetalleDaoImpl implements CostoExtraDetalleDAO {
	
	private static final Logger log = Logger.getLogger(CostoExtraDetalleDaoImpl.class);
	private Session sesion;
	
	// constructor
	public CostoExtraDetalleDaoImpl() { }

	public int crea(CostoExtraDetalle costoExtraDetalle) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(costoExtraDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public CostoExtraDetalle busca(int idCostoExtraDetalle) {
		CostoExtraDetalle costoExtraDetalle = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CostoExtraDetalle ced where ced.idCostoExtraDetalle = :idCostoExtraDetalle");
			query.setParameter("idCostoExtraDetalle", idCostoExtraDetalle);
			costoExtraDetalle = (CostoExtraDetalle)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return costoExtraDetalle;
	}

	public void modifica(CostoExtraDetalle costoExtraDetalle) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(costoExtraDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CostoExtraDetalle> lista() {
		List<CostoExtraDetalle> lista = new ArrayList<CostoExtraDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from CostoExtraDetalle ced where ced.activo = true order by ced.idCostoExtraDetalle asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<CostoExtraDetalle> listaPorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		List<CostoExtraDetalle> lista = new ArrayList<CostoExtraDetalle>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CostoExtraDetalle ced where ced.activo = true and ced.tipoTrabajoDetalle.idTipoTrabajoDetalle = :idTipoTrabajoDetalle order by ced.idCostoExtraDetalle asc");
			query.setParameter("idTipoTrabajoDetalle", idTipoTrabajoDetalle); 
			lista = query.list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
