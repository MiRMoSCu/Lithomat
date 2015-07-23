package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.InsumoCalificacion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.InsumoCalificacionService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.InsumoCalificacionDAO;

@Service("insumoCalificacionService")
public class InsumoCalificacionServiceImpl implements InsumoCalificacionService {
	
	@Resource
	private InsumoCalificacionDAO insumoCalificacionDAO;

	public int creaInsumoCalificacion(InsumoCalificacion insumoCalificacion) {
		return insumoCalificacionDAO.crea(insumoCalificacion);
	}

	public int modificaInsumoCalificacion(InsumoCalificacion insumoCalificacion) {
		return insumoCalificacionDAO.modifica(insumoCalificacion);
	}

	public int eliminaInsumoCalificacion(int idInsumoCalificacion) {
		return insumoCalificacionDAO.elimina(idInsumoCalificacion);
	}

	public List<InsumoCalificacion> listaInsumoCalificacion() {
		return insumoCalificacionDAO.lista();
	}
}