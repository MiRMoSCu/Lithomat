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
	
	public int obtieneNumeroTipoPapelExtendidoPorParametros(
			boolean busquedaPorNombre,
			boolean busquedaPorGramaje,
			boolean busquedaPorKilogramos,
			boolean busquedaPorAncho,
			boolean busquedaPorAlto,
			boolean busquedaPorProveedor,
			String nombre,
			Integer gramaje,
			Float kilogramos,
			Float ancho,
			Float alto,
			Integer idProveedorPapel
		);
	
	public List<TipoPapelExtendido> listaTipoPapelExtendidoPorParametrosPorNumeroPagina(
			boolean busquedaPorNombre,
			boolean busquedaPorGramaje,
			boolean busquedaPorKilogramos,
			boolean busquedaPorAncho,
			boolean busquedaPorAlto,
			boolean busquedaPorProveedor,
			String nombre,
			Integer gramaje,
			Float kilogramos,
			Float ancho,
			Float alto,
			Integer idProveedorPapel,
			int numeroPagina, 
			int numeroRegistrosPorPagina
		);
	
	public List<TipoPapelExtendidoDTO> listaTipoPapelExtendidoPorParametrosPorNumeroPaginaEnDTO(
			boolean busquedaPorNombre,
			boolean busquedaPorGramaje,
			boolean busquedaPorKilogramos,
			boolean busquedaPorAncho,
			boolean busquedaPorAlto,
			boolean busquedaPorProveedor,
			String nombre,
			Integer gramaje,
			Float kilogramos,
			Float ancho,
			Float alto,
			Integer idProveedorPapel,
			int numeroPagina, 
			int numeroRegistrosPorPagina
		);
	
	public String listaHTMLTipoPapelExtendidoPorConsulta(ParametrosBusquedaTipoPapelExtendido parametros);

	public List<ComboSelect> listaComboSelect();
	
	public byte[] obtieneExcelListaTipoPapelExtendido();
	
	public void cargaExcel(String path);
	
}