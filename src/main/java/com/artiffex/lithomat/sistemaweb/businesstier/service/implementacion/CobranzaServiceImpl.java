package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Cobranza;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CobranzaService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CobranzaDAO;

@Service("cobranzaService")
public class CobranzaServiceImpl implements CobranzaService {
	
	@Resource
	private CobranzaDAO cobranzaDAO;

	public void creaCobranza(Cobranza cobranza) {
		cobranzaDAO.crea(cobranza);
	}

	public void modificaCobranza(Cobranza cobranza) {
		cobranzaDAO.modifica(cobranza);
	}

	public void eliminaCobranza(Cobranza cobranza) {
		cobranzaDAO.elimina(cobranza);
	}

	public List<Cobranza> listaCobranza() {
		return cobranzaDAO.lista();
	}
}