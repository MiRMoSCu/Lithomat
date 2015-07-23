package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TabuladorPrecios;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TabuladorPreciosService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TabuladorPreciosDAO;

@Service("tabuladorPreciosService")
public class TabuladorPreciosServiceImpl implements TabuladorPreciosService {
	
	@Resource
	private TabuladorPreciosDAO tabuladorPreciosDAO;

	public void creaTabuladorPrecios(TabuladorPrecios tabuladorPrecios) {
		tabuladorPreciosDAO.crea(tabuladorPrecios);
	}
	
	public TabuladorPrecios buscaTabuladorPrecios(int idTabuladorPrecios) {
		return tabuladorPreciosDAO.busca(idTabuladorPrecios);
	}

	public void modificaTabuladorPrecios(TabuladorPrecios tabuladorPrecios) {
		tabuladorPreciosDAO.modifica(tabuladorPrecios);
	}

	public List<TabuladorPrecios> listaTabuladorPrecios() {
		return tabuladorPreciosDAO.lista();
	}

	public float obtienePrecioUnitarioTabulador(int idMaquina, int cantidad) {
		return tabuladorPreciosDAO.buscaPrecioTabulador(idMaquina, cantidad);
	}

}