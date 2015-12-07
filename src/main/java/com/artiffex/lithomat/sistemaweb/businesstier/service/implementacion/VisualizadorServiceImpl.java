package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.VisualizadorDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.VisualizadorService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.VisualizadorDAO;

@Service("visualizadorService")
public class VisualizadorServiceImpl implements VisualizadorService {

	private static final int BUSQUEDA_DEFAULT = 0;
	private static final int BUSQUEDA_NUT = 1;
	private static final int BUSQUEDA_ESTATUS = 2;
	private static final int BUSQUEDA_NOMBRE_OP = 3;
	private static final int BUSQUEDA_DESCRIPCION_OP = 4;
	private static final int BUSQUEDA_FECHA_COTIZACION = 5;
	private static final int BUSQUEDA_CLIENTE = 6;

	@Resource
	private VisualizadorDAO visualizadorDAO;

	public int getNumeroOrdenesProduccion(
			int tipoBusqueda, 
			String nut,
			String nombre, 
			String descripcion, 
			String fechaCotizacionInicio,
			String fechaCotizacionFin, 
			String cliente, 
			int idEstatusOrden
		) {

		String query = "";
		Object[] parametros = null;

		switch (tipoBusqueda) {
		case BUSQUEDA_DEFAULT:
			query = "SELECT \n" 
					+ "    COUNT(*)\n" 
					+ "FROM\n"
					+ "    orden_produccion op\n" 
					+ "WHERE\n"
					+ "    op.activo = TRUE;";

			parametros = null;

			break;

		case BUSQUEDA_NUT:
			query = "SELECT \n" 
					+ "    COUNT(*)\n" 
					+ "FROM\n"
					+ "    orden_produccion op\n" 
					+ "WHERE\n"
					+ "    op.nut = ?\n" 
					+ "        AND op.activo = TRUE;";

			parametros = new Object[] { nut };

			break;

		case BUSQUEDA_ESTATUS:
			query = "SELECT \n"
					+ "    COUNT(*)\n"
					+ "FROM\n"
					+ "    orden_produccion op,\n"
					+ "    historial_estatus he,\n"
					+ "    estatus_orden eo\n"
					+ "WHERE\n"
					+ "    op.id_orden_produccion = he.id_orden_produccion\n"
					+ "        AND he.id_estatus_orden = eo.id_estatus_orden\n"
					+ "        AND he.fecha = (SELECT \n"
					+ "            MAX(fecha)\n"
					+ "        FROM\n"
					+ "            historial_estatus\n"
					+ "        WHERE\n"
					+ "            id_orden_produccion = he.id_orden_produccion)\n"
					+ "        AND eo.id_estatus_orden = ?\n"
					+ "        AND op.activo = TRUE;";

			parametros = new Object[] { idEstatusOrden };

			break;

		case BUSQUEDA_NOMBRE_OP:
			query = "SELECT \n" 
					+ "    COUNT(*)\n" 
					+ "FROM\n"
					+ "    orden_produccion op\n" 
					+ "WHERE\n"
					+ "    op.nombre LIKE ?\n"
					+ "        AND op.activo = TRUE;";

			parametros = new Object[] { "%" + nombre + "%" };

			break;

		case BUSQUEDA_DESCRIPCION_OP:
			query = "SELECT \n" 
					+ "    COUNT(*)\n" 
					+ "FROM\n"
					+ "    orden_produccion op\n" 
					+ "WHERE\n"
					+ "    op.descripcion LIKE ?\n"
					+ "        AND op.activo = TRUE;";

			parametros = new Object[] { "%" + descripcion + "%" };

			break;

		case BUSQUEDA_FECHA_COTIZACION:
			query = "SELECT \n"
					+ "    COUNT(*)\n"
					+ "FROM\n"
					+ "    orden_produccion op\n"
					+ "WHERE\n"
					+ "    DATE(op.fecha_cotizacion) BETWEEN DATE(?) AND DATE(?)\n"
					+ "        AND op.activo = TRUE;";

			parametros = new Object[] { fechaCotizacionInicio,
					fechaCotizacionFin };

			break;

		case BUSQUEDA_CLIENTE:
			query = "SELECT \n" 
					+ "    COUNT(*)\n" 
					+ "FROM\n"
					+ "    orden_produccion op,\n" 
					+ "    cliente c\n"
					+ "WHERE\n" 
					+ "    op.id_cliente = c.id_cliente\n"
					+ "        AND c.nombre_moral LIKE ?\n"
					+ "        AND op.activo = TRUE;";

			parametros = new Object[] { "%" + cliente + "%" };

			break;

		default:
			break;
		}

		return visualizadorDAO.numeroOrdenesProduccion(query, parametros);
	}

