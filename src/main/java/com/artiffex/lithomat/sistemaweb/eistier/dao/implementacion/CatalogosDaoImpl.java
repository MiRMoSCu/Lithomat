package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CatalogosDAO;

@Repository("catalogosDAO")
public class CatalogosDaoImpl implements CatalogosDAO {
	
	private static final Logger log = Logger.getLogger(CatalogosDaoImpl.class);
	
	//private static final String queryCreaPerfil = "insert into PERFIL (NOMBRE, DESCRIPCION, ACTIVO) VALUES (?,?,?)";
	//private static final String queryModulo = "insert into MODULO (NOMBRE, DESCRIPCION, PATH, ACTIVO) VALUES (?,?,?,?)";
	
	public int creaCatalogos(){
		log.info("crea");
		
		
		/*
     	//PERFIL
    	resultado = getJdbcTemplate().update(queryCreaPerfil,"Administrador","Super usuario",true);
    	resultado = getJdbcTemplate().update(queryCreaPerfil,"Jefe Produccion","Jefe Produccion",true);
    	resultado = getJdbcTemplate().update(queryCreaPerfil,"Jefe Disenio","Jefe area de Disenio",true);
    	resultado = getJdbcTemplate().update(queryCreaPerfil,"Jefe Preprensa","Jefe area Preprensa",true);
    	resultado = getJdbcTemplate().update(queryCreaPerfil,"Jefe Transporte","Jefe area Transporte",true);
    	resultado = getJdbcTemplate().update(queryCreaPerfil,"Jefe Acabado","Jefe area Acabado",true);
    	resultado = getJdbcTemplate().update(queryCreaPerfil,"Jefe Offset","Jefe area Offset",true);
    	//AREA
    	resultado = getJdbcTemplate().update(queryModulo,"Solicitud Servicio","Solicitud Servicio",null,true);
    	resultado = getJdbcTemplate().update(queryModulo,"Disenio","Disenio",null,true);
    	resultado = getJdbcTemplate().update(queryModulo,"Preprensa","Preprensa",null,true);
    	resultado = getJdbcTemplate().update(queryModulo,"Transporte","Transporte",null,true);
    	resultado = getJdbcTemplate().update(queryModulo,"Acabado","Acabado",null,true);
    	resultado = getJdbcTemplate().update(queryModulo,"Offset","Offset",null,true);
    	resultado = getJdbcTemplate().update(queryModulo,"Proceso Externo","Proceso Externo",null,true);
    	resultado = getJdbcTemplate().update(queryModulo,"Reportes","Reportes",null,true);
    	resultado = getJdbcTemplate().update(queryModulo,"Administracion","Administracion",null,true);
    	resultado = getJdbcTemplate().update(queryModulo,"Administracion","Administracion",null,true);		
		*/
		return 1;		
	}
}
