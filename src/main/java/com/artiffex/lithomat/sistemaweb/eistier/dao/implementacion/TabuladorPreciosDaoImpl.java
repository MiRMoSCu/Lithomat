package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TabuladorPreciosDTO;
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
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
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
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
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
	
	public float buscaPrecioTabulador(String sqlQuery) {
		float precioTabulador = 0f;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(sqlQuery);
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
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
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
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from TabuladorPrecios tp where tp.activo = true order by tp.maquina.idMaquina asc, tp.tipoComplejidad asc, tp.inicioTabulador asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	public int numeroRegistros(String strQuery) {
		int numeroRegistros = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			numeroRegistros = ((BigInteger)query.uniqueResult()).intValue();
			sesion.getTransaction().commit();
			query = null;
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return numeroRegistros;
	}

	@SuppressWarnings("unchecked")
	public List<TabuladorPreciosDTO> listaPorCriteriosBusqueda(String strQuery) {
		List<TabuladorPreciosDTO> lista = new ArrayList<TabuladorPreciosDTO>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(strQuery);
			query.setResultTransformer(Transformers.aliasToBean(TabuladorPreciosDTO.class));
			lista = query.list();
			sesion.getTransaction().commit();
			query = null;
		} catch ( Exception e ) {
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
