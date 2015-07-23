package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.PreprensaDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Preprensa;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.PreprensaService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.PreprensaDAO;

@Service("preprensaService")
public class PreprensaServiceImpl implements PreprensaService {
	
	@Resource
	private PreprensaDAO preprensaDAO;

	public int creaPreprensa(Preprensa preprensa) {
		return preprensaDAO.crea(preprensa);
	}
	
	public Preprensa buscaPreprensa(int idPreprensa) {
		return preprensaDAO.busca(idPreprensa);
	}
	
	public Preprensa buscaPreprensaPorPartida(int idPartida) {
		return preprensaDAO.buscaPorPartida(idPartida);
	}
	
	public PreprensaDTO buscaPreprensaPorPartidaEnDTO(int idPartida) {
		Preprensa preprensa = preprensaDAO.buscaPorPartida(idPartida);
		PreprensaDTO preprensaDTO = new PreprensaDTO();
		preprensaDTO.setIdPreprensa(preprensa.getIdPreprensa());
		preprensaDTO.setIndicacionTareaRealizar(preprensa.getIndicacionTareaRealizar()==null?"":preprensa.getIndicacionTareaRealizar());
		preprensaDTO.setMaterialesRecibe(preprensa.getMaterialesRecibe()==null?"":preprensa.getMaterialesRecibe());
		preprensaDTO.setObservaciones(preprensa.getObservaciones()==null?"":preprensa.getObservaciones());
		preprensa = null;
		return preprensaDTO;
	}

	public void modificaPreprensa(Preprensa preprensa) {
		preprensaDAO.modifica(preprensa);
	}

	public List<Preprensa> listaPreprensa() {
		return preprensaDAO.lista();
	}

}
