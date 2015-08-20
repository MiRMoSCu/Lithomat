package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TabuladorPreciosDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("tabuladorPrecios")
public class TabuladorPreciosDaoImpl implements TabuladorPreciosDAO {
	
	private static final Logger log = Logger.getLogger(TabuladorPreciosDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TabuladorPreciosDaoImpl() { }

	public int crea(TabuladorPrecios tabuladorPrecios) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(tabuladorPrecios);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public TabuladorPrecios busca(int idTabuladorPrecios) {
		TabuladorPrecios tabuladorPrecios = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from TabuladorPrecios tp where tp.idTabuladorPrecios = :idTabuladorPrecios");
			query.setParameter("idTabuladorPrecios", idTabuladorPrecios);
			tabuladorPrecios = (TabuladorPrecios)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return tabuladorPrecios;
	}
	
	public float buscaPrecioTabulador(String sqlQuery, int idMaquina, int cantidad) {
		float precioTabulador = 0f;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(sqlQuery);
			query.setParameter("idMaquina", idMaquina);
			query.setParameter("cantidadMasUno", cantidad+1);
			query.setParameter("cantidadMenosUno", cantidad-1);
			precioTabulador = ((BigDecimal)query.uniqueResult()).floatValue();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return precioTabulador;
	}

	public void modifica(TabuladorPrecios tabuladorPrecios) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(tabuladorPrecios);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<TabuladorPrecios> lista() {
		List<TabuladorPrecios> lista = new ArrayList<TabuladorPrecios>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from TabuladorPrecios tp where tp.activo = true order by tp.maquina.idMaquina asc, tp.inicioTabulador asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
