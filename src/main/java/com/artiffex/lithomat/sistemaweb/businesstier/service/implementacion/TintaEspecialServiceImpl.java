package com.artiffex.lithomat.sistemaweb.businesstier.service.implementacion;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TintaEspecial;
import com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz.TintaEspecialService;
import com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz.TintaEspecialDAO;

@Service("tintaEspecialService")
public class TintaEspecialServiceImpl implements TintaEspecialService {

	@Resource
	private TintaEspecialDAO tintaEspecialDAO;

	public void modificaTintaEspecial(TintaEspecial tintaEspecial) {
		tintaEspecialDAO.modifica(tintaEspecial);
	}

	public List<TintaEspecial> listaTintaEspecial() {
		return tintaEspecialDAO.lista();
	}

	public HashMap<String, Object> getHashPrecioYTipoPrecio() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<TintaEspecial> listaTintaEspecial = tintaEspecialDAO.lista();
		for (TintaEspecial tintaEspecial : listaTintaEspecial) {
			map.put("precio", tintaEspecial.getPrecio());
			map.put("factorDivisor", tintaEspecial.getTipoPrecio().getFactorDivisor());
			tintaEspecial = null;
		}
		listaTintaEspecial = null;
		return map;
	}
}
