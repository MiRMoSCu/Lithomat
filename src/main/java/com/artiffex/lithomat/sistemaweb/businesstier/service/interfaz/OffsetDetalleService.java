package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.OffsetDetalle;

public interface OffsetDetalleService {
	
	public int creaOffsetDetalle(OffsetDetalle offsetDetalle);
	
	public int modificaOffsetDetalle(OffsetDetalle offsetDetalle);
	
	public int eliminaOffsetDetalle(int idOffsetDetalle);
	
	public List<OffsetDetalle> listaOffsetDetalle();
	
}