	public List<VisualizadorDTO> getListaOrdenesProduccion(
			int tipoBusqueda,
			int numeroPagina, 
			int numeroRegistrosPorPagina, 
			String nut,
			String nombre, 
			String descripcion, 
			String fechaCotizacionInicio,
			String fechaCotizacionFin, 
			String cliente, 
			int idEstatusOrden
		) {

		String query = "";
		Object[] parametros = null;
		List<VisualizadorDTO> listaOrdenesProduccion = null;

		switch (tipoBusqueda) {
		case BUSQUEDA_DEFAULT:
			query = "SELECT \n"
					+ "    op.id_orden_produccion,\n"
					+ "    op.nut,\n"
					+ "    op.nombre,\n"
					+ "    op.descripcion,\n"
					+ "    op.fecha_cotizacion,\n"
					+ "    c.nombre_moral,\n"
					+ "    eo.id_estatus_orden,\n"
					+ "    eo.nombre nombre_estatus\n"
					+ "FROM\n"
					+ "    orden_produccion op,\n"
					+ "    historial_estatus he,\n"
					+ "    estatus_orden eo,\n"
					+ "    cliente c\n"
					+ "WHERE\n"
					+ "    c.id_cliente = op.id_cliente\n"
					+ "        AND he.id_orden_produccion = op.id_orden_produccion\n"
					+ "        AND eo.id_estatus_orden = he.id_estatus_orden\n"
					+ "        AND he.fecha = (SELECT \n"
					+ "            MAX(fecha)\n"
					+ "        FROM\n"
					+ "            historial_estatus\n"
					+ "        WHERE\n"
					+ "            id_orden_produccion = he.id_orden_produccion)\n"
					+ "        AND op.activo = TRUE\n"
					+ "ORDER BY fecha_cotizacion DESC\n" + "LIMIT ?, ?;";

			parametros = new Object[] {
					numeroRegistrosPorPagina * (numeroPagina - 1),
					numeroRegistrosPorPagina };

			break;

		case BUSQUEDA_NUT:
			query = "SELECT \n"
					+ "    op.id_orden_produccion,\n"
					+ "    op.nut,\n"
					+ "    op.nombre,\n"
					+ "    op.descripcion,\n"
					+ "    op.fecha_cotizacion,\n"
					+ "    c.nombre_moral,\n"
					+ "    eo.id_estatus_orden,\n"
					+ "    eo.nombre nombre_estatus\n"
					+ "FROM\n"
					+ "    orden_produccion op,\n"
					+ "    historial_estatus he,\n"
					+ "    estatus_orden eo,\n"
					+ "    cliente c\n"
					+ "WHERE\n"
					+ "    c.id_cliente = op.id_cliente\n"
					+ "        AND he.id_orden_produccion = op.id_orden_produccion\n"
					+ "        AND eo.id_estatus_orden = he.id_estatus_orden\n"
					+ "        AND he.fecha = (SELECT \n"
					+ "            MAX(fecha)\n"
					+ "        FROM\n"
					+ "            historial_estatus\n"
					+ "        WHERE\n"
					+ "            id_orden_produccion = he.id_orden_produccion)\n"
					+ "        AND op.nut = ?\n"
					+ "        AND op.activo = TRUE\n"
					+ "ORDER BY fecha_cotizacion DESC\n" + "LIMIT ?, ?;";

			parametros = new Object[] { nut,
					numeroRegistrosPorPagina * (numeroPagina - 1),
					numeroRegistrosPorPagina };

			break;

		case BUSQUEDA_ESTATUS:
			query = "SELECT \n"
					+ "    op.id_orden_produccion,\n"
					+ "    op.nut,\n"
					+ "    op.nombre,\n"
					+ "    op.descripcion,\n"
					+ "    op.fecha_cotizacion,\n"
					+ "    c.nombre_moral,\n"
					+ "    eo.id_estatus_orden,\n"
					+ "    eo.nombre nombre_estatus\n"
					+ "FROM\n"
					+ "    orden_produccion op,\n"
					+ "    historial_estatus he,\n"
					+ "    estatus_orden eo,\n"
					+ "    cliente c\n"
					+ "WHERE\n"
					+ "    c.id_cliente = op.id_cliente\n"
					+ "        AND he.id_orden_produccion = op.id_orden_produccion\n"
					+ "        AND eo.id_estatus_orden = he.id_estatus_orden\n"
					+ "        AND he.fecha = (SELECT \n"
					+ "            MAX(fecha)\n"
					+ "        FROM\n"
					+ "            historial_estatus\n"
					+ "        WHERE\n"
					+ "            id_orden_produccion = he.id_orden_produccion)\n"
					+ "        AND eo.id_estatus_orden = ?\n"
					+ "        AND op.activo = TRUE\n"
					+ "ORDER BY fecha_cotizacion DESC\n" + "LIMIT ?, ?;";

			parametros = new Object[] { idEstatusOrden,
					numeroRegistrosPorPagina * (numeroPagina - 1),
					numeroRegistrosPorPagina };

			break;

		case BUSQUEDA_NOMBRE_OP:
			query = "SELECT \n"
					+ "    op.id_orden_produccion,\n"
					+ "    op.nut,\n"
					+ "    op.nombre,\n"
					+ "    op.descripcion,\n"
					+ "    op.fecha_cotizacion,\n"
					+ "    c.nombre_moral,\n"
					+ "    eo.id_estatus_orden,\n"
					+ "    eo.nombre nombre_estatus\n"
					+ "FROM\n"
					+ "    orden_produccion op,\n"
					+ "    historial_estatus he,\n"
					+ "    estatus_orden eo,\n"
					+ "    cliente c\n"
					+ "WHERE\n"
					+ "    c.id_cliente = op.id_cliente\n"
					+ "        AND he.id_orden_produccion = op.id_orden_produccion\n"
					+ "        AND eo.id_estatus_orden = he.id_estatus_orden\n"
					+ "        AND he.fecha = (SELECT \n"
					+ "            MAX(fecha)\n"
					+ "        FROM\n"
					+ "            historial_estatus\n"
					+ "        WHERE\n"
					+ "            id_orden_produccion = he.id_orden_produccion)\n"
					+ "        AND op.nombre LIKE ?\n"
					+ "        AND op.activo = TRUE\n"
					+ "ORDER BY fecha_cotizacion DESC\n" + "LIMIT ?, ?;";

			parametros = new Object[] { "%" + nombre + "%",
					numeroRegistrosPorPagina * (numeroPagina - 1),
					numeroRegistrosPorPagina };

			break;

		case BUSQUEDA_DESCRIPCION_OP:
			query = "SELECT \n"
					+ "    op.id_orden_produccion,\n"
					+ "    op.nut,\n"
					+ "    op.nombre,\n"
					+ "    op.descripcion,\n"
					+ "    op.fecha_cotizacion,\n"
					+ "    c.nombre_moral,\n"
					+ "    eo.id_estatus_orden,\n"
					+ "    eo.nombre nombre_estatus\n"
					+ "FROM\n"
					+ "    orden_produccion op,\n"
					+ "    historial_estatus he,\n"
					+ "    estatus_orden eo,\n"
					+ "    cliente c\n"
					+ "WHERE\n"
					+ "    c.id_cliente = op.id_cliente\n"
					+ "        AND he.id_orden_produccion = op.id_orden_produccion\n"
					+ "        AND eo.id_estatus_orden = he.id_estatus_orden\n"
					+ "        AND he.fecha = (SELECT \n"
					+ "            MAX(fecha)\n"
					+ "        FROM\n"
					+ "            historial_estatus\n"
					+ "        WHERE\n"
					+ "            id_orden_produccion = he.id_orden_produccion)\n"
					+ "        AND op.descripcion LIKE ?\n"
					+ "        AND op.activo = TRUE\n"
					+ "ORDER BY fecha_cotizacion DESC\n" + "LIMIT ?, ?;";

			parametros = new Object[] { "%" + descripcion + "%",
					numeroRegistrosPorPagina * (numeroPagina - 1),
					numeroRegistrosPorPagina };

			break;

		case BUSQUEDA_FECHA_COTIZACION:
			query = "SELECT \n"
					+ "    op.id_orden_produccion,\n"
					+ "    op.nut,\n"
					+ "    op.nombre,\n"
					+ "    op.descripcion,\n"
					+ "    op.fecha_cotizacion,\n"
					+ "    c.nombre_moral,\n"
					+ "    eo.id_estatus_orden,\n"
					+ "    eo.nombre nombre_estatus\n"
					+ "FROM\n"
					+ "    orden_produccion op,\n"
					+ "    historial_estatus he,\n"
					+ "    estatus_orden eo,\n"
					+ "    cliente c\n"
					+ "WHERE\n"
					+ "    c.id_cliente = op.id_cliente\n"
					+ "        AND he.id_orden_produccion = op.id_orden_produccion\n"
					+ "        AND eo.id_estatus_orden = he.id_estatus_orden\n"
					+ "        AND he.fecha = (SELECT \n"
					+ "            MAX(fecha)\n"
					+ "        FROM\n"
					+ "            historial_estatus\n"
					+ "        WHERE\n"
					+ "            id_orden_produccion = he.id_orden_produccion)\n"
					+ "        AND DATE(op.fecha_cotizacion) BETWEEN DATE(?) AND DATE(?)\n"
					+ "        AND op.activo = TRUE\n"
					+ "ORDER BY fecha_cotizacion DESC\n" + "LIMIT ?, ?;";

			parametros = new Object[] { fechaCotizacionInicio,
					fechaCotizacionFin,
					numeroRegistrosPorPagina * (numeroPagina - 1),
					numeroRegistrosPorPagina };

			break;

		case BUSQUEDA_CLIENTE:
			query = "SELECT \n"
					+ "    op.id_orden_produccion,\n"
					+ "    op.nut,\n"
					+ "    op.nombre,\n"
					+ "    op.descripcion,\n"
					+ "    op.fecha_cotizacion,\n"
					+ "    c.nombre_moral,\n"
					+ "    eo.id_estatus_orden,\n"
					+ "    eo.nombre nombre_estatus\n"
					+ "FROM\n"
					+ "    orden_produccion op,\n"
					+ "    historial_estatus he,\n"
					+ "    estatus_orden eo,\n"
					+ "    cliente c\n"
					+ "WHERE\n"
					+ "    c.id_cliente = op.id_cliente\n"
					+ "        AND he.id_orden_produccion = op.id_orden_produccion\n"
					+ "        AND eo.id_estatus_orden = he.id_estatus_orden\n"
					+ "        AND he.fecha = (SELECT \n"
					+ "            MAX(fecha)\n"
					+ "        FROM\n"
					+ "            historial_estatus\n"
					+ "        WHERE\n"
					+ "            id_orden_produccion = he.id_orden_produccion)\n"
					+ "        AND c.nombre_moral LIKE ?\n"
					+ "        AND op.activo = TRUE\n"
					+ "ORDER BY fecha_cotizacion DESC\n" + "LIMIT ?, ?;";

			parametros = new Object[] { "%" + cliente + "%",
					numeroRegistrosPorPagina * (numeroPagina - 1),
					numeroRegistrosPorPagina };

			break;

		default:
			listaOrdenesProduccion = null;
			break;
		}

		listaOrdenesProduccion = visualizadorDAO.listaOrdenesProduccion(query, parametros);
		
		return listaOrdenesProduccion;
	}

}
