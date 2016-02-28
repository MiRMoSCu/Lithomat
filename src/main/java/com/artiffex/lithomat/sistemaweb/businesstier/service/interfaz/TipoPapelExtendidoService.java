package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TipoPapelExtendidoDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ParametrosBusquedaTipoPapelExtendido;

public interface TipoPapelExtendidoService {

	public void creaTipoPapelExtendido(TipoPapelExtendido tipoPapelExtendido);
	
	public TipoPapelExtendido buscaTipoPapelExtendido(int idTipoPapelExtendido);

	public void modificaTipoPapelExtendido(TipoPapelExtendido tipoPapelExtendido);

	public List<TipoPapelExtendido> listaTipoPapelExtendido();
	
	public int numeroRegistrosPorCriterioBusqueda(ParametrosBusquedaTipoPapelExtendido parametros);
	
	public List<TipoPapelExtendidoDTO> listaPorCriterioBusquedaPorNumeroPagina(ParametrosBusquedaTipoPapelExtendido parametros, int numeroPagina, int numeroRegistrosPorPagina);
	
	public String listaHTMLTipoPapelExtendidoPorConsulta(ParametrosBusquedaTipoPapelExtendido parametros);

	public List<ComboSelect> listaComboSelect();
	
	public byte[] obtieneExcelListaTipoPapelExtendido();
	
	public void cargaExcel(String path);
	
	public void borradoLogicoPorProveedorPapel(int idProveedorPapel);
	
}