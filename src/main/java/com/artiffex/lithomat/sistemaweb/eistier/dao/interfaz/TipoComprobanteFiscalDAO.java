package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoComprobanteFiscal;

public interface TipoComprobanteFiscalDAO {

	public int crea(TipoComprobanteFiscal tipoComprobanteFiscal);
	
	public TipoComprobanteFiscal busca(int idTipoComprobanteFiscal);

	public void modifica(TipoComprobanteFiscal tipoComprobanteFiscal);

	public List<TipoComprobanteFiscal> lista();

}