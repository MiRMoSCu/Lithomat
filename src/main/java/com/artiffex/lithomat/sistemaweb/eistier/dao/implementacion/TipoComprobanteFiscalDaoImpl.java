package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComprobanteFiscal;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoComprobanteFiscalDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tipoComprobanteFiscal")
public class TipoComprobanteFiscalDaoImpl implements TipoComprobanteFiscalDAO {
	
	private static final Logger log = Logger.getLogger(TipoComprobanteFiscalDaoImpl.class);
	private Session sesion;
	
	// consructor
	public TipoComprobanteFiscalDaoImpl() { }

	public int crea(TipoComprobanteFiscal tipoComprobanteFiscal) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(tipoComprobanteFiscal);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TipoComprobanteFiscal busca(int idTipoComprobanteFiscal) {
		TipoComprobanteFiscal tipoComprobanteFiscal = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoComprobanteFiscal tcf where tcf.idTipoComprobanteFiscal = :idTipoComprobanteFiscal");
			query.setParameter("idTipoComprobanteFiscal", idTipoComprobanteFiscal);
			tipoComprobanteFiscal = (TipoComprobanteFiscal)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tipoComprobanteFiscal;
	}

	public void modifica(TipoComprobanteFiscal tipoComprobanteFiscal) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(tipoComprobanteFiscal);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoComprobanteFiscal> lista() {
		List<TipoComprobanteFiscal> lista = new ArrayList<TipoComprobanteFiscal>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from TipoComprobanteFiscal tcf where tcf.activo = true order by tcf.idTipoComprobanteFiscal asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
