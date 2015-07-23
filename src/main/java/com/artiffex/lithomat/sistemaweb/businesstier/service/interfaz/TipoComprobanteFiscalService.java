package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComprobanteFiscal;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface TipoComprobanteFiscalService {

	public void creaTipoComprobanteFiscal(TipoComprobanteFiscal tipoComprobanteFiscal);
	
	public TipoComprobanteFiscal buscaTipoComprobanteFiscal(int idTipoComprobanteFiscal);

	public void modificaTipoComprobanteFiscal(TipoComprobanteFiscal tipoComprobanteFiscal);

	public List<TipoComprobanteFiscal> listaTipoComprobanteFiscal();

	public List<ComboSelect> listaComboSelect();
	
}