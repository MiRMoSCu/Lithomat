package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.ResponsableInsumo;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface ResponsableInsumoService {

	public void creaResponsableInsumo(ResponsableInsumo responsableInsumo);
	
	public ResponsableInsumo buscaResponsableInsumo(int idResponsableInsumo);

	public void modificaResponsableInsumo(ResponsableInsumo responsableInsumo);

	public List<ResponsableInsumo> listaResponsableInsumo();

	public List<ComboSelect> listaComboSelect();
}