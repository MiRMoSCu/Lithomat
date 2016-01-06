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
		sqlQuery.append("CAST((tp.precio / tprecio.factor_divisor) AS DECIMAL (6,3)) precio_unitario ");
		sqlQuery.append("FROM ");
		sqlQuery.append("tabulador_precios tp, ");
		sqlQuery.append("tipo_precio tprecio ");
		sqlQuery.append("WHERE ");
		sqlQuery.append("tp.id_tipo_precio = tprecio.id_tipo_precio ");
		sqlQuery.append("AND tp.id_maquina = ");
		sqlQuery.append(idMaquina);
		sqlQuery.append(" ");
		sqlQuery.append("AND tp.id_tipo_complejidad = ");
		sqlQuery.append(idTipoComplejidad);
		sqlQuery.append(" ");
		sqlQuery.append("AND ");
		sqlQuery.append(cantidad + 1);
		sqlQuery.append(" > tp.inicio_tabulador ");
		sqlQuery.append("AND ");
		sqlQuery.append(cantidad - 1);
		sqlQuery.append(" < tp.fin_tabulador ");
		sqlQuery.append("AND tp.activo = TRUE;");
		
		precioUnitario = tabuladorPreciosDAO.buscaPrecioTabulador(sqlQuery.toString());
		
		sqlQuery = null;
		return precioUnitario;
	}

}