package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.AvisoMantenimientoMaquina;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.AvisoMantenimientoMaquinaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("avisoMantenimientoMaquinaDAO")
public class AvisoMantenimientoMaquinaDaoImpl implements AvisoMantenimientoMaquinaDAO {
	
	private static final Logger log = Logger.getLogger(AvisoMantenimientoMaquinaDaoImpl.class);
	private Session sesion;
	
	// constructor
	public AvisoMantenimientoMaquinaDaoImpl() { }

	public int crea(AvisoMantenimientoMaquina avisoMantenimientoMaquina) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(avisoMantenimientoMaquina);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}

	public AvisoMantenimientoMaquina busca(int idAvisoMantenimientoMaquina) {
		AvisoMantenimientoMaquina avisoMantenimientoMaquina = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from AvisoMantenimientoMaquina amm where amm.idAvisoMantenimientoMaquina = :idAvisoMantenimientoMaquina");
			query.setParameter("idAvisoMantenimientoMaquina", idAvisoMantenimientoMaquina);
			avisoMantenimientoMaquina = (AvisoMantenimientoMaquina)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return avisoMantenimientoMaquina;
	}

	public void modifica(AvisoMantenimientoMaquina avisoMantenimientoMaquina) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(avisoMantenimientoMaquina);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<AvisoMantenimientoMaquina> lista() {
		List<AvisoMantenimientoMaquina> lista = new ArrayList<AvisoMantenimientoMaquina>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from AvisoMantenimientoMaquina amm where amm.activo = true order by amm.idAvisoMantenimientoMaquina asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}
	
}
