package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TransporteDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Transporte;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TransporteService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TransporteDAO;

@Service("transporteService")
public class TransporteServiceImpl implements TransporteService {
	
	@Resource
	private TransporteDAO transporteDAO;

	public int creaTransporte(Transporte transporte) {
		return transporteDAO.crea(transporte);
	}
	
	public Transporte buscaTransporte(int idTransporte) {
		return transporteDAO.busca(idTransporte);
	}
	
	public Transporte buscaTransportePorPartida(int idPartida) {
		return transporteDAO.buscaPorPartida(idPartida);
	}
	
	public TransporteDTO buscaTransportePorPartidaEnDTO(int idPartida) {
		Transporte transporte = transporteDAO.buscaPorPartida(idPartida);
		TransporteDTO transporteDTO = new TransporteDTO();
		transporteDTO.setIdTransporte(transporte.getIdTransporte());
		transporteDTO.setIndicacionTareaRealizar(transporte.getIndicacionTareaRealizar()==null?"":transporte.getIndicacionTareaRealizar());
		transporteDTO.setMaterialesRecibe(transporte.getMaterialesRecibe()==null?"":transporte.getMaterialesRecibe());
		transporteDTO.setObservaciones(transporte.getObservaciones()==null?"":transporte.getObservaciones());
		transporte = null;
		return transporteDTO;
	}

	public void modificaTransporte(Transporte transporte) {
		transporteDAO.modifica(transporte);
	}

	public List<Transporte> listaTransporte() {
		return transporteDAO.lista();
	}

}
