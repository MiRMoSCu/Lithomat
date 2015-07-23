package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.EstatusOrdenDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("estatusOrdenDAO")
@Transactional
public class EstatusOrdenDaoImpl implements EstatusOrdenDAO {
	
	private static final Logger log = Logger.getLogger(EstatusOrdenDaoImpl.class);
	private Session sesion;
	
	//constructor
	public EstatusOrdenDaoImpl() { }

	public int crea(EstatusOrden estatusOrden) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(estatusOrden);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public EstatusOrden busca(int idEstatusOrden) {
		EstatusOrden estatusOrden = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from EstatusOrden eo where eo.idEstatusOrden = :idEstatusOrden");
			query.setParameter("idEstatusOrden", idEstatusOrden);
			estatusOrden = (EstatusOrden)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return estatusOrden;
	}

	public void modifica(EstatusOrden estatusOrden) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(estatusOrden);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<EstatusOrden> lista() {
		log.info("lista()");
		List<EstatusOrden> lista = new ArrayList<EstatusOrden>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from EstatusOrden eo where eo.activo = true order by eo.idEstatusOrden asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<EstatusOrden> listaEstatusPosible(String nut) {
		List<EstatusOrden> listaEstatusOrden = new ArrayList<EstatusOrden>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(
					"SELECT \r\n" + 
					"    eo.id_estatus_orden, eo.nombre, eo.descripcion, eo.activo\r\n" + 
					"FROM\r\n" + 
					"    orden_produccion op,\r\n" + 
					"    historial_estatus he,\r\n" + 
					"    estatus_orden eo\r\n" + 
					"WHERE\r\n" + 
					"    he.id_orden_produccion = op.id_orden_produccion\r\n" + 
					"        AND he.fecha = (SELECT \r\n" + 
					"            MAX(fecha)\r\n" + 
					"        FROM\r\n" + 
					"            historial_estatus\r\n" + 
					"        WHERE\r\n" + 
					"            id_orden_produccion = he.id_orden_produccion)\r\n" + 
					"        AND eo.id_estatus_orden > he.id_estatus_orden\r\n" + 
					"        AND op.nut = :nut");
			query.setParameter("nut", nut);
			query.addEntity(EstatusOrden.class);
			listaEstatusOrden = query.list();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return listaEstatusOrden;
	}

}
