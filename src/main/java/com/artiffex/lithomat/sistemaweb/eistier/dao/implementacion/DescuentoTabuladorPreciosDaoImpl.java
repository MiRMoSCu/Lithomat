package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.DescuentoTabuladorPreciosDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.DescuentoTabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.DescuentoTabuladorPreciosDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("descuentoTabuladorPreciosDAO")
public class DescuentoTabuladorPreciosDaoImpl implements DescuentoTabuladorPreciosDAO {
	
	private static final Logger log = Logger.getLogger(DescuentoTabuladorPreciosDaoImpl.class);
	private Session sesion;
	
	// constructor
	public DescuentoTabuladorPreciosDaoImpl() { }

	public int crea(DescuentoTabuladorPrecios descuentoTabuladorPrecios) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(descuentoTabuladorPrecios);
			sesion.getTransaction().commit();
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public DescuentoTabuladorPrecios busca(int idDescuentoTabuladorPrecios) {
		DescuentoTabuladorPrecios descuentoTabuladorPrecios = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from DescuentoTabuladorPrecios dtp where dtp.idDescuentoTabuladorPrecios = :idDescuentoTabuladorPrecios");
			query.setParameter("idDescuentoTabuladorPrecios", idDescuentoTabuladorPrecios);
			descuentoTabuladorPrecios = (DescuentoTabuladorPrecios)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return descuentoTabuladorPrecios;
	}
	
	public DescuentoTabuladorPreciosDTO buscaPorQuery(String queryString) {
		DescuentoTabuladorPreciosDTO descuentoTabuladorPreciosDTO = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(queryString);
			query.setResultTransformer(Transformers.aliasToBean(DescuentoTabuladorPreciosDTO.class));
			descuentoTabuladorPreciosDTO = (DescuentoTabuladorPreciosDTO)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return descuentoTabuladorPreciosDTO;
	}

	public void modifica(DescuentoTabuladorPrecios descuentoTabuladorPrecios) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(descuentoTabuladorPrecios);
			sesion.getTransaction().commit();
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<DescuentoTabuladorPrecios> lista() {
		List<DescuentoTabuladorPrecios> lista = new ArrayList<DescuentoTabuladorPrecios>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from DescuentoTabuladorPrecios dtp where dtp.activo = true order by dtp.idDescuentoTabuladorPrecios asc").list();
			sesion.getTransaction().commit();
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	public float buscaFloatPorQuery(String queryString) {
		float resultadoFlotante = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(queryString);
			resultadoFlotante = ((BigDecimal)query.uniqueResult()).floatValue();
			sesion.getTransaction().commit();
			query = null;
		} catch ( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return resultadoFlotante;
	}
	
}
