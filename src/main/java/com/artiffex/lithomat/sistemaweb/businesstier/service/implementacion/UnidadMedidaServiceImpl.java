package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.UnidadMedida;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.UnidadMedidaService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.UnidadMedidaDAO;

@Service("unidadMedidaService")
public class UnidadMedidaServiceImpl implements UnidadMedidaService {
	
	@Resource
	private UnidadMedidaDAO unidadMedidaDAO;

	public int creaUnidadMedida(UnidadMedida unidadMedida) {
		return unidadMedidaDAO.crea(unidadMedida);
	}

	public void modificaUnidadMedida(UnidadMedida unidadMedida) {
		unidadMedidaDAO.modifica(unidadMedida);
	}

	public void eliminaUnidadMedida(UnidadMedida unidadMedida) {
		unidadMedidaDAO.elimina(unidadMedida);
	}

	public List<UnidadMedida> listaUnidadMedida() {
		return unidadMedidaDAO.lista();
	}
}