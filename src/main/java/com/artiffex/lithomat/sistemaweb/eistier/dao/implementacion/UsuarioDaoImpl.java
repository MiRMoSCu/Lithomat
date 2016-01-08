package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Usuario;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.UsuarioDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("usuarioDAO")
public class UsuarioDaoImpl implements UsuarioDAO {
	
	private static final Logger log = Logger.getLogger(UsuarioDaoImpl.class);
	private Session sesion;
	
	// constructor
	public UsuarioDaoImpl() { }

	public int crea(Usuario usuario) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(usuario);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public Usuario busca(int idUsuario) {
		Usuario usuario = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from Usuario u where u.idUsuario = :idUsuario");
			query.setParameter("idUsuario", idUsuario);
			usuario = (Usuario)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return usuario;
	}
	
	public Usuario busca(String nombreUsuario) {
		Usuario usuario = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from Usuario u where u.usuario = :nombreUsuario");
			query.setParameter("nombreUsuario", nombreUsuario);
			usuario = (Usuario)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return usuario;
	}

	public void modifica(Usuario usuario) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(usuario);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> lista() {
		List<Usuario> lista =new ArrayList<Usuario>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from Usuario u where u.activo = true order by u.idUsuario asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
		
}// UsuarioDAOImpl
