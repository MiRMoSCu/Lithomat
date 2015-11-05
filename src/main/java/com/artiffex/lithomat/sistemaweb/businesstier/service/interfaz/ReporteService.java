package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.sql.Timestamp;

public interface ReporteService {

	public byte[] obtieneExcelListaColaImpresion( Timestamp fechaImpresion, int idMaquina, int idEstatusOrden );
	
}
