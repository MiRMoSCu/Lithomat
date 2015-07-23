package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPapelExtendido;

public interface TipoPapelExtendidoDAO {

	public int crea(TipoPapelExtendido tipoPapelExtendido);
	
	public TipoPapelExtendido busca(int idTipoPapelExtendido);

	public void modifica(TipoPapelExtendido tipoPapelExtendido);

	public List<TipoPapelExtendido> lista();
	
}
