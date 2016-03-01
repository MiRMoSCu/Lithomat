package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.ayuda.CalificacionTrabajoDetalleDTOAyuda;
import com.artiffex.lithomat.sistemaweb.ayuda.OrdenProduccionDTOAyuda;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionOrdenProduccionDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.GenericJdbcDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("resumenCalificacionOrdenProduccionDAO")
public class CalificacionOrdenProduccionDaoImpl extends GenericJdbcDAO implements CalificacionOrdenProduccionDAO {
	
	private static final Logger log = Logger.getLogger(CalificacionOrdenProduccionDaoImpl.class);
	private Session sesion;
	
	// constructor
	public CalificacionOrdenProduccionDaoImpl() { }

	public int crea(CalificacionOrdenProduccion calificacionOrdenProduccion) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(calificacionOrdenProduccion);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public CalificacionOrdenProduccion buscaPorOrdenProduccion(int idOrdenProduccion) {
		CalificacionOrdenProduccion calificacionOrdenProduccion = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from CalificacionOrdenProduccion cop where cop.ordenProduccion.idOrdenProduccion = :idOrdenProduccion");
			query.setParameter("idOrdenProduccion", idOrdenProduccion);
			calificacionOrdenProduccion = (CalificacionOrdenProduccion)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return calificacionOrdenProduccion;
	}

	public void modifica(CalificacionOrdenProduccion calificacionOrdenProduccion) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(calificacionOrdenProduccion);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	public List<OrdenProduccionDTOAyuda> obtieneVOPruebaJasper(int idOrdenProduccion) {
		
		String qry = 
				"SELECT \n" + 
				"	nut, nombre, descripcion\n" + 
				"FROM\n" + 
				"	orden_produccion;";
		
		return getJdbcTemplate().query(qry, new RowMapper<OrdenProduccionDTOAyuda>() {
			public OrdenProduccionDTOAyuda mapRow(ResultSet rs, int i)
					throws SQLException {
				OrdenProduccionDTOAyuda op = new OrdenProduccionDTOAyuda();
				op.setNut(rs.getString("nut"));
				op.setNombre(rs.getString("nombre"));
				op.setDescripcion(rs.getString("descripcion"));
				return op;
			}
		});
	}

	public List<CalificacionTrabajoDetalleDTOAyuda> ejemploListaPapel() {
		
		String qry = 
				"SELECT \n" + 
				"    papel_cantidad_total,\n" + 
				"    papel_precio_unitario,\n" + 
				"    papel_coste_total\n" + 
				"FROM\n" + 
				"    calificacion_trabajo_detalle;";
		
		return getJdbcTemplate().query(qry, new RowMapper<CalificacionTrabajoDetalleDTOAyuda>() {
			public CalificacionTrabajoDetalleDTOAyuda mapRow(ResultSet rs, int i)
					throws SQLException {
				CalificacionTrabajoDetalleDTOAyuda ctd = new CalificacionTrabajoDetalleDTOAyuda();
				ctd.setPapelCantidadTotal(rs.getInt("papel_cantidad_total"));
				ctd.setPapelPrecioUnitario(rs.getInt("papel_precio_unitario"));
				ctd.setPapelCosteTotal(rs.getInt("papel_coste_total"));
				return ctd;
			}
		});
	}
	
}
