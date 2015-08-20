package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
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

	public float obtienePrecioUnitarioTabulador(int idTipoComplejidad, int idMaquina, int cantidad) {
		float precioUnitario = 0;
		StringBuilder sqlQuery = new StringBuilder();
		
		sqlQuery.append("SELECT ");
		switch( idTipoComplejidad ) {
			case 1:
				sqlQuery.append("CAST((tp.precio_complejidad_sencilla / tipo_precio.factor_divisor) AS DECIMAL (6,3)) precio_unitario ");
				break;
			case 2:
				sqlQuery.append("CAST((tp.precio_complejidad_regular / tipo_precio.factor_divisor) AS DECIMAL (6,3)) precio_unitario ");
				break;
			case 3:
				sqlQuery.append("CAST((tp.precio_complejidad_dificil / tipo_precio.factor_divisor) AS DECIMAL (6,3)) precio_unitario ");
				break;
			default:
				sqlQuery.append("CAST((tp.precio_complejidad_regular / tipo_precio.factor_divisor) AS DECIMAL (6,3)) precio_unitario ");
				break;
		}
		sqlQuery.append("FROM ");
		sqlQuery.append("maquina m, tabulador_precios tp, tipo_precio tipo_precio ");
		sqlQuery.append("WHERE ");
		sqlQuery.append("m.id_maquina = tp.id_maquina ");
		sqlQuery.append("AND tp.id_tipo_precio = tipo_precio.id_tipo_precio ");
		sqlQuery.append("AND tp.id_maquina = :idMaquina ");
		sqlQuery.append("AND :cantidadMasUno > tp.inicio_tabulador ");
		sqlQuery.append("AND :cantidadMenosUno < tp.fin_tabulador ");
		sqlQuery.append("AND tp.activo = TRUE;");
		
		precioUnitario = tabuladorPreciosDAO.buscaPrecioTabulador(sqlQuery.toString(), idMaquina, cantidad);
		
		sqlQuery = null;
		return precioUnitario;
	}

}