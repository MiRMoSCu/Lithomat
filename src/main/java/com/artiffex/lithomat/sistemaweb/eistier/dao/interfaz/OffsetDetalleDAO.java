package com.artiffex.lithomat.sistemaweb.eistier.dao.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.OffsetDetalle;

public interface OffsetDetalleDAO {
	
	public int crea(OffsetDetalle offsetDetalle);
	
	public int modifica(OffsetDetalle offsetDetalle);
	
	public int elimina(int idOffsetDetalle);
	
	public List<OffsetDetalle> lista();
	
}
