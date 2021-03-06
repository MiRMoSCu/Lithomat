package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;
import java.util.List;

public class DisenioDTO implements Serializable {

	private static final long serialVersionUID = 4176993695633240991L;
	
	private int idDisenio;
	private String indicacionTareaRealizar;
	private String materialesRecibe;
	private String observaciones;
	private List<DisenioDetalleDTO> listaDisenioDetalleDTO;
	
	
	public int getIdDisenio() {
		return idDisenio;
	}
	public void setIdDisenio(int idDisenio) {
		this.idDisenio = idDisenio;
	}
	public String getIndicacionTareaRealizar() {
		return indicacionTareaRealizar;
	}
	public void setIndicacionTareaRealizar(String indicacionTareaRealizar) {
		this.indicacionTareaRealizar = indicacionTareaRealizar;
	}
	public String getMaterialesRecibe() {
		return materialesRecibe;
	}
	public void setMaterialesRecibe(String materialesRecibe) {
		this.materialesRecibe = materialesRecibe;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public List<DisenioDetalleDTO> getListaDisenioDetalleDTO() {
		return listaDisenioDetalleDTO;
	}
	public void setListaDisenioDetalleDTO(
			List<DisenioDetalleDTO> listaDisenioDetalleDTO) {
		this.listaDisenioDetalleDTO = listaDisenioDetalleDTO;
	}
}
