package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.HistorialEstatus;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.HistorialEstatusService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.HistorialEstatusDAO;

@Service("historialEstatusService")
public class HistorialEstatusServiceImpl implements HistorialEstatusService {
	
	@Resource
	private HistorialEstatusDAO historialEstatusDAO;

	public int creaHistorialEstatus(HistorialEstatus historialEstatus) {
		return historialEstatusDAO.crea(historialEstatus);
	}
	
	public HistorialEstatus buscaHistorialEstatus(int idHistorialEstatus) {
		return historialEstatusDAO.busca(idHistorialEstatus);
	}
	
	public HistorialEstatus buscaUltimoHistorialEstatus(int idOrdenProduccion) {
		return historialEstatusDAO.buscaPorOrdenProduccion(idOrdenProduccion);
	}

	public void modificaHistorialEstatus(HistorialEstatus historialEstatus) {
		historialEstatusDAO.modifica(historialEstatus);
	}

	public List<HistorialEstatus> listaHistorialEstatus(int idOrdenProduccion) {
		return historialEstatusDAO.lista(idOrdenProduccion);
	}
	
}