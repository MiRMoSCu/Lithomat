package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.PreprensaDetalle;

public interface PreprensaDetalleService {

	public int creaPreprensaDetalle(PreprensaDetalle preprensaDetalle);
	
	public PreprensaDetalle buscaPreprensaDetalle(int idPreprensaDetalle);

	public void modificaPreprensaDetalle(PreprensaDetalle preprensaDetalle);
	
	public List<PreprensaDetalle> listaPreprensaDetalle();
	
	public List<PreprensaDetalle> listaPreprensaDetallePorPreprensa(int idPreprensa);
	
	public String listaHTML(int idPreprensa);
	
	public String listaHTMLModificacionPorPreprensa(int idPreprensa);
	
	public String listaHTMLProcesosYPrecio(int idPartida);
	
	public String listaHTMLProcesosYPrecioConPorcentajeCliente(int idPartida, float porcentajeCliente);
	
}
