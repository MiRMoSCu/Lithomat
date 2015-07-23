package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cobranza;

public interface CobranzaDAO {
	
	public int crea(Cobranza cobranza);
	
	public int modifica(Cobranza cobranza);
	
	public int elimina(Cobranza cobranza);
	
	public List<Cobranza> lista();
	
}
