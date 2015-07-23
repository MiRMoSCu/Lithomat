package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoVuelta;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface TipoVueltaService {

	public void creaTipoVuelta(TipoVuelta tipoVuelta);
	
	public TipoVuelta buscaTipoVuelta(int idTipoVuelta);

	public void modificaTipoVuelta(TipoVuelta tipoVuelta);

	public List<TipoVuelta> listaTipoVuelta();

	public List<ComboSelect> listaComboSelect();
}
