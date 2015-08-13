package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Perfil;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PerfilDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("perfilDAO")
public class PerfilDaoImpl implements PerfilDAO {
	
	private static final Logger log = Logger.getLogger(PerfilDaoImpl.class);
	private Session sesion;
	
	// constructor
	public PerfilDaoImpl() { }

	public int crea(Perfil perfil) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Perfil busca(int idPerfil) {
		// TODO Auto-generated method stub
		return null;
	}

	public void modifica(Perfil perfil) {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	public List<Perfil> lista() {
		List<Perfil> lista = new ArrayList<Perfil>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from Perfil p where p.activo = true order by p.idPerfil asc").list();
			sesion.getTransaction().commit();
		} catch( Exception e ) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
