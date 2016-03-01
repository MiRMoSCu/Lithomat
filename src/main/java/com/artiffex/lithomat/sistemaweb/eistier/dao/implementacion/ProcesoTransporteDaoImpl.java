package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoTransporte;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProcesoTransporteDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("procesoTransporteDAO")
public class ProcesoTransporteDaoImpl implements ProcesoTransporteDAO {
	
	private static final Logger log = Logger.getLogger(ProcesoTransporteDaoImpl.class);
	private Session sesion;
	
	// constructor
	public ProcesoTransporteDaoImpl() { }

	public int crea(ProcesoTransporte procesoTransporte) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(procesoTransporte);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public ProcesoTransporte busca(int idProcesoTransporte) {
		ProcesoTransporte procesoTransporte = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from ProcesoTransporte pt where pt.idProcesoTransporte = :idProcesoTransporte");
			query.setParameter("idProcesoTransporte", idProcesoTransporte);
			procesoTransporte = (ProcesoTransporte)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return procesoTransporte;
	}

	public void modifica(ProcesoTransporte procesoTransporte) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(procesoTransporte);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProcesoTransporte> lista() {
		List<ProcesoTransporte> lista = new ArrayList<ProcesoTransporte>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from ProcesoTransporte pt where pt.activo = true order by pt.idProcesoTransporte asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
