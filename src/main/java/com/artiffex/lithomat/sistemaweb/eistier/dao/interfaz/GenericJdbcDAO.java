package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class GenericJdbcDAO extends JdbcDaoSupport {

	// ESTADOS DE ERROR
	public static int FAILURE_UPDATE 	= -1;
	public static int VALUE_ZERO		= 0;
	
	@Resource(name = "dataSource")
	public void setJdbcDataSource(DataSource ds) {
		super.setDataSource(ds);
	}
}
