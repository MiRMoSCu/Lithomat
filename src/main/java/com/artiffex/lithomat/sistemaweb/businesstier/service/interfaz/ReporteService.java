package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;


public interface ReporteService {

	public byte[] obtieneExcelListaColaImpresion( int idEstatusOrden, int idMaquina, boolean aplicaTodasMaquinas, String fechaInicial, String fechaFinal );
	
}
