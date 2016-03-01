package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoPreprensa;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProcesoPreprensaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("procesoPreprensaDAO")
public class ProcesoPreprensaDaoImpl implements ProcesoPreprensaDAO {
	
	private static final Logger log = Logger.getLogger(ProcesoPreprensaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public ProcesoPreprensaDaoImpl() { }

	public int crea(ProcesoPreprensa procesoPreprensa) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(procesoPreprensa);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public ProcesoPreprensa busca(int idProcesoPreprensa) {
		ProcesoPreprensa procesoPreprensa = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from ProcesoPreprensa pp where pp.idProcesoPreprensa = :idProcesoPreprensa");
			query.setParameter("idProcesoPreprensa", idProcesoPreprensa);
			procesoPreprensa = (ProcesoPreprensa)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return procesoPreprensa;
	}

	public void modifica(ProcesoPreprensa procesoPreprensa) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(procesoPreprensa);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProcesoPreprensa> lista() {
		List<ProcesoPreprensa> lista = new ArrayList<ProcesoPreprensa>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from ProcesoPreprensa pp where pp.activo = true order by pp.idProcesoPreprensa asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
