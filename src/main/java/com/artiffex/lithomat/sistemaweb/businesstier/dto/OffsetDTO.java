package com.artiffex.lithomat.sistemaweb.businesstier.dto;

import java.io.Serializable;

public class OffsetDTO implements Serializable {
	
	private static final long serialVersionUID = 8143933746315409782L;
	
	private int idOffset;
	private String indicacionTareaRealizar;
	private String materialesRecibe;
	private String observaciones;
	
	
	public int getIdOffset() {
		return idOffset;
	}
	public void setIdOffset(int idOffset) {
		this.idOffset = idOffset;
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
	
}
