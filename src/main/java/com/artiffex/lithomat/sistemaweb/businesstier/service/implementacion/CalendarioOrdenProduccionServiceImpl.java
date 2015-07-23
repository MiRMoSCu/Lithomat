package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalendarioOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CalendarioOrdenProduccionService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CalendarioOrdenProduccionDAO;

@Service("calendarioOrdenProduccionService")
public class CalendarioOrdenProduccionServiceImpl implements CalendarioOrdenProduccionService {
	
	@Resource
	private CalendarioOrdenProduccionDAO calendarioOrdenProduccionDAO;

	public int creaCalendarioOrdenProduccion(CalendarioOrdenProduccion calendarioOrdenProduccion) {
		return calendarioOrdenProduccionDAO.crea(calendarioOrdenProduccion);
	}

	public int modificaCalendarioOrdenProduccion(CalendarioOrdenProduccion calendarioOrdenProduccion) {
		return calendarioOrdenProduccionDAO.modifica(calendarioOrdenProduccion);
	}

	public int eliminaCalendarioOrdenProduccion(int idCalendarioOrdenProduccion) {
		return calendarioOrdenProduccionDAO.elimina(idCalendarioOrdenProduccion);
	}

	public List<CalendarioOrdenProduccion> listaCalendarioOrdenProduccion() {
		return calendarioOrdenProduccionDAO.lista();
	}
}