package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;

public interface TipoTrabajoDetalleDAO {

	public int crea(TipoTrabajoDetalle tipoTrabajoDetalle);
	
	public TipoTrabajoDetalle busca(int idTipoTrabajoDetalle);

	public void modifica(TipoTrabajoDetalle tipoTrabajoDetalle);

	public List<TipoTrabajoDetalle> lista();
	
	public List<TipoTrabajoDetalle> listaPorPartida(int idPartida);
	
	public List<TipoTrabajoDetalle> listaPorEstatusOrden(int idEstatusOrden);
	
}
