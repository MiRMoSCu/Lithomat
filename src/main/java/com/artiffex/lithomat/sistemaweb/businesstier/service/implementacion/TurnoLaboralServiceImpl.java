package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TurnoLaboral;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TurnoLaboralService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TurnoLaboralDAO;

@Service("turnoLaboralService")
public class TurnoLaboralServiceImpl implements TurnoLaboralService {
	
	@Resource
	private TurnoLaboralDAO turnoLaboralDAO;

	public void creaTurnoLaboral(TurnoLaboral turnoLaboral) {
		turnoLaboralDAO.crea(turnoLaboral);
	}
	
	public TurnoLaboral busca(int idTurnoLaboral) {
		return turnoLaboralDAO.busca(idTurnoLaboral);
	}

	public void modificaTurnoLaboral(TurnoLaboral turnoLaboral) {
		turnoLaboralDAO.modifica(turnoLaboral);
	}

	public List<TurnoLaboral> listaTurnoLaboral() {
		return turnoLaboralDAO.lista();
	}

}