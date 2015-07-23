package com.artiffex.lithomat.sistemaweb.businesstier.service.interfaz;

import java.util.List;

import com.artiffex.lithomat.sistemaweb.businesstier.entity.EstatusOrden;
import com.artiffex.lithomat.sistemaweb.businesstier.utilidades.ComboSelect;

public interface EstatusOrdenService {

	public void creaEstatusOrden(EstatusOrden estatusOrden);
	
	public EstatusOrden buscaEstatusOrden(int idEstatusOrden);

	public void modificaEstatusOrden(EstatusOrden estatusOrden);

	public List<EstatusOrden> listaEstatusOrden();

	public List<ComboSelect> listaComboSelect();
	
	public List<ComboSelect> listaComboSelectEstatusPosiblePorNut(String nut);

}