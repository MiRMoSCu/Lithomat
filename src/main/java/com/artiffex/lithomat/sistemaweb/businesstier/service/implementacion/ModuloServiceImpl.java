package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.Modulo;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.ModuloService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.ModuloDAO;

@Service("moduloService")
public class ModuloServiceImpl implements ModuloService {
	
	@Resource
	private ModuloDAO moduloDAO;

	public int creaModulo(Modulo modulo) {
		return moduloDAO.crea(modulo);
	}

	public int modificaModulo(Modulo modulo) {
		return moduloDAO.modifica(modulo);
	}

	public int eliminaModulo(int idModulo) {
		return moduloDAO.elimina(idModulo);
	}

	public List<Modulo> listaModulo() {
		return moduloDAO.lista();
	}
}