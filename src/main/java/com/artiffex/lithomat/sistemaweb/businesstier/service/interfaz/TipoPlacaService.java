package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoPlaca;

public interface TipoPlacaService {
	
	public void creaTipoPlaca(TipoPlaca tipoPlaca);
	
	public TipoPlaca buscaTipoPlaca(int idTipoPlaca);

	public void modificaTipoPlaca(TipoPlaca tipoPlaca);

	public List<TipoPlaca> listaTipoPlaca();

	public String jsonListaTipoPlaca(int idMaquina);
	
}