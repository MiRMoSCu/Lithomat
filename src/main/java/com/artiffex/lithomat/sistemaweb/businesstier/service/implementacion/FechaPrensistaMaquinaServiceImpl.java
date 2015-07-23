package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.FechaPrensistaMaquina;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.FechaPrensistaMaquinaService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.FechaPrensistaMaquinaDAO;

@Service("fechaPrensistaMaquinaService")
public class FechaPrensistaMaquinaServiceImpl implements FechaPrensistaMaquinaService {
	
	@Resource
	private FechaPrensistaMaquinaDAO fechaPrensistaMaquinaDAO;

	public int creaFechaPrensistaMaquina(FechaPrensistaMaquina fechaPrensistaMaquina) {
		return fechaPrensistaMaquinaDAO.crea(fechaPrensistaMaquina);
	}

	public int modificaFechaPrensistaMaquina(FechaPrensistaMaquina fechaPrensistaMaquina) {
		return fechaPrensistaMaquinaDAO.modifica(fechaPrensistaMaquina);
	}

	public int eliminaFechaPrensistaMaquina(int idFechaPrensistaMaquina) {
		return fechaPrensistaMaquinaDAO.elimina(idFechaPrensistaMaquina);
	}

	public List<FechaPrensistaMaquina> listaFechaPrensistaMaquina() {
		return fechaPrensistaMaquinaDAO.lista();
	}
}