package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cliente;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ClienteDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("clienteDAO")
@Transactional
public class ClienteDaoImpl implements ClienteDAO {
	
	private static final Logger log = Logger.getLogger(ClienteDaoImpl.class);
	private Session sesion;
	
	// constructor
	public ClienteDaoImpl() { }

	public int crea(Cliente cliente) {
		int id = 0;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			id = (Integer)sesion.save(cliente);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public Cliente busca(int idCliente) {
		Cliente cliente = null;
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			//cliente = (Cliente)sesion.createQuery("from Cliente as cliente where cliente.id_cliente = :idCliente").setParameter("idCliente", idCliente).uniqueResult();
			Query query = sesion.createQuery("from Cliente c where c.idCliente = :idCliente");
			query.setParameter("idCliente", idCliente);
			cliente = (Cliente)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return cliente;
	}

	public void modifica(Cliente cliente) {
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			sesion.update(cliente);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> lista() {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			lista = sesion.createQuery("from Cliente c where c.activo = true order by c.idCliente").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscaPorNombre(String nombreMoral) {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			sesion = HibernateUtil.getInstance().getCurrentSession();
			sesion.beginTransaction();
			Query query = sesion.createQuery("from Cliente c where c.activo = true and UCASE(c.nombreMoral) like UCASE(:nombreMoral) order by c.idCliente asc, c.nombreMoral asc");
			query.setParameter("nombreMoral", "%"+nombreMoral+"%");
			lista = query.list();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

}
