package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TamanioPublicacion;

public interface TamanioPublicacionDAO {

	public int crea(TamanioPublicacion tamanioPublicacion);
	
	public TamanioPublicacion busca(int idTamanioPublicacion);

	public void modifica(TamanioPublicacion tamanioPublicacion);

	public List<TamanioPublicacion> lista();
	
	public List<TamanioPublicacion> listaDecimales();
	
}
