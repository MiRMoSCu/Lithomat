package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TintaEspecial;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TintaEspecialDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tintaEspecialDAO")
public class TintaEspecialDaoImpl implements TintaEspecialDAO {
	
	private static final Logger log = Logger.getLogger(TintaEspecialDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TintaEspecialDaoImpl() { }

	public void modifica(TintaEspecial tintaEspecial) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(tintaEspecial);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TintaEspecial> lista() {
		List<TintaEspecial> lista = new ArrayList<TintaEspecial>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from TintaEspecial te where te.activo = true order by te.idTintaEspecial asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
