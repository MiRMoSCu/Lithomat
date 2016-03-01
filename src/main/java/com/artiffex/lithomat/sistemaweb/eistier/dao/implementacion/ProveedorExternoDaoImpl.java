package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ProveedorExterno;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ProveedorExternoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("proveedorExternoDAO")
@Transactional
public class ProveedorExternoDaoImpl implements ProveedorExternoDAO {
	
	private static final Logger log = Logger.getLogger(ProveedorExternoDaoImpl.class);
	private Session sesion;
	
	// constructor
	public ProveedorExternoDaoImpl() { }

	public int crea(ProveedorExterno proveedorExterno) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(proveedorExterno);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public ProveedorExterno busca(int idProveedorExterno) {
		ProveedorExterno proveedorExterno = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from ProveedorExterno pe where pe.idProveedorExterno = :idProveedorExterno");
			query.setParameter("idProveedorExterno", idProveedorExterno);
			proveedorExterno = (ProveedorExterno)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return proveedorExterno;
	}

	public void modifica(ProveedorExterno proveedorExterno) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(proveedorExterno);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProveedorExterno> lista() {
		List<ProveedorExterno> lista = new ArrayList<ProveedorExterno>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from ProveedorExterno pe where pe.activo = true order by pe.idProveedorExterno asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
