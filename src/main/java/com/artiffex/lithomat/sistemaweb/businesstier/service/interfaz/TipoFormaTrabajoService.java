package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoFormaTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface TipoFormaTrabajoService {

	public void creaTipoFormaTrabajo(TipoFormaTrabajo tipoFormaTrabajo);
	
	public TipoFormaTrabajo buscaTipoFormaTrabajo(int idTipoFormaTrabajo);

	public void modificaTipoFormaTrabajo(TipoFormaTrabajo tipoFormaTrabajo);

	public List<TipoFormaTrabajo> listaTipoFormaTrabajo();

	public List<ComboSelect> listaComboSelect();
	
}
