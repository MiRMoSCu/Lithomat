package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPlaca;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoPlacaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tipoPlacaDAO")
public class TipoPlacaDaoImpl implements TipoPlacaDAO {
	
	private static final Logger log = Logger.getLogger(TipoPlacaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TipoPlacaDaoImpl() { }

	public int crea(TipoPlaca tipoPlaca) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(tipoPlaca);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TipoPlaca busca(int idTipoPlaca) {
		TipoPlaca tipoPlaca = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoPlaca tp where tp.idTipoPlaca = :idTipoPlaca");
			query.setParameter("idTipoPlaca", idTipoPlaca);
			tipoPlaca = (TipoPlaca)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tipoPlaca;
	}

	public void modifica(TipoPlaca tipoPlaca) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(tipoPlaca);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoPlaca> lista() {
		List<TipoPlaca> lista = new ArrayList<TipoPlaca>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from TipoPlaca tp where tp.activo = true order by tp.maquina.idMaquina asc, tp.idTipoPlaca asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<TipoPlaca> lista(int idMaquina) {
		List<TipoPlaca> lista = new ArrayList<TipoPlaca>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoPlaca tp where tp.activo = true and tp.maquina.idMaquina = :idMaquina");
			query.setParameter("idMaquina", idMaquina);
			lista = query.list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	public void borradoLogico(String strQuery) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			query.executeUpdate();
			sesion.getTransaction().commit();
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}
	
}
