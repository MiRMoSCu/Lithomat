package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.OffsetDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Offset;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.OffsetService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.OffsetDAO;

@Service("offsetService")
public class OffsetServiceImpl implements OffsetService {

	@Resource
	private OffsetDAO offsetDAO;

	public int creaOffset(Offset offset) {
		return offsetDAO.crea(offset);
	}
	
	public Offset buscaOffset(int idOffset) {
		return offsetDAO.busca(idOffset);
	}
	
	public OffsetDTO buscaOffsetPorPartidaEnDTO(int idPartida) {
		Offset offset = offsetDAO.buscaPorPartida(idPartida);
		OffsetDTO offsetDTO = new OffsetDTO();
		offsetDTO.setIdOffset(offset.getIdOffset());
		offsetDTO.setIndicacionTareaRealizar(offset.getIndicacionTareaRealizar()==null?"":offset.getIndicacionTareaRealizar());
		offsetDTO.setMaterialesRecibe(offset.getMaterialesRecibe()==null?"":offset.getMaterialesRecibe());
		offsetDTO.setObservaciones(offset.getObservaciones()==null?"":offset.getObservaciones());
		offset = null;
		return offsetDTO;
	}

	public void modificaOffset(Offset offset) {
		offsetDAO.modifica(offset);
	}
	
	public List<Offset> listaOffset() {
		return offsetDAO.lista();
	}
	
}
