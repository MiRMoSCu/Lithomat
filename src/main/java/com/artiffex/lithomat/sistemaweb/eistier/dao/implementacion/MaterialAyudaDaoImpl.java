package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyuda;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.MaterialAyudaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("materialAyudaDAO")
@Transactional
public class MaterialAyudaDaoImpl implements MaterialAyudaDAO {
	
	private static final Logger log = Logger.getLogger(MaterialAyudaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public MaterialAyudaDaoImpl() { }

	public int crea(MaterialAyuda materialAyuda) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(materialAyuda);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public MaterialAyuda busca(int idMaterialAyuda) {
		MaterialAyuda materialAyuda = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from MaterialAyuda ma where ma.idMaterialAyuda = :idMaterialAyuda");
			query.setParameter("idMaterialAyuda", idMaterialAyuda);
			materialAyuda = (MaterialAyuda)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return materialAyuda;
	}

	public void modifica(MaterialAyuda materialAyuda) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(materialAyuda);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<MaterialAyuda> lista() {
		List<MaterialAyuda> lista = new ArrayList<MaterialAyuda>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from MaterialAyuda ma where ma.activo = true order by ma.idMaterialAyuda asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
