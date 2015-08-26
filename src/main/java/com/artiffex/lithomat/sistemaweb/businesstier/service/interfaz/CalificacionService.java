package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.ayuda.CalificacionTrabajoDetalleDTOAyuda;
import com.artiffex.lithomat.sistemaweb.ayuda.OrdenProduccionDTOAyuda;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.ReporteCotizacionDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionOrdenProduccion;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionProcesosPartida;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.CalificacionTrabajoDetalle;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.Remision;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades._CalificacionPartida;


public interface CalificacionService {

	public int creaCalificacion(int idOrdenProduccion);
	
	public CalificacionOrdenProduccion buscaCalificacionOrdenProduccion(int idOrdenProduccion);
	
	public CalificacionTrabajoDetalle buscaCalificacionTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public _CalificacionPartida buscaCalificacionPartida(int idPartida);
	
	public CalificacionProcesosPartida buscaCalificacionProcesos(int idPartida);
	
	//public float obtienePrecioNetoPorNut(String nut);
	
	//**************************
	
	public void actualizaOrdenProduccion(int idOrdenProduccion);
	
	public void actualizaPartida(int idOrdenProduccion);
	
	public void actualizaProcesosPartida(int idOrdenProduccion);
	
	//**************************
	// JASPER REPORTS
	
	public String obtieneCondicionesProduccion(String nut);
	
	public void guardaCondicionesProduccion(String nut, String condicionesProduccion);
	
	public List<ReporteCotizacionDTO> obtieneListaPrecioCotizacionPartida(String nut);
	
	public List<Remision> obtieneRemisionPorNut(String nut);
	
	// Ejemplos JasperReports
	
	public List<OrdenProduccionDTOAyuda> obtieneVOPruebaJasper(int idOrdenProduccion);
	
	public List<CalificacionTrabajoDetalleDTOAyuda> obtieneEjemploVOPapel();

}