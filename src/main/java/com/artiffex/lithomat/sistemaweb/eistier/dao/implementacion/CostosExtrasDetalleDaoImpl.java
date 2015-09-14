package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtrasDetalle;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CostosExtrasDetalleDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("costosExtrasDetalleDAO")
public class CostosExtrasDetalleDaoImpl implements CostosExtrasDetalleDAO {
	
	private static final Logger log = Logger.getLogger(CostosExtrasDetalleDaoImpl.class);
	private Session sesion;
	
	// constructor
	public CostosExtrasDetalleDaoImpl() { }

	public int crea(CostosExtrasDetalle costosExtrasDetalle) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(costosExtrasDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public CostosExtrasDetalle busca(int idCostosExtrasDetalle) {
		CostosExtrasDetalle costosExtrasDetalle = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CostosExtrasDetalle ced where ced.idCostosExtrasDetalle = :idCostosExtrasDetalle");
			query.setParameter("idCostosExtrasDetalle", idCostosExtrasDetalle);
			costosExtrasDetalle = (CostosExtrasDetalle)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return costosExtrasDetalle;
	}

	public void modifica(CostosExtrasDetalle costosExtrasDetalle) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(costosExtrasDetalle);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CostosExtrasDetalle> lista() {
		List<CostosExtrasDetalle> lista = new ArrayList<CostosExtrasDetalle>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from CostosExtrasDetalle ced where ced.activo = true order by ced.idCostosExtrasDetalle asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<CostosExtrasDetalle> listaPorTipoTrabajoDetalle(int idTipoTrabajoDetalle) {
		List<CostosExtrasDetalle> lista = new ArrayList<CostosExtrasDetalle>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CostosExtrasDetalle ced where ced.activo = true and ced.tipoTrabajoDetalle.idTipoTrabajoDetalle = :idTipoTrabajoDetalle order by ced.idCostosExtrasDetalle asc");
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
