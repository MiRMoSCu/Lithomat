package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TransporteDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TransporteDetalle;

public interface TransporteDetalleService {

	public int creaTransporteDetalle(TransporteDetalle transporteDetalle);
	
	public TransporteDetalle buscaTransporteDetalle(int idTransporteDetalle);

	public void modificaTransporteDetalle(TransporteDetalle transporteDetalle);
	
	public List<TransporteDetalle> listaTransporteDetalle();
	
	public List<TransporteDetalle> listaTransporteDetallePorTransporte(int idTransporte);
	
	public List<TransporteDetalleDTO> listaTransporteDetallePorTransporteEnDTO(int idTransporte);
	
	public String listaHTML(int idTransporte);
	
	public String listaHTMLModificacionPorTransporte(int idTransporte);
	
	public String listaHTMLProcesosYPrecio(int idPartida);
	
	public String listaHTMLProcesosYPrecioConPorcentajeCliente(int idPartida, float porcentajeCliente);
	
}