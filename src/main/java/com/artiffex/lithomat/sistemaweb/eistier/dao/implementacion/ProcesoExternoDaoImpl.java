package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProcesoExterno;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProcesoExternoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("procesoExternoDAO")
@Transactional
public class ProcesoExternoDaoImpl implements ProcesoExternoDAO {
	
	private static final Logger log = Logger.getLogger(ProcesoExternoDaoImpl.class);
	private Session sesion;
	
	// constructor
	public ProcesoExternoDaoImpl() { }

	public int crea(ProcesoExterno procesoExterno) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(procesoExterno);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public ProcesoExterno busca(int idProcesoExterno) {
		ProcesoExterno procesoExterno = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from ProcesoExterno pe where pe.idProcesoExterno = :idProcesoExterno");
			query.setParameter("idProcesoExterno", idProcesoExterno);
			procesoExterno = (ProcesoExterno)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return procesoExterno;
	}

	public void modifica(ProcesoExterno procesoExterno) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(procesoExterno);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProcesoExterno> lista() {
		List<ProcesoExterno> lista = new ArrayList<ProcesoExterno>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from ProcesoExterno pe where pe.activo = true order by pe.proveedorExterno.idProveedorExterno asc, pe.idProcesoExterno asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
