package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtras;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CostosExtrasDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("costosExtrasDAO")
@Transactional
public class CostosExtrasDaoImpl implements CostosExtrasDAO {
	
	private static final Logger log = Logger.getLogger(CostosExtrasDaoImpl.class);
	private Session sesion;
	
	// constructor
	public CostosExtrasDaoImpl() { }
	
	public int crea(CostosExtras costosExtras) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(costosExtras);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public CostosExtras busca(int idCostosExtras) {
		CostosExtras costosExtras = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CostosExtras ce where ce.idCostosExtras = :idCostosExtras");
			query.setParameter("idCostosExtras", idCostosExtras);
			costosExtras = (CostosExtras)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return costosExtras;
	}
	
	public void modifica(CostosExtras costosExtras) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(costosExtras);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CostosExtras> lista() {
		List<CostosExtras> lista = new ArrayList<CostosExtras>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from CostosExtras ce where ce.activo = true order by ce.idCostosExtras asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
