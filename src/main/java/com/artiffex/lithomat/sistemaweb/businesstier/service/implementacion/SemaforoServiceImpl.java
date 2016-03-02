package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.SemaforoService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaSemaforo;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.SemaforoDAO;

@Service("semaforoService")
public class SemaforoServiceImpl implements SemaforoService {
	
	//private static final int ESTATUS_EN_ESPERA 			= 2;
	private static final int ESTATUS_DISENIO 			= 4;
	private static final int ESTATUS_PREPRENSA 			= 5;
	private static final int ESTATUS_TRANSPORTE 		= 6;
	private static final int ESTATUS_OFFSET 			= 7;
	private static final int ESTATUS_ACABADO 			= 8;
	//private static final int ESTATUS_PROCESO_EXTERNO 	= 9;
	private static final int ESTATUS_FINALIZADO 		= 10;
	
	@Resource
	private SemaforoDAO semaforoDAO;

	public int numeroRegistrosPorCriterioBusqueda(ParametrosBusquedaSemaforo parametros) {
		
		int idEstatusOrden = 0;
		if ( "ROLE_DISENIO".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_DISENIO;
		else if ( "ROLE_PREPRENSA".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_PREPRENSA;
		else if ( "ROLE_TRANSPORTE".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_TRANSPORTE;
		else if ( "ROLE_ACABADO".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_ACABADO;
		else if ( "ROLE_OFFSET".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_OFFSET;
		else if ( "ROLE_CLIENTE".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_FINALIZADO;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT ");
		query.append("    COUNT(*)");
		query.append(" FROM");
		query.append("    orden_produccion op,");
		query.append("    historial_estatus he,");
		query.append("    estatus_orden eo");
		query.append(" WHERE");
		query.append("    op.id_orden_produccion = he.id_orden_produccion");
		query.append("        AND he.id_estatus_orden = eo.id_estatus_orden");
		query.append("        AND he.fecha = (SELECT ");
		query.append("            MAX(fecha)");
		query.append("        FROM");
		query.append("            historial_estatus");
		query.append("        WHERE");
		query.append("            id_orden_produccion = he.id_orden_produccion)");
		query.append("        AND eo.id_estatus_orden = ");
		query.append(idEstatusOrden);
		query.append("        AND op.activo = TRUE;");
		
		int numeroRegistros = semaforoDAO.numeroRegistros( query.toString() );
		
		query = null;
		return numeroRegistros;
	}

	public List<VisualizadorDTO> listaPorCriterioBusquedaPorNumeroPagina(ParametrosBusquedaSemaforo parametros, int numeroPagina, int numeroRegistrosPorPagina) {
		
		boolean existeParametro = false;
		
		int idEstatusOrden = 0;
		if ( "ROLE_DISENIO".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_DISENIO;
		else if ( "ROLE_PREPRENSA".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_PREPRENSA;
		else if ( "ROLE_TRANSPORTE".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_TRANSPORTE;
		else if ( "ROLE_ACABADO".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_ACABADO;
		else if ( "ROLE_OFFSET".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_OFFSET;
		else if ( "ROLE_CLIENTE".equals( parametros.getRole() ) )
			idEstatusOrden = ESTATUS_FINALIZADO;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT ");
		query.append("    op.id_orden_produccion idOrdenProduccion,");
		query.append("    op.nut,");
		query.append("    op.nombre,");
		query.append("    op.descripcion,");
		query.append("    DATE(op.fecha_cotizacion) fechaCotizacion,");
		query.append("    c.nombre_moral nombreMoral,");
		query.append("    eo.id_estatus_orden idEstatusOrden,");
		query.append("    eo.nombre nombreEstatus");
		query.append(" FROM");
		query.append("    orden_produccion op,");
		query.append("    historial_estatus he,");
		query.append("    estatus_orden eo,");
		query.append("    cliente c");
		query.append(" WHERE");
		
		if ( parametros.isBusquedaPorNut() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("    op.nut = '");
			query.append(parametros.getNut());
			query.append("'");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorNombreOrdenProduccion() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("        op.nombre LIKE '%");
			query.append(parametros.getNombreOrdenProduccion());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorDescripcionOrdenProduccion() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("        op.descripcion LIKE '%");
			query.append(parametros.getDescripcionOrdenProduccion());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorNombreMoral() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("        c.nombre_moral LIKE '%");
			query.append(parametros.getNombreMoral());
			query.append("%'");
			existeParametro = true;
		}
		
		if ( existeParametro )
			query.append(" AND ");
		
		query.append("        eo.id_estatus_orden = ");
		query.append(idEstatusOrden);
		query.append("        AND op.activo = TRUE");
		query.append("        AND c.id_cliente = op.id_cliente");
		query.append("        AND he.id_orden_produccion = op.id_orden_produccion");
		query.append("        AND eo.id_estatus_orden = he.id_estatus_orden");
		query.append("        AND he.fecha = (SELECT ");
		query.append("            MAX(fecha)");
		query.append("        FROM");
		query.append("            historial_estatus");
		query.append("        WHERE");
		query.append("            id_orden_produccion = he.id_orden_produccion)");
		query.append(" ORDER BY fecha_cotizacion DESC");
		query.append(" LIMIT ");
		query.append(numeroRegistrosPorPagina * (numeroPagina - 1));
		query.append(" , ");
		query.append(numeroRegistrosPorPagina);
		query.append(";");
		
		//System.out.println(query.toString());
		
		List<VisualizadorDTO> lista = semaforoDAO.listaPorCriterioBusqueda( query.toString() );
		
		query = null;
		return lista;
	}

}
