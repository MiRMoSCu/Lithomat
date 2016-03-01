package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Preprensa;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PreprensaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("preprensaDAO")
public class PreprensaDaoImpl implements PreprensaDAO {
	
	private static final Logger log = Logger.getLogger(PreprensaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public PreprensaDaoImpl() { }

	public int crea(Preprensa preprensa) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(preprensa);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public Preprensa busca(int idPreprensa) {
		Preprensa preprensa = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from Preprensa p where p.idPreprensa = :idPreprensa");
			query.setParameter("idPreprensa", idPreprensa);
			preprensa = (Preprensa)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return preprensa;
	}
	
	public Preprensa buscaPorPartida(int idPartida) {
		Preprensa preprensa = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from Preprensa p where p.activo = true and p.partida.idPartida = :idPartida");
			query.setParameter("idPartida", idPartida);
			preprensa = (Preprensa)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return preprensa;
	}

	public void modifica(Preprensa preprensa) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(preprensa);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Preprensa> lista() {
		List<Preprensa> lista = new ArrayList<Preprensa>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from Preprensa p where p.activo = true order by c.idPreprensa").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
