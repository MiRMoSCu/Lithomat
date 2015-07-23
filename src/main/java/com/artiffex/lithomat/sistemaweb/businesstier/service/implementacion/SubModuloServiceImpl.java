package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.SubModulo;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.SubModuloService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.SubModuloDAO;

@Service("subModuloService")
public class SubModuloServiceImpl implements SubModuloService {
	
	@Resource
	private SubModuloDAO subModuloDAO;

	public int creaSubModulo(SubModulo subModulo) {
		return subModuloDAO.crea(subModulo);
	}

	public int modificaSubModulo(SubModulo subModulo) {
		return subModuloDAO.modifica(subModulo);
	}

	public int eliminaSubModulo(int idSubModulo) {
		return subModuloDAO.elimina(idSubModulo);
	}

	public List<SubModulo> listaSubModulo() {
		return subModuloDAO.lista();
	}
}