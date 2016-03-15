package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.CostoExtraDetalle;

public interface CostoExtraDetalleService {
	
	public int creaCostoExtraDetalle(CostoExtraDetalle costoExtraDetalle);
	
	public CostoExtraDetalle buscaCostoExtraDetalle(int idCostoExtraDetalle);
	
	public void modificaCostoExtraDetalle(CostoExtraDetalle costoExtraDetalle);
	
	public List<CostoExtraDetalle> listaCostoExtraDetalle();
	
	public List<CostoExtraDetalle> listaCostoExtraDetallePorNut(String nut);
	
	public List<CostoExtraDetalle> listaCostoExtraDetallePorPartida(int idPartida);
	
	public List<CostoExtraDetalle> listaCostoExtraDetallePorTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public String buscaHTML(int idTipoTrabajoDetalle);
	
	public String listaHTMLModificacion(int idTipoTrabajoDetalle);
	
	public String listaHTMLProcesosYPrecioConPorcentajeCliente(int idTipoTrabajoDetalle, float porcentajeCliente);
	
}