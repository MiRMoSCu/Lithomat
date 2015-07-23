package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface TipoPapelExtendidoService {

	public void creaTipoPapelExtendido(TipoPapelExtendido tipoPapelExtendido);
	
	public TipoPapelExtendido buscaTipoPapelExtendido(int idTipoPapelExtendido);

	public void modificaTipoPapelExtendido(TipoPapelExtendido tipoPapelExtendido);

	public List<TipoPapelExtendido> listaTipoPapelExtendido();

	public List<ComboSelect> listaComboSelect();
	
	public byte[] obtieneExcelListaTipoPapelExtendido();
	
	public void cargaExcel(String path);
	
}