package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.DisenioDetalle;

public interface DisenioDetalleService {

	public int creaDisenioDetalle(DisenioDetalle disenioDetalle);
	
	public DisenioDetalle buscaDisenioDetalle(int idDisenioDetalle);

	public void modificaDisenioDetalle(DisenioDetalle disenioDetalle);
	
	public List<DisenioDetalle> listaDisenioDetalle();
	
	public List<DisenioDetalle> listaDisenioDetallePorDisenio(int idDisenio);

	public String listaHTML(int idDisenio);
	
	public String listaHTMLModificacionPorDisenio(int idDisenio);
	
	public String listaHTMLProcesosYPrecio(int idPartida);
	
	
}