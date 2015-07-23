package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cobranza;

public interface CobranzaService {
	
	public void creaCobranza(Cobranza cobranza);
	
	public void modificaCobranza(Cobranza cobranza);
	
	public void eliminaCobranza(Cobranza cobranza);
	
	public List<Cobranza> listaCobranza();
	
}