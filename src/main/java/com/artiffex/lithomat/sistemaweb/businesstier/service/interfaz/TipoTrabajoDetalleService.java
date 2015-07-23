package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.HashMap;
import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TipoTrabajoDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;

public interface TipoTrabajoDetalleService {

	public int creaTipoTrabajoDetalle(TipoTrabajoDetalle tipoTrabajoDetalle);
	
	public TipoTrabajoDetalle buscaTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public TipoTrabajoDetalleDTO buscaTipoTrabajoDetalleEnDTO(int idTipoTrabajoDetalle);

	public void modificaTipoTrabajoDetalle(TipoTrabajoDetalle tipoTrabajoDetalle);

	public List<TipoTrabajoDetalle> listaTipoTrabajoDetalle();
	
	public List<TipoTrabajoDetalle> listaTipoTrabajoDetallePorPartida(int idPartida);

	public HashMap<String, Object> obtieneSumatorias(int idTipoTrabajoDetalle);
	
	public String buscaHTML(int idPartida);

}