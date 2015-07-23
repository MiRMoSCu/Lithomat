package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TipoTrabajoService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TipoTrabajoDAO;

@Service("tipoTrabajoService")
public class TipoTrabajoServiceImpl implements TipoTrabajoService {
	
	@Resource
	private TipoTrabajoDAO tipoTrabajoDAO;

	public void creaTipoTrabajo(TipoTrabajo tipoTrabajo) {
		tipoTrabajoDAO.crea(tipoTrabajo);
	}
	
	public TipoTrabajo buscaTipoTrabajo(int idTipoTrabajo) {
		return tipoTrabajoDAO.busca(idTipoTrabajo);
	}

	public void modificaTipoTrabajo(TipoTrabajo tipoTrabajo) {
		tipoTrabajoDAO.modifica(tipoTrabajo);
	}

	public List<TipoTrabajo> listaTipoTrabajo() {
		return tipoTrabajoDAO.lista();
	}

}