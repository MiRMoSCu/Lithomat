package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.OffsetDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OffsetDetalleService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.OffsetDetalleDAO;

@Service("offsetDetalleService")
public class OffsetDetalleServiceImpl implements OffsetDetalleService {
	
	@Resource
	private OffsetDetalleDAO offsetDetalleDAO;

	public int creaOffsetDetalle(OffsetDetalle offsetDetalle) {
		return offsetDetalleDAO.crea(offsetDetalle);
	}

	public int modificaOffsetDetalle(OffsetDetalle offsetDetalle) {
		return offsetDetalleDAO.modifica(offsetDetalle);
	}

	public int eliminaOffsetDetalle(int idOffsetDetalle) {
		return offsetDetalleDAO.elimina(idOffsetDetalle);
	}

	public List<OffsetDetalle> listaOffsetDetalle() {
		return offsetDetalleDAO.lista();
	}
}