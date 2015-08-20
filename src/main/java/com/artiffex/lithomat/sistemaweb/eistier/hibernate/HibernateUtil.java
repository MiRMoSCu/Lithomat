package com.artiffex.lithomat.sistemaweb.eistier.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final Logger log = Logger.getLogger(HibernateUtil.class);
	private static SessionFactory sessionFactory;
	private static String SERVER_CONFIG_FILE_LOCATION 	= "hibernate/hibernate.cfg.xml";

	// constructor
	private HibernateUtil() { }	
	
	private static synchronized void initSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure(SERVER_CONFIG_FILE_LOCATION);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(builder.build());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getInstance() {
		if (sessionFactory == null) {
			log.info("sessionFactory == null : true");
			initSessionFactory();
		}
		return sessionFactory;
	}
	
	public static void close() {
		if (sessionFactory != null)
			sessionFactory.close();
		sessionFactory = null;
	}

	public Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
