package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.ayuda.CalificacionTrabajoDetalleDTOAyuda;
import com.artiffex.lithomat.sistemaweb.ayuda.OrdenProduccionDTOAyuda;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.ReporteCotizacionDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionPliego;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.OrdenTrabajo;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.RemisionPartida;


public interface CalificacionService {

	public int creaCalificacion(int idOrdenProduccion);
	
	public CalificacionOrdenProduccion buscaCalificacionOrdenProduccion(int idOrdenProduccion);
	
	public CalificacionPartida buscaCalificacionPartida(int idPartida);
	
	public CalificacionTrabajoDetalle buscaCalificacionTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public CalificacionPliego buscaCalificacionPliego(int idPliego);
	
	//**************************
	
	public void actualizaOrdenProduccion(int idOrdenProduccion);
	
	public void actualizaPartida(int idOrdenProduccion);
	
	public void actualizaProcesosPartida(int idOrdenProduccion);
	
	public void actualizaDescuento(String nut, int porcentajeDescuento);
	
	//**************************
	// JASPER REPORTS
	
	public String obtieneCondicionesProduccion(String nut);
	
	public void guardaCondicionesProduccion(String nut, String condicionesProduccion);
	
	public List<ReporteCotizacionDTO> obtieneListaPrecioCotizacionPartida(String nut);
	
	public List<RemisionPartida> obtieneRemisionPorNut(String nut);
	
	public List<OrdenTrabajo> obtieneOrdenTrabajo(String nut);
	
	// Ejemplos JasperReports
	
	public List<OrdenProduccionDTOAyuda> obtieneVOPruebaJasper(int idOrdenProduccion);
	
	public List<CalificacionTrabajoDetalleDTOAyuda> obtieneEjemploVOPapel();

}