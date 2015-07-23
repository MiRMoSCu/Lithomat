package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoFormacion;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoFormacionService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoFormacionDAO;

@Service("tipoFormacionService")
public class TipoFormacionServiceImpl implements TipoFormacionService {
	
	@Resource
	private TipoFormacionDAO tipoFormacionDAO;

	public int creaTipoFormacion(TipoFormacion tipoFormacion) {
		return tipoFormacionDAO.crea(tipoFormacion);
	}

	public int modificaTipoFormacion(TipoFormacion tipoFormacion) {
		return tipoFormacionDAO.modifica(tipoFormacion);
	}

	public int eliminaTipoFormacion(int idTipoFormacion) {
		return tipoFormacionDAO.elimina(idTipoFormacion);
	}

	public List<TipoFormacion> listaTipoFormacion() {
		return tipoFormacionDAO.lista();
	}
}