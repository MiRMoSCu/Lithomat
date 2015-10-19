package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;
import java.util.List;

public class TransporteDTO implements Serializable {
	
	private static final long serialVersionUID = -358269518004921648L;
	
	private int idTransporte;
	private String indicacionTareaRealizar;
	private String materialesRecibe;
	private String observaciones;
	private List<TransporteDetalleDTO> listaTransporteDetalleDTO;
	
	
	public int getIdTransporte() {
		return idTransporte;
	}
	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
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
	public List<TransporteDetalleDTO> getListaTransporteDetalleDTO() {
		return listaTransporteDetalleDTO;
	}
	public void setListaTransporteDetalleDTO(
			List<TransporteDetalleDTO> listaTransporteDetalleDTO) {
		this.listaTransporteDetalleDTO = listaTransporteDetalleDTO;
	}
}
