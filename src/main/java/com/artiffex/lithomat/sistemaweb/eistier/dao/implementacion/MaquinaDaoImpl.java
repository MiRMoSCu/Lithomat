package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Maquina;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.MaquinaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("maquinaDAO")
@Transactional
public class MaquinaDaoImpl implements MaquinaDAO {
	
	private static final Logger log = Logger.getLogger(MaquinaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public MaquinaDaoImpl() { }

	public int crea(Maquina maquina) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(maquina);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public Maquina busca(int idMaquina) {
		Maquina maquina = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from Maquina m where m.idMaquina = :idMaquina");
			query.setParameter("idMaquina", idMaquina);
			maquina = (Maquina)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return maquina;
	}

	public void modifica(Maquina maquina) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(maquina);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Maquina> lista() {
		List<Maquina> lista = new ArrayList<Maquina>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from Maquina m where m.activo = true order by m.numColores desc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
