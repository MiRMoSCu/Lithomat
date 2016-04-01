package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import com.artiffex.lithomat.sistemaweb.businesstier.dto.CotizacionExpressDTOResultado;
import com.artiffex.lithomat.sistemaweb.businesstier.dto.CotizacionExpressDTOVariables;

public interface CotizacionExpressService {
	
	public CotizacionExpressDTOResultado calculaCotizacionExpress(CotizacionExpressDTOVariables cotizacionExpressDTOVariables);

}
