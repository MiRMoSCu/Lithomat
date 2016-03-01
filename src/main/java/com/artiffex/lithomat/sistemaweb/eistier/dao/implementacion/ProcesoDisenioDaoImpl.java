package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoDisenio;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProcesoDisenioDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("procesoDisenioDAO")
@Transactional
public class ProcesoDisenioDaoImpl implements ProcesoDisenioDAO {
	
	private static final Logger log = Logger.getLogger(ProcesoDisenioDaoImpl.class);
	private Session sesion;
	
	// constructor
	public ProcesoDisenioDaoImpl() { }

	public int crea(ProcesoDisenio procesoDisenio) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(procesoDisenio);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public ProcesoDisenio busca(int idProcesoDisenio) {
		ProcesoDisenio procesoDisenio = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from ProcesoDisenio pd where pd.idProcesoDisenio = :idProcesoDisenio");
			query.setParameter("idProcesoDisenio", idProcesoDisenio);
			procesoDisenio = (ProcesoDisenio)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return procesoDisenio;
	}

	public void modifica(ProcesoDisenio procesoDisenio) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(procesoDisenio);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProcesoDisenio> lista() {
		List<ProcesoDisenio> lista = new ArrayList<ProcesoDisenio>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from ProcesoDisenio pd where pd.activo = true order by pd.idProcesoDisenio").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
