package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Transporte;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TransporteDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("transporteDAO")
public class TransporteDaoImpl implements TransporteDAO {
	
	private static final Logger log = Logger.getLogger(TransporteDaoImpl.class);
	private Session sesion;
	
	// constructor
	public TransporteDaoImpl() { }

	public int crea(Transporte transporte) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(transporte);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public Transporte busca(int idTransporte) {
		Transporte transporte = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from Transporte t where t.idTransporte = :idTransporte");
			query.setParameter("idTransporte", idTransporte);
			transporte = (Transporte)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return transporte;
	}
	
	public Transporte buscaPorPartida(int idPartida) {
		Transporte transporte = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from Transporte t where t.activo = true and t.partida.idPartida = :idPartida");
			query.setParameter("idPartida", idPartida);
			transporte = (Transporte)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return transporte;
	}

	public void modifica(Transporte transporte) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(transporte);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Transporte> lista() {
		List<Transporte> lista = new ArrayList<Transporte>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from Transporte t where t.activo = true order by t.idTransporte asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
