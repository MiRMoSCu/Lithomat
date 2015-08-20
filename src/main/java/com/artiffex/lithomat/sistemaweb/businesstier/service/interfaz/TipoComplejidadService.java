package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComplejidad;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface TipoComplejidadService {

	public void creaTipoComplejidad(TipoComplejidad tipoComplejidad);
	
	public TipoComplejidad buscaTipoComplejidad(int idTipoComplejidad);
	
	public void modificaTipoComplejidad(TipoComplejidad tipoComplejidad);
	
	public List<TipoComplejidad> listaTipoComplejidad();
	
	public List<ComboSelect> listaComboSelect();

}
