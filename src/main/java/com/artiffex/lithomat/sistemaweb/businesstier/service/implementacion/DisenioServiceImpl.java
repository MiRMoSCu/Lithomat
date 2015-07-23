package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.DisenioDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Disenio;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.DisenioService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.DisenioDAO;

@Service("disenioService")
public class DisenioServiceImpl implements DisenioService {
	
	@Resource
	private DisenioDAO disenioDAO;

	public int creaDisenio(Disenio disenio) {
		return disenioDAO.crea(disenio);
	}
	
	public Disenio buscaDisenio(int idDisenio) {
		return disenioDAO.busca(idDisenio);
	}
	
	public Disenio buscaDisenioPorPartida(int idPartida) {
		return disenioDAO.buscaPorPartida(idPartida);
	}
	
	public DisenioDTO buscaDisenioPorPartidaEnDTO(int idPartida) {
		Disenio disenio = disenioDAO.buscaPorPartida(idPartida);
		DisenioDTO disenioDTO = new DisenioDTO();
		disenioDTO.setIdDisenio(disenio.getIdDisenio());
		disenioDTO.setIndicacionTareaRealizar(disenio.getIndicacionTareaRealizar()==null?"":disenio.getIndicacionTareaRealizar());
		disenioDTO.setMaterialesRecibe(disenio.getIndicacionTareaRealizar()==null?"":disenio.getIndicacionTareaRealizar());
		disenioDTO.setObservaciones(disenio.getObservaciones()==null?"":disenio.getObservaciones());
		disenio = null;
		return disenioDTO;
	}

	public void modificaDisenio(Disenio disenio) {
		disenioDAO.modifica(disenio);
	}

	public List<Disenio> listaDisenio() {
		return disenioDAO.lista();
	}

}
