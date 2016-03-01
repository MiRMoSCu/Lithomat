package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.MaterialAyudaXPartida;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.MaterialAyudaXPartidaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("materialAyudaXPartidaDAO")
public class MaterialAyudaXPartidaDaoImpl implements MaterialAyudaXPartidaDAO {
	
	private static final Logger log = Logger.getLogger(MaterialAyudaXPartidaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public MaterialAyudaXPartidaDaoImpl() { }

	public int crea(MaterialAyudaXPartida materialAyudaXPartida) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(materialAyudaXPartida);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public MaterialAyudaXPartida busca(int idMaterialAyudaXPartida) {
		MaterialAyudaXPartida materialAyudaXPartida = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from MaterialAyudaXPartida maxp where maxp.idMaterialAyudaXPartida = :idMaterialAyudaXPartida");
			query.setParameter("idMaterialAyudaXPartida", idMaterialAyudaXPartida);
			materialAyudaXPartida = (MaterialAyudaXPartida)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return materialAyudaXPartida;
	}

	public void modifica(MaterialAyudaXPartida materialAyudaXPartida) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(materialAyudaXPartida);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<MaterialAyudaXPartida> lista() {
		List<MaterialAyudaXPartida> lista = new ArrayList<MaterialAyudaXPartida>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from MaterialAyudaXPartida maxp where maxp.activo = true order by maxp.idMaterialAyudaXPartida asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<MaterialAyudaXPartida> lista(int idPartida) {
		List<MaterialAyudaXPartida> lista = new ArrayList<MaterialAyudaXPartida>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from MaterialAyudaXPartida maxp where maxp.activo = true and maxp.partida.idPartida = :idPartida order by maxp.idMaterialAyudaXPartida asc");
			query.setParameter("idPartida", idPartida); 
			lista = query.list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
