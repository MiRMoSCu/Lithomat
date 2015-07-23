package com.artiffex.lithomat.sistemaweb.eistier.dao.implementacion;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.artiffex.lithomat.sistemaweb.businesstier.utilidades._CalificacionPartida;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalificacionPartidaDAO;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.GenericJdbcDAO;

@Repository("calificacionPartidaDAO")
public class CalificacionPartidaDaoImpl extends GenericJdbcDAO implements CalificacionPartidaDAO {
	
	private static final Logger log = Logger.getLogger(CalificacionPartidaDaoImpl.class);
	
	private static final String queryBusca =
			"SELECT \n" + 
			"    tt.nombre nombre_tipo_trabajo,\n" + 
			"    p.nombre_partida,\n" + 
			"    p.cantidad,\n" + 
			"    p.descripcion_partida,\n" + 
			"    cpp.coste_total_procesos_partida\n" + 
			"FROM\n" + 
			"    partida p,\n" + 
			"    tipo_trabajo tt,\n" + 
			"    calificacion_procesos_partida cpp\n" + 
			"WHERE\n" + 
			"    tt.id_tipo_trabajo = p.id_tipo_trabajo\n" + 
			"        AND cpp.id_partida = p.id_partida\n" + 
			"        AND p.id_partida = ?;";

	public _CalificacionPartida busca(int idPartida) {
		log.info("busca");
		return getJdbcTemplate().queryForObject(
					queryBusca, 
					new Object[] { idPartida },
					new RowMapper<_CalificacionPartida>() {
						public _CalificacionPartida mapRow(ResultSet rs, int i) throws SQLException {
							_CalificacionPartida calificacionPartida = new _CalificacionPartida();
							calificacionPartida.setNombreTipoTrabajo(rs.getString("nombre_tipo_trabajo"));
							calificacionPartida.setNombrePartida(rs.getString("nombre_partida"));
							calificacionPartida.setCantidad(rs.getInt("cantidad"));
							calificacionPartida.setDescripcionPartida(rs.getString("descripcion_partida"));
							calificacionPartida.setCosteTotal(rs.getFloat("coste_total_procesos_partida"));
							return calificacionPartida;
						}
					}
				);
	}
	
}
