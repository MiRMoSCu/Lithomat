package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaTipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoPapelExtendidoDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tipoPapelExtendidoDAO")
public class TipoPapelExtendidoDaoImpl implements TipoPapelExtendidoDAO {
	
	private static final Logger log = Logger.getLogger(TipoPapelExtendidoDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TipoPapelExtendidoDaoImpl() { }

	public int crea(TipoPapelExtendido tipoPapelExtendido) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(tipoPapelExtendido);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TipoPapelExtendido busca(int idTipoPapelExtendido) {
		TipoPapelExtendido tipoPapelExtendido = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TipoPapelExtendido tpe where tpe.idTipoPapelExtendido = :idTipoPapelExtendido");
			query.setParameter("idTipoPapelExtendido", idTipoPapelExtendido);
			tipoPapelExtendido = (TipoPapelExtendido)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tipoPapelExtendido;
	}

	public void modifica(TipoPapelExtendido tipoPapelExtendido) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(tipoPapelExtendido);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoPapelExtendido> lista() {
		List<TipoPapelExtendido> lista = new ArrayList<TipoPapelExtendido>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from TipoPapelExtendido tpe where tpe.activo = true order by tpe.proveedorPapel.idProveedorPapel asc, tpe.nombre asc, tpe.gramaje asc, tpe.kilogramos asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<TipoPapelExtendido> listaPorQuery(String query, ParametrosBusquedaTipoPapelExtendido parametros) {
		List<TipoPapelExtendido> lista = new ArrayList<TipoPapelExtendido>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery(query).setProperties(parametros).list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	public int numeroTipoPapelExtendido(String strQuery) {
		int numeroRegistros = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			numeroRegistros = ((BigInteger)query.uniqueResult()).intValue();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return numeroRegistros;
	}

	@SuppressWarnings("unchecked")
	public List<TipoPapelExtendido> listaPorRango(String strQuery) {
		List<TipoPapelExtendido> lista = new ArrayList<TipoPapelExtendido>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			query.addEntity(TipoPapelExtendido.class);
			lista = query.list();
			sesion.getTransaction().commit();
		} catch( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
