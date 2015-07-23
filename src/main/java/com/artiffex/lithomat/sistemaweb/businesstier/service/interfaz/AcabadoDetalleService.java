package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.AcabadoDetalle;

public interface AcabadoDetalleService {

	public int creaAcabadoDetalle(AcabadoDetalle acabadoDetalle);
	
	public AcabadoDetalle buscaAcabadoDetalle(int idAcabadoDetalle);

	public void modificaAcabadoDetalle(AcabadoDetalle acabadoDetalle);

	public List<AcabadoDetalle> listaAcabadoDetalle();
	
	public List<AcabadoDetalle> listaAcabadoDetallePorAcabado(int idAcabado);
	
	public String listaHTML(int idAcabado);
	
	public String listaHTMLModificacionPorAcabado(int idAcabado);
	
	public String listaHTMLProcesosYPrecio(int idPartida);
	
}