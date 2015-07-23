package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.TipoTrabajoDetalle;

public interface TipoTrabajoDetalleDAO {

	public int crea(TipoTrabajoDetalle tipoTrabajoDetalle);
	
	public TipoTrabajoDetalle busca(int idTipoTrabajoDetalle);

	public void modifica(TipoTrabajoDetalle tipoTrabajoDetalle);

	public List<TipoTrabajoDetalle> lista();
	
	public List<TipoTrabajoDetalle> listaPorPartida(int idPartida);
	
	
	
	
	
	
	
	


	

	

	
	
	
	// Metodos abajo son utilizados para CalificacionService
	

	//public boolean getClienteProporcionaPapel(int idTipoTrabajoDetalle);

	//public boolean getClienteProporcionaTinta(int idTipoTrabajoDetalle);

	//public boolean getClienteProporcionaTintaEspecial(int idTipoTrabajoDetalle);

	//public boolean getClienteProporcionaBarniz(int idTipoTrabajoDetalle);

	//public boolean getClienteProporcionaPlacas(int idTipoTrabajoDetalle);

	
	
	//public List<Integer> listaIdTipoTrabajoDetalle(int idPartida);
	
	//public int getRepeticionesXPliego(int idTipoTrabajoDetalle);
	
	//public int actualiza(TipoTrabajoDetalle tipoTrabajoDetalle);
	
	//public float getPrecioUnitarioPapel(int idTipoTrabajoDetalle);
	
}
