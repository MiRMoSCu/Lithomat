package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistoricoProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.HistoricoProduccionService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.HistoricoProduccionDAO;

@Service("historicoProduccionService")
public class HistoricoProduccionServiceImpl implements HistoricoProduccionService {
	
	@Resource
	private HistoricoProduccionDAO historicoProduccionDAO;

	public int creaHistoricoProduccion(HistoricoProduccion historicoProduccion) {
		return historicoProduccionDAO.crea(historicoProduccion);
	}

	public int modificaHistoricoProduccion(
			HistoricoProduccion historicoProduccion) {
		return historicoProduccionDAO.modifica(historicoProduccion);
	}

	public int eliminaHistoricoProduccion(int idHistoricoProduccion) {
		return historicoProduccionDAO.elimina(idHistoricoProduccion);
	}

	public List<HistoricoProduccion> listaHistoricoProduccion() {
		return historicoProduccionDAO.lista();
	}
}