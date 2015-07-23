package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CombinacionTintas;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CombinacionTintasDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("combinacionTintasDAO")
@Transactional
public class CombinacionTintasDaoImpl implements CombinacionTintasDAO {
	
	private static final Logger log = Logger.getLogger(CombinacionTintasDaoImpl.class);
	private Session sesion;
	
	// constructor
	public CombinacionTintasDaoImpl() { }

	public int crea(CombinacionTintas combinacionTintas) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(combinacionTintas);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public CombinacionTintas busca(int idCombinacionTintas) {
		CombinacionTintas combinacionTintas = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CombinacionTintas ct where ct.idCombinacionTintas = :idCombinacionTintas");
			query.setParameter("idCombinacionTintas", idCombinacionTintas);
			combinacionTintas = (CombinacionTintas)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return combinacionTintas;
	}

	public void modifica(CombinacionTintas combinacionTintas) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(combinacionTintas);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<CombinacionTintas> lista() {
		List<CombinacionTintas> lista = new ArrayList<CombinacionTintas>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from CombinacionTintas ct where ct.activo = true order by ct.numTintas desc, ct.idCombinacionTintas asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
