package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TabuladorPreciosDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaTabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TabuladorPreciosDAO;

@Service("tabuladorPreciosService")
public class TabuladorPreciosServiceImpl implements TabuladorPreciosService {
	
	@Resource
	private TabuladorPreciosDAO tabuladorPreciosDAO;

	public void creaTabuladorPrecios(TabuladorPrecios tabuladorPrecios) {
		tabuladorPreciosDAO.crea(tabuladorPrecios);
	}
	
	public TabuladorPrecios buscaTabuladorPrecios(int idTabuladorPrecios) {
		return tabuladorPreciosDAO.busca(idTabuladorPrecios);
	}

	public void modificaTabuladorPrecios(TabuladorPrecios tabuladorPrecios) {
		tabuladorPreciosDAO.modifica(tabuladorPrecios);
	}

	public List<TabuladorPrecios> listaTabuladorPrecios() {
		return tabuladorPreciosDAO.lista();
	}
	
	public int numeroRegistrosPorCriterioBusqueda(ParametrosBusquedaTabuladorPrecios parametros) {
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT ");
		query.append("    COUNT(*)");
		query.append(" FROM");
		query.append("    tabulador_precios tp,");
		query.append("    maquina m,");
		query.append("    tipo_complejidad tc,");
		query.append("    tipo_precio t_precio");
		query.append(" WHERE");
		
		if ( parametros.isBusquedaPorMaquina() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("        tp.id_maquina = ");
			query.append( parametros.getIdMaquina() );
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorComplejidad() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("        tp.id_tipo_complejidad = ");
			query.append( parametros.getIdTipoComplejidad() );
			existeParametro = true;
		}
		
		if ( existeParametro )
			query.append(" AND ");

		query.append("        tp.activo = TRUE");
		query.append("        AND m.id_maquina = tp.id_maquina");
		query.append("        AND tc.id_tipo_complejidad = tp.id_tipo_complejidad");
		query.append("        AND t_precio.id_tipo_precio = tp.id_tipo_precio");
		query.append(" ORDER BY tp.id_maquina ASC , tp.id_tipo_complejidad ASC , tp.inicio_tabulador ASC;");
		
		int numRegistros = tabuladorPreciosDAO.numeroRegistros( query.toString() );
		
		query = null;
		
		// TODO Auto-generated method stub
		return numRegistros;
	}

	public List<TabuladorPreciosDTO> listaPorCriterioBusquedaPorNumeroPagina(ParametrosBusquedaTabuladorPrecios parametros, int numeroPagina, int numeroRegistrosPorPagina) {
		boolean existeParametro = false;
		
		StringBuilder query = new StringBuilder();
		query.append(" SELECT ");
		query.append("    tp.id_tabulador_precios idTabuladorPrecios,");
		query.append("    m.nombre maquina,");
		query.append("    tp.nombre_insumo nombreInsumo,");
		query.append("    tp.descripcion descripcion,");
		query.append("    tp.inicio_tabulador inicioTabulador,");
		query.append("    tp.fin_tabulador finTabulador,");
		query.append("    tc.nombre tipoComplejidad,");
		query.append("    tp.precio,");
		query.append("    t_precio.nombre tipoPrecio");
		query.append(" FROM");
		query.append("    tabulador_precios tp,");
		query.append("    maquina m,");
		query.append("    tipo_complejidad tc,");
		query.append("    tipo_precio t_precio");
		query.append(" WHERE");
		
		if ( parametros.isBusquedaPorMaquina() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("        tp.id_maquina = ");
			query.append( parametros.getIdMaquina() );
			existeParametro = true;
		}
		
		if ( parametros.isBusquedaPorComplejidad() ) {
			if ( existeParametro )
				query.append(" AND ");
			query.append("        tp.id_tipo_complejidad = ");
			query.append( parametros.getIdTipoComplejidad() );
			existeParametro = true;
		}
		
		if ( existeParametro )
			query.append(" AND ");

		query.append("        tp.activo = TRUE");
		query.append("        AND m.id_maquina = tp.id_maquina");
		query.append("        AND tc.id_tipo_complejidad = tp.id_tipo_complejidad");
		query.append("        AND t_precio.id_tipo_precio = tp.id_tipo_precio");
		query.append(" ORDER BY tp.id_maquina ASC , tp.id_tipo_complejidad ASC , tp.inicio_tabulador ASC");
		query.append(" LIMIT ");
		query.append(numeroRegistrosPorPagina * (numeroPagina - 1));
		query.append(" , ");
		query.append(numeroRegistrosPorPagina);
		query.append(";");
		
		List<TabuladorPreciosDTO> lista = tabuladorPreciosDAO.listaPorCriteriosBusqueda( query.toString() );
		
		query = null;
		
		return lista;
	}

	public float obtienePrecioUnitarioTabulador(int idTipoComplejidad, int idMaquina, int cantidad) {
		float precioUnitario = 0;
		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append(" SELECT ");
		sqlQuery.append("    CAST((tp.precio / tprecio.factor_divisor) AS DECIMAL (6 , 3 )) precio_unitario");
		sqlQuery.append(" FROM");
		sqlQuery.append("    tabulador_precios tp,");
		sqlQuery.append("    tipo_precio tprecio");
		sqlQuery.append(" WHERE");
		sqlQuery.append("    tp.id_tipo_precio = tprecio.id_tipo_precio");
		sqlQuery.append("        AND tp.id_maquina = ");
		sqlQuery.append(idMaquina);
		sqlQuery.append("        AND tp.id_tipo_complejidad = ");
		sqlQuery.append(idTipoComplejidad);
		sqlQuery.append("        AND ");
		sqlQuery.append(cantidad + 1);
		sqlQuery.append(" > tp.inicio_tabulador");
		sqlQuery.append("        AND ");
		sqlQuery.append(cantidad - 1);
		sqlQuery.append(" < tp.fin_tabulador");
		sqlQuery.append("        AND tp.activo = TRUE;");
		
		precioUnitario = tabuladorPreciosDAO.buscaPrecioTabulador(sqlQuery.toString());
		
		sqlQuery = null;
		return precioUnitario;
	}

}