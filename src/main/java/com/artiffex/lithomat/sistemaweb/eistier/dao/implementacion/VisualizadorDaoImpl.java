package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.GenericJdbcDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.VisualizadorDAO;

@Repository("visualizadorDAO")
public class VisualizadorDaoImpl extends GenericJdbcDAO implements VisualizadorDAO {
	
	private static final Logger log = Logger.getLogger(VisualizadorDaoImpl.class);

	public int numeroOrdenesProduccion(String query, Object[] parametros) {
		log.info("numeroOrdenesProduccion");
		return getJdbcTemplate().queryForInt(query, parametros);
	}

	public List<VisualizadorDTO> listaOrdenesProduccion(String query, Object[] parametros) {
		log.info("listaOrdenesProduccion");

		List<VisualizadorDTO> listaOrdenesProduccion = getJdbcTemplate().query(query, parametros, new RowMapper<VisualizadorDTO>() {
					public VisualizadorDTO mapRow(ResultSet rs, int i)
							throws SQLException {
						
						VisualizadorDTO visualizador = new VisualizadorDTO();
						visualizador.setId_orden_produccion(rs.getInt("id_orden_produccion"));
						visualizador.setNut(rs.getString("nut"));
						visualizador.setNombre(rs.getString("nombre"));
						visualizador.setDescripcion(rs.getString("descripcion"));
						visualizador.setFecha_cotizacion(rs.getDate("fecha_cotizacion"));
						visualizador.setNombre_moral(rs.getString("nombre_moral"));
						visualizador.setId_estatus_orden(rs.getInt("id_estatus_orden"));
						visualizador.setNombre_estatus(rs.getString("nombre_estatus"));
						return visualizador;
					}
				});
		return listaOrdenesProduccion;
	}
}
