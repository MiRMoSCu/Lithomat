package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.FechaPrensistaMaquinaDTOGrid;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.FechaPrensistaMaquina;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.FechaPrensistaMaquinaService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.FechaPrensistaMaquinaDAO;

@Service("fechaPrensistaMaquinaService")
public class FechaPrensistaMaquinaServiceImpl implements FechaPrensistaMaquinaService {
	
	@Resource
	private FechaPrensistaMaquinaDAO fechaPrensistaMaquinaDAO;

	public int creaFechaPrensistaMaquina(FechaPrensistaMaquina fechaPrensistaMaquina) {
		return fechaPrensistaMaquinaDAO.crea(fechaPrensistaMaquina);
	}

	public int modificaFechaPrensistaMaquina(FechaPrensistaMaquina fechaPrensistaMaquina) {
		return fechaPrensistaMaquinaDAO.modifica(fechaPrensistaMaquina);
	}

	public int eliminaFechaPrensistaMaquina(int idFechaPrensistaMaquina) {
		return fechaPrensistaMaquinaDAO.elimina(idFechaPrensistaMaquina);
	}

	public List<FechaPrensistaMaquina> listaFechaPrensistaMaquina() {
		return fechaPrensistaMaquinaDAO.lista();
	}

	public int obtieneNumeroFechaPrensistaMaquinaPorParametros(boolean busquedaPorNut, String nut) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT ");
		query.append("    COUNT(*) ");
		query.append("FROM ");
		query.append("    orden_produccion op_dos, ");
		query.append("    partida par, ");
		query.append("    tipo_trabajo_detalle ttd, ");
		query.append("    pliego p ");
		query.append("        LEFT OUTER JOIN ");
		query.append("    fecha_prensista_maquina fpm ON p.id_pliego = fpm.id_pliego ");
		query.append("WHERE ");
		
		if ( busquedaPorNut ) {
			if ( existeParametro ) {
				query.append("AND ");
			}
			query.append("    op_dos.nut LIKE '");
			query.append(nut);
			query.append("' ");
			existeParametro = true;
		}
		
		if ( existeParametro )
			query.append("        AND fpm.id_pliego IS NULL ");
		else
			query.append("    fpm.id_pliego IS NULL ");
		
		query.append("        AND ttd.id_tipo_trabajo_detalle = p.id_tipo_trabajo_detalle ");
		query.append("        AND par.id_partida = ttd.id_partida ");
		query.append("        AND op_dos.id_orden_produccion = par.id_orden_produccion ");
		query.append("        AND op_dos.nut IN (SELECT ");
		query.append("            op_uno.nut ");
		query.append("        FROM ");
		query.append("            orden_produccion op_uno, ");
		query.append("            historial_estatus he_dos ");
		query.append("        WHERE ");
		query.append("            (he_dos.id_orden_produccion , he_dos.fecha) IN (SELECT ");
		query.append("                    he_uno.id_orden_produccion, MAX(he_uno.fecha) ");
		query.append("                FROM ");
		query.append("                    historial_estatus he_uno ");
		query.append("                GROUP BY he_uno.id_orden_produccion) ");
		query.append("                AND he_dos.id_estatus_orden >= 7 ");
		query.append("                AND he_dos.id_orden_produccion = op_uno.id_orden_produccion);");
		
		int numRegistros = fechaPrensistaMaquinaDAO.numeroRegistrosFechaPrensistaMaquina( query.toString() );
		
		query = null;
		
		return numRegistros;
	}

	public List<FechaPrensistaMaquinaDTOGrid> listaFechaPrensistaMaquinaPorParametrosEnDTO(boolean busquedaPorNut, String nut, int numeroPagina, int numeroRegistrosPorPagina) {
		
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT ");
		query.append("    op_dos.nut, ");
		query.append("    op_dos.nombre nombreOrdenProduccion, ");
		query.append("    par.nombre_partida nombrePartida, ");
		query.append("    ttd.descripcion descripcionTipoTrabajoDetalle, ");
		query.append("    p.id_pliego idPliego, ");
		query.append("    p.numero_pliego noPliego, ");
		query.append("    p.hojas_requeridas hojasRequeridas ");
		query.append("FROM ");
		query.append("    orden_produccion op_dos, ");
		query.append("    partida par, ");
		query.append("    tipo_trabajo_detalle ttd, ");
		query.append("    pliego p ");
		query.append("        LEFT OUTER JOIN ");
		query.append("    fecha_prensista_maquina fpm ON p.id_pliego = fpm.id_pliego ");
		query.append("WHERE ");
		
		if ( busquedaPorNut ) {
			if ( existeParametro ) {
				query.append("AND ");
			}
			query.append("    op_dos.nut LIKE '");
			query.append(nut);
			query.append("' ");
			existeParametro = true;
		}
		
		if ( existeParametro )
			query.append("        AND fpm.id_pliego IS NULL ");
		else
			query.append("    fpm.id_pliego IS NULL ");
		
		query.append("        AND ttd.id_tipo_trabajo_detalle = p.id_tipo_trabajo_detalle ");
		query.append("        AND par.id_partida = ttd.id_partida ");
		query.append("        AND op_dos.id_orden_produccion = par.id_orden_produccion ");
		query.append("        AND op_dos.nut IN (SELECT ");
		query.append("            op_uno.nut ");
		query.append("        FROM ");
		query.append("            orden_produccion op_uno, ");
		query.append("            historial_estatus he_dos ");
		query.append("        WHERE ");
		query.append("            (he_dos.id_orden_produccion , he_dos.fecha) IN (SELECT ");
		query.append("                    he_uno.id_orden_produccion, MAX(he_uno.fecha) ");
		query.append("                FROM ");
		query.append("                    historial_estatus he_uno ");
		query.append("                GROUP BY he_uno.id_orden_produccion) ");
		query.append("                AND he_dos.id_estatus_orden >= 7 ");
		query.append("                AND he_dos.id_orden_produccion = op_uno.id_orden_produccion) ");
		query.append("ORDER BY op_dos.id_orden_produccion ASC, p.id_pliego ASC ");
		query.append("LIMIT");
		query.append(" ");
		query.append(numeroRegistrosPorPagina * (numeroPagina - 1));
		query.append(" , ");
		query.append(numeroRegistrosPorPagina);
		query.append(";");
		
		List<FechaPrensistaMaquinaDTOGrid> lista = fechaPrensistaMaquinaDAO.listaPorRango( query.toString() );
		
		query = null;
		
		return lista;
	}

	
}