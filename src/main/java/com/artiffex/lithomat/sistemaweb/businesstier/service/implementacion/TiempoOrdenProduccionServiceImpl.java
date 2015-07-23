package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TiempoOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TiempoOrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TiempoOrdenProduccionDAO;

@Service("tiempoOrdenProduccionService")
public class TiempoOrdenProduccionServiceImpl implements TiempoOrdenProduccionService {
	
	@Resource
	private TiempoOrdenProduccionDAO tiempoOrdenProduccionDAO;

	public int creaTiempoOrdenProduccion(
			TiempoOrdenProduccion tiempoOrdenProduccion) {
		return tiempoOrdenProduccionDAO.crea(tiempoOrdenProduccion);
	}

	public int modificaTiempoOrdenProduccion(
			TiempoOrdenProduccion tiempoOrdenProduccion) {
		return tiempoOrdenProduccionDAO.modifica(tiempoOrdenProduccion);
	}

	public int eliminaTiempoOrdenProduccion(int idTiempoOrdenProduccion) {
		return tiempoOrdenProduccionDAO.elimina(idTiempoOrdenProduccion);
	}

	public List<TiempoOrdenProduccion> listaTiempoOrdenProduccion() {
		return tiempoOrdenProduccionDAO.lista();
	}
}