package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostosExtrasDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.CostosExtrasDetalleService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.CostosExtrasDetalleDAO;

@Service("costosExtrasDetalleService")
public class CostosExtrasDetalleServiceImpl implements CostosExtrasDetalleService {
	
	@Resource
	private CostosExtrasDetalleDAO costosExtrasDetalleDAO;

	public int creaCostosExtrasDetalle(CostosExtrasDetalle costosExtrasDetalle) {
		return costosExtrasDetalleDAO.crea(costosExtrasDetalle);
	}
	
	public CostosExtrasDetalle buscaCostosExtrasDetalle(int idCostosExtrasDetalle) {
		return costosExtrasDetalleDAO.busca(idCostosExtrasDetalle);
	}

	public void modificaCostosExtrasDetalle(CostosExtrasDetalle costosExtrasDetalle) {
		costosExtrasDetalleDAO.modifica(costosExtrasDetalle);
	}

	public List<CostosExtrasDetalle> listaCostosExtrasDetalle() {
		return costosExtrasDetalleDAO.lista();
	}

	public List<CostosExtrasDetalle> listaCostosExtrasDetallePorPartida(int idPartida) {
		return costosExtrasDetalleDAO.listaPorPartida(idPartida);
	}
}