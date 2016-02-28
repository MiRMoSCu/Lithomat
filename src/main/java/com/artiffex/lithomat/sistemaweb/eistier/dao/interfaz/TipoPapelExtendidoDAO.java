package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TipoPapelExtendidoDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaTipoPapelExtendido;

public interface TipoPapelExtendidoDAO {

	public int crea(TipoPapelExtendido tipoPapelExtendido);
	
	public TipoPapelExtendido busca(int idTipoPapelExtendido);

	public void modifica(TipoPapelExtendido tipoPapelExtendido);

	public List<TipoPapelExtendido> lista();
	
	public List<TipoPapelExtendido> listaPorQuery(String query, ParametrosBusquedaTipoPapelExtendido parametros);
	
	public int numeroRegistros(String strQuery);
	
	public List<TipoPapelExtendidoDTO> listaPorCriteriosBusqueda(String strQuery);
	
	public void borradoLogico(String strQuery);
	
}
