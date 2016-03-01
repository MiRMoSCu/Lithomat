package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PerfilXUsuario;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PerfilXUsuarioDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("perfilXUsuarioDAO")
public class PerfilXUsuarioDaoImpl implements PerfilXUsuarioDAO {
	
	private static final Logger log = Logger.getLogger(PerfilXUsuarioDaoImpl.class);
	private Session sesion;
	
	// constructor
	public PerfilXUsuarioDaoImpl() { }

	public int crea(PerfilXUsuario perfilXUsuario) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(perfilXUsuario);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public PerfilXUsuario busca(int idPerfilXUsuario) {
		PerfilXUsuario pxu = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from PerfilXUsuario pxu where pxu.idPerfilXUsuario = :idPerfilXUsuario");
			query.setParameter("idPerfilXUsuario", idPerfilXUsuario);
			pxu = (PerfilXUsuario)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return pxu;
	}
	
	public PerfilXUsuario buscaPorUsuario(int idUsuario) {
		PerfilXUsuario pxu = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from PerfilXUsuario pxu where pxu.activo = true and pxu.usuario.idUsuario = :idUsuario");
			query.setParameter("idUsuario", idUsuario);
			pxu = (PerfilXUsuario)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return pxu;
	}

	public void modifica(PerfilXUsuario perfilXUsuario) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(perfilXUsuario);
			sesion.getTransaction().commit();
		}catch( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<PerfilXUsuario> lista() {
		log.info("ENTRASTE AQUI");
		List<PerfilXUsuario> lista = new ArrayList<PerfilXUsuario>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from PerfilXUsuario pxu where pxu.activo = true order by pxu.idPerfilXUsuario asc").list();
			sesion.getTransaction().commit();
		} catch( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
