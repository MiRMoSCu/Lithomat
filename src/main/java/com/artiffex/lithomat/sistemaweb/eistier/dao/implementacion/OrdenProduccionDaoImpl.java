package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.OrdenProduccion;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.OrdenProduccionDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("ordenProduccionDAO")
public class OrdenProduccionDaoImpl implements OrdenProduccionDAO {
	
	private static final Logger log = Logger.getLogger(OrdenProduccionDaoImpl.class);
	private Session sesion;
	
	// constructor
	public OrdenProduccionDaoImpl() { }

	public int crea(OrdenProduccion ordenProduccion) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(ordenProduccion);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public OrdenProduccion busca(int idOrdenProduccion) {
		OrdenProduccion ordenProduccion = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from OrdenProduccion op where op.idOrdenProduccion = :idOrdenProduccion");
			query.setParameter("idOrdenProduccion", idOrdenProduccion);
			ordenProduccion = (OrdenProduccion)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return ordenProduccion;
	}
	
	public OrdenProduccion buscaPorNut(String nut) {
		OrdenProduccion ordenProduccion = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from OrdenProduccion op where op.activo = true and op.nut = :nut");
			query.setParameter("nut", nut);
			ordenProduccion = (OrdenProduccion)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return ordenProduccion;
	}

	public void modifica(OrdenProduccion ordenProduccion) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(ordenProduccion);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrdenProduccion> lista() {
		List<OrdenProduccion> lista = new ArrayList<OrdenProduccion>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from OrdenProduccion op where op.activo = true order by op.idOrdenProduccion asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	public int contador(Timestamp fechaGeneracion) {
		int contador = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery("SELECT count(op.id_orden_produccion) FROM orden_produccion op WHERE DATE(op.fecha_generacion) = DATE(:fechaGeneracion)");
			query.setParameter("fechaGeneracion", fechaGeneracion);
			contador = ((BigInteger)query.uniqueResult()).intValue();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return contador;
	}

	public int buscaIdEstatusOrden(String nut) {
		int idEstatusOrden = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(
					"SELECT \r\n" + 
					"    he.id_estatus_orden\r\n" + 
					"FROM\r\n" + 
					"    orden_produccion op,\r\n" + 
					"    historial_estatus he\r\n" + 
					"WHERE\r\n" + 
					"    he.id_orden_produccion = op.id_orden_produccion\r\n" + 
					"        AND he.fecha = (SELECT \r\n" + 
					"            MAX(fecha)\r\n" + 
					"        FROM\r\n" + 
					"            historial_estatus\r\n" + 
					"        WHERE\r\n" + 
					"            id_orden_produccion = he.id_orden_produccion)\r\n" + 
					"        AND op.nut = :nut");
			query.setParameter("nut", nut);
			idEstatusOrden = (Integer)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return idEstatusOrden;
	}
	
}
