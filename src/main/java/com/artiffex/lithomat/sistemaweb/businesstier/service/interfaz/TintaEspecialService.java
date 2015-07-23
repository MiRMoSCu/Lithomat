package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.HashMap;
import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TintaEspecial;

public interface TintaEspecialService {
	
	public void modificaTintaEspecial(TintaEspecial tintaEspecial);

	public List<TintaEspecial> listaTintaEspecial();
	
	public HashMap<String, Object> getHashPrecioYTipoPrecio();
	
}
