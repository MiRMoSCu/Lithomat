package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.HashMap;
import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.TipoTrabajoDetalleDTO;
import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;

public interface TipoTrabajoDetalleService {

	public int creaTipoTrabajoDetalle(TipoTrabajoDetalle tipoTrabajoDetalle);
	
	public void eliminaTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public TipoTrabajoDetalle buscaTipoTrabajoDetalle(int idTipoTrabajoDetalle);
	
	public TipoTrabajoDetalleDTO buscaTipoTrabajoDetalleEnDTO(int idTipoTrabajoDetalle);

	public void modificaTipoTrabajoDetalle(TipoTrabajoDetalle tipoTrabajoDetalle);

	public List<TipoTrabajoDetalle> listaTipoTrabajoDetalle();
	
	public List<TipoTrabajoDetalle> listaTipoTrabajoDetallePorPartida(int idPartida);
	
	public HashMap<String, Object> obtieneSumatorias(int idTipoTrabajoDetalle);
	
	public String buscaHTML(int idPartida);
	
	public String obtienePapelDescripcionBasica(int idTipoTrabajoDetalle);
	
	public List<TipoTrabajoDetalle> listaTipoTrabajoDetallePorEstatusOrden(int idEstatusOrden);
	
	public List<TipoTrabajoDetalle> listaTipoTrabajoDetallePorEstatusMaquinaFecha(int idEstatusOrden, int idMaquina, boolean aplicaTodasMaquinas, String fechaInicial, String fechaFinal);
	
	public float obtieneCostosExtraCosteTotal(int idTipoTrabajoDetalle);

}