package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PapelSobrante;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PapelSobranteDAO;
import com.artiffex.lithomat.sistemaweb.eistier.hibernate.HibernateUtil;

@Repository("papelSobranteDAO")
@Transactional
public class PapelSobranteDaoImpl implements PapelSobranteDAO {
	
	private static final Logger log = Logger.getLogger(PapelSobranteDaoImpl.class);
	private Session sesion;
	
	// constructor
	public PapelSobranteDaoImpl() { }

	public int crea(PapelSobrante papelSobrante) {
		int id = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			id = (Integer)sesion.save(papelSobrante);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return id;
	}
	
	public PapelSobrante busca(int idPapelSobrante) {
		PapelSobrante papelSobrante = null;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			Query query = sesion.createQuery("from PapelSobrante ps where ps.idPapelSobrante = :idPapelSobrante");
			query.setParameter("idPapelSobrante", idPapelSobrante);
			papelSobrante = (PapelSobrante)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return papelSobrante;
	}

	public void modifica(PapelSobrante papelSobrante) {
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			sesion.update(papelSobrante);
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<PapelSobrante> lista() {
		List<PapelSobrante> lista = new ArrayList<PapelSobrante>();
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			lista = sesion.createQuery("from PapelSobrante ps where ps.activo = true order by ps.inicioTabulador asc, ps.frenteNumTinta asc, ps.vueltaNumTinta asc, ps.tintaEspecial asc").list();
			sesion.getTransaction().commit();
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return lista;
	}

	public int buscaHojasSobrante(PapelSobrante papelSobrante) {
		int hojasSobrante = 0;
		try {
			try {
				sesion = HibernateUtil.getInstance().getCurrentSession();
			} catch ( HibernateException he ) {
				sesion = HibernateUtil.getInstance().openSession();
			}
			sesion.beginTransaction();
			SQLQuery query = sesion.createSQLQuery(
					"SELECT \n" + 
					"    hojas_sobrante\n" + 
					"FROM\n" + 
					"    papel_sobrante\n" + 
					"WHERE\n" + 
					"    inicio_tabulador < :inicio_tabulador\n" + 
					"        AND fin_tabulador > :fin_tabulador\n" + 
					"        AND frente_num_tinta = :frente_num_tinta\n" + 
					"        AND vuelta_num_tinta = :vuelta_num_tinta\n" +
					"        AND tinta_especial = :tinta_especial\n" +
					"        AND activo = true");
			query.setParameter("inicio_tabulador", papelSobrante.getInicioTabulador());
			query.setParameter("fin_tabulador", papelSobrante.getFinTabulador());
			query.setParameter("frente_num_tinta", papelSobrante.getFrenteNumTinta());
			query.setParameter("vuelta_num_tinta", papelSobrante.getVueltaNumTinta());
			query.setParameter("tinta_especial", papelSobrante.isTintaEspecial());
			hojasSobrante = (Integer)query.uniqueResult();
			sesion.getTransaction().commit();
			query = null;
		} catch(Exception e) {
			log.error(e.getMessage());
			sesion.getTransaction().rollback();
		}
		return hojasSobrante;
	}
	
}
