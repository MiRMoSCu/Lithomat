package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.AvisoMantenimientoMaquina;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.AvisoMantenimientoMaquinaService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.AvisoMantenimientoMaquinaDAO;

@Service("avisoMantenimientoMaquinaService")
public class AvisoMantenimientoMaquinaServiceImpl implements AvisoMantenimientoMaquinaService {
	@Resource
	private AvisoMantenimientoMaquinaDAO avisoMantenimientoMaquinaDAO;

	public int creaAvisoMantenimientoMaquina(AvisoMantenimientoMaquina avisoMantenimientoMaquina) {
		return avisoMantenimientoMaquinaDAO.crea(avisoMantenimientoMaquina);
	}
	
	public AvisoMantenimientoMaquina buscaAvisoMantenimientoMaquina(int idAvisoMantenimientoMaquina) {
		return avisoMantenimientoMaquinaDAO.busca(idAvisoMantenimientoMaquina);
	}

	public void modificaAvisoMantenimientoMaquina(AvisoMantenimientoMaquina avisoMantenimientoMaquina) {
		avisoMantenimientoMaquinaDAO.modifica(avisoMantenimientoMaquina);
	}

	public List<AvisoMantenimientoMaquina> listaAvisoMantenimientoMaquina() {
		return avisoMantenimientoMaquinaDAO.lista();
	}

}