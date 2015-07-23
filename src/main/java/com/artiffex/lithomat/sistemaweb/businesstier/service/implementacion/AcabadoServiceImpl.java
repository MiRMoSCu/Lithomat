package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.AcabadoDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.Acabado;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AcabadoService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.AcabadoDAO;

@Service("acabadoService")
public class AcabadoServiceImpl implements AcabadoService {
	
	@Resource
	private AcabadoDAO acabadoDAO;

	public int creaAcabado(Acabado acabado) {
		return acabadoDAO.crea(acabado);
	}
	
	public Acabado buscaAcabado(int idAcabado) {
		return acabadoDAO.busca(idAcabado);
	}
	
	public Acabado buscaAcabadoPorPartida(int idPartida) {
		return acabadoDAO.buscaPorPartida(idPartida);
	}
	
	public AcabadoDTO buscaAcabadoPorPartidaEnDTO(int idPartida) {
		Acabado acabado = acabadoDAO.buscaPorPartida(idPartida);
		AcabadoDTO acabadoDTO = new AcabadoDTO();
		acabadoDTO.setIdAcabado(acabado.getIdAcabado());
		acabadoDTO.setIndicacionTareaRealizar(acabado.getIndicacionTareaRealizar()==null?"":acabado.getIndicacionTareaRealizar());
		acabadoDTO.setMaterialesRecibe(acabado.getMaterialesRecibe()==null?"":acabado.getMaterialesRecibe());
		acabadoDTO.setObservaciones(acabado.getObservaciones()==null?"":acabado.getObservaciones());
		acabado = null;
		return acabadoDTO;
	}

	public void modificaAcabado(Acabado acabado) {
		acabadoDAO.modifica(acabado);
	}

	public List<Acabado> listaAcabado() {
		return acabadoDAO.lista();
	}
	
}